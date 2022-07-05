package ar.edu.ungs.apps;

import ar.edu.ungs.apps.shared.Application;
import ar.edu.ungs.apps.swing.SwingApplication;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public final class Starter {
  private static final Map<String, Class<? extends Application>> applications = applications();

  public static void main(String[] args) {
    ensureApplicationExists(args);

    String applicationName = args[0];

    run(applicationName);
  }

  private static void run(String applicationName) {
    try {
      applications.get(applicationName).getConstructor().newInstance().run();
    } catch (NoSuchMethodException
        | InvocationTargetException
        | InstantiationException
        | IllegalAccessException error) {
      throw new RuntimeException(String.format("can not run <%s> application", applicationName));
    }
  }

  private static void ensureApplicationExists(String[] args) {
    if (args[0] == null || args[0].isEmpty()) {
      throw new RuntimeException("the application not selected");
    }

    if (!applications.containsKey(args[0])) {
      throw new RuntimeException(String.format("the application <%s> not exists", args[0]));
    }
  }

  private static Map<String, Class<? extends Application>> applications() {
    Map<String, Class<? extends Application>> applications = new HashMap<>();
    applications.put("swing", SwingApplication.class);
    return applications;
  }
}
