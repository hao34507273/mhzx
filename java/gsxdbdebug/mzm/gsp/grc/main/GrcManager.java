/*      */ package mzm.gsp.grc.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import gnet.GDeliveryManager;
/*      */ import gnet.link.Onlines;
/*      */ import grc.DataBetweenGameAndGrc;
/*      */ import grc.DataBetweenGameAndGrcArg;
/*      */ import grc.DataBetweenGameAndGrcRes;
/*      */ import grc.GrcBackBindFriendInfo;
/*      */ import grc.GrcBindFriendVitalityInfo;
/*      */ import grc.GrcBindRewardInfo;
/*      */ import grc.GrcGetFriendsList;
/*      */ import grc.GrcGetFriendsListArg;
/*      */ import grc.GrcGetFriendsListRes;
/*      */ import grc.GrcGetUserReceiveGiftInfoList;
/*      */ import grc.GrcGetUserReceiveGiftInfoListArg;
/*      */ import grc.GrcGetUserReceiveGiftInfoListRes;
/*      */ import grc.GrcLossUserInfo;
/*      */ import grc.GrcRebateInfo;
/*      */ import grc.GrcRecallFriendInfo;
/*      */ import grc.GrcRecallInfo;
/*      */ import grc.GrcRecallUserInfo;
/*      */ import grc.GrcReceiveAllGift;
/*      */ import grc.GrcReceiveAllGiftArg;
/*      */ import grc.GrcReceiveAllGiftRes;
/*      */ import grc.GrcReceiveGift;
/*      */ import grc.GrcReceiveGiftArg;
/*      */ import grc.GrcReceiveGiftRes;
/*      */ import grc.GrcRoleInfo;
/*      */ import grc.GrcSendGift;
/*      */ import grc.GrcSendGiftArg;
/*      */ import grc.GrcSendGiftRes;
/*      */ import grc.GrcUploadRoleInfo;
/*      */ import grc.GrcUploadRoleInfoArg;
/*      */ import grc.GrcUserBackInfo;
/*      */ import grc.GrcUserInfo;
/*      */ import grc.GrcUserLogin;
/*      */ import grc.GrcUserLoginArg;
/*      */ import grc.GrcUserLoginRes;
/*      */ import grc.GrcUserProfileInfo;
/*      */ import grc.GrcUserReceiveGiftMetaInfo;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.active.main.ActiveInterface;
/*      */ import mzm.gsp.activity.main.ActivityInterface;
/*      */ import mzm.gsp.alllotto.main.AllLottoOneByOneManager;
/*      */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*      */ import mzm.gsp.avatar.main.AvatarInterface;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.buff.main.BuffInterface;
/*      */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*      */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*      */ import mzm.gsp.crossbattle.point.CorpsPointRaceInfo;
/*      */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*      */ import mzm.gsp.fight.main.FightInterface;
/*      */ import mzm.gsp.friend.main.POnSaveGrcFriendRoleList;
/*      */ import mzm.gsp.grc.BindVitalityInfo;
/*      */ import mzm.gsp.grc.FriendBindInfo;
/*      */ import mzm.gsp.grc.FriendRecallInfo;
/*      */ import mzm.gsp.grc.GrcFriendInfo;
/*      */ import mzm.gsp.grc.RebateInfo;
/*      */ import mzm.gsp.grc.RecallLossInfo;
/*      */ import mzm.gsp.grc.RecallRoleInfo;
/*      */ import mzm.gsp.grc.SGrcReceiveAllGiftResp;
/*      */ import mzm.gsp.grc.SGrcReceiveGiftResp;
/*      */ import mzm.gsp.grc.SGrcSendGiftResp;
/*      */ import mzm.gsp.grc.SGrcTurnOnOffResp;
/*      */ import mzm.gsp.grc.SNotifyPrivilegeAwardTip;
/*      */ import mzm.gsp.grc.SReportQQVipPayInfoResp;
/*      */ import mzm.gsp.grc.SSyncGrcFriendsCountAwardInfo;
/*      */ import mzm.gsp.grc.SSyncGrcGetFriendList;
/*      */ import mzm.gsp.grc.SSyncGrcGiftTypeOnOff;
/*      */ import mzm.gsp.grc.SSyncGrcReceiveGiftList;
/*      */ import mzm.gsp.grc.SSyncGrcSendGiftList;
/*      */ import mzm.gsp.grc.SyncBackFriendBindInfo;
/*      */ import mzm.gsp.grc.SyncBindVitalityInfo;
/*      */ import mzm.gsp.grc.SyncRecallLossInfo;
/*      */ import mzm.gsp.grc.SyncUserBackInfo;
/*      */ import mzm.gsp.grc.confbean.GrcGiftCfg;
/*      */ import mzm.gsp.grc.confbean.SGrcConsts;
/*      */ import mzm.gsp.grc.confbean.SGrcGiftCfg;
/*      */ import mzm.gsp.grc.confbean.SPrivilegeAwardCfg;
/*      */ import mzm.gsp.grc.event.AntiAddictProxyDone;
/*      */ import mzm.gsp.grc.event.AntiAddictProxyDoneArg;
/*      */ import mzm.gsp.grc.event.BackDone;
/*      */ import mzm.gsp.grc.event.BackDoneArg;
/*      */ import mzm.gsp.grc.event.BindFriendDone;
/*      */ import mzm.gsp.grc.event.BindFriendDoneArg;
/*      */ import mzm.gsp.grc.event.ConfirmIndianaNumberDone;
/*      */ import mzm.gsp.grc.event.ConfirmIndianaNumberDoneArg;
/*      */ import mzm.gsp.grc.event.GetAllLottoAwardRoleInfoDone;
/*      */ import mzm.gsp.grc.event.GetAttendIndianaNumDoneArg;
/*      */ import mzm.gsp.grc.event.GetBindVitalityInfoDone;
/*      */ import mzm.gsp.grc.event.GetBindVitalityInfoDoneArg;
/*      */ import mzm.gsp.grc.event.GetCrossBattleKnockoutStageBetInfoDone;
/*      */ import mzm.gsp.grc.event.GetCrossBattleKnockoutStageBetInfoDoneArg;
/*      */ import mzm.gsp.grc.event.GetIndianaAwardNumberDoneArg;
/*      */ import mzm.gsp.grc.event.GetIndianaNumberDoneArg;
/*      */ import mzm.gsp.grc.event.GetRecallRebateDone;
/*      */ import mzm.gsp.grc.event.GetRecallRebateDoneArg;
/*      */ import mzm.gsp.grc.event.GetRecallRebateInfoDone;
/*      */ import mzm.gsp.grc.event.GetRecallRebateInfoDoneArg;
/*      */ import mzm.gsp.grc.event.GetVitalityRewardDone;
/*      */ import mzm.gsp.grc.event.GetVitalityRewardDoneArg;
/*      */ import mzm.gsp.grc.event.RecallFriendDone;
/*      */ import mzm.gsp.grc.event.RecallFriendDoneArg;
/*      */ import mzm.gsp.grc.event.RecallRechargeRebateDone;
/*      */ import mzm.gsp.grc.event.RecallRechargeRebateDoneArg;
/*      */ import mzm.gsp.grc.event.ReportAccountInfoDone;
/*      */ import mzm.gsp.grc.event.ReportAccountInfoDoneArg;
/*      */ import mzm.gsp.grc.event.ReportRoleCrossBattleKnockoutBetInfoDone;
/*      */ import mzm.gsp.grc.event.ReportRoleCrossBattleKnockoutBetInfoDoneArg;
/*      */ import mzm.gsp.grc.event.SendBindMailDone;
/*      */ import mzm.gsp.grc.event.SendBindMailDoneArg;
/*      */ import mzm.gsp.grc.event.UpdateRoleVitalityDone;
/*      */ import mzm.gsp.grc.event.UpdateRoleVitalityDoneArg;
/*      */ import mzm.gsp.guaji.main.GuajiInterface;
/*      */ import mzm.gsp.indiana.main.IndianaOneByOneManager;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.mail.main.SendMailRet;
/*      */ import mzm.gsp.online.main.AppInfo;
/*      */ import mzm.gsp.online.main.OnlineInfoArgs;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.pubdata.ModelInfo;
/*      */ import mzm.gsp.role.main.ModMoneyResult;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.VigorOperResult;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import mzm.gsp.util.Pair;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.OnlineUserInfo;
/*      */ import xbean.Pod;
/*      */ import xbean.PrivilegeAwardInfo;
/*      */ import xbean.QQVipObservers;
/*      */ import xbean.RecallFriendBackGame;
/*      */ import xbean.RoleGrcFriendInfo;
/*      */ import xbean.RolePrivilegeInfo;
/*      */ import xbean.UserGrcFriendInfo;
/*      */ import xbean.UserLoginPrivilegeInfo;
/*      */ import xbean.UserLoginPrivileges;
/*      */ import xbean.UserQQVipInfo;
/*      */ import xdb.Executor;
/*      */ import xdb.Xdb;
/*      */ import xtable.Onlineuserinfo;
/*      */ import xtable.Role2privilege;
/*      */ import xtable.User2grc_friend;
/*      */ import xtable.User2loginprivileges;
/*      */ import xtable.User2qqvipinfo;
/*      */ import xtable.User2qqvipobservers;
/*      */ 
/*      */ public class GrcManager
/*      */ {
/*      */   public static final String ENCODING = "UTF-8";
/*      */   
/*      */   static void init()
/*      */   {
/*  179 */     for (SPrivilegeAwardCfg cfg : SPrivilegeAwardCfg.getAll().values())
/*      */     {
/*  181 */       int buffCfgid = cfg.daily_team_instance_award_buff_cfg_id;
/*  182 */       if (buffCfgid > 0)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  187 */         switch (cfg.privilege_type)
/*      */         {
/*      */         case 1: 
/*  190 */           AwardInterface.registerBuffId2AddType(buffCfgid, 102);
/*  191 */           break;
/*      */         
/*      */         case 2: 
/*  194 */           AwardInterface.registerBuffId2AddType(buffCfgid, 103);
/*  195 */           break;
/*      */         
/*      */         case 3: 
/*  198 */           AwardInterface.registerBuffId2AddType(buffCfgid, 104);
/*  199 */           break;
/*      */         case 4: 
/*  201 */           AwardInterface.registerBuffId2AddType(buffCfgid, 100);
/*  202 */           break;
/*      */         case 5: 
/*  204 */           AwardInterface.registerBuffId2AddType(buffCfgid, 101);
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  212 */     ActivityInterface.registerActivityByLogicType(51, new ShareAwardActivityHandler());
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
/*      */   public static boolean canDoAction(long roleid, int aciton)
/*      */   {
/*  226 */     return RoleStatusInterface.checkCanSetStatus(roleid, aciton, true);
/*      */   }
/*      */   
/*      */   static void syncGrcFriendsCountAwardInfo(String userid, long roleid)
/*      */   {
/*  231 */     xbean.User xUser = xtable.User.get(userid);
/*  232 */     if (xUser == null)
/*      */     {
/*  234 */       return;
/*      */     }
/*      */     
/*  237 */     SSyncGrcFriendsCountAwardInfo core = new SSyncGrcFriendsCountAwardInfo();
/*  238 */     core.award_serial_no = xUser.getGrc_friends_count_award_serial_no();
/*  239 */     core.friends_count = xUser.getGrc_friends_count();
/*  240 */     OnlineManager.getInstance().send(roleid, core);
/*      */   }
/*      */   
/*      */   static boolean tryCalcTopRole(String userid, long currRoleId)
/*      */   {
/*  245 */     xbean.User xUser = xtable.User.get(userid);
/*  246 */     if (xUser == null)
/*      */     {
/*  248 */       return false;
/*      */     }
/*      */     
/*  251 */     long oldTopRoleByFightingCapacity = xUser.getMax_fighting_capacity_roleid();
/*  252 */     if (oldTopRoleByFightingCapacity == currRoleId)
/*      */     {
/*  254 */       return true;
/*      */     }
/*      */     
/*  257 */     int max = 0;
/*  258 */     long maxFightingCapacityRoleid = 0L;
/*  259 */     for (Iterator i$ = xUser.getRoleids().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  261 */       int fightingCapacity = RoleInterface.getFightValue(roleid);
/*  262 */       Integer deleteStatus = RoleInterface.getDeleteState(roleid);
/*  263 */       if ((fightingCapacity > max) && ((deleteStatus == null) || (deleteStatus.intValue() == 3)))
/*      */       {
/*  265 */         maxFightingCapacityRoleid = roleid;
/*  266 */         max = fightingCapacity;
/*      */       }
/*      */     }
/*  269 */     xUser.setMax_fighting_capacity_roleid(maxFightingCapacityRoleid);
/*      */     
/*  271 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isOpenPrivilege(long roleid)
/*      */   {
/*  276 */     if (!OpenInterface.getOpenStatus(122))
/*      */     {
/*  278 */       return false;
/*      */     }
/*      */     
/*  281 */     if (OpenInterface.isBanPlay(roleid, 122))
/*      */     {
/*  283 */       OpenInterface.sendBanPlayMsg(roleid, 122);
/*  284 */       return false;
/*      */     }
/*      */     
/*  287 */     return true;
/*      */   }
/*      */   
/*      */   static void updateQQVipInfos(String userid, long roleid, Map<Integer, grc.QQVipInfo> qqVipInfos)
/*      */   {
/*  292 */     UserQQVipInfo xUserQQVipInfo = User2qqvipinfo.get(userid);
/*  293 */     if (xUserQQVipInfo == null)
/*      */     {
/*  295 */       xUserQQVipInfo = Pod.newUserQQVipInfo();
/*  296 */       User2qqvipinfo.insert(userid, xUserQQVipInfo);
/*      */     }
/*      */     
/*  299 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  300 */     xUserQQVipInfo.getVipinfos().clear();
/*  301 */     for (grc.QQVipInfo qqVipInfo : qqVipInfos.values())
/*      */     {
/*  303 */       int vipFlag = qqVipInfo.vip_flag;
/*  304 */       long expireTimestamp = qqVipInfo.expire_timestamp * 1000L;
/*  305 */       if ((expireTimestamp > 0L) && (qqVipInfo.is_vip != 0))
/*      */       {
/*  307 */         long serviceTime = expireTimestamp - curTime;
/*  308 */         if (serviceTime <= 0L) {
/*      */           continue;
/*      */         }
/*      */         
/*  312 */         if (serviceTime <= 345600000L)
/*      */         {
/*  314 */           QQVipObservers xQQVipObservers = User2qqvipobservers.get(userid);
/*  315 */           if (xQQVipObservers == null)
/*      */           {
/*  317 */             xQQVipObservers = Pod.newQQVipObservers();
/*  318 */             User2qqvipobservers.add(userid, xQQVipObservers);
/*      */           }
/*  320 */           QQVipLostObserver observer = new QQVipLostObserver(roleid, vipFlag, (serviceTime - 1L) / 1000L + 1L);
/*  321 */           QQVipLostObserver oldObserver = (QQVipLostObserver)xQQVipObservers.getObservers().put(Integer.valueOf(vipFlag), observer);
/*  322 */           if (oldObserver != null)
/*      */           {
/*  324 */             oldObserver.stopTimer();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  329 */       xbean.QQVipInfo xQQVipInfo = Pod.newQQVipInfo();
/*  330 */       xQQVipInfo.setVip_flag(vipFlag);
/*  331 */       xQQVipInfo.setIs_vip(qqVipInfo.is_vip == 1);
/*  332 */       xQQVipInfo.setIs_year(qqVipInfo.is_year == 1);
/*  333 */       xQQVipInfo.setIs_luxury(qqVipInfo.is_luxury == 1);
/*  334 */       xQQVipInfo.setLevel(qqVipInfo.level);
/*  335 */       xQQVipInfo.setExpire_timestamp(qqVipInfo.expire_timestamp);
/*  336 */       xUserQQVipInfo.getVipinfos().put(Integer.valueOf(qqVipInfo.vip_flag), xQQVipInfo);
/*      */     }
/*      */   }
/*      */   
/*      */   static void removeQQVipInfos(String userid)
/*      */   {
/*  342 */     User2qqvipinfo.remove(userid);
/*      */   }
/*      */   
/*      */   static int getLoginPrivilegeFromDB(String userid, boolean isHoldLock, boolean skipCheck)
/*      */   {
/*  347 */     UserLoginPrivileges xUserLoginPrivileges = isHoldLock ? User2loginprivileges.get(userid) : User2loginprivileges.select(userid);
/*      */     
/*  349 */     if (xUserLoginPrivileges == null)
/*      */     {
/*  351 */       return 0;
/*      */     }
/*      */     
/*  354 */     String platName = CommonUtils.getPlatName(userid);
/*  355 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  356 */     for (Map.Entry<Integer, UserLoginPrivilegeInfo> entry : xUserLoginPrivileges.getPrivileges().entrySet())
/*      */     {
/*  358 */       int privilege = ((Integer)entry.getKey()).intValue();
/*  359 */       if (privilege == 2 ? 
/*      */       
/*  361 */         "wechat".equals(platName) : 
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  366 */         (privilege != 1) || 
/*      */         
/*  368 */         ("qq".equals(platName)))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  374 */         if (skipCheck)
/*      */         {
/*  376 */           return privilege;
/*      */         }
/*      */         
/*  379 */         UserLoginPrivilegeInfo xUserLoginPrivilegeInfo = (UserLoginPrivilegeInfo)entry.getValue();
/*  380 */         if (!DateTimeUtils.needDailyReset(xUserLoginPrivilegeInfo.getRecord_time(), currTime, 0))
/*      */         {
/*  382 */           return privilege;
/*      */         }
/*      */       }
/*      */     }
/*  386 */     return 0;
/*      */   }
/*      */   
/*      */   static int getLoginPrivilegeFromOnlineUserInfo(String userid, boolean isHoldLock)
/*      */   {
/*  391 */     OnlineUserInfo xOnlineUserInfo = isHoldLock ? Onlineuserinfo.get(userid) : Onlineuserinfo.select(userid);
/*      */     
/*  393 */     if (xOnlineUserInfo == null)
/*      */     {
/*  395 */       return 0;
/*      */     }
/*  397 */     String privilegeValue = Onlines.getInstance().findEnumFromLoginArg(12, xOnlineUserInfo);
/*      */     
/*      */ 
/*  400 */     if (privilegeValue == null)
/*      */     {
/*  402 */       return 0;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*  407 */       int privilege = Integer.parseInt(privilegeValue);
/*  408 */       String platName = CommonUtils.getPlatName(userid);
/*  409 */       if (privilege == 2)
/*      */       {
/*  411 */         if (!"wechat".equals(platName))
/*      */         {
/*  413 */           return 0;
/*      */         }
/*      */       }
/*  416 */       else if (privilege == 1)
/*      */       {
/*  418 */         if (!"qq".equals(platName))
/*      */         {
/*  420 */           return 0;
/*      */         }
/*      */       }
/*      */       
/*  424 */       return privilege;
/*      */     }
/*      */     catch (NumberFormatException e) {}
/*      */     
/*  428 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */   static int getLoginPrivilege(String userid, boolean isHoldLock)
/*      */   {
/*  434 */     return getLoginPrivilege(userid, isHoldLock, false);
/*      */   }
/*      */   
/*      */   static int getLoginPrivilege(String userid, boolean isHoldLock, boolean skipCheck)
/*      */   {
/*  439 */     int privilege = getLoginPrivilegeFromOnlineUserInfo(userid, isHoldLock);
/*  440 */     if (privilege != 0)
/*      */     {
/*  442 */       return privilege;
/*      */     }
/*      */     
/*  445 */     return getLoginPrivilegeFromDB(userid, isHoldLock, skipCheck);
/*      */   }
/*      */   
/*      */   static void tryUpdateLoginPrivilege(String userid)
/*      */   {
/*  450 */     int privilege = getLoginPrivilegeFromOnlineUserInfo(userid, true);
/*  451 */     if (privilege == 2)
/*      */     {
/*  453 */       UserLoginPrivileges xUserLoginPrivileges = User2loginprivileges.get(userid);
/*  454 */       if (xUserLoginPrivileges == null)
/*      */       {
/*  456 */         xUserLoginPrivileges = Pod.newUserLoginPrivileges();
/*  457 */         User2loginprivileges.add(userid, xUserLoginPrivileges);
/*      */       }
/*      */       
/*  460 */       UserLoginPrivilegeInfo xUserLoginPrivilegeInfo = (UserLoginPrivilegeInfo)xUserLoginPrivileges.getPrivileges().get(Integer.valueOf(privilege));
/*  461 */       if (xUserLoginPrivilegeInfo == null)
/*      */       {
/*  463 */         xUserLoginPrivilegeInfo = Pod.newUserLoginPrivilegeInfo();
/*  464 */         xUserLoginPrivileges.getPrivileges().put(Integer.valueOf(privilege), xUserLoginPrivilegeInfo);
/*      */       }
/*      */       
/*  467 */       long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  468 */       xUserLoginPrivilegeInfo.setRecord_time(currTime);
/*      */     }
/*      */     else
/*      */     {
/*  472 */       UserLoginPrivileges xUserLoginPrivileges = User2loginprivileges.get(userid);
/*  473 */       if (xUserLoginPrivileges == null)
/*      */       {
/*  475 */         return;
/*      */       }
/*      */       
/*  478 */       UserLoginPrivilegeInfo xUserLoginPrivilegeInfo = (UserLoginPrivilegeInfo)xUserLoginPrivileges.getPrivileges().get(Integer.valueOf(2));
/*      */       
/*  480 */       if (xUserLoginPrivilegeInfo == null)
/*      */       {
/*  482 */         return;
/*      */       }
/*      */       
/*  485 */       long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  486 */       if (DateTimeUtils.needDailyReset(xUserLoginPrivilegeInfo.getRecord_time(), currTime, 0))
/*      */       {
/*  488 */         xUserLoginPrivileges.getPrivileges().remove(Integer.valueOf(2));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static int getQQVipPrivilege(String userid)
/*      */   {
/*  495 */     UserQQVipInfo xUserQQVipInfo = User2qqvipinfo.get(userid);
/*  496 */     if (xUserQQVipInfo == null)
/*      */     {
/*  498 */       return 0;
/*      */     }
/*      */     
/*      */ 
/*  502 */     xbean.QQVipInfo xQQVipInfo = (xbean.QQVipInfo)xUserQQVipInfo.getVipinfos().get(Integer.valueOf(16));
/*  503 */     if ((xQQVipInfo != null) && (xQQVipInfo.getIs_vip()))
/*      */     {
/*  505 */       return 5;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  510 */     xbean.QQVipInfo xQQVipInfo = (xbean.QQVipInfo)xUserQQVipInfo.getVipinfos().get(Integer.valueOf(1));
/*  511 */     if ((xQQVipInfo != null) && (xQQVipInfo.getIs_vip()))
/*      */     {
/*  513 */       return 4;
/*      */     }
/*      */     
/*      */ 
/*  517 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean tryAddLoginPrivilegeAward(String userid, long roleid, int loginPrivilege, SPrivilegeAwardCfg privilegeAwardCfg)
/*      */   {
/*  523 */     RolePrivilegeInfo xRolePrivilegeInfo = Role2privilege.get(Long.valueOf(roleid));
/*  524 */     if (xRolePrivilegeInfo == null)
/*      */     {
/*  526 */       xRolePrivilegeInfo = Pod.newRolePrivilegeInfo();
/*      */       
/*  528 */       Role2privilege.insert(Long.valueOf(roleid), xRolePrivilegeInfo);
/*      */     }
/*      */     
/*  531 */     int awardNum = 0;
/*  532 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  533 */     PrivilegeAwardInfo xPrivilegeAwardInfo = (PrivilegeAwardInfo)xRolePrivilegeInfo.getLogin_award_infos().get(Integer.valueOf(loginPrivilege));
/*  534 */     if (xPrivilegeAwardInfo == null)
/*      */     {
/*  536 */       xPrivilegeAwardInfo = Pod.newPrivilegeAwardInfo();
/*  537 */       xRolePrivilegeInfo.getLogin_award_infos().put(Integer.valueOf(loginPrivilege), xPrivilegeAwardInfo);
/*      */     }
/*      */     else
/*      */     {
/*  541 */       if (DateTimeUtils.needDailyReset(xPrivilegeAwardInfo.getAward_timestamp(), currTime, 0))
/*      */       {
/*  543 */         awardNum = 0;
/*      */       }
/*      */       else
/*      */       {
/*  547 */         awardNum = xPrivilegeAwardInfo.getAward_num();
/*      */       }
/*      */       
/*  550 */       if (awardNum >= 1)
/*      */       {
/*  552 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  556 */     xPrivilegeAwardInfo.setAward_num(awardNum + 1);
/*  557 */     xPrivilegeAwardInfo.setAward_timestamp(currTime);
/*      */     
/*  559 */     int dailyMailCfgid = privilegeAwardCfg.daily_award_mail_cfg_id;
/*  560 */     if (dailyMailCfgid > 0)
/*      */     {
/*  562 */       TLogArg tLogArg = new TLogArg(LogReason.GRC_LOGIN_PRIVILEGE_AWARD_ADD, loginPrivilege);
/*  563 */       SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, dailyMailCfgid, null, null, tLogArg);
/*  564 */       if (!ret.isOK())
/*      */       {
/*  566 */         GameServer.logger().error(String.format("[grc]GrcManager.tryAddLoginPrivilegeAward@add mail failed|userid=%s|roleid=%d|login_privilege=%d|daily_mail_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(loginPrivilege), Integer.valueOf(dailyMailCfgid) }));
/*      */         
/*      */ 
/*      */ 
/*  570 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  574 */     return true;
/*      */   }
/*      */   
/*      */   static boolean tryAddLoginPrivilegeAward(String userid, long roleid)
/*      */   {
/*  579 */     int loginPrivilege = getLoginPrivilege(userid, false);
/*  580 */     if (loginPrivilege == 0)
/*      */     {
/*  582 */       return true;
/*      */     }
/*      */     
/*  585 */     SPrivilegeAwardCfg privilegeAwardCfg = SPrivilegeAwardCfg.get(loginPrivilege);
/*  586 */     if (privilegeAwardCfg == null)
/*      */     {
/*  588 */       return false;
/*      */     }
/*      */     
/*  591 */     int buffId = privilegeAwardCfg.daily_team_instance_award_buff_cfg_id;
/*  592 */     if (buffId > 0)
/*      */     {
/*  594 */       if (!BuffInterface.isContainBuff(roleid, buffId))
/*      */       {
/*  596 */         BuffInterface.installBuff(roleid, buffId);
/*      */       }
/*      */     }
/*      */     
/*  600 */     return tryAddLoginPrivilegeAward(userid, roleid, loginPrivilege, privilegeAwardCfg);
/*      */   }
/*      */   
/*      */   static boolean tryAwardForQQVipPrivilege(String userid, long roleid, int privilege)
/*      */   {
/*  605 */     int awardMailCfgid = 0;
/*  606 */     if (5 == privilege)
/*      */     {
/*  608 */       awardMailCfgid = SGrcConsts.getInstance().SUPER_VIP_FRESHMAN_AWARD_MAIL_CFG_ID;
/*      */     }
/*  610 */     else if (4 == privilege)
/*      */     {
/*  612 */       awardMailCfgid = SGrcConsts.getInstance().NORMAL_VIP_FRESHMAN_AWARD_MAIL_CFG_ID;
/*      */     }
/*      */     
/*  615 */     RolePrivilegeInfo xRolePrivilegeInfo = Role2privilege.get(Long.valueOf(roleid));
/*  616 */     if (xRolePrivilegeInfo == null)
/*      */     {
/*  618 */       xRolePrivilegeInfo = Pod.newRolePrivilegeInfo();
/*      */       
/*  620 */       Role2privilege.insert(Long.valueOf(roleid), xRolePrivilegeInfo);
/*      */     }
/*      */     
/*  623 */     int awardNum = 0;
/*  624 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  625 */     PrivilegeAwardInfo xPrivilegeAwardInfo = (PrivilegeAwardInfo)xRolePrivilegeInfo.getFreshman_award_infos().get(Integer.valueOf(privilege));
/*  626 */     if (xPrivilegeAwardInfo == null)
/*      */     {
/*  628 */       xPrivilegeAwardInfo = Pod.newPrivilegeAwardInfo();
/*  629 */       xRolePrivilegeInfo.getFreshman_award_infos().put(Integer.valueOf(privilege), xPrivilegeAwardInfo);
/*      */     }
/*      */     else
/*      */     {
/*  633 */       awardNum = xPrivilegeAwardInfo.getAward_num();
/*  634 */       if (awardNum >= 1)
/*      */       {
/*  636 */         return true;
/*      */       }
/*      */     }
/*  639 */     xPrivilegeAwardInfo.setAward_num(awardNum + 1);
/*  640 */     xPrivilegeAwardInfo.setAward_timestamp(currTime);
/*      */     
/*  642 */     if (awardMailCfgid > 0)
/*      */     {
/*  644 */       TLogArg tLogArg = new TLogArg(LogReason.GRC_QQ_VIP_PRIVILEGE_FRESHMEN_AWARD_ADD, privilege);
/*  645 */       SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, awardMailCfgid, null, null, tLogArg);
/*  646 */       if (!ret.isOK())
/*      */       {
/*  648 */         GameServer.logger().error(String.format("[grc]GrcManager.tryAwardForQQVipPrivilege@add mail failed|userid=%s|roleid=%d|privilege=%d|award_mail_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(privilege), Integer.valueOf(awardMailCfgid) }));
/*      */         
/*      */ 
/*      */ 
/*  652 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  656 */     return true;
/*      */   }
/*      */   
/*      */   static boolean tryAwardForQQVipPrivilege(String userid, long roleid)
/*      */   {
/*  661 */     int privilege = getQQVipPrivilege(userid);
/*  662 */     if (privilege <= 0)
/*      */     {
/*  664 */       return true;
/*      */     }
/*      */     
/*  667 */     SPrivilegeAwardCfg privilegeAwardCfg = SPrivilegeAwardCfg.get(privilege);
/*  668 */     if (privilegeAwardCfg == null)
/*      */     {
/*  670 */       return false;
/*      */     }
/*      */     
/*  673 */     int buffId = privilegeAwardCfg.daily_team_instance_award_buff_cfg_id;
/*  674 */     if (buffId > 0)
/*      */     {
/*  676 */       if (!BuffInterface.isContainBuff(roleid, buffId))
/*      */       {
/*  678 */         BuffInterface.installBuff(roleid, buffId);
/*      */       }
/*      */     }
/*      */     
/*  682 */     return tryAwardForQQVipPrivilege(userid, roleid, privilege);
/*      */   }
/*      */   
/*      */   static boolean tryAwardForQQVipPay(String userid, long roleid, int vipFlag)
/*      */   {
/*  687 */     int privilege = getQQVipPrivilege(userid);
/*  688 */     if (privilege <= 0)
/*      */     {
/*  690 */       return true;
/*      */     }
/*      */     
/*  693 */     xbean.User xUser = xtable.User.get(userid);
/*  694 */     if (xUser == null)
/*      */     {
/*  696 */       return false;
/*      */     }
/*      */     
/*  699 */     int awardNum = 0;
/*  700 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  701 */     PrivilegeAwardInfo xPrivilegeAwardInfo = (PrivilegeAwardInfo)xUser.getPrivilege_award_infos().get(Integer.valueOf(privilege));
/*  702 */     if (xPrivilegeAwardInfo == null)
/*      */     {
/*  704 */       xPrivilegeAwardInfo = Pod.newPrivilegeAwardInfo();
/*  705 */       xUser.getPrivilege_award_infos().put(Integer.valueOf(privilege), xPrivilegeAwardInfo);
/*      */     }
/*      */     else
/*      */     {
/*  709 */       if (DateTimeUtils.needMonthlyReset(xPrivilegeAwardInfo.getAward_timestamp(), currTime, 1, 0))
/*      */       {
/*  711 */         awardNum = 0;
/*      */       }
/*      */       else
/*      */       {
/*  715 */         awardNum = xPrivilegeAwardInfo.getAward_num();
/*      */       }
/*      */       
/*  718 */       if (awardNum >= 1)
/*      */       {
/*  720 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  724 */     xPrivilegeAwardInfo.setAward_num(awardNum + 1);
/*  725 */     xPrivilegeAwardInfo.setAward_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*      */     
/*  727 */     int awardMailCfgid = vipFlag == 1 ? SGrcConsts.getInstance().NORMAL_VIP_PAY_AWARD_MAIL_CFG_ID : SGrcConsts.getInstance().SUPER_VIP_PAY_AWARD_MAIL_CFG_ID;
/*      */     
/*      */ 
/*  730 */     if (awardMailCfgid > 0)
/*      */     {
/*  732 */       TLogArg tLogArg = new TLogArg(LogReason.GRC_QQ_VIP_PRIVILEGE_PAY_AWARD_ADD, privilege);
/*  733 */       SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, awardMailCfgid, null, null, tLogArg);
/*  734 */       if (!ret.isOK())
/*      */       {
/*  736 */         GameServer.logger().error(String.format("[grc]GrcManager.tryAwardForQQVipPay@add mail failed|userid=%s|roleid=%d|vip_flag=%d|privilege=%d|award_mail_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(vipFlag), Integer.valueOf(privilege), Integer.valueOf(awardMailCfgid) }));
/*      */         
/*      */ 
/*      */ 
/*  740 */         return false;
/*      */       }
/*      */     }
/*  743 */     return true;
/*      */   }
/*      */   
/*      */   static boolean addSignExtraAward(String userid, long roleid, int privilege)
/*      */   {
/*  748 */     SPrivilegeAwardCfg privilegeAwardCfg = SPrivilegeAwardCfg.get(privilege);
/*  749 */     if (privilegeAwardCfg == null)
/*      */     {
/*  751 */       return false;
/*      */     }
/*      */     
/*  754 */     if (privilegeAwardCfg.sign_extra_award_num <= 0)
/*      */     {
/*  756 */       return true;
/*      */     }
/*      */     
/*  759 */     TLogArg tLogArg = new TLogArg(LogReason.GRC_PRIVILEGE_SIGN_EXTRA_AWARD_ADD, privilege);
/*  760 */     if (!awardGift(userid, roleid, privilegeAwardCfg.sign_extra_award_type, privilegeAwardCfg.sign_extra_award_num, tLogArg))
/*      */     {
/*  762 */       return false;
/*      */     }
/*      */     
/*  765 */     SNotifyPrivilegeAwardTip notifyPrivilegeAwardTip = new SNotifyPrivilegeAwardTip();
/*  766 */     notifyPrivilegeAwardTip.award_type = 1;
/*  767 */     notifyPrivilegeAwardTip.privilege_type = privilege;
/*  768 */     OnlineManager.getInstance().send(roleid, notifyPrivilegeAwardTip);
/*      */     
/*  770 */     return true;
/*      */   }
/*      */   
/*      */   static boolean addSignExtraAward(String userid, long roleid)
/*      */   {
/*  775 */     int qqVipPrivilege = getQQVipPrivilege(userid);
/*  776 */     if (qqVipPrivilege > 0)
/*      */     {
/*  778 */       if (!addSignExtraAward(userid, roleid, qqVipPrivilege))
/*      */       {
/*  780 */         GameServer.logger().error(String.format("[grc]GrcManager.addSignExtraAward@add sign extra award failed|userid=%s|roleid=%d|qq_vip_privilege=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(qqVipPrivilege) }));
/*      */         
/*      */ 
/*      */ 
/*  784 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  788 */     int loginPrivilege = getLoginPrivilege(userid, false);
/*  789 */     if (loginPrivilege > 0)
/*      */     {
/*  791 */       if (!addSignExtraAward(userid, roleid, loginPrivilege))
/*      */       {
/*  793 */         GameServer.logger().error(String.format("[grc]GrcManager.addSignExtraAward@add sign extra award failed|userid=%s|roleid=%d|login_privilege=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(loginPrivilege) }));
/*      */         
/*      */ 
/*      */ 
/*  797 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  801 */     return true;
/*      */   }
/*      */   
/*      */   static void uninstallPrivilegeBuff(String userid, long roleid, SPrivilegeAwardCfg privilegeAwardCfg)
/*      */   {
/*  806 */     if (privilegeAwardCfg == null)
/*      */     {
/*  808 */       return;
/*      */     }
/*      */     
/*  811 */     int buffId = privilegeAwardCfg.daily_team_instance_award_buff_cfg_id;
/*  812 */     if (buffId > 0)
/*      */     {
/*  814 */       BuffInterface.uninstallBuf(roleid, buffId);
/*      */     }
/*      */   }
/*      */   
/*      */   static void uninstallPrivilegeBuff(String userid, long roleid)
/*      */   {
/*  820 */     int qqVipPrivilege = getQQVipPrivilege(userid);
/*  821 */     if (qqVipPrivilege > 0)
/*      */     {
/*  823 */       SPrivilegeAwardCfg privilegeAwardCfg = SPrivilegeAwardCfg.get(qqVipPrivilege);
/*  824 */       uninstallPrivilegeBuff(userid, roleid, privilegeAwardCfg);
/*      */     }
/*      */     
/*      */ 
/*  828 */     int loginPrivilege = getLoginPrivilege(userid, false, true);
/*  829 */     if (loginPrivilege > 0)
/*      */     {
/*  831 */       SPrivilegeAwardCfg privilegeAwardCfg = SPrivilegeAwardCfg.get(loginPrivilege);
/*  832 */       uninstallPrivilegeBuff(userid, roleid, privilegeAwardCfg);
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean resetTopRole(String userid)
/*      */   {
/*  838 */     xbean.User xUser = xtable.User.get(userid);
/*  839 */     if (xUser == null)
/*      */     {
/*  841 */       return false;
/*      */     }
/*  843 */     xUser.setMax_fighting_capacity_roleid(0L);
/*      */     
/*  845 */     return true;
/*      */   }
/*      */   
/*      */   static Long getMaxFightingCapacityRoleId(String userid)
/*      */   {
/*  850 */     return xtable.User.selectMax_fighting_capacity_roleid(userid);
/*      */   }
/*      */   
/*      */   static boolean fillRoleInfo(Role role, GrcRoleInfo grcRole) throws UnsupportedEncodingException
/*      */   {
/*  855 */     long roleid = role.getId();
/*  856 */     grcRole.roleid = roleid;
/*  857 */     grcRole.rolename.setString(role.getName(), "UTF-8");
/*  858 */     grcRole.level = role.getLevel();
/*  859 */     grcRole.gender = ((byte)role.getGender());
/*  860 */     grcRole.occupation = role.getOccupationId();
/*  861 */     grcRole.avatarid = AvatarInterface.getCurrentAvatar(roleid);
/*  862 */     grcRole.avatar_frameid = AvatarFrameInterface.getCurrentAvatarFrameId(roleid, false);
/*  863 */     grcRole.fighting_capacity = role.getFightValue();
/*  864 */     grcRole.platform = ((byte)Onlines.getInstance().findPlatid(role.getUserId()));
/*  865 */     grcRole.zoneid = CommonUtils.getZoneId(role.getUserId());
/*  866 */     return true;
/*      */   }
/*      */   
/*      */   static boolean updateGrcInfo(long roleId) throws UnsupportedEncodingException
/*      */   {
/*  871 */     Role role = RoleInterface.getRole(roleId, false);
/*  872 */     if (role == null)
/*      */     {
/*  874 */       return false;
/*      */     }
/*      */     
/*  877 */     String userId = role.getUserId();
/*  878 */     Long maxFightingCapacityRoleId = getMaxFightingCapacityRoleId(userId);
/*  879 */     if ((maxFightingCapacityRoleId == null) || (maxFightingCapacityRoleId.longValue() == 0L))
/*      */     {
/*  881 */       return false;
/*      */     }
/*      */     
/*  884 */     if (roleId != maxFightingCapacityRoleId.longValue())
/*      */     {
/*  886 */       return false;
/*      */     }
/*      */     
/*  889 */     GrcUploadRoleInfoArg arg = new GrcUploadRoleInfoArg();
/*  890 */     arg.account.setString(userId, "UTF-8");
/*  891 */     if (!fillRoleInfo(role, arg.roleinfo))
/*      */     {
/*  893 */       return false;
/*      */     }
/*      */     
/*  896 */     GrcUploadRoleInfo rpc = new GrcUploadRoleInfo(arg);
/*  897 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void syncFriendList(String userid, int pageIndex, int friendTotalCount, Collection<GrcUserInfo> friends)
/*      */     throws UnsupportedEncodingException
/*      */   {
/*  903 */     SSyncGrcGetFriendList core = new SSyncGrcGetFriendList();
/*  904 */     core.page_index = pageIndex;
/*  905 */     core.total_friend_count = friendTotalCount;
/*  906 */     RecallFriendBackGame xRecallFriendBackGame = xtable.User.selectRecall_friend_back_game(userid);
/*  907 */     for (GrcUserInfo grcUserInfo : friends)
/*      */     {
/*  909 */       GrcFriendInfo grcFriendInfo = new GrcFriendInfo();
/*  910 */       grcFriendInfo.openid = grcUserInfo.openid;
/*  911 */       grcFriendInfo.nickname = grcUserInfo.nickname;
/*  912 */       grcFriendInfo.figure_url = grcUserInfo.figure_url;
/*  913 */       grcFriendInfo.roleid = grcUserInfo.roleinfo.roleid;
/*  914 */       grcFriendInfo.rolename = grcUserInfo.roleinfo.rolename;
/*  915 */       grcFriendInfo.level = grcUserInfo.roleinfo.level;
/*  916 */       grcFriendInfo.gender = grcUserInfo.roleinfo.gender;
/*  917 */       grcFriendInfo.occupation = grcUserInfo.roleinfo.occupation;
/*  918 */       grcFriendInfo.avatarid = grcUserInfo.roleinfo.avatarid;
/*  919 */       grcFriendInfo.avatar_frameid = grcUserInfo.roleinfo.avatar_frameid;
/*  920 */       grcFriendInfo.fighting_capacity = grcUserInfo.roleinfo.fighting_capacity;
/*  921 */       grcFriendInfo.zoneid = grcUserInfo.roleinfo.zoneid;
/*  922 */       grcFriendInfo.login_privilege = grcUserInfo.login_privilege;
/*  923 */       for (grc.QQVipInfo grcQQVipInfo : grcUserInfo.qq_vip_infos.values())
/*      */       {
/*  925 */         mzm.gsp.grc.QQVipInfo qqVipInfo = new mzm.gsp.grc.QQVipInfo();
/*  926 */         qqVipInfo.vip_flag = grcQQVipInfo.vip_flag;
/*  927 */         qqVipInfo.is_vip = grcQQVipInfo.is_vip;
/*  928 */         qqVipInfo.is_year = grcQQVipInfo.is_year;
/*  929 */         qqVipInfo.is_luxury = grcQQVipInfo.is_luxury;
/*  930 */         qqVipInfo.level = grcQQVipInfo.level;
/*  931 */         grcFriendInfo.qq_vip_infos.put(Integer.valueOf(qqVipInfo.vip_flag), qqVipInfo);
/*      */       }
/*      */       
/*  934 */       if (GameServerInfoManager.isValidZone(grcFriendInfo.zoneid))
/*      */       {
/*  936 */         grcFriendInfo.recall_state = RecallFriendManager.getRecallFriendState(xRecallFriendBackGame, grcFriendInfo.roleid);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  941 */         grcFriendInfo.recall_state = 0;
/*      */       }
/*      */       
/*  944 */       core.friends.add(grcFriendInfo);
/*      */     }
/*      */     
/*  947 */     OnlineManager.getInstance().send(userid, core);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void saveGrcFriendRoleList(String userId, long roleId, Collection<GrcUserInfo> friends)
/*      */   {
/*  955 */     if (!OpenInterface.getOpenStatus(497))
/*  956 */       return;
/*  957 */     UserGrcFriendInfo xUserGrcFriendInfo = User2grc_friend.get(userId);
/*  958 */     if (xUserGrcFriendInfo == null)
/*      */     {
/*  960 */       xUserGrcFriendInfo = Pod.newUserGrcFriendInfo();
/*  961 */       User2grc_friend.add(userId, xUserGrcFriendInfo);
/*      */     }
/*  963 */     for (GrcUserInfo friendInfo : friends)
/*      */     {
/*  965 */       long friendRoleId = friendInfo.roleinfo.roleid;
/*  966 */       int zoneId = friendInfo.roleinfo.zoneid;
/*  967 */       if (!xUserGrcFriendInfo.getZone2ids().containsKey(Integer.valueOf(zoneId)))
/*  968 */         xUserGrcFriendInfo.getZone2ids().put(Integer.valueOf(zoneId), Pod.newRoleGrcFriendInfo());
/*  969 */       ((RoleGrcFriendInfo)xUserGrcFriendInfo.getZone2ids().get(Integer.valueOf(zoneId))).getIds().add(Long.valueOf(friendRoleId));
/*      */     }
/*      */     
/*  972 */     NoneRealTimeTaskManager.getInstance().addTask(new POnSaveGrcFriendRoleList(roleId));
/*      */   }
/*      */   
/*      */   static void syncSendGiftList(String userid, Collection<grc.GrcUserSendGiftInfo> userSendGiftInfos)
/*      */   {
/*  977 */     SSyncGrcSendGiftList core = new SSyncGrcSendGiftList();
/*  978 */     for (grc.GrcUserSendGiftInfo grcUserSendGiftInfo : userSendGiftInfos)
/*      */     {
/*  980 */       mzm.gsp.grc.GrcUserSendGiftInfo userSendGiftInfo = new mzm.gsp.grc.GrcUserSendGiftInfo();
/*  981 */       userSendGiftInfo.gift_type = grcUserSendGiftInfo.gift_type;
/*  982 */       for (grc.GrcSendGiftInfo grcSendGiftInfo : grcUserSendGiftInfo.today_send_gift_infos)
/*      */       {
/*  984 */         mzm.gsp.grc.GrcSendGiftInfo sendGiftInfo = new mzm.gsp.grc.GrcSendGiftInfo();
/*  985 */         sendGiftInfo.to = grcSendGiftInfo.to_openid;
/*  986 */         userSendGiftInfo.today_send_gift_infos.add(sendGiftInfo);
/*      */       }
/*  988 */       core.user_send_gift_infos.add(userSendGiftInfo);
/*      */     }
/*  990 */     OnlineManager.getInstance().send(userid, core);
/*      */   }
/*      */   
/*      */ 
/*      */   static void syncReceiveGiftList(String userid, int pageIndex, int totalCount, Collection<grc.GrcUserReceiveGiftTimesInfo> userReceiveGiftTimesInfos, Collection<grc.GrcReceiveGiftInfo> receiveGiftInfos)
/*      */     throws UnsupportedEncodingException
/*      */   {
/*  997 */     SSyncGrcReceiveGiftList core = new SSyncGrcReceiveGiftList();
/*  998 */     core.total_count = totalCount;
/*  999 */     core.page_index = pageIndex;
/* 1000 */     for (grc.GrcUserReceiveGiftTimesInfo grcUserReceiveGiftTimesInfo : userReceiveGiftTimesInfos)
/*      */     {
/* 1002 */       mzm.gsp.grc.GrcUserReceiveGiftTimesInfo timesInfo = new mzm.gsp.grc.GrcUserReceiveGiftTimesInfo();
/* 1003 */       timesInfo.gift_type = grcUserReceiveGiftTimesInfo.gift_type;
/* 1004 */       timesInfo.today_receive_times = grcUserReceiveGiftTimesInfo.today_receive_times;
/* 1005 */       core.user_receive_gift_times_infos.add(timesInfo);
/*      */     }
/* 1007 */     for (grc.GrcReceiveGiftInfo grcUserReceiveGiftInfo : receiveGiftInfos)
/*      */     {
/* 1009 */       mzm.gsp.grc.GrcReceiveGiftInfo receiveGiftInfo = new mzm.gsp.grc.GrcReceiveGiftInfo();
/* 1010 */       receiveGiftInfo.gift_type = grcUserReceiveGiftInfo.gift_type;
/* 1011 */       receiveGiftInfo.serialid = grcUserReceiveGiftInfo.serialid;
/* 1012 */       receiveGiftInfo.from = grcUserReceiveGiftInfo.from_openid;
/* 1013 */       receiveGiftInfo.from_nickname = grcUserReceiveGiftInfo.from_nickname;
/* 1014 */       receiveGiftInfo.from_figure_url = grcUserReceiveGiftInfo.from_figure_url;
/* 1015 */       receiveGiftInfo.count = grcUserReceiveGiftInfo.gift_count;
/* 1016 */       receiveGiftInfo.timestamp = grcUserReceiveGiftInfo.timestamp;
/* 1017 */       core.receive_gift_infos.add(receiveGiftInfo);
/*      */     }
/* 1019 */     OnlineManager.getInstance().send(userid, core);
/*      */   }
/*      */   
/*      */   static void syncGrcGiftTypeOnOff(String userid, Collection<GrcUserReceiveGiftMetaInfo> userReceiveGiftTimesInfos)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 1025 */     if (userReceiveGiftTimesInfos.size() == 0)
/*      */     {
/* 1027 */       return;
/*      */     }
/*      */     
/* 1030 */     SSyncGrcGiftTypeOnOff core = new SSyncGrcGiftTypeOnOff();
/* 1031 */     for (GrcUserReceiveGiftMetaInfo grcUserReceiveGiftMetaInfo : userReceiveGiftTimesInfos)
/*      */     {
/* 1033 */       core.gift_type_onoff_map.put(Integer.valueOf(grcUserReceiveGiftMetaInfo.gift_type), Integer.valueOf(grcUserReceiveGiftMetaInfo.onoff));
/*      */     }
/*      */     
/* 1036 */     OnlineManager.getInstance().send(userid, core);
/*      */   }
/*      */   
/*      */   static boolean sendGrcInfoOnLogin(String userid, long roleid) throws UnsupportedEncodingException
/*      */   {
/* 1041 */     String appid = Onlines.getInstance().findGameAppid(userid);
/* 1042 */     if (appid == null)
/*      */     {
/* 1044 */       GameServer.logger().error(String.format("[grc]GrcManager.sendGrcInfoOnLogin@appid null|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*      */       
/* 1046 */       return false;
/*      */     }
/* 1048 */     AppInfo appInfo = OnlineInfoArgs.getInstance().getAppInfo(appid);
/* 1049 */     if (appInfo == null)
/*      */     {
/* 1051 */       GameServer.logger().error(String.format("[grc]GrcManager.sendGrcInfoOnLogin@app info is null|userid=%s|roleid=%d|appid=%s", new Object[] { userid, Long.valueOf(roleid), appid }));
/*      */       
/*      */ 
/* 1054 */       return false;
/*      */     }
/* 1056 */     String accessToken = Onlines.getInstance().findOpenKey(userid);
/* 1057 */     if ((accessToken == null) || (accessToken.isEmpty()))
/*      */     {
/* 1059 */       GameServer.logger().error(String.format("[grc]GrcManager.sendGrcInfoOnLogin@access token is null or is empty|userid=%s|roleid=%d|appid=%s", new Object[] { userid, Long.valueOf(roleid), appid }));
/*      */       
/*      */ 
/*      */ 
/* 1063 */       return false;
/*      */     }
/*      */     
/* 1066 */     Role role = RoleInterface.getRole(roleid, false);
/* 1067 */     if (role == null)
/*      */     {
/* 1069 */       return false;
/*      */     }
/*      */     
/* 1072 */     GrcUserLoginArg arg = new GrcUserLoginArg();
/* 1073 */     arg.appid.setString(appInfo.getAppId(), "UTF-8");
/* 1074 */     arg.appkey.setString(appInfo.getAppKey(), "UTF-8");
/* 1075 */     arg.account.setString(userid, "UTF-8");
/* 1076 */     arg.access_token.setString(accessToken, "UTF-8");
/* 1077 */     arg.loginip = Onlines.getInstance().findip(userid);
/* 1078 */     arg.login_privilege = getLoginPrivilege(userid, false);
/* 1079 */     if (!fillRoleInfo(role, arg.roleinfo))
/*      */     {
/* 1081 */       return false;
/*      */     }
/*      */     
/* 1084 */     GrcUserLogin rpc = new GrcUserLogin(arg);
/* 1085 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void updateGrcFriendsCount(String userid, int friendsTotalCount)
/*      */   {
/* 1090 */     xbean.User xUser = xtable.User.get(userid);
/* 1091 */     if (xUser == null)
/*      */     {
/* 1093 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1097 */     if (friendsTotalCount > 1)
/*      */     {
/* 1099 */       xUser.setGrc_friends_count(friendsTotalCount - 1);
/*      */     }
/*      */     else
/*      */     {
/* 1103 */       xUser.setGrc_friends_count(friendsTotalCount);
/*      */     }
/*      */   }
/*      */   
/*      */   static void updateUserProfileInfo(String userid, List<GrcUserProfileInfo> userProfileInfo)
/*      */   {
/* 1109 */     if ((userProfileInfo == null) || (userProfileInfo.isEmpty()))
/*      */     {
/* 1111 */       return;
/*      */     }
/*      */     
/* 1114 */     xbean.User xUser = xtable.User.get(userid);
/* 1115 */     if (xUser == null)
/*      */     {
/* 1117 */       return;
/*      */     }
/*      */     
/* 1120 */     GrcUserProfileInfo profileInfo = (GrcUserProfileInfo)userProfileInfo.get(0);
/* 1121 */     if ((profileInfo != null) && (profileInfo.figure_url != null))
/*      */     {
/* 1123 */       xUser.setFigure_url(profileInfo.figure_url.getString("UTF-8"));
/* 1124 */       xUser.setNick_name(profileInfo.nickname.getString("UTF-8"));
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean onGrcUserLoginResponse(GrcUserLoginArg arg, GrcUserLoginRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1132 */       String userid = arg.account.getString("UTF-8");
/* 1133 */       long roleid = arg.roleinfo.roleid;
/*      */       
/* 1135 */       syncFriendList(userid, 1, res.friend_total_count, res.friends);
/*      */       
/* 1137 */       saveGrcFriendRoleList(userid, roleid, res.friends);
/*      */       
/* 1139 */       updateGrcFriendsCount(userid, res.friend_total_count);
/*      */       
/* 1141 */       updateUserProfileInfo(userid, res.profile_info);
/*      */       
/* 1143 */       syncSendGiftList(userid, res.user_send_gift_infos);
/*      */       
/* 1145 */       syncReceiveGiftList(userid, 1, res.receive_gift_total_count, res.user_receive_gift_times_infos, res.receive_gift_infos);
/*      */       
/*      */ 
/* 1148 */       syncGrcGiftTypeOnOff(userid, res.user_receive_gift_meta_infos);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1153 */       syncUserBackInfo(userid, roleid, res.back_info);
/*      */       
/* 1155 */       syncRecallLossInfo(userid, roleid, res.recall_friends, res.recall_info);
/*      */       
/* 1157 */       syncBindRewardInfo(userid, roleid, res.bind_reward_info);
/*      */       
/* 1159 */       syncBindVitalityInfo(userid, roleid, res.profile_info, res.role_vitality_info, res.recall_bind_info, res.back_bind_info);
/*      */       
/*      */ 
/* 1162 */       new POnRoleLoginForRecall(userid, roleid).execute();
/*      */       
/*      */ 
/* 1165 */       if (!isOpenPrivilege(roleid))
/*      */       {
/* 1167 */         return true;
/*      */       }
/*      */       
/* 1170 */       updateQQVipInfos(userid, roleid, res.qq_vip_infos);
/*      */       
/* 1172 */       return tryAwardForQQVipPrivilege(userid, roleid);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 1177 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void onGrcUserLoginTimeout(GrcUserLoginArg arg, GrcUserLoginRes res) {}
/*      */   
/*      */ 
/*      */ 
/*      */   static QQVipLostObserver clearQQVipLostObserver(String userid)
/*      */   {
/* 1188 */     QQVipObservers xQQVipObservers = User2qqvipobservers.get(userid);
/* 1189 */     if (xQQVipObservers != null)
/*      */     {
/* 1191 */       Iterator<Map.Entry<Integer, QQVipLostObserver>> itr = xQQVipObservers.getObservers().entrySet().iterator();
/* 1192 */       while (itr.hasNext())
/*      */       {
/* 1194 */         ((QQVipLostObserver)((Map.Entry)itr.next()).getValue()).stopTimer();
/* 1195 */         itr.remove();
/*      */       }
/*      */     }
/* 1198 */     User2qqvipobservers.remove(userid);
/*      */     
/* 1200 */     return null;
/*      */   }
/*      */   
/*      */   static QQVipLostObserver removeQQVipLostObserver(String userid, int vipFlag)
/*      */   {
/* 1205 */     QQVipObservers xQQVipObservers = User2qqvipobservers.get(userid);
/* 1206 */     if (xQQVipObservers != null)
/*      */     {
/* 1208 */       return (QQVipLostObserver)xQQVipObservers.getObservers().remove(Integer.valueOf(vipFlag));
/*      */     }
/*      */     
/* 1211 */     return null;
/*      */   }
/*      */   
/*      */   static void onQQVipLost(String userid, long roleid, int vipFlag)
/*      */   {
/* 1216 */     int privilegeType = 0;
/* 1217 */     if (vipFlag == 1)
/*      */     {
/* 1219 */       privilegeType = 4;
/*      */     }
/* 1221 */     else if (vipFlag == 16)
/*      */     {
/* 1223 */       privilegeType = 5;
/*      */     }
/*      */     else
/*      */     {
/* 1227 */       return;
/*      */     }
/*      */     
/* 1230 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1231 */     UserQQVipInfo xUserQQVipInfo = User2qqvipinfo.get(userid);
/* 1232 */     if (xUserQQVipInfo != null)
/*      */     {
/* 1234 */       xbean.QQVipInfo xQQVipInfo = (xbean.QQVipInfo)xUserQQVipInfo.getVipinfos().get(Integer.valueOf(vipFlag));
/* 1235 */       if ((xQQVipInfo != null) && (xQQVipInfo.getIs_vip()))
/*      */       {
/* 1237 */         long expireTimestamp = xQQVipInfo.getExpire_timestamp() * 1000L;
/* 1238 */         if (curTime > expireTimestamp)
/*      */         {
/* 1240 */           return;
/*      */         }
/*      */       }
/* 1243 */       xUserQQVipInfo.getVipinfos().remove(Integer.valueOf(vipFlag));
/*      */     }
/*      */     
/* 1246 */     SPrivilegeAwardCfg privilegeAwardCfg = SPrivilegeAwardCfg.get(privilegeType);
/* 1247 */     uninstallPrivilegeBuff(userid, roleid, privilegeAwardCfg);
/*      */     
/* 1249 */     removeQQVipLostObserver(userid, vipFlag);
/*      */   }
/*      */   
/*      */   static boolean getFriendList(long roleId, int pageIndex)
/*      */   {
/*      */     try
/*      */     {
/* 1256 */       String userId = RoleInterface.getUserId(roleId);
/* 1257 */       if (userId == null)
/*      */       {
/* 1259 */         return false;
/*      */       }
/*      */       
/* 1262 */       GrcGetFriendsListArg arg = new GrcGetFriendsListArg();
/* 1263 */       arg.account.setString(userId, "UTF-8");
/* 1264 */       arg.page_index = (pageIndex - 1);
/*      */       
/* 1266 */       GrcGetFriendsList rpc = new GrcGetFriendsList(arg);
/* 1267 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1274 */     return false;
/*      */   }
/*      */   
/*      */   static void onGetFriendListResponse(GrcGetFriendsListArg arg, GrcGetFriendsListRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1281 */       String userid = arg.account.getString("UTF-8");
/*      */       
/* 1283 */       syncFriendList(userid, res.page_index, res.friend_total_count, res.friends);
/*      */       
/* 1285 */       updateGrcFriendsCount(userid, res.friend_total_count);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetFriendListTimeout(GrcGetFriendsListArg arg, GrcGetFriendsListRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1297 */       GameServer.logger().error(String.format("[grc]GrcManager.onGetFriendListTimeout@get friend list timeout|retcode=%d|account=%s|page_index=%d", new Object[] { Integer.valueOf(res.retcode), arg.account.getString("UTF-8"), Integer.valueOf(arg.page_index) }));
/*      */     }
/*      */     catch (Exception e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getReceiveGiftList(long roleId, int pageIndex)
/*      */   {
/*      */     try
/*      */     {
/* 1312 */       String userid = RoleInterface.getUserId(roleId);
/* 1313 */       if (userid == null)
/*      */       {
/* 1315 */         return false;
/*      */       }
/*      */       
/* 1318 */       GrcGetUserReceiveGiftInfoListArg arg = new GrcGetUserReceiveGiftInfoListArg();
/* 1319 */       arg.account.setString(userid, "UTF-8");
/* 1320 */       arg.page_index = (pageIndex - 1);
/*      */       
/* 1322 */       GrcGetUserReceiveGiftInfoList rpc = new GrcGetUserReceiveGiftInfoList(arg);
/* 1323 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1330 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetReceiveGiftListResponse(GrcGetUserReceiveGiftInfoListArg arg, GrcGetUserReceiveGiftInfoListRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1338 */       String userid = arg.account.getString("UTF-8");
/* 1339 */       syncReceiveGiftList(userid, res.page_index, res.receive_gift_total_count, res.user_receive_gift_times_infos, res.receive_gift_infos);
/*      */       
/*      */ 
/* 1342 */       syncGrcGiftTypeOnOff(userid, res.user_receive_gift_meta_infos);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetReceiveGiftListTimeout(GrcGetUserReceiveGiftInfoListArg arg, GrcGetUserReceiveGiftInfoListRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1355 */       GameServer.logger().error(String.format("[grc]GrcManager.onGetReceiveGiftListTimeout@get receive gift list timeout|retcode=%d|account=%s|page_index=%d", new Object[] { Integer.valueOf(res.retcode), arg.account.getString("UTF-8"), Integer.valueOf(arg.page_index) }));
/*      */     }
/*      */     catch (Exception e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMaxSendCount(int giftType)
/*      */   {
/* 1368 */     SGrcGiftCfg cfg = SGrcGiftCfg.get(giftType);
/* 1369 */     if (cfg == null)
/*      */     {
/* 1371 */       return 0;
/*      */     }
/* 1373 */     return cfg.send_max_times_everyday;
/*      */   }
/*      */   
/*      */   static boolean sendGift(int giftType, long from, Octets to) throws UnsupportedEncodingException
/*      */   {
/* 1378 */     GrcGiftCfg cfg = GrcGiftCfg.get(SGrcConsts.getInstance().OPEN_GIFT_CFG_ID);
/* 1379 */     int openGiftType = cfg.gift_type;
/* 1380 */     if ((giftType > 4) || (giftType < 0) || (giftType != openGiftType))
/*      */     {
/* 1382 */       SGrcSendGiftResp resp = new SGrcSendGiftResp();
/* 1383 */       resp.retcode = 110;
/* 1384 */       resp.gift_type = giftType;
/* 1385 */       resp.to = to;
/* 1386 */       OnlineManager.getInstance().sendAtOnce(from, resp);
/* 1387 */       return false;
/*      */     }
/*      */     
/* 1390 */     int maxCount = getMaxSendCount(giftType);
/* 1391 */     if (maxCount < 1)
/*      */     {
/* 1393 */       SGrcSendGiftResp resp = new SGrcSendGiftResp();
/* 1394 */       resp.retcode = 113;
/* 1395 */       resp.gift_type = giftType;
/* 1396 */       resp.to = to;
/* 1397 */       OnlineManager.getInstance().sendAtOnce(from, resp);
/* 1398 */       return false;
/*      */     }
/*      */     
/* 1401 */     String userid = RoleInterface.getUserId(from);
/* 1402 */     String toOpenid = to.getString("UTF-8");
/* 1403 */     if (toOpenid.equals(CommonUtils.getOpenId(userid)))
/*      */     {
/* 1405 */       SGrcSendGiftResp resp = new SGrcSendGiftResp();
/* 1406 */       resp.retcode = 111;
/* 1407 */       resp.gift_type = giftType;
/* 1408 */       resp.to = to;
/* 1409 */       OnlineManager.getInstance().sendAtOnce(from, resp);
/* 1410 */       return false;
/*      */     }
/*      */     
/* 1413 */     GrcSendGiftArg arg = new GrcSendGiftArg();
/* 1414 */     arg.gift_type = giftType;
/* 1415 */     arg.from_account.setString(userid, "UTF-8");
/* 1416 */     arg.to_openid = to;
/* 1417 */     arg.gift_count = cfg.gift_count;
/* 1418 */     arg.max_send_times_everyday = maxCount;
/* 1419 */     GrcSendGift rpc = new GrcSendGift(arg);
/* 1420 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onSendGiftResponse(GrcSendGiftArg arg, GrcSendGiftRes res)
/*      */   {
/* 1425 */     SGrcSendGiftResp resp = new SGrcSendGiftResp();
/* 1426 */     resp.retcode = res.retcode;
/* 1427 */     resp.gift_type = arg.gift_type;
/* 1428 */     resp.to = arg.to_openid;
/* 1429 */     OnlineManager.getInstance().send(arg.from_account.getString("UTF-8"), resp);
/*      */   }
/*      */   
/*      */   static void onSendGiftTimeout(GrcSendGiftArg arg, GrcSendGiftRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1436 */       GameServer.logger().error(String.format("[grc]GrcManager.onSendGiftTimeout@send gift timeout|retcode=%d|from_account=%s|to_openid=%s|gift_type=%d|gift_count=%d|max_send_times_everyday=%d", new Object[] { Integer.valueOf(res.retcode), arg.from_account.getString("UTF-8"), arg.to_openid.getString("UTF-8"), Integer.valueOf(arg.gift_type), Integer.valueOf(arg.gift_count), Integer.valueOf(arg.max_send_times_everyday) }));
/*      */     }
/*      */     catch (Exception e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMaxRceiveCount(int giftType)
/*      */   {
/* 1450 */     SGrcGiftCfg cfg = SGrcGiftCfg.get(giftType);
/* 1451 */     if (cfg == null)
/*      */     {
/* 1453 */       return 0;
/*      */     }
/* 1455 */     return cfg.receive_max_times_everyday;
/*      */   }
/*      */   
/*      */   static boolean receiveGift(long to, int giftType, long serialid) throws UnsupportedEncodingException
/*      */   {
/* 1460 */     if ((giftType > 4) || (giftType < 0))
/*      */     {
/* 1462 */       SGrcReceiveGiftResp resp = new SGrcReceiveGiftResp();
/* 1463 */       resp.retcode = 110;
/* 1464 */       resp.gift_type = giftType;
/* 1465 */       resp.serialid = serialid;
/* 1466 */       OnlineManager.getInstance().sendAtOnce(to, resp);
/* 1467 */       return false;
/*      */     }
/*      */     
/* 1470 */     int maxCount = getMaxRceiveCount(giftType);
/* 1471 */     if (maxCount < 1)
/*      */     {
/* 1473 */       SGrcReceiveGiftResp resp = new SGrcReceiveGiftResp();
/* 1474 */       resp.retcode = 115;
/* 1475 */       resp.gift_type = giftType;
/* 1476 */       resp.serialid = serialid;
/* 1477 */       OnlineManager.getInstance().sendAtOnce(to, resp);
/* 1478 */       return false;
/*      */     }
/*      */     
/* 1481 */     String userid = RoleInterface.getUserId(to);
/* 1482 */     GrcReceiveGiftArg arg = new GrcReceiveGiftArg();
/* 1483 */     arg.to_account.setString(userid, "UTF-8");
/* 1484 */     arg.to_roleid = to;
/* 1485 */     arg.gift_type = giftType;
/* 1486 */     arg.serialid = serialid;
/* 1487 */     arg.max_receive_times_everyday = maxCount;
/*      */     
/* 1489 */     GrcReceiveGift rpc = new GrcReceiveGift(arg);
/* 1490 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static boolean awardGift(String userid, long roleid, int giftType, long giftCount, TLogArg arg)
/*      */   {
/* 1495 */     switch (giftType)
/*      */     {
/*      */     case 1: 
/* 1498 */       return RoleInterface.addVigor(roleid, (int)giftCount, arg) == VigorOperResult.SUCCESS;
/*      */     
/*      */     case 3: 
/* 1501 */       return RoleInterface.addGold(roleid, giftCount, arg).isSucceed();
/*      */     
/*      */     case 4: 
/* 1504 */       return RoleInterface.addSilver(roleid, giftCount, arg).isSucceed();
/*      */     
/*      */     case 2: 
/* 1507 */       return GuajiInterface.addGetingpoolDoublePoint(roleid, (int)giftCount, arg);
/*      */     }
/*      */     
/* 1510 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean onReceiveGiftResponse(GrcReceiveGiftArg arg, GrcReceiveGiftRes res)
/*      */   {
/* 1516 */     SGrcReceiveGiftResp resp = new SGrcReceiveGiftResp();
/* 1517 */     resp.gift_type = arg.gift_type;
/* 1518 */     resp.serialid = arg.serialid;
/* 1519 */     if (res.retcode != 0)
/*      */     {
/* 1521 */       resp.retcode = res.retcode;
/* 1522 */       OnlineManager.getInstance().sendAtOnce(arg.to_roleid, resp);
/* 1523 */       return false;
/*      */     }
/*      */     
/* 1526 */     String userid = arg.to_account.getString("UTF-8");
/* 1527 */     TLogArg tLogArg = new TLogArg(LogReason.GRC_RECEIVE_GIFT_AWARD_ADD);
/* 1528 */     if (!awardGift(userid, arg.to_roleid, arg.gift_type, res.gift_count, tLogArg))
/*      */     {
/* 1530 */       resp.retcode = 300;
/* 1531 */       OnlineManager.getInstance().sendAtOnce(arg.to_roleid, resp);
/* 1532 */       return false;
/*      */     }
/*      */     
/* 1535 */     resp.retcode = res.retcode;
/* 1536 */     OnlineManager.getInstance().send(arg.to_roleid, resp);
/*      */     
/* 1538 */     return true;
/*      */   }
/*      */   
/*      */   static void onReceiveGiftTimeout(GrcReceiveGiftArg arg, GrcReceiveGiftRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1545 */       GameServer.logger().error(String.format("[grc]GrcManager.onReceiveGiftTimeout@receive gift timeout|retcode=%d|to_account=%s|to_roleid=%d|gift_type=%d|serialid=%d|max_receive_times_everyday=%d", new Object[] { Integer.valueOf(res.retcode), arg.to_account.getString("UTF-8"), Long.valueOf(arg.to_roleid), Integer.valueOf(arg.gift_type), Long.valueOf(arg.serialid), Integer.valueOf(arg.max_receive_times_everyday) }));
/*      */     }
/*      */     catch (Exception e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean receiveAllGift(long to)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 1559 */     String userid = RoleInterface.getUserId(to);
/* 1560 */     GrcReceiveAllGiftArg arg = new GrcReceiveAllGiftArg();
/* 1561 */     arg.to_account.setString(userid, "UTF-8");
/* 1562 */     arg.to_roleid = to;
/* 1563 */     for (SGrcGiftCfg cfg : SGrcGiftCfg.getAll().values())
/*      */     {
/* 1565 */       arg.gift_type_to_max_receive_times_everyday.put(Integer.valueOf(cfg.id), Integer.valueOf(cfg.receive_max_times_everyday));
/*      */     }
/* 1567 */     GrcReceiveAllGift rpc = new GrcReceiveAllGift(arg);
/* 1568 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static boolean onReceiveAllGiftResponse(GrcReceiveAllGiftArg arg, GrcReceiveAllGiftRes res)
/*      */   {
/* 1573 */     SGrcReceiveAllGiftResp resp = new SGrcReceiveAllGiftResp();
/* 1574 */     if (res.retcode != 0)
/*      */     {
/* 1576 */       resp.retcode = res.retcode;
/* 1577 */       OnlineManager.getInstance().sendAtOnce(arg.to_roleid, resp);
/* 1578 */       return false;
/*      */     }
/*      */     
/* 1581 */     String userid = arg.to_account.getString("UTF-8");
/* 1582 */     TLogArg tLogArg = new TLogArg(LogReason.GRC_RECEIVE_ALL_GIFT_AWARD_ADD);
/* 1583 */     for (grc.GrcReceivedGiftInfos grcReceivedGiftInfos : res.receive_gifts)
/*      */     {
/* 1585 */       if (!awardGift(userid, arg.to_roleid, grcReceivedGiftInfos.gift_type, grcReceivedGiftInfos.gift_count, tLogArg))
/*      */       {
/* 1587 */         resp.retcode = 300;
/* 1588 */         resp.receive_gifts.clear();
/* 1589 */         OnlineManager.getInstance().sendAtOnce(arg.to_roleid, resp);
/*      */         
/* 1591 */         return false;
/*      */       }
/*      */       
/* 1594 */       mzm.gsp.grc.GrcReceivedGiftInfos giftInfos = new mzm.gsp.grc.GrcReceivedGiftInfos();
/* 1595 */       giftInfos.gift_type = grcReceivedGiftInfos.gift_type;
/* 1596 */       giftInfos.receive_times = grcReceivedGiftInfos.receive_times;
/* 1597 */       giftInfos.serialids = grcReceivedGiftInfos.serialids;
/* 1598 */       resp.receive_gifts.add(giftInfos);
/*      */     }
/*      */     
/* 1601 */     resp.retcode = res.retcode;
/* 1602 */     OnlineManager.getInstance().send(arg.to_roleid, resp);
/*      */     
/* 1604 */     return true;
/*      */   }
/*      */   
/*      */   static boolean onReceiveAllGiftTimeout(GrcReceiveAllGiftArg arg, GrcReceiveAllGiftRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1611 */       GameServer.logger().error(String.format("[grc]GrcManager.onReceiveAllGiftTimeout@receive all gift timeout|retcode=%d|to_account=%s|to_roleid=%d", new Object[] { Integer.valueOf(res.retcode), arg.to_account.getString("UTF-8"), Long.valueOf(arg.to_roleid) }));
/*      */     }
/*      */     catch (Exception e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1621 */     return false;
/*      */   }
/*      */   
/*      */   static boolean turnOnOffGiftRcv(long roleId, int giftType, boolean onOff)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 1627 */     if ((giftType > 4) || (giftType < 0))
/*      */     {
/* 1629 */       SGrcTurnOnOffResp resp = new SGrcTurnOnOffResp();
/* 1630 */       resp.retcode = 110;
/* 1631 */       resp.gift_type = giftType;
/* 1632 */       resp.onoff = ((byte)(onOff ? 1 : 0));
/* 1633 */       OnlineManager.getInstance().sendAtOnce(roleId, resp);
/* 1634 */       return false;
/*      */     }
/*      */     
/* 1637 */     String userid = RoleInterface.getUserId(roleId);
/* 1638 */     String openId = CommonUtils.getOpenId(userid);
/* 1639 */     String channel = CommonUtils.getPlatName(userid);
/*      */     
/* 1641 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1642 */     arg.openid.setString(openId, "UTF-8");
/* 1643 */     arg.channel.setString(channel, "UTF-8");
/* 1644 */     arg.qtype = 1;
/* 1645 */     arg.data_direction = 1;
/* 1646 */     OctetsStream os = new OctetsStream();
/* 1647 */     os.marshal(roleId);
/* 1648 */     os.marshal(giftType);
/* 1649 */     os.marshal((byte)(onOff ? 1 : 0));
/* 1650 */     os.marshal(0);
/* 1651 */     os.marshal(0);
/* 1652 */     arg.info.replace(os);
/*      */     
/* 1654 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1655 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static boolean checkQQVipPayInfo(long roleId, int vipFlag, byte isNew)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 1661 */     if ((vipFlag != 1) && (vipFlag != 16))
/*      */     {
/* 1663 */       SReportQQVipPayInfoResp resp = new SReportQQVipPayInfoResp();
/* 1664 */       resp.retcode = 110;
/* 1665 */       resp.vip_flag = vipFlag;
/* 1666 */       resp.is_new = isNew;
/* 1667 */       OnlineManager.getInstance().sendAtOnce(roleId, resp);
/* 1668 */       return false;
/*      */     }
/*      */     
/* 1671 */     String userid = RoleInterface.getUserId(roleId);
/* 1672 */     String openId = CommonUtils.getOpenId(userid);
/* 1673 */     String channel = CommonUtils.getPlatName(userid);
/*      */     
/* 1675 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1676 */     arg.openid.setString(openId, "UTF-8");
/* 1677 */     arg.channel.setString(channel, "UTF-8");
/* 1678 */     arg.qtype = 2;
/* 1679 */     arg.data_direction = 1;
/* 1680 */     OctetsStream os = new OctetsStream();
/* 1681 */     os.marshal(roleId);
/* 1682 */     os.marshal(vipFlag);
/* 1683 */     os.marshal(isNew);
/* 1684 */     os.marshal(0);
/* 1685 */     os.marshal(0);
/* 1686 */     arg.info.replace(os);
/*      */     
/* 1688 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1689 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static boolean reportScoreBatch(String userid, long roleid, String params)
/*      */   {
/*      */     try
/*      */     {
/* 1696 */       String openId = CommonUtils.getOpenId(userid);
/* 1697 */       String channel = CommonUtils.getPlatName(userid);
/*      */       
/* 1699 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1700 */       arg.openid.setString(openId, "UTF-8");
/* 1701 */       arg.channel.setString(channel, "UTF-8");
/* 1702 */       arg.qtype = 3;
/* 1703 */       arg.data_direction = 1;
/* 1704 */       OctetsStream os = new OctetsStream();
/* 1705 */       os.marshal(roleid);
/* 1706 */       os.marshal(Octets.wrap(params, "UTF-8"));
/* 1707 */       os.marshal(0);
/* 1708 */       os.marshal(0);
/* 1709 */       arg.info.replace(os);
/*      */       
/* 1711 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1712 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 1717 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean reportRoles(String userid)
/*      */   {
/*      */     try
/*      */     {
/* 1725 */       String roles = RoleInterface.getRoleList(userid);
/* 1726 */       if (roles == null)
/*      */       {
/* 1728 */         return false;
/*      */       }
/*      */       
/* 1731 */       String openId = CommonUtils.getOpenId(userid);
/* 1732 */       String channel = CommonUtils.getPlatName(userid);
/* 1733 */       int zoneid = CommonUtils.getZoneId(userid);
/* 1734 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1735 */       arg.openid.setString(openId, "UTF-8");
/* 1736 */       arg.channel.setString(channel, "UTF-8");
/* 1737 */       arg.qtype = 4;
/* 1738 */       arg.data_direction = 1;
/* 1739 */       OctetsStream os = new OctetsStream();
/* 1740 */       os.marshal(zoneid);
/* 1741 */       os.marshal(Octets.wrap(roles, "UTF-8"));
/* 1742 */       os.marshal(0);
/* 1743 */       os.marshal(0);
/* 1744 */       arg.info.replace(os);
/*      */       
/* 1746 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1747 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 1752 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean sendAntiAddictProxy(String proxyInfo, Octets context)
/*      */   {
/*      */     try
/*      */     {
/* 1760 */       DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1761 */       arg.qtype = 20;
/* 1762 */       arg.data_direction = 1;
/*      */       
/* 1764 */       OctetsStream osArgInfo = new OctetsStream();
/* 1765 */       osArgInfo.marshal(proxyInfo.getBytes("UTF-8"));
/* 1766 */       osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 1767 */       arg.info.replace(osArgInfo);
/*      */       
/* 1769 */       DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1770 */       return GDeliveryManager.getInstance().send(rpc);
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 1775 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static void onAntiAddictProxyDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1783 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 1784 */       String proxyReqInfo = new String(osArgInfo.unmarshal_bytes(), "UTF-8");
/* 1785 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 1787 */       String proxyRspInfo = res.info.size() > 0 ? res.info.getString("UTF-8") : null;
/* 1788 */       AntiAddictProxyDone event = new AntiAddictProxyDone();
/* 1789 */       TriggerEventsManger.getInstance().triggerEvent(event, new AntiAddictProxyDoneArg(retcode, proxyReqInfo, proxyRspInfo, context));
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}catch (MarshalException e) {}
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
/*      */   static boolean asyncReportFightRecord(long recordid, int dataType, Octets data, Octets context)
/*      */   {
/* 1804 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1805 */     arg.qtype = 26;
/* 1806 */     arg.data_direction = 1;
/*      */     
/* 1808 */     OctetsStream osArgInfo = new OctetsStream();
/* 1809 */     osArgInfo.marshal(recordid);
/* 1810 */     osArgInfo.marshal(dataType);
/* 1811 */     osArgInfo.marshal(data);
/* 1812 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 1813 */     arg.info.replace(osArgInfo);
/*      */     
/* 1815 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1816 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onReportFightRecordDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1824 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 1825 */       long recordid = osArgInfo.unmarshal_long();
/* 1826 */       int dataType = osArgInfo.unmarshal_int();
/* 1827 */       Octets data = osArgInfo.unmarshal_Octets();
/* 1828 */       Octets context = osArgInfo.unmarshal_Octets();
/* 1829 */       FightInterface.onReportFightRecordDone(retcode, recordid, dataType, data, context);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean asyncGetFightRecord(long recordid, int dataType, Octets context)
/*      */   {
/* 1839 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1840 */     arg.qtype = 27;
/* 1841 */     arg.data_direction = 1;
/*      */     
/* 1843 */     OctetsStream osArgInfo = new OctetsStream();
/* 1844 */     osArgInfo.marshal(recordid);
/* 1845 */     osArgInfo.marshal(dataType);
/* 1846 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 1847 */     arg.info.replace(osArgInfo);
/*      */     
/* 1849 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1850 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   public static void onGetFightRecordDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1858 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 1859 */       long recordid = osArgInfo.unmarshal_long();
/* 1860 */       int dataType = osArgInfo.unmarshal_int();
/* 1861 */       Octets context = osArgInfo.unmarshal_Octets();
/* 1862 */       FightInterface.onGetFightRecordDone(retcode, recordid, dataType, context, res.info);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean asyncCleanRankInfo(int rankType, long rankid, Octets context)
/*      */   {
/* 1872 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1873 */     arg.qtype = 48;
/* 1874 */     arg.data_direction = 1;
/*      */     
/* 1876 */     OctetsStream osArgInfo = new OctetsStream();
/* 1877 */     osArgInfo.marshal(rankType);
/* 1878 */     osArgInfo.marshal(rankid);
/* 1879 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 1880 */     arg.info.replace(osArgInfo);
/*      */     
/* 1882 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1883 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static boolean asyncRemoveRankInfo(int rankType, long rankid, long chartObjid, Octets context)
/*      */   {
/* 1888 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1889 */     arg.qtype = 49;
/* 1890 */     arg.data_direction = 1;
/*      */     
/* 1892 */     OctetsStream osArgInfo = new OctetsStream();
/* 1893 */     osArgInfo.marshal(rankType);
/* 1894 */     osArgInfo.marshal(rankid);
/* 1895 */     osArgInfo.marshal(chartObjid);
/* 1896 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 1897 */     arg.info.replace(osArgInfo);
/*      */     
/* 1899 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1900 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean asyncReportRankInfo(int rankType, long rankid, long chartObjid, double score, Octets chartObjInfo, Octets context)
/*      */   {
/* 1906 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1907 */     arg.qtype = 50;
/* 1908 */     arg.data_direction = 1;
/*      */     
/* 1910 */     OctetsStream osArgInfo = new OctetsStream();
/* 1911 */     osArgInfo.marshal(rankType);
/* 1912 */     osArgInfo.marshal(rankid);
/* 1913 */     osArgInfo.marshal(chartObjid);
/* 1914 */     osArgInfo.marshal(score);
/* 1915 */     osArgInfo.marshal(chartObjInfo == null ? Octets.EMPTY_OCTETS : chartObjInfo);
/* 1916 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 1917 */     arg.info.replace(osArgInfo);
/*      */     
/* 1919 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1920 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onCleanRankInfoDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1927 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 1928 */       int rankType = osArgInfo.unmarshal_int();
/* 1929 */       long rankid = osArgInfo.unmarshal_long();
/* 1930 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 1932 */       CrossServerInterface.onCleanRankInfoDone(retcode, rankType, rankid, context);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onRemoveRankInfoDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1944 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 1945 */       int rankType = osArgInfo.unmarshal_int();
/* 1946 */       long rankid = osArgInfo.unmarshal_long();
/* 1947 */       long chartObjid = osArgInfo.unmarshal_long();
/* 1948 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 1950 */       CrossServerInterface.onRemoveRankInfoDone(retcode, rankType, rankid, chartObjid, context);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onReportRankInfoDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 1962 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 1963 */       int rankType = osArgInfo.unmarshal_int();
/* 1964 */       long rankid = osArgInfo.unmarshal_long();
/* 1965 */       long chartObjid = osArgInfo.unmarshal_long();
/*      */       
/* 1967 */       double score = osArgInfo.unmarshal_double();
/* 1968 */       Octets chartObjInfo = osArgInfo.unmarshal_Octets();
/* 1969 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 1971 */       CrossServerInterface.onReportRankInfoDone(retcode, rankType, rankid, chartObjid, chartObjInfo, context);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean asyncGetRank(int rankType, long rankid, long chartObjid, Octets context)
/*      */   {
/* 1981 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 1982 */     arg.qtype = 51;
/* 1983 */     arg.data_direction = 1;
/*      */     
/* 1985 */     OctetsStream osArgInfo = new OctetsStream();
/* 1986 */     osArgInfo.marshal(rankType);
/* 1987 */     osArgInfo.marshal(rankid);
/* 1988 */     osArgInfo.marshal(chartObjid);
/* 1989 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 1990 */     arg.info.replace(osArgInfo);
/*      */     
/* 1992 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 1993 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onGetRankDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 2000 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 2001 */       int rankType = osArgInfo.unmarshal_int();
/* 2002 */       long rankid = osArgInfo.unmarshal_long();
/* 2003 */       long chartObjid = osArgInfo.unmarshal_long();
/* 2004 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 2006 */       int rank = 0;
/* 2007 */       if (res.info.size() > 0)
/*      */       {
/* 2009 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 2010 */         rank = osResInfo.unmarshal_int();
/*      */       }
/*      */       
/* 2013 */       CrossServerInterface.onGetRankDone(retcode, rankType, rankid, chartObjid, context, rank);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean asyncGetRankRange(int rankType, long rankid, int from, int to, Octets context)
/*      */   {
/* 2023 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2024 */     arg.qtype = 52;
/* 2025 */     arg.data_direction = 1;
/*      */     
/* 2027 */     OctetsStream osArgInfo = new OctetsStream();
/* 2028 */     osArgInfo.marshal(rankType);
/* 2029 */     osArgInfo.marshal(rankid);
/* 2030 */     osArgInfo.marshal(from);
/* 2031 */     osArgInfo.marshal(to);
/* 2032 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 2033 */     arg.info.replace(osArgInfo);
/*      */     
/* 2035 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2036 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onGetRankRangeDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 2043 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 2044 */       int rankType = osArgInfo.unmarshal_int();
/* 2045 */       long rankid = osArgInfo.unmarshal_long();
/* 2046 */       int from = osArgInfo.unmarshal_int();
/* 2047 */       int to = osArgInfo.unmarshal_int();
/* 2048 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 2050 */       int cardinality = 0;
/* 2051 */       List<byte[]> rankRangeInfos = null;
/* 2052 */       if (res.info.size() > 0)
/*      */       {
/* 2054 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 2055 */         cardinality = osResInfo.unmarshal_int();
/* 2056 */         if (cardinality > 0)
/*      */         {
/* 2058 */           rankRangeInfos = new ArrayList();
/* 2059 */           int size = osResInfo.unmarshal_int();
/* 2060 */           for (int i = size; i > 0; i--)
/*      */           {
/* 2062 */             rankRangeInfos.add(osResInfo.unmarshal_bytes());
/*      */           }
/*      */         }
/*      */       }
/* 2066 */       CrossServerInterface.onGetRankRangeDone(retcode, rankType, rankid, from, to, context, cardinality, rankRangeInfos);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reportCrossBattleOwnResult(int activityCfgid, Map<Long, Octets> result)
/*      */   {
/* 2076 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2077 */     arg.qtype = 53;
/* 2078 */     arg.data_direction = 1;
/*      */     
/* 2080 */     OctetsStream osArgInfo = new OctetsStream();
/* 2081 */     osArgInfo.marshal(activityCfgid);
/* 2082 */     osArgInfo.compact_uint32(result.size());
/* 2083 */     for (Map.Entry<Long, Octets> entry : result.entrySet())
/*      */     {
/* 2085 */       osArgInfo.marshal(((Long)entry.getKey()).longValue());
/* 2086 */       osArgInfo.marshal((Octets)entry.getValue());
/*      */     }
/* 2088 */     arg.info.replace(osArgInfo);
/*      */     
/* 2090 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2091 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onReportCrossBattleOwnResult(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 2099 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 2100 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 2101 */       CrossServerInterface.onReportCrossBattleOwnResultDone(retcode, activityCfgid);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean clearCrossBattleOwnResult(int activityCfgid, Map<Long, Octets> result)
/*      */   {
/* 2111 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2112 */     arg.qtype = 54;
/* 2113 */     arg.data_direction = 1;
/*      */     
/* 2115 */     OctetsStream osArgInfo = new OctetsStream();
/* 2116 */     osArgInfo.marshal(activityCfgid);
/* 2117 */     osArgInfo.compact_uint32(result.size());
/* 2118 */     for (Map.Entry<Long, Octets> entry : result.entrySet())
/*      */     {
/* 2120 */       osArgInfo.marshal(((Long)entry.getKey()).longValue());
/* 2121 */       osArgInfo.marshal((Octets)entry.getValue());
/*      */     }
/* 2123 */     arg.info.replace(osArgInfo);
/*      */     
/* 2125 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2126 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onClearCrossBattleOwnResult(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 2134 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 2135 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 2136 */       CrossServerInterface.onClearCrossBattleOwnResultDone(retcode, activityCfgid);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean asyncGetCorpsZone(Octets context)
/*      */   {
/* 2146 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2147 */     arg.qtype = 55;
/* 2148 */     arg.data_direction = 1;
/*      */     
/* 2150 */     OctetsStream osArgInfo = new OctetsStream();
/* 2151 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 2152 */     arg.info.replace(osArgInfo);
/*      */     
/* 2154 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2155 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onGetCorpsZoneDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 2162 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 2163 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 2165 */       int size = 0;
/* 2166 */       Map<Long, Integer> data = null;
/* 2167 */       if (res.info.size() > 0)
/*      */       {
/* 2169 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 2170 */         size = osResInfo.uncompact_uint32();
/* 2171 */         if (size > 0)
/*      */         {
/* 2173 */           data = new HashMap();
/* 2174 */           for (int i = size; i > 0; i--)
/*      */           {
/* 2176 */             long key = osResInfo.unmarshal_long();
/* 2177 */             int value = osResInfo.unmarshal_int();
/* 2178 */             data.put(Long.valueOf(key), Integer.valueOf(value));
/*      */           }
/*      */         }
/*      */       }
/* 2182 */       CrossServerInterface.onGetCorpsZoneDone(retcode, context, data);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean asyncReportCorpsPointRace(Octets context)
/*      */   {
/* 2192 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2193 */     arg.qtype = 56;
/* 2194 */     arg.data_direction = 1;
/*      */     
/* 2196 */     OctetsStream osArgInfo = new OctetsStream();
/* 2197 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 2198 */     arg.info.replace(osArgInfo);
/*      */     
/* 2200 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2201 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onReportCorpsPointRaceDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 2209 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 2210 */       Octets context = osArgInfo.unmarshal_Octets();
/* 2211 */       CrossServerInterface.onReportCorpsPointRaceDone(retcode, context);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean asyncGetZonePointRace(int activityCfgid, int zone, Octets context)
/*      */   {
/* 2221 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2222 */     arg.qtype = 57;
/* 2223 */     arg.data_direction = 1;
/*      */     
/* 2225 */     OctetsStream osArgInfo = new OctetsStream();
/* 2226 */     osArgInfo.marshal(activityCfgid);
/* 2227 */     osArgInfo.marshal(zone);
/* 2228 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 2229 */     arg.info.replace(osArgInfo);
/*      */     
/* 2231 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2232 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onGetZonePointRaceDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 2239 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 2240 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 2241 */       int zone = osArgInfo.unmarshal_int();
/* 2242 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 2244 */       int cardinality = 0;
/* 2245 */       List<CorpsPointRaceInfo> corpsPointRaceInfos = null;
/* 2246 */       if (res.info.size() > 0)
/*      */       {
/* 2248 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 2249 */         cardinality = osResInfo.unmarshal_int();
/* 2250 */         if (cardinality > 0)
/*      */         {
/* 2252 */           corpsPointRaceInfos = new ArrayList();
/* 2253 */           for (int i = 0; i < cardinality; i++)
/*      */           {
/* 2255 */             CorpsPointRaceInfo corpsPointRaceInfo = new CorpsPointRaceInfo();
/* 2256 */             corpsPointRaceInfo.unmarshal(osResInfo);
/* 2257 */             corpsPointRaceInfos.add(corpsPointRaceInfo);
/*      */           }
/*      */         }
/*      */       }
/* 2261 */       CrossServerInterface.onGetZonePointRaceDone(retcode, activityCfgid, zone, context, corpsPointRaceInfos);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean asyncRemovePointRace(int activityCfgid, int zone, int timePointCfgid, Octets context)
/*      */   {
/* 2271 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2272 */     arg.qtype = 58;
/* 2273 */     arg.data_direction = 1;
/*      */     
/* 2275 */     OctetsStream osArgInfo = new OctetsStream();
/* 2276 */     osArgInfo.marshal(activityCfgid);
/* 2277 */     osArgInfo.marshal(zone);
/* 2278 */     osArgInfo.marshal(timePointCfgid);
/* 2279 */     osArgInfo.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 2280 */     arg.info.replace(osArgInfo);
/*      */     
/* 2282 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2283 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onRemovePointRaceDone(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 2290 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 2291 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 2292 */       int zone = osArgInfo.unmarshal_int();
/* 2293 */       int timePointCfgid = osArgInfo.unmarshal_int();
/* 2294 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 2296 */       CrossServerInterface.onRemovePointRaceDone(retcode, activityCfgid, zone, timePointCfgid, context);
/*      */     }
/*      */     catch (MarshalException e) {}
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getCrossBattleKnockOutOwnServerInfo(long roleId, int activityCfgId, int knockOutType, int fightStage, int maxFightZoneId, int maxFightIndexId, List<Integer> zoneIdList)
/*      */   {
/* 2324 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2325 */     arg.qtype = 105;
/* 2326 */     arg.data_direction = 1;
/*      */     
/* 2328 */     OctetsStream os = new OctetsStream();
/* 2329 */     os.marshal(roleId);
/* 2330 */     os.marshal(activityCfgId);
/* 2331 */     os.marshal(knockOutType);
/* 2332 */     os.marshal(fightStage);
/* 2333 */     os.marshal(maxFightZoneId);
/* 2334 */     os.marshal(maxFightIndexId);
/*      */     
/* 2336 */     os.marshal(zoneIdList.size());
/* 2337 */     for (Iterator i$ = zoneIdList.iterator(); i$.hasNext();) { int zoneId = ((Integer)i$.next()).intValue();
/*      */       
/* 2339 */       os.marshal(zoneId);
/*      */     }
/*      */     
/* 2342 */     arg.info.replace(os);
/*      */     
/* 2344 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*      */     
/* 2346 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetCrossBattleKnockOutOwnServerInfo(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 2355 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     
/*      */     try
/*      */     {
/* 2359 */       long roleId = osArgInfo.unmarshal_long();
/*      */       
/* 2361 */       int activityCfgId = osArgInfo.unmarshal_int();
/*      */       
/* 2363 */       int knockOutType = osArgInfo.unmarshal_int();
/*      */       
/* 2365 */       int fightStage = osArgInfo.unmarshal_int();
/*      */       
/*      */ 
/* 2368 */       int maxFightZoneId = osArgInfo.unmarshal_int();
/*      */       
/*      */ 
/* 2371 */       int maxFightIndexId = osArgInfo.unmarshal_int();
/*      */       
/* 2373 */       OctetsStream osResInfo = new OctetsStream(res.info);
/* 2374 */       String knockOutOwnServerJsonStr = osResInfo.size() > 0 ? osResInfo.unmarshal_String("UTF-8") : null;
/*      */       
/* 2376 */       CrossBattleKnockoutInterface.initKnockOutOwnServerData(retcode, roleId, activityCfgId, knockOutType, fightStage, knockOutOwnServerJsonStr);
/*      */ 
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 2381 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getCrossBattleKnockOutInfo(int activityCfgId, int knockOutType, int fightZoneId, int nowFightStage, int maxTeamNum, int maxStage, int fightTimesEveryRound, Octets octets, int repeatTimes)
/*      */   {
/* 2392 */     long canGetKnockOutInfoTime = CrossBattleKnockoutInterface.getKnockOutCanGetInfoTime(activityCfgId, knockOutType);
/* 2393 */     if (DateTimeUtils.getCurrTimeInMillis() < canGetKnockOutInfoTime)
/*      */     {
/* 2395 */       StringBuilder stringBuilder = new StringBuilder();
/* 2396 */       stringBuilder.append("[grc_knockout]GrcManager.getCorssBattleKnockOutInfo");
/* 2397 */       stringBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 2398 */       stringBuilder.append("|knock_out_type=").append(knockOutType);
/* 2399 */       stringBuilder.append("fight_zone_id=").append(fightZoneId);
/* 2400 */       stringBuilder.append("|now_fight_stage=").append(nowFightStage);
/* 2401 */       stringBuilder.append("|max_team_num=").append(maxTeamNum);
/* 2402 */       stringBuilder.append("|max_stage=").append(maxStage);
/* 2403 */       stringBuilder.append("|fight_times_every_round=").append(fightTimesEveryRound);
/*      */       
/* 2405 */       GameServer.logger().error(stringBuilder.toString());
/* 2406 */       return false;
/*      */     }
/* 2408 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2409 */     arg.qtype = 100;
/* 2410 */     arg.data_direction = 1;
/*      */     
/* 2412 */     OctetsStream os = new OctetsStream();
/* 2413 */     os.marshal(activityCfgId);
/* 2414 */     os.marshal(knockOutType);
/* 2415 */     os.marshal(fightZoneId);
/* 2416 */     os.marshal(nowFightStage);
/* 2417 */     os.marshal(maxTeamNum);
/* 2418 */     os.marshal(maxStage);
/* 2419 */     os.marshal(fightTimesEveryRound);
/*      */     
/* 2421 */     os.marshal(octets);
/* 2422 */     os.marshal(repeatTimes);
/* 2423 */     arg.info.replace(os);
/*      */     
/* 2425 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*      */     
/* 2427 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetCrossBattleKnockOut(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 2436 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     try
/*      */     {
/* 2439 */       OctetsStream osResInfo = new OctetsStream(res.info);
/* 2440 */       int activityCfgId = osArgInfo.unmarshal_int();
/*      */       
/* 2442 */       final int knockOutType = osArgInfo.unmarshal_int();
/*      */       
/* 2444 */       final int fightZoneId = osArgInfo.unmarshal_int();
/*      */       
/* 2446 */       final int nowFightStage = osArgInfo.unmarshal_int();
/*      */       
/* 2448 */       final int maxTeamNum = osArgInfo.unmarshal_int();
/*      */       
/* 2450 */       final int maxStage = osArgInfo.unmarshal_int();
/*      */       
/* 2452 */       final int fightTimesEveryRound = osArgInfo.unmarshal_int();
/*      */       
/* 2454 */       final Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/*      */ 
/* 2457 */       final int repeatTimes = osArgInfo.unmarshal_int();
/*      */       
/* 2459 */       StringBuilder sBuilder = new StringBuilder();
/* 2460 */       sBuilder.append("[crossbattle_knockout]GrcManager.onGetCrossBattleKnockOut@get cross battle knock out response");
/* 2461 */       sBuilder.append("|ret=").append(retcode);
/* 2462 */       sBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 2463 */       sBuilder.append("|knock_out_type=").append(knockOutType);
/* 2464 */       sBuilder.append("|fight_zone_id=").append(fightZoneId);
/* 2465 */       sBuilder.append("|now_fight_stage=").append(nowFightStage);
/* 2466 */       sBuilder.append("|max_fight_team=").append(maxTeamNum);
/* 2467 */       sBuilder.append("|max_stage=").append(maxStage);
/* 2468 */       sBuilder.append("|fight_times_every_round=").append(fightTimesEveryRound);
/* 2469 */       sBuilder.append("|repeat_times=").append(repeatTimes);
/*      */       
/* 2471 */       if (res.retcode == 500)
/*      */       {
/* 2473 */         initKnockOutFirstRoundData(activityCfgId, knockOutType, fightZoneId, nowFightStage, maxTeamNum, maxStage, fightTimesEveryRound, context);
/*      */         
/*      */ 
/* 2476 */         GameServer.logger().info(sBuilder.toString());
/* 2477 */         return;
/*      */       }
/* 2479 */       if (res.retcode != 0)
/*      */       {
/* 2481 */         if (repeatTimes < 10)
/*      */         {
/* 2483 */           Xdb.executor().schedule(new Runnable()
/*      */           {
/*      */ 
/*      */ 
/*      */             public void run() {
/* 2488 */               GrcManager.getCrossBattleKnockOutInfo(this.val$activityCfgId, knockOutType, fightZoneId, nowFightStage, maxTeamNum, maxStage, fightTimesEveryRound, context, repeatTimes + 1); } }, (repeatTimes + 1) * 1000L, TimeUnit.MILLISECONDS);
/*      */           
/*      */ 
/*      */ 
/* 2492 */           return;
/*      */         }
/*      */       }
/*      */       
/* 2496 */       String knockOutJsonStr = osResInfo.size() > 0 ? osResInfo.unmarshal_String("UTF-8") : null;
/* 2497 */       sBuilder.append("|knock_out_str=").append(knockOutJsonStr);
/* 2498 */       GameServer.logger().info(sBuilder.toString());
/*      */       
/* 2500 */       CrossBattleKnockoutInterface.initKnockOutData(retcode, activityCfgId, knockOutType, fightZoneId, knockOutJsonStr, context);
/*      */ 
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/*      */ 
/* 2506 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean initKnockOutFirstRoundData(int activityCfgId, int knockOutType, int fightZoneId, int nowFightStage, int maxTeamNum, int maxStage, int fightTimesEveryRound, Octets octets)
/*      */   {
/* 2514 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2515 */     arg.qtype = 108;
/* 2516 */     arg.data_direction = 1;
/*      */     
/* 2518 */     OctetsStream os = new OctetsStream();
/* 2519 */     os.marshal(activityCfgId);
/* 2520 */     os.marshal(knockOutType);
/* 2521 */     os.marshal(fightZoneId);
/* 2522 */     os.marshal(nowFightStage);
/* 2523 */     os.marshal(maxTeamNum);
/* 2524 */     os.marshal(maxStage);
/* 2525 */     os.marshal(fightTimesEveryRound);
/*      */     
/* 2527 */     boolean isNeedForceInit = CrossBattleKnockoutInterface.isNeedForceInit(activityCfgId, knockOutType);
/* 2528 */     os.marshal(isNeedForceInit);
/* 2529 */     switch (knockOutType)
/*      */     {
/*      */     case 1: 
/* 2532 */       List<Pair<Integer, Integer>> matchList = CrossBattleKnockoutInterface.getSelectinInitFightRelationList(activityCfgId);
/* 2533 */       if (matchList == null)
/*      */       {
/* 2535 */         return false;
/*      */       }
/* 2537 */       os.marshal(matchList.size());
/* 2538 */       for (Pair<Integer, Integer> pair : matchList)
/*      */       {
/* 2540 */         os.marshal(((Integer)pair.first).intValue());
/* 2541 */         os.marshal(((Integer)pair.second).intValue());
/*      */       }
/* 2543 */       break;
/*      */     
/*      */     case 2: 
/* 2546 */       List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> finalMatchCfgList = CrossBattleKnockoutInterface.getFinalInitFightRelationList(activityCfgId);
/* 2547 */       if (finalMatchCfgList == null)
/*      */       {
/* 2549 */         return false;
/*      */       }
/* 2551 */       os.marshal(finalMatchCfgList.size());
/* 2552 */       int selectionMaxStage = CrossBattleKnockoutInterface.getKnockOutStageSize(activityCfgId, 1);
/* 2553 */       os.marshal(selectionMaxStage);
/*      */       
/* 2555 */       for (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> pair : finalMatchCfgList)
/*      */       {
/* 2557 */         Pair<Integer, Integer> aCorpsInfo = (Pair)pair.first;
/* 2558 */         os.marshal(((Integer)aCorpsInfo.first).intValue());
/* 2559 */         os.marshal(((Integer)aCorpsInfo.second).intValue());
/*      */         
/* 2561 */         Pair<Integer, Integer> bCorpsInfo = (Pair)pair.second;
/* 2562 */         os.marshal(((Integer)bCorpsInfo.first).intValue());
/* 2563 */         os.marshal(((Integer)bCorpsInfo.second).intValue());
/*      */       }
/* 2565 */       break;
/*      */     }
/*      */     
/*      */     
/*      */ 
/*      */ 
/* 2571 */     os.marshal(octets);
/* 2572 */     arg.info.replace(os);
/*      */     
/* 2574 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*      */     
/* 2576 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onInitKnockOutFirstRoundData(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 2582 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     try
/*      */     {
/* 2585 */       int activityCfgId = osArgInfo.unmarshal_int();
/*      */       
/* 2587 */       int knockOutType = osArgInfo.unmarshal_int();
/*      */       
/* 2589 */       int fightZoneId = osArgInfo.unmarshal_int();
/*      */       
/*      */ 
/* 2592 */       int nowFightStage = osArgInfo.unmarshal_int();
/*      */       
/* 2594 */       int maxTeamNum = osArgInfo.unmarshal_int();
/*      */       
/* 2596 */       int maxStage = osArgInfo.unmarshal_int();
/*      */       
/* 2598 */       int fightTimesEveryRound = osArgInfo.unmarshal_int();
/*      */       
/*      */ 
/* 2601 */       boolean isNeedForceInit = osArgInfo.unmarshal_boolean();
/* 2602 */       if (knockOutType == 1)
/*      */       {
/* 2604 */         int size = osArgInfo.unmarshal_int();
/* 2605 */         for (int index = 1; index <= size; index++)
/*      */         {
/* 2607 */           osArgInfo.unmarshal_int();
/* 2608 */           osArgInfo.unmarshal_int();
/*      */         }
/*      */       }
/* 2611 */       else if (knockOutType == 2)
/*      */       {
/* 2613 */         int size = osArgInfo.unmarshal_int();
/*      */         
/* 2615 */         int selectionMaxStage = osArgInfo.unmarshal_int();
/*      */         
/* 2617 */         for (int index = 1; index <= size; index++)
/*      */         {
/* 2619 */           osArgInfo.unmarshal_int();
/* 2620 */           osArgInfo.unmarshal_int();
/* 2621 */           osArgInfo.unmarshal_int();
/* 2622 */           osArgInfo.unmarshal_int();
/*      */         }
/*      */       }
/*      */       
/* 2626 */       Octets context = osArgInfo.unmarshal_Octets();
/* 2627 */       if (res.retcode == 0)
/*      */       {
/* 2629 */         getCrossBattleKnockOutInfo(activityCfgId, knockOutType, fightZoneId, nowFightStage, maxTeamNum, maxStage, fightTimesEveryRound, context, 0);
/*      */       }
/*      */       
/*      */ 
/* 2633 */       StringBuilder sBuilder = new StringBuilder();
/* 2634 */       sBuilder.append("[crossbattle_knockout]GrcManager.onInitKnockOutFirstRoundData");
/* 2635 */       sBuilder.append("|retcode=").append(retcode);
/* 2636 */       sBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 2637 */       sBuilder.append("|knock_out_type=").append(knockOutType);
/* 2638 */       sBuilder.append("|fight_zone_id=").append(fightZoneId);
/* 2639 */       sBuilder.append("|now_fight_stage=").append(nowFightStage);
/* 2640 */       sBuilder.append("|max_team_num=").append(maxTeamNum);
/* 2641 */       sBuilder.append("|max_stage=").append(maxStage);
/* 2642 */       sBuilder.append("|fight_times_every_round=").append(fightTimesEveryRound);
/*      */       
/* 2644 */       GameServer.logger().info(sBuilder.toString());
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 2648 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reportCrossBattleKnockOutFightResult(int activityCfgId, int knockOutType, int fightZoneId, int stage, long ownCorpsId, String ownCorpsName, long opponentCorpsId, String opponentCorpsName, int fightIndexId, int maxFightStage, int fightTimesEveryRound, String result, int repeatTimes)
/*      */   {
/* 2661 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2662 */     arg.qtype = 101;
/* 2663 */     arg.data_direction = 1;
/*      */     
/* 2665 */     OctetsStream os = new OctetsStream();
/* 2666 */     os.marshal(activityCfgId);
/* 2667 */     os.marshal(knockOutType);
/* 2668 */     os.marshal(fightZoneId);
/* 2669 */     os.marshal(stage);
/* 2670 */     os.marshal(ownCorpsId);
/* 2671 */     os.marshal(ownCorpsName, "UTF-8");
/* 2672 */     os.marshal(opponentCorpsId);
/* 2673 */     os.marshal(opponentCorpsName, "UTF-8");
/* 2674 */     os.marshal(fightIndexId);
/* 2675 */     os.marshal(maxFightStage);
/* 2676 */     os.marshal(fightTimesEveryRound);
/* 2677 */     os.marshal(result);
/* 2678 */     os.marshal(repeatTimes);
/*      */     
/* 2680 */     arg.info.replace(os);
/*      */     
/* 2682 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2683 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onReportKnockOutFightResult(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 2694 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     try
/*      */     {
/* 2697 */       int activityCfgId = osArgInfo.unmarshal_int();
/*      */       
/* 2699 */       final int knockOutType = osArgInfo.unmarshal_int();
/*      */       
/* 2701 */       final int fightZoneId = osArgInfo.unmarshal_int();
/*      */       
/* 2703 */       final int nowFightStage = osArgInfo.unmarshal_int();
/*      */       
/* 2705 */       final long ownCorpsId = osArgInfo.unmarshal_long();
/*      */       
/* 2707 */       String ownCorpsName = osArgInfo.unmarshal_String("UTF-8");
/* 2708 */       final long opponentCorpsId = osArgInfo.unmarshal_long();
/*      */       
/* 2710 */       final String opponentCorpsName = osArgInfo.unmarshal_String("UTF-8");
/*      */       
/* 2712 */       int fightIndexId = osArgInfo.unmarshal_int();
/*      */       
/* 2714 */       final int maxFightStage = osArgInfo.unmarshal_int();
/*      */       
/* 2716 */       final int fightTimesEveryRound = osArgInfo.unmarshal_int();
/* 2717 */       final String fightResult = osArgInfo.unmarshal_String();
/* 2718 */       final int repeatTimes = osArgInfo.unmarshal_int();
/* 2719 */       if (retcode != 0)
/*      */       {
/* 2721 */         if (repeatTimes < 10)
/*      */         {
/* 2723 */           Xdb.executor().schedule(new Runnable()
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             public void run() {
/* 2729 */               GrcManager.reportCrossBattleKnockOutFightResult(this.val$activityCfgId, knockOutType, fightZoneId, nowFightStage, ownCorpsId, opponentCorpsId, opponentCorpsName, maxFightStage, fightTimesEveryRound, fightResult, repeatTimes, this.val$fightResult, this.val$repeatTimes + 1); } }, (repeatTimes + 1) * 1000L, TimeUnit.MILLISECONDS);
/*      */ 
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 2738 */         CrossBattleKnockoutInterface.onReportCrossBattleFightResult(activityCfgId, knockOutType, fightZoneId, ownCorpsId, ownCorpsName, opponentCorpsId, opponentCorpsName, nowFightStage, fightIndexId, fightResult);
/*      */       }
/*      */       
/*      */ 
/* 2742 */       StringBuilder sbBuilder = new StringBuilder();
/* 2743 */       sbBuilder.append("[crossbattle_knockout]GrcManager.onReportKnockOutFightResult");
/* 2744 */       sbBuilder.append("|retcode=").append(retcode);
/* 2745 */       sbBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 2746 */       sbBuilder.append("|knock_out_type=").append(knockOutType);
/* 2747 */       sbBuilder.append("|fight_zone_id=").append(fightZoneId);
/* 2748 */       sbBuilder.append("|now_fight_stage=").append(nowFightStage);
/* 2749 */       sbBuilder.append("|own_corps_id=").append(ownCorpsId);
/* 2750 */       sbBuilder.append("|own_corps_name=").append(ownCorpsName);
/* 2751 */       sbBuilder.append("|opponent_corps_id=").append(opponentCorpsId);
/* 2752 */       sbBuilder.append("|opponent_corps_name=").append(opponentCorpsName);
/* 2753 */       sbBuilder.append("|fight_index_id=").append(fightIndexId);
/* 2754 */       sbBuilder.append("|max_fight_stage=").append(maxFightStage);
/* 2755 */       sbBuilder.append("|fight_times_every_round=").append(fightTimesEveryRound);
/* 2756 */       sbBuilder.append("|fight_result=").append(fightResult);
/* 2757 */       sbBuilder.append("|repeat_times=").append(repeatTimes);
/*      */       
/* 2759 */       GameServer.logger().info(sbBuilder.toString());
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 2763 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reportCrossBattleKnockOutFightBegin(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int fightIndexId, long fightRecordId, int repeatTimes)
/*      */   {
/* 2773 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2774 */     arg.qtype = 102;
/* 2775 */     arg.data_direction = 1;
/*      */     
/* 2777 */     OctetsStream os = new OctetsStream();
/* 2778 */     os.marshal(activityCfgId);
/* 2779 */     os.marshal(knockOutType);
/* 2780 */     os.marshal(fightZoneId);
/* 2781 */     os.marshal(fightStage);
/* 2782 */     os.marshal(fightIndexId);
/* 2783 */     os.marshal(fightRecordId);
/* 2784 */     os.marshal(repeatTimes);
/*      */     
/* 2786 */     arg.info.replace(os);
/*      */     
/* 2788 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2789 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onReportKnockOutFightBeginRes(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 2798 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     
/*      */     try
/*      */     {
/* 2802 */       int activityCfgId = osArgInfo.unmarshal_int();
/* 2803 */       final int knockOutType = osArgInfo.unmarshal_int();
/* 2804 */       final int fightZoneId = osArgInfo.unmarshal_int();
/* 2805 */       final int fightStage = osArgInfo.unmarshal_int();
/* 2806 */       final int fightIndexId = osArgInfo.unmarshal_int();
/* 2807 */       final int fightRecordId = osArgInfo.unmarshal_int();
/* 2808 */       final int repeatTimes = osArgInfo.unmarshal_int();
/* 2809 */       if (retcode != 0)
/*      */       {
/* 2811 */         if (repeatTimes < 10)
/*      */         {
/* 2813 */           Xdb.executor().schedule(new Runnable()
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             public void run() {
/* 2819 */               GrcManager.reportCrossBattleKnockOutFightBegin(this.val$activityCfgId, knockOutType, fightZoneId, fightStage, fightIndexId, fightRecordId, repeatTimes + 1); } }, (repeatTimes + 1) * 1000L, TimeUnit.MILLISECONDS);
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 2826 */       StringBuilder sb = new StringBuilder();
/* 2827 */       sb.append("[crossbattle_knockout]GrcManager.onReportKnockOutFightBeginRes");
/* 2828 */       sb.append("|ret_code=").append(retcode);
/* 2829 */       sb.append("|activity_cfg_id=").append(activityCfgId);
/* 2830 */       sb.append("|knock_out_type=").append(knockOutType);
/* 2831 */       sb.append("|fight_zone_id=").append(fightZoneId);
/* 2832 */       sb.append("|fight_stage=").append(fightStage);
/* 2833 */       sb.append("|fight_index_id=").append(fightIndexId);
/* 2834 */       sb.append("|fight_record_id=").append(fightRecordId);
/* 2835 */       sb.append("|repeat_times=").append(repeatTimes);
/* 2836 */       GameServer.logger().info(sb.toString());
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 2840 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reportCrossBattleCorpsInfo(int activityCfgId, long corpsId, String declaration, int createTime)
/*      */   {
/* 2851 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2852 */     arg.qtype = 111;
/* 2853 */     arg.data_direction = 1;
/*      */     
/* 2855 */     OctetsStream os = new OctetsStream();
/* 2856 */     os.marshal(activityCfgId);
/* 2857 */     os.marshal(corpsId);
/* 2858 */     os.marshal(declaration, "UTF-8");
/* 2859 */     os.marshal(createTime);
/*      */     
/* 2861 */     arg.info.replace(os);
/*      */     
/* 2863 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2864 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reportCrossBattleCorpsRoleInfo(int activityCfgId, long corpsId, long roleId, String roleName, int occupationId, int roleLevel, int avatarId, int multifightvalue, int mfrank, int gender, int joinTime, int duty, int lastLogOffTime)
/*      */   {
/* 2874 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2875 */     arg.qtype = 110;
/* 2876 */     arg.data_direction = 1;
/*      */     
/* 2878 */     OctetsStream os = new OctetsStream();
/* 2879 */     os.marshal(activityCfgId);
/* 2880 */     os.marshal(corpsId);
/* 2881 */     os.marshal(roleId);
/* 2882 */     os.marshal(roleName, "UTF-8");
/* 2883 */     os.marshal(occupationId);
/* 2884 */     os.marshal(roleLevel);
/* 2885 */     os.marshal(avatarId);
/* 2886 */     os.marshal(multifightvalue);
/* 2887 */     os.marshal(mfrank);
/* 2888 */     os.marshal(gender);
/* 2889 */     os.marshal(joinTime);
/* 2890 */     os.marshal(duty);
/* 2891 */     os.marshal(lastLogOffTime);
/*      */     
/* 2893 */     arg.info.replace(os);
/*      */     
/* 2895 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2896 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static boolean getCrossBattleCorpsInfo(int activityCfgId, long corpsId, long roleId)
/*      */   {
/* 2901 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2902 */     arg.qtype = 112;
/* 2903 */     arg.data_direction = 1;
/*      */     
/* 2905 */     OctetsStream os = new OctetsStream();
/* 2906 */     os.marshal(activityCfgId);
/* 2907 */     os.marshal(corpsId);
/* 2908 */     os.marshal(roleId);
/*      */     
/* 2910 */     arg.info.replace(os);
/*      */     
/* 2912 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2913 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetCrossBattleCorpsInfo(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 2923 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     try
/*      */     {
/* 2926 */       OctetsStream osResInfo = new OctetsStream(res.info);
/*      */       
/* 2928 */       int activityCfgId = osArgInfo.unmarshal_int();
/*      */       
/* 2930 */       long corpsId = osArgInfo.unmarshal_long();
/*      */       
/* 2932 */       long roleId = osArgInfo.unmarshal_long();
/*      */       
/* 2934 */       if (res.retcode != 0)
/*      */       {
/* 2936 */         CrossBattleKnockoutInterface.sendGetCorpsInfoFail(roleId);
/* 2937 */         return;
/*      */       }
/* 2939 */       String corpsInfoJson = osResInfo.size() > 0 ? osResInfo.unmarshal_String("UTF-8") : null;
/*      */       
/* 2941 */       CrossBattleKnockoutInterface.sendGetCorpInfo(roleId, corpsId, corpsInfoJson);
/*      */ 
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 2946 */       e.printStackTrace();
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/* 2950 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getNotifyKnockOutCorpsIdList(int activityCfgId, int knockOutType, int fightStage, int maxFightIndexId, int maxFightZoneId, List<Integer> zoneIdList, int repeatTimes, Octets octets)
/*      */   {
/* 2963 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 2964 */     arg.qtype = 103;
/* 2965 */     arg.data_direction = 1;
/*      */     
/* 2967 */     OctetsStream os = new OctetsStream();
/* 2968 */     os.marshal(activityCfgId);
/* 2969 */     os.marshal(knockOutType);
/* 2970 */     os.marshal(fightStage);
/* 2971 */     os.marshal(maxFightIndexId);
/* 2972 */     os.marshal(maxFightZoneId);
/* 2973 */     os.marshal(zoneIdList.size());
/* 2974 */     for (Integer zoneId : zoneIdList)
/*      */     {
/* 2976 */       os.marshal(zoneId.intValue());
/*      */     }
/* 2978 */     os.marshal(repeatTimes);
/* 2979 */     os.marshal(octets);
/* 2980 */     arg.info.replace(os);
/*      */     
/* 2982 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 2983 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetNotifyKnockOutCorpsIdList(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 2992 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     
/*      */     try
/*      */     {
/* 2996 */       int activityCfgId = osArgInfo.unmarshal_int();
/*      */       
/* 2998 */       final int knockOutType = osArgInfo.unmarshal_int();
/*      */       
/* 3000 */       final int fightStage = osArgInfo.unmarshal_int();
/*      */       
/* 3002 */       final int maxFightZoneId = osArgInfo.unmarshal_int();
/*      */       
/* 3004 */       final int maxFightIndexId = osArgInfo.unmarshal_int();
/*      */       
/* 3006 */       int zoneIdSize = osArgInfo.unmarshal_int();
/* 3007 */       final List<Integer> zoneIdList = new ArrayList();
/* 3008 */       for (int index = 1; index <= zoneIdSize; index++)
/*      */       {
/* 3010 */         int zoneId = osArgInfo.unmarshal_int();
/* 3011 */         zoneIdList.add(Integer.valueOf(zoneId));
/*      */       }
/*      */       
/* 3014 */       final int repeatTimes = osArgInfo.unmarshal_int();
/* 3015 */       final Octets octets = osArgInfo.unmarshal_Octets();
/*      */       
/* 3017 */       if (retcode != 0)
/*      */       {
/* 3019 */         if (repeatTimes < 10)
/*      */         {
/* 3021 */           Xdb.executor().schedule(new Runnable()
/*      */           {
/*      */ 
/*      */ 
/*      */             public void run() {
/* 3026 */               GrcManager.getNotifyKnockOutCorpsIdList(this.val$activityCfgId, knockOutType, fightStage, maxFightIndexId, maxFightZoneId, zoneIdList, repeatTimes + 1, octets); } }, (repeatTimes + 1) * 10000L, TimeUnit.MILLISECONDS);
/*      */         }
/*      */         
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/* 3034 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 3035 */         Set<Long> corpsIdSet = new HashSet();
/* 3036 */         int size = osResInfo.unmarshal_int();
/* 3037 */         for (int index = 1; index <= size; index++)
/*      */         {
/* 3039 */           corpsIdSet.add(Long.valueOf(osResInfo.unmarshal_long()));
/*      */         }
/*      */         
/* 3042 */         CrossBattleKnockoutInterface.onGetFightStageCorpsIdList(retcode, activityCfgId, knockOutType, fightStage, corpsIdSet, octets);
/*      */       }
/*      */       
/*      */ 
/* 3046 */       StringBuilder sb = new StringBuilder();
/* 3047 */       sb.append("[crossbattle_knockout]GrcManager.onGetNotifyKnockOutCorpsIdList");
/* 3048 */       sb.append("|activity_cfg_id=").append(activityCfgId);
/* 3049 */       sb.append("|knock_out_type=").append(knockOutType);
/* 3050 */       sb.append("|fight_stage=").append(fightStage);
/* 3051 */       sb.append("|max_fight_zone_id=").append(maxFightZoneId);
/* 3052 */       sb.append("|max_fight_index_id=").append(maxFightIndexId);
/* 3053 */       sb.append("|zone_id_list=").append(zoneIdList.toString());
/* 3054 */       sb.append("|repeat_times=").append(repeatTimes);
/* 3055 */       sb.append("|ret_code=").append(retcode);
/*      */       
/* 3057 */       GameServer.logger().info(sb.toString());
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 3061 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getGetKnockOutQualificationCorpsIdList(int activityCfgId, int knockOutType, int fightStage, int maxFightIndexId, int maxFightZoneId, int maxSelectionTeamSize, int maxSelectionStage, List<Integer> zoneIdList, int repeatTimes, long roleId, long corpsId)
/*      */   {
/* 3072 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3073 */     arg.qtype = 113;
/* 3074 */     arg.data_direction = 1;
/*      */     
/* 3076 */     OctetsStream os = new OctetsStream();
/* 3077 */     os.marshal(activityCfgId);
/* 3078 */     os.marshal(knockOutType);
/* 3079 */     os.marshal(fightStage);
/* 3080 */     os.marshal(maxFightZoneId);
/* 3081 */     os.marshal(maxFightIndexId);
/* 3082 */     os.marshal(maxSelectionTeamSize);
/* 3083 */     os.marshal(maxSelectionStage);
/* 3084 */     os.marshal(zoneIdList.size());
/* 3085 */     for (Integer zoneId : zoneIdList)
/*      */     {
/* 3087 */       os.marshal(zoneId.intValue());
/*      */     }
/* 3089 */     os.marshal(repeatTimes);
/* 3090 */     os.marshal(roleId);
/* 3091 */     os.marshal(corpsId);
/* 3092 */     arg.info.replace(os);
/*      */     
/* 3094 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 3095 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetKnockOutQualificationCorpsIdList(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 3104 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     
/*      */     try
/*      */     {
/* 3108 */       int activityCfgId = osArgInfo.unmarshal_int();
/*      */       
/* 3110 */       final int knockOutType = osArgInfo.unmarshal_int();
/*      */       
/* 3112 */       final int fightStage = osArgInfo.unmarshal_int();
/*      */       
/* 3114 */       final int maxFightZoneId = osArgInfo.unmarshal_int();
/*      */       
/* 3116 */       final int maxFightIndexId = osArgInfo.unmarshal_int();
/*      */       
/* 3118 */       final int selectionTeamSize = osArgInfo.unmarshal_int();
/*      */       
/* 3120 */       final int maxSelectionStage = osArgInfo.unmarshal_int();
/*      */       
/*      */ 
/* 3123 */       int zoneIdSize = osArgInfo.unmarshal_int();
/* 3124 */       final List<Integer> zoneIdList = new ArrayList();
/* 3125 */       for (int index = 1; index <= zoneIdSize; index++)
/*      */       {
/* 3127 */         int zoneId = osArgInfo.unmarshal_int();
/* 3128 */         zoneIdList.add(Integer.valueOf(zoneId));
/*      */       }
/*      */       
/* 3131 */       final int repeatTimes = osArgInfo.unmarshal_int();
/*      */       
/* 3133 */       final long roleId = osArgInfo.unmarshal_long();
/* 3134 */       long corpsId = osArgInfo.unmarshal_long();
/*      */       
/* 3136 */       if (retcode != 0)
/*      */       {
/* 3138 */         if (repeatTimes < 10)
/*      */         {
/* 3140 */           Xdb.executor().schedule(new Runnable()
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             public void run() {
/* 3146 */               GrcManager.getGetKnockOutQualificationCorpsIdList(this.val$activityCfgId, knockOutType, fightStage, maxFightIndexId, maxFightZoneId, selectionTeamSize, maxSelectionStage, zoneIdList, repeatTimes + 1, roleId, this.val$corpsId); } }, (repeatTimes + 1) * 1000L, TimeUnit.MILLISECONDS);
/*      */ 
/*      */         }
/*      */         
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/* 3155 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 3156 */         Set<Long> corpsIdSet = new HashSet();
/* 3157 */         int size = osResInfo.unmarshal_int();
/* 3158 */         for (int index = 1; index <= size; index++)
/*      */         {
/* 3160 */           corpsIdSet.add(Long.valueOf(osResInfo.unmarshal_long()));
/*      */         }
/*      */         
/* 3163 */         CrossBattleKnockoutInterface.notifyKnockOutQualificationCorpsIdSet(roleId, corpsId, knockOutType, corpsIdSet);
/*      */       }
/*      */       
/* 3166 */       StringBuilder sb = new StringBuilder();
/* 3167 */       sb.append("[crossbattle_knockout]GrcManager.onGetNotifyKnockOutCorpsIdList");
/* 3168 */       sb.append("|activity_cfg_id=").append(activityCfgId);
/* 3169 */       sb.append("|knock_out_type=").append(knockOutType);
/* 3170 */       sb.append("|fight_stage=").append(fightStage);
/* 3171 */       sb.append("|max_fight_zone_id=").append(maxFightZoneId);
/* 3172 */       sb.append("|max_fight_index_id=").append(maxFightIndexId);
/* 3173 */       sb.append("|zone_id_list=").append(zoneIdList.toString());
/* 3174 */       sb.append("|repeat_times=").append(repeatTimes);
/* 3175 */       sb.append("|ret_code=").append(retcode);
/*      */       
/* 3177 */       GameServer.logger().info(sb.toString());
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 3181 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean gmSetSelectionCorpsInfo(int activityCfgId, int fightZoneId, long corpsId, int rank, String corpsName, int badgeId, int zoneId)
/*      */   {
/* 3191 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3192 */     arg.qtype = 104;
/* 3193 */     arg.data_direction = 1;
/*      */     
/* 3195 */     OctetsStream os = new OctetsStream();
/* 3196 */     os.marshal(activityCfgId);
/* 3197 */     os.marshal(fightZoneId);
/* 3198 */     os.marshal(corpsId);
/* 3199 */     os.marshal(rank);
/* 3200 */     os.marshal(corpsName, "UTF-8");
/* 3201 */     os.marshal(badgeId);
/* 3202 */     os.marshal(zoneId);
/*      */     
/* 3204 */     arg.info.replace(os);
/*      */     
/* 3206 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 3207 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGmSetSelectionCorpsInfo(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 3216 */     GameServer.logger().info(String.format("[crossbattle_selection]GrcManager.onGmSetSelectionCorpsInfo|ret=%d", new Object[] { Integer.valueOf(retcode) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGmSetSelectionCorpsInfoTimeout(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 3225 */     GameServer.logger().info(String.format("[crossbattle_selection]GrcManager.onGmSetSelectionCorpsInfoTimeout|ret=%d", new Object[] { Integer.valueOf(retcode) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean gmSetFinalCorpsInfo(int activityCfgId, int fightZoneId, int rank, long corpsId, String corpsName, int badgeId, int zoneId, int maxSelectionStage)
/*      */   {
/* 3235 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3236 */     arg.qtype = 106;
/* 3237 */     arg.data_direction = 1;
/*      */     
/* 3239 */     OctetsStream os = new OctetsStream();
/* 3240 */     os.marshal(activityCfgId);
/* 3241 */     os.marshal(fightZoneId);
/* 3242 */     os.marshal(rank);
/* 3243 */     os.marshal(corpsId);
/* 3244 */     os.marshal(corpsName, "UTF-8");
/* 3245 */     os.marshal(badgeId);
/* 3246 */     os.marshal(zoneId);
/* 3247 */     os.marshal(maxSelectionStage);
/*      */     
/* 3249 */     arg.info.replace(os);
/*      */     
/* 3251 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 3252 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGmSetFinalCorpsInfo(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 3260 */     GameServer.logger().info(String.format("[crossbattle_final]GrcManager.onGmSetFinalCorpsInfo|ret=%d", new Object[] { Integer.valueOf(retcode) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGmSetFinalCorpsInfoTimeout(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 3269 */     GameServer.logger().info(String.format("[crossbattle_final]GrcManager.onGmSetSelectionCorpsInfoTimeout|ret=%d", new Object[] { Integer.valueOf(retcode) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean clearKnockOutData(int activityCfgId, int knockOutType, int restartFightZoneId, int fightStage, int restartFightIndexId, int maxFightZoneId, int maxFightIndexId, long prepareWorldBeginTime, int repeatTimes)
/*      */   {
/* 3280 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3281 */     arg.qtype = 107;
/* 3282 */     arg.data_direction = 1;
/*      */     
/* 3284 */     OctetsStream os = new OctetsStream();
/* 3285 */     os.marshal(activityCfgId);
/* 3286 */     os.marshal(knockOutType);
/* 3287 */     os.marshal(restartFightZoneId);
/* 3288 */     os.marshal(fightStage);
/* 3289 */     os.marshal(restartFightIndexId);
/* 3290 */     os.marshal(maxFightZoneId);
/* 3291 */     os.marshal(maxFightIndexId);
/* 3292 */     os.marshal(prepareWorldBeginTime);
/* 3293 */     os.marshal(repeatTimes);
/*      */     
/* 3295 */     arg.info.replace(os);
/*      */     
/* 3297 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 3298 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onClearKnockOutDataResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 3309 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 3310 */       int activityCfgId = osArgInfo.unmarshal_int();
/* 3311 */       final int knockOutType = osArgInfo.unmarshal_int();
/* 3312 */       final int restartFightZoneId = osArgInfo.unmarshal_int();
/* 3313 */       final int fightStage = osArgInfo.unmarshal_int();
/* 3314 */       final int restartFightIndexId = osArgInfo.unmarshal_int();
/*      */       
/* 3316 */       final int maxFightZoneId = osArgInfo.unmarshal_int();
/* 3317 */       final int maxFightIndexId = osArgInfo.unmarshal_int();
/* 3318 */       final long restartPrepareWorldBeginTime = osArgInfo.unmarshal_long();
/* 3319 */       int repeatTimes = osArgInfo.unmarshal_int();
/*      */       
/* 3321 */       if (retcode != 0)
/*      */       {
/* 3323 */         if (repeatTimes < 10)
/*      */         {
/* 3325 */           Xdb.executor().schedule(new Runnable()
/*      */           {
/*      */ 
/*      */ 
/*      */             public void run() {
/* 3330 */               GrcInterface.clearKnockOutData(this.val$activityCfgId, knockOutType, restartFightZoneId, fightStage, restartFightIndexId, maxFightZoneId, maxFightIndexId, restartPrepareWorldBeginTime, this.val$repeatTimes + 1); } }, (repeatTimes + 1) * 1000L, TimeUnit.MILLISECONDS);
/*      */ 
/*      */         }
/*      */         
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/* 3339 */         boolean isRestartAllFightZone = false;
/* 3340 */         if (restartFightZoneId == -1)
/*      */         {
/* 3342 */           isRestartAllFightZone = true;
/*      */         }
/* 3344 */         List<Pair<Integer, Integer>> restartFightList = new ArrayList();
/* 3345 */         restartFightList.add(new Pair(Integer.valueOf(restartFightZoneId), Integer.valueOf(restartFightIndexId)));
/*      */         
/*      */ 
/* 3348 */         getNotifyKnockOutRestartCorpsId(restartPrepareWorldBeginTime, activityCfgId, knockOutType, isRestartAllFightZone, restartFightList, fightStage, maxFightIndexId, maxFightZoneId, GameServerInfoManager.getZoneIds(), 1, 0);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 3353 */       StringBuilder sBuilder = new StringBuilder();
/* 3354 */       sBuilder.append("[crossbattle_knockout]GrcManager.onClearKnockOutDataResponse");
/* 3355 */       sBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 3356 */       sBuilder.append("|knock_out_type=").append(knockOutType);
/* 3357 */       sBuilder.append("|restart_fight_zone_id=").append(restartFightZoneId);
/* 3358 */       sBuilder.append("|restart_fight_index_id=").append(restartFightIndexId);
/* 3359 */       sBuilder.append("|restart_prepare_world_begin_time=").append(restartPrepareWorldBeginTime);
/* 3360 */       sBuilder.append("|repeat_times=").append(repeatTimes);
/* 3361 */       sBuilder.append("|ret=").append(retcode);
/*      */       
/* 3363 */       GameServer.logger().info(sBuilder.toString());
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 3367 */       e.printStackTrace();
/*      */     }
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
/*      */   static boolean getNotifyKnockOutRestartCorpsId(long worldBeginTime, int activityCfgId, int knockOutType, boolean isAllFightZoneRestart, List<Pair<Integer, Integer>> restartFightList, int fightStage, int maxFightIndexId, int maxFightZoneId, List<Integer> zoneIdList, int type, int repeatTimes)
/*      */   {
/* 3404 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3405 */     arg.qtype = 109;
/* 3406 */     arg.data_direction = 1;
/*      */     
/* 3408 */     OctetsStream os = new OctetsStream();
/* 3409 */     os.marshal(activityCfgId);
/* 3410 */     os.marshal(knockOutType);
/* 3411 */     os.marshal(fightStage);
/* 3412 */     os.marshal(isAllFightZoneRestart);
/* 3413 */     os.marshal(restartFightList.size());
/* 3414 */     for (Pair<Integer, Integer> pair : restartFightList)
/*      */     {
/* 3416 */       os.marshal(((Integer)pair.first).intValue());
/* 3417 */       os.marshal(((Integer)pair.second).intValue());
/*      */     }
/* 3419 */     os.marshal(maxFightIndexId);
/* 3420 */     os.marshal(maxFightZoneId);
/* 3421 */     os.marshal(zoneIdList.size());
/* 3422 */     for (Integer zoneId : zoneIdList)
/*      */     {
/* 3424 */       os.marshal(zoneId.intValue());
/*      */     }
/*      */     
/* 3427 */     os.marshal(worldBeginTime);
/* 3428 */     os.marshal(type);
/* 3429 */     os.marshal(repeatTimes);
/*      */     
/* 3431 */     arg.info.replace(os);
/*      */     
/* 3433 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 3434 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetNotifyKnockOutRestartCorpsIdResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 3445 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */       
/* 3447 */       int activityCfgId = osArgInfo.unmarshal_int();
/*      */       
/* 3449 */       final int knockOutType = osArgInfo.unmarshal_int();
/*      */       
/* 3451 */       final int restartFightStage = osArgInfo.unmarshal_int();
/*      */       
/*      */ 
/* 3454 */       final boolean isAllFightZoneRestart = osArgInfo.unmarshal_boolean();
/* 3455 */       int restartFightSize = osArgInfo.unmarshal_int();
/* 3456 */       final List<Pair<Integer, Integer>> restartFightList = new ArrayList();
/* 3457 */       for (int index = 1; index <= restartFightSize; index++)
/*      */       {
/* 3459 */         Pair<Integer, Integer> pair = new Pair(Integer.valueOf(osArgInfo.unmarshal_int()), Integer.valueOf(osArgInfo.unmarshal_int()));
/*      */         
/* 3461 */         restartFightList.add(pair);
/*      */       }
/*      */       
/* 3464 */       final int maxFightZoneId = osArgInfo.unmarshal_int();
/*      */       
/* 3466 */       final int maxFightIndexId = osArgInfo.unmarshal_int();
/*      */       
/* 3468 */       int zoneIdSize = osArgInfo.unmarshal_int();
/* 3469 */       int zoneId; for (int index = 1; index <= zoneIdSize; index++)
/*      */       {
/*      */ 
/* 3472 */         zoneId = osArgInfo.unmarshal_int();
/*      */       }
/*      */       
/* 3475 */       long restartPrepareWorldBeginTime = osArgInfo.unmarshal_long();
/* 3476 */       int type = osArgInfo.unmarshal_int();
/* 3477 */       final int repeatTimes = osArgInfo.unmarshal_int();
/*      */       
/* 3479 */       if (retcode != 0)
/*      */       {
/* 3481 */         if (repeatTimes < 10)
/*      */         {
/* 3483 */           Xdb.executor().schedule(new Runnable()
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             public void run() {
/* 3489 */               GrcManager.getNotifyKnockOutRestartCorpsId(this.val$restartPrepareWorldBeginTime, knockOutType, isAllFightZoneRestart, restartFightList, restartFightStage, maxFightIndexId, maxFightZoneId, repeatTimes, GameServerInfoManager.getZoneIds(), 1, this.val$repeatTimes + 1); } }, (repeatTimes + 1) * 1000L, TimeUnit.MILLISECONDS);
/*      */ 
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/*      */ 
/* 3500 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 3501 */         Map<Long, Pair<Long, String>> corpsIdMap = new HashMap();
/* 3502 */         int size = osResInfo.unmarshal_int();
/* 3503 */         for (int index = 1; index <= size; index++)
/*      */         {
/* 3505 */           long corpsId = osResInfo.unmarshal_long();
/* 3506 */           long opponentCorpsId = osResInfo.unmarshal_long();
/* 3507 */           String opponentCorpsName = osResInfo.unmarshal_String("UTF-8");
/*      */           
/* 3509 */           corpsIdMap.put(Long.valueOf(corpsId), new Pair(Long.valueOf(opponentCorpsId), opponentCorpsName));
/*      */         }
/*      */         
/*      */ 
/* 3513 */         CrossBattleKnockoutInterface.onGetNotifyCrossBattleRestartCorpsIdList(activityCfgId, knockOutType, isAllFightZoneRestart, restartFightList, restartPrepareWorldBeginTime, restartFightStage, corpsIdMap, type);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 3518 */       StringBuilder sBuilder = new StringBuilder();
/* 3519 */       sBuilder.append("[crossbattle_knockout]GrcManager.onClearKnockOutDataResponse");
/* 3520 */       sBuilder.append("|ret=").append(res.retcode);
/* 3521 */       sBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 3522 */       sBuilder.append("|knock_out_type=").append(knockOutType);
/* 3523 */       sBuilder.append("|restart_prepare_world_begin_time=").append(restartPrepareWorldBeginTime);
/* 3524 */       sBuilder.append("|restart_fight_stage=").append(restartFightStage);
/* 3525 */       sBuilder.append("|type=").append(type);
/* 3526 */       sBuilder.append("|repeat_times=").append(repeatTimes);
/* 3527 */       sBuilder.append("|max_fight_zone_id=").append(maxFightZoneId);
/* 3528 */       sBuilder.append("|max_fight_index_id=").append(maxFightIndexId);
/*      */       
/* 3530 */       GameServer.logger().info(sBuilder.toString());
/*      */ 
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 3535 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reportCrossBattleStageFightEndCorpsRoleInfo(int activityCfgId, int knockOutType, int fightStage, long corpsId, long roleId, String roleName, int occupationId, int roleLevel, int avatarId, int multifightvalue, int mfrank, int gender, int joinTime, int duty, ModelInfo modelInfo)
/*      */   {
/* 3547 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3548 */     arg.qtype = 114;
/* 3549 */     arg.data_direction = 1;
/*      */     
/* 3551 */     OctetsStream os = new OctetsStream();
/* 3552 */     os.marshal(activityCfgId);
/* 3553 */     os.marshal(knockOutType);
/* 3554 */     os.marshal(fightStage);
/* 3555 */     os.marshal(corpsId);
/* 3556 */     os.marshal(roleId);
/* 3557 */     os.marshal(roleName, "UTF-8");
/* 3558 */     os.marshal(occupationId);
/* 3559 */     os.marshal(roleLevel);
/* 3560 */     os.marshal(avatarId);
/* 3561 */     os.marshal(multifightvalue);
/* 3562 */     os.marshal(mfrank);
/* 3563 */     os.marshal(gender);
/* 3564 */     os.marshal(joinTime);
/* 3565 */     os.marshal(duty);
/* 3566 */     os.marshal(modelInfo.modelid);
/* 3567 */     os.marshal(modelInfo.name, "UTF-8");
/* 3568 */     os.marshal(modelInfo.extramap.size());
/* 3569 */     for (Map.Entry<Integer, Integer> entry : modelInfo.extramap.entrySet())
/*      */     {
/* 3571 */       os.marshal(((Integer)entry.getKey()).intValue());
/* 3572 */       os.marshal(((Integer)entry.getValue()).intValue());
/*      */     }
/*      */     
/* 3575 */     arg.info.replace(os);
/*      */     
/* 3577 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 3578 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getCrossBattleStageFightEndCorpsInfo(int activityCfgId, int knockOutType, int fightStage, long corpsId, Octets octets, int repeatTimes)
/*      */   {
/* 3587 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3588 */     arg.qtype = 115;
/* 3589 */     arg.data_direction = 1;
/*      */     
/* 3591 */     OctetsStream os = new OctetsStream();
/* 3592 */     os.marshal(activityCfgId);
/* 3593 */     os.marshal(knockOutType);
/* 3594 */     os.marshal(fightStage);
/* 3595 */     os.marshal(corpsId);
/* 3596 */     os.marshal(octets);
/* 3597 */     os.marshal(repeatTimes);
/*      */     
/* 3599 */     arg.info.replace(os);
/*      */     
/* 3601 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 3602 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onGetCrossBattleStageFightEndCorpsInfo(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/* 3611 */     OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */     try
/*      */     {
/* 3614 */       OctetsStream osResInfo = new OctetsStream(res.info);
/* 3615 */       int activityCfgId = osArgInfo.unmarshal_int();
/* 3616 */       final int knockOutType = osArgInfo.unmarshal_int();
/* 3617 */       final int fightStage = osArgInfo.unmarshal_int();
/*      */       
/*      */ 
/* 3620 */       final long corpsId = osArgInfo.unmarshal_long();
/*      */       
/* 3622 */       Octets octets = osArgInfo.unmarshal_Octets();
/*      */       
/* 3624 */       final int repeatTimes = osArgInfo.unmarshal_int();
/*      */       
/* 3626 */       StringBuilder sBuilder = new StringBuilder();
/* 3627 */       sBuilder.append("[crossbattle_knockout]GrcManager.onGetCrossBattleStageFightEndCorpsInfo@get stage fight end corps response");
/* 3628 */       sBuilder.append("|ret=").append(retcode);
/* 3629 */       sBuilder.append("|activity_cfg_id=").append(activityCfgId);
/* 3630 */       sBuilder.append("|knock_out_type=").append(knockOutType);
/* 3631 */       sBuilder.append("|fight_stage=").append(fightStage);
/* 3632 */       sBuilder.append("|corps_id=").append(corpsId);
/* 3633 */       sBuilder.append("|repeat_times=").append(repeatTimes);
/*      */       
/* 3635 */       if (res.retcode != 0)
/*      */       {
/* 3637 */         if (repeatTimes < 10)
/*      */         {
/* 3639 */           Xdb.executor().schedule(new Runnable()
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             public void run() {
/* 3645 */               GrcManager.getCrossBattleStageFightEndCorpsInfo(this.val$activityCfgId, knockOutType, fightStage, corpsId, repeatTimes, this.val$repeatTimes + 1); } }, (repeatTimes + 1) * 1000L, TimeUnit.MICROSECONDS);
/*      */           
/*      */ 
/*      */ 
/* 3649 */           GameServer.logger().info(sBuilder.toString());
/* 3650 */           return;
/*      */         }
/*      */       }
/*      */       
/* 3654 */       String corpsInfoJson = osResInfo.size() > 0 ? osResInfo.unmarshal_String("UTF-8") : null;
/*      */       
/* 3656 */       CrossBattleKnockoutInterface.onGetHistoryCorpsInfo(res.retcode, corpsId, corpsInfoJson, octets);
/*      */       
/* 3658 */       sBuilder.append("|corps_info_json=").append(corpsInfoJson);
/* 3659 */       GameServer.logger().info(sBuilder.toString());
/*      */ 
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/* 3664 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean getCrossBattleKnockoutStageBetInfo(int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightNum, long roleid, int reason)
/*      */   {
/* 3672 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3673 */     arg.qtype = 61;
/* 3674 */     arg.data_direction = 1;
/*      */     
/* 3676 */     OctetsStream os = new OctetsStream();
/* 3677 */     os.marshal(activityCfgid);
/* 3678 */     os.marshal(knockoutType);
/* 3679 */     os.marshal(fightZoneid);
/* 3680 */     os.marshal(stage);
/* 3681 */     os.marshal(fightNum);
/* 3682 */     os.marshal(roleid);
/* 3683 */     os.marshal(reason);
/* 3684 */     arg.info.replace(os);
/*      */     
/* 3686 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*      */     
/* 3688 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetCrossBattleKnockoutStageBetInfo(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 3696 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 3697 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 3698 */       int knockoutType = osArgInfo.unmarshal_int();
/* 3699 */       int fightZoneid = osArgInfo.unmarshal_int();
/* 3700 */       int stage = osArgInfo.unmarshal_int();
/* 3701 */       int fightNum = osArgInfo.unmarshal_int();
/* 3702 */       long roleid = osArgInfo.unmarshal_long();
/* 3703 */       int reason = osArgInfo.unmarshal_int();
/* 3704 */       TriggerEventsManger.getInstance().triggerEvent(new GetCrossBattleKnockoutStageBetInfoDone(), new GetCrossBattleKnockoutStageBetInfoDoneArg(retcode, activityCfgid, knockoutType, fightZoneid, stage, fightNum, roleid, reason, res.info), CrossBattleOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
/*      */ 
/*      */ 
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/*      */ 
/*      */ 
/* 3712 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean reportRoleCrossBattleKnockoutBetInfo(int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightIndex, long roleid, long betCorpsid, int betMoneyNum)
/*      */   {
/* 3719 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3720 */     arg.qtype = 62;
/* 3721 */     arg.data_direction = 1;
/*      */     
/* 3723 */     OctetsStream os = new OctetsStream();
/* 3724 */     os.marshal(activityCfgid);
/* 3725 */     os.marshal(knockoutType);
/* 3726 */     os.marshal(fightZoneid);
/* 3727 */     os.marshal(stage);
/* 3728 */     os.marshal(fightIndex);
/* 3729 */     os.marshal(roleid);
/* 3730 */     os.marshal(betCorpsid);
/* 3731 */     os.marshal(betMoneyNum);
/* 3732 */     arg.info.replace(os);
/*      */     
/* 3734 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/*      */     
/* 3736 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onReportRoleCrossBattleKnockoutBetInfo(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 3744 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 3745 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 3746 */       int knockoutType = osArgInfo.unmarshal_int();
/* 3747 */       int fightZoneid = osArgInfo.unmarshal_int();
/* 3748 */       int stage = osArgInfo.unmarshal_int();
/* 3749 */       int fightIndex = osArgInfo.unmarshal_int();
/* 3750 */       long roleid = osArgInfo.unmarshal_long();
/* 3751 */       long betCorpsid = osArgInfo.unmarshal_long();
/* 3752 */       int betMoneyNum = osArgInfo.unmarshal_int();
/* 3753 */       TriggerEventsManger.getInstance().triggerEvent(new ReportRoleCrossBattleKnockoutBetInfoDone(), new ReportRoleCrossBattleKnockoutBetInfoDoneArg(retcode, activityCfgid, knockoutType, fightZoneid, stage, fightIndex, roleid, betCorpsid, betMoneyNum, res.info), CrossBattleOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
/*      */ 
/*      */ 
/*      */     }
/*      */     catch (MarshalException e)
/*      */     {
/*      */ 
/*      */ 
/* 3761 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean reportRoleBasicInfo(String openid, long loginTime, int maxLevel, Octets context)
/*      */   {
/* 3767 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 3768 */     arg.qtype = 200;
/* 3769 */     arg.data_direction = 1;
/*      */     
/* 3771 */     OctetsStream os = new OctetsStream();
/* 3772 */     os.marshal(openid, "UTF-8");
/* 3773 */     os.marshal(loginTime);
/* 3774 */     os.marshal(maxLevel);
/* 3775 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 3776 */     arg.info.replace(os);
/*      */     
/* 3778 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 3779 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onReportRoleBasicInfoResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 3787 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/*      */       
/* 3789 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 3790 */       long loginTime = osArgInfo.unmarshal_long();
/* 3791 */       int maxLevel = osArgInfo.unmarshal_int();
/* 3792 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/*      */ 
/* 3795 */       ReportAccountInfoDoneArg eventArg = new ReportAccountInfoDoneArg(retcode, openid, loginTime, maxLevel, context);
/*      */       
/* 3797 */       TriggerEventsManger.getInstance().triggerEvent(new ReportAccountInfoDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncRecallLossInfo(String userid, long roleid, List<GrcLossUserInfo> recallFriends, List<GrcRecallInfo> recallInfo)
/*      */   {
/* 3808 */     if ((recallFriends.isEmpty()) && (recallInfo.isEmpty()))
/*      */     {
/* 3810 */       return;
/*      */     }
/*      */     
/* 3813 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/*      */ 
/* 3816 */     String activeUserid = RoleInterface.getUserId(roleid);
/* 3817 */     xbean.User xUser = xtable.User.get(activeUserid);
/*      */     
/* 3819 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/* 3820 */     long lastRecallTime = xRecallFriendBackGame.getLast_recall_friend_time();
/* 3821 */     if (!DateTimeUtils.isInSameDay(now, lastRecallTime))
/*      */     {
/* 3823 */       xRecallFriendBackGame.setRecall_friend_times_today(0);
/*      */     }
/* 3825 */     if (!recallInfo.isEmpty())
/*      */     {
/* 3827 */       GrcRecallInfo grcRecallInfo = (GrcRecallInfo)recallInfo.get(0);
/* 3828 */       long updateTime = grcRecallInfo.udpate_time;
/* 3829 */       if (DateTimeUtils.isInSameDay(now, updateTime))
/*      */       {
/* 3831 */         xRecallFriendBackGame.setCross_recall_friend_times_today(grcRecallInfo.recall_num);
/*      */       }
/*      */       else
/*      */       {
/* 3835 */         xRecallFriendBackGame.setCross_recall_friend_times_today(0);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3840 */     SyncRecallLossInfo msg = new SyncRecallLossInfo();
/* 3841 */     msg.today_num = (xRecallFriendBackGame.getRecall_friend_times_today() + xRecallFriendBackGame.getCross_recall_friend_times_today());
/*      */     
/* 3843 */     msg.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xRecallFriendBackGame.getLast_recall_friend_time()));
/*      */     
/* 3845 */     if (!recallFriends.isEmpty())
/*      */     {
/* 3847 */       Map<String, GrcLossUserInfo> adds = new HashMap();
/* 3848 */       for (GrcLossUserInfo grcLossUserInfo : recallFriends)
/*      */       {
/* 3850 */         xbean.RecallUserInfo xTargetRecallUserInfo = null;
/* 3851 */         String friendOpenid = grcLossUserInfo.user_info.openid.getString("UTF-8");
/* 3852 */         for (xbean.RecallUserInfo xRecallUserInfo : xRecallFriendBackGame.getRecall_friend_list())
/*      */         {
/* 3854 */           String tmpFriendOpenid = xRecallUserInfo.getRecall_openid();
/* 3855 */           if (tmpFriendOpenid.isEmpty())
/*      */           {
/* 3857 */             String friendUserid = xRecallUserInfo.getUser_id();
/* 3858 */             tmpFriendOpenid = CommonUtils.getOpenId(friendUserid);
/* 3859 */             xRecallUserInfo.setRecall_openid(tmpFriendOpenid);
/*      */           }
/*      */           
/* 3862 */           if (friendOpenid.equals(tmpFriendOpenid))
/*      */           {
/* 3864 */             if (grcLossUserInfo.invite_time > xRecallUserInfo.getRecall_time())
/*      */             {
/* 3866 */               xRecallUserInfo.setRecall_time(grcLossUserInfo.invite_time);
/*      */             }
/* 3868 */             if (grcLossUserInfo.start_time > xRecallUserInfo.getStart_time())
/*      */             {
/* 3870 */               xRecallUserInfo.setStart_time(grcLossUserInfo.start_time);
/* 3871 */               xRecallUserInfo.setBe_recall_num(grcLossUserInfo.be_recall_num);
/*      */             }
/* 3873 */             xTargetRecallUserInfo = xRecallUserInfo;
/* 3874 */             break;
/*      */           }
/*      */         }
/* 3877 */         if (xTargetRecallUserInfo != null)
/*      */         {
/* 3879 */           msg.loss_infos.add(getRecallLossInfo(grcLossUserInfo, xTargetRecallUserInfo));
/*      */         }
/*      */         else
/*      */         {
/* 3883 */           if (grcLossUserInfo.invite_time > 0L)
/*      */           {
/* 3885 */             adds.put(friendOpenid, grcLossUserInfo);
/*      */           }
/* 3887 */           msg.loss_infos.add(getRecallLossInfo(grcLossUserInfo));
/*      */         }
/*      */       }
/* 3890 */       for (Map.Entry<String, GrcLossUserInfo> entry : adds.entrySet())
/*      */       {
/* 3892 */         xbean.RecallUserInfo xRecallUserInfo = Pod.newRecallUserInfo();
/* 3893 */         xRecallUserInfo.setRecall_openid((String)entry.getKey());
/* 3894 */         GrcLossUserInfo grcLossUserInfo = (GrcLossUserInfo)entry.getValue();
/* 3895 */         xRecallUserInfo.setRecall_time(grcLossUserInfo.invite_time);
/* 3896 */         xRecallUserInfo.setStart_time(grcLossUserInfo.start_time);
/* 3897 */         xRecallUserInfo.setBe_recall_num(grcLossUserInfo.be_recall_num);
/* 3898 */         xRecallFriendBackGame.getRecall_friend_list().add(xRecallUserInfo);
/*      */       }
/*      */     }
/*      */     
/* 3902 */     OnlineManager.getInstance().send(roleid, msg);
/*      */   }
/*      */   
/*      */   private static RecallLossInfo getRecallLossInfo(GrcLossUserInfo grcLossUserInfo)
/*      */   {
/* 3907 */     RecallLossInfo lossInfo = new RecallLossInfo();
/* 3908 */     mzm.gsp.grc.RecallUserInfo userInfo = lossInfo.user_info;
/* 3909 */     boxRecallUserInfo(userInfo, grcLossUserInfo.user_info);
/*      */     
/* 3911 */     RecallRoleInfo roleInfo = lossInfo.role_info;
/* 3912 */     boxRecallRoleInfo(roleInfo, grcLossUserInfo.roleinfo);
/*      */     
/* 3914 */     if (grcLossUserInfo.start_time == 0L)
/*      */     {
/* 3916 */       lossInfo.start_time = ((int)TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()));
/*      */     }
/*      */     else
/*      */     {
/* 3920 */       lossInfo.start_time = ((int)TimeUnit.MILLISECONDS.toSeconds(grcLossUserInfo.start_time));
/*      */     }
/* 3922 */     lossInfo.be_recall_num = grcLossUserInfo.be_recall_num;
/* 3923 */     lossInfo.invite_time = ((int)TimeUnit.MILLISECONDS.toSeconds(grcLossUserInfo.invite_time));
/* 3924 */     return lossInfo;
/*      */   }
/*      */   
/*      */ 
/*      */   private static RecallLossInfo getRecallLossInfo(GrcLossUserInfo grcLossUserInfo, xbean.RecallUserInfo xRecallUserInfo)
/*      */   {
/* 3930 */     RecallLossInfo lossInfo = new RecallLossInfo();
/* 3931 */     mzm.gsp.grc.RecallUserInfo userInfo = lossInfo.user_info;
/* 3932 */     boxRecallUserInfo(userInfo, grcLossUserInfo.user_info);
/*      */     
/* 3934 */     RecallRoleInfo roleInfo = lossInfo.role_info;
/* 3935 */     boxRecallRoleInfo(roleInfo, grcLossUserInfo.roleinfo);
/*      */     
/* 3937 */     long startTime = xRecallUserInfo.getStart_time();
/* 3938 */     if (startTime == 0L)
/*      */     {
/* 3940 */       lossInfo.start_time = ((int)TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()));
/*      */     }
/*      */     else
/*      */     {
/* 3944 */       lossInfo.start_time = ((int)TimeUnit.MILLISECONDS.toSeconds(startTime));
/*      */     }
/* 3946 */     lossInfo.be_recall_num = xRecallUserInfo.getBe_recall_num();
/* 3947 */     lossInfo.invite_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xRecallUserInfo.getRecall_time()));
/* 3948 */     return lossInfo;
/*      */   }
/*      */   
/*      */   static void boxRecallUserInfo(mzm.gsp.grc.RecallUserInfo userInfo, GrcRecallUserInfo grcUserInfo)
/*      */   {
/* 3953 */     userInfo.openid = grcUserInfo.openid;
/* 3954 */     userInfo.nickname = grcUserInfo.nickname;
/* 3955 */     userInfo.figure_url = grcUserInfo.figure_url;
/* 3956 */     userInfo.last_login = ((int)TimeUnit.MILLISECONDS.toSeconds(grcUserInfo.login_time));
/* 3957 */     userInfo.login_privilege = grcUserInfo.login_privilege;
/* 3958 */     for (grc.QQVipInfo grcQQVipInfo : grcUserInfo.qq_vip_infos.values())
/*      */     {
/* 3960 */       mzm.gsp.grc.QQVipInfo qqVipInfo = new mzm.gsp.grc.QQVipInfo();
/* 3961 */       qqVipInfo.vip_flag = grcQQVipInfo.vip_flag;
/* 3962 */       qqVipInfo.is_vip = grcQQVipInfo.is_vip;
/* 3963 */       qqVipInfo.is_year = grcQQVipInfo.is_year;
/* 3964 */       qqVipInfo.is_luxury = grcQQVipInfo.is_luxury;
/* 3965 */       qqVipInfo.level = grcQQVipInfo.level;
/* 3966 */       userInfo.qq_vip_infos.put(Integer.valueOf(qqVipInfo.vip_flag), qqVipInfo);
/*      */     }
/*      */   }
/*      */   
/*      */   static void boxRecallRoleInfo(RecallRoleInfo roleInfo, GrcRoleInfo grcRoleInfo)
/*      */   {
/* 3972 */     roleInfo.gender = grcRoleInfo.gender;
/* 3973 */     roleInfo.level = grcRoleInfo.level;
/* 3974 */     roleInfo.occupation = grcRoleInfo.occupation;
/* 3975 */     roleInfo.roleid = grcRoleInfo.roleid;
/* 3976 */     roleInfo.rolename = grcRoleInfo.rolename;
/* 3977 */     roleInfo.zoneid = grcRoleInfo.zoneid;
/* 3978 */     roleInfo.fight = grcRoleInfo.fighting_capacity;
/*      */   }
/*      */   
/*      */   static void boxRecallRoleInfo(RecallRoleInfo recallRoleInfo, long roleid)
/*      */   {
/* 3983 */     Role role = RoleInterface.getRole(roleid, true);
/* 3984 */     recallRoleInfo.fight = role.getFightValue();
/* 3985 */     recallRoleInfo.gender = role.getGender();
/* 3986 */     recallRoleInfo.level = role.getLevel();
/* 3987 */     recallRoleInfo.occupation = role.getOccupationId();
/* 3988 */     recallRoleInfo.roleid = roleid;
/*      */     try
/*      */     {
/* 3991 */       recallRoleInfo.rolename.setString(role.getName(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/* 3996 */     recallRoleInfo.zoneid = GameServerInfoManager.getZoneidFromRoleid(roleid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean recallFriend(String openid, String friendOpenid, long serialNo, int period, int todayRecallMax, int beRecallNum, Octets context)
/*      */   {
/* 4005 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4006 */     arg.qtype = 201;
/* 4007 */     arg.data_direction = 1;
/*      */     
/* 4009 */     OctetsStream os = new OctetsStream();
/* 4010 */     os.marshal(openid, "UTF-8");
/* 4011 */     os.marshal(friendOpenid, "UTF-8");
/* 4012 */     os.marshal(serialNo);
/*      */     
/* 4014 */     os.marshal(period);
/* 4015 */     os.marshal(todayRecallMax);
/* 4016 */     os.marshal(beRecallNum);
/*      */     
/* 4018 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4019 */     arg.info.replace(os);
/*      */     
/* 4021 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4022 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onRecallFriendResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4029 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4030 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4031 */       String friendOpenid = osArgInfo.unmarshal_String("UTF-8");
/* 4032 */       long serialNo = osArgInfo.unmarshal_long();
/*      */       
/* 4034 */       osArgInfo.unmarshal_int();
/* 4035 */       osArgInfo.unmarshal_int();
/* 4036 */       osArgInfo.unmarshal_int();
/*      */       
/* 4038 */       Octets context = osArgInfo.unmarshal_Octets();
/* 4039 */       RecallResponse rsp = new RecallResponse();
/* 4040 */       if (res.info.size() > 0)
/*      */       {
/* 4042 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 4043 */         rsp.unmarshal(osResInfo);
/*      */       }
/*      */       
/*      */ 
/* 4047 */       RecallFriendDoneArg eventArg = new RecallFriendDoneArg(retcode, openid, friendOpenid, serialNo, context, rsp);
/* 4048 */       TriggerEventsManger.getInstance().triggerEvent(new RecallFriendDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncUserBackInfo(String userid, long roleid, List<GrcUserBackInfo> grcUserBackInfo)
/*      */   {
/* 4058 */     if (grcUserBackInfo.isEmpty())
/*      */     {
/* 4060 */       return;
/*      */     }
/*      */     
/* 4063 */     GrcUserBackInfo backInfo = (GrcUserBackInfo)grcUserBackInfo.get(0);
/* 4064 */     SyncUserBackInfo msg = new SyncUserBackInfo();
/* 4065 */     msg.back_time = ((int)TimeUnit.MILLISECONDS.toSeconds(backInfo.back_time));
/* 4066 */     msg.first = backInfo.first;
/* 4067 */     for (GrcRecallFriendInfo friendInfo : backInfo.recall_friends)
/*      */     {
/* 4069 */       FriendRecallInfo info = new FriendRecallInfo();
/* 4070 */       boxFriendRecallInfo(info, friendInfo);
/* 4071 */       msg.recall_friends.add(info);
/*      */     }
/* 4073 */     OnlineManager.getInstance().send(roleid, msg);
/*      */   }
/*      */   
/*      */   static void boxFriendRecallInfo(FriendRecallInfo result, GrcRecallFriendInfo grcInfo)
/*      */   {
/* 4078 */     boxRecallUserInfo(result.user_info, grcInfo.user_info);
/* 4079 */     boxRecallRoleInfo(result.role_info, grcInfo.roleinfo);
/* 4080 */     result.callback = grcInfo.callback;
/* 4081 */     result.state = grcInfo.state;
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
/*      */   static boolean back(String openid, int activityCfgid, long serialNo, Octets context)
/*      */   {
/* 4094 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4095 */     arg.qtype = 210;
/* 4096 */     arg.data_direction = 1;
/*      */     
/* 4098 */     OctetsStream os = new OctetsStream();
/* 4099 */     os.marshal(openid, "UTF-8");
/* 4100 */     os.marshal(activityCfgid);
/* 4101 */     os.marshal(serialNo);
/* 4102 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4103 */     arg.info.replace(os);
/*      */     
/* 4105 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4106 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onBackResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4113 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4114 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4115 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 4116 */       long serialNo = osArgInfo.unmarshal_long();
/* 4117 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 4119 */       GrcUserBackInfo userBackInfo = new GrcUserBackInfo();
/* 4120 */       if (res.info.size() > 0)
/*      */       {
/* 4122 */         OctetsStream osRsp = new OctetsStream(res.info);
/* 4123 */         userBackInfo.unmarshal(osRsp);
/*      */       }
/*      */       
/*      */ 
/* 4127 */       BackDoneArg eventArg = new BackDoneArg(retcode, openid, activityCfgid, serialNo, context, userBackInfo);
/* 4128 */       TriggerEventsManger.getInstance().triggerEvent(new BackDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean bindFriend(String openid, String friendOpenid, long serialNo, int bindPeriodInHour, int bindFriendNum, int beBindFriendNum, Octets context)
/*      */   {
/* 4139 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4140 */     arg.qtype = 202;
/* 4141 */     arg.data_direction = 1;
/*      */     
/* 4143 */     OctetsStream os = new OctetsStream();
/* 4144 */     os.marshal(openid, "UTF-8");
/* 4145 */     os.marshal(friendOpenid, "UTF-8");
/* 4146 */     os.marshal(serialNo);
/* 4147 */     os.marshal(bindPeriodInHour);
/* 4148 */     os.marshal(bindFriendNum);
/* 4149 */     os.marshal(beBindFriendNum);
/* 4150 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4151 */     arg.info.replace(os);
/*      */     
/* 4153 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4154 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onBindFriendResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4161 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4162 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4163 */       String friendOpenid = osArgInfo.unmarshal_String("UTF-8");
/* 4164 */       long serialNo = osArgInfo.unmarshal_long();
/*      */       
/* 4166 */       osArgInfo.unmarshal_int();
/* 4167 */       osArgInfo.unmarshal_int();
/* 4168 */       osArgInfo.unmarshal_int();
/*      */       
/* 4170 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 4172 */       BindFriendResponse response = new BindFriendResponse();
/* 4173 */       if (res.info.size() > 0)
/*      */       {
/* 4175 */         OctetsStream osRsp = new OctetsStream(res.info);
/* 4176 */         response.unmarshal(osRsp);
/*      */       }
/*      */       
/*      */ 
/* 4180 */       BindFriendDoneArg eventArg = new BindFriendDoneArg(retcode, openid, friendOpenid, serialNo, context, response);
/* 4181 */       TriggerEventsManger.getInstance().triggerEvent(new BindFriendDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncBindRewardInfo(String userid, long roleid, List<GrcBindRewardInfo> grcBindRewardInfo)
/*      */   {
/* 4191 */     if (grcBindRewardInfo.isEmpty())
/*      */     {
/* 4193 */       return;
/*      */     }
/*      */     
/* 4196 */     SyncBackFriendBindInfo msg = new SyncBackFriendBindInfo();
/* 4197 */     GrcBindRewardInfo bindRewardInfo = (GrcBindRewardInfo)grcBindRewardInfo.get(0);
/* 4198 */     for (GrcBackBindFriendInfo grcFriendInfo : bindRewardInfo.back_friends)
/*      */     {
/* 4200 */       FriendBindInfo info = new FriendBindInfo();
/* 4201 */       info.bind_time = ((int)TimeUnit.MILLISECONDS.toSeconds(grcFriendInfo.bind_time));
/* 4202 */       boxRecallUserInfo(info.user_info, grcFriendInfo.user_info);
/* 4203 */       msg.back_friends.add(info);
/* 4204 */       if (grcFriendInfo.mail_state == 0)
/*      */       {
/* 4206 */         String friendOpenid = grcFriendInfo.user_info.openid.getString("UTF-8");
/* 4207 */         NoneRealTimeTaskManager.getInstance().addTask(new RSendBindMail(userid, roleid, friendOpenid));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 4212 */     GrcRebateInfo grcRebateInfo = bindRewardInfo.rebate_info;
/* 4213 */     RebateInfo rebateInfo = msg.rebate_info;
/* 4214 */     rebateInfo.receive_num = grcRebateInfo.receive_num;
/* 4215 */     rebateInfo.receive_time = ((int)TimeUnit.MILLISECONDS.toSeconds(grcRebateInfo.receive_time));
/* 4216 */     rebateInfo.total_num = grcRebateInfo.total_num;
/* 4217 */     OnlineManager.getInstance().send(roleid, msg);
/*      */   }
/*      */   
/*      */   static boolean sendBindMail(String openid, String friendOpenid, long serial, Octets context)
/*      */   {
/* 4222 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4223 */     arg.qtype = 203;
/* 4224 */     arg.data_direction = 1;
/*      */     
/* 4226 */     OctetsStream os = new OctetsStream();
/* 4227 */     os.marshal(openid, "UTF-8");
/* 4228 */     os.marshal(friendOpenid, "UTF-8");
/* 4229 */     os.marshal(serial);
/* 4230 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4231 */     arg.info.replace(os);
/*      */     
/* 4233 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4234 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onBindMailResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4241 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4242 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4243 */       String friendOpenid = osArgInfo.unmarshal_String("UTF-8");
/* 4244 */       long serialNo = osArgInfo.unmarshal_long();
/* 4245 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 4247 */       String friendName = null;
/* 4248 */       if (res.info.size() > 0)
/*      */       {
/* 4250 */         OctetsStream os = new OctetsStream(res.info);
/* 4251 */         Octets octets = os.unmarshal_Octets();
/* 4252 */         friendName = octets.getString("UTF-8");
/*      */       }
/*      */       
/*      */ 
/* 4256 */       SendBindMailDoneArg eventArg = new SendBindMailDoneArg(retcode, openid, friendOpenid, serialNo, context, friendName);
/*      */       
/* 4258 */       TriggerEventsManger.getInstance().triggerEvent(new SendBindMailDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean updateRoleVitalityInfo(String openid, RoleVitalityInfo vitalityInfo, Octets context)
/*      */   {
/* 4269 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4270 */     arg.qtype = 204;
/* 4271 */     arg.data_direction = 1;
/*      */     
/* 4273 */     OctetsStream os = new OctetsStream();
/* 4274 */     os.marshal(openid, "UTF-8");
/* 4275 */     os.marshal(vitalityInfo);
/* 4276 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4277 */     arg.info.replace(os);
/*      */     
/* 4279 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4280 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onUpdateRoleVitalityInfoResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4288 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4289 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4290 */       RoleVitalityInfo vitalityInfo = new RoleVitalityInfo();
/* 4291 */       vitalityInfo.unmarshal(osArgInfo);
/* 4292 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/*      */ 
/* 4295 */       UpdateRoleVitalityDoneArg eventArg = new UpdateRoleVitalityDoneArg(retcode, openid, vitalityInfo, context);
/* 4296 */       TriggerEventsManger.getInstance().triggerEvent(new UpdateRoleVitalityDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncBindVitalityInfo(String userid, long roleid, List<GrcUserProfileInfo> userProfileInfo, List<GrcRoleInfo> grcRoleInfo, List<GrcBindFriendVitalityInfo> recallBindInfos, List<GrcBindFriendVitalityInfo> backBindInfos)
/*      */   {
/* 4308 */     SyncBindVitalityInfo msg = new SyncBindVitalityInfo();
/* 4309 */     String openid = CommonUtils.getOpenId(userid);
/* 4310 */     mzm.gsp.grc.RoleVitalityInfo vitalityInfo = msg.vitality_info;
/* 4311 */     mzm.gsp.grc.RecallUserInfo recallUserInfo = vitalityInfo.user_info;
/*      */     try
/*      */     {
/* 4314 */       recallUserInfo.openid.setString(openid, "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e1) {}
/*      */     
/*      */ 
/* 4319 */     if ((userProfileInfo != null) && (!userProfileInfo.isEmpty()))
/*      */     {
/* 4321 */       GrcUserProfileInfo profileInfo = (GrcUserProfileInfo)userProfileInfo.get(0);
/* 4322 */       recallUserInfo.figure_url = profileInfo.figure_url;
/* 4323 */       recallUserInfo.nickname = profileInfo.nickname;
/*      */     }
/*      */     else
/*      */     {
/* 4327 */       xbean.User xUser = xtable.User.get(userid);
/* 4328 */       if (xUser != null)
/*      */       {
/*      */         try
/*      */         {
/* 4332 */           recallUserInfo.figure_url.setString(xUser.getFigure_url(), "UTF-8");
/* 4333 */           recallUserInfo.nickname.setString(xUser.getNick_name(), "UTF-8");
/*      */         }
/*      */         catch (UnsupportedEncodingException e) {}
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 4341 */     if (grcRoleInfo.isEmpty())
/*      */     {
/* 4343 */       boxRecallRoleInfo(vitalityInfo.role_info, roleid);
/* 4344 */       vitalityInfo.vitality = ActiveInterface.getTotalActiveValue(roleid);
/* 4345 */       vitalityInfo.update_time = ((int)TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()));
/*      */     }
/*      */     else
/*      */     {
/* 4349 */       RecallFriendManager.boxRoleVitalityInfo((GrcRoleInfo)grcRoleInfo.get(0), vitalityInfo);
/*      */     }
/*      */     
/* 4352 */     for (GrcBindFriendVitalityInfo grcFriendVitalityInfo : recallBindInfos)
/*      */     {
/* 4354 */       BindVitalityInfo bindVitalityInfo = new BindVitalityInfo();
/* 4355 */       RecallFriendManager.boxBindVitalityInfo(grcFriendVitalityInfo, bindVitalityInfo);
/* 4356 */       msg.recall_bind_infos.add(bindVitalityInfo);
/*      */     }
/* 4358 */     for (GrcBindFriendVitalityInfo grcFriendVitalityInfo : backBindInfos)
/*      */     {
/* 4360 */       BindVitalityInfo bindVitalityInfo = new BindVitalityInfo();
/* 4361 */       RecallFriendManager.boxBindVitalityInfo(grcFriendVitalityInfo, bindVitalityInfo);
/* 4362 */       msg.back_bind_infos.add(bindVitalityInfo);
/*      */     }
/* 4364 */     OnlineManager.getInstance().send(roleid, msg);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean getBindReward(String openid, String friendOpenid, int bindType, long serialNo, int vitality, Octets context)
/*      */   {
/* 4370 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4371 */     arg.qtype = 205;
/* 4372 */     arg.data_direction = 1;
/*      */     
/* 4374 */     OctetsStream os = new OctetsStream();
/* 4375 */     os.marshal(openid, "UTF-8");
/* 4376 */     os.marshal(friendOpenid, "UTF-8");
/* 4377 */     os.marshal(bindType);
/* 4378 */     os.marshal(serialNo);
/* 4379 */     os.marshal(vitality);
/* 4380 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4381 */     arg.info.replace(os);
/*      */     
/* 4383 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4384 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetBindRewardResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4392 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4393 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4394 */       String friendOpenid = osArgInfo.unmarshal_String("UTF-8");
/* 4395 */       int bindType = osArgInfo.unmarshal_int();
/* 4396 */       long serialNo = osArgInfo.unmarshal_long();
/* 4397 */       osArgInfo.unmarshal_int();
/* 4398 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 4400 */       GetVitalityRewardResponse response = new GetVitalityRewardResponse();
/* 4401 */       if (res.info.size() > 0)
/*      */       {
/* 4403 */         OctetsStream osRsp = new OctetsStream(res.info);
/* 4404 */         response.unmarshal(osRsp);
/*      */       }
/*      */       
/*      */ 
/* 4408 */       GetVitalityRewardDoneArg eventArg = new GetVitalityRewardDoneArg(retcode, openid, friendOpenid, bindType, serialNo, context, response);
/*      */       
/* 4410 */       TriggerEventsManger.getInstance().triggerEvent(new GetVitalityRewardDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getBindVitalityInfo(String openid, Octets context)
/*      */   {
/* 4420 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4421 */     arg.qtype = 206;
/* 4422 */     arg.data_direction = 1;
/*      */     
/* 4424 */     OctetsStream os = new OctetsStream();
/* 4425 */     os.marshal(openid, "UTF-8");
/* 4426 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4427 */     arg.info.replace(os);
/*      */     
/* 4429 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4430 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetBindVitalityInfoResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4438 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4439 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4440 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 4442 */       GetBindVitalityInfoResponse response = new GetBindVitalityInfoResponse();
/* 4443 */       if (res.info.size() > 0)
/*      */       {
/* 4445 */         OctetsStream osRsp = new OctetsStream(res.info);
/* 4446 */         response.unmarshal(osRsp);
/*      */       }
/*      */       
/*      */ 
/* 4450 */       GetBindVitalityInfoDoneArg eventArg = new GetBindVitalityInfoDoneArg(retcode, openid, context, response);
/* 4451 */       TriggerEventsManger.getInstance().triggerEvent(new GetBindVitalityInfoDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean recallRechargeRebate(String openid, int rebate, long serialNo, int rebatePoolMax, int rebateMax, Octets context)
/*      */   {
/* 4462 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4463 */     arg.qtype = 207;
/* 4464 */     arg.data_direction = 1;
/*      */     
/* 4466 */     OctetsStream os = new OctetsStream();
/* 4467 */     os.marshal(openid, "UTF-8");
/* 4468 */     os.marshal(rebate);
/* 4469 */     os.marshal(serialNo);
/* 4470 */     os.marshal(rebatePoolMax);
/* 4471 */     os.marshal(rebateMax);
/* 4472 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4473 */     arg.info.replace(os);
/*      */     
/* 4475 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4476 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onRecallRechargeRebateResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4484 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4485 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4486 */       int rebate = osArgInfo.unmarshal_int();
/* 4487 */       long serialNo = osArgInfo.unmarshal_long();
/* 4488 */       osArgInfo.unmarshal_int();
/* 4489 */       osArgInfo.unmarshal_int();
/* 4490 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/*      */ 
/* 4493 */       RecallRechargeRebateDoneArg eventArg = new RecallRechargeRebateDoneArg(retcode, openid, rebate, serialNo, context);
/*      */       
/* 4495 */       TriggerEventsManger.getInstance().triggerEvent(new RecallRechargeRebateDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getRecallRebate(String openid, int num, long serialNo, int dailyMax, Octets context)
/*      */   {
/* 4506 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4507 */     arg.qtype = 208;
/* 4508 */     arg.data_direction = 1;
/*      */     
/* 4510 */     OctetsStream os = new OctetsStream();
/* 4511 */     os.marshal(openid, "UTF-8");
/* 4512 */     os.marshal(num);
/* 4513 */     os.marshal(serialNo);
/* 4514 */     os.marshal(dailyMax);
/* 4515 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4516 */     arg.info.replace(os);
/*      */     
/* 4518 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4519 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetRecallRebateResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4527 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4528 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4529 */       int num = osArgInfo.unmarshal_int();
/* 4530 */       long serialNo = osArgInfo.unmarshal_long();
/* 4531 */       osArgInfo.unmarshal_int();
/* 4532 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 4534 */       GetRecallRebateResponse response = new GetRecallRebateResponse();
/* 4535 */       if (res.info.size() > 0)
/*      */       {
/* 4537 */         OctetsStream os = new OctetsStream(res.info);
/* 4538 */         response.unmarshal(os);
/*      */       }
/*      */       
/*      */ 
/* 4542 */       GetRecallRebateDoneArg eventArg = new GetRecallRebateDoneArg(retcode, openid, num, serialNo, context, response);
/*      */       
/* 4544 */       TriggerEventsManger.getInstance().triggerEvent(new GetRecallRebateDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getRecallRebateInfo(String openid, Octets context)
/*      */   {
/* 4554 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4555 */     arg.qtype = 209;
/* 4556 */     arg.data_direction = 1;
/*      */     
/* 4558 */     OctetsStream os = new OctetsStream();
/* 4559 */     os.marshal(openid, "UTF-8");
/* 4560 */     os.marshal(context == null ? Octets.EMPTY_OCTETS : context);
/* 4561 */     arg.info.replace(os);
/*      */     
/* 4563 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4564 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetRecallRebateInfoResponse(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4572 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4573 */       String openid = osArgInfo.unmarshal_String("UTF-8");
/* 4574 */       Octets context = osArgInfo.unmarshal_Octets();
/*      */       
/* 4576 */       GetRecallRebateResponse response = new GetRecallRebateResponse();
/* 4577 */       if (res.info.size() > 0)
/*      */       {
/* 4579 */         OctetsStream os = new OctetsStream(res.info);
/* 4580 */         response.unmarshal(os);
/*      */       }
/*      */       
/* 4583 */       GetRecallRebateInfoDoneArg eventArg = new GetRecallRebateInfoDoneArg(retcode, openid, context, response);
/* 4584 */       TriggerEventsManger.getInstance().triggerEvent(new GetRecallRebateInfoDone(), eventArg);
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getIndianaNumber(int activityCfgid, int turn, int sortid, int initAwardNum, int extraAwardNeedNum, long roleid, boolean canGetSpecialNumber)
/*      */   {
/* 4595 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4596 */     arg.qtype = 220;
/* 4597 */     arg.data_direction = 1;
/*      */     
/* 4599 */     OctetsStream os = new OctetsStream();
/* 4600 */     os.marshal(activityCfgid);
/* 4601 */     os.marshal(turn);
/* 4602 */     os.marshal(sortid);
/* 4603 */     os.marshal(initAwardNum);
/* 4604 */     os.marshal(extraAwardNeedNum);
/* 4605 */     os.marshal(roleid);
/* 4606 */     os.marshal(canGetSpecialNumber);
/* 4607 */     arg.info.replace(os);
/*      */     
/* 4609 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4610 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onGetIndianaNumber(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4617 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4618 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 4619 */       int turn = osArgInfo.unmarshal_int();
/* 4620 */       int sortid = osArgInfo.unmarshal_int();
/*      */       
/* 4622 */       int initAwardNum = osArgInfo.unmarshal_int();
/*      */       
/* 4624 */       int extraAwardNeedNum = osArgInfo.unmarshal_int();
/* 4625 */       long roleid = osArgInfo.unmarshal_long();
/*      */       
/* 4627 */       boolean canGetSpecialNumber = osArgInfo.unmarshal_boolean();
/*      */       
/* 4629 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.grc.event.GetIndianaNumberDone(), new GetIndianaNumberDoneArg(retcode, activityCfgid, turn, sortid, roleid, res.info), IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean confirmIndianaNumber(int activityCfgid, int turn, int sortid, long roleid, int number)
/*      */   {
/* 4642 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4643 */     arg.qtype = 221;
/* 4644 */     arg.data_direction = 1;
/*      */     
/* 4646 */     OctetsStream os = new OctetsStream();
/* 4647 */     os.marshal(activityCfgid);
/* 4648 */     os.marshal(turn);
/* 4649 */     os.marshal(sortid);
/* 4650 */     os.marshal(roleid);
/* 4651 */     os.marshal(number);
/* 4652 */     arg.info.replace(os);
/*      */     
/* 4654 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4655 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onConfirmIndianaNumber(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4662 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4663 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 4664 */       int turn = osArgInfo.unmarshal_int();
/* 4665 */       int sortid = osArgInfo.unmarshal_int();
/* 4666 */       long roleid = osArgInfo.unmarshal_long();
/* 4667 */       int number = osArgInfo.unmarshal_int();
/*      */       
/* 4669 */       TriggerEventsManger.getInstance().triggerEvent(new ConfirmIndianaNumberDone(), new ConfirmIndianaNumberDoneArg(retcode, activityCfgid, turn, sortid, roleid, number), IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getAttendIndianaNum(int activityCfgid, int turn, int sortid)
/*      */   {
/* 4681 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4682 */     arg.qtype = 222;
/* 4683 */     arg.data_direction = 1;
/*      */     
/* 4685 */     OctetsStream os = new OctetsStream();
/* 4686 */     os.marshal(activityCfgid);
/* 4687 */     os.marshal(turn);
/* 4688 */     os.marshal(sortid);
/* 4689 */     arg.info.replace(os);
/*      */     
/* 4691 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4692 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */   static void onGetAttendIndianaNum(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4699 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4700 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 4701 */       int turn = osArgInfo.unmarshal_int();
/* 4702 */       int sortid = osArgInfo.unmarshal_int();
/*      */       
/* 4704 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.grc.event.GetAttendIndianaNumDone(), new GetAttendIndianaNumDoneArg(retcode, activityCfgid, turn, sortid, res.info), IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getIndianaAwardNumber(int activityCfgid, int turn, int sortid)
/*      */   {
/* 4716 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4717 */     arg.qtype = 223;
/* 4718 */     arg.data_direction = 1;
/*      */     
/* 4720 */     OctetsStream os = new OctetsStream();
/* 4721 */     os.marshal(activityCfgid);
/* 4722 */     os.marshal(turn);
/* 4723 */     os.marshal(sortid);
/* 4724 */     arg.info.replace(os);
/*      */     
/* 4726 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4727 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetIndianaAwardNumber(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4735 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4736 */       int activityCfgid = osArgInfo.unmarshal_int();
/* 4737 */       int turn = osArgInfo.unmarshal_int();
/* 4738 */       int sortid = osArgInfo.unmarshal_int();
/*      */       
/* 4740 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.grc.event.GetIndianaAwardNumberDone(), new GetIndianaAwardNumberDoneArg(retcode, activityCfgid, turn, sortid, res.info), IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean getAllLottoAwardRoleInfo(int activityCfgid, List<Integer> turns)
/*      */   {
/* 4752 */     DataBetweenGameAndGrcArg arg = new DataBetweenGameAndGrcArg();
/* 4753 */     arg.qtype = 230;
/* 4754 */     arg.data_direction = 1;
/*      */     
/* 4756 */     OctetsStream os = new OctetsStream();
/* 4757 */     os.marshal(activityCfgid);
/* 4758 */     os.compact_uint32(turns.size());
/* 4759 */     for (Iterator i$ = turns.iterator(); i$.hasNext();) { int turn = ((Integer)i$.next()).intValue();
/*      */       
/* 4761 */       os.marshal(turn);
/*      */     }
/* 4763 */     arg.info.replace(os);
/*      */     
/* 4765 */     DataBetweenGameAndGrc rpc = new DataBetweenGameAndGrc(arg);
/* 4766 */     return GDeliveryManager.getInstance().send(rpc);
/*      */   }
/*      */   
/*      */ 
/*      */   static void onGetAllLottoAwardRoleInfo(int retcode, DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4774 */       OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4775 */       int activityCfgid = osArgInfo.unmarshal_int();
/*      */       
/* 4777 */       TriggerEventsManger.getInstance().triggerEvent(new GetAllLottoAwardRoleInfoDone(), new mzm.gsp.grc.event.GetAllLottoAwardRoleInfoDoneArg(retcode, activityCfgid, res.info), AllLottoOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)));
/*      */     }
/*      */     catch (MarshalException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onDataBetweenGameAndGrcResponse(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 4791 */       if (arg.qtype == 1)
/*      */       {
/* 4793 */         OctetsStream os = new OctetsStream(arg.info);
/* 4794 */         long roleid = os.unmarshal_long();
/* 4795 */         int giftType = os.unmarshal_int();
/* 4796 */         byte onOff = os.unmarshal_byte();
/*      */         
/* 4798 */         SGrcTurnOnOffResp resp = new SGrcTurnOnOffResp();
/* 4799 */         resp.retcode = res.retcode;
/* 4800 */         resp.gift_type = giftType;
/* 4801 */         resp.onoff = onOff;
/* 4802 */         OnlineManager.getInstance().send(roleid, resp);
/*      */       }
/* 4804 */       else if (arg.qtype == 2)
/*      */       {
/* 4806 */         OctetsStream osArgInfo = new OctetsStream(arg.info);
/* 4807 */         long roleid = osArgInfo.unmarshal_long();
/* 4808 */         int vipFlag = osArgInfo.unmarshal_int();
/* 4809 */         byte isNew = osArgInfo.unmarshal_byte();
/*      */         
/* 4811 */         if (res.retcode != 0)
/*      */         {
/* 4813 */           SReportQQVipPayInfoResp resp = new SReportQQVipPayInfoResp();
/* 4814 */           resp.retcode = res.retcode;
/* 4815 */           resp.vip_flag = vipFlag;
/* 4816 */           resp.is_new = isNew;
/* 4817 */           OnlineManager.getInstance().sendAtOnce(roleid, resp);
/*      */         }
/*      */         
/* 4820 */         Map<Integer, grc.QQVipInfo> qqVipInfos = new HashMap();
/* 4821 */         OctetsStream osResInfo = new OctetsStream(res.info);
/* 4822 */         for (int size = osResInfo.uncompact_uint32(); size > 0; size--)
/*      */         {
/* 4824 */           int k = osResInfo.unmarshal_int();
/* 4825 */           grc.QQVipInfo v = new grc.QQVipInfo();
/* 4826 */           v.unmarshal(osResInfo);
/* 4827 */           qqVipInfos.put(Integer.valueOf(k), v);
/*      */         }
/* 4829 */         new POnCheckQQVipPlayInfo(roleid, vipFlag, isNew, qqVipInfos).execute();
/*      */       }
/* 4831 */       else if (arg.qtype == 5)
/*      */       {
/* 4833 */         new POnGenInviteCodeResp(arg, res).call();
/*      */       }
/* 4835 */       else if (arg.qtype == 6)
/*      */       {
/* 4837 */         new POnUseInviteCodeResp(arg, res).call();
/*      */       }
/* 4839 */       else if (arg.qtype == 7)
/*      */       {
/* 4841 */         new POnAddInviteFriendsRebateBindYuanbaoResp(arg, res).call();
/*      */       }
/* 4843 */       else if (arg.qtype == 8)
/*      */       {
/* 4845 */         new POnAddInviteFriendsGiftTimesResp(arg, res).call();
/*      */       }
/* 4847 */       else if (arg.qtype == 9)
/*      */       {
/* 4849 */         new POnGetInviteFriendsRebateBindYuanbaoResp(arg, res).call();
/*      */       }
/* 4851 */       else if (arg.qtype == 10)
/*      */       {
/* 4853 */         new POnGetInviteFriendsGiftTimesResp(arg, res).call();
/*      */       }
/* 4855 */       else if (arg.qtype == 11)
/*      */       {
/* 4857 */         new POnGetInviteFriendsInfoResp(arg, res).call();
/*      */       }
/* 4859 */       else if (arg.qtype == 20)
/*      */       {
/* 4861 */         onAntiAddictProxyDone(res.retcode, arg, res);
/*      */       }
/* 4863 */       else if (arg.qtype == 26)
/*      */       {
/* 4865 */         onReportFightRecordDone(res.retcode, arg, res);
/*      */       }
/* 4867 */       else if (arg.qtype == 27)
/*      */       {
/* 4869 */         onGetFightRecordDone(res.retcode, arg, res);
/*      */       }
/* 4871 */       else if (arg.qtype == 48)
/*      */       {
/* 4873 */         onCleanRankInfoDone(res.retcode, arg, res);
/*      */       }
/* 4875 */       else if (arg.qtype == 49)
/*      */       {
/* 4877 */         onRemoveRankInfoDone(res.retcode, arg, res);
/*      */       }
/* 4879 */       else if (arg.qtype == 50)
/*      */       {
/* 4881 */         onReportRankInfoDone(res.retcode, arg, res);
/*      */       }
/* 4883 */       else if (arg.qtype == 51)
/*      */       {
/* 4885 */         onGetRankDone(res.retcode, arg, res);
/*      */       }
/* 4887 */       else if (arg.qtype == 52)
/*      */       {
/* 4889 */         onGetRankRangeDone(res.retcode, arg, res);
/*      */       }
/* 4891 */       else if (arg.qtype == 53)
/*      */       {
/* 4893 */         onReportCrossBattleOwnResult(res.retcode, arg, res);
/*      */       }
/* 4895 */       else if (arg.qtype == 54)
/*      */       {
/* 4897 */         onClearCrossBattleOwnResult(res.retcode, arg, res);
/*      */       }
/* 4899 */       else if (arg.qtype == 55)
/*      */       {
/* 4901 */         onGetCorpsZoneDone(res.retcode, arg, res);
/*      */       }
/* 4903 */       else if (arg.qtype == 56)
/*      */       {
/* 4905 */         onReportCorpsPointRaceDone(res.retcode, arg, res);
/*      */       }
/* 4907 */       else if (arg.qtype == 57)
/*      */       {
/* 4909 */         onGetZonePointRaceDone(res.retcode, arg, res);
/*      */       }
/* 4911 */       else if (arg.qtype == 58)
/*      */       {
/* 4913 */         onRemovePointRaceDone(res.retcode, arg, res);
/*      */       }
/* 4915 */       else if (arg.qtype == 61)
/*      */       {
/* 4917 */         onGetCrossBattleKnockoutStageBetInfo(res.retcode, arg, res);
/*      */       }
/* 4919 */       else if (arg.qtype == 62)
/*      */       {
/* 4921 */         onReportRoleCrossBattleKnockoutBetInfo(res.retcode, arg, res);
/*      */       }
/* 4923 */       else if (arg.qtype == 100)
/*      */       {
/* 4925 */         onGetCrossBattleKnockOut(res.retcode, arg, res);
/*      */       }
/* 4927 */       else if (arg.qtype == 101)
/*      */       {
/* 4929 */         onReportKnockOutFightResult(res.retcode, arg, res);
/*      */       }
/* 4931 */       else if (arg.qtype == 102)
/*      */       {
/* 4933 */         onReportKnockOutFightBeginRes(res.retcode, arg, res);
/*      */       }
/* 4935 */       else if (arg.qtype == 103)
/*      */       {
/* 4937 */         onGetNotifyKnockOutCorpsIdList(res.retcode, arg, res);
/*      */       }
/* 4939 */       else if (arg.qtype == 104)
/*      */       {
/* 4941 */         onGmSetSelectionCorpsInfo(res.retcode, arg, res);
/*      */       }
/* 4943 */       else if (arg.qtype == 105)
/*      */       {
/* 4945 */         onGetCrossBattleKnockOutOwnServerInfo(res.retcode, arg, res);
/*      */       }
/* 4947 */       else if (arg.qtype == 106)
/*      */       {
/* 4949 */         onGmSetFinalCorpsInfo(res.retcode, arg, res);
/*      */       }
/* 4951 */       else if (arg.qtype == 107)
/*      */       {
/* 4953 */         onClearKnockOutDataResponse(res.retcode, arg, res);
/*      */       }
/* 4955 */       else if (arg.qtype == 108)
/*      */       {
/* 4957 */         onInitKnockOutFirstRoundData(res.retcode, arg, res);
/*      */       }
/* 4959 */       else if (arg.qtype == 109)
/*      */       {
/* 4961 */         onGetNotifyKnockOutRestartCorpsIdResponse(res.retcode, arg, res);
/*      */       }
/* 4963 */       else if (arg.qtype == 112)
/*      */       {
/* 4965 */         onGetCrossBattleCorpsInfo(res.retcode, arg, res);
/*      */       }
/* 4967 */       else if (arg.qtype == 113)
/*      */       {
/* 4969 */         onGetKnockOutQualificationCorpsIdList(res.retcode, arg, res);
/*      */       }
/* 4971 */       else if (arg.qtype == 115)
/*      */       {
/* 4973 */         onGetCrossBattleStageFightEndCorpsInfo(res.retcode, arg, res);
/*      */       }
/* 4975 */       else if (arg.qtype == 200)
/*      */       {
/* 4977 */         onReportRoleBasicInfoResponse(res.retcode, arg, res);
/*      */       }
/* 4979 */       else if (arg.qtype == 201)
/*      */       {
/* 4981 */         onRecallFriendResponse(res.retcode, arg, res);
/*      */       }
/* 4983 */       else if (arg.qtype == 202)
/*      */       {
/* 4985 */         onBindFriendResponse(res.retcode, arg, res);
/*      */       }
/* 4987 */       else if (arg.qtype == 203)
/*      */       {
/* 4989 */         onBindMailResponse(res.retcode, arg, res);
/*      */       }
/* 4991 */       else if (arg.qtype == 204)
/*      */       {
/* 4993 */         onUpdateRoleVitalityInfoResponse(res.retcode, arg, res);
/*      */       }
/* 4995 */       else if (arg.qtype == 205)
/*      */       {
/* 4997 */         onGetBindRewardResponse(res.retcode, arg, res);
/*      */       }
/* 4999 */       else if (arg.qtype == 206)
/*      */       {
/* 5001 */         onGetBindVitalityInfoResponse(res.retcode, arg, res);
/*      */       }
/* 5003 */       else if (arg.qtype == 207)
/*      */       {
/* 5005 */         onRecallRechargeRebateResponse(res.retcode, arg, res);
/*      */       }
/* 5007 */       else if (arg.qtype == 208)
/*      */       {
/* 5009 */         onGetRecallRebateResponse(res.retcode, arg, res);
/*      */       }
/* 5011 */       else if (arg.qtype == 209)
/*      */       {
/* 5013 */         onGetRecallRebateInfoResponse(res.retcode, arg, res);
/*      */       }
/* 5015 */       else if (arg.qtype == 210)
/*      */       {
/* 5017 */         onBackResponse(res.retcode, arg, res);
/*      */       }
/* 5019 */       else if (arg.qtype == 220)
/*      */       {
/* 5021 */         onGetIndianaNumber(res.retcode, arg, res);
/*      */       }
/* 5023 */       else if (arg.qtype == 221)
/*      */       {
/* 5025 */         onConfirmIndianaNumber(res.retcode, arg, res);
/*      */       }
/* 5027 */       else if (arg.qtype == 222)
/*      */       {
/* 5029 */         onGetAttendIndianaNum(res.retcode, arg, res);
/*      */       }
/* 5031 */       else if (arg.qtype == 223)
/*      */       {
/* 5033 */         onGetIndianaAwardNumber(res.retcode, arg, res);
/*      */       }
/* 5035 */       else if (arg.qtype == 230)
/*      */       {
/* 5037 */         onGetAllLottoAwardRoleInfo(res.retcode, arg, res);
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */       try
/*      */       {
/* 5044 */         GameServer.logger().error(String.format("[grc]GrcManager.onDataBetweenGameAndGrcResponse@handle response failed|retcode=%d|openid=%s|channel=%s|qtype=%d|data_direction=%d|arg_info=%s|res_info=%s", new Object[] { Integer.valueOf(res.retcode), arg.openid.getString("UTF-8"), arg.channel.getString("UTF-8"), Integer.valueOf(arg.qtype), Byte.valueOf(arg.data_direction), octetsToString(arg.info), octetsToString(res.info) }), e);
/*      */       }
/*      */       catch (Exception ex) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onDataBetweenGameAndGrcTimeout(DataBetweenGameAndGrcArg arg, DataBetweenGameAndGrcRes res)
/*      */   {
/*      */     try
/*      */     {
/* 5061 */       GameServer.logger().error(String.format("[grc]GrcManager.onDataBetweenGameAndGrcTimeout@timeout|retcode=%d|openid=%s|channel=%s|qtype=%d|data_direction=%d|arg_info=%s", new Object[] { Integer.valueOf(res.retcode), arg.openid.getString("UTF-8"), arg.channel.getString("UTF-8"), Integer.valueOf(arg.qtype), Byte.valueOf(arg.data_direction), octetsToString(arg.info) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 5067 */       if (arg.qtype == 20)
/*      */       {
/* 5069 */         onAntiAddictProxyDone(8, arg, res);
/*      */       }
/* 5071 */       else if (arg.qtype == 26)
/*      */       {
/* 5073 */         onReportFightRecordDone(8, arg, res);
/*      */       }
/* 5075 */       else if (arg.qtype == 27)
/*      */       {
/* 5077 */         onGetFightRecordDone(8, arg, res);
/*      */       }
/* 5079 */       else if (arg.qtype == 48)
/*      */       {
/* 5081 */         onCleanRankInfoDone(8, arg, res);
/*      */       }
/* 5083 */       else if (arg.qtype == 49)
/*      */       {
/* 5085 */         onRemoveRankInfoDone(8, arg, res);
/*      */       }
/* 5087 */       else if (arg.qtype == 50)
/*      */       {
/* 5089 */         onReportRankInfoDone(8, arg, res);
/*      */       }
/* 5091 */       else if (arg.qtype == 51)
/*      */       {
/* 5093 */         onGetRankDone(8, arg, res);
/*      */       }
/* 5095 */       else if (arg.qtype == 52)
/*      */       {
/* 5097 */         onGetRankRangeDone(8, arg, res);
/*      */       }
/* 5099 */       else if (arg.qtype == 53)
/*      */       {
/* 5101 */         onReportCrossBattleOwnResult(8, arg, res);
/*      */       }
/* 5103 */       else if (arg.qtype == 54)
/*      */       {
/* 5105 */         onClearCrossBattleOwnResult(8, arg, res);
/*      */       }
/* 5107 */       else if (arg.qtype == 55)
/*      */       {
/* 5109 */         onGetCorpsZoneDone(8, arg, res);
/*      */       }
/* 5111 */       else if (arg.qtype == 56)
/*      */       {
/* 5113 */         onReportCorpsPointRaceDone(8, arg, res);
/*      */       }
/* 5115 */       else if (arg.qtype == 57)
/*      */       {
/* 5117 */         onGetZonePointRaceDone(8, arg, res);
/*      */       }
/* 5119 */       else if (arg.qtype == 58)
/*      */       {
/* 5121 */         onRemovePointRaceDone(8, arg, res);
/*      */       }
/* 5123 */       else if (arg.qtype == 61)
/*      */       {
/* 5125 */         onGetCrossBattleKnockoutStageBetInfo(8, arg, res);
/*      */       }
/* 5127 */       else if (arg.qtype == 62)
/*      */       {
/* 5129 */         onReportRoleCrossBattleKnockoutBetInfo(8, arg, res);
/*      */       }
/* 5131 */       else if (arg.qtype == 100)
/*      */       {
/* 5133 */         onGetCrossBattleKnockOut(res.retcode, arg, res);
/*      */       }
/* 5135 */       else if (arg.qtype == 101)
/*      */       {
/* 5137 */         onReportKnockOutFightResult(res.retcode, arg, res);
/*      */       }
/* 5139 */       else if (arg.qtype == 102)
/*      */       {
/* 5141 */         onReportKnockOutFightBeginRes(res.retcode, arg, res);
/*      */       }
/* 5143 */       else if (arg.qtype == 103)
/*      */       {
/* 5145 */         onGetNotifyKnockOutCorpsIdList(res.retcode, arg, res);
/*      */       }
/* 5147 */       else if (arg.qtype == 104)
/*      */       {
/* 5149 */         onGmSetSelectionCorpsInfoTimeout(res.retcode, arg, res);
/*      */       }
/* 5151 */       else if (arg.qtype == 107)
/*      */       {
/* 5153 */         onClearKnockOutDataResponse(res.retcode, arg, res);
/*      */       }
/* 5155 */       else if (arg.qtype == 108)
/*      */       {
/* 5157 */         onInitKnockOutFirstRoundData(res.retcode, arg, res);
/*      */       }
/* 5159 */       else if (arg.qtype == 109)
/*      */       {
/* 5161 */         onGetNotifyKnockOutRestartCorpsIdResponse(res.retcode, arg, res);
/*      */       }
/* 5163 */       else if (arg.qtype == 112)
/*      */       {
/* 5165 */         onGetCrossBattleCorpsInfo(res.retcode, arg, res);
/*      */       }
/* 5167 */       else if (arg.qtype == 115)
/*      */       {
/* 5169 */         onGetCrossBattleStageFightEndCorpsInfo(res.retcode, arg, res);
/*      */       }
/* 5171 */       else if (arg.qtype == 200)
/*      */       {
/* 5173 */         onReportRoleBasicInfoResponse(8, arg, res);
/*      */       }
/* 5175 */       else if (arg.qtype == 201)
/*      */       {
/* 5177 */         onRecallFriendResponse(8, arg, res);
/*      */       }
/* 5179 */       else if (arg.qtype == 202)
/*      */       {
/* 5181 */         onBindFriendResponse(8, arg, res);
/*      */       }
/* 5183 */       else if (arg.qtype == 203)
/*      */       {
/* 5185 */         onBindMailResponse(8, arg, res);
/*      */       }
/* 5187 */       else if (arg.qtype == 204)
/*      */       {
/* 5189 */         onUpdateRoleVitalityInfoResponse(8, arg, res);
/*      */       }
/* 5191 */       else if (arg.qtype == 205)
/*      */       {
/* 5193 */         onGetBindRewardResponse(8, arg, res);
/*      */       }
/* 5195 */       else if (arg.qtype == 206)
/*      */       {
/* 5197 */         onGetBindVitalityInfoResponse(8, arg, res);
/*      */       }
/* 5199 */       else if (arg.qtype == 207)
/*      */       {
/* 5201 */         onRecallRechargeRebateResponse(8, arg, res);
/*      */       }
/* 5203 */       else if (arg.qtype == 208)
/*      */       {
/* 5205 */         onGetRecallRebateResponse(8, arg, res);
/*      */       }
/* 5207 */       else if (arg.qtype == 209)
/*      */       {
/* 5209 */         onGetRecallRebateInfoResponse(8, arg, res);
/*      */       }
/* 5211 */       else if (arg.qtype == 210)
/*      */       {
/* 5213 */         onBackResponse(8, arg, res);
/*      */       }
/* 5215 */       else if (arg.qtype == 220)
/*      */       {
/* 5217 */         onGetIndianaNumber(8, arg, res);
/*      */       }
/* 5219 */       else if (arg.qtype == 221)
/*      */       {
/* 5221 */         onConfirmIndianaNumber(8, arg, res);
/*      */       }
/* 5223 */       else if (arg.qtype == 222)
/*      */       {
/* 5225 */         onGetAttendIndianaNum(8, arg, res);
/*      */       }
/* 5227 */       else if (arg.qtype == 223)
/*      */       {
/* 5229 */         onGetIndianaAwardNumber(8, arg, res);
/*      */       }
/* 5231 */       else if (arg.qtype == 230)
/*      */       {
/* 5233 */         onGetAllLottoAwardRoleInfo(8, arg, res);
/*      */       }
/*      */     }
/*      */     catch (Exception e) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static String octetsToString(Octets octets)
/*      */   {
/* 5244 */     return CommonUtils.bytesToHexString(octets.array(), 0, octets.size());
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\GrcManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */