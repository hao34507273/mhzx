/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillGangRobberProcedure;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillRobberArg;
/*    */ 
/*    */ public class POnKillGangRobber extends KillGangRobberProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     lock(xtable.Role2properties.getTable(), ((KillRobberArg)this.arg).roleIds);
/* 14 */     for (Iterator i$ = ((KillRobberArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 16 */       RoleVigorManager.getInstance().awardAward(roleId, 6, new TLogArg(mzm.gsp.tlog.LogReason.VIGOR_ADD__GANGROBBER, 0));
/*    */     }
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnKillGangRobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */