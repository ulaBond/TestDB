
package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//генерирует уникальный ID-код
    private Long  id;
    private String firstname;
    private String lastname;
    private int day;
    private int mounth;
    private int year;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Groupname groupName;//для связи с таблицей Группа

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMounth() {
        return mounth;
    }

    public void setMounth(int mounth) {
        this.mounth = mounth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public Groupname getGroupName() {
            return groupName;
        }

        public void setGroupName(Groupname groupName) {
            this.groupName = groupName;
        }
    @Override
    public String toString() {
        return "Student{" + "id=" + id 
                + ", firstname=" + firstname 
                + ", lastname=" + lastname 
                + ", day=" + day 
                + ", mounth=" + mounth 
                + ", year=" + year 
                + ", groupName=" + groupName + '}';
    }

    

     
    
}
