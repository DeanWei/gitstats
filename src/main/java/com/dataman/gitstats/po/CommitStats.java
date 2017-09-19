package com.dataman.gitstats.po;

import org.gitlab4j.api.models.Commit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName: Commit 补充统计
 * @Description: commit 补充统计 
 * @author liuqing 
 * @date 2017年9月19日 上午10:37:50 
 * @Copyright © 2017北京数人科技有限公司
 */
@Document
public class CommitStats extends Commit{
	
	@Id
	String _id; //从 gitlab 中读出来
	int addRow; //添加行数
	int removeRow; //删除行数
	String projectName;

	public String get_id() {
		return super.getId();
	}

	public void set_id(String _id) {
		super.setId(_id);
	}

	public int getAddRow() {
		return addRow;
	}

	public void setAddRow(int addRow) {
		this.addRow = addRow;
	}

	public int getRemoveRow() {
		return removeRow;
	}

	public void setRemoveRow(int removeRow) {
		this.removeRow = removeRow;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
