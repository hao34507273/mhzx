/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.title.event.AppellationPropertyChangeProcedure;
/*    */ import mzm.gsp.title.main.AppellationPropertyChangeArg;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ 
/*    */ public class POnAppellationPropertyChange extends AppellationPropertyChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     RoleOutFightObj outFightObj = new RoleOutFightObj(((AppellationPropertyChangeArg)this.arg).roleId);
/* 12 */     outFightObj.setAppellationPro(TitleInterface.getNowPropertyMap(((AppellationPropertyChangeArg)this.arg).roleId));
/* 13 */     outFightObj.syncClientRoleProperty();
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnAppellationPropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */