/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.chart.main.ChartCfgManager;
/*     */ import xbean.ChildrenRatingRankInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.SingleChildRatingRankInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Childrengrowthdiary;
/*     */ import xtable.Childrenratingrank;
/*     */ import xtable.Role2children;
/*     */ 
/*     */ public class ChildrenModule implements mzm.event.Module, MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  25 */     return Arrays.asList(new Table[] { xtable.Children.getTable(), Role2children.getTable(), Childrengrowthdiary.getTable(), Childrenratingrank.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  32 */     return new PChildrenRankMerge(null).call();
/*     */   }
/*     */   
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  38 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/*  44 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/*  50 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/*  56 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class PChildrenRankMerge
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  67 */       long mainZoneId = MergeMain.getMainZoneid();
/*  68 */       long viceZoneId = MergeMain.getViceZoneid();
/*  69 */       lock(Childrenratingrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneId), Long.valueOf(viceZoneId) }));
/*     */       
/*  71 */       ChildrenRatingRankInfo xMainChildrenRatingRankInfo = Childrenratingrank.get(Long.valueOf(mainZoneId));
/*  72 */       ChildrenRatingRankInfo xViceChildrenRatingRankInfo = Childrenratingrank.get(Long.valueOf(viceZoneId));
/*  73 */       if (null == xMainChildrenRatingRankInfo)
/*     */       {
/*  75 */         xMainChildrenRatingRankInfo = Pod.newChildrenRatingRankInfo();
/*  76 */         Childrenratingrank.add(Long.valueOf(mainZoneId), xMainChildrenRatingRankInfo);
/*     */       }
/*  78 */       if (null == xViceChildrenRatingRankInfo)
/*     */       {
/*  80 */         xViceChildrenRatingRankInfo = Pod.newChildrenRatingRankInfo();
/*  81 */         Childrenratingrank.add(Long.valueOf(viceZoneId), xViceChildrenRatingRankInfo);
/*     */       }
/*  83 */       List<SingleChildRatingRankInfo> xMainSingleRatingRankInfoList = xMainChildrenRatingRankInfo.getRanklist();
/*  84 */       List<SingleChildRatingRankInfo> xViceSingleRatingRankInfoList = xViceChildrenRatingRankInfo.getRanklist();
/*     */       
/*  86 */       List<SingleChildRatingRankInfo> MergedRankInfoList = new java.util.LinkedList();
/*  87 */       MergedRankInfoList.addAll(xMainSingleRatingRankInfoList);
/*  88 */       MergedRankInfoList.addAll(xViceSingleRatingRankInfoList);
/*     */       
/*  90 */       java.util.Collections.sort(MergedRankInfoList, new Comparator()
/*     */       {
/*     */ 
/*     */         public int compare(SingleChildRatingRankInfo xInfo1, SingleChildRatingRankInfo xInfo2)
/*     */         {
/*  95 */           int rating1 = ChildrenManager.getChildRating(xInfo1.getChildid(), false);
/*  96 */           int rating2 = ChildrenManager.getChildRating(xInfo2.getChildid(), false);
/*  97 */           return rating1 > rating2 ? -1 : 1;
/*     */         }
/*     */         
/* 100 */       });
/* 101 */       xMainSingleRatingRankInfoList.clear();
/* 102 */       SChartSubTypeCfg sChatrSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(36);
/* 103 */       int RatingRankSize = sChatrSubTypeCfg.capacity + sChatrSubTypeCfg.extraSize;
/* 104 */       Iterator<SingleChildRatingRankInfo> iterator = MergedRankInfoList.iterator();
/* 105 */       for (int i = 1; i <= RatingRankSize; i++)
/*     */       {
/* 107 */         if (!iterator.hasNext()) {
/*     */           break;
/*     */         }
/*     */         
/* 111 */         xMainSingleRatingRankInfoList.add(((SingleChildRatingRankInfo)iterator.next()).copy());
/*     */       }
/*     */       
/* 114 */       Childrenratingrank.remove(Long.valueOf(viceZoneId));
/*     */       
/* 116 */       GameServer.logger().info(String.format("[merge]ChildrenModule.PChildrenRankMerge.processImpl@handle children rating rank merge success|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneId), Long.valueOf(viceZoneId) }));
/*     */       
/*     */ 
/*     */ 
/* 120 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\ChildrenModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */