package action.chainofresponsibility;

public class SeniorApprover extends Approver {
    @Override
    public void processRequest(Request request) {
        if (request.price <= 200) {
            System.out.println("<= 200 senior 处理");
        } else {
            setNextApprover(new SuperiorApprover());
            nextApprover.processRequest(request);
        }
    }
}
