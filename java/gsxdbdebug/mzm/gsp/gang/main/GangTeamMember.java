/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ class GangTeamMember implements Comparable<GangTeamMember>
/*    */ {
/*    */   final long memberid;
/*    */   final long joinTime;
/*    */   
/*    */   GangTeamMember(long memberid, long joinTime) {
/*  9 */     this.memberid = memberid;
/* 10 */     this.joinTime = joinTime;
/*    */   }
/*    */   
/*    */   public int compareTo(GangTeamMember other)
/*    */   {
/* 15 */     long diff = this.joinTime - other.joinTime;
/* 16 */     if (diff == 0L) {
/* 17 */       diff = this.memberid - other.memberid;
/*    */     }
/*    */     
/* 20 */     if (diff > 0L) {
/* 21 */       return 1;
/*    */     }
/* 23 */     if (diff < 0L) {
/* 24 */       return -1;
/*    */     }
/* 26 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangTeamMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */