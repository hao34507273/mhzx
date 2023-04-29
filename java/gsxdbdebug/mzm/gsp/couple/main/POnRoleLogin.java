/*    */ package mzm.gsp.couple.main;
/*    */ 
/*    */ import mzm.gsp.couple.SCommonRideRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.CoupleRide;
/*    */ import xtable.Role2coupleride;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     Long coupleid = Role2coupleride.select((Long)this.arg);
/* 13 */     if (coupleid == null) {
/* 14 */       return false;
/*    */     }
/* 16 */     CoupleRide xCoupleRide = xtable.Coupleride.select(coupleid);
/* 17 */     if (xCoupleRide == null) {
/* 18 */       return false;
/*    */     }
/* 20 */     long roleidA = xCoupleRide.getRolea();
/* 21 */     long roleidB = xCoupleRide.getRoleb();
/* 22 */     lock(Role2coupleride.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleidA), Long.valueOf(roleidB) }));
/* 23 */     Long coupleid1 = Role2coupleride.get((Long)this.arg);
/* 24 */     if (coupleid1 == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     if (coupleid1 != coupleid) {
/* 28 */       return false;
/*    */     }
/* 30 */     long otherRoleid = roleidA;
/* 31 */     if (otherRoleid == ((Long)this.arg).longValue()) {
/* 32 */       otherRoleid = roleidB;
/*    */     }
/* 34 */     SCommonRideRes commonRideRoleRes = new SCommonRideRes();
/* 35 */     CoupleManager.fillInCommonRideRes(otherRoleid, commonRideRoleRes.commonrideroleinfo, true);
/* 36 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), commonRideRoleRes);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */