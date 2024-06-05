package ru.netology.todos;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks );

        Todos todos = new Todos();

        todos.add(epic);
        String query = "GGGG";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        //Assertions.assertArrayEquals(expected, actual);


    }
}