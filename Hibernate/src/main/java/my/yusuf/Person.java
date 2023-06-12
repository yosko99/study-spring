package my.yusuf;

import jakarta.persistence.*;
import my.yusuf.beans.Dog;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    private int pid;
    private Name name;
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Dog> dog = new ArrayList<>();

    public List<Dog> getDog() {
        return dog;
    }

    public void setDog(List<Dog> dog) {
        this.dog = dog;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", name=" + name +
                ", dog=" + dog +
                '}';
    }
}
