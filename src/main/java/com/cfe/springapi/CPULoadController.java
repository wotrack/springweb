package com.cfe.springapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import com.sun.management.*;


@RestController
public class CPULoadController {
    
    @RequestMapping("/load/cpu")
    public String performcheck(int load) {
        //int load =2;
        //double loadSys = OperatingSystemMXBean.getSystemCpuLoad();
        
        double amount = 1;
        for(int i=1; i < load; i++) {
            for (int j=1; j< load; j++) {
                for (int k=1; k < load; k++) {
                    for (int l=1; l<load; l++) {
                        amount = amount *l;
                    }
                    amount = amount *k;
                }
                amount = amount *j;
            }
            amount = amount *i;
        }
        return  " .. final value: "+amount+" .... done! ..";
    }

    @RequestMapping("/load/check")
    public String initcheck(int amount) {
        return  "I am listing ..check: "+amount+" .... done! ..";
    }

    @RequestMapping("/load/simple")
    public String simpleload(@RequestParam("load") int load) {
        long amount = 1;
        for(int i=1; i < load; i++) {
            for (int j=1; j< load; j++) {
               amount = amount *j;
            }
            amount = amount *i;
        }
        return  ".. new final value: "+amount+" .... done! ..";
    }

}