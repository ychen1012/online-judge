package cn.oj.onlinejudge.handler.gcchandler;

import cn.oj.onlinejudge.handler.base.CHandler;
import cn.oj.onlinejudge.util.ExecutorUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class GNUC99Handler extends CHandler {

	@Value("${judge.GNUC99}")
	private String compilerWord;

	@Override
	protected ExecutorUtil.ExecMessage HandlerCompiler(File path) {
		String cmd = compilerWord.replace("PATH",path.getPath());
		ExecutorUtil.ExecMessage msg = ExecutorUtil.exec(cmd, 1000);
		return msg;
	}
}