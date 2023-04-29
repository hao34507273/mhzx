/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.NoneRoleKeyChartObj;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ 
/*    */ public class ChildrenRatingChart
/*    */   extends NoneRoleKeyChartObj<Long, ChildrenRatingChart>
/*    */ {
/*    */   private final long childId;
/*    */   private final long roleId;
/*    */   private final int rating;
/*    */   
/*    */   ChildrenRatingChart(long childId, long roleId, int rating)
/*    */   {
/* 15 */     this.childId = childId;
/* 16 */     this.roleId = roleId;
/* 17 */     this.rating = rating;
/*    */   }
/*    */   
/*    */   public long getChildId()
/*    */   {
/* 22 */     return this.childId;
/*    */   }
/*    */   
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 28 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getRating()
/*    */   {
/* 33 */     return this.rating;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 39 */     return Long.valueOf(this.childId);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 45 */     if (IdipManager.isBanRank(getKey().longValue(), 36))
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(ChildrenRatingChart obj)
/*    */   {
/* 55 */     return getRating() > obj.getRating();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\ChildrenRatingChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */