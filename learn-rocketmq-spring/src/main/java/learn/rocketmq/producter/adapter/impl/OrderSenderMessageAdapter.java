//package learn.rocketmq.producter.adapter.impl;
//
//import learn.rocketmq.producter.mq.SenderMessage;
//import learn.rocketmq.producter.adapter.SenderMessageTemplate;
//import learn.rocketmq.producter.dto.MessageDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderSenderMessageAdapter extends SenderMessageTemplate  {
//
//    @Autowired
//    private SenderMessage senderMessage;
//
//    @Override
//    public boolean senderOrderMessageInfo(MessageDto dto){
//        String topic = "";
//        String tags = "";
//        String body = "";
//
//        return senderMessage.doSendMessage(topic, tags, body);
//    }
//
//
//    @Override
//    protected void senderBefore(MessageDto dto) {
//
//    }
//
//    @Override
//    protected void senderAfter(MessageDto dto) {
//
//    }
//}
