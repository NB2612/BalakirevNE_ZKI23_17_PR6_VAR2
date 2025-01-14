public class Menu {

  // RED_TEXT    \u001B[31m
  // WHITE_TEXT  \u001B[0m
  // GREEN_TEXT  \u001B[32m

  private final Input input;

  protected int menuItem;


  public Menu() {
    input = new Input();
  }

  public void startMenu(){
    System.out.print("""
          \u001B[32mДобро пожаловать в программу для работы со стеком!
          Выберите действие:
          1 - ссылочные данные (например, String);
          2 - примитивные данные (например, int);
          3 - выход
          $\u001B[0m\s""");

    menuItem = input.nextInt();
    switch (menuItem){
      case 1:
        stackStringMenu();
        break;
      case 2:
        stackIntMenu();
        break;
      case 3:
        System.out.println("\u001B[0mВыход из программы...");
        input.close();
        System.exit(0);
      default:
        System.out.println("\u001B[31mДействие вызвало ошибку: Некоректный пункт меню\u001B[0m");
        break;
    }

  }

  public void stackStringMenu() {
    Stack<String> stack = new Stack<>();

    do {
      System.out.print("""
          \u001B[32mВыберите действие:
          1 - проверить, стек пуст/не пуст;
          2 - добавить(втолкнуть) элемент в стек;
          3 - удалить(вытолкнуть) элемент из стека;
          4 - получить вершину стека;
          5 - обменять значения двух верхних элементов стека;
          6 - извлечь из стека первое вхождение передаваемого значения;
          7 - вывод стека на экран.
          8 - выход
          $\u001B[0m\s""");

      menuItem = input.nextInt();

      switch (menuItem) {
        case 1:
          if (stack.isEmpty()) {
            System.out.println("Стек пуст");
          } else {
            System.out.println("В стеке есть данные");
          }
          break;
        case 2:
          System.out.print("\u001B[32mВведите желаемый элемент:\u001B[0m ");
          String item = input.nextLine();
          try {
            stack.push(item);
            System.out.println("Элемент добавлен");
          } catch (IllegalStateException e) {
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 3:
          System.out.print("\u001B[32mВведите номер элемета для удаления:\u001B[0m ");
          try {
            System.out.println("Элемент\u001B[32m " + stack.pop(input.nextInt())
                + " \u001B[0mудален успешно");
          } catch (EmptyStackException | IndexOutOfBoundsException e){
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 4:
          try {
            System.out.println("Вершина стека: \u001B[32m" + stack.peek());
          } catch (EmptyStackException e){
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 5:
          try {
            stack.swapTopTwo();
            System.out.println("Обмен завершен успешно");
          } catch (IllegalStateException e){
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 6:
          System.out.print("\u001B[32mВведите значение для поиска: \u001B[0m");
          try {
            System.out.println("Первое вхождение: \u001B[0m" + stack.extract(input.nextLine()));
          } catch (IllegalStateException e){
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 7:
          stack.display();
          break;
        case 8:
          System.out.println("\u001B[0mВыход из программы...");
          input.close();
          System.exit(0);
        default:
          System.out.println("\u001B[31mДействие вызвало ошибку: Некоректный пункт меню\u001B[0m");
          break;
      }
    } while (true);
  }

  public void stackIntMenu() {
    Stack<Integer> stack = new Stack<>();
    do {
      System.out.print("""
          \u001B[32mВыберите действие:
          1 - проверить, стек пуст/не пуст;
          2 - добавить(втолкнуть) элемент в стек;
          3 - удалить(вытолкнуть) элемент из стека;
          4 - получить вершину стека;
          5 - обменять значения двух верхних элементов стека;
          6 - извлечь из стека первое вхождение передаваемого значения;
          7 - вывод стека на экран.
          8 - выход
          $\u001B[0m\s""");

      menuItem = input.nextInt();

      switch (menuItem) {
        case 1:
          if (stack.isEmpty()) {
            System.out.println("Стек пуст");
          } else {
            System.out.println("В стеке есть данные");
          }
          break;
        case 2:
          System.out.print("\u001B[32mВведите желаемый элемент:\u001B[0m ");
          int item = input.nextInt();
          try {
            stack.push(item);
            System.out.println("Элемент добавлен");
          } catch (IllegalStateException e) {
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 3:
          System.out.print("\u001B[32mВведите номер элемета для удаления:\u001B[0m ");
          try {
            System.out.println("Элемент\u001B[32m " + stack.pop(input.nextInt())
                + " \u001B[0mудален успешно");
          } catch (EmptyStackException | IndexOutOfBoundsException e){
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 4:
          try {
            System.out.println("Вершина стека: \u001B[32m" + stack.peek());
          } catch (EmptyStackException e){
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 5:
          try {
            stack.swapTopTwo();
            System.out.println("Обмен завершен успешно");
          } catch (IllegalStateException e){
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 6:
          System.out.print("\u001B[32mВведите значение для поиска: \u001B[0m");
          try {
            System.out.println("Первое вхождение: \u001B[0m" + stack.extract(input.nextInt()));
          } catch (IllegalStateException e){
            System.out.println("\u001B[31mДействие вызвало ошибку: " + e.getMessage()
                + "\u001B[0m");
          }
          break;
        case 7:
          stack.display();
          break;
        case 8:
          System.out.println("\u001B[0mВыход из программы...");
          input.close();
          System.exit(0);
        default:
          System.out.println("\u001B[31mДействие вызвало ошибку: Некоректный пункт меню\u001B[0m");
          break;
      }
    } while (true);
  }


}
