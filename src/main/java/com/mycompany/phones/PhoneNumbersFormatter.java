package com.mycompany.phones;

/**
 *
 * @author mrebrov
 */
public class PhoneNumbersFormatter {

    public String removeNotNumbers(String str) {
        char[] original = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length; i++) {
            if (Character.isDigit(original[i])) {
                sb.append(Character.toString(original[i]));
            }
        }
        return sb.toString();
    }

    public String formatNumbers(String str) {
        StringBuilder sb = new StringBuilder();
        String countryCode = "7";
        String cityCode = "812";

        if (str.length() == 7) {
            sb.append(countryCode).append(cityCode);
        }
        if (str.length() == 10) {
            sb.append(countryCode);
        }
        sb.append(str);
        return sb.toString();
    }

    public String toPhoneFormat(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("+").append(str.charAt(0)).append(" ").append("(");
        for (int i = 1; i < 4; i++) {
            sb.append(str.charAt(i));
        }
        sb.append(")").append(" ");
        for (int i = 4; i < 8; i++) {
            sb.append(str.charAt(i));
        }
        sb.append("-");
        for (int i = 8; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
