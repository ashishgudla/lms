import java.io.*;
import java.util.*;
class a
{	
	static void adduser()throws IOException
	{	System.out.println("enter the id of the new user");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		BufferedWriter out=new BufferedWriter(new FileWriter(s,true));
	}
	static void removeuser()throws IOException
	{
		System.out.println("enter the id of the user to remove");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		File f=new File(s);
		if(f.length()==0)
			f.delete();
		else
			System.out.println("file not empty");
	}	
	static void addbook()throws IOException
	{
		BufferedReader in=new BufferedReader(new FileReader("catalogue.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the details of book as specified below");
		System.out.println("XX999.999-title-author-available/not available");
		String s=br.readLine();
		String s2=in.readLine();
		while(true)
		{	
			if(s.equals(s2))
			{
				System.out.println("\nbook already exists");
				return;
			}
			s2=in.readLine();
			if(s2==null)
				break;
		}
		in.close();
		BufferedWriter out=new BufferedWriter(new FileWriter("catalogue.txt",true));
		out.write(s);
		out.newLine();
		out.close();
	}	
	static void removebook()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in=new BufferedReader(new FileReader("catalogue.txt"));
		BufferedWriter out=new BufferedWriter(new FileWriter("temp.txt",true));
		System.out.println("enter the book-id of the book to be removed");
		String s=br.readLine();
		String s2=in.readLine();
		StringTokenizer st=new StringTokenizer(s2,"-");
		while(st.hasMoreTokens())
		{
			st=new StringTokenizer(s2,"-");
			String q=st.nextToken();
			if(!q.equals(s))
			{	
				out.write(s2);
				out.newLine();	
			}
			s2=in.readLine();
			if(s2==null)
				break ;
		}
		in.close();
		out.close();
		File f1=new File("catalogue.txt");
		File f2=new File("temp.txt");
		boolean b1=f1.delete();
		File f=new File("catalogue.txt");
		boolean b2=f2.renameTo(f);
	}	
	static void register()throws IOException
	{
		System.out.println("\nWelcome to registration");
		System.out.println("Enter ur id:");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		try{
		BufferedWriter out=new BufferedWriter(new FileWriter(s,true));}
		catch(FileNotFoundException e)
		{
			System.out.println("Invalid user");
		}
	}
	static void givebook()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the book id to be issued");
		String s1=br.readLine();
		System.out.println("enter the id to which book has to be issued");
		String s2=br.readLine();
		BufferedReader in=new BufferedReader(new FileReader("catalogue.txt"));
		BufferedWriter out=new BufferedWriter(new FileWriter("temp.txt",true));
		BufferedWriter out2=new BufferedWriter(new FileWriter(s2,true));
		String s3=in.readLine();
		outer:while(true)
		{
			int count=0;String s=null;
			StringTokenizer st=new StringTokenizer(s3,"-");
			while(st.hasMoreTokens())
			{
				 s=st.nextToken();
				if(s1.equals(s))
				{
					s=st.nextToken();
					s=st.nextToken();
					s=st.nextToken();
					if(s.equals("available"))
						count++;
					if(s.equals("availablenot"))
					{
						System.out.println("Book already given");
						out.write(s3);
						out.newLine();
						s3=in.readLine();
						if(s3==null)
							break outer;
						continue outer;
					}
				}	
			}	
			if(count!=0)
			{
				out.write(s3);
				out.write("not");
				out.newLine();
				out2.write(s3);
				Date d=new Date();
				out2.write("#"+d.getDate()+"."+(d.getMonth()+1)+"."+(d.getYear()+1900)+"#"+d.getDate()+"."+(d.getMonth()+4)+"."+(d.getYear()+1900));
				out2.newLine();
			}
			if(count==0)
			{
				out.write(s3);
				out.newLine();
			}
			s3=in.readLine();
			if(s3==null)
				break;
		}
		in.close();
		out.close();
		out2.close();
		File f1=new File("catalogue.txt");
		File f2=new File("temp.txt");
		boolean b1=f1.delete();
		File f=new File("catalogue.txt");
		boolean b2=f2.renameTo(f);
	}		
	static void takebook()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the book id being returned");
		String s1=br.readLine();
		System.out.println("Enter the id of the student/staff");
		String s2=br.readLine();
		BufferedReader in1=new BufferedReader(new FileReader("catalogue.txt"));
		BufferedReader in2=new BufferedReader(new FileReader(s2));
		BufferedWriter out1=new BufferedWriter(new FileWriter("temp1.txt",true));
		BufferedWriter out2=new BufferedWriter(new FileWriter("temp2.txt",true));
		String s3=in1.readLine();
		while(true)
		{
			int count=0;
			StringTokenizer st=new StringTokenizer(s3,"-");
			while(st.hasMoreTokens())
			{
				if(s1.equals(st.nextToken()))
					count++;
			}
			if(count==0)
			{
				out1.write(s3);
				out1.newLine();
			}
			s3=in1.readLine();
			if(s3==null)
				break;
		}
		String s4=in2.readLine();
		while(true)
		{
			int count=0;
			StringTokenizer st=new StringTokenizer(s4,"-");
			while(st.hasMoreTokens())
			{
				if(s1.equals(st.nextToken()))
					count++;
			}
			if(count==0)
			{
				out2.write(s4);
				out2.newLine();
			}
			if(count!=0)
			{
				StringTokenizer st2=new StringTokenizer(s4,"#");
				out1.write(st2.nextToken());
				out1.newLine();
			}
			s4=in2.readLine();
			if(s4==null)
				break;
		}
		in1.close();
		in2.close();
		out1.close();
		out2.close();
		File f1=new File("catalogue.txt");
		File f2=new File(s2);
		File f3=new File("temp1.txt");
		File f4=new File("temp2.txt");
		boolean b1=f1.delete();
		boolean b2=f2.delete();
		File f5=new File("catalogue.txt");
		boolean b3=f3.renameTo(f5);
		File f6=new File(s2);
		boolean b4=f4.renameTo(f6);
	}
	static void checkstatus()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter ur id");
		String s=br.readLine();
		try
		{
			BufferedReader in=new BufferedReader(new FileReader(s));
			String s2=in.readLine();
			System.out.println("\n");
			System.out.println("Book-id   -   Title   -   Author   -   available   -   TakenDate   -   DueDate");
			System.out.println("------------------------------------------------------------------------------");
			while(true)
			{
				StringTokenizer st=new StringTokenizer(s2,"#");
				System.out.println(st.nextToken()+"    "+st.nextToken()+"    "+st.nextToken());
				s2=in.readLine();
				if(s2==null)
					break;
			}
		}
		catch(Exception e)
		{
			System.out.println("user not exists");
		}
	}	
	static void checkavailability()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter book-id or title or author");
		String s1=br.readLine();
		BufferedReader in=new BufferedReader(new FileReader("catalogue.txt"));
		String s2=in.readLine();
		while(true)
		{
			int count=0;
			int count2=0;
			StringTokenizer st=new StringTokenizer(s2,"-");
			while(st.hasMoreTokens())
			{
				String s3=st.nextToken();
				if(s3.equals("availablenot"))
					count++;
				if(s3.equalsIgnoreCase(s1))
					count2++;		
			}
			if((count==0)&&(count2!=0))
				System.out.println(s2);
			s2=in.readLine();
			if(s2==null)
				break;
		}
	}	
	public static void main(String args[])throws IOException
	{	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;int ch;
		outer: while(true)
		{
		System.out.println("\n\n1.admin\n2.student\n3.staff\n4.new user(register)\n5.exit\nchoose ur category:");
		
		s=br.readLine();
		
		try{
		ch=Integer.parseInt(s);}	
		catch(Exception e){ continue;}
		switch(ch)
		{
			case 1:     	System.out.println("\nenter admin password");
				String s2=br.readLine();
				if(s2.equals("ashish"))
				{
					System.out.println("\n\n1.add  user\n2.remove user\n3.add book\n4.remove book\n5.give book\n6.take book\n7.check availability");
					int ch2;
					s=br.readLine();
					try{
					ch2=Integer.parseInt(s);}	
					catch(Exception e){ continue;}
					switch(ch2)
					{
						case 1:	adduser();break;
						case 2: 	removeuser();break;
						case 3:	addbook();break;
						case 4:	removebook();break;
						case 5:	givebook();break;
						case 6: 	takebook();break;
						case 7: 	checkavailability();break;
					}
				}
				else
					System.out.println("\nwrong password");
				break;
			case 2:
			case 3:	System.out.println("\n\n1.check satus\n2.checkavailability");
				s=br.readLine();
				int ch2;
				try{
				ch2=Integer.parseInt(s);}	
				catch(Exception e){ continue;}
				switch(ch2)
				{
					case 1:	checkstatus();break;
					case 2:	checkavailability();break;
				}
				break;
			case 4:         register();	
				break;
			case 5:         break outer;
			default:       break;
		}
		}		
	}
}