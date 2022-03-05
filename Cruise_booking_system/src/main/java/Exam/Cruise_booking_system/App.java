package Exam.Cruise_booking_system;

import java.io.*;
import java.io.*;
import java.util.*;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


/**
 * int b= 50; switch(b) { case 20:System.out.println("20 exe");break; case
 * 30:System.out.println("30 exe");break; case 40:System.out.println("40
 * exe");break; default:System.out.println("no one exe"); }
 *
 */
public class App {
	static String fileName = "src/main/resources/customer_data.csv";
	static Scanner sc = new Scanner(System.in);

	public class cruiseab {

	}

	static List<AllData> a = new ArrayList<AllData>();
	static List<CrusieData> c = new ArrayList<CrusieData>();

	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		All_Func af = new All_Func();
		System.out.println("---------------cruise booking system------------");
		int ch = 0 ; // choice for operartion

		CrusieData cd = new CrusieData();

		do {
			int flag = 0,d=0,m=0,y=0;
			System.out.print(
					"\n[1]read cust data into list from file\n[2]display all cust id and name list\n[3]search cust list\n[4]allow cust to book cruise\n[5]view cust booked cruise\n[6]save cust to file\n[0]exit\n");

			System.out.print("\n enter choice: ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				a = af.csv_reader(a);
				System.out.print("\ndata read sucessfully\n");
				break;
			case 2:
				System.out.print("\ncust id\t cust name\n");

				for (AllData ad1 : a) {
					System.out.print("\n" + ad1.getCust_id() + "\t " + ad1.getCust_name());
				}
				System.out.print("\n");
				break;
			case 3:
				System.out.print("\neneter customer name you want search : ");
				String fname = sc.next();
				String sname = sc.nextLine();
				String search = fname + sname;
				String ans = af.search_cust(search, a);
				System.out.println(ans);

				break;
			case 4:
				String as = "", ti = "", da = "";
				System.out.print("enter the name ");
				String f1name = sc.next();
				String s2name = sc.nextLine();
				String funame = f1name + s2name;
				af.book_cruz(funame,a,c);

				break;
			case 5:
				System.out.print("\nview cust booked cruise");
				af.cust_cruz(c);
				

				break;
			case 6:
				String date1 = "";
				System.out.print("\nenter the date ");
				System.out.print("\n\tenter booking day: ");
				 d = sc.nextInt();
				if (d > 0 & d <= 31) {
					d = d;
				} else {
					System.out.print(
							"***please enter value between month days that is from 1 to 31*****\n\tenter oppointment day: ");
					d = sc.nextInt();
				}
				System.out.print("\n\tenter booking month: ");
				 m = sc.nextInt();
				if (m > 0 & m <= 12) {
					m = m;
				} else {
					System.out.print(
							"***please enter value for month that is from 1 to 12*****\n\tenter oppointment month: ");
					m = sc.nextInt();
				}
				System.out.print("\n\tenter booking year: ");
				 y = sc.nextInt();
				if (y > 2021 & y <= 2025) {
					y = y;
				} else {
					System.out.print(
							"***please enter value for year that is from 2022 to 2030*****\n\tenter oppointment year: ");
					y = sc.nextInt();
				}
				date1 = d + "/" + m + "/" + y;
				
				String path = ("src/main/resources/cruise_opp.csv");
				for (CrusieData cd2 : c) {


					FileWriter w = new FileWriter(path);  
					if (cd2.getDate().equals(date1)) {					
						
							w.append(cd2.getC_id());
							w.append(",");
							w.append(cd2.getCname());
							w.append(",");
							w.append(cd2.getDate()+"\n"); 
							
						}
						w.close();
					break;
							

				}
				System.out.print("data write suscessfull");
				
				
				break;

			case 0:
				System.out.println("thank you!!");break;
			}

		} while (ch != 0);

	}
}
