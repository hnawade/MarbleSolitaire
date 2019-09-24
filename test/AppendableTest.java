import java.io.IOException;

/**
 * The {@code AppendableTest} class extends the {@code Appendable} interface for the purpose of
 * testing the case that appending to the given Appendable results in an IOException error.
 */
class AppendableTest implements Appendable {
  /**
   * Throws an IOException.
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  /**
   * Throws an IOException.
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  /**
   * Throws an IOException.
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
