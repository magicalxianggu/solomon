package com.magical.jwgl.command.domain;

/*
 * 登记分制
 */
public class TwoLevelMark extends Mark {

	private TwoLevelTypeEnum levelMark;

	@Override
	public TwoLevelTypeEnum getMark() {
		return levelMark;
	}

	public TwoLevelMark(TwoLevelTypeEnum levelMark){
		this.levelMark=levelMark;
	}
	
}
