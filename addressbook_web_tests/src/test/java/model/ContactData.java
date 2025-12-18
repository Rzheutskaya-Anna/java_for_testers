package model;

public record ContactData(String id, String firstname, String lastname, String address, String mobile, String email, String photo,
                          String home, String work, String phone2, String email2, String email3) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "","" ,"" );
    }

    public ContactData withContactId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.address, this.mobile, this.email, this.photo, this.home, this.work, this.phone2,this.email2, this.email3 );
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.address, this.mobile, this.email, this.photo,  this.home, this.work, this.phone2,this.email2, this.email3);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.address, this.mobile, this.email, this.photo,  this.home, this.work, this.phone2,this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, address, this.mobile, this.email, this.photo,  this.home, this.work, this.phone2,this.email2, this.email3);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, mobile, this.email, this.photo,  this.home, this.work, this.phone2,this.email2, this.email3);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.mobile, email, this.photo,  this.home, this.work, this.phone2,this.email2, this.email3);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.mobile, this.email, photo,  this.home, this.work, this.phone2,this.email2, this.email3);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.mobile, this.email, photo,  this.home, work, this.phone2,this.email2, this.email3);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.mobile, this.email, photo,  home, this.work, this.phone2,this.email2, this.email3);
    }
    public ContactData withSecondary(String phone2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.mobile, this.email, photo,  this.home, this.work, phone2,this.email2, this.email3);
    }
    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.mobile, email, this.photo,  this.home, this.work, this.phone2, email2, this.email3);
    }
    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.mobile, email, this.photo,  this.home, this.work, this.phone2, this.email2, email3);
    }
}