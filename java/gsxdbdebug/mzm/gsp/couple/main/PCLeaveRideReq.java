/*    */ package mzm.gsp.couple.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CoupleRide;
/*    */ 
/*    */ public class PCLeaveRideReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCLeaveRideReq(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     Long coupleid = xtable.Role2coupleride.select(Long.valueOf(this.roleid));
/* 19 */     if (coupleid == null) {
/* 20 */       GameServer.logger().info(String.format("[CoupleRide]PCLeaveRideReq.processImp@已经结束双人飞行了|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 22 */       return false;
/*    */     }
/* 24 */     CoupleRide xCoupleRide = xtable.Coupleride.select(coupleid);
/* 25 */     if (xCoupleRide == null) {
/* 26 */       GameServer.logger().info(String.format("[CoupleRide]PCLeaveRideReq.processImp@已经结束双人飞行了|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 28 */       return false;
/*    */     }
/* 30 */     long roleA = xCoupleRide.getRolea();
/* 31 */     long roleB = xCoupleRide.getRoleb();
/* 32 */     lock(xtable.Role2coupleride.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleA), Long.valueOf(roleB) }));
/*    */     
/* 34 */     DissolveCoupleRideRet dissolveCoupleRideRet = CoupleManager.dissolveCoupleRide(roleA, roleB);
/* 35 */     return dissolveCoupleRideRet.success();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\PCLeaveRideReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */