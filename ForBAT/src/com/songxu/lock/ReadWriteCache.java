package com.songxu.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 利用读写锁实现的一个数据结构
 * @author songxu
 *
 */
public class ReadWriteCache 
{
	//利用hashmap作为底层数据结构
	private Map<String, Object> cache=new HashMap<String, Object>();
	//构造读写锁
	private ReentrantReadWriteLock readwritelock=new ReentrantReadWriteLock();
	//读锁
	private Lock readLock=readwritelock.readLock();
	//写锁
	private Lock writeLock=readwritelock.writeLock();
	
	/**
	 * 存入数据
	 * @param key  键
	 * @param value 值
	 */
	public void put(String key,Object value)
	{
		writeLock.lock();
		//锁一定在try块之外
		try {
			cache.put(key, value);
		} 
		finally
		{
			writeLock.unlock();
		}
	}
	/**
	 * 获取数据
	 * @param key 键
	 * @return  值
	 */
	public Object get(String key)
	{
		readLock.lock();
		try {
			return cache.get(key);
		} 
		finally
		{
			readLock.unlock();
		}
	}

}
