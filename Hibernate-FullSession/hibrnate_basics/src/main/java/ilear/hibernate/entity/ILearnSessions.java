package ilear.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Getter
@Setter
public class ILearnSessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SessionId;

    @Column
    private String SessionName;

    @ManyToMany(mappedBy = "iLearn")
    private Collection<Employee> employees= new HashSet<>();

}
