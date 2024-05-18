/**
 * Исключение, выбрасываемое при попытке доступа к элементу пустого стека.
 */
public class EmptyStackException extends RuntimeException {

  /**
   * Создаёт новое исключение {@code EmptyStackException} без сообщения.
   */
  public EmptyStackException() {
    super();
  }

  /**
   * Создаёт новое исключение {@code EmptyStackException} с указанным сообщением.
   *
   * @param message сообщение об ошибке, описывающее причину исключения.
   */
  public EmptyStackException(String message) {
    super(message);
  }
}