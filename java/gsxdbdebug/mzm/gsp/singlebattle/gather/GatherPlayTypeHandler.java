/*     */ package mzm.gsp.singlebattle.gather;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.singlebattle.SGatherSourceResult;
/*     */ import mzm.gsp.singlebattle.confbean.SBattleGatherPlayCfg;
/*     */ import mzm.gsp.singlebattle.main.EachPlayTypeHandler;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleGatherData;
/*     */ import xbean.RoleGatherData;
/*     */ import xtable.Battlegather;
/*     */ import xtable.Role2gatherdata;
/*     */ 
/*     */ public class GatherPlayTypeHandler implements EachPlayTypeHandler
/*     */ {
/*     */   public void onBattleStart(long battleId, int playCfgId)
/*     */   {
/*  24 */     SBattleGatherPlayCfg playCfg = SBattleGatherPlayCfg.get(playCfgId);
/*  25 */     if (playCfg == null)
/*     */     {
/*  27 */       GameServer.logger().error(String.format("[battlegather]PlayTypeHandler.onBattleStart@ playCfg is null!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */       
/*     */ 
/*  30 */       return;
/*     */     }
/*  32 */     new Session_StartOutputGather(playCfg.beginTime, battleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onRoleJoinBattle(long battleId, int playCfgId, long roleId) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onMatchStart(long battleId, int playCfgId) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPoint(long battleId, int playCfgId, long roleId, boolean remainRoleLock)
/*     */   {
/*     */     RoleGatherData xRoleGatherData;
/*     */     
/*     */     RoleGatherData xRoleGatherData;
/*     */     
/*  51 */     if (remainRoleLock)
/*     */     {
/*  53 */       xRoleGatherData = Role2gatherdata.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  57 */       xRoleGatherData = Role2gatherdata.select(Long.valueOf(roleId));
/*     */     }
/*  59 */     if (xRoleGatherData == null)
/*     */     {
/*  61 */       return 0;
/*     */     }
/*  63 */     return xRoleGatherData.getPoint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onMatchEnd(long battleId, int playCfgId)
/*     */   {
/*  71 */     BattleGatherData xBattleGatherData = Battlegather.get(Long.valueOf(battleId));
/*  72 */     if (xBattleGatherData == null)
/*     */     {
/*  74 */       GameServer.logger().info(String.format("[battlegather]PlayTypeHandler.onMatchEnd@ xBattleGatherData is null!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  78 */       return;
/*     */     }
/*  80 */     BattleGatherManager.removeOriginalGatherItems(battleId, xBattleGatherData, MapCallBack_RemoveMapEntity.RemoveGatherItemReason.MATCH_END);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onStartClean(long battleId, int playCfgId)
/*     */   {
/*  88 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(battleId, true);
/*  89 */     if (globalInfo == null)
/*     */     {
/*  91 */       return;
/*     */     }
/*  93 */     SGatherSourceResult res = new SGatherSourceResult();
/*  94 */     for (Iterator i$ = globalInfo.getAllMembers().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  97 */       RoleGatherData xRoleGatherData = Role2gatherdata.select(Long.valueOf(roleId));
/*  98 */       if (xRoleGatherData != null)
/*     */       {
/*     */ 
/*     */ 
/* 102 */         res.role2totalsource.put(Long.valueOf(roleId), Integer.valueOf(xRoleGatherData.getTotalsource())); }
/*     */     }
/* 104 */     SingleBattleInterface.battleBro(battleId, res, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onBattleEnd(long battleId, int playCfgId)
/*     */   {
/* 111 */     Battlegather.remove(Long.valueOf(battleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onRoleQuitBattle(long battleId, int playCfgId, long roleId, SingleBattleInterface.LeaveBattleReason leaveReason)
/*     */   {
/* 118 */     Role2gatherdata.remove(Long.valueOf(roleId));
/*     */     
/*     */ 
/* 121 */     RoleStatusInterface.unsetStatus(roleId, 1516);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canFight(long battleId, int playCfgId, long activeRoleId, long passiveRoleId)
/*     */   {
/* 127 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\GatherPlayTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */