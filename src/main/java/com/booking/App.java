package com.booking;

import java.util.Scanner;

import com.booking.repositary.Repo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Repo r = new Repo();
        
        System.out.println("1.book a movie seat ");
        System.out.println("2. view all booking ");
        System.out.println("3.Update number of seat ");
        System.out.println("4. delete booking");
        
        Scanner sc= new Scanner(System.in);
        
        int opration = sc.nextInt();
        //swuch case
        switch(opration) {
        case 1 : 
        	r.bookTicket();
        	break;
        case 2 :
        	r.getAll();
        	break;
        	
        case 3: 
        	r.updateNumber();
        	break;
        	
        case 4:
        	r.deleteUser();
        	break;
        	
        	default:
        		System.out.println("Enter valid opration ");
        }
        
    }
}
