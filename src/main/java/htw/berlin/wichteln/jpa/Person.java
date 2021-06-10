package htw.berlin.wichteln.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
        private String name;
        private String mail;

        //Konstruktor für jpa und erstellung
        protected Person(){};
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
        public String toString() {
                return String.format(
                        "Person[id=%d, name='%s', mail='%s']",
                        id, name, mail);
        }
}
