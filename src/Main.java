import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/Student";
    private static final String username = "root";
    private static final String password = "Tarun@1508";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("###########################################");
            System.out.println("1 : Add Student");
            System.out.println("2 : Delete Student");
            System.out.println("3 : Update Student");
            System.out.println("4 : Enter Multiple Students");
            System.out.println("5 : Show all Students");
            System.out.println("6 : Exit Program");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            System.out.println("###########################################");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    addMultipleStudents();
                    break;
                case 5:
                    showStudents();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addStudent() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();

        String sql = "INSERT INTO students (name, age ,marks) VALUES (?, ? , ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setDouble(3, marks);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new student was inserted successfully!");
        }

        statement.close();
        connection.close();
        scanner.close();
    }

    private static void deleteStudent() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM students WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Student was deleted successfully!");
        } else {
            System.out.println("Student was not deleted successfully! or Student might not exist!");
        }

        statement.close();
        connection.close();
        scanner.close();
    }

    private static void updateStudent() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter new student marks: ");
        double marks = scanner.nextDouble();

        String sql = "UPDATE students SET name = ?, age = ?, marks = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setDouble(3, marks);
        statement.setInt(4, id);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Student was updated successfully!");
        }

        statement.close();
        connection.close();
        scanner.close();
    }

    private static void addMultipleStudents() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students to add: ");
        int count = scanner.nextInt();

        String sql = "INSERT INTO students (name, age , marks) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < count; i++) {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student age: ");
            int age = scanner.nextInt();
            System.out.print("Enter student marks: ");
            double marks = scanner.nextDouble();

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setDouble(3, marks);
            statement.addBatch();
        }

        int[] rowsInserted = statement.executeBatch();
        System.out.println(rowsInserted.length + " students were inserted successfully!");

        statement.close();
        connection.close();
        scanner.close();
    }

    private static void showStudents() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "SELECT * FROM students";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("ID\tName\tAge\tMarks");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            double marks = resultSet.getDouble("marks");
            System.out.println(id + "\t" + name + "\t" + age + "\t" + marks);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}