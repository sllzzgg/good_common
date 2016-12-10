package com.dshl.commons.utlis;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dshl.commons.JedisClient;

import redis.clients.jedis.JedisCluster;

/**
 * 集群版
 * 
 * @author Noah
 *
 */
public class JedisClientCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}
	
	@Override
	public Long set(String key, String value, int seconds){
		jedisCluster.set(key, value);
		return jedisCluster.expire(key, seconds);
	}

	@Override
	public String hget(String key, String hkey) {
		return jedisCluster.hget(key, hkey);
	}

	@Override
	public long hset(String key, String hkey, String value) {
		return jedisCluster.hset(key, hkey, value);
	}

	@Override
	public long incr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public long expire(String key, int second) {
		return jedisCluster.expire(key, second);
	}

	@Override
	public long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	@Override
	public long del(String key) {

		return jedisCluster.del(key);
	}

	@Override
	public long hdel(String key, String hkey) {

		return jedisCluster.hdel(key, hkey);
	}

	@Override
	public long decr(String key) {
		return jedisCluster.decr(key);
	}

	@Override
	public String hmset(String key, Map<String, String> map) {

		return jedisCluster.hmset(key, map);
	}

	@Override
	public List<String> hmget(String key, String... fields) {

		return jedisCluster.hmget(key, fields);
	}

	@Override
	public Long rpush(String key, String... fields) {

		return jedisCluster.rpush(key, fields);
	}

	@Override
	public Long lpush(String key, String... fields) {

		return jedisCluster.lpush(key, fields);
	}

	@Override
	public List<String> lrange(String key, long start, long end) {

		return jedisCluster.lrange(key, start, end);
	}

	@Override
	public Long llen(String key) {

		return jedisCluster.llen(key);
	}

	@Override
	public String lset(String key, long index, String value) {

		return jedisCluster.lset(key, index, value);
	}

	@Override
	public String ltrim(String key, long start, long end) {

		return jedisCluster.ltrim(key, start, end);
	}

	@Override
	public Boolean exists(String key) {

		return jedisCluster.exists(key);
	}

	@Override
	public String type(String key) {

		return jedisCluster.type(key);
	}

	@Override
	public String getSet(String key, String value) {

		return jedisCluster.getSet(key, value);
	}

	@Override
	public String lpop(String key) {

		return jedisCluster.lpop(key);
	}

	@Override
	public String rpop(String key) {

		return jedisCluster.rpop(key);
	}

	@Override
	public Long lrem(String key, long count, String value) {

		return jedisCluster.lrem(key, count, value);
	}

	/**
	 * 集群请勿使用
	 */
	@Override
	public long del(String... fields) {
		return 0;
	}
	
	/**
	 * 删除所有数据
	 * @return OK
	 */
	public String flushAll(){
		return jedisCluster.flushAll();
	}

}
