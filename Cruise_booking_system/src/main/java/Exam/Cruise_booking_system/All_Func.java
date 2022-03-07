package Exam.Cruise_booking_system;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
import java.util.Scanner;





class emailexp extends Exception{
	emailexp(){
		System.out.println("wrongs email id");
		
	}
}

class idexp extends Exception{
	idexp(){
		System.out.println("wrongs customer id");
		
	}
}





public class All_Func {

	static String fn= "customer_data.csv";
	static String fileName = "src/main/resources/"+fn;
	int flag ,d,m,y;
	static Scanner sc = new Scanner(System.in);
	
	
	public void filechecker(String file) throws emailexp {
		if(fn.equals(file)) {
			System.out.print("\ndata read sucessfully\n");
		}
		else {
			System.out.println("enter correct file name try again: ");
			App.f=sc.next();
			System.out.print("\ndata read sucessfully\n");
			
		}
	}

	public List<AllData> csv_reader(List<AllData> a) throws IOException, emailexp {

			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String ts = "";
			while ((ts = br.readLine()) != null) {
				String[] s = ts.split(",");
				String c="@gmail.com";
				String c_id=s[0];
				String e=s[2];
				if(e.endsWith(c) & e.charAt(0)>='a'& e.charAt(0)<='z' & c_id.charAt(0)=='c') {
					AllData a1 = new AllData(s[0], s[1], s[2]);
					a.add(a1);
				}
				else {
//					throw new idexp();    //cant check 2 exception at once
					throw new emailexp();
				}
				
			}
			
			return a;

		} 

		

	public void search_cust(String search, List<AllData> a) {

		flag=0;
		for (AllData ad1 : a) {

			if (ad1.getCust_name().contains(search)) {
				flag = 1;
				System.out.println("id = "+ad1.getCust_id()+" name = "+ad1.getCust_name());
			}

		}
		if (flag == 0) {
			System.out.println("\nnot found");  
		} 
		
		
	}
	
	public void search_cust_id(String id, List<AllData> a) {

		int flag=0;
		for (AllData ad1 : a) {

			if (id.equals(ad1.getCust_id())) {
				flag=1;
				System.out.println("id = "+ad1.getCust_id()+" name = "+ad1.getCust_name());

			}

		}
		if (flag == 0) {
			System.out.println("\nnot found");  
		} 

	}
	
	public void book_cruz(String funame,List<AllData> a,List<CrusieData> c) {
		String as = "", ti = "", da = "";

		flag=0;
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
				CrusieData cdi = new CrusieData();
				cdi.setC_id(ti);
				cdi.setCname(funame);
				cdi.setDate(da);
				c.add(cdi);

			}
			

		}

		if (flag == 1) {
			System.out.print("\nbooking of " + funame + " confirmed on date " + da);

		} else {
			System.out.print("\nname not found");
		}
	}
	
	
	public void cust_cruz(List<CrusieData> c) {
		flag=0;
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
		int counter=0;
		
		for (CrusieData cd1 : c) {

			if (cd1.getDate().equals(dat)) {
				flag = 1;
				counter++;
				System.out.println("\ncust id: " + cd1.getC_id() + "\tcust_name: " + cd1.getCname());
				
			}

		}
		
		System.out.print("\nnumber of attendee :"+counter);
		if (flag == 0) {
			
			System.out.print("\number attendee not present");
		} 
		
	}
	
	
	public void file_writer(List<CrusieData> c) throws IOException {
		flag=0;
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
		
		String Da=d+"_"+m+"_"+y;
		
		
		
		
		String cdate=date1;
		String path = "src/main/resources/cruise"+Da+".csv";
		File fi = new File(path);
		
		FileWriter w = new FileWriter(fi); 
		for (CrusieData cd2 : c) {


			
			if (cd2.getDate().equals(date1)) {					
				 
					w.append(cd2.getC_id());
					w.append(",");
					w.append(cd2.getCname());
					w.append(",");
					w.append(cd2.getDate()+"\n"); 
				
				}
				
		}
		w.close();
	}
	
	
	

	
	
	

}
