package in.shriji;

import in.shriji.notificaction.NotificationService;
import in.shriji.notificaction.SmsNotification;
import in.shriji.notificaction.WhatsAppNotification;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
//        NotificationService notification=new SmsNotification();
        NotificationService notification=new WhatsAppNotification();
        OrderService order=new OrderService(notification);
//        PaymentService payment=new PaymentService();
        order.payOrder();
//        payment.pay();
    }
}
