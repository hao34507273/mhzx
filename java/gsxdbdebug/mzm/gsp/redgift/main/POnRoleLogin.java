/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.SSyncRedgiftActivityLeftTime;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!RedGiftManager.isRedGiftFunOpen()) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     if (!RedGiftManager.isRedGiftFunOpenWithRoleId(((Long)this.arg).longValue())) {
/* 25 */       return false;
/*    */     }
/* 27 */     long startTime = RedGiftManager.getRedgiftActivityLeftTime();
/* 28 */     if (startTime == 0L) {
/* 29 */       return false;
/*    */     }
/* 31 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 32 */     if (curTime >= startTime) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     int roleLevel = RoleInterface.getLevel(((Long)this.arg).longValue());
/* 37 */     if (!RedGiftManager.isLevelOnGetRedgiftRange(roleLevel)) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     SSyncRedgiftActivityLeftTime sSyncRedgiftActivityLeftTime = new SSyncRedgiftActivityLeftTime();
/* 42 */     sSyncRedgiftActivityLeftTime.lefttime = ((int)TimeUnit.MILLISECONDS.toSeconds(startTime - curTime));
/* 43 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncRedgiftActivityLeftTime);
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */