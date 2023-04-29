/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import xbean.ArenaScore;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArenaInterface
/*    */ {
/*    */   public static int getScore(String userid, long roleid, boolean remainLock)
/*    */   {
/* 20 */     return ArenaManager.getScore(userid, roleid, remainLock);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean setScore(long roleid, int score)
/*    */   {
/* 34 */     ArenaScore xScore = ArenaManager.getXArenaScore(roleid, true);
/* 35 */     return ArenaManager.setScore(roleid, xScore, score);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */