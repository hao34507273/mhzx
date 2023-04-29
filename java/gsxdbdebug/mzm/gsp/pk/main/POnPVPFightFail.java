/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVPFightFailArg;
/*    */ import mzm.gsp.fight.event.PVPFightFailProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.SStartPKFail;
/*    */ 
/*    */ public class POnPVPFightFail
/*    */   extends PVPFightFailProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     if (!(((PVPFightFailArg)this.arg).context instanceof PKFightContext))
/* 15 */       return false;
/* 16 */     PKFightContext context = (PKFightContext)((PVPFightFailArg)this.arg).context;
/* 17 */     SStartPKFail sStartPKFail = new SStartPKFail();
/* 18 */     sStartPKFail.retcode = -1;
/* 19 */     sStartPKFail.role_type = -1;
/* 20 */     OnlineManager.getInstance().sendMulti(sStartPKFail, ((PVPFightFailArg)this.arg).activeRoles);
/* 21 */     PKLogManager.error(String.format("POnPVPFightFail.processImp()@fail|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(context.mainActiveRoleId), Long.valueOf(context.mainTargetRoleId) }));
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\POnPVPFightFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */