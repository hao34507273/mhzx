/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.chart.main.ChartCfgManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RolekejuRank;
/*     */ import xdb.Table;
/*     */ import xtable.Gloablekeju;
/*     */ import xtable.Role2keju;
/*     */ import xtable.Rolekejurank;
/*     */ 
/*     */ public class KejuMerger implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  22 */     List<Table> tables = new ArrayList();
/*  23 */     tables.add(Role2keju.getTable());
/*  24 */     tables.add(Gloablekeju.getTable());
/*  25 */     tables.add(Rolekejurank.getTable());
/*  26 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  32 */     boolean ret = new Merge_Gloablekeju_Pro(null).call();
/*  33 */     if (!ret)
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     ret = new Merge_Rolekejurank_Pro(null).call();
/*     */     
/*  39 */     return ret;
/*     */   }
/*     */   
/*     */   private static class Merge_Gloablekeju_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  48 */       long mainKey = MergeMain.getMainZoneid();
/*  49 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  51 */       lock(Gloablekeju.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  53 */       Gloablekeju.remove(Long.valueOf(viceKey));
/*  54 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Rolekejurank_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  65 */       long mainKey = MergeMain.getMainZoneid();
/*  66 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  68 */       lock(Rolekejurank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  70 */       RolekejuRank xMainkejuRank = Rolekejurank.get(Long.valueOf(mainKey));
/*  71 */       RolekejuRank xVicekejuRank = Rolekejurank.get(Long.valueOf(viceKey));
/*     */       
/*  73 */       if ((xMainkejuRank == null) || (xVicekejuRank == null))
/*     */       {
/*  75 */         if (xVicekejuRank != null)
/*     */         {
/*  77 */           xMainkejuRank = xbean.Pod.newRolekejuRank();
/*  78 */           Rolekejurank.insert(Long.valueOf(mainKey), xMainkejuRank);
/*     */           
/*  80 */           for (int i = 0; i < xVicekejuRank.getRankdatas().size(); i++)
/*     */           {
/*  82 */             xMainkejuRank.getRankdatas().add(xVicekejuRank.getRankdatas().get(i));
/*     */ 
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  93 */         List<Long> roleList = new ArrayList(xMainkejuRank.getRankdatas().size() + xVicekejuRank.getRankdatas().size());
/*     */         
/*     */ 
/*  96 */         roleList.addAll(xMainkejuRank.getRankdatas());
/*  97 */         roleList.addAll(xVicekejuRank.getRankdatas());
/*     */         
/*  99 */         lock(Role2keju.getTable(), roleList);
/* 100 */         List<KejuMerger.RoleKejuPoint> list = new ArrayList();
/* 101 */         for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 103 */           int point = KeJuQuestionManager.getInstance().getDianshiUsetime(roleid, true);
/* 104 */           KejuMerger.RoleKejuPoint roleKejuPoint = new KejuMerger.RoleKejuPoint(roleid, point);
/* 105 */           list.add(roleKejuPoint);
/*     */         }
/*     */         
/* 108 */         java.util.Collections.sort(list);
/*     */         
/* 110 */         int size = xMainkejuRank.getRankdatas().size();
/* 111 */         xMainkejuRank.getRankdatas().clear();
/*     */         
/* 113 */         SChartSubTypeCfg sChartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(4);
/* 114 */         if (sChartSubTypeCfg != null)
/*     */         {
/* 116 */           size = sChartSubTypeCfg.capacity;
/*     */         }
/* 118 */         for (int i = 0; i < Math.min(size, list.size()); i++)
/*     */         {
/* 120 */           xMainkejuRank.getRankdatas().add(Long.valueOf(((KejuMerger.RoleKejuPoint)list.get(i)).getRoleId()));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 125 */       Rolekejurank.remove(Long.valueOf(viceKey));
/* 126 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RoleKejuPoint
/*     */     implements Comparable<RoleKejuPoint>
/*     */   {
/*     */     private final long roleId;
/*     */     private final int point;
/*     */     
/*     */     public RoleKejuPoint(long roleId, int point)
/*     */     {
/* 138 */       this.roleId = roleId;
/* 139 */       this.point = point;
/*     */     }
/*     */     
/*     */ 
/*     */     public int compareTo(RoleKejuPoint o)
/*     */     {
/* 145 */       return getPoint() - o.getPoint();
/*     */     }
/*     */     
/*     */     public long getRoleId()
/*     */     {
/* 150 */       return this.roleId;
/*     */     }
/*     */     
/*     */     public int getPoint()
/*     */     {
/* 155 */       return this.point;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\KejuMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */