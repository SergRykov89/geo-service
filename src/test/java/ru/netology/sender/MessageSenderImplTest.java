package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.entity.Country.*;

class MessageSenderImplTest {

    @Test
    void sendToRussia() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.65")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(RUSSIA)).thenReturn("Добро пожаловать");
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.65");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService) {};
        String result = messageSender.send(headers);
        assertEquals(result, "Добро пожаловать");
    }

    @Test
    void sendToNewYork() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(USA)).thenReturn("Welcome");
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService) {};
        String result = messageSender.send(headers);
        assertEquals( "Welcome", result);
    }

    @Test
    void sendToUsa() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.189")).thenReturn(new Location("New York", Country.USA, null, 0));
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(USA)).thenReturn("Welcome");
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.189");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService) {};
        String result = messageSender.send(headers);
        assertEquals( "Welcome", result);
    }
}