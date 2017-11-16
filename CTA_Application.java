package lab6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CTA_Application extends CTA_Route{

	public static void main(String[] args) throws IOException {
		int choice=1;
		Scanner input1=new Scanner(System.in);
		readfile();
		while (choice>0) {
			System.out.println("\n1. Get all the names of the stations\n2. Display the nearest station\n3. Display information about one station"
					+ "\n4. Display the information about all the stations\n5. Add a new station\n6. Delete a station\n7. From A to B\n8. Exit\nEnter choice: ");
			choice=input1.nextInt();
			if(choice==1) { displayStationNames();
					continue;}
			else if(choice==2) { displayNearest();
					continue;}
			else if(choice==3) {displayInfo();
					continue;}
			else if(choice==4) {displayAllInfo();	
					continue;}
			else if(choice==5) {addNew();
					continue;}
			else if(choice==6) {deleteOne();
					continue;}
			else if(choice==7) {route();
		 			continue;}
			else if(choice==8) {write();
				System.out.println("\nThank you! \n");
				break;}
			else { System.out.println("Enter a number between 1 and 8 only!");
				 continue;}
			} 
	}

}
