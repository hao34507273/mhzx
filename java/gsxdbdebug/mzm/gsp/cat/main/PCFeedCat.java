/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.cat.SFeedCatFailed;
/*     */ import mzm.gsp.cat.SFeedCatSuccess;
/*     */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*     */ import mzm.gsp.cat.confbean.SCatLevelCfg;
/*     */ import mzm.gsp.cat.confbean.SLevelToCatCfg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CatBag;
/*     */ import xbean.CatInfo;
/*     */ import xbean.FeedCatInfo;
/*     */ import xbean.FeedInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFeedInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCFeedCat extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   private final long catid;
/*     */   private String userid;
/*     */   
/*     */   public PCFeedCat(long roleid, long targetRoleid, long catid)
/*     */   {
/*  41 */     this.roleid = roleid;
/*  42 */     this.targetRoleid = targetRoleid;
/*  43 */     this.catid = catid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if ((this.targetRoleid <= 0L) || (this.catid <= 0L))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!CatManager.isFunOpen(this.roleid))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     if (!CatManager.checkRoleStatus(this.roleid))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     if (!HomelandInterface.hasHome(this.targetRoleid))
/*     */     {
/*  68 */       onFailed(6);
/*  69 */       return false;
/*     */     }
/*  71 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.targetRoleid, false);
/*  72 */     if (worldid < 0L)
/*     */     {
/*  74 */       onFailed(11);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     this.userid = RoleInterface.getUserId(this.roleid);
/*  79 */     if (this.userid == null)
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  86 */     lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     
/*  88 */     CatInfo xTargetCatInfo = CatManager.getHomelandCat(this.targetRoleid, true);
/*  89 */     if (xTargetCatInfo == null)
/*     */     {
/*  91 */       onFailed(4);
/*  92 */       return false;
/*     */     }
/*  94 */     if (xTargetCatInfo.getId() != this.catid)
/*     */     {
/*  96 */       Map<String, Object> extras = new HashMap();
/*  97 */       extras.put("target_catid", Long.valueOf(xTargetCatInfo.getId()));
/*  98 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/*  99 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/*     */       
/* 101 */       onFailed(2, extras);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     if (!CatManager.checkNpcService(this.roleid, xTargetCatInfo))
/*     */     {
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     if (!CatManager.checkState(xTargetCatInfo))
/*     */     {
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     if (xTargetCatInfo.getState() == 2)
/*     */     {
/* 119 */       Map<String, Object> extras = new HashMap();
/* 120 */       extras.put("current_state", Integer.valueOf(xTargetCatInfo.getState()));
/* 121 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 122 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/*     */       
/* 124 */       onFailed(-4, extras);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     if ((xTargetCatInfo.getExplored_level() != 0) || (xTargetCatInfo.getExplored_partner_cfgid() != 0))
/*     */     {
/* 131 */       Map<String, Object> extras = new HashMap();
/* 132 */       extras.put("current_state", Integer.valueOf(xTargetCatInfo.getState()));
/* 133 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 134 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/* 135 */       extras.put("explored_level", Integer.valueOf(xTargetCatInfo.getExplored_level()));
/* 136 */       extras.put("explored_partner_cfgid", Integer.valueOf(xTargetCatInfo.getExplored_partner_cfgid()));
/*     */       
/* 138 */       onFailed(-5, extras);
/* 139 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 143 */     int curLevel = CatManager.getCatLevel(xTargetCatInfo);
/* 144 */     if (curLevel <= 0)
/*     */     {
/* 146 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 150 */     int vigor = xTargetCatInfo.getVigor();
/* 151 */     SLevelToCatCfg levelToCatCfg = SLevelToCatCfg.get(curLevel);
/* 152 */     if (levelToCatCfg == null)
/*     */     {
/* 154 */       Map<String, Object> extras = new HashMap();
/* 155 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 156 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/* 157 */       extras.put("total_explore_num", Integer.valueOf(xTargetCatInfo.getTotal_explore_num()));
/*     */       
/* 159 */       onFailed(14, extras);
/* 160 */       return false;
/*     */     }
/* 162 */     SCatLevelCfg catLevelCfg = SCatLevelCfg.get(levelToCatCfg.catLevelCfgid);
/* 163 */     if (catLevelCfg == null)
/*     */     {
/* 165 */       Map<String, Object> extras = new HashMap();
/* 166 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 167 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/* 168 */       extras.put("total_explore_num", Integer.valueOf(xTargetCatInfo.getTotal_explore_num()));
/* 169 */       extras.put("cur_cat_level_cfgid", Integer.valueOf(levelToCatCfg.catLevelCfgid));
/*     */       
/* 171 */       onFailed(15, extras);
/* 172 */       return false;
/*     */     }
/* 174 */     if (vigor >= catLevelCfg.vigorMax)
/*     */     {
/* 176 */       Map<String, Object> extras = new HashMap();
/* 177 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 178 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/* 179 */       extras.put("total_explore_num", Integer.valueOf(xTargetCatInfo.getTotal_explore_num()));
/* 180 */       extras.put("current_vigor", Integer.valueOf(xTargetCatInfo.getVigor()));
/* 181 */       extras.put("vigor_max", Integer.valueOf(catLevelCfg.vigorMax));
/*     */       
/* 183 */       onFailed(-1, extras);
/* 184 */       return false;
/*     */     }
/*     */     
/* 187 */     CatBag xCatBag = CatManager.getCatBag(this.roleid);
/* 188 */     FeedInfo xFeedInfo = xCatBag.getFeed_info();
/*     */     
/* 190 */     CatManager.checkDailyFeedInfo(xFeedInfo);
/*     */     
/*     */ 
/* 193 */     int todayTotalFeedNum = getTodayTotalFeedNum(xFeedInfo);
/* 194 */     if (todayTotalFeedNum >= SCatCfgConsts.getInstance().DAILY_FEED_MAX)
/*     */     {
/* 196 */       Map<String, Object> extras = new HashMap();
/* 197 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 198 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/* 199 */       extras.put("today_total_feed_num", Integer.valueOf(todayTotalFeedNum));
/* 200 */       extras.put("daily_feed_max", Integer.valueOf(SCatCfgConsts.getInstance().DAILY_FEED_MAX));
/*     */       
/* 202 */       onFailed(-3, extras);
/* 203 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 207 */     int feedNum = getTodayFeedNum(xFeedInfo, this.targetRoleid, this.catid);
/* 208 */     if (feedNum >= SCatCfgConsts.getInstance().DAILY_THE_CAT_FEED_MAX)
/*     */     {
/* 210 */       Map<String, Object> extras = new HashMap();
/* 211 */       extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 212 */       extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/* 213 */       extras.put("today_feed_num", Integer.valueOf(feedNum));
/* 214 */       extras.put("daily_the_cat_feed_max", Integer.valueOf(SCatCfgConsts.getInstance().DAILY_THE_CAT_FEED_MAX));
/*     */       
/* 216 */       onFailed(-2, extras);
/* 217 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 221 */     addTodayFeedNum(xFeedInfo, this.targetRoleid, this.catid);
/*     */     
/* 223 */     xTargetCatInfo.setVigor(vigor + catLevelCfg.vigor);
/*     */     
/*     */ 
/* 226 */     if (xTargetCatInfo.getVigor() >= catLevelCfg.vigorMax)
/*     */     {
/*     */ 
/* 229 */       TLogArg tLogArg = new TLogArg(LogReason.SEND_MAIL_ON_VIGOR_MAX);
/* 230 */       List<String> emptyStrings = java.util.Collections.emptyList();
/* 231 */       int mailCfgId = SCatCfgConsts.getInstance().CAT_VIGOR_MAX_MAIL_CFG_ID;
/* 232 */       SendMailRet sendMailRet = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.targetRoleid, mailCfgId, emptyStrings, emptyStrings, null, tLogArg);
/*     */       
/* 234 */       if (!sendMailRet.isOK())
/*     */       {
/* 236 */         Map<String, Object> extras = new HashMap();
/* 237 */         extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 238 */         extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/* 239 */         extras.put("old_vigor", Integer.valueOf(vigor));
/* 240 */         extras.put("add_vigor", Integer.valueOf(catLevelCfg.vigor));
/* 241 */         extras.put("mail_cfgid", Integer.valueOf(SCatCfgConsts.getInstance().CAT_VIGOR_MAX_MAIL_CFG_ID));
/*     */         
/* 243 */         onFailed(1, extras);
/* 244 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 249 */     RoleFeedInfo xRoleFeedInfo = Pod.newRoleFeedInfo();
/* 250 */     xRoleFeedInfo.setRoleid(this.roleid);
/* 251 */     xRoleFeedInfo.setFeed_timestamp(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 252 */     xRoleFeedInfo.setRole_name(RoleInterface.getName(this.roleid));
/* 253 */     xTargetCatInfo.getRecords().add(xRoleFeedInfo);
/* 254 */     if (xTargetCatInfo.getRecords().size() > SCatCfgConsts.getInstance().CAT_FEED_RECORD_LIMIT)
/*     */     {
/* 256 */       xTargetCatInfo.getRecords().remove(0);
/*     */     }
/*     */     
/*     */ 
/* 260 */     int awardCfgid = SCatCfgConsts.getInstance().FEED_AWARD_ID;
/* 261 */     if (awardCfgid > 0)
/*     */     {
/* 263 */       AwardReason feedCatReason = new AwardReason(LogReason.FEED_CAT, awardCfgid);
/* 264 */       feedCatReason.setAwardItemBind(true);
/*     */       
/* 266 */       mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(awardCfgid, this.userid, this.roleid, true, true, feedCatReason);
/*     */       
/* 268 */       if (awardModel == null)
/*     */       {
/* 270 */         Map<String, Object> extras = new HashMap();
/* 271 */         extras.put("item_cfgid", Integer.valueOf(xTargetCatInfo.getItem_cfgid()));
/* 272 */         extras.put("cat_level_cfgid", Integer.valueOf(xTargetCatInfo.getCat_level_cfgid()));
/* 273 */         extras.put("award_cfgid", Integer.valueOf(SCatCfgConsts.getInstance().FEED_AWARD_ID));
/*     */         
/* 275 */         onFailed(3, extras);
/* 276 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 281 */     addTlog(xTargetCatInfo.getCat_level_cfgid(), xTargetCatInfo.getItem_cfgid(), xTargetCatInfo.getTotal_explore_num(), vigor, catLevelCfg.vigor, xTargetCatInfo.getVigor());
/*     */     
/*     */ 
/* 284 */     SFeedCatSuccess resp = new SFeedCatSuccess();
/* 285 */     resp.target_roleid = this.targetRoleid;
/* 286 */     resp.catid = this.catid;
/* 287 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 289 */     GameServer.logger().info(String.format("[cat]PCFeedCat.processImp@feed cat success|roleid=%d|target_roleid=%d|catid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid), Long.valueOf(this.catid) }));
/*     */     
/*     */ 
/* 292 */     return true;
/*     */   }
/*     */   
/*     */   int getTodayTotalFeedNum(FeedInfo xFeedInfo)
/*     */   {
/* 297 */     Map<Long, FeedCatInfo> feeds = xFeedInfo.getFeed_records();
/* 298 */     if (feeds.isEmpty())
/*     */     {
/* 300 */       return 0;
/*     */     }
/* 302 */     int result = 0;
/* 303 */     for (FeedCatInfo xFeedCatInfo : feeds.values())
/*     */     {
/* 305 */       for (Integer num : xFeedCatInfo.getFeed_cats().values())
/*     */       {
/* 307 */         result += num.intValue();
/*     */       }
/*     */     }
/* 310 */     return result;
/*     */   }
/*     */   
/*     */   int getTodayFeedNum(FeedInfo xFeedInfo, long targetRoleid, long catid)
/*     */   {
/* 315 */     FeedCatInfo xFeedCatInfo = (FeedCatInfo)xFeedInfo.getFeed_records().get(Long.valueOf(targetRoleid));
/* 316 */     if (xFeedCatInfo == null)
/*     */     {
/* 318 */       return 0;
/*     */     }
/* 320 */     Integer xNum = (Integer)xFeedCatInfo.getFeed_cats().get(Long.valueOf(catid));
/* 321 */     if (xNum == null)
/*     */     {
/* 323 */       return 0;
/*     */     }
/* 325 */     return xNum.intValue();
/*     */   }
/*     */   
/*     */   void addTodayFeedNum(FeedInfo xFeedInfo, long targetRoleid, long catid)
/*     */   {
/* 330 */     FeedCatInfo xFeedCatInfo = (FeedCatInfo)xFeedInfo.getFeed_records().get(Long.valueOf(targetRoleid));
/* 331 */     if (xFeedCatInfo == null)
/*     */     {
/* 333 */       xFeedCatInfo = Pod.newFeedCatInfo();
/* 334 */       xFeedInfo.getFeed_records().put(Long.valueOf(targetRoleid), xFeedCatInfo);
/*     */     }
/*     */     
/* 337 */     Integer xNum = (Integer)xFeedCatInfo.getFeed_cats().get(Long.valueOf(catid));
/* 338 */     if (xNum == null)
/*     */     {
/* 340 */       xFeedCatInfo.getFeed_cats().put(Long.valueOf(catid), Integer.valueOf(1));
/*     */     }
/*     */     else
/*     */     {
/* 344 */       xFeedCatInfo.getFeed_cats().put(Long.valueOf(catid), Integer.valueOf(xNum.intValue() + 1));
/*     */     }
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 350 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 355 */     if (retcode < 0)
/*     */     {
/* 357 */       SFeedCatFailed resp = new SFeedCatFailed();
/* 358 */       resp.target_roleid = this.targetRoleid;
/* 359 */       resp.catid = this.catid;
/* 360 */       resp.retcode = retcode;
/* 361 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 364 */     StringBuffer logBuilder = new StringBuffer();
/* 365 */     logBuilder.append("[cat]PCFeedCat.onFailed@feed cat failed");
/* 366 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 367 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 368 */     logBuilder.append('|').append("catid=").append(this.catid);
/* 369 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 371 */     if (extraParams != null)
/*     */     {
/* 373 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 375 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 379 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(int catLevelCfgid, int itemCfgid, int totalExploreNum, int oldVigor, int addVigor, int newVigor)
/*     */   {
/* 385 */     String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 386 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 388 */     TLogManager.getInstance().addLog(this.userid, "FeedCatForServer", new Object[] { vGameIp, this.userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.targetRoleid), Long.valueOf(this.catid), Integer.valueOf(catLevelCfgid), Integer.valueOf(itemCfgid), Integer.valueOf(totalExploreNum), Integer.valueOf(oldVigor), Integer.valueOf(addVigor), Integer.valueOf(newVigor), Integer.valueOf(SCatCfgConsts.getInstance().FEED_AWARD_ID) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCFeedCat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */