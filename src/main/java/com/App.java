package com;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import com.perscholas.model.Department;
import com.perscholas.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();
        Teacher t1 = new Teacher();
        t1.setTeacherName("Haseeb");
        t1.setSalary("100");

        Teacher t2 = new Teacher();
        t2.setTeacherName("Jenny Finch");
        t2.setSalary("10000");

        Teacher t3 = new Teacher();
        t3.setTeacherName("James");
        t3.setSalary("25000");

        Teacher t4 = new Teacher();
        t4.setTeacherName("SID ROSE");
        t4.setSalary("3000");

        Teacher t5 = new Teacher();
        t5.setSalary("200");
        t5.setTeacherName("Ali");
        List<Teacher> teachlist=new ArrayList<>();
        teachlist.add(t1);
        teachlist.add(t2);
        teachlist.add(t3);
        teachlist.add(t4);
        teachlist.add(t5);

        List<Teacher> teachers=new ArrayList<>();
        teachers.add(t2);
        teachers.add(t4);

        session.save(t1);
        session.save(t2);
        session.save(t3);
        session.save(t4);

//createDepartment
        Department department = new Department();
        department.setDname("Development");
        department.setTeacherlist(teachlist);
        department.setDname("Testing");
        department.setTeacherlist(teachers);
        session.save(department);
        t.commit();


    }
    }
