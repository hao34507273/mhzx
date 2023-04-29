/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import mzm.gsp.singlebattle.main.EachPlayTypeHandler;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*    */ 
/*    */ 
/*    */ public class GrabPlayTypeHandler
/*    */   implements EachPlayTypeHandler
/*    */ {
/*    */   public void onBattleStart(long battleId, int playCfgId)
/*    */   {
/* 12 */     GrabPlayHandlerImpl.onBattleStart(battleId, playCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onRoleJoinBattle(long battleId, int playCfgId, long roleId)
/*    */   {
/* 18 */     GrabPlayHandlerImpl.onRoleJoinBattle(battleId, playCfgId, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPoint(long battleId, int playCfgId, long roleId, boolean remainRoleLock)
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onBattleEnd(long battleId, int playCfgId)
/*    */   {
/* 30 */     GrabPlayHandlerImpl.onBattleEnd(battleId, playCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onRoleQuitBattle(long battleId, int playCfgId, long roleId, SingleBattleInterface.LeaveBattleReason leaveReason)
/*    */   {
/* 36 */     GrabPlayHandlerImpl.onRoleQuitBattle(battleId, playCfgId, roleId, leaveReason);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean canFight(long battleId, int playCfgId, long activeRoleId, long passiveRoleId)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onMatchEnd(long battleId, int playCfgId)
/*    */   {
/* 48 */     GrabPlayHandlerImpl.onMatchEnd(battleId, playCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onStartClean(long battleId, int playCfgId)
/*    */   {
/* 54 */     GrabPlayHandlerImpl.onStartClean(battleId, playCfgId);
/*    */   }
/*    */   
/*    */   public void onMatchStart(long battleId, int playCfgId) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\GrabPlayTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */