/*     */ package mzm.gsp.loginaward.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.loginaward.LoginActivityInfo;
/*     */ import mzm.gsp.loginaward.SLoginActivityInfos;
/*     */ import mzm.gsp.loginaward.confbean.SLoginActivityAwardCfg;
/*     */ import mzm.gsp.loginaward.confbean.SLoginActivityAwardInfo;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LoginActivityInfos;
/*     */ import xbean.LoginInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2loginactivity;
/*     */ 
/*     */ public class LoginActivityManager
/*     */ {
/*     */   static final boolean isFunOpen(long roleId, boolean send)
/*     */   {
/*  38 */     if (!OpenInterface.getOpenStatus(153))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (OpenInterface.isBanPlay(roleId, 153))
/*     */     {
/*  44 */       if (send)
/*     */       {
/*  46 */         OpenInterface.sendBanPlayMsg(roleId, 153);
/*     */       }
/*  48 */       return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   static final void init()
/*     */   {
/*  55 */     ActivityInterface.registerActivityByLogicType(54, new LoginActivityHandler(), false);
/*     */   }
/*     */   
/*     */   static final void initData(String userid, long roleId, int activityid)
/*     */   {
/*  60 */     LoginActivityInfos xLoginActivityInfos = Role2loginactivity.get(Long.valueOf(roleId));
/*  61 */     if (xLoginActivityInfos == null)
/*     */     {
/*  63 */       xLoginActivityInfos = Pod.newLoginActivityInfos();
/*  64 */       Role2loginactivity.insert(Long.valueOf(roleId), xLoginActivityInfos);
/*     */     }
/*     */     
/*  67 */     LoginInfo xLoginInfo = (LoginInfo)xLoginActivityInfos.getLogin_infos().get(Integer.valueOf(activityid));
/*  68 */     if (xLoginInfo == null)
/*     */     {
/*  70 */       xLoginInfo = Pod.newLoginInfo();
/*  71 */       xLoginActivityInfos.getLogin_infos().put(Integer.valueOf(activityid), xLoginInfo);
/*     */     }
/*     */     else
/*     */     {
/*  75 */       handleOnline(xLoginInfo, activityid);
/*  76 */       sendAwardMailIfNeed(userid, roleId, activityid, xLoginInfo);
/*  77 */       GameServer.logger().warn("[loginaward]LoginActivityManager.initData@initdata again");
/*     */     }
/*  79 */     initXLoginInfo(xLoginInfo, activityid);
/*     */     
/*  81 */     GameServer.logger().info(String.format("[loginaward]LoginActivityManager.initData@initdata|userid=%s|roleid=%d|activity_cfgid=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(activityid) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void initXLoginInfo(LoginInfo xLoginInfo, int activityCfgId)
/*     */   {
/*  88 */     xLoginInfo.setLast_time(0L);
/*  89 */     xLoginInfo.getSortids().clear();
/*  90 */     xLoginInfo.getUnreceivedsortids().clear();
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogin(String userId, long roleId)
/*     */   {
/*  95 */     if (!isFunOpen(roleId, false))
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     SLoginActivityInfos msg = new SLoginActivityInfos();
/* 101 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 102 */     for (SLoginActivityAwardCfg cfg : SLoginActivityAwardCfg.getAll().values())
/*     */     {
/* 104 */       int activityCfgid = cfg.id;
/* 105 */       ActivityLimitTimeStageEnum result = ActivityInterface.getActivityLimitTimeStage(activityCfgid, now);
/* 106 */       if ((result == ActivityLimitTimeStageEnum.CFG_ERROR) || (result == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER))
/*     */       {
/* 108 */         LoginInfo xLoginInfo = getLoginInfo(roleId, activityCfgid);
/* 109 */         if (xLoginInfo != null)
/*     */         {
/*     */ 
/* 112 */           sendAwardMailIfNeed(userId, roleId, activityCfgid, xLoginInfo);
/* 113 */           removeLoginInfo(roleId, activityCfgid);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 118 */       else if (ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/* 122 */         LoginInfo xLoginInfo = getLoginInfo(roleId, activityCfgid);
/* 123 */         if (xLoginInfo != null)
/*     */         {
/*     */ 
/*     */ 
/* 127 */           calculateDiffDaysLogin(xLoginInfo, cfg);
/*     */           
/* 129 */           LoginActivityInfo info = new LoginActivityInfo();
/* 130 */           boxLoginActivityInfo(xLoginInfo, info);
/* 131 */           msg.activityinfos.put(Integer.valueOf(activityCfgid), info);
/*     */         } } }
/* 133 */     if (msg.activityinfos.size() > 0)
/*     */     {
/* 135 */       OnlineManager.getInstance().send(roleId, msg);
/*     */     }
/*     */     
/* 138 */     return true;
/*     */   }
/*     */   
/*     */   private static final void boxLoginActivityInfo(LoginInfo xLoginInfo, LoginActivityInfo info)
/*     */   {
/* 143 */     info.sortids.addAll(xLoginInfo.getSortids());
/*     */   }
/*     */   
/*     */   private static void calculateDiffDaysLogin(LoginInfo xLoginInfo, SLoginActivityAwardCfg cfg)
/*     */   {
/* 148 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 149 */     long lastTime = xLoginInfo.getLast_time();
/* 150 */     if (DateTimeUtils.diffDays(now, lastTime) > 0)
/*     */     {
/* 152 */       int activityCfgid = cfg.id;
/*     */       
/* 154 */       long startTime = ActivityInterface.getActivityStartTime(activityCfgid);
/* 155 */       int index = DateTimeUtils.diffDays(now, startTime) + 1;
/* 156 */       for (SLoginActivityAwardInfo awardInfo : cfg.awardInfos.values())
/*     */       {
/* 158 */         if (awardInfo.loginDay == index)
/*     */         {
/* 160 */           xLoginInfo.getUnreceivedsortids().add(Integer.valueOf(awardInfo.sortId));
/* 161 */           break;
/*     */         }
/*     */       }
/* 164 */       xLoginInfo.setLast_time(now);
/*     */     }
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogoff(String userId, long roleId)
/*     */   {
/* 170 */     if (!isFunOpen(roleId, false))
/*     */     {
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 176 */     for (SLoginActivityAwardCfg cfg : SLoginActivityAwardCfg.getAll().values())
/*     */     {
/* 178 */       int activityCfgid = cfg.id;
/*     */       
/* 180 */       ActivityLimitTimeStageEnum result = ActivityInterface.getActivityLimitTimeStage(activityCfgid, now);
/* 181 */       if (result == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER)
/*     */       {
/* 183 */         long endTime = ActivityInterface.getActivityEndTime(activityCfgid);
/* 184 */         LoginInfo xLoginInfo = getLoginInfo(roleId, activityCfgid);
/* 185 */         if (xLoginInfo != null)
/*     */         {
/*     */ 
/* 188 */           calculateDiffDays(xLoginInfo, cfg, endTime);
/* 189 */           sendAwardMailIfNeed(userId, roleId, activityCfgid, xLoginInfo);
/* 190 */           removeLoginInfo(roleId, activityCfgid);
/*     */         }
/*     */         else
/*     */         {
/* 194 */           long loginTime = RoleInterface.getLastLoginTime(roleId);
/* 195 */           long activityStartTime = ActivityInterface.getActivityStartTime(activityCfgid);
/* 196 */           if (loginTime <= activityStartTime)
/*     */           {
/*     */ 
/* 199 */             LoginInfo xTmpLoginInfo = Pod.newLoginInfo();
/* 200 */             calculateDiffDays(xTmpLoginInfo, cfg, endTime);
/* 201 */             sendAwardMailIfNeed(userId, roleId, activityCfgid, xTmpLoginInfo);
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 208 */       else if (ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/* 212 */         LoginInfo xLoginInfo = getLoginInfo(roleId, activityCfgid);
/* 213 */         if (xLoginInfo != null)
/*     */         {
/*     */ 
/*     */ 
/* 217 */           calculateDiffDays(xLoginInfo, cfg, now); }
/*     */       } }
/* 219 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static final void calculateDiffDays(LoginInfo xLoginInfo, SLoginActivityAwardCfg cfg, long time)
/*     */   {
/* 225 */     long lastTime = xLoginInfo.getLast_time();
/* 226 */     if (DateTimeUtils.diffDays(time, lastTime) == 0)
/*     */     {
/* 228 */       return;
/*     */     }
/*     */     
/*     */ 
/* 232 */     int activityCfgid = cfg.id;
/* 233 */     long startTime = ActivityInterface.getActivityStartTime(activityCfgid);
/* 234 */     int startIndex = 0;
/* 235 */     if (lastTime == 0L)
/*     */     {
/* 237 */       startIndex = 1;
/*     */     }
/*     */     else
/*     */     {
/* 241 */       startIndex = DateTimeUtils.diffDays(lastTime, startTime) + 1;
/*     */     }
/* 243 */     int endIndex = DateTimeUtils.diffDays(time, startTime) + 1;
/*     */     
/* 245 */     for (SLoginActivityAwardInfo awardInfo : cfg.awardInfos.values())
/*     */     {
/* 247 */       if ((awardInfo.loginDay >= startIndex) && (awardInfo.loginDay <= endIndex))
/*     */       {
/* 249 */         if (!xLoginInfo.getSortids().contains(Integer.valueOf(awardInfo.sortId)))
/*     */         {
/* 251 */           xLoginInfo.getUnreceivedsortids().add(Integer.valueOf(awardInfo.sortId));
/*     */         }
/*     */       }
/*     */     }
/* 255 */     xLoginInfo.setLast_time(time);
/*     */   }
/*     */   
/*     */   static final int getAward(String userId, long roleId, int activityCfgId, int sortId)
/*     */   {
/* 260 */     SLoginActivityAwardCfg loginActivityAwardCfg = SLoginActivityAwardCfg.get(activityCfgId);
/* 261 */     if (loginActivityAwardCfg == null)
/*     */     {
/* 263 */       return 1;
/*     */     }
/*     */     
/* 266 */     SLoginActivityAwardInfo awardInfo = (SLoginActivityAwardInfo)loginActivityAwardCfg.awardInfos.get(Integer.valueOf(sortId));
/* 267 */     if (awardInfo == null)
/*     */     {
/* 269 */       return 2;
/*     */     }
/*     */     
/* 272 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityCfgId).isCanJoin())
/*     */     {
/* 274 */       return -1;
/*     */     }
/*     */     
/* 277 */     LoginInfo xLoginInfo = getLoginInfo(roleId, activityCfgId);
/* 278 */     if (xLoginInfo == null)
/*     */     {
/* 280 */       return 4;
/*     */     }
/*     */     
/* 283 */     if (xLoginInfo.getSortids().contains(Integer.valueOf(sortId)))
/*     */     {
/*     */ 
/* 286 */       return -2;
/*     */     }
/*     */     
/* 289 */     long startTime = ActivityInterface.getActivityStartTime(activityCfgId);
/* 290 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 291 */     int currentDay = DateTimeUtils.diffDays(now, startTime) + 1;
/*     */     
/* 293 */     if (awardInfo.loginDay != currentDay)
/*     */     {
/* 295 */       return -3;
/*     */     }
/*     */     
/* 298 */     int awardCfgid = awardInfo.awardCfgId;
/* 299 */     AwardReason loginActivityAwardReason = new AwardReason(LogReason.LOGIN_AWARD_LOGIN_DAY, awardCfgid);
/* 300 */     loginActivityAwardReason.setAwardItemBind(true);
/*     */     
/* 302 */     AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userId, roleId, true, true, loginActivityAwardReason);
/*     */     
/* 304 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 307 */       return 3;
/*     */     }
/*     */     
/*     */ 
/* 311 */     xLoginInfo.getSortids().add(Integer.valueOf(sortId));
/* 312 */     xLoginInfo.getUnreceivedsortids().remove(Integer.valueOf(sortId));
/*     */     
/* 314 */     addTlog(userId, roleId, activityCfgId, awardInfo, 1);
/* 315 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void sendAwardMailIfNeed(String userid, long roleId, int activityCfgId, LoginInfo xLoginInfo)
/*     */   {
/* 321 */     SLoginActivityAwardCfg loginActivityAwardCfg = SLoginActivityAwardCfg.get(activityCfgId);
/* 322 */     if (loginActivityAwardCfg == null)
/*     */     {
/* 324 */       return;
/*     */     }
/*     */     
/* 327 */     int mailCfgId = loginActivityAwardCfg.mailCfgId;
/* 328 */     if (mailCfgId <= 0)
/*     */     {
/* 330 */       return;
/*     */     }
/*     */     
/* 333 */     if (xLoginInfo.getUnreceivedsortids().isEmpty())
/*     */     {
/* 335 */       return;
/*     */     }
/*     */     
/*     */ 
/* 339 */     java.util.List<String> emptyStrings = java.util.Collections.emptyList();
/* 340 */     for (Iterator i$ = xLoginInfo.getUnreceivedsortids().iterator(); i$.hasNext();) { int sortId = ((Integer)i$.next()).intValue();
/*     */       
/* 342 */       SLoginActivityAwardInfo awardInfo = (SLoginActivityAwardInfo)loginActivityAwardCfg.awardInfos.get(Integer.valueOf(sortId));
/* 343 */       if (awardInfo == null)
/*     */       {
/* 345 */         GameServer.logger().error(String.format("[loginaward]LoginActivityManager.sendAwardMailIfNeed@login activity award info not exist|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(activityCfgId), Integer.valueOf(sortId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 351 */         int awardCfgId = awardInfo.awardCfgId;
/* 352 */         AwardReason loginActivityAwardReason = new AwardReason(LogReason.LOGIN_AWARD_LOGIN_DAY, awardCfgId);
/* 353 */         loginActivityAwardReason.setAwardItemBind(true);
/* 354 */         AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgId, roleId, loginActivityAwardReason);
/* 355 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 358 */           addTlog(userid, roleId, activityCfgId, awardInfo, 3);
/*     */         }
/*     */         else
/*     */         {
/* 362 */           MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, true);
/* 363 */           TLogArg tLogArg = new TLogArg(LogReason.LOGIN_AWARD_LOGIN_DAY, awardCfgId);
/* 364 */           SendMailRet ret = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleId, mailCfgId, emptyStrings, emptyStrings, attachment, tLogArg);
/*     */           
/*     */ 
/* 367 */           if (ret.isOK())
/*     */           {
/*     */ 
/* 370 */             addTlog(userid, roleId, activityCfgId, awardInfo, 2);
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 375 */             if (ret.getRetEnum() == mzm.gsp.mail.main.SendMailRet.RetEnum.SEND_MAIL_CFG_NOT_EXIST)
/*     */             {
/* 377 */               GameServer.logger().error(String.format("[loginaward]LoginActivityManager.sendAwardMailIfNeed@mail cfgid not exist|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|award_cfgid=%d|login_day=%d|mail_cfgid=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(activityCfgId), Integer.valueOf(awardInfo.sortId), Integer.valueOf(awardInfo.awardCfgId), Integer.valueOf(awardInfo.loginDay), Integer.valueOf(mailCfgId) }));
/*     */             }
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 386 */             addTlog(userid, roleId, activityCfgId, awardInfo, 4);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
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
/*     */   static final void addTlog(String userId, long roleId, int activityCfgId, SLoginActivityAwardInfo awardInfo, int status)
/*     */   {
/* 407 */     String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 408 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 410 */     TLogManager.getInstance().addLog(userId, "LoginActivityForServer", new Object[] { vGameIp, userId, Long.valueOf(roleId), Integer.valueOf(roleLevel), Integer.valueOf(activityCfgId), Integer.valueOf(awardInfo.sortId), Integer.valueOf(awardInfo.loginDay), Integer.valueOf(awardInfo.awardCfgId), Integer.valueOf(status) });
/*     */   }
/*     */   
/*     */ 
/*     */   private static LoginInfo getLoginInfo(long roleid, int activityCfgid)
/*     */   {
/* 416 */     LoginActivityInfos xLoginActivityInfos = Role2loginactivity.get(Long.valueOf(roleid));
/* 417 */     if (xLoginActivityInfos == null)
/*     */     {
/* 419 */       return null;
/*     */     }
/*     */     
/* 422 */     return (LoginInfo)xLoginActivityInfos.getLogin_infos().get(Integer.valueOf(activityCfgid));
/*     */   }
/*     */   
/*     */   private static boolean removeLoginInfo(long roleid, int activityCfgid)
/*     */   {
/* 427 */     LoginActivityInfos xLoginActivityInfos = Role2loginactivity.get(Long.valueOf(roleid));
/* 428 */     if (xLoginActivityInfos == null)
/*     */     {
/* 430 */       return false;
/*     */     }
/*     */     
/* 433 */     return xLoginActivityInfos.getLogin_infos().remove(Integer.valueOf(activityCfgid)) != null;
/*     */   }
/*     */   
/*     */   static final void handleOnline(LoginInfo xLoginInfo, int activityCfgId)
/*     */   {
/* 438 */     int max = -1;
/* 439 */     Set<Integer> sortIds = xLoginInfo.getSortids();
/* 440 */     for (Iterator i$ = sortIds.iterator(); i$.hasNext();) { int sortId = ((Integer)i$.next()).intValue();
/*     */       
/* 442 */       if (sortId > max)
/*     */       {
/* 444 */         max = sortId;
/*     */       }
/*     */     }
/*     */     
/* 448 */     Set<Integer> unReceivedSortids = xLoginInfo.getUnreceivedsortids();
/* 449 */     for (Iterator i$ = unReceivedSortids.iterator(); i$.hasNext();) { int sortId = ((Integer)i$.next()).intValue();
/*     */       
/* 451 */       if (sortId > max)
/*     */       {
/* 453 */         max = sortId;
/*     */       }
/*     */     }
/*     */     
/* 457 */     SLoginActivityAwardCfg loginActivityAwardCfg = SLoginActivityAwardCfg.get(activityCfgId);
/* 458 */     for (SLoginActivityAwardInfo awardInfo : loginActivityAwardCfg.awardInfos.values())
/*     */     {
/* 460 */       int sortId = awardInfo.sortId;
/* 461 */       if (sortId > max)
/*     */       {
/* 463 */         unReceivedSortids.add(Integer.valueOf(sortId));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\LoginActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */