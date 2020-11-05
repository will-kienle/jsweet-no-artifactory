package source.functions;

import java.util.function.Function;

public class BasicFunctions {

    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x;
        assert f.apply(2) == 2;
        assert Function.<Integer>identity().apply(2) == 2;

        MyFunc ff = getFunc();
        String res = applyIt(ff);
        assert res == "good";
        
        // useful for overload
        assert ff instanceof MyFunc;
    }

    static MyFuncImpl getFunc() {
        return new MyFuncImpl();
    }

    static String applyIt(MyFunc f) {
        return f.doThis();
    }
}

@FunctionalInterface
interface MyFunc {
    String doThis();
}

class MyFuncImpl implements MyFunc {
    @Override
    public String doThis() {
        return "good";
    }
}