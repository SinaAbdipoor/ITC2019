package com.main;

/**
 * The main class and the starting point of this project.
 * <p>
 * Created by Sina on 03-Dec-21
 *
 * @author Sina
 * @version 0.6
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(initialInfo());
    }

    /**
     * Returns some basic information as the start of this project.
     *
     * @return Initial information.
     */
    static String initialInfo() {
        return "----------------------------------------------------------------------------------------------------" +
                "\n*** International Timetabling Competition 2019 ***\n" +
                "----------------------------------------------------------------------------------------------------" +
                "\nThis project aims to implement the ITC 2019 dataset. This implementation is done in " +
                "Object-Oriented Programming (OOP). The main objectives of this project are:\n" +
                "1) Loading the dataset, parsing the problem instance XML file, and storing the problem instances as " +
                "objects;\n" +
                "2) Interacting with and manipulating the problem instances;\n" +
                "3) Creating an object-oriented structure for the solution;\n" +
                "4) Utilizing optimization strategies to address this problem;\n" +
                "5) Storing the solution in the required XML format and submitting it to the ITC 2019 validator " +
                "programmatically using the ITC 2019 API.\n" +
                "For further information about the ITC 2019, visit: https://www.itc2019.org/home\n" +
                "\n***IMPORTANT***\nThis project is done as a part of my Ph.D. studies and is sponsored by " +
                "Universiti Putra Malaysia (UPM). This work is copyright protected under GNU General Public License " +
                "v3.0.\nAny personal or commercial usage of this project without proper citation is considered as " +
                "infringement.\n" +
                "GitHub Source Code: https://github.com/SinaAbdipoor/ITC2019\n" +
                "\nSina Abdipoor\nPh.D. Artificial Intelligence\n" +
                "https://sites.google.com/view/sina-abdipoor\n" +
                "----------------------------------------------------------------------------------------------------";
    }
}