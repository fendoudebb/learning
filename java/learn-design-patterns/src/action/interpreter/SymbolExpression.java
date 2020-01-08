package action.interpreter;

import java.util.Set;

public class SymbolExpression implements Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(Set<Integer> var) {
        return 0;
    }
}