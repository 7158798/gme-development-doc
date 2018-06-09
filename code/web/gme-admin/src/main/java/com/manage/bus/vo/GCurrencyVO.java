package com.manage.bus.vo;


import java.io.Serializable;
import java.util.Date;

import com.manage.base.entity.BaseVO;

/**
* 币种表（g_currency）
功能描述：存储币种信息。查询bean
*/
public class GCurrencyVO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 币种符号
	 */
	private String currency_symbol;
	/**
	 * 是否是媒介币 0不是-1是
	 */
	private Integer is_token;
	/**
	 * 充值/提现 充值/提现(0000四位)：00-前两位表示是否充值;00-后两位表示是否提现;其中01表示是;02表示否;
	 */
	private String is_open;
	/**
	 * 启用/冻结 1启用-2冻结
	 */
	private Integer is_enable;
	/**
	 * 启用开始时间
	 */
	private Date bg_create_date; 
	/**
	 * 启用结束时间
	 */
	private Date end_create_date;
	public String getCurrency_symbol() {
		return currency_symbol;
	}
	public void setCurrency_symbol(String currency_symbol) {
		this.currency_symbol = currency_symbol;
	}
	public Integer getIs_token() {
		return is_token;
	}
	public void setIs_token(Integer is_token) {
		this.is_token = is_token;
	}
	public String getIs_open() {
		return is_open;
	}
	public void setIs_open(String is_open) {
		this.is_open = is_open;
	}
	public Integer getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(Integer is_enable) {
		this.is_enable = is_enable;
	}
	public Date getBg_create_date() {
		return bg_create_date;
	}
	public void setBg_create_date(Date bg_create_date) {
		this.bg_create_date = bg_create_date;
	}
	public Date getEnd_create_date() {
		return end_create_date;
	}
	public void setEnd_create_date(Date end_create_date) {
		this.end_create_date = end_create_date;
	}
	
}
