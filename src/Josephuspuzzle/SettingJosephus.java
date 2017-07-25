package Josephuspuzzle;

public class SettingJosephus {
	
    private Node firstNode;
    private int count;
      
    private static class Node{
        int person;
        Node next;
        public Node(int person){
            this.person = person;
        }
    }
    
    public void appendElement(int x){
        count++;
        Node c = new Node(x);
        if(firstNode == null){
            firstNode = c;
        }else{
            Node q = firstNode;
            while(q.next != firstNode){
                q = q.next;
            }
            q.next = c;
        }
        c.next = firstNode;
    }    
     
    public void displayList(){
        Node c = firstNode;
	    while(c.next != firstNode){
	        c = c.next;
	    }
	    System.out.println(c.person);	    
	} 
    public int displayPerson(){
        Node c = firstNode;
	    while(c.next != firstNode){
	        c = c.next;
	    }
	    return c.person;	    
	} 
     
    public int deleteNode(Node node){
        Node current = firstNode;
        Node previous = firstNode;
        int person = node.person;
        while(current.person != person){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        count--;
        return person;
    } 
    
    public void game(int countToDeath, int cba){
    	do{
    		firstNode = firstNode.next;
    	}while(firstNode.person != cba);
        Node current = firstNode;
        while(true){
            for(int i=0; i<countToDeath; i++){
                current = current.next;
            }
            firstNode = current.next;
            if(count >1){
            	System.out.println(deleteNode(current) + " dies...");
            }else{
                break;
                }
            current = firstNode;
        }
    }
    
    public void game2(int countToDeath, int cba, int abc){
    	do{
    		firstNode = firstNode.next;
    	}while(firstNode.person != cba);
        Node current = firstNode;
        while(true){
            for(int i=0; i<countToDeath; i++){
                current = current.next;
            }
            firstNode = current.next;
            if(count >1){
            	deleteNode(current);
            	//System.out.println(deleteNode(current) + " commits seppuku!");
            }else{
                break;
                }
            current = firstNode;
        }
    }    
}