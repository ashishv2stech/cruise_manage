package Exam.Cruise_booking_system;

import java.io.*;
import java.io.*;
import java.util.*;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


/**
 *
 * customer_data.csv
 *
 */

//




public class App {
	
	static Scanner sc = new Scanner(System.in);
	static List<AllData> a = new ArrayList<AllData>();
	static List<CrusieData> c = new ArrayList<CrusieData>();
	
	public static String f;

	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, emailexp {
		All_Func af = new All_Func();
		System.out.println("---------------cruise booking system------------");
		

		CrusieData cd = new CrusieData();
		 int ch=0;
		do {
			int flag = 0,d=0,m=0,y=0;
			System.out.print(
					"\n[1]read cust data into list from file\n[2]display all cust id and name list\n[3]search cust by name in list\n[4]search cust by id in list\n[5]allow cust to book cruise\n[6]view cust booked cruise\n[7]save cust to file\n[0]exit\n");

			System.out.print("\n enter choice: ");
				ch=sc.nextInt();
				
				switch (ch) {
				case 1:
					
					System.out.println("enter file name");
					String f=sc.next();
					af.filechecker(f);
					a = af.csv_reader(a);
					System.out.println("no of customers are : "+ a.size());
					break;
				case 2:
					if(!a.isEmpty()) {
						for (AllData ad1 : a) {
							System.out.print("\n" + ad1.getCust_id() + "\t " + ad1.getCust_name());
						}
						System.out.print("\n");
					}
					else {
						System.out.print("\nenter wrong input please choose option 1\n");
					}
					
					break;
				case 3:
					if(!a.isEmpty()) {
						System.out.print("\neneter customer name you want search : ");
						String fname = sc.next();
						String sname = sc.nextLine();
						String search = fname + sname;
						af.search_cust(search, a);
					
					}
					else {
						System.out.print("\nenter wrong input please choose option 1\n");
					}
					

					break;
				case 4:
					if(!a.isEmpty()) {
						System.out.print("\neneter customer id you want search : ");
						String id=sc.next();
						af.search_cust_id(id,a);
					
					}
					else {
						System.out.print("\nenter wrong input please choose option 1\n");
					}

					break;
				case 5:
					if(!a.isEmpty()) {
						String as = "", ti = "", da = "";
						System.out.print("enter the name ");
						String f1name = sc.next();
						String s2name = sc.nextLine();
						String funame = f1name + s2name;
						af.book_cruz(funame,a,c);
					
					}
					else {
						System.out.print("\nenter wrong input please choose option 1\n");
					}

					break;
				case 6:
					if(!a.isEmpty()) {
						System.out.print("\nview cust booked cruise");
						af.cust_cruz(c);
					}
					else {
						System.out.print("\nenter wrong input please choose option 1\n");
					}
					
					break;
				case 7:
					if(!a.isEmpty()) {
						af.file_writer(c);
						System.out.print("data write suscessfull");
					
					}
					else {
						System.out.print("\nenter wrong input please choose option 1\n");
					}
					break;

				case 0:
					System.out.println("thank you!!");break;
				}
				

		} while (ch != 0);

	}
}
