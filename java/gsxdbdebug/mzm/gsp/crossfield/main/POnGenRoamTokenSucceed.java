/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.crossfield.SSynCrossFieldMatchInfo;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenSucceedProcedure;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldGenRoamTokenSucceedArg;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGenRoamTokenSucceed
/*    */   extends GenRoamTokenSucceedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!(this.arg instanceof SingleCrossFieldGenRoamTokenSucceedArg))
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     SingleCrossFieldGenRoamTokenSucceedArg arg = (SingleCrossFieldGenRoamTokenSucceedArg)this.arg;
/* 23 */     long roleid = arg.getContext().getRoleid();
/*    */     
/*    */ 
/* 26 */     arg.getContext().setProcess((byte)2);
/*    */     
/* 28 */     SSynCrossFieldMatchInfo protocol = new SSynCrossFieldMatchInfo();
/* 29 */     protocol.activity_cfg_id = arg.getContext().getActivityCfgid();
/* 30 */     protocol.process = 2;
/* 31 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 33 */     CrossFieldManager.logger.info(String.format("[crossfield]POnGenRoamTokenSucceed.processImp@gen token succeed process|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(arg.getContext().getActivityCfgid()) }));
/*    */     
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnGenRoamTokenSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */