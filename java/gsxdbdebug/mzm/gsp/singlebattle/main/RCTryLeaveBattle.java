/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.singlebattle.SLeaveSingleBattleBro;
/*     */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STSingleBattlePlayLibCfg;
/*     */ import mzm.gsp.singlebattle.event.LeaveSingleBattle;
/*     */ import mzm.gsp.singlebattle.event.LeaveSingleBattleArg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSessions;
/*     */ import xbean.RoleSingleBattle;
/*     */ import xtable.Role2singlebattle;
/*     */ 
/*     */ 
/*     */ public class RCTryLeaveBattle
/*     */   extends LogicRunnable
/*     */ {
/*     */   private final long roleId;
/*     */   private final long _battleId;
/*     */   private final int _battleCfgId;
/*     */   private SingleBattleInterface.LeaveBattleReason leaveReason;
/*     */   private SSingleBattleCfg _battleCfg;
/*     */   
/*     */   public RCTryLeaveBattle(long roleId, long battleId, int battleCfgId)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this._battleId = battleId;
/*  36 */     this._battleCfgId = battleCfgId;
/*     */   }
/*     */   
/*     */ 
/*  40 */   private boolean surrender = false;
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  45 */     if ((SingleBattleInterface.isMatchIngStage(this._battleId, false)) && (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1515, true)))
/*     */     {
/*     */ 
/*     */ 
/*  49 */       return;
/*     */     }
/*     */     
/*  52 */     this._battleCfg = SSingleBattleCfg.get(this._battleCfgId);
/*     */     
/*  54 */     onRoleLeaveBattle();
/*     */     
/*  56 */     new SingleLeaveBattle(null).call();
/*     */     
/*  58 */     if (this.surrender)
/*     */     {
/*  60 */       GameServer.logger().info(String.format("[singlebattle]RCTryLeaveBattle.process@ end battle for leaving battle!|battleId=%d|battleCfgId=%d|roleId=%d", new Object[] { Long.valueOf(this._battleId), Integer.valueOf(this._battleCfgId), Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       SingleBattleManager.advanceEndMatch(this._battleId, this._battleCfg, 3);
/*     */     }
/*     */     
/*  67 */     SingleBattleMemberManager.getInstance().removeRoleAFLeave(this._battleCfg.battleType, this._battleId, this.roleId);
/*     */     
/*  69 */     SingleBattleManager.clearRoleMapData(this.roleId);
/*     */   }
/*     */   
/*     */   private class SingleLeaveBattle
/*     */     extends LogicProcedure
/*     */   {
/*     */     private SingleLeaveBattle() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  79 */       RoleSingleBattle xRoleBattleData = Role2singlebattle.select(Long.valueOf(RCTryLeaveBattle.this.roleId));
/*  80 */       if (xRoleBattleData == null)
/*     */       {
/*  82 */         GameServer.logger().error(String.format("[singlebattle]PCTryLeaveBattle.processImp@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(RCTryLeaveBattle.this.roleId) }));
/*     */         
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       if (xRoleBattleData.getBattleid() != RCTryLeaveBattle.this._battleId)
/*     */       {
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       int _campId = xRoleBattleData.getCampid();
/*     */       
/*  94 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(RCTryLeaveBattle.this._battleId, true);
/*  95 */       if (globalInfo == null)
/*     */       {
/*  97 */         GameServer.logger().error(String.format("[singlebattle]PCTryLeaveBattle.processImp@ no xGlobalInfo! |roleId=%d|battleId=%d|battleCfgId=%d|", new Object[] { Long.valueOf(RCTryLeaveBattle.this.roleId), Long.valueOf(RCTryLeaveBattle.this._battleId), Integer.valueOf(xRoleBattleData.getBattlecfgid()) }));
/*     */         
/*     */ 
/*     */ 
/* 101 */         return false;
/*     */       }
/*     */       
/* 104 */       xRoleBattleData = Role2singlebattle.get(Long.valueOf(RCTryLeaveBattle.this.roleId));
/* 105 */       if (xRoleBattleData == null)
/*     */       {
/* 107 */         GameServer.logger().error(String.format("[singlebattle]PCTryLeaveBattle.processImp@ recheck no RoleSingleBattle! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(RCTryLeaveBattle.this.roleId), Long.valueOf(RCTryLeaveBattle.this._battleId) }));
/*     */         
/*     */ 
/*     */ 
/* 111 */         return false;
/*     */       }
/*     */       
/* 114 */       int stage = globalInfo.getStage();
/* 115 */       if (stage == 4)
/*     */       {
/* 117 */         RCTryLeaveBattle.this.leaveReason = SingleBattleInterface.LeaveBattleReason.OVER_CLEAN;
/*     */       }
/*     */       else
/*     */       {
/* 121 */         RCTryLeaveBattle.this.leaveReason = SingleBattleInterface.LeaveBattleReason.ACTIVE_LEAVE;
/*     */       }
/*     */       
/* 124 */       globalInfo.battleBro(new SLeaveSingleBattleBro(RCTryLeaveBattle.this.roleId), false);
/*     */       
/* 126 */       globalInfo.setRoleState(RCTryLeaveBattle.this.roleId, _campId, 3);
/*     */       
/* 128 */       SingleBattleManager.removeSingleBattleAllStatus(RCTryLeaveBattle.this.roleId);
/*     */       
/* 130 */       MapInterface.unSetModelProtocol(RCTryLeaveBattle.this.roleId, 12621580);
/*     */       
/* 132 */       Session.removeSession(xRoleBattleData.getRolesessions().getDiesessionid());
/* 133 */       Session.removeSession(xRoleBattleData.getRolesessions().getProtectsessionid());
/*     */       
/* 135 */       Role2singlebattle.remove(Long.valueOf(RCTryLeaveBattle.this.roleId));
/*     */       
/* 137 */       LeaveSingleBattleArg arg = new LeaveSingleBattleArg(RCTryLeaveBattle.this.roleId, RCTryLeaveBattle.this._battleId, RCTryLeaveBattle.this.leaveReason, globalInfo.getBattleContext(), xRoleBattleData.getPvpfightcount());
/*     */       
/* 139 */       if (stage == 4)
/*     */       {
/* 141 */         arg.setRes(globalInfo.getSingleBattleResult());
/*     */       }
/* 143 */       TriggerEventsManger.getInstance().triggerEvent(new LeaveSingleBattle(), arg);
/*     */       
/*     */ 
/*     */ 
/* 147 */       if ((stage != 4) && (!globalInfo.isSurrender(_campId)))
/*     */       {
/*     */ 
/* 150 */         RCTryLeaveBattle.this.surrender = globalInfo.checkAndSetSurrender(_campId);
/*     */       }
/*     */       
/* 153 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private void onRoleLeaveBattle()
/*     */   {
/* 159 */     STSingleBattlePlayLibCfg playLibCfg = STSingleBattlePlayLibCfg.get(this._battleCfg.playLibId);
/* 160 */     if (playLibCfg == null)
/*     */     {
/* 162 */       GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.initPlays@ STSingleBattlePlayLibCfg is null!|battleCfgId=%d|playLibId=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId) }));
/*     */       
/*     */ 
/*     */ 
/* 166 */       return;
/*     */     }
/* 168 */     for (Map.Entry<Integer, Integer> entry : playLibCfg.type2cfgId.entrySet())
/*     */     {
/* 170 */       EachPlayTypeHandler handler = SingleBattleRegisterManager.getEachPlayTypeHandler(((Integer)entry.getKey()).intValue());
/* 171 */       if (handler == null)
/*     */       {
/* 173 */         GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.initPlays@ EachPlayTypeHandler is null!|battleCfgId=%d|playLibId=%d|playType=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId), entry.getKey() }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 179 */         initEachPlayOnRoleLeave(this._battleId, ((Integer)entry.getValue()).intValue(), handler);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void initEachPlayOnRoleLeave(final long battleId, int playCfgId, final EachPlayTypeHandler handler) {
/* 185 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 191 */         handler.onRoleQuitBattle(battleId, this.val$playCfgId, RCTryLeaveBattle.this.roleId, RCTryLeaveBattle.this.leaveReason);
/* 192 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\RCTryLeaveBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */