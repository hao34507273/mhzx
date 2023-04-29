/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.award.confbean.SAwardVigor;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.ActivityVigor;
/*     */ import mzm.gsp.role.SSyncVigorList;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.vigor.confbean.SVigorDescCfg;
/*     */ import mzm.gsp.yuanbao.main.CurrencyLogUtil;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Activity2Vigor;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleVigorHistory;
/*     */ import xtable.Role2vigor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RoleVigorManager
/*     */ {
/*  28 */   private static final Logger logger = Logger.getLogger(RoleVigorManager.class);
/*     */   
/*  30 */   private Map<Integer, Integer> type2countMap = new HashMap();
/*  31 */   private Map<Integer, List<SAwardVigor>> type2AwardListMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  39 */   private static RoleVigorManager instance = new RoleVigorManager();
/*     */   
/*     */   public static RoleVigorManager getInstance()
/*     */   {
/*  43 */     return instance;
/*     */   }
/*     */   
/*     */   public void init()
/*     */   {
/*  48 */     for (SVigorDescCfg cfg : SVigorDescCfg.getAll().values())
/*     */     {
/*  50 */       this.type2countMap.put(Integer.valueOf(cfg.awardType), Integer.valueOf(cfg.count));
/*     */     }
/*  52 */     for (SAwardVigor cfg : SAwardVigor.getAll().values())
/*     */     {
/*  54 */       List<SAwardVigor> awardVigorList = (List)this.type2AwardListMap.get(Integer.valueOf(cfg.awardType));
/*  55 */       if (awardVigorList == null)
/*     */       {
/*  57 */         awardVigorList = new ArrayList();
/*  58 */         this.type2AwardListMap.put(Integer.valueOf(cfg.awardType), awardVigorList);
/*     */       }
/*  60 */       awardVigorList.add(cfg);
/*     */     }
/*  62 */     SAwardVigor.getAll().clear();
/*  63 */     SVigorDescCfg.getAll().clear();
/*     */   }
/*     */   
/*     */   public static void postInit()
/*     */   {
/*  68 */     new VigorDayUpdateObserver();
/*     */   }
/*     */   
/*     */   VigorOperResult awardAward(long roleId, int awardType, TLogArg logArg)
/*     */   {
/*  73 */     Activity2Vigor xVigor = Role2vigor.get(Long.valueOf(roleId));
/*  74 */     if (xVigor == null)
/*     */     {
/*  76 */       xVigor = Pod.newActivity2Vigor();
/*  77 */       Role2vigor.add(Long.valueOf(roleId), xVigor);
/*     */     }
/*  79 */     RoleVigorHistory xRoleVigorHistory = (RoleVigorHistory)xVigor.getAwardvigorhistorymap().get(Integer.valueOf(awardType));
/*  80 */     if (xRoleVigorHistory == null)
/*     */     {
/*  82 */       xRoleVigorHistory = Pod.newRoleVigorHistory();
/*  83 */       xVigor.getAwardvigorhistorymap().put(Integer.valueOf(awardType), xRoleVigorHistory);
/*     */     }
/*  85 */     Role role = RoleInterface.getRole(roleId, true);
/*  86 */     int level = role.getLevel();
/*  87 */     Integer maxCount = (Integer)this.type2countMap.get(Integer.valueOf(awardType));
/*  88 */     if (maxCount == null)
/*     */     {
/*  90 */       logger.error("奖励活力失败！，没有配置相应的奖励类型");
/*  91 */       return VigorOperResult.VIGOR_TYPE_ERROR;
/*     */     }
/*  93 */     if (xRoleVigorHistory.getCount() >= maxCount.intValue())
/*     */     {
/*  95 */       return VigorOperResult.VIGOR_ADD_MAX;
/*     */     }
/*  97 */     SAwardVigor realVigorCfg = null;
/*  98 */     List<SAwardVigor> awardVigorList = (List)this.type2AwardListMap.get(Integer.valueOf(awardType));
/*     */     
/* 100 */     if (awardVigorList == null)
/*     */     {
/* 102 */       logger.error("找不到对应类型的活力奖励配置" + awardType);
/* 103 */       return VigorOperResult.VIGOR_TYPE_ERROR;
/*     */     }
/* 105 */     for (SAwardVigor sAwardVigor : awardVigorList)
/*     */     {
/* 107 */       if ((sAwardVigor.levelMax >= level) && (sAwardVigor.levelMin <= level))
/*     */       {
/*     */ 
/*     */ 
/* 111 */         realVigorCfg = sAwardVigor;
/*     */       }
/*     */     }
/* 114 */     if (realVigorCfg == null)
/*     */     {
/* 116 */       logger.error("找不到对应类型的活力奖励配置" + awardType + " role level " + level);
/* 117 */       return VigorOperResult.VIGOR_TYPE_ERROR;
/*     */     }
/* 119 */     role.addVigor(realVigorCfg.awardVigor);
/*     */     
/* 121 */     xRoleVigorHistory.setCount(xRoleVigorHistory.getCount() + 1);
/* 122 */     xRoleVigorHistory.setVigor(xRoleVigorHistory.getVigor() + realVigorCfg.awardVigor);
/*     */     
/* 124 */     SSyncVigorList sSyncVigorList = new SSyncVigorList();
/* 125 */     ActivityVigor activityVigor = new ActivityVigor();
/* 126 */     activityVigor.count = xRoleVigorHistory.getCount();
/* 127 */     activityVigor.vigor = xRoleVigorHistory.getVigor();
/* 128 */     sSyncVigorList.vigormap.put(Integer.valueOf(awardType), activityVigor);
/* 129 */     OnlineManager.getInstance().send(roleId, sSyncVigorList);
/*     */     
/* 131 */     return VigorOperResult.SUCCESS;
/*     */   }
/*     */   
/*     */   void syncVigorList(long roleId)
/*     */   {
/* 136 */     SSyncVigorList sSyncVigorList = new SSyncVigorList();
/* 137 */     Activity2Vigor xVigor = Role2vigor.get(Long.valueOf(roleId));
/* 138 */     if (xVigor == null)
/*     */     {
/* 140 */       OnlineManager.getInstance().send(roleId, sSyncVigorList);
/* 141 */       return;
/*     */     }
/* 143 */     for (Map.Entry<Integer, RoleVigorHistory> entry : xVigor.getAwardvigorhistorymap().entrySet())
/*     */     {
/* 145 */       ActivityVigor activityVigor = new ActivityVigor();
/* 146 */       RoleVigorHistory xHistory = (RoleVigorHistory)xVigor.getAwardvigorhistorymap().get(entry.getKey());
/* 147 */       if (xHistory == null)
/*     */       {
/* 149 */         activityVigor.count = 0;
/* 150 */         activityVigor.vigor = 0;
/*     */       }
/*     */       else
/*     */       {
/* 154 */         activityVigor.count = xHistory.getCount();
/* 155 */         activityVigor.vigor = xHistory.getVigor();
/*     */       }
/* 157 */       sSyncVigorList.vigormap.put(entry.getKey(), activityVigor);
/*     */     }
/* 159 */     OnlineManager.getInstance().send(roleId, sSyncVigorList);
/*     */   }
/*     */   
/*     */ 
/*     */   static void logVigorChange(long roleId, TLogArg arg, int leftVigor, int changeValue)
/*     */   {
/* 165 */     CurrencyLogUtil.logCurrency(roleId, CurrencyType.CURRENCY_VIGOR, changeValue, leftVigor, arg);
/* 166 */     CurrencyLogUtil.tLogCurrency(roleId, CurrencyType.CURRENCY_VIGOR, changeValue, leftVigor, arg);
/* 167 */     CurrencyLogUtil.tlogMoneyFlow(roleId, CurrencyType.CURRENCY_VIGOR, changeValue, leftVigor, arg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleVigorManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */