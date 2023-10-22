import java.util.Scanner;

public class Binary2Decimal {
	public void BinToNum() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap mot chuoi nhi phan: ");
        String bin = scanner.nextLine();
        
        int size = bin.length();
        boolean inv = false;
        int n = size - 1;
        int res = 0;
        int mul = 1;
        while (n >= 0) {
        	if (bin.charAt(n) != '0' && bin.charAt(n) != '1' || bin.length() > 16) {
        		System.out.println("INVALID BINARY STRING: `" + bin + "`");
        		inv = true;
        		break;
        	}
        	if (bin.charAt(n) == '1') {
        		res += mul;
        	}
        	mul *= 2;
        	n--;
        }
        
        if (inv == false) {
        	System.out.println("So thap phan tuong ung voi chuoi nhi phan `" + bin + "` la : "+ res);
        }
		
        scanner.close();
	}
}
