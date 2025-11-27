package manager;

import model.ContactData;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }
public void createContact(ContactData contact){
        openContactPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContactEdit(contact);
        fillContactForm(modifiedContact);
        submitContactEdit();
        returnToHomePage();
    }
    private void selectContactEdit(ContactData contact) {
        click(By.cssSelector(String.format("a[href^='edit.php?id=%s']", contact.id())));
        //click(By.cssSelector(String.format("input[value='%s']",contact.id())));
    }
    public void submitContactEdit() {
        click(By.name("update"));
    }

    public void removeContact(ContactData contact){
        openHomePage();
        selectContact();
        removeSelectedContact();
        returnToHomePage();
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void openHomePage() {
        if (!manager.isElementPresent(By.name("new"))){
            click(By.linkText("home"));
        }

    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("mobile"), contact.mobile());
    }

    private void openContactPage() {
        if (!manager.isElementPresent(By.name("nickname")));
        click(By.linkText("add new"));
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCountContact() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var tds = manager.driver.findElements(By.name("entry"));
        for (var td : tds) {
            var tdFirstName = td.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var tdLastName = td.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var tdMobile = td.findElement(By.cssSelector("td:nth-child(6)")).getText();
            var tdAddress = td.findElement(By.cssSelector("td:nth-child(4)")).getText();
            var tdEmail = td.findElement(By.cssSelector("td:nth-child(5)")).getText();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData()
                    .withContactId(id)
                    .withFirstName(tdFirstName)
                    .withLastName(tdLastName)
                    .withMobile(tdMobile)
                    .withAddress(tdAddress)
                    .withEmail(tdEmail));
        }

        return contacts;
    }

}
