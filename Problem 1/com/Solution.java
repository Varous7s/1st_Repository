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
//		System.out.println(a.getDamage()+"\t"+a.getPassword());
		System.out.println(checkDamage(a));
	}
	
	sc.close();
	}
	public static String checkDamage(Passcode p) 
	{
		String pswrd=p.getPassword();
		char pwd[]=pswrd.toUpperCase().toCharArray();
//		System.out.println(pwd.length);
		int countK=0,swap_count=0;
		for(int i=0;i<pwd.length;i++) {
			if(pwd[i]=='K') { 
				countK++;
			}
		}
		if(countK > p.getDamage())
			return "IMPOSSIBLE";
		else if((double)p.getDamage() >= calculateDamage(pwd))
			return Integer.toString(swap_count);
		else {
			outer_loop:
			for(int k=0;k<pwd.length;k++) {
				for(int j=0;j<pwd.length;j++) {
					int flag=0;
					//swapping of adjacent MK->KM
					for(int i=pwd.length-1;i>0;i--) {
						flag=0;
						if(pwd[i-1]=='M'&& pwd[i]=='K') {
							flag=1;
							char temp=pwd[i];
							pwd[i]=pwd[i-1];
							pwd[i-1]=temp;
							swap_count++;
//							String s=new String(pwd);
//							System.out.println(swap_count+"\t"+s);
						}
						if( (double)p.getDamage() >= calculateDamage(pwd)) 
//							return Integer.toString(swap_count);
							break outer_loop;
						if(flag==1)
							break;
					}
					if(flag==0) {
						//swapping of adjacent SK->KS
						for(int i=0;i<pwd.length;i++) {
							if(pwd[i]=='S'&& pwd[i+1]=='K') {
								char temp=pwd[i];
								pwd[i]=pwd[i+1];
								pwd[i+1]=temp;
								swap_count++;
//								String s1=new String(pwd);
//								System.out.println(swap_count+"\t"+s1);
								if( (double)p.getDamage() >= calculateDamage(pwd))
									break outer_loop;
								else
									break;
							}
						}						
					}					
				}
			}
			if(swap_count>=pwd.length)
				return "IMPOSSIBLE";
			else 
				return Integer.toString(swap_count);
		}		
	}
	
	public static double calculateDamage(char pwd[]) {
		double d=0; //initial damage
		double power=1;
		for(int i=0;i<pwd.length;i++) {
			if(pwd[i]=='K') { 
				d=power+d;
			}
			else if(pwd[i]=='M') {
				power*=3;
			} 
			else if(pwd[i]=='S' && power>=2) {
				power/=2;
			}
		}
		return d;
		
	}
}
