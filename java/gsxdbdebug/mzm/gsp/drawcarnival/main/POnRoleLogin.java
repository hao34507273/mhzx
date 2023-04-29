/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     DrawCarnivalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID), new PSynDrawInfo(((Long)this.arg).longValue()));
/*    */     
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */