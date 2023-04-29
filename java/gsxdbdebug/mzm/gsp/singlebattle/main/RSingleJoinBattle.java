/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSingleBattle;
/*     */ import xtable.Role2singlebattle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RSingleJoinBattle
/*     */   extends LogicRunnable
/*     */ {
/*     */   private final long roleId;
/*     */   private final long _battleId;
/*     */   private int _campId;
/*     */   SSingleBattleCfg cfg;
/*     */   
/*     */   public RSingleJoinBattle(long battleId, long roleId)
/*     */   {
/*  30 */     this._battleId = battleId;
/*  31 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!OnlineManager.getInstance().isOnline(this.roleId))
/*     */     {
/*  39 */       GameServer.logger().error(String.format("[singleBattle]RSingleJoinBattle.RSingleJoinBattle@ offline!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  41 */       return;
/*     */     }
/*     */     
/*  44 */     PJoinBattle p = new PJoinBattle(null);
/*  45 */     if (!p.call())
/*     */     {
/*  47 */       GameServer.logger().error(String.format("[singleBattle]RSingleJoinBattle.RSingleJoinBattle@ join battle err!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  49 */       return;
/*     */     }
/*  51 */     if (p.isFristJoin())
/*     */     {
/*     */ 
/*  54 */       new SynBattleInfo(null).call();
/*     */       
/*  56 */       SingleBattleManager.onPlayJoinBattle(this._battleId, this.cfg, this.roleId);
/*     */     }
/*     */     
/*  59 */     SingleBattleMemberManager.getInstance().addValidRoleId(this.cfg.battleType, this._battleId, this.roleId);
/*     */   }
/*     */   
/*     */   private class PJoinBattle extends LogicProcedure
/*     */   {
/*  64 */     private boolean isFristJoin = false;
/*     */     
/*     */     private PJoinBattle() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  70 */       RoleSingleBattle xRoleBattleData = Role2singlebattle.select(Long.valueOf(RSingleJoinBattle.this.roleId));
/*  71 */       if (xRoleBattleData == null)
/*     */       {
/*  73 */         GameServer.logger().error(String.format("[singlebattle]PSingleJoinBattle.processImp@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(RSingleJoinBattle.this.roleId) }));
/*     */         
/*  75 */         return false;
/*     */       }
/*     */       
/*  78 */       if (xRoleBattleData.getBattleid() != RSingleJoinBattle.this._battleId)
/*     */       {
/*  80 */         GameServer.logger().error(String.format("[singlebattle]PSingleJoinBattle.processImp@ not in this battle! |roleId=%d|battleId_own=%d|this.battle=%d", new Object[] { Long.valueOf(RSingleJoinBattle.this.roleId), Long.valueOf(xRoleBattleData.getBattleid()), Long.valueOf(RSingleJoinBattle.this._battleId) }));
/*     */         
/*     */ 
/*     */ 
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       RSingleJoinBattle.this._campId = xRoleBattleData.getCampid();
/*     */       
/*  89 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(RSingleJoinBattle.this._battleId, true);
/*  90 */       if (globalInfo == null)
/*     */       {
/*  92 */         GameServer.logger().error(String.format("[singlebattle]PSingleJoinBattle.processImp@ no xGlobalInfo! |roleId=%d|battleId=%d|battleCfgId=%d|", new Object[] { Long.valueOf(RSingleJoinBattle.this.roleId), Long.valueOf(RSingleJoinBattle.this._battleId), Integer.valueOf(xRoleBattleData.getBattlecfgid()) }));
/*     */         
/*     */ 
/*     */ 
/*  96 */         return false;
/*     */       }
/*  98 */       RSingleJoinBattle.this.cfg = globalInfo.getBattleCfg();
/*     */       
/* 100 */       xRoleBattleData = Role2singlebattle.get(Long.valueOf(RSingleJoinBattle.this.roleId));
/* 101 */       if (xRoleBattleData == null)
/*     */       {
/* 103 */         GameServer.logger().error(String.format("[singlebattle]PSingleJoinBattle.processImp@ recheck no RoleSingleBattle! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(RSingleJoinBattle.this.roleId), Long.valueOf(RSingleJoinBattle.this._battleId) }));
/*     */         
/*     */ 
/*     */ 
/* 107 */         return false;
/*     */       }
/* 109 */       if (xRoleBattleData.getJointime() <= 0L)
/*     */       {
/* 111 */         xRoleBattleData.setJointime(DateTimeUtils.getCurrTimeInMillis());
/*     */         
/* 113 */         if (!RoleStatusInterface.setStatus(RSingleJoinBattle.this.roleId, 1511, true))
/*     */         {
/* 115 */           GameServer.logger().error(String.format("[singlebattle]PSingleJoinBattle.processImp@ set state err! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(RSingleJoinBattle.this.roleId), Long.valueOf(RSingleJoinBattle.this._battleId) }));
/*     */           
/*     */ 
/* 118 */           return false;
/*     */         }
/* 120 */         this.isFristJoin = true;
/*     */       }
/*     */       
/* 123 */       return true;
/*     */     }
/*     */     
/*     */     public boolean isFristJoin()
/*     */     {
/* 128 */       return this.isFristJoin;
/*     */     }
/*     */   }
/*     */   
/*     */   private class SynBattleInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private SynBattleInfo() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 139 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(RSingleJoinBattle.this._battleId, true);
/* 140 */       if (globalInfo == null)
/*     */       {
/* 142 */         GameServer.logger().error(String.format("[singlebattle]PSingleJoinBattle.processImp@ no xGlobalInfo! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(RSingleJoinBattle.this.roleId), Long.valueOf(RSingleJoinBattle.this._battleId) }));
/*     */         
/*     */ 
/* 145 */         return false;
/*     */       }
/* 147 */       SingleBattleManager.onRoleJoinBattle(globalInfo, RSingleJoinBattle.this.roleId, RSingleJoinBattle.this._campId);
/* 148 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\RSingleJoinBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */