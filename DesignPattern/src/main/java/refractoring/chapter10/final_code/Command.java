package refractoring.chapter10.final_code;

import java.util.HashMap;
import java.util.Map;

public class Command {
    public static final Command FORWARD = new Command("forward");
    public static final Command BACKWARD = new Command("backward");
    public static final Command TURN_RIGHT = new Command("right");
    public static final Command TURN_LEFT = new Command("left");
    private static final Map<String, Command> commandMap = new HashMap<String, Command>();

    static {
        commandMap.put(FORWARD.name, FORWARD);
        commandMap.put(BACKWARD.name, BACKWARD);
        commandMap.put(TURN_RIGHT.name, TURN_RIGHT);
        commandMap.put(TURN_LEFT.name, TURN_LEFT);
    }

    private final String name;

    private Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Command parseCommand(String name) throws InvalidCommandException {
        if (!commandMap.containsKey(name)) {
            throw new InvalidCommandException(name);
        }
        return commandMap.get(name);
    }
}