/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.server.event.ServerLevelUpRunnable;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class ROnServerLevelUp extends ServerLevelUpRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     PetArenaTeamManager.addTask(new RUdpateAllRobotPetTeam(null));
/*    */   }
/*    */   
/*    */   private static class RUdpateAllRobotPetTeam
/*    */     extends LogicRunnable
/*    */   {
/*    */     public void process() throws Exception
/*    */     {
/* 18 */       PetArenaTeamManager.getInstance().updateAllRobotTeamInfo();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\ROnServerLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */