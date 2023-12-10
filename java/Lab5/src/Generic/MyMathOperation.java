package Generic;

import java.util.ArrayList;

public class MyMathOperation<T extends Number> {

    public double calculateStandardDeviation(ArrayList<T> a) {
        int N = a.size();
        if (N <= 0) {
            throw new IllegalArgumentException("Mảng rỗng");
        }

        double sum = 0;
        double mean = calculateMean(a);

        for (T element : a) {
            double value = element.doubleValue();
            sum += Math.pow(value - mean, 2);
        }

        double var = sum / N;
        return Math.sqrt(var);
    }

    private double calculateMean(ArrayList<T> a) {
        double sum = 0;
        for (T element : a) {
            sum += element.doubleValue();
        }
        return sum / a.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(30);

        MyMathOperation<Integer> inVal = new MyMathOperation<>();
        double intResult = inVal.calculateStandardDeviation(a);
        System.out.println("Độ lệch chuẩn của Integer List: " + intResult);

        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(10.5);
        doubleList.add(20.7);
        doubleList.add(30.2);

        MyMathOperation<Double> doubleVal = new MyMathOperation<>();
        double doubleResult = doubleVal.calculateStandardDeviation(doubleList);
        System.out.println("Độ lệch chuẩn của Double List: " + doubleResult);
    }
}
