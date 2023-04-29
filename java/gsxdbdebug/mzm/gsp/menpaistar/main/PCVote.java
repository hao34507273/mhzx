/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.menpaistar.SVoteFailed;
/*     */ import mzm.gsp.menpaistar.SVoteSuccess;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.menpaistar.confbean.SVotePointCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Campaign;
/*     */ import xbean.MenPaiStarCampaignInfo;
/*     */ import xbean.MenPaiStarVoteInfo;
/*     */ import xbean.VoteAwardInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2menpaistarcampaign;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCVote extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   private final int voteNum;
/*     */   
/*     */   public PCVote(long roleid, long targetRoleid, int voteNum)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.targetRoleid = targetRoleid;
/*  40 */     this.voteNum = voteNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if ((this.targetRoleid < 0L) || (this.voteNum < 0))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1006))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     long endTime = MenPaiStarConfigManager.voteEndTime();
/*  63 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  64 */     if (now >= endTime)
/*     */     {
/*     */ 
/*  67 */       Map<String, Object> extras = new HashMap();
/*  68 */       extras.put("end_time", Long.valueOf(endTime));
/*  69 */       onFailed(15, extras);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/*  75 */     if (!CampaignChartManager.canJoin(ocpid))
/*     */     {
/*  77 */       Map<String, Object> extras = new HashMap();
/*  78 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  79 */       onFailed(-4, extras);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     CampaignChartObj chartObj = CampaignChartManager.getChartObjByRoleid(ocpid, this.targetRoleid);
/*  85 */     if (chartObj == null)
/*     */     {
/*  87 */       onFailed(-3);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     String userid = RoleInterface.getUserId(this.roleid);
/*  92 */     if (userid == null)
/*     */     {
/*  94 */       onFailed(2);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     lock(Lockeys.get(User.getTable(), userid));
/* 100 */     lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     
/* 102 */     int activityCfgid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 103 */     ActivityJoinResult joinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*     */     
/* 105 */     if (!joinResult.isCanJoin())
/*     */     {
/* 107 */       Map<String, Object> extras = new HashMap();
/* 108 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/* 109 */       extras.put("reason", Integer.valueOf(joinResult.getReasonValue()));
/* 110 */       onFailed(17, extras);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     MenPaiStarVoteInfo xVoteInfo = xtable.Role2menpaistarvote.get(Long.valueOf(this.roleid));
/* 115 */     if (xVoteInfo == null)
/*     */     {
/* 117 */       onFailed(9);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (xVoteInfo.getVote() != 1)
/*     */     {
/* 123 */       Map<String, Object> extras = new HashMap();
/* 124 */       extras.put("vote", Integer.valueOf(xVoteInfo.getVote()));
/* 125 */       onFailed(9, extras);
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     if (xVoteInfo.getVote_num() >= SMenPaiStarConst.getInstance().VOTE_NUM)
/*     */     {
/* 131 */       onFailed(-1);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     MenPaiStarCampaignInfo xCampaignInfo = Role2menpaistarcampaign.get(Long.valueOf(this.targetRoleid));
/* 136 */     if (xCampaignInfo == null)
/*     */     {
/* 138 */       onFailed(8);
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     int targetOcpid = RoleInterface.getOccupationId(this.targetRoleid);
/* 143 */     if (ocpid != targetOcpid)
/*     */     {
/* 145 */       Map<String, Object> extras = new HashMap();
/* 146 */       extras.put("occupationid", Integer.valueOf(ocpid));
/* 147 */       extras.put("target_occupationid", Integer.valueOf(targetOcpid));
/* 148 */       onFailed(-3, extras);
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/* 153 */     if (xCampaign == null)
/*     */     {
/* 155 */       onFailed(8);
/* 156 */       return false;
/*     */     }
/* 158 */     if (xCampaign.getCampaign() != 1)
/*     */     {
/* 160 */       Map<String, Object> extras = new HashMap();
/* 161 */       extras.put("campaign", Integer.valueOf(xCampaign.getCampaign()));
/* 162 */       onFailed(8, extras);
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     int level = RoleInterface.getLevel(this.roleid);
/* 167 */     SVotePointCfg votePointCfg = MenPaiStarManager.getVotePointCfg(level);
/* 168 */     if (votePointCfg == null)
/*     */     {
/* 170 */       Map<String, Object> extras = new HashMap();
/* 171 */       extras.put("level", Integer.valueOf(level));
/* 172 */       onFailed(3, extras);
/* 173 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 177 */     xVoteInfo.setVote_num(xVoteInfo.getVote_num() + 1);
/*     */     
/*     */ 
/* 180 */     MenPaiStarManager.addTLog(this.roleid, "MenPaiStarAddVoteNumForServer", new Object[] { Integer.valueOf(ocpid), Long.valueOf(this.targetRoleid), Integer.valueOf(xVoteInfo.getVote_num()) });
/*     */     
/*     */ 
/* 183 */     UpdateCampaignOneByOne.getInstance().add(ocpid, new PVote(userid, this.roleid, ocpid, this.targetRoleid, this.voteNum));
/*     */     
/* 185 */     GameServer.logger().info(String.format("[menpaistar]PCVote.processImp@vote success|roleid=%d|target_roleid=%d|vote_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid), Integer.valueOf(this.voteNum) }));
/*     */     
/*     */ 
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 193 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 198 */     SVoteFailed resp = new SVoteFailed();
/* 199 */     resp.target_roleid = this.targetRoleid;
/* 200 */     resp.vote_num = this.voteNum;
/* 201 */     resp.retcode = retcode;
/* 202 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 204 */     StringBuffer logBuilder = new StringBuffer();
/* 205 */     logBuilder.append("[menpaistar]PCVote.onFailed@vote failed");
/* 206 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 207 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 208 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 210 */     if (extraParams != null)
/*     */     {
/* 212 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 214 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 218 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */   private static class PVote extends LogicProcedure
/*     */   {
/*     */     private final String userid;
/*     */     private final long roleid;
/*     */     private final int ocpid;
/*     */     private final long targetRoleid;
/*     */     private final int voteNum;
/*     */     
/*     */     public PVote(String userid, long roleid, int ocpid, long targetRoleid, int voteNum)
/*     */     {
/* 231 */       this.userid = userid;
/* 232 */       this.roleid = roleid;
/* 233 */       this.ocpid = ocpid;
/* 234 */       this.targetRoleid = targetRoleid;
/* 235 */       this.voteNum = voteNum;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 241 */       if (!MenPaiStarManager.canDoAction(this.roleid, 1006))
/*     */       {
/* 243 */         return false;
/*     */       }
/*     */       
/* 246 */       if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */       {
/* 248 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 252 */       if (!CampaignChartManager.canJoin(this.ocpid))
/*     */       {
/* 254 */         Map<String, Object> extras = new HashMap();
/* 255 */         extras.put("occupationid", Integer.valueOf(this.ocpid));
/* 256 */         onFailed(-4, extras);
/* 257 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 261 */       lock(Lockeys.get(User.getTable(), this.userid));
/* 262 */       lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */       
/* 264 */       MenPaiStarVoteInfo xVoteInfo = xtable.Role2menpaistarvote.get(Long.valueOf(this.roleid));
/* 265 */       if (xVoteInfo == null)
/*     */       {
/* 267 */         onFailed(9);
/* 268 */         return false;
/*     */       }
/*     */       
/* 271 */       if (xVoteInfo.getVote() != 1)
/*     */       {
/* 273 */         Map<String, Object> extras = new HashMap();
/* 274 */         extras.put("vote", Integer.valueOf(xVoteInfo.getVote()));
/* 275 */         onFailed(9, extras);
/* 276 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 280 */       CampaignChartObj chartObj = CampaignChartManager.getChartObjByRoleid(this.ocpid, this.targetRoleid);
/* 281 */       if (chartObj == null)
/*     */       {
/* 283 */         onFailed(-3);
/*     */         
/* 285 */         new PAddVoteNum(this.roleid).execute();
/* 286 */         return false;
/*     */       }
/*     */       
/* 289 */       MenPaiStarCampaignInfo xCampaignInfo = Role2menpaistarcampaign.get(Long.valueOf(this.targetRoleid));
/* 290 */       if (xCampaignInfo == null)
/*     */       {
/* 292 */         onFailed(8);
/* 293 */         return false;
/*     */       }
/*     */       
/* 296 */       int targetOcpid = RoleInterface.getOccupationId(this.targetRoleid);
/* 297 */       if (this.ocpid != targetOcpid)
/*     */       {
/* 299 */         Map<String, Object> extras = new HashMap();
/* 300 */         extras.put("occupationid", Integer.valueOf(this.ocpid));
/* 301 */         extras.put("target_occupationid", Integer.valueOf(targetOcpid));
/* 302 */         onFailed(-3, extras);
/*     */         
/*     */ 
/* 305 */         new PAddVoteNum(this.roleid).execute();
/* 306 */         return false;
/*     */       }
/*     */       
/* 309 */       Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(this.ocpid));
/* 310 */       if (xCampaign == null)
/*     */       {
/* 312 */         onFailed(8);
/* 313 */         return false;
/*     */       }
/* 315 */       if (xCampaign.getCampaign() != 1)
/*     */       {
/* 317 */         Map<String, Object> extras = new HashMap();
/* 318 */         extras.put("campaign", Integer.valueOf(xCampaign.getCampaign()));
/* 319 */         onFailed(8, extras);
/* 320 */         return false;
/*     */       }
/*     */       
/* 323 */       int level = RoleInterface.getLevel(this.roleid);
/* 324 */       SVotePointCfg votePointCfg = MenPaiStarManager.getVotePointCfg(level);
/* 325 */       if (votePointCfg == null)
/*     */       {
/* 327 */         Map<String, Object> extras = new HashMap();
/* 328 */         extras.put("level", Integer.valueOf(level));
/* 329 */         onFailed(3, extras);
/* 330 */         return false;
/*     */       }
/*     */       
/* 333 */       int addPoint = votePointCfg.point;
/* 334 */       int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/* 335 */       if (level > serverLevel)
/*     */       {
/* 337 */         addPoint = votePointCfg.overflow;
/*     */       }
/*     */       
/*     */ 
/* 341 */       VoteAwardInfo xVoteAwardInfo = xCampaign.getVote_award_info();
/* 342 */       int realNum = xVoteAwardInfo.getNum();
/* 343 */       int award = xVoteAwardInfo.getAward();
/* 344 */       if (realNum > 0)
/*     */       {
/* 346 */         TLogArg tlogArg = new TLogArg(LogReason.MENPAI_STAR_VOTE_GOLD);
/* 347 */         ModMoneyResult moneyResult = RoleInterface.addGold(this.roleid, award, tlogArg, true);
/* 348 */         if (moneyResult.getRes() == mzm.gsp.role.main.ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*     */         {
/* 350 */           MenPaiStarManager.sendSCommonResultRes(this.roleid, 11, true);
/*     */           
/* 352 */           new PAddVoteNum(this.roleid).execute();
/* 353 */           return false;
/*     */         }
/*     */       }
/* 356 */       int voteAwardCfgid = SMenPaiStarConst.getInstance().VOTE_AWARD_CFG_ID;
/* 357 */       AwardReason awardReason = new AwardReason(LogReason.MENPAI_STAR_VOTE_AWARD, voteAwardCfgid);
/* 358 */       mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(voteAwardCfgid, this.userid, this.roleid, true, true, awardReason);
/* 359 */       if (awardModel == null)
/*     */       {
/* 361 */         Map<String, Object> extras = new HashMap();
/* 362 */         extras.put("award_cfgid", Integer.valueOf(voteAwardCfgid));
/* 363 */         onFailed(3, extras);
/*     */         
/*     */ 
/* 366 */         new PAddVoteNum(this.roleid).execute();
/* 367 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 371 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 372 */       xCampaign.setPoint(xCampaign.getPoint() + addPoint);
/* 373 */       xCampaign.setUpdate_point_time(now);
/* 374 */       if (realNum > 0)
/*     */       {
/* 376 */         int newNum = realNum - 1;
/* 377 */         xVoteAwardInfo.setNum(newNum);
/* 378 */         if (newNum == 0)
/*     */         {
/* 380 */           MenPaiStarManager.sendSupplyVoteAwardMail(this.targetRoleid);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 385 */       MenPaiStarManager.addTLog(this.roleid, "MenPaiStarVoteSuccessForServer", new Object[] { Integer.valueOf(this.ocpid), Long.valueOf(this.targetRoleid), Integer.valueOf(addPoint), Integer.valueOf(xCampaign.getPoint()), Integer.valueOf(xVoteInfo.getVote_num()), Integer.valueOf(voteAwardCfgid), Integer.valueOf(realNum > 0 ? award : 0) });
/*     */       
/*     */ 
/*     */ 
/* 389 */       MenPaiStarManager.updateCampaignRank(this.targetRoleid, RoleInterface.getName(this.targetRoleid), this.ocpid, xCampaign.getPoint(), now, award, xVoteAwardInfo.getNum());
/*     */       
/*     */ 
/* 392 */       SVoteSuccess rsp = new SVoteSuccess();
/* 393 */       if (realNum > 0)
/*     */       {
/* 395 */         rsp.gold = award;
/*     */       }
/* 397 */       rsp.point = addPoint;
/* 398 */       rsp.vote_num = this.voteNum;
/* 399 */       rsp.target_roleid = this.targetRoleid;
/* 400 */       OnlineManager.getInstance().send(this.roleid, rsp);
/*     */       
/* 402 */       GameServer.logger().info(String.format("[menpaistar]PVote.processImp@vote success|roleid=%d|target_roleid=%d|vote_num=%d|target_vote_num=%d|target_award=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid), Integer.valueOf(this.voteNum), Integer.valueOf(xVoteAwardInfo.getNum()), Integer.valueOf(award) }));
/*     */       
/*     */ 
/*     */ 
/* 406 */       return true;
/*     */     }
/*     */     
/*     */     private void onFailed(int retcode)
/*     */     {
/* 411 */       onFailed(retcode, null);
/*     */     }
/*     */     
/*     */     private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */     {
/* 416 */       SVoteFailed resp = new SVoteFailed();
/* 417 */       resp.target_roleid = this.targetRoleid;
/* 418 */       resp.vote_num = this.voteNum;
/* 419 */       resp.retcode = retcode;
/* 420 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */       
/* 422 */       StringBuffer logBuilder = new StringBuffer();
/* 423 */       logBuilder.append("[menpaistar]PVote.onFailed@vote failed");
/* 424 */       logBuilder.append('|').append("roleid=").append(this.roleid);
/* 425 */       logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 426 */       logBuilder.append('|').append("retcode=").append(retcode);
/*     */       
/* 428 */       if (extraParams != null)
/*     */       {
/* 430 */         for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */         {
/* 432 */           logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */         }
/*     */       }
/*     */       
/* 436 */       GameServer.logger().error(logBuilder.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCVote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */