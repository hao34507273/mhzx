/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ class MatchObj implements Comparable<MatchObj>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int score;
/*    */   private final int winTimes;
/*    */   
/*    */   MatchObj(long roleid, int score, int winTimes) {
/* 10 */     this.roleid = roleid;
/* 11 */     this.score = score;
/* 12 */     this.winTimes = winTimes;
/*    */   }
/*    */   
/*    */   public long getRoleid() {
/* 16 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int compareTo(MatchObj other)
/*    */   {
/* 21 */     int ret = other.score - this.score;
/* 22 */     if (ret == 0) {
/* 23 */       ret = other.winTimes - this.winTimes;
/*    */     }
/* 25 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MatchObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */