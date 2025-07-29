package Student_management;

public class Query {
    public static final String insert = "INSERT INTO students (sid, sname, sage, smail) VALUES (?, ?, ?, ?);";
    public static final String update = "UPDATE students SET sname = ? WHERE sid = ?;";
    public static final String delete = "DELETE FROM students WHERE sid = ?;";
    public static final String select = "SELECT * FROM students;";
}
