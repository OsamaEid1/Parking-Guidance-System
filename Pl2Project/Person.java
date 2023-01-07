package Pl2Project;

public class Person {
    public String name;
    public String password;
    public String jobTitle;
    
   public Person(){
   }
            
   public Person(String name,String password,String jobTitle){
      this.name=name;
      this.password=password;
      this.jobTitle=jobTitle;
   }
   
   public String getPersonData() {
        return this.name+ "@" + this.password + "@" + this.jobTitle;
    }
    
}
