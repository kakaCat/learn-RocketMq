package learn.rocketmq.producter.dto;

public class MessageDto<T> {

    private T t;

    private Class<T> clazz;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
