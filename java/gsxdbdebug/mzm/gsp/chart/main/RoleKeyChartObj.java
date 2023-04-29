/*    */ package mzm.gsp.chart.main;
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
/*    */ public abstract class RoleKeyChartObj<TChartObj extends RoleKeyChartObj<TChartObj>>
/*    */   extends RoleRelatedChartObj<Long, TChartObj>
/*    */   implements ObjWithKey<Long>
/*    */ {
/*    */   public long getRoleid()
/*    */   {
/* 18 */     return ((Long)getKey()).longValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RoleKeyChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */