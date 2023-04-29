/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_CreatePrepareWorld;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class POnGetNotifyCorpsIdSet
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int knockOutType;
/*     */   private final int fightStage;
/*     */   private final Set<Long> corpsIdSet;
/*     */   private final boolean isRestart;
/*     */   
/*     */   public POnGetNotifyCorpsIdSet(int knockOutType, int fightStage, Set<Long> corpsIdSet)
/*     */   {
/*  46 */     this.knockOutType = knockOutType;
/*  47 */     this.fightStage = fightStage;
/*  48 */     this.corpsIdSet = corpsIdSet;
/*  49 */     this.isRestart = false;
/*     */   }
/*     */   
/*     */ 
/*     */   public POnGetNotifyCorpsIdSet(int knockOutType, int fightStage, Set<Long> corpsIdSet, boolean isRestart)
/*     */   {
/*  55 */     this.knockOutType = knockOutType;
/*  56 */     this.fightStage = fightStage;
/*  57 */     this.corpsIdSet = corpsIdSet;
/*  58 */     this.isRestart = isRestart;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  64 */     int currentActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*     */     
/*  66 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(currentActivityCfgId);
/*  67 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  73 */     if (knockOutCfg == null)
/*     */     {
/*  75 */       return false;
/*     */     }
/*  77 */     if (!this.isRestart)
/*     */     {
/*     */ 
/*     */ 
/*  81 */       SBulletinInfo sBulletinInfo = getStageStartBullet();
/*  82 */       BulletinInterface.sendBulletin(sBulletinInfo);
/*     */     }
/*     */     
/*  85 */     for (Iterator i$ = this.corpsIdSet.iterator(); i$.hasNext();) { long corpsId = ((Long)i$.next()).longValue();
/*     */       
/*  87 */       int corposIdFightZoneId = CrossBattleKnockoutManager.getFightZone(corpsId, currentActivityCfgId, this.knockOutType);
/*     */       
/*  89 */       if (corposIdFightZoneId <= 0)
/*     */       {
/*  91 */         Map<String, Object> extraMap = new HashMap();
/*  92 */         extraMap.put("fight_stage", Integer.valueOf(this.fightStage));
/*  93 */         extraMap.put("corps_id", Long.valueOf(corpsId));
/*  94 */         extraMap.put("corps_id_set", this.corpsIdSet.toString());
/*     */         
/*  96 */         onGetNotifyCropsIdSetFail(-2, extraMap);
/*     */       }
/*     */       else
/*     */       {
/* 100 */         GetKnockOutContext_CreatePrepareWorld createPrepareWorld = new GetKnockOutContext_CreatePrepareWorld(corpsId, this.fightStage);
/*     */         
/*     */ 
/* 103 */         OctetsStream octetsStream = new OctetsStream();
/* 104 */         octetsStream.marshal(createPrepareWorld);
/*     */         
/* 106 */         GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 107 */         getKnockOutContext.oper_type = 2;
/* 108 */         getKnockOutContext.content = octetsStream;
/*     */         
/* 110 */         GrcInterface.getCrossBattleKnockOutInfo(currentActivityCfgId, this.knockOutType, corposIdFightZoneId, this.fightStage, knockOutCfg.need_team_size, knockOutCfg.stage_time_point_cfg_id_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 115 */     StringBuilder sb = new StringBuilder();
/* 116 */     sb.append("[crossbattle_knockout]PCreateKnockOutPrepareWorld.processImp@create prepare world success");
/* 117 */     sb.append("|knock_out_type=").append(this.knockOutType);
/* 118 */     sb.append("|fight_stage=").append(this.fightStage);
/* 119 */     sb.append("|corps_id_set=").append(this.corpsIdSet.toString());
/* 120 */     sb.append("|is_restart=").append(this.isRestart);
/*     */     
/* 122 */     GameServer.logger().info(sb.toString());
/* 123 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private SBulletinInfo getStageStartBullet()
/*     */   {
/* 132 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/*     */     
/* 134 */     switch (this.knockOutType)
/*     */     {
/*     */     case 1: 
/* 137 */       sBulletinInfo.bulletintype = 37;
/* 138 */       return sBulletinInfo;
/*     */     
/*     */     case 2: 
/* 141 */       sBulletinInfo.bulletintype = 42;
/* 142 */       return sBulletinInfo;
/*     */     }
/* 144 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onGetNotifyCropsIdSetFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 150 */     StringBuilder sb = new StringBuilder();
/* 151 */     sb.append("[crossbattle_knockout]POnGetNotifyCorpsIdSet.processImp@error");
/* 152 */     sb.append("|ret=").append(ret);
/* 153 */     sb.append("|fight_stage=").append(this.fightStage);
/* 154 */     sb.append("|knock_out_type=").append(this.knockOutType);
/* 155 */     sb.append("|corps_id_set=").append(this.corpsIdSet);
/* 156 */     sb.append("|is_restart=").append(this.isRestart);
/*     */     
/* 158 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 160 */       Iterator<Map.Entry<String, Object>> iterator = extraMap.entrySet().iterator();
/* 161 */       while (iterator.hasNext())
/*     */       {
/* 163 */         Map.Entry<String, Object> entry = (Map.Entry)iterator.next();
/* 164 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 168 */     GameServer.logger().error(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnGetNotifyCorpsIdSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */