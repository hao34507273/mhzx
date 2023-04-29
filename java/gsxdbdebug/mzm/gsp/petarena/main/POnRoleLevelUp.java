/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.pet.main.PetFightInterface;
/*    */ import mzm.gsp.pet.main.PetFightTeam;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/* 14 */     PetFightTeam petFightTeam = PetFightInterface.getPetFightDefenseTeam(roleid, true);
/* 15 */     if (petFightTeam == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     int level = ((RoleLevelUpArg)this.arg).newLevel;
/* 21 */     PetArenaTeamManager.addTask(new RUpdateLevel(roleid, level));
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateLevel extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleid;
/*    */     private final int level;
/*    */     
/*    */     public RUpdateLevel(long roleid, int level)
/*    */     {
/* 32 */       this.roleid = roleid;
/* 33 */       this.level = level;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 39 */       if (!PetArenaTeamManager.getInstance().updateLevel(this.roleid, this.level))
/*    */       {
/* 41 */         GameServer.logger().error(String.format("[petarena]RUpdateLevel.process@update failed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */