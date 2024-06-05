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

    @Test
    public void shouldSeveralFindSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(7, "Почесать ухо");
        SimpleTask simpleTask2 = new SimpleTask(8, "Почесать нос");
        SimpleTask simpleTask3 = new SimpleTask(9, "Почесать колено");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        String query = "Почесать";

        Task[] expected = {simpleTask1, simpleTask2, simpleTask3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSeveralFindOneSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(7, "Почесать ухо");
        SimpleTask simpleTask2 = new SimpleTask(8, "Почесать нос");
        SimpleTask simpleTask3 = new SimpleTask(9, "Почесать колено");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        String query = "колено";

        Task[] expected = {simpleTask3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSeveralNoFindSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(7, "Почесать ухо");
        SimpleTask simpleTask2 = new SimpleTask(8, "Почесать нос");
        SimpleTask simpleTask3 = new SimpleTask(9, "Почесать колено");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        String query = "Забить гвоздь";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSeveralFindOneEpic() {
        String[] subtasks1 = { "Молоко", "Яйца", "Хлеб" };
        String[] subtasks2 = { "Самогон", "Пиво", "Водка" };
        String[] subtasks3 = { "Молоко", "Кефир", "Селедка" };

        Epic epic1 = new Epic(55,subtasks1);
        Epic epic2 = new Epic(56,subtasks2);
        Epic epic3 = new Epic(57,subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        String query = "Самогон";

        Task[] expected = {epic2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSeveralFindEpic() {
        String[] subtasks1 = { "Молоко", "Яйца", "Хлеб" };
        String[] subtasks2 = { "Молоко", "Пиво", "Водка" };
        String[] subtasks3 = { "Молоко", "Кефир", "Селедка" };

        Epic epic1 = new Epic(55,subtasks1);
        Epic epic2 = new Epic(56,subtasks2);
        Epic epic3 = new Epic(57,subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        String query = "Молоко";

        Task[] expected = {epic1, epic2, epic3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNoSeveralFindEpic() {
        String[] subtasks1 = { "Молоко", "Яйца", "Хлеб" };
        String[] subtasks2 = { "Молоко", "Пиво", "Водка" };
        String[] subtasks3 = { "Молоко", "Кефир", "Селедка" };

        Epic epic1 = new Epic(55,subtasks1);
        Epic epic2 = new Epic(56,subtasks2);
        Epic epic3 = new Epic(57,subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        String query = "Боржоми";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSeveralFindMeeting() {
        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                666,
                "Выкатка 4й версии приложения",
                "Приложение ГазпромБанка",
                "В среду после ужина"
        );

        Meeting meeting3 = new Meeting(
                777,
                "Выкатка 5й версии приложения",
                "Приложение ВТББанка",
                "В четверг после завтрака"
        );
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        String query = "Выкатка";

        Task[] expected = {meeting1, meeting2, meeting3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSeveralFindOneMeeting() {
        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                666,
                "Выкатка 4й версии приложения",
                "Приложение ГазпромБанка",
                "В среду после ужина"
        );

        Meeting meeting3 = new Meeting(
                777,
                "Выкатка 5й версии приложения",
                "Приложение ВТББанка",
                "В четверг после завтрака"
        );
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        String query = "Выкатка 5й версии приложения";

        Task[] expected = {meeting3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNoSeveralFindMeeting() {
        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                666,
                "Выкатка 4й версии приложения",
                "Приложение ГазпромБанка",
                "В среду после ужина"
        );

        Meeting meeting3 = new Meeting(
                777,
                "Выкатка 5й версии приложения",
                "Приложение ВТББанка",
                "В четверг после завтрака"
        );
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        String query = "Отдохнуть";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);

    }


}
