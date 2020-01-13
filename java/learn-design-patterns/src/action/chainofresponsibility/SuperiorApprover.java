package action.chainofresponsibility;

public class SuperiorApprover extends Approver {
    @Override
    public void processRequest(Request request) {
        if (request.price > 200) {
            System.out.println("> 200 superior 处理");
        } else {
            setNextApprover(new JuniorApprover());
            nextApprover.processRequest(request);
        }
    }
}
