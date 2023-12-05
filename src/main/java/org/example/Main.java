package org.example;

import java.util.ArrayList;
import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
//    public static void main(String[] args) {
//        // Press Alt+Enter with your caret at the highlighted text to see how
//        // IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Shift+F9 to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);
//        }
//    }
//private static ArrayList<String> removedMessages = new ArrayList<>();
//    public static void displayMessages(Stack messageStack, Queue messageQueue) {
//        System.out.println("Hiển thị tin nhắn từ hàng chờ:");
//        for (String message : messageQueue.getAllMessages()) {
//            System.out.println("Tin nhắn: " + message);
//            removedMessages.add(message);
//        }
//
//        System.out.println("Hiển thị tin nhắn từ ngăn xếp:");
//        for (String message : messageStack.getAllMessages()) {
//            System.out.println("Tin nhắn: " + message);
//            removedMessages.add(message);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Stack messageStack = new Stack(5);
//        Queue messageQueue = new Queue(5);
//
//        while (true) {
//            System.out.println("1. Nhập tin nhắn");
//            System.out.println("2. Hiển thị tin nhắn");
//            System.out.println("3. Kết thúc");
//
//            System.out.print("Chọn hành động (1-3): ");
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Nhập tin nhắn: ");
//                    String message = scanner.next();
//
//                    // Kiểm tra tin nhắn trước khi đưa vào hàng chờ và ngăn xếp
//                    if (isValidMessage(message)) {
//                        messageQueue.insert(message);
//                        messageStack.push(message);
//                    }
//                    break;
//                case 2:
//                    if (removedMessages.isEmpty()) {
//                        System.out.println("Không có tin nhắn để hiển thị.");
//                    } else {
//                        System.out.println("Hiển thị tin nhắn đã nhập:");
//                        for (String msg : removedMessages) {
//                            System.out.println("Tin nhắn: " + msg);
//                        }
//                    }
//                    break;
//                case 3:
//                    System.out.println("Kết thúc chương trình.");
//                    System.exit(0);
//                default:
//                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
//            }
//        }
//    }
//
//    // Phương thức kiểm tra tin nhắn
//    public static boolean isValidMessage(String message) {
//        // Kiểm tra độ dài không vượt quá 250 ký tự
//        if (message.length() > 250) {
//            System.out.println("Tin nhắn không được vượt quá 250 ký tự.");
//            return false;
//        }
//
//        // Kiểm tra xem có chứa ký tự spam không
//        if (message.matches("(\\w)*(\\w)\\2(\\w)*")) {
//            System.out.println("Tin nhắn chứa ký tự spam. Vui lòng nhập lại.");
//            return false;
//        }
//
//        return true;
//    }
//}
private static ArrayList<String> removedMessages = new ArrayList<>();

    public static void displayMessages(Stack messageStack, Queue messageQueue) {
        System.out.println("Hiển thị tin nhắn từ hàng chờ:");
        for (String message : messageQueue.getAllMessages()) {
            System.out.println("Tin nhắn: " + message);
            removedMessages.add(message);
        }

        System.out.println("Hiển thị tin nhắn từ ngăn xếp:");
        for (String message : messageStack.getAllMessages()) {
            System.out.println("Tin nhắn: " + message);
            removedMessages.add(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack messageStack = new Stack(5);
        Queue messageQueue = new Queue(5);

        while (true) {
            System.out.println("1. Nhập tin nhắn");
            System.out.println("2. Kiểm tra và đẩy tin nhắn vào hàng chờ");
            System.out.println("3. Hiển thị tin nhắn");
            System.out.println("4. Kết thúc");

            System.out.print("Chọn hành động (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tin nhắn: ");
                    String message = scanner.next();

                    // Kiểm tra tin nhắn trước khi đưa vào hàng chờ và ngăn xếp
                    if (isValidMessage(message)) {
                        System.out.println("test");
                        messageQueue.enqueue(message);
                        System.out.println(messageQueue.getAllMessages());
                    } else {
                        System.out.println("Tin nhắn không hợp lệ. Vui lòng nhập lại.");
                    }
                    break;

                case 2:
                    if (messageQueue.isFull()) {
                        // Nếu hàng chờ đầy, bắt đầu dequeue và đẩy vào ngăn xếp
                        while (!messageQueue.isEmpty()) {
                            String msg = messageQueue.dequeue();
                            messageStack.push(msg);
                            System.out.println("Đã dequeue và đẩy vào ngăn xếp: " + msg);
                        }
                    } else {
                        // Nếu hàng chờ chưa đầy, quay lại nhập tin nhắn
                        System.out.println("Hàng chờ chưa đầy. Quay lại nhập tin nhắn.");
                    }
                    break;

                case 3:
                    // Hiển thị tin nhắn từ ngăn xếp
                    while (!messageStack.isEmpty()) {
                        String msg = messageStack.pop();
                        System.out.println("Tin nhắn từ ngăn xếp: " + msg);
                        removedMessages.add(msg);
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }

        }
    }

    // Phương thức kiểm tra tin nhắn
    public static boolean isValidMessage(String message) {
        // Kiểm tra độ dài không vượt quá 250 ký tự
        if (message.length() > 250) {
            System.out.println("Tin nhắn không được vượt quá 250 ký tự.");
            return false;
        }

        // Kiểm tra xem có chứa ký tự spam không
        if (message.matches("(\\w)*(\\w)\\2(\\w)*")) {
            System.out.println("Tin nhắn chứa ký tự spam. Vui lòng nhập lại.");
            return false;
        }

        return true;
    }
}
