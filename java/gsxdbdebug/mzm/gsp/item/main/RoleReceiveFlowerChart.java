/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ import xbean.FlowerPoint;
/*    */ import xtable.Role2flowerpoint;
/*    */ 
/*    */ public class RoleReceiveFlowerChart extends RoleKeyChartObj<RoleReceiveFlowerChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int receivePoint;
/*    */   
/*    */   public int getReceivePoint()
/*    */   {
/* 14 */     return this.receivePoint;
/*    */   }
/*    */   
/*    */   public RoleReceiveFlowerChart(long roleid, int receivePoint)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.receivePoint = receivePoint;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 26 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 33 */     if (mzm.gsp.idip.main.IdipManager.isBanRank(getKey().longValue(), 6))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     FlowerPoint xFlowerPoint = Role2flowerpoint.select(Long.valueOf(this.roleid));
/*    */     
/* 39 */     if (xFlowerPoint == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     if (xFlowerPoint.getReceivepoint() == 0)
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     long freshtime = ItemGiveManager.getFlowerrefreshtime();
/* 48 */     return (xFlowerPoint.getCleartime() >= freshtime) && (ItemGiveManager.isFlowerVersionRight(xFlowerPoint.getVersion()));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isTopThan(RoleReceiveFlowerChart obj)
/*    */   {
/* 55 */     return getReceivePoint() > obj.getReceivePoint();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\RoleReceiveFlowerChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */