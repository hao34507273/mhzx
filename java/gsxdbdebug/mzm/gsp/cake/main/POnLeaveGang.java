/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnLeaveGang
/*    */   extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     for (Iterator i$ = SCakeActivityCfg.getAll().values().iterator(); i$.hasNext();) { cfg = (SCakeActivityCfg)i$.next();
/*    */       
/* 21 */       for (i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 23 */         removeCakeState(roleId, cfg.stateId); } }
/*    */     SCakeActivityCfg cfg;
/*    */     Iterator i$;
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   void removeCakeState(final long roleId, int status)
/*    */   {
/* 31 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 37 */         return RoleStatusInterface.unsetStatus(roleId, this.val$status);
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\POnLeaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */