/*    */ package mzm.gsp.teamplatform.memberbean;
/*    */ 
/*    */ public class TeamRepeatMember
/*    */ {
/*    */   private long leaderId;
/*    */   private long teamId;
/*    */   
/*    */   public TeamRepeatMember(long leaderId, long teamId) {
/*  9 */     this.leaderId = leaderId;
/* 10 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */   public long getLeaderId() {
/* 14 */     return this.leaderId;
/*    */   }
/*    */   
/*    */   public void setLeaderId(long leaderId) {
/* 18 */     this.leaderId = leaderId;
/*    */   }
/*    */   
/*    */   public long getTeamId() {
/* 22 */     return this.teamId;
/*    */   }
/*    */   
/*    */   public void setTeamId(long teamId) {
/* 26 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 31 */     if (this == obj) {
/* 32 */       return true;
/*    */     }
/* 34 */     if ((obj instanceof TeamRepeatMember)) {
/* 35 */       TeamRepeatMember et = (TeamRepeatMember)obj;
/* 36 */       if ((et.leaderId == this.leaderId) && (et.teamId == this.teamId))
/*    */       {
/* 38 */         return true;
/*    */       }
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 46 */     int result = 17;
/* 47 */     result = 37 * result + (int)(this.leaderId ^ this.leaderId >>> 32);
/* 48 */     result = 37 * result + (int)(this.teamId ^ this.teamId >>> 32);
/* 49 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\memberbean\TeamRepeatMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */