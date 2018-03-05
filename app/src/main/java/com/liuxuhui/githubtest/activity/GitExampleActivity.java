package com.liuxuhui.githubtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liuxuhui.githubtest.R;

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

    /**g
     * 代码已经push上去了才发现写错
     * git revert 希望撤销的commit
     * 就可以把远程仓库写错的commit撤销了（该命令执行后，会生成一个新的commit）
     */

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

    /**
     * git cherry-pick 把选中的其它分支的commits合并到当前分支
     * git cherry-pick <commit id> 单独合并某一个提交
     * git cherry-pick -x <commit id> 单独合并某一个提交（同上，不同点：保留了原提交者的信息）
     * git cherry-pick <start-commit-id>..<end-commit-id> 合并此区间的commits（左开右闭，不包含start-commit-id）到当前分支
     * git cherry-pick <start-commit-id>^..<end-commit-id> 合并此区间的commits（左闭右闭）到当前分支
     * 注：有冲突解决冲突
     */

    /**
     * vim 文件路径  用编辑器打开某个文件
     */

    /**
     * Git如何切换远程仓库的地址
     * 1.修改命令：git remote set-url origin url
     * 2.先删后加：
     * git remote rm origin
     * git remote add origin url
     * 3.修改config文件：
     * 在项目的根目录下，查看隐藏的文件夹，找到.git文件夹下的config文件，就可以修改其中的git remote origin地址了
     */

    /**
     * 合并分支git rebase的使用
     * 使用merge之后，commit历史就会出现分叉，如果不希望commit历史出现分叉，可以使用rebase代替merge
     * rebase  是在新位置重新提交
     * 例如：将develop分支合并到master分支
     * 1.git checkout develop（确保当前分支是develop，是的话就不需要此次切换）
     * 2.git rebase master
     * 3.git checkout master(切换到master分支)
     * 4.git merge develop(把master移到最新的commit)
     */

    //回滚单一文件

    /**
     * 合并分支git merge的使用
     * 例如：将develop分支合并到master分支
     * 1.git checkout master 切换到master分支
     * 2.git merge develop （默认情况下，Git执行“快进式合并”（fast-farwardmerge），会直接将master分支指向develop分支）；
     * 建议使用git merge develop --no-ff,这样会在执行正常合并后，并在master分支上生成一个新的节点，为了保证版本演进的清晰，建议使用这种做法。
     *
     */
}
