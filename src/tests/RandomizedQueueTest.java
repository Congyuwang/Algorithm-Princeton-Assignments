package tests;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import princeton.algo.queue.LinkedQueue;
import princeton.algo.stack.LinkedStack;
import princeton.algo.queue.RandomizedQueue;
import princeton.algo.queue.Deque;

class RandomizedQueueTest {
    public static void main(String[] args) {
        int RANGE = 10;
        int ROUND = 10000;
        test("randomizedQueue", RANGE, ROUND);
        test("deque", RANGE, ROUND);
        test("linkedQueue", RANGE, ROUND);
        test("linkedStack", RANGE, ROUND);
    }

    public static void test(String algorithm, int range, int round) {
        final int RANGE = range;
        final int ROUND = round;
        final int[][] uniformChecker = new int[RANGE][RANGE];
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        Deque<Integer> deque = new Deque<>();
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        // add integers
        for (int i = 0; i < RANGE; i++) {
            switch (algorithm) {
                case "randomizedQueue":
                    randomizedQueue.enqueue(i);
                    break;
                case "deque":
                    deque.enqueue(i);
                    break;
                case "linkedQueue":
                    linkedQueue.enqueue(i);
                    break;
                case "linkedStack":
                    linkedStack.push(i);
                    break;
                default:
                    break;
            }
        }
        // count the appearance of number s at position pos
        switch (algorithm) {
            case "randomizedQueue":
                for (int r = 0; r < ROUND; r++) {
                    int pos = 0;
                    for (int s : randomizedQueue) {
                        uniformChecker[pos++][s]++;
                    }
                }
                break;
            case "deque":
                for (int r = 0; r < ROUND; r++) {
                    int pos = 0;
                    deque.shuffle();
                    for (int s : deque) {
                        uniformChecker[pos++][s]++;
                    }
                }
                break;
            case "linkedQueue":
                for (int r = 0; r < ROUND; r++) {
                    int pos = 0;
                    linkedQueue.shuffle();
                    for (int s : linkedQueue) {
                        uniformChecker[pos++][s]++;
                    }
                }
                break;
            case "linkedStack":
                for (int r = 0; r < ROUND; r++) {
                    int pos = 0;
                    linkedStack.shuffle();
                    for (int s : linkedStack) {
                        uniformChecker[pos++][s]++;
                    }
                }
                break;
            default:
                break;
        }
        // print the result
        System.out.println(algorithm+":");
        for (int[] a : uniformChecker) {
            for (int s : a) {
                System.out.printf("%6d ", s);
            }
            System.out.println();
        }
        // calculate the Chi-squared statistics
        double squaredSum = 0;
        double expected = (double) ROUND / RANGE;
        for (int i = 0; i < RANGE; i++) {
            for (int j = 0; j < RANGE; j++) {
                squaredSum += Math.pow(uniformChecker[i][j] - expected, 2);
            }
        }
        int degreeOfFreedom = (RANGE - 1) * (RANGE - 1);
        double chiSquared = squaredSum / expected;
        System.out.println();
        ChiSquaredDistribution chiSquaredDistribution = new ChiSquaredDistribution(degreeOfFreedom);
        System.out.printf("Chi(%d) = %f\n", degreeOfFreedom, squaredSum / expected);
        System.out.printf("p-value = %f\n", chiSquaredDistribution.cumulativeProbability(chiSquared));
        System.out.println();
    }
}
