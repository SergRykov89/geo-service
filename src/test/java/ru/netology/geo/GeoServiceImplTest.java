package ru.netology.geo;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.Argument;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void byIp() {
        GeoService geoService = new GeoServiceImpl();
        Location result = geoService.byIp("172.0.32.11");
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        assertEquals(expected.toString(), result.toString());

    }

}