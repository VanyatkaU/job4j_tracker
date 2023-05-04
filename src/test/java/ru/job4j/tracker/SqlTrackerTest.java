package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class  SqlTrackerTest {

    private static Connection cn;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        cn.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = cn.prepareStatement(
                "delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = new Item("item");
        tracker.add(item);
        MatcherAssert.assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplacementWasSuccessful() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Ivan"));
        Item item1 = tracker.add(new Item("Stepan"));
        tracker.replace(item.getId(), item1);
        MatcherAssert.assertThat(tracker.findById(item.getId()).getName(), is(item1.getName()));
    }

    @Test
    public void whenReplacementWasNonSuccessful() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Ivan"));
        Item item1 = tracker.add(new Item("Stepan"));
        tracker.replace(item.getId() + 1, item1);
        MatcherAssert.assertThat(tracker.findById(item.getId()).getName(), is(item.getName()));
    }

    @Test
    public void whenDeleteWasSuccessful() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Ivan"));
        tracker.delete(item.getId());
        MatcherAssert.assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenDeleteWasNonSuccessful() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Stepan"));
        tracker.delete(1);
        MatcherAssert.assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindAllItems() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Ivan"));
        Item item1 = tracker.add(new Item("Stepan"));
        MatcherAssert.assertThat(tracker.findAll(), is(Arrays.asList(item, item1)));
    }

    @Test
    public void whenNonFindAllItems() {
        SqlTracker tracker = new SqlTracker(cn);
        MatcherAssert.assertThat(tracker.findAll(), is(Collections.emptyList()));
    }

    @Test
    public void whenFindByNameItem() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Ivan"));
        Item item1 = tracker.add(new Item("Stepan"));
        MatcherAssert.assertThat(tracker.findByName("Ivan"), is(List.of(item)));
    }

    @Test
    public void whenNonFindByNameItem() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Ivan"));
        Item item1 = tracker.add(new Item("Stepan"));
        MatcherAssert.assertThat(tracker.findByName("Alex"), is(Collections.emptyList()));
    }

    @Test
    public void whenFindByIdItem() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Ivan"));
        Item item1 = tracker.add(new Item("Stepan"));
        MatcherAssert.assertThat(tracker.findById(item1.getId()), is(item1));
    }

    @Test
    public void whenNonFindByIdItem() {
        SqlTracker tracker = new SqlTracker(cn);
        Item item = tracker.add(new Item("Ivan"));
        Item item1 = tracker.add(new Item("Stepan"));
        MatcherAssert.assertThat(tracker.findById(3), is(nullValue()));
    }
}