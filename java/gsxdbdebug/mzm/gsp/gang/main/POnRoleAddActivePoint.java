/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.active.event.ActiveArg;
/*    */ import mzm.gsp.active.event.AddActivePointProcedure;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import xbean.Gang;
/*    */ 
/*    */ public class POnRoleAddActivePoint
/*    */   extends AddActivePointProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     if ((((ActiveArg)this.arg).oldPoint < SGangConst.getInstance().ACTIVE_MEMBER_NEED_ACTIVE_POINT) && (((ActiveArg)this.arg).newPoint >= SGangConst.getInstance().ACTIVE_MEMBER_NEED_ACTIVE_POINT))
/*    */     {
/*    */ 
/* 17 */       Gang xGang = GangManager.getXGangByRoleid(((ActiveArg)this.arg).roleid, true);
/* 18 */       if (xGang == null) {
/* 19 */         return true;
/*    */       }
/*    */       
/* 22 */       GangManager.increaseActiveMemberNumber(xGang);
/*    */     }
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnRoleAddActivePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */