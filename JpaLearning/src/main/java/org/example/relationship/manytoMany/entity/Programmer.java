package org.example.relationship.manytoMany.entity;



import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int salary;

    /*

    create table programmers_projects(
                                     programmer_id int,
                                     project_id int,
                                     FOREIGN KEY (programmer_id)
                                         REFERENCES programmer(id),
                                     FOREIGN KEY (project_id)
                                         REFERENCES project(id)
)



     */

    @ManyToMany(cascade = CascadeType.ALL,
     fetch = FetchType.EAGER)
    @JoinTable( name="programmers_projects",
            joinColumns = @JoinColumn(name = "programmer_id" ,referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="project_id",referencedColumnName = "id")
    )
    private Set<Project> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }
}
