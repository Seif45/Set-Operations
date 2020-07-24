import java.util.Scanner;

public class SetOperations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\r\n");
		System.out.println("Enter the universe elements and hit Enter when you finish :");
		String input = scan.next();
		int i;
		int universeSize = 0;
		char[] universe = new char[input.length()];
		for (i = 0 ; i < input.length() ; i++) {
			if (input.charAt(i) == ' ') {
				continue;
			}
			else {
				universe[universeSize++] = input.charAt(i);
			}
		}
		String universeString = input;
		String[] numbers = new String[universeSize];
		System.out.println("Enter the number of subsets");
		int n;
		input = scan.next();
		while (true) {
			try {
				while ( Integer.valueOf(input) <= 0 ) {
					System.out.println("Enter a valid number");
					input = scan.next();
				}
				if ( Integer.valueOf(input) > 0 ) {
					break;
				}
			}
			catch (NumberFormatException | NullPointerException nfe){
				System.out.println("Enter a valid number");
				input = scan.next();
			}
		}
		int j;
		n = Integer.valueOf(input);
		for ( i = 1 ; i <= n ; i++ ) {
			j = -1 ;
			while (j < input.length()) {
				System.out.println("Enter elements of the subset number " + i + " :");
				input = scan.next();
				for ( j = 0 ; j < input.length() ; j++) {
					if (input.charAt(j) == ' ') {
						continue;
					}
					else if (!universeString.contains(String.valueOf(input.charAt(j)))) {
						System.out.println("Please enter valid elements that exist in universe");
						break;
					}
					else {
						boolean found = false;
						for (int k = 0 ; k < universeSize ; k++) {
							if (input.charAt(j) == universe[k]) {
								if (numbers[k] == null) {
									numbers[k] = String.valueOf(i);
								}
								else {
									numbers[k] += i;
								}
								numbers[k] += " ";
								found = true;
							}
							if (found) {
								break;
							}
						}
					}
				}
			}
		}
		while (true) {
			System.out.println();
			System.out.println("Choose the number of the operation :");
			System.out.println("1-Union of two sets");
			System.out.println("2-Intersection of two sets");
			System.out.println("3-Complement of a set");
			System.out.println("4-Exit");
			System.out.println("------------------------------------");
			input = scan.next();
			int choice;
			while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
				System.out.println("Please choose a valid choice.");
				input = scan.next();
			}
			choice = Character.getNumericValue(input.charAt(0));
			if (choice == 1) {
				String set1,set2;
				boolean phi = true;
				System.out.println("The number of first set is");
				set1 = scan.next();
				while (true) {
					try {
						while ( (Integer.valueOf(set1) > n) || (Integer.valueOf(set1) <= 0)) {
							System.out.println("Enter a valid number");
							set1 = scan.next();
						}
						if ( (Integer.valueOf(set1) <= n) && (Integer.valueOf(set1) > 0)) {
							break;
						}

					}
					catch (NumberFormatException | NullPointerException nfe){
						System.out.println("Enter a valid number");
						set1 = scan.next();
					}
				}
				System.out.println("The number of second set is");
				set2 = scan.next();
				while (true) {
					try {
						while ( (Integer.valueOf(set2) > n) || (Integer.valueOf(set2) <= 0)) {
							System.out.println("Enter a valid number");
							set2 = scan.next();
						}
						if ( (Integer.valueOf(set2) <= n) && (Integer.valueOf(set2) > 0)) {
							break;
						}

					}
					catch (NumberFormatException | NullPointerException nfe){
						System.out.println("Enter a valid number");
						set2 = scan.next();
					}
				}
				System.out.println("The union of set " + set1 + " and " + set2 + " is");
				System.out.println();
				for (i = 0 ; i < numbers.length ; i++) {
					if ((numbers[i] != null) && (numbers[i].contains(set1) || numbers[i].contains(set2))) {
						System.out.print(String.valueOf(universe[i]) + " ");
						phi = false;
					}
				}
				if (phi) {
					System.out.print("phi");
				}
				System.out.println();
			}
			else if (choice == 2) {
				String set1,set2;
				boolean phi = true;
				System.out.println("The number of first set is");
				set1 = scan.next();
				while (true) {
					try {
						while ( (Integer.valueOf(set1) > n) || (Integer.valueOf(set1) <= 0)) {
							System.out.println("Enter a valid number");
							set1 = scan.next();
						}
						if ( (Integer.valueOf(set1) <= n) && (Integer.valueOf(set1) > 0)) {
							break;
						}

					}
					catch (NumberFormatException | NullPointerException nfe){
						System.out.println("Enter a valid number");
						set1 = scan.next();
					}
				}
				System.out.println("The number of second set is");
				set2 = scan.next();
				while (true) {
					try {
						while ( (Integer.valueOf(set2) > n) || (Integer.valueOf(set2) <= 0)) {
							System.out.println("Enter a valid number");
							set2 = scan.next();
						}
						if ( (Integer.valueOf(set2) <= n) && (Integer.valueOf(set2) > 0)) {
							break;
						}

					}
					catch (NumberFormatException | NullPointerException nfe){
						System.out.println("Enter a valid number");
						set2 = scan.next();
					}
				}
				System.out.println("The intersection of set " + set1 + " and " + set2 + " is");
				System.out.println();
				for (i = 0 ; i < numbers.length ; i++) {
					if ((numbers[i] != null) && (numbers[i].contains(set1) && numbers[i].contains(set2))) {
						System.out.print(String.valueOf(universe[i]) + " ");
						phi = false;
					}
				}
				if (phi) {
					System.out.print("phi");
				}
				System.out.println();
			}
			else if (choice == 3) {
				String set;
				boolean phi = true;
				System.out.println("The number of the set is");
				set = scan.next();
				while (true) {
					try {
						while ( (Integer.valueOf(set) > n) || (Integer.valueOf(set) <= 0)) {
							System.out.println("Enter a valid number");
							set = scan.next();
						}
						if ( (Integer.valueOf(set) <= n) && (Integer.valueOf(set) > 0)) {
							break;
						}

					}
					catch (NumberFormatException | NullPointerException nfe){
						System.out.println("Enter a valid number");
						set = scan.next();
					}
				}
				System.out.println("The complement of set " + set + " is");
				System.out.println();
				for (i = 0 ; i < numbers.length ; i++) {
					if ((numbers[i] == null) || (!numbers[i].contains(set))) {
						System.out.print(String.valueOf(universe[i]) + " ");
						phi = false;
					}
				}
				if (phi) {
					System.out.print("phi");
				}
				System.out.println();
			}
			else if (choice == 4) {
				System.out.println();
				System.out.println("Thank you");
				System.out.println("===========================================================================================================");
				break;
			}
		}
		scan.close();
	}
}
