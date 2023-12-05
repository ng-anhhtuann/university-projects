package File;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		try {
			// đọc file
			FileInputStream fis = new FileInputStream("src/File/input.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			// parse hàng đầu thành số lượng hàng
			int rFreq = Integer.parseInt(br.readLine());

			// tạo mảng 2 chiều với data trong file sau đó
			List<List<Integer>> a = new ArrayList<>();
			for (int i = 0; i < rFreq; i++) {
				String[] elements = br.readLine().split("\\s+"); // lấy data chia theo dấu cách
				List<Integer> row = new ArrayList<>();
				for (int j = 1; j < elements.length; j++) {
					row.add(Integer.parseInt(elements[j]));
				}
				a.add(row);
			}

			// lấy số truy vấn và xuất console các hàng truy vấn
			int freq = Integer.parseInt(br.readLine());
			for (int i = 0; i < freq; i++) {
				String[] query = br.readLine().split("\\s+");
				int row = Integer.parseInt(query[0]) - 1;
				int start = Integer.parseInt(query[1]) - 1;
				int end = Integer.parseInt(query[2]);

				if (row >= 0 && row < a.size() && start >= 0
						&& start < a.get(row).size()) {
					for (int j = start; j < start + end; j++) {
						if (j >= a.get(row).size()) {
							System.out.print("ERROR");
						} else {
							System.out.print(a.get(row).get(j) + " ");
						}
					}
					System.out.println();
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
