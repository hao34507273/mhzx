/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.GetWingEventProcedure;
/*    */ import mzm.gsp.wing.event.GetWingdArg;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ 
/*    */ public class POnGetWingEvent extends GetWingEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((GetWingdArg)this.arg).getRoleid());
/* 12 */     role.setWingPro(WingInterface.getCurWingPlanPros(((GetWingdArg)this.arg).getRoleid(), true));
/* 13 */     role.installPassiveSkill();
/* 14 */     role.syncClientRoleProperty();
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnGetWingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */