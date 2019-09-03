package learn.rocketmq.producter.mq;

import com.alibaba.fastjson.JSONObject;
import learn.rocketmq.mq.RocketMQProducer;
import learn.rocketmq.producter.SenderMessageService;
import learn.rocketmq.producter.dto.MessageDto;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MqSenderMessageServiceImpl  implements SenderMessageService {

    @Autowired
    @Qualifier("rocketMQProducer")
    private RocketMQProducer producer;


    public boolean sendMessage(String topic, String tags, MessageDto dto){

        return doSendMessage(topic, tags, JSONObject.toJSONString(dto));
    }

    @Override
    public boolean doSendMessage(String topic, String tags, String body) {
        boolean isSend = false;


        Message msg = new Message(topic, tags, body.getBytes());
        try {
            SendResult result = producer.getDefaultMQProducer().send(msg);
            isSend = isSend(result.getSendStatus());
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return isSend ;
    }

    private boolean isSend(SendStatus sendStatus){

        return SendStatus.SEND_OK == sendStatus ? true : false;
    }



}
