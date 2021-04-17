/**
 * zbj: created on 2021/4/5 20:50.
 */
public class EnumDemo {

    public static void main(String[] args) {
        int status = 1;
        /*String orderStatus;
        if (status == 0) {
            orderStatus = "UNPAID";
        } else if (status == 1) {
            orderStatus = "PAID";
        } else {
            orderStatus = "PAYING";
        }*/

        String orderStatus = OrderStatus.of(status);
        System.out.println(orderStatus);
    }

    private enum OrderStatus {
        UNPAID(0,"未支付"),
        PAID(1,"已支付"),
        PAYING(2, "支付中");

        private int code;
        private String label;

        OrderStatus(int code, String label) {
            this.code = code;
            this.label = label;
        }

        public static String of(int code) {
            for(OrderStatus s : OrderStatus.values()) {
                if(s.code == code) {
                    return s.label;
                }
            }
            return "";
        }
    }

}
