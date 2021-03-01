package ol.kankan.kankan.jpa.entiry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-28 22:22 by kankan
 * @updated 2021-02-28 22:22 by kankan
 */
@Entity
@Setter
@Getter
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "departments")
    @JoinTable(name = "person_department",
            joinColumns = {@JoinColumn(
                    name = "department_id",
                    referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(
                    name = "person_id",
                    referencedColumnName = "id")})
    private Set<Person> persons;

    public Department() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, persons);
    }

    @Override
    public String toString() {
        for(Person p:this.persons){
            p.getDepartments().clear();
        }
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", persons=" + persons +
                '}';
    }
}
