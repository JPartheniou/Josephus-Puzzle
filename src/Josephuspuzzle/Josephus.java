package Josephuspuzzle;

import java.util.Scanner;

public class Josephus {
	
    private static SettingJosephus group;
    private static int people;
    private static int count;
    private static int first;
    private static int type;
    private static int position;
    Scanner input = new Scanner(System.in);
    
    public void userInput(){
    	
    	
    	System.out.print("Please select game: ");
    	type = input.nextInt();
    	if(type == 1){
	        System.out.print("Please enter the total amout of people: ");        
	        people = input.nextInt();
	        System.out.print("Please enter the counter to kill: ");
	        count = input.nextInt();
	        System.out.print("Please enter the person that counting starts from: ");
	        first = input.nextInt();
    	}else if(type == 2){
    		System.out.print("Please enter the total amout of people: ");        
            people = input.nextInt();
            System.out.print("Please enter the position of the person that you want to survive: ");
            position = input.nextInt();
            System.out.print("Please enter the person that counting starts from: ");
            first = input.nextInt();
    	}else{
    		System.out.print("Your input is invalid! Please try again!");
    	}
    }
    
    public void createGroup(){
    	group = new SettingJosephus();
        for(int i=1; i<=people; i++){
        	group.appendElement(i);
        }
        //group.displayList();
    }
    
    /*public void run(){
    	if(type == 1){
	    	if(people>0 && count>0 && first>0){
	    	group.game(count, first);
	        System.out.print("The one that lives is: ");
	        group.displayList();
	    	}else{
	    		System.out.println("All your input must be greater than 0! Please try again!");
	    	}
    	}else if(type == 2){
    		if(people>0 && position>0 && position<=people && first>0){
    			int surv = 0;
    			for(int i=1; i<=people; i++){
    				group.game2(i, position, first);
    				if(group.displayPerson() == position){
    					surv = i;
    					break;
    				}
    			}
    	        System.out.print("The position of the survivor should be: " + surv);
    	    }else{
    	    	System.out.println("All your input must be greater than 0! Please try again!");
    	    }
    	}
    }*/
    
    public static void main(String args[]){    	
        Josephus c = new Josephus();
        c.userInput();
        long time1 = System.currentTimeMillis();
        //c.createGroup();
        if(type == 1){
	    	if(people>0 && count>0 && first>0){
	    		c.createGroup();
		    	group.game(count, first);
		        System.out.print("The one that lives is: ");
		        group.displayList();
	    	}else{
	    		System.out.println("All your input must be greater than 0! Please try again!");
	    	}
    	}else if(type == 2){
    		if(people>0 && position>0 && position<=people && first>0){
    			int surv = 0;
    			for(int i=1; i<=people; i++){
    				c.createGroup();
    				group.game2(i, position, first);
    				if(group.displayPerson() == position){
    					surv = i;
    					break;
    				}
    			}
    	        System.out.println("The position of the survivor should be: " + surv);
    	    }else{
    	    	System.out.println("All your input must be greater than 0! Please try again!");
    	    }
    	}
        //c.run();
        long time2 = System.currentTimeMillis();
        long timefinal = time2 - time1;
        long memoryused = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Duration of execution: " + timefinal);        
        System.out.println("Memory used for the execution: " + memoryused);       
    }
    
}