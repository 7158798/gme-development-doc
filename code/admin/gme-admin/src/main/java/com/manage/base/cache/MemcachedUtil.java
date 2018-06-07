package com.manage.base.cache;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.manage.base.tag.Global;
import com.schooner.MemCached.MemcachedItem;

/**
 * 缓存帮助类
 */
public class MemcachedUtil {
	
	private static final Log log = LogFactory.getLog(MemcachedUtil.class);
	
	private static MemcachedUtil cacheUtil=null;
	private MemCachedClient client;
	
	private MemcachedUtil(){}
	
	public static MemcachedUtil getInstance() {
		if (null == cacheUtil) {
			synchronized(MemcachedUtil.class){
				if(null == cacheUtil){
					cacheUtil = new MemcachedUtil();
					cacheUtil.init();
				}
			}
		}
		return cacheUtil;
	}
	
	private void init(){
		try{
			String addr1 = Global.getConfig("m.cacheUrl").trim();
			String weights1 = Global.getConfig("m.cacheWeights").trim();
			String InitConn1 = Global.getConfig("m.cacheInitConn").trim();
			String MinConn1 = Global.getConfig("m.cacheMinConn").trim();
			String MaxConn1 = Global.getConfig("m.cacheMaxConn").trim();
			String MaxIdle1 = Global.getConfig("m.cacheMaxIdle").trim();
			String MaintSleep1 = Global.getConfig("m.cacheMaintSleep").trim();
			String Nagle1 = Global.getConfig("m.cacheNagle").trim();
			String SocketTO1 = Global.getConfig("m.cacheSocketTO").trim();
			String SocketConnectTO1 = Global.getConfig("m.cacheSocketConnectTO").trim();
			
			client = new MemCachedClient("poolName");
	        String [] addr = addr1.split(",");
	        
	        String [] temp1 = weights1.split(",");
	        Integer [] weights = new Integer[temp1.length];
	        for(int i = 0;i < temp1.length;i++){
	        	weights[i] = Integer.parseInt(temp1[i]);
	        }
	        
	        SockIOPool pool = SockIOPool.getInstance("poolName");
	        pool.setServers(addr);
	        pool.setWeights(weights);
	        pool.setInitConn(Integer.parseInt(InitConn1));
	        pool.setMinConn(Integer.parseInt(MinConn1));
	        pool.setMaxConn(Integer.parseInt(MaxConn1));
	        pool.setMaxIdle(Integer.parseInt(MaxIdle1));
	        pool.setMaintSleep(Long.parseLong(MaintSleep1));
	        pool.setNagle(Boolean.parseBoolean(Nagle1));
	        pool.setSocketTO(Integer.parseInt(SocketTO1));
	        pool.setSocketConnectTO(Integer.parseInt(SocketConnectTO1));
	        pool.initialize();
	        
	        if(client == null){
				throw new RuntimeException("缓存对象没有初始化成功。。。。。。。");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  放入缓存
	 * @param key key
	 * @param obj 对象
	 * @return
	 * @throws Exception
	 */
	public boolean putObject(String key,Object obj){
		if(check()){
			return client.set(key.toUpperCase(), obj);
		}
		return false;
	}
	
	/**
	 * 放入对象 多久后失效
	 * @param key key
	 * @param obj 对象
	 * @param date 时间
	 * @return
	 * @throws Exception
	 */
	public boolean putObject(String key,Object obj,Date date){
		if(check()){
			return client.set(key.toUpperCase(), obj,date);
		}
		return false;
	}
	
	/**
	 * 取出缓存中的对象
	 * @param key key
	 * @return
	 * @throws Exception
	 */
	public Object getObject(String key){
		if(check()){
			return client.get(key.toUpperCase());
		}
		return null;
	}
	
	/**
	 * 删除缓存中的对象
	 * @param key key
	 * @return
	 * @throws Exception
	 */
	public boolean deleObject(String key){
		if(check()){
			return client.delete(key.toUpperCase());
		}
		return false;
	}
	
	/**
	 * flush并不会将items删除，只是将所有的items标记为expired，因此这时memcache依旧占用所有内存
	 */
	public boolean flushAll(){
		client = new MemCachedClient();
		return client.flushAll();
	}
	
	/**
	 * 取出缓存中的获取原子性对象
	 * @param key key
	 * @return
	 * @throws Exception
	 */
	public MemcachedItem getCasObject(String key){
		if(check()){
			return client.gets(key.toUpperCase());
		}
		return null;
	}
	
	/**
	 *  放入原子性缓存
	 * @param key key
	 * @param obj 对象
	 * @return
	 * @throws Exception
	 */
	public boolean putCasObject(String key,Object obj,long cas){
		if(check()){
			return client.cas(key.toUpperCase(), obj, cas);
		}
		return false;
	}
	
	private boolean check(){
		if(client == null){
			log.error("缓存对象没有初始化成功。。。。。。。");
			return false;
		}
		return true;
	}
	
}
