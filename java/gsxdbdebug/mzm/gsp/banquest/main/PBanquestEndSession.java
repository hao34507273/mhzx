/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBanquestEndSession
/*    */   extends Session
/*    */ {
/*    */   private final long roleId;
/*    */   private final long startTime;
/*    */   
/*    */   public PBanquestEndSession(long interval, long roleId, long startTime)
/*    */   {
/* 18 */     super(interval, roleId);
/* 19 */     this.roleId = roleId;
/* 20 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     Procedure.execute(new PBanquestEnd(this.roleId, this.startTime));
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 31 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public long getStartTime()
/*    */   {
/* 36 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public String getStartTimeStr()
/*    */   {
/* 41 */     if (this.startTime <= 0L)
/*    */     {
/* 43 */       return "";
/*    */     }
/* 45 */     return BanquestManager.getFormatDate(this.startTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PBanquestEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */