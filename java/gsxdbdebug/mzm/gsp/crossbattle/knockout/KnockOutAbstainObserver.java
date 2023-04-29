/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KnockOutAbstainObserver
/*     */   extends MilliObserver
/*     */ {
/*     */   private final long corpsId;
/*     */   private final String corpsName;
/*     */   private final long opponentCorpsId;
/*     */   private final String opponentCorpsName;
/*     */   private final int knockOutType;
/*     */   private final int fightStage;
/*     */   private final int fightIndexId;
/*     */   
/*     */   public KnockOutAbstainObserver(long intervalMilliSeconds, long corpsId, String corpsName, long opponentCorpsId, String opponentCorpsName, int knockOutType, int selectionStage, int fightIndexId)
/*     */   {
/*  41 */     super(intervalMilliSeconds);
/*  42 */     this.corpsId = corpsId;
/*  43 */     this.corpsName = corpsName;
/*  44 */     this.opponentCorpsId = opponentCorpsId;
/*  45 */     this.opponentCorpsName = opponentCorpsName;
/*  46 */     this.knockOutType = knockOutType;
/*  47 */     this.fightStage = selectionStage;
/*  48 */     this.fightIndexId = fightIndexId;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  54 */     StringBuilder contextBuilder = new StringBuilder();
/*  55 */     contextBuilder.append("knock_out_abstain_observer={");
/*  56 */     contextBuilder.append("|corps_id=").append(this.corpsId);
/*  57 */     contextBuilder.append("|corps_name=").append(this.corpsName);
/*  58 */     contextBuilder.append("|opponent_corps_id=").append(this.opponentCorpsId);
/*  59 */     contextBuilder.append("|opponent_corps_name=").append(this.opponentCorpsName);
/*  60 */     contextBuilder.append("|knock_out_type=").append(this.knockOutType);
/*  61 */     contextBuilder.append("|fight_stage=").append(this.fightStage);
/*  62 */     contextBuilder.append("|fight_index_id=").append(this.fightIndexId);
/*  63 */     contextBuilder.append("}");
/*     */     
/*  65 */     return contextBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  71 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new POnKnockOutAbstain(this.corpsId, this.corpsName, this.opponentCorpsId, this.opponentCorpsName, this.knockOutType, this.fightStage, this.fightIndexId));
/*     */     
/*     */ 
/*     */ 
/*  75 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class POnKnockOutAbstain
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long corpsId;
/*     */     
/*     */     private final String corpsName;
/*     */     
/*     */     private final long opponentCorpsId;
/*     */     
/*     */     private final String opponentCorpsName;
/*     */     
/*     */     private final int knockOutType;
/*     */     
/*     */     private final int fightStage;
/*     */     
/*     */     private final int fightIndexId;
/*     */     
/*     */     public POnKnockOutAbstain(long corpsId, String corpsName, long opponentCorpsId, String opponentCorpsName, int knockOutType, int selectionStage, int fightIndexId)
/*     */     {
/*  98 */       this.corpsId = corpsId;
/*  99 */       this.corpsName = corpsName;
/* 100 */       this.opponentCorpsId = opponentCorpsId;
/* 101 */       this.opponentCorpsName = opponentCorpsName;
/* 102 */       this.knockOutType = knockOutType;
/* 103 */       this.fightStage = selectionStage;
/* 104 */       this.fightIndexId = fightIndexId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 110 */       int nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*     */       
/* 112 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(nowActivityCfgId);
/* 113 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 115 */         log(-1);
/* 116 */         return false;
/*     */       }
/*     */       
/* 119 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 120 */       if (knockOutCfg == null)
/*     */       {
/* 122 */         log(-2);
/* 123 */         return false;
/*     */       }
/*     */       
/* 126 */       int maxFightStage = knockOutCfg.stage_time_point_cfg_id_list.size();
/*     */       
/* 128 */       int fightZoneId = CrossBattleKnockoutManager.getFightZone(this.corpsId, nowActivityCfgId, this.knockOutType);
/*     */       
/* 130 */       String fightResultStr = String.valueOf(SignalFightResultEnum.ABSTAIN_LOSE.fightResult);
/*     */       
/*     */ 
/* 133 */       boolean isSendGrcSuccess = GrcInterface.reportCrossBattleKnockOutFightResult(nowActivityCfgId, this.knockOutType, fightZoneId, this.fightStage, this.corpsId, this.corpsName, this.opponentCorpsId, this.opponentCorpsName, this.fightIndexId, maxFightStage, knockOutCfg.fight_times_every_stage, fightResultStr);
/*     */       
/*     */ 
/*     */ 
/* 137 */       if (!isSendGrcSuccess)
/*     */       {
/* 139 */         Xdb.executor().schedule(new RRepeatReportCrossBattleKnockOutFightResult(nowActivityCfgId, this.knockOutType, fightZoneId, this.fightStage, this.corpsId, this.corpsName, this.opponentCorpsId, this.opponentCorpsName, this.fightIndexId, maxFightStage, knockOutCfg.fight_times_every_stage, fightResultStr, 1), 60L, TimeUnit.MILLISECONDS);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */       List<Long> roleIdList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(this.corpsId, nowActivityCfgId, true);
/*     */       
/*     */       Iterator i$;
/* 151 */       if ((roleIdList != null) && (!roleIdList.isEmpty()))
/*     */       {
/* 153 */         for (i$ = roleIdList.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 155 */           Xdb.executor().schedule(new Runnable()
/*     */           {
/*     */ 
/*     */ 
/*     */             public void run() {
/* 160 */               new PQueryToNotifyFightResult(roleId, KnockOutAbstainObserver.POnKnockOutAbstain.this.corpsId, KnockOutAbstainObserver.POnKnockOutAbstain.this.opponentCorpsId, KnockOutAbstainObserver.POnKnockOutAbstain.this.knockOutType, KnockOutAbstainObserver.POnKnockOutAbstain.this.fightStage, KnockOutAbstainObserver.POnKnockOutAbstain.this.fightIndexId, 0).execute(); } }, 2000L, TimeUnit.MILLISECONDS);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 167 */       StringBuilder sb = new StringBuilder();
/* 168 */       sb.append("[crossbattle_knockout]POnKnockOutAbstain.processImp@corps abstain");
/* 169 */       sb.append("|corps_id=").append(this.corpsId);
/* 170 */       sb.append("|corps_name=").append(this.corpsName);
/* 171 */       sb.append("|opponent_corps_id=").append(this.opponentCorpsId);
/* 172 */       sb.append("|opponent_corps_name=").append(this.opponentCorpsName);
/* 173 */       sb.append("|knock_out_type=").append(this.knockOutType);
/* 174 */       sb.append("|fight_stage=").append(this.fightStage);
/* 175 */       sb.append("|fight_index_id=").append(this.fightIndexId);
/* 176 */       sb.append("|max_fight_stage=").append(maxFightStage);
/* 177 */       sb.append("|fight_zone_id=").append(fightZoneId);
/* 178 */       sb.append("|fight_result_str=").append(fightResultStr);
/* 179 */       sb.append("|is_send_grc_success=").append(isSendGrcSuccess);
/*     */       
/* 181 */       GameServer.logger().info(sb.toString());
/*     */       
/* 183 */       KnockOutTLogManager.tlogKnockOutFightResult(nowActivityCfgId, this.knockOutType, fightZoneId, this.fightStage, this.fightIndexId, this.corpsId, this.corpsName, this.opponentCorpsId, this.opponentCorpsName, Integer.valueOf(fightResultStr).intValue());
/*     */       
/*     */ 
/* 186 */       return true;
/*     */     }
/*     */     
/*     */     private void log(int ret)
/*     */     {
/* 191 */       log(ret, null);
/*     */     }
/*     */     
/*     */     private void log(int ret, Map<String, Object> extraMap)
/*     */     {
/* 196 */       StringBuilder sb = new StringBuilder();
/* 197 */       sb.append("[crossbattle_knockout]POnKnockOutAbstain.processImp@corps abstain");
/* 198 */       sb.append("|corps_id=").append(this.corpsId);
/* 199 */       sb.append("|corps_name=").append(this.corpsName);
/* 200 */       sb.append("|opponent_corps_id=").append(this.opponentCorpsId);
/* 201 */       sb.append("|opponent_corps_name=").append(this.opponentCorpsName);
/* 202 */       sb.append("|knock_out_type=").append(this.knockOutType);
/* 203 */       sb.append("|fight_stage=").append(this.fightStage);
/* 204 */       sb.append("|fight_index_id=").append(this.fightIndexId);
/*     */       
/* 206 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 208 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 210 */           sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */         }
/*     */       }
/*     */       
/* 214 */       GameServer.logger().error(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutAbstainObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */