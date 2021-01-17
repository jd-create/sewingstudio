package nl.pianoatelierdemeijer.sewingstudio.model;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

@Entity
@Table(name = "account")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "bank_account")
    private DecimalFormat bankAccount;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")   //dit moet altijd overeenstemmen met naam van 'user' van ManyToOne bij Address!!!
   private List<Address> addressList;

    public User()
    {}
    public User(String firstName,String lastName, String email, String phoneNumber, DecimalFormat bankAccount)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DecimalFormat getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(DecimalFormat bankAccount) {
        this.bankAccount = bankAccount;
    }
}
