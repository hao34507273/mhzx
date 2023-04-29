/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import xbean.RolekejuRank;
/*     */ import xtable.Rolekejurank;
/*     */ 
/*     */ public class KejuRankManager extends mzm.gsp.chart.main.RoleKeyRankManagerNew<RoleKejuChart>
/*     */ {
/*     */   private static KejuRankManager instance;
/*     */   
/*     */   public KejuRankManager(int chartType)
/*     */   {
/*  15 */     super(chartType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  22 */     if (instance != null)
/*     */     {
/*  24 */       return;
/*     */     }
/*     */     
/*     */ 
/*  28 */     instance = new KejuRankManager(4);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static KejuRankManager getInstance()
/*     */   {
/*  35 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  42 */     List<RoleKejuChart> objs = getAllChartObjs();
/*  43 */     RolekejuRank rolekejuRank = Rolekejurank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  44 */     if (rolekejuRank == null)
/*     */     {
/*  46 */       rolekejuRank = xbean.Pod.newRolekejuRank();
/*  47 */       Rolekejurank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), rolekejuRank);
/*     */     }
/*  49 */     rolekejuRank.getRankdatas().clear();
/*  50 */     for (RoleKejuChart kejuChart : objs)
/*     */     {
/*  52 */       rolekejuRank.getRankdatas().add(kejuChart.getKey());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  60 */     RolekejuRank kejuRank = Rolekejurank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  61 */     Iterator i$; if (kejuRank != null)
/*     */     {
/*  63 */       for (i$ = kejuRank.getRankdatas().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*     */ 
/*  66 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleid))
/*     */         {
/*  68 */           KeJuQuestionManager.logger.info(String.format("[keju]KejuRankManager.rankDataFromDB@ role is deleted!|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  73 */           RoleKejuChart roleKejuChart = new RoleKejuChart(roleid, KeJuQuestionManager.getInstance().getDianshiUsetime(roleid, false));
/*     */           
/*  75 */           rank(roleKejuChart);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/*  86 */     RolekejuRank kejuRank = Rolekejurank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  87 */     if (kejuRank != null)
/*     */     {
/*  89 */       kejuRank.getRankdatas().clear();
/*     */     }
/*  91 */     super.clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/*  97 */     getInstance().rank(new RoleKejuChart(roleid, KeJuQuestionManager.getInstance().getDianshiUsetime(roleid, false)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/* 106 */     xbean.KeJuInfo keJuInfo = xtable.Role2keju.get(Long.valueOf(roleid));
/* 107 */     if (keJuInfo != null)
/*     */     {
/* 109 */       keJuInfo.setStarttime(0L);
/*     */     }
/*     */     
/* 112 */     getInstance().delete(Long.valueOf(roleid));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\KejuRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */