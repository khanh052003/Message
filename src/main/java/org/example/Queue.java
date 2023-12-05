package org.example;

import java.util.ArrayList;

//
//import java.util.ArrayList;
//import java.util.List;
//
//class Queue {
//    private int maxSize;
//    private int front;
//    private int rear;
//    private String[] queueArray;
//
//    public Queue(int size) {
//        maxSize = size;
//        queueArray = new String[maxSize];
//        front = 0;
//        rear = -1;
//    }
//    public List<String> getAllMessages() {
//        List<String> messages = new ArrayList<>();
//        while (!isEmpty()) {
//            messages.add(remove());
//        }
//        return messages;
//    }
//
////    public void insert(String message) {
////        if (!isFull()) {
////            if (rear == maxSize - 1) {
////                rear = -1;
////            }
////            queueArray[++rear] = message;
////            System.out.println("Đã đưa tin nhắn vào hàng chờ.");
////        } else {
////            System.out.println("Hàng chờ đầy, không thể đưa thêm tin nhắn.");
////        }
////    }
//public void insert(String message) {
//    if (rear == maxSize - 1) {
//        rear = -1;
//    }
//    queueArray[++rear] = message;
//    System.out.println("Đã đưa tin nhắn vào hàng chờ.");
//}
//
//    public String remove() {
//        if (!isEmpty()) {
//            String temp = queueArray[front++];
//            if (front == maxSize) {
//                front = 0;
//            }
//            return temp;
//        } else {
//            return null;
//        }
//    }
//
//    public boolean isFull() {
//        return (rear + 1 == front) || (front == 0 && rear == maxSize - 1);
//    }
//
//    public boolean isEmpty() {
//        return (rear + 1 == front) || (front + maxSize - 1 == rear);
//    }
//
//
//}
import java.util.ArrayList;

public class Queue {
    private ArrayList<String> messages;
    private int maxSize;
    private int front;
    private int rear;
    private int currentSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        messages = new ArrayList<>();
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public void enqueue(String message) {
        if (isFull()) {
            System.out.println("Hàng chờ đã đầy. Không thể thêm tin nhắn mới.");
            return;
        }
        rear = (rear + 1) % maxSize;
        messages.add(rear, message);
        currentSize++;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Hàng chờ rỗng. Không thể lấy tin nhắn.");
            return null;
        }
        String message = messages.get(front);
        messages.remove(front);
        rear = (rear - 1) % maxSize;
        currentSize--;
        return message;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public ArrayList<String> getAllMessages() {
        return messages;
    }



}


