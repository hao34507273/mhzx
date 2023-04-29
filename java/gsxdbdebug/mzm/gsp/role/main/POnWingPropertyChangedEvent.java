/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.WingPropertyChangedArg;
/*    */ import mzm.gsp.wing.event.WingPropertyChangedEventProcedure;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ 
/*    */ public class POnWingPropertyChangedEvent
/*    */   extends WingPropertyChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((WingPropertyChangedArg)this.arg).getRoleid());
/* 13 */     role.setWingPro(WingInterface.getCurWingPlanPros(((WingPropertyChangedArg)this.arg).getRoleid(), true));
/* 14 */     role.installPassiveSkill();
/* 15 */     role.syncClientRoleProperty();
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnWingPropertyChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */