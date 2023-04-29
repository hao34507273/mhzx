/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.chart.main.RankManagerNew;
/*    */ import mzm.gsp.role.main.RoleFightValueChart;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FightValueRank;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleFightValueBean;
/*    */ import xtable.Fightvaluerank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MergeRoleFightValue
/*    */   extends LogicProcedure
/*    */ {
/* 22 */   private static final Logger logger = Logger.getLogger(MergeRoleFightValue.class);
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     long mainKey = MergeMain.getMainZoneid();
/* 28 */     long viceKey = MergeMain.getViceZoneid();
/*    */     
/* 30 */     lock(Fightvaluerank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */     
/* 32 */     FightValueRank xViceRoleFight = Fightvaluerank.get(Long.valueOf(viceKey));
/* 33 */     if (xViceRoleFight == null)
/*    */     {
/* 35 */       logger.warn(String.format("[roleLvRank]MergeRoleFightValue.processImp@ no vice fight xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 37 */       return true;
/*    */     }
/* 39 */     FightValueRank xMainRoleFight = Fightvaluerank.get(Long.valueOf(mainKey));
/* 40 */     if (xMainRoleFight == null)
/*    */     {
/* 42 */       xMainRoleFight = Pod.newFightValueRank();
/* 43 */       Fightvaluerank.insert(Long.valueOf(mainKey), xMainRoleFight);
/*    */     }
/*    */     
/* 46 */     RoleFightRankManagerForMerge mergeRank = new RoleFightRankManagerForMerge(Integer.MAX_VALUE, 0);
/*    */     
/* 48 */     addRoleLVData(xMainRoleFight.getRolerankdatas(), mergeRank);
/*    */     
/* 50 */     addRoleLVData(xViceRoleFight.getRolerankdatas(), mergeRank);
/*    */     
/* 52 */     xMainRoleFight.getRolerankdatas().clear();
/*    */     
/* 54 */     for (RoleFightValueChart rankObj : mergeRank.getAllChartObjs())
/*    */     {
/* 56 */       RoleFightValueBean xRoleFight = Pod.newRoleFightValueBean();
/* 57 */       xRoleFight.setRoleid(rankObj.getRoleid());
/* 58 */       xMainRoleFight.getRolerankdatas().add(xRoleFight);
/*    */     }
/*    */     
/* 61 */     mergeRank.clear();
/*    */     
/* 63 */     Fightvaluerank.remove(Long.valueOf(viceKey));
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void addRoleLVData(List<RoleFightValueBean> xRoleFightDatas, RoleFightRankManagerForMerge mergeRank)
/*    */   {
/* 75 */     if ((xRoleFightDatas == null) || (xRoleFightDatas.size() == 0))
/*    */     {
/* 77 */       return;
/*    */     }
/* 79 */     for (RoleFightValueBean xRoleFight : xRoleFightDatas)
/*    */     {
/* 81 */       long roleId = xRoleFight.getRoleid();
/* 82 */       int fightValue = RoleInterface.getFightValue(roleId);
/* 83 */       RoleFightValueChart rankObj = new RoleFightValueChart(roleId, fightValue);
/* 84 */       mergeRank.rank(rankObj);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private class RoleFightRankManagerForMerge
/*    */     extends RankManagerNew<Long, RoleFightValueChart>
/*    */   {
/*    */     public RoleFightRankManagerForMerge(int capacity, int extraSize)
/*    */     {
/* 99 */       super(extraSize);
/*    */     }
/*    */     
/*    */     public void saveToDB() {}
/*    */     
/*    */     public void rankDataFromDB() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeRoleFightValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */