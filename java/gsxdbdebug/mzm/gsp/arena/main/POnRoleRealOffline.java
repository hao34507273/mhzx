/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.ArenaScore;
/*    */ import xbean.ArenaTmp;
/*    */ 
/*    */ 
/*    */ public class POnRoleRealOffline
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmp(false);
/* 16 */     if (xArenaTmp == null) {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     if (MapInterface.getRoleWorldInstanceId(((Long)this.arg).longValue()) != xArenaTmp.getWorld()) {
/* 21 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 25 */     ArenaScore xScore = ArenaManager.getXArenaScoreIfNotExist(((Long)this.arg).longValue());
/* 26 */     xScore.setParticipated(true);
/*    */     
/* 28 */     ArenaManager.leaveActivityWorldAndCheckActivityEnd(((Long)this.arg).longValue());
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\POnRoleRealOffline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */