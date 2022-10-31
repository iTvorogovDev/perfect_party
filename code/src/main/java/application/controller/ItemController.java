package application.controller;

import application.entity.*;
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
public class ItemController {

    @Autowired
    private JdbcTemplate template;

    @PostMapping("/getItemTable")
    public List<Item> getItemTable() {

        final String command = "SELECT * FROM Item;";
        List<Item> result = template.query(command,
                new ResultSetExtractor<List<Item>>() {
                    @Override
                    public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {

                        try {

                            List<Item> list = new ArrayList<Item>();
                            while (rs.next()) {

                                Item i = new Item();
                                i.setItemId(rs.getInt(1));
                                i.setSupplierId(rs.getInt(2));
                                i.setItemType(rs.getString(3));
                                i.setItemName(rs.getString(4));
                                i.setItemDescription(rs.getString(5));
                                i.setPrice(rs.getDouble(6));
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

    @PostMapping("/getSupplierTable")
    public List<Supplier> getSupplierTable() {

        final String command = "SELECT * FROM Supplier;";
        List<Supplier> result = template.query(command,
                new ResultSetExtractor<List<Supplier>>() {
                    @Override
                    public List<Supplier> extractData(ResultSet rs) throws SQLException,
                            DataAccessException {

                        try {
                            List<Supplier> list = new ArrayList<Supplier>();
                            while (rs.next()) {

                                Supplier s = new Supplier();
                                s.setSupplierId(rs.getInt(1));
                                s.setSupplierName(rs.getString(2));
                                list.add(s);

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

    @PostMapping("/addSupplier")
    public Supplier addSupplier(@RequestBody Supplier supplier) {

        final String command = "INSERT INTO Supplier (SupplierName) VALUES (?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(command, new String[]{"ID"});
            ps.setString(1, supplier.getSupplierName());
            return ps;
        }, keyHolder);
        return new Supplier(keyHolder.getKey().intValue(), supplier.getSupplierName());

    }

    @PostMapping("/addMenuItem")
    public MenuItem addMenuItem(@RequestBody MenuItem item) {

        final String insertItemCommand = "INSERT INTO Item (SupplierId, ItemType, ItemName, ItemDescription, Price)" +
                " VALUES (?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertItemCommand, new String[]{"ID"});
            ps.setInt(1, item.getSupplierId());
            ps.setString(2, item.getItemType());
            ps.setString(3, item.getItemName());
            ps.setString(4, item.getItemDescription());
            ps.setDouble(5, item.getPrice());
            return ps;
        }, keyHolder);
        final String insertMenuItemCommand = "INSERT INTO MenuItem (ItemId) VALUES (?);";
        template.update(insertMenuItemCommand, new Object[] {keyHolder.getKey().intValue()});
        return new MenuItem(keyHolder.getKey().intValue(), item.getSupplierId(), item.getItemType(),
                item.getItemName(), item.getItemDescription(), item.getPrice());


    }

    @PostMapping("/addFlowerArrangement")
    public FlowerArrangement addFlowerArrangement(@RequestBody FlowerArrangement item) {

        final String insertItemCommand = "INSERT INTO Item (SupplierId, ItemType, ItemName, ItemDescription, Price)" +
                " VALUES (?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertItemCommand, new String[]{"ID"});
            ps.setInt(1, item.getSupplierId());
            ps.setString(2, item.getItemType());
            ps.setString(3, item.getItemName());
            ps.setString(4, item.getItemDescription());
            ps.setDouble(5, item.getPrice());
            return ps;
        }, keyHolder);
        final String insertMenuItemCommand = "INSERT INTO FlowerArrangement (ItemId) VALUES (?);";
        template.update(insertMenuItemCommand, new Object[] {keyHolder.getKey().intValue()});;
        return new FlowerArrangement(keyHolder.getKey().intValue(), item.getSupplierId(), item.getItemType(),
                item.getItemName(), item.getItemDescription(), item.getPrice());

    }

    @PostMapping("/addDecorItem")
    public DecorItem addDecorItem(@RequestBody DecorItem item) {

        final String insertItemCommand = "INSERT INTO Item (SupplierId, ItemType, ItemName, ItemDescription, Price)" +
                " VALUES (?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertItemCommand, new String[]{"ID"});
            ps.setInt(1, item.getSupplierId());
            ps.setString(2, item.getItemType());
            ps.setString(3, item.getItemName());
            ps.setString(4, item.getItemDescription());
            ps.setDouble(5, item.getPrice());
            return ps;
        }, keyHolder);
        final String insertMenuItemCommand = "INSERT INTO DecorItem (ItemId) VALUES (?);";
        template.update(insertMenuItemCommand, new Object[] {keyHolder.getKey().intValue()});;
        return new DecorItem(keyHolder.getKey().intValue(), item.getSupplierId(), item.getItemType(),
                item.getItemName(), item.getItemDescription(), item.getPrice());

    }

    @PostMapping("/addMusicEntertainmentOption")
    public DecorItem addMusicEntertainmentOption(@RequestBody MusicEntertainmentOption meo) {

        final String insertItemCommand = "INSERT INTO Item (SupplierId, ItemType, ItemName, ItemDescription, Price)" +
                " VALUES (?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertItemCommand, new String[]{"ID"});
            ps.setInt(1, meo.getSupplierId());
            ps.setString(2, meo.getItemType());
            ps.setString(3, meo.getItemName());
            ps.setString(4, meo.getItemDescription());
            ps.setDouble(5, meo.getPrice());
            return ps;
        }, keyHolder);
        final String insertMenuItemCommand = "INSERT INTO MusicEntertainmentOption (ItemId, AvailableStartDateTime, AvailableEndDateTime)" +
                " VALUES (?, ?, ?);";
        template.update(insertMenuItemCommand, new Object[] {keyHolder.getKey().intValue(),
                meo.getAvailableStartDateTime(), meo.getAvailableEndDateTime()});
        return new DecorItem(keyHolder.getKey().intValue(), meo.getSupplierId(), meo.getItemType(),
                meo.getItemName(), meo.getItemDescription(), meo.getPrice());

    }

}
