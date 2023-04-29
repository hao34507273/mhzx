/*    */ package mzm.gsp.chart.main;
/*    */ 
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
/*    */ public abstract class NoneRealTimeRoleKeyRankManagerNew<TChartObj extends RoleKeyChartObj<TChartObj>>
/*    */   extends NoneRealTimeRoleRelatedRankManagerNew<Long, TChartObj>
/*    */ {
/*    */   public NoneRealTimeRoleKeyRankManagerNew(int chartType, RoleRelatedRankManagerNew<Long, TChartObj> rankManagerNew)
/*    */   {
/* 22 */     super(chartType, rankManagerNew);
/*    */   }
/*    */   
/*    */   public boolean removeByRoleid(final long roleid, boolean isClear)
/*    */   {
/* 27 */     boolean ret = delete(Long.valueOf(roleid));
/* 28 */     if (isClear) {
/* 29 */       Procedure.execute(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 33 */           NoneRealTimeRoleKeyRankManagerNew.this.clearRoleRankData(roleid);
/* 34 */           return true;
/*    */         }
/*    */       });
/*    */     }
/* 38 */     return ret;
/*    */   }
/*    */   
/*    */   public int getMaxRank(long roleid)
/*    */   {
/* 43 */     return super.getRank(Long.valueOf(roleid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\NoneRealTimeRoleKeyRankManagerNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */