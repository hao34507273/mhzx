/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import mzm.gsp.award.event.MultiRoleSelectArg;
/*    */ 
/*    */ public class POnFinishFanpaiEvent extends mzm.gsp.award.event.MultiRoleSelectAwardEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if ((((MultiRoleSelectArg)this.arg).context instanceof ParaseleneLiheContext))
/*    */     {
/* 11 */       ParaseleneLiheContext context = (ParaseleneLiheContext)((MultiRoleSelectArg)this.arg).context;
/*    */       
/* 13 */       ParaseleneManager.transferToNextLayer(((MultiRoleSelectArg)this.arg).allRoles, context.layer);
/*    */     }
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\POnFinishFanpaiEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */