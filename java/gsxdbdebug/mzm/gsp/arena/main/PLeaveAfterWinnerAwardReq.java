/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Arena;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PLeaveAfterWinnerAwardReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PLeaveAfterWinnerAwardReq(long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     Arena xArena = ArenaManager.getXArena(false);
/* 21 */     if (xArena == null) {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     if (!xArena.getFinished()) {
/* 26 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 30 */     if (ArenaManager.isInArenaWorld(this.roleid)) {
/* 31 */       ArenaManager.leaveActivityWorld(this.roleid);
/*    */     }
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PLeaveAfterWinnerAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */