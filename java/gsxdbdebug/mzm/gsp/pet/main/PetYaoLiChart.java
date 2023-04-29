/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.NoneRoleKeyChartObj;
/*    */ 
/*    */ public class PetYaoLiChart extends NoneRoleKeyChartObj<Long, PetYaoLiChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final long petid;
/*    */   private final int yaoLiValue;
/*    */   private final long yaoLiTime;
/*    */   
/*    */   public PetYaoLiChart(long petId, long roleid, int yaoLiValue, long yaoLiTime)
/*    */   {
/* 14 */     this.petid = petId;
/* 15 */     this.roleid = roleid;
/* 16 */     this.yaoLiValue = yaoLiValue;
/* 17 */     this.yaoLiTime = yaoLiTime;
/*    */   }
/*    */   
/*    */   public int getYaoLiValue() {
/* 21 */     return this.yaoLiValue;
/*    */   }
/*    */   
/*    */   public long getPetId() {
/* 25 */     return this.petid;
/*    */   }
/*    */   
/*    */   public long getRoleId() {
/* 29 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public long getYaoLiTime() {
/* 33 */     return this.yaoLiTime;
/*    */   }
/*    */   
/*    */   public Long getKey()
/*    */   {
/* 38 */     return Long.valueOf(this.petid);
/*    */   }
/*    */   
/*    */   public boolean isAvailable()
/*    */   {
/* 43 */     if (mzm.gsp.idip.main.IdipManager.isBanRank(getKey().longValue(), 1))
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isTopThan(PetYaoLiChart obj)
/*    */   {
/* 52 */     if (getYaoLiValue() != obj.getYaoLiValue()) {
/* 53 */       return getYaoLiValue() > obj.getYaoLiValue();
/*    */     }
/* 55 */     return getYaoLiTime() < obj.getYaoLiTime();
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 60 */     return this.roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetYaoLiChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */