package sbnz.cdss.websockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    public void onRecivedMessage(String message) {
        this.template.convertAndSend("/chat",new SimpleDateFormat("HH:mm:ss")
                .format(new Date())  + "-" + message);
    }


}
