/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedArg;
/*    */ import xbean.PersonalInfo;
/*    */ 
/*    */ public class POnAvatarFrameChanged extends mzm.gsp.avatar.event.AvatarFrameChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((AvatarFrameChangedArg)this.arg).roleId;
/* 11 */     PersonalInfo xPersonalInfo = xtable.Role2personal.get(Long.valueOf(roleid));
/* 12 */     if (xPersonalInfo == null)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     if (xPersonalInfo.getAdverts().isEmpty())
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     UpdateCacheOneByOne.getInstance().add(new RUpdateAvatarFrame(roleid, ((AvatarFrameChangedArg)this.arg).avatarFrameId));
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateAvatarFrame extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleid;
/*    */     private final int avatarFrameId;
/*    */     
/*    */     public RUpdateAvatarFrame(long roleid, int avatarFrameId)
/*    */     {
/* 32 */       this.roleid = roleid;
/* 33 */       this.avatarFrameId = avatarFrameId;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 39 */       AdvertDataCache.getInstance().roleAvatarFrameChange(this.roleid, this.avatarFrameId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnAvatarFrameChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */