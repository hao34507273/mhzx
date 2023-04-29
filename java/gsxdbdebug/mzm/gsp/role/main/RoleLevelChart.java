/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ public class RoleLevelChart extends RoleKeyChartObj<RoleLevelChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int level;
/*    */   private final long lvupTime;
/*    */   
/*    */   public RoleLevelChart(long roleid, int level, long lvupTime)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.level = level;
/* 15 */     this.lvupTime = lvupTime;
/*    */   }
/*    */   
/*    */   public int getLevel()
/*    */   {
/* 20 */     return this.level;
/*    */   }
/*    */   
/*    */   public long getLvupTime()
/*    */   {
/* 25 */     return this.lvupTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 31 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 37 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(RoleLevelChart obj)
/*    */   {
/* 43 */     if (getLevel() > obj.getLevel())
/*    */     {
/* 45 */       return true;
/*    */     }
/* 47 */     if (getLevel() < obj.getLevel())
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     return getLvupTime() < obj.getLvupTime();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleLevelChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */