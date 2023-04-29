/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.active.event.ActiveArg;
/*    */ import mzm.gsp.active.event.AddActivePointProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.shitu.SynShiTuActiveUpdate;
/*    */ import xtable.Role2shitu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleAddActivePoint
/*    */   extends AddActivePointProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     long masterId = ShiTuManager.getMasterId(Role2shitu.get(Long.valueOf(((ActiveArg)this.arg).roleid)));
/* 19 */     if (masterId > 0L)
/*    */     {
/* 21 */       SynShiTuActiveUpdate syn = new SynShiTuActiveUpdate();
/* 22 */       syn.role_id = ((ActiveArg)this.arg).roleid;
/* 23 */       syn.active_value = ((ActiveArg)this.arg).newPoint;
/* 24 */       OnlineManager.getInstance().send(masterId, syn);
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRoleAddActivePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */