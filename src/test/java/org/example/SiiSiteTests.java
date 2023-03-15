package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SiiSiteTests extends BaseTest {

    @Test
    @DisplayName("Testing sii.pl title")
    void shouldValidateCorrectTitleBooking() {
        //GIVEN
        driver.get("https://www.sii.pl");
        logger.info("URL application = https://www.sii.pl");
        driver.manage().window().maximize();
        //WHEN
        String actualTitle = driver.getTitle();
        logger.info("Actual title is " + actualTitle);
        //THEN
        assertThat(actualTitle).isEqualTo("Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska");
    }

    @Test
    @DisplayName("Testing language change")
    void shouldValidateLanguageChange() {
        //GIVEN
        driver.get("https://www.sii.pl");
        logger.info("URL application = https://www.sii.pl");
        driver.manage().window().maximize();
        //WHEN
        driver.findElements(By.cssSelector(".js-wpml-ls-legacy-dropdown")).get(1).click();
        driver.findElements(By.cssSelector(".icl-en")).get(1).click();
        logger.info("Language changed to English");
        //THEN
        assertThat(driver.findElements(By.cssSelector(".icl_lang_sel_native")).get(1).getText()).isEqualTo("ENGLISH");
    }

    @Test
    @DisplayName("Testing visibility of offer")
    void shouldValidateOffer() {
        //GIVEN
        driver.get("https://www.sii.pl");
        logger.info("URL application = https://www.sii.pl");
        driver.manage().window().maximize();
        //WHEN
        driver.findElements(By.cssSelector(".-what-we-offer")).get(1).click();
        logger.info("Offer entered");
        driver.findElements(By.cssSelector("[href='https://sii.pl/oferta/digital/aplikacje-i-uslugi-webowe/']"))
                .get(1)
                .click();
        logger.info("'Aplikacje webowe' section entered");
        //THEN
        assertThat(driver.findElement(By.cssSelector(".sii-o-top-lead__header__text__title"))
                .getText()).isEqualTo("Aplikacje webowe");
    }

    @Test
    @DisplayName("Testing visibility of contact page")
    void shouldValidateContactPage() {
        //GIVEN
        driver.get("https://www.sii.pl");
        logger.info("URL application = https://www.sii.pl");
        driver.manage().window().maximize();
        //WHEN
        driver.findElements(By.cssSelector("[href='https://sii.pl/contact-us/']")).get(2).click();
        logger.info("Contact page entered");
        //THEN
        assertThat(driver.findElements(By.cssSelector(".sii-m-section-header__title"))
                .get(0)
                .getText()).isEqualTo("Wyślij zapytanie");
    }
}
