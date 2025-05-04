public class Employee {

    private static int idGenerator = 1;

    private final int id;
    private  final String follName;
    private  int department;
    private  int salary;

    public  Employee(String follName, int department, int salary){
        id = idGenerator++;
        this.follName = follName;
        this.department = department;
        this.salary = salary;

    }


    public int getId() {
        return id;
    }

    public String getFollName() {
        return follName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", follName = " + follName +
                ", department = " + department +
                ", salary = " + salary ;
    }
}
