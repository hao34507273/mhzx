/*     */ package mzm.gsp.hula.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HulaInfo;
/*     */ import xbean.HulaRank;
/*     */ import xtable.Hularank;
/*     */ import xtable.Role2hula;
/*     */ 
/*     */ public class HulaChart extends RoleKeyRankManagerNew<HulaChartObj>
/*     */ {
/*     */   private static HulaChart instance;
/*     */   
/*     */   public static HulaChart getInstance()
/*     */   {
/*  20 */     return instance;
/*     */   }
/*     */   
/*     */   private HulaChart(int chartType)
/*     */   {
/*  25 */     super(chartType);
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/*  30 */     if (instance == null)
/*     */     {
/*  32 */       instance = new HulaChart(25);
/*     */     }
/*     */     else
/*     */     {
/*  36 */       throw new RuntimeException("草裙舞排行榜初始化异常");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  44 */     long localid = GameServerInfoManager.getLocalId();
/*  45 */     HulaRank xHulaRank = Hularank.get(Long.valueOf(localid));
/*  46 */     if (xHulaRank == null)
/*     */     {
/*  48 */       return;
/*     */     }
/*  50 */     for (Iterator i$ = xHulaRank.getRanklist().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  53 */       if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleid))
/*     */       {
/*  55 */         HulaManager.logger.info(String.format("[hula]HulaChart.rankDataFromDB@role is deleted!|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       }
/*     */       else {
/*  58 */         int score = HulaManager.getRolePoint(roleid);
/*  59 */         Map<Integer, Integer> deleteTypes = HulaManager.getRoleAllDeleteTypes(roleid);
/*  60 */         rank(new HulaChartObj(roleid, score, deleteTypes));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void saveToDB()
/*     */   {
/*  67 */     List<HulaChartObj> hulaChartObjs = getAllChartObjs();
/*     */     
/*  69 */     long localid = GameServerInfoManager.getLocalId();
/*  70 */     HulaRank xHulaRank = Hularank.get(Long.valueOf(localid));
/*  71 */     if (xHulaRank == null)
/*     */     {
/*  73 */       xHulaRank = xbean.Pod.newHulaRank();
/*  74 */       Hularank.insert(Long.valueOf(localid), xHulaRank);
/*     */     }
/*  76 */     xHulaRank.getRanklist().clear();
/*  77 */     for (HulaChartObj hulaChartObj : hulaChartObjs)
/*     */     {
/*  79 */       xHulaRank.getRanklist().add(hulaChartObj.getKey());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/*  87 */     int score = HulaManager.getRolePoint(roleid);
/*  88 */     Map<Integer, Integer> deleteTypes = HulaManager.getRoleAllDeleteTypes(roleid);
/*  89 */     HulaChartObj hulaChartObj = new HulaChartObj(roleid, score, deleteTypes);
/*  90 */     rank(hulaChartObj);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/*  97 */     HulaInfo xHulaInfo = Role2hula.get(Long.valueOf(roleid));
/*  98 */     if (xHulaInfo != null)
/*     */     {
/* 100 */       xHulaInfo.setPoint(0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */