package application.controller;

import application.entity.Booking;
import application.entity.CustomerAccount;
import application.entity.GetUserBookingHistoryResponse;
import application.entity.Venue;
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
public class VenueController {

    @Autowired
    private JdbcTemplate template;

    @PostMapping("/getVenueTable")
    public List<Venue> getVenueTable() {

        final String command = "SELECT * FROM Venue;";
        List<Venue> result = template.query(command,
                new ResultSetExtractor<List<Venue>>() {
                    @Override
                    public List<Venue> extractData(ResultSet rs) throws SQLException, DataAccessException {

                        try {

                            List<Venue> list = new ArrayList<Venue>();
                            while (rs.next()) {

                                Venue v = new Venue();
                                v.setVenueId(rs.getInt(1));
                                v.setVenueName(rs.getString(2));
                                v.setAddress(rs.getString(3));
                                v.setBuildingType(rs.getString(4));
                                v.setCapacity(rs.getInt(5));
                                v.setOperationStartTime(rs.getTime(6));
                                v.setOperationEndTime(rs.getTime(7));
                                list.add(v);

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

    @PostMapping("/getBookingTable")
    public List<Booking> getBookingTable() {

        final String command = "SELECT * FROM Booking;";
        List<Booking> result = template.query(command,
                new ResultSetExtractor<List<Booking>>() {
                    @Override
                    public List<Booking> extractData(ResultSet rs) throws SQLException, DataAccessException {

                        try {

                            List<Booking> list = new ArrayList<Booking>();
                            while (rs.next()) {

                                Booking b = new Booking();
                                b.setBookingId(rs.getInt(1));
                                b.setBookingType(rs.getString(2));
                                b.setUsername(rs.getString(3));
                                b.setStartDateTime(rs.getTimestamp(4));
                                b.setEndDateTime(rs.getTimestamp(5));
                                b.setVenueId(rs.getInt(6));
                                b.setAttendeesNumber(rs.getInt(7));
                                list.add(b);

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

    @PostMapping("/addVenue")
    public Venue addVenue(@RequestBody Venue venue) {

        final String command = "INSERT INTO Venue (VenueName, Address, BuildingType, Capacity, OperationStartTime, OperationEndTime)" +
                " VALUES (?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(command, new String[]{"ID"});
            ps.setString(1, venue.getVenueName());
            ps.setString(2, venue.getAddress());
            ps.setString(3, venue.getBuildingType());
            ps.setInt(4, venue.getCapacity());
            ps.setTime(5, venue.getOperationStartTime());
            ps.setTime(6, venue.getOperationEndTime());
            return ps;
        }, keyHolder);
        return new Venue(keyHolder.getKey().intValue(), venue.getCapacity(), venue.getVenueName(), venue.getAddress(),
                venue.getBuildingType(), venue.getOperationStartTime(), venue.getOperationEndTime());

    }

    @PostMapping("/addBooking")
    public Booking addBooking(@RequestBody Booking booking) {

        final String command = "INSERT INTO booking (BookingType, Username, StartDateTime, EndDateTime, VenueId, AttendeesNumber)" +
                " VALUES (?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(command, new String[]{"ID"});
            ps.setString(1, booking.getBookingType());
            ps.setString(2, booking.getUsername());
            ps.setTimestamp(3, booking.getStartDateTime());
            ps.setTimestamp(4, booking.getEndDateTime());
            ps.setInt(5, booking.getVenueId());
            ps.setInt(6, booking.getAttendeesNumber());
            return ps;
        }, keyHolder);
        return new Booking(keyHolder.getKey().intValue(), booking.getVenueId(), booking.getAttendeesNumber(),
                booking.getBookingType(), booking.getUsername(), booking.getStartDateTime(), booking.getEndDateTime());

    }

    @PostMapping("/getUserBookingHistory")
    public List<GetUserBookingHistoryResponse> getUserBookingHistory(@RequestBody CustomerAccount customerAccount) {

        final String command = "SELECT * FROM Booking LEFT OUTER JOIN Venue ON Booking.VenueId = Venue.VenueId WHERE Username = ?;";
        List<GetUserBookingHistoryResponse> result = template.query(command, new Object[] {customerAccount.getUsername()},
                new ResultSetExtractor<List<GetUserBookingHistoryResponse>>() {
                    @Override
                    public List<GetUserBookingHistoryResponse> extractData(ResultSet rs) throws SQLException,
                            DataAccessException {

                        try {

                            List<GetUserBookingHistoryResponse> list = new ArrayList<GetUserBookingHistoryResponse>();
                            while (rs.next()) {

                                GetUserBookingHistoryResponse r = new GetUserBookingHistoryResponse();
                                r.setBookingId(rs.getInt(1));
                                r.setBookingType(rs.getString(2));
                                r.setUsername(rs.getString(3));
                                r.setStartDateTime(rs.getTimestamp(4));
                                r.setEndDateTime(rs.getTimestamp(5));
                                r.setVenueId(rs.getInt(6));
                                r.setAttendeesNumber(rs.getInt(7));
                                r.setVenueId(rs.getInt(8));
                                r.setVenueName(rs.getString(9));
                                r.setAddress(rs.getString(10));
                                r.setBuildingType(rs.getString(11));
                                r.setCapacity(rs.getInt(12));
                                r.setOperationStartTime(rs.getTime(13));
                                r.setOperationEndTime(rs.getTime(14));
                                list.add(r);

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
