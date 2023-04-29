/*    */ package mzm.gsp.chess.event;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ChessGameBeginArg
/*    */ {
/*  8 */   private final List<Long> roleIds = new LinkedList();
/*    */   
/*    */   public ChessGameBeginArg(long roleIdA, long roleIdB)
/*    */   {
/* 12 */     this.roleIds.add(Long.valueOf(roleIdA));
/* 13 */     this.roleIds.add(Long.valueOf(roleIdB));
/*    */   }
/*    */   
/*    */   public List<Long> getRoleIds()
/*    */   {
/* 18 */     return this.roleIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\event\ChessGameBeginArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */