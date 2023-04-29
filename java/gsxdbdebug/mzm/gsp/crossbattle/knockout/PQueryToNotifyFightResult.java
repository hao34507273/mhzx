/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_NotifyFightResult;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PQueryToNotifyFightResult
/*     */   extends LogicProcedure
/*     */   implements Runnable
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
/*     */   public PQueryToNotifyFightResult(long roleId, long corpsId, long opponentCorpsId, int knockOutType, int fightStage, int fightIndexId, int winOrLose)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.corpsId = corpsId;
/*  36 */     this.opponentCorpsId = opponentCorpsId;
/*  37 */     this.knockOutType = knockOutType;
/*  38 */     this.fightStage = fightStage;
/*  39 */     this.fightIndexId = fightIndexId;
/*  40 */     this.winOrLose = winOrLose;
/*  41 */     this.repeatTimes = 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public PQueryToNotifyFightResult(long roleId, long corpsId, long opponentCorpsId, int knockOutType, int fightStage, int fightIndexId, int winOrLose, int repeatTimes)
/*     */   {
/*  47 */     this.roleId = roleId;
/*  48 */     this.corpsId = corpsId;
/*  49 */     this.opponentCorpsId = opponentCorpsId;
/*  50 */     this.knockOutType = knockOutType;
/*  51 */     this.fightStage = fightStage;
/*  52 */     this.fightIndexId = fightIndexId;
/*  53 */     this.winOrLose = winOrLose;
/*  54 */     this.repeatTimes = repeatTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  60 */     GetKnockOutContext_NotifyFightResult notifyFightResult = new GetKnockOutContext_NotifyFightResult(this.roleId, this.corpsId, this.opponentCorpsId, this.knockOutType, this.fightStage, this.fightIndexId, this.winOrLose, this.repeatTimes);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  69 */     OctetsStream octetsStream = new OctetsStream();
/*  70 */     octetsStream.marshal(notifyFightResult);
/*     */     
/*  72 */     GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/*  73 */     getKnockOutContext.oper_type = 9;
/*  74 */     getKnockOutContext.content = octetsStream;
/*     */     
/*  76 */     int activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*     */     
/*  78 */     Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/*  79 */     if (nowFightStagePair == null)
/*     */     {
/*  81 */       log(-1);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     int fightZoneId = CrossBattleKnockoutManager.getFightZone(this.corpsId, activityCfgId, this.knockOutType);
/*  86 */     if (fightZoneId < 0)
/*     */     {
/*  88 */       log(-2);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(activityCfgId);
/*  93 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  95 */       log(-3);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 100 */     if (knockOutCfg == null)
/*     */     {
/* 102 */       log(-4);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     int nowFightStage = ((Integer)nowFightStagePair.first).intValue();
/*     */     
/* 108 */     boolean isSendSuccess = GrcInterface.getCrossBattleKnockOutInfo(activityCfgId, this.knockOutType, fightZoneId, nowFightStage, knockOutCfg.need_team_size, knockOutCfg.stage_time_point_cfg_id_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */     
/*     */ 
/*     */ 
/* 112 */     StringBuilder sb = new StringBuilder();
/* 113 */     sb.append("[crossbattle_knockout]PQueryToNotifyFightResult.processImp@query to notify fight result");
/* 114 */     sb.append("|role_id=").append(this.roleId);
/* 115 */     sb.append("|corps_id=").append(this.corpsId);
/* 116 */     sb.append("|opponent_corps_id=").append(this.opponentCorpsId);
/* 117 */     sb.append("|knock_out_type=").append(this.knockOutType);
/* 118 */     sb.append("|fight_stage=").append(this.fightStage);
/* 119 */     sb.append("|fight_index_id=").append(this.fightIndexId);
/* 120 */     sb.append("|win_or_lose=").append(this.winOrLose);
/* 121 */     sb.append("|repeat_times=").append(this.repeatTimes);
/* 122 */     sb.append("|is_send_sucess=").append(isSendSuccess);
/*     */     
/* 124 */     GameServer.logger().info(sb.toString());
/* 125 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void run()
/*     */   {
/* 131 */     execute();
/*     */   }
/*     */   
/*     */   private void log(int ret)
/*     */   {
/* 136 */     log(ret, null);
/*     */   }
/*     */   
/*     */   private void log(int ret, Map<String, Object> extraMap)
/*     */   {
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     sb.append("[crossbattle_knockout]PQueryToNotifyFightResult.processImp@error");
/* 143 */     sb.append("|ret=").append(ret);
/* 144 */     sb.append("|role_id=").append(this.roleId);
/* 145 */     sb.append("|corps_id=").append(this.corpsId);
/* 146 */     sb.append("|opponent_corps_id=").append(this.opponentCorpsId);
/* 147 */     sb.append("|knock_out_type=").append(this.knockOutType);
/* 148 */     sb.append("|fight_stage=").append(this.fightStage);
/* 149 */     sb.append("|fight_index_id=").append(this.fightIndexId);
/* 150 */     sb.append("|win_or_lose=").append(this.winOrLose);
/* 151 */     sb.append("|repeat_times=").append(this.repeatTimes);
/*     */     
/* 153 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 155 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 157 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 161 */     GameServer.logger().error(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PQueryToNotifyFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */