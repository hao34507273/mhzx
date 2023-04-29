/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ public class RoleMasterChart extends RoleKeyChartObj<RoleMasterChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int apprenticeSize;
/*    */   
/*    */   public RoleMasterChart(long roleid, int apprenticeSize)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.apprenticeSize = apprenticeSize;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 19 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public int getApprenticeSize()
/*    */   {
/* 24 */     return this.apprenticeSize;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(RoleMasterChart rankObj)
/*    */   {
/* 36 */     return getApprenticeSize() > rankObj.getApprenticeSize();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\RoleMasterChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */