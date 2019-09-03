package learn.rocketmq.controller;


import learn.rocketmq.mq.RocketMQProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    @Qualifier("rocketMQProducer")
    private RocketMQProducer producer;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("TopicTest", "TAG1", (i + "這是spring集成").getBytes());
            SendResult result = producer.getDefaultMQProducer().send(msg);
            System.out.println(result);
            System.out.println(1);
        }
        return "hello";
    }

}
