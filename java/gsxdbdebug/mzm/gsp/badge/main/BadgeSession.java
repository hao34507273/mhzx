/*    */ package mzm.gsp.badge.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BadgeSession
/*    */   extends Session
/*    */ {
/*    */   private final long roleId;
/*    */   private int badgeId;
/*    */   
/*    */   public BadgeSession(long interval, long roleId, int badgeId)
/*    */   {
/* 19 */     super(interval, roleId);
/* 20 */     this.roleId = roleId;
/* 21 */     this.badgeId = badgeId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     Procedure.execute(new PRemoveBadge(this.roleId, this.badgeId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\badge\main\BadgeSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */