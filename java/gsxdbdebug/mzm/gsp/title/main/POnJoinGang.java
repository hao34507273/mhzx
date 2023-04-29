/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.JoinGangProcedure;
/*    */ 
/*    */ public class POnJoinGang
/*    */   extends JoinGangProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     return new PGangMemberAppellationChange(((GangArg)this.arg).roleId, ((GangArg)this.arg).gangId, TitleManager.getGangAppId()).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */