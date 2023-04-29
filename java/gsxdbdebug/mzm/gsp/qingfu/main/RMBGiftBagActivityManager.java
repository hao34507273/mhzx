/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
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
/*     */ import mzm.gsp.qingfu.SSyncRMBGiftBagActivityInfo;
/*     */ import mzm.gsp.qingfu.confbean.RMBGiftBagGenDayInfo;
/*     */ import mzm.gsp.qingfu.confbean.SRMBGiftBagAwardCfg;
/*     */ import mzm.gsp.qingfu.event.TssChangedArg;
/*     */ import mzm.gsp.qingfu.event.TssChangedArg.TssChangedInfo;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.QingfuInfo;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ public class RMBGiftBagActivityManager
/*     */ {
/*     */   static final void init()
/*     */   {
/*  37 */     RMBGiftBagActivityHandler handler = new RMBGiftBagActivityHandler();
/*  38 */     ActivityInterface.registerActivityByLogicType(47, handler, true);
/*     */   }
/*     */   
/*     */   static final long getCalcTssBuyTimes(String userid, int serviceId, QingfuInfo xQingfuInfo)
/*     */   {
/*  43 */     Map<String, TssChangedArg.TssChangedInfo> tssChangedInfos = QingfuManager.delayHandleContext.getTssChangedInfoMap();
/*  44 */     if (tssChangedInfos == null)
/*     */     {
/*  46 */       return QingfuManager.getTssBuyTimes(userid, xQingfuInfo, serviceId);
/*     */     }
/*     */     
/*  49 */     TssChangedArg.TssChangedInfo tssChangedInfo = (TssChangedArg.TssChangedInfo)tssChangedInfos.get(String.valueOf(serviceId));
/*  50 */     if (tssChangedInfo == null)
/*     */     {
/*  52 */       return QingfuManager.getTssBuyTimes(userid, xQingfuInfo, serviceId);
/*     */     }
/*     */     
/*  55 */     return QingfuManager.getTssBuyTimes(userid, tssChangedInfo.oldTotalOpenDays, serviceId);
/*     */   }
/*     */   
/*     */ 
/*     */   static final void sendAwardMailIfNeed(String userid, long roleid, int activityCfgid, QingfuInfo xQingfuInfo, xbean.RMBGiftBagActivityInfo xRMBGiftBagActivityInfo)
/*     */   {
/*  61 */     int mailCfgid = xRMBGiftBagActivityInfo.getSend_award_mail_cfgid();
/*  62 */     if (mailCfgid <= 0)
/*     */     {
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> entry : xRMBGiftBagActivityInfo.getTiers().entrySet())
/*     */     {
/*  69 */       int tierid = ((Integer)entry.getKey()).intValue();
/*  70 */       xbean.RMBGiftBagTierInfo xRMBGiftBagTierInfo = (xbean.RMBGiftBagTierInfo)entry.getValue();
/*  71 */       long currNum = getCalcTssBuyTimes(userid, xRMBGiftBagTierInfo.getProduct_serviceid(), xQingfuInfo);
/*  72 */       long baseNum = xRMBGiftBagTierInfo.getBase_num();
/*  73 */       long buyTimes = currNum - baseNum;
/*  74 */       long delta = buyTimes - xRMBGiftBagTierInfo.getAward_times();
/*  75 */       if (delta > 0L)
/*     */       {
/*  77 */         int awardCfgid = xRMBGiftBagTierInfo.getAward_cfgid();
/*  78 */         AwardReason rmbGiftBagAwardReason = new AwardReason(LogReason.RMB_GFIT_ACTIVITY_AWARD_ADD, awardCfgid, PresentType.PRESENT_BIND_RMB_GIFT_BAG_ACTIVITY);
/*     */         
/*  80 */         rmbGiftBagAwardReason.setAwardItemBind(true);
/*  81 */         AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgid, roleid, rmbGiftBagAwardReason);
/*  82 */         if (awardModel == null)
/*     */         {
/*     */ 
/*  85 */           addTlog(userid, roleid, activityCfgid, tierid, awardCfgid, baseNum, currNum, (int)buyTimes, 3);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  90 */           java.util.List<String> emptyStrings = java.util.Collections.emptyList();
/*  91 */           TLogArg tLogArg = new TLogArg(LogReason.RMB_GFIT_ACTIVITY_AWARD_ADD, awardCfgid);
/*  92 */           MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, true);
/*  93 */           int awadTimes = xRMBGiftBagTierInfo.getAward_times();
/*  94 */           for (long i = 0L; i < delta; i += 1L)
/*     */           {
/*  96 */             SendMailRet ret = MailInterface.synBuildAndSendMail(roleid, mailCfgid, emptyStrings, emptyStrings, attachment, tLogArg);
/*     */             
/*  98 */             if (ret.isOK())
/*     */             {
/*     */ 
/* 101 */               addTlog(userid, roleid, activityCfgid, tierid, awardCfgid, baseNum, currNum, ++awadTimes, 2);
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/* 106 */               if (ret.getRetEnum() == SendMailRet.RetEnum.SEND_MAIL_CFG_NOT_EXIST)
/*     */               {
/* 108 */                 GameServer.logger().info(String.format("[qingfu]RMBGiftBagActivityManager.sendAwardMailIfNeed@mail cfgid not exist|roleid=%d|userid=%s|activity_cfgid=%d|tierid=%d|award_cfg_id=%d|purchase_num=%d|base_purchase_num=%d|mail_cfgid=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Integer.valueOf(tierid), Integer.valueOf(awardCfgid), Long.valueOf(currNum), Long.valueOf(baseNum), Integer.valueOf(mailCfgid) }));
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */               addTlog(userid, roleid, activityCfgid, tierid, awardCfgid, baseNum, currNum, ++awadTimes, 4);
/*     */             }
/*     */           }
/*     */         } } }
/* 119 */     xRMBGiftBagActivityInfo.getTiers().clear();
/*     */   }
/*     */   
/*     */   static final void initData(String userid, long roleid, int activityCfgid)
/*     */   {
/* 124 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 125 */     if (xQingfuInfo == null)
/*     */     {
/* 127 */       xQingfuInfo = Pod.newQingfuInfo();
/* 128 */       Qingfu.insert(userid, xQingfuInfo);
/*     */     }
/*     */     
/* 131 */     xbean.RMBGiftBagActivityInfo xRmbGiftBagActivityInfo = (xbean.RMBGiftBagActivityInfo)xQingfuInfo.getRmb_gift_bag_activity_infos().get(Integer.valueOf(activityCfgid));
/* 132 */     if (xRmbGiftBagActivityInfo == null)
/*     */     {
/* 134 */       xRmbGiftBagActivityInfo = Pod.newRMBGiftBagActivityInfo();
/* 135 */       xQingfuInfo.getRmb_gift_bag_activity_infos().put(Integer.valueOf(activityCfgid), xRmbGiftBagActivityInfo);
/*     */     }
/*     */     else
/*     */     {
/* 139 */       sendAwardMailIfNeed(userid, roleid, activityCfgid, xQingfuInfo, xRmbGiftBagActivityInfo);
/*     */     }
/*     */     
/* 142 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 143 */     SRMBGiftBagAwardCfg rmbAwardCfg = SRMBGiftBagAwardCfg.get(activityCfgid);
/* 144 */     int openServerDays = getOpenServerDays(currTime, rmbAwardCfg.days.size());
/* 145 */     xRmbGiftBagActivityInfo.setOpen_server_days(openServerDays);
/* 146 */     xRmbGiftBagActivityInfo.setSend_award_mail_cfgid(rmbAwardCfg.send_award_mail_cfgid);
/* 147 */     RMBGiftBagGenDayInfo rmbGiftBagGenDayInfo = (RMBGiftBagGenDayInfo)rmbAwardCfg.days.get(Integer.valueOf(openServerDays));
/* 148 */     if (rmbGiftBagGenDayInfo != null)
/*     */     {
/* 150 */       for (Map.Entry<Integer, mzm.gsp.qingfu.confbean.RMBGiftBagTierInfo> entry : rmbGiftBagGenDayInfo.tiers.entrySet())
/*     */       {
/* 152 */         int tierid = ((Integer)entry.getKey()).intValue();
/* 153 */         mzm.gsp.qingfu.confbean.RMBGiftBagTierInfo rmbGiftBagTierInfo = (mzm.gsp.qingfu.confbean.RMBGiftBagTierInfo)entry.getValue();
/* 154 */         xbean.RMBGiftBagTierInfo xRmbGiftBagTierInfo = Pod.newRMBGiftBagTierInfo();
/* 155 */         xRmbGiftBagTierInfo.setAward_cfgid(rmbGiftBagTierInfo.award_cfg_id);
/* 156 */         xRmbGiftBagTierInfo.setAward_times(0);
/* 157 */         int serviceid = rmbGiftBagTierInfo.product_service_id;
/* 158 */         xRmbGiftBagTierInfo.setProduct_serviceid(serviceid);
/* 159 */         long baseNum = getCalcTssBuyTimes(userid, serviceid, xQingfuInfo);
/* 160 */         xRmbGiftBagTierInfo.setBase_num(baseNum);
/* 161 */         xRmbGiftBagTierInfo.setAward_timestamp(currTime);
/* 162 */         xRmbGiftBagActivityInfo.getTiers().put(Integer.valueOf(tierid), xRmbGiftBagTierInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static final int getOpenServerDays(long currTime, int days)
/*     */   {
/* 169 */     long openServerTimestamp = GameServerInfoManager.getOpenServerTimestamp();
/* 170 */     if (openServerTimestamp <= 0L)
/*     */     {
/* 172 */       return 1;
/*     */     }
/*     */     
/* 175 */     long deltaMilliSeconds = DateTimeUtils.getDailyResetTime(currTime, 0) - DateTimeUtils.getDailyResetTime(openServerTimestamp, 0);
/*     */     
/* 177 */     long totalDays = deltaMilliSeconds / 86400000L;
/* 178 */     return (int)(totalDays % days) + 1;
/*     */   }
/*     */   
/*     */   static final int getOpenServerDays(xbean.RMBGiftBagActivityInfo xRMBGiftBagActivityInfo, long currTime, int days)
/*     */   {
/* 183 */     int dbOpenDays = xRMBGiftBagActivityInfo.getOpen_server_days();
/* 184 */     int opendays = getOpenServerDays(currTime, days);
/* 185 */     return dbOpenDays == opendays ? 0 : dbOpenDays;
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogin(String userid, long roleid)
/*     */   {
/* 190 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 191 */     if (xQingfuInfo == null)
/*     */     {
/* 193 */       return false;
/*     */     }
/*     */     
/* 196 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 197 */     SSyncRMBGiftBagActivityInfo core = new SSyncRMBGiftBagActivityInfo();
/* 198 */     for (SRMBGiftBagAwardCfg cfg : SRMBGiftBagAwardCfg.getAll().values())
/*     */     {
/* 200 */       int activityCfgid = cfg.activity_cfg_id;
/* 201 */       ActivityLimitTimeStageEnum result = ActivityInterface.getActivityLimitTimeStage(activityCfgid, curTime);
/* 202 */       if ((result == ActivityLimitTimeStageEnum.CFG_ERROR) || (result == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER))
/*     */       {
/* 204 */         xbean.RMBGiftBagActivityInfo xRMBGiftBagActivityInfo = (xbean.RMBGiftBagActivityInfo)xQingfuInfo.getRmb_gift_bag_activity_infos().remove(Integer.valueOf(activityCfgid));
/*     */         
/* 206 */         if (xRMBGiftBagActivityInfo != null)
/*     */         {
/* 208 */           sendAwardMailIfNeed(userid, roleid, activityCfgid, xQingfuInfo, xRMBGiftBagActivityInfo);
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 214 */       else if (ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 219 */         xbean.RMBGiftBagActivityInfo xRMBGiftBagActivityInfo = (xbean.RMBGiftBagActivityInfo)xQingfuInfo.getRmb_gift_bag_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */         
/* 221 */         if (xRMBGiftBagActivityInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 226 */           mzm.gsp.qingfu.RMBGiftBagActivityInfo rmbGiftBagActivityInfo = new mzm.gsp.qingfu.RMBGiftBagActivityInfo();
/* 227 */           rmbGiftBagActivityInfo.opendays = getOpenServerDays(xRMBGiftBagActivityInfo, curTime, cfg.days.size());
/* 228 */           boxRMBGiftBagActivityInfo(userid, xQingfuInfo, xRMBGiftBagActivityInfo, rmbGiftBagActivityInfo);
/* 229 */           if (rmbGiftBagActivityInfo.tiers.size() > 0)
/*     */           {
/* 231 */             core.activity_infos.put(Integer.valueOf(activityCfgid), rmbGiftBagActivityInfo); }
/*     */         }
/*     */       }
/*     */     }
/* 235 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 237 */       OnlineManager.getInstance().send(userid, core);
/*     */     }
/*     */     
/* 240 */     return true;
/*     */   }
/*     */   
/*     */   static final boolean onPurchaseService(TssChangedArg arg)
/*     */   {
/* 245 */     String userid = arg.userid;
/* 246 */     QingfuInfo xQingfuInfo = Qingfu.get(arg.userid);
/* 247 */     if (xQingfuInfo == null)
/*     */     {
/* 249 */       return false;
/*     */     }
/*     */     
/* 252 */     Long roleid = QingfuManager.getSuitableRoleId(userid);
/* 253 */     if (roleid == null)
/*     */     {
/* 255 */       return false;
/*     */     }
/*     */     
/* 258 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 259 */     SSyncRMBGiftBagActivityInfo core = new SSyncRMBGiftBagActivityInfo();
/* 260 */     for (SRMBGiftBagAwardCfg cfg : SRMBGiftBagAwardCfg.getAll().values())
/*     */     {
/* 262 */       QingfuManager.delayHandleContext.set(arg.changedInfos);
/*     */       try
/*     */       {
/* 265 */         int activityCfgid = cfg.activity_cfg_id;
/* 266 */         if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid.longValue(), activityCfgid).isCanJoin())
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 302 */           QingfuManager.delayHandleContext.set(null);
/*     */         }
/*     */         else
/*     */         {
/* 271 */           xbean.RMBGiftBagActivityInfo xRMBGiftBagActivityInfo = (xbean.RMBGiftBagActivityInfo)xQingfuInfo.getRmb_gift_bag_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */           
/* 273 */           if (xRMBGiftBagActivityInfo == null)
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
/* 302 */             QingfuManager.delayHandleContext.set(null);
/*     */           }
/*     */           else
/*     */           {
/* 278 */             boolean tssChanged = false;
/* 279 */             for (xbean.RMBGiftBagTierInfo xRMBGiftBagTierInfo : xRMBGiftBagActivityInfo.getTiers().values())
/*     */             {
/* 281 */               int serviceid = xRMBGiftBagTierInfo.getProduct_serviceid();
/* 282 */               TssChangedArg.TssChangedInfo tssChangedInfo = (TssChangedArg.TssChangedInfo)arg.changedInfos.get(String.valueOf(serviceid));
/* 283 */               if (tssChangedInfo != null)
/*     */               {
/* 285 */                 tssChanged = true;
/* 286 */                 break;
/*     */               }
/*     */             }
/*     */             
/* 290 */             if (!tssChanged)
/*     */             {
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
/* 302 */               QingfuManager.delayHandleContext.set(null);
/*     */             }
/*     */             else
/*     */             {
/* 295 */               mzm.gsp.qingfu.RMBGiftBagActivityInfo rmbGiftBagActivityInfo = new mzm.gsp.qingfu.RMBGiftBagActivityInfo();
/* 296 */               rmbGiftBagActivityInfo.opendays = getOpenServerDays(xRMBGiftBagActivityInfo, curTime, cfg.days.size());
/* 297 */               boxRMBGiftBagActivityInfo(userid, xQingfuInfo, xRMBGiftBagActivityInfo, rmbGiftBagActivityInfo);
/* 298 */               core.activity_infos.put(Integer.valueOf(activityCfgid), rmbGiftBagActivityInfo);
/*     */             }
/*     */           }
/*     */         }
/* 302 */       } finally { QingfuManager.delayHandleContext.set(null);
/*     */       }
/*     */     }
/*     */     
/* 306 */     if (core.activity_infos.size() > 0)
/*     */     {
/* 308 */       OnlineManager.getInstance().send(userid, core);
/*     */     }
/*     */     
/* 311 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void boxRMBGiftBagActivityInfo(String userid, QingfuInfo xQingfuInfo, xbean.RMBGiftBagActivityInfo xRMBGiftBagActivityInfo, mzm.gsp.qingfu.RMBGiftBagActivityInfo rmbGiftBagActivityInfo)
/*     */   {
/* 317 */     for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> entry : xRMBGiftBagActivityInfo.getTiers().entrySet())
/*     */     {
/* 319 */       int tierid = ((Integer)entry.getKey()).intValue();
/* 320 */       xbean.RMBGiftBagTierInfo xRMBGiftBagTierInfo = (xbean.RMBGiftBagTierInfo)entry.getValue();
/*     */       
/* 322 */       mzm.gsp.qingfu.RMBGiftBagTierInfo rmbGiftBagTierInfo = new mzm.gsp.qingfu.RMBGiftBagTierInfo();
/* 323 */       rmbGiftBagTierInfo.buy_times = ((int)(QingfuManager.getTssBuyTimes(userid, xQingfuInfo, xRMBGiftBagTierInfo.getProduct_serviceid()) - xRMBGiftBagTierInfo.getBase_num()));
/*     */       
/* 325 */       rmbGiftBagTierInfo.award_times = xRMBGiftBagTierInfo.getAward_times();
/* 326 */       rmbGiftBagTierInfo.award_timestamp = (xRMBGiftBagTierInfo.getAward_timestamp() / 1000L);
/* 327 */       rmbGiftBagActivityInfo.tiers.put(Integer.valueOf(tierid), rmbGiftBagTierInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   static final int getAward(String userid, long roleid, int activityCfgid, int tierid)
/*     */   {
/* 333 */     SRMBGiftBagAwardCfg rmbGiftBagAwardCfg = SRMBGiftBagAwardCfg.get(activityCfgid);
/* 334 */     if (rmbGiftBagAwardCfg == null)
/*     */     {
/* 336 */       return 1;
/*     */     }
/*     */     
/* 339 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 340 */     if (xQingfuInfo == null)
/*     */     {
/* 342 */       return 2;
/*     */     }
/*     */     
/* 345 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid).isCanJoin())
/*     */     {
/* 347 */       return 3;
/*     */     }
/*     */     
/* 350 */     xbean.RMBGiftBagActivityInfo xRMBGiftBagActivityInfo = (xbean.RMBGiftBagActivityInfo)xQingfuInfo.getRmb_gift_bag_activity_infos().get(Integer.valueOf(activityCfgid));
/*     */     
/* 352 */     if (xRMBGiftBagActivityInfo == null)
/*     */     {
/* 354 */       return 4;
/*     */     }
/*     */     
/* 357 */     xbean.RMBGiftBagTierInfo xRMBGiftBagTierInfo = (xbean.RMBGiftBagTierInfo)xRMBGiftBagActivityInfo.getTiers().get(Integer.valueOf(tierid));
/* 358 */     if (xRMBGiftBagTierInfo == null)
/*     */     {
/* 360 */       return 5;
/*     */     }
/*     */     
/* 363 */     long currNum = QingfuManager.getTssBuyTimes(userid, xQingfuInfo, xRMBGiftBagTierInfo.getProduct_serviceid());
/* 364 */     long baseNum = xRMBGiftBagTierInfo.getBase_num();
/* 365 */     long buyTimes = currNum - baseNum;
/* 366 */     long delta = buyTimes - xRMBGiftBagTierInfo.getAward_times();
/* 367 */     if (delta <= 0L)
/*     */     {
/* 369 */       return 6;
/*     */     }
/*     */     
/* 372 */     int awardCfgid = xRMBGiftBagTierInfo.getAward_cfgid();
/* 373 */     AwardReason rmbGiftBagAwardReason = new AwardReason(LogReason.RMB_GFIT_ACTIVITY_AWARD_ADD, awardCfgid, PresentType.PRESENT_BIND_RMB_GIFT_BAG_ACTIVITY);
/*     */     
/* 375 */     rmbGiftBagAwardReason.setAwardItemBind(true);
/* 376 */     for (long i = delta; i > 0L; i -= 1L)
/*     */     {
/* 378 */       AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userid, roleid, true, true, rmbGiftBagAwardReason);
/*     */       
/* 380 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 383 */         return 7;
/*     */       }
/* 385 */       xRMBGiftBagTierInfo.setAward_times(xRMBGiftBagTierInfo.getAward_times() + 1);
/*     */     }
/* 387 */     xRMBGiftBagTierInfo.setAward_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/* 390 */     addTlog(userid, roleid, activityCfgid, tierid, awardCfgid, baseNum, currNum, xRMBGiftBagTierInfo.getAward_times(), 1);
/*     */     
/* 392 */     GameServer.logger().info(String.format("[qingfu]RMBGiftBagActivityManager.getAward@get rmb gift bag activity award|roleid=%d|userid=%s|activity_cfgid=%d|tierid=%d|award_cfg_id=%d|purchase_num=%d|base_purchase_num=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(activityCfgid), Integer.valueOf(tierid), Integer.valueOf(awardCfgid), Long.valueOf(currNum), Long.valueOf(baseNum) }));
/*     */     
/*     */ 
/*     */ 
/* 396 */     return 0;
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
/*     */ 
/*     */   static final void addTlog(String userid, long roleid, int activity_cfgid, int tierid, int awardid, long baseBuyTimes, long buyTimes, int awardTimes, int status)
/*     */   {
/* 424 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(roleid);
/* 425 */     StringBuilder sbLog = new StringBuilder();
/* 426 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|').append(userid).append('|').append(roleid).append('|').append(roleLevel).append('|');
/*     */     
/* 428 */     sbLog.append(activity_cfgid).append('|').append(tierid).append('|').append(awardid).append('|').append(baseBuyTimes).append('|').append(buyTimes).append('|').append(awardTimes).append('|').append(status);
/*     */     
/* 430 */     TLogManager.getInstance().addLog(roleid, "RMBGiftBagActivityForServer", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\RMBGiftBagActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */