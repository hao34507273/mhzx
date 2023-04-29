/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.chat.crossserver.CrossServerChatExtraInfoType;
/*     */ import mzm.gsp.chat.crossserver.CrossServerChatHandler;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.roam.CrossCompeteRoamManager;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.FactionCrossCompete;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ 
/*     */ 
/*     */ public class CrossCompeteChatHandler
/*     */   implements CrossServerChatHandler
/*     */ {
/*     */   public boolean isForbiddenTalkInRoamServer(long roleid)
/*     */   {
/*  28 */     return false;
/*     */   }
/*     */   
/*     */   public List<Integer> getDestServerZoneid(long roleid)
/*     */   {
/*  33 */     List<Integer> zoneidList = new ArrayList();
/*  34 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*     */ 
/*  37 */       RoamCrossCompeteRole xRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(roleid, false);
/*     */       
/*  39 */       if (xRole == null) {
/*  40 */         return null;
/*     */       }
/*  42 */       int orginalZoneid = GameServerInfoManager.getZoneidFromRoleid(roleid);
/*  43 */       zoneidList.add(Integer.valueOf(orginalZoneid));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  48 */       Gang faction = GangInterface.getGangByRoleId(roleid, false);
/*  49 */       if (faction == null) {
/*  50 */         return null;
/*     */       }
/*  52 */       long factionid = faction.getGangId();
/*     */       
/*  54 */       FactionCrossCompete xFactionCompete = CrossCompeteManager.getXFactionCrossCompete(factionid, false);
/*     */       
/*  56 */       if (xFactionCompete == null) {
/*  57 */         return null;
/*     */       }
/*  59 */       long opponentid = xFactionCompete.getOpponent();
/*     */       
/*  61 */       CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/*  62 */       if (xCompete == null) {
/*  63 */         return null;
/*     */       }
/*  65 */       CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, factionid, opponentid);
/*     */       
/*  67 */       if (xAgainst == null) {
/*  68 */         return null;
/*     */       }
/*  70 */       if (xAgainst.getRoam_serverid() <= 0) {
/*  71 */         return null;
/*     */       }
/*     */       
/*     */ 
/*  75 */       int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*  76 */       if ((CrossCompeteManager.isPrepareStage(stage)) || (CrossCompeteManager.isFightStage(stage)) || (CrossCompeteManager.isWaitForceEndStage(stage)))
/*     */       {
/*     */ 
/*  79 */         zoneidList.add(Integer.valueOf(xAgainst.getRoam_serverid()));
/*     */       }
/*     */     }
/*  82 */     return zoneidList;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getReceiveRoleByOrgKeyListInRoamServer(long orgkey)
/*     */   {
/*  88 */     long factionid = orgkey;
/*     */     
/*  90 */     RoamCrossCompeteFactionTmp xFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(factionid, false);
/*     */     
/*  92 */     if (xFactionTmp == null) {
/*  93 */       CrossCompeteManager.logError("CrossCompeteChatHandler.getReceiveRoleByOrgKeyListInRoamServer@roam faction null|factionid=%d", new Object[] { Long.valueOf(factionid) });
/*     */       
/*     */ 
/*  96 */       return null;
/*     */     }
/*     */     
/*  99 */     if (CrossCompeteManager.isLoggerDebugEnabled()) {
/* 100 */       CrossCompeteManager.logDebug("CrossCompeteChatHandler.getReceiveRoleByOrgKeyListInRoamServer@get roles|factionid=%d|roles=%s", new Object[] { Long.valueOf(factionid), xFactionTmp.getRoles() });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 105 */     return new ArrayList(xFactionTmp.getRoles());
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getReceiveRoleListByRoleidInRoamServer(long roleid)
/*     */   {
/* 111 */     RoamCrossCompeteRole xRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(roleid, false);
/*     */     
/* 113 */     if (xRole == null) {
/* 114 */       CrossCompeteManager.logError("CrossCompeteChatHandler.getReceiveRoleListByRoleidInRoamServer@roam role null|roleid=%d", new Object[] { Long.valueOf(roleid) });
/*     */       
/*     */ 
/* 117 */       return null;
/*     */     }
/*     */     
/* 120 */     long factionid = xRole.getFactionid();
/* 121 */     RoamCrossCompeteFactionTmp xFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(factionid, false);
/*     */     
/*     */ 
/* 124 */     if (xFactionTmp == null) {
/* 125 */       CrossCompeteManager.logError("CrossCompeteChatHandler.getReceiveRoleListByRoleidInRoamServer@roam faction null|roleid=%d|factionid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(factionid) });
/*     */       
/*     */ 
/* 128 */       return null;
/*     */     }
/*     */     
/* 131 */     return new ArrayList(xFactionTmp.getRoles());
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<CrossServerChatExtraInfoType, Integer> getExtraInfoInRoamServer(long roleid)
/*     */   {
/* 137 */     Map<CrossServerChatExtraInfoType, Integer> extraInfo = new HashMap();
/*     */     
/* 139 */     RoamCrossCompeteRole xRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(roleid, false);
/* 140 */     if (xRole == null) {
/* 141 */       CrossCompeteManager.logError("CrossCompeteChatHandler.getExtraInfoInRoamServer@roam role null|roleid=%d", new Object[] { Long.valueOf(roleid) });
/*     */       
/*     */ 
/* 144 */       return extraInfo;
/*     */     }
/*     */     
/* 147 */     int dutyLevel = GangInterface.getDutyLevelByDutyid(xRole.getDuty());
/* 148 */     if (dutyLevel < 0) {
/* 149 */       CrossCompeteManager.logError("CrossCompeteChatHandler.getExtraInfoInRoamServer@duty level negative|roleid=%d|factionid=%d|dutyid=%d|duty_level=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(xRole.getFactionid()), Integer.valueOf(xRole.getDuty()), Integer.valueOf(dutyLevel) });
/*     */       
/*     */ 
/* 152 */       return extraInfo;
/*     */     }
/*     */     
/* 155 */     extraInfo.put(CrossServerChatExtraInfoType.FactionDuty, Integer.valueOf(dutyLevel));
/* 156 */     extraInfo.put(CrossServerChatExtraInfoType.FactionidHigh, Integer.valueOf(CommonUtils.getLongHigh(xRole.getFactionid())));
/*     */     
/* 158 */     extraInfo.put(CrossServerChatExtraInfoType.FactionidLow, Integer.valueOf(CommonUtils.getLongLow(xRole.getFactionid())));
/*     */     
/*     */ 
/* 161 */     return extraInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\CrossCompeteChatHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */