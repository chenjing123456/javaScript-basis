#linux

##day01

1.命令
  
  * history 查看历史命令(所写过的历史命令)
  * ls 列出当前目录所有可见文件以及目录
  * pwd 打印当前所在目录
  * / 根目录
  * ~ 表示当前用户下的家目录 /home/briup
  * /home 表示所有用户的家目录 /home
  * cd [目录] 切换目录
  
      * .当前目录
      * ..上一级目录
      * ~ 当前用户的家目录： /home/briup
      * /根目录
      * cd  默认进入到当前用户的家目录 /home/briup
      * cd ./aaa 进入当前目录下的aaa(相对路径)
      
  * !1043 运行 历史命令行中的第1043个命令
  * clear 清屏
  * more 预览文本文件 (more /etc/passwd)
  * tail 预览文本文件，默认预览后十行
  * poweroff关机
  * reboot 重启
  * ls -l /etc/passwd (-l 表示以长格式列出文件) -rw--xr--r(用户权限 用户同组人权限 其他用户权限)

2.查看命令如何使用
  
  * 命令 --help(-h)
  * man命令 查看命令API
  * sudo 以管理员的身份运行
  * 一般命令的使用 ：命令[options] [文件]  ls -a ./

3.重要目录
  
  * /  根目录(相当于window系统的我的电脑)
  * /bin  系统执行文件
  * /var 在运行过程中逐渐变大的目录(日志等)
  * /lib 函数库
  * /home 所有用户家目录 
  * /etc 所有系统的核心配置文件
  ```
    /etc/passwd 普通用户可看
    /etc/shadow 超级管理员
    /etc/group
    /etc/gshadow

  ```

  * /opt 第三方软件安装目录
  * /usr 默认软件(相当于windows中c盘的program files)

4.账户管理
  
  * 普通用户： 在安装ubuntu时，设置的用户briup/briup
  * 超级管理员用户 ：系统内置，需要在第一次使用ubuntu的时候，重置root密码
  ```
  命令
    sudo passwd root/root
    使用普通用户访问shadow权限不足
    briup@ubuntu:~$ more /etc/shadow 改为使用超级管理员身份运行
    briup@ubuntu:~$ sudo more /etc/shadow
        //或briup@ubuntu:~$ sudo !!  (!!命令是指复制上一行命令)
  ```

5.用户
  
  * 用户添加 
  ```
  1.sudo adduser 用户名 (默认添加了家目录，shell和密码)
  2.sudo useradd 用户名 
  （默认创建用户,默认没有创建家目录，没有指定shell）
  3.sudo useradd -m 用户名 (默认有创建家目录)
  
    重置/设定用户密码 sudo passwd 用户名(sudo passwd larry)

    usermod -s /bin/bash 修改/添加shell

    sudo useradd -m -s /bin/bash -p larry larry
    (-p表示密码，-m添加家目录，-s添加shell)
    -p 指定的密码登录不上，可以用passwd 命令添加
  ```
  * 用户删除
  ```
  sudo userdel -r 用户名(-r 表示删除家目录)
  


  ```

  * 删除目录或者文件：rm
    如果是删除目录必须加(-r)，不然rm会预设删除文件
     (sudo rm -r -d 目录名)

  * 用户名的切换 (su - 用户名)
  * sudo命令只能是超级管理员和默认用户能使用

##day02

6.链接
  
  * 硬链接 :ln a.txt a1.h(连接号增加)
  * 软链接(快捷方式) :ln -s a.txt b1.s(连接号不增加，相当于快捷方式)

7.权限管理(chmod)
```
chmod  mode file
mode包括who cp permissions
  who :u(所有者) g(同组人) o(其他人) a(所有的人)
  cp :+(增加权限) -(减少权限) =(赋予权限)
  permissions：r z x .
```

  * chmod u+r file1
  * chmod u+x,go+r file2
  * chmod a=rw file3

8.目录以及文件管理

  * touch:创建一个空文件；将某个文件日期修订为目前（修改最近访问时间）
  * mkdir:创建目录
  * rm -r disName :删除目录
  * rmdir disName :删除空目录
  * rm fileName :删除文件名
  * mkdir -p dir1/dir2:创建连级目录(dir1下的dir2)

9.文件压缩：
  
  * zip 与window打包一致，打包后源文件还在：zip ab.txt.zip a.txt b.txt
  * gzip 源文件不在： gzip a.txt  ->a.txt.gz
  * bzip2 源文件不在 ：bzip2 a.txt ->a.txt.bz2

10.文件打包
  
  * 归档
  
      * tar cvf abc.tar  a.txt b.txt c.txt ：产生abc.tar文档
      * 
      
  * 压缩
      * gzip abc.tar ：产生abc.tar.gz文档
      * bzip2 abc.tar:产生abc.tar.bz2文档
      
  * 一步到位
  
      * tar cvfz abc.tar.gz a.txt b.txt c.txt
      * tar cvfj abc.tar.bz2 a.txt b.txt c.txt

11.文件拆包

  * 解压
      
      * gunzip abc.tar.gz //产生abc.tar文档
      * bunzip2 abc.tar.bz2 //产生abc.tar文档
      
  * 解档
  
      * tar xvf abc.tar
      * tar xvf abc.tar 
  
  * 一步到位
      
      * tar xvfz abc.tar.gz 
      * tar xvfj abc.tar.bz2
  
  * -C 目录：表示指定解压后文件放置目录(路径可以是绝对路径，也可以是相对路径) -C /home/briup/Desktop

12.重定向
  
  * > 表示覆盖 cal > a.txt
  * >> 表示追加
  * < 表示输入重定向 (head < a.txt)
  
13.cp mv rm
 
 * cp拷贝：不能把一个目录复制到另一个目录(加参数-r 就可以复制目录)
     
      * cp -r a b c;(把a b 目录复制到c目录中) 
      
 * mv 移动/重命名(剪切):可以把一个目录移动到另一个目录中
 * rm 删除

##day03
 
14.元字符
  
  * ?代表任意单个字符
  * (*)  0-多个任意字符
  * []匹配指定范围内的单个字符
  * ;在一行中输入多个命令
  * | 管道，上一个命令的输出作为下一个命令的输入
  

15.环境变量
   
   * /etc/profile 配置系统变量
   * ~/.bashrc 配置用户变量
   * 
   * 使配置文件强制生效 ：(source 配置文件) source .bashrc
   * 环境变量怎么配置：(变量名=变量值) export JAVA_HMOE=/opt/jdk


#vi编辑器

1.vi三种模式
 
  * 命令模式:打开vi默认进入命令模式。
  * 底行模式：从命令行进入底行用：？/
  * 插入模式:从命令行进入编辑模式用a i o A I O
  ```
  a :在光标位置之后插入
  i :在光标之前插入
  o :向下换行插入
  A :在当前行的最后面
  I :在当前行的最前面
  O :向上换行插入

  ```

2.启动vi
  
  * vi (在里面保存并起文件名)
  * vi 文件名(在外面新建文件)

3.退出vi
  
  * :q 退出
  * :w 保存
  * :w filenewname (存入另一个文件中)
  * :wq 保存并退出
  * :q!强制退出(不想保存修改后的文件)

4.vi中光标的位置

  * 向上 k
  * 向下 j
  * 向左 h
  * 向右 l

5.删除命令(:分号表示进入底行模式)

  * x 删除一个字符
  * dw 删除一个单词(3dw)
  * dd 删除整行(5dd)
  * :2,4d(删除2到4行)

6.光标定位命令

  * 1G光标定位到第一行(5G第五行)
  * $G光标定位到最后一行
  * :$光标定位到最后一行
  * :1光标定位到第一行

7.替换命令

  * r 替换一个字符(命令模式)
  * cw 替换一个单词(会进入插入模式)
  * cc 替换一行(会进入插入模式)
  * C 从当前光标位置替换到结尾位置

8.复制命令

  * yw 复制一个单词
  * yy 复制一行
  * p 粘贴到当前位置
  * :4,6co8 (把4到5行复制到第八行之后)
  * :4,5m7（把4到5行剪切到第七行之后）
  
9.其他命令

  * ~ 切换大小写
  * J 把下面一行与当前行合并
  * :set nu 加行号
  * :r file2 插入一个新文件到当前文件中
  * u 撤销
  * /字符串 从当前行查找向下字符串
  * n 查找继续
  * ？字符串 从当前行向上查找字符串
  * :1,$s/旧串/新串/g   替换全文
  * :%s/旧串/新串/g   替换全文

10.分屏
  
  * :split 纵向分屏
  * :open .  打开目录查找文件并放入到分屏中
  * :close 关闭光标所在分屏
  * ctrl+ww 切换当前所在分屏
  * :vsplit 横向分屏

11.find 查找命令

  * -atime 最近访问时间
  * -mtime 最近修改时间
  * -name 根据名字查找，后面的参数用“”引起来
  * -p 查找并且替换
  * -e 执行操作
  * xargs 与其他命令配合使用，提取上一个命令的结果作为随后命令的参数
  * -i.bak 修改之前进行备份，备份文件为使用.bak结尾。

12.清空文件(黑洞)
  
  * cat /etc/null > c.txt  清空c.txt文件
  * : > c.txt


##day04(网络)

1.网络配置(步骤一)
   
  * windows
  ```
   ipconfig 查看windows的ip地址设置信息
        vmnet8 
            192.168.159.1
  ```

  * ubuntu 
  ```
  ifconfig 查看虚拟机ip地址设置信息
      手动设置以太网(以太网的子网必须设置成与windiws一致的，如192.168.259)
         192.168.159.200
  ```

2.开发
```
 使用C/S 客户端/服务器模式

   ## 客户端

        开发
        windows
            (poll    在线问卷系统)
        
        1. 浏览器（访问apache上的网站）
            http://192.168.159.200:80/poll

     (步骤五)  在浏览器中访问服务器，必须先打开ubuntu里面的apache2.
            打开方式：cd /usr/local/apache2/bin ;sudo ./apachectl -k start
            关闭：sudo ./apachectl -k stop

        2. dos
       (步骤三)  * 远程登录 然后打开ftp,(cd /usr/local/proftpd/sbin ;sudo ./proftpd 已经成功打开ubuntu里面的ftp服务)
            * 退出ubuntu ,进入windows系统

            * ftp 192.168.159.200 链接到ubuntu里面的ftp(拨号)

            * 双方ftp连接成功，可以进行文件通信

            * 进行下载上传
            ftp> put poll上传到ubuntu
            ftp> get poll下载到ubuntu

        3. doc
       (步骤二)  telnet 192.168.159.200（远程拨号）

            user    briup
            passwd  briup
            briup@ubuntu:~$ cp

    ##服务器

        部署
        阿里云 ubuntu

        1. 服务器软件
            apache(静态)
                部署目录（apache2/htdocs）：
     (步骤四)   (重新远程登录，进入ubuntu,通过ftp上传文件到ubuntu之后,把文件压缩并且移动到服务器的部署目录中)

                mv poll /usr/local/apache2/htdocs/
                    html css js
            
            tomcat(动态)
                servlet/jsp
            IIS
                asp
        2. 文件传输服务 ftp(proftpd)
            ~/poll
            ->
            apache/htdocs
        3. telnet服务
```

3. ubuntu系统软件安装方式
```
    1) 在线安装（简单）
        sudo apt-get install 软件名

        卸载
        sudo apt-get purge apache2

        例如：
        sudo apt-get install vim
        sudo apt-get install mysql   
    2) 离线安装
        1. 二进制文件直接安装
            解压后直接使用
                vscode
                    ./code

        2. 源文件构建安装
        例如安装ftp。
            1.拿到压缩包proftpd-1.3.6.tar.gz并解压成proftpd-1.3.6(源文件)，再将它(源文件)移动到 /opt下，源文件在windows相对于在c盘

            2.进入到/opt/proftpd-1.3.6里，把源文件里面的配置文件configure放到安装目录usr下，sudo configure --prefix=安装路径(/usr/local/proftpd)
            
            /usr/local/proftpd/sbin/ 下的proftpd是可执行文件
            安装目录相当于windows中的D盘。里面有
            
            3.sudo make
            4.sudo make install
            5.测试
               打开服务：sudo ./proftpd 
            
```

4.ftp(可以操作linux和windows系统)：dos命令加！，ubuntu命令不用加
  
  * !本机命令
  * cd lcd
  * ls dir
  * pwd
  * bin
  * get put mget mput(批量)
  * prompt 用此命令 交流模式关闭之后就可以进行无询问批量下载传输

#ps

1.选区
  
  * ctrl+d 取消选区
  * ctrl+shift+i 反选(表示选择区域之外的所有内容)
  * del 对所选区域进行删除(必须明确所选区)，前提是所选择的图层解锁

2.取色

  * X 前景色与背景色交换
  * D 让前景色和背景色恢复到初始状态
  * alt+del 赋前景色
  * ctrl+del 赋背景色
  * 选区选中之后可以对所选区域进行前景和背景色的改变

3.污点修复工具

  * alt+鼠标左键 污点画笔工具