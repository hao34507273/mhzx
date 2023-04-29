/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.JoinGangProcedure;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteSignUp;
/*    */ 
/*    */ public class POnJoinGang
/*    */   extends JoinGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     Gang faction = GangInterface.getGang(((GangArg)this.arg).gangId, false);
/* 17 */     if (faction == null) {
/* 18 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 23 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 24 */     if (xCompete != null) {
/* 25 */       CrossCompeteSignUp xSignUp = (CrossCompeteSignUp)xCompete.getSignup_factions().get(Long.valueOf(((GangArg)this.arg).gangId));
/* 26 */       if (xSignUp != null) {
/* 27 */         CrossCompeteManager.syncSignUp(((GangArg)this.arg).roleId);
/*    */       }
/*    */     }
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */