/*    */ package mzm.gsp.singlebattle.antiafk;
/*    */ 
/*    */ import mzm.gsp.afk.main.AFKInterface;
/*    */ import mzm.gsp.singlebattle.confbean.AntiAFKCfg;
/*    */ import mzm.gsp.singlebattle.main.EachPlayTypeHandler;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AntiAFKPlayTypeHandler
/*    */   implements EachPlayTypeHandler
/*    */ {
/*    */   public boolean canFight(long battleId, int playCfgId, long activeRoleId, long passiveRoleId)
/*    */   {
/* 18 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPoint(long battleId, int playCfgId, long roleId, boolean remainRoleLock)
/*    */   {
/* 24 */     return 0;
/*    */   }
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
/*    */   public void onBattleStart(long battleId, int playCfgId) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onMatchEnd(long battleId, int playCfgId) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onMatchStart(long battleId, int playCfgId) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onRoleJoinBattle(long battleId, int playCfgId, long roleId)
/*    */   {
/* 54 */     AntiAFKCfg cfg = AntiAFKCfg.get(playCfgId);
/* 55 */     if (cfg == null)
/*    */     {
/*    */ 
/* 58 */       return;
/*    */     }
/* 60 */     AFKInterface.startAFKDetect(roleId, cfg.afk_detect_cfg_id);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onRoleQuitBattle(long battleId, int playCfgId, long roleId, SingleBattleInterface.LeaveBattleReason leaveReason)
/*    */   {
/* 66 */     AntiAFKCfg cfg = AntiAFKCfg.get(playCfgId);
/* 67 */     if (cfg == null)
/*    */     {
/*    */ 
/* 70 */       return;
/*    */     }
/* 72 */     AFKInterface.stopAFKDetect(roleId, cfg.afk_detect_cfg_id);
/*    */   }
/*    */   
/*    */   public void onStartClean(long battleId, int playCfgId) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\antiafk\AntiAFKPlayTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */