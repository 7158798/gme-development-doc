package com.manage.sysConfig;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 * 系统配置文件
 * @author Administrator
 */
public class SysConfig {
	private static SysConfig config = null;
	
	//每页显示的条数(用于分页)  
	private Integer pageNumber;
	//每批次插入的数量
	private Integer batchNumber;
	//是否加载缓存 1是 0否
	private Integer isCache;
	//资金密码混淆字段
	private String moneyPwd;
	//登录密码混淆字段
	private String loginPwd;
	//扣费机制 
	private Integer orderType;
	//手续费
	private BigDecimal feeMoney;
	//显示条数
	private Integer showCount;
	//最低充值金额
	private BigDecimal minMoney;
	//最高充值金额
	private BigDecimal maxMoney;
	//key超时
	private Integer redisTimeOut;
	//长度基数个数
	private Integer widthCount;
	//首页显示条数
	private Integer indexShowCount;
	//交易页面显示
	private Integer tradeShowCount;
	//市场页面显示条数
	private Integer marketShowCount;
	//coinInfo超时时间 单位(秒)
	private Integer coinInfoTimeOut;
	//集市订单手续费  买家
	private BigDecimal orderDeposit;
	//集市订单手续费   卖家
	private BigDecimal sellOrderDeposit;
	//用户中心API
	private String userCenterAPI;
	
	//点对点交易浮动价格浮动比例 
	private BigDecimal floatBi;
	
	private Integer marketOpens;
	//usdt价
	private BigDecimal usdt;
	//身份认证后赠送GPC数量
	private BigDecimal auth_gpcnum;
	//身份认证后推送人赠送GPC数量
	private BigDecimal ref_gpcnum;
	
	public BigDecimal getUsdt() {
		return usdt;
	}
	public void setUsdt(BigDecimal usdt) {
		this.usdt = usdt;
	}

		//后台二维码访问地址
		private String mangerPath;
	
	public Integer getMarketOpens() {
		return marketOpens;
	}
	public void setMarketOpens(Integer marketOpens) {
		this.marketOpens = marketOpens;
	}

	public String getUserCenterAPI() {
		return userCenterAPI;
	}
	public void setUserCenterAPI(String userCenterAPI) {
		this.userCenterAPI = userCenterAPI;
	}

	private String coinPut;
	
	public String getCoinPut() {
		return coinPut;
	}
	public void setCoinPut(String coinPut) {
		this.coinPut = coinPut;
	}
	public BigDecimal getFloatBi() {
		return floatBi;
	}
	public void setFloatBi(BigDecimal floatBi) {
		this.floatBi = floatBi;
	}
	public Integer getCoinInfoTimeOut() {
		return coinInfoTimeOut;
	}
	public void setCoinInfoTimeOut(Integer coinInfoTimeOut) {
		this.coinInfoTimeOut = coinInfoTimeOut;
	}
	public Integer getTradeShowCount() {
		return tradeShowCount;
	}
	public void setTradeShowCount(Integer tradeShowCount) {
		this.tradeShowCount = tradeShowCount;
	}
	public Integer getMarketShowCount() {
		return marketShowCount;
	}
	public void setMarketShowCount(Integer marketShowCount) {
		this.marketShowCount = marketShowCount;
	}
	public Integer getIndexShowCount() {
		return indexShowCount;
	}
	public void setIndexShowCount(Integer indexShowCount) {
		this.indexShowCount = indexShowCount;
	}
	public Integer getWidthCount() {
		return widthCount;
	}
	public void setWidthCount(Integer widthCount) {
		this.widthCount = widthCount;
	}
	public Integer getRedisTimeOut() {
		return redisTimeOut;
	}
	public void setRedisTimeOut(Integer redisTimeOut) {
		this.redisTimeOut = redisTimeOut;
	}
	public BigDecimal getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(BigDecimal minMoney) {
		this.minMoney = minMoney;
	}
	public BigDecimal getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(BigDecimal maxMoney) {
		this.maxMoney = maxMoney;
	}
	public Integer getShowCount() {
		return showCount;
	}
	public void setShowCount(Integer showCount) {
		this.showCount = showCount;
	}
	public BigDecimal getFeeMoney() {
		return feeMoney;
	}
	public void setFeeMoney(BigDecimal feeMoney) {
		this.feeMoney = feeMoney;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
	public BigDecimal getOrderDeposit() {
		return orderDeposit;
	}
	public void setOrderDeposit(BigDecimal orderDeposit) {
		this.orderDeposit = orderDeposit;
	}
	
	public BigDecimal getSellOrderDeposit() {
		return sellOrderDeposit;
	}
	public void setSellOrderDeposit(BigDecimal sellOrderDeposit) {
		this.sellOrderDeposit = sellOrderDeposit;
	}

	//redis服务器地址
	private String redisIp;
	//redis服务端口
	private Integer port;
	//超时时间
	private Integer timeout;
	//redis密码
	private String password;
	//最大连接数  -1表示不限制
	private Integer maxWaitMillis;
	//最大允许空闲连接数
	private Integer maxIdle;
	//最小允许空闲连接数
	private Integer minIdle;
	//最大等待时间  单位ms
	private Long maxWait;
	//使用连接时，检测连接是否成功
	private Boolean testOnBorrow;
	//返回连接时，检测连接是否成功
	private Boolean testOnReturn;
	private Boolean testWhileIdle;
	//此redis服务的名字
	private String redisName;
	//最大分配对象
	private Integer maxTotal;
	//app混淆字符窜
	private String appPwd; 
	
	public Integer getMaxTotal() {
		return maxTotal;
	}
	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}
	public String getMoneyPwd() {
		return moneyPwd;
	}
	public void setMoneyPwd(String moneyPwd) {
		this.moneyPwd = moneyPwd;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public String getRedisName() {
		return redisName;
	}
	public void setRedisName(String redisName) {
		this.redisName = redisName;
	}
	public Integer getMaxWaitMillis() {
		return maxWaitMillis;
	}
	public void setMaxWaitMillis(Integer maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}
	public Boolean getTestWhileIdle() {
		return testWhileIdle;
	}
	public void setTestWhileIdle(Boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	public String getRedisIp() {
		return redisIp;
	}
	public void setRedisIp(String redisIp) {
		this.redisIp = redisIp;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	public Integer getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}
	public Long getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(Long maxWait) {
		this.maxWait = maxWait;
	}
	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(Boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public Boolean getTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(Boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public Integer getIsCache() {
		return isCache;
	}
	public void setIsCache(Integer isCache) {
		this.isCache = isCache;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(Integer batchNumber) {
		this.batchNumber = batchNumber;
	}
	public static void setConfig(SysConfig config) {
		SysConfig.config = config;
	}
	//缓存服务器配置
	
	private SysConfig(){
		initConfig();
	}
	public String getAppPwd() {
		return appPwd;
	}
	public void setAppPwd(String appPwd) {
		this.appPwd = appPwd;
	}
	
	
	public BigDecimal getAuth_gpcnum() {
		return auth_gpcnum;
	}
	public void setAuth_gpcnum(BigDecimal auth_gpcnum) {
		this.auth_gpcnum = auth_gpcnum;
	}
	public BigDecimal getRef_gpcnum() {
		return ref_gpcnum;
	}
	public void setRef_gpcnum(BigDecimal ref_gpcnum) {
		this.ref_gpcnum = ref_gpcnum;
	}
	public String getMangerPath() {
		return mangerPath;
	}
	public void setMangerPath(String mangerPath) {
		this.mangerPath = mangerPath;
	}
	public static SysConfig getConfig(){
		if(config == null){
			synchronized(SysConfig.class){
				if(config == null){
					config = new SysConfig();
				}
			}
		}
		return config;
	}
	public void initConfig(){
		readConfigFile();
	}
	//读取系统配置文件
	private void readConfigFile(){
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(SysConfig.class.getResource("/com/manage/sysConfig/SysConfig.xml"));
			if(doc == null) return ;			
			//系统配置
			pageNumber=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/pageNumber").getText()));
			batchNumber=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/batchNumber").getText()));
			isCache=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/isCache").getText()));
			orderType=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/orderType").getText()));
			feeMoney=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/feeMoney").getText()));
			redisTimeOut=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/redisTimeOut").getText()));
			widthCount=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/widthCount").getText()));
			indexShowCount=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/indexShowCount").getText()));
			tradeShowCount=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/tradeShowCount").getText()));
			marketShowCount=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/marketShowCount").getText()));
			loginPwd=StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/loginPwd").getText());
			moneyPwd=StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/moneyPwd").getText());
			showCount=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/showCount").getText()));
			minMoney=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/minMoney").getText()));
			maxMoney=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/maxMoney").getText()));
			coinInfoTimeOut=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/coinInfoTimeOut").getText()));
			orderDeposit=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/orderDeposit").getText()));
			sellOrderDeposit=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/sellOrderDeposit").getText()));
			floatBi=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/floatBi").getText()));
			coinPut=StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/coinPut").getText());
			marketOpens=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/marketOpens").getText()));
			
			auth_gpcnum=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/auth_gpcnum").getText()));
			ref_gpcnum=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/ref_gpcnum").getText()));
			
			//redis缓存服务器配置
			redisIp=StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/redisIp").getText());
			port=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/port").getText()));
			timeout=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/timeout").getText()));
			password=StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/password").getText());
			maxWaitMillis=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/pool/maxWaitMillis").getText()));
			maxIdle=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/pool/maxIdle").getText()));
			minIdle=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/pool/minIdle").getText()));
			testOnBorrow=Boolean.parseBoolean(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/pool/testOnBorrow").getText()));
			testOnReturn=Boolean.parseBoolean(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/pool/testOnReturn").getText()));
			testWhileIdle=Boolean.parseBoolean(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/pool/testWhileIdle").getText()));
			redisName=StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/redisName").getText());
			maxTotal=Integer.parseInt(StringUtils.trimToEmpty(doc.selectSingleNode("sys/redis/pool/maxTotal").getText()));
			mangerPath = StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/mangerPath").getText());
			usdt=new BigDecimal(StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/usdt").getText()));
			userCenterAPI = StringUtils.trimToEmpty(doc.selectSingleNode("sys/sysconfig/userCenterAPI").getText());
		} catch (Exception e) {
			throw new RuntimeException("配置文件sysConfig.xml错误",e);
		}
	}
	
}
