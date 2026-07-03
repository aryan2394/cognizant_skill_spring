package in.shriji;

import in.shriji.notificaction.NotificationService;

public class OrderService {
    private NotificationService notification;
    public OrderService(NotificationService notification)
    {
        this.notification=notification;
    }
    public void payOrder()
    {
        notification.noti();
        System.out.println("order paid");
    }

}
