package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void name() {
        Address address = new Address("Moscow", "Arbat", 13, 432);
        Address address2 = new Address("Moscow", "Gogolya", 20, 31);
        Profile profile = new Profile(address);
        Profile profile2 = new Profile(address2);
        List<Profile> profiles = List.of(
                profile,
                profile2
        );
        List<Address> addresses = new Profiles().collect(profiles);
        List<Address> expected = List.of(
                address,
                address2
        );
        assertThat(expected, is(addresses));
    }
}