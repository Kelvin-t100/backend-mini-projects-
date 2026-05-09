package simple_student_register_jdbc;
import java.util.*;
import java.sql.*;
public class Main{
    public static void main(String []areg){
        Scanner x=new Scanner(System.in);
        boolean state=true;
        methods M=new methods();
        try{
       Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/M_P_STUDENT_DETAILS","root","root");
         while(state){
            System.out.print("what you wanna do?\n1.view the database\n2.entry for new student\n");
            System.out.print("3.update the database\n4.search a student\n5.delete an entry\n6.exit");
            int choice=x.nextInt();
            switch (choice) {
                case 1:
                   M.display(connect);
                    break;
                case 2:
                    System.out.println("enter id");int id=x.nextInt();x.nextLine();
                    System.out.println("enter name");String name=x.nextLine();
                    System.out.println("enter remark");String remark=x.nextLine();
                   M.new_entry(connect,id,name,remark) ;
                    break;
                case 3:
                    System.out.println("what you want to update??\n1.name\n2.remark");
                    int minichoice=x.nextInt();
                    switch (minichoice) {
                        case 1:
                            System.out.println("enter the id and the proper name");
                            int ser_id=x.nextInt();x.nextLine();String re_name=x.nextLine();
                            M.updatename(connect,ser_id,re_name);
                            break;
                        case 2:
                            System.out.println("enter the id and the remark");
                            int serc_id=x.nextInt();x.nextLine();String re_remark=x.nextLine();
                            M.updateremark(connect,serc_id,re_remark);
                            break;
                    
                        default:
                            System.out.println("really are you a teacher??");
                            break;
                    }
                
                    break;
                case 4:
                    System.out.println("enter the id alone");int search=x.nextInt();
                    M.searchstudent(connect,search);                    
                    break;
                case 5:
                System.out.println("enter the id and forget him ");int del=x.nextInt();
                M.delstudent(connect,del);
                    break;
                case 6:
                    state=false;System.out.println("adios :3");
                    break;
               
                default:
                    System.out.println("you know numbers, right??");
                    break;
            }
        }
        }catch(Exception e){
        // System.out.println("holy moly ERROR: "+ e)
        e.printStackTrace();
    }
    x.close();
    }
}
