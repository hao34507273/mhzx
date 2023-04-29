/*      */ package mzm.gsp.grc.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import gnet.link.Onlines;
/*      */ import grc.GrcBindFriendVitalityInfo;
/*      */ import grc.GrcRecallFriendInfo;
/*      */ import grc.GrcRecallUserInfo;
/*      */ import grc.GrcRoleInfo;
/*      */ import grc.GrcUserBackInfo;
/*      */ import hub.BindFriendVitalityInfo;
/*      */ import hub.RecallNotifyBindFriendReq;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.active.main.ActiveInterface;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.award.main.AwardModel;
/*      */ import mzm.gsp.award.main.AwardReason;
/*      */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*      */ import mzm.gsp.grc.AddBindVitalityInfo;
/*      */ import mzm.gsp.grc.BindVitalityInfo;
/*      */ import mzm.gsp.grc.FriendRecallInfo;
/*      */ import mzm.gsp.grc.RecallRoleInfo;
/*      */ import mzm.gsp.grc.SBindFriendFailed;
/*      */ import mzm.gsp.grc.SBindFriendSuccess;
/*      */ import mzm.gsp.grc.SGetBindRewardFailed;
/*      */ import mzm.gsp.grc.SGetBindRewardSuccess;
/*      */ import mzm.gsp.grc.SGetRecallRebateFailed;
/*      */ import mzm.gsp.grc.SGetRecallRebateInfoSuccess;
/*      */ import mzm.gsp.grc.SGetRecallRebateSuccess;
/*      */ import mzm.gsp.grc.SRecallFriendFailed;
/*      */ import mzm.gsp.grc.SRecallFriendSuccess;
/*      */ import mzm.gsp.grc.SSendRecallFriendSuccess;
/*      */ import mzm.gsp.grc.SyncUserBackInfo;
/*      */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*      */ import mzm.gsp.grc.confbean.SRecallVitalityAwardCfg;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.mail.main.SendMailRet;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.qingfu.main.PresentResult;
/*      */ import mzm.gsp.qingfu.main.PresentType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.AtomicRangeInteger;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.BeRecalledBackGameInfo;
/*      */ import xbean.Pod;
/*      */ import xbean.RecallFriendBackGame;
/*      */ import xdb.Lockeys;
/*      */ import xtable.Basic;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class RecallFriendManager
/*      */ {
/*      */   static int getRecallFriendState(RecallFriendBackGame xRecallFriendBackGame, long roleId)
/*      */   {
/*   85 */     if (xRecallFriendBackGame == null)
/*      */     {
/*   87 */       return 0;
/*      */     }
/*      */     
/*   90 */     String userId = RoleInterface.getUserId(roleId);
/*   91 */     if (userId == null)
/*      */     {
/*   93 */       return 0;
/*      */     }
/*   95 */     String openid = CommonUtils.getOpenId(userId);
/*      */     
/*   97 */     xbean.User xBeRecalledUser = xtable.User.select(userId);
/*   98 */     if (xBeRecalledUser == null)
/*      */     {
/*  100 */       return 0;
/*      */     }
/*      */     
/*  103 */     boolean result = checkRecallCondition(xBeRecalledUser, true);
/*  104 */     if (!result)
/*      */     {
/*  106 */       return 0;
/*      */     }
/*      */     
/*  109 */     List<xbean.RecallUserInfo> xRecallUserInfoList = xRecallFriendBackGame.getRecall_friend_list();
/*  110 */     for (xbean.RecallUserInfo xRecallUserInfo : xRecallUserInfoList)
/*      */     {
/*  112 */       String tmpFriendOpenid = xRecallUserInfo.getRecall_openid();
/*  113 */       if (tmpFriendOpenid.isEmpty())
/*      */       {
/*  115 */         String friendUserid = xRecallUserInfo.getUser_id();
/*  116 */         tmpFriendOpenid = CommonUtils.getOpenId(friendUserid);
/*  117 */         xRecallUserInfo.setRecall_openid(tmpFriendOpenid);
/*      */       }
/*  119 */       if (tmpFriendOpenid.equals(openid))
/*      */       {
/*  121 */         if (DateTimeUtils.getCurrTimeInMillis() - xRecallUserInfo.getRecall_time() > SRecallFriendConsts.getInstance().PERIOD_TIME * 86400000L)
/*      */         {
/*      */ 
/*  124 */           return 1;
/*      */         }
/*  126 */         return 2;
/*      */       }
/*      */     }
/*      */     
/*  130 */     BeRecalledBackGameInfo xBeRecalledBackGameInfo = xBeRecalledUser.getRecall_friend_back_game().getBe_recalled_back_game();
/*  131 */     boolean isBeRecallTimesTop = xBeRecalledBackGameInfo.getCurrent_period_be_recalled_times() >= SRecallFriendConsts.getInstance().ONE_PERIOD_BE_RECALL_TIMES;
/*  132 */     if (isBeRecallTimesTop)
/*      */     {
/*  134 */       long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  135 */       if (currentTimeMillis - xBeRecalledBackGameInfo.getPeriod_begin_time() > 86400000L * SRecallFriendConsts.getInstance().PERIOD_TIME)
/*      */       {
/*  137 */         return 1;
/*      */       }
/*  139 */       return 0;
/*      */     }
/*      */     
/*  142 */     return 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkRecallCondition(xbean.User xBeRecalledUser, boolean checkIsOnLine)
/*      */   {
/*  156 */     if (xBeRecalledUser == null)
/*      */     {
/*  158 */       return false;
/*      */     }
/*      */     
/*  161 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  162 */     List<Long> xBeRecallFriendRoleIdList = xBeRecalledUser.getRoleids();
/*      */     
/*  164 */     int maxRoleLevel = 0;
/*  165 */     long maxLastLogoffTime = 0L;
/*  166 */     for (Iterator i$ = xBeRecallFriendRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/*  168 */       if (checkIsOnLine)
/*      */       {
/*  170 */         boolean isOnLine = OnlineManager.getInstance().isOnlineOrInProtect(roleId);
/*  171 */         if (isOnLine)
/*      */         {
/*  173 */           return false;
/*      */         }
/*      */       }
/*      */       
/*  177 */       int roleLevel = RoleInterface.getLevel(roleId);
/*  178 */       maxRoleLevel = roleLevel < maxRoleLevel ? maxRoleLevel : roleLevel;
/*      */       
/*  180 */       long lastLogOffTime = RoleInterface.getLastLogoffTime(roleId);
/*  181 */       maxLastLogoffTime = lastLogOffTime < maxLastLogoffTime ? maxLastLogoffTime : lastLogOffTime;
/*      */     }
/*      */     
/*  184 */     if (maxRoleLevel < SRecallFriendConsts.getInstance().RECALL_MIN_ROLE_LEVEL)
/*      */     {
/*  186 */       return false;
/*      */     }
/*      */     
/*  189 */     long offLineTime = currentTimeMillis - maxLastLogoffTime;
/*  190 */     if (offLineTime < SRecallFriendConsts.getInstance().RECALL_MIN_OffLINE_TIME * 86400000L)
/*      */     {
/*  192 */       return false;
/*      */     }
/*  194 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRecallFriendSwitchOpen(long roleId, boolean isSendTips)
/*      */   {
/*  209 */     if (!OpenInterface.getOpenStatus(189))
/*      */     {
/*  211 */       return false;
/*      */     }
/*      */     
/*  214 */     if (OpenInterface.isBanPlay(roleId, 189))
/*      */     {
/*  216 */       if (isSendTips)
/*      */       {
/*  218 */         OpenInterface.sendBanPlayMsg(roleId, 189);
/*      */       }
/*  220 */       return false;
/*      */     }
/*      */     
/*  223 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkMutexStatus(long roleId)
/*      */   {
/*  231 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 87, true))
/*      */     {
/*  233 */       GameServer.logger().error(String.format("[recall]RecallFriendManager.checkMutexStatus@contains mutex state|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*      */       
/*  235 */       return false;
/*      */     }
/*  237 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRecallFriend(String activeUserId, long activeRoleId, String beRecalledUserId, int beRecalledZoneId, String beRecallIdOpenId, int nowRecallFriendNum)
/*      */   {
/*  259 */     int activeRoleLevel = RoleInterface.getLevel(activeRoleId);
/*      */     
/*  261 */     StringBuilder sbLog = new StringBuilder();
/*  262 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  263 */     sbLog.append(activeUserId).append('|');
/*  264 */     sbLog.append(activeRoleId).append('|');
/*  265 */     sbLog.append(activeRoleLevel).append('|');
/*      */     
/*  267 */     sbLog.append(beRecalledUserId).append('|');
/*  268 */     sbLog.append(beRecalledZoneId).append('|');
/*  269 */     sbLog.append(beRecallIdOpenId).append('|');
/*  270 */     sbLog.append(nowRecallFriendNum);
/*      */     
/*  272 */     TLogManager.getInstance().addLog(activeRoleId, "RecallFriendStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRecallFriendNumAward(String userId, long roleId, int serialNum, int currentRecallFriendNum, int awardId)
/*      */   {
/*  292 */     int activeRoleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  294 */     StringBuilder sbLog = new StringBuilder();
/*  295 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  296 */     sbLog.append(userId).append('|');
/*  297 */     sbLog.append(roleId).append('|');
/*  298 */     sbLog.append(activeRoleLevel).append('|');
/*      */     
/*  300 */     sbLog.append(serialNum).append('|');
/*  301 */     sbLog.append(currentRecallFriendNum).append('|');
/*  302 */     sbLog.append(awardId);
/*      */     
/*  304 */     TLogManager.getInstance().addLog(roleId, "RecallFriendNumAwardStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRecallFriendSignAward(String userId, long roleId, int signDay, int awardId, int reason)
/*      */   {
/*  322 */     int activeRoleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  324 */     StringBuilder sbLog = new StringBuilder();
/*  325 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  326 */     sbLog.append(userId).append('|');
/*  327 */     sbLog.append(roleId).append('|');
/*  328 */     sbLog.append(activeRoleLevel).append('|');
/*      */     
/*  330 */     sbLog.append(signDay).append('|');
/*  331 */     sbLog.append(awardId).append('|');
/*  332 */     sbLog.append(reason);
/*      */     
/*  334 */     TLogManager.getInstance().addLog(roleId, "RecallFriendSignAwardStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRecallFriendBigGiftAward(String userId, long roleId, int awardId, int reason)
/*      */   {
/*  349 */     int activeRoleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  351 */     StringBuilder sbLog = new StringBuilder();
/*  352 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  353 */     sbLog.append(userId).append('|');
/*  354 */     sbLog.append(roleId).append('|');
/*  355 */     sbLog.append(activeRoleLevel).append('|');
/*      */     
/*  357 */     sbLog.append(awardId).append('|');
/*  358 */     sbLog.append(reason);
/*      */     
/*  360 */     TLogManager.getInstance().addLog(roleId, "RecallFriendBigGiftAwardStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRecallFriendBackGame(String userId, long roleId, int reason)
/*      */   {
/*  373 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  375 */     StringBuilder sbLog = new StringBuilder();
/*  376 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  377 */     sbLog.append(userId).append('|');
/*  378 */     sbLog.append(roleId).append('|');
/*  379 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  381 */     sbLog.append(reason);
/*      */     
/*  383 */     TLogManager.getInstance().addLog(roleId, "RecallFriendBackGameStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRecallFriendBackGameNum(String userId, long roleId, String beRecallUserId)
/*      */   {
/*  400 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/*  402 */     StringBuilder sbLog = new StringBuilder();
/*  403 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  404 */     sbLog.append(userId).append('|');
/*  405 */     sbLog.append(roleId).append('|');
/*  406 */     sbLog.append(roleLevel).append('|');
/*      */     
/*  408 */     sbLog.append(beRecallUserId);
/*      */     
/*  410 */     TLogManager.getInstance().addLog(roleId, "RecallFriendBackGameNumStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void addTLog(long roleid, String logName, Object... logColumns)
/*      */   {
/*  422 */     String vGameIp = GameServerInfoManager.getHostIP();
/*  423 */     int roleLevel = RoleInterface.getLevel(roleid);
/*  424 */     String userid = RoleInterface.getUserId(roleid);
/*      */     
/*  426 */     StringBuilder logStr = new StringBuilder();
/*  427 */     logStr.append(vGameIp);
/*  428 */     logStr.append("|").append(userid);
/*  429 */     logStr.append("|").append(roleid);
/*  430 */     logStr.append("|").append(roleLevel);
/*  431 */     for (Object colum : logColumns)
/*      */     {
/*  433 */       logStr.append("|").append(colum);
/*      */     }
/*      */     
/*  436 */     TLogManager.getInstance().addLog(userid, logName, logStr.toString());
/*      */   }
/*      */   
/*  439 */   private static final AtomicRangeInteger autoIncrement = new AtomicRangeInteger(0, 524288);
/*      */   
/*      */   static long getSerialNo()
/*      */   {
/*  443 */     long serialNo = DateTimeUtils.getCurrTimeInMillis() / 1000L << 32 & 0xFFFFFFFF00000000 | GameServerInfoManager.getLocalId() << 20 | autoIncrement.getAndIncrement();
/*      */     
/*  445 */     return serialNo;
/*      */   }
/*      */   
/*      */   static boolean isFunOpen(long roleid, boolean send)
/*      */   {
/*  450 */     if (!OpenInterface.getOpenStatus(499))
/*      */     {
/*  452 */       return false;
/*      */     }
/*  454 */     if (OpenInterface.isBanPlay(roleid, 499))
/*      */     {
/*  456 */       if (send)
/*      */       {
/*  458 */         OpenInterface.sendBanPlayMsg(roleid, 499);
/*      */       }
/*  460 */       return false;
/*      */     }
/*  462 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isRebateFunOpen(long roleid, boolean send)
/*      */   {
/*  467 */     if (!OpenInterface.getOpenStatus(515))
/*      */     {
/*  469 */       return false;
/*      */     }
/*  471 */     if (OpenInterface.isBanPlay(roleid, 515))
/*      */     {
/*  473 */       if (send)
/*      */       {
/*  475 */         OpenInterface.sendBanPlayMsg(roleid, 515);
/*      */       }
/*  477 */       return false;
/*      */     }
/*  479 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isBindFriendFunOpen(long roleid, boolean send)
/*      */   {
/*  484 */     if (!OpenInterface.getOpenStatus(543))
/*      */     {
/*  486 */       return false;
/*      */     }
/*  488 */     if (OpenInterface.isBanPlay(roleid, 543))
/*      */     {
/*  490 */       if (send)
/*      */       {
/*  492 */         OpenInterface.sendBanPlayMsg(roleid, 543);
/*      */       }
/*  494 */       return false;
/*      */     }
/*  496 */     return true;
/*      */   }
/*      */   
/*      */   static boolean canDoAction(long roleid, int action)
/*      */   {
/*  501 */     return RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reportRoleBasicInfo(String userid, long roleid)
/*      */   {
/*  513 */     xbean.User xUser = xtable.User.get(userid);
/*  514 */     int maxLevel = 0;
/*  515 */     for (Iterator i$ = xUser.getRoleids().iterator(); i$.hasNext();) { long role = ((Long)i$.next()).longValue();
/*      */       
/*  517 */       int level = RoleInterface.getLevel(role);
/*  518 */       if (level > maxLevel)
/*      */       {
/*  520 */         maxLevel = level;
/*      */       }
/*      */     }
/*      */     
/*  524 */     long loginTime = RoleInterface.getLastLoginTime(roleid);
/*  525 */     String openid = CommonUtils.getOpenId(userid);
/*      */     
/*  527 */     ReportRoleBasicInfoContext context = new ReportRoleBasicInfoContext();
/*  528 */     context.count = 1;
/*  529 */     context.roleid = roleid;
/*  530 */     OctetsStream osContext = new OctetsStream();
/*  531 */     context.marshal(osContext);
/*      */     
/*  533 */     if (!GrcManager.reportRoleBasicInfo(openid, loginTime, maxLevel, osContext))
/*      */     {
/*  535 */       GameServer.logger().error(String.format("[recall]RecallFriendManager.reportRoleBasicInfo@send msg failed|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*      */       
/*      */ 
/*  538 */       return false;
/*      */     }
/*      */     
/*  541 */     GameServer.logger().info(String.format("[recall]RecallFriendManager.reportRoleBasicInfo@send msg success|userid=%s|roleid=%d|openid=%s|login_time=%d|max_level=%d", new Object[] { userid, Long.valueOf(roleid), openid, Long.valueOf(loginTime), Integer.valueOf(maxLevel) }));
/*      */     
/*      */ 
/*      */ 
/*  545 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onRecallFriendResponse(int retcode, String openid, String friendOpenid, long serialNo, Octets context, RecallResponse recallResponse)
/*      */   {
/*  551 */     OctetsStream os = new OctetsStream(context);
/*  552 */     RecallContext recallContext = new RecallContext();
/*      */     try
/*      */     {
/*  555 */       recallContext.unmarshal(os);
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/*  559 */       GameServer.logger().error("[recall]RecallFriendManager.onRecallFriendResponse@marshal error", e);
/*  560 */       return false;
/*      */     }
/*      */     
/*  563 */     long roleid = recallContext.roleid;
/*  564 */     long friendRoleid = recallContext.friendRoleid;
/*  565 */     if (retcode == 0)
/*      */     {
/*      */ 
/*  568 */       String activeUserid = RoleInterface.getUserId(roleid);
/*  569 */       Lockeys.lock(Lockeys.get(xtable.User.getTable(), activeUserid));
/*  570 */       xbean.User xActiveUser = xtable.User.get(activeUserid);
/*      */       
/*  572 */       RecallFriendBackGame xActiveRecallFriendBackGame = xActiveUser.getRecall_friend_back_game();
/*  573 */       xActiveRecallFriendBackGame.setRecall_friend_num(xActiveRecallFriendBackGame.getRecall_friend_num() + 1);
/*      */       
/*  575 */       long updateTime = recallResponse.updateTime;
/*  576 */       long lastUpdateTime = xActiveRecallFriendBackGame.getLast_recall_friend_time();
/*  577 */       if (updateTime > lastUpdateTime)
/*      */       {
/*  579 */         if (!DateTimeUtils.isInSameDay(updateTime, lastUpdateTime))
/*      */         {
/*  581 */           xActiveRecallFriendBackGame.setRecall_friend_times_today(0);
/*      */         }
/*  583 */         xActiveRecallFriendBackGame.setLast_recall_friend_time(updateTime);
/*  584 */         xActiveRecallFriendBackGame.setCross_recall_friend_times_today(recallResponse.todayNum);
/*      */       }
/*  586 */       else if (updateTime < lastUpdateTime)
/*      */       {
/*  588 */         if (DateTimeUtils.isInSameDay(updateTime, lastUpdateTime))
/*      */         {
/*  590 */           xActiveRecallFriendBackGame.setCross_recall_friend_times_today(recallResponse.todayNum);
/*      */         }
/*      */         else
/*      */         {
/*  594 */           xActiveRecallFriendBackGame.setCross_recall_friend_times_today(0);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  599 */         xActiveRecallFriendBackGame.setCross_recall_friend_times_today(recallResponse.todayNum);
/*      */       }
/*      */       
/*  602 */       xbean.RecallUserInfo xTargetRecallUserInfo = null;
/*  603 */       for (xbean.RecallUserInfo xRecallUserInfo : xActiveRecallFriendBackGame.getRecall_friend_list())
/*      */       {
/*  605 */         if (xRecallUserInfo.getRecall_openid().equals(friendOpenid))
/*      */         {
/*  607 */           xTargetRecallUserInfo = xRecallUserInfo;
/*  608 */           break;
/*      */         }
/*      */       }
/*  611 */       if (xTargetRecallUserInfo == null)
/*      */       {
/*  613 */         xTargetRecallUserInfo = Pod.newRecallUserInfo();
/*  614 */         xTargetRecallUserInfo.setRecall_openid(friendOpenid);
/*  615 */         xActiveRecallFriendBackGame.getRecall_friend_list().add(xTargetRecallUserInfo);
/*      */       }
/*  617 */       xTargetRecallUserInfo.setRecall_time(updateTime);
/*      */       
/*  619 */       AwardModel awardModel = AwardInterface.awardFixAward(SRecallFriendConsts.getInstance().RECALL_FRIEND_FIX_AWARD_ID, activeUserid, roleid, true, true, new AwardReason(LogReason.RECALL_FRIEND_AWARD));
/*      */       
/*      */ 
/*  622 */       if (awardModel == null)
/*      */       {
/*  624 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onRecallFriendResponse@award failed|retcode=%d|openid=%s|friend_openid=%s|serial=%d|count=%d|roleid=%d|friend_roleid=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Long.valueOf(serialNo), Integer.valueOf(recallContext.count), Long.valueOf(roleid), Long.valueOf(friendRoleid) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  631 */       tlogRecallFriend(activeUserid, roleid, String.valueOf(friendRoleid), recallContext.friendZoneid, friendOpenid, xActiveRecallFriendBackGame.getRecall_friend_num());
/*      */       
/*      */ 
/*      */ 
/*  635 */       SRecallFriendSuccess rsp = new SRecallFriendSuccess();
/*  636 */       rsp.role_id = friendRoleid;
/*  637 */       rsp.zone_id = recallContext.friendZoneid;
/*  638 */       rsp.invite_time = ((int)TimeUnit.MILLISECONDS.toSeconds(updateTime));
/*      */       try
/*      */       {
/*  641 */         rsp.open_id.setString(friendOpenid, "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e) {}
/*      */       
/*      */ 
/*  646 */       OnlineManager.getInstance().send(roleid, rsp);
/*      */       
/*  648 */       SSendRecallFriendSuccess sendRecallFriendSuccess = new SSendRecallFriendSuccess();
/*  649 */       sendRecallFriendSuccess.role_id = friendRoleid;
/*  650 */       sendRecallFriendSuccess.zone_id = recallContext.friendZoneid;
/*  651 */       sendRecallFriendSuccess.open_id = rsp.open_id;
/*  652 */       OnlineManager.getInstance().send(roleid, sendRecallFriendSuccess);
/*      */       
/*  654 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onRecallFriendResponse@success|retcode=%d|openid=%s|friend_openid=%s|serial=%d|count=%d|roleid=%d|friend_roleid=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Long.valueOf(serialNo), Integer.valueOf(recallContext.count), Long.valueOf(roleid), Long.valueOf(friendRoleid) }));
/*      */       
/*      */ 
/*      */ 
/*  658 */       return true;
/*      */     }
/*      */     
/*  661 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onRecallFriendResponse@failed|retcode=%d|openid=%s|friend_openid=%s|serial=%d|count=%d|roleid=%d|friend_roleid=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Long.valueOf(serialNo), Integer.valueOf(recallContext.count), Long.valueOf(roleid), Long.valueOf(friendRoleid) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  666 */     if (retcode == 8)
/*      */     {
/*  668 */       if (recallContext.count >= 3)
/*      */       {
/*  670 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onRecallFriendResponse@multiple time out|serial=%d", new Object[] { Long.valueOf(serialNo) }));
/*      */         
/*      */ 
/*  673 */         return false;
/*      */       }
/*      */       
/*  676 */       recallContext.count += 1;
/*  677 */       OctetsStream osContext = new OctetsStream();
/*  678 */       recallContext.marshal(osContext);
/*  679 */       if (!GrcManager.recallFriend(openid, friendOpenid, serialNo, SRecallFriendConsts.getInstance().RECALL_PERIOD_TIME, SRecallFriendConsts.getInstance().MAX_RECALL_TIMES_EVERY_DAY, SRecallFriendConsts.getInstance().ONE_PERIOD_BE_RECALL_TIMES, osContext))
/*      */       {
/*      */ 
/*      */ 
/*  683 */         sendRecallFailedMsg(roleid, friendOpenid, -10);
/*  684 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onRecallFriendResponse@send msg failed|serial=%d", new Object[] { Long.valueOf(serialNo) }));
/*      */         
/*  686 */         return false;
/*      */       }
/*  688 */       return true;
/*      */     }
/*      */     
/*  691 */     if (retcode == 10)
/*      */     {
/*  693 */       sendRecallFailedMsg(roleid, friendOpenid, -3);
/*  694 */       return false;
/*      */     }
/*  696 */     if (retcode == 700)
/*      */     {
/*  698 */       sendRecallFailedMsg(roleid, friendOpenid, -2);
/*  699 */       return false;
/*      */     }
/*  701 */     if (retcode == 701)
/*      */     {
/*  703 */       sendRecallFailedMsg(roleid, friendOpenid, -4);
/*  704 */       return false;
/*      */     }
/*  706 */     if (retcode == 702)
/*      */     {
/*  708 */       sendRecallFailedMsg(roleid, friendOpenid, -5);
/*  709 */       return false;
/*      */     }
/*  711 */     if (retcode == 703)
/*      */     {
/*  713 */       sendRecallFailedMsg(roleid, friendOpenid, -6);
/*  714 */       return false;
/*      */     }
/*  716 */     if (retcode == 704)
/*      */     {
/*  718 */       sendRecallFailedMsg(roleid, friendOpenid, -7);
/*  719 */       return false;
/*      */     }
/*  721 */     if (retcode == 706)
/*      */     {
/*  723 */       sendRecallFailedMsg(roleid, friendOpenid, -9);
/*  724 */       return false;
/*      */     }
/*  726 */     if (retcode == 705)
/*      */     {
/*  728 */       sendRecallFailedMsg(roleid, friendOpenid, -8);
/*  729 */       return false;
/*      */     }
/*  731 */     if (retcode == 707)
/*      */     {
/*  733 */       sendRecallFailedMsg(roleid, friendOpenid, -12);
/*  734 */       return false;
/*      */     }
/*  736 */     return false;
/*      */   }
/*      */   
/*      */   private static void sendRecallFailedMsg(long roleid, String friendOpenid, int retcode)
/*      */   {
/*  741 */     SRecallFriendFailed msg = new SRecallFriendFailed();
/*      */     try
/*      */     {
/*  744 */       msg.open_id.setString(friendOpenid, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*  749 */     msg.retcode = retcode;
/*  750 */     OnlineManager.getInstance().sendAtOnce(roleid, msg);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onBackResponse(int retcode, String openid, int activityCfgid, long serialNo, Octets context, GrcUserBackInfo backInfo)
/*      */   {
/*  756 */     OctetsStream os = new OctetsStream(context);
/*  757 */     BackContext backContext = new BackContext();
/*      */     try
/*      */     {
/*  760 */       backContext.unmarshal(os);
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/*  764 */       GameServer.logger().error("[recall]RecallFriendManager.onBackResponse@marshal error", e);
/*  765 */       return false;
/*      */     }
/*      */     
/*  768 */     long roleid = backContext.roleid;
/*  769 */     if (retcode == 0)
/*      */     {
/*  771 */       if (backInfo.recall_friends.isEmpty())
/*      */       {
/*  773 */         GameServer.logger().info(String.format("[recall]RecallFriendManager.onBackResponse@recall empty|retcode=%d|openid=%s|activity_cfgid=%d|count=%d|roleid=%d|serial=%d", new Object[] { Integer.valueOf(retcode), openid, Integer.valueOf(activityCfgid), Integer.valueOf(backContext.count), Long.valueOf(roleid), Long.valueOf(serialNo) }));
/*      */         
/*      */ 
/*      */ 
/*  777 */         return true;
/*      */       }
/*      */       
/*      */ 
/*  781 */       SyncUserBackInfo msg = new SyncUserBackInfo();
/*  782 */       msg.back_time = ((int)TimeUnit.MILLISECONDS.toSeconds(backInfo.back_time));
/*  783 */       msg.first = backInfo.first;
/*  784 */       for (GrcRecallFriendInfo friendInfo : backInfo.recall_friends)
/*      */       {
/*  786 */         FriendRecallInfo info = new FriendRecallInfo();
/*  787 */         GrcManager.boxFriendRecallInfo(info, friendInfo);
/*  788 */         msg.recall_friends.add(info);
/*      */       }
/*  790 */       OnlineManager.getInstance().send(roleid, msg);
/*      */       
/*  792 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onBackResponse@success|retcode=%d|openid=%s|activity_cfgid=%d|count=%d|roleid=%d|serial=%d", new Object[] { Integer.valueOf(retcode), openid, Integer.valueOf(activityCfgid), Integer.valueOf(backContext.count), Long.valueOf(roleid), Long.valueOf(serialNo) }));
/*      */       
/*      */ 
/*      */ 
/*  796 */       return true;
/*      */     }
/*      */     
/*  799 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onBackResponse@failed|retcode=%d|openid=%s|activity_cfgid=%d|count=%d|roleid=%d|serial=%d", new Object[] { Integer.valueOf(retcode), openid, Integer.valueOf(activityCfgid), Integer.valueOf(backContext.count), Long.valueOf(roleid), Long.valueOf(serialNo) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  804 */     if (retcode == 8)
/*      */     {
/*  806 */       if (backContext.count >= 3)
/*      */       {
/*  808 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onBackResponse@multiple time out|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*      */         
/*  810 */         return false;
/*      */       }
/*      */       
/*  813 */       backContext.count += 1;
/*  814 */       OctetsStream osContext = new OctetsStream();
/*  815 */       backContext.marshal(osContext);
/*      */       
/*  817 */       if (!GrcManager.back(openid, activityCfgid, serialNo, osContext))
/*      */       {
/*  819 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onBackResponse@send msg failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*      */         
/*  821 */         return false;
/*      */       }
/*  823 */       return true;
/*      */     }
/*  825 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onBindFriendResponse(int retcode, String openid, String friendOpenid, long serialNo, Octets context, BindFriendResponse response)
/*      */   {
/*  831 */     OctetsStream os = new OctetsStream(context);
/*  832 */     BindFriendContext bindContext = new BindFriendContext();
/*      */     try
/*      */     {
/*  835 */       bindContext.unmarshal(os);
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/*  839 */       GameServer.logger().error("[recall]RecallFriendManager.onBindFriendResponse@marshal error", e);
/*  840 */       return false;
/*      */     }
/*      */     
/*  843 */     long roleid = bindContext.roleid;
/*  844 */     if (retcode == 0)
/*      */     {
/*      */ 
/*  847 */       String userid = RoleInterface.getUserId(roleid);
/*  848 */       Lockeys.lock(Lockeys.get(xtable.User.getTable(), userid));
/*  849 */       Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*      */       
/*  851 */       sendAddBindVitalityInfo(openid, userid, roleid, response.vitalityInfo, response.friendVitalityInfo);
/*      */       
/*  853 */       int awardCfgId = SRecallFriendConsts.getInstance().BIND_FRIEND_AWARD_CFG_ID;
/*  854 */       AwardReason awardReason = new AwardReason(LogReason.RECALL_FRIEND_BIND_MAIL, awardCfgId);
/*  855 */       AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgId, roleid, awardReason);
/*  856 */       if (awardModel == null)
/*      */       {
/*  858 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onBindFriendResponse@award model null|roleid=%d|award_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(awardCfgId) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  863 */       MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, false);
/*  864 */       String friendName = response.friendVitalityInfo.user_info.nickname.getString("UTF-8");
/*  865 */       List<String> emptyStrings = Collections.emptyList();
/*  866 */       List<String> contextStrs = new ArrayList();
/*  867 */       contextStrs.add(friendName);
/*  868 */       contextStrs.add(String.valueOf(SRecallFriendConsts.getInstance().BIND_VITALITY));
/*      */       
/*  870 */       int mailCfgid = SRecallFriendConsts.getInstance().BACK_BIND_FRIEND_NOTIFY_MAIL_CFG_ID;
/*  871 */       TLogArg tLogArg = new TLogArg(LogReason.RECALL_FRIEND_BIND_MAIL);
/*  872 */       SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, mailCfgid, emptyStrings, contextStrs, attachment, tLogArg);
/*      */       
/*  874 */       if (!ret.isOK())
/*      */       {
/*  876 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onBindFriendResponse@send mail failed|roleid=%d|mail_cfgid=%d|ret=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(mailCfgid), String.valueOf(ret.getRetEnum()) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  883 */       new PNotifyBindFriend(userid, roleid, response).execute();
/*      */       
/*      */ 
/*  886 */       addTLog(roleid, "RecallBindFriendForServer", new Object[] { openid, friendOpenid, Long.valueOf(response.bindTime) });
/*      */       
/*      */ 
/*  889 */       SBindFriendSuccess rsp = new SBindFriendSuccess();
/*      */       try
/*      */       {
/*  892 */         rsp.open_id.setString(friendOpenid, "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e) {}
/*      */       
/*      */ 
/*  897 */       OnlineManager.getInstance().send(roleid, rsp);
/*      */       
/*  899 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onBindFriendResponse@success|retcode=%d|openid=%s|friend_openid=%s|serial=%d|count=%d|roleid=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Long.valueOf(serialNo), Integer.valueOf(bindContext.count), Long.valueOf(roleid) }));
/*      */       
/*      */ 
/*      */ 
/*  903 */       return true;
/*      */     }
/*      */     
/*  906 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onBindFriendResponse@failed|retcode=%d|openid=%s|friend_openid=%s|serial=%d|count=%d|roleid=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Long.valueOf(serialNo), Integer.valueOf(bindContext.count), Long.valueOf(roleid) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  911 */     if (retcode == 8)
/*      */     {
/*  913 */       if (bindContext.count >= 3)
/*      */       {
/*  915 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onBindFriendResponse@multiple time out|serial=%d", new Object[] { Long.valueOf(serialNo) }));
/*      */         
/*  917 */         return false;
/*      */       }
/*      */       
/*  920 */       bindContext.count += 1;
/*  921 */       OctetsStream osContext = new OctetsStream();
/*  922 */       bindContext.marshal(osContext);
/*      */       
/*  924 */       int bindPeriodInHour = SRecallFriendConsts.getInstance().BIND_PERIOD_IN_HOUR;
/*  925 */       int bindFriendNum = SRecallFriendConsts.getInstance().BIND_FRIEND_NUM;
/*  926 */       int beBindFriendNum = SRecallFriendConsts.getInstance().BE_BIND_FRIEND_NUM;
/*      */       
/*  928 */       if (!GrcManager.bindFriend(openid, friendOpenid, serialNo, bindPeriodInHour, bindFriendNum, beBindFriendNum, osContext))
/*      */       {
/*      */ 
/*  931 */         sendBindFriendFailedMsg(roleid, friendOpenid, -10);
/*  932 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onBindFriendResponse@send msg failed|serial=%d", new Object[] { Long.valueOf(serialNo) }));
/*      */         
/*  934 */         return false;
/*      */       }
/*  936 */       return true;
/*      */     }
/*      */     
/*  939 */     if (retcode == 10)
/*      */     {
/*  941 */       sendBindFriendFailedMsg(roleid, friendOpenid, -5);
/*  942 */       return false;
/*      */     }
/*  944 */     if (retcode == 707)
/*      */     {
/*  946 */       sendBindFriendFailedMsg(roleid, friendOpenid, -8);
/*  947 */       return false;
/*      */     }
/*  949 */     if (retcode == 708)
/*      */     {
/*  951 */       sendBindFriendFailedMsg(roleid, friendOpenid, -1);
/*  952 */       return false;
/*      */     }
/*  954 */     if (retcode == 709)
/*      */     {
/*  956 */       sendBindFriendFailedMsg(roleid, friendOpenid, -2);
/*  957 */       return false;
/*      */     }
/*  959 */     if (retcode == 710)
/*      */     {
/*  961 */       sendBindFriendFailedMsg(roleid, friendOpenid, -3);
/*  962 */       return false;
/*      */     }
/*  964 */     if (retcode == 711)
/*      */     {
/*  966 */       sendBindFriendFailedMsg(roleid, friendOpenid, -4);
/*  967 */       return false;
/*      */     }
/*  969 */     if (retcode == 712)
/*      */     {
/*  971 */       sendBindFriendFailedMsg(roleid, friendOpenid, -6);
/*  972 */       return false;
/*      */     }
/*  974 */     if (retcode == 716)
/*      */     {
/*  976 */       sendBindFriendFailedMsg(roleid, friendOpenid, -9);
/*  977 */       return false;
/*      */     }
/*  979 */     return false;
/*      */   }
/*      */   
/*      */   private static void sendBindFriendFailedMsg(long roleid, String friendOpenid, int retcode)
/*      */   {
/*  984 */     SBindFriendFailed msg = new SBindFriendFailed();
/*      */     try
/*      */     {
/*  987 */       msg.open_id.setString(friendOpenid, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*  992 */     msg.retcode = retcode;
/*  993 */     OnlineManager.getInstance().sendAtOnce(roleid, msg);
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendAddBindVitalityInfo(String openid, String userid, long roleid, List<GrcRoleInfo> grcRoleInfo, GrcBindFriendVitalityInfo friendVitalityInfo)
/*      */   {
/*  999 */     AddBindVitalityInfo msg = new AddBindVitalityInfo();
/*      */     
/* 1001 */     mzm.gsp.grc.RoleVitalityInfo vitalityInfo = msg.vitality_info;
/* 1002 */     mzm.gsp.grc.RecallUserInfo recallUserInfo = vitalityInfo.user_info;
/* 1003 */     xbean.User xUser = xtable.User.get(userid);
/* 1004 */     if (xUser != null)
/*      */     {
/*      */       try
/*      */       {
/* 1008 */         recallUserInfo.figure_url.setString(xUser.getFigure_url(), "UTF-8");
/* 1009 */         recallUserInfo.nickname.setString(xUser.getNick_name(), "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e) {}
/*      */     }
/*      */     
/*      */ 
/* 1015 */     if (grcRoleInfo.isEmpty())
/*      */     {
/* 1017 */       boxRoleVitalityInfo(roleid, vitalityInfo);
/*      */     }
/*      */     else
/*      */     {
/* 1021 */       boxRoleVitalityInfo((GrcRoleInfo)grcRoleInfo.get(0), vitalityInfo);
/*      */     }
/*      */     
/* 1024 */     BindVitalityInfo bindVitalityInfo = new BindVitalityInfo();
/* 1025 */     boxBindVitalityInfo(friendVitalityInfo, bindVitalityInfo);
/* 1026 */     msg.back_bind_infos.add(bindVitalityInfo);
/*      */     
/* 1028 */     OnlineManager.getInstance().send(roleid, msg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void notifyFriend(String openid, String userid, long roleid, long friendRoleid, int friendZoneid, List<GrcRoleInfo> grcRoleInfo, GrcBindFriendVitalityInfo friendVitalityInfo)
/*      */   {
/* 1035 */     if (GameServerInfoManager.isValidZone(friendZoneid))
/*      */     {
/* 1037 */       String friendUserid = RoleInterface.getUserId(friendRoleid);
/* 1038 */       Long onlineRoleid = Onlines.getInstance().getRoleid(friendUserid);
/* 1039 */       if (onlineRoleid == null)
/*      */       {
/* 1041 */         return;
/*      */       }
/* 1043 */       if (!OnlineManager.getInstance().isOnline(onlineRoleid.longValue()))
/*      */       {
/* 1045 */         return;
/*      */       }
/*      */       
/* 1048 */       Lockeys.lock(Lockeys.get(xtable.User.getTable(), new Object[] { userid, friendUserid }));
/* 1049 */       Lockeys.lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(roleid), Long.valueOf(friendRoleid) }));
/* 1050 */       AddBindVitalityInfo msg = new AddBindVitalityInfo();
/*      */       
/* 1052 */       mzm.gsp.grc.RoleVitalityInfo vitalityInfo = msg.vitality_info;
/* 1053 */       mzm.gsp.grc.RecallUserInfo recallUserInfo = vitalityInfo.user_info;
/* 1054 */       xbean.User xUser = xtable.User.get(friendUserid);
/* 1055 */       if (xUser != null)
/*      */       {
/*      */         try
/*      */         {
/* 1059 */           recallUserInfo.figure_url.setString(xUser.getFigure_url(), "UTF-8");
/* 1060 */           recallUserInfo.nickname.setString(xUser.getNick_name(), "UTF-8");
/*      */         }
/*      */         catch (UnsupportedEncodingException e) {}
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1067 */       if (friendVitalityInfo.roleinfo.roleid == onlineRoleid.longValue())
/*      */       {
/*      */ 
/* 1070 */         boxRoleVitalityInfo(onlineRoleid.longValue(), vitalityInfo);
/*      */       }
/*      */       else
/*      */       {
/* 1074 */         boxRoleVitalityInfo(friendVitalityInfo, vitalityInfo);
/*      */       }
/*      */       
/*      */ 
/* 1078 */       BindVitalityInfo bindVitalityInfo = new BindVitalityInfo();
/* 1079 */       bindVitalityInfo.bind_time = ((int)TimeUnit.MILLISECONDS.toSeconds(friendVitalityInfo.bind_time));
/* 1080 */       mzm.gsp.grc.RecallUserInfo recallUserInfo = bindVitalityInfo.user_info;
/* 1081 */       xbean.User xUser = xtable.User.get(userid);
/* 1082 */       if (xUser != null)
/*      */       {
/*      */         try
/*      */         {
/* 1086 */           recallUserInfo.openid.setString(openid, "UTF-8");
/* 1087 */           recallUserInfo.figure_url.setString(xUser.getFigure_url(), "UTF-8");
/* 1088 */           recallUserInfo.nickname.setString(xUser.getNick_name(), "UTF-8");
/*      */         }
/*      */         catch (UnsupportedEncodingException e) {}
/*      */       }
/*      */       
/*      */ 
/* 1094 */       if (grcRoleInfo.isEmpty())
/*      */       {
/*      */ 
/* 1097 */         boxBindVitalityInfo(roleid, bindVitalityInfo);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1102 */         boxBindVitalityInfo((GrcRoleInfo)grcRoleInfo.get(0), bindVitalityInfo);
/*      */       }
/* 1104 */       msg.recall_bind_infos.add(bindVitalityInfo);
/*      */       
/* 1106 */       OnlineManager.getInstance().send(onlineRoleid.longValue(), msg);
/* 1107 */       NoneRealTimeTaskManager.getInstance().addTask(new RSendBindMail(friendUserid, onlineRoleid.longValue(), openid));
/*      */     }
/*      */     else
/*      */     {
/* 1111 */       RecallNotifyBindFriendReq recallNotifyBindFriendReq = new RecallNotifyBindFriendReq();
/* 1112 */       recallNotifyBindFriendReq.roleid = friendRoleid;
/*      */       
/* 1114 */       BindFriendVitalityInfo bindFriendVitalityInfo = recallNotifyBindFriendReq.friend_vitality_info;
/* 1115 */       bindFriendVitalityInfo.bind_time = friendVitalityInfo.bind_time;
/* 1116 */       xbean.User xUser = xtable.User.get(userid);
/*      */       try
/*      */       {
/* 1119 */         bindFriendVitalityInfo.openid.setString(openid, "UTF-8");
/* 1120 */         bindFriendVitalityInfo.figure_url.setString(xUser.getFigure_url(), "UTF-8");
/* 1121 */         bindFriendVitalityInfo.nickname.setString(xUser.getNick_name(), "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e1) {}
/*      */       
/*      */ 
/* 1126 */       hub.RoleVitalityInfo roleVitalityInfo = bindFriendVitalityInfo.roleinfo;
/* 1127 */       if (grcRoleInfo.isEmpty())
/*      */       {
/* 1129 */         boxRoleVitalityInfo(userid, roleid, roleVitalityInfo);
/*      */       }
/*      */       else
/*      */       {
/* 1133 */         boxRoleVitalityInfo((GrcRoleInfo)grcRoleInfo.get(0), roleVitalityInfo);
/*      */       }
/*      */       
/*      */ 
/* 1137 */       boxRoleVitalityInfo(friendVitalityInfo, recallNotifyBindFriendReq.role_vitality_info);
/*      */       
/*      */ 
/* 1140 */       CrossServerInterface.notifyBindFriend(friendZoneid, userid, roleid, recallNotifyBindFriendReq);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onSendFriendMailResponse(int retcode, String openid, String friendOpenid, long serialNo, Octets context, String friendName)
/*      */   {
/* 1147 */     OctetsStream os = new OctetsStream(context);
/* 1148 */     SendFriendMailContext mailContext = new SendFriendMailContext();
/*      */     try
/*      */     {
/* 1151 */       mailContext.unmarshal(os);
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 1155 */       GameServer.logger().error("[recall]RecallFriendManager.onSendFriendMailResponse@marshal error", e);
/* 1156 */       return false;
/*      */     }
/*      */     
/* 1159 */     long roleid = mailContext.roleid;
/* 1160 */     if (retcode == 0)
/*      */     {
/* 1162 */       List<String> emptyStrings = Collections.emptyList();
/* 1163 */       List<String> contextStrs = new ArrayList();
/* 1164 */       contextStrs.add(friendName);
/* 1165 */       contextStrs.add(String.valueOf(SRecallFriendConsts.getInstance().BIND_VITALITY));
/*      */       
/*      */ 
/* 1168 */       String userid = RoleInterface.getUserId(roleid);
/* 1169 */       Lockeys.lock(Lockeys.get(xtable.User.getTable(), userid));
/* 1170 */       Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*      */       
/* 1172 */       int awardCfgId = SRecallFriendConsts.getInstance().BIND_FRIEND_AWARD_CFG_ID;
/* 1173 */       AwardReason awardReason = new AwardReason(LogReason.RECALL_FRIEND_BIND_MAIL, awardCfgId);
/* 1174 */       AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgId, roleid, awardReason);
/* 1175 */       if (awardModel == null)
/*      */       {
/* 1177 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onSendFriendMailResponse@award model null|roleid=%d|award_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(awardCfgId) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1182 */       MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, false);
/* 1183 */       int mailCfgid = SRecallFriendConsts.getInstance().RECALL_BIND_FRIEND_NOTIFY_MAIL_CFG_ID;
/* 1184 */       TLogArg tLogArg = new TLogArg(LogReason.RECALL_FRIEND_BIND_MAIL);
/* 1185 */       SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, mailCfgid, emptyStrings, contextStrs, attachment, tLogArg);
/*      */       
/*      */ 
/* 1188 */       if (!ret.isOK())
/*      */       {
/* 1190 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onSendFriendMailResponse@send mail failed|roleid=%d|mail_cfgid=%d|ret=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(mailCfgid), String.valueOf(ret.getRetEnum()) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1196 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onSendFriendMailResponse@success|retcode=%d|openid=%s|friend_openid=%s|serial=%d|count=%d|roleid=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Long.valueOf(serialNo), Integer.valueOf(mailContext.count), Long.valueOf(roleid) }));
/*      */       
/*      */ 
/*      */ 
/* 1200 */       return true;
/*      */     }
/*      */     
/* 1203 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onSendFriendMailResponse@failed|retcode=%d|openid=%s|friend_openid=%s|serial=%d|count=%d|roleid=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Long.valueOf(serialNo), Integer.valueOf(mailContext.count), Long.valueOf(roleid) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1208 */     if (retcode == 8)
/*      */     {
/* 1210 */       if (mailContext.count >= 3)
/*      */       {
/* 1212 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onSendFriendMailResponse@multiple time out|serial=%d", new Object[] { Long.valueOf(serialNo) }));
/*      */         
/*      */ 
/* 1215 */         return false;
/*      */       }
/*      */       
/* 1218 */       mailContext.count += 1;
/* 1219 */       OctetsStream osContext = new OctetsStream();
/* 1220 */       mailContext.marshal(osContext);
/* 1221 */       if (!GrcManager.sendBindMail(openid, friendOpenid, serialNo, osContext))
/*      */       {
/* 1223 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onSendFriendMailResponse@send msg failed|serial=%d", new Object[] { Long.valueOf(serialNo) }));
/*      */         
/*      */ 
/* 1226 */         return false;
/*      */       }
/* 1228 */       return true;
/*      */     }
/* 1230 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onUpdateRoleVitalityResponse(int retcode, String openid, RoleVitalityInfo vitalityInfo, Octets context)
/*      */   {
/* 1236 */     if (retcode == 0)
/*      */     {
/* 1238 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onUpdateRoleVitalityResponse@success|retcode=%d|openid=%s|roleid=%d|vitality=%d", new Object[] { Integer.valueOf(retcode), openid, Long.valueOf(vitalityInfo.roleid), Integer.valueOf(vitalityInfo.vitality) }));
/*      */       
/*      */ 
/*      */ 
/* 1242 */       return true;
/*      */     }
/*      */     
/* 1245 */     OctetsStream os = new OctetsStream(context);
/* 1246 */     int count = 0;
/*      */     try
/*      */     {
/* 1249 */       count = os.unmarshal_int();
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/* 1255 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onUpdateRoleVitalityResponse@failed|retcode=%d|openid=%s|roleid=%d|vitality=%d|count=%d", new Object[] { Integer.valueOf(retcode), openid, Long.valueOf(vitalityInfo.roleid), Integer.valueOf(vitalityInfo.vitality), Integer.valueOf(count) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1260 */     if (retcode == 8)
/*      */     {
/* 1262 */       if (count >= 3)
/*      */       {
/* 1264 */         return false;
/*      */       }
/*      */       
/* 1267 */       count++;
/* 1268 */       OctetsStream osContext = new OctetsStream();
/* 1269 */       osContext.marshal(count);
/*      */       
/* 1271 */       if (!GrcManager.updateRoleVitalityInfo(openid, vitalityInfo, osContext))
/*      */       {
/* 1273 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onUpdateRoleVitalityResponse@send msg failed|roleid=%d", new Object[] { Long.valueOf(vitalityInfo.roleid) }));
/*      */         
/*      */ 
/* 1276 */         return false;
/*      */       }
/* 1278 */       return true;
/*      */     }
/* 1280 */     return false;
/*      */   }
/*      */   
/*      */   static void boxRoleVitalityInfo(long roleid, mzm.gsp.grc.RoleVitalityInfo vitalityInfo)
/*      */   {
/* 1285 */     GrcManager.boxRecallRoleInfo(vitalityInfo.role_info, roleid);
/* 1286 */     vitalityInfo.vitality = ActiveInterface.getTotalActiveValue(roleid);
/* 1287 */     vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()));
/*      */   }
/*      */   
/*      */   static void boxRoleVitalityInfo(GrcRoleInfo grcRoleInfo, mzm.gsp.grc.RoleVitalityInfo vitalityInfo)
/*      */   {
/* 1292 */     GrcManager.boxRecallRoleInfo(vitalityInfo.role_info, grcRoleInfo);
/* 1293 */     OctetsStream os = new OctetsStream(grcRoleInfo.extra_info);
/*      */     try
/*      */     {
/* 1296 */       vitalityInfo.vitality = os.unmarshal_int();
/* 1297 */       vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(os.unmarshal_long()));
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void boxRoleVitalityInfo(GrcBindFriendVitalityInfo grcVitalityInfo, mzm.gsp.grc.RoleVitalityInfo vitalityInfo)
/*      */   {
/* 1307 */     GrcManager.boxRecallRoleInfo(vitalityInfo.role_info, grcVitalityInfo.roleinfo);
/* 1308 */     vitalityInfo.vitality = grcVitalityInfo.vitality;
/* 1309 */     vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(grcVitalityInfo.update_time));
/*      */   }
/*      */   
/*      */   static void boxRoleVitalityInfo(GrcRoleInfo grcRoleInfo, hub.RoleVitalityInfo vitalityInfo)
/*      */   {
/* 1314 */     vitalityInfo.fight = grcRoleInfo.fighting_capacity;
/* 1315 */     vitalityInfo.gender = grcRoleInfo.gender;
/* 1316 */     vitalityInfo.level = grcRoleInfo.level;
/* 1317 */     vitalityInfo.occupation = grcRoleInfo.occupation;
/* 1318 */     vitalityInfo.roleid = grcRoleInfo.roleid;
/* 1319 */     vitalityInfo.name = grcRoleInfo.rolename;
/* 1320 */     vitalityInfo.zoneid = grcRoleInfo.zoneid;
/*      */     
/* 1322 */     OctetsStream os = new OctetsStream(grcRoleInfo.extra_info);
/*      */     try
/*      */     {
/* 1325 */       vitalityInfo.vitality = os.unmarshal_int();
/* 1326 */       vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(os.unmarshal_long()));
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void boxRoleVitalityInfo(GrcBindFriendVitalityInfo grcVitalityInfo, hub.RoleVitalityInfo vitalityInfo)
/*      */   {
/* 1335 */     GrcRoleInfo grcRoleInfo = grcVitalityInfo.roleinfo;
/* 1336 */     vitalityInfo.fight = grcRoleInfo.fighting_capacity;
/* 1337 */     vitalityInfo.gender = grcRoleInfo.gender;
/* 1338 */     vitalityInfo.level = grcRoleInfo.level;
/* 1339 */     vitalityInfo.occupation = grcRoleInfo.occupation;
/* 1340 */     vitalityInfo.roleid = grcRoleInfo.roleid;
/* 1341 */     vitalityInfo.name = grcRoleInfo.rolename;
/* 1342 */     vitalityInfo.zoneid = grcRoleInfo.zoneid;
/* 1343 */     vitalityInfo.vitality = grcVitalityInfo.vitality;
/* 1344 */     vitalityInfo.update_time = grcVitalityInfo.update_time;
/*      */   }
/*      */   
/*      */   static void boxRoleVitalityInfo(String userid, long roleid, hub.RoleVitalityInfo vitalityInfo)
/*      */   {
/* 1349 */     Role role = RoleInterface.getRole(roleid, true);
/* 1350 */     vitalityInfo.fight = role.getFightValue();
/* 1351 */     vitalityInfo.gender = role.getGender();
/* 1352 */     vitalityInfo.level = role.getLevel();
/* 1353 */     vitalityInfo.occupation = role.getOccupationId();
/* 1354 */     vitalityInfo.roleid = roleid;
/*      */     try
/*      */     {
/* 1357 */       vitalityInfo.name.setString(role.getName(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 1362 */     vitalityInfo.zoneid = CommonUtils.getZoneId(userid);
/* 1363 */     vitalityInfo.vitality = ActiveInterface.getTotalActiveValue(roleid);
/* 1364 */     vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()));
/*      */   }
/*      */   
/*      */   static void boxBindVitalityInfo(GrcBindFriendVitalityInfo grcInfo, BindVitalityInfo vitalityInfo)
/*      */   {
/* 1369 */     GrcManager.boxRecallUserInfo(vitalityInfo.user_info, grcInfo.user_info);
/* 1370 */     GrcManager.boxRecallRoleInfo(vitalityInfo.role_info, grcInfo.roleinfo);
/*      */     
/* 1372 */     vitalityInfo.vitality = grcInfo.vitality;
/* 1373 */     vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(grcInfo.update_time));
/*      */     
/* 1375 */     vitalityInfo.bind_time = ((int)TimeUnit.MILLISECONDS.toSeconds(grcInfo.bind_time));
/* 1376 */     vitalityInfo.state = grcInfo.state;
/*      */   }
/*      */   
/*      */   static void boxBindVitalityInfo(GrcRoleInfo grcRoleInfo, BindVitalityInfo vitalityInfo)
/*      */   {
/* 1381 */     GrcManager.boxRecallRoleInfo(vitalityInfo.role_info, grcRoleInfo);
/*      */     
/* 1383 */     OctetsStream os = new OctetsStream(grcRoleInfo.extra_info);
/*      */     try
/*      */     {
/* 1386 */       vitalityInfo.vitality = os.unmarshal_int();
/* 1387 */       vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(os.unmarshal_long()));
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void boxBindVitalityInfo(long roleid, BindVitalityInfo vitalityInfo)
/*      */   {
/* 1396 */     GrcManager.boxRecallRoleInfo(vitalityInfo.role_info, roleid);
/* 1397 */     vitalityInfo.vitality = ActiveInterface.getTotalActiveValue(roleid);
/* 1398 */     vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()));
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onGetVitalityRewardResponse(int retcode, String openid, String friendOpenid, int bindType, long serialNo, Octets context, GetVitalityRewardResponse rsp)
/*      */   {
/* 1404 */     OctetsStream os = new OctetsStream(context);
/* 1405 */     GetVitalityRewardContext rewardContext = new GetVitalityRewardContext();
/*      */     try
/*      */     {
/* 1408 */       rewardContext.unmarshal(os);
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 1412 */       GameServer.logger().error("[recall]RecallFriendManager.onGetVitalityRewardResponse@marshal error", e);
/* 1413 */       return false;
/*      */     }
/*      */     
/* 1416 */     long roleid = rewardContext.roleid;
/* 1417 */     if (retcode == 0)
/*      */     {
/* 1419 */       long startTime = rsp.startTime;
/* 1420 */       long rewardTime = rsp.rewardTime;
/*      */       
/* 1422 */       int dayIndex = DateTimeUtils.diffDays(rewardTime, startTime) + 1;
/* 1423 */       SRecallVitalityAwardCfg vitalityAwardCfg = SRecallVitalityAwardCfg.get(dayIndex);
/* 1424 */       if (vitalityAwardCfg == null)
/*      */       {
/* 1426 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onGetVitalityRewardResponse@cfg is null|retcode=%d|openid=%s|friend_openid=%s|bind_type=%d|serial=%d|count=%d|roleid=%d|day=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Integer.valueOf(bindType), Long.valueOf(serialNo), Integer.valueOf(rewardContext.count), Long.valueOf(roleid), Integer.valueOf(dayIndex) }));
/*      */         
/*      */ 
/*      */ 
/* 1430 */         return false;
/*      */       }
/*      */       
/* 1433 */       int award = vitalityAwardCfg.backAward;
/* 1434 */       if (bindType == 1)
/*      */       {
/* 1436 */         award = vitalityAwardCfg.recallAward;
/*      */       }
/* 1438 */       String userid = RoleInterface.getUserId(roleid);
/* 1439 */       AwardReason awardReason = new AwardReason(LogReason.RECALL_FRIEND_VITALITY_AWARD, award);
/*      */       
/* 1441 */       AwardModel awardModel = AwardInterface.awardFixAward(award, userid, roleid, true, true, awardReason);
/* 1442 */       if (awardModel == null)
/*      */       {
/* 1444 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onGetVitalityRewardResponse@award failed|retcode=%d|openid=%s|friend_openid=%s|bind_type=%d|serial=%d|count=%d|roleid=%d|day=%d|award=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Integer.valueOf(bindType), Long.valueOf(serialNo), Integer.valueOf(rewardContext.count), Long.valueOf(roleid), Integer.valueOf(dayIndex), Integer.valueOf(award) }));
/*      */         
/*      */ 
/*      */ 
/* 1448 */         return false;
/*      */       }
/*      */       
/*      */ 
/* 1452 */       addTLog(roleid, "RecallGetVitalityRewardForServer", new Object[] { openid, friendOpenid, Long.valueOf(startTime), Long.valueOf(rewardTime), Integer.valueOf(award), Integer.valueOf(bindType), Long.valueOf(serialNo) });
/*      */       
/*      */ 
/* 1455 */       SGetBindRewardSuccess msg = new SGetBindRewardSuccess();
/* 1456 */       msg.bind_type = bindType;
/* 1457 */       msg.reward_time = ((int)TimeUnit.MILLISECONDS.toSeconds(rewardTime));
/*      */       try
/*      */       {
/* 1460 */         msg.open_id.setString(friendOpenid, "UTF-8");
/*      */       }
/*      */       catch (UnsupportedEncodingException e) {}
/*      */       
/*      */ 
/* 1465 */       OnlineManager.getInstance().send(roleid, msg);
/*      */       
/* 1467 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onGetVitalityRewardResponse@success|retcode=%d|openid=%s|friend_openid=%s|bind_type=%d|serial=%d|count=%d|roleid=%d|day=%d|award=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Integer.valueOf(bindType), Long.valueOf(serialNo), Integer.valueOf(rewardContext.count), Long.valueOf(roleid), Integer.valueOf(dayIndex), Integer.valueOf(award) }));
/*      */       
/*      */ 
/*      */ 
/* 1471 */       return true;
/*      */     }
/*      */     
/* 1474 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onGetVitalityRewardResponse@failed|retcode=%d|openid=%s|friend_openid=%s|bind_type=%d|serial=%d|count=%d|roleid=%d", new Object[] { Integer.valueOf(retcode), openid, friendOpenid, Integer.valueOf(bindType), Long.valueOf(serialNo), Integer.valueOf(rewardContext.count), Long.valueOf(roleid) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1479 */     if (retcode == 8)
/*      */     {
/* 1481 */       if (rewardContext.count >= 3)
/*      */       {
/* 1483 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onGetVitalityRewardResponse@multiple time out|serial=%d", new Object[] { Long.valueOf(serialNo) }));
/*      */         
/*      */ 
/* 1486 */         return false;
/*      */       }
/*      */       
/* 1489 */       rewardContext.count += 1;
/* 1490 */       OctetsStream osContext = new OctetsStream();
/* 1491 */       rewardContext.marshal(osContext);
/* 1492 */       if (!GrcManager.getBindReward(openid, friendOpenid, bindType, serialNo, SRecallFriendConsts.getInstance().BIND_VITALITY, osContext))
/*      */       {
/*      */ 
/* 1495 */         sendGetVitalityRewardFailedMsg(roleid, friendOpenid, bindType, -7);
/* 1496 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onGetVitalityRewardResponse@send msg failed|serial=%d", new Object[] { Long.valueOf(serialNo) }));
/*      */         
/*      */ 
/* 1499 */         return false;
/*      */       }
/* 1501 */       return true;
/*      */     }
/*      */     
/* 1504 */     if (retcode == 717)
/*      */     {
/* 1506 */       sendGetVitalityRewardFailedMsg(roleid, friendOpenid, bindType, -1);
/* 1507 */       return false;
/*      */     }
/* 1509 */     if (retcode == 718)
/*      */     {
/* 1511 */       sendGetVitalityRewardFailedMsg(roleid, friendOpenid, bindType, -2);
/* 1512 */       return false;
/*      */     }
/* 1514 */     if (retcode == 719)
/*      */     {
/* 1516 */       sendGetVitalityRewardFailedMsg(roleid, friendOpenid, bindType, -3);
/*      */       
/* 1518 */       return false;
/*      */     }
/* 1520 */     if (retcode == 720)
/*      */     {
/* 1522 */       sendGetVitalityRewardFailedMsg(roleid, friendOpenid, bindType, -4);
/*      */       
/* 1524 */       return false;
/*      */     }
/* 1526 */     if (retcode == 721)
/*      */     {
/* 1528 */       sendGetVitalityRewardFailedMsg(roleid, friendOpenid, bindType, -5);
/* 1529 */       return false;
/*      */     }
/* 1531 */     if (retcode == 713)
/*      */     {
/* 1533 */       sendGetVitalityRewardFailedMsg(roleid, friendOpenid, bindType, -6);
/* 1534 */       return false;
/*      */     }
/* 1536 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void sendGetVitalityRewardFailedMsg(long roleid, String friendOpenid, int bindType, int retcode)
/*      */   {
/* 1542 */     SGetBindRewardFailed msg = new SGetBindRewardFailed();
/*      */     try
/*      */     {
/* 1545 */       msg.open_id.setString(friendOpenid, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 1550 */     msg.bind_type = bindType;
/* 1551 */     msg.retcode = retcode;
/* 1552 */     OnlineManager.getInstance().sendAtOnce(roleid, msg);
/*      */   }
/*      */   
/*      */   static int notifyBindFriend(RecallNotifyBindFriendReq reqData)
/*      */   {
/* 1557 */     long roleid = reqData.roleid;
/* 1558 */     String userid = RoleInterface.getUserId(roleid);
/* 1559 */     if (userid == null)
/*      */     {
/* 1561 */       GameServer.logger().error(String.format("[recall]RecallFriendManager.notifyBindFriend@user not found|roleid=%d|req_data=%s", new Object[] { Long.valueOf(roleid), reqData }));
/*      */       
/*      */ 
/* 1564 */       return -1;
/*      */     }
/* 1566 */     Long onlineRoleid = Onlines.getInstance().getRoleid(userid);
/* 1567 */     if (onlineRoleid == null)
/*      */     {
/*      */ 
/* 1570 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.notifyBindFriend@role not online|userid=%s|req_data=%s", new Object[] { userid, reqData }));
/*      */       
/*      */ 
/* 1573 */       return -2;
/*      */     }
/*      */     
/* 1576 */     String openid = CommonUtils.getOpenId(userid);
/*      */     
/*      */ 
/* 1579 */     AddBindVitalityInfo msg = new AddBindVitalityInfo();
/*      */     
/* 1581 */     mzm.gsp.grc.RoleVitalityInfo vitalityInfo = msg.vitality_info;
/* 1582 */     mzm.gsp.grc.RecallUserInfo recallUserInfo = vitalityInfo.user_info;
/* 1583 */     xbean.User xUser = xtable.User.get(userid);
/*      */     try
/*      */     {
/* 1586 */       recallUserInfo.figure_url.setString(xUser.getFigure_url(), "UTF-8");
/* 1587 */       recallUserInfo.nickname.setString(xUser.getNick_name(), "UTF-8");
/* 1588 */       recallUserInfo.openid.setString(openid, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 1593 */     hub.RoleVitalityInfo hubRoleVitalityInfo = reqData.role_vitality_info;
/* 1594 */     if (hubRoleVitalityInfo.roleid != onlineRoleid.longValue())
/*      */     {
/* 1596 */       RecallRoleInfo recallRoleInfo = vitalityInfo.role_info;
/* 1597 */       recallRoleInfo.fight = hubRoleVitalityInfo.fight;
/* 1598 */       recallRoleInfo.gender = hubRoleVitalityInfo.gender;
/* 1599 */       recallRoleInfo.level = hubRoleVitalityInfo.level;
/* 1600 */       recallRoleInfo.occupation = hubRoleVitalityInfo.occupation;
/* 1601 */       recallRoleInfo.roleid = hubRoleVitalityInfo.roleid;
/* 1602 */       recallRoleInfo.rolename = hubRoleVitalityInfo.name;
/* 1603 */       recallRoleInfo.zoneid = hubRoleVitalityInfo.zoneid;
/*      */       
/*      */ 
/* 1606 */       vitalityInfo.vitality = hubRoleVitalityInfo.vitality;
/* 1607 */       vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(hubRoleVitalityInfo.update_time));
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1612 */       boxRoleVitalityInfo(onlineRoleid.longValue(), vitalityInfo);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1617 */     BindFriendVitalityInfo hubFriendVitalityInfo = reqData.friend_vitality_info;
/* 1618 */     BindVitalityInfo bindVitalityInfo = new BindVitalityInfo();
/* 1619 */     bindVitalityInfo.bind_time = ((int)TimeUnit.MILLISECONDS.toSeconds(hubFriendVitalityInfo.bind_time));
/*      */     
/* 1621 */     mzm.gsp.grc.RecallUserInfo recallUserInfo = bindVitalityInfo.user_info;
/* 1622 */     recallUserInfo.openid = hubFriendVitalityInfo.openid;
/* 1623 */     recallUserInfo.figure_url = hubFriendVitalityInfo.figure_url;
/* 1624 */     recallUserInfo.nickname = hubFriendVitalityInfo.nickname;
/*      */     
/* 1626 */     hub.RoleVitalityInfo hubRoleVitalityInfo = hubFriendVitalityInfo.roleinfo;
/* 1627 */     RecallRoleInfo recallRoleInfo = bindVitalityInfo.role_info;
/* 1628 */     recallRoleInfo.fight = hubRoleVitalityInfo.fight;
/* 1629 */     recallRoleInfo.gender = hubRoleVitalityInfo.gender;
/* 1630 */     recallRoleInfo.level = hubRoleVitalityInfo.level;
/* 1631 */     recallRoleInfo.occupation = hubRoleVitalityInfo.occupation;
/* 1632 */     recallRoleInfo.roleid = hubRoleVitalityInfo.roleid;
/* 1633 */     recallRoleInfo.rolename = hubRoleVitalityInfo.name;
/* 1634 */     recallRoleInfo.zoneid = hubRoleVitalityInfo.zoneid;
/*      */     
/* 1636 */     bindVitalityInfo.vitality = hubRoleVitalityInfo.vitality;
/* 1637 */     bindVitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(hubRoleVitalityInfo.update_time));
/*      */     
/* 1639 */     msg.recall_bind_infos.add(bindVitalityInfo);
/*      */     
/* 1641 */     OnlineManager.getInstance().send(onlineRoleid.longValue(), msg);
/*      */     
/* 1643 */     String friendOpenid = reqData.friend_vitality_info.openid.getString("UTF-8");
/* 1644 */     NoneRealTimeTaskManager.getInstance().addTask(new RSendBindMail(userid, onlineRoleid.longValue(), friendOpenid));
/* 1645 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onRecallRechargeRebateResponse(int retcode, String openid, int rebate, long serialNo, Octets context)
/*      */   {
/* 1651 */     if (retcode == 0)
/*      */     {
/* 1653 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onRecallRechargeRebateResponse@success|retcode=%d|openid=%s|rebate=%d|serial=%d", new Object[] { Integer.valueOf(retcode), openid, Integer.valueOf(rebate), Long.valueOf(serialNo) }));
/*      */       
/*      */ 
/*      */ 
/* 1657 */       return true;
/*      */     }
/*      */     
/* 1660 */     OctetsStream os = new OctetsStream(context);
/* 1661 */     int count = 0;
/*      */     try
/*      */     {
/* 1664 */       count = os.unmarshal_int();
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */     
/*      */ 
/*      */ 
/* 1670 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onRecallRechargeRebateResponse@failed|retcode=%d|openid=%s|rebate=%d|serial=%d|count=%d", new Object[] { Integer.valueOf(retcode), openid, Integer.valueOf(rebate), Long.valueOf(serialNo), Integer.valueOf(count) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1675 */     if (retcode == 8)
/*      */     {
/* 1677 */       if (count >= 3)
/*      */       {
/* 1679 */         return false;
/*      */       }
/*      */       
/* 1682 */       count++;
/* 1683 */       OctetsStream osContext = new OctetsStream();
/* 1684 */       osContext.marshal(count);
/* 1685 */       if (!GrcManager.recallRechargeRebate(openid, rebate, serialNo, SRecallFriendConsts.getInstance().YUAN_BAO_POLL_MAX, SRecallFriendConsts.getInstance().RECHARGE_REBATE_MAX, osContext))
/*      */       {
/*      */ 
/* 1688 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onRecallRechargeRebateResponse@send msg failed|openid=%s|serial=%d", new Object[] { openid, Long.valueOf(serialNo) }));
/*      */         
/*      */ 
/*      */ 
/* 1692 */         return false;
/*      */       }
/* 1694 */       return true;
/*      */     }
/* 1696 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onGetRecallRebateResponse(int retcode, String openid, int num, long serialNo, Octets context, GetRecallRebateResponse response)
/*      */   {
/* 1702 */     OctetsStream os = new OctetsStream(context);
/* 1703 */     GetRecallRebateContext rebateContext = new GetRecallRebateContext();
/*      */     try
/*      */     {
/* 1706 */       rebateContext.unmarshal(os);
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 1710 */       GameServer.logger().error("[recall]RecallFriendManager.onGetRecallRebateResponse@marshal error", e);
/* 1711 */       return false;
/*      */     }
/*      */     
/* 1714 */     long roleid = rebateContext.roleid;
/* 1715 */     if (retcode == 0)
/*      */     {
/*      */ 
/* 1718 */       String userid = RoleInterface.getUserId(roleid);
/* 1719 */       xbean.User xUser = xtable.User.get(userid);
/* 1720 */       Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*      */       
/* 1722 */       RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/* 1723 */       xbean.RebateInfo xRebateInfo = xRecallFriendBackGame.getRebate_info();
/* 1724 */       xRebateInfo.setReceive_num(response.receiveNum);
/* 1725 */       xRebateInfo.setReceive_time(response.receiveTime);
/* 1726 */       xRebateInfo.setTotal_num(response.totalNum);
/*      */       
/* 1728 */       TLogArg tLogArg = new TLogArg(LogReason.RECALL_FRIEND_BACK_REBATE);
/* 1729 */       if (QingfuInterface.presentYuanbao(userid, roleid, num, PresentType.PRSENT_BIND_RECALL_REBATE, tLogArg) != PresentResult.Success)
/*      */       {
/* 1731 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onGetRecallRebateResponse@presend yuanbao failed|openid=%s|roleid=%d|num=%d|serial=%d", new Object[] { openid, Long.valueOf(roleid), Integer.valueOf(num), Long.valueOf(serialNo) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1738 */       addTLog(roleid, "RecallGetBackRebateForServer", new Object[] { openid, Integer.valueOf(num), Integer.valueOf(response.totalNum), Integer.valueOf(response.receiveNum), Long.valueOf(response.receiveTime), Long.valueOf(serialNo) });
/*      */       
/*      */ 
/* 1741 */       SGetRecallRebateSuccess msg = new SGetRecallRebateSuccess();
/* 1742 */       msg.num = num;
/* 1743 */       mzm.gsp.grc.RebateInfo rebateInfo = msg.rebate_info;
/* 1744 */       rebateInfo.receive_num = response.receiveNum;
/* 1745 */       rebateInfo.receive_time = ((int)TimeUnit.MILLISECONDS.toSeconds(response.receiveTime));
/* 1746 */       rebateInfo.total_num = response.totalNum;
/* 1747 */       OnlineManager.getInstance().send(roleid, msg);
/*      */       
/* 1749 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onGetRecallRebateResponse@success|retcode=%d|openid=%s|roleid=%d|num=%d|serial=%d", new Object[] { Integer.valueOf(retcode), openid, Long.valueOf(roleid), Integer.valueOf(num), Long.valueOf(serialNo) }));
/*      */       
/*      */ 
/*      */ 
/* 1753 */       return true;
/*      */     }
/*      */     
/* 1756 */     int count = rebateContext.count;
/* 1757 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onRecallRechargeRebateResponse@failed|retcode=%d|openid=%s|roleid=%d|num=%d|serial=%d|count=%d", new Object[] { Integer.valueOf(retcode), openid, Long.valueOf(roleid), Integer.valueOf(num), Long.valueOf(serialNo), Integer.valueOf(count) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1762 */     if (retcode == 8)
/*      */     {
/* 1764 */       if (count >= 3)
/*      */       {
/* 1766 */         return false;
/*      */       }
/*      */       
/* 1769 */       rebateContext.count = (++count);
/* 1770 */       OctetsStream osContext = new OctetsStream();
/* 1771 */       rebateContext.marshal(osContext);
/* 1772 */       if (!GrcManager.getRecallRebate(openid, num, serialNo, SRecallFriendConsts.getInstance().YUAN_BAO_DRAW, osContext))
/*      */       {
/* 1774 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onRecallRechargeRebateResponse@send msg failed|openid=%s|serial=%d", new Object[] { openid, Long.valueOf(serialNo) }));
/*      */         
/*      */ 
/*      */ 
/* 1778 */         return false;
/*      */       }
/* 1780 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1784 */     if (retcode == 10)
/*      */     {
/* 1786 */       sendGetRecallRebateFailedMsg(roleid, num, -1);
/* 1787 */       return false;
/*      */     }
/* 1789 */     if (retcode == 722)
/*      */     {
/* 1791 */       sendGetRecallRebateFailedMsg(roleid, num, -2);
/* 1792 */       return false;
/*      */     }
/* 1794 */     if (retcode == 723)
/*      */     {
/* 1796 */       sendGetRecallRebateFailedMsg(roleid, num, -3);
/* 1797 */       return false;
/*      */     }
/* 1799 */     return false;
/*      */   }
/*      */   
/*      */   private static void sendGetRecallRebateFailedMsg(long roleid, int num, int retcode)
/*      */   {
/* 1804 */     SGetRecallRebateFailed msg = new SGetRecallRebateFailed();
/* 1805 */     msg.num = num;
/* 1806 */     msg.retcode = retcode;
/* 1807 */     OnlineManager.getInstance().sendAtOnce(roleid, msg);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onGetRecallRebateInfoResponse(int retcode, String openid, Octets context, GetRecallRebateResponse response)
/*      */   {
/* 1813 */     OctetsStream os = new OctetsStream(context);
/* 1814 */     GetRecallRebateInfoContext rebateContext = new GetRecallRebateInfoContext();
/*      */     try
/*      */     {
/* 1817 */       rebateContext.unmarshal(os);
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 1821 */       GameServer.logger().error("[recall]RecallFriendManager.onGetRecallRebateInfoResponse@marshal error", e);
/* 1822 */       return false;
/*      */     }
/*      */     
/* 1825 */     long roleid = rebateContext.roleid;
/* 1826 */     if (retcode == 0)
/*      */     {
/*      */ 
/* 1829 */       String userid = RoleInterface.getUserId(roleid);
/* 1830 */       xbean.User xUser = xtable.User.get(userid);
/* 1831 */       RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/* 1832 */       xbean.RebateInfo xRebateInfo = xRecallFriendBackGame.getRebate_info();
/* 1833 */       xRebateInfo.setReceive_num(response.receiveNum);
/* 1834 */       xRebateInfo.setReceive_time(response.receiveTime);
/* 1835 */       xRebateInfo.setTotal_num(response.totalNum);
/*      */       
/* 1837 */       SGetRecallRebateInfoSuccess msg = new SGetRecallRebateInfoSuccess();
/* 1838 */       mzm.gsp.grc.RebateInfo rebateInfo = msg.rebate_info;
/* 1839 */       rebateInfo.receive_num = response.receiveNum;
/* 1840 */       rebateInfo.receive_time = ((int)TimeUnit.MILLISECONDS.toSeconds(response.receiveTime));
/* 1841 */       rebateInfo.total_num = response.totalNum;
/* 1842 */       OnlineManager.getInstance().send(roleid, msg);
/*      */       
/* 1844 */       GameServer.logger().info(String.format("[recall]RecallFriendManager.onGetRecallRebateInfoResponse@success|retcode=%d|openid=%s|roleid=%d", new Object[] { Integer.valueOf(retcode), openid, Long.valueOf(roleid) }));
/*      */       
/*      */ 
/*      */ 
/* 1848 */       return true;
/*      */     }
/*      */     
/* 1851 */     int count = rebateContext.count;
/* 1852 */     GameServer.logger().error(String.format("[recall]RecallFriendManager.onGetRecallRebateInfoResponse@failed|retcode=%d|openid=%s|roleid=%d|count=%d", new Object[] { Integer.valueOf(retcode), openid, Long.valueOf(roleid), Integer.valueOf(count) }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1857 */     if (retcode == 8)
/*      */     {
/* 1859 */       if (count >= 3)
/*      */       {
/* 1861 */         return false;
/*      */       }
/*      */       
/* 1864 */       rebateContext.count = (++count);
/* 1865 */       OctetsStream osContext = new OctetsStream();
/* 1866 */       rebateContext.marshal(osContext);
/* 1867 */       if (!GrcManager.getRecallRebateInfo(openid, osContext))
/*      */       {
/* 1869 */         GameServer.logger().error(String.format("[recall]RecallFriendManager.onGetRecallRebateInfoResponse@send msg failed|openid=%s", new Object[] { openid }));
/*      */         
/*      */ 
/* 1872 */         return false;
/*      */       }
/* 1874 */       return true;
/*      */     }
/* 1876 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\RecallFriendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */