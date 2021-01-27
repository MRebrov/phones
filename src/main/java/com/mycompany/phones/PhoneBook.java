package com.mycompany.phones;

import java.util.List;

/**
 *
 * @author mrebrov
 */
public class PhoneBook {

    private List<String> phoneNumbers;

    public PhoneBook(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers.subList(0, phoneNumbers.size());
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}
