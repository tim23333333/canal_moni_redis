package com.atguigu.canal.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @auther zzyy
 * @create 2022-12-22 12:42
 */
public class RedisUtils
{
    public static final String  REDIS_IP_ADDR = "192.168.168.102";
    public static final String  REDIS_pwd = "111111";
    public static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool=new JedisPool(jedisPoolConfig,REDIS_IP_ADDR,6379,10000,REDIS_pwd);
    }

    public static Jedis getJedis() throws Exception {
        if(null!=jedisPool){
            return jedisPool.getResource();
        }
        throw new Exception("Jedispool is not ok");
    }

//    public static void main(String[] args) throws Exception {
//        Jedis jedis = getJedis();
//        System.out.println(jedis.ping());
//    }

}


