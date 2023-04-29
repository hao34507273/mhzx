/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedArg;
/*    */ 
/*    */ public class POnAvatarFrameChanged extends mzm.gsp.avatar.event.AvatarFrameChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ShiTuManager.synShiTuRoleInfoChange(((AvatarFrameChangedArg)this.arg).roleId);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnAvatarFrameChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */