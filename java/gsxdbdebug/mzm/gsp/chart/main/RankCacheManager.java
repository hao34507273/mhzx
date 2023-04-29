/*     */ package mzm.gsp.chart.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.chart.confbean.RankAwardBean;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeAwardCfg;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ public class RankCacheManager
/*     */ {
/*     */   static final int ROLE_RELATED = 1;
/*  28 */   static Map<Integer, Map<Integer, RankManager>> rankManagerMap = new HashMap();
/*     */   
/*  30 */   static Map<Integer, RankAwardHandler> rankAwardHandlerMap = new HashMap();
/*     */   
/*     */   static void addRoleRelatedManager(int rankType, RoleRelatedRankManager roleRelatedRankManager)
/*     */   {
/*  34 */     Map<Integer, RankManager> map = (Map)rankManagerMap.get(Integer.valueOf(1));
/*  35 */     if (map == null) {
/*  36 */       map = new HashMap();
/*  37 */       rankManagerMap.put(Integer.valueOf(1), map);
/*     */     }
/*  39 */     SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(rankType);
/*  40 */     if (chartSubTypeCfg == null) {
/*  41 */       GameServer.logger().info(String.format("[Chart]RankCacheManager.addRoleRelatedManager@chartSubTypeCfg is null|chartType=%d", new Object[] { Integer.valueOf(rankType) }));
/*  42 */       return;
/*     */     }
/*  44 */     map.put(Integer.valueOf(rankType), roleRelatedRankManager);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean removeRoleidInAllRank(long roleid, boolean isClear)
/*     */   {
/*  54 */     Map<Integer, RankManager> roleRelatedMap = (Map)rankManagerMap.get(Integer.valueOf(1));
/*  55 */     if (roleRelatedMap == null) {
/*  56 */       return false;
/*     */     }
/*  58 */     boolean ret = false;
/*  59 */     for (RankManager rankManager : roleRelatedMap.values()) {
/*  60 */       RoleRelatedRankManager roleRelatedRankManager = (RoleRelatedRankManager)rankManager;
/*  61 */       if (roleRelatedRankManager.removeByRoleid(roleid, isClear)) {
/*  62 */         ret = true;
/*     */       }
/*     */     }
/*  65 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addRoleRankInAllRank(final long roleid)
/*     */   {
/*  75 */     Map<Integer, RankManager> roleRelatedMap = (Map)rankManagerMap.get(Integer.valueOf(1));
/*  76 */     if (roleRelatedMap == null) {
/*  77 */       return;
/*     */     }
/*  79 */     for (RankManager rankManager : roleRelatedMap.values()) {
/*  80 */       RoleRelatedRankManager roleRelatedRankManager = (RoleRelatedRankManager)rankManager;
/*  81 */       Procedure.execute(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/*  85 */           RankCacheManager.this.addRankRoleForIDIP(roleid);
/*  86 */           return true;
/*     */         }
/*     */       });
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
/*     */   static boolean removeRoleidInRank(long roleid, int rankType, boolean isClear)
/*     */   {
/* 101 */     Map<Integer, RankManager> roleRelatedMap = (Map)rankManagerMap.get(Integer.valueOf(1));
/* 102 */     if (roleRelatedMap == null) {
/* 103 */       return false;
/*     */     }
/* 105 */     RankManager rankManager = (RankManager)roleRelatedMap.get(Integer.valueOf(rankType));
/* 106 */     if (rankManager == null) {
/* 107 */       return false;
/*     */     }
/* 109 */     RoleRelatedRankManager roleRelatedRankManager = (RoleRelatedRankManager)rankManager;
/* 110 */     boolean ret = roleRelatedRankManager.removeByRoleid(roleid, isClear);
/* 111 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addRoleRank(final long roleid, int rankType)
/*     */   {
/* 121 */     Map<Integer, RankManager> roleRelatedMap = (Map)rankManagerMap.get(Integer.valueOf(1));
/* 122 */     if (roleRelatedMap == null) {
/* 123 */       return;
/*     */     }
/* 125 */     RankManager rankManager = (RankManager)roleRelatedMap.get(Integer.valueOf(rankType));
/* 126 */     if (rankManager == null) {
/* 127 */       return;
/*     */     }
/* 129 */     RoleRelatedRankManager roleRelatedRankManager = (RoleRelatedRankManager)rankManager;
/* 130 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 134 */         RankCacheManager.this.addRankRoleForIDIP(roleid);
/* 135 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   static int getMaxRank(long roleid, int rankType)
/*     */   {
/* 142 */     Map<Integer, RankManager> roleRelatedMap = (Map)rankManagerMap.get(Integer.valueOf(1));
/* 143 */     if (roleRelatedMap == null) {
/* 144 */       return -2;
/*     */     }
/* 146 */     RankManager rankManager = (RankManager)roleRelatedMap.get(Integer.valueOf(rankType));
/* 147 */     if (rankManager == null) {
/* 148 */       return -2;
/*     */     }
/* 150 */     RoleRelatedRankManager roleRelatedRankManager = (RoleRelatedRankManager)rankManager;
/* 151 */     return roleRelatedRankManager.getMaxRank(roleid);
/*     */   }
/*     */   
/*     */   static List<RoleRelatedChartObj> getRoleRelatedChartObjs(int rankType, int from, int to)
/*     */   {
/* 156 */     Map<Integer, RankManager> roleRelatedMap = (Map)rankManagerMap.get(Integer.valueOf(1));
/* 157 */     if (roleRelatedMap == null) {
/* 158 */       return Collections.EMPTY_LIST;
/*     */     }
/* 160 */     RankManager rankManager = (RankManager)roleRelatedMap.get(Integer.valueOf(rankType));
/* 161 */     if (rankManager == null) {
/* 162 */       return Collections.EMPTY_LIST;
/*     */     }
/* 164 */     RoleRelatedRankManager roleRelatedRankManager = (RoleRelatedRankManager)rankManager;
/* 165 */     List retList = roleRelatedRankManager.getRankObjs(from, to);
/* 166 */     if (retList.size() > 0) {
/* 167 */       if ((retList.get(0) instanceof RoleRelatedChartObj)) {
/* 168 */         return retList;
/*     */       }
/* 170 */       GameServer.logger().error(String.format("[Rank]RankCacheManager.getRoleRelatedChartObjs@not roleRelated object|ranktype=%d", new Object[] { Integer.valueOf(rankType) }));
/*     */       
/*     */ 
/*     */ 
/* 174 */       return Collections.EMPTY_LIST;
/*     */     }
/*     */     
/* 177 */     return Collections.EMPTY_LIST;
/*     */   }
/*     */   
/*     */ 
/*     */   static void postinit()
/*     */   {
/* 183 */     for (SChartSubTypeCfg sChartSubTypeCfg : SChartSubTypeCfg.getAll().values()) {
/* 184 */       if (sChartSubTypeCfg.timeCommonCfgids.size() > 0) {
/* 185 */         if (!rankAwardHandlerMap.containsKey(Integer.valueOf(sChartSubTypeCfg.chartType))) {
/* 186 */           GameServer.logger().info("排行奖有奖励但是并没有注册排行榜发奖的处理类,rankType:" + sChartSubTypeCfg.chartType);
/*     */         } else
/* 188 */           for (Iterator i$ = sChartSubTypeCfg.timeCommonCfgids.iterator(); i$.hasNext();) { int timeCommonCfgid = ((Integer)i$.next()).intValue();
/* 189 */             new ChartAwardObserver(timeCommonCfgid, sChartSubTypeCfg.chartType);
/*     */           }
/* 191 */       } else { SChartSubTypeAwardCfg chartSubTypeAwardCfg = SChartSubTypeAwardCfg.get(sChartSubTypeCfg.chartType);
/* 192 */         if (chartSubTypeAwardCfg != null)
/*     */         {
/*     */ 
/* 195 */           Map<Integer, RankManager> map = (Map)rankManagerMap.get(Integer.valueOf(1));
/* 196 */           if (map == null) {
/* 197 */             GameServer.logger().warn(String.format("[Rank]RankCacheManager.postinit@do not exist role_related rank", new Object[0]));
/*     */           }
/*     */           else
/*     */           {
/* 201 */             RankManager rankManager = (RankManager)map.get(Integer.valueOf(sChartSubTypeCfg.chartType));
/* 202 */             if (rankManager == null) {
/* 203 */               GameServer.logger().warn(String.format("[Rank]RankCacheManager.postinit@do not cache role_related rank|rankType=%d", new Object[] { Integer.valueOf(sChartSubTypeCfg.chartType) }));
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
/*     */   static boolean sendChartAward(String userid, long roleid, int chartType, int rank)
/*     */   {
/* 219 */     SChartSubTypeAwardCfg chartSubTypeAwardCfg = SChartSubTypeAwardCfg.get(chartType);
/* 220 */     if (chartSubTypeAwardCfg == null) {
/* 221 */       GameServer.logger().error(String.format("[Rank]RankCacheManager.sendChartAward@chartSubTypeAwardCfg is null|roleid=%d|chartType=%d|rank=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(chartType), Integer.valueOf(rank) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 228 */       return false;
/*     */     }
/* 230 */     GameServer.logger().info(String.format("[Rank]RankCacheManager.sendChartAward@do award|roleid=%d|chartType=%d|rank=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(chartType), Integer.valueOf(rank) }));
/*     */     
/*     */ 
/* 233 */     Map.Entry<Integer, RankAwardBean> entry = chartSubTypeAwardCfg.awardMap.ceilingEntry(Integer.valueOf(rank));
/*     */     
/* 235 */     if (entry == null) {
/* 236 */       GameServer.logger().error(String.format("[Rank]RankCacheManager.sendChartAward@not exist awardBean|roleid=%d|chartType=%d|rank=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(chartType), Integer.valueOf(rank) }));
/*     */       
/*     */ 
/*     */ 
/* 240 */       return false;
/*     */     }
/* 242 */     RankAwardBean rankAwardBean = (RankAwardBean)entry.getValue();
/* 243 */     mzm.gsp.award.main.AwardModel awardModel = null;
/* 244 */     if (rankAwardBean.awardid > 0) {
/* 245 */       awardModel = AwardInterface.getRoleFixAwardModel(rankAwardBean.awardid, roleid, new AwardReason(LogReason.CHART_AWARD, rankAwardBean.awardid));
/*     */       
/* 247 */       if (awardModel == null) {
/* 248 */         GameServer.logger().info(String.format("[Chart]ChartAwardRoleProcedure.processImp@awardModel null|roleid=%d|chartType=%d|rank=%d|awardid=%d|mailid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(chartType), Integer.valueOf(rank), Integer.valueOf(rankAwardBean.awardid), Integer.valueOf(rankAwardBean.rankMail) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 258 */     if (rankAwardBean.awardHonorid > 0) {
/* 259 */       AwardInterface.awardFixAward(rankAwardBean.awardHonorid, userid, roleid, false, false, new AwardReason(LogReason.CHART_AWARD, rankAwardBean.awardHonorid));
/*     */     }
/*     */     
/* 262 */     MailAttachment mailAttachment = null;
/* 263 */     if (awardModel != null) {
/* 264 */       mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/*     */     } else {
/* 266 */       mailAttachment = new MailAttachment();
/*     */     }
/* 268 */     List<String> titleStrings = null;
/* 269 */     List<String> contentStrings = new ArrayList();
/*     */     
/* 271 */     contentStrings.add(String.valueOf(rank + 1));
/* 272 */     MailInterface.synBuildAndSendMail(roleid, rankAwardBean.rankMail, titleStrings, contentStrings, mailAttachment, new TLogArg(LogReason.CHART_AWARD, rankAwardBean.awardid));
/*     */     
/* 274 */     return true;
/*     */   }
/*     */   
/*     */   static void registerRankAwardHandle(int rankType, RankAwardHandler rankAwardHandler) {
/* 278 */     rankAwardHandlerMap.put(Integer.valueOf(rankType), rankAwardHandler);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RankCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */