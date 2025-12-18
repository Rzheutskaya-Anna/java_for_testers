package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void createContact(ContactData contact, GroupData group) {
        openContactPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToHomePage();
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        openHomePage();
        showAllContacts();
        selectContact(contact);
        selectGroupAtHomePage(group);
    }
    private void showAllContacts() {
        new Select(manager.driver.findElement(By.name("group")))
                .selectByVisibleText("[all]");
    }


    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContactEdit(contact);
        fillContactForm(modifiedContact);
        submitContactEdit();
        returnToHomePage();
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectGroupWithContacts(group);
        removeSelectedContactFromGroup(contact);
        openHomePage();
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("mobile"), contact.mobile());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        attach(By.name("photo"), contact.photo());
    }
    public ContactData getContactFormData(ContactData contact) {
        openHomePage();
        selectContactEdit(contact);
        String home = manager.driver.findElement(By.name("home")).getAttribute("value");
        String mobile = manager.driver.findElement(By.name("mobile")).getAttribute("value");
        String work = manager.driver.findElement(By.name("work")).getAttribute("value");
        String email = manager.driver.findElement(By.name("email")).getAttribute("value");
        String email2 = manager.driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = manager.driver.findElement(By.name("email3")).getAttribute("value");
        String address = manager.driver.findElement(By.name("address")).getText();
        return new ContactData()
                .withContactId(contact.id())
                .withHome(home)
                .withMobile(mobile)
                .withWork(work)
                .withAddress(address)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3);
    }
    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    private void selectGroupAtHomePage(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
        click(By.name("add"));
    }

    private void selectGroupWithContacts(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }


    private void removeSelectedContactFromGroup(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
        click(By.name("remove"));
    }


    public void submitContactEdit() {
        click(By.name("update"));
    }

    private void selectContactEdit(ContactData contact) {
        click(By.cssSelector(String.format("a[href^='edit.php?id=%s']", contact.id())));
        //click(By.cssSelector(String.format("input[value='%s']",contact.id())));
    }

    private void openHomePage() {
        if (!manager.isElementPresent((By.name("new")))) {
            click(By.linkText("home"));
        }
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCountContact() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    private void openContactPage() {
        if (!manager.isElementPresent((By.name("nickname")))) {
            click(By.linkText("add new"));
        }
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
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
    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
return result;
    }

    public Map<String, String> getEmails() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var emails = row.findElements(By.tagName("td")).get(4).getText();
            result.put(id, emails);
        }
        return result;
    }

    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[5]", contact.id()))).getText();
    }

    public String getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[4]", contact.id()))).getText();
    }
}