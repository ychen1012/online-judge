package cn.oj.onlinejudge.handler.base;

import cn.oj.onlinejudge.util.ExecutorUtil;
import cn.oj.onlinejudge.util.FileUtils;
import cn.oj.onlinejudge.vo.JudgeTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class Python3Handler extends Handler {
    @Value("$(python2 PATH/main.py)")
    private String python2RunCommand;

    @Override
    protected void createSrc(JudgeTask task, File path) throws IOException {
        File srcPath = new File(path, "main.py");
        FileUtils.write(task.getSrc(), srcPath);
    }

    @Override
    protected ExecutorUtil.ExecMessage HandlerCompiler(File path) {
        return new ExecutorUtil.ExecMessage();
    }

    @Override
    protected String getRunCommand(File path) {
        return python2RunCommand.replace("PATH", path.getPath());
    }
}
