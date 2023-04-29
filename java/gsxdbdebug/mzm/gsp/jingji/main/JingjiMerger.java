/*     */ package mzm.gsp.jingji.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.JingJiDailyRank;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleJingJiBean;
/*     */ import xbean.RoleJingJiRank;
/*     */ import xtable.Jingjidailytrankbackup;
/*     */ import xtable.Rolejingjirank;
/*     */ import xtable.Rolejingjirank_backup;
/*     */ 
/*     */ public class JingjiMerger implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  22 */     List<xdb.Table> tables = new ArrayList();
/*     */     
/*  24 */     tables.add(xtable.Jingji.getTable());
/*  25 */     tables.add(Rolejingjirank.getTable());
/*  26 */     tables.add(Rolejingjirank_backup.getTable());
/*  27 */     tables.add(xtable.Role2jingjipvp.getTable());
/*  28 */     tables.add(Jingjidailytrankbackup.getTable());
/*     */     
/*  30 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  36 */     Merge_Jingji_Pro m = new Merge_Jingji_Pro(null);
/*  37 */     boolean ret = m.call();
/*     */     
/*  39 */     if (!ret)
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     boolean isNeedResetSeason = m.isNeedResetSeason();
/*  44 */     ret = new Merge_Rolejingjirank_Pro(isNeedResetSeason).call();
/*  45 */     if (!ret)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     ret = new Merge_Rolejingjirank_backup_Pro(null).call();
/*  50 */     if (!ret)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     ret = new PJingJiDailyRankBackupMerge(null).call();
/*     */     
/*  57 */     return ret;
/*     */   }
/*     */   
/*     */   private static class Merge_Jingji_Pro
/*     */     extends LogicProcedure
/*     */   {
/*  63 */     private boolean isNeedResetSeason = false;
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  68 */       long mainKey = MergeMain.getMainZoneid();
/*  69 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  71 */       lock(xtable.Jingji.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*  72 */       xbean.Jingji xMainJingji = xtable.Jingji.get(Long.valueOf(mainKey));
/*  73 */       xbean.Jingji xViceJingji = xtable.Jingji.get(Long.valueOf(viceKey));
/*     */       
/*  75 */       long mainSeasonStarttime = xMainJingji.getSeasonstarttime();
/*  76 */       long viceSeasonStarttime = xViceJingji.getSeasonstarttime();
/*  77 */       if (mainSeasonStarttime != viceSeasonStarttime)
/*     */       {
/*  79 */         this.isNeedResetSeason = true;
/*  80 */         xMainJingji.setMerge_clear(1);
/*     */         
/*  82 */         if (viceSeasonStarttime > mainSeasonStarttime)
/*     */         {
/*  84 */           xMainJingji.setSeasonstarttime(viceSeasonStarttime);
/*     */         }
/*     */       }
/*     */       
/*  88 */       xtable.Jingji.remove(Long.valueOf(viceKey));
/*  89 */       return true;
/*     */     }
/*     */     
/*     */     public boolean isNeedResetSeason()
/*     */     {
/*  94 */       return this.isNeedResetSeason;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class Merge_Rolejingjirank_backup_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 106 */       long viceKey = MergeMain.getViceZoneid();
/* 107 */       lock(Rolejingjirank_backup.getTable(), Arrays.asList(new Long[] { Long.valueOf(viceKey) }));
/* 108 */       Rolejingjirank_backup.remove(Long.valueOf(viceKey));
/* 109 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Merge_Rolejingjirank_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final boolean isNeedResetSeason;
/*     */     
/*     */     public Merge_Rolejingjirank_Pro(boolean isNeedResetSeason)
/*     */     {
/* 121 */       this.isNeedResetSeason = isNeedResetSeason;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 127 */       long mainKey = MergeMain.getMainZoneid();
/* 128 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 130 */       lock(Rolejingjirank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 132 */       RoleJingJiRank xMainJingJiRank = Rolejingjirank.get(Long.valueOf(mainKey));
/* 133 */       RoleJingJiRank xViceJingJiRank = Rolejingjirank.get(Long.valueOf(viceKey));
/*     */       
/* 135 */       if (this.isNeedResetSeason)
/*     */       {
/* 137 */         Rolejingjirank.remove(Long.valueOf(mainKey));
/* 138 */         Rolejingjirank.remove(Long.valueOf(viceKey));
/* 139 */         return true;
/*     */       }
/*     */       
/* 142 */       if ((xMainJingJiRank == null) || (xViceJingJiRank == null))
/*     */       {
/* 144 */         if (xViceJingJiRank != null)
/*     */         {
/* 146 */           xMainJingJiRank = Pod.newRoleJingJiRank();
/* 147 */           Rolejingjirank.insert(Long.valueOf(mainKey), xMainJingJiRank);
/*     */           
/* 149 */           for (int i = 0; i < xViceJingJiRank.getRankdatas().size(); i++)
/*     */           {
/* 151 */             RoleJingJiBean xrRoleJingJiBean = Pod.newRoleJingJiBean();
/* 152 */             xrRoleJingJiBean.setRoleid(((RoleJingJiBean)xViceJingJiRank.getRankdatas().get(i)).getRoleid());
/* 153 */             xMainJingJiRank.getRankdatas().add(xrRoleJingJiBean);
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 166 */         List<Long> roleList = new ArrayList(xMainJingJiRank.getRankdatas().size() + xViceJingJiRank.getRankdatas().size());
/*     */         
/*     */ 
/* 169 */         for (RoleJingJiBean xrRoleJingJiBean : xMainJingJiRank.getRankdatas())
/*     */         {
/* 171 */           roleList.add(Long.valueOf(xrRoleJingJiBean.getRoleid()));
/*     */         }
/* 173 */         for (RoleJingJiBean xrRoleJingJiBean : xViceJingJiRank.getRankdatas())
/*     */         {
/* 175 */           roleList.add(Long.valueOf(xrRoleJingJiBean.getRoleid()));
/*     */         }
/*     */         
/* 178 */         lock(xtable.Role2jingjipvp.getTable(), roleList);
/* 179 */         List<JingjiMerger.RoleJingjiPoint> list = new ArrayList();
/* 180 */         for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 182 */           int point = JingjiManager.getWinpoint(roleid, true);
/* 183 */           JingjiMerger.RoleJingjiPoint roleJingjiPoint = new JingjiMerger.RoleJingjiPoint(roleid, point);
/* 184 */           list.add(roleJingjiPoint);
/*     */         }
/*     */         
/* 187 */         java.util.Collections.sort(list);
/*     */         
/* 189 */         int size = xMainJingJiRank.getRankdatas().size();
/* 190 */         xMainJingJiRank.getRankdatas().clear();
/*     */         
/* 192 */         SChartSubTypeCfg sChartSubTypeCfg = mzm.gsp.chart.main.ChartCfgManager.getChartSubTypeCfg(3);
/* 193 */         if (sChartSubTypeCfg != null)
/*     */         {
/* 195 */           size = sChartSubTypeCfg.capacity;
/*     */         }
/* 197 */         for (int i = 0; i < Math.min(size, list.size()); i++)
/*     */         {
/* 199 */           RoleJingJiBean xrRoleJingJiBean = Pod.newRoleJingJiBean();
/* 200 */           xrRoleJingJiBean.setRoleid(((JingjiMerger.RoleJingjiPoint)list.get(i)).getRoleId());
/* 201 */           xMainJingJiRank.getRankdatas().add(xrRoleJingJiBean);
/*     */         }
/*     */       }
/*     */       
/* 205 */       Rolejingjirank.remove(Long.valueOf(viceKey));
/* 206 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RoleJingjiPoint
/*     */     implements Comparable<RoleJingjiPoint>
/*     */   {
/*     */     private final long roleId;
/*     */     private final int point;
/*     */     
/*     */     public RoleJingjiPoint(long roleId, int point)
/*     */     {
/* 218 */       this.roleId = roleId;
/* 219 */       this.point = point;
/*     */     }
/*     */     
/*     */ 
/*     */     public int compareTo(RoleJingjiPoint o)
/*     */     {
/* 225 */       return o.getPoint() - this.point;
/*     */     }
/*     */     
/*     */     public long getRoleId()
/*     */     {
/* 230 */       return this.roleId;
/*     */     }
/*     */     
/*     */     public int getPoint()
/*     */     {
/* 235 */       return this.point;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PJingJiDailyRankBackupMerge
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 245 */       long mainKey = MergeMain.getMainZoneid();
/* 246 */       long viceKey = MergeMain.getViceZoneid();
/* 247 */       lock(Jingjidailytrankbackup.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 249 */       JingJiDailyRank xViceJingji = Jingjidailytrankbackup.get(Long.valueOf(viceKey));
/* 250 */       if (xViceJingji != null)
/*     */       {
/* 252 */         JingJiDailyRank xMainJingji = Jingjidailytrankbackup.get(Long.valueOf(mainKey));
/* 253 */         if (xMainJingji == null)
/*     */         {
/* 255 */           xMainJingji = Pod.newJingJiDailyRank();
/* 256 */           xMainJingji.setTime(xViceJingji.getTime());
/* 257 */           Jingjidailytrankbackup.insert(Long.valueOf(mainKey), xMainJingji);
/*     */         }
/* 259 */         xMainJingji.getRole_ranks().putAll(xViceJingji.getRole_ranks());
/* 260 */         for (RoleJingJiBean xRoleJingJiBean : xViceJingji.getRank_datas())
/*     */         {
/* 262 */           xMainJingji.getRank_datas().add(xRoleJingJiBean.copy());
/*     */         }
/*     */         
/* 265 */         Jingjidailytrankbackup.remove(Long.valueOf(viceKey));
/*     */       }
/* 267 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingjiMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */