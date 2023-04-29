/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ import xbean.FlowerPoint;
/*    */ import xtable.Role2flowerpoint;
/*    */ 
/*    */ public class RoleGiveFlowerChart extends RoleKeyChartObj<RoleGiveFlowerChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private int givePoint;
/*    */   
/*    */   public int getGivePoint()
/*    */   {
/* 14 */     return this.givePoint;
/*    */   }
/*    */   
/*    */   public RoleGiveFlowerChart(long roleid, int givePoint)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.givePoint = givePoint;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 26 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 32 */     if (mzm.gsp.idip.main.IdipManager.isBanRank(getKey().longValue(), 5))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     FlowerPoint xFlowerPoint = Role2flowerpoint.select(Long.valueOf(this.roleid));
/*    */     
/* 38 */     if (xFlowerPoint == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     if (xFlowerPoint.getGivepoint() == 0)
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     long freshtime = ItemGiveManager.getFlowerrefreshtime();
/* 47 */     return (xFlowerPoint.getCleartime() >= freshtime) && (ItemGiveManager.isFlowerVersionRight(xFlowerPoint.getVersion()));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isTopThan(RoleGiveFlowerChart obj)
/*    */   {
/* 54 */     return getGivePoint() > obj.getGivePoint();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\RoleGiveFlowerChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */