/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.chart.main.RankManagerNew;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleLevelChart;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleLevelBean;
/*     */ import xbean.RoleLevelRank;
/*     */ import xtable.Rolelevelrank;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MergeRoleLevel
/*     */   extends LogicProcedure
/*     */ {
/*  22 */   private static final Logger logger = Logger.getLogger(MergeRoleLevel.class);
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     long mainKey = MergeMain.getMainZoneid();
/*  28 */     long viceKey = MergeMain.getViceZoneid();
/*     */     
/*  30 */     lock(Rolelevelrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */     
/*  32 */     RoleLevelRank xViceRoleLv = Rolelevelrank.get(Long.valueOf(viceKey));
/*  33 */     if (xViceRoleLv == null)
/*     */     {
/*  35 */       logger.warn(String.format("[roleLvRank]MergeRoleLevel.processImp@ no vice level xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  37 */       return true;
/*     */     }
/*  39 */     RoleLevelRank xMainRoleLv = Rolelevelrank.get(Long.valueOf(mainKey));
/*  40 */     if (xMainRoleLv == null)
/*     */     {
/*  42 */       xMainRoleLv = Pod.newRoleLevelRank();
/*  43 */       Rolelevelrank.insert(Long.valueOf(mainKey), xMainRoleLv);
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
/*  56 */       RoleLevelBean xRoleLv = Pod.newRoleLevelBean();
/*  57 */       xRoleLv.setRoleid(rankObj.getRoleid());
/*  58 */       xMainRoleLv.getRankdatas().add(xRoleLv);
/*     */     }
/*     */     
/*  61 */     mergeRank.clear();
/*     */     
/*  63 */     Rolelevelrank.remove(Long.valueOf(viceKey));
/*  64 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addRoleLVData(List<RoleLevelBean> xRoleLVDatas, RoleLevelRankManagerForMerge mergeRank)
/*     */   {
/*  75 */     if ((xRoleLVDatas == null) || (xRoleLVDatas.size() == 0))
/*     */     {
/*  77 */       return;
/*     */     }
/*  79 */     for (RoleLevelBean xRoleLv : xRoleLVDatas)
/*     */     {
/*  81 */       long roleId = xRoleLv.getRoleid();
/*  82 */       int roleLv = RoleInterface.getLevel(roleId);
/*  83 */       long lvTime = RoleInterface.getLevelUpCurTime(roleId);
/*  84 */       RoleLevelChart rankObj = new RoleLevelChart(roleId, roleLv, lvTime);
/*  85 */       mergeRank.rank(rankObj);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   class RoleLevelRankManagerForMerge
/*     */     extends RankManagerNew<Long, RoleLevelChart>
/*     */   {
/*     */     public RoleLevelRankManagerForMerge(int capacity, int extraSize)
/*     */     {
/* 100 */       super(extraSize);
/*     */     }
/*     */     
/*     */     public void saveToDB() {}
/*     */     
/*     */     public void rankDataFromDB() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeRoleLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */