package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    // Constructor with only myNumber
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    // Constructor with myNumber and initial contact list
    public MobilePhone(String myNumber, List<Contact> initialContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(initialContacts);
    }

    // Getter methods
    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    // Add a new contact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false; // Contact already exists
        }
        myContacts.add(contact);
        return true;
    }

    // Update an existing contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            return false; // Contact not found
        }
        myContacts.set(foundPosition, newContact);
        return true;
    }

    // Remove a contact
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false; // Contact not found
        }
        myContacts.remove(foundPosition);
        return true;
    }

    // Find contact by Contact object (Now public)
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    // Find contact by name (Now public)
    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // Query contact by name
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null; // Contact not found
    }

    // Print all contacts
    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}

