/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.menpaistar.SSetAwardFailed;
/*     */ import mzm.gsp.menpaistar.SSetAwardSuccess;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Campaign;
/*     */ import xbean.MenPaiStarCampaignInfo;
/*     */ import xtable.Role2menpaistarcampaign;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCSetAward extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long clientYuanbao;
/*     */   private final mzm.gsp.menpaistar.VoteAwardInfo voteAwardInfo;
/*     */   private final int voteNum;
/*     */   
/*     */   public PCSetAward(long roleid, long clientYuanbao, mzm.gsp.menpaistar.VoteAwardInfo voteAwardInfo, int voteNum)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.clientYuanbao = clientYuanbao;
/*  39 */     this.voteAwardInfo = voteAwardInfo;
/*  40 */     this.voteNum = voteNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     int award = this.voteAwardInfo.award;
/*  47 */     int num = this.voteAwardInfo.num;
/*  48 */     if ((this.voteNum < 0) || (award <= 0) || (num <= 0))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1005))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!MenPaiStarManager.checkAward(award))
/*     */     {
/*  65 */       Map<String, Object> extras = new HashMap();
/*  66 */       extras.put("award", Integer.valueOf(award));
/*  67 */       onFailed(3, extras);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!MenPaiStarManager.checkVoteNum(num))
/*     */     {
/*  73 */       Map<String, Object> extras = new HashMap();
/*  74 */       extras.put("num", Integer.valueOf(num));
/*  75 */       onFailed(3, extras);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     long endTime = MenPaiStarConfigManager.voteEndTime();
/*  81 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  82 */     if (now >= endTime)
/*     */     {
/*     */ 
/*  85 */       Map<String, Object> extras = new HashMap();
/*  86 */       extras.put("end_time", Long.valueOf(endTime));
/*  87 */       onFailed(15, extras);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/*  93 */     if (!CampaignChartManager.canJoin(ocpid))
/*     */     {
/*  95 */       Map<String, Object> extras = new HashMap();
/*  96 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  97 */       onFailed(-3, extras);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     CampaignChartObj chartObj = CampaignChartManager.getChartObjByRoleid(ocpid, this.roleid);
/* 103 */     if (chartObj == null)
/*     */     {
/* 105 */       onFailed(19);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     String userid = RoleInterface.getUserId(this.roleid);
/* 110 */     if (userid == null)
/*     */     {
/* 112 */       onFailed(2);
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     UpdateCampaignOneByOne.getInstance().add(ocpid, new PSetAward(userid, this.roleid, ocpid, this.clientYuanbao, award, num, this.voteNum));
/*     */     
/*     */ 
/* 119 */     GameServer.logger().info(String.format("[menpaistar]PCSetAward.processImp@add queue success|roleid=%d|ocpid=%d|vote_num=%d|award=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(ocpid), Integer.valueOf(this.voteNum), Integer.valueOf(award), Integer.valueOf(num) }));
/*     */     
/*     */ 
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 128 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 133 */     SSetAwardFailed resp = new SSetAwardFailed();
/* 134 */     resp.client_yuanbao = this.clientYuanbao;
/* 135 */     resp.vote_num = this.voteNum;
/* 136 */     resp.vote_award_info = this.voteAwardInfo;
/* 137 */     resp.retcode = retcode;
/* 138 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 140 */     StringBuffer logBuilder = new StringBuffer();
/* 141 */     logBuilder.append("[menpaistar]PCSetAward.onFailed@set award failed");
/* 142 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 143 */     logBuilder.append('|').append("client_yuanbao=").append(this.clientYuanbao);
/* 144 */     logBuilder.append('|').append("vote_num=").append(this.voteNum);
/* 145 */     logBuilder.append('|').append("award=").append(this.voteAwardInfo.award);
/* 146 */     logBuilder.append('|').append("num=").append(this.voteAwardInfo.num);
/* 147 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 149 */     if (extraParams != null)
/*     */     {
/* 151 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 153 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 157 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */   private static class PSetAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final String userid;
/*     */     private final long roleid;
/*     */     private final int ocpid;
/*     */     private final long clientYuanbao;
/*     */     private final int award;
/*     */     private final int num;
/*     */     private final int voteNum;
/*     */     
/*     */     public PSetAward(String userid, long roleid, int ocpid, long clientYuanbao, int award, int num, int voteNum)
/*     */     {
/* 173 */       this.userid = userid;
/* 174 */       this.roleid = roleid;
/* 175 */       this.ocpid = ocpid;
/* 176 */       this.clientYuanbao = clientYuanbao;
/* 177 */       this.award = award;
/* 178 */       this.num = num;
/* 179 */       this.voteNum = voteNum;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 185 */       if (!MenPaiStarManager.canDoAction(this.roleid, 1005))
/*     */       {
/* 187 */         return false;
/*     */       }
/*     */       
/* 190 */       if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */       {
/* 192 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 196 */       if (!CampaignChartManager.canJoin(this.ocpid))
/*     */       {
/* 198 */         Map<String, Object> extras = new HashMap();
/* 199 */         extras.put("occupationid", Integer.valueOf(this.ocpid));
/* 200 */         onFailed(-3, extras);
/* 201 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 205 */       CampaignChartObj chartObj = CampaignChartManager.getChartObjByRoleid(this.ocpid, this.roleid);
/* 206 */       if (chartObj == null)
/*     */       {
/* 208 */         onFailed(19);
/* 209 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 213 */       lock(xdb.Lockeys.get(User.getTable(), this.userid));
/* 214 */       int activityCfgid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 215 */       ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(this.userid, this.roleid, activityCfgid);
/*     */       
/* 217 */       if (!joinResult.isCanJoin())
/*     */       {
/* 219 */         Map<String, Object> extras = new HashMap();
/* 220 */         extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/* 221 */         extras.put("reason", Integer.valueOf(joinResult.getReasonValue()));
/* 222 */         onFailed(17, extras);
/* 223 */         return false;
/*     */       }
/*     */       
/* 226 */       MenPaiStarCampaignInfo xCampaignInfo = Role2menpaistarcampaign.get(Long.valueOf(this.roleid));
/* 227 */       if (xCampaignInfo == null)
/*     */       {
/* 229 */         onFailed(8);
/* 230 */         return false;
/*     */       }
/*     */       
/* 233 */       Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(this.ocpid));
/* 234 */       if ((xCampaign == null) || (xCampaign.getCampaign() != 1))
/*     */       {
/* 236 */         Map<String, Object> extras = new HashMap();
/* 237 */         extras.put("occupationid", Integer.valueOf(this.ocpid));
/* 238 */         onFailed(8, extras);
/* 239 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 243 */       xbean.VoteAwardInfo xVoteAwardInfo = xCampaign.getVote_award_info();
/* 244 */       if (xVoteAwardInfo.getNum() != this.voteNum)
/*     */       {
/* 246 */         onFailed(-2);
/* 247 */         return false;
/*     */       }
/*     */       
/* 250 */       int oldGold = xVoteAwardInfo.getAward();
/* 251 */       if ((oldGold == this.award) && (this.voteNum == this.num))
/*     */       {
/*     */ 
/* 254 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 258 */       int rate = 100;
/* 259 */       int oldYuanbao = oldGold * this.voteNum / 100;
/* 260 */       int newYuanbao = this.award * this.num / 100;
/* 261 */       int costYuanbao = newYuanbao - oldYuanbao;
/*     */       
/* 263 */       if (costYuanbao < 0)
/*     */       {
/* 265 */         if (!MenPaiStarManager.sendReturnCostMail(this.roleid, -costYuanbao))
/*     */         {
/* 267 */           onFailed(1);
/* 268 */           return false;
/*     */         }
/*     */       }
/* 271 */       else if (costYuanbao > 0)
/*     */       {
/* 273 */         long yuanbao = QingfuInterface.getBalance(this.userid, true);
/* 274 */         if (yuanbao != this.clientYuanbao)
/*     */         {
/* 276 */           onFailed(4);
/* 277 */           return false;
/*     */         }
/*     */         
/* 280 */         TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.MENPAI_STAR_SET_VOTE_AWARD);
/* 281 */         CostResult costResult = QingfuInterface.costYuanbao(this.userid, this.roleid, costYuanbao, CostType.COST_BIND_FIRST_SET_VOTE_AWARD, tLogArg);
/*     */         
/* 283 */         if (costResult != CostResult.Success)
/*     */         {
/* 285 */           Map<String, Object> extras = new HashMap();
/* 286 */           extras.put("cost_yuanbao", Integer.valueOf(costYuanbao));
/* 287 */           extras.put("cost_code", Integer.valueOf(costResult.code));
/* 288 */           onFailed(-1, extras);
/* 289 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 294 */       xVoteAwardInfo.setAward(this.award);
/* 295 */       xVoteAwardInfo.setNum(this.num);
/*     */       
/*     */ 
/* 298 */       String name = RoleInterface.getName(this.roleid);
/* 299 */       MenPaiStarManager.updateCampaignRank(this.roleid, name, this.ocpid, xCampaign.getPoint(), xCampaign.getUpdate_point_time(), this.award, this.num);
/*     */       
/*     */ 
/*     */ 
/* 303 */       addTlog(this.userid, this.ocpid, oldGold, this.voteNum, this.award, this.num, costYuanbao);
/*     */       
/* 305 */       SSetAwardSuccess resp = new SSetAwardSuccess();
/* 306 */       resp.vote_award_info = new mzm.gsp.menpaistar.VoteAwardInfo(this.award, this.num);
/* 307 */       OnlineManager.getInstance().send(this.roleid, resp);
/*     */       
/* 309 */       GameServer.logger().info(String.format("[menpaistar]PSetAward.processImp@set award success|roleid=%d|vote_num=%d|old_gold=%d|award=%d|num=%d|cost_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.voteNum), Integer.valueOf(oldGold), Integer.valueOf(this.award), Integer.valueOf(this.num), Integer.valueOf(costYuanbao) }));
/*     */       
/*     */ 
/*     */ 
/* 313 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     private void addTlog(String userid, int ocpid, int oldGold, int oldNum, int gold, int num, int costYuanbao)
/*     */     {
/* 319 */       String vGameIp = GameServerInfoManager.getHostIP();
/* 320 */       int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */       
/* 322 */       TLogManager.getInstance().addLog(userid, "MenPaiStarSetVoteAwardForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(ocpid), Integer.valueOf(oldGold), Integer.valueOf(oldNum), Integer.valueOf(gold), Integer.valueOf(num), Integer.valueOf(costYuanbao) });
/*     */     }
/*     */     
/*     */ 
/*     */     private void onFailed(int retcode)
/*     */     {
/* 328 */       onFailed(retcode, null);
/*     */     }
/*     */     
/*     */     private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */     {
/* 333 */       SSetAwardFailed resp = new SSetAwardFailed();
/* 334 */       resp.client_yuanbao = this.clientYuanbao;
/* 335 */       resp.vote_num = this.voteNum;
/* 336 */       resp.vote_award_info = new mzm.gsp.menpaistar.VoteAwardInfo(this.award, this.num);
/* 337 */       resp.retcode = retcode;
/* 338 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */       
/* 340 */       StringBuffer logBuilder = new StringBuffer();
/* 341 */       logBuilder.append("[menpaistar]PSetAward.onFailed@set award failed");
/* 342 */       logBuilder.append('|').append("roleid=").append(this.roleid);
/* 343 */       logBuilder.append('|').append("client_yuanbao=").append(this.clientYuanbao);
/* 344 */       logBuilder.append('|').append("vote_num=").append(this.voteNum);
/* 345 */       logBuilder.append('|').append("award=").append(this.award);
/* 346 */       logBuilder.append('|').append("num=").append(this.num);
/* 347 */       logBuilder.append('|').append("retcode=").append(retcode);
/*     */       
/* 349 */       if (extraParams != null)
/*     */       {
/* 351 */         for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */         {
/* 353 */           logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */         }
/*     */       }
/*     */       
/* 357 */       GameServer.logger().error(logBuilder.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCSetAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */