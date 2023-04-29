/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STSingleBattlePlayLibCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSingleBattle;
/*     */ import xtable.Role2singlebattle;
/*     */ 
/*     */ public class PCTryFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long passiveRoleId;
/*     */   private int _battleCfgId;
/*     */   private SSingleBattleCfg _battleCfg;
/*     */   private long _battleId;
/*     */   
/*     */   public PCTryFight(long roleId, long passiveRoleId)
/*     */   {
/*  22 */     this.roleId = roleId;
/*  23 */     this.passiveRoleId = passiveRoleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     RoleSingleBattle xRoleBattle1 = Role2singlebattle.select(Long.valueOf(this.roleId));
/*  35 */     if (xRoleBattle1 == null)
/*     */     {
/*  37 */       GameServer.logger().error(String.format("[singlebattle]PCTryFight.processImp@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     this._battleId = xRoleBattle1.getBattleid();
/*     */     
/*  44 */     int _campId = xRoleBattle1.getCampid();
/*     */     
/*  46 */     SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(this._battleId, true);
/*  47 */     if (globalInfo == null)
/*     */     {
/*  49 */       GameServer.logger().error(String.format("[singlebattle]PCTryFight.processImp@ no xGlobalInfo! |roleId=%d|battleId=%d|battleCfgId=%d|", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this._battleId), Integer.valueOf(xRoleBattle1.getBattlecfgid()) }));
/*     */       
/*     */ 
/*     */ 
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     int stage = globalInfo.getStage();
/*  57 */     if (stage != 2)
/*     */     {
/*  59 */       GameServer.logger().error(String.format("[singlebattle]PCTryFight.processImp@ not in match stage! |roleId=%d|battleId=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this._battleId), Integer.valueOf(stage) }));
/*     */       
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     lock(xtable.Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.passiveRoleId) }));
/*     */     
/*  67 */     xRoleBattle1 = Role2singlebattle.get(Long.valueOf(this.roleId));
/*  68 */     if (xRoleBattle1 == null)
/*     */     {
/*  70 */       GameServer.logger().error(String.format("[singlebattle]PCTryFight.processImp@ recheck no RoleSingleBattle! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this._battleId) }));
/*     */       
/*     */ 
/*  73 */       return false;
/*     */     }
/*  75 */     RoleSingleBattle xRoleBattle2 = Role2singlebattle.select(Long.valueOf(this.passiveRoleId));
/*  76 */     if (xRoleBattle2 == null)
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[singlebattle]PCTryFight.processImp@ no xRoleBattleData2! |roleId=%d|battleId=%d|battleCfgId=%d|passiveRoleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this._battleId), Integer.valueOf(xRoleBattle1.getBattlecfgid()), Long.valueOf(this.passiveRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*  84 */     if (xRoleBattle2.getBattleid() != this._battleId)
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[singlebattle]PCTryFight.processImp@ no in same battle! |roleId=%d|battleId=%d|battleCfgId=%d|passiveRoleId=%d|battle2=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this._battleId), Integer.valueOf(xRoleBattle1.getBattlecfgid()), Long.valueOf(this.passiveRoleId), Long.valueOf(xRoleBattle2.getBattleid()) }));
/*     */       
/*     */ 
/*     */ 
/*  90 */       return false;
/*     */     }
/*  92 */     if (_campId == xRoleBattle2.getCampid())
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[singlebattle]PCTryFight.processImp@ same camp! |roleId=%d|battleId=%d|battleCfgId=%d|passiveRoleId=%d|campId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this._battleId), Integer.valueOf(xRoleBattle1.getBattlecfgid()), Long.valueOf(this.passiveRoleId), Integer.valueOf(_campId) }));
/*     */       
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     this._battleCfg = globalInfo.getBattleCfg();
/*     */     
/* 104 */     if (!canJoinFight(this.roleId, this.passiveRoleId))
/*     */     {
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     mzm.gsp.fight.main.FightInterface.startPVPFight(this.roleId, this.passiveRoleId, new SingleBattleFightContext(this._battleId, globalInfo.getBattleCfgId()), 24, FightReason.SINGLE_BATTLE_FIGHT);
/*     */     
/*     */ 
/*     */ 
/* 113 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean canJoinFight(long activeRoleId, long passiveRoleId)
/*     */   {
/* 125 */     STSingleBattlePlayLibCfg playLibCfg = STSingleBattlePlayLibCfg.get(this._battleCfg.playLibId);
/* 126 */     if (playLibCfg == null)
/*     */     {
/* 128 */       GameServer.logger().error(String.format("[singleBattle]PCTryFight.canJoinFight@ STSingleBattlePlayLibCfg is null!|battleCfgId=%d|playLibId=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId) }));
/*     */       
/*     */ 
/*     */ 
/* 132 */       return false;
/*     */     }
/* 134 */     for (Map.Entry<Integer, Integer> entry : playLibCfg.type2cfgId.entrySet())
/*     */     {
/* 136 */       EachPlayTypeHandler handler = SingleBattleRegisterManager.getEachPlayTypeHandler(((Integer)entry.getKey()).intValue());
/* 137 */       if (handler == null)
/*     */       {
/* 139 */         GameServer.logger().error(String.format("[singleBattle]PCTryFight.canJoinFight@ EachPlayTypeHandler is null!|battleCfgId=%d|playLibId=%d|playType=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId), entry.getKey() }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 145 */       else if (!handler.canFight(this._battleId, ((Integer)entry.getValue()).intValue(), activeRoleId, passiveRoleId))
/*     */       {
/* 147 */         GameServer.logger().error(String.format("[singleBattle]PCTryFight.canJoinFight@ forbid fight!|battleCfgId=%d|playLibId=%d|playType=%d|playCfgId=%d|activeRoleId=%d|passiveRoleId=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId), entry.getKey(), entry.getValue(), Long.valueOf(activeRoleId), Long.valueOf(passiveRoleId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 152 */         return false;
/*     */       }
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\PCTryFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */