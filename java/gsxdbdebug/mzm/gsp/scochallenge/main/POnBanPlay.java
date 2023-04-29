/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import mzm.gsp.idip.event.BanPlayArg;
/*    */ import mzm.gsp.idip.event.BanPlayProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class POnBanPlay
/*    */   extends BanPlayProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     if (((BanPlayArg)this.arg).playType == 10)
/*    */     {
/* 15 */       TeamInterface.leaveTeam(((BanPlayArg)this.arg).roleId);
/*    */     }
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnBanPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */