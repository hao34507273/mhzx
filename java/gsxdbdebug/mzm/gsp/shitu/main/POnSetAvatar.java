/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.SetAvatarArg;
/*    */ 
/*    */ public class POnSetAvatar extends mzm.gsp.avatar.event.SetAvatarProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ShiTuManager.synShiTuRoleInfoChange(((SetAvatarArg)this.arg).roleId);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnSetAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */