package learn.rocketmq.springboot.controller;

import com.alibaba.fastjson.JSON;
import learn.rocketmq.springboot.config.UserContent;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test(){
        DefaultMQProducer producer = new DefaultMQProducer("111");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setSendMsgTimeout(400000000);
        try {
            producer.start();

            UserContent userContent = new UserContent(String.valueOf(0),"abc"+0);
            String jsonstr = JSON.toJSONString(userContent);
            System.out.println("发送消息:"+jsonstr);
            Message message = new Message("TopicTest", "TagA", jsonstr.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            System.err.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
        return "hello";
    }

}
