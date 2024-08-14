package by.solmed.assistant.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String phoneNumber;
    private String email;
    private String state;
    private String city;
    private String street;
    private String zip;

    public Client() {
    }

    public Client(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Client(long id, String firstName, String lastName, String gender, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Client(String firstName, String lastName, String gender, int age, String phoneNumber, String email,
                  String state, String city, String street, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zip = zip;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && age == client.age && Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName) && Objects.equals(gender, client.gender)
                && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(email, client.email)
                && Objects.equals(state, client.state) && Objects.equals(city, client.city)
                && Objects.equals(street, client.street) && Objects.equals(zip, client.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, age, phoneNumber, email, state, city, street, zip);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}