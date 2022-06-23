import java.util.*;

public class Main {
    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        {
            romanMap.put('I', 1);
            romanMap.put('V', 5);
            romanMap.put('X', 10);
            romanMap.put('L', 50);
            romanMap.put('C', 100);
            romanMap.put('D', 500);
            romanMap.put('M', 1000);
        }

        char[] strArray = s.toCharArray();
        int total = 0;
        int last = 1;
        int secondLast = 2;
        int length = s.length();
        int combinedValue = 0;
        char secondLastValue = 0;

        for (int i=0; i<length; i++) {

            char lastValue = strArray[strArray.length - last];

            try {
                if (secondLast < strArray.length) {
                    secondLastValue = strArray[strArray.length - secondLast];
                } else if (secondLast >= strArray.length) {
                    secondLastValue = 0;
                }
            }
            catch (Exception e) {
                throw new IndexOutOfBoundsException();
                }

            last = last + 1;
            secondLast = secondLast + 1;

            try {
                if (romanMap.get(lastValue) > romanMap.get(secondLastValue)) {
                    combinedValue = romanMap.get(lastValue) - romanMap.get(secondLastValue);
                    last = last + 1;
                    secondLast = secondLast + 1;
                    System.out.println("ITERATION " + i);
                    System.out.println("LAST VALUE " + lastValue);
                    System.out.println("SECOND LAST VALUE " + secondLastValue);
                    System.out.println("COMBINED VALUE " + combinedValue);
                } else if (secondLastValue = null) {
                    total = total + romanMap.get(lastValue);
                    System.out.println("TOTAL " + total);
                }
            }
            catch (Exception e) {
                throw new NullPointerException();
            }

            total = combinedValue + total;
        }

        System.out.println(total);
        return total;
    }
}

//else if (secondLast == strArray.length){
//                throw new IndexOutOfBoundsException();
