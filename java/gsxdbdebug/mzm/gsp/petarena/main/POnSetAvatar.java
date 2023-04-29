/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.avatar.event.SetAvatarArg;
/*    */ import mzm.gsp.avatar.event.SetAvatarProcedure;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import mzm.gsp.pet.main.PetFightTeam;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnSetAvatar extends SetAvatarProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleid = ((SetAvatarArg)this.arg).roleId;
/* 15 */     PetFightTeam petFightTeam = mzm.gsp.pet.main.PetFightInterface.getPetFightDefenseTeam(roleid, true);
/* 16 */     if (petFightTeam == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     int newAvatar = AvatarInterface.getCurrentAvatar(roleid, true);
/* 22 */     PetArenaTeamManager.addTask(new RUpdateAvatar(roleid, newAvatar));
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateAvatar extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleid;
/*    */     private final int avatar;
/*    */     
/*    */     public RUpdateAvatar(long roleid, int avatar)
/*    */     {
/* 33 */       this.roleid = roleid;
/* 34 */       this.avatar = avatar;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 40 */       if (!PetArenaTeamManager.getInstance().updateAvatar(this.roleid, this.avatar))
/*    */       {
/* 42 */         GameServer.logger().error(String.format("[petarena]RUpdateAvatar.process@update failed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnSetAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */