import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Задачи блока методы
        System.out.println("Задача №1");
        task1(2023);
        task1(202332);
        System.out.println();

        System.out.println("Задача №2");
        task2(0);
        task2(1);
        System.out.println();

        System.out.println("Задача №3");
        task3(98);
        task3(228);
        System.out.println();

        // Дополнительные задачи блока методы
        System.out.println("Задача №4");
        task4();
        System.out.println();

        System.out.println("Задача №5");
        task5();
        System.out.println();

        System.out.println("Задача №6");
        task6();
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public static void task1(int year) {
        if (isLeapYear(year)) {
            System.out.println(year + " год — високосный год.");
        } else {
            System.out.println(year + " год — невисокосный год.");
        }
    }

    public static String getInfoMessage(int os, int year) {
        if (year > 2014 && os == 1) {
            return "Вы используете Android." +
                    " Установите версию приложения для Android по ссылке Link1.";
        } else if (year > 2014 && os == 0) {
            return "Вы используете iOS." +
                    " Установите версию приложения для iOS по ссылке Link2.";
        } else if (year < 2015 && os == 1) {
            return "Вы используете Android." +
                    " Установите облегченную версию приложения для Android по ссылке Link3.";
        } else {
            return "Вы используете iOS." +
                    " Установите облегченную версию приложения для iOS по ссылке Link4.";
        }
    }

    public static void task2(int os) {
        int year = LocalDate.now().getYear();
        String message = getInfoMessage(os, year);
        System.out.println(message);
    }

    public static int calculateDeliveryDays(int deliveryDistance) {
        if (deliveryDistance < 20) {
            return 1;
        } else if (deliveryDistance < 60) {
            return 2;
        } else if (deliveryDistance < 100) {
            return 3;
        } else {
            return -1;
        }
    }

    public static void task3(int deliveryDistance) {
        int deliveryDays = calculateDeliveryDays(deliveryDistance);

        String message;
        if (deliveryDays != -1) {
            message = String.format("Потребуется дней: %s", deliveryDays);
        } else {
            message = "Доставки нет";
        }

        System.out.println(message);
    }

    private static void changePlaces(char[] array, int leftIndex, int rightIndex) {
        char charInMemory = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = charInMemory;
    }

    public static void reversMatrix(char[] array) {
        for (int leftIndex = 0, rightIndex = array.length - 1;
             leftIndex < rightIndex; leftIndex++, rightIndex--) {
            changePlaces(array, leftIndex, rightIndex);
//        char charInMemory;
//        for (int leftIndex = 0, rightIndex = array.length - 1;
//             leftIndex < rightIndex; leftIndex++, rightIndex--) {
//            charInMemory = array[leftIndex];
//            array[leftIndex] = array[rightIndex];
//            array[rightIndex] = charInMemory;
// Разделим функции, согласно теории: на каждую функцию один метод.
        }
    }

    private static void changePlaces(int[] array, int leftIndex, int rightIndex) {
        int inMemory = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = inMemory;
    }

    public static void reversMatrix(int[] array) {
        for (int leftIndex = 0, rightIndex = array.length - 1;
             leftIndex < rightIndex; leftIndex++, rightIndex--) {
            changePlaces(array, leftIndex, rightIndex);
        }
    }

    public static void task4() {
        char[] arrayOfNames = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        reversMatrix(arrayOfNames);
        System.out.println(Arrays.toString(arrayOfNames));

        int[] numbers = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        reversMatrix(numbers);
        System.out.println(Arrays.toString(numbers));
    }

//    public static String sortStringChars(String inputString) {
//        char[] charArray = inputString.toCharArray();
//        Arrays.sort(charArray);
//        inputString = new String(charArray);
//        return inputString;
//    }

    public static void findDuplicates(String inputString) {

        char[] charArray = inputString.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                System.out.println("В строке найден дубль символа: " + charArray[i]);
                return;
            }
        }
        System.out.println("В данной строке не имеется дублирующих символов.");
    }

    public static void task5() {
        String inputString = "asdfghkjeeeepqr4023";
        findDuplicates(inputString);
        inputString = "1234567890абвгдеё";
        findDuplicates(inputString);
    }

    public static int[] generateRandomArray(int arrayLength, int segmentLength, int segmentDisplace) {
        java.util.Random random = new java.util.Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(segmentLength) + segmentDisplace;
        }
        return array;
    }

    public static int calculateSumAllArrayValues(int[] array) {
        int sum = 0;
        for (int i : array) sum += i;
        return sum;
    }

    public static double calculateAverageArrayValue(int arrayLength, int arraySum) {
        return (double) arraySum / arrayLength;
    }

    public static double averageArrayValue(int arrayLength) {
        int[] array = generateRandomArray(arrayLength, 100000, 100000);
        return calculateAverageArrayValue(arrayLength, calculateSumAllArrayValues(array));
    }

    public static void printMessage(double value){
        System.out.printf("%s%n", value);
    }

    public static void task6() {
        printMessage(averageArrayValue(33));
        printMessage(averageArrayValue(111));
    }
}