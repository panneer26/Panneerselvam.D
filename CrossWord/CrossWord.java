package source;
import java.util.*;
public class CrossWord {
	static String src[][]={{"T","H","S","M","A","L","L","T","R","P","T","L","A"},
							{"E","A","P","C","R","S","R","P","S","P","B","L","S"},
							{"E","L","I","C","F","T","O","S","P","A","R","Q","H"},
							{"N","I","H","D","E","T","S","E","R","I","U","V","C"},
							{"N","B","C","D","W","U","S","J","J","I","Y","B","D"},
							{"Y","M","A","E","S","Y","C","E","N","O","T","N","Y"},
							{"P","I","E","T","G","N","L","N","G","T","D","S","J"},
							{"P","S","C","U","D","U","E","C","G","C","A","A","G"},
							{"O","T","G","G","C","B","W","U","W","J","E","J","S"},
							{"I","Q","L","E","A","V","Q","K","Q","N","T","T","D"},
							{"N","D","L","S","D","C","A","H","T","M","R","E","R"},
							{"T","O","C","T","G","H","J","H","D","S","E","T","Y"},
							{"M","G","M","I","J","R","T","Y","Y","U","I","O","P"}};
	static Scanner s=new Scanner(System.in);
	static String str,rstr;
	static int len;
	public static void main(String[] args) {
		dispmat();
		System.out.print("\n\nEnter the word to be print :  ");
		str=s.next().toUpperCase();
		rstr=rev(str);
		System.out.println("\n\n");
		len=str.length();
		checkR();
		checkC();
		checkLD();
		checkRD();
		System.out.println("Combination not found");
		s.close();
	}
	static void dispmat() {
		System.out.println("The Source box is: \n");
		for(int i=0;i<13;i++) {
			for(int j=0;j<13;j++) System.out.print(src[i][j]+"  ");
			System.out.println();
		}
	}
	static void checkR() {
		String temp="";
		for(int i=0;i<13;i++) {
			temp="";
			for(int j=0;j<13;j++) temp+=src[i][j];
			if(temp.contains(str)||temp.equals(str)) {
				for(int j=0;j<=13-len;j++) {
					if(temp.substring(j,j+len).equals(str)) {
						putmat(true,i,j);
					}
				}
				
			}
			if(temp.contains(rstr)||temp.equals(rstr)) {
				for(int j=0;j<13-len;j++) {
					if(temp.substring(j,j+len).equals(rstr)) {
						putmat(true,i,j);
					}
				}
				
			}
			
		}
	}
	static String rev(String x) {
		StringBuffer rst=new StringBuffer(x);
		rst=rst.reverse();
		return rst.toString();
	}
	static void checkC() {
		String temp="";
		for(int i=0;i<13;i++){
			temp="";
			for(int j=0;j<13;j++) temp+=src[j][i];
			if(temp.contains(str)||temp.equals(str)) {
				for(int j=0;j<=13-len;j++){
					if(temp.substring(j,j+len).equals(str))  {
						putmat(false,i,j);
					}
				}
			}
			if(temp.contains(rstr)||temp.equals(rstr)) {
				for(int j=0;j<=13-len;j++){
					if(temp.substring(j,j+len).equals(rstr))  {
						putmat(false,i,j);
					}
				}
			}
		}
	}
	
	static void putmat(boolean row,int cl,int rw) {
		if(row) {
				for(int i=0;i<13;i++) {
					for(int j=0;j<13;j++) {
						if(j>=rw&&j<rw+len&&i==cl) System.out.print(src[i][j]+" ");
						else System.out.print("* ");
					}
					System.out.print("\n");
				}
		}
		else {
				for(int i=0;i<13;i++) {
					for(int j=0;j<13;j++) {
						if(i>=rw&&i<rw+len&&j==cl) System.out.print(src[i][j]+" ");
						else System.out.print("* ");
					}
					System.out.print("\n");
				}
		}
		System.exit(0);
	}
	static void checkLD() {
		String temp="";
		boolean fl=true;
		for(int j=13-len;j>=0&&j<=13;) {
			temp="";
			for(int i=0,k=j;k<13;i++,k++) {
				if(fl) {
					temp+=src[k][i];
					if(temp.contains(str)||temp.contains(rstr)) putD(true,k-len+1,i-len+1);
				}
				else {
					temp+=src[i][k];
					if(temp.contains(str)||temp.contains(rstr)) putD(true,i-len+1,k-len+1);
				}
			}
			if(j==0) fl=false;
			if(fl) j--;
			else j++;
		}
	}
	static void putD(boolean lef,int rw,int col) {
		if(lef) {
			int x=rw,y=col,c=0;
			for(int i=0;i<13;i++) {
				for(int j=0;j<13;j++) {
						if(x==i&&y==j&&c<len) {
							System.out.print(src[i][j]+" ");
							x++;
							y++;
							c++;
						}
						else System.out.print("* ");
				}
				System.out.println();
			}
			
		}
		else {
			int x=rw,y=col,c=0;
			for(int i=0;i<13;i++) {
				for(int j=0;j<13;j++) {
						if(x==i&&y==j&&c<len) {
							System.out.print(src[i][j]+" ");
							x++;
							y--;
							c++;
						}
						else System.out.print("* ");
				}
				System.out.println();
			}
		}
		System.exit(0);
	}
	static void checkRD() {
		String temp="";
		boolean fl=true;
		for(int j=13-len;j>=0&&j<=13;) {
			temp="";
			for(int i=12,k=j;k<13;i--,k++) {
				if(fl) {
					temp+=src[k][i];
					if(temp.contains(str)||temp.contains(rstr)) putD(false,k-len+1,i+len-1);
				}
				else {
					temp+=src[i][k];
					if(temp.contains(str)||temp.contains(rstr)) putD(false,i-len+1,k+len-1);
				}
			}
			if(j==0) fl=false;
			if(fl) j--;
			else j++;
		}
	}
}