package ra.modal;

import ra.config.InputMethod;

import java.util.ArrayList;

public class Student extends User {
    private Subject subject;
    private Classes myClass;
    private boolean status = false;

    public Student() {
    }

    public Student(Subject subject, Classes myClass, boolean status) {
        this.subject = subject;
        this.myClass = myClass;
        this.status = status;
    }

    public Student(int id, String username, String password, String fullName, String phoneNumber, String dob, Subject subject, Classes myClass, boolean status) {
        super(id, username, password, fullName, phoneNumber, dob);
        this.subject = subject;
        this.myClass = myClass;
        this.status = status;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Classes getMyClass() {
        return myClass;
    }

    public void setMyClass(Classes myClass) {
        this.myClass = myClass;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(ArrayList<Classes> classes, ArrayList<Subject> subjects) {
        super.inputData();
        // nhập môn học
        for (Subject s : subjects) {
            System.out.println(s);
        }
        while (true) {
            System.out.print("Nhập vào ID môn học bạn muốn chọn: ");
            int id = InputMethod.getInteger();
            boolean flag = false;
            for (Subject s : subjects) {
                if (s.getId() == id) {
                    this.subject = s;
                    flag = true;
                }
            }
            if (flag) {
                break;
            } else {
                System.err.print("\nKhông có môn học đó, Vui lòng nhập lại: ");
            }
        }
        // nhập lớp muốn chọn
        for (Classes c : classes) {
            System.out.println("ID: " + c.getId() + " | Class: " + c.getClassName());
        }
        while (true) {
            System.out.print("Nhập vào ID lớp bạn muốn chọn: ");
            int id = InputMethod.getInteger();
            Classes flag = null;
            for (Classes c : classes) {
                if (c.getId() == id) {
                    flag = c;
                }
            }
            if (flag == null) {
                System.err.print("\nKhông có lớp đó, Vui lòng nhập lại: ");
            } else {
                if (flag.getSubject().getId() == this.getSubject().getId()) {
                    this.myClass = flag;
                    break;
                } else {
                    System.err.println("Chọn lớp không đúng, vui lòng chọn lại");
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSubject: " + subject.getSubjectName() + " | Class: " + myClass.getClassName();
    }
}
