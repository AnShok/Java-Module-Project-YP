public class Formatter {
    public static String formatTotalCost(double totalCost) {
        String formattedTotalCost;
        int integerPart = (int) totalCost;
        int decimalPart = (int) ((totalCost - integerPart) * 100);

        if (integerPart % 10 == 1 && integerPart % 100 != 11) {
            formattedTotalCost = integerPart + "." + String.format("%02d", decimalPart) + " рубль";
        } else if (integerPart % 10 >= 2 && integerPart % 10 <= 4 && (integerPart % 100 < 10 || integerPart % 100 >= 20)) {
            formattedTotalCost = integerPart + "." + String.format("%02d", decimalPart) + " рубля";
        } else {
            formattedTotalCost = integerPart + "." + String.format("%02d", decimalPart) + " рублей";
        }

        return formattedTotalCost;
    }
}
