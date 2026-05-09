package simple_student_register_jdbc;

import java.sql.*;

public class methods{
    public void display(Connection connect){
        try{
        String query="select * from student_register";
        PreparedStatement ps=connect.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("reg_no")+" "+rs.getString("name")+" "+rs.getString("remark"));
        }
    }catch(Exception e){System.out.println("(catch)error in display"+e);}
    }

    public void new_entry(Connection connect,int reg,String name,String remark){
        try{
            String check="select * from student_register where reg_no=?";
            PreparedStatement che=connect.prepareStatement(check);
           che.setInt(1,reg);
           ResultSet rs=che.executeQuery();

           if(rs.next()){
           System.out.println("there is a student has that id, recheck your id number please");return;}
           
         String query="insert into student_register(reg_no,name,remark)values(?,?,?)";
         PreparedStatement ps=connect.prepareStatement(query);
         ps.setInt(1, reg);
         ps.setString(2, name);
         ps.setString(3, remark);
         ps.executeUpdate();
         System.out.println("inserted...");
        }catch(Exception e){System.out.println("(catch)error in new_entry"+e);}
    }

    public void updatename(Connection connect,int id,String rename){
        try{
            String check="select * from student_register where reg_no=?";
            PreparedStatement che=connect.prepareStatement(check);
           che.setInt(1,id);
           ResultSet rs=che.executeQuery();

           if(!(rs.next())){
           System.out.println("there is a student has that id, recheck your id number please");return;}

            String query="update student_register set name=? where reg_no=?";
            PreparedStatement ps=connect.prepareStatement(query);
            ps.setString(1, rename);
            ps.setInt(2, id);
            ps.executeUpdate();System.out.println("updated successfully");
        }catch(Exception e){
            System.out.println("(catch)error in update name: "+e);
        }
    }

    public void updateremark(Connection connect,int id,String remark){
        try{
            String check="select * from student_register where reg_no=?";
            PreparedStatement che=connect.prepareStatement(check);
           che.setInt(1,id);
           ResultSet rs=che.executeQuery();

           if(!(rs.next())){
           System.out.println("there is a student has that id, recheck your id number please");return;}

            String query="update student_register set remark=? where reg_no=?";
            PreparedStatement ps=connect.prepareStatement(query);
            ps.setString(1, remark);
            ps.setInt(2, id);
            ps.executeUpdate();System.out.println("updated successfully");
        }catch(Exception e){
            System.out.println("(catch)error in update remark: "+e);
        }
    }

    public void searchstudent(Connection connect,int reg){
        try{
        String query="select * from student_register where reg_no=?";
        PreparedStatement ps=connect.prepareStatement(query);
        ps.setInt(1, reg);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            System.out.println("register num"+rs.getInt("reg_no")+"\nname"+rs.getString("name")+"\nremark"+rs.getString("remark"));
        }else{
            System.out.println("there is no students with that id");
        }
        }catch(Exception e){
            System.out.println("(catch)error in search student"+ e);
        }
    }
    
    public void delstudent(Connection connect,int id){
        try{
            String check="select * from student_register where reg_no=?";
            PreparedStatement che=connect.prepareStatement(check);
           che.setInt(1,id);
           ResultSet rs=che.executeQuery();

           if(!(rs.next())){
           System.out.println("no student has that id, recheck your id number please");return;}

            String query="delete from student_register where reg_no=?";
            PreparedStatement ps=connect.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();System.out.println("deleted successfully");
        }catch(Exception e){
            System.out.println("(catch)error in delete student: "+e);
        }
    }
}
