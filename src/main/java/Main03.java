import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main03 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        String department = "Research and Development";
        em.createQuery("SELECT e FROM Employee e" +
                        " where  e.department.name = :departmentName" +
                                " order by e.salary, e.id",
                Employee.class)
                .setParameter("departmentName", department)
                .getResultStream()
                        .forEach(employee -> {
                            String format = String.format("%s %s from %s - $%.2f",
                                    employee.getFirstName(),
                                    employee.getLastName(),
                                    department,
                                    employee.getSalary());
                            System.out.println(format);
                        });



        em.getTransaction().commit();
        em.close();
    }
}
