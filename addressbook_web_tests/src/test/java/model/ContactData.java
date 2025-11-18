package model;

public record ContactData(String firstname, String lastname, String address, String mobile, String email) {
    public ContactData(){
        this("", "", "", "","");
    }
public ContactData withFirstName(String firstName){
        return new ContactData(firstName, this.lastname, this.address, this.mobile, this.email);
}
    public ContactData withLastName(String lastName){
        return new ContactData(this.firstname, lastname, this.address, this.mobile, this.email);
    }
    public ContactData withAddress(String address){
        return new ContactData(this.firstname, this.lastname, address, this.mobile, this.email);
    }
    public ContactData withMobile(String mobile){
        return new ContactData(this.firstname, this.lastname, this.address, mobile, this.email);
    }
    public ContactData withEmail(String address){
        return new ContactData(this.firstname, this.lastname, this.address, this.mobile, email);
    }

}
