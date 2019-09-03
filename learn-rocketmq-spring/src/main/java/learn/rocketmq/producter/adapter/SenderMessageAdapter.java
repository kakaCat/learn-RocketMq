package learn.rocketmq.producter.adapter;

import learn.rocketmq.producter.dto.MessageDto;

public interface SenderMessageAdapter {

    boolean senderOrderMessage(MessageDto dto);

}
