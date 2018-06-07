package com.manage.sys.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *	表名：ll_sys_menu
 *  注释:菜单
 */
 
public class Sys_menu implements Serializable,Comparable<Sys_menu>{
	/**编号*/	
	private java.lang.Long id;
	/**菜单名*/	
	private java.lang.String menuname;
	/**菜单地址*/	
	private java.lang.String menuurl;
	/**菜单排序*/	
	private java.lang.Integer menusortno;
	/**父类菜单*/	
	private java.lang.Long menufatherid;
	/**菜单类型*/	
	private java.lang.Integer type;
	/**ico*/	
	private java.lang.String ico;
	/**是否显示:1是;2否*/	
	private java.lang.Integer isshow;
	private List<Sys_menu> children=new ArrayList<Sys_menu>();
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setMenuname(java.lang.String menuname){
		this.menuname=menuname;
	}
	public java.lang.String getMenuname(){
		return this.menuname;
	}
	public void setMenuurl(java.lang.String menuurl){
		this.menuurl=menuurl;
	}
	public java.lang.String getMenuurl(){
		return this.menuurl;
	}
	public void setMenusortno(java.lang.Integer menusortno){
		this.menusortno=menusortno;
	}
	public java.lang.Integer getMenusortno(){
		return this.menusortno;
	}
	public void setMenufatherid(java.lang.Long menufatherid){
		this.menufatherid=menufatherid;
	}
	public java.lang.Long getMenufatherid(){
		return this.menufatherid;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
	}
	public void setIco(java.lang.String ico){
		this.ico=ico;
	}
	public java.lang.String getIco(){
		return this.ico;
	}
	public void setIsshow(java.lang.Integer isshow){
		this.isshow=isshow;
	}
	public java.lang.Integer getIsshow(){
		return this.isshow;
	}
	public List<Sys_menu> getChildren() {
		return children;
	}
	public void setChildren(List<Sys_menu> children) {
		this.children = children;
	}
	public int compareTo(Sys_menu ll_sys_menu) {
        return this.getMenusortno().compareTo(ll_sys_menu.getMenusortno());
    }
	
	@Override
	public String toString() {
		return "Sys_menu [id=" + id + ", menuname=" + menuname + ", menuurl=" + menuurl + ", menusortno=" + menusortno + ", menufatherid=" + menufatherid + ", type=" + type + ", ico=" + ico
				+ ", isshow=" + isshow + ", children=" + children + "]";
	}
	
}
