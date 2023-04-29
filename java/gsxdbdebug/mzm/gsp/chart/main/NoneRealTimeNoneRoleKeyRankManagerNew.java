/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class NoneRealTimeNoneRoleKeyRankManagerNew<TKey, TChartObj extends NoneRoleKeyChartObj<TKey, TChartObj>>
/*    */   extends NoneRealTimeRoleRelatedRankManagerNew<TKey, TChartObj>
/*    */ {
/*    */   public NoneRealTimeNoneRoleKeyRankManagerNew(int chartType, RoleRelatedRankManagerNew<TKey, TChartObj> rankManagerNew)
/*    */   {
/* 24 */     super(chartType, rankManagerNew);
/*    */   }
/*    */   
/*    */   public boolean removeByRoleid(final long roleid, boolean isClear)
/*    */   {
/* 29 */     boolean ret = false;
/* 30 */     List<TChartObj> allchartObj = getAllChartObjs();
/* 31 */     for (TChartObj chartObj : allchartObj) {
/* 32 */       if ((chartObj.getRoleid() == roleid) && 
/* 33 */         (delete(chartObj.getKey()))) {
/* 34 */         ret = true;
/*    */       }
/*    */     }
/*    */     
/* 38 */     if (isClear) {
/* 39 */       Procedure.execute(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 43 */           NoneRealTimeNoneRoleKeyRankManagerNew.this.clearRoleRankData(roleid);
/* 44 */           return true;
/*    */         }
/*    */       });
/*    */     }
/* 48 */     return ret;
/*    */   }
/*    */   
/*    */   public int getMaxRank(long roleid)
/*    */   {
/* 53 */     List<TChartObj> allchartObj = getAllChartObjs();
/* 54 */     for (int i = 0; i < allchartObj.size(); i++) {
/* 55 */       TChartObj chartObj = (NoneRoleKeyChartObj)allchartObj.get(i);
/* 56 */       if (chartObj.getRoleid() == roleid) {
/* 57 */         return i;
/*    */       }
/*    */     }
/* 60 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\NoneRealTimeNoneRoleKeyRankManagerNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */