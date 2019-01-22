package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String[] contact = {"Hi, my name is %s!", "My number is %s"};
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/contacts")
    public Contacts[] contacts(@RequestParam(value="name", defaultValue="<Content not paste>") String name) {
        return new Contacts[]{
                new Contacts(counter.incrementAndGet(), String.format(contact[0], name)),
                new Contacts(counter.incrementAndGet(), String.format(contact[1], name))
        };
    }
}
