package com.infrastructure.utils;

import android.util.Log;

/**
 * @author hys
 * @version 1.1版本 2016年7月15日 21:09:53
 * @descirption: 默认tag,"hys".log.i_v_d_e,可自定义设置tag，可链接定位。
 */

public class MyLog {

    private static String tag;
    public static void setTag(String tag1){
        tag=tag1;
    }
    public static void i(String msg){
        if(tag==null){
            tag="hys";
        }
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            //出错点，compareTo()括号中的内容一定要是 方法名,比如'i'
            if (stackTraceElement[i].getMethodName().compareTo("i") == 0)
            {
                currentIndex = i + 1;
                break;
            }
        }


        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.i(tag ,msg+ "  ///at " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");

    }//Log.i

    public static void d(String msg){
        if(tag==null){
            tag="hys";
        }
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            //出错点，compareTo()括号中的内容一定要是 方法名,比如'i'
            if (stackTraceElement[i].getMethodName().compareTo("d") == 0)
            {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.d(tag ,msg+ "  ///at " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");

    }//Log.d

    public static void v(String msg){
        if(tag==null){
            tag="hys";
        }
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            //出错点，compareTo()括号中的内容一定要是 方法名,比如'i'
            if (stackTraceElement[i].getMethodName().compareTo("v") == 0)
            {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.v(tag ,msg+ "  ///at " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");

    }//Log.v

    public static void e(String msg){
        if(tag==null){
            tag="hys";
        }
        StackTraceElement[] stackTraceElement = Thread.currentThread()
                .getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            //出错点，compareTo()括号中的内容一定要是 方法名,比如'i'
            if (stackTraceElement[i].getMethodName().compareTo("e") == 0)
            {
                currentIndex = i + 1;
                break;
            }
        }

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName
                .lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String
                .valueOf(stackTraceElement[currentIndex].getLineNumber());

        Log.e(tag ,msg+ "  ///at " + fullClassName + "." + methodName + "("
                + className + ".java:" + lineNumber + ")");

    }//Log.e
}//MyLog_cls
