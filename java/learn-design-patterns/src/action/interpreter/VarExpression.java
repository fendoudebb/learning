package action.interpreter;

import java.util.Set;

public class VarExpression implements Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(Set<Integer> var) {
        return var.contains(Integer.valueOf(this.key)) ? Integer.valueOf(this.key) : -1;
    }
}
