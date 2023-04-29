/*     */ package mzm.gsp.loginaward.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.loginaward.LoginSumActivityInfo;
/*     */ import mzm.gsp.loginaward.SLoginSumActivityInfos;
/*     */ import mzm.gsp.loginaward.confbean.SLoginSumActivityAwardCfg;
/*     */ import mzm.gsp.loginaward.confbean.SLoginSumActivityAwardInfo;
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
/*     */ import xbean.LoginSumActivityInfos;
/*     */ import xbean.LoginSumInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2loginsumactivity;
/*     */ 
/*     */ public class LoginSumActivityManager
/*     */ {
/*     */   static final boolean isFunOpen(long roleId, boolean send)
/*     */   {
/*  38 */     if (!OpenInterface.getOpenStatus(154))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (OpenInterface.isBanPlay(roleId, 154))
/*     */     {
/*  44 */       if (send)
/*     */       {
/*  46 */         OpenInterface.sendBanPlayMsg(roleId, 154);
/*     */       }
/*  48 */       return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   static final void init()
/*     */   {
/*  55 */     ActivityInterface.registerActivityByLogicType(55, new LoginSumActivityHandler(), false);
/*     */   }
/*     */   
/*     */ 
/*     */   static final void initData(String userid, long roleId, int activityid)
/*     */   {
/*  61 */     LoginSumActivityInfos xLoginSumActivityInfos = Role2loginsumactivity.get(Long.valueOf(roleId));
/*  62 */     if (xLoginSumActivityInfos == null)
/*     */     {
/*  64 */       xLoginSumActivityInfos = Pod.newLoginSumActivityInfos();
/*  65 */       Role2loginsumactivity.insert(Long.valueOf(roleId), xLoginSumActivityInfos);
/*     */     }
/*     */     
/*  68 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  69 */     LoginSumInfo xLoginSumInfo = (LoginSumInfo)xLoginSumActivityInfos.getLogin_sum_infos().get(Integer.valueOf(activityid));
/*  70 */     if (xLoginSumInfo == null)
/*     */     {
/*  72 */       xLoginSumInfo = Pod.newLoginSumInfo();
/*  73 */       xLoginSumActivityInfos.getLogin_sum_infos().put(Integer.valueOf(activityid), xLoginSumInfo);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  78 */       calculateDiffDays(xLoginSumInfo, now);
/*  79 */       sendAwardMailIfNeed(userid, roleId, activityid, xLoginSumInfo);
/*  80 */       GameServer.logger().warn("[loginaward]LoginSumActivityManager.initData@initdata again");
/*     */     }
/*     */     
/*  83 */     initXLoginSumInfo(xLoginSumInfo);
/*     */     
/*  85 */     GameServer.logger().info(String.format("[loginaward]LoginSumActivityManager.initData@initdata|userid=%s|roleid=%d|activity_cfgid=%d", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(activityid) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void initXLoginSumInfo(LoginSumInfo xLoginSumInfo)
/*     */   {
/*  92 */     xLoginSumInfo.getSortids().clear();
/*  93 */     xLoginSumInfo.setLast_time(0L);
/*  94 */     xLoginSumInfo.setLogin_days(0);
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogin(String userId, long roleId)
/*     */   {
/*  99 */     if (!isFunOpen(roleId, false))
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     SLoginSumActivityInfos msg = new SLoginSumActivityInfos();
/* 105 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 106 */     for (SLoginSumActivityAwardCfg cfg : SLoginSumActivityAwardCfg.getAll().values())
/*     */     {
/* 108 */       int activityCfgid = cfg.id;
/* 109 */       ActivityLimitTimeStageEnum result = ActivityInterface.getActivityLimitTimeStage(activityCfgid, now);
/*     */       
/* 111 */       if ((result == ActivityLimitTimeStageEnum.CFG_ERROR) || (result == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER))
/*     */       {
/* 113 */         LoginSumInfo xLoginSumInfo = getLoginSumInfo(roleId, activityCfgid);
/* 114 */         if (xLoginSumInfo != null)
/*     */         {
/*     */ 
/* 117 */           sendAwardMailIfNeed(userId, roleId, activityCfgid, xLoginSumInfo);
/* 118 */           removeLoginSumInfo(roleId, activityCfgid);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 123 */       else if (ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 129 */         LoginSumInfo xLoginSumInfo = getLoginSumInfo(roleId, activityCfgid);
/* 130 */         if (xLoginSumInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 135 */           if (DateTimeUtils.needDailyReset(xLoginSumInfo.getLast_time(), now, 0))
/*     */           {
/* 137 */             xLoginSumInfo.setLogin_days(xLoginSumInfo.getLogin_days() + 1);
/* 138 */             xLoginSumInfo.setLast_time(now);
/*     */           }
/*     */           
/* 141 */           LoginSumActivityInfo info = new LoginSumActivityInfo();
/* 142 */           boxLoginSumActivityInfo(xLoginSumInfo, info);
/* 143 */           msg.activityinfos.put(Integer.valueOf(activityCfgid), info);
/*     */         } } }
/* 145 */     if (msg.activityinfos.size() > 0)
/*     */     {
/* 147 */       OnlineManager.getInstance().send(roleId, msg);
/*     */     }
/*     */     
/* 150 */     return true;
/*     */   }
/*     */   
/*     */   static final void boxLoginSumActivityInfo(LoginSumInfo xLoginSumInfo, LoginSumActivityInfo info)
/*     */   {
/* 155 */     info.logindays = xLoginSumInfo.getLogin_days();
/* 156 */     info.sortids.addAll(xLoginSumInfo.getSortids());
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogoff(String userId, long roleId)
/*     */   {
/* 161 */     if (!isFunOpen(roleId, false))
/*     */     {
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 167 */     for (SLoginSumActivityAwardCfg cfg : SLoginSumActivityAwardCfg.getAll().values())
/*     */     {
/* 169 */       int activityCfgid = cfg.id;
/* 170 */       long activityStartTime = ActivityInterface.getActivityStartTime(activityCfgid);
/*     */       
/* 172 */       ActivityLimitTimeStageEnum result = ActivityInterface.getActivityLimitTimeStage(activityCfgid, now);
/* 173 */       if (result == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER)
/*     */       {
/* 175 */         LoginSumInfo xLoginSumInfo = getLoginSumInfo(roleId, activityCfgid);
/* 176 */         if (xLoginSumInfo != null)
/*     */         {
/* 178 */           long endTime = ActivityInterface.getActivityEndTime(activityCfgid);
/* 179 */           calculateDiffDays(xLoginSumInfo, endTime);
/* 180 */           sendAwardMailIfNeed(userId, roleId, activityCfgid, xLoginSumInfo);
/* 181 */           removeLoginSumInfo(roleId, activityCfgid);
/*     */         }
/*     */         else
/*     */         {
/* 185 */           long loginTime = RoleInterface.getLastLoginTime(roleId);
/* 186 */           if (loginTime <= activityStartTime)
/*     */           {
/*     */ 
/* 189 */             LoginSumInfo xTmpLoginSumInfo = Pod.newLoginSumInfo();
/* 190 */             initXLoginSumInfo(xTmpLoginSumInfo);
/* 191 */             if (xTmpLoginSumInfo.getLast_time() == 0L)
/*     */             {
/* 193 */               xTmpLoginSumInfo.setLast_time(activityStartTime);
/* 194 */               xTmpLoginSumInfo.setLogin_days(1);
/*     */             }
/* 196 */             calculateDiffDays(xTmpLoginSumInfo, now);
/* 197 */             sendAwardMailIfNeed(userId, roleId, activityCfgid, xTmpLoginSumInfo);
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 204 */       else if (ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 209 */         LoginSumInfo xLoginSumInfo = getLoginSumInfo(roleId, activityCfgid);
/* 210 */         if (xLoginSumInfo != null)
/*     */         {
/*     */ 
/*     */ 
/* 214 */           if (xLoginSumInfo.getLast_time() == 0L)
/*     */           {
/* 216 */             xLoginSumInfo.setLast_time(activityStartTime);
/* 217 */             xLoginSumInfo.setLogin_days(1);
/*     */           }
/* 219 */           calculateDiffDays(xLoginSumInfo, now);
/*     */         } } }
/* 221 */     return true;
/*     */   }
/*     */   
/*     */   private static final void calculateDiffDays(LoginSumInfo xLoginSumInfo, long time)
/*     */   {
/* 226 */     long lastTime = xLoginSumInfo.getLast_time();
/* 227 */     int diff = DateTimeUtils.diffDays(time, lastTime);
/* 228 */     if (diff > 0)
/*     */     {
/* 230 */       xLoginSumInfo.setLogin_days(xLoginSumInfo.getLogin_days() + diff);
/* 231 */       xLoginSumInfo.setLast_time(time);
/*     */     }
/*     */   }
/*     */   
/*     */   static final int getAward(String userid, long roleId, int activityCfgId, int sortId)
/*     */   {
/* 237 */     SLoginSumActivityAwardCfg loginSumActivityAwardCfg = SLoginSumActivityAwardCfg.get(activityCfgId);
/* 238 */     if (loginSumActivityAwardCfg == null)
/*     */     {
/* 240 */       return 1;
/*     */     }
/*     */     
/* 243 */     SLoginSumActivityAwardInfo awardInfo = (SLoginSumActivityAwardInfo)loginSumActivityAwardCfg.awardInfos.get(Integer.valueOf(sortId));
/* 244 */     if (awardInfo == null)
/*     */     {
/* 246 */       return 2;
/*     */     }
/*     */     
/* 249 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleId, activityCfgId).isCanJoin())
/*     */     {
/* 251 */       return -1;
/*     */     }
/*     */     
/* 254 */     LoginSumInfo xLoginSumInfo = getLoginSumInfo(roleId, activityCfgId);
/* 255 */     if (xLoginSumInfo == null)
/*     */     {
/* 257 */       return 4;
/*     */     }
/*     */     
/* 260 */     if (xLoginSumInfo.getSortids().contains(Integer.valueOf(sortId)))
/*     */     {
/*     */ 
/* 263 */       return -2;
/*     */     }
/*     */     
/* 266 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 268 */     if (xLoginSumInfo.getLast_time() == 0L)
/*     */     {
/* 270 */       xLoginSumInfo.setLast_time(ActivityInterface.getActivityStartTime(activityCfgId));
/* 271 */       xLoginSumInfo.setLogin_days(1);
/*     */     }
/* 273 */     calculateDiffDays(xLoginSumInfo, now);
/* 274 */     if (awardInfo.loginSum > xLoginSumInfo.getLogin_days())
/*     */     {
/*     */ 
/* 277 */       return -3;
/*     */     }
/*     */     
/* 280 */     int awardCfgid = awardInfo.awardCfgId;
/* 281 */     AwardReason loginActivityAwardReason = new AwardReason(LogReason.LOGIN_AWARD_LOGIN_SUM, awardCfgid);
/* 282 */     loginActivityAwardReason.setAwardItemBind(true);
/*     */     
/* 284 */     AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userid, roleId, true, true, loginActivityAwardReason);
/*     */     
/* 286 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 289 */       return 3;
/*     */     }
/*     */     
/*     */ 
/* 293 */     xLoginSumInfo.getSortids().add(Integer.valueOf(sortId));
/*     */     
/* 295 */     addTlog(userid, roleId, activityCfgId, xLoginSumInfo.getLogin_days(), awardInfo, 1);
/* 296 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   private static final void sendAwardMailIfNeed(String userid, long roleId, int activityCfgId, LoginSumInfo xLoginSumInfo)
/*     */   {
/* 302 */     SLoginSumActivityAwardCfg loginSumActivityAwardCfg = SLoginSumActivityAwardCfg.get(activityCfgId);
/* 303 */     if (loginSumActivityAwardCfg == null)
/*     */     {
/* 305 */       return;
/*     */     }
/*     */     
/* 308 */     int mailCfgId = loginSumActivityAwardCfg.mailCfgId;
/* 309 */     if (mailCfgId <= 0)
/*     */     {
/* 311 */       return;
/*     */     }
/*     */     
/* 314 */     if (xLoginSumInfo.getSortids().size() == loginSumActivityAwardCfg.awardInfos.size())
/*     */     {
/* 316 */       return;
/*     */     }
/*     */     
/*     */ 
/* 320 */     int curLoginDays = xLoginSumInfo.getLogin_days();
/* 321 */     java.util.List<String> emptyStrings = java.util.Collections.emptyList();
/* 322 */     for (Map.Entry<Integer, SLoginSumActivityAwardInfo> entry : loginSumActivityAwardCfg.awardInfos.entrySet())
/*     */     {
/* 324 */       SLoginSumActivityAwardInfo awardInfo = (SLoginSumActivityAwardInfo)entry.getValue();
/* 325 */       if (awardInfo.loginSum <= curLoginDays)
/*     */       {
/*     */ 
/*     */ 
/* 329 */         int sortId = ((Integer)entry.getKey()).intValue();
/* 330 */         if (!xLoginSumInfo.getSortids().contains(Integer.valueOf(sortId)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 335 */           int awardCfgId = awardInfo.awardCfgId;
/* 336 */           AwardReason loginSumActivityAwardReason = new AwardReason(LogReason.LOGIN_AWARD_LOGIN_SUM, awardCfgId);
/* 337 */           loginSumActivityAwardReason.setAwardItemBind(true);
/* 338 */           AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgId, roleId, loginSumActivityAwardReason);
/* 339 */           if (awardModel == null)
/*     */           {
/*     */ 
/* 342 */             addTlog(userid, roleId, activityCfgId, curLoginDays, awardInfo, 3);
/*     */           }
/*     */           else
/*     */           {
/* 346 */             MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, true);
/* 347 */             TLogArg tLogArg = new TLogArg(LogReason.LOGIN_AWARD_LOGIN_SUM, awardCfgId);
/* 348 */             SendMailRet ret = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleId, mailCfgId, emptyStrings, emptyStrings, attachment, tLogArg);
/*     */             
/*     */ 
/* 351 */             if (ret.isOK())
/*     */             {
/*     */ 
/* 354 */               addTlog(userid, roleId, activityCfgId, curLoginDays, awardInfo, 2);
/*     */             }
/*     */             else
/*     */             {
/* 358 */               if (ret.getRetEnum() == mzm.gsp.mail.main.SendMailRet.RetEnum.SEND_MAIL_CFG_NOT_EXIST)
/*     */               {
/* 360 */                 GameServer.logger().info(String.format("[loginaward]LoginSumActivityManager.sendAwardMailIfNeed@mail cfgid not exist|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|award_cfgid=%d|login_sum=%d|mail_cfgid=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(activityCfgId), Integer.valueOf(awardInfo.sortId), Integer.valueOf(awardInfo.awardCfgId), Integer.valueOf(awardInfo.loginSum), Integer.valueOf(mailCfgId) }));
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 368 */               addTlog(userid, roleId, activityCfgId, xLoginSumInfo.getLogin_days(), awardInfo, 4);
/*     */             }
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
/*     */ 
/*     */   static final void addTlog(String userId, long roleId, int activityCfgId, int curLoginDays, SLoginSumActivityAwardInfo awardInfo, int status)
/*     */   {
/* 391 */     String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 392 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 394 */     TLogManager.getInstance().addLog(userId, "LoginSumActivityForServer", new Object[] { vGameIp, userId, Long.valueOf(roleId), Integer.valueOf(roleLevel), Integer.valueOf(activityCfgId), Integer.valueOf(curLoginDays), Integer.valueOf(awardInfo.sortId), Integer.valueOf(awardInfo.loginSum), Integer.valueOf(awardInfo.awardCfgId), Integer.valueOf(status) });
/*     */   }
/*     */   
/*     */ 
/*     */   static LoginSumInfo getLoginSumInfo(long roleid, int activityCfgid)
/*     */   {
/* 400 */     LoginSumActivityInfos xLoginSumActivityInfos = Role2loginsumactivity.get(Long.valueOf(roleid));
/* 401 */     if (xLoginSumActivityInfos == null)
/*     */     {
/* 403 */       return null;
/*     */     }
/*     */     
/* 406 */     return (LoginSumInfo)xLoginSumActivityInfos.getLogin_sum_infos().get(Integer.valueOf(activityCfgid));
/*     */   }
/*     */   
/*     */   private static boolean removeLoginSumInfo(long roleid, int activityCfgid)
/*     */   {
/* 411 */     LoginSumActivityInfos xLoginSumActivityInfos = Role2loginsumactivity.get(Long.valueOf(roleid));
/* 412 */     if (xLoginSumActivityInfos == null)
/*     */     {
/* 414 */       return false;
/*     */     }
/*     */     
/* 417 */     return xLoginSumActivityInfos.getLogin_sum_infos().remove(Integer.valueOf(activityCfgid)) != null;
/*     */   }
/*     */   
/*     */   static void sendLoginSumActivityInfos(String userid, long roleId)
/*     */   {
/* 422 */     SLoginSumActivityInfos msg = new SLoginSumActivityInfos();
/* 423 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 424 */     for (SLoginSumActivityAwardCfg cfg : SLoginSumActivityAwardCfg.getAll().values())
/*     */     {
/* 426 */       int activityCfgid = cfg.id;
/* 427 */       if (ActivityInterface.canJoinAndCheckInitActivityData(userid, roleId, activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 432 */         LoginSumInfo xLoginSumInfo = getLoginSumInfo(roleId, activityCfgid);
/* 433 */         if (xLoginSumInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 438 */           if (xLoginSumInfo.getLast_time() == 0L)
/*     */           {
/*     */ 
/* 441 */             xLoginSumInfo.setLast_time(now);
/* 442 */             xLoginSumInfo.setLogin_days(1);
/*     */           }
/* 444 */           calculateDiffDays(xLoginSumInfo, now);
/*     */           
/* 446 */           LoginSumActivityInfo info = new LoginSumActivityInfo();
/* 447 */           boxLoginSumActivityInfo(xLoginSumInfo, info);
/* 448 */           msg.activityinfos.put(Integer.valueOf(activityCfgid), info);
/*     */         } } }
/* 450 */     if (msg.activityinfos.size() > 0)
/*     */     {
/* 452 */       OnlineManager.getInstance().send(roleId, msg);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\LoginSumActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */