package java.ibasic;

import java.security.SecureRandom;
import java.util.Arrays;

public class IRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecureRandom rng = new SecureRandom();
        byte[] randomBytes = new byte[64];
        rng.nextBytes(randomBytes); // Fills randomBytes with random bytes (duh)
        System.out.println(Arrays.toString(randomBytes));
	}

}
