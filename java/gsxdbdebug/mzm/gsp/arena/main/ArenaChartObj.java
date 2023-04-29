/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArenaChartObj
/*    */   extends RoleKeyChartObj<ArenaChartObj>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int score;
/*    */   private final int winTimes;
/*    */   
/*    */   public ArenaChartObj(long roleid, int score, int winTimes)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.score = score;
/* 19 */     this.winTimes = winTimes;
/*    */   }
/*    */   
/*    */   public long getRoleid() {
/* 23 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int getScore() {
/* 27 */     return this.score;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 33 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public boolean isAvailable()
/*    */   {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isTopThan(ArenaChartObj other)
/*    */   {
/* 43 */     if (this.score > other.score) {
/* 44 */       return true;
/*    */     }
/* 46 */     if (this.score < other.score) {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     if (this.winTimes > other.winTimes) {
/* 51 */       return true;
/*    */     }
/* 53 */     if (this.winTimes < other.winTimes) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     return this.roleid < other.roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */