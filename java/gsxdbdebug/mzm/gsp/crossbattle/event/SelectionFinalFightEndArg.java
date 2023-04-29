/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SelectionFinalFightEndArg
/*    */ {
/*    */   public final int session;
/*    */   public final long corpsId;
/*    */   public final List<Long> roleIdList;
/*    */   public final int fightType;
/*    */   public final boolean isWin;
/*    */   public final int rank;
/*    */   
/*    */   public SelectionFinalFightEndArg(long corpsId, List<Long> roleIdList, int fightType, boolean isWin, int rank)
/*    */   {
/* 20 */     this.session = 0;
/* 21 */     this.corpsId = corpsId;
/* 22 */     this.roleIdList = roleIdList;
/* 23 */     this.fightType = fightType;
/* 24 */     this.isWin = isWin;
/* 25 */     this.rank = rank;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\SelectionFinalFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */