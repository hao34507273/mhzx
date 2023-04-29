/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.SSyncSaveAmtActivityInfo;
/*     */ import mzm.gsp.qingfu.confbean.SQingfuCfgConsts;
/*     */ import mzm.gsp.qingfu.confbean.SSaveAmtActivityAwardInfo;
/*     */ import mzm.gsp.qingfu.confbean.SSaveAmtAwardCfg;
/*     */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.QingfuInfo;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ public class SaveAmtActivityManager
/*     */ {
/*  38 */   static volatile Map<Integer, Integer> activityToSwith = null;
/*     */   
/*     */   static final void collectSwithInfo()
/*     */   {
/*  42 */     Map<Integer, Integer> tmpActivityToSwith = new HashMap();
/*     */     
/*     */ 
/*  45 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().SAVE_AMT_ACTIVITY_CFG_ID), Integer.valueOf(111));
/*     */     
/*     */ 
/*     */ 
/*  49 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().RECHARGE_TIMES_ACTIVITY_CFG_ID), Integer.valueOf(114));
/*     */     
/*     */ 
/*     */ 
/*  53 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_1), Integer.valueOf(112));
/*     */     
/*  55 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_2), Integer.valueOf(112));
/*     */     
/*  57 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_3), Integer.valueOf(112));
/*     */     
/*  59 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_4), Integer.valueOf(112));
/*     */     
/*  61 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_5), Integer.valueOf(112));
/*     */     
/*  63 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_6), Integer.valueOf(112));
/*     */     
/*  65 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_7), Integer.valueOf(112));
/*     */     
/*  67 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_8), Integer.valueOf(112));
/*     */     
/*  69 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_9), Integer.valueOf(112));
/*     */     
/*  71 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_10), Integer.valueOf(112));
/*     */     
/*  73 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_11), Integer.valueOf(112));
/*     */     
/*  75 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_SAVE_AMT_ACTIVITY_CFG_ID_12), Integer.valueOf(112));
/*     */     
/*     */ 
/*  78 */     activityToSwith = tmpActivityToSwith;
/*     */   }
/*     */   
/*     */   static final void init()
/*     */   {
/*  83 */     collectSwithInfo();
/*     */     
/*  85 */     SaveAmtActivtiyHandler handler = new SaveAmtActivtiyHandler();
/*  86 */     ActivityInterface.registerActivityByLogicType(43, handler, true);
/*     */   }
/*     */   
/*     */   static final long getCalcSaveAmt(QingfuInfo xQingfuInfo)
/*     */   {
/*  91 */     Long saveAmt = QingfuManager.delayHandleContext.getLong();
/*  92 */     if (saveAmt == null)
/*     */     {
/*  94 */       return QingfuManager.getSaveAmt(xQingfuInfo);
/*     */     }
/*     */     
/*  97 */     return saveAmt.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */   static final void sendAwardMailIfNeed(String userid, long roleid, int activityCfgid, QingfuInfo xQingfuInfo, xbean.SaveAmtActivityInfo xSaveAmtActivityInfo)
/*     */   {
/* 103 */     SSaveAmtAwardCfg saveAmtAwardCfg = SSaveAmtAwardCfg.get(activityCfgid);
/* 104 */     if (saveAmtAwardCfg == null)
/*     */     {
/* 106 */       return;
/*     */     }
/*     */     
/* 109 */     int mailCfgid = saveAmtAwardCfg.send_award_mail_cfgid;
/* 110 */     if (mailCfgid <= 0)
/*     */     {
/* 112 */       return;
/*     */     }
/*     */     
/* 115 */     long currSaveAmt = getCalcSaveAmt(xQingfuInfo);
/* 116 */     long baseSaveAmt = xSaveAmtActivityInfo.getSave_amt();
/* 117 */     long deltaSaveAmt = currSaveAmt - baseSaveAmt;
/* 118 */     List<String> emptyStrings = Collections.emptyList();
/* 119 */     int sortid = xSaveAmtActivityInfo.getSortid();
/* 120 */     sortid = sortid < 0 ? 0 : sortid;
/* 121 */     for (int i = sortid + 1;; i++)
/*     */     {
/* 123 */       SSaveAmtActivityAwardInfo saveAmtActivityAwardInfo = (SSaveAmtActivityAwardInfo)saveAmtAwardCfg.award_infos.get(Integer.valueOf(i));
/* 124 */       if (saveAmtActivityAwardInfo == null) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/* 129 */       if (deltaSaveAmt < saveAmtActivityAwardInfo.save_amt_cond) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/* 134 */       int awardCfgid = saveAmtActivityAwardInfo.award_cfg_id;
/* 135 */       AwardReason saveAmtActivityAwardReason = new AwardReason(LogReason.SAVE_AMT_ACTIVITY_AWARD_ADD, activityCfgid, PresentType.PRESENT_BIND_SAVE_AMT_ACTIVITY);
/*     */       
/*     */ 
/* 138 */       saveAmtActivityAwardReason.setAwardItemBind(true);
/* 139 */       AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgid, roleid, saveAmtActivityAwardReason);
/* 140 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 143 */         addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, baseSaveAmt, currSaveAmt, 3);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 148 */         MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, true);
/* 149 */         TLogArg tLogArg = new TLogArg(LogReason.SAVE_AMT_ACTIVITY_AWARD_ADD, awardCfgid);
/* 150 */         SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, mailCfgid, emptyStrings, emptyStrings, attachment, tLogArg);
/*     */         
/*     */ 
/* 153 */         if (ret.isOK())
/*     */         {
/*     */ 
/* 156 */           addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, baseSaveAmt, currSaveAmt, 2);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 162 */           if (ret.getRetEnum() == SendMailRet.RetEnum.SEND_MAIL_CFG_NOT_EXIST)
/*     */           {
/* 164 */             GameServer.logger().info(String.format("[qingfu]SaveAmtActivityManager.sendAwardMailIfNeed@send mail cfg id not exist|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|award_cfg_id=%d|save_amt=%d|base_save_amt=%d|delta_save_amt=%d|mail_cfgid=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Integer.valueOf(sortid), Integer.valueOf(awardCfgid), Long.valueOf(currSaveAmt), Long.valueOf(baseSaveAmt), Long.valueOf(deltaSaveAmt), Integer.valueOf(mailCfgid) }));
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 172 */           addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, baseSaveAmt, currSaveAmt, 4);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static final void initData(String userid, long roleid, int activityCfgid) {
/* 179 */     if (!isOpen(activityCfgid, roleid))
/*     */     {
/* 181 */       throw new RuntimeException(String.format("[qingfu]SaveAmtActivityManager.initData@pls ignore this exception|roleid=%d|userid=%s|activity_cfgid=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 186 */     GameServer.logger().info(String.format("[qingfu]SaveAmtActivityManager.initData@enter init data|roleid=%d|userid=%s|activity_cfgid=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 190 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 191 */     if (xQingfuInfo == null)
/*     */     {
/* 193 */       return;
/*     */     }
/*     */     
/* 196 */     xbean.SaveAmtActivityInfo xSaveAmtActivityInfo = (xbean.SaveAmtActivityInfo)xQingfuInfo.getSave_amt_activity_infos().get(Integer.valueOf(activityCfgid));
/* 197 */     if (xSaveAmtActivityInfo == null)
/*     */     {
/* 199 */       xSaveAmtActivityInfo = Pod.newSaveAmtActivityInfo();
/* 200 */       xQingfuInfo.getSave_amt_activity_infos().put(Integer.valueOf(activityCfgid), xSaveAmtActivityInfo);
/*     */ 
/*     */ 
/*     */     }
/* 204 */     else if (!xSaveAmtActivityInfo.getIs_reset())
/*     */     {
/* 206 */       xSaveAmtActivityInfo.setSave_amt(0L);
/* 207 */       xSaveAmtActivityInfo.setIs_reset(true);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 213 */     GameServer.logger().info(String.format("[qingfu]SaveAmtActivityManager.initData@dump info|roleid=%d|userid=%s|activity_cfgid=%d|save_amt=%d|base_save_amt=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Long.valueOf(QingfuManager.getSaveAmt(xQingfuInfo)), Long.valueOf(xSaveAmtActivityInfo.getSave_amt()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 220 */     xSaveAmtActivityInfo.setIs_reset(true);
/* 221 */     xSaveAmtActivityInfo.setSave_amt(getCalcSaveAmt(xQingfuInfo));
/* 222 */     xSaveAmtActivityInfo.setSortid(-1);
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogin(String userid, long roleid)
/*     */   {
/* 227 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 228 */     if (xQingfuInfo == null)
/*     */     {
/* 230 */       return false;
/*     */     }
/*     */     
/* 233 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 234 */     SSyncSaveAmtActivityInfo core = new SSyncSaveAmtActivityInfo();
/* 235 */     for (SSaveAmtAwardCfg cfg : SSaveAmtAwardCfg.getAll().values())
/*     */     {
/* 237 */       int activityCfgid = cfg.id;
/*     */       
/*     */ 
/* 240 */       if (isOpen(activityCfgid, roleid))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 245 */         ActivityLimitTimeStageEnum result = ActivityInterface.getActivityLimitTimeStage(activityCfgid, curTime);
/* 246 */         if ((result == ActivityLimitTimeStageEnum.CFG_ERROR) || (result == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER))
/*     */         {
/* 248 */           xbean.SaveAmtActivityInfo xSaveAmtActivityInfo = (xbean.SaveAmtActivityInfo)xQingfuInfo.getSave_amt_activity_infos().remove(Integer.valueOf(activityCfgid));
/* 249 */           if (xSaveAmtActivityInfo != null)
/*     */           {
/* 251 */             if (!xSaveAmtActivityInfo.getIs_reset())
/*     */             {
/* 253 */               xSaveAmtActivityInfo.setSave_amt(0L);
/* 254 */               xSaveAmtActivityInfo.setIs_reset(true);
/*     */             }
/*     */             
/* 257 */             GameServer.logger().info(String.format("[qingfu]SaveAmtActivityManager.onRoleLogin@dump info|roleid=%d|userid=%s|activity_cfgid=%d|save_amt=%d|base_save_amt=%d|result=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Long.valueOf(QingfuManager.getSaveAmt(xQingfuInfo)), Long.valueOf(xSaveAmtActivityInfo.getSave_amt()), Integer.valueOf(result.ordinal()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 269 */         else if (ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 274 */           xbean.SaveAmtActivityInfo xSaveAmtActivityInfo = (xbean.SaveAmtActivityInfo)xQingfuInfo.getSave_amt_activity_infos().get(Integer.valueOf(activityCfgid));
/* 275 */           if (xSaveAmtActivityInfo != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 280 */             if (!xSaveAmtActivityInfo.getIs_reset())
/*     */             {
/* 282 */               xSaveAmtActivityInfo.setSave_amt(0L);
/* 283 */               xSaveAmtActivityInfo.setIs_reset(true);
/*     */             }
/*     */             
/* 286 */             mzm.gsp.qingfu.SaveAmtActivityInfo info = new mzm.gsp.qingfu.SaveAmtActivityInfo();
/* 287 */             boxSaveAmtActivityInfo(xSaveAmtActivityInfo, info);
/* 288 */             core.activity_infos.put(Integer.valueOf(activityCfgid), info);
/*     */           }
/*     */         } } }
/* 291 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 293 */       OnlineManager.getInstance().send(roleid, core);
/*     */     }
/*     */     
/* 296 */     trySendTipMail(userid, roleid);
/*     */     
/* 298 */     return true;
/*     */   }
/*     */   
/*     */   static final boolean onSaveAmtChanged(SaveAmtChangedArg arg)
/*     */   {
/* 303 */     String userid = arg.userid;
/* 304 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 305 */     if (xQingfuInfo == null)
/*     */     {
/* 307 */       return false;
/*     */     }
/*     */     
/* 310 */     long roleid = QingfuManager.getSuitableRoleId(userid).longValue();
/* 311 */     SSyncSaveAmtActivityInfo core = new SSyncSaveAmtActivityInfo();
/* 312 */     for (SSaveAmtAwardCfg cfg : SSaveAmtAwardCfg.getAll().values())
/*     */     {
/* 314 */       QingfuManager.delayHandleContext.set(Long.valueOf(arg.oldSaveAmt));
/*     */       try
/*     */       {
/* 317 */         int activityCfgid = cfg.id;
/*     */         
/*     */ 
/* 320 */         if (!isOpen(activityCfgid, roleid))
/*     */         {
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
/* 349 */           QingfuManager.delayHandleContext.set(null);
/*     */         }
/* 325 */         else if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */         {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 349 */           QingfuManager.delayHandleContext.set(null);
/*     */         }
/*     */         else
/*     */         {
/* 330 */           xbean.SaveAmtActivityInfo xSaveAmtActivityInfo = (xbean.SaveAmtActivityInfo)xQingfuInfo.getSave_amt_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */           
/* 332 */           if (xSaveAmtActivityInfo == null)
/*     */           {
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
/* 349 */             QingfuManager.delayHandleContext.set(null);
/*     */           }
/*     */           else
/*     */           {
/* 337 */             if (!xSaveAmtActivityInfo.getIs_reset())
/*     */             {
/* 339 */               xSaveAmtActivityInfo.setSave_amt(0L);
/* 340 */               xSaveAmtActivityInfo.setIs_reset(true);
/*     */             }
/*     */             
/* 343 */             mzm.gsp.qingfu.SaveAmtActivityInfo info = new mzm.gsp.qingfu.SaveAmtActivityInfo();
/* 344 */             boxSaveAmtActivityInfo(xSaveAmtActivityInfo, info);
/* 345 */             core.activity_infos.put(Integer.valueOf(activityCfgid), info);
/*     */           }
/*     */         }
/*     */       } finally {
/* 349 */         QingfuManager.delayHandleContext.set(null);
/*     */       }
/*     */     }
/*     */     
/* 353 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 355 */       OnlineManager.getInstance().send(roleid, core);
/*     */     }
/*     */     
/* 358 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void boxSaveAmtActivityInfo(xbean.SaveAmtActivityInfo xSaveAmtActivityInfo, mzm.gsp.qingfu.SaveAmtActivityInfo info)
/*     */   {
/* 364 */     info.base_save_amt = xSaveAmtActivityInfo.getSave_amt();
/* 365 */     info.sortid = xSaveAmtActivityInfo.getSortid();
/*     */   }
/*     */   
/*     */   static final int getAward(String userid, long roleid, int activityCfgid, int sortid)
/*     */   {
/* 370 */     SSaveAmtAwardCfg saveAmtAwardCfg = SSaveAmtAwardCfg.get(activityCfgid);
/* 371 */     if (saveAmtAwardCfg == null)
/*     */     {
/* 373 */       return 1;
/*     */     }
/*     */     
/* 376 */     SSaveAmtActivityAwardInfo saveAmtActivityAwardInfo = (SSaveAmtActivityAwardInfo)saveAmtAwardCfg.award_infos.get(Integer.valueOf(sortid));
/* 377 */     if (saveAmtActivityAwardInfo == null)
/*     */     {
/* 379 */       return 2;
/*     */     }
/*     */     
/*     */ 
/* 383 */     if (!isOpen(activityCfgid, roleid))
/*     */     {
/* 385 */       return -1;
/*     */     }
/*     */     
/* 388 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */     {
/* 390 */       return -1;
/*     */     }
/*     */     
/* 393 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 394 */     if (xQingfuInfo == null)
/*     */     {
/* 396 */       return 3;
/*     */     }
/*     */     
/* 399 */     xbean.SaveAmtActivityInfo xSaveAmtActivityInfo = (xbean.SaveAmtActivityInfo)xQingfuInfo.getSave_amt_activity_infos().get(Integer.valueOf(activityCfgid));
/* 400 */     if (xSaveAmtActivityInfo == null)
/*     */     {
/* 402 */       return 4;
/*     */     }
/*     */     
/* 405 */     int oldSortid = xSaveAmtActivityInfo.getSortid();
/* 406 */     if (oldSortid >= 0)
/*     */     {
/* 408 */       int delta = sortid - oldSortid;
/* 409 */       if (delta <= 0)
/*     */       {
/* 411 */         return -3;
/*     */       }
/*     */       
/* 414 */       if (delta > 1)
/*     */       {
/* 416 */         return 5;
/*     */       }
/*     */     }
/*     */     
/* 420 */     if (!xSaveAmtActivityInfo.getIs_reset())
/*     */     {
/* 422 */       xSaveAmtActivityInfo.setSave_amt(0L);
/* 423 */       xSaveAmtActivityInfo.setIs_reset(true);
/*     */     }
/*     */     
/* 426 */     long currSaveAmt = QingfuManager.getSaveAmt(xQingfuInfo);
/* 427 */     long baseSaveAmt = xSaveAmtActivityInfo.getSave_amt();
/* 428 */     long deltaSaveAmt = currSaveAmt - baseSaveAmt;
/* 429 */     if (deltaSaveAmt < saveAmtActivityAwardInfo.save_amt_cond)
/*     */     {
/* 431 */       return -2;
/*     */     }
/*     */     
/* 434 */     int awardCfgid = saveAmtActivityAwardInfo.award_cfg_id;
/* 435 */     AwardReason saveAmtActivityAwardReason = new AwardReason(LogReason.SAVE_AMT_ACTIVITY_AWARD_ADD, activityCfgid, PresentType.PRESENT_BIND_SAVE_AMT_ACTIVITY);
/*     */     
/* 437 */     saveAmtActivityAwardReason.setAwardItemBind(true);
/* 438 */     AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userid, roleid, true, true, saveAmtActivityAwardReason);
/*     */     
/* 440 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 443 */       return 6;
/*     */     }
/*     */     
/* 446 */     xSaveAmtActivityInfo.setSortid(sortid);
/*     */     
/*     */ 
/* 449 */     addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, baseSaveAmt, currSaveAmt, 1);
/*     */     
/* 451 */     GameServer.logger().info(String.format("[qingfu]SaveAmtActivityManager.getAward@get save amt activity award|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|award_cfg_id=%d|save_amt=%d|base_save_amt=%d|delta_save_amt=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Integer.valueOf(sortid), Integer.valueOf(awardCfgid), Long.valueOf(currSaveAmt), Long.valueOf(baseSaveAmt), Long.valueOf(deltaSaveAmt) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 456 */     return 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static final void addTlog(String userid, long roleid, int activity_cfgid, int tierid, int awardid, long baseSaveAmt, long saveAmt, int status)
/*     */   {
/* 483 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 484 */     StringBuilder sbLog = new StringBuilder();
/* 485 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|').append(userid).append('|').append(roleid).append('|').append(roleLevel).append('|');
/*     */     
/* 487 */     sbLog.append(activity_cfgid).append('|').append(tierid).append('|').append(awardid).append('|').append(baseSaveAmt).append('|').append(saveAmt).append('|').append(status);
/*     */     
/* 489 */     TLogManager.getInstance().addLog(roleid, "SaveAmtActivityForServer", sbLog.toString());
/*     */   }
/*     */   
/*     */   static final void trySendTipMail(String userid, long roleid)
/*     */   {
/* 494 */     int mailCfgid = SQingfuCfgConsts.getInstance().RECHARGE_TIMES_MAIL_ID;
/* 495 */     if (mailCfgid <= 0)
/*     */     {
/* 497 */       return;
/*     */     }
/*     */     
/* 500 */     int level = SQingfuCfgConsts.getInstance().RECHARGE_TIMES_MAIL_LEVEL;
/* 501 */     if (level <= 0)
/*     */     {
/* 503 */       return;
/*     */     }
/*     */     
/* 506 */     int activityCfgid = SQingfuCfgConsts.getInstance().RECHARGE_TIMES_ACTIVITY_CFG_ID;
/* 507 */     SSaveAmtAwardCfg saveAmtAwardCfg = SSaveAmtAwardCfg.get(activityCfgid);
/* 508 */     if ((saveAmtAwardCfg == null) || (saveAmtAwardCfg.award_infos.isEmpty()))
/*     */     {
/* 510 */       return;
/*     */     }
/*     */     
/*     */ 
/* 514 */     if (!isOpen(activityCfgid, roleid))
/*     */     {
/* 516 */       return;
/*     */     }
/*     */     
/* 519 */     SSaveAmtActivityAwardInfo saveAmtActivityAwardInfo = (SSaveAmtActivityAwardInfo)saveAmtAwardCfg.award_infos.get(Integer.valueOf(1));
/* 520 */     if (saveAmtActivityAwardInfo == null)
/*     */     {
/* 522 */       return;
/*     */     }
/*     */     
/* 525 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 526 */     if (roleLevel < level)
/*     */     {
/* 528 */       return;
/*     */     }
/*     */     
/* 531 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 532 */     if (xQingfuInfo == null)
/*     */     {
/* 534 */       return;
/*     */     }
/*     */     
/*     */ 
/* 538 */     if (!FirstRechargeManager.isGetAward(xQingfuInfo))
/*     */     {
/* 540 */       return;
/*     */     }
/*     */     
/* 543 */     if (QingfuManager.getSaveAmt(xQingfuInfo) >= saveAmtActivityAwardInfo.save_amt_cond)
/*     */     {
/* 545 */       return;
/*     */     }
/*     */     
/* 548 */     if (!QingfuManager.checkAndSetSendRechargeTimesTipMailNo(roleid, 2))
/*     */     {
/* 550 */       return;
/*     */     }
/*     */     
/* 553 */     MailInterface.asynBuildAndSendMail(roleid, mailCfgid, null, null, null);
/*     */   }
/*     */   
/*     */   static final boolean isOpen(int activityCfgid, long roleid)
/*     */   {
/* 558 */     Integer moduleid = (Integer)activityToSwith.get(Integer.valueOf(activityCfgid));
/* 559 */     if (moduleid == null)
/*     */     {
/* 561 */       return true;
/*     */     }
/*     */     
/* 564 */     if ((!OpenInterface.getOpenStatus(moduleid.intValue())) || (OpenInterface.isBanPlay(roleid, moduleid.intValue())))
/*     */     {
/* 566 */       return false;
/*     */     }
/*     */     
/* 569 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\SaveAmtActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */