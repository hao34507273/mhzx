/*    */ package mzm.gsp.couple.main;
/*    */ 
/*    */ import xbean.CoupleRide;
/*    */ import xtable.Coupleride;
/*    */ import xtable.Role2coupleride;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CoupleInterface
/*    */ {
/*    */   public static CoupleRideRet coupleRide(long roleid1, long roleid2)
/*    */   {
/* 13 */     return CoupleManager.coupleRide(roleid1, roleid2);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static DissolveCoupleRideRet dissiloveRide(long roleidA, long roleidB)
/*    */   {
/* 24 */     return CoupleManager.dissolveCoupleRide(roleidA, roleidB);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static long getCoupleRide(long roleid)
/*    */   {
/* 34 */     Long coupleRideid = Role2coupleride.select(Long.valueOf(roleid));
/* 35 */     if (coupleRideid == null) {
/* 36 */       return -1L;
/*    */     }
/* 38 */     CoupleRide coupleRide = Coupleride.select(coupleRideid);
/* 39 */     if (coupleRide == null) {
/* 40 */       return -1L;
/*    */     }
/* 42 */     long ret = coupleRide.getRolea();
/* 43 */     if (roleid == ret) {
/* 44 */       ret = coupleRide.getRoleb();
/*    */     }
/* 46 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\CoupleInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */