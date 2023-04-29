/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.crossfield.SCancelCrossFieldMatchSuccess;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchSuccessArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchSuccessProcedure;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnSingleCrossFieldCancelMatchSuccess
/*    */   extends SingleCrossFieldCancelMatchSuccessProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long roleid = ((SingleCrossFieldCancelMatchSuccessArg)this.arg).getContext().getRoleid();
/* 21 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 23 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 25 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/* 27 */     CrossFieldManager.unsetMatchStatus(roleid);
/* 28 */     RoleSingleCrossFieldContextManager.getInstance().removeContextid(roleid);
/*    */     
/* 30 */     SCancelCrossFieldMatchSuccess protocol = new SCancelCrossFieldMatchSuccess();
/* 31 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 33 */     CrossFieldManager.logger.info(String.format("[crossfield]POnSingleCrossFieldCancelMatchSuccess.processImp@single cross field cancel match success process|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(((SingleCrossFieldCancelMatchSuccessArg)this.arg).getContext().getActivityCfgid()) }));
/*    */     
/*    */ 
/* 36 */     CrossFieldTLogManager.addMatchTLog(roleid, 6, ((SingleCrossFieldCancelMatchSuccessArg)this.arg).getContext().getActivityCfgid(), ((SingleCrossFieldCancelMatchSuccessArg)this.arg).getContext().getContextid(), -1L);
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnSingleCrossFieldCancelMatchSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */