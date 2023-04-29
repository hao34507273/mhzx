/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.chart.main.RankManagerNew;
/*     */ import mzm.gsp.role.main.RoleLevelChart;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NoneRealRoleLevelBean;
/*     */ import xbean.NoneRealTimeRoleLevelRank;
/*     */ import xbean.Pod;
/*     */ import xtable.Nonerealtimerolelevelrank;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MergeRoleNTLevel
/*     */   extends LogicProcedure
/*     */ {
/*  22 */   private static final Logger logger = Logger.getLogger(MergeRoleNTLevel.class);
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     long mainKey = MergeMain.getMainZoneid();
/*  28 */     long viceKey = MergeMain.getViceZoneid();
/*     */     
/*  30 */     lock(Nonerealtimerolelevelrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */     
/*  32 */     NoneRealTimeRoleLevelRank xViceRoleLv = Nonerealtimerolelevelrank.get(Long.valueOf(viceKey));
/*  33 */     if (xViceRoleLv == null)
/*     */     {
/*  35 */       logger.warn(String.format("[mfv]MergeRoleNTLevel.processImp@ no vice NT roleLv xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  37 */       return true;
/*     */     }
/*  39 */     NoneRealTimeRoleLevelRank xMainRoleLv = Nonerealtimerolelevelrank.get(Long.valueOf(mainKey));
/*  40 */     if (xMainRoleLv == null)
/*     */     {
/*  42 */       xMainRoleLv = Pod.newNoneRealTimeRoleLevelRank();
/*  43 */       Nonerealtimerolelevelrank.insert(Long.valueOf(mainKey), xMainRoleLv);
/*     */     }
/*     */     
/*  46 */     RoleLevelRankManagerForMerge mergeRank = new RoleLevelRankManagerForMerge(Integer.MAX_VALUE, 0);
/*     */     
/*  48 */     addRoleLVData(xMainRoleLv.getRankdatas(), mergeRank);
/*     */     
/*  50 */     addRoleLVData(xViceRoleLv.getRankdatas(), mergeRank);
/*     */     
/*  52 */     xMainRoleLv.getRankdatas().clear();
/*     */     
/*  54 */     for (RoleLevelChart rankObj : mergeRank.getAllChartObjs())
/*     */     {
/*  56 */       NoneRealRoleLevelBean xRoleLv = Pod.newNoneRealRoleLevelBean();
/*  57 */       xRoleLv.setRoleid(rankObj.getRoleid());
/*  58 */       xRoleLv.setLvuptime(rankObj.getLvupTime());
/*  59 */       xRoleLv.setLevel(rankObj.getLevel());
/*  60 */       xMainRoleLv.getRankdatas().add(xRoleLv);
/*     */     }
/*     */     
/*  63 */     xMainRoleLv.getKeytorankchange().putAll(xViceRoleLv.getKeytorankchange());
/*     */     
/*  65 */     mergeRank.clear();
/*     */     
/*  67 */     Nonerealtimerolelevelrank.remove(Long.valueOf(viceKey));
/*  68 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addRoleLVData(List<NoneRealRoleLevelBean> xRoleLVDatas, RoleLevelRankManagerForMerge mergeRank)
/*     */   {
/*  79 */     if ((xRoleLVDatas == null) || (xRoleLVDatas.size() == 0))
/*     */     {
/*  81 */       return;
/*     */     }
/*  83 */     for (NoneRealRoleLevelBean xRoleLv : xRoleLVDatas)
/*     */     {
/*  85 */       long roleId = xRoleLv.getRoleid();
/*  86 */       int roleLv = xRoleLv.getLevel();
/*  87 */       long lvTime = xRoleLv.getLvuptime();
/*  88 */       RoleLevelChart rankObj = new RoleLevelChart(roleId, roleLv, lvTime);
/*  89 */       mergeRank.rank(rankObj);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class RoleLevelRankManagerForMerge
/*     */     extends RankManagerNew<Long, RoleLevelChart>
/*     */   {
/*     */     public RoleLevelRankManagerForMerge(int capacity, int extraSize)
/*     */     {
/* 104 */       super(extraSize);
/*     */     }
/*     */     
/*     */     public void saveToDB() {}
/*     */     
/*     */     public void rankDataFromDB() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeRoleNTLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */