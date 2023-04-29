/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import mzm.gsp.singlebattle.main.EachPlayTypeHandler;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayTypeHandler
/*    */   implements EachPlayTypeHandler
/*    */ {
/*    */   public void onBattleStart(long battleId, int playCfgId) {}
/*    */   
/*    */   public void onRoleJoinBattle(long battleId, int playCfgId, long roleId) {}
/*    */   
/*    */   public void onMatchStart(long battleId, int playCfgId) {}
/*    */   
/*    */   public int getPoint(long battleId, int playCfgId, long roleId, boolean remainRoleLock)
/*    */   {
/* 34 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onMatchEnd(long battleId, int playCfgId) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onStartClean(long battleId, int playCfgId) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onBattleEnd(long battleId, int playCfgId) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onRoleQuitBattle(long battleId, int playCfgId, long roleId, SingleBattleInterface.LeaveBattleReason leaveReason) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean canFight(long battleId, int playCfgId, long activeRoleId, long passiveRoleId)
/*    */   {
/* 69 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\PlayTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */