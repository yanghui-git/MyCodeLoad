/**
 * gcc  -fPIC -I //Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/include   -I /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/include/darwin    -shared -o libJavaCallC.so Cclass.c
 *
 *  native 实战  Java 调用C 方法
 *
 * https://zhuanlan.zhihu.com/p/292544623
 *
 */
public class JavaCallC {

    static {
        // 使用文件名加载自定义的C语言库
        System.load("/Users/hui.yang/IdeaProjects/MyCodeLoad2.0/SpringEasy/src/main/java/com/yh/test/nativetest/libJavaCallC.so");
    }

    public static void main(String[] args) {
        JavaCallC javaCallC =new JavaCallC();

        // 调用本地方法
        javaCallC.cMethod();
    }
    // 使用C语言实现本地方法
    private native void cMethod();
}
