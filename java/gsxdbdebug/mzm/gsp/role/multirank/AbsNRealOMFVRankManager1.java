/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.NoneRealTimeRoleKeyRankManagerNew;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NoneRealRoleMultiFightValueBean;
/*     */ import xbean.NoneRealTimeMultiFightValueRank;
/*     */ import xbean.NoneRealTimeOccMFVRankData;
/*     */ import xbean.NoneRealTimeOccMFVRankDataBackUp;
/*     */ import xbean.NoneRealTimeOccMFVRoleRankBackUp;
/*     */ import xbean.Pod;
/*     */ import xtable.Nonerealtimeoccmfvrank;
/*     */ import xtable.Nonerealtimeoccmfvrankbackup;
/*     */ 
/*     */ public abstract class AbsNRealOMFVRankManager extends NoneRealTimeRoleKeyRankManagerNew<RoleMultiFightValueChart> implements mzm.gsp.chart.main.RankAwardHandler
/*     */ {
/*     */   public AbsNRealOMFVRankManager(int chartType, AbsOMFVRankManager rankManagerNew)
/*     */   {
/*  27 */     super(chartType, rankManagerNew);
/*  28 */     RankInterface.registerRankAwardHandle(chartType, this);
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  34 */     setNewRankXData(getXRankDataIfAbsence());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private NoneRealTimeMultiFightValueRank getXRankDataIfAbsence()
/*     */   {
/*  46 */     NoneRealTimeOccMFVRankData xNOMFVData = Nonerealtimeoccmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  47 */     if (xNOMFVData == null)
/*     */     {
/*  49 */       xNOMFVData = Pod.newNoneRealTimeOccMFVRankData();
/*  50 */       Nonerealtimeoccmfvrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xNOMFVData);
/*     */     }
/*     */     
/*  53 */     NoneRealTimeMultiFightValueRank xNMFVRank = (NoneRealTimeMultiFightValueRank)xNOMFVData.getOcc2rankdata().get(Integer.valueOf(getOccId()));
/*  54 */     if (xNMFVRank == null)
/*     */     {
/*  56 */       xNMFVRank = Pod.newNoneRealTimeMultiFightValueRank();
/*  57 */       xNMFVRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*  58 */       xNOMFVData.getOcc2rankdata().put(Integer.valueOf(getOccId()), xNMFVRank);
/*     */     }
/*  60 */     return xNMFVRank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setNewRankXData(NoneRealTimeMultiFightValueRank xNMFVRank)
/*     */   {
/*  70 */     if (xNMFVRank == null)
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[MFV]AbsNRealOMFVRankManager.setNewRankXData@ xNMFVRank is null!|occId=%d", new Object[] { Integer.valueOf(getOccId()) }));
/*     */       
/*  74 */       return;
/*     */     }
/*     */     
/*  77 */     xNMFVRank.getRankdatas().clear();
/*  78 */     xNMFVRank.getKeytorankchange().clear();
/*     */     
/*  80 */     xNMFVRank.setSavetime(getSaveDbTime());
/*     */     
/*  82 */     for (RoleMultiFightValueChart roleMFVChart : getCacheRankDatas())
/*     */     {
/*  84 */       NoneRealRoleMultiFightValueBean roleMFVBean = Pod.newNoneRealRoleMultiFightValueBean();
/*  85 */       roleMFVBean.setMultifightvalue(roleMFVChart.getFightValue());
/*  86 */       roleMFVBean.setRoleid(roleMFVChart.getKey().longValue());
/*  87 */       xNMFVRank.getRankdatas().add(roleMFVBean);
/*     */     }
/*     */     
/*  90 */     xNMFVRank.getKeytorankchange().putAll(getCacheRankChangeMap());
/*     */   }
/*     */   
/*     */ 
/*     */   public void initCachDataFromDb()
/*     */   {
/*  96 */     initCacheRankData(getXRankData());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private NoneRealTimeMultiFightValueRank getXRankData()
/*     */   {
/* 106 */     NoneRealTimeOccMFVRankData xNOMFVData = Nonerealtimeoccmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 107 */     if (xNOMFVData == null)
/*     */     {
/* 109 */       GameServer.logger().warn(String.format("[MFV]AbsNRealOMFVRankManager.getXRankData@ xNOMFVData is null!", new Object[0]));
/* 110 */       return null;
/*     */     }
/* 112 */     NoneRealTimeMultiFightValueRank xNMFVRank = (NoneRealTimeMultiFightValueRank)xNOMFVData.getOcc2rankdata().get(Integer.valueOf(getOccId()));
/* 113 */     if (xNMFVRank == null)
/*     */     {
/* 115 */       GameServer.logger().warn(String.format("[MFV]AbsNRealOMFVRankManager.getXRankData@ xNMFVRank is null!|occId=%d", new Object[] { Integer.valueOf(getOccId()) }));
/*     */       
/* 117 */       return null;
/*     */     }
/* 119 */     return xNMFVRank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initCacheRankData(NoneRealTimeMultiFightValueRank xNMFVRank)
/*     */   {
/* 129 */     if (xNMFVRank == null)
/*     */     {
/* 131 */       return;
/*     */     }
/*     */     
/* 134 */     _initSaveDbTime(xNMFVRank.getSavetime());
/*     */     
/* 136 */     List<RoleMultiFightValueChart> roleMFVCharts = new ArrayList();
/* 137 */     for (NoneRealRoleMultiFightValueBean roleFightValueBean : xNMFVRank.getRankdatas())
/*     */     {
/* 139 */       long roleId = roleFightValueBean.getRoleid();
/* 140 */       if (!MultiRankManager.canBeRanked(roleId, getOccId()))
/*     */       {
/*     */ 
/* 143 */         GameServer.logger().info(String.format("[occmfv]AbsNRealOMFVRankManager.initCacheRankData@ can not be ranked!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       }
/*     */       else
/*     */       {
/* 147 */         int mfv = roleFightValueBean.getMultifightvalue();
/* 148 */         RoleMultiFightValueChart roleMFVChart = new RoleMultiFightValueChart(roleId, mfv, getOccId());
/* 149 */         roleMFVCharts.add(roleMFVChart);
/*     */       } }
/* 151 */     _initCacheRankDatas(roleMFVCharts);
/*     */     
/* 153 */     _initCacheRankChangeMap(xNMFVRank.getKeytorankchange());
/*     */     
/* 155 */     checkAward(xNMFVRank);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 161 */     int mfv = MultiRankManager.getRoleMFValue(roleid);
/* 162 */     int occupationId = RoleInterface.getOccupationId(roleid);
/* 163 */     rank(new RoleMultiFightValueChart(roleid, mfv, occupationId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void doAward()
/*     */   {
/* 175 */     NoneRealTimeOccMFVRankData xNMFVRank = Nonerealtimeoccmfvrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 176 */     if (xNMFVRank == null)
/*     */     {
/* 178 */       return;
/*     */     }
/* 180 */     int occid = getOccId();
/* 181 */     NoneRealTimeMultiFightValueRank xNoneRealTimeMultiFightValueRank = (NoneRealTimeMultiFightValueRank)xNMFVRank.getOcc2rankdata().get(Integer.valueOf(occid));
/* 182 */     if (xNoneRealTimeMultiFightValueRank == null)
/*     */     {
/* 184 */       return;
/*     */     }
/* 186 */     checkAward(xNoneRealTimeMultiFightValueRank);
/*     */   }
/*     */   
/*     */ 
/*     */   private void checkAward(NoneRealTimeMultiFightValueRank xNMFVRank)
/*     */   {
/* 192 */     long awrdTime = xNMFVRank.getAwardtime();
/* 193 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 194 */     if (awrdTime <= 0L)
/*     */     {
/*     */ 
/* 197 */       xNMFVRank.setAwardtime(now);
/* 198 */       return;
/*     */     }
/*     */     
/* 201 */     int chartType = getOccChartType();
/*     */     
/*     */ 
/* 204 */     if (!isSendAward())
/*     */     {
/* 206 */       GameServer.logger().error(String.format("[Role]AbsNRealOMFVRankManager.checkAward@can not award|chart_type=%d", new Object[] { Integer.valueOf(chartType) }));
/*     */       
/* 208 */       return;
/*     */     }
/* 210 */     if (RankInterface.isInSameAwardTime(awrdTime, chartType))
/*     */     {
/* 212 */       return;
/*     */     }
/*     */     
/*     */ 
/* 216 */     int rank = RankInterface.getAwardRank(chartType) + 1;
/* 217 */     int size = Math.min(rank, xNMFVRank.getRankdatas().size());
/* 218 */     NoneRealTimeOccMFVRoleRankBackUp xNoneRealTimeOccMFVRoleRankBackUp = initAndClear(chartType);
/* 219 */     for (int i = 0; i < size; i++)
/*     */     {
/* 221 */       NoneRealRoleMultiFightValueBean xNoneRealRoleMultiFightBean = (NoneRealRoleMultiFightValueBean)xNMFVRank.getRankdatas().get(i);
/* 222 */       long roleid = xNoneRealRoleMultiFightBean.getRoleid();
/* 223 */       NoneRealTimeTaskManager.getInstance().addTask(new AbsNRealOMFVRankManager.PAwardProcedure(roleid, i, chartType));
/*     */       
/*     */ 
/* 226 */       backup(xNoneRealTimeOccMFVRoleRankBackUp, xNoneRealRoleMultiFightBean);
/*     */       
/* 228 */       GameServer.logger().info(String.format("[Role]AbsNRealOMFVRankManager.checkAward@do award rank|chart_type=%d|rank=%d|roleid=%d", new Object[] { Integer.valueOf(chartType), Integer.valueOf(rank), Long.valueOf(roleid) }));
/*     */     }
/*     */     
/*     */ 
/* 232 */     xNMFVRank.setAwardtime(now);
/* 233 */     GameServer.logger().info(String.format("[Role]AbsNRealOMFVRankManager.checkAward@do award rank|rank=%d|chart_type=%d", new Object[] { Integer.valueOf(rank), Integer.valueOf(chartType) }));
/*     */   }
/*     */   
/*     */ 
/*     */   private NoneRealTimeOccMFVRoleRankBackUp initAndClear(int chartType)
/*     */   {
/* 239 */     long localid = GameServerInfoManager.getLocalId();
/* 240 */     NoneRealTimeOccMFVRankDataBackUp xNRTOccMFVBackUp = Nonerealtimeoccmfvrankbackup.get(Long.valueOf(localid));
/* 241 */     if (xNRTOccMFVBackUp == null)
/*     */     {
/* 243 */       xNRTOccMFVBackUp = Pod.newNoneRealTimeOccMFVRankDataBackUp();
/* 244 */       Nonerealtimeoccmfvrankbackup.insert(Long.valueOf(localid), xNRTOccMFVBackUp);
/*     */     }
/* 246 */     NoneRealTimeOccMFVRoleRankBackUp xNoneRealTimeOccMFVRoleRankBackUp = (NoneRealTimeOccMFVRoleRankBackUp)xNRTOccMFVBackUp.getRank_datas().get(Integer.valueOf(chartType));
/*     */     
/* 248 */     if (xNoneRealTimeOccMFVRoleRankBackUp == null)
/*     */     {
/* 250 */       xNoneRealTimeOccMFVRoleRankBackUp = Pod.newNoneRealTimeOccMFVRoleRankBackUp();
/* 251 */       xNRTOccMFVBackUp.getRank_datas().put(Integer.valueOf(chartType), xNoneRealTimeOccMFVRoleRankBackUp);
/*     */     }
/* 253 */     xNoneRealTimeOccMFVRoleRankBackUp.getRole_datas().clear();
/* 254 */     return xNoneRealTimeOccMFVRoleRankBackUp;
/*     */   }
/*     */   
/*     */ 
/*     */   private void backup(NoneRealTimeOccMFVRoleRankBackUp xNoneRealTimeOccMFVRoleRankBackUp, NoneRealRoleMultiFightValueBean xNoneRealRoleMultiFightValueBean)
/*     */   {
/* 260 */     if (xNoneRealRoleMultiFightValueBean == null)
/*     */     {
/* 262 */       return;
/*     */     }
/* 264 */     NoneRealRoleMultiFightValueBean xNRTRoleMFVBeanBackUp = Pod.newNoneRealRoleMultiFightValueBean();
/* 265 */     xNRTRoleMFVBeanBackUp.setRoleid(xNoneRealRoleMultiFightValueBean.getRoleid());
/* 266 */     xNRTRoleMFVBeanBackUp.setMultifightvalue(xNoneRealRoleMultiFightValueBean.getMultifightvalue());
/*     */     
/* 268 */     xNoneRealTimeOccMFVRoleRankBackUp.getRole_datas().add(xNRTRoleMFVBeanBackUp);
/*     */   }
/*     */   
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
/*     */ 
/*     */   abstract int getOccId();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract boolean isSendAward();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static AbsNRealOMFVRankManager getNOMFVRankManagerByOccId(int occupationId)
/*     */   {
/* 302 */     switch (occupationId)
/*     */     {
/*     */     case 1: 
/* 305 */       return GuiWangNRealMFVManager.getInstance();
/*     */     case 2: 
/* 307 */       return QingYunNRealMFVManager.getInstance();
/*     */     case 3: 
/* 309 */       return TianYinNRealMFVManager.getInstance();
/*     */     case 4: 
/* 311 */       return FenXiangNRealMFVManager.getInstance();
/*     */     case 5: 
/* 313 */       return HeHuanNRealMFVManager.getInstance();
/*     */     case 6: 
/* 315 */       return ShengWuNRealMFVManager.getInstance();
/*     */     case 7: 
/* 317 */       return CangYuNRealMFVManager.getInstance();
/*     */     case 8: 
/* 319 */       return LingYinNRealMFVManager.getInstance();
/*     */     case 9: 
/* 321 */       return YiNengNRealMFVManager.getInstance();
/*     */     }
/*     */     
/* 324 */     return null;
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
/*     */ 
/*     */   public static int getOccRank(long roleId)
/*     */   {
/* 338 */     int roleOccId = RoleInterface.getOccupationId(roleId);
/* 339 */     AbsNRealOMFVRankManager roleRankManager = getNOMFVRankManagerByOccId(roleOccId);
/* 340 */     if (roleRankManager == null)
/*     */     {
/* 342 */       GameServer.logger().error(String.format("[MFV]AbsNRealOMFVRankManager.getOccRank@ no role rankManager!|occupationId=%d", new Object[] { Integer.valueOf(roleOccId) }));
/*     */       
/* 344 */       return 0;
/*     */     }
/* 346 */     return roleRankManager.getRank(Long.valueOf(roleId)) + 1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Long> getTopNRoleIds(int occupationId, int size, int gender)
/*     */   {
/* 362 */     if (size <= 0)
/*     */     {
/* 364 */       return java.util.Collections.emptyList();
/*     */     }
/* 366 */     AbsNRealOMFVRankManager noneRealRankManager = getNOMFVRankManagerByOccId(occupationId);
/* 367 */     if (noneRealRankManager == null)
/*     */     {
/* 369 */       return java.util.Collections.emptyList();
/*     */     }
/* 371 */     List<Long> roleIds = new ArrayList();
/* 372 */     for (RoleMultiFightValueChart roleMFVChart : noneRealRankManager.getCacheRankDatas())
/*     */     {
/* 374 */       long roleId = roleMFVChart.getRoleid();
/* 375 */       if ((gender == 0) || (RoleInterface.getGender(roleId) == gender))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 380 */         roleIds.add(Long.valueOf(roleId));
/* 381 */         if (roleIds.size() >= size) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 387 */     return roleIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static AbsNRealOMFVRankManager getNOMFVRankManagerByChartType(int chartType)
/*     */   {
/* 399 */     switch (chartType)
/*     */     {
/*     */     }
/* 402 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\AbsNRealOMFVRankManager1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */