/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.bigboss.confbean.SOcp2ChartType;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.OcpBigBossRoleList;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleBossBean;
/*     */ import xtable.Bigbossactivity;
/*     */ import xtable.Ocpbossrank;
/*     */ import xtable.Role2bigboss;
/*     */ import xtable.Rolebossrank;
/*     */ 
/*     */ public class BigbossMerger implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  24 */     List<xdb.Table> tables = new ArrayList();
/*  25 */     tables.add(Role2bigboss.getTable());
/*  26 */     tables.add(Bigbossactivity.getTable());
/*  27 */     tables.add(Rolebossrank.getTable());
/*  28 */     tables.add(Ocpbossrank.getTable());
/*  29 */     tables.add(xtable.Role_big_boss_remote_chart_infos.getTable());
/*  30 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  37 */     boolean ret = new Merger_Bigbossactivity_Pro(null).call();
/*  38 */     if (!ret)
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     ret = new Merger_Rolebossrank_Pro(null).call();
/*  43 */     if (!ret)
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     for (Iterator i$ = SOcp2ChartType.getAll().keySet().iterator(); i$.hasNext();) { int ocp = ((Integer)i$.next()).intValue();
/*     */       
/*  50 */       ret = new Merger_Ocpbossrank_Pro(ocp, SOcp2ChartType.get(ocp).charttype).call();
/*  51 */       if (!ret)
/*     */       {
/*  53 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  57 */     return ret;
/*     */   }
/*     */   
/*     */   private static class Merger_Bigbossactivity_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  65 */       long mainKey = MergeMain.getMainZoneid();
/*  66 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  68 */       lock(Bigbossactivity.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  70 */       Bigbossactivity.remove(Long.valueOf(viceKey));
/*     */       
/*  72 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Merger_Rolebossrank_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  81 */       long mainKey = MergeMain.getMainZoneid();
/*  82 */       long viceKey = MergeMain.getViceZoneid();
/*  83 */       lock(Rolebossrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*  84 */       Rolebossrank.remove(Long.valueOf(mainKey));
/*  85 */       Rolebossrank.remove(Long.valueOf(viceKey));
/*  86 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Merger_Ocpbossrank_Pro extends LogicProcedure
/*     */   {
/*     */     private final int ocp;
/*     */     private final int charttype;
/*     */     
/*     */     public Merger_Ocpbossrank_Pro(int ocp, int charttype)
/*     */     {
/*  97 */       this.ocp = ocp;
/*  98 */       this.charttype = charttype;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 104 */       long mainZoneid = MergeMain.getMainZoneid();
/* 105 */       long viceZoneid = MergeMain.getViceZoneid();
/* 106 */       long viceK = GameServerInfoManager.toGlobalId(this.ocp, viceZoneid);
/* 107 */       long mainK = GameServerInfoManager.toGlobalId(this.ocp, mainZoneid);
/*     */       
/* 109 */       List<Long> allKeys = new ArrayList(2);
/* 110 */       allKeys.add(Long.valueOf(mainK));
/* 111 */       allKeys.add(Long.valueOf(viceK));
/* 112 */       lock(Ocpbossrank.getTable(), allKeys);
/*     */       
/* 114 */       OcpBigBossRoleList xMainBossRank = Ocpbossrank.get(Long.valueOf(mainK));
/* 115 */       OcpBigBossRoleList xViceBossRank = Ocpbossrank.get(Long.valueOf(viceK));
/* 116 */       if ((xMainBossRank == null) || (xViceBossRank == null))
/*     */       {
/* 118 */         if (xViceBossRank != null)
/*     */         {
/* 120 */           xMainBossRank = Pod.newOcpBigBossRoleList();
/* 121 */           Ocpbossrank.insert(Long.valueOf(mainK), xMainBossRank);
/*     */           
/* 123 */           for (int i = 0; i < xViceBossRank.getRolelist().size(); i++)
/*     */           {
/* 125 */             RoleBossBean xRoleBossBean = Pod.newRoleBossBean();
/* 126 */             xRoleBossBean.setRoleid(((RoleBossBean)xViceBossRank.getRolelist().get(i)).getRoleid());
/* 127 */             xMainBossRank.getRolelist().add(xRoleBossBean);
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
/* 139 */         List<Long> roleList = new ArrayList(xMainBossRank.getRolelist().size() + xViceBossRank.getRolelist().size());
/*     */         
/* 141 */         for (RoleBossBean xBossBean : xMainBossRank.getRolelist())
/*     */         {
/* 143 */           roleList.add(Long.valueOf(xBossBean.getRoleid()));
/*     */         }
/* 145 */         for (RoleBossBean xBossBean : xViceBossRank.getRolelist())
/*     */         {
/* 147 */           roleList.add(Long.valueOf(xBossBean.getRoleid()));
/*     */         }
/*     */         
/* 150 */         lock(Role2bigboss.getTable(), roleList);
/* 151 */         List<BigbossMerger.RoleBigbossPoint> list = new ArrayList();
/* 152 */         for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 154 */           int point = BigbossManager.getDamagePoint(roleid, mzm.gsp.role.main.RoleInterface.getOccupationId(roleid));
/* 155 */           BigbossMerger.RoleBigbossPoint roleBigbossPoint = new BigbossMerger.RoleBigbossPoint(roleid, point);
/* 156 */           list.add(roleBigbossPoint);
/*     */         }
/*     */         
/* 159 */         java.util.Collections.sort(list);
/*     */         
/* 161 */         int size = xMainBossRank.getRolelist().size();
/* 162 */         xMainBossRank.getRolelist().clear();
/*     */         
/* 164 */         SChartSubTypeCfg sChartSubTypeCfg = mzm.gsp.chart.main.ChartCfgManager.getChartSubTypeCfg(this.charttype);
/* 165 */         if (sChartSubTypeCfg != null)
/*     */         {
/* 167 */           size = sChartSubTypeCfg.capacity;
/*     */         }
/* 169 */         for (int i = 0; i < Math.min(size, list.size()); i++)
/*     */         {
/* 171 */           RoleBossBean xRoleBossBean = Pod.newRoleBossBean();
/* 172 */           xRoleBossBean.setRoleid(((BigbossMerger.RoleBigbossPoint)list.get(i)).getRoleId());
/* 173 */           xMainBossRank.getRolelist().add(xRoleBossBean);
/*     */         }
/*     */       }
/*     */       
/* 177 */       Ocpbossrank.remove(Long.valueOf(viceK));
/*     */       
/* 179 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RoleBigbossPoint implements Comparable<RoleBigbossPoint>
/*     */   {
/*     */     private final long roleId;
/*     */     private final int point;
/*     */     
/*     */     public RoleBigbossPoint(long roleId, int point)
/*     */     {
/* 190 */       this.roleId = roleId;
/* 191 */       this.point = point;
/*     */     }
/*     */     
/*     */ 
/*     */     public int compareTo(RoleBigbossPoint o)
/*     */     {
/* 197 */       return o.getPoint() - this.point;
/*     */     }
/*     */     
/*     */     public long getRoleId()
/*     */     {
/* 202 */       return this.roleId;
/*     */     }
/*     */     
/*     */     public int getPoint()
/*     */     {
/* 207 */       return this.point;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BigbossMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */