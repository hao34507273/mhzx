/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import xbean.HomeInfo;
/*    */ 
/*    */ public class HomeInfoWrapper
/*    */ {
/*    */   private final HomeInfo xHomeInfo;
/*  8 */   private long homeWorldId = -1L;
/*    */   
/*    */   private final long ownerRoleId;
/*    */   
/* 12 */   private long partnerRoleId = -1L;
/*    */   
/*    */ 
/*    */   public HomeInfoWrapper(HomeInfo xHomeInfo, long homeWorldId, long ownerRoleId, long partnerRoleId)
/*    */   {
/* 17 */     this.xHomeInfo = xHomeInfo;
/* 18 */     this.homeWorldId = homeWorldId;
/* 19 */     this.ownerRoleId = ownerRoleId;
/* 20 */     this.partnerRoleId = partnerRoleId;
/*    */   }
/*    */   
/*    */   public HomeInfo getxHomeInfo()
/*    */   {
/* 25 */     return this.xHomeInfo;
/*    */   }
/*    */   
/*    */   public long getHomeWorldId()
/*    */   {
/* 30 */     return this.homeWorldId;
/*    */   }
/*    */   
/*    */   public long getOwnerRoleId()
/*    */   {
/* 35 */     return this.ownerRoleId;
/*    */   }
/*    */   
/*    */   public long getPartnerRoleId()
/*    */   {
/* 40 */     return this.partnerRoleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\HomeInfoWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */