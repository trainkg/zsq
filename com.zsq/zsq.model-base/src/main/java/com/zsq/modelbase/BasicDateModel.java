package com.zsq.modelbase;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 带有时间戳的基础模型 
 * @author peculiar.1@163.com
 * @version $ID: BasicDateModel.java, V1.0.0 2018年10月1日 上午11:17:32 $
 */
@Getter
@Setter
public class BasicDateModel extends BasicModel {
	private Date createTime;
	private Date updateTIme;
	private Long createBy;
	private Long updateBy;
}
