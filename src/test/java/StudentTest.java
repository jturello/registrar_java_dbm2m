import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class StudentTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void student_instantiatedWithName_true() {
    Student myStudent = new Student("Susie Student", 2016, 1, 1);
    assertEquals("Susie Student", myStudent.getName());
  }

  @Test
  public void student_instantiatedWithEnrollmentDate_true() {
    Student myStudent = new Student("Sally Student", 2016, 1, 1);
    assertEquals("2016-01-01", myStudent.getEnrollmentDate());
  }

      @Test
      public void save_savesIntoDatabase_true() {
      Student myStudent = new Student("Sam Student", 2016, 1, 1);
      myStudent.save();
      assertTrue(Student.all().get(0).equals(myStudent));
    }

//   @Test
//   public void all_emptyAtFirst() {
//     assertEquals(Student.all().size(), 0);
//   }
//
//   @Test
//   public void equals_returnsTrueIfNamesAretheSame() {
//     Category firstCategory = new Category("Household chores");
//     Category secondCategory = new Category("Household chores");
//     assertTrue(firstCategory.equals(secondCategory));
//   }

//
// @Test
//  public void find_findCategoryInDatabase_true() {
//    Category myCategory = new Category("Household chores");
//    myCategory.save();
//    Category savedCategory = Category.find(myCategory.getId());
//    assertTrue(myCategory.equals(savedCategory));
//  }
//
//  @Test
//   public void getTasks_retrievesALlTasksFromDatabase_tasksList() {
//     Category myCategory = new Category("Household chores");
//     myCategory.save();
//     Task firstTask = new Task("Mow the lawn", myCategory.getId());
//     firstTask.save();
//     Task secondTask = new Task("Do the dishes", myCategory.getId());
//     secondTask.save();
//     Task[] tasks = new Task[] { firstTask, secondTask };
//     assertTrue(myCategory.getTasks().containsAll(Arrays.asList(tasks)));
//   }

}
