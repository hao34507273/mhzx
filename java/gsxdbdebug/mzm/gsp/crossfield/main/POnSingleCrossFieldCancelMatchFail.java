/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.crossfield.SCancelCrossFieldMatchFail;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchFailArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchFailProcedure;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class POnSingleCrossFieldCancelMatchFail
/*    */   extends SingleCrossFieldCancelMatchFailProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long roleid = ((SingleCrossFieldCancelMatchFailArg)this.arg).getContext().getRoleid();
/*    */     
/* 19 */     SCancelCrossFieldMatchFail protocol = new SCancelCrossFieldMatchFail();
/* 20 */     protocol.res = 0;
/* 21 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 23 */     CrossFieldManager.logger.info(String.format("[crossfield]POnSingleCrossFieldCancelMatchFail.processImp@single cross field cancel match fail process|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(((SingleCrossFieldCancelMatchFailArg)this.arg).getContext().getActivityCfgid()) }));
/*    */     
/*    */ 
/* 26 */     CrossFieldTLogManager.addMatchTLog(roleid, 5, ((SingleCrossFieldCancelMatchFailArg)this.arg).getContext().getActivityCfgid(), ((SingleCrossFieldCancelMatchFailArg)this.arg).getContext().getContextid(), 1L);
/*    */     
/*    */ 
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnSingleCrossFieldCancelMatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */