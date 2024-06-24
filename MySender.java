import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MySender
{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(4321);
			byte b[]=new byte[10];//if we take 20 byte then null will come and reversing it we will get null first and we will get 
			//nothing as output bcz nothing will be printed after null in string so take small size to show output
			String msg="";
			DatagramPacket pack=null;
			Scanner scan=new Scanner(System.in);
			
			System.out.print("\n Enter String : ");
			msg=scan.nextLine();
			
			b=msg.getBytes();
			InetAddress ip=InetAddress.getByName("localhost");
			pack=new DatagramPacket(b,b.length,ip,1234);
			ds.send(pack);
			
			pack=new DatagramPacket(b,b.length);
			ds.receive(pack);
			b=pack.getData();
			msg=new String(b);
			System.out.println("\n Reverse : "+msg);
			
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Receiver error : "+e.getMessage());
		}
	}
}