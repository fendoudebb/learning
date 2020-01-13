package action.chainofresponsibility;

public abstract class Approver {
    Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void processRequest(Request request);
}
