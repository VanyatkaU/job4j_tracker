package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollect() {
        List<Profile> profile = List.of(
                new Profile(new Address("Moscow", "sh. Entusiasts", 18, 12)),
                new Profile(new Address("Reutov", "Lenina", 4, 187)),
                new Profile(new Address("Zheleznogorsk", "Kurskay", 5, 146)));
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(profile);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "sh. Entusiasts", 18, 12));
        expected.add(new Address("Reutov", "Lenina", 4, 187));
        expected.add(new Address("Zheleznogorsk", "Kurskay", 5, 146));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectRep() {
        List<Profile> profile = List.of(
                new Profile(new Address("Moscow", "sh. Entusiasts", 18, 12)),
                new Profile(new Address("Reutov", "Lenina", 4, 187)),
                new Profile(new Address("Zheleznogorsk", "Kurskay", 5, 146)),
                new Profile(new Address("Zheleznogorsk", "Kurskay", 5, 146)));
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(profile);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "sh. Entusiasts", 18, 12));
        expected.add(new Address("Reutov", "Lenina", 4, 187));
        expected.add(new Address("Zheleznogorsk", "Kurskay", 5, 146));
        assertThat(rsl, is(expected));
    }
}
