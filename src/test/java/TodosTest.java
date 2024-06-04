import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.todos.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(7, "Почесать ухо");

        Todos todos = new Todos();

        todos.add(simpleTask);
        String query = "Почесать ухо";

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks );

        Todos todos = new Todos();

        todos.add(epic);
        String query = "Молоко";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

     @Test
    public void shouldFindMeeting() {
         Meeting meeting = new Meeting(
                 555,
                 "Выкатка 3й версии приложения",
                 "Приложение НетоБанка",
                 "Во вторник после обеда"
         );
         Todos todos = new Todos();

         todos.add(meeting);
         String query = "Приложение НетоБанка";

         Task[] expected = {meeting};
         Task[] actual = todos.search(query);
         Assertions.assertArrayEquals(expected, actual);

     }

    @Test
    public void shouldFindThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        String query = "Приложение НетоБанка";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
}
