package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.dto.Employee;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    public static boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Employee(empID, firstName, lastName, street, city, lane, contact)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.crudUtil(
                sql,
                employee.getEmpId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getStreet(),
                employee.getCity(),
                employee.getLane(),
                employee.getContact()
        );
    }

    public static List<Employee> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee";
        List<Employee> allData = new ArrayList<>();

        ResultSet resultSet = CrudUtil.crudUtil(sql);

        while (resultSet.next()){
            allData.add(new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            ));
        }
        return allData;
    }

    public static boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Employee SET firstName =?, lastName =?, street =?, city =?, " +
                "lane =?, contact =? WHERE empID =?";
        return CrudUtil.crudUtil(
                sql,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getStreet(),
                employee.getCity(),
                employee.getLane(),
                employee.getContact(),
                employee.getEmpId()
        );
    }
}
