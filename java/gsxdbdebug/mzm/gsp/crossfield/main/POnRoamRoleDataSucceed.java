/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.crossfield.SSynCrossFieldMatchInfo;
/*    */ import mzm.gsp.crossfield.confbean.SCrossFieldConsts;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedProcedure;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldRoamRoleDataSucceedArg;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ import mzm.gsp.online.main.LoginAssistManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnRoamRoleDataSucceed
/*    */   extends RoamRoleDataSucceedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!(this.arg instanceof SingleCrossFieldRoamRoleDataSucceedArg))
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     SingleCrossFieldRoamRoleDataSucceedArg arg = (SingleCrossFieldRoamRoleDataSucceedArg)this.arg;
/* 29 */     long roleid = arg.getContext().getRoleid();
/* 30 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 32 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 34 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/*    */ 
/* 37 */     arg.getContext().setProcess((byte)3);
/* 38 */     RoleSingleCrossFieldContextManager.getInstance().removeContextid(roleid);
/*    */     
/*    */ 
/* 41 */     long endTimeMills = DateTimeUtils.getCurrTimeInMillis() + SCrossFieldConsts.getInstance().CROSS_SERVER_PROTECT_DURATION_IN_SECOND * 1000;
/*    */     
/* 43 */     LoginAssistManager.getInstance().addProtectUser(userid, endTimeMills);
/*    */     
/* 45 */     SSynCrossFieldMatchInfo protocol = new SSynCrossFieldMatchInfo();
/* 46 */     protocol.activity_cfg_id = arg.getContext().getActivityCfgid();
/* 47 */     protocol.process = 3;
/* 48 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 50 */     CrossFieldManager.logger.info(String.format("[crossfield]POnRoamRoleDataSucceed.processImp@roam role data succeed process|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(arg.getContext().getActivityCfgid()) }));
/*    */     
/*    */ 
/* 53 */     CrossFieldTLogManager.addMatchTLog(roleid, 3, arg.getContext().getActivityCfgid(), arg.getContext().getContextid(), -1L);
/*    */     
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnRoamRoleDataSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */