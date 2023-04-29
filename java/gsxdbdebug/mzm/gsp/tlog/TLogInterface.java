/*    */ package mzm.gsp.tlog;
/*    */ 
/*    */ public class TLogInterface
/*    */ {
/*    */   public static void initTlogServerIPAndPort(String tlogServerIp, int port) {
/*  6 */     TLogManager.initTlogServerIPAndPort(tlogServerIp, port);
/*    */   }
/*    */   
/*    */ 
/*    */   public static String getTlogServerIP()
/*    */   {
/* 12 */     return TLogManager.getTlogServerIP();
/*    */   }
/*    */   
/*    */   public static int getTlogServerPort() {
/* 16 */     return TLogManager.getTlogServerPort();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tlog\TLogInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */