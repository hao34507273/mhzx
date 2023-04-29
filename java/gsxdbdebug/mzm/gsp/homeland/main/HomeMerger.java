/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.chart.main.ChartCfgManager;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomelandRankList;
/*     */ import xdb.Table;
/*     */ import xtable.Homelandrank;
/*     */ import xtable.Role2homeinfo;
/*     */ import xtable.Role2homeoperate;
/*     */ 
/*     */ public class HomeMerger implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  22 */     List<Table> tables = new ArrayList();
/*  23 */     tables.add(Role2homeinfo.getTable());
/*  24 */     tables.add(Role2homeoperate.getTable());
/*  25 */     tables.add(Homelandrank.getTable());
/*     */     
/*  27 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  33 */     return new Merger_Homelandrank_Pro(null).call();
/*     */   }
/*     */   
/*     */   private static class Merger_Homelandrank_Pro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  41 */       long mainKey = MergeMain.getMainZoneid();
/*  42 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  44 */       lock(Homelandrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*  45 */       HomelandRankList xMainRankList = Homelandrank.get(Long.valueOf(mainKey));
/*  46 */       HomelandRankList xViceRankList = Homelandrank.get(Long.valueOf(viceKey));
/*  47 */       if ((xMainRankList == null) || (xViceRankList == null))
/*     */       {
/*  49 */         if (xViceRankList != null)
/*     */         {
/*  51 */           xMainRankList = xbean.Pod.newHomelandRankList();
/*  52 */           xMainRankList.setAwardtime(xViceRankList.getAwardtime());
/*  53 */           Homelandrank.insert(Long.valueOf(mainKey), xMainRankList);
/*     */           
/*  55 */           for (int i = 0; i < xViceRankList.getRanklist().size(); i++)
/*     */           {
/*  57 */             xMainRankList.getRanklist().add(xViceRankList.getRanklist().get(i));
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  67 */         List<Long> roleList = new ArrayList(xMainRankList.getRanklist().size() + xViceRankList.getRanklist().size());
/*     */         
/*  69 */         roleList.addAll(xMainRankList.getRanklist());
/*  70 */         roleList.addAll(xViceRankList.getRanklist());
/*     */         
/*  72 */         lock(Role2homeinfo.getTable(), roleList);
/*  73 */         List<HomeMerger.RoleHomePoint> list = new ArrayList();
/*  74 */         for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/*  76 */           HomeInfo xHomeInfo = Role2homeinfo.get(Long.valueOf(roleid));
/*  77 */           int point = HomelandManager.getHomelandPoint(xHomeInfo);
/*  78 */           HomeMerger.RoleHomePoint roleHomePoint = new HomeMerger.RoleHomePoint(roleid, point);
/*  79 */           list.add(roleHomePoint);
/*     */         }
/*     */         
/*  82 */         java.util.Collections.sort(list);
/*     */         
/*  84 */         int size = xMainRankList.getRanklist().size();
/*  85 */         xMainRankList.getRanklist().clear();
/*  86 */         SChartSubTypeCfg sChartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(22);
/*  87 */         if (sChartSubTypeCfg != null)
/*     */         {
/*  89 */           size = sChartSubTypeCfg.capacity;
/*     */         }
/*  91 */         for (int i = 0; i < Math.min(size, list.size()); i++)
/*     */         {
/*  93 */           xMainRankList.getRanklist().add(Long.valueOf(((HomeMerger.RoleHomePoint)list.get(i)).getRoleId()));
/*     */         }
/*  95 */         xMainRankList.setAwardtime(Math.max(xMainRankList.getAwardtime(), xViceRankList.getAwardtime()));
/*     */       }
/*     */       
/*  98 */       Homelandrank.remove(Long.valueOf(viceKey));
/*  99 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RoleHomePoint implements Comparable<RoleHomePoint>
/*     */   {
/*     */     private final long roleId;
/*     */     private final int point;
/*     */     
/*     */     public RoleHomePoint(long roleId, int point)
/*     */     {
/* 110 */       this.roleId = roleId;
/* 111 */       this.point = point;
/*     */     }
/*     */     
/*     */ 
/*     */     public int compareTo(RoleHomePoint o)
/*     */     {
/* 117 */       return o.getPoint() - this.point;
/*     */     }
/*     */     
/*     */     public long getRoleId()
/*     */     {
/* 122 */       return this.roleId;
/*     */     }
/*     */     
/*     */     public int getPoint()
/*     */     {
/* 127 */       return this.point;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\HomeMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */