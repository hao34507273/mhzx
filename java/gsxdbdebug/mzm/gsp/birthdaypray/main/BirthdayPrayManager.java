/*     */ package mzm.gsp.birthdaypray.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.STGraph2ActivityId;
/*     */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.WorldCounterInfo;
/*     */ import xbean.WorldCounterReward;
/*     */ import xbean.WorldCounterRewardInfo;
/*     */ import xbean.WorldCounterRewardStages;
/*     */ import xtable.Role2worldcounterreward;
/*     */ import xtable.Worldcounter;
/*     */ 
/*     */ public class BirthdayPrayManager
/*     */ {
/*  21 */   static final Logger logger = Logger.getLogger("birthdaypray");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBirthdayPraySwitchOpen(int activityCfgid)
/*     */   {
/*  30 */     SBirthdayPrayCfg cfg = SBirthdayPrayCfg.get(activityCfgid);
/*  31 */     if (cfg == null)
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     if (!OpenInterface.getOpenStatus(cfg.openId))
/*     */     {
/*  37 */       return false;
/*     */     }
/*  39 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBirthdayPraySwitchOpen(long roleid, int openId)
/*     */   {
/*  50 */     if (!OpenInterface.getOpenStatus(openId))
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (OpenInterface.isBanPlay(roleid, openId))
/*     */     {
/*  56 */       OpenInterface.sendBanPlayMsg(roleid, openId);
/*  57 */       return false;
/*     */     }
/*  59 */     return true;
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
/*     */   static long addWorldCounterTimes(int index_1, int index_2, int changeTimes)
/*     */   {
/*  77 */     long globalIndex = GameServerInfoManager.toGlobalId(index_1);
/*     */     
/*  79 */     WorldCounterInfo xWorldCounterInfo = Worldcounter.get(Long.valueOf(globalIndex));
/*  80 */     if (xWorldCounterInfo == null)
/*     */     {
/*  82 */       xWorldCounterInfo = Pod.newWorldCounterInfo();
/*  83 */       Worldcounter.insert(Long.valueOf(globalIndex), xWorldCounterInfo);
/*     */     }
/*  85 */     Long oldTimes = (Long)xWorldCounterInfo.getIndex2times().get(Integer.valueOf(index_2));
/*  86 */     long nowTimes = (oldTimes == null ? 0L : oldTimes.longValue()) + changeTimes;
/*  87 */     xWorldCounterInfo.getIndex2times().put(Integer.valueOf(index_2), Long.valueOf(nowTimes));
/*  88 */     return nowTimes;
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
/*     */   static long getWorldCounterTimes(int index_1, int index_2, boolean retainLock)
/*     */   {
/* 106 */     long globalIndex = GameServerInfoManager.toGlobalId(index_1);
/*     */     WorldCounterInfo xWorldCounterInfo;
/*     */     WorldCounterInfo xWorldCounterInfo;
/* 109 */     if (retainLock)
/*     */     {
/* 111 */       xWorldCounterInfo = Worldcounter.get(Long.valueOf(globalIndex));
/*     */     }
/*     */     else
/*     */     {
/* 115 */       xWorldCounterInfo = Worldcounter.select(Long.valueOf(globalIndex));
/*     */     }
/* 117 */     if (xWorldCounterInfo == null)
/*     */     {
/* 119 */       return 0L;
/*     */     }
/* 121 */     Long nowTimes = (Long)xWorldCounterInfo.getIndex2times().get(Integer.valueOf(index_2));
/* 122 */     return nowTimes == null ? 0L : nowTimes.longValue();
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
/*     */   static WorldCounterRewardInfo getWorldCounterRewardInfo(long roleId, int index_1)
/*     */   {
/* 136 */     WorldCounterReward xWorldCounterReward = Role2worldcounterreward.get(Long.valueOf(roleId));
/* 137 */     if (xWorldCounterReward == null)
/*     */     {
/* 139 */       xWorldCounterReward = Pod.newWorldCounterReward();
/* 140 */       Role2worldcounterreward.insert(Long.valueOf(roleId), xWorldCounterReward);
/*     */     }
/* 142 */     WorldCounterRewardInfo xWorldCounterRewardInfo = (WorldCounterRewardInfo)xWorldCounterReward.getReward_info().get(Integer.valueOf(index_1));
/* 143 */     if (xWorldCounterRewardInfo == null)
/*     */     {
/* 145 */       xWorldCounterRewardInfo = Pod.newWorldCounterRewardInfo();
/* 146 */       xWorldCounterReward.getReward_info().put(Integer.valueOf(index_1), xWorldCounterRewardInfo);
/*     */     }
/* 148 */     return xWorldCounterRewardInfo;
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
/*     */   static java.util.List<Integer> getWorldCounterRewardStages(long roleId, int index_1, int index_2)
/*     */   {
/* 164 */     WorldCounterReward xWorldCounterReward = Role2worldcounterreward.get(Long.valueOf(roleId));
/* 165 */     if (xWorldCounterReward == null)
/*     */     {
/* 167 */       return Collections.EMPTY_LIST;
/*     */     }
/* 169 */     WorldCounterRewardInfo xWorldCounterRewardInfo = (WorldCounterRewardInfo)xWorldCounterReward.getReward_info().get(Integer.valueOf(index_1));
/* 170 */     if (xWorldCounterRewardInfo == null)
/*     */     {
/* 172 */       return Collections.EMPTY_LIST;
/*     */     }
/*     */     
/* 175 */     WorldCounterRewardStages xWorldCounterRewardStages = (WorldCounterRewardStages)xWorldCounterRewardInfo.getIndex2reward_stages().get(Integer.valueOf(index_2));
/* 176 */     if (xWorldCounterRewardStages == null)
/*     */     {
/* 178 */       return Collections.EMPTY_LIST;
/*     */     }
/* 180 */     return new ArrayList(xWorldCounterRewardStages.getRewarded_stages());
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
/*     */   static java.util.List<Integer> addWorldCounterRewardStages(long roleId, int index_1, int index_2, int stageId)
/*     */   {
/* 195 */     WorldCounterRewardInfo xWorldCounterRewardInfo = getWorldCounterRewardInfo(roleId, index_1);
/* 196 */     WorldCounterRewardStages xWorldCounterRewardStages = (WorldCounterRewardStages)xWorldCounterRewardInfo.getIndex2reward_stages().get(Integer.valueOf(index_2));
/* 197 */     if (xWorldCounterRewardStages == null)
/*     */     {
/* 199 */       xWorldCounterRewardStages = Pod.newWorldCounterRewardStages();
/* 200 */       xWorldCounterRewardInfo.getIndex2reward_stages().put(Integer.valueOf(index_2), xWorldCounterRewardStages);
/*     */     }
/* 202 */     xWorldCounterRewardStages.getRewarded_stages().add(Integer.valueOf(stageId));
/* 203 */     return new ArrayList(xWorldCounterRewardStages.getRewarded_stages());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getActivityId(int graphId)
/*     */   {
/* 215 */     STGraph2ActivityId cfg = STGraph2ActivityId.get(graphId);
/* 216 */     if (cfg == null)
/*     */     {
/* 218 */       return -1;
/*     */     }
/* 220 */     return cfg.activityId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\BirthdayPrayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */