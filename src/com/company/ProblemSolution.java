package com.company;

/**
 * Problem statement
 * A password is considered strong if below condition are all met:
 * 1. It has at least 6 characters and at most 20 characters
 * 2. It must contain at least one lowercase letter, at least one uppercase letter,
 * and at least one digit
 * 3.It must not contain three repeating characters in a row
 *
 * Input: string, s
 * Output: int, the minimum change required to make s a strong password or
 * 0 if it is already strong.
 */

public class ProblemSolution {
    /**
     * Find how many constrain characters(lowercase, uppercase, digit) are missing
     * @param pwdArray characters array from given password string
     * @return digit from 0 to 3 representing the required missing characters
     */
    public static int getNrOfMissingCharacters(char[] pwdArray) {
        int requiredLower = 1;
        int requiredUpper = 1;
        int requiredDigit = 1;
        for (char c : pwdArray) {
            if (Character.isDigit(c)) requiredDigit = 0;
            if (Character.isUpperCase(c)) requiredUpper = 0;
            if (Character.isLowerCase(c)) requiredLower = 0;
        }
        return requiredDigit + requiredLower + requiredUpper;
    }

    /**
     * Compute the minimum number of changes in order to have a strong password
     * @param s the given string representing the password to check
     * @return the minimum number of changes in order to obtain a strong password, 0 if the password is already strong
     */
    public static int minimumChanges(String s){
        char[] pwdArray = s.toCharArray();
        int pwdLength = pwdArray.length;
        int nrMissingLUD = getNrOfMissingCharacters(pwdArray); // Step 1

        // Step 2
        int nrReplacements = 0, repeating1 = 0, repeating2 = 0;
        int nrOfRepeatingCharacters = 2;
        for(int i = 0; i <= pwdLength - 2; i++){
            if(i != pwdLength - 2 && pwdArray[i]==pwdArray[i+1] && pwdArray[i+1]==pwdArray[i+2]){
                nrOfRepeatingCharacters += 1;
            }else{
                if(nrOfRepeatingCharacters !=2 ){
                    nrReplacements += nrOfRepeatingCharacters/3;
                    if(nrOfRepeatingCharacters %3 == 0) repeating1 += 1;
                    if(nrOfRepeatingCharacters %3 == 1) repeating2 += 1;
                    nrOfRepeatingCharacters = 2;
                }
            }
        }

        // Step 3
        //Case 1
        if(pwdLength < 6){
            if(nrMissingLUD <= 6 - pwdLength) return 6 - pwdLength;
            return nrMissingLUD;
        }

        //Case 2
        if(pwdLength <= 20){
            return Math.max(nrMissingLUD, nrReplacements);
        }

        //Case 3
        int nrDeletion = pwdLength - 20;
        // if we delete 1 character from 3n repeated characters will be the same with one replacement
        nrReplacements -= Math.min(nrDeletion, repeating1);
        // if we delete 2 characters from 3n + 1 repeated character will be the same with one replacement
        nrReplacements -= Math.min(Math.max(nrDeletion - repeating1, 0), repeating2 * 2)/2 ;
        // if we delete 3 characters from 3n + 2 repeated characters will be the same with one replacement
        nrReplacements -= Math.max(nrDeletion - repeating1 - repeating2 * 2, 0)/3  ;

        return nrDeletion + Math.max(nrMissingLUD, nrReplacements);
    }
}
