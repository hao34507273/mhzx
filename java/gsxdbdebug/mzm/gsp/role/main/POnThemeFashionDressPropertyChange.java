/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChangeArg;
/*    */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChangeProcedure;
/*    */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnThemeFashionDressPropertyChange
/*    */   extends ThemeFashionDressPropertyChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((ThemeFashionDressPropertyChangeArg)this.arg).roleId);
/* 17 */     role.setFationPro(FashionDressInterface.getThemeFashionDressRoleProperty(((ThemeFashionDressPropertyChangeArg)this.arg).roleId, true));
/* 18 */     role.installPassiveSkill();
/* 19 */     role.syncClientRoleProperty();
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnThemeFashionDressPropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */