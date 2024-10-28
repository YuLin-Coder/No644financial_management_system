package com.orm;

public class TGongzi
{
	private int id;
	private int zhigong_id;
	private double jiben;
	private double gongling;
	private double zhiwu;
	private double butie;
	
	private TZhigong zgxx;
	private double hj;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getZhigong_id() {
		return zhigong_id;
	}
	public void setZhigong_id(int zhigong_id) {
		this.zhigong_id = zhigong_id;
	}
	public double getJiben() {
		return jiben;
	}
	public void setJiben(double jiben) {
		this.jiben = jiben;
	}
	public double getGongling() {
		return gongling;
	}
	public void setGongling(double gongling) {
		this.gongling = gongling;
	}
	public double getZhiwu() {
		return zhiwu;
	}
	public void setZhiwu(double zhiwu) {
		this.zhiwu = zhiwu;
	}
	public double getButie() {
		return butie;
	}
	public void setButie(double butie) {
		this.butie = butie;
	}
	public TZhigong getZgxx() {
		return zgxx;
	}
	public void setZgxx(TZhigong zgxx) {
		this.zgxx = zgxx;
	}
	public double getHj() {
		return hj;
	}
	public void setHj(double hj) {
		this.hj = hj;
	}
}
