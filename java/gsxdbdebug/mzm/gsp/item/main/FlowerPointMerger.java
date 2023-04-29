/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FlowerPointClear;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleGiveFlowerBean;
/*     */ import xbean.RoleGiveFlowerRank;
/*     */ import xbean.RoleReceivceFlowerRank;
/*     */ import xbean.RoleReceiveFlowerBean;
/*     */ import xtable.Flowerpointclear;
/*     */ import xtable.Rolegiveflowerrank;
/*     */ import xtable.Rolereceiveflowerrank;
/*     */ 
/*     */ public class FlowerPointMerger implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  22 */     List<xdb.Table> tables = new java.util.ArrayList();
/*     */     
/*  24 */     tables.add(xtable.Role2flowerpoint.getTable());
/*  25 */     tables.add(Flowerpointclear.getTable());
/*  26 */     tables.add(Rolegiveflowerrank.getTable());
/*  27 */     tables.add(Rolereceiveflowerrank.getTable());
/*  28 */     tables.add(xtable.Rolegiveflowerrank_backup.getTable());
/*  29 */     tables.add(xtable.Rolereceiveflowerrank_backup.getTable());
/*  30 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  37 */     boolean ret = new Merge_Flowerpointclear_Pro(null).call();
/*  38 */     if (!ret)
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     ret = new Merge_Rolegiveflowerrank_Pro(null).call();
/*  44 */     if (!ret)
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     ret = new Merge_Rolereceiveflowerrank_Pro(null).call();
/*     */     
/*  51 */     if (!ret)
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     ret = new Merge_Rolegiveflowerrank_backup_Pro(null).call();
/*  57 */     if (!ret)
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     ret = new Merge_Rolereceiveflowerrank_backup_Pro(null).call();
/*  63 */     if (!ret)
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Flowerpointclear_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  77 */       long mainKey = MergeMain.getMainZoneid();
/*  78 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  80 */       lock(Flowerpointclear.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*  81 */       FlowerPointClear xMain = Flowerpointclear.get(Long.valueOf(mainKey));
/*  82 */       FlowerPointClear xVice = Flowerpointclear.get(Long.valueOf(viceKey));
/*     */       
/*     */ 
/*  85 */       xMain.setFlowerrefreshtime(Math.min(xMain.getFlowerrefreshtime(), xVice.getFlowerrefreshtime()));
/*     */       
/*  87 */       Flowerpointclear.remove(Long.valueOf(viceKey));
/*  88 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Rolegiveflowerrank_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  99 */       long mainKey = MergeMain.getMainZoneid();
/* 100 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 102 */       lock(Rolegiveflowerrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 104 */       RoleGiveFlowerRank xMainRoleGiveFlowerRank = Rolegiveflowerrank.get(Long.valueOf(mainKey));
/* 105 */       RoleGiveFlowerRank xViceRoleGiveFlowerRank = Rolegiveflowerrank.get(Long.valueOf(viceKey));
/*     */       
/* 107 */       if ((xMainRoleGiveFlowerRank == null) || (xViceRoleGiveFlowerRank == null))
/*     */       {
/* 109 */         if (xViceRoleGiveFlowerRank != null)
/*     */         {
/* 111 */           xMainRoleGiveFlowerRank = Pod.newRoleGiveFlowerRank();
/* 112 */           xMainRoleGiveFlowerRank.setVersion(xViceRoleGiveFlowerRank.getVersion());
/* 113 */           Rolegiveflowerrank.insert(Long.valueOf(mainKey), xMainRoleGiveFlowerRank);
/*     */           
/* 115 */           for (int i = 0; i < xViceRoleGiveFlowerRank.getRankdatas().size(); i++)
/*     */           {
/* 117 */             RoleGiveFlowerBean xRoleGiveFlowerBean = Pod.newRoleGiveFlowerBean();
/* 118 */             xRoleGiveFlowerBean.setRoleid(((RoleGiveFlowerBean)xViceRoleGiveFlowerRank.getRankdatas().get(i)).getRoleid());
/* 119 */             xRoleGiveFlowerBean.setPoint(((RoleGiveFlowerBean)xViceRoleGiveFlowerRank.getRankdatas().get(i)).getPoint());
/* 120 */             xMainRoleGiveFlowerRank.getRankdatas().add(xRoleGiveFlowerBean);
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 133 */       else if (xMainRoleGiveFlowerRank.getVersion() != xViceRoleGiveFlowerRank.getVersion())
/*     */       {
/* 135 */         xMainRoleGiveFlowerRank.setVersion(Math.max(xMainRoleGiveFlowerRank.getVersion(), xViceRoleGiveFlowerRank.getVersion()));
/*     */         
/* 137 */         xMainRoleGiveFlowerRank.getRankdatas().clear();
/*     */       }
/*     */       else
/*     */       {
/* 141 */         List<FlowerPointMerger.RoleFlowerPoint> list = new java.util.ArrayList(xMainRoleGiveFlowerRank.getRankdatas().size() + xViceRoleGiveFlowerRank.getRankdatas().size());
/*     */         
/* 143 */         for (RoleGiveFlowerBean xGiveFlowerBean : xMainRoleGiveFlowerRank.getRankdatas())
/*     */         {
/* 145 */           FlowerPointMerger.RoleFlowerPoint roleFlowerPoint = new FlowerPointMerger.RoleFlowerPoint(xGiveFlowerBean.getRoleid(), xGiveFlowerBean.getPoint());
/*     */           
/* 147 */           list.add(roleFlowerPoint);
/*     */         }
/* 149 */         for (RoleGiveFlowerBean xGiveFlowerBean : xViceRoleGiveFlowerRank.getRankdatas())
/*     */         {
/* 151 */           FlowerPointMerger.RoleFlowerPoint roleFlowerPoint = new FlowerPointMerger.RoleFlowerPoint(xGiveFlowerBean.getRoleid(), xGiveFlowerBean.getPoint());
/*     */           
/* 153 */           list.add(roleFlowerPoint);
/*     */         }
/*     */         
/* 156 */         java.util.Collections.sort(list);
/*     */         
/* 158 */         int size = xMainRoleGiveFlowerRank.getRankdatas().size();
/* 159 */         xMainRoleGiveFlowerRank.getRankdatas().clear();
/*     */         
/* 161 */         SChartSubTypeCfg sChartSubTypeCfg = mzm.gsp.chart.main.ChartCfgManager.getChartSubTypeCfg(5);
/* 162 */         if (sChartSubTypeCfg != null)
/*     */         {
/* 164 */           size = sChartSubTypeCfg.capacity;
/*     */         }
/* 166 */         for (int i = 0; i < Math.min(size, list.size()); i++)
/*     */         {
/* 168 */           RoleGiveFlowerBean xRoleGiveFlowerBean = Pod.newRoleGiveFlowerBean();
/* 169 */           xRoleGiveFlowerBean.setRoleid(((FlowerPointMerger.RoleFlowerPoint)list.get(i)).getRoleId());
/* 170 */           xRoleGiveFlowerBean.setPoint(((FlowerPointMerger.RoleFlowerPoint)list.get(i)).getPoint());
/* 171 */           xMainRoleGiveFlowerRank.getRankdatas().add(xRoleGiveFlowerBean);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 177 */       Rolegiveflowerrank.remove(Long.valueOf(viceKey));
/* 178 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Rolereceiveflowerrank_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 189 */       long mainKey = MergeMain.getMainZoneid();
/* 190 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 192 */       lock(Rolereceiveflowerrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 194 */       RoleReceivceFlowerRank xMainReceivceFlowerRank = Rolereceiveflowerrank.get(Long.valueOf(mainKey));
/* 195 */       RoleReceivceFlowerRank xViceReceivceFlowerRank = Rolereceiveflowerrank.get(Long.valueOf(viceKey));
/*     */       
/* 197 */       if ((xMainReceivceFlowerRank == null) || (xViceReceivceFlowerRank == null))
/*     */       {
/* 199 */         if (xViceReceivceFlowerRank != null)
/*     */         {
/* 201 */           xMainReceivceFlowerRank = Pod.newRoleReceivceFlowerRank();
/* 202 */           Rolereceiveflowerrank.insert(Long.valueOf(mainKey), xMainReceivceFlowerRank);
/* 203 */           xMainReceivceFlowerRank.setVersion(xViceReceivceFlowerRank.getVersion());
/* 204 */           for (int i = 0; i < xViceReceivceFlowerRank.getRankdatas().size(); i++)
/*     */           {
/* 206 */             RoleReceiveFlowerBean xRoleReceiveFlowerBean = Pod.newRoleReceiveFlowerBean();
/* 207 */             xRoleReceiveFlowerBean.setRoleid(((RoleReceiveFlowerBean)xViceReceivceFlowerRank.getRankdatas().get(i)).getRoleid());
/* 208 */             xRoleReceiveFlowerBean.setPoint(((RoleReceiveFlowerBean)xViceReceivceFlowerRank.getRankdatas().get(i)).getPoint());
/* 209 */             xMainReceivceFlowerRank.getRankdatas().add(xRoleReceiveFlowerBean);
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 222 */       else if (xMainReceivceFlowerRank.getVersion() != xViceReceivceFlowerRank.getVersion())
/*     */       {
/* 224 */         xMainReceivceFlowerRank.setVersion(Math.max(xMainReceivceFlowerRank.getVersion(), xViceReceivceFlowerRank.getVersion()));
/*     */         
/* 226 */         xMainReceivceFlowerRank.getRankdatas().clear();
/*     */       }
/*     */       else
/*     */       {
/* 230 */         List<FlowerPointMerger.RoleFlowerPoint> list = new java.util.ArrayList(xMainReceivceFlowerRank.getRankdatas().size() + xViceReceivceFlowerRank.getRankdatas().size());
/*     */         
/*     */ 
/* 233 */         for (RoleReceiveFlowerBean xReceiveFlowerBean : xMainReceivceFlowerRank.getRankdatas())
/*     */         {
/* 235 */           FlowerPointMerger.RoleFlowerPoint roleFlowerPoint = new FlowerPointMerger.RoleFlowerPoint(xReceiveFlowerBean.getRoleid(), xReceiveFlowerBean.getPoint());
/*     */           
/* 237 */           list.add(roleFlowerPoint);
/*     */         }
/* 239 */         for (RoleReceiveFlowerBean xReceiveFlowerBean : xViceReceivceFlowerRank.getRankdatas())
/*     */         {
/* 241 */           FlowerPointMerger.RoleFlowerPoint roleFlowerPoint = new FlowerPointMerger.RoleFlowerPoint(xReceiveFlowerBean.getRoleid(), xReceiveFlowerBean.getPoint());
/*     */           
/* 243 */           list.add(roleFlowerPoint);
/*     */         }
/*     */         
/* 246 */         java.util.Collections.sort(list);
/*     */         
/* 248 */         int size = xMainReceivceFlowerRank.getRankdatas().size();
/* 249 */         xMainReceivceFlowerRank.getRankdatas().clear();
/*     */         
/* 251 */         SChartSubTypeCfg sChartSubTypeCfg = mzm.gsp.chart.main.ChartCfgManager.getChartSubTypeCfg(6);
/* 252 */         if (sChartSubTypeCfg != null)
/*     */         {
/* 254 */           size = sChartSubTypeCfg.capacity;
/*     */         }
/* 256 */         for (int i = 0; i < Math.min(size, list.size()); i++)
/*     */         {
/* 258 */           RoleReceiveFlowerBean xRoleReceiveFlowerBean = Pod.newRoleReceiveFlowerBean();
/* 259 */           xRoleReceiveFlowerBean.setRoleid(((FlowerPointMerger.RoleFlowerPoint)list.get(i)).getRoleId());
/* 260 */           xRoleReceiveFlowerBean.setPoint(((FlowerPointMerger.RoleFlowerPoint)list.get(i)).getPoint());
/* 261 */           xMainReceivceFlowerRank.getRankdatas().add(xRoleReceiveFlowerBean);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 267 */       Rolereceiveflowerrank.remove(Long.valueOf(viceKey));
/* 268 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RoleFlowerPoint
/*     */     implements Comparable<RoleFlowerPoint>
/*     */   {
/*     */     private final long roleId;
/*     */     private final int point;
/*     */     
/*     */     public RoleFlowerPoint(long roleId, int point)
/*     */     {
/* 280 */       this.roleId = roleId;
/* 281 */       this.point = point;
/*     */     }
/*     */     
/*     */ 
/*     */     public int compareTo(RoleFlowerPoint o)
/*     */     {
/* 287 */       return o.getPoint() - this.point;
/*     */     }
/*     */     
/*     */     public long getRoleId()
/*     */     {
/* 292 */       return this.roleId;
/*     */     }
/*     */     
/*     */     public int getPoint()
/*     */     {
/* 297 */       return this.point;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Rolegiveflowerrank_backup_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 308 */       long mainKey = MergeMain.getMainZoneid();
/* 309 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 311 */       lock(xtable.Rolegiveflowerrank_backup.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 312 */       xtable.Rolegiveflowerrank_backup.remove(Long.valueOf(viceKey));
/* 313 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Rolereceiveflowerrank_backup_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 324 */       long mainKey = MergeMain.getMainZoneid();
/* 325 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 327 */       lock(xtable.Rolereceiveflowerrank_backup.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 328 */       xtable.Rolereceiveflowerrank_backup.remove(Long.valueOf(viceKey));
/* 329 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\FlowerPointMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */