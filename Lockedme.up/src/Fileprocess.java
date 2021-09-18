import java.util.*;
import java.io.*;

public class Fileprocess{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		fileoperation fp=new fileoperation();
		fp.listfiles();
		
		
		
		
		int op;
		while(true)
		{
			try {
		op=fp.menu();
		
			}catch(InputMismatchException e)
		{
			System.out.println("Input not matching");
			continue;
		}
		switch(op)
		{
		case 1:
			fp.listfiles();
			fp.listfiles1();
			break;
		case 2:
			int op1=fp.submenu();
			 switch(op1)
			 {
			 case 1:
				 fp.addfile();
				 fp.listfiles();
				 break;
			 case 2:
				 fp.deletefile();
				 fp.listfiles();
				 break;
			 case 3:
				 fp.listfiles();
				 fp.searchfile();
				 break;
				
			 case 4:
				 continue;
				 //break;
			
			 case 5:
				 System.exit(0);
				 break;
			default:
				System.out.println("Wrong choice");
				break;
			 }
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice");
			break; 
		}
		
		}
		}
	}





class fileoperation
{
	Scanner sc=new Scanner(System.in);
	String contents[];
	int opno,opno1,m;
	fileoperation()
	{
		System.out.println("********* Welcome to lockedme.com *******************");
		System.out.println("You can perform file operations");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("this application is develpoed by Joylina Dsouza");
		System.out.println("**************************************");
		System.out.println("**************************************");
	}
	
	public int mainmenu()
	{
		System.out.println("press 1 to go back to main menu");
		int m=sc.nextInt();
		return m;
		
	}
	
	public int menu()
	{
		System.out.println("\n \nselect any option from the following menu");
		System.out.println("1. List all the files from the folder");
		System.out.println("2.Display menu for file operations");
		System.out.println("3.Exit program");
		opno=sc.nextInt();
		return opno;
	}	
	
	
	
		
	public void listfiles()
	{
		//System.out.println("enter a path for displaying the files");
		//String path=sc.next();
		File dpath= new File("/Users/ripsondsouza/Desktop/abc");
		contents = dpath.list();
		System.out.println("Selected folder: abc");
	    System.out.println("Number of files you have in your folder:" +contents.length);
	}
	
	
	public void listfiles1()
	{
		System.out.println("List of files and directories in the specified directory:");
		List<String>list = Arrays.asList(contents);
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		//System.out.println("Case Insensitive Sort = "+list);
		list.forEach(System.out::println);
	      //for(int i=0; i<contents.length; i++) {
	        // System.out.println(contents[i]);}
		
	}
	
	public int submenu()
	{
		System.out.println("1.Add new file");
		System.out.println("2.Delete any file from the folder");
		System.out.println("3.Search file from the folder");
		System.out.println("4.Go back to main menu");
		System.out.println("5. Exit from the application");
		opno1=sc.nextInt();
		return opno1;
	}
	
	
	
	
	public void addfile()
	{
		try  
		{  
			System.out.print("Enter the desired name of your file: ");
		    String fileName=sc.next();
		    String location="/Users/ripsondsouza/Desktop/abc";
		    String fileLocation=location+"/"+fileName;
		   // System.out.println(fileLocation);
		    File file = new File(fileLocation);
	       if(file.createNewFile())
	       {
	    	   System.out.println("Success!");
	    	   System.out.println("do you want to add content in your file yes or no");
			    String ch=sc.next();
			    		if(ch.equalsIgnoreCase("yes"))
			    		{
			    			FileOutputStream fos=new FileOutputStream(file);  
			    			System.out.print("Enter file content: ");         
			    			String str=sc.next(); 
			    			str+=sc.nextLine(); 
			    			byte[] b= str.getBytes();      
			    			fos.write(b);         
			    			fos.close();            
			    			System.out.println("file saved.");  
			    		}  
			    		else if(ch.equalsIgnoreCase("no"))
			    		{
			    			System.out.println("file saved with out any content");
			    		}
			    		else
			    		{
			    			System.out.println("Wrong choice");
			    		}
	       }
	       else
	       {
	    	   System.out.println("Error, file already exists");
	       }
		    

		}  
		catch(Exception e)  
		{  
		e.printStackTrace();          
		}  
		
}  
		
		
		
	
	
	public void deletefile()
	{
		System.out.print("Enter the file name you want to delete: ");
	    String fileName=sc.next();
	    String location="/Users/ripsondsouza/Desktop/abc";
	    String fileLocation=location+"/"+fileName;
	   // System.out.println(fileLocation);
	    File file = new File(fileLocation);
	    if(file.delete())
	    {
	    	System.out.println("file deleted succesfully");
	    }
	    else
	    {
	    	System.out.println("file no found ");
	    }
		
	}
	
	
	
	
	public void searchfile() throws IOException
	{
		 int i;
		System.out.print("Enter the file name you want to search: ");
	    String fileName=sc.next();
	    //System.out.println(fileName);
	    String location="/Users/ripsondsouza/Desktop/abc";
	    String fileLocation=location+"/"+fileName;
	    //System.out.println(contents.length);
	    
	    for(i=0;i<contents.length;i++)
	    { 
	 
		if(contents[i].equals(fileName))
		{
			
			
			System.out.println("File found at location" +fileLocation);
			BufferedReader br;
			
				br = new BufferedReader(new FileReader(fileLocation));
				String st;
			  
			  while ((st = br.readLine()) != null)
				    System.out.println(st);
			  
	          	st=br.readLine();
			System.out.println(st);
			  if(st==null)
			  {
				  System.out.println("\n file does not have any data");
			  }
			  
				
				  
			 
			  
			  
			
			
	    	
		}}
		if(i==contents.length)
		{
			System.out.println("file not found");
			//break;
		}
	    
		
		
	    
	}}
	
	      
	      
	
		
		
		
	
	
	
	
	
	
