package org.example.relationship.oneToOne.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    @Temporal(TemporalType.DATE)
    private Date validFrom;
    @Temporal(TemporalType.DATE)
    private  Date validTo;


    /**
     *
     * create table license(
     *                         id int PRIMARY KEY AUTO_INCREMENT,
     *                         type varchar(20),
     *                         valid_from date,
     *                         valid_to date,
     *                         person_id int,
     *                         FOREIGN KEY (person_id)
     *                         REFERENCES person(id)
     * )
     */
   /* @JoinColumn(name = "person_id") → Means the license table will have a
   person_id column as a foreign key.
   */
    @OneToOne (cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name ="person_id")
    private Person person;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "License{" +
                "type='" + type + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", person=" + person +
                '}';
    }
}
