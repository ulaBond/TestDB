
package testdb;

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
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestDBPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    public App() {
        try {
            students = em.createQuery("SELECT s FROM Student s")
                .getResultList();
        } catch (Exception e) {
            System.out.println("Запись в БД отсутствует.");
            students = new ArrayList<>();
            groupnames = new ArrayList<>();
        }
        
    }
    
    public void run (){
        tx.begin();
        if(students.isEmpty()){
        
        }
        for (int i = 0; i < students.size(); i++) { 
            Student student = students.get(i);
            if(student.getId() == null){ 
               // em.persist(groupName);
                //groupName.setGname("JKTV21");
                //groupName.setYear(2021);
                student.setFirstname("Ivan");
                student.setLastname("Ivanov");
                student.setDay(12);
                student.setMounth(2);
                student.setYear(2000);
                student.setGroupName(new Groupname());//для создания новой группы
                student.getGroupName().setGname("JKTV21");
                student.getGroupName().setYear(2021);
                em.persist(student);
                Groupname groupname = student.getGroupName();
                student = new Student();
                
                student.setFirstname("Tatjana");
                student.setLastname("Subbotina");
                student.setDay(12);
                student.setMounth(2);
                student.setYear(2000);
                student.setGroupName(groupname);
                student.getGroupName().setGname("JPTV22");
                student.getGroupName().setYear(2022);
                em.persist(student);//запись в БД
            }else{
                student.setFirstname("Boris");
                student.setLastname("Semenov");
                student.setDay(12);
                student.setMounth(2);
                student.setYear(2000);
                student.getGroupName().setGname("JpTV22");
                student.getGroupName().setYear(2022);
                em.merge(student);
            }
        }
        tx.commit();
    }
}
