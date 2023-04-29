/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ public class MarryReqSession extends Session
/*    */ {
/*    */   private final boolean isUseYuanBao;
/*    */   private final int level;
/*    */   private final long otherRoleid;
/*    */   
/*    */   public MarryReqSession(long interval, long roleId, long otherRoleid, boolean isUseYuanBao, int level)
/*    */   {
/* 13 */     super(interval, roleId);
/* 14 */     this.level = level;
/* 15 */     this.isUseYuanBao = isUseYuanBao;
/* 16 */     this.otherRoleid = otherRoleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut() {}
/*    */   
/*    */ 
/*    */   public long getOtherRoleid()
/*    */   {
/* 25 */     return this.otherRoleid;
/*    */   }
/*    */   
/*    */   public long getRoleid() {
/* 29 */     return getOwerId();
/*    */   }
/*    */   
/*    */   public boolean isUseYuanBao() {
/* 33 */     return this.isUseYuanBao;
/*    */   }
/*    */   
/*    */   public int getLevel() {
/* 37 */     return this.level;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\MarryReqSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */