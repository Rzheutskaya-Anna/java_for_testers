package manager;

import org.openqa.selenium.By;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class HelperBase {

    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void click(By locator) {
        manager.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void attach(By locator, String file) {
        if (file == null || file.isEmpty()) {
            System.out.println("файл не найден");
        } else {
            manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
        }

    }

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}