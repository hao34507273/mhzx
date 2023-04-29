/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.PrisonInfo;
/*    */ import xtable.Role2prisoninfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleOutOfJailSession
/*    */   extends Session
/*    */ {
/*    */   public RoleOutOfJailSession(long interval, long roleId)
/*    */   {
/* 25 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 31 */     new RoleOutOfJailProc().execute();
/*    */   }
/*    */   
/*    */   class RoleOutOfJailProc extends LogicProcedure
/*    */   {
/*    */     RoleOutOfJailProc() {}
/*    */     
/*    */     protected boolean processImp() throws Exception {
/* 39 */       long roleId = RoleOutOfJailSession.this.getOwerId();
/* 40 */       PrisonInfo xPrisonInfo = Role2prisoninfo.get(Long.valueOf(roleId));
/* 41 */       RoleJailStat roleJailStat = PrisonInterface.checkCanLetRoleOutOfJail(roleId, xPrisonInfo);
/* 42 */       if (roleJailStat.canGetOutOfJail)
/*    */       {
/* 44 */         PrisonInterface.letRoleOutOfJail(roleId, SPKConsts.getInstance().JAIL_OUT_MAIL_ID, new ArrayList(), new ArrayList(), new TLogArg(LogReason.JAIL_OUT_MAIL));
/*    */       }
/*    */       
/* 47 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\RoleOutOfJailSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */