#include <stdio.h> //头文件
 #include "JavaCallC.h" // java文件头，这里一定要加上上面java语言的头文件

 // 这就是上面头文件中的cMethod方法的具体实现，注意方法签名不能变，一定要和头文件一样。
 JNIEXPORT void JNICALL Java_JavaCallC_cMethod(JNIEnv *env, jobject c1)
 {
     // 如果java调用cMethod方法成功，则会打印这句话
     printf("Java native 实战  \n");
 }
