/*     */ package mzm.gsp.lifeskillactivity.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SLifeSkillActivityCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Gang;
/*     */ import xbean.GangDutyMembers;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LifeSkillActivityManager
/*     */ {
/*     */   static boolean isFunOpen(int activityId)
/*     */   {
/*  24 */     SLifeSkillActivityCfg sLifeSkillActivityCfg = SLifeSkillActivityCfg.get(activityId);
/*  25 */     if (sLifeSkillActivityCfg == null) {
/*  26 */       return false;
/*     */     }
/*  28 */     if (!OpenInterface.getOpenStatus(sLifeSkillActivityCfg.openId))
/*     */     {
/*  30 */       GameServer.logger().error("[lifeskillactivity]LifeSkillActivityManager.isFunOpen@fun not open");
/*  31 */       return false;
/*     */     }
/*  33 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFunOpen(long roleid, int openId)
/*     */   {
/*  44 */     if (!OpenInterface.getOpenStatus(openId))
/*     */     {
/*  46 */       GameServer.logger().error("[lifeskillactivity]LifeSkillActivityManager.isFunOpen@fun not open");
/*  47 */       return false;
/*     */     }
/*  49 */     if (OpenInterface.isBanPlay(roleid, openId))
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[lifeskillactivity]LifeSkillActivityManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*  52 */       OpenInterface.sendBanPlayMsg(roleid, openId);
/*  53 */       return false;
/*     */     }
/*  55 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNpcController(int activityCfgid)
/*     */   {
/*  65 */     SLifeSkillActivityCfg sLifeSkillActivityCfg = SLifeSkillActivityCfg.get(activityCfgid);
/*  66 */     if (sLifeSkillActivityCfg == null)
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[lifeskillactivity]LifeSkillActivityManager.getNpcController@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*     */       
/*  70 */       return -1;
/*     */     }
/*  72 */     SNpc npc = NpcInterface.getNpc(sLifeSkillActivityCfg.npcCfgId);
/*  73 */     if (npc == null)
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[lifeskillactivity]LifeSkillActivityManager.getNpcController@npc cfg is null|activity_cfgid=%d|npc_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(sLifeSkillActivityCfg.npcCfgId) }));
/*     */       
/*     */ 
/*  78 */       return -1;
/*     */     }
/*  80 */     return npc.controllerId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onOpenChange(int activityCfgid, boolean open)
/*     */   {
/*  90 */     if (!ActivityInterface.isActivityOpen(activityCfgid))
/*     */     {
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     int controller = getNpcController(activityCfgid);
/*  96 */     if (controller <= 0)
/*     */     {
/*  98 */       return;
/*     */     }
/*     */     
/* 101 */     if (open)
/*     */     {
/* 103 */       ControllerInterface.triggerController(controller);
/*     */     }
/*     */     else
/*     */     {
/* 107 */       ControllerInterface.collectController(controller);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInGang(Gang xGang, long roleid)
/*     */   {
/* 119 */     for (GangDutyMembers xMembers : xGang.getDuty2members().values()) {
/* 120 */       if (xMembers.getMembers().contains(Long.valueOf(roleid))) {
/* 121 */         return true;
/*     */       }
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static TLogArg newTLogArg(int currencyType)
/*     */   {
/* 136 */     switch (currencyType)
/*     */     {
/*     */     case 0: 
/* 139 */       return new TLogArg(LogReason.LIFE_SKILL_ACTIVITY_COST_NULL);
/*     */     
/*     */     case 1: 
/* 142 */       return new TLogArg(LogReason.LIFE_SKILL_ACTIVITY_COST_YUAN_BAO);
/*     */     
/*     */     case 2: 
/* 145 */       return new TLogArg(LogReason.LIFE_SKILL_ACTIVITY_COST_GOLD);
/*     */     
/*     */     case 3: 
/* 148 */       return new TLogArg(LogReason.LIFE_SKILL_ACTIVITY_COST_SILVER);
/*     */     
/*     */     case 5: 
/* 151 */       return new TLogArg(LogReason.LIFE_SKILL_ACTIVITY_COST_JIN_DING);
/*     */     
/*     */     case 4: 
/* 154 */       return new TLogArg(LogReason.LIFE_SKILL_ACTIVITY_COST_BANG_GONG);
/*     */     }
/*     */     
/* 157 */     GameServer.logger().error(String.format("[lifeskillactivity]LifeSkillActivityManager.newTLogArg@not support the currency type|currency_type=%d", new Object[] { Integer.valueOf(currencyType) }));
/*     */     
/*     */ 
/*     */ 
/* 161 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskillactivity\main\LifeSkillActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */