/*    */ package mzm.gsp.backgame.main;
/*    */ 
/*    */ import mzm.gsp.backgame.confbean.BackGameConsts;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.Role2BackGameInfo;
/*    */ import xtable.Role2backgame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BackGameInterface
/*    */ {
/*    */   public static int getBackGameStorage2ExpRate(long roleId)
/*    */   {
/* 18 */     Role2BackGameInfo xRole2BackGameInfo = Role2backgame.get(Long.valueOf(roleId));
/* 19 */     if (xRole2BackGameInfo == null)
/*    */     {
/* 21 */       return 0;
/*    */     }
/*    */     
/* 24 */     long xBackGameStartTime = xRole2BackGameInfo.getBack_state_start_time();
/* 25 */     if (BackGameManager.isInBackState(DateTimeUtils.getCurrTimeInMillis(), xBackGameStartTime))
/*    */     {
/* 27 */       return BackGameConsts.getInstance().getReserverExpRate;
/*    */     }
/*    */     
/* 30 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\main\BackGameInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */