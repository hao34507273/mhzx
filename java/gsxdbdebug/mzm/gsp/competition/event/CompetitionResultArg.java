/*    */ package mzm.gsp.competition.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CompetitionResultArg
/*    */ {
/*    */   public final long factionid1;
/* 11 */   public final List<Long> members1 = new ArrayList();
/*    */   
/*    */   public final long factionid2;
/* 14 */   public final List<Long> members2 = new ArrayList();
/*    */   
/*    */   public final int result;
/*    */   
/*    */   public CompetitionResultArg(long factionid1, List<Long> members1, long factionid2, List<Long> members2, int result)
/*    */   {
/* 20 */     this.factionid1 = factionid1;
/* 21 */     this.members1.addAll(members1);
/* 22 */     this.factionid2 = factionid2;
/* 23 */     this.members2.addAll(members2);
/* 24 */     this.result = result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isFaction1Winner()
/*    */   {
/* 32 */     if ((this.result == 3) || (this.result == 4))
/*    */     {
/* 34 */       return true;
/*    */     }
/* 36 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isFaction2Winner()
/*    */   {
/* 44 */     if ((this.result == 2) || (this.result == 5))
/*    */     {
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\event\CompetitionResultArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */