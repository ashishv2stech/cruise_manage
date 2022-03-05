package Exam.Cruise_booking_system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Writer;
import java.nio.Buffer;
import java.util.List;
import java.util.Scanner;

import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.CSVReader;

public class All_Func {

	String fileName = "src/main/resources/customer_data.csv";
	int flag = 0,d,m,y;
	static Scanner sc = new Scanner(System.in);
	CrusieData cdi = new CrusieData();

	public List<AllData> csv_reader(List<AllData> a) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String ts = "";
			while ((ts = br.readLine()) != null) {
				String[] s = ts.split(",");
				AllData a1 = new AllData(s[0], s[1], s[2]);
				a.add(a1);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return a;

	}

	public String search_cust(String search, List<AllData> a) {

		String id = "", name = "", s = "";
		for (AllData ad1 : a) {

			if (search.equals(ad1.getCust_name())) {
				flag = 1;
				id = ad1.getCust_id();
				name = ad1.getCust_name();

			}

		}
		if (flag == 1) {
			s = "\n**************name found***********  " + "\ncust id: " + id + "\tcust_name: " + name;
		} else {
			s = "\nnot found";
		}

		return s;

	}
	
	
	public void book_cruz(String funame,List<AllData> a,List<CrusieData> c) {
		String as = "", ti = "", da = "";

		for (AllData ad2 : a) {

			if (ad2.getCust_name().equals(funame)) {
				flag = 1;
				ti = ad2.getCust_id();
				System.out.print("enter the date ");
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
				da = d + "/" + m + "/" + y;

			}
			cdi.setC_id(ti);
			cdi.setCname(funame);
			cdi.setDate(da);
			c.add(cdi);

		}

		if (flag == 1) {
			System.out.print("\nbooking of " + funame + " confirmed on date " + da);

		} else {
			System.out.print("\nname not found");
		}
	}
	
	
	public void cust_cruz(List<CrusieData> c) {
		String dat = "";
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
		dat = d + "/" + m + "/" + y;
		String cbook="";
		int counter=0;
		for (CrusieData cd1 : c) {

			if (cd1.getDate().equals(dat)) {
				flag = 1;
				counter++;
//				for(CrusieData cd5:c)
//					{
//					  cbook+="\n "+"cust id: " + cd5.getC_id() + "\tcust_name: " + cd5.getCname();
//					}
				 cbook+="\n "+"cust id: " + cd1.getC_id() + "\tcust_name: " + cd1.getCname();
					

			}
			break;

		}
		if (flag == 1) {
			System.out.print(cbook);
			System.out.print("\nnumber of attendee :"+counter);
		} else {
			System.out.print("\number attendee not present");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
