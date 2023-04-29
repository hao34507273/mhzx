/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ 
/*    */ 
/*    */ class RoleJingjiChart
/*    */   extends RoleKeyChartObj<RoleJingjiChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int winPoint;
/*    */   
/*    */   RoleJingjiChart(long roleid, int winPoint)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.winPoint = winPoint;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 22 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public int getWinPoint()
/*    */   {
/* 27 */     return this.winPoint;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 33 */     if (IdipManager.isBanRank(getKey().longValue(), 3))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     long roleSeasonEndTime = JingjiInterface.getRoleLastseasonendtime(getKey().longValue());
/* 38 */     if (roleSeasonEndTime == 0L)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     return roleSeasonEndTime >= JingjiInterface.getSeasonStarttime();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isTopThan(RoleJingjiChart rankObj)
/*    */   {
/* 51 */     return getWinPoint() > rankObj.getWinPoint();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\RoleJingjiChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */