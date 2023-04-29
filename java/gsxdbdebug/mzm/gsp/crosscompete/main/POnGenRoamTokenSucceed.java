/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.CrossCompeteGenRoamTokenSucceedArg;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenSucceedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGenRoamTokenSucceed
/*    */   extends GenRoamTokenSucceedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     if (!(this.arg instanceof CrossCompeteGenRoamTokenSucceedArg)) {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     CrossCompeteGenRoamTokenSucceedArg succeedArg = (CrossCompeteGenRoamTokenSucceedArg)this.arg;
/*    */     
/* 20 */     CrossCompeteManager.logInfo("POnGenRoamTokenSucceed.processImp@gen roam token succeed|factionid=%d|roles=%s|roam_serverid=%d", new Object[] { Long.valueOf(succeedArg.context.factionid), succeedArg.context.getRoleidList(), Integer.valueOf(succeedArg.context.roamServerid) });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnGenRoamTokenSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */