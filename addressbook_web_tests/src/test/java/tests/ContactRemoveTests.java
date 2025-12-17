package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemoveTests extends TestBase{

    @Test
    void canRemoveContact(){
if (!app.contact().isContactPresent()) {
    app.contact().createContact(new ContactData("","Ivan", "Ivanov", "Minskaya-street", "147258369", "123@gmail.com", "", "", "", ""));
}
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }
    @Test
    void canRemoveContactFromGroup() {
        var groups = app.hbm().getGroupList();
        if (groups.isEmpty()) {
            app.hbm().createGroup(new GroupData("", "Test Group", "Header", "Footer"));
            groups = app.hbm().getGroupList();
        }
        var group = groups.get(0);
        if (app.hbm().getContactsInGroup(group).isEmpty()) {
            var contact = new ContactData()
                    .withFirstName("test")
                    .withLastName("test_name");
            app.contact().createContact(contact, group);
        }
        var oldContacts = app.hbm().getContactsInGroup(group);
        var contactToRemove = oldContacts.get(0);
        app.contact().removeContactFromGroup(contactToRemove, group);
        var newContacts = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldContacts.size() - 1, newContacts.size());
    }
}
