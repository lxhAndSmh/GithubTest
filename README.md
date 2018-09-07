1.配置仓库信息
git config 为仓库配置相关信息
配置本机的用户名和Email地址
git config -global user.name "your github account"
git config -global user.email "email@example.com"
git config -L 显示配置信息

2.创建分支：
git branch <分支名> 创建一个全新的本地分支，但依然停留在当前分支，需再使用git checkout <分支名>切换到新建的分支
git checkout -b minedevelop<分支名> 创建自己的本地分支，并切换到该分支

3.切换分支
git checkout <分支名> 切换分支前先git fetch将远程更新到本地仓库（没有git fetch的话会有问题）
切换分支的正常流程：git add .  ->  git commit -a -m""  ->  git fetch  ->  git checkout <分支名>

4.分支合并
如果将开发中的分支(develop>，合并到稳定分支(master)，
首先切换到master分支：git checkout master
然后执行合并操作：git merge develop
如果有冲突，会提示你调用git status查看冲突文件
解决冲突后，然后调用git add .和git commit -a -m""提交更改
放弃解决冲突，取消 merge，如果你最终决定放弃这次 merge，也需要执行一次 merge --abort 来手动取消它：
git merge --abort

5.删除分支
git branch -d<分支名> 如果该分支没有合并到主分支会报错(删除的本地仓库)
git branch -D<分支名> 强制删除(删除的本地仓库)
git branch -d -r<分支名> 删除远程分支
把远程的分支删除：
git push origin --delete <branchName>
（ 删除远程分支
$ git push origin --delete <branch-name>
git push origin -d <remote/branch>） # 用 -d 参数把远程仓库的 branch 也删了

6.查看分支
git branch 列出本地已经存在的分支，并且在当前的分支前面加"*"号标记
git branch -r列出远程分支
git branch -a列出本地分支和远程分支

7.重命名分支
git branch -m | -M oldbranch newbranch 如果newbranch名字分支已经存在，则需要使用-M强制重命名，否则，使用-m进行重命名

8.版本回退
git reset HEAD^或git reset HEAD~1 撤销最后一次提交
git reset --hard HEAD^ 撤销最后一次提交并清除本地修改
在Git中，HEAD表示当前版本，就是最新提交的版本，即使用git log打印出来的位于第一位的版本，上一个版本就是HEAD^，上上个版本就是HEAD^^，
当前向上100个可以写成HEAD~100。当然，还有一种方式就是直接使用commit id来代替HEAD^，比如版本号是cadab353589f3eef075817b890dafe8b722d802b，
那么就可以直接使用命令：
$ git reset --hard cadab353589f 使用前几位表示即可，git会自动查找(回退到此commit id，此commit还存在)
注：版本回退以后，使用git log打印的历史记录都是回退版本之前的数据，之后的都没有了，不过放心，git总有后悔药可以吃哒~
1.如果命令行窗口没有关闭，直接去前面找commit id即可；
2.如果命令行窗口关闭了，或者第二天后悔了，可以进入到该目录下，
使用git reflog命令来查看以前的每一次命令，可以获得每次提交的commitid，就可以版本回退了。
$ git reflog   可以查看命令历史，包含提交的commit id

9.正确的提交流程
git stash 备份当前工作内容保存到git栈中
git pull 更新代码
git stash pop 从git栈中读取最近一次保存的内容，回复工作区的相关内容
如果有冲突就提交解决冲突
git add . 添加所有的文件、文件夹
git commit -a -m"" 提交本次事务，即将add的文件提交到git仓库，引号内部表示本次提交的提示信息
git push 提交到远程

10.git status 显示提交的状态：已经添加，等待提交事务的文件(绿色字体表示)；已经改变但是没有添加(not staged)的文件(红色字体表示)

11.git commit --verbose 列出diff的结果

12.git log 打印历史记录

13.查询该文件和git仓库中的文件的区别，即做了什么修改
git diff <文件全称> 如果已经add了，就打印不出有什么修改了，这一步骤应该在add之前，即添加之前可以用来看看做了什么修改。

14.忽略文件
有一些文件并不能上传到git上。
①.Android Studio自动生成配置文件：不能上传到git上，否则的话，如果你的同事下载下来，但是它的studio(gradle)版本和你的不一样，
或者其他配置的各种路径不一样，就需要重建项目，严重的话，根本无法重建项目，一片爆红！网上的方法也解决不了。
②.保存了数据库密码或者什么不能上传的文件；
。。。
所以需要在项目的根目录下创建一个名称为.gitignore文件，然后把要忽略的文件名填进去，Git就会自动忽略这些文件。
不需要从头写.gitignore文件，GitHub已经为我们准备了各种配置文件，只需要组合一下就可以使用了。

忽略文件的原则：
①.忽略操作系统自动生成的文件，比如缩略图等；
②.忽略编译生成的中间文件、可执行文件等，也就是如果一个文件是通过另一个文件自动生成的，那自动生成的文件就没必要放进版本库，
比如Java编译产生的.class文件；
③.忽略你自己的带有敏感信息的配置文件，比如存放口令的配置文件。

15.无法commit时：
因为你已经提交一了一个commit，该进程卡在这里了，所以无法继续提交。
rm -f ./.git/index.lock 命令，结束该进程。

16.删除仓库中的文件夹(忽略已经提交的文件)
git rm  -r  --cached  加文件名

17.建立追踪关系，在现有分支与指定的远程分支之间
$ git branch --set-upstream [branch] [remote-branch]


18.打标签
标签可以针对某一时间点的版本做标记，常用于版本发布。

列出标签
$ Git tag # 在控制台打印出当前仓库的所有标签
$ git tag -l ‘v0.1.*’ # 搜索符合模式的标签

打标签
git标签分为两种类型：轻量标签和附注标签。轻量标签是指向提交对象的引用，附注标签则是仓库中的一个独立对象。建议使用附注标签。
# 创建轻量标签
$ git tag v0.1.2-light

# 创建附注标签
$ git tag -a v0.1.2 -m “0.1.2版本”

创建轻量标签不需要传递参数，直接指定标签名称即可。
创建附注标签时，参数a即annotated的缩写，指定标签类型，后附标签名。参数m指定标签说明，说明信息会保存在标签对象中。

切换到标签
与切换分支命令相同，用git checkout -b [一个新分支] [tagname]
查看标签信息
用git show命令可以查看标签的版本信息：
$ git show v0.1.2

删除标签
误打或需要修改标签时，需要先将标签删除，再打新标签。
$ git tag -d v0.1.2 # 删除标签

参数d即delete的缩写，意为删除其后指定的标签。

给指定的commit打标签
打标签不必要在head之上，也可在之前的版本上打，这需要你知道某个提交对象的校验和（通过git log获取）。
# 补打标签
$ git tag -a v0.1.1 9fbc3d0

标签发布
通常的git push不会将标签对象提交到git服务器，我们需要进行显式的操作：
$ git push origin v0.1.2 # 将v0.1.2标签提交到git服务器
$ git push origin –tags # 将本地所有标签一次性提交到git服务器


19.checkout TAG的内容
git checkout -b 分支名 tag名

    注意：如果想看之前某个标签状态下的文件，可以这样操作

    1.git tag   查看当前分支下的标签

    2.git  checkout v0.21   此时会指向打v0.21标签时的代码状态，（但现在处于一个空的分支上）

    3. cat  test.txt   查看某个文件

20.git commit -m 发现提示
Another git process seems to be running in this repository, e.g.
an editor opened by 'git commit'. Please make sure all processes
are terminated then try again. If it still fails, a git process
may have crashed in this repository earlier:
remove the file manually to continue.

大致意思就是你已经提交一了一个commit，该进程卡在这里了，所以无法继续提交。
使用$ rm -f ./.git/index.lock 命令，结束该进程。即可继续提交。

21.关联一个本地仓库到远程仓库
    1.git  init 初始化本地仓库
    2.git remote add origin https://git（远程仓库的地址）


22.一些常用的git高级命令
    /**
     * 修改之前提交的commit中的错误代码
     * 1.git rebase -i [commit前一个对应的SHA-1 码]
     * 2.在编辑界面将要修改的commit那一行中的pick改成edit，退出编辑界面
     * 3.修改代码，然后操作git add .    和git commit --amend
     * 4.git rebase --continue
     */


    /**
     * 撤销某一次的commit
     * 1.git rebase -i [要撤销的commit前一个commit对应的SHA-1 码]
     * 2.在编辑界面删掉要撤销的那行commit(shift + i键，进入插入模式)
     * 3.按esc键退出插入模式，回归命令模式，shift + ZZ退出编辑模式
     * 4.git rebase --continue
     */

    /**
     * 撤销某一次的commit方式二
     * git rebase --onto 目标commit  起点commit 终点commit
     * 注意：rebase的时候会把目标commit（不包括目标commit自身）和起点commit（包括起点commit自身）之间的commit删除
     * 例如：git rebase --onto 第三个commit 第4个commit branch
     */


    /**
     * 代码已经push上去了才发现写错
     * git revert 希望撤销的commit
     * 就可以把远程仓库写错的commit撤销了（该命令执行后，会生成一个新的commit）
     */

    /**
     * 代码已经push上去了才发现写错
     * 希望撤销的多个commit
     * git reset -hard 希望回退到的commitid
     * git push origin 分支名 -force
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

     /**
      * git remote show origin 查看remote地址，远程地址，还有本地分支与之相对应关系等信息
      * git remote prune origin 删除那些远程仓库已经不存在，但使用git branch -a 仍可以看到的分支了。
      */

    /**
      * 如何让单个文件回退到指定的版本
      * 1.进入到文件所在文件目录，或者能找到文件的路径
      * 2.git reset a4e215234aa4927c85693dca7b68e9976948a35e MainActivity.java
      * 3.提交到本地git commit -m ""
      * 4.push到远程
      */