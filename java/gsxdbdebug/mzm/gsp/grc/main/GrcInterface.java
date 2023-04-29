/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import grc.DataBetweenGameAndGrcArg;
/*     */ import grc.DataBetweenGameAndGrcRes;
/*     */ import grc.GrcGetFriendsListArg;
/*     */ import grc.GrcGetFriendsListRes;
/*     */ import grc.GrcGetUserReceiveGiftInfoListArg;
/*     */ import grc.GrcGetUserReceiveGiftInfoListRes;
/*     */ import grc.GrcReceiveAllGiftArg;
/*     */ import grc.GrcReceiveAllGiftRes;
/*     */ import grc.GrcReceiveGiftArg;
/*     */ import grc.GrcReceiveGiftRes;
/*     */ import grc.GrcSendGiftArg;
/*     */ import grc.GrcSendGiftRes;
/*     */ import grc.GrcUserLoginArg;
/*     */ import grc.GrcUserLoginRes;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.util.Pair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GrcInterface
/*     */ {
/*     */   public static void onGrcUserLoginResponse(GrcUserLoginArg arg, GrcUserLoginRes res)
/*     */   {
/*  30 */     new POnGrcUserLoginReponse(arg, res).execute();
/*     */   }
/*     */   
/*     */   public static void onGrcUserLoginTimeout(GrcUserLoginArg arg, GrcUserLoginRes res)
/*     */   {
/*  35 */     GrcManager.onGrcUserLoginTimeout(arg, res);
/*     */   }
/*     */   
/*     */   public static void getFriendList(long roleId, int pageIndex)
/*     */   {
/*  40 */     GrcManager.getFriendList(roleId, pageIndex);
/*     */   }
/*     */   
/*     */   public static void onGetFriendListResponse(GrcGetFriendsListArg arg, GrcGetFriendsListRes res)
/*     */   {
/*  45 */     new POnGetFriendListReponse(arg, res).execute();
/*     */   }
/*     */   
/*     */   public static void onGetFriendListTimeout(GrcGetFriendsListArg arg, GrcGetFriendsListRes res)
/*     */   {
/*  50 */     GrcManager.onGetFriendListTimeout(arg, res);
/*     */   }
/*     */   
/*     */   public static void getReceiveGiftList(long roleId, int pageIndex)
/*     */   {
/*  55 */     GrcManager.getReceiveGiftList(roleId, pageIndex);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void onGetReceiveGiftListResponse(GrcGetUserReceiveGiftInfoListArg arg, GrcGetUserReceiveGiftInfoListRes res)
/*     */   {
/*  61 */     GrcManager.onGetReceiveGiftListResponse(arg, res);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void onGetReceiveGiftListTimeout(GrcGetUserReceiveGiftInfoListArg arg, GrcGetUserReceiveGiftInfoListRes res)
/*     */   {
/*  67 */     GrcManager.onGetReceiveGiftListTimeout(arg, res);
/*     */   }
/*     */   
/*     */   public static void onSendGiftResponse(GrcSendGiftArg arg, GrcSendGiftRes res)
/*     */   {
/*  72 */     GrcManager.onSendGiftResponse(arg, res);
/*     */   }
/*     */   
/*     */   public static void onSendGiftTimeout(GrcSendGiftArg arg, GrcSendGiftRes res)
/*     */   {
/*  77 */     GrcManager.onSendGiftTimeout(arg, res);
/*     */   }
/*     */   
/*     */   public static void onReceiveGiftResponse(GrcReceiveGiftArg arg, GrcReceiveGiftRes res)
/*     */   {
/*  82 */     new POnReceiveGiftReponse(arg, res).execute();
/*     */   }
/*     */   
/*     */   public static void onReceiveGiftTimeout(GrcReceiveGiftArg arg, GrcReceiveGiftRes res)
/*     */   {
/*  87 */     GrcManager.onReceiveGiftTimeout(arg, res);
/*     */   }
/*     */   
/*     */   public static void onReceiveAllGiftResponse(GrcReceiveAllGiftArg arg, GrcReceiveAllGiftRes res)
/*     */   {
/*  92 */     new POnReceiveAllGiftResponse(arg, res).execute();
/*     */   }
/*     */   
/*     */   public static void onReceiveAllGiftTimeout(GrcReceiveAllGiftArg arg, GrcReceiveAllGiftRes res)
/*     */   {
/*  97 */     GrcManager.onReceiveAllGiftTimeout(arg, res);
/*     */   }
/*     */   
/*     */   public static void onDataBetweenGameAndGrcResponse(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*     */   {
/* 102 */     GrcManager.onDataBetweenGameAndGrcResponse(arg, res);
/*     */   }
/*     */   
/*     */   public static void onDataBetweenGameAndGrcTimeout(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*     */   {
/* 107 */     GrcManager.onDataBetweenGameAndGrcTimeout(arg, res);
/*     */   }
/*     */   
/*     */   public static boolean reportProfileScore(String userid, long roleid, String param)
/*     */   {
/* 112 */     return GrcManager.reportScoreBatch(userid, roleid, param);
/*     */   }
/*     */   
/*     */   public static boolean antiAddictProxy(String proxyInfo, Octets context)
/*     */   {
/* 117 */     return GrcManager.sendAntiAddictProxy(proxyInfo, context);
/*     */   }
/*     */   
/*     */   public static boolean asyncCleanRankInfo(int rankType, long rankid, Octets context)
/*     */   {
/* 122 */     return GrcManager.asyncCleanRankInfo(rankType, rankid, context);
/*     */   }
/*     */   
/*     */   public static boolean asyncRemoveRankInfo(int rankType, long rankid, long chartObjid, Octets context)
/*     */   {
/* 127 */     return GrcManager.asyncRemoveRankInfo(rankType, rankid, chartObjid, context);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean asyncReportRankInfo(int rankType, long rankid, long chartObjid, double score, Octets chartObjInfo, Octets context)
/*     */   {
/* 133 */     return GrcManager.asyncReportRankInfo(rankType, rankid, chartObjid, score, chartObjInfo, context);
/*     */   }
/*     */   
/*     */   public static boolean asyncGetRank(int rankType, long rankid, long chartObjid, Octets context)
/*     */   {
/* 138 */     return GrcManager.asyncGetRank(rankType, rankid, chartObjid, context);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean asyncGetRankRange(int rankType, long rankid, int from, int to, Octets context)
/*     */   {
/* 144 */     return GrcManager.asyncGetRankRange(rankType, rankid, from, to, context);
/*     */   }
/*     */   
/*     */   public static boolean reportCrossBattleOwnResult(int activityCfgid, Map<Long, Octets> result)
/*     */   {
/* 149 */     return GrcManager.reportCrossBattleOwnResult(activityCfgid, result);
/*     */   }
/*     */   
/*     */   public static boolean clearCrossBattleOwnResult(int activityCfgid, Map<Long, Octets> result)
/*     */   {
/* 154 */     return GrcManager.clearCrossBattleOwnResult(activityCfgid, result);
/*     */   }
/*     */   
/*     */   public static boolean asyncGetCorpsZone(Octets context)
/*     */   {
/* 159 */     return GrcManager.asyncGetCorpsZone(context);
/*     */   }
/*     */   
/*     */   public static boolean asyncReportCorpsPointRace(Octets context)
/*     */   {
/* 164 */     return GrcManager.asyncReportCorpsPointRace(context);
/*     */   }
/*     */   
/*     */   public static boolean asyncGetZonePointRace(int activityCfgid, int zone, Octets context)
/*     */   {
/* 169 */     return GrcManager.asyncGetZonePointRace(activityCfgid, zone, context);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean asyncRemovePointRace(int activityCfgid, int zone, int timePointCfgid, Octets context)
/*     */   {
/* 175 */     return GrcManager.asyncRemovePointRace(activityCfgid, zone, timePointCfgid, context);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean getCrossBattleKnockOutInfo(int activityCfgId, int knockOutType, int fightZoneId, int nowFightStage, int maxTeamNum, int maxStage, int fightTimesEveryRound, Octets octets)
/*     */   {
/* 185 */     return GrcManager.getCrossBattleKnockOutInfo(activityCfgId, knockOutType, fightZoneId, nowFightStage, maxTeamNum, maxStage, fightTimesEveryRound, octets, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean reportCrossBattleKnockOutFightResult(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, long ownCorpsId, String ownCorpsName, long opponentCorpsId, String opponentCorpsName, int fightIndexId, int maxFightStage, int fightTimesEveryRound, String result)
/*     */   {
/* 197 */     return GrcManager.reportCrossBattleKnockOutFightResult(activityCfgId, knockOutType, fightZoneId, fightStage, ownCorpsId, ownCorpsName, opponentCorpsId, opponentCorpsName, fightIndexId, maxFightStage, fightTimesEveryRound, result, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean reportCrossBattleKnockOutFightBegin(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int fightIndexId, long fightRecordId)
/*     */   {
/* 208 */     return GrcManager.reportCrossBattleKnockOutFightBegin(activityCfgId, knockOutType, fightZoneId, fightStage, fightIndexId, fightRecordId, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean getNotifyKnockOutCorpsIdList(int activityCfgId, int knockOutType, int fightStage, int maxFightIndexId, int maxFightZone, List<Integer> zoneIdList, Octets octets)
/*     */   {
/* 218 */     return GrcManager.getNotifyKnockOutCorpsIdList(activityCfgId, knockOutType, fightStage, maxFightIndexId, maxFightZone, zoneIdList, 0, octets);
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
/*     */   public static boolean getNotifyKnockOutRestartCorpsIdList(long worldBeginTime, int activityCfgId, int knockOutType, boolean isRestartAllFightZone, List<Pair<Integer, Integer>> restartFightList, int fightStage, int maxFightIndexId, int maxFightZone, List<Integer> zoneIdList, int type)
/*     */   {
/* 234 */     return GrcManager.getNotifyKnockOutRestartCorpsId(worldBeginTime, activityCfgId, knockOutType, isRestartAllFightZone, restartFightList, fightStage, maxFightIndexId, maxFightZone, zoneIdList, type, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean getKnockOutQualificationCorpsIdList(int activityCfgId, int knockOutType, int fightStage, int maxFightIndexId, int maxFightZone, int selectionTeamSize, int maxSelectionStage, List<Integer> zoneIdList, long roleId, long corpsId)
/*     */   {
/* 245 */     return GrcManager.getGetKnockOutQualificationCorpsIdList(activityCfgId, knockOutType, fightStage, maxFightIndexId, maxFightZone, selectionTeamSize, maxSelectionStage, zoneIdList, 0, roleId, corpsId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean gmSetSelectionCorpsInfo(int activityCfgId, int fightZoneId, long corpsId, int rank, String corpsName, int badgeId, int zoneId)
/*     */   {
/* 255 */     return GrcManager.gmSetSelectionCorpsInfo(activityCfgId, fightZoneId, corpsId, rank, corpsName, badgeId, zoneId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean gmSetFinalCorpsInfo(int activityCfgId, int fightZoneId, int rank, long corpsId, String corpsName, int badgeId, int zoneId, int maxSelectionStage)
/*     */   {
/* 264 */     return GrcManager.gmSetFinalCorpsInfo(activityCfgId, fightZoneId, rank, corpsId, corpsName, badgeId, zoneId, maxSelectionStage);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean getCrossBattleKnockoutStageBetInfo(int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightNum, long roleid, int reason)
/*     */   {
/* 271 */     return GrcManager.getCrossBattleKnockoutStageBetInfo(activityCfgid, knockoutType, fightZoneid, stage, fightNum, roleid, reason);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean reportRoleCrossBattleKnockoutBetInfo(int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightIndex, long roleid, long betCorpsid, int betMoneyNum)
/*     */   {
/* 279 */     return GrcManager.reportRoleCrossBattleKnockoutBetInfo(activityCfgid, knockoutType, fightZoneid, stage, fightIndex, roleid, betCorpsid, betMoneyNum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean getCrossBattleKnockOutOwnServerInfo(long roleId, int activityCfgId, int knockOutType, int fightStage, int maxFightZoneId, int maxFightIndexId, List<Integer> zoneIdList)
/*     */   {
/* 287 */     return GrcManager.getCrossBattleKnockOutOwnServerInfo(roleId, activityCfgId, knockOutType, fightStage, maxFightZoneId, maxFightIndexId, zoneIdList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean clearKnockOutData(int activityCfgId, int knockOutType, int restartFightZoneId, int fightStage, int restartFightIndexId, int maxFightZoneId, int maxFightIndexId, long prepareWorldBeginTime, int repeatTimes)
/*     */   {
/* 295 */     return GrcManager.clearKnockOutData(activityCfgId, knockOutType, restartFightZoneId, fightStage, restartFightIndexId, maxFightZoneId, maxFightIndexId, prepareWorldBeginTime, repeatTimes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean asyncReportFightRecord(long recordid, int dataType, Octets data, Octets context)
/*     */   {
/* 302 */     return GrcManager.asyncReportFightRecord(recordid, dataType, data, context);
/*     */   }
/*     */   
/*     */   public static boolean asyncGetFightRecord(long recordid, int dataType, Octets context)
/*     */   {
/* 307 */     return GrcManager.asyncGetFightRecord(recordid, dataType, context);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean reportCrossBattleCorpsInfo(int activityCfgId, long corpsId, String declaration, int createTime)
/*     */   {
/* 313 */     return GrcManager.reportCrossBattleCorpsInfo(activityCfgId, corpsId, declaration, createTime);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean reportCrossBattleCorpsRoleInfo(int activityCfgId, long corpsId, long roleId, String roleName, int occupationId, int roleLevel, int avatarId, int multifightvalue, int mfrank, int gender, int joinTime, int duty, int lastLogOffTime)
/*     */   {
/* 320 */     return GrcManager.reportCrossBattleCorpsRoleInfo(activityCfgId, corpsId, roleId, roleName, occupationId, roleLevel, avatarId, multifightvalue, mfrank, gender, joinTime, duty, lastLogOffTime);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean getCrossBattleCorpsInfo(int activityCfgId, long corpsId, long roleId)
/*     */   {
/* 326 */     return GrcManager.getCrossBattleCorpsInfo(activityCfgId, corpsId, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean reportCrossBattleStageFightEndCorpsRoleInfo(int activityCfgId, int knockOutType, int fightStage, long corpsId, long roleId, String roleName, int occupationId, int roleLevel, int avatarId, int multifightvalue, int mfrank, int gender, int joinTime, int duty, ModelInfo modelInfo)
/*     */   {
/* 334 */     return GrcManager.reportCrossBattleStageFightEndCorpsRoleInfo(activityCfgId, knockOutType, fightStage, corpsId, roleId, roleName, occupationId, roleLevel, avatarId, multifightvalue, mfrank, gender, joinTime, duty, modelInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean getCrossBattleStageFightEndCorpsInfo(int activityCfgId, int knockOutType, int fightStage, long corpsId, Octets context)
/*     */   {
/* 344 */     return GrcManager.getCrossBattleStageFightEndCorpsInfo(activityCfgId, knockOutType, fightStage, corpsId, context, 0);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean getIndianaNumber(int activityCfgid, int turn, int sortid, int initAwardNum, int extraAwardNeedNum, long roleid, boolean canGetSpecialNumber)
/*     */   {
/* 350 */     return GrcManager.getIndianaNumber(activityCfgid, turn, sortid, initAwardNum, extraAwardNeedNum, roleid, canGetSpecialNumber);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean confirmIndianaNumber(int activityCfgid, int turn, int sortid, long roleid, int number)
/*     */   {
/* 357 */     return GrcManager.confirmIndianaNumber(activityCfgid, turn, sortid, roleid, number);
/*     */   }
/*     */   
/*     */   public static boolean getAttendIndianaNum(int activityCfgid, int turn, int sortid)
/*     */   {
/* 362 */     return GrcManager.getAttendIndianaNum(activityCfgid, turn, sortid);
/*     */   }
/*     */   
/*     */   public static boolean getIndianaAwardNumber(int activityCfgid, int turn, int sortid)
/*     */   {
/* 367 */     return GrcManager.getIndianaAwardNumber(activityCfgid, turn, sortid);
/*     */   }
/*     */   
/*     */   public static boolean getAllLottoAwardRoleInfo(int activityCfgid, List<Integer> turns)
/*     */   {
/* 372 */     return GrcManager.getAllLottoAwardRoleInfo(activityCfgid, turns);
/*     */   }
/*     */   
/*     */   public static boolean back(String openid, int activityCfgid, Octets context)
/*     */   {
/* 377 */     long serialNo = RecallFriendManager.getSerialNo();
/* 378 */     return GrcManager.back(openid, activityCfgid, serialNo, context);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\GrcInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */