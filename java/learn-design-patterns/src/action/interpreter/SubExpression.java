package action.interpreter;

import java.util.Set;

public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(Set<Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }

}
