package com.cfe.springapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

@RestController
public class RedisAppController {
    public JedisPool pool;       
    @RequestMapping("/redis/test")
	public String index() {
		return "Redis COntroller listening!";
    }

    @RequestMapping("/redis/get")
    public String getval(String key) {
    	pool = new JedisPool(new JedisPoolConfig(),
                    "localhost",6379, 
                    Protocol.DEFAULT_TIMEOUT);

    	System.out.println ("executed set initiating....");
        if (pool != null) {
            String res = "";
            Jedis jedis = pool.getResource();
            if (!"".equalsIgnoreCase(key)) res = jedis.get(key);
            pool.returnResource(jedis);
            return "redis returned : "+res+ " .. "; 
        } else {
            return "pool not found ..";
        }        
    }

    @RequestMapping("/redis/set")
    public String setval(String key, String value) {
    	pool = new JedisPool(new JedisPoolConfig(),
                    "localhost",6379, 
                    Protocol.DEFAULT_TIMEOUT);

    	System.out.println ("executed set initiating....");
        if (pool != null) {
            String res = "";
            Jedis jedis = pool.getResource();
            if (!"".equalsIgnoreCase(key) && !"".equalsIgnoreCase(value)) {
                res = jedis.set(key, value);
            }
            pool.returnResource(jedis);
            return "redis returned : "+res+ " .. "; 
        } else {
            return "pool not found ..";
        }
        
    }

    @RequestMapping("/redis/info")
    public String info() {
    	pool = new JedisPool(new JedisPoolConfig(),
                    "localhost",6379, 
                    Protocol.DEFAULT_TIMEOUT);

    	System.out.println ("executed set initiating....");
        if (pool != null) {
            String res = "";
            Jedis jedis = pool.getResource();
            res = jedis.info();
            pool.returnResource(jedis);
            return "redis returned : "+res+ " .. "; 
        } else {
            return "pool not found ..";
        }
    }

    @RequestMapping("/redis/flush")
    public String flush() {
    	pool = new JedisPool(new JedisPoolConfig(),
                    "localhost",6379, 
                    Protocol.DEFAULT_TIMEOUT);

    	System.out.println ("executed set initiating....");
        if (pool != null) {
            String res = "";
            Jedis jedis = pool.getResource();
            res = jedis.flushDB();
            pool.returnResource(jedis);
            return "redis returned : "+res+ " .. "; 
        } else {
            return "pool not found ..";
        }
    }
    
}
