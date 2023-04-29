/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.singlebattle.confbean.BuffCfgid2InfoCfgidCfg;
/*    */ import mzm.gsp.singlebattle.main.BattleTaskOneByOne;
/*    */ import mzm.gsp.singlebattle.main.EachPlayTypeHandler;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Single_battle_buffs;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BuffPlayTypeHandler
/*    */   implements EachPlayTypeHandler
/*    */ {
/*    */   public boolean canFight(long battleId, int playCfgId, long activeRoleId, long passiveRoleId)
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPoint(long battleId, int playCfgId, long roleId, boolean remainRoleLock)
/*    */   {
/* 29 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onBattleEnd(long battleId, int playCfgId)
/*    */   {
/* 35 */     Single_battle_buffs.remove(Long.valueOf(battleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onBattleStart(long battleId, int playCfgId) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onMatchEnd(final long battleId, int playCfgId)
/*    */   {
/* 47 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(battleId), new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 52 */         BuffManager.removeBuff(battleId, false);
/* 53 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */   public void onMatchStart(final long battleId, int playCfgId)
/*    */   {
/* 61 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(battleId), new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 66 */         BuffManager.refreshBuff(battleId, true);
/* 67 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onRoleJoinBattle(long battleId, int playCfgId, long roleId) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onRoleQuitBattle(long battleId, int playCfgId, long roleId, SingleBattleInterface.LeaveBattleReason leaveReason)
/*    */   {
/* 82 */     List<Integer> allBuffCfgids = new ArrayList();
/* 83 */     allBuffCfgids.addAll(BuffCfgid2InfoCfgidCfg.getAll().keySet());
/* 84 */     List<Integer> buffCfgids = BuffInterface.contains(roleId, allBuffCfgids, true);
/* 85 */     for (Iterator i$ = buffCfgids.iterator(); i$.hasNext();) { int buffCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 87 */       BuffInterface.uninstallBuf(roleId, buffCfgid);
/*    */     }
/* 89 */     BuffManager.removeRoleBuffInfo(roleId);
/*    */   }
/*    */   
/*    */   public void onStartClean(long battleId, int playCfgId) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\BuffPlayTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */