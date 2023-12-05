package org.example;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Stack {
//    private int maxSize;
//    private int top;
//    private String[] stackArray;
//
//    public Stack(int size) {
//        maxSize = size;
//        stackArray = new String[maxSize];
//        top = -1;
//    }
//
//    public void push(String message) {
//        if (!isFull()) {
//            stackArray[++top] = message;
//            System.out.println("Đã đưa tin nhắn vào ngăn xếp.");
//        } else {
//            System.out.println("Ngăn xếp đầy, không thể đưa thêm tin nhắn.");
//        }
//    }
//
//    public String pop() {
//        if (!isEmpty()) {
//            return stackArray[top--];
//        } else {
//            return null;
//        }
//    }
//
//    public boolean isFull() {
//        return top == maxSize - 1;
//    }
//
//    public boolean isEmpty() {
//        return top == -1;
//    }
//    public List<String> getAllMessages() {
//        List<String> messages = new ArrayList<>();
//        while (!isEmpty()) {
//            messages.add(pop());
//        }
//        return messages;
//    }
//}
import java.util.ArrayList;
import java.util.Scanner;

class Stack {
    private ArrayList<String> messages;
    private int maxSize;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        messages = new ArrayList<>();
        top = -1;
    }

    public void push(String message) {
        if (isFull()) {
            System.out.println("Ngăn xếp đã đầy. Không thể thêm tin nhắn mới.");
            return;
        }
        messages.add(message);
        top++;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Ngăn xếp rỗng. Không thể lấy tin nhắn.");
            return null;
        }
        String message = messages.get(top);
        messages.remove(top);
        top--;
        return message;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public ArrayList<String> getAllMessages() {
        return messages;
    }
}