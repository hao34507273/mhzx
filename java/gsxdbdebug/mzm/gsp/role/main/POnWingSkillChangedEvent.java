/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.WingSkillChangedArg;
/*    */ import mzm.gsp.wing.event.WingSkillChangedEventProcedure;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ 
/*    */ public class POnWingSkillChangedEvent
/*    */   extends WingSkillChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((WingSkillChangedArg)this.arg).getRoleid());
/* 13 */     role.setWingPro(WingInterface.getCurWingPlanPros(((WingSkillChangedArg)this.arg).getRoleid(), true));
/* 14 */     role.installPassiveSkill();
/* 15 */     role.syncClientRoleProperty();
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnWingSkillChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */