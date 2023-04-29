/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ class LogCfgArgs
/*    */ {
/*    */   int OnlineLogIntervalSeconds;
/*    */   int HeartbeatLogIntervalSeconds;
/*    */   @com.thoughtworks.xstream.annotations.XStreamAsAttribute
/* 10 */   ArrayList<LogCfg> logCfgs = new ArrayList();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\LogCfgArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */