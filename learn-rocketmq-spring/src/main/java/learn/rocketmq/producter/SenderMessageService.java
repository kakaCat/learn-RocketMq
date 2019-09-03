package learn.rocketmq.producter;

public interface SenderMessageService {

    boolean doSendMessage(String topic, String tags, String body);

}
