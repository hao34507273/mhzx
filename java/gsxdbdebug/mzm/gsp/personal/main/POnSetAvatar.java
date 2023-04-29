/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.SetAvatarArg;
/*    */ import mzm.gsp.avatar.event.SetAvatarProcedure;
/*    */ import xbean.PersonalInfo;
/*    */ 
/*    */ public class POnSetAvatar extends SetAvatarProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((SetAvatarArg)this.arg).roleId;
/* 12 */     PersonalInfo xPersonalInfo = xtable.Role2personal.get(Long.valueOf(((SetAvatarArg)this.arg).roleId));
/* 13 */     if (xPersonalInfo == null)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     if (xPersonalInfo.getAdverts().isEmpty())
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     int avatarid = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(roleId, false);
/* 23 */     UpdateCacheOneByOne.getInstance().add(new RUpdateHeadImage(((SetAvatarArg)this.arg).roleId, avatarid));
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateHeadImage extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleId;
/*    */     private final int newHeadImage;
/*    */     
/*    */     public RUpdateHeadImage(long roleId, int newHeadImage)
/*    */     {
/* 34 */       this.roleId = roleId;
/* 35 */       this.newHeadImage = newHeadImage;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 41 */       AdvertDataCache.getInstance().roleHeadImageChange(this.roleId, this.newHeadImage);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnSetAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */