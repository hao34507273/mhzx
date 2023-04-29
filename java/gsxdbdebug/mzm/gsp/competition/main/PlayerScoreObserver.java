/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Competition;
/*    */ import xbean.CompetitionAgainst;
/*    */ import xbean.CompetitionMatch;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class PlayerScoreObserver
/*    */   extends Observer
/*    */ {
/* 19 */   private final boolean[] ret = new boolean[1];
/*    */   
/*    */   public PlayerScoreObserver() {
/* 22 */     super(SCompetitionConsts.getInstance().PlayerScoreMinutes * 60);
/* 23 */     this.ret[0] = true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 29 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 34 */         if (!CompetitionManager.isCompeteStage()) {
/* 35 */           PlayerScoreObserver.this.ret[0] = 0;
/* 36 */           return false;
/*    */         }
/*    */         
/* 39 */         Competition xCompetition = CompetitionManager.getXCompetition(false);
/* 40 */         Iterator<Map.Entry<CompetitionMatch, CompetitionAgainst>> iter = xCompetition.getAgainsts().entrySet().iterator();
/* 41 */         while (iter.hasNext()) {
/* 42 */           Map.Entry<CompetitionMatch, CompetitionAgainst> entry = (Map.Entry)iter.next();
/* 43 */           CompetitionMatch xMatch = (CompetitionMatch)entry.getKey();
/* 44 */           CompetitionAgainst xAgainst = (CompetitionAgainst)entry.getValue();
/* 45 */           if (!xAgainst.getFinished())
/*    */           {
/*    */ 
/* 48 */             NoneRealTimeTaskManager.getInstance().addTask(new PAddPlayerScore(xMatch.getFrontfaction(), xMatch.getBehindfaction()));
/*    */           }
/*    */         }
/*    */         
/* 52 */         return true;
/*    */       }
/*    */       
/* 55 */     });
/* 56 */     return this.ret[0];
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PlayerScoreObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */