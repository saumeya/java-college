package data;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Admin ad = new Admin();
		int choice,r,flag;
		Scanner sc = new Scanner(System.in);
		int ans;
		do{
			System.out.println("\nMain Menu\n1.Admin\n2.Student");
			choice = sc.nextInt();
			switch(choice){
			case 1:
				do{
					System.out.println("\nAdmin Menu\n1.Add Record\n2.View Records\n3.Remove Record\n4.Search Record\n5.View Topper\n6.View Failed");
					choice = sc.nextInt();
					switch(choice){
					case 1:
						ad.addrecord();
						break;
					case 2:
						ad.displayall();
						break;
					case 3:
						System.out.println("\nEnter Roll No. to delete : ");
						r=sc.nextInt();
						flag=ad.delete(r);
						if(flag==0)
							System.out.println("Record not found!");
						break;
					case 4:
						System.out.println("\nEnter Roll No. to search : ");
						r=sc.nextInt();
						flag=ad.search(r);
						if(flag==0)
							System.out.println("\nRecord not found!");
						break;
					case 5:
						ad.topper();
						break;
					case 6:
						ad.fail();
						break;
						
					}
					System.out.println("\nPress 1 to continue in Admin Menu");
					ans = sc.nextInt();
				}while(ans==1);
				break;
			case 2:
				do{
					System.out.println("\nStudent Menu\n1.View Your Result\n2.View Topper");
					choice = sc.nextInt();
					switch(choice){
					case 1:
						System.out.println("\nEnter Roll No. to search : ");
						r=sc.nextInt();
						flag=ad.search(r);
						if(flag==0)
							System.out.println("\nRecord not found!");
												break;
					case 2:
						ad.topper();
						break;
						
					}
					System.out.println("\nPress 1 to continue in Student Menu");
					ans = sc.nextInt();
				}while(ans==1);
				break;
				
			}
			System.out.println("\nPress 1 to continue in Main Menu");
			ans = sc.nextInt();
		}while(ans==1);
		sc.close();
	}
}