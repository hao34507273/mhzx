/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ObserveFight;
/*    */ 
/*    */ public class PCObserveFightWithLeader extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCObserveFightWithLeader(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long leaderid = mzm.gsp.team.main.TeamInterface.getTeamLeaderByRoleid(this.roleid, false, false);
/* 19 */     if (leaderid < 0L) {
/* 20 */       if (GameServer.logger().isDebugEnabled())
/* 21 */         GameServer.logger().debug("玩家不再队伍中!!");
/* 22 */       return false;
/*    */     }
/* 24 */     if ((leaderid == this.roleid) && 
/* 25 */       (GameServer.logger().isDebugEnabled())) {
/* 26 */       GameServer.logger().debug("玩家就是队长!!!");
/*    */     }
/* 28 */     ObserveFight xObserveFight = xtable.Role2observefight.select(Long.valueOf(leaderid));
/*    */     
/* 30 */     long beobservedRoleid = -1L;
/*    */     
/* 32 */     if (xObserveFight == null)
/*    */     {
/* 34 */       beobservedRoleid = leaderid;
/*    */     } else {
/* 36 */       int observeType = xObserveFight.getObservetype();
/* 37 */       switch (observeType) {
/*    */       case 0: 
/* 39 */         beobservedRoleid = xObserveFight.getObservevalue();
/* 40 */         break;
/*    */       case 1: 
/* 42 */         mzm.gsp.map.main.MapInterface.observeMonsterFight(this.roleid, (int)xObserveFight.getObservevalue());
/* 43 */         return true;
/*    */       
/*    */       default: 
/* 46 */         GameServer.logger().error(String.format("[Fight]PCObserveFightWithLeader.processImp@donot exist observe type|type=%d|roleid=%d|leaderid=%d", new Object[] { Integer.valueOf(observeType), Long.valueOf(this.roleid), Long.valueOf(leaderid) }));
/*    */         
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 53 */         return false;
/*    */       }
/*    */       
/*    */     }
/* 57 */     FightManager.reqObserveFight(this.roleid, beobservedRoleid);
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCObserveFightWithLeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */