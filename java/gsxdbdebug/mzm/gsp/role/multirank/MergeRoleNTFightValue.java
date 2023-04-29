/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.chart.main.RankManagerNew;
/*     */ import mzm.gsp.role.main.RoleFightValueChart;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NoneRealRoleFightValueBean;
/*     */ import xbean.NoneRealTimeFightValueRank;
/*     */ import xbean.Pod;
/*     */ import xtable.Nonerealtimefightvaluerank;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MergeRoleNTFightValue
/*     */   extends LogicProcedure
/*     */ {
/*  21 */   private static final Logger logger = Logger.getLogger(MergeRoleNTFightValue.class);
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  26 */     long mainKey = MergeMain.getMainZoneid();
/*  27 */     long viceKey = MergeMain.getViceZoneid();
/*     */     
/*  29 */     lock(Nonerealtimefightvaluerank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */     
/*  31 */     NoneRealTimeFightValueRank xViceRoleFightValue = Nonerealtimefightvaluerank.get(Long.valueOf(viceKey));
/*  32 */     if (xViceRoleFightValue == null)
/*     */     {
/*  34 */       logger.warn(String.format("[mfv]MergeRoleNTFightValue.processImp@ no vice NT role fight value xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*     */ 
/*  37 */       return true;
/*     */     }
/*  39 */     NoneRealTimeFightValueRank xMainRoleNtFightValue = Nonerealtimefightvaluerank.get(Long.valueOf(mainKey));
/*  40 */     if (xMainRoleNtFightValue == null)
/*     */     {
/*  42 */       xMainRoleNtFightValue = Pod.newNoneRealTimeFightValueRank();
/*  43 */       Nonerealtimefightvaluerank.insert(Long.valueOf(mainKey), xMainRoleNtFightValue);
/*     */     }
/*     */     
/*  46 */     RoleFightRankManagerForMerge mergeRank = new RoleFightRankManagerForMerge(Integer.MAX_VALUE, 0);
/*     */     
/*  48 */     addRoleLVData(xMainRoleNtFightValue.getRankdatas(), mergeRank);
/*     */     
/*  50 */     addRoleLVData(xViceRoleFightValue.getRankdatas(), mergeRank);
/*     */     
/*  52 */     xMainRoleNtFightValue.getRankdatas().clear();
/*     */     
/*  54 */     for (RoleFightValueChart rankObj : mergeRank.getAllChartObjs())
/*     */     {
/*  56 */       NoneRealRoleFightValueBean xRoleFight = Pod.newNoneRealRoleFightValueBean();
/*  57 */       xRoleFight.setRoleid(rankObj.getRoleid());
/*  58 */       xRoleFight.setFightvalue(rankObj.getFightValue());
/*  59 */       xMainRoleNtFightValue.getRankdatas().add(xRoleFight);
/*     */     }
/*     */     
/*  62 */     xMainRoleNtFightValue.getKeytorankchange().putAll(xViceRoleFightValue.getKeytorankchange());
/*     */     
/*  64 */     mergeRank.clear();
/*     */     
/*  66 */     Nonerealtimefightvaluerank.remove(Long.valueOf(viceKey));
/*  67 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addRoleLVData(List<NoneRealRoleFightValueBean> xRoleFightDatas, RoleFightRankManagerForMerge mergeRank)
/*     */   {
/*  78 */     if ((xRoleFightDatas == null) || (xRoleFightDatas.size() == 0))
/*     */     {
/*  80 */       return;
/*     */     }
/*  82 */     for (NoneRealRoleFightValueBean xRoleFight : xRoleFightDatas)
/*     */     {
/*  84 */       long roleId = xRoleFight.getRoleid();
/*  85 */       int fightValue = xRoleFight.getFightvalue();
/*  86 */       RoleFightValueChart rankObj = new RoleFightValueChart(roleId, fightValue);
/*  87 */       mergeRank.rank(rankObj);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class RoleFightRankManagerForMerge
/*     */     extends RankManagerNew<Long, RoleFightValueChart>
/*     */   {
/*     */     public RoleFightRankManagerForMerge(int capacity, int extraSize)
/*     */     {
/* 102 */       super(extraSize);
/*     */     }
/*     */     
/*     */     public void saveToDB() {}
/*     */     
/*     */     public void rankDataFromDB() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeRoleNTFightValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */