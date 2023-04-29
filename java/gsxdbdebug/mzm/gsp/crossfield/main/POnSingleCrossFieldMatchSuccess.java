/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.crossfield.SSynCrossFieldMatchInfo;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchSuccessArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchSuccessProcedure;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ import mzm.gsp.online.main.CrossTokenCheckObserver;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnSingleCrossFieldMatchSuccess
/*    */   extends SingleCrossFieldMatchSuccessProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     long roleid = ((SingleCrossFieldMatchSuccessArg)this.arg).getContext().getRoleid();
/* 24 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 26 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 28 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/*    */ 
/* 31 */     ((SingleCrossFieldMatchSuccessArg)this.arg).getContext().setProcess((byte)1);
/*    */     
/* 33 */     RoleStatusInterface.setStatus(roleid, 41, false);
/*    */     
/* 35 */     CrossFieldManager.unsetMatchStatus(roleid);
/*    */     
/* 37 */     CrossTokenCheckObserver.createCrossTokenCheckObserver(roleid);
/*    */     
/* 39 */     SSynCrossFieldMatchInfo protocol = new SSynCrossFieldMatchInfo();
/* 40 */     protocol.activity_cfg_id = ((SingleCrossFieldMatchSuccessArg)this.arg).getContext().getActivityCfgid();
/* 41 */     protocol.process = 1;
/* 42 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 44 */     CrossFieldManager.logger.info(String.format("[crossfield]POnSingleCrossFieldMatchSuccess.processImp@single cross field match success process|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(((SingleCrossFieldMatchSuccessArg)this.arg).getContext().getActivityCfgid()) }));
/*    */     
/*    */ 
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnSingleCrossFieldMatchSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */