/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.arena.SArenaTitle;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.Arena;
/*    */ import xbean.ArenaScore;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (!ArenaManager.isInArenaWorld(((Long)this.arg).longValue()))
/*    */     {
/* 18 */       RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 8);
/*    */     }
/*    */     else {
/* 21 */       Arena xArena = ArenaManager.getXArena(false);
/* 22 */       if (xArena == null) {
/* 23 */         return false;
/*    */       }
/*    */       
/* 26 */       if (xArena.getFinished())
/*    */       {
/* 28 */         ArenaManager.leaveActivityWorld(((Long)this.arg).longValue());
/*    */       }
/*    */       else
/*    */       {
/* 32 */         ArenaManager.syncStage(((Long)this.arg).longValue());
/*    */         
/* 34 */         ArenaScore xScore = Arenascore.select((Long)this.arg);
/*    */         
/* 36 */         ArenaManager.syncRoleScore(((Long)this.arg).longValue(), xScore);
/*    */         
/* 38 */         ArenaManager.syncGetWinTimesAward(((Long)this.arg).longValue(), xScore);
/*    */         
/*    */ 
/* 41 */         MapInterface.setModelProtocol(((Long)this.arg).longValue(), new SArenaTitle(xScore.getCamp()));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */