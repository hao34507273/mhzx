/*     */ package mzm.gsp.active.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.active.SUpdateActiveDataRes;
/*     */ import mzm.gsp.active.event.ActiveArg;
/*     */ import mzm.gsp.active.event.AddActivePoint;
/*     */ import mzm.gsp.active.event.ClearActivePointArg;
/*     */ import mzm.gsp.active.event.ClearActivePointPoint;
/*     */ import mzm.gsp.activity.confbean.SActiveAwardBean;
/*     */ import mzm.gsp.activity.confbean.SActiveConst;
/*     */ import mzm.gsp.activity.confbean.SActiviteAwardCfg;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.Active;
/*     */ import xtable.Role2active;
/*     */ 
/*     */ public class ActiveManager
/*     */ {
/*     */   static int getTotalActiveValue(Active xActive)
/*     */   {
/*  39 */     if (xActive == null)
/*     */     {
/*  41 */       return 0;
/*     */     }
/*  43 */     int ret = 0;
/*  44 */     for (Map.Entry<Integer, Integer> entry : xActive.getActivitymap().entrySet())
/*     */     {
/*  46 */       int activityid = ((Integer)entry.getKey()).intValue();
/*  47 */       int count = ((Integer)entry.getValue()).intValue();
/*  48 */       SActivityCfg sActivityCfg = ActivityInterface.getActivityCfg(activityid);
/*  49 */       if (sActivityCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*  53 */         ret += sActivityCfg.awardActiveValue * Math.min(count, sActivityCfg.awardActiveTimes); }
/*     */     }
/*  55 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Active checkAndInitActive(long roleid, long timeNow)
/*     */   {
/*  67 */     Active xActive = Role2active.get(Long.valueOf(roleid));
/*  68 */     if (xActive == null)
/*     */     {
/*  70 */       xActive = xbean.Pod.newActive();
/*  71 */       xActive.setResettime(timeNow);
/*  72 */       Role2active.insert(Long.valueOf(roleid), xActive);
/*     */     }
/*     */     else
/*     */     {
/*  76 */       int commonCfgid = SActiveConst.getInstance().activeResetObserverid;
/*     */       
/*  78 */       long startTime = TimeCommonUtil.getBeforeStartTime(timeNow, commonCfgid);
/*  79 */       if (xActive.getResettime() < startTime)
/*     */       {
/*     */ 
/*  82 */         updateActiveData(timeNow, roleid, xActive);
/*     */       }
/*     */     }
/*  85 */     return xActive;
/*     */   }
/*     */   
/*     */   private static void updateActiveData(long timeNow, long roleid, Active xActive)
/*     */   {
/*  90 */     int roleLevel = RoleInterface.getLevel(roleid);
/*  91 */     TreeMap<Integer, SActiviteAwardCfg> sActiviteAwardCfgMap = (TreeMap)SActiviteAwardCfg.getAll();
/*  92 */     Map.Entry<Integer, SActiviteAwardCfg> matchLevelEntry = sActiviteAwardCfgMap.floorEntry(Integer.valueOf(roleLevel));
/*  93 */     if (matchLevelEntry != null)
/*     */     {
/*  95 */       SActiviteAwardCfg sActiviteAwardCfg = (SActiviteAwardCfg)matchLevelEntry.getValue();
/*     */       
/*  97 */       int value = getTotalActiveValue(xActive);
/*  98 */       List<AwardModel> awardModelItemBindList = new ArrayList();
/*  99 */       List<AwardModel> awardModelItemUnBindList = new ArrayList();
/* 100 */       for (Map.Entry<Integer, SActiveAwardBean> entry : sActiviteAwardCfg.active_award_map.entrySet())
/*     */       {
/* 102 */         int awardedIndex = ((Integer)entry.getKey()).intValue();
/* 103 */         if (!xActive.getAward_index_id_set().contains(Integer.valueOf(awardedIndex)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 108 */           SActiveAwardBean sActiveAwardBean = (SActiveAwardBean)entry.getValue();
/* 109 */           if (sActiveAwardBean.active_value <= value)
/*     */           {
/* 111 */             AwardModel awardModel = AwardInterface.getRoleFixAwardModel(sActiveAwardBean.award_id, roleid, new AwardReason(LogReason.ACTIVE_AWARD_ITEM));
/*     */             
/* 113 */             if (sActiveAwardBean.is_bind == 1)
/*     */             {
/* 115 */               awardModelItemBindList.add(awardModel);
/*     */             }
/*     */             else
/*     */             {
/* 119 */               awardModelItemUnBindList.add(awardModel);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 124 */       if ((!awardModelItemBindList.isEmpty()) || (!awardModelItemUnBindList.isEmpty()))
/*     */       {
/* 126 */         MailAttachment mailAttachment = new MailAttachment();
/* 127 */         AwardInterface.fillMailAttchMentBy(awardModelItemUnBindList, awardModelItemBindList, mailAttachment);
/* 128 */         if (mailAttachment.isHasItem())
/*     */         {
/*     */ 
/* 131 */           mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleid, SActiveConst.getInstance().mailCfgId, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(LogReason.ACTIVE_AWARD_ITEM));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 137 */       ClearActivePointArg clearActivePointArg = new ClearActivePointArg(roleid, value);
/* 138 */       TriggerEventsManger.getInstance().triggerEvent(new ClearActivePointPoint(), clearActivePointArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */     }
/*     */     
/*     */ 
/* 142 */     xActive.getActivitymap().clear();
/* 143 */     xActive.getAward_index_id_set().clear();
/* 144 */     xActive.setResettime(timeNow);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addActivityCount(long roleid, Active xActive, int activityid)
/*     */   {
/* 156 */     SActivityCfg activityCfg = ActivityInterface.getActivityCfg(activityid);
/* 157 */     if (activityCfg.awardActiveTimes <= 0)
/*     */     {
/* 159 */       return false;
/*     */     }
/* 161 */     Integer times = (Integer)xActive.getActivitymap().get(Integer.valueOf(activityid));
/* 162 */     if ((times != null) && (times.intValue() >= activityCfg.awardActiveTimes))
/*     */     {
/* 164 */       return false;
/*     */     }
/* 166 */     if (times == null)
/*     */     {
/* 168 */       times = Integer.valueOf(0);
/*     */     }
/* 170 */     Integer localInteger1 = times;Integer localInteger2 = times = Integer.valueOf(times.intValue() + 1);
/* 171 */     int originalPoint = getTotalActiveValue(xActive);
/* 172 */     xActive.getActivitymap().put(Integer.valueOf(activityid), times);
/* 173 */     int nowPoint = getTotalActiveValue(xActive);
/*     */     
/* 175 */     tlogActiveChange(roleid, nowPoint);
/*     */     
/*     */ 
/* 178 */     ActiveArg activeArg = new ActiveArg(roleid, originalPoint, nowPoint);
/* 179 */     TriggerEventsManger.getInstance().triggerEvent(new AddActivePoint(), activeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */     
/* 181 */     return true;
/*     */   }
/*     */   
/*     */   static void tlogActiveChange(long roleId, int nowActiveValue)
/*     */   {
/* 186 */     String userId = RoleInterface.getUserId(roleId);
/* 187 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 189 */     StringBuilder sbLog = new StringBuilder();
/* 190 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 191 */     sbLog.append(userId).append('|');
/* 192 */     sbLog.append(roleId).append('|');
/* 193 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 195 */     sbLog.append(nowActiveValue);
/*     */     
/* 197 */     TLogManager.getInstance().addLog(roleId, "ActiveChangeStatis", sbLog.toString());
/*     */   }
/*     */   
/*     */   static int getActivityCount(Active xActive, int activityid)
/*     */   {
/* 202 */     Integer times = (Integer)xActive.getActivitymap().get(Integer.valueOf(activityid));
/* 203 */     if (times != null)
/*     */     {
/* 205 */       return times.intValue();
/*     */     }
/*     */     
/*     */ 
/* 209 */     return 0;
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
/*     */   static void sendUpdateActiveMsg(long roleid, int activityid, int count)
/*     */   {
/* 222 */     SUpdateActiveDataRes sUpdateActiveDataRes = new SUpdateActiveDataRes();
/* 223 */     sUpdateActiveDataRes.activedata.activityid = activityid;
/* 224 */     sUpdateActiveDataRes.activedata.activecount = count;
/* 225 */     OnlineManager.getInstance().send(roleid, sUpdateActiveDataRes);
/*     */   }
/*     */   
/*     */   static void init() {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\ActiveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */