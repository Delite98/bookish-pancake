package base;

import org.openqa.selenium.By;
import services.Properties;
import services.WaitsService;

import java.time.Duration;

public abstract class BaseForm {

    private By uniqueFormLocator;
    private String formName;

    public BaseForm(By uniqueFormLocator, String formName) {
        this.uniqueFormLocator = uniqueFormLocator;
        this.formName = formName;

    }

}
