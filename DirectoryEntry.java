/*
This class sets the name and number for the directory and gets the information
to be used within the phone directory class.
*/

import java.util.*;
import java.io.*;

public class DirectoryEntry {
        private String name;
        private String number;

        public DirectoryEntry(String n, String num) {
                this.name = n;
                this.number = num;
        }

        public String getName() {
                return this.name;
        }

        public void setName(String s) {
                this.name = s;
        }

        public String getNumber() {
                return this.number;
        }

        public void setNumber(String s) {
                this.number = s;
        }
}
