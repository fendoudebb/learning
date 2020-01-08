package action.interpreter;

import java.util.Set;

public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(Set<Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
