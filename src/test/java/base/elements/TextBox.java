package base.elements;

import base.BaseElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    private static final Logger logger = LogManager.getLogger(BaseElement.class);

    public TextBox(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void sendKeysElement(String text) {
        logger.info("Insert text to element {}", text);
        getElement().sendKeys(text);
    }
}
