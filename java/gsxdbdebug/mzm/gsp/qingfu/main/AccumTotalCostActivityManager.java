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
/*     */ import mzm.gsp.qingfu.SSyncAccumTotalCostActivityInfo;
/*     */ import mzm.gsp.qingfu.confbean.SAccumTotalCostActivityAwardInfo;
/*     */ import mzm.gsp.qingfu.confbean.SAccumTotalCostAwardCfg;
/*     */ import mzm.gsp.qingfu.confbean.SQingfuCfgConsts;
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
/*     */ public class AccumTotalCostActivityManager
/*     */ {
/*  37 */   static volatile Map<Integer, Integer> activityToSwith = null;
/*     */   
/*     */   static final void collectSwithInfo()
/*     */   {
/*  41 */     Map<Integer, Integer> tmpActivityToSwith = new HashMap();
/*     */     
/*     */ 
/*  44 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_1), Integer.valueOf(113));
/*     */     
/*  46 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_2), Integer.valueOf(113));
/*     */     
/*  48 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_3), Integer.valueOf(113));
/*     */     
/*  50 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_4), Integer.valueOf(113));
/*     */     
/*  52 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_5), Integer.valueOf(113));
/*     */     
/*  54 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_6), Integer.valueOf(113));
/*     */     
/*  56 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_7), Integer.valueOf(113));
/*     */     
/*  58 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_8), Integer.valueOf(113));
/*     */     
/*  60 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_9), Integer.valueOf(113));
/*     */     
/*  62 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_10), Integer.valueOf(113));
/*     */     
/*  64 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_11), Integer.valueOf(113));
/*     */     
/*  66 */     tmpActivityToSwith.put(Integer.valueOf(SQingfuCfgConsts.getInstance().TIME_LIMITED_ACCUM_TOTAL_COST_ACTIVITY_CFG_ID_12), Integer.valueOf(113));
/*     */     
/*     */ 
/*  69 */     activityToSwith = tmpActivityToSwith;
/*     */   }
/*     */   
/*     */   static final void init()
/*     */   {
/*  74 */     collectSwithInfo();
/*     */     
/*  76 */     AccumTotalCostActivtiyHandler handler = new AccumTotalCostActivtiyHandler();
/*  77 */     ActivityInterface.registerActivityByLogicType(44, handler, true);
/*     */   }
/*     */   
/*     */ 
/*     */   static final void sendAwardMailIfNeed(String userid, long roleid, int activityCfgid, QingfuInfo xQingfuInfo, xbean.AccumTotalCostActivityInfo xAccumTotalCostActivityInfo)
/*     */   {
/*  83 */     SAccumTotalCostAwardCfg accumTotalCostCfg = SAccumTotalCostAwardCfg.get(activityCfgid);
/*  84 */     if (accumTotalCostCfg == null)
/*     */     {
/*  86 */       return;
/*     */     }
/*     */     
/*  89 */     int mailCfgid = accumTotalCostCfg.send_award_mail_cfgid;
/*  90 */     if (mailCfgid <= 0)
/*     */     {
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     long currAccumTotalCost = getCalcAccumTotalCostYuanbao(xQingfuInfo);
/*  96 */     long baseAccumTotalCost = xAccumTotalCostActivityInfo.getAccum_total_cost();
/*  97 */     long deltaAccumTotalCost = currAccumTotalCost - baseAccumTotalCost;
/*  98 */     List<String> emptyStrings = Collections.emptyList();
/*  99 */     int sortid = xAccumTotalCostActivityInfo.getSortid();
/* 100 */     sortid = sortid < 0 ? 0 : sortid;
/* 101 */     for (int i = sortid + 1;; i++)
/*     */     {
/* 103 */       SAccumTotalCostActivityAwardInfo accumTotalCostActivityAwardInfo = (SAccumTotalCostActivityAwardInfo)accumTotalCostCfg.award_infos.get(Integer.valueOf(i));
/* 104 */       if (accumTotalCostActivityAwardInfo == null) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/* 109 */       if (deltaAccumTotalCost < accumTotalCostActivityAwardInfo.accum_total_cost_cond) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/* 114 */       int awardCfgid = accumTotalCostActivityAwardInfo.award_cfg_id;
/* 115 */       AwardReason accumTotalCostActivityAwardReason = new AwardReason(LogReason.ACCUM_TOTAL_COST_ACTIVITY_AWARD_ADD, activityCfgid, PresentType.PRESENT_BIND_ACCUM_TOTAL_COST_ACTIVITY);
/*     */       
/*     */ 
/*     */ 
/* 119 */       accumTotalCostActivityAwardReason.setAwardItemBind(true);
/* 120 */       AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgid, roleid, accumTotalCostActivityAwardReason);
/*     */       
/* 122 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 125 */         addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, baseAccumTotalCost, currAccumTotalCost, 3);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 130 */         MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, true);
/* 131 */         TLogArg tLogArg = new TLogArg(LogReason.ACCUM_TOTAL_COST_ACTIVITY_AWARD_ADD, awardCfgid);
/* 132 */         SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, mailCfgid, emptyStrings, emptyStrings, attachment, tLogArg);
/*     */         
/*     */ 
/* 135 */         if (ret.isOK())
/*     */         {
/*     */ 
/* 138 */           addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, baseAccumTotalCost, currAccumTotalCost, 2);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 144 */           if (ret.getRetEnum() == SendMailRet.RetEnum.SEND_MAIL_CFG_NOT_EXIST)
/*     */           {
/* 146 */             GameServer.logger().info(String.format("[qingfu]AccumTotalCostActivityManager.sendAwardMailIfNeed@mail cfg id not exist|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|award_cfg_id=%d|accum_total_cost=%d|base_accum_total_cost=%d|delta_accum_total_cost=%d|mail_cfgid=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Integer.valueOf(sortid), Integer.valueOf(accumTotalCostActivityAwardInfo.award_cfg_id), Long.valueOf(currAccumTotalCost), Long.valueOf(baseAccumTotalCost), Long.valueOf(deltaAccumTotalCost), Integer.valueOf(mailCfgid) }));
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 154 */           addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, baseAccumTotalCost, currAccumTotalCost, 4);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static final void initData(String userid, long roleid, int activityCfgid) {
/* 161 */     if (!isOpen(activityCfgid, roleid))
/*     */     {
/* 163 */       throw new RuntimeException(String.format("[qingfu]AccumTotalCostActivityManager.initData@pls ignore this exception|roleid=%d|userid=%s|activity_cfgid=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 169 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 170 */     if (xQingfuInfo == null)
/*     */     {
/* 172 */       return;
/*     */     }
/*     */     
/* 175 */     xbean.AccumTotalCostActivityInfo xAccumTotalCostActivityInfo = (xbean.AccumTotalCostActivityInfo)xQingfuInfo.getAccum_total_cost_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */     
/* 177 */     if (xAccumTotalCostActivityInfo == null)
/*     */     {
/* 179 */       xAccumTotalCostActivityInfo = Pod.newAccumTotalCostActivityInfo();
/* 180 */       xQingfuInfo.getAccum_total_cost_activity_infos().put(Integer.valueOf(activityCfgid), xAccumTotalCostActivityInfo);
/*     */     }
/*     */     else
/*     */     {
/* 184 */       sendAwardMailIfNeed(userid, roleid, activityCfgid, xQingfuInfo, xAccumTotalCostActivityInfo);
/*     */     }
/* 186 */     xAccumTotalCostActivityInfo.setAccum_total_cost(getCalcAccumTotalCostYuanbao(xQingfuInfo));
/* 187 */     xAccumTotalCostActivityInfo.setSortid(-1);
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogin(String userid, long roleid)
/*     */   {
/* 192 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 193 */     if (xQingfuInfo == null)
/*     */     {
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 199 */     SSyncAccumTotalCostActivityInfo core = new SSyncAccumTotalCostActivityInfo();
/* 200 */     for (SAccumTotalCostAwardCfg cfg : SAccumTotalCostAwardCfg.getAll().values())
/*     */     {
/* 202 */       int activityCfgid = cfg.id;
/*     */       
/*     */ 
/* 205 */       if (isOpen(activityCfgid, roleid))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 210 */         ActivityLimitTimeStageEnum result = ActivityInterface.getActivityLimitTimeStage(activityCfgid, curTime);
/* 211 */         if ((result == ActivityLimitTimeStageEnum.CFG_ERROR) || (result == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER))
/*     */         {
/* 213 */           xbean.AccumTotalCostActivityInfo xAccumTotalCostActivityInfo = (xbean.AccumTotalCostActivityInfo)xQingfuInfo.getAccum_total_cost_activity_infos().remove(Integer.valueOf(activityCfgid));
/*     */           
/* 215 */           if (xAccumTotalCostActivityInfo != null)
/*     */           {
/* 217 */             sendAwardMailIfNeed(userid, roleid, activityCfgid, xQingfuInfo, xAccumTotalCostActivityInfo);
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/* 223 */         else if (ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 228 */           xbean.AccumTotalCostActivityInfo xAccumTotalCostActivityInfo = (xbean.AccumTotalCostActivityInfo)xQingfuInfo.getAccum_total_cost_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */           
/* 230 */           if (xAccumTotalCostActivityInfo != null)
/*     */           {
/*     */ 
/*     */ 
/* 234 */             mzm.gsp.qingfu.AccumTotalCostActivityInfo info = new mzm.gsp.qingfu.AccumTotalCostActivityInfo();
/* 235 */             boxAccumTotalCostActivityInfo(xAccumTotalCostActivityInfo, info);
/* 236 */             core.activity_infos.put(Integer.valueOf(activityCfgid), info);
/*     */           } } } }
/* 238 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 240 */       OnlineManager.getInstance().send(roleid, core);
/*     */     }
/*     */     
/* 243 */     return true;
/*     */   }
/*     */   
/*     */   static final long getAccumTotalCostYuanbao(QingfuInfo xQingfuInfo)
/*     */   {
/* 248 */     return xQingfuInfo.getTotal_cost() + xQingfuInfo.getTotal_cost_bind();
/*     */   }
/*     */   
/*     */   static final long getCalcAccumTotalCostYuanbao(QingfuInfo xQingfuInfo)
/*     */   {
/* 253 */     Long accumTotalCostYuanbao = QingfuManager.delayHandleContext.getLong();
/* 254 */     if (accumTotalCostYuanbao == null)
/*     */     {
/* 256 */       return getAccumTotalCostYuanbao(xQingfuInfo);
/*     */     }
/*     */     
/* 259 */     return accumTotalCostYuanbao.longValue();
/*     */   }
/*     */   
/*     */   static final boolean onCostInfoChanged(String userid, long roleid, long oldAccumTotalCost)
/*     */   {
/* 264 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 265 */     if (xQingfuInfo == null)
/*     */     {
/* 267 */       return false;
/*     */     }
/*     */     
/* 270 */     SSyncAccumTotalCostActivityInfo core = new SSyncAccumTotalCostActivityInfo();
/* 271 */     for (SAccumTotalCostAwardCfg cfg : SAccumTotalCostAwardCfg.getAll().values())
/*     */     {
/* 273 */       QingfuManager.delayHandleContext.set(Long.valueOf(oldAccumTotalCost));
/*     */       try
/*     */       {
/* 276 */         int activityCfgid = cfg.id;
/*     */         
/*     */ 
/* 279 */         if (!isOpen(activityCfgid, roleid))
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
/* 303 */           QingfuManager.delayHandleContext.set(null);
/*     */         }
/* 284 */         else if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
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
/* 303 */           QingfuManager.delayHandleContext.set(null);
/*     */         }
/*     */         else
/*     */         {
/* 289 */           xbean.AccumTotalCostActivityInfo xAccumTotalCostActivityInfo = (xbean.AccumTotalCostActivityInfo)xQingfuInfo.getAccum_total_cost_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */           
/* 291 */           if (xAccumTotalCostActivityInfo == null)
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
/* 303 */             QingfuManager.delayHandleContext.set(null);
/*     */           }
/*     */           else
/*     */           {
/* 297 */             mzm.gsp.qingfu.AccumTotalCostActivityInfo info = new mzm.gsp.qingfu.AccumTotalCostActivityInfo();
/* 298 */             boxAccumTotalCostActivityInfo(xAccumTotalCostActivityInfo, info);
/* 299 */             core.activity_infos.put(Integer.valueOf(activityCfgid), info);
/*     */           }
/*     */         }
/*     */       } finally {
/* 303 */         QingfuManager.delayHandleContext.set(null);
/*     */       }
/*     */     }
/* 306 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 308 */       OnlineManager.getInstance().send(roleid, core);
/*     */     }
/*     */     
/* 311 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void boxAccumTotalCostActivityInfo(xbean.AccumTotalCostActivityInfo xAccumTotalCostActivityInfo, mzm.gsp.qingfu.AccumTotalCostActivityInfo info)
/*     */   {
/* 317 */     info.base_accum_total_cost = xAccumTotalCostActivityInfo.getAccum_total_cost();
/* 318 */     info.sortid = xAccumTotalCostActivityInfo.getSortid();
/*     */   }
/*     */   
/*     */   static final int getAward(String userid, long roleid, int activityCfgid, int sortid)
/*     */   {
/* 323 */     SAccumTotalCostAwardCfg accumTotalCostCfg = SAccumTotalCostAwardCfg.get(activityCfgid);
/* 324 */     if (accumTotalCostCfg == null)
/*     */     {
/* 326 */       return 1;
/*     */     }
/*     */     
/* 329 */     SAccumTotalCostActivityAwardInfo accumTotalCostActivityAwardInfo = (SAccumTotalCostActivityAwardInfo)accumTotalCostCfg.award_infos.get(Integer.valueOf(sortid));
/* 330 */     if (accumTotalCostActivityAwardInfo == null)
/*     */     {
/* 332 */       return 2;
/*     */     }
/*     */     
/*     */ 
/* 336 */     if (!isOpen(activityCfgid, roleid))
/*     */     {
/* 338 */       return -1;
/*     */     }
/*     */     
/* 341 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */     {
/* 343 */       return -1;
/*     */     }
/*     */     
/* 346 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 347 */     if (xQingfuInfo == null)
/*     */     {
/* 349 */       return 3;
/*     */     }
/*     */     
/* 352 */     xbean.AccumTotalCostActivityInfo xAccumTotalCostActivityInfo = (xbean.AccumTotalCostActivityInfo)xQingfuInfo.getAccum_total_cost_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */     
/* 354 */     if (xAccumTotalCostActivityInfo == null)
/*     */     {
/* 356 */       return 4;
/*     */     }
/*     */     
/* 359 */     int oldSortid = xAccumTotalCostActivityInfo.getSortid();
/* 360 */     if (oldSortid >= 0)
/*     */     {
/* 362 */       int delta = sortid - oldSortid;
/* 363 */       if (delta <= 0)
/*     */       {
/* 365 */         return -3;
/*     */       }
/*     */       
/* 368 */       if (delta > 1)
/*     */       {
/* 370 */         return 5;
/*     */       }
/*     */     }
/*     */     
/* 374 */     long currAccumTotalCost = getAccumTotalCostYuanbao(xQingfuInfo);
/* 375 */     long baseAccumTotalCost = xAccumTotalCostActivityInfo.getAccum_total_cost();
/* 376 */     long deltaAccumTotalCost = currAccumTotalCost - baseAccumTotalCost;
/* 377 */     if (deltaAccumTotalCost < accumTotalCostActivityAwardInfo.accum_total_cost_cond)
/*     */     {
/* 379 */       return -2;
/*     */     }
/*     */     
/* 382 */     int awardCfgid = accumTotalCostActivityAwardInfo.award_cfg_id;
/* 383 */     AwardReason accumTotalCostActivityAwardReason = new AwardReason(LogReason.ACCUM_TOTAL_COST_ACTIVITY_AWARD_ADD, activityCfgid, PresentType.PRESENT_BIND_ACCUM_TOTAL_COST_ACTIVITY);
/*     */     
/*     */ 
/*     */ 
/* 387 */     accumTotalCostActivityAwardReason.setAwardItemBind(true);
/* 388 */     AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userid, roleid, true, true, accumTotalCostActivityAwardReason);
/*     */     
/* 390 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 393 */       return 6;
/*     */     }
/*     */     
/* 396 */     xAccumTotalCostActivityInfo.setSortid(sortid);
/*     */     
/*     */ 
/* 399 */     addTlog(userid, roleid, activityCfgid, sortid, awardCfgid, baseAccumTotalCost, currAccumTotalCost, 1);
/*     */     
/* 401 */     GameServer.logger().info(String.format("[qingfu]AccumTotalCostActivityManager.getAward@get accum total cost activity award|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|award_cfg_id=%d|accum_total_cost=%d|base_accum_total_cost=%d|delta_accum_total_cost=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Integer.valueOf(sortid), Integer.valueOf(accumTotalCostActivityAwardInfo.award_cfg_id), Long.valueOf(currAccumTotalCost), Long.valueOf(baseAccumTotalCost), Long.valueOf(deltaAccumTotalCost) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 407 */     return 0;
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
/*     */   static final void addTlog(String userid, long roleid, int activity_cfgid, int tierid, int awardid, long baseAccumTotalCost, long accumTotalCost, int status)
/*     */   {
/* 433 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 434 */     StringBuilder sbLog = new StringBuilder();
/* 435 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|').append(userid).append('|').append(roleid).append('|').append(roleLevel).append('|');
/*     */     
/* 437 */     sbLog.append(activity_cfgid).append('|').append(tierid).append('|').append(awardid).append('|').append(baseAccumTotalCost).append('|').append(accumTotalCost).append('|').append(status);
/*     */     
/* 439 */     TLogManager.getInstance().addLog(roleid, "AccumTotalCostActivityForServer", sbLog.toString());
/*     */   }
/*     */   
/*     */   static final boolean isOpen(int activityCfgid, long roleid)
/*     */   {
/* 444 */     Integer moduleid = (Integer)activityToSwith.get(Integer.valueOf(activityCfgid));
/* 445 */     if (moduleid == null)
/*     */     {
/* 447 */       return true;
/*     */     }
/*     */     
/* 450 */     if ((!OpenInterface.getOpenStatus(moduleid.intValue())) || (OpenInterface.isBanPlay(roleid, moduleid.intValue())))
/*     */     {
/* 452 */       return false;
/*     */     }
/*     */     
/* 455 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\AccumTotalCostActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */