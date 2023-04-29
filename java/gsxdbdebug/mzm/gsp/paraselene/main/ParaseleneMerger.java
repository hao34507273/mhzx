/*     */ package mzm.gsp.paraselene.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.chart.main.ChartCfgManager;
/*     */ import xbean.ParaseleneRank;
/*     */ import xbean.ParaseleneRankRole;
/*     */ import xbean.Pod;
/*     */ import xdb.Table;
/*     */ import xtable.Paraselenerank;
/*     */ import xtable.Role2paraselene;
/*     */ 
/*     */ public class ParaseleneMerger implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  22 */     List<Table> tables = new ArrayList();
/*     */     
/*  24 */     tables.add(Role2paraselene.getTable());
/*  25 */     tables.add(Paraselenerank.getTable());
/*     */     
/*  27 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  34 */     return new Merge_Paraselenerank_Pro(null).call();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Paraselenerank_Pro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  44 */       long mainKey = MergeMain.getMainZoneid();
/*  45 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  47 */       lock(Paraselenerank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  49 */       ParaseleneRank xMainParaseleneRank = Paraselenerank.get(Long.valueOf(mainKey));
/*  50 */       ParaseleneRank xViceParaseleneRank = Paraselenerank.get(Long.valueOf(viceKey));
/*     */       
/*  52 */       if ((xMainParaseleneRank == null) || (xViceParaseleneRank == null))
/*     */       {
/*  54 */         if (xViceParaseleneRank != null)
/*     */         {
/*  56 */           xMainParaseleneRank = Pod.newParaseleneRank();
/*  57 */           Paraselenerank.insert(Long.valueOf(mainKey), xMainParaseleneRank);
/*     */           
/*  59 */           for (int i = 0; i < xViceParaseleneRank.getRanklist().size(); i++)
/*     */           {
/*  61 */             ParaseleneRankRole xParaseleneRankRole = Pod.newParaseleneRankRole();
/*  62 */             xParaseleneRankRole.setRoleid(((ParaseleneRankRole)xViceParaseleneRank.getRanklist().get(i)).getRoleid());
/*  63 */             xMainParaseleneRank.getRanklist().add(xParaseleneRankRole);
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  75 */         List<Long> roleList = new ArrayList(xMainParaseleneRank.getRanklist().size() + xViceParaseleneRank.getRanklist().size());
/*     */         
/*  77 */         for (ParaseleneRankRole xParaseleneRankRole : xMainParaseleneRank.getRanklist())
/*     */         {
/*  79 */           roleList.add(Long.valueOf(xParaseleneRankRole.getRoleid()));
/*     */         }
/*  81 */         for (ParaseleneRankRole xParaseleneRankRole : xViceParaseleneRank.getRanklist())
/*     */         {
/*  83 */           roleList.add(Long.valueOf(xParaseleneRankRole.getRoleid()));
/*     */         }
/*  85 */         lock(Role2paraselene.getTable(), roleList);
/*  86 */         List<ParaseleneMerger.RoleParaselenePoint> list = new ArrayList();
/*  87 */         for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/*  89 */           int point = ParaseleneManager.getRoleFinishtime(roleid);
/*  90 */           ParaseleneMerger.RoleParaselenePoint roleParaselenePoint = new ParaseleneMerger.RoleParaselenePoint(roleid, point);
/*  91 */           list.add(roleParaselenePoint);
/*     */         }
/*     */         
/*  94 */         java.util.Collections.sort(list);
/*     */         
/*  96 */         int size = xMainParaseleneRank.getRanklist().size();
/*  97 */         xMainParaseleneRank.getRanklist().clear();
/*     */         
/*  99 */         SChartSubTypeCfg sChartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(10);
/* 100 */         if (sChartSubTypeCfg != null)
/*     */         {
/* 102 */           size = sChartSubTypeCfg.capacity;
/*     */         }
/* 104 */         for (int i = 0; i < Math.min(size, list.size()); i++)
/*     */         {
/* 106 */           ParaseleneRankRole xParaseleneRankRole = Pod.newParaseleneRankRole();
/* 107 */           xParaseleneRankRole.setRoleid(((ParaseleneMerger.RoleParaselenePoint)list.get(i)).getRoleId());
/* 108 */           xMainParaseleneRank.getRanklist().add(xParaseleneRankRole);
/*     */         }
/*     */       }
/*     */       
/* 112 */       Paraselenerank.remove(Long.valueOf(viceKey));
/* 113 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RoleParaselenePoint
/*     */     implements Comparable<RoleParaselenePoint>
/*     */   {
/*     */     private final long roleId;
/*     */     private final int point;
/*     */     
/*     */     public RoleParaselenePoint(long roleId, int point)
/*     */     {
/* 125 */       this.roleId = roleId;
/* 126 */       this.point = point;
/*     */     }
/*     */     
/*     */ 
/*     */     public int compareTo(RoleParaselenePoint o)
/*     */     {
/* 132 */       return getPoint() - o.getPoint();
/*     */     }
/*     */     
/*     */     public long getRoleId()
/*     */     {
/* 137 */       return this.roleId;
/*     */     }
/*     */     
/*     */     public int getPoint()
/*     */     {
/* 142 */       return this.point;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */