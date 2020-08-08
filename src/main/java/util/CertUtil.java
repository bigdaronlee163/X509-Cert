package util;

import java.math.BigInteger;
import java.util.Random;

public class CertUtil {

    static public BigInteger getNextSerialNumber(){

        long i = 123 ;
        return new  BigInteger(String.valueOf(i));



    }

    public static void main(String[] args) {
        BigInteger  bigInteger = CertUtil.getNextSerialNumber();
        System.out.println(bigInteger);
    }



}
