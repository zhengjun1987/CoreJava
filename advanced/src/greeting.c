#include "chapter12jni_HelloNative.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_chapter12jni_HelloNative_greeting
  (JNIEnv *env, jclass thiz){
        printf("Hello,Jni!");
  }


JNIEXPORT jint JNICALL Java_chapter12jni_HelloNative_print
  (JNIEnv *env, jclass thiz, jint width, jint precision, jdouble x){
        char fmt[30];
        jint ret;
        sprintf(fmt,"%%%d.%df",width,precision);
        ret = printf(fmt,x);
        fflush(stdout);
        return ret;
  }