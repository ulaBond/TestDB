
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* */
@Entity 
public class Groupname {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gname;
    private int Year;

    public Groupname() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    @Override
    public String toString() {
        return "Groupname{" + "id=" + id 
                + ", gname=" + gname 
                + ", Year=" + Year + '}';
    }
    
}
