package templatemethod;


public abstract class AbstGameConnectHelper {
    // 외부에서 호출하면안되는데 하위클래스가 사용할 수 있게.
    protected abstract String doSecurity(String string);

    protected abstract boolean authentication(String id, String passwword);

    protected abstract int authorization(String username);

    protected abstract String connection(String info);

    public String requestConnection(String str) {
        // 보안 작업->암호화 된 문자열을 decode(복호화)
        String decodedInfo = doSecurity(str);
        String id = "userId";
        String password = "password";
        if (!authentication(id, password)) {
            throw new Error("Id/Password 불일치");
        }
        ;

        String username = "username";
        int i = authorization(username);
        switch (i) {
            case 0:
                // Manager
                System.out.println("Manager");
                break;
            case 1:
                System.out.println("User");
                break;
            case 2:
                System.out.println("VIP");
                break;
            case 3:
                System.out.println("Owner");
                break;
            case 4:
                System.out.println("Shut down");
                break;
            default:
        }
        return connection(decodedInfo);
    }


}
