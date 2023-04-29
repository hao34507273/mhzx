/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ 
/*    */ class MatchObjByActiveness
/*    */   implements Comparable<MatchObjByActiveness>
/*    */ {
/*    */   final long factionid;
/*    */   
/*    */   final int activeNumber;
/*    */   
/*    */   final int activeness;
/*    */   final long displayid;
/*    */   
/*    */   MatchObjByActiveness(long factionid, int activeNumber, int activeness, long displayid)
/*    */   {
/* 16 */     this.factionid = factionid;
/* 17 */     this.activeNumber = activeNumber;
/* 18 */     this.activeness = activeness;
/* 19 */     this.displayid = displayid;
/*    */   }
/*    */   
/*    */   long getFactionid() {
/* 23 */     return this.factionid;
/*    */   }
/*    */   
/*    */   long getDisplayid() {
/* 27 */     return this.displayid;
/*    */   }
/*    */   
/*    */   public int compareTo(MatchObjByActiveness other)
/*    */   {
/* 32 */     int ret = other.activeness - this.activeness;
/* 33 */     if (ret != 0) {
/* 34 */       return ret;
/*    */     }
/* 36 */     ret = other.activeNumber - this.activeNumber;
/* 37 */     if (ret != 0) {
/* 38 */       return ret;
/*    */     }
/*    */     
/* 41 */     if (this.factionid < other.factionid) {
/* 42 */       return -1;
/*    */     }
/* 44 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\MatchObjByActiveness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */