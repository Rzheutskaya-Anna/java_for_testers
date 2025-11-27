package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemoveTests extends TestBase{

    @Test
    void canRemoveContact(){
if (!app.contact().isContactPresent()){
    app.contact().createContact(new ContactData("","Ivan", "Ivanov", "Minskaya-street", "147258369", "123@gmail.com"));
}
        var oldContacts = app.contact().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.contact().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }
}
