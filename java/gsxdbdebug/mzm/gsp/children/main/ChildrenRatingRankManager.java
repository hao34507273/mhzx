/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import xbean.ChildrenRatingRankInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xbean.SingleChildRatingRankInfo;
/*     */ import xtable.Childrenratingrank;
/*     */ 
/*     */ public class ChildrenRatingRankManager extends mzm.gsp.chart.main.NoneRoleKeyRankManagerNew<Long, ChildrenRatingChart>
/*     */ {
/*  12 */   private static final ChildrenRatingRankManager instance = new ChildrenRatingRankManager(36);
/*     */   
/*     */   private ChildrenRatingRankManager(int chartType)
/*     */   {
/*  16 */     super(chartType);
/*     */   }
/*     */   
/*     */   public static ChildrenRatingRankManager getInstance()
/*     */   {
/*  21 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  27 */     List<ChildrenRatingChart> allCharts = getAllChartObjs();
/*  28 */     ChildrenRatingRankInfo xChildrenRatingRank = Childrenratingrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  29 */     if (null == xChildrenRatingRank)
/*     */     {
/*  31 */       xChildrenRatingRank = xbean.Pod.newChildrenRatingRankInfo();
/*  32 */       Childrenratingrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xChildrenRatingRank);
/*     */     }
/*  34 */     xChildrenRatingRank.getRanklist().clear();
/*  35 */     for (ChildrenRatingChart singleChildChart : allCharts)
/*     */     {
/*  37 */       SingleChildRatingRankInfo xChildRankInfo = xbean.Pod.newSingleChildRatingRankInfo();
/*  38 */       xChildRankInfo.setChildid(singleChildChart.getKey().longValue());
/*  39 */       xChildrenRatingRank.getRanklist().add(xChildRankInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  46 */     ChildrenRatingRankInfo xChildrenRatingRank = Childrenratingrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  47 */     if (null == xChildrenRatingRank)
/*     */     {
/*  49 */       return;
/*     */     }
/*  51 */     for (SingleChildRatingRankInfo xChildRankInfo : xChildrenRatingRank.getRanklistAsData())
/*     */     {
/*  53 */       long childId = xChildRankInfo.getChildid();
/*  54 */       rank(childId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleId)
/*     */   {
/*  61 */     Role2ChildrenInfo xRole2ChildrenInfo = xtable.Role2children.select(Long.valueOf(roleId));
/*  62 */     if (null == xRole2ChildrenInfo)
/*     */     {
/*  64 */       return;
/*     */     }
/*  66 */     List<Long> childIdList = xRole2ChildrenInfo.getChild_id_listAsData();
/*  67 */     for (Long childId : childIdList)
/*     */     {
/*  69 */       rank(childId.longValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleId)
/*     */   {
/*  81 */     Role2ChildrenInfo xRole2ChildrenInfo = xtable.Role2children.get(Long.valueOf(roleId));
/*  82 */     if (null == xRole2ChildrenInfo)
/*     */     {
/*  84 */       return;
/*     */     }
/*  86 */     List<Long> childIdList = xRole2ChildrenInfo.getChild_id_listAsData();
/*  87 */     for (Long childId : childIdList)
/*     */     {
/*  89 */       delete(childId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void deleteChildRankData(long childId)
/*     */   {
/* 100 */     delete(Long.valueOf(childId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void rank(long roleId, long childId, int rating)
/*     */   {
/* 110 */     ChildrenRatingChart childRatingChart = new ChildrenRatingChart(childId, roleId, rating);
/* 111 */     rank(childRatingChart);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void rank(long childId)
/*     */   {
/* 121 */     xbean.ChildInfo xChildInfo = xtable.Children.select(Long.valueOf(childId));
/* 122 */     if (null == xChildInfo)
/*     */     {
/*     */ 
/* 125 */       mzm.gsp.GameServer.logger().error(String.format("[children]ChildrenRatingRankManager.rank@rank child not exsist|childId=%d", new Object[] { Long.valueOf(childId) }));
/*     */       
/* 127 */       return;
/*     */     }
/* 129 */     long roleId = xChildInfo.getOwn_role_id();
/* 130 */     int rating = ChildrenManager.getChildRating(childId, false);
/* 131 */     if (0 != rating)
/*     */     {
/* 133 */       rank(roleId, childId, rating);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\ChildrenRatingRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */