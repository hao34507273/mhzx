/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.pet.main.PetFightInterface;
/*    */ import mzm.gsp.pet.main.PetFightTeam;
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleRename extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleid = ((Long)this.arg).longValue();
/* 15 */     PetFightTeam petFightTeam = PetFightInterface.getPetFightDefenseTeam(roleid, true);
/* 16 */     if (petFightTeam == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     String name = RoleInterface.getName(roleid);
/* 22 */     PetArenaTeamManager.addTask(new RUpdateName(roleid, name));
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateName extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleid;
/*    */     private final String name;
/*    */     
/*    */     public RUpdateName(long roleid, String name)
/*    */     {
/* 33 */       this.roleid = roleid;
/* 34 */       this.name = name;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 40 */       if (!PetArenaTeamManager.getInstance().updateName(this.roleid, this.name))
/*    */       {
/* 42 */         GameServer.logger().error(String.format("[petarena]RUpdateName.process@update failed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */