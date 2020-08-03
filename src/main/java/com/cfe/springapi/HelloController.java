package com.cfe.springapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
    }
    
    @RequestMapping("/load/cpu")
    public String performcheck() {
        int load =2;
        long amount = 1;
        for(int i=0; i < load; i++) {
            for (int j=0; i< load; j++) {
                for (int k=0; k < load; k++) {
                    for (int l=0; l<load; l++) {
                        amount = amount *l;
                    }
                    amount = amount *k;
                }
                amount = amount *j;
            }
            amount = amount *i;
        }
        return  "final value: "+amount;
    }

    @RequestMapping("/load/check")
    public String initcheck(int amount) {
        return  "I am listing ..check: "+amount;
    }

    @RequestMapping("/load/simple")
    public String simpleload(int load) {
        int amount = 1;
        for(int i=1; i < load; i++) {
            for (int j=1; j< load; j++) {
               amount = amount *j;
            }
            amount = amount *i;
        }
        return  "final value: "+amount;
    }
}