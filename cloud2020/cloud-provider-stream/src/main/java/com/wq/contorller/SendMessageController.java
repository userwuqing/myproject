package com.wq.contorller;

import com.wq.service.ISendMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月15日 16:08
 */
@RestController
@RequestMapping("send")
public class SendMessageController {

    @Resource
    private com.wq.service.ISendMessageService sendMessageService;

    @GetMapping("sendMessage.do")
    public String sendMessage() {
        sendMessageService.sendMessage();
        return "消息服务生产者8801";
    }
}
