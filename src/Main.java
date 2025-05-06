import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Леонид", "Василий", "Петр", "Мирон", "Анатолий", "Семен", "Евгений"};
    private final static String[] SURNAMES = {"Леонидов", "Васильев", "Петров", "Миронов", "Игнатов", "Семенов", "Попов"};
    private final static String[] PATRONYMIC_NAMES = {"Леонидович", "Васильевич", "Петрович", "Миронович", "Анатольевич", "Семенович", "Евгеньевич"};

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMIC_NAMES[RANDOM.nextInt(0, NAMES.length)] + " ";
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50_000, 100_000));


        }
    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма зп сотрудников: " + calculeteSumOfSalarries());
        System.out.println("Cотрудник с мин зп: " + findEmployeeWithMinSalaru());
        System.out.println("Сотрудник с макс зп: " + findEmployeeWithMaxSalaru());
        System.out.println("Средняя зп " + calculateAverageOfSalaries());
        printFullName();

    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculeteSumOfSalarries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && sum == 0) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }


    private static Employee findEmployeeWithMinSalaru() {
        Employee employeeWinMinSalaru = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWinMinSalaru == null || employee.getSalary() < employeeWinMinSalaru.getSalary()) {
                employeeWinMinSalaru = employee;
            }
        }
        return employeeWinMinSalaru;
    }

    private static Employee findEmployeeWithMaxSalaru() {
        Employee employeeWinMaxSalaru = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWinMaxSalaru == null || employee.getSalary() > employeeWinMaxSalaru.getSalary()) {
                employeeWinMaxSalaru = employee;
            }
        }
        return employeeWinMaxSalaru;
    }

    private static double calculateAverageOfSalaries() {
        double totalSalary = 0;
        int count = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                totalSalary += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : totalSalary / count;
    }


    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getFollName() != null) {
                System.out.println(employee.getFollName());
            } else {
                System.out.println("Информация о сотрудники отсутствует");
            }
        }
    }
}