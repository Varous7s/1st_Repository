package com;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	int t =sc.nextInt();sc.nextLine();
	String s[] = new String[t];
	Passcode p[] = new Passcode[t];
	for(int i=0;i<t;i++) {
		s[i]=sc.nextLine();
	}
	for(int i=0;i<t;i++) {
		p[i]=new Passcode(Integer.parseInt(s[i].split(" ")[0]),s[i].split(" ")[1]);
	}
	for(Passcode a:p) {
		//System.out.println(a.getDamage()+"\t"+a.getPassword());
		checkDamage(a);
	}
	
	sc.close();
	}
	public static int checkDamage(Passcode p) {
		String pswrd=p.getPassword();
		char pwd[]=pswrd.toUpperCase().toCharArray();
		double d=0; //initial damage
		double power=1;
		int countK=0,countM=0,countS=0;
		for(int i=0;i<pwd.length;i++) {
			if(pwd[i]=='K') { 
				d=power+d;
				countK++;
			}
			else if(pwd[i]=='M') {
				power*=3;
				countM++;
			}
			else if(pwd[i]=='S' && power>=1) {
				power/=2;
				countS++;
			}
		}
		if(countK > p.getDamage())
			return -1;
		else {
			d
		}
		
	}
}
