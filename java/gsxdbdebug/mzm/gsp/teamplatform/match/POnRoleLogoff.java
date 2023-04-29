/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     MatchActivityCfg matchData = TeamMatchMananger.getRoleActivity(((Long)this.arg).longValue(), false);
/* 18 */     if (matchData == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     if (!TeamMatchMananger.cancelMatch(((Long)this.arg).longValue(), CancelMatchType.LOGOFF_CANCEL))
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */