package utils;

import org.openqa.selenium.By;

public class data {
    public static By MODAL_CONTENT = By.xpath("//div[@id='custom_feedback_container']//div[@class='modal-dialog']//div[@class='modal-content']");
    public static By SELECT_COMBO_BOX = By.xpath("//div[@id='custom_feedback_container']//div[@class='modal-dialog']//div[@class='modal-content']//input[@role='combobox']");
    public static By LIST = By.xpath("//div[@id='custom_feedback_container']//div[@class='modal-dialog']//div[@class='modal-content']//ul//li[@class='item']");
    public static By SUBMIT = By.xpath("//div[@id='custom_feedback_container']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='btn default_card_submit']");
}
