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
/*    */ public abstract class NoneRoleKeyRankManagerNew<TKey, TChartObj extends NoneRoleKeyChartObj<TKey, TChartObj>>
/*    */   extends RoleRelatedRankManagerNew<TKey, TChartObj>
/*    */ {
/*    */   public NoneRoleKeyRankManagerNew(int chartType)
/*    */   {
/* 23 */     super(chartType);
/*    */   }
/*    */   
/*    */   public boolean removeByRoleid(final long roleid, boolean isClear)
/*    */   {
/* 28 */     boolean ret = false;
/* 29 */     List<TChartObj> allchartObj = getAllChartObjs();
/* 30 */     for (TChartObj chartObj : allchartObj) {
/* 31 */       if ((chartObj.getRoleid() == roleid) && 
/* 32 */         (delete(chartObj.getKey()))) {
/* 33 */         ret = true;
/*    */       }
/*    */     }
/*    */     
/* 37 */     if (isClear) {
/* 38 */       Procedure.execute(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 42 */           NoneRoleKeyRankManagerNew.this.clearRoleRankData(roleid);
/* 43 */           return true;
/*    */         }
/*    */       });
/*    */     }
/* 47 */     return ret;
/*    */   }
/*    */   
/*    */   public int getMaxRank(long roleid)
/*    */   {
/* 52 */     List<TChartObj> allchartObj = getAllChartObjs();
/* 53 */     for (int i = 0; i < allchartObj.size(); i++) {
/* 54 */       TChartObj chartObj = (NoneRoleKeyChartObj)allchartObj.get(i);
/* 55 */       if (chartObj.getRoleid() == roleid) {
/* 56 */         return i;
/*    */       }
/*    */     }
/* 59 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\NoneRoleKeyRankManagerNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */