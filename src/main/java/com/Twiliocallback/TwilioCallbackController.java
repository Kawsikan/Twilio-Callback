package com.Twiliocallback;

import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/callback")
public class TwilioCallbackController {

    @PostMapping("")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        VoiceResponse.Builder builder = new VoiceResponse.Builder();

        String digits = request.getParameter("Digits");
        if (digits != null) {
            switch (digits) {
                case "1":
                    builder.say(new Say.Builder("You selected sales. Good for you!").build());
                    break;
                case "2":
                    builder.say(new Say.Builder("You need support. We will help!").build());
                    break;
                default:
                    builder.say(new Say.Builder("Sorry, I don\'t understand that choice.").build());
                    break;
            }
        }
        response.setContentType("application/xml");
        try {
            response.getWriter().print(builder.build().toXml());
        } catch (TwiMLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        VoiceResponse.Builder builder = new VoiceResponse.Builder();

        String digits = request.getParameter("Digits");
        if (digits != null) {
            switch (digits) {
                case "1":
                    builder.say(new Say.Builder("You selected sales. Good for you!").build());
                    break;
                case "2":
                    builder.say(new Say.Builder("You need support. We will help!").build());
                    break;
                default:
                    builder.say(new Say.Builder("Sorry, I don\'t understand that choice.").build());
                    break;
            }
        }
        response.setContentType("application/xml");
        try {
            response.getWriter().print(builder.build().toXml());
        } catch (TwiMLException e) {
            throw new RuntimeException(e);
        }
    }

}
