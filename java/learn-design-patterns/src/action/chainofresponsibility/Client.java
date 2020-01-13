package action.chainofresponsibility;

public class Client {
    public static void main(String[] args) {
        Request request = new Request();
        request.price = 250;
        Approver approver = new JuniorApprover();
        approver.processRequest(request);
    }
}
