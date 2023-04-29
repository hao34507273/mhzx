/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ public class FriendsCicrlePopularityChart extends RoleKeyChartObj<FriendsCicrlePopularityChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int popularityValue;
/*    */   
/*    */   public FriendsCicrlePopularityChart(long roleid, int pupularityValue)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.popularityValue = pupularityValue;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 19 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public int getPopularityValue()
/*    */   {
/* 30 */     return this.popularityValue;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(FriendsCicrlePopularityChart rankObj)
/*    */   {
/* 36 */     return this.popularityValue > rankObj.getPopularityValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\FriendsCicrlePopularityChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */