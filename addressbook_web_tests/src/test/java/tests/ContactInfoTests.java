package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase{
    @Test
    void testPhone(){
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2())
                    .filter(s -> s != null && ! "".equals(s))
                    .collect(Collectors.joining("\n"))
        ));
        var phones = app.contact().getPhones();
        Assertions.assertEquals(expected, phones);
    }

}
