/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.billing_system;
import javax.swing.*;  
/**
 *
 * @author Shrinidhi T S
 */
public class OptionPane {  
JFrame f;  
OptionPane(String s){  
    f=new JFrame();  
    JOptionPane.showMessageDialog(f,s);  
}  
 
}
