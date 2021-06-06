package refractoring.before;
public class Logger {
    private enum State {
        STOPPED {
            @Override public void start() {
                System.out.println("** START LOGGING **");
            }
            @Override public void stop() {
                /* 아무것도 하지 않음 */
            }
            @Override public void log(String info) {
                System.out.println("Ignoring: " + info);
            }
        },

        LOGGING {
            @Override public void start() {
                /* 아무것도 하지 않음 */
            }
            @Override public void stop() {
                System.out.println("** STOP LOGGING **");
            }
            @Override public void log(String info) {
                System.out.println("Logging: " + info);
            }
        };

        public abstract void start();
        public abstract void stop();
        public abstract void log(String info);
    }

    private State _state;
    public Logger() {
        setState(State.STOPPED);
    }
    public void setState(State state) {
        _state = state;
    }
    public void start() {
        _state.start();
        setState(State.LOGGING);
    }
    public void stop() {
        _state.stop();
        setState(State.STOPPED);
    }
    public void log(String info) {
        _state.log(info);
    }
}
//public class Logger {
//    public static final int STATE_STOPPED = 0;
//    public static final int STATE_LOGGING = 1;
//    private int _state;
//
//    public Logger() {
//        _state = STATE_STOPPED;
//    }
//
//    public void start() {
//        switch (_state) {
//            case STATE_STOPPED:
//                System.out.println("** START LOGGING **");
//                _state = STATE_LOGGING;
//                break;
//            case STATE_LOGGING:
//                /* 아무것도 하지 않음 */
//                break;
//            default:
//                System.out.println("Invalid state: " + _state);
//        }
//    }
//
//    public void stop() {
//        switch (_state) {
//            case STATE_STOPPED:
//                /* 아무것도 하지 않음 */
//                break;
//            case STATE_LOGGING:
//                System.out.println("** STOP LOGGING **");
//                _state = STATE_STOPPED;
//                break;
//            default:
//                System.out.println("Invalid state: " + _state);
//        }
//    }
//
//    public void log(String info) {
//        switch (_state) {
//            case STATE_STOPPED:
//                System.out.println("Ignoring: " + info);
//                break;
//            case STATE_LOGGING:
//                System.out.println("Logging: " + info);
//                break;
//            default:
//                System.out.println("Invalid state: " + _state);
//        }
//    }
//}
