/**
 * Обобщенный класс стека.
 *
 * @param <T> тип элементов, хранимых в этом стеке
 */
public class Stack<T> {

  private final T[] stackArray; // Массив для хранения элементов стека
  private int top; // Индекс вершины стека

  /**
   * Создает новый стек с заданной вместимостью.
   *
   * @param capacity вместимость стека
   */
  @SuppressWarnings("unchecked")
  public Stack(int capacity) {
    stackArray = (T[]) new Object[capacity];
    top = -1;
  }

  /**
   * Проверяет, пуст ли стек.
   *
   * @return true, если стек пуст, иначе false
   */
  public boolean isEmpty() {
    return top == -1;
  }

  /**
   * Проверяет, полон ли стек.
   *
   * @return true, если стек полон, иначе false
   */
  public boolean isFull() {
    return top == stackArray.length - 1;
  }

  /**
   * Добавляет элемент в стек (вталкивание).
   *
   * @param element элемент для добавления в стек
   * @throws IllegalStateException если стек полон
   */
  public void push(T element) {
    if (isFull()) {
      throw new IllegalStateException("Стек переполнен");
    }
    stackArray[++top] = element;
  }

  /**
   * Удаляет верхний элемент из стека (выталкивание).
   *
   * @return элемент, удаленный из стека
   * @throws EmptyStackException если стек пуст
   */
  public T pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return stackArray[top--];
  }

  /**
   * Удаляет элемент из стека (выталкивание).
   *
   * @param index индекс элемента для удаления
   * @return элемент, удаленный из стека
   * @throws EmptyStackException       если стек пуст
   * @throws IndexOutOfBoundsException если индекс вне диапазона
   */
  public T pop(int index) {
    if (isEmpty()) {
      throw new EmptyStackException("Стек пуст");
    }
    if (index < 0 || index > top) {
      throw new IndexOutOfBoundsException("Индекс вне диапазона");
    }
    T element = stackArray[index];
    for (int i = index; i < top; i++) {
      stackArray[i] = stackArray[i + 1];
    }
    top--;
    return element;
  }

  /**
   * Возвращает вершину стека (без удаления).
   *
   * @return элемент на вершине стека
   * @throws EmptyStackException если стек пуст
   */
  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException("Стек пуст");
    }
    return stackArray[top];
  }

  /**
   * Обменивает значения двух верхних элементов стека.
   *
   * @throws IllegalStateException если в стеке меньше двух элементов
   */
  public void swapTopTwo() {
    if (top < 1) {
      throw new IllegalStateException("Недостаточно элементов для обмена");
    }
    T temp = stackArray[top];
    stackArray[top] = stackArray[top - 1];
    stackArray[top - 1] = temp;
  }

  /**
   * Извлекает из стека первое вхождение передаваемого значения.
   *
   * @param value значение для извлечения из стека
   * @return возвращает null в случае, если элемента нет в стеке
   */
  public Object extract(T value) {
    int foundIndex = -1;
    for (int i = top; i >= 0; i--) {
      if (stackArray[i].equals(value)) {
        foundIndex = i;
        break;
      }
    }
    if (foundIndex != -1) {
      return foundIndex + " | " + stackArray[foundIndex];
    }
    return null;
  }

  /**
   * Выводит стек на экран.
   */
  public void display() {
    if (isEmpty()) {
      System.out.println("Стек пуст");
      return;
    }
    System.out.print("\u001B[0mID | element |");
    for (int i = top; i >= 0; i--) {
      System.out.print("\n" + i + " | " + stackArray[i] + " |");
      if (i == top) {
        System.out.print(" <-- Вершина");
      }
    }
    System.out.println();
  }
}