/*************************************************************************************
DS Mini Project : Hospital Appointment System

Group Members :
1.Ankita Patil - UCE2021550
2.Niharika Patil - UCE2021553
3.Pradnya Patil - UCE2021554
4.Sanika Patil - UCE2021555

Problem Statement : Implementing priority queue using linked list in
Hospital Appointment System to :
            1. Add new patient
            2. Revisit
            3. Search for a patient
            4. Display patient list 
            5. Discharge of patient

****************************************************************************************/

//Data structure used - Priority queue using linked list
import java.util.Scanner;    //Importing Scanner class

class node{    //Node class 
		node next;
		int id, age,problem;
		String name, gender, place, phnum,bloodgrp, date;
		int pri;
		
		//Parameterized constructor of Node class to initialize variables 
		node(int id,int age,int problem, String date,String name,String gender,String place,String phnum,String bloodgrp,int pri){
				this.id= id;
				this.age = age;
				this.problem=problem;
				this.name=name;
				this.gender = gender;
				this.place = place;
				this.phnum = phnum;
				this.date = date;
				this.pri = pri;
				this.bloodgrp=bloodgrp;
				this.next  = null;
		}
}
class Hospital{     
	Scanner sc1 = new Scanner(System.in);    //Scanner object to take input
	node front;
	node rear;
	int appointment_no;
	
	Hospital(){    //Constructor to initialize variables
		front = null;
		rear = null;
		appointment_no=0;
	}
	
	void insert() {  //Method to insert details about patient and health issue
		String n1, gen, pnum, p1,b1,d1;
		int a1,ans,priority,pr;
		node ptr;
		appointment_no++;
		
		System.out.println("Enter your name : ");
		n1=sc1.nextLine();
		System.out.println("Enter your blood group =");
		b1=sc1.nextLine();
		System.out.println("Enter your age : ");
		a1=sc1.nextInt();
		sc1.nextLine();
		System.out.println("Enter your gender : ");
		gen=sc1.next();
		System.out.println("Enter appointment date :");
		d1 = sc1.next();
		System.out.println("Enter your phone number(Must be ten digits) : ");
		pnum=sc1.next();
		sc1.nextLine();
		
		if(pnum.length() != 10){   //TestCase - Phone number length to be 10 digits only
			System.out.println("The phone number entered is invalid..!!!");
            System.out.println("Enter the phone number(Must be ten digits): ");
            pnum = sc1.next();
            sc1.nextLine();
		}
		System.out.println("Enter your address = ");
		p1=sc1.nextLine();
		System.out.println("Enter '1' for emergency or '0' for regular ");  //To check whether patient is emergency or regular
		ans = sc1.nextInt();
		sc1.nextLine();
		
		System.out.println("-------Health Issues-------");   //List of health issues
		System.out.println("1.Heart issues");
		System.out.println("2.Brain issues");
		System.out.println("3.Dental issues");
		System.out.println("4.Bone issue");
		System.out.println("5.ENT Problem");
		System.out.println("6.Exit");
		System.out.println("Choose your health issue :");
		pr= sc1.nextInt();
		System.out.println("Enter priority of the patient:");    //Taking input for priority of patient
		priority=sc1.nextInt();
		sc1.nextLine();
		
		//Enqueue operation using priority queue
		node new_node=new node(appointment_no,a1,pr,d1,n1,gen,p1,pnum,b1,priority); //Initializing new node with parameters
		if(front==null) {            
			front=new_node;
			rear=new_node;
		}
		else {  
			if(new_node.pri<=front.pri) {// add node at the front
				new_node.next=front;
				front=new_node;
			}
			else if(new_node.pri>=rear.pri) {// add node at the end
				rear.next=new_node;
				rear=new_node;
				rear.next=null;
			}
			else {// add node in the middle
				node temp=front;
				node prev=front;
				while(temp.pri<new_node.pri) {
					prev=temp;
					temp=temp.next;
				}
				prev.next=new_node;
				new_node.next=temp;
			}
		}
	}
	
	void display() {  //Method to display the patient details
		node curr = front;
		if(front==null) {    //Checking if patient list is empty
			System.out.println("No patients appointed till now....");
		}
		else {     //Displaying Patient Details
			while(curr!=null) {
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Appointmnt no. :  "+curr.id);
				System.out.println("Name           :  "+curr.name);
				System.out.println("Age            :  "+curr.age);
				System.out.println("Bloodgroup     :  "+curr.bloodgrp);
				System.out.println("Gender         :  "+curr.gender);
				System.out.println("Date           :  "+curr.date);
				System.out.println("Phone number   :  "+curr.phnum);
				System.out.println("Place          :  "+curr.place);
			
				switch(curr.problem) {   //Switch case for assigning appropriate Doctor according to health issue
				case 1: //For Heart issue
					System.out.println();
					System.out.println("For your problem you are assigned :");
					System.out.println("Name\t\t\tQualification\t\tSpeciality\t\t\tContact no.\tAppointment Fee");
					System.out.println("Dr Sonakshi Bose\tMS in Cardiology\tHeart specialist(Cardiologist)\t9034409346\t500");
					System.out.println();
					break;
				
				case 2: //For Brain issue
					System.out.println();
					System.out.println("For your problem you are assigned :");
					System.out.println("Name\t\t\tQualification\t\tSpeciality\t\t\tContact no.\tAppointment Fee");
					System.out.println("Dr Manav Dixit\t\tMS in Neurology\t\tBrain specialist(Neurologist)\t9276656656\t500");
					System.out.println();
					break;
				
				case 3:  //For Dental issue
					System.out.println();
					System.out.println("For your problem you are assigned :");
					System.out.println("Name\t\t\tQualification\t\tSpeciality\t\tContact no.\tAppointment Fee");
					System.out.println("Dr Supriya Rajput\tMDS in Dental Surgery\tDentist\t\t\t7845574601\t450");
					System.out.println();
					break;
				
				case 4:  //For Bone issue
					System.out.println();
					System.out.println("For your problem you are assigned :");
					System.out.println("Name\t\t\tQualification\t\tSpeciality\t\t\tContact no.\tAppointment Fee");
					System.out.println("Dr Pramod Kelkar\tMS in Orthopaedics\tBone specialist(Orthopaedist)\t7645380643\t400");
					System.out.println();
					break;
				
				case 5: //For ENT problems
					System.out.println();
					System.out.println("For your problem you are assigned :");
					System.out.println("Name\t\t\tQualification\t\tSpeciality\t\t\tContact no.\tAppointment Fee");
					System.out.println("Dr Rasika Patel\t\tMS in (ENT)\t\tENT specialist\t\t\t9160944956\t450");
					System.out.println();
					break;
				
				case 6:  //To exit the switch case
					System.out.println("Exit!!!");
					break;
				
				default : //Default statement  
					System.out.println("Invalid choice");
					break;
				}
				curr = curr.next;
			}	
		}
	}
	
	void search() {  //Method to search the patient by name
	    String nam;
	    int flag=0;
	    node curr = front;
	    System.out.println("Enter the name you want to search :");
	    nam = sc1.nextLine();
	    if(front==null) {
	    	System.out.println("No patients appointed till now....");
	    }
	    else {
	    	while(curr!=null) {
	    		if(nam.equalsIgnoreCase(curr.name)) {  //Equal Ignoring Case
	    			flag=1;
	    			break;
	    		}
	    		curr=curr.next;
	    	}
	    	if(flag==0) {
	    		System.out.println("Invalid details...");
	        }
	    	if(flag==1) {
	    		System.out.println("Patient found...!!");
		        System.out.println("Appointmnt no. :  "+curr.id);
		        System.out.println("Name           :  "+curr.name);
		        System.out.println("Age            :  "+curr.age);
		        System.out.println("Bloodgroup     :  "+curr.bloodgrp);
		        System.out.println("Gender         :  "+curr.gender);
		        System.out.println("Date           :  "+curr.date);
		        System.out.println("Phone number   :  "+curr.phnum);
		        System.out.println("Place          :  "+curr.place);
		        curr = curr.next;
	    	}
	    }
	}
	void update() {  //Method to update the information of patient
		System.out.println("Enter name of patient:");
		String n=sc1.nextLine();
		node ptr=front;
		int flag=0;
		while(ptr!=null) {
			if(ptr.name.equalsIgnoreCase(n)) {    //Equal Ignoring case
				flag=1;
				break;
			}
			ptr=ptr.next;
		}
		if(flag==1) {
			System.out.println("-------Health Issues-------");
			System.out.println("1.Heart issues");
			System.out.println("2.Brain issues");
			System.out.println("3.Dental issues");
			System.out.println("4.Bone issue");
			System.out.println("5.ENT Problem");
			System.out.println("6.Exit");
			System.out.println("Choose your health issue :");
			ptr.problem= sc1.nextInt();
			sc1.nextLine();
			System.out.println("Enter date:");
			ptr.date=sc1.nextLine();
			System.out.println("Information updated successfully...");
		}
	}
	
	//Dequeue operation using priority queue
	void delete() {  //Method to discharge the patient
		if(front==null) {
			System.out.println("No data found");;
		}else {
		node temp=front;
		front=front.next;
		temp.next=null;
		System.out.println("Details of patient given discharge:");
		System.out.println("---------------------------------------");
		System.out.println("Name         :  "+temp.name);
		System.out.println("Age          :  "+temp.age);
		System.out.println("Bloodgroup   :  "+temp.bloodgrp);
		System.out.println("Gender       :  "+temp.gender);
		System.out.println("Date         :  "+temp.date);
		System.out.println("Phone number :  "+temp.phnum);
		System.out.println("Place        :  "+temp.place);
		}
	}
}

public class Main {    //Main class
	public static void main(String[]args) {   //Main Method
		Scanner sc1 = new Scanner(System.in);   //Scanner object to take inputs
		int ch;
		Hospital d1 = new Hospital();  //Object created to call all methods
		do {
			System.out.println();
			System.out.print("\n + PATIL HOSPITAL +");
			System.out.println("\n--------------------------------");//menu
			System.out.println("1.New patient\n2.Revisit\n3.Search for a patient\n4.Display patient list\n5.Discharge patient\n6.Exit");
			System.out.println("--------------------------------");
		    System.out.println("Enter your choice :");
			ch=sc1.nextInt();
			System.out.println();
			switch(ch) {  //Switch case for menu-driven program
			case 1:
				d1.insert();   //To insert patient details
				break;
			case 2:
				d1.update();    //To update patient details
				break;
			case 3:
				d1.search();   //To search patient details
				break;
			case 4:
				d1.display();  //To display patient details
				break;
			case 5:
				d1.delete();    //To discharge patient
				break;
			case 6:
				System.out.println("Thanks for visiting us...");  //Greetings to patient
				System.out.println("Hope you get well soon!! Stay Healthy...");
				break;
			default :
				System.out.println("Your choice is invalid. Please select correct option");  //Default statement
				break;
			}
		}while(ch!=6);   //Condition for while loop
	}
}

/*****************************************************************************************
 
Output :



 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
1

Enter your name : 
Riya Patel
Enter your blood group =
O+
Enter your age : 
24
Enter your gender : 
Female
Enter appointment date :
11/12/22
Enter your phone number(Must be ten digits) : 
7869789067
Enter your address = 
Dhule
Enter '1' for emergency or '0' for regular 
0
-------Health Issues-------
1.Heart issues
2.Brain issues
3.Dental issues
4.Bone issue
5.ENT Problem
6.Exit
Choose your health issue :
5
Enter priority of the patient:
1


 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
1

Enter your name : 
Raj Malhotra
Enter your blood group =
A+
Enter your age : 
34
Enter your gender : 
Male
Enter appointment date :
6/12/22
Enter your phone number(Must be ten digits) : 
7869789076
Enter your address = 
Mumbai
Enter '1' for emergency or '0' for regular 
0

-------Health Issues-------
1.Heart issues
2.Brain issues
3.Dental issues
4.Bone issue
5.ENT Problem
6.Exit
Choose your health issue :
4
Enter priority of the patient:
2


 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
1

Enter your name : 
Omkar Kale
Enter your blood group =
AB+
Enter your age : 
50
Enter your gender : 
Male
Enter appointment date :
3/12/22
Enter your phone number(Must be ten digits) : 
745686798
The phone number entered is invalid..!!!
Enter the phone number(Must be ten digits): 

768956789609
Enter your address = 
Aurangabad
Enter '1' for emergency or '0' for regular 
1
-------Health Issues-------
1.Heart issues
2.Brain issues
3.Dental issues
4.Bone issue
5.ENT Problem
6.Exit
Choose your health issue :
1
Enter priority of the patient:
1


 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
1

Enter your name : 
Reema Roy
Enter your blood group =
B+
Enter your age : 
56
Enter your gender : 
Female
Enter appointment date :
8/12/22
Enter your phone number(Must be ten digits) : 
7234567812
Enter your address = 
Goa
Enter '1' for emergency or '0' for regular 
0
-------Health Issues-------
1.Heart issues
2.Brain issues
3.Dental issues
4.Bone issue
5.ENT Problem
6.Exit
Choose your health issue :
3
Enter priority of the patient:
3


 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
1

Enter your name : 
Kanika Gupta
Enter your blood group =
O-
Enter your age : 
38
Enter your gender : 
Female
Enter appointment date :
10/12/22
Enter your phone number(Must be ten digits) : 
6758945678
Enter your address = 
Nanded
Enter '1' for emergency or '0' for regular 
1
-------Health Issues-------
1.Heart issues
2.Brain issues
3.Dental issues
4.Bone issue
5.ENT Problem
6.Exit
Choose your health issue :
2
Enter priority of the patient:
2


 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
4

----------------------------------------------------------------------------------
Appointmnt no. :  3
Name           :  Omkar Kale
Age            :  50
Bloodgroup     :  AB+
Gender         :  Male
Date           :  3/12/22
Phone number   :  768956789609
Place          :  Aurangabad

For your problem you are assigned :
Name			Qualification		Speciality			Contact no.	Appointment Fee
Dr Sonakshi Bose	MS in Cardiology	Heart specialist(Cardiologist)	9034409346	500

----------------------------------------------------------------------------------
Appointmnt no. :  1
Name           :  Riya Patel
Age            :  24
Bloodgroup     :  O+
Gender         :  Female
Date           :  11/12/22
Phone number   :  7869789067
Place          :  Dhule

For your problem you are assigned :
Name			Qualification		Speciality	        Contact no.	Appointment Fee
Dr Rasika Patel		MS in (ENT)		ENT specialist		9160944956	450

----------------------------------------------------------------------------------
Appointmnt no. :  5
Name           :  Kanika Gupta
Age            :  38
Bloodgroup     :  O-
Gender         :  Female
Date           :  10/12/22
Phone number   :  6758945678
Place          :  Nanded

For your problem you are assigned :
Name			Qualification		Speciality			Contact no.	Appointment Fee
Dr Manav Dixit		MS in Neurology		Brain specialist(Neurologist)	9276656656	500

----------------------------------------------------------------------------------
Appointmnt no. :  2
Name           :  Raj Malhotra
Age            :  34
Bloodgroup     :  A+
Gender         :  Male
Date           :  6/12/22
Phone number   :  7869789076
Place          :  Mumbai

For your problem you are assigned :
Name			Qualification		Speciality			Contact no.	Appointment Fee
Dr Pramod Kelkar	MS in Orthopaedics	Bone specialist(Orthopaedist)	7645380643	400

----------------------------------------------------------------------------------
Appointmnt no. :  4
Name           :  Reema Roy
Age            :  56
Bloodgroup     :  B+
Gender         :  Female
Date           :  8/12/22
Phone number   :  7234567812
Place          :  Goa

For your problem you are assigned :
Name			Qualification		   Speciality		Contact no.	Appointment Fee
Dr Supriya Rajput	MDS in Dental Surgery      Dentist	        7845574601	450



 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
2

Enter name of patient:
Raj Malhotra
-------Health Issues-------
1.Heart issues
2.Brain issues
3.Dental issues
4.Bone issue
5.ENT Problem
6.Exit
Choose your health issue :
4
Enter date:
11/12/22
Information updated successfully...


 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
4

----------------------------------------------------------------------------------
Appointmnt no. :  3
Name           :  Omkar Kale
Age            :  50
Bloodgroup     :  AB+
Gender         :  Male
Date           :  3/12/22
Phone number   :  768956789609
Place          :  Aurangabad

For your problem you are assigned :
Name			Qualification		Speciality			Contact no.	Appointment Fee
Dr Sonakshi Bose	MS in Cardiology	Heart specialist(Cardiologist)	9034409346	500

----------------------------------------------------------------------------------
Appointmnt no. :  1
Name           :  Riya Patel
Age            :  24
Bloodgroup     :  O+
Gender         :  Female
Date           :  11/12/22
Phone number   :  7869789067
Place          :  Dhule

For your problem you are assigned :
Name			Qualification		Speciality		Contact no.	Appointment Fee
Dr Rasika Patel		MS in (ENT)	        ENT specialist		9160944956	450

----------------------------------------------------------------------------------
Appointmnt no. :  5
Name           :  Kanika Gupta
Age            :  38
Bloodgroup     :  O-
Gender         :  Female
Date           :  10/12/22
Phone number   :  6758945678
Place          :  Nanded

For your problem you are assigned :
Name			Qualification           Speciality			Contact no.	Appointment Fee
Dr Manav Dixit		MS in Neurology		Brain specialist(Neurologist)	9276656656	500

----------------------------------------------------------------------------------
Appointmnt no. :  2
Name           :  Raj Malhotra
Age            :  34
Bloodgroup     :  A+
Gender         :  Male
Date           :  11/12/22
Phone number   :  7869789076
Place          :  Mumbai

For your problem you are assigned :
Name			Qualification		Speciality			Contact no.	Appointment Fee
Dr Pramod Kelkar	MS in Orthopaedics	Bone specialist(Orthopaedist)	7645380643	400

----------------------------------------------------------------------------------
Appointmnt no. :  4
Name           :  Reema Roy
Age            :  56
Bloodgroup     :  B+
Gender         :  Female
Date           :  8/12/22
Phone number   :  7234567812
Place          :  Goa

For your problem you are assigned :
Name			Qualification		    Speciality		Contact no.	Appointment Fee
Dr Supriya Rajput	MDS in Dental Surgery	    Dentist	        7845574601	450



 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
3

Enter the name you want to search :
Kanika Gupta
Patient found...!!
Appointmnt no. :  5
Name           :  Kanika Gupta
Age            :  38
Bloodgroup     :  O-
Gender         :  Female
Date           :  10/12/22
Phone number   :  6758945678
Place          :  Nanded


 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
5

Details of patient given discharge:
---------------------------------------
Name         :  Omkar Kale
Age          :  50
Bloodgroup   :  AB+
Gender       :  Male
Date         :  3/12/22
Phone number :  768956789609
Place        :  Aurangabad


 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
4

----------------------------------------------------------------------------------
Appointmnt no. :  1
Name           :  Riya Patel
Age            :  24
Bloodgroup     :  O+
Gender         :  Female
Date           :  11/12/22
Phone number   :  7869789067
Place          :  Dhule

For your problem you are assigned :
Name			Qualification		Speciality	        Contact no.	Appointment Fee
Dr Rasika Patel		MS in (ENT)		ENT specialist		9160944956	450

----------------------------------------------------------------------------------
Appointmnt no. :  5
Name           :  Kanika Gupta
Age            :  38
Bloodgroup     :  O-
Gender         :  Female
Date           :  10/12/22
Phone number   :  6758945678
Place          :  Nanded

For your problem you are assigned :
Name			Qualification		Speciality			Contact no.	Appointment Fee
Dr Manav Dixit		MS in Neurology		Brain specialist(Neurologist)	9276656656	500

----------------------------------------------------------------------------------
Appointmnt no. :  2
Name           :  Raj Malhotra
Age            :  34
Bloodgroup     :  A+
Gender         :  Male
Date           :  11/12/22
Phone number   :  7869789076
Place          :  Mumbai

For your problem you are assigned :
Name			Qualification		Speciality		        Contact no.	Appointment Fee
Dr Pramod Kelkar	MS in Orthopaedics	Bone specialist(Orthopaedist)	7645380643	400

----------------------------------------------------------------------------------
Appointmnt no. :  4
Name           :  Reema Roy
Age            :  56
Bloodgroup     :  B+
Gender         :  Female
Date           :  8/12/22
Phone number   :  7234567812
Place          :  Goa

For your problem you are assigned :
Name			Qualification		    Speciality		Contact no.	Appointment Fee
Dr Supriya Rajput	MDS in Dental Surgery       Dentist	        7845574601	450



 + PATIL HOSPITAL +
--------------------------------
1.New patient
2.Revisit
3.Search for a patient
4.Display patient list
5.Discharge patient
6.Exit
--------------------------------
Enter your choice :
6

Thanks for visiting us...
Hope you get well soon!! Stay healthy...

*****************************************************************************************/
