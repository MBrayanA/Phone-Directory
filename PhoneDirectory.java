/*
Class that creates directory and implements various methods all of which are 
part of dropdown menu options that the user can choose when running main. 
*/

import java.util.*;
import java.io.*;
public class PhoneDirectory {
    private ArrayList<DirectoryEntry> theDirectory;  //creates an ArrayList
    public PhoneDirectory() {
            this.theDirectory = new ArrayList<DirectoryEntry>();
    }

    public ArrayList<DirectoryEntry> getTheDirectory() {
            return this.theDirectory;  //returns the directory
    }

    public void setTheDirectory(ArrayList<DirectoryEntry> d) {
            this.theDirectory = d;
    }

    public String addOrChangeEntry(String name, String number){
    // add an entry to directory or change an existing entry; return the old number
            for (int i = 0; i < this.theDirectory.size(); i++) {
                    if (this.theDirectory.get(i).getName().equals(name)) {
                            String oldNumber = this.theDirectory.get(i).getNumber();
                            this.theDirectory.get(i).setNumber(number);
                            return oldNumber;  //returns the old number in the phone directory
                    }
            }
            this.theDirectory.add(new DirectoryEntry(name, number));
            return null;  //returns null if it is a new entry
    }
    public DirectoryEntry searchEntry(String name) {
    // search the entry referenced by name
            for (DirectoryEntry d : this.theDirectory) {
                    if (d.getName().equals(name)) {
                            return d;  //returns the entry searched
                    }
            }
            return null; //returns null if there is no entry for name
    }

    public DirectoryEntry removeEntry(String name) {
    // remove the entry referenced by name
            int idc = -1;  //stores the index of the searched element
            for (int i = 0; i < this.theDirectory.size(); i++) {
                    if (this.theDirectory.get(i).getName().equals(name)) {
                            idc = i;
                            break;
                    }
            }
            if (idc != -1) {
                    DirectoryEntry deletedEntry = this.theDirectory.get(idc);
                    this.theDirectory.remove(idc);
                    return deletedEntry;  //returns the entry removed
            }
            return null;  //returns null if there is no entry for name
    }
    public void displayAllEntries() {
        // display all entries
                System.out.println("The entries are:");
                for (DirectoryEntry d : this.theDirectory) {
                        System.out.println(d.getName() + " has the phone number: " + d.getNumber());
                }
                System.out.println("");
        }
    }
    
    