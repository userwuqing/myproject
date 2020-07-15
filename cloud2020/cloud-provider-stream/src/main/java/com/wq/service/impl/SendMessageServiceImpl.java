package com.wq.service.impl;

import com.wq.service.ISendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Random;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月15日 16:10
 */
@EnableBinding(Source.class)
public class SendMessageServiceImpl implements ISendMessageService {

    @Autowired
    private MessageChannel messageChannel;

    @Output("output")
    @Override
    public void sendMessage() {
        String message = "消息队列"+new Random().nextInt(100);
        //发送消息
        messageChannel.send(MessageBuilder.withPayload(message).build());
    }
}
