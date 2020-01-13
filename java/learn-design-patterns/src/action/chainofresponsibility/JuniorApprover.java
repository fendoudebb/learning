package action.chainofresponsibility;

public class JuniorApprover extends Approver {
    @Override
    public void processRequest(Request request) {
        if (request.price <= 100) {
            System.out.println("<= 100 junior 处理");
        } else {
            setNextApprover(new SeniorApprover());
            nextApprover.processRequest(request);
        }
    }
}
