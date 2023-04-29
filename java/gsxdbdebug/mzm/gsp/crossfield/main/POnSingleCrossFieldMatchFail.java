/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.crossfield.SSynCrossFieldMatchFail;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFailArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFailProcedure;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnSingleCrossFieldMatchFail
/*    */   extends SingleCrossFieldMatchFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleid = ((SingleCrossFieldMatchFailArg)this.arg).getContext().getRoleid();
/* 20 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 22 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 24 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/* 26 */     CrossFieldManager.unsetMatchStatus(roleid);
/* 27 */     RoleSingleCrossFieldContextManager.getInstance().removeContextid(roleid);
/*    */     
/* 29 */     SSynCrossFieldMatchFail protocol = new SSynCrossFieldMatchFail();
/* 30 */     protocol.res = 0;
/* 31 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 33 */     CrossFieldManager.logger.info(String.format("[crossfield]POnSingleCrossFieldMatchFail.processImp@single cross field match fail process|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(((SingleCrossFieldMatchFailArg)this.arg).getContext().getActivityCfgid()) }));
/*    */     
/*    */ 
/* 36 */     CrossFieldTLogManager.addMatchTLog(roleid, 2, ((SingleCrossFieldMatchFailArg)this.arg).getContext().getActivityCfgid(), ((SingleCrossFieldMatchFailArg)this.arg).getContext().getContextid(), 1L);
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnSingleCrossFieldMatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */