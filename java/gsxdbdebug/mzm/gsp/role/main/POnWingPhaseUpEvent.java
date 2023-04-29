/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.WingPhaseUpArg;
/*    */ import mzm.gsp.wing.event.WingPhaseUpEventProcedure;
/*    */ 
/*    */ public class POnWingPhaseUpEvent extends WingPhaseUpEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((WingPhaseUpArg)this.arg).getRoleid());
/* 11 */     role.setWingPro(mzm.gsp.wing.main2.WingInterface.getCurWingPlanPros(((WingPhaseUpArg)this.arg).getRoleid(), true));
/* 12 */     role.installPassiveSkill();
/* 13 */     role.syncClientRoleProperty();
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnWingPhaseUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */