package App.Domain.Pos;

public class Employee {
    private String ssn;

    private String name;

    private String age;

    private int wage;


    public String getName(){ return this.name; }

    public void setName(String name){
        this.name = name;
    }

    public String getSsn(){ return this.ssn; }

    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    public String getAge(){ return this.age; }

    public void setAge(String age){ this.age = age; }

    public int getWage(){ return this.wage; }

    public void setWage(String wage){ this.wage = Integer.parseInt(wage); }

}
