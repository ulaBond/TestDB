
package testdb;

import entity.GroupStudents;
import entity.Groupname;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/*todo
* добавить Entity группы 
* сделать массив студентов 
* */
public class App {
    private List<Student> students;
    private List<Groupname> groupnames;
    private List<GroupStudents> listgroupStudents;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestDBPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    public App() {
        try {
            students = em.createQuery("SELECT s FROM Student s").getResultList();
            groupnames = em.createQuery("SELECT gn FROM Groupname gn").getResultList();
            listgroupStudents = em.createQuery("SELECT gs FROM GroupStudents gs").getResultList();
        } catch (Exception e) {
            System.out.println("Запись в БД отсутствует.");
            students = new ArrayList<>();
            groupnames = new ArrayList<>();
            listgroupStudents = new ArrayList<>();
        }
        
    }
    
    public void run (){
        tx.begin();
        
        if(students.isEmpty()){
            Student student = new Student();
            student.setFirstname("Ivan");
            student.setLastname("Ivanov");
            student.setDay(12);
            student.setMounth(2);
            student.setYear(2000);                
            em.persist(student);
            
            Groupname groupname = new Groupname();
            groupname.setGname("JKTV");
            groupname.setYear(2021);
            em.persist(groupname);
            
            GroupStudents groupStudents = new GroupStudents();
            groupStudents.setStudent(student);
            groupStudents.setGroup(groupname);
            em.persist(groupStudents);
            //-------------------------------------------
            student.setFirstname("Tatjana");
            student.setLastname("Subbotina");
            student.setDay(30);
            student.setMounth(12);
            student.setYear(2001);                
            em.persist(student);//запись в БД
            
            groupname = new Groupname();
            groupname.setGname("JPTV");
            groupname.setYear(2022);
            em.persist(groupname);
            
            groupStudents = new GroupStudents();
            groupStudents.setStudent(student);
            groupStudents.setGroup(groupname); 
            em.persist(groupname);
            
            }
       
        tx.commit();
            List<GroupStudents> groupStudents = em.createQuery("SELECT gs FROM GroupStudents gs ORDER BY gs.student DESC").getResultList();
            for (int i = 0; i < groupStudents.size(); i++) { 
                GroupStudents gs = groupStudents.get(i);
                gs.getGroup().setYear(2000);
                System.out.printf("Student: %s %s, group: %s-%d%n"
                        ,gs.getStudent().getFirstname()
                        ,gs.getStudent().getLastname()
                        ,gs.getGroup().getGname()
                        ,gs.getGroup().getYear()
                        );
            }
        }   
    }
