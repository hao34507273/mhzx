/*     */ package mzm.gsp.activity.main;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ActivityJoinResult
/*     */ {
/*     */   private boolean canJoin;
/*     */   
/*     */ 
/*     */ 
/*     */   private Reason reason;
/*     */   
/*     */ 
/*     */ 
/*     */   private String userid;
/*     */   
/*     */ 
/*     */ 
/*     */   private long roleId;
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isCanJoin()
/*     */   {
/*  26 */     return this.canJoin;
/*     */   }
/*     */   
/*     */   public boolean isRoleLevelWrong() {
/*  30 */     return this.reason == Reason.RoleLevel;
/*     */   }
/*     */   
/*     */   public boolean isPerSonCountWrong() {
/*  34 */     return this.reason == Reason.PersonCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isDataWrong()
/*     */   {
/*  43 */     return this.reason == Reason.DataError;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSingleRoleTeam()
/*     */   {
/*  52 */     return this.reason == Reason.SingleRoleTeam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isActivityJoinCountMax()
/*     */   {
/*  61 */     return this.reason == Reason.ActivityCountToMax;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isServerLevelSuit()
/*     */   {
/*  69 */     return this.reason == Reason.ServerLevelWrong;
/*     */   }
/*     */   
/*     */   public boolean isActivityNotOpen() {
/*  73 */     return this.reason == Reason.ActivityNotOpen;
/*     */   }
/*     */   
/*     */   public void setCanJoin(boolean canJoin) {
/*  77 */     this.canJoin = canJoin;
/*     */   }
/*     */   
/*     */   public void setReason(Reason reason) {
/*  81 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   public void setUserid(String userid) {
/*  85 */     this.userid = userid;
/*     */   }
/*     */   
/*     */   public String getUserid() {
/*  89 */     return this.userid;
/*     */   }
/*     */   
/*     */   public void setRoleId(long roleId) {
/*  93 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   public long getRoleId() {
/*  97 */     return this.roleId;
/*     */   }
/*     */   
/*     */   public int getReasonValue() {
/* 101 */     return this.reason.ordinal();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum Reason
/*     */   {
/* 110 */     RoleLevel, 
/* 111 */     PersonCount, 
/* 112 */     ActivityCountToMax, 
/* 113 */     ActivityNotOpen, 
/* 114 */     ActivityInPause, 
/* 115 */     ActivityInForceClose, 
/* 116 */     MenPai, 
/* 117 */     SingleRoleTeam, 
/* 118 */     DataError, 
/* 119 */     ServerLevelWrong;
/*     */     
/*     */     private Reason() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityJoinResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */