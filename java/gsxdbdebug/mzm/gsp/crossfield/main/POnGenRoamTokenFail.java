/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.crossfield.SSynCrossFieldMatchFail;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenFailProcedure;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldGenRoamTokenFailArg;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnGenRoamTokenFail
/*    */   extends GenRoamTokenFailProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!(this.arg instanceof SingleCrossFieldGenRoamTokenFailArg))
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     SingleCrossFieldGenRoamTokenFailArg arg = (SingleCrossFieldGenRoamTokenFailArg)this.arg;
/* 27 */     long roleid = arg.getContext().getRoleid();
/* 28 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 30 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 32 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/* 34 */     RoleStatusInterface.unsetStatus(roleid, 41);
/* 35 */     RoleSingleCrossFieldContextManager.getInstance().removeContextid(roleid);
/*    */     
/* 37 */     SSynCrossFieldMatchFail protocol = new SSynCrossFieldMatchFail();
/* 38 */     protocol.res = 1;
/* 39 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 41 */     CrossFieldManager.logger.info(String.format("[crossfield]POnGenRoamTokenFail.processImp@gen token fail process|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(arg.getContext().getActivityCfgid()) }));
/*    */     
/*    */ 
/* 44 */     CrossFieldTLogManager.addMatchTLog(roleid, 2, arg.getContext().getActivityCfgid(), arg.getContext().getContextid(), 2L);
/*    */     
/*    */ 
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnGenRoamTokenFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */