package flyway;

public class SuperMagicApp implements DbSetup {
  public static void main(String[] args) {
   DbSetup.migrate(
        "jdbc:postgresql://localhost:5432/postgres",
        "postgres",
        "Samir12345");
    /**
     * if table exists then do nothing
     * if something went wrong - exec: flyway.clean and flyway.migrate
     */
  }
}
