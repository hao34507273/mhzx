/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ public class ReportCrossBattleOwnResultDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public ReportCrossBattleOwnResultDoneArg(int retcode, int activityCfgid)
/*    */   {
/* 10 */     this.retcode = retcode;
/* 11 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 21 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isTimeout()
/*    */   {
/* 31 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getRetCode()
/*    */   {
/* 41 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getActivityCfgid()
/*    */   {
/* 51 */     return this.activityCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportCrossBattleOwnResultDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */