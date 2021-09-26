package KurdishNumberToWords;

import java.text.DecimalFormat;

// convertion class
public class NumberToKurdishWords {
    // tens numbers
    private static final String[] tensNames = {"", " دە", " بیست", " سی", " چل", " پەنجا", " شەست", " حەفتا", " هەشتا", " نەوەد"};
    // 0 - 19 names
    private static final String[] numNames = {"", " یەک", " دوو", " سێ", " چوار", " پێنج", " شەش", " حەوت", " هەشت", " نۆ", " دە", " یانزە",
        " دوانزە", " سیانزە", " چواردە", " پانزە", " شانزە", " حەڤە", " هەژدە", " نۆزدە"};

    private NumberToKurdishWords() {
    }

     /**
    * number to kurdish words method
    *
    * @param number {long} - the convertion number
    * @return {String} - the number kurdish words
    */
    public static String convert(long number) {
        // 0 to 999 999 999 999
        if (number == 0) {
            return "سفر";
        }
        // converting number to String
        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9, 12));
        // billions string
        String tradBillions;
        // if the number has billions, then convertion its part to words
        if (billions == 0) {
            tradBillions = "";
        } else {
            tradBillions = convertLessThanOneThousand(billions)
                    + setAnd(Integer.parseInt(snumber.substring(0, 12)), 1000000000, " ملیار");
        }
        // result String
        String result = tradBillions;
        // millions string
        String tradMillions;
        // if the number has millions, then convertion its part to words
        if (millions == 0) {
            tradMillions = "";
        } else {
            tradMillions = convertLessThanOneThousand(millions)
                    + setAnd(Integer.parseInt(snumber.substring(3, 12)), 1000000, " ملیۆن");
        }
        result = result + tradMillions;
        // hundred thousands String
        String tradHundredThousands;
        // if the number has hundred thousands, then convertion its part to words
        if (hundredThousands == 0) {
            tradHundredThousands = "";
        } else {
            tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                    + setAnd(Integer.parseInt(snumber.substring(6, 12)), 1000, " هەزار");

        }
        result = result + tradHundredThousands;

        String tradThousand;
        // thousands string, it takes the number's less than a thousand part
        tradThousand = convertLessThanOneThousand(thousands);
        // generating result string
        result = result + tradThousand;

        // remove extra spaces and returning the result
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    /**
    * less a thousand number to string
    *
    * @param number {int} - the convertion number
    * @return {String} - the number kurdish words
    */
    private static String convertLessThanOneThousand(int number) {
        // less than a thousand number string
        String soFar;
        // if 100's mod of number was between 0-19
        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            // if 10's mod of the number was 0, it prevents adding "و"
            if (number % 10 == 0) {

                number /= 10;

                soFar = tensNames[number % 10];
                number /= 10;
            } else {
                soFar = numNames[number % 10];
                number /= 10;

                soFar = tensNames[number % 10] + " و" + soFar;
                number /= 10;
            }

        }
        // if the number got to 0
        if (number == 0) {
            return soFar;
        }
        // returning result
        return soFar.equals("") ? numNames[number] + " سەد" + soFar : numNames[number] + " سەد" + " و" + soFar;
    }

    /**
    * adding "و" between numbers
    *
    * @param number {long} - the convertion number
    * @param number {long} - number's mod
    * @param number {string} - number's word string
    * @return {String} -result string
    */
    private static String setAnd(long number, long mod, String text) {
        return (number % mod != 0) ? text + " و" : text;
    }

}
