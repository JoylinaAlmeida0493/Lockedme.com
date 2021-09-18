package src;
import java.io.*;
import java.util.*;
public class Filehandle {
     public static void main(String args[])throws IOException
     {
    	 
    	 
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("enter the operation you want ot perform on file");
    	 System.out.println("1. read 2.write 3.append 4. get details of file");
    	 
    	 int ch=sc.nextInt();
    	 File f0 = new File("/Users/ripsondsouza/Desktop/abc.rtf"); 
    	 switch(ch)
    	 {
    	 case 4:
    	 {
         if (f0.exists()) {  
             // Getting file name  
             System.out.println("The name of the file is: " + f0.getName());  
    
             // Getting path of the file   
             System.out.println("The absolute path of the file is: " + f0.getAbsolutePath());     
    
             // Checking whether the file is writable or not  
             System.out.println("Is file writeable?: " + f0.canWrite());    
    
             // Checking whether the file is readable or not  
             System.out.println("Is file readable " + f0.canRead());    
    
         }
         else
         {
        	 System.out.println("file does not exist");
         }
         break;
    	 }
    	 case 1:
    	 {
        BufferedReader br = new BufferedReader(new FileReader(f0));
        String st;
        
       while ((st = br.readLine()) != null)
       System.out.println(st);
       br.close();
       break;
    	 }
         
    	 case 2:
    	 {
         FileWriter fw=new FileWriter(f0);
         System.out.println("enter the string");
         String s1=sc.next();
         fw.write(s1);
         fw.close();
         break;
    	 }
    	 case 3:
    	 {
         FileWriter fw1=new FileWriter(f0,true); 
         System.out.println("enter the string");
         String s2=sc.next();
         fw1.write(s2);    
         fw1.close();
        break;
    	 }
    	 default:
    	 {
    		 
    		 System.out.println("wrong option selected");
    		 break;
    	 }
    	 
         
     }
	
	
     }}
