package learn.rocketmq.producter.adapter;

import learn.rocketmq.producter.dto.MessageDto;

public abstract class SenderMessageTemplate implements SenderMessageAdapter{


    protected abstract void senderBefore(MessageDto dto);

    protected abstract boolean senderOrderMessageInfo(MessageDto dto);


    protected abstract void senderAfter(MessageDto dto);


    @Override
    public boolean senderOrderMessage(MessageDto dto){
        this.senderAfter(dto);
        boolean result = this.senderOrderMessageInfo(dto);
        this.senderBefore(dto);
        return result;
    }

}
