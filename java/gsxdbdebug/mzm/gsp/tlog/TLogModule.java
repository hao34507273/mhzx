/*    */ package mzm.gsp.tlog;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ 
/*    */ public class TLogModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 11 */     TLogManager.getInstance().init();
/* 12 */     LogReason.checkReasonValue();
/* 13 */     SNSTYPE.checkValue();
/* 14 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 20 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tlog\TLogModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */