package cn.oj.onlinejudge.handler.base;

import cn.oj.onlinejudge.util.ExecutorUtil;
import cn.oj.onlinejudge.util.FileUtils;
import cn.oj.onlinejudge.vo.JudgeTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class JavaHandler extends Handler {

    /*
     * PATH作为标记，实际运行中听过String.replace（）替换掉PATH
     *
     * */
    @Value("${judge.Javaword}")
    private String javaCompileCommand;

    @Value("${judge.Javarun}")
    private String javaRunCommand;

    @Override
    protected void createSrc(JudgeTask task, File path) throws IOException {
        File srcPath = new File(path, "main.java");
        FileUtils.write(task.getSrc(), srcPath);
    }

    @Override
    protected ExecutorUtil.ExecMessage HandlerCompiler(File path) {
        String realCommandCommand = javaCompileCommand.replace("PATH", path.getPath());
        ExecutorUtil.ExecMessage msg = ExecutorUtil.exec(realCommandCommand, 1000);
        return msg;
    }

    @Override
    protected String getRunCommand(File path) {
        return javaRunCommand.replace("PATH", path.getPath());
    }
}
