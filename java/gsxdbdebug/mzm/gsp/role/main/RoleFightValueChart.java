/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ public class RoleFightValueChart extends RoleKeyChartObj<RoleFightValueChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int fightValue;
/*    */   
/*    */   public RoleFightValueChart(long roleid, int fightValue)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.fightValue = fightValue;
/*    */   }
/*    */   
/*    */   public int getFightValue()
/*    */   {
/* 18 */     return this.fightValue;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 24 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(RoleFightValueChart obj)
/*    */   {
/* 36 */     return getFightValue() > obj.getFightValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleFightValueChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */