/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.WingExpChangedArg;
/*    */ import mzm.gsp.wing.event.WingExpChangedEventProcedure;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ 
/*    */ public class POnWingExpChangedEvent extends WingExpChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (!((WingExpChangedArg)this.arg).lvUp())
/*    */     {
/*    */ 
/* 14 */       return false;
/*    */     }
/* 16 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((WingExpChangedArg)this.arg).getRoleId());
/* 17 */     role.setWingPro(WingInterface.getCurWingPlanPros(((WingExpChangedArg)this.arg).getRoleId(), true));
/* 18 */     role.installPassiveSkill();
/* 19 */     role.syncClientRoleProperty();
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnWingExpChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */