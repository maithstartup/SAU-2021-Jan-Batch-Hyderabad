package working;

public class AUSingleton {

    private static AUSingleton mysingleton = new AUSingleton();
    private static int singletonVar;

    private AUSingleton() {
        AUSingleton.singletonVar = 1;
    }

    public static AUSingleton getInstance() {
        return mysingleton;
    }

    public static int getSingletonVar() {
        return singletonVar;
    }

    public static void setSingletonVar(int singletonVar) {
        AUSingleton.singletonVar = singletonVar;
    }

    protected static void exampleFuntion() {
        System.out.println("Function print: " + AUSingleton.getSingletonVar());
    }
}
