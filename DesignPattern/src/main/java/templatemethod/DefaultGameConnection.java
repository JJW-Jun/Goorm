package templatemethod;

public class DefaultGameConnection extends AbstGameConnectHelper{

    @Override
    protected String doSecurity(String string) {
        System.out.println("Decode");
        return "String";
    }

    @Override
    protected boolean authentication(String id, String passwword) {
        System.out.println("Id / Password ghkrdl");
        return true;
    }

    @Override
    protected int authorization(String username) {
        System.out.println("권한 확인");
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println("마지막 접속단계");
        return null;
    }
}
