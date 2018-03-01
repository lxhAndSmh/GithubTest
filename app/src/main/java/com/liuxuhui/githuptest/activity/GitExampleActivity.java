package com.liuxuhui.githuptest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liuxuhui.githuptest.R;

/**
 * Created by liuxuhui on 2018/2/26 16:07
 * git 命令行练习
 */
public class GitExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_example);
        //修改刚提交的错误代码 git commit --amend
        //git reset --hard [commit对应的SHA-1码]
    }

    /**
     * 修改之前提交的commit中的错误代码
     * 1.git rebase -i [commit前一个对应的SHA-1 码]
     * 2.在编辑界面将要修改的commit那一行中的pick改成edit，退出编辑界面
     * 3.修改代码，然后操作git add .    和git commit --amend
     * 4.git rebase --continue
     */
    private void amendCommit(){

    }

    /**
     * 撤销某一次的commit
     * 1.git rebase -i [要撤销的commit前一个commit对应的SHA-1 码]
     * 2.在编辑界面删掉要撤销的那行commit
     * 3.git rebase --continue
     */
    private void backoutCommit(){

    }

    /**
     * 撤销某一次的commit方式二
     * git rebase --onto 目标commit  起点commit 终点commit
     * 注意：rebase的时候会把目标commit（不包括目标commit自身）和起点commit（包括起点commit自身）之间的commit删除
     * 例如：git rebase --onto 第三个commit 第4个commit branch
     */
    private void rebaseOnto(){

    }
    //最后一次舍弃
    //git revert HEAD^
    /**
     * git stash 临时存放工作目录的改动
     * git stash pop
     * 注意：没有被track的文件（即从没被add过的文件不会被stash起来，因为Git会忽略它们。
     * 如果想把这些文件也一起stash，可以加上'-u'参数，它是'--include-untracked'的简写，
     * 如下：git stash -u）
     */

    //编辑器添加
    /**
     * git checkout的本质
     * git checkout branch名 的本质，其实是把HEAD指向指定的branch，然后签出这个branch所对应的commit的工作目录。
     * 所以同样的，checkout的目标也可以直接指定某个commit。（使用场景，切换一个指向某个指定的commit分支）
     * 例如：1.git checkout b6c149 则直接HEAD指向当前b6c149commit的分支
     *      2.git checkout -b 分支名
     */

}
