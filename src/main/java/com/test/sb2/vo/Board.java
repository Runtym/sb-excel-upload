package com.test.sb2.vo;

import lombok.Data;

@Data
public class Board {
	private String boardNum;
	private String boardType;
	private String boardTitle;
	private String boardComment;
	private String creator;
	private String createTime;
	private String modifier;
	private String modifiedTime;
}
