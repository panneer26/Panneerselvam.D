package date;
import java.util.*;

class calc{
	 int dt,mn,yr,rm,cn,var1,mnf,rem,mnc,yrc,i,val1,fin,val,loop = 0;
	String day;
	/*dt= to store date
	 mn= to store month
	 yr= to store year
	 rm= to store last 2 digits of year
	 cn= to store first 2 digits of year
	 var1= to check leap concept
	 rem= to store sum of dte and last 2 digits of year
	 mnc= to store the month code
	 yrc= to store the year code
	 i= used to initialise yrc
	 fin= to store the final day  code*/
	Scanner sc=new Scanner(System.in);
	
	void align(int x,int y,int z) {
		dt=x;
		mn=y;
		yr=z;
	}
	void checkyr() {//to check the given inputs are right
		if(yr<=9999&&yr>=0) {
		}
		else {
			System.out.println("ENTER VALID YEAR : ");
			yr = sc.nextInt();
			checkyr();
		}
	}
	void checkmn() {
		if(mn>0&&mn<13) {
			mn=mn+0;
		 }
			else {
				System.out.println("ENTER THE VALID MONTH : ");
					mn= sc.nextInt();
					checkmn();
			}
	}
	void checkdt(){
		if(dt<32&&dt>0&&mn==1||mn==3||mn==5||mn==7||mn==8||mn==10||mn==12) {
			dt=dt+0;	
		}
		else if(dt<31&&dt>0&&mn==4||mn==6||mn==9||mn==11) {
			dt=dt+0;
			
		}
		else if((yr%4==0&&dt<30&&dt>0&&mn==2)||(yr%4!=0&&dt>0&&dt<29&&mn==2)) {
			dt=dt+0;
		}
		else {
			System.out.println("ENTER VALID DATE : ");
			dt= sc.nextInt();
			checkdt();
		}
	}
	void align() {//to initialise the year code and month code
		switch (mn) {
		case 1:
			mnc=1;
			break;
		case 2:
			mnc=4;
			break;
		case 3:
			mnc=4;
			break;
		case 4:
			mnc=0;
		case 5:
			mnc=2;
			break;
		case 6:
			mnc=5;
			break;
		case 7:
			mnc=0;
			break;
		case 8:
			mnc=3;
			break;
		case 9:
			mnc=6;
			break;
		case 10:
			mnc=1;
			break;
		case 11:
			mnc=4;
			break;
		case 12:
			mnc=6;
			break;
		}
		i=cn;
		while(i>=4) {
			i=i-4;
		}
		switch (i) {
		case 0:
			yrc=6;
			break;
		case 1:
			yrc=4;
			break;
		case 2:
			yrc=2;
			break;
		case 3:
			yrc=0;
			break;
		}
	}
	//mnf=val1-yrc-rem-dt-rm;
    void comcal(){
    	rm=(yr%100);
		cn=(yr/100);
		rem=(rm/4);
		align();
    }
	void proc() {//to calculate
			comcal();
			val=(mnc+yrc+rem+dt+rm);
			fin=val%7;
			if (mn==4) {
				fin=fin-2;
			}
			if(yr%4==0) {
				switch (mn) {
				case 1:
					fin=fin-1;
					break;
				case 2:
					fin=fin-1;
					break;
				}
			}
			switch (fin) {
			case -1:
				fin=6;
				break;
			case -2:
				fin=5;
				break;
			case -3:
				fin=4;
				break;
			case -4:
				fin=3;
				break;
			case -5:
				fin=2;
				break;
			case -6:
				fin=1;
				break;
			case -7:
				fin=0;
				break;
			}
	}
	void display() {// display the output
			if(fin<7) {
				System.out.println("\n");
				switch (fin) {
				case 0:
					System.out.println("SATURDAY");
					break;
				case 1:
					System.out.println("SUNDAY");
					break;
				case 2:
					System.out.println("MONDAY");
					break;
				case 3:
					System.out.println("TUESDAY");
					break;
				case 4:
					System.out.println("WEDNESDAY");
                    break;
				case 5:
					System.out.println("THURSDAY");
                    break;
				case 6:
					System.out.println("FRIDAY");
                    break;
                    }
				System.out.println("\n");
			}			
		}
		
	void dispmon(int h) {
		switch (h) {
        case 1:
			System.out.println("JANUARY\n");
			break;
        case 2:
			System.out.println("FEBRUARY\n");
			break;
        case 3:
			System.out.println("MARCH\n");
			break;
        case 4:
			System.out.println("APRIL\n");
			break;
        case 5:
			System.out.println("MAY\n");
			break;
        case 6:
			System.out.println("JUNE\n");
			break;
        case 7:
			System.out.println("JULY\n");
			break;
        case 8:
			System.out.println("AUGUST\n");
			break;
        case 9:
			System.out.println("SEPTEMBER\n");
			break;
        case 10:
			System.out.println("OCTOBER\n");
			break;
        case 11:
			System.out.println("NOVEMBER\n");
			break;
        case 12:
			System.out.println("DECEMBER\n");
			break;
		  default:
			System.out.println("ENTER VALID MONTH");
			}
	}
	  void dispcal(int month) {
		  int u,m=0,co=0;
			align(1,month,yr);
	        dispmon(month);
	        comcal();
	        proc();
			System.out.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
			switch (fin) {
			case 0:
				System.out.print("\n\t\t\t\t\t\t");
				m=1;
				break;
			case 1:
				System.out.print("\n");
				m=7;
				break;
			case 2:
				System.out.print("\n\t");
				m=6;
				break;
			case 3:
				System.out.print("\n\t\t");
				m=5;
				break;
			case 4:
				System.out.print("\n\t\t\t");
				m=4;
	            break;
			case 5:
				System.out.print("\n\t\t\t\t");
				m=3;
	            break;
			case 6:
				System.out.print("\n\t\t\t\t\t");
				m=2;
	            break;
	            }	
			if(mn==1||mn==3||mn==5||mn==7||mn==8||mn==10||mn==12) {
				loop=31;
			}
			else if(mn==4||mn==6||mn==9||mn==11) {
				loop=30;
			}
			else if(yr%4==0&&mn==2) {
				loop=29;
			}
			else if(yr%4!=0&mn==2) {
				loop=28;
			}
			for(u=1;u<=loop;) {
				for(int l=1;l<=m &&u<=loop;l++) {
					System.out.print(""+u);
					System.out.print("\t");
					u++;
					if(co>=m) {
						m=7;
					}
					co++;
				}
				System.out.println("");
			}
		System.out.println("\n");
		}
	}

public class date {
	public static void main(String[] args) {
		Scanner scs=new Scanner(System.in);
		calc s = new calc();
		int g = 0;
		int dat,mon,yer,ch;
		do{
		System.out.println("HI THERE.....\nWHAT DO YOU WANT...?\n1.DATE CALCULATION\n2.MONTH CALENDAR\n3.YEAR CALENDAR\n");
		System.out.println("ENTER YOUR CHOICE :");
		ch=scs.nextInt();
		switch (ch) {
		case 1:
			System.out.println("ENTER THE DATE : ");
			dat = scs.nextInt();
			System.out.println("ENTER THE MONTH : ");
			mon = scs.nextInt();
			System.out.println("ENTER THE YEAR : ");
			yer = scs.nextInt();
			s.align(dat,mon,yer);
			s.checkyr();
			s.checkmn();
			s.checkdt();
			s.proc();
			s.display();
			break;
		case 2:
			System.out.println("ENTER THE MONTH : ");
			mon = scs.nextInt();
			System.out.println("ENTER THE YEAR : ");
			yer = scs.nextInt();
			s.align(1,mon,yer);
			s.checkyr();
			s.checkmn();
			System.out.println("\nthe month calender is\n");
			s.dispcal(mon);
			break;
		case 3:
			System.out.println("ENTER THE YEAR : ");
			yer = scs.nextInt();
			s.align(1,1,yer);
			s.checkyr();
			System.out.println("\nthe year calender is\n");
			for(int r=1;r<=12;r++) {
				s.dispcal(r);
			}
			break;
		}	
			System.out.println("\n\nif YOU WANT TO PROCEED ANOTHER TIME THEN CLICK 1 else CKICK 0");
			g= scs.nextInt() ;
			}while(g==1);
			scs.close();	
			}
	  }