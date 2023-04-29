/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.menpaistar.SyncEffectNpcs;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarNpcCfg;
/*     */ import mzm.gsp.menpaistar.confbean.SVoteAwardCfg;
/*     */ import mzm.gsp.menpaistar.confbean.SVoteNumCfg;
/*     */ import mzm.gsp.menpaistar.confbean.SVotePointCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Campaign;
/*     */ import xbean.CampaignChart;
/*     */ import xbean.CampaignCharts;
/*     */ import xbean.MenPaiStar;
/*     */ import xbean.MenPaiStarCampaignInfo;
/*     */ import xbean.MenPaiStarChart;
/*     */ import xbean.MenPaiStarChartInfo;
/*     */ import xbean.MenPaiStarVoteInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.VoteAwardInfo;
/*     */ import xtable.Role2menpaistarcampaign;
/*     */ import xtable.Role2menpaistarvote;
/*     */ 
/*     */ public class MenPaiStarManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   static final int RATE = 100;
/*     */   
/*     */   static void init()
/*     */   {
/*  48 */     ActivityInterface.registerActivityByLogicType(79, new MenPaiStarActivityHandler(), false);
/*  49 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  51 */       return;
/*     */     }
/*     */     
/*  54 */     CampaignChartManager.init();
/*  55 */     MenPaiStarChartManager.init();
/*     */   }
/*     */   
/*     */   static boolean isFunOpen()
/*     */   {
/*  60 */     return OpenInterface.getOpenStatus(270);
/*     */   }
/*     */   
/*     */   static boolean isBanPlay(long roleid)
/*     */   {
/*  65 */     return OpenInterface.isBanPlay(roleid, 270);
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleid)
/*     */   {
/*  70 */     if (!OpenInterface.getOpenStatus(270))
/*     */     {
/*  72 */       GameServer.logger().error("[menpaistar]MenPaiStarManager.isFunOpen@fun not open");
/*  73 */       return false;
/*     */     }
/*  75 */     if (OpenInterface.isBanPlay(roleid, 270))
/*     */     {
/*  77 */       GameServer.logger().error(String.format("[menpaistar]MenPaiStarManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*  78 */       OpenInterface.sendBanPlayMsg(roleid, 270);
/*  79 */       return false;
/*     */     }
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/*  86 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, action, true);
/*     */   }
/*     */   
/*     */   static MenPaiStar getAndInitXMenPaiStar()
/*     */   {
/*  91 */     long key = GameServerInfoManager.getLocalId();
/*  92 */     MenPaiStar xMenPaiStar = xtable.Menpaistar.get(Long.valueOf(key));
/*  93 */     if (xMenPaiStar == null)
/*     */     {
/*  95 */       xMenPaiStar = Pod.newMenPaiStar();
/*  96 */       xtable.Menpaistar.insert(Long.valueOf(key), xMenPaiStar);
/*     */     }
/*  98 */     return xMenPaiStar;
/*     */   }
/*     */   
/*     */   static xbean.MenPaiStarInfo getAndInitXMenPaiStarInfo(int ocpid)
/*     */   {
/* 103 */     MenPaiStar xMenPaiStar = getAndInitXMenPaiStar();
/* 104 */     xbean.MenPaiStarInfo xMenPaiStarInfo = (xbean.MenPaiStarInfo)xMenPaiStar.getCharts().get(Integer.valueOf(ocpid));
/* 105 */     if (xMenPaiStarInfo == null)
/*     */     {
/* 107 */       xMenPaiStarInfo = Pod.newMenPaiStarInfo();
/* 108 */       xMenPaiStarInfo.setFinished(true);
/* 109 */       xMenPaiStar.getCharts().put(Integer.valueOf(ocpid), xMenPaiStarInfo);
/*     */     }
/* 111 */     return xMenPaiStarInfo;
/*     */   }
/*     */   
/*     */   static MenPaiStarChart getAndInitXMenPaiStarChart()
/*     */   {
/* 116 */     long key = GameServerInfoManager.getLocalId();
/* 117 */     MenPaiStarChart xMenPaiStarChart = xtable.Menpaistarchart.get(Long.valueOf(key));
/* 118 */     if (xMenPaiStarChart == null)
/*     */     {
/* 120 */       xMenPaiStarChart = Pod.newMenPaiStarChart();
/* 121 */       xtable.Menpaistarchart.insert(Long.valueOf(key), xMenPaiStarChart);
/*     */     }
/* 123 */     return xMenPaiStarChart;
/*     */   }
/*     */   
/*     */   static MenPaiStarChartInfo getXMenPaiStarChartInfo(int ocpid)
/*     */   {
/* 128 */     MenPaiStarChart xMenPaiStarChart = getAndInitXMenPaiStarChart();
/* 129 */     return (MenPaiStarChartInfo)xMenPaiStarChart.getCharts().get(Integer.valueOf(ocpid));
/*     */   }
/*     */   
/*     */   static CampaignCharts getAndInitXCampaignCharts()
/*     */   {
/* 134 */     long key = GameServerInfoManager.getLocalId();
/* 135 */     CampaignCharts xCampaignCharts = xtable.Campaigncharts.get(Long.valueOf(key));
/* 136 */     if (xCampaignCharts == null)
/*     */     {
/* 138 */       xCampaignCharts = Pod.newCampaignCharts();
/* 139 */       xtable.Campaigncharts.insert(Long.valueOf(key), xCampaignCharts);
/*     */     }
/* 141 */     return xCampaignCharts;
/*     */   }
/*     */   
/*     */   static CampaignChart getAndInitXCampaignChart(int ocpid)
/*     */   {
/* 146 */     CampaignCharts xCampaignCharts = getAndInitXCampaignCharts();
/* 147 */     CampaignChart xCampaignChart = (CampaignChart)xCampaignCharts.getCharts().get(Integer.valueOf(ocpid));
/* 148 */     if (xCampaignChart == null)
/*     */     {
/* 150 */       xCampaignChart = Pod.newCampaignChart();
/* 151 */       xCampaignCharts.getCharts().put(Integer.valueOf(ocpid), xCampaignChart);
/*     */     }
/* 153 */     return xCampaignChart;
/*     */   }
/*     */   
/*     */   static MenPaiStarChartInfo trans(MenPaiStarChartObj chartObj)
/*     */   {
/* 158 */     MenPaiStarChartInfo xMenPaiStarChartInfo = Pod.newMenPaiStarChartInfo();
/* 159 */     xMenPaiStarChartInfo.setOccupationid(chartObj.getOcpid());
/* 160 */     xMenPaiStarChartInfo.setPoint(chartObj.getPoint());
/* 161 */     xMenPaiStarChartInfo.setRole_name(chartObj.getName());
/* 162 */     xMenPaiStarChartInfo.setRoleid(chartObj.getRoleid());
/* 163 */     xMenPaiStarChartInfo.setUpdate_point_time(chartObj.getUpdatePointTime());
/* 164 */     return xMenPaiStarChartInfo;
/*     */   }
/*     */   
/*     */   static MenPaiStarCampaignInfo getAndInitXCampaignInfo(long roleid)
/*     */   {
/* 169 */     MenPaiStarCampaignInfo xCampaignInfo = Role2menpaistarcampaign.get(Long.valueOf(roleid));
/* 170 */     if (xCampaignInfo == null)
/*     */     {
/* 172 */       xCampaignInfo = Pod.newMenPaiStarCampaignInfo();
/* 173 */       Role2menpaistarcampaign.insert(Long.valueOf(roleid), xCampaignInfo);
/*     */     }
/* 175 */     return xCampaignInfo;
/*     */   }
/*     */   
/*     */   static MenPaiStarVoteInfo getAndInitXVoteInfo(long roleid)
/*     */   {
/* 180 */     MenPaiStarVoteInfo xVoteInfo = Role2menpaistarvote.get(Long.valueOf(roleid));
/* 181 */     if (xVoteInfo == null)
/*     */     {
/* 183 */       xVoteInfo = Pod.newMenPaiStarVoteInfo();
/* 184 */       Role2menpaistarvote.insert(Long.valueOf(roleid), xVoteInfo);
/*     */     }
/* 186 */     return xVoteInfo;
/*     */   }
/*     */   
/*     */   static SVotePointCfg getVotePointCfg(int level)
/*     */   {
/* 191 */     SVotePointCfg result = null;
/* 192 */     for (SVotePointCfg cfg : SVotePointCfg.getAll().values())
/*     */     {
/* 194 */       int maxLevel = cfg.maxLevel;
/* 195 */       if (maxLevel == level)
/*     */       {
/* 197 */         return cfg;
/*     */       }
/* 199 */       if (maxLevel >= level)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 205 */         if (result == null)
/*     */         {
/* 207 */           result = cfg;
/*     */ 
/*     */ 
/*     */         }
/* 211 */         else if (maxLevel < result.maxLevel)
/*     */         {
/* 213 */           result = cfg;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 218 */     return result;
/*     */   }
/*     */   
/*     */   static boolean checkAward(int award)
/*     */   {
/* 223 */     for (SVoteAwardCfg voteAwardCfg : SVoteAwardCfg.getAll().values())
/*     */     {
/* 225 */       if (voteAwardCfg.value == award)
/*     */       {
/* 227 */         return true;
/*     */       }
/*     */     }
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   static boolean checkVoteNum(int num)
/*     */   {
/* 235 */     for (SVoteNumCfg voteNumCfg : SVoteNumCfg.getAll().values())
/*     */     {
/* 237 */       if (voteNumCfg.num == num)
/*     */       {
/* 239 */         return true;
/*     */       }
/*     */     }
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   static void fillCampaignInfo(long roleid, mzm.gsp.menpaistar.MenPaiStarInfo menPaiStarInfo)
/*     */   {
/* 247 */     MenPaiStarCampaignInfo xCampaignInfo = Role2menpaistarcampaign.get(Long.valueOf(roleid));
/* 248 */     if (xCampaignInfo == null)
/*     */     {
/* 250 */       return;
/*     */     }
/*     */     
/* 253 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 254 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/* 255 */     if (xCampaign == null)
/*     */     {
/* 257 */       return;
/*     */     }
/*     */     
/* 260 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 261 */     long lastCamaignFightTime = xCampaignInfo.getLast_campaign_time();
/* 262 */     if (DateTimeUtils.needDailyReset(lastCamaignFightTime, now, 0, 0))
/*     */     {
/* 264 */       xCampaignInfo.setToday_campaign_num(0);
/* 265 */       xCampaignInfo.setLast_campaign_time(now);
/*     */     }
/*     */     
/* 268 */     menPaiStarInfo.campaign = ((byte)xCampaign.getCampaign());
/* 269 */     menPaiStarInfo.today_campaign_num = xCampaignInfo.getToday_campaign_num();
/* 270 */     menPaiStarInfo.last_campaign_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xCampaignInfo.getLast_campaign_time()));
/*     */   }
/*     */   
/*     */   static void fillVoteInfo(long roleid, mzm.gsp.menpaistar.MenPaiStarInfo menPaiStarInfo)
/*     */   {
/* 275 */     MenPaiStarVoteInfo xVoteInfo = Role2menpaistarvote.get(Long.valueOf(roleid));
/* 276 */     if (xVoteInfo == null)
/*     */     {
/* 278 */       return;
/*     */     }
/*     */     
/* 281 */     menPaiStarInfo.vote = ((byte)xVoteInfo.getVote());
/* 282 */     menPaiStarInfo.vote_num = xVoteInfo.getVote_num();
/*     */     
/*     */ 
/* 285 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 286 */     long lastVoteFightTime = xVoteInfo.getLast_vote_time();
/* 287 */     if (DateTimeUtils.needDailyReset(lastVoteFightTime, now, 0, 0))
/*     */     {
/* 289 */       xVoteInfo.setToday_vote_num(0);
/* 290 */       xVoteInfo.setLast_vote_time(now);
/*     */     }
/* 292 */     menPaiStarInfo.today_vote_num = xVoteInfo.getToday_vote_num();
/* 293 */     menPaiStarInfo.last_vote_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xVoteInfo.getLast_vote_time()));
/*     */     
/*     */ 
/* 296 */     Map<Long, Long> worldCanvass = xVoteInfo.getWorld_canvass();
/* 297 */     Iterator<Map.Entry<Long, Long>> it = worldCanvass.entrySet().iterator();
/* 298 */     int worldCd = SMenPaiStarConst.getInstance().WORLD_CHANNEL_CD;
/* 299 */     long milliseconds = TimeUnit.MINUTES.toMillis(worldCd);
/* 300 */     while (it.hasNext())
/*     */     {
/* 302 */       Map.Entry<Long, Long> entry = (Map.Entry)it.next();
/* 303 */       long value = ((Long)entry.getValue()).longValue();
/* 304 */       if (value + milliseconds <= now)
/*     */       {
/* 306 */         it.remove();
/*     */       }
/*     */       else {
/* 309 */         menPaiStarInfo.world_canvass.put(entry.getKey(), Integer.valueOf((int)TimeUnit.MILLISECONDS.toSeconds(value)));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 314 */     Map<Long, Long> gangCanvass = xVoteInfo.getGang_canvass();
/* 315 */     Iterator<Map.Entry<Long, Long>> it = gangCanvass.entrySet().iterator();
/* 316 */     int gangCd = SMenPaiStarConst.getInstance().GANG_CHANNEL_CD;
/* 317 */     long milliseconds = TimeUnit.MINUTES.toMillis(gangCd);
/* 318 */     while (it.hasNext())
/*     */     {
/* 320 */       Map.Entry<Long, Long> entry = (Map.Entry)it.next();
/* 321 */       long value = ((Long)entry.getValue()).longValue();
/* 322 */       if (value + milliseconds <= now)
/*     */       {
/* 324 */         it.remove();
/*     */       }
/*     */       else {
/* 327 */         menPaiStarInfo.gang_canvass.put(entry.getKey(), Integer.valueOf((int)TimeUnit.MILLISECONDS.toSeconds(value)));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void initData(long roleid)
/*     */   {
/* 334 */     returnCost(roleid, false);
/* 335 */     Role2menpaistarvote.remove(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void returnCost(long roleid, boolean checkTime)
/*     */   {
/* 345 */     MenPaiStarCampaignInfo xCampaignInfo = Role2menpaistarcampaign.get(Long.valueOf(roleid));
/* 346 */     if (xCampaignInfo == null)
/*     */     {
/* 348 */       return;
/*     */     }
/*     */     
/* 351 */     int activityid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 352 */     long activityStartTime = ActivityInterface.getActivityStartTime(activityid);
/* 353 */     long activityEndTime = ActivityInterface.getActivityEndTime(activityid);
/* 354 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 356 */     int yuanbao = 0;
/* 357 */     Iterator<Map.Entry<Integer, Campaign>> xIt = xCampaignInfo.getCampaigns().entrySet().iterator();
/* 358 */     while (xIt.hasNext())
/*     */     {
/* 360 */       Campaign xCampaign = (Campaign)((Map.Entry)xIt.next()).getValue();
/* 361 */       if (xCampaign.getCampaign() != 1)
/*     */       {
/* 363 */         xIt.remove();
/*     */ 
/*     */ 
/*     */       }
/* 367 */       else if (checkTime)
/*     */       {
/*     */ 
/* 370 */         long lastTime = xCampaign.getVote_award_info().getLast_time();
/* 371 */         if ((lastTime >= activityStartTime) && (lastTime < activityEndTime) && (now < activityEndTime)) {}
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 377 */         int num = xCampaign.getVote_award_info().getNum();
/* 378 */         if (num <= 0)
/*     */         {
/* 380 */           xIt.remove();
/*     */         }
/*     */         else
/*     */         {
/* 384 */           int award = xCampaign.getVote_award_info().getAward();
/* 385 */           yuanbao += award * num / 100;
/* 386 */           xIt.remove();
/*     */         }
/*     */       } }
/* 389 */     if (yuanbao > 0)
/*     */     {
/* 391 */       sendReturnCostMail(roleid, yuanbao);
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean sendReturnCostMail(long roleid, int yuanbao)
/*     */   {
/* 397 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 398 */     mailAttachment.setBindYuanBao(yuanbao);
/* 399 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.MENPAI_STAR_VOTE_AWARD_RETURN_COST);
/* 400 */     List<String> emptyStrings = java.util.Collections.emptyList();
/* 401 */     int mailCfgId = SMenPaiStarConst.getInstance().RETURN_VOTE_COST_MAIL_CFG_ID;
/* 402 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, mailCfgId, emptyStrings, emptyStrings, mailAttachment, tLogArg);
/*     */     
/* 404 */     if (!sendMailRet.isOK())
/*     */     {
/* 406 */       GameServer.logger().error(String.format("[menpaistar]MenPaiStarManager.sendReturnCostMail@send mail failed|roleid=%d|mail_ret=%s|yuanbao=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(sendMailRet.getRetEnum().ret), Integer.valueOf(yuanbao) }));
/*     */       
/*     */ 
/*     */ 
/* 410 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 414 */     addTLog(roleid, "MenPaiStarReturnCostForServer", new Object[] { Integer.valueOf(yuanbao), Integer.valueOf(mailCfgId) });
/* 415 */     GameServer.logger().info(String.format("[menpaistar]MenPaiStarManager.sendReturnCostMail@success|roleid=%d|yuanbao=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(yuanbao) }));
/*     */     
/* 417 */     return true;
/*     */   }
/*     */   
/*     */   static boolean onRoleSwitchOccup(long roleid, int oldOccup, int newOccup)
/*     */   {
/* 422 */     MenPaiStarCampaignInfo xCampaignInfo = Role2menpaistarcampaign.get(Long.valueOf(roleid));
/* 423 */     if (xCampaignInfo == null)
/*     */     {
/* 425 */       return true;
/*     */     }
/*     */     
/* 428 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 429 */     long voteEndTime = MenPaiStarConfigManager.voteEndTime();
/*     */     
/* 431 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(oldOccup));
/* 432 */     if ((xCampaign != null) && (xCampaign.getCampaign() == 1))
/*     */     {
/* 434 */       if (CampaignChartManager.canJoin(oldOccup))
/*     */       {
/* 436 */         if (now < voteEndTime)
/*     */         {
/* 438 */           RDeleteCampaign deleteCampaign = new RDeleteCampaign(oldOccup, roleid);
/* 439 */           UpdateCampaignOneByOne.getInstance().add(oldOccup, deleteCampaign);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 444 */       int num = xCampaign.getVote_award_info().getNum();
/* 445 */       if (num > 0)
/*     */       {
/* 447 */         int award = xCampaign.getVote_award_info().getAward();
/* 448 */         int yuanbao = award * num / 100;
/* 449 */         if (yuanbao > 0)
/*     */         {
/* 451 */           sendReturnCostMail(roleid, yuanbao);
/*     */         }
/*     */       }
/* 454 */       xCampaign.getVote_award_info().setAward(0);
/* 455 */       xCampaign.getVote_award_info().setNum(0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 460 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(newOccup));
/* 461 */     if ((xCampaign != null) && (xCampaign.getCampaign() == 1))
/*     */     {
/* 463 */       if (CampaignChartManager.canJoin(oldOccup))
/*     */       {
/* 465 */         if (now < voteEndTime)
/*     */         {
/* 467 */           int point = xCampaign.getPoint();
/* 468 */           long updatePointTime = xCampaign.getUpdate_point_time();
/* 469 */           String name = RoleInterface.getName(roleid);
/* 470 */           VoteAwardInfo xVoteAwardInfo = xCampaign.getVote_award_info();
/* 471 */           int award = xVoteAwardInfo.getAward();
/* 472 */           int num = xVoteAwardInfo.getNum();
/* 473 */           updateCampaignRankAsync(roleid, name, newOccup, point, updatePointTime, award, num);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 479 */     return true;
/*     */   }
/*     */   
/*     */   static int getMenPaiStarNpc(int ocpid)
/*     */   {
/* 484 */     SMenPaiStarNpcCfg cfg = SMenPaiStarNpcCfg.get(ocpid);
/* 485 */     if (cfg == null)
/*     */     {
/* 487 */       GameServer.logger().error(String.format("[menpaistar]MenPaiStarManager.getMenPaiStarChampionNpc@cfg is null|occupationid=%d", new Object[] { Integer.valueOf(ocpid) }));
/*     */       
/* 489 */       return -1;
/*     */     }
/* 491 */     return cfg.npcCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */   static void updateCampaignRankAsync(long roleid, String name, int ocpid, int point, long updatePointTime, int award, int num)
/*     */   {
/* 497 */     CampaignChartObj chartObj = new CampaignChartObj(roleid, ocpid, point, updatePointTime, name, award, num);
/* 498 */     RUpdateCampaign updateCampaign = new RUpdateCampaign(chartObj);
/* 499 */     UpdateCampaignOneByOne.getInstance().add(ocpid, updateCampaign);
/*     */   }
/*     */   
/*     */ 
/*     */   static void updateCampaignRank(long roleid, String name, int ocpid, int point, long updatePointTime, int award, int num)
/*     */   {
/* 505 */     CampaignChartObj chartObj = new CampaignChartObj(roleid, ocpid, point, updatePointTime, name, award, num);
/* 506 */     CampaignChartManager.rank(chartObj);
/*     */   }
/*     */   
/*     */   static void sendSupplyVoteAwardMail(long roleid)
/*     */   {
/* 511 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.MENPAI_STAR_SUPPLY_VOTE_AWARD);
/* 512 */     List<String> emptyStrings = java.util.Collections.emptyList();
/* 513 */     int mailCfgId = SMenPaiStarConst.getInstance().SUPPLY_VOTE_AWARD_MAIL_CFG_ID;
/* 514 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, mailCfgId, emptyStrings, emptyStrings, null, tLogArg);
/*     */     
/* 516 */     if (!sendMailRet.isOK())
/*     */     {
/* 518 */       GameServer.logger().error(String.format("[menpaistar]MenPaiStarManager.sendSupplyVoteAwardMail@send mail failed|roleid=%d|mail_ret=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(sendMailRet.getRetEnum().ret) }));
/*     */       
/*     */ 
/*     */ 
/* 522 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void onCampaignFightEnd(long roleid, boolean win)
/*     */   {
/* 529 */     MenPaiStarCampaignInfo xCampaignInfo = getAndInitXCampaignInfo(roleid);
/* 530 */     xCampaignInfo.setToday_campaign_num(xCampaignInfo.getToday_campaign_num() + 1);
/*     */     
/* 532 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 533 */     long campaignFightEndTime = MenPaiStarConfigManager.campaignFightEndTime();
/* 534 */     boolean timeOut = now >= campaignFightEndTime;
/* 535 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 536 */     if ((win) && (!timeOut))
/*     */     {
/* 538 */       Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/* 539 */       if (xCampaign == null)
/*     */       {
/* 541 */         xCampaign = Pod.newCampaign();
/* 542 */         xCampaignInfo.getCampaigns().put(Integer.valueOf(ocpid), xCampaign);
/*     */       }
/* 544 */       xCampaign.setCampaign(1);
/* 545 */       xCampaign.getVote_award_info().setLast_time(now);
/*     */       
/*     */ 
/* 548 */       updateCampaignRankAsync(roleid, RoleInterface.getName(roleid), ocpid, 0, now, 0, 0);
/*     */     }
/*     */     
/* 551 */     if (!timeOut)
/*     */     {
/*     */ 
/* 554 */       mzm.gsp.menpaistar.SSyncCampaignFightResult msg = new mzm.gsp.menpaistar.SSyncCampaignFightResult();
/* 555 */       msg.success = ((byte)(win ? 1 : 0));
/* 556 */       OnlineManager.getInstance().send(roleid, msg);
/*     */     }
/*     */     
/*     */ 
/* 560 */     addTLog(roleid, "MenPaiStarCampaignFightResultForServer", new Object[] { Integer.valueOf(ocpid), Integer.valueOf(win ? 1 : 0), Integer.valueOf(timeOut ? 1 : 0), Integer.valueOf(xCampaignInfo.getToday_campaign_num()) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void onVoteFightEnd(long roleid, boolean win)
/*     */   {
/* 567 */     MenPaiStarVoteInfo xVoteInfo = getAndInitXVoteInfo(roleid);
/* 568 */     xVoteInfo.setToday_vote_num(xVoteInfo.getToday_vote_num() + 1);
/* 569 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 570 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 571 */     long voteFightEndTime = MenPaiStarConfigManager.voteEndTime();
/* 572 */     boolean timeOut = now >= voteFightEndTime;
/* 573 */     if ((win) && (!timeOut))
/*     */     {
/* 575 */       xVoteInfo.setVote(1);
/*     */       
/* 577 */       xVoteInfo.setVote_num(0);
/*     */     }
/*     */     
/* 580 */     if (!timeOut)
/*     */     {
/*     */ 
/* 583 */       mzm.gsp.menpaistar.SSyncVoteFightResult msg = new mzm.gsp.menpaistar.SSyncVoteFightResult();
/* 584 */       msg.success = ((byte)(win ? 1 : 0));
/* 585 */       OnlineManager.getInstance().send(roleid, msg);
/*     */     }
/*     */     
/*     */ 
/* 589 */     addTLog(roleid, "MenPaiStarVoteFightResultForServer", new Object[] { Integer.valueOf(ocpid), Integer.valueOf(win ? 1 : 0), Integer.valueOf(timeOut ? 1 : 0), Integer.valueOf(xVoteInfo.getToday_vote_num()) });
/*     */   }
/*     */   
/*     */ 
/*     */   static void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 595 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 596 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 597 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 599 */     StringBuilder logStr = new StringBuilder();
/* 600 */     logStr.append(vGameIp);
/* 601 */     logStr.append("|").append(userid);
/* 602 */     logStr.append("|").append(roleid);
/* 603 */     logStr.append("|").append(roleLevel);
/*     */     
/* 605 */     for (Object colum : logColumns)
/*     */     {
/* 607 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 610 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */   
/*     */   static List<Integer> getNpcCfgids()
/*     */   {
/* 615 */     List<Integer> npcIds = new java.util.ArrayList();
/* 616 */     for (SMenPaiStarNpcCfg menPaiStarNpcCfg : SMenPaiStarNpcCfg.getAll().values())
/*     */     {
/* 618 */       npcIds.add(Integer.valueOf(menPaiStarNpcCfg.npcCfgid));
/*     */     }
/* 620 */     return npcIds;
/*     */   }
/*     */   
/*     */   static void sendSCommonResultRes(long roleId, int res, boolean rightNow)
/*     */   {
/* 625 */     mzm.gsp.role.SCommonResultRes sCommonResultRes = new mzm.gsp.role.SCommonResultRes();
/* 626 */     sCommonResultRes.result = res;
/* 627 */     if (rightNow)
/*     */     {
/* 629 */       OnlineManager.getInstance().sendAtOnce(roleId, sCommonResultRes);
/*     */     }
/*     */     else
/*     */     {
/* 633 */       OnlineManager.getInstance().send(roleId, sCommonResultRes);
/*     */     }
/*     */   }
/*     */   
/*     */   static void syncEffectNpcs(long roleid)
/*     */   {
/* 639 */     SyncEffectNpcs msg = new SyncEffectNpcs();
/* 640 */     for (Iterator i$ = MenPaiStarConfigManager.getOcpids().iterator(); i$.hasNext();) { int ocpid = ((Integer)i$.next()).intValue();
/*     */       
/* 642 */       int npcCfgid = MenPaiStarConfigManager.getNpc(ocpid);
/* 643 */       mzm.gsp.pubdata.ModelInfo modelInfo = mzm.gsp.map.main.MapInterface.getCloneRoleNpcPubModelInfo(mzm.gsp.map.main.CloneRoleNpcModelType.MEN_PAI_STAR, npcCfgid, false);
/*     */       
/* 645 */       if (modelInfo == null)
/*     */       {
/* 647 */         msg.npccfgids.put(Integer.valueOf(ocpid), Long.valueOf(0L));
/*     */       }
/*     */       else
/*     */       {
/* 651 */         long champion = CampaignChartManager.getLastChampion(ocpid);
/* 652 */         msg.npccfgids.put(Integer.valueOf(ocpid), Long.valueOf(champion));
/*     */       }
/*     */     }
/* 655 */     OnlineManager.getInstance().send(roleid, msg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\MenPaiStarManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */