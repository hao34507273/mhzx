/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.ChartObj;
/*    */ 
/*    */ public class MenpaiPVPChartObj extends ChartObj<Long, MenpaiPVPChartObj> implements mzm.gsp.chart.main.ObjWithKey<Long>
/*    */ {
/*    */   private long roleid;
/*    */   private int score;
/*    */   private int winTimes;
/*    */   
/*    */   public MenpaiPVPChartObj(long roleid, int score, int winTimes)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.score = score;
/* 15 */     this.winTimes = winTimes;
/*    */   }
/*    */   
/*    */   public long getRoleid() {
/* 19 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int getScore() {
/* 23 */     return this.score;
/*    */   }
/*    */   
/*    */   public int getWinTimes() {
/* 27 */     return this.winTimes;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(MenpaiPVPChartObj rankObj)
/*    */   {
/* 39 */     if (this.score > rankObj.score) {
/* 40 */       return true;
/*    */     }
/* 42 */     if (this.score < rankObj.score) {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (this.winTimes > rankObj.winTimes) {
/* 47 */       return true;
/*    */     }
/* 49 */     if (this.winTimes < rankObj.winTimes) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     return this.roleid < rankObj.roleid;
/*    */   }
/*    */   
/*    */   public Long getKey()
/*    */   {
/* 58 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MenpaiPVPChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */