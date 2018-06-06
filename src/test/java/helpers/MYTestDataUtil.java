package helpers;

import globals.Globals;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Random;

public class MYTestDataUtil {

    public static String generateBsn() {
        String Result1 = "";
        int Nr9 = getRandomValue(3);
        int Nr8 = getRandomValue(10);
        int Nr7 = getRandomValue(10);
        int Nr6 = getRandomValue(10);
        int Nr5 = getRandomValue(10);
        int Nr4 = getRandomValue(10);
        int Nr3 = getRandomValue(10);
        int Nr2 = getRandomValue(10);
        int Nr1 = 0;
        int SofiNr = 0;
        if ((Nr9 == 0) && (Nr8 == 0) && (Nr7 == 0)) {
            Nr8 = 1;
        }
        SofiNr = 9 * Nr9 + 8 * Nr8 + 7 * Nr7 + 6 * Nr6 + 5 * Nr5 + 4 * Nr4 + 3 * Nr3 + 2 * Nr2;
        Nr1 = floor(SofiNr - (floor(SofiNr / 11)) * 11);
        if (Nr1 > 9) {
            if (Nr2 > 0) {
                Nr2 -= 1;
                Nr1 = 8;
            } else {
                Nr2 += 1;
                Nr1 = 1;
            }
        }
        Result1 += Nr9;
        Result1 += Nr8;
        Result1 += Nr7;
        Result1 += Nr6;
        Result1 += Nr5;
        Result1 += Nr4;
        Result1 += Nr3;
        Result1 += Nr2;
        Result1 += Nr1;
        System.out.println("Generated BSN: " + Result1);
        return Result1;
    }

    private static int getRandomValue(int max) {
    	
    	Random random = new SecureRandom();
        return random.nextInt(max);
    }
    
    private static int floor(double d) {
        return (int) d;
    }
    
    public static String generateUsername() {
    	
    	Calendar calendar = Calendar.getInstance();
    	
    	String username = Globals.USERNAME_PREFIX + 
    			calendar.get(Calendar.YEAR) + 
    			String.format("%02d", calendar.get(Calendar.MONTH)) + 
    			String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)) + 
    			String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY)) + 
    			String.format("%02d", calendar.get(Calendar.MINUTE)) + 
    			String.format("%02d", calendar.get(Calendar.SECOND));
    	
    	System.out.println("Username generated: " + username);
    	
    	return username;
    }
    
    // Generate a RijksRegisterNummer (Belgium only) based on a date of birth
    // Date of birth needs to be in DDMMYYYY format! 
    public static String generateRijksRegisterNummer(String dateOfBirth) {
    	
    	// Format date of birth for RRN calculation
    	String dateOfBirthForRrn = dateOfBirth.substring(6) + dateOfBirth.substring(2,4) + dateOfBirth.substring(0,2);
    	
    	// Generate random value to be appended to the formatted date of birth
    	String random = String.format("%03d", getRandomValue(998));
    	
    	// Do a MOD 97 on the result
    	int modrest = Integer.parseInt(dateOfBirthForRrn + random) % 97;
    	
    	// Subtract this from 97
    	int pad = 97 - modrest;
    	
    	// Add the result to the previous number to return a valid RRN
    	return dateOfBirthForRrn + random + String.format("%02d", pad);
    }
}
