package File;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/File/input.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            int rowCount = Integer.parseInt(br.readLine());

            List<List<Integer>> a = new ArrayList<>();
            for (int i = 0; i < rowCount; i++) {
                String[] ele = br.readLine().split("\\s+");
                List<Integer> row = new ArrayList<>();
                for (int j = 1; j < ele.length; j++) {
                    row.add(Integer.parseInt(ele[j]));
                }
                a.add(row);
            }

            int q = Integer.parseInt(br.readLine());
            for (int i = 0; i < q; i++) {
                String[] query = br.readLine().split("\\s+");
                int row = Integer.parseInt(query[0]) - 1;
                int rowIndex = Integer.parseInt(query[1]) - 1;
                int numOfele = Integer.parseInt(query[2]);

                if (row >= 0 && row < a.size()) {
                    List<Integer> rows = a.get(row);
                    if (rowIndex >= 0 && rowIndex < rows.size()) {
                        int endIndex = Math.min(rowIndex + numOfele, rows.size());
                        rows.subList(rowIndex, endIndex).clear(); 
                        
                        for (int j = 0; j < rows.size(); j++) {
                            System.out.print(rows.get(j) + " ");
                        }
                        if(rows.size() == 0) {
                            System.out.print("EMPTY");
                        }
                        System.out.println();
                    } else {
                        System.out.println("ERROR");
                    }
                } else {
                    System.out.println("ERROR");
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
