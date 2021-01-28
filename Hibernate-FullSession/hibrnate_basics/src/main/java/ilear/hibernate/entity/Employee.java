package ilear.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="EmployeeTable")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id" )
    private int EmployeeId;
    @Column(name = "First_Name", length = 25)
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
//    @ElementCollection
//    private List<String > skillSet = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ILearnID")s

    @OneToMany(mappedBy = "employeeId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "EmployeeSessions")
    private Collection<ILearnSessions> iLearn= new HashSet<>();




    public Employee( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
