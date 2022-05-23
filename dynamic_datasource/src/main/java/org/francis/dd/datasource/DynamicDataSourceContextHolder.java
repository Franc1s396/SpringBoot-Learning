package org.francis.dd.datasource;

/**
 * @author Franc1s
 * @date 2022/5/15
 * @apiNote 这个类用来存储当前线程所使用的数据源名称
 */
public class DynamicDataSourceContextHolder {
    private static ThreadLocal<String> CONTEXT_HOLDER=new ThreadLocal<>();

    public static void setDataSourceType(String dataSourceType){
        CONTEXT_HOLDER.set(dataSourceType);
    }

    public static String getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceType(){
        CONTEXT_HOLDER.remove();
    }
}
