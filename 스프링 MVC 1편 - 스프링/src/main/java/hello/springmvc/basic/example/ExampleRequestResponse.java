package hello.springmvc.basic.example;

import hello.springmvc.basic.HelloData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleRequestResponse {


    @RequestMapping("/example-1")
    public HttpEntity<String> exam_1() {
        return new HttpEntity<>("ok");
    }

    @RequestMapping("/example-2")
    @ResponseBody
    public String exam_2(@RequestBody String HelloData) {
        return HelloData;
    }

    @RequestMapping("/example-3")
    @ResponseBody
    public HelloData exam_3(@RequestBody HelloData helloData) {
        return helloData;
    }

    @RequestMapping("/example-4")
    public ResponseEntity<String> exam_4(HttpEntity<String> httpEntity) {
        String body = httpEntity.getBody();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
