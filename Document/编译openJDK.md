### 手动编译一套openJDK ###

> 环境

   1.centOS 6.7(由于电脑内存小，在用7.0时发生未知原因导致开不了机)

   2.BootstrapJDK: openJDK7

   3.source: openJDK7_source

   4.centos 包安装： 

    yum -y install gcc gcc-c++ alsa-lib alsa-lib-devel libXrender libXrender-devel libXi-devel libXt-devel libXtst-devel cups cups-devel
    
    yum -y install ant

    yum -y install freetype*

   5.配置 `/etc/profile`
    
    export LANG=C
    export ALT_BOOTDIR=/usr/java/jdk1.7.0_80
    export ALLOW_DOWNLOADS=true
    
    export HOTSPOT_BUILD_JOBS=8
    export ALT_PARALLEL_COMPILE_JOBS=8
    
    export SKIP_COMPARE_IMAGES=true
    export USE_PRECOMPILED_HEADER=true
    
    #content builded
    export BUILD_LANGTOOLS=true
    #export BUILD_JAXP=false
    #export BUILD_JAXWS=fasle
    #export BUILD_CORBA=fasle
    export BUILD_HOTSPOT=true
    export BUILD_JDK=true
    BUILD_DEPLOY=false
    BUILD_INSTALL=false
    export ALT_OUTPUTDIR=/usr/lib/jvm/jdkBuild/openjdk_7u/build
    unset JAVA_HOME
    unset CLASSPATH
    
    make jvmg jvmg1 2>&1 | tee $ALT_OUTPUTDIR/build.log

   6.make

  -  如果只编译hotspot 在hotspot/make下执行 make jvmg jvmg1
    
  - 如果编译所有,在源码根目录/make下执行 make

   7.调试

   - gdb调试
    
       -配置jvmg/env.sh:

        LD_LIBRARY_PATH=.:${JAVA_HOME}/jre/lib/i386/native_threads:${JAVA_HOME}/jre/lib/i386:
        export LD_LIBRARY_PATH

      gdb调试命令暂时没学

   - netbeans调试

       - 添加项目
       - 选择make目录或者Makefile(8.2版本选择make)
       - 修改build命令
       
            ${MAKE} -f Makefile clean jvmg ALT_BOOTDIR=/usr/java/jdk1.7.0_80 ARCH_DATA_MODEL=32 LANG=C
       - finish->等待make结束
       - 修改run命令
       
            /usr/lib/jvm/openjdk7/build/linux_i486_compiler2/jvmg/gamma Queens 
       - 添加环境变量
       
           - JAVA_HOM：/usr/java/jdk1.7.0_80(BootstrapJDK目录)
           - CLASSPATH: .:${JAVA_HOME}/jre/lib/rt.jar:${JAVA_HOME}/jre/lib/i18n.jar+[自己class文件所在目录]
           - LD_LIBRARY_PATH: /usr/lib/jvm/openjdk7/build/linux_i486_compiler2/jvmg
             
            