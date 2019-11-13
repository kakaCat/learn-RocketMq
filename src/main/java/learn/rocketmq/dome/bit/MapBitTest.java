package learn.rocketmq.dome.bit;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.BitVector;

import java.util.ArrayList;
import java.util.List;

public class MapBitTest {

    public static void main(String[] args) {

        BitVector bitVector = new BitVector();

        bitVector.set(1L);

        boolean set = bitVector.isSet(1L);

        boolean set2 = bitVector.isSet(2L);
        System.out.println(set2);

//        System.out.printf("set:{%s} , set2:{%d}",set,set2);

        List<Boolean> bo = new ArrayList<>();

        bo.add(false);

        String json = JSONObject.toJSONString(bitVector);

        System.out.println("json"+ json);


    }


}
