package application.controller;

import application.entity.DateRangeRequest;
import application.entity.PaymentMethod;
import application.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private JdbcTemplate template;

    @PostMapping("/addPaymentMethod")
    public PaymentMethod addPaymentMethod(@RequestBody PaymentMethod paymentMethod) {


        String command = "INSERT INTO PaymentMethod (Username, CardNumber, FirstName, LastName, ExpiryDate, CVV," +
                " PhoneNumber, AddressLineOne, AddressLineTwo, PostalCode, Province, Country)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        template.update(command, new Object[]{paymentMethod.getUsername(), paymentMethod.getCardNumber(), paymentMethod.getFirstName(),
                paymentMethod.getLastName(), paymentMethod.getExpiryDate(), paymentMethod.getCvv(), paymentMethod.getPhoneNumber(), paymentMethod.getAddressLineOne(),
                paymentMethod.getAddressLineTwo(), paymentMethod.getPostalCode(), paymentMethod.getProvince(), paymentMethod.getCountry()});
        return paymentMethod;

    }

    @PostMapping("/recordPurchase")
    public Purchase recordPurchase(@RequestBody Purchase purchase) {

        final String command = "INSERT INTO Purchase (PurchaseDate, Username, CardNumber, BookingId, Amount)" +
                " VALUES (?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(command, new String[]{"ID"});
            ps.setDate(1, purchase.getPurchaseDate());
            ps.setString(2, purchase.getUsername());
            ps.setString(3, purchase.getCardNumber());
            ps.setInt(4, purchase.getBookingId());
            ps.setDouble(5, purchase.getAmount());
            return ps;
        }, keyHolder);
        return new Purchase(keyHolder.getKey().intValue(), purchase.getBookingId(), purchase.getAmount(),
                purchase.getUsername(), purchase.getCardNumber(), purchase.getPurchaseDate());

    }

    @PostMapping("/getDateRangePurchaseSum")
    public List<Integer> getDateRangePurchaseSum(@RequestBody DateRangeRequest request) {

        final String command = "SELECT SUM(Amount) FROM Purchase WHERE PurchaseDate BETWEEN ? AND ?;";
        List<Integer> result = template.query(command, new Object[] {request.getStartDate(), request.getEndDate()},
                new ResultSetExtractor<List<Integer>>() {
                    @Override
                    public List<Integer> extractData(ResultSet rs) throws SQLException,
                            DataAccessException {

                        try {
                            List<Integer> list = new ArrayList<Integer>();
                            while (rs.next()) {

                                Integer i = rs.getInt(1);
                                list.add(i);

                            }
                            return list;

                        } catch (DataAccessException e) {

                            e.printStackTrace();
                            return null;

                        }
                    }

                });

        return result;

    }

}
