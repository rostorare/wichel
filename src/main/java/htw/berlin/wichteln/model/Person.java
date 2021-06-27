package htw.berlin.wichteln.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
        private String name;
        private String mail;



        //Konstruktor für jpa und erstellung
        public Person(){};
        public Person(String name,String mail){
                this.name = name;
                this.mail = mail;

        }


        //getter


        public Long getId() {return id;}
        public String getName() {return name;}
        public String getMail() {return mail;}
        //setter
        public void setName(String name) {this.name = name;}
        public void setMail(String mail) {this.mail = mail;}


        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                return id.equals(person.id) && name.equals(person.name) && mail.equals(person.mail);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, mail);
        }

        @Override
        public String toString() {
                return "Person{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", mail=" + mail +
                        '}';
        }





        // mach tnicht viel sinn da autogenerated

}
