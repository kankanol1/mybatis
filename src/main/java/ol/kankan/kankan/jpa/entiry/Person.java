package ol.kankan.kankan.jpa.entiry;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author kankan
 * @version 1.0
 * @created 2021-02-28 19:43 by kankan
 * @updated 2021-02-28 19:43 by kankan
 */
@Entity
@Setter
@Getter
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    @JsonIgnoreProperties(value = "persons")
    @JoinTable(name = "person_department",
            joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id", referencedColumnName = "id")})
    @ApiModelProperty(value = "人员部门")
    /*
    * joinColumns是主操作表的中间表列，
    * inverseJoinColumns是副操作表的中间表列
    *
    * name  是默认将外实体的主键作为外键
    *
    * */
    private Set<Department> departments;// = new LinkedHashSet<>();

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        for(Department d:this.departments){
            d.getPersons().clear();
        }
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }
}
