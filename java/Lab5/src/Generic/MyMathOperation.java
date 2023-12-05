package Generic;

import java.util.ArrayList;

public class MyMathOperation<T extends Number> {

    public double calculateStandardDeviation(ArrayList<T> arrayList) {
        int N = arrayList.size();
        if (N <= 0) {
            throw new IllegalArgumentException("Mảng rỗng");
        }

        double sum = 0;
        double mean = calculateMean(arrayList);

        for (T element : arrayList) {
            double value = element.doubleValue();
            sum += Math.pow(value - mean, 2);
        }

        double variance = sum / N;
        return Math.sqrt(variance);
    }

    private double calculateMean(ArrayList<T> arrayList) {
        double sum = 0;
        for (T element : arrayList) {
            sum += element.doubleValue();
        }
        return sum / arrayList.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);

        MyMathOperation<Integer> intMathOperation = new MyMathOperation<>();
        double intResult = intMathOperation.calculateStandardDeviation(intList);
        System.out.println("Standard Deviation of Integer List: " + intResult);

        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(10.5);
        doubleList.add(20.7);
        doubleList.add(30.2);

        MyMathOperation<Double> doubleMathOperation = new MyMathOperation<>();
        double doubleResult = doubleMathOperation.calculateStandardDeviation(doubleList);
        System.out.println("Standard Deviation of Double List: " + doubleResult);
    }
}
