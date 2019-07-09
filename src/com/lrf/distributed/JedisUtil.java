package com.lrf.distributed;
/**
 * 分布锁测试
 */

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {

    private static JedisPool pool;

    static {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        // 设置最大连接数
        poolConfig.setMaxTotal(GenericObjectPoolConfig.DEFAULT_MAX_TOTAL);
        // 设置最大空闲连接数
        poolConfig.setMaxIdle(GenericObjectPoolConfig.DEFAULT_MAX_IDLE);
        // 设置最小空闲连接数
        poolConfig.setMinIdle(GenericObjectPoolConfig.DEFAULT_MIN_IDLE);
        // 设置开启 jmx 功能
        poolConfig.setJmxEnabled(true);
        // 设置连接池没有连接后客户端的最大等待时间 ( 单位为毫秒 )
        poolConfig.setMaxWaitMillis(2 * 1000);
        pool = new JedisPool(poolConfig, "192.168.2.99", 6379, 10 * 1000, null, 3);
    }

    /**
     * 尝试获取分布式锁
     *
     * @param jedis      Redis客户端
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean lock(String key, String value) {
        boolean flag = true;
        Jedis jedis = null;
        try {
            // 1. 从连接池获取 jedis 对象
            jedis = pool.getResource();
            // 2. 执行操作
            String result = jedis.set(key, value, "NX", "PX", 10 * 1000);
            if (result == null) {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) // 如果使用 JedisPool ， close 操作不是关闭连接，代表归还连接池
                jedis.close();
        }
        return flag;
    }


    /**
     * 释放分布式锁
     *
     * @param jedis     Redis客户端
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean unlock(String key, String value) {
        boolean flag = false;
        Jedis jedis = null;
        try {
            // 1. 从连接池获取 jedis 对象
            jedis = pool.getResource();
            // 2. 执行操作
            String sql = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Long result = (Long) jedis.eval(sql, 1, key, value);
            if (result != null && result > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) // 如果使用 JedisPool ， close 操作不是关闭连接，代表归还连接池
                jedis.close();
        }
        return flag;
    }
}
