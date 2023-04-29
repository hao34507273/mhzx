/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedArg;
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedProcedure;
/*    */ import mzm.gsp.pet.main.PetFightTeam;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnAvatarFrameChanged extends AvatarFrameChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((AvatarFrameChangedArg)this.arg).roleId;
/* 14 */     PetFightTeam petFightTeam = mzm.gsp.pet.main.PetFightInterface.getPetFightDefenseTeam(roleid, true);
/* 15 */     if (petFightTeam == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     int avatarFrame = ((AvatarFrameChangedArg)this.arg).avatarFrameId;
/* 21 */     PetArenaTeamManager.addTask(new RUpdateAvatarFrame(roleid, avatarFrame));
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateAvatarFrame extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleid;
/*    */     private final int avatarFrame;
/*    */     
/*    */     public RUpdateAvatarFrame(long roleid, int avatarFrame)
/*    */     {
/* 32 */       this.roleid = roleid;
/* 33 */       this.avatarFrame = avatarFrame;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 39 */       if (!PetArenaTeamManager.getInstance().updateAvatarFrame(this.roleid, this.avatarFrame))
/*    */       {
/* 41 */         GameServer.logger().error(String.format("[petarena]RUpdateAvatarFrame.process@update failed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnAvatarFrameChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */