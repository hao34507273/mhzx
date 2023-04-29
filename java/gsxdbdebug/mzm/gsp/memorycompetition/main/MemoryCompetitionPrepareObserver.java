/*    */ package mzm.gsp.memorycompetition.main;
/*    */ 
/*    */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import xbean.MemoryCompetitionInfo;
/*    */ 
/*    */ public class MemoryCompetitionPrepareObserver extends MilliObserver
/*    */ {
/*    */   private final long memoryCompetitionId;
/*    */   private final long begineTime;
/*    */   
/*    */   public MemoryCompetitionPrepareObserver(long intervalMilliSeconds, long memoryCompetitionId, long beginTime)
/*    */   {
/* 14 */     super(intervalMilliSeconds);
/* 15 */     this.memoryCompetitionId = memoryCompetitionId;
/* 16 */     this.begineTime = beginTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 22 */     new PMemoryCompetitionObserver(this.memoryCompetitionId).execute();
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   public long getBegineTime()
/*    */   {
/* 28 */     return this.begineTime;
/*    */   }
/*    */   
/*    */   private static class PMemoryCompetitionObserver extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long memoryCompetitionId;
/*    */     
/*    */     public PMemoryCompetitionObserver(long memoryCompetitionId)
/*    */     {
/* 37 */       this.memoryCompetitionId = memoryCompetitionId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 43 */       MemoryCompetitionInfo xMemoryCompetitionInfo = xtable.Memorycompetition.get(Long.valueOf(this.memoryCompetitionId));
/* 44 */       if (xMemoryCompetitionInfo == null)
/*    */       {
/* 46 */         return false;
/*    */       }
/*    */       
/* 49 */       SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(xMemoryCompetitionInfo.getMemory_competition_cfg_id());
/* 50 */       if (competitionCfg == null)
/*    */       {
/* 52 */         return false;
/*    */       }
/*    */       
/* 55 */       MemoryCompetitionManager.startQuestion(this.memoryCompetitionId, xMemoryCompetitionInfo, competitionCfg);
/*    */       
/* 57 */       xMemoryCompetitionInfo.setRoles_current_prepare_question_observer(null);
/* 58 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\MemoryCompetitionPrepareObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */