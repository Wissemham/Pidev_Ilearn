/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.utils;

import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author MSI
 */
public class ValidMail {
    public static boolean validateEmailAddress(String votreEmail){
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(votreEmail);
    }
    
}
