package cn.oj.onlinejudge.service;

import cn.oj.onlinejudge.handler.base.Handler;
import cn.oj.onlinejudge.handler.gcchandler.GNUC11Handler;
import cn.oj.onlinejudge.handler.gcchandler.GNUC90Handler;
import cn.oj.onlinejudge.handler.gcchandler.GNUC99Handler;
import cn.oj.onlinejudge.vo.JudgeResult;
import cn.oj.onlinejudge.vo.JudgeTask;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class JudgeService {

	@Autowired
	private GNUC90Handler gnuc90Handler;

	@Autowired
	private GNUC99Handler gnuc99Handler;

	@Autowired
	private GNUC11Handler gnuc11Handler;


	public JudgeResult judge(JudgeTask task) {
		long start = System.currentTimeMillis();
		log.info("=========开始判题=========");
		JudgeResult result;
		if (task.getJudgeId() == null || task.getJudgeId() < 1 || task.getJudgeId() > 3) {
			result = new JudgeResult("编译选项有误!",null);
		} else {
			Handler handler;
			switch (task.getJudgeId()){
				case 1:handler = gnuc90Handler;break;
				case 2:handler = gnuc99Handler;break;
				case 3:handler = gnuc11Handler;break;
				default:
					handler = gnuc90Handler;
			}
			result = handler.judge(task);
		}
		log.info("=========结束判题：" + result + "=========");
		log.info("=========判题耗时：" + (System.currentTimeMillis() - start) / 1000 + " secends !=========");
		return result;
	}
}
