import java.time.LocalDate;
import java.util.Scanner;
import model.Task;
import service.TaskManager;

public class main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- To-Do List App ---");
            System.out.println("1. View Tasks\n2. Add Task\n3. Mark Completed\n4. Delete Task\n5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    var tasks = manager.getTasks();
                    if (tasks.isEmpty()) System.out.println("No tasks available!");
                    else tasks.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Description: "); String desc = sc.nextLine();
                    System.out.print("Due Date (YYYY-MM-DD): "); LocalDate date = LocalDate.parse(sc.nextLine());
                    manager.addTask(new Task(title, desc, date));
                    System.out.println("Task added!");
                    break;

                case 3:
                    System.out.print("Task number to mark completed: ");
                    int compIndex = sc.nextInt() - 1;
                    manager.markCompleted(compIndex);
                    System.out.println("Task marked completed!");
                    break;

                case 4:
                    System.out.print("Task number to delete: ");
                    int delIndex = sc.nextInt() - 1;
                    manager.deleteTask(delIndex);
                    System.out.println("Task deleted!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
