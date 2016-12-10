package com.dshl.commons;

import java.util.List;
import java.util.Map;

/**
 * Jedis简单二次封装
 * @author Noah
 * @version 1.1.6
 */
public interface JedisClient {

	/**
	 * 单查
	 * @param key 获取数据的键名
	 * @return 获取到的数据（如果不存在返回nil）
	 */
	public String get(String key);
	/**
	 * 单存
	 * @param key 存储数据的键
	 * @param value 存储的数据
	 * @return 成功返回OK
	 */
	public String set(String key, String value);
	/**
	 * 单存加过期时间(单位:s)
	 * 
	 * @author Noah
	 *
	 * 2016年7月19日上午10:51:46
	 * 
	 * @param key 存储数据的键
	 * @param value 存储的数据
	 * @param seconds 要设置的过期时间(单位:s)
	 * @return
	 */
	public Long set(String key, String value, int seconds);
	/**
	 * 单删
	 * @param fields 要删除的value对应的键
	 * @return 成功返回所删除的个数
	 */
	public long del(String... fields);
	/**
	 * 单删
	 * @param key 要删除的value对应的键
	 * @return 成功返回1
	 */
	public long del(String key);
	/**
	 * 哈希查
	 * @param key 获取数据的键
	 * @param hkey 获取数据的hash键
	 * @return 返回所存储的hash值（无结果返回null）
	 */
	public String hget(String key, String hkey);
	/**
	 * 哈希存
	 * @param key 存储数据的键
	 * @param hkey 存数据的hash键
	 * @param value 存储的数据
	 * @return 成功返回1
	 */
	public long hset(String key, String hkey, String value);
	/**
	 * 哈希删
	 * @param key 删除的键
	 * @param hkey 删除的hash键
	 * @return 成功返回1
	 */
	public long hdel(String key, String hkey);
	/**
	 * 获取自增1后的值
	 * @param key 获取键自增后值的键
	 * @return 对应的value自增后的值
	 */
	public long incr(String key);
	/**
	 * 获取自减1后的值
	 * @param key
	 * @return 对应的value自减后的值
	 */
	public long decr(String key);
	/**
	 * 设置过期时间
	 * @param key 要设置过期的键
	 * @param second 过期时间
	 * @return 成功返回1
	 */
	public long expire(String key, int second);
	/**
	 * 获取剩余过期时间
	 * @param key 获取过期时间剩余多久的键
	 * @return 剩余过期时间
	 */
	public long ttl(String key);
	/**
	 * 向名称为key的hash中添加元素field i<—>value i
	 * @param key 存储map类型的键
	 * @param map 存储数据
	 * @return 成功返回OK
	 */
	public String hmset(String key, Map<String,String> map);
	/**
	 * 返回名称为key的hash中field i对应的value
	 * @param key 获取值的键
	 * @param fields 获取map的key值
	 * @return 所存在的KEY对应的value
	 */
	public List<String> hmget(String key, String... fields);
	/**
	 * 有序右追加
	 * @param key 存入的键
	 * @param fields 向右追加存放
	 * @return 成功返回现有list长度
	 */
	public Long rpush(String key, String... fields);
	/**
	 * 有序左追加
	 * @param key 存入的键
	 * @param fields 向左追加存放
	 * @return 成功返回现有list长度
	 */
	public Long lpush(String key, String... fields);
	/**
	 * 案范围取出
	 * @param key 取出的键
	 * @param start 起始位置（起始为0）
	 * @param end 结束为止（-1表示获取所有）
	 * @return 返回list，泛型为String
	 */
	public List<String> lrange(String key, long start, long end);
	/**
	 * 获取list类型的长度
	 * @param key 想要获取长度的键
	 * @return 长度(键不存在返回0)
	 */
	public Long llen(String key);
	/**
	 * 给名称为key的list中index位置的元素赋值为value
	 * @param key 修改的键
	 * @param index 所在list位置
	 * @param value 修改后的值
	 * @return 成功返回OK
	 */
	public String lset(String key, long index, String value);
	/**
	 * 进行裁剪：左右包含
	 * @param key 要裁剪的list
	 * @param start 起始位置
	 * @param end 结束为止
	 * @return 成功返回OK
	 */
	public String ltrim(String key, long start, long end);
	/**
	 * 确定一个键是不是存在
	 * @param key 判断的键
	 * @return true或者false
	 */
	public Boolean exists(String key);
	/**
	 * 获取类型
	 * @param key 查询类型的键
	 * @return hash/String/...
	 */
	public String type(String key);
	/**
	 * 给名称为key的赋上一个value
	 * @param key
	 * @param value
	 * @return 成功返回之前所存储的值
	 */
	public String getSet(String key, String value);
	/**
	 * 返回并删除名称为key的list中的首元素
	 * @param key 要删除list首元素的键
	 * @return 返回已被删除的值
	 */
	public String lpop(String key);
	/**
	 * 返回并删除名称为key的list中的尾元素
	 * @param key 要删除list尾元素的键
	 * @return 返回已被删除的值
	 */
	public String rpop(String key);
	/**
	 * 删除count个名称为key的list中值为value的元素。
	 * count=0	删除所有值为value的元素。
	 * count>0     从头至尾删除count个值为value的元素。
	 * count<0	从尾到头删除|count|个值为value的元素。
	 * @param key 删除的键
	 * @param count 删除的数量
	 * @param value 删除的值
	 * @return 返回删除个数
	 */
	public Long lrem(String key, long count, String value);
	/**
	 * 删除所有数据
	 * @return OK
	 */
	public String flushAll();
}