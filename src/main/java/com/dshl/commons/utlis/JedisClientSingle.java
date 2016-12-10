package com.dshl.commons.utlis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dshl.commons.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 单机版
 * 
 * @author Noah
 *
 */
public class JedisClientSingle implements JedisClient {

	@Autowired
	private JedisPool jedisPool;

	/**
	 * 单查
	 */
	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	/**
	 * 单加
	 */
	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}
	
	/**
	 * 单加以及设置过期时间
	 */
	@Override
	public Long set(String key, String value, int seconds){
		Jedis jedis = jedisPool.getResource();
		jedis.set(key, value);
		Long expire = jedis.expire(key, seconds);
		jedis.close();
		return expire;
	}

	/**
	 * 单删
	 */
	@Override
	public long del(String... fields) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(fields);
		jedis.close();
		return result;
	}

	/**
	 * 哈删
	 */
	@Override
	public long hdel(String key, String hkey) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(key, hkey);
		jedis.close();
		return result;
	}

	/**
	 * 哈查
	 */
	@Override
	public String hget(String key, String hkey) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(key, hkey);
		jedis.close();
		return string;
	}

	/**
	 * 哈加
	 */
	@Override
	public long hset(String key, String hkey, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(key, hkey, value);
		jedis.close();
		return result;
	}

	@Override
	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	/**
	 * 过期时间 过期返回-2 永久返回-1
	 */
	@Override
	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	/**
	 * 获取过期时间
	 */
	@Override
	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	@Override
	public long decr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.decr(key);
		jedis.close();
		return result;
	}

	@Override
	public String hmset(String key, Map<String, String> map) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hmset(key, map);
		jedis.close();
		return result;
	}

	@Override
	public List<String> hmget(String key, String... fields) {
		Jedis jedis = jedisPool.getResource();
		List<String> result = jedis.hmget(key, fields);
		jedis.close();
		return result;
	}

	@Override
	public Long rpush(String key, String... fields) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.rpush(key, fields);
		jedis.close();
		return result;
	}

	@Override
	public Long lpush(String key, String... fields) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.lpush(key, fields);
		jedis.close();
		return result;
	}

	@Override
	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = jedisPool.getResource();
		List<String> result = jedis.lrange(key, start, end);
		jedis.close();
		return result;
	}

	@Override
	public Long llen(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.llen(key);
		jedis.close();
		return result;
	}

	@Override
	public String lset(String key, long index, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.lset(key, index, value);
		jedis.close();
		return result;
	}

	@Override
	public String ltrim(String key, long start, long end) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.ltrim(key, start, end);
		jedis.close();
		return result;
	}

	@Override
	public Boolean exists(String key) {
		Jedis jedis = jedisPool.getResource();
		Boolean result = jedis.exists(key);
		return result;
	}

	@Override
	public String type(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.type(key);
		jedis.close();
		return result;
	}

	@Override
	public String getSet(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.getSet(key, value);
		jedis.close();
		return result;
	}

	@Override
	public String lpop(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.lpop(key);
		jedis.close();
		return result;
	}

	@Override
	public String rpop(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.rpop(key);
		jedis.close();
		return result;
	}

	@Override
	public Long lrem(String key, long count, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.lrem(key, count, value);
		jedis.close();
		return result;
	}

	@Override
	public long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}
	

	/**
	 * 删除所有数据
	 * @return OK
	 */
	public String flushAll(){
		Jedis jedis = jedisPool.getResource();
		String result = jedis.flushAll();
		jedis.close();
		return result;
	}

}
