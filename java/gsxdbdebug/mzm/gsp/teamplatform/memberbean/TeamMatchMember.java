/*    */ package mzm.gsp.teamplatform.memberbean;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamMatchMember
/*    */ {
/*    */   private long teamId;
/*    */   
/*    */   private long startTime;
/*    */   
/*    */   private int level;
/*    */   
/*    */   private int level_low;
/*    */   
/*    */   private int level_high;
/*    */   
/*    */ 
/*    */   public TeamMatchMember(int level, long startTime)
/*    */   {
/* 20 */     this.level = level;
/* 21 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   public TeamMatchMember(int level, long startTime, long teamId, int level_low, int level_high) {
/* 25 */     this.level = level;
/* 26 */     this.startTime = startTime;
/* 27 */     this.teamId = teamId;
/* 28 */     this.level_low = level_low;
/* 29 */     this.level_high = level_high;
/*    */   }
/*    */   
/*    */   public long getTeamId()
/*    */   {
/* 34 */     return this.teamId;
/*    */   }
/*    */   
/* 37 */   public void setTeamId(long teamId) { this.teamId = teamId; }
/*    */   
/*    */   public long getStartTime() {
/* 40 */     return this.startTime;
/*    */   }
/*    */   
/* 43 */   public void setStartTime(long startTime) { this.startTime = startTime; }
/*    */   
/*    */   public int getLevel_low() {
/* 46 */     return this.level_low;
/*    */   }
/*    */   
/*    */   public void setLevel_low(int level_low)
/*    */   {
/* 51 */     this.level_low = level_low;
/*    */   }
/*    */   
/* 54 */   public int getLevel_high() { return this.level_high; }
/*    */   
/*    */ 
/*    */   public void setLevel_high(int level_high)
/*    */   {
/* 59 */     this.level_high = level_high;
/*    */   }
/*    */   
/*    */   public int getLevel() {
/* 63 */     return this.level;
/*    */   }
/*    */   
/*    */   public void setLevel(int level)
/*    */   {
/* 68 */     this.level = level;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 73 */     if (this == obj) {
/* 74 */       return true;
/*    */     }
/* 76 */     if ((obj instanceof TeamMatchMember)) {
/* 77 */       TeamMatchMember et = (TeamMatchMember)obj;
/* 78 */       if ((et.level == this.level) && (et.level_high == this.level_high) && (et.level_low == this.level_low) && (et.startTime == this.startTime) && (et.teamId == this.teamId))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 83 */         return true;
/*    */       }
/*    */     }
/* 86 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 91 */     int result = 17;
/* 92 */     result = 37 * result + this.level;
/* 93 */     result = 37 * result + this.level_high;
/* 94 */     result = 37 * result + this.level_low;
/* 95 */     result = 37 * result + (int)(this.startTime ^ this.startTime >>> 32);
/* 96 */     result = 37 * result + (int)(this.teamId ^ this.teamId >>> 32);
/* 97 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\memberbean\TeamMatchMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */