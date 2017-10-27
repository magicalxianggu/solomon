package com.magical.jwgl.command.domain;

/*
 * 百分制
 */
public class HundredMark extends Mark {
	private Float mark;

	@Override
	public Float getMark() {
		return this.mark;
	}

	public HundredMark(Float mark) throws Exception{
		if(mark<0f || mark>100f){
			throw new Exception("百分制格式不正确！");
		}
		this.mark=mark;
	}
}
