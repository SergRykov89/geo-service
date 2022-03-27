package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localeOfRussia() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        assertEquals(expected, result);
    }

    @Test
    void localeOfUSA() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.USA);
        String expected = "Welcome";
        assertEquals(expected, result);
    }

}