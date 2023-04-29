/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ public class RoleHomelandChart
/*    */   extends RoleKeyChartObj<RoleHomelandChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int point;
/*    */   
/*    */   public RoleHomelandChart(long roleid, int point)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.point = point;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 23 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public int getPoint()
/*    */   {
/* 28 */     return this.point;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 34 */     if (IdipManager.isBanRank(getKey().longValue(), 22))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (OpenInterface.isBanPlay(getKey().longValue(), 161))
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     if (!HomelandManager.isCurrentHomeCreator(getKey().longValue()))
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isTopThan(RoleHomelandChart rankObj)
/*    */   {
/* 53 */     return getPoint() > rankObj.getPoint();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\RoleHomelandChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */