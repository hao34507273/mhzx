/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class UnbanZeroProfitObserver extends Observer
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public UnbanZeroProfitObserver(long roleId, long intervalSeconds)
/*    */   {
/* 11 */     super(intervalSeconds);
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 18 */     IdipManager.uninstallZeroProfitBuff(this.roleId);
/* 19 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\UnbanZeroProfitObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */