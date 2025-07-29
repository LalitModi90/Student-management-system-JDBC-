package Student_management;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {

    public static void createStudent(Student student) throws SQLException {
        Connection con = DB.connect();
        String query = Query.insert;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, student.getSid());
        ps.setString(2, student.getSname());
        ps.setString(3, student.getSage());
        ps.setString(4, student.getSmail());

        System.out.println("\nExecuting: " + ps + "\n" + student);
        ps.executeUpdate();
        ps.close();
    }

    public static void updateStudent(int sid, String sname) throws SQLException {
        Connection con = DB.connect();
        String query = Query.update;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, sname);
        ps.setInt(2, sid);

        System.out.println("\nExecuting: " + ps);
        ps.executeUpdate();
        ps.close();
    }

    public static void deleteStudent(int sid) throws SQLException {
        Connection con = DB.connect();
        String query = Query.delete;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, sid);

        System.out.println("\nExecuting: " + ps);
        ps.executeUpdate();
        ps.close();
    }

    public static ArrayList<Student> readStudents() throws SQLException {
        ArrayList<Student> studentList = new ArrayList<>();
        Connection con = DB.connect();
        String query = Query.select;

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Student st = new Student(
                rs.getInt("sid"),
                rs.getString("sname"),
                rs.getString("sage"),
                rs.getString("smail")
            );
            studentList.add(st);
        }

        rs.close();
        stmt.close();
        return studentList;
    }
}
