package com.manage.bus.entity;
import java.io.Serializable;
/**
 *	表名：g_currency
 *  注释:币种表（g_currency）
功能描述：存储币种信息。
 */
 
public class GCurrency implements Serializable{
	/**币种编号*/	
	private java.lang.String currency_id;
	/**顺序号，递增*/	
	private java.lang.Integer currency_sn;
	/**币种符号*/	
	private java.lang.String currency_symbol;
	/**币种描述*/	
	private java.lang.String currency_desc;
	/**币种图标*/	
	private java.lang.String icon_id;
	/**中文名*/	
	private java.lang.String name_cn;
	/**英文名*/	
	private java.lang.String name_en;
	/**启用日期*/	
	private java.sql.Timestamp enable_time;
	/**是否是媒介币0-不是;1-是;*/	
	private java.lang.Integer is_token;
	/**操作者编号*/	
	private java.lang.String operator_uid;
	/**操作者*/	
	private java.lang.String operator_name;
	/**提现配置编号；存储币种提现配置表（g_withdrawal_config）的config_id*/	
	private java.lang.String currency_config_id;
	/**充值/提现(0000四位)：00-前两位表示是否充值;00-后两位表示是否提现;其中01表示是;02表示否;*/	
	private java.lang.Integer is_open;
	/**1-启用(默认);2-冻结;*/	
	private java.lang.Integer is_enable;
	/**发行量*/	
	private java.math.BigDecimal supply;
	/**流通总量*/	
	private java.math.BigDecimal circulation;
	/**备注*/	
	private java.lang.String remark;
	/**数据表版本,默认1*/	
	private java.lang.Integer version;
	/**创建时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp create_time;
	/**更新时间格式:yyyy-MM-dd HH:ss:mm*/	
	private java.sql.Timestamp updated_time;
	
	public void setCurrency_id(java.lang.String currency_id){
		this.currency_id=currency_id;
	}
	public java.lang.String getCurrency_id(){
		return this.currency_id;
	}
	public void setCurrency_sn(java.lang.Integer currency_sn){
		this.currency_sn=currency_sn;
	}
	public java.lang.Integer getCurrency_sn(){
		return this.currency_sn;
	}
	public void setCurrency_symbol(java.lang.String currency_symbol){
		this.currency_symbol=currency_symbol;
	}
	public java.lang.String getCurrency_symbol(){
		return this.currency_symbol;
	}
	public void setCurrency_desc(java.lang.String currency_desc){
		this.currency_desc=currency_desc;
	}
	public java.lang.String getCurrency_desc(){
		return this.currency_desc;
	}
	public void setIcon_id(java.lang.String icon_id){
		this.icon_id=icon_id;
	}
	public java.lang.String getIcon_id(){
		return this.icon_id;
	}
	public void setName_cn(java.lang.String name_cn){
		this.name_cn=name_cn;
	}
	public java.lang.String getName_cn(){
		return this.name_cn;
	}
	public void setName_en(java.lang.String name_en){
		this.name_en=name_en;
	}
	public java.lang.String getName_en(){
		return this.name_en;
	}
	public void setEnable_time(java.sql.Timestamp enable_time){
		this.enable_time=enable_time;
	}
	public java.sql.Timestamp getEnable_time(){
		return this.enable_time;
	}
	public void setOperator_uid(java.lang.String operator_uid){
		this.operator_uid=operator_uid;
	}
	public java.lang.String getOperator_uid(){
		return this.operator_uid;
	}
	public void setOperator_name(java.lang.String operator_name){
		this.operator_name=operator_name;
	}
	public java.lang.String getOperator_name(){
		return this.operator_name;
	}
	public void setCurrency_config_id(java.lang.String currency_config_id){
		this.currency_config_id=currency_config_id;
	}
	public java.lang.String getCurrency_config_id(){
		return this.currency_config_id;
	}
	public void setIs_open(java.lang.Integer is_open){
		this.is_open=is_open;
	}
	public java.lang.Integer getIs_open(){
		return this.is_open;
	}
	public void setSupply(java.math.BigDecimal supply){
		this.supply=supply;
	}
	public java.math.BigDecimal getSupply(){
		return this.supply;
	}
	public void setCirculation(java.math.BigDecimal circulation){
		this.circulation=circulation;
	}
	public java.math.BigDecimal getCirculation(){
		return this.circulation;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return this.remark;
	}
	public void setVersion(java.lang.Integer version){
		this.version=version;
	}
	public java.lang.Integer getVersion(){
		return this.version;
	}
	public void setCreate_time(java.sql.Timestamp create_time){
		this.create_time=create_time;
	}
	public java.sql.Timestamp getCreate_time(){
		return this.create_time;
	}
	public void setUpdated_time(java.sql.Timestamp updated_time){
		this.updated_time=updated_time;
	}
	public java.sql.Timestamp getUpdated_time(){
		return this.updated_time;
	}
	/**  
	 * 获取is_token  
	 * @return is_token is_token  
	 */
	public java.lang.Integer getIs_token() {
		return is_token;
	}
	/**  
	 * 设置is_token  
	 * @param is_token is_token  
	 */
	public void setIs_token(java.lang.Integer is_token) {
		this.is_token = is_token;
	}
	/**  
	 * 获取is_enable  
	 * @return is_enable is_enable  
	 */
	public java.lang.Integer getIs_enable() {
		return is_enable;
	}
	/**  
	 * 设置is_enable  
	 * @param is_enable is_enable  
	 */
	public void setIs_enable(java.lang.Integer is_enable) {
		this.is_enable = is_enable;
	}
	
}
