package KurdishNumberToWords;

import java.text.DecimalFormat;

public class NumberToKurdishWords {

    private static final String[] tensNames = {"", " دە", " بیست", " سی", " چل", " پەنجا", " شەست", " حەفتا", " هەشتا", " نەوەد"};

    private static final String[] numNames = {"", " یەک", " دوو", " سێ", " چوار", " پێنج", " شەش", " حەوت", " هەشت", " نۆ", " دە", " یانزە",
        " دوانزە", " سیانزە", " چواردە", " پانزە", " شانزە", " حەڤە", " هەژدە", " نۆزدە"};

    private NumberToKurdishWords() {
    }

    //this is the main work
    public static String convert(long number) {
        // 0 to 999 999 999 999
        if (number == 0) {
            return "سفر";
        }

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

        String tradBillions;
        if (billions == 0) {
            tradBillions = "";
        } else {
            tradBillions = convertLessThanOneThousand(billions)
                    + setAnd(Integer.parseInt(snumber.substring(0, 12)), 1000000000, " بلیۆن");
        }
        String result = tradBillions;

        String tradMillions;
        if (millions == 0) {
            tradMillions = "";
        } else {
            tradMillions = convertLessThanOneThousand(millions)
                    + setAnd(Integer.parseInt(snumber.substring(3, 12)), 1000000, " ملیۆن");
        }
        result = result + tradMillions;

        String tradHundredThousands;

        if (hundredThousands == 0) {
            tradHundredThousands = "";
        } else {
            tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                    + setAnd(Integer.parseInt(snumber.substring(6, 12)), 1000, " هەزار");

        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            //ama leraya bo away agar mody 10 krd krdia sfr nache (و) dabnet
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
        if (number == 0) {
            return soFar;
        }
        return soFar.equals("") ? numNames[number] + " سەد" + soFar : numNames[number] + " سەد" + " و" + soFar;
    }

    //bo danany (و) la newan zhmarakan
    private static String setAnd(long number, long mod, String text) {
        return (number % mod != 0) ? text + " و" : text;
    }

}
