/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xdb.Executor;
/*     */ 
/*     */ public class PNotifyFightResult extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long corpsId;
/*     */   private final long opponentCorpsId;
/*     */   private final int knockOutType;
/*     */   private final int fightStage;
/*     */   private final int fightIndexId;
/*     */   private final int winOrLose;
/*     */   private final int repeatTimes;
/*     */   
/*     */   public PNotifyFightResult(long roleId, long corpsId, long opponentCorpsId, int knockOutType, int fightStage, int fightIndexId, int winOrLose)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.corpsId = corpsId;
/*  35 */     this.opponentCorpsId = opponentCorpsId;
/*  36 */     this.knockOutType = knockOutType;
/*  37 */     this.fightStage = fightStage;
/*  38 */     this.fightIndexId = fightIndexId;
/*  39 */     this.winOrLose = winOrLose;
/*  40 */     this.repeatTimes = 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public PNotifyFightResult(long roleId, long corpsId, long opponentCorpsId, int knockOutType, int fightStage, int fightIndexId, int winOrLose, int repeatTimes)
/*     */   {
/*  46 */     this.roleId = roleId;
/*  47 */     this.corpsId = corpsId;
/*  48 */     this.opponentCorpsId = opponentCorpsId;
/*  49 */     this.knockOutType = knockOutType;
/*  50 */     this.fightStage = fightStage;
/*  51 */     this.fightIndexId = fightIndexId;
/*  52 */     this.winOrLose = winOrLose;
/*  53 */     this.repeatTimes = repeatTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  59 */     int activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*  60 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  61 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  63 */       log(-1);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  68 */     if (knockOutCfg == null)
/*     */     {
/*  70 */       log(-2);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/*  75 */     if (knockOutHandler == null)
/*     */     {
/*  77 */       log(-3);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgId);
/*  82 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = xtable.Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*  83 */     if (xCrossBattleKnockoutActivityInfo == null)
/*     */     {
/*  85 */       log(-4);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     
/*  91 */     if (xCrossBattleKnockoutInfo == null)
/*     */     {
/*  93 */       log(-5);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     int fightZoneId = CrossBattleKnockoutManager.getFightZone(this.corpsId, activityCfgId, this.knockOutType);
/*  98 */     if (fightZoneId < 0)
/*     */     {
/* 100 */       log(-6);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(fightZoneId));
/* 105 */     if (xFightZoneInfo == null)
/*     */     {
/* 107 */       log(-7);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(this.fightStage));
/* 112 */     if (xFightStageInfo == null)
/*     */     {
/* 114 */       log(-8);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)xFightStageInfo.getFight_against_info_map().get(Integer.valueOf(this.fightIndexId));
/* 119 */     if (xFightAgainstInfo == null)
/*     */     {
/* 121 */       log(-9);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     if (xFightAgainstInfo.getCal_fight_result() == 0)
/*     */     {
/* 127 */       if (this.repeatTimes < 10)
/*     */       {
/* 129 */         xdb.Xdb.executor().schedule(new PQueryToNotifyFightResult(this.roleId, this.corpsId, this.opponentCorpsId, this.knockOutType, this.fightStage, this.fightIndexId, this.winOrLose, this.repeatTimes + 1), (this.repeatTimes + 1) * 1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 134 */       log(-10);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     long corpsIdA = xFightAgainstInfo.getA_corps_id();
/* 139 */     long corpsIdB = xFightAgainstInfo.getB_corps_id();
/*     */     
/* 141 */     Pair<Long, Pair<Integer, Integer>> winCorpsIdPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), corpsIdA, corpsIdB, this.fightStage, this.fightIndexId, knockOutCfg.fight_times_every_stage);
/*     */     
/*     */ 
/* 144 */     xio.Protocol notifyFightResult = null;
/* 145 */     if (((Long)winCorpsIdPair.first).longValue() == -1L)
/*     */     {
/* 147 */       if (this.fightStage % knockOutCfg.fight_times_every_stage == 0)
/*     */       {
/* 149 */         notifyFightResult = knockOutHandler.getNotifyFightResult(0, 1);
/*     */       }
/*     */       else
/*     */       {
/* 153 */         notifyFightResult = knockOutHandler.getNotifyFightResult(this.winOrLose, 0);
/*     */       }
/*     */     }
/* 156 */     else if (((Long)winCorpsIdPair.first).longValue() == this.corpsId)
/*     */     {
/* 158 */       notifyFightResult = knockOutHandler.getNotifyFightResult(1, 1);
/*     */     }
/* 160 */     else if (((Long)winCorpsIdPair.first).longValue() == this.opponentCorpsId)
/*     */     {
/* 162 */       notifyFightResult = knockOutHandler.getNotifyFightResult(0, 1);
/*     */     }
/*     */     
/* 165 */     if (notifyFightResult == null)
/*     */     {
/* 167 */       Map<String, Object> extraMap = new HashMap();
/* 168 */       extraMap.put("win_corps_id", winCorpsIdPair.first);
/* 169 */       extraMap.put("win_score", ((Pair)winCorpsIdPair.second).first);
/* 170 */       extraMap.put("lost_score", ((Pair)winCorpsIdPair.second).second);
/*     */       
/* 172 */       log(-11, extraMap);
/*     */       
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     OnlineManager.getInstance().send(this.roleId, notifyFightResult);
/*     */     
/* 179 */     Map<String, Object> extraMap = new HashMap();
/* 180 */     extraMap.put("win_corps_id", winCorpsIdPair.first);
/* 181 */     extraMap.put("win_score", ((Pair)winCorpsIdPair.second).first);
/* 182 */     extraMap.put("lost_score", ((Pair)winCorpsIdPair.second).second);
/* 183 */     log(1, extraMap);
/* 184 */     return true;
/*     */   }
/*     */   
/*     */   private void log(int ret)
/*     */   {
/* 189 */     log(ret, null);
/*     */   }
/*     */   
/*     */   private void log(int ret, Map<String, Object> extraMap)
/*     */   {
/* 194 */     StringBuilder sBuilder = new StringBuilder();
/* 195 */     sBuilder.append("[crossbattle_knockout]PNotifyFightResult.processImp");
/* 196 */     sBuilder.append("|ret=").append(ret);
/* 197 */     sBuilder.append("role_id=").append(this.roleId);
/* 198 */     sBuilder.append("corps_id=").append(this.corpsId);
/* 199 */     sBuilder.append("opponent_corps_id=").append(this.opponentCorpsId);
/* 200 */     sBuilder.append("knock_out_type=").append(this.knockOutType);
/* 201 */     sBuilder.append("fight_stage=").append(this.fightStage);
/* 202 */     sBuilder.append("fight_index_id=").append(this.fightIndexId);
/* 203 */     sBuilder.append("win_or_list=").append(this.winOrLose);
/* 204 */     sBuilder.append("repeat_times=").append(this.repeatTimes);
/*     */     
/* 206 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 208 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 210 */         sBuilder.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 214 */     GameServer.logger().error(sBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PNotifyFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */