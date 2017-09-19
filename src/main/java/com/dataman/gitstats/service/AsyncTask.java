package com.dataman.gitstats.service;

import java.util.List;
import java.util.concurrent.Future;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Comment;
import org.gitlab4j.api.models.Commit;
import org.gitlab4j.api.models.Diff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.dataman.gitstats.po.CommitStats;
import com.dataman.gitstats.po.ProjectStats;
import com.dataman.gitstats.repository.CommitStatsRepository;
import com.dataman.gitstats.repository.ProjectRepository;


@Component
public class AsyncTask {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GitLabApi gitLabApi;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	CommitStatsRepository commitStatsRepository;
	
	
	/**
	 * @method initProjectStats(初始化数据)
	 * @return String
	 * @author liuqing
	 * @throws GitLabApiException 
	 * @date 2017年9月19日 下午4:31:20
	 */
	@Async  
	public Future<String> initProjectStats(ProjectStats prostats) throws GitLabApiException{
		long begin = System.currentTimeMillis();
		int row=0,addRow=0,removeRow=0,commits=0;
		int projectId= prostats.getProId();
		String sha= prostats.getSha();
		//获取当前版本所有的commit
		List<Commit> list= gitLabApi.getCommitsApi().getCommits(projectId);
		//遍历统计add 和　remove
		for (Commit commit : list) {
			int a=0,r=0,t=0;
			CommitStats cs=new CommitStats();
			
			List<Diff> diffs= gitLabApi.getCommitsApi().getDiff(projectId, commit.getId());
		}
		
		
		
		//修改初始化状态　和　修改统计数据
		prostats.setTotalCommit(commits);
		prostats.setTotalRemove(removeRow);
		prostats.setTotalAdd(addRow);
		prostats.setTotalRow(addRow-removeRow);
		
		long end = System.currentTimeMillis();
		return new AsyncResult<String>("初始化完成");  
	}
	
	
}
