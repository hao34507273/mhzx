/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateArg;
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateRemoveProcedure;
/*    */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnChangeModelCardStateRemove
/*    */   extends ChangeModelCardStateRemoveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((ChangeModelCardStateArg)this.arg).roleId);
/* 19 */     role.setBianShenCardPro(ChangeModelCardInterface.getCurChangeModelCardProp(((ChangeModelCardStateArg)this.arg).roleId, true));
/* 20 */     role.syncClientRoleProperty();
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnChangeModelCardStateRemove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */