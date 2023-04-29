/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STSingleBattlePlayLibCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleSingleBattle;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2singlebattle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingleBattleInterface
/*     */ {
/*     */   public static void activeLevelBattle(long roleId)
/*     */   {
/*  24 */     SingleBattleManager.activeLevelBattle(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getBattleId(long roleId, boolean remainRoleLock)
/*     */   {
/*     */     RoleSingleBattle xRoleBattle;
/*     */     
/*     */ 
/*     */ 
/*     */     RoleSingleBattle xRoleBattle;
/*     */     
/*     */ 
/*     */ 
/*  41 */     if (remainRoleLock)
/*     */     {
/*  43 */       xRoleBattle = Role2singlebattle.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  47 */       xRoleBattle = Role2singlebattle.select(Long.valueOf(roleId));
/*     */     }
/*  49 */     if (xRoleBattle == null)
/*     */     {
/*  51 */       return -1L;
/*     */     }
/*  53 */     return xRoleBattle.getBattleid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SingleBattleGlobalInfo getSingleBattleGlobalInfo(long battleId, boolean remainBattleLock)
/*     */   {
/*  69 */     return SingleBattleManager.getBattleGlobalInfo(battleId, remainBattleLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RoleBattleBaseInfo getRoleBattleBaseInfo(long roleId, boolean remainRoleLock)
/*     */   {
/*  83 */     RoleBattleBaseInfo roleBattleBaseInfo = new RoleBattleBaseInfo(roleId, remainRoleLock);
/*  84 */     return roleBattleBaseInfo.getxRoleSingleBattle() == null ? null : roleBattleBaseInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void battleBro(long battleId, Protocol p, boolean atOnce)
/*     */   {
/* 101 */     if (p == null)
/*     */     {
/* 103 */       return;
/*     */     }
/* 105 */     SingleBattleGlobalInfo globalInfo = getSingleBattleGlobalInfo(battleId, false);
/* 106 */     if (globalInfo == null)
/*     */     {
/* 108 */       return;
/*     */     }
/* 110 */     globalInfo.battleBro(p, atOnce);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void battleCampBro(long battleId, int campId, Protocol p, boolean atOnce)
/*     */   {
/* 127 */     if (p == null)
/*     */     {
/* 129 */       return;
/*     */     }
/* 131 */     SingleBattleGlobalInfo globalInfo = getSingleBattleGlobalInfo(battleId, false);
/* 132 */     if (globalInfo == null)
/*     */     {
/* 134 */       return;
/*     */     }
/* 136 */     globalInfo.campBro(campId, p, atOnce);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerPlayHandler(int playType, EachPlayTypeHandler handler)
/*     */   {
/* 149 */     SingleBattleRegisterManager.registerPlayHandler(playType, handler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static CreateSingleBattleInfo startSingleBattle(int battleCfgId, Set<Long> roleIds_1, Set<Long> roleIds_2, SingleBattleContext context)
/*     */   {
/* 169 */     PStartSingleBattle p = new PStartSingleBattle(battleCfgId, roleIds_1, roleIds_2, context);
/* 170 */     p.createBattle();
/* 171 */     return p.getCreateSingleBattleInfo();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void joinBattle(long battleId, long roleId)
/*     */   {
/* 181 */     BattleTaskOneByOne.getInstance().addLogicRunnable(Long.valueOf(battleId), new RSingleJoinBattle(battleId, roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getRoleNumber(long roleId)
/*     */   {
/* 195 */     Integer num = Role2singlebattle.selectNumber(Long.valueOf(roleId));
/* 196 */     return num == null ? -1 : num.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addCampSource(long battleId, int campId, final int value)
/*     */   {
/* 210 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(battleId), new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 216 */         return SingleBattleManager.addCampSource(this.val$battleId, value, this.val$value);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addCampSource(long battleId, Map<Integer, Integer> campId2AddValue)
/*     */   {
/* 233 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(battleId), new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 239 */         return SingleBattleManager.addCampSource(this.val$battleId, this.val$campId2AddValue);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addRolePoint(long battleId, int campId, final long roleId, final int value)
/*     */   {
/* 255 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(battleId), new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 261 */         return SingleBattleManager.handRolePoint(this.val$battleId, roleId, value, this.val$value, true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void cutRolePoint(long battleId, int campId, final long roleId, final int value)
/*     */   {
/* 277 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(battleId), new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 283 */         return SingleBattleManager.handRolePoint(this.val$battleId, roleId, value, this.val$value, false);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMatchIngStage(long battleId, boolean remainSingleBattleLock)
/*     */   {
/* 299 */     return getStage(battleId, remainSingleBattleLock) == 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getStage(long battleId, boolean remainSingleBattleLock)
/*     */   {
/* 313 */     SingleBattleGlobalInfo globalInfo = getSingleBattleGlobalInfo(battleId, remainSingleBattleLock);
/* 314 */     if (globalInfo == null)
/*     */     {
/* 316 */       return -1;
/*     */     }
/* 318 */     return globalInfo.getStage();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getPlayType2CfgId(int battleCfgId)
/*     */   {
/* 331 */     SSingleBattleCfg cfg = SSingleBattleCfg.get(battleCfgId);
/* 332 */     if (cfg == null)
/*     */     {
/* 334 */       return Collections.emptyMap();
/*     */     }
/* 336 */     STSingleBattlePlayLibCfg playLibCfg = STSingleBattlePlayLibCfg.get(cfg.playLibId);
/* 337 */     if (playLibCfg == null)
/*     */     {
/* 339 */       return Collections.emptyMap();
/*     */     }
/* 341 */     return playLibCfg.type2cfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getShouldMemberNum(int battleType)
/*     */   {
/* 352 */     return SingleBattleMemberManager.getInstance().getShouldMemberNum(battleType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getValidMemberNum(int battleType)
/*     */   {
/* 363 */     return SingleBattleMemberManager.getInstance().getValidMemberNum(battleType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum LeaveBattleReason
/*     */   {
/* 374 */     ACTIVE_LEAVE, 
/* 375 */     OVER_CLEAN;
/*     */     
/*     */     private LeaveBattleReason() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */