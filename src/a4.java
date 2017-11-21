import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
 
public class a4 {
 
   public static void main (String[] args) {
 
    
      String userName = "5 1 3 1 3 5 1 1 3 1 6 6 1 4 4 3";
      
      /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String userName=" ";
      try {
         userName = br.readLine();
      } catch (IOException ioe) {
         System.out.println("IO error trying to read your name!");
         System.exit(1);
      }*/
      
      String[] rb = userName.split(" ");
      int[] n = new int[rb.length];
      
      for(int i =0; i<rb.length;i++){
    	  n[i] = Integer.parseInt(rb[i]);
      }
      
      int[] result = BiPartite(n);
      if(result[result.length-1] == 2)
    	  System.out.print("0"); //graph is bipartite
      else{
      for(int i=0;i<result.length-1;i++)
    	  
    	  System.out.print(result[i]+" ");
      }
   }
   
   static int[] BiPartite(int[] n) {
	 int[] color = new int[n[0]+1]; //create a color array
	 color[0] = 1; //assign first circle to s1 with color red(1)
	 LinkedList<Integer> myStack = new LinkedList<Integer>(); //create a linkedlist that function like a queue
	 myStack.add(0); //using FIFO
	 while(!myStack.isEmpty()){
		 int k = (int) myStack.pop();
		 for(int i =0;i<n[0];i++)
		 {
			 if (k!=i){ //dont campare vertex to itself
			 int left = (n[k*3+1]-n[i*3+1])*(n[k*3+1]-n[i*3+1]) + (n[k*3+2]-n[i*3+2])*(n[k*3+2]-n[i*3+2]);
			 int right = n[k*3+3]*n[k*3+3] + n[i*3+3]*n[i*3+3];
			 //System.out.println(left + ","+right);
			 if(right>=left){ //check to see whether two circle intersect
				 if(color[k] == color[i]){ //unable to bipartite the graph
					 color[n[0]] = 2; //the final block of array is for indicating whether the graph can be bipartite or not
				 }
				 else if(color[k] == 1 && color[i]== 0){ //if the vertex is unmarked, and the other vertex is red, assign the vertex blue
					 color[i] = 2;
					 myStack.add(i);
				 }
				 else if(color[i]== 0){ //assign the vertex red(because the other vertex is blue)
					 color[i] = 1;
					 myStack.add(i);
				 }
			 }
			}
		 }
		 if(myStack.size() == 0){ //check for any circles that are independent to those being colored
			 for(int i = 0;i<n[0];i++){
				 if(color[i] == 0){
					 myStack.add(i); //if an independent circle is found, add it to the linkedlist
					 color[i] = 1; //assign it to S1
					 break; //break out of for the loop
				 }
			 }
		 }
	 }
	 return color;
   }
} 