/*    */ package mzm.gsp.teamplatform.memberbean;
/*    */ 
/*    */ 
/*    */ public class RoleMatchMember
/*    */ {
/*    */   private long roleId;
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
/*    */   public RoleMatchMember(int level, long startTime)
/*    */   {
/* 19 */     this.level = level;
/* 20 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   public RoleMatchMember(int level, long startTime, long roleId, int level_low, int level_high) {
/* 24 */     this.level = level;
/* 25 */     this.startTime = startTime;
/* 26 */     this.roleId = roleId;
/* 27 */     this.level_high = level_high;
/* 28 */     this.level_low = level_low;
/*    */   }
/*    */   
/*    */   public long getRoleId() {
/* 32 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public void setRoleId(long roleId) {
/* 36 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   public long getStartTime() {
/* 40 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public void setStartTime(long startTime) {
/* 44 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   public int getLevel() {
/* 48 */     return this.level;
/*    */   }
/*    */   
/*    */   public void setLevel(int level) {
/* 52 */     this.level = level;
/*    */   }
/*    */   
/*    */   public int getLevel_low() {
/* 56 */     return this.level_low;
/*    */   }
/*    */   
/*    */   public void setLevel_low(int level_low) {
/* 60 */     this.level_low = level_low;
/*    */   }
/*    */   
/*    */   public int getLevel_high() {
/* 64 */     return this.level_high;
/*    */   }
/*    */   
/*    */   public void setLevel_high(int level_high) {
/* 68 */     this.level_high = level_high;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 73 */     if (this == obj) {
/* 74 */       return true;
/*    */     }
/* 76 */     if ((obj instanceof RoleMatchMember)) {
/* 77 */       RoleMatchMember et = (RoleMatchMember)obj;
/* 78 */       if ((et.level == this.level) && (et.level_high == this.level_high) && (et.level_low == this.level_low) && (et.startTime == this.startTime) && (et.roleId == this.roleId))
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
/* 96 */     result = 37 * result + (int)(this.roleId ^ this.roleId >>> 32);
/* 97 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\memberbean\RoleMatchMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */