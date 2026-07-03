package in.shriji.notificaction;

public class SmsNotification implements NotificationService{
    @Override
    public void noti()
    {
        System.out.println("sms message");
    }
}
