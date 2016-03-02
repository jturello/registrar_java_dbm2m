import java.util.*;
import org.sql2o.*;
import java.time.LocalDate;
import java.sql.Date;

public class Student {

  private int id;
  private String name;
  private LocalDate enrollment_date;


  public Student(String name, int year, int month, int day) {
    this.name = name;
    this.enrollment_date = LocalDate.of(year, month, day);
  }
//
//   public int getId() {
//     return id;
//   }

  public String getName() {
    return name;
  }

  public String getEnrollmentDate() {
    return enrollment_date.toString();
  }

  public static List<LocalDate> all() {
    String sql = "SELECT enrollment_date FROM Students";
    try(Connection con = DB.sql2o.open()) {

      List<Date> sqlDates = con.createQuery(sql).executeAndFetch(java.sql.Date.class);
      ArrayList<LocalDate> locdate = new ArrayList();
      for (Date date : sqlDates) {
        locdate.add(date.toLocalDate());
      }
      return locdate;
      // List<Student> tmp = con.createQuery(sql).executeAndFetch(Student.class);
      // for (Student student : tmp) {
      //   student.enrollment_date = student.enrollment_date.toLocalDate();
      // }
      // return tmp;
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    // Date enroll_date = Date.valueOf(enrollment_date);
    String sql = "INSERT INTO Students (name, enrollment_date) VALUES (:name, :enrollment_date)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("enrollment_date", Date.valueOf(enrollment_date))
      .executeUpdate()
      .getKey();
  }
}



} // END STUDENT CLASS

//   @Override
//   public boolean equals(Object otherCategory){
//     if (!(otherCategory instanceof Category)) {
//       return false;
//     } else {
//       Category newCategory = (Category) otherCategory;
//       return this.getName().equals(newCategory.getName());
//     }
//   }
//

//
// public static Category find(int id) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM Categories where id=:id";
//       Category Category = con.createQuery(sql)
//         .addParameter("id", id)
//         .executeAndFetchFirst(Category.class);
//       return Category;
//     }
//   }
//
//   public List<Task> getTasks() {
//   try(Connection con = DB.sql2o.open()) {
//     String sql = "SELECT * FROM tasks where categoryId=:id";
//     return con.createQuery(sql)
//       .addParameter("id", id)
//       .executeAndFetch(Task.class);
//     }
//   }
