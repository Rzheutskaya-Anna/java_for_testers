package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemoveTests extends TestBase{

    @Test
    void canRemoveContact(){
if (!app.contact().isContactPresent()){
    app.contact().createContact(new ContactData("Ivan", "Ivanov", "Minskaya street", "147258369", "123@gmail.com"));
}
app.contact().removeContact();
    }
}
