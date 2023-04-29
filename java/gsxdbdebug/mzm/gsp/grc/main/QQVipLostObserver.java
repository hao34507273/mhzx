/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class QQVipLostObserver extends Observer
/*    */ {
/*    */   private final long roleid;
/*    */   private final int vipFlag;
/*    */   
/*    */   public QQVipLostObserver(long roleid, int vipFlag, long intervalSeconds)
/*    */   {
/* 12 */     super(intervalSeconds);
/*    */     
/* 14 */     this.roleid = roleid;
/* 15 */     this.vipFlag = vipFlag;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     new POnQQVipLost(this.roleid, this.vipFlag).execute();
/*    */     
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\QQVipLostObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */