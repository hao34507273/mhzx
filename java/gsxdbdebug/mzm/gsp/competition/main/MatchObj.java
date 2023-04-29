/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ 
/*    */ class MatchObj
/*    */   implements Comparable<MatchObj>
/*    */ {
/*    */   private final long factionid;
/*    */   
/*    */   private final int rank;
/*    */   
/*    */   private final int level;
/*    */   
/*    */   MatchObj(long factionid, int rank, int level)
/*    */   {
/* 15 */     this.factionid = factionid;
/* 16 */     this.rank = rank;
/* 17 */     this.level = level;
/*    */   }
/*    */   
/*    */   long getFactionid() {
/* 21 */     return this.factionid;
/*    */   }
/*    */   
/*    */   public int compareTo(MatchObj other)
/*    */   {
/* 26 */     int ret = other.rank - this.rank;
/* 27 */     if (ret != 0) {
/* 28 */       return ret;
/*    */     }
/* 30 */     ret = other.level - this.level;
/* 31 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\MatchObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */