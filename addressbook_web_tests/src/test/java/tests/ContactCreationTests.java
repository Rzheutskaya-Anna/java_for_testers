package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData>contactProvider(){
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "test name")){
            for (var lastname : List.of("", "test last name")){
                for (var address : List.of("", "test address")){
                    for (var mobile : List.of("", "test mobile")){
                        for (var email : List.of("", "test email")){
                            result.add(new ContactData(firstname, lastname,address, mobile, email));
                        }
                    }
                }
for (int i = 0; i < 5; i++ ){
    result.add(new ContactData(randomString(i*10), randomString(i*10), randomString(i*10), randomString(i*10), randomString(i*10)));
}
            }
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact){
        int contactCount = app.contact().getCountContact();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getCountContact();
        Assertions.assertEquals(contactCount +1, newContactCount);

    }

    @Test
    void canCreateContact(){
app.contact().createContact(new ContactData().withFirstName("test"));
    }

}
