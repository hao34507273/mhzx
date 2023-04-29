/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import xbean.BigBoss;
/*     */ import xbean.OcpBigBossRoleList;
/*     */ import xbean.RoleBossBean;
/*     */ import xtable.Ocpbossrank;
/*     */ 
/*     */ public class BigBossRankManager extends mzm.gsp.chart.main.RoleKeyRankManagerNew<RoleBigBossChart>
/*     */ {
/*     */   private final int ocp;
/*     */   
/*     */   BigBossRankManager(int chartType, int ocp)
/*     */   {
/*  16 */     super(chartType);
/*  17 */     this.ocp = ocp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  24 */     List<RoleBigBossChart> bigBossCharts = getAllChartObjs();
/*  25 */     long key = GameServerInfoManager.toGlobalId(this.ocp);
/*     */     
/*  27 */     OcpBigBossRoleList xOcpBigBossRoleList = Ocpbossrank.get(Long.valueOf(key));
/*  28 */     if (xOcpBigBossRoleList == null)
/*     */     {
/*  30 */       xOcpBigBossRoleList = xbean.Pod.newOcpBigBossRoleList();
/*  31 */       Ocpbossrank.insert(Long.valueOf(key), xOcpBigBossRoleList);
/*     */     }
/*  33 */     xOcpBigBossRoleList.getRolelist().clear();
/*  34 */     for (RoleBigBossChart roleBigBossChart : bigBossCharts)
/*     */     {
/*  36 */       RoleBossBean roleBossBean = xbean.Pod.newRoleBossBean();
/*  37 */       roleBossBean.setRoleid(roleBigBossChart.getKey().longValue());
/*  38 */       xOcpBigBossRoleList.getRolelist().add(roleBossBean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  45 */     long key = GameServerInfoManager.toGlobalId(this.ocp);
/*  46 */     OcpBigBossRoleList xOcpBigBossRoleList = Ocpbossrank.get(Long.valueOf(key));
/*  47 */     if (xOcpBigBossRoleList != null)
/*     */     {
/*  49 */       for (RoleBossBean roleBossBean : xOcpBigBossRoleList.getRolelist())
/*     */       {
/*  51 */         long roleid = roleBossBean.getRoleid();
/*     */         
/*  53 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleid))
/*     */         {
/*  55 */           BigbossManager.logger.info(String.format("[bigboss]BigbossRankManager.rankDataFromDB@role is deleted|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  60 */           RoleBigBossChart roleBigBossChart = new RoleBigBossChart(roleid, BigbossManager.getDamagePoint(roleid, this.ocp));
/*     */           
/*  62 */           rank(roleBigBossChart);
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
/*  73 */     long key = GameServerInfoManager.toGlobalId(this.ocp);
/*  74 */     OcpBigBossRoleList xOcpBigBossRoleList = Ocpbossrank.get(Long.valueOf(key));
/*  75 */     if (xOcpBigBossRoleList != null)
/*     */     {
/*  77 */       xOcpBigBossRoleList.getRolelist().clear();
/*     */     }
/*  79 */     super.clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/*  85 */     BigBoss xBigBoss = BigbossManager.getBigboss(roleid, false);
/*  86 */     if (xBigBoss == null)
/*     */     {
/*  88 */       return;
/*     */     }
/*  90 */     Integer value = (Integer)xBigBoss.getOcp2damagepoint().get(Integer.valueOf(this.ocp));
/*  91 */     if (value == null)
/*     */     {
/*  93 */       return;
/*     */     }
/*  95 */     long startTimestamp = BigbossManager.getActivityStarttime();
/*  96 */     if (startTimestamp <= 0L)
/*     */     {
/*  98 */       return;
/*     */     }
/* 100 */     if (xBigBoss.getStarttime() != startTimestamp)
/*     */     {
/* 102 */       return;
/*     */     }
/* 104 */     rank(new RoleBigBossChart(roleid, value.intValue()));
/* 105 */     BigbossManager.reportRoleBigBossRankInfo(mzm.gsp.util.CommonUtils.getLong(this.ocp, (int)(startTimestamp / 1000L)), roleid, mzm.gsp.role.main.RoleInterface.getName(roleid), this.ocp, value.intValue(), 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/* 112 */     long startTimestamp = BigbossManager.getActivityStarttime();
/* 113 */     if (startTimestamp <= 0L)
/*     */     {
/* 115 */       return;
/*     */     }
/* 117 */     BigbossManager.setDamagePoint(roleid, this.ocp, 0);
/* 118 */     delete(Long.valueOf(roleid));
/* 119 */     BigbossManager.removeRoleBigBossRankInfo(mzm.gsp.util.CommonUtils.getLong(this.ocp, (int)(startTimestamp / 1000L)), roleid, 1);
/*     */   }
/*     */   
/*     */   public int getOcp()
/*     */   {
/* 124 */     return this.ocp;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BigBossRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */