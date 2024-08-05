package by.solmed.assistant.core.domain;

import java.util.Objects;

public class Staff {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String major;
    private String subdivision;
    private String experience;
    private String category;
    private String type;

    public Staff() {
    }

    public Staff(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Staff(long id, String firstName, String lastName, String gender, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Staff(String firstName, String lastName, String gender, int age, String major,
                 String subdivision, String experience, String category, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.major = major;
        this.subdivision = subdivision;
        this.experience = experience;
        this.category = category;
        this.type = type;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return id == staff.id && age == staff.age && Objects.equals(firstName, staff.firstName)
                && Objects.equals(lastName, staff.lastName) && Objects.equals(gender, staff.gender)
                && Objects.equals(major, staff.major) && Objects.equals(subdivision, staff.subdivision)
                && Objects.equals(experience, staff.experience) && Objects.equals(category, staff.category)
                && Objects.equals(type, staff.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, age, major, subdivision, experience, category, type);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", subdivision='" + subdivision + '\'' +
                ", experience='" + experience + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
