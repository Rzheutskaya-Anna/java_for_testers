package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData>contactProvider(){
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "testname")){
            for (var lastname : List.of("", "testlast name")){
                for (var address : List.of("", "testaddress")){
                    for (var mobile : List.of("", "testmobile")){
                        for (var email : List.of("", "testemail")){
                            result.add(new ContactData().withFirstName(firstname).withLastName(lastname).withEmail(email).withAddress(address).withMobile(mobile));
                        }
                    }
                }
for (int i = 0; i < 5; i++ ){
    result.add(new ContactData(randomString(i*10), randomString(i*10), randomString(i*10), randomString(i*10), randomString(i*10), randomString(i*10)));
}
            }
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact){
        var oldContacts = app.contact().getList();
        app.contact().createContact(contact);
        var newContacts = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withContactId(newContacts.get(newContacts.size()-1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);
    }

    @Test
    void canCreateContact(){
app.contact().createContact(new ContactData().withFirstName("test"));
    }

}
