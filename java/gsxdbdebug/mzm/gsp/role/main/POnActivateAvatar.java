/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.ActivateAvatarArg;
/*    */ import mzm.gsp.avatar.event.ActivateAvatarProcedure;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnActivateAvatar
/*    */   extends ActivateAvatarProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     RoleOutFightObj outFightObj = new RoleOutFightObj(((ActivateAvatarArg)this.arg).roleId);
/* 18 */     outFightObj.setAvatarPro(AvatarInterface.getRoleAvatarProperties(((ActivateAvatarArg)this.arg).roleId));
/* 19 */     outFightObj.syncClientRoleProperty();
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnActivateAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */