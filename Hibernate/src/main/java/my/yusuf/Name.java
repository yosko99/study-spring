package my.yusuf;

import jakarta.persistence.Embeddable;

@Embeddable // Don't create table import to another one
public class Name {
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    private String fName;
    private String sName;
    private String lName;

    @Override
    public String toString() {
        return "Name{" +
                "fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
