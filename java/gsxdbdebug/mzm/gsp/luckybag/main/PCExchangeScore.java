/*     */ package mzm.gsp.luckybag.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.luckybag.SExchangeScoreFailed;
/*     */ import mzm.gsp.luckybag.SExchangeScoreSuccess;
/*     */ import mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts;
/*     */ import mzm.gsp.luckybag.confbean.SLuckyBagScoreCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LuckyBagInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2luckybag;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCExchangeScore extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int luckyBagScoreCfgid;
/*     */   private final int clientScore;
/*     */   private final int num;
/*     */   
/*     */   public PCExchangeScore(long roleid, int luckyBagScoreCfgid, int clientScore, int num)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.luckyBagScoreCfgid = luckyBagScoreCfgid;
/*  37 */     this.clientScore = clientScore;
/*  38 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if ((this.luckyBagScoreCfgid <= 0) || (this.clientScore <= 0) || (this.num <= 0))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!LuckyBagManager.canDoAction(this.roleid, 1091))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!LuckyBagManager.isFunOpen(this.roleid))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     SLuckyBagScoreCfg luckyBagScoreCfg = SLuckyBagScoreCfg.get(this.luckyBagScoreCfgid);
/*  60 */     if (luckyBagScoreCfg == null)
/*     */     {
/*  62 */       onFailed(4);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     String userid = RoleInterface.getUserId(this.roleid);
/*  67 */     if (userid == null)
/*     */     {
/*  69 */       onFailed(1);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  76 */     int activityCfgid = SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID;
/*  77 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid).isCanJoin())
/*     */     {
/*  79 */       onFailed(-3);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     LuckyBagInfo xLuckyBagInfo = Role2luckybag.get(Long.valueOf(this.roleid));
/*  84 */     if (xLuckyBagInfo == null)
/*     */     {
/*  86 */       onFailed(1);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     int beginScore = xLuckyBagInfo.getScore();
/*  91 */     if (beginScore != this.clientScore)
/*     */     {
/*  93 */       Map<String, Object> extras = new HashMap();
/*  94 */       extras.put("begin_score", Integer.valueOf(beginScore));
/*  95 */       onFailed(5, extras);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     int needScore = luckyBagScoreCfg.scoreValue * this.num;
/* 100 */     if (beginScore < needScore)
/*     */     {
/* 102 */       Map<String, Object> extras = new HashMap();
/* 103 */       extras.put("begin_score", Integer.valueOf(beginScore));
/* 104 */       extras.put("need_score", Integer.valueOf(needScore));
/* 105 */       onFailed(-1, extras);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     int endScore = beginScore - needScore;
/* 110 */     if (endScore >= beginScore)
/*     */     {
/* 112 */       Map<String, Object> extras = new HashMap();
/* 113 */       extras.put("begin_score", Integer.valueOf(beginScore));
/* 114 */       extras.put("need_score", Integer.valueOf(needScore));
/* 115 */       onFailed(1, extras);
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     int num = ItemInterface.getAvailableGridNum(this.roleid, 340600000, true);
/* 121 */     if (num <= 0)
/*     */     {
/* 123 */       onFailed(-2);
/* 124 */       return false;
/*     */     }
/* 126 */     int awardCfgid = luckyBagScoreCfg.awardId;
/* 127 */     int needNum = getGridNum(this.roleid, awardCfgid, this.num);
/* 128 */     if (needNum <= 0)
/*     */     {
/*     */ 
/* 131 */       Map<String, Object> extras = new HashMap();
/* 132 */       extras.put("award_cfgid", Integer.valueOf(awardCfgid));
/* 133 */       extras.put("need_num", Integer.valueOf(needNum));
/* 134 */       onFailed(1, extras);
/* 135 */       return false;
/*     */     }
/* 137 */     if (needNum > num)
/*     */     {
/* 139 */       onFailed(-4);
/* 140 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 144 */     xLuckyBagInfo.setScore(endScore);
/*     */     
/*     */ 
/* 147 */     AwardReason awardReason = new AwardReason(LogReason.LUKCY_BAG_EXCHANGE_SCORE, awardCfgid);
/* 148 */     awardReason.setAwardItemBind(true);
/* 149 */     AwardModel awardModel = AwardInterface.awardFixAwardNTime(awardCfgid, this.num, userid, this.roleid, true, true, awardReason);
/*     */     
/* 151 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 154 */       Map<String, Object> extras = new HashMap();
/* 155 */       extras.put("award_cfgid", Integer.valueOf(awardCfgid));
/* 156 */       onFailed(1, extras);
/* 157 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 161 */     LuckyBagManager.addTLog(this.roleid, "LuckyBagScoreExchangeForServer", new Object[] { Integer.valueOf(beginScore), Integer.valueOf(endScore), Integer.valueOf(needScore), Integer.valueOf(awardCfgid), Integer.valueOf(activityCfgid), Integer.valueOf(this.num) });
/*     */     
/*     */ 
/* 164 */     SExchangeScoreSuccess rsp = new SExchangeScoreSuccess();
/* 165 */     rsp.score = endScore;
/* 166 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 168 */     GameServer.logger().info(String.format("[luckybag]PCExchangeScore.processImp@exchange score success|roleid=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(awardCfgid) }));
/*     */     
/*     */ 
/* 171 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 176 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 181 */     SExchangeScoreFailed rsp = new SExchangeScoreFailed();
/* 182 */     rsp.retcode = retcode;
/* 183 */     rsp.client_score = this.clientScore;
/* 184 */     rsp.lucky_bag_score_cfgid = this.luckyBagScoreCfgid;
/* 185 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 187 */     StringBuilder logBuilder = new StringBuilder();
/* 188 */     logBuilder.append("[luckybag]PCExchangeScore.onFailed@exchange score failed");
/* 189 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 190 */     logBuilder.append('|').append("client_score=").append(this.clientScore);
/* 191 */     logBuilder.append('|').append("lucky_bag_score_cfgid=").append(this.luckyBagScoreCfgid);
/* 192 */     logBuilder.append('|').append("num=").append(this.num);
/* 193 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 195 */     if (extraParams != null)
/*     */     {
/* 197 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 199 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 203 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */   private int getGridNum(long roleid, int awardCfgid, int num)
/*     */   {
/* 208 */     AwardReason awardReason = new AwardReason(LogReason.LUKCY_BAG_EXCHANGE_SCORE, awardCfgid);
/* 209 */     awardReason.setJustQuery(true);
/* 210 */     AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgid, roleid, awardReason);
/* 211 */     if (awardModel == null)
/*     */     {
/* 213 */       return -1;
/*     */     }
/*     */     
/* 216 */     Map<Integer, Integer> fixedItems = new HashMap();
/* 217 */     for (Map.Entry<Integer, Integer> entry : awardModel.getItemMap().entrySet())
/*     */     {
/* 219 */       fixedItems.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() * num));
/*     */     }
/*     */     
/* 222 */     return ItemInterface.needGrid(fixedItems);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\PCExchangeScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */