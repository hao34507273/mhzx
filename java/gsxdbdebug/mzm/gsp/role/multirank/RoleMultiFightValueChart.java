/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ public class RoleMultiFightValueChart extends RoleKeyChartObj<RoleMultiFightValueChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int fightValue;
/*    */   private int occupationId;
/*    */   
/*    */   public RoleMultiFightValueChart(long roleid, int fightValue)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.fightValue = fightValue;
/*    */   }
/*    */   
/*    */   public RoleMultiFightValueChart(long roleid, int fightValue, int occupationId)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.fightValue = fightValue;
/* 21 */     this.occupationId = occupationId;
/*    */   }
/*    */   
/*    */   public int getFightValue()
/*    */   {
/* 26 */     return this.fightValue;
/*    */   }
/*    */   
/*    */   public int getOccupationId()
/*    */   {
/* 31 */     return this.occupationId;
/*    */   }
/*    */   
/*    */   public void setOccupationId(int occupationId)
/*    */   {
/* 36 */     this.occupationId = occupationId;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 42 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(RoleMultiFightValueChart obj)
/*    */   {
/* 54 */     return getFightValue() > obj.getFightValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\RoleMultiFightValueChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */