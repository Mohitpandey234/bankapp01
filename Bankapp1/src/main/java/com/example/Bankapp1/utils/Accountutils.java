package com.example.Bankapp1.utils;

import javax.print.DocFlavor;
import java.time.Year;

public class Accountutils {
    /**
     * 2023 * randomsixdigit
     * */

    public static final String ACCOUNT_EXIST_CODE="001";
    public static final String ACCOUNT_EXIST_MESSAGE="This user already exist";

    public static final String ACCOUNT_CREATION_SUCCESS="002";
    public static final String ACCOUNT_CREATION_MESSAGE="Account successfully created";

    Year currentYear= Year.now();
    int min=100000;
    int max=999999;

    //generating a random no between min and max

    int randomNumber=(int)Math.floor(Math.random() * (max-min-1) +min);
    //convert the current year and random no to string and join them together

    String year=String.valueOf(currentYear);
    String randomNumber1=String.valueOf(randomNumber);
    StringBuilder accountNumber=new StringBuilder();

    public static String generateAccountNumber(){
        Year currentYear= Year.now();
        int min=100000;
        int max=999999;

        //generating a random no between min and max

        int randomNumber=(int)Math.floor(Math.random() * (max-min-1) +min);
        //convert the current year and random no to string and join them together

        String year=String.valueOf(currentYear);
        String randomNumber1=String.valueOf(randomNumber);
        StringBuilder accountNumber=new StringBuilder();
       return accountNumber.append(year).append(randomNumber1).toString();

    }
}
