package springboot_rest_v2.sprigbootrest.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springboot_rest_v2.sprigbootrest.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);  /*Получаем сессию*/
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        allEmployees = query.getResultList();
        Query query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        //        Session session = entityManager.unwrap(Session.class);
//        Employee emp = session.get(Employee.class, id);
        Employee emp = entityManager.find(Employee.class, id);
        return emp;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("delete Employee where id = :empId");
        Query query = entityManager.createQuery("delete Employee where id = :empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
