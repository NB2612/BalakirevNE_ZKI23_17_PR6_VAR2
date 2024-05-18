import java.util.Scanner;

public class Input {

  private final Scanner scanner;

  public Input() {
    scanner = new Scanner(System.in);
  }

  /**
   * Получает из консоли данные в формате int
   *
   * @return возвращает числовое значение
   */
  public int nextInt() {
    if (scanner.hasNextInt()) {
      int item = scanner.nextInt();
      scanner.nextLine();
      return item;
    }
    scanner.nextLine();
    System.out.println("\u001B[31mОшибка: Введеный символ не является числом\u001B[0m");
    return 0;
  }

  /**
   * Получает из консоли данные в формате Object
   *
   * @return возвращает элемент из строки в формате Object
   */
  public Object nextObj() {
    return scanner.next();
  }

  public void close() {
    scanner.close();
  }

}
