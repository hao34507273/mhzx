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
/*    */ public abstract class RoleKeyRankManagerNew<TChartObj extends RoleKeyChartObj<TChartObj>>
/*    */   extends RoleRelatedRankManagerNew<Long, TChartObj>
/*    */ {
/*    */   public RoleKeyRankManagerNew(int chartType)
/*    */   {
/* 21 */     super(chartType);
/*    */   }
/*    */   
/*    */   public boolean removeByRoleid(final long roleid, boolean isClear)
/*    */   {
/* 26 */     boolean ret = delete(Long.valueOf(roleid));
/* 27 */     if (isClear) {
/* 28 */       Procedure.execute(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 32 */           RoleKeyRankManagerNew.this.clearRoleRankData(roleid);
/* 33 */           return true;
/*    */         }
/*    */       });
/*    */     }
/* 37 */     return ret;
/*    */   }
/*    */   
/*    */   public int getMaxRank(long roleid)
/*    */   {
/* 42 */     return super.getRank(Long.valueOf(roleid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RoleKeyRankManagerNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */