package Student_management;

public class Student {
    private int sid;
    private String sname;
    private String sage;
    private String smail;

    public Student(int sid, String sname, String sage, String smail) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.smail = smail;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getSage() {
        return sage;
    }

    public String getSmail() {
        return smail;
    }

    @Override
    public String toString() {
        return "Student [ID: " + sid + ", Name: " + sname + ", Age: " + sage + ", Email: " + smail + "]";
    }
}
