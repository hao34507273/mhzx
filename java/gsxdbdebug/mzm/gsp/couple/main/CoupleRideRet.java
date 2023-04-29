/*    */ package mzm.gsp.couple.main;
/*    */ 
/*    */ public class CoupleRideRet
/*    */ {
/*    */   private Reason reason;
/*    */   
/*    */   public CoupleRideRet(Reason reason) {
/*  8 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   public static enum Reason {
/* 12 */     CoupleLeaderLevelNotEnough, 
/* 13 */     CoupleMemberLevelNotEnough, 
/* 14 */     CoupleLeaderMustMALE, 
/* 15 */     CoupleMemberMustFEMALE, 
/* 16 */     CoupleLeaderNotHasAirCraft, 
/* 17 */     CoupleLeaderInTeam, 
/* 18 */     CoupleMemberInTeam, 
/* 19 */     CoupleLeaderStatusError, 
/* 20 */     CoupleMemberStatusError, 
/* 21 */     CoupleLeaderInCoupleRide, 
/* 22 */     CoupleMemberInCoupleRide, 
/* 23 */     CoupleLeaderInNotFlyMap, 
/* 24 */     CoupleLeaderInModelChange, 
/* 25 */     CoupleMemberInModelChange, 
/* 26 */     SUCCESS;
/*    */     
/*    */ 
/*    */ 
/*    */     private Reason() {}
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean success()
/*    */   {
/* 36 */     return this.reason == Reason.SUCCESS;
/*    */   }
/*    */   
/*    */   public boolean isCoupleLeaderGenderError() {
/* 40 */     return this.reason == Reason.CoupleLeaderMustMALE;
/*    */   }
/*    */   
/*    */   public boolean isCoupleMemberGenderError() {
/* 44 */     return this.reason == Reason.CoupleMemberMustFEMALE;
/*    */   }
/*    */   
/*    */   public boolean isCoupleLeaderLeveNotEnough() {
/* 48 */     return this.reason == Reason.CoupleLeaderLevelNotEnough;
/*    */   }
/*    */   
/*    */   public boolean isCoupleMemberLevelNotEnough() {
/* 52 */     return this.reason == Reason.CoupleMemberLevelNotEnough;
/*    */   }
/*    */   
/*    */   public boolean isCoupleLeaderNotHasAirCraft() {
/* 56 */     return this.reason == Reason.CoupleLeaderNotHasAirCraft;
/*    */   }
/*    */   
/*    */   public boolean isCoupleLeaderInTeam() {
/* 60 */     return this.reason == Reason.CoupleLeaderInTeam;
/*    */   }
/*    */   
/*    */   public boolean isCoupleMemberInTeam() {
/* 64 */     return this.reason == Reason.CoupleMemberInTeam;
/*    */   }
/*    */   
/*    */   public boolean isCoupleLeaderStatusError() {
/* 68 */     return this.reason == Reason.CoupleLeaderStatusError;
/*    */   }
/*    */   
/*    */   public boolean isCoupleMemberStatusError() {
/* 72 */     return this.reason == Reason.CoupleMemberStatusError;
/*    */   }
/*    */   
/*    */   public boolean isCoupleLeaderInCoupleRide() {
/* 76 */     return this.reason == Reason.CoupleLeaderInCoupleRide;
/*    */   }
/*    */   
/*    */   public boolean isCoupleMemberInCoupleRide() {
/* 80 */     return this.reason == Reason.CoupleMemberInCoupleRide;
/*    */   }
/*    */   
/*    */   public boolean isCoupleLeaderInNotFlyMap() {
/* 84 */     return this.reason == Reason.CoupleLeaderInNotFlyMap;
/*    */   }
/*    */   
/*    */   public boolean isCoupleLeaderInModelChange() {
/* 88 */     return this.reason == Reason.CoupleLeaderInModelChange;
/*    */   }
/*    */   
/*    */   public boolean isCoupleMemberInModelChange() {
/* 92 */     return this.reason == Reason.CoupleMemberInModelChange;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\CoupleRideRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */