package application.controller;

import application.entity.CustomerAccount;
import application.entity.EmployeeAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private JdbcTemplate template;

    @PostMapping("/registerCustomer")
    public CustomerAccount registerCustomer(@RequestBody CustomerAccount account) {

        String command = "INSERT INTO CustomerAccount" +
                " (Username, UserPassword, FirstName, LastName, PhoneNumber, EmailAddress) VALUES (?, ?, ?, ?, ?, ?);";
        template.update(command, new Object[]{account.getUsername(), account.getUserPassword(), account.getFirstName(),
                account.getLastName(), account.getPhoneNumber(), account.getEmailAddress()});
        return account;

    }

    @PostMapping("/registerEmployee")
    public EmployeeAccount registerEmployee(@RequestBody EmployeeAccount account) {

        String command = "INSERT INTO EmployeeAccount" +
                " (Username, EmployeePassword, FirstName, LastName) VALUES (?, ?, ?, ?);";
        template.update(command, new Object[]{account.getUsername(), account.getEmployeePassword(), account.getFirstName(),
                account.getLastName()});
        return account;

    }

    @PostMapping("/userLogin")
    public List<CustomerAccount> userLogin(@RequestBody CustomerAccount customerAccount) {

        String command = "SELECT * FROM CustomerAccount WHERE Username = ? AND UserPassword = ?;";
        List<CustomerAccount> result = template.query(command, new Object[] {customerAccount.getUsername(), customerAccount.getUserPassword()},
                new ResultSetExtractor<List<CustomerAccount>>() {
            @Override
            public List<CustomerAccount> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                try {
                    List<CustomerAccount> list = new ArrayList<CustomerAccount>();
                    while (rs.next()) {

                        CustomerAccount ca = new CustomerAccount();
                        ca.setUsername(rs.getString(1));
                        ca.setUserPassword(rs.getString(2));
                        ca.setFirstName((rs.getString(3)));
                        ca.setLastName((rs.getString(4)));
                        ca.setPhoneNumber(rs.getString(5));
                        ca.setEmailAddress(rs.getString(6));
                        list.add(ca);

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
