/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class UnlockRoleInfoObserver extends Observer
/*    */ {
/*    */   private final long roleId;
/*    */   private final int infoType;
/*    */   
/*    */   public UnlockRoleInfoObserver(long roleId, int infoType, long intervalSeconds)
/*    */   {
/* 12 */     super(intervalSeconds);
/* 13 */     this.roleId = roleId;
/* 14 */     this.infoType = infoType;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 20 */     IdipManager.removeLockRoleInfo(this.roleId, this.infoType);
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\UnlockRoleInfoObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */