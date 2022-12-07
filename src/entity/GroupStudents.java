/*Таблица связи меджу Группой и Студентами*/
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author pupil
 */
@Entity
public class GroupStudents {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Student student;
    @OneToOne(mappedBy = "groupname")//Такое же поле, как в Entity Student
    private Groupname group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Groupname getGroup() {
        return group;
    }

    public void setGroup(Groupname group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "GroupStudents{" + "id=" + id 
                + ", student=" + student 
                + ", group=" + group + '}';
    }
    
    
}
