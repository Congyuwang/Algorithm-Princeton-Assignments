package tests;

import princeton.algo.queue.*;
import princeton.algo.sort.Shuffle;
import princeton.algo.stack.*;
import princeton.algo.binaryHeap.*;
import java.util.Scanner;

class IteratorTest {
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> twoStackQueue = new TwoStackQueue<>();
        Deque<Integer> deque = new Deque<>();
        Queue<Integer> randomizedQueue = new RandomizedQueue<>();
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        Stack<Integer> arrayStack = new ArrayStack<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String item = scanner.next();
            switch (item) {
                case "-":
                    try {
                        System.out.printf("linkedQueue: %s\n", linkedQueue.dequeue());
                    } catch (Exception e) {
                        System.out.printf("linkedQueue Error: %s\n", e.getMessage());
                    }
                    try {
                        System.out.printf("arrayQueue: %s\n", arrayQueue.dequeue());
                    } catch (Exception e) {
                        System.out.printf("arrayQueue Error: %s\n", e.getMessage());
                    }
                    try {
                        System.out.printf("twoStackQueue: %s\n", twoStackQueue.dequeue());
                    } catch (Exception e) {
                        System.out.printf("twoStackQueue Error: %s\n", e.getMessage());
                    }
                    try {
                        System.out.printf("deque: %s\n", deque.dequeue());
                    } catch (Exception e) {
                        System.out.printf("deque Error: %s\n", e.getMessage());
                    }
                    try {
                        System.out.printf("randomizedQueue: %s\n", randomizedQueue.dequeue());
                    } catch (Exception e) {
                        System.out.printf("randomizedQueue Error: %s\n", e.getMessage());
                    }
                    try {
                        System.out.printf("linkedStack: %d\n", linkedStack.pop());
                    } catch (Exception e) {
                        System.out.printf("linkedStack Error: %s\n", e.getMessage());
                    }
                    try {
                        System.out.printf("arrayStack: %d\n", arrayStack.pop());
                    } catch (Exception e) {
                        System.out.printf("arrayStack Error: %s\n", e.getMessage());
                    }
                    try {
                        System.out.printf("priorityQueue: %s\n", priorityQueue.dequeue());
                    } catch (Exception e) {
                        System.out.printf("priorityQueue Error: %s\n", e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case ">>":
                    System.out.println();
                    System.out.println("arrayQueue (FIFO):");
                    for (int i : arrayQueue) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    System.out.println("twoStackQueue (FIFO):");
                    for (int i : twoStackQueue) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    System.out.println("linkedQueue (FIFO):");
                    for (int i : linkedQueue) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    System.out.println("deque (FIFO):");
                    for (int i : deque) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    System.out.println("randomizedQueue:");
                    for (int i : randomizedQueue) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    System.out.println("linkedStack (LIFO):");
                    for (int i : linkedStack) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    System.out.println("arrayStack (LIFO):");
                    for (int i : arrayStack) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    System.out.println("priorityQueue:");
                    for (int i : priorityQueue) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                case "-s":
                    Shuffle.shuffle(arrayQueue);
                    Shuffle.shuffle(arrayStack);
                    Shuffle.shuffle(linkedQueue);
                    Shuffle.shuffle(linkedStack);
                    Shuffle.shuffle(deque);
                    Shuffle.shuffle(twoStackQueue);
                    System.out.println("Shuffled!");
                    break;
                default:
                    try {
                        int intItem = Integer.parseInt(item);
                        linkedQueue.enqueue(intItem);
                        arrayQueue.enqueue(intItem);
                        twoStackQueue.enqueue(intItem);
                        deque.enqueue(intItem);
                        randomizedQueue.enqueue(intItem);
                        arrayStack.push(intItem);
                        linkedStack.push(intItem);
                        priorityQueue.enqueue(intItem);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        scanner.close();
    }
}
