/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.pet.event.PetFightDefenseTeamChangedArg;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnPetFightDefenseTeamChanged extends mzm.gsp.pet.event.PetFightDefenseTeamChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleid = ((PetFightDefenseTeamChangedArg)this.arg).roleId;
/* 13 */     int score = PetInterface.getDefenseTeamScore(roleid);
/* 14 */     PetArenaTeamManager.addTask(new RUpdateScore(roleid, score));
/*    */     
/* 16 */     GameServer.logger().info(String.format("[petarena]POnPetFightDefenseTeamChanged.processImp@to update score|roleid=%d|score=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(score) }));
/*    */     
/*    */ 
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateScore extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleid;
/*    */     private final int score;
/*    */     
/*    */     public RUpdateScore(long roleid, int score)
/*    */     {
/* 29 */       this.roleid = roleid;
/* 30 */       this.score = score;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 36 */       if (!PetArenaTeamManager.getInstance().updateScore(this.roleid, this.score))
/*    */       {
/* 38 */         GameServer.logger().error(String.format("[petarena]RUpdateScore.process@update failed|roleid=%d|score=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.score) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnPetFightDefenseTeamChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */