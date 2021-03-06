package com.kodilla.testing.library;

public class LibraryUser {
    private String firstname;
    private String lastname;
    private String peselId;

    public LibraryUser(String firstname, String lastname, String peselId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.peselId = peselId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryUser)) return false;

        LibraryUser that = (LibraryUser) o;

        if (!firstname.equals(that.firstname)) return false;
        if (!lastname.equals(that.lastname)) return false;
        return peselId.equals(that.peselId);
    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + peselId.hashCode();
        return result;
    }

    public String getFirstname() {
        return firstname;
    }

    public LibraryUser setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public LibraryUser setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getPeselId() {
        return peselId;
    }

    public LibraryUser setPeselId(String peselId) {
        this.peselId = peselId;
        return this;
    }
}
