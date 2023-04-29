/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import xbean.MultiFightValueRank;
/*     */ import xbean.OccMFVRankData;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMultiFightValueBean;
/*     */ import xtable.Occmfvrank;
/*     */ 
/*     */ public abstract class AbsOMFVRankManager extends RoleKeyRankManagerNew<RoleMultiFightValueChart>
/*     */ {
/*     */   public AbsOMFVRankManager(int chartType)
/*     */   {
/*  16 */     super(chartType);
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  22 */     java.util.List<RoleMultiFightValueChart> allObjs = getAllChartObjs();
/*  23 */     OccMFVRankData xOccMfvRank = Occmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  24 */     if (xOccMfvRank == null)
/*     */     {
/*  26 */       xOccMfvRank = Pod.newOccMFVRankData();
/*  27 */       Occmfvrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xOccMfvRank);
/*     */     }
/*  29 */     xOccMfvRank.getOcc2rankdata().remove(Integer.valueOf(getOccId()));
/*  30 */     for (RoleMultiFightValueChart roleMultiFightValueChart : allObjs)
/*     */     {
/*  32 */       RoleMultiFightValueBean xMFVBean = Pod.newRoleMultiFightValueBean();
/*  33 */       xMFVBean.setRoleid(roleMultiFightValueChart.getKey().longValue());
/*  34 */       MultiFightValueRank xMFVData = (MultiFightValueRank)xOccMfvRank.getOcc2rankdata().get(Integer.valueOf(getOccId()));
/*  35 */       if (xMFVData == null)
/*     */       {
/*  37 */         xMFVData = Pod.newMultiFightValueRank();
/*  38 */         xOccMfvRank.getOcc2rankdata().put(Integer.valueOf(getOccId()), xMFVData);
/*     */       }
/*  40 */       xMFVData.getRolerankdatas().add(xMFVBean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  47 */     OccMFVRankData xOccMfvRank = Occmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  48 */     if (xOccMfvRank == null)
/*     */     {
/*  50 */       return;
/*     */     }
/*  52 */     MultiFightValueRank xOMFVRank = (MultiFightValueRank)xOccMfvRank.getOcc2rankdata().get(Integer.valueOf(getOccId()));
/*  53 */     if (xOMFVRank == null)
/*     */     {
/*  55 */       return;
/*     */     }
/*  57 */     for (RoleMultiFightValueBean xMFVBean : xOMFVRank.getRolerankdatas())
/*     */     {
/*  59 */       long roleId = xMFVBean.getRoleid();
/*  60 */       if (!MultiRankManager.canBeRanked(roleId, getOccId()))
/*     */       {
/*  62 */         mzm.gsp.GameServer.logger().info(String.format("[occmfv]AbsOMFVRankManager.rankDataFromDB@ can not ranked!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       }
/*     */       else
/*     */       {
/*  66 */         int mfv = MultiRankManager.getRoleMFValue(roleId);
/*  67 */         RoleMultiFightValueChart roleMFVChart = new RoleMultiFightValueChart(roleId, mfv, getOccId());
/*  68 */         rank(roleMFVChart);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/*  77 */     int mfv = MultiRankManager.getRoleMFValue(roleid);
/*  78 */     int occupationId = mzm.gsp.role.main.RoleInterface.getOccupationId(roleid);
/*  79 */     rank(new RoleMultiFightValueChart(roleid, mfv, occupationId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract int getOccChartType();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract int getOccId();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AbsOMFVRankManager getAbsOMFVRankManagerByOccId(int occupationId)
/*     */   {
/* 111 */     switch (occupationId)
/*     */     {
/*     */     case 1: 
/* 114 */       return GuiWangMFVManager.getInstance();
/*     */     case 2: 
/* 116 */       return QingYunMFVManager.getInstance();
/*     */     case 3: 
/* 118 */       return TianYinMFVManager.getInstance();
/*     */     case 4: 
/* 120 */       return FenXiangMFVManager.getInstance();
/*     */     case 5: 
/* 122 */       return HeHuanMFVManager.getInstance();
/*     */     case 6: 
/* 124 */       return ShengWuMFVManager.getInstance();
/*     */     case 7: 
/* 126 */       return CangYuMFVManager.getInstance();
/*     */     case 8: 
/* 128 */       return LingYinMFVManager.getInstance();
/*     */     case 9: 
/* 130 */       return YiNengMFVManager.getInstance();
/*     */     }
/*     */     
/* 133 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static AbsOMFVRankManager getAbsOMFVRankManagerByChartType(int chartType)
/*     */   {
/* 146 */     switch (chartType)
/*     */     {
/*     */     }
/* 149 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\AbsOMFVRankManager1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */