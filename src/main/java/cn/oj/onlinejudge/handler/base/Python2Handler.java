package cn.oj.onlinejudge.handler.base;

import cn.oj.onlinejudge.util.ExecutorUtil;
import cn.oj.onlinejudge.util.FileUtils;
import cn.oj.onlinejudge.vo.JudgeTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class Python2Handler extends Handler {
    /*
    用PATH做为占位符，最终调用String.replace进行替换;
    * */


    @Value("$(python3 PATH/main.py)")
    private String python3RunCommand;

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
        return python3RunCommand.replace("PATH", path.getPath());
    }
}
