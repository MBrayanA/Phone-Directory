/*
Maintains a phone directory that will give the user options to add or change, remove, 
load previous, or search for new entries. Additionally has option to display all entries.
*/


import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) {
            Scanner kb = new Scanner(System.in);
            PhoneDirectory phoneDirectory = new PhoneDirectory();

            while (true) {
                    //menu
                    System.out.println("Select one of the options given below");
                    System.out.println("1. Load a previously saved phone directory from file");
                    System.out.println("2. Add or change an entry");
                    System.out.println("3. Remove an entry");
                    System.out.println("4. Search for an entry");
                    System.out.println("5. Display all entries");
                    System.out.println("6. Save the current phone directory to a file");
                    System.out.println("7. Quit the program");

                    BufferedReader input;
                    int pick = kb.nextInt();

                     if (pick == 1) {  // Load a previously saved phone directory from file
                            try {
                                    System.out.println("Please enter a filename");
                                    Scanner scan = new Scanner(System.in);
                                    String file = scan.nextLine();

                                    while (scan.hasNextLine()) {
                                            input = new BufferedReader(new FileReader(file));  //opens new file
                                            String s = scan.nextLine();
                                            phoneDirectory.addOrChangeEntry(s.split(" ")[0], s.split(" ")[1]);
                                    }
                                    System.out.println("All data imported.");
                            } catch (FileNotFoundException e) {
                                    System.out.println(e);
                            }
                    } else if (pick == 2) {  // Add or change an entry
                            System.out.println("Enter the name and number of the entry that you would like to add or changed:");
                            String name = kb.next();
                            String number = kb.next();
                            String oldNumber = phoneDirectory.addOrChangeEntry(name, number);
                            if (oldNumber == null) {
                                    System.out.println("The new entry was added to the Directory.");
                            } else {
                                    System.out.println("Enter the old number: " + oldNumber);
                            }
                    }  else if (pick == 3) {  // Remove an entry
                            System.out.println("Enter the name of the entry you would like to remove:");
                            String name = kb.next();
                            DirectoryEntry removed = phoneDirectory.removeEntry(name);
                            if (removed == null) {
                                    System.out.println("That entry was not found");
                            } else {
                                    System.out.println("The entry was removed");
                            }
                        } else if (pick == 4) {  // Search for an entry
                            System.out.println("Enter the name of the entry you would like to search:");
                            String name = kb.next();
                            DirectoryEntry searched = phoneDirectory.searchEntry(name);
                            if (searched == null) {
                                    System.out.println("The entry was not found");
                            } else {
                                    System.out.println("The name searched has this number: " + searched.getNumber());
                            }
                    } else if (pick == 5) {  // Display all entries
                            phoneDirectory.displayAllEntries();
                    } else if (pick == 6) {  // Save the current phone directory to a file
                            try {
                                PrintWriter output;
                                System.out.println("Enter a filename that you want to save it to");
                                String theFilename = kb.next();
                                System.out.println("Would you like to append or override the file(a/o)");
                                String answer = kb.next();
                                if (answer.equals("o")) {
                                    output = new PrintWriter(new FileOutputStream(theFilename,  false));
                                    // writing into the file
                                    for (DirectoryEntry d : phoneDirectory.getTheDirectory())
                                            output.println(d.getName() + " " + d.getNumber() + "\n");
                                   output.close();
                                } else if (answer.equals("a")) {
                                        output = new PrintWriter(new PrintWriter(new FileOutputStream(theFilename, true)));
                                         for (DirectoryEntry d : phoneDirectory.getTheDirectory())
                                            output.println(d.getName() + " " + d.getNumber() + "\n");
                                        output.close();
                                }
                            } catch (IOException e) {
                                    System.out.println(e);
                            }
                    } else if (pick == 7) {  // Quit the program
                            break;
                    } else {
                            System.out.println("That choice was not valid. Enter a valid choice");
                    }
            }
    }
}

