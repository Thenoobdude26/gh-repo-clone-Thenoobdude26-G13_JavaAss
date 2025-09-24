package apumedicalcenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class APUMedicalCentre {

    public static void main(String[] args) {
        // Create the main frame
        String Current_user_ID = "doc001";
        JFrame frame = new JFrame("APU Medical Centre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null); // center on screen

        // Create the Doctor panel
        Doctor doctorPanel = new Doctor(Current_user_ID); // assuming default constructor

        // Add the panel to the frame
        frame.add(doctorPanel);

        frame.setVisible(true);
    }

}



//package apumedicalcenter;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class APUMedicalCentre {
//
//    public static void main(String[] args) {
//        // Create the main frame
//        String Current_user_ID = "cust004";
//        JFrame frame = new JFrame("APU Medical Centre");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 500);
//        frame.setLocationRelativeTo(null); // center on screen
//
//        // Create the Customer panel
//        Customer customerPanel = new Customer(Current_user_ID); // assuming default constructor
//
//        // Add the panel to the frame
//        frame.add(customerPanel);
//
//        frame.setVisible(true);
//    }
//
//}

