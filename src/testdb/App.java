
package testdb;

import entity.Groupname;
import entity.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
    private List<Student> students;
    private List<Groupname> groupnames;
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestDBPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    public App() {
        try {
            students = em.createQuery("SELECT s FROM Student s").getResultList();
            groupnames = em.createQuery("SELECT gn FROM Groupname gn").getResultList();
            
        } catch (Exception e) {
            System.out.println("Запись в БД отсутствует.");
            students = new ArrayList<>();
            groupnames = new ArrayList<>();
        }
        
    }
    
    public void run (){
        tx.begin();
        
        if(students.isEmpty()){
            Groupname groupname = new Groupname();
            groupname.setGname("JKTV");
            groupname.setYear(2021);
            em.persist(groupname);
            
            Student student = new Student();
            student.setFirstname("Ivan");
            student.setLastname("Ivanov");
            student.setDay(12);
            student.setMounth(2);
            student.setYear(2000);  
            student.setGroup(groupname);
            em.persist(student);
            
            groupname.getStudents().add(student);//добавляем студента в группу и обновляем БД
            em.merge(groupname);
            
            student = new Student();
            student.setFirstname("Aldo");
            student.setLastname("Tamme");
            student.setDay(10);
            student.setMounth(5);
            student.setYear(2001);  
            student.setGroup(groupname);
            em.persist(student);
            
            groupname.getStudents().add(student);//добавляем студента в группу и обновляем БД
            em.merge(groupname);
            //------------------- 2 group ------------------------
            groupname = new Groupname();
            groupname.setGname("JPTV");
            groupname.setYear(2022);
            em.persist(groupname);
            
            student = new Student();
            student.setFirstname("Boris");
            student.setLastname("Semenov");
            student.setDay(01);
            student.setMounth(4);
            student.setYear(2002);  
            student.setGroup(groupname);
            em.persist(student);
            
            groupname.getStudents().add(student);//добавляем студента в группу и обновляем БД
            em.merge(groupname);
            }
       
        tx.commit();   
            System.out.println("----------------------Students:--------------------- ");        
            for (int i = 0; i < students.size(); i++) { 
                Student student = students.get(i);
                System.out.printf("Student: %s %s, group: %s-%d%n"
                        ,student.getFirstname()
                        ,student.getLastname()
                        ,student.getGroup()
                        ,student.getYear()
                        );
            }
            System.out.println("-------Groups:------ ");  
            for (int i = 0; i < groupnames.size(); i++) { 
                Groupname group = groupnames.get(i);
                System.out.printf("Group: %s-%d%n"
                        ,group.getGname()
                        ,group.getYear()
                        ,Arrays.toString(group.getStudents().toArray())
                        );
            }
        }   
    }
