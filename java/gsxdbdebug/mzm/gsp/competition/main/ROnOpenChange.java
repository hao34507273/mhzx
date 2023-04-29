/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.competition.confbean.SCompetitionMercenaryConsts;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import xbean.Competition;
/*    */ import xbean.CompetitionAgainst;
/*    */ import xbean.CompetitionMatch;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xtable.Faction_competition_tmp;
/*    */ 
/*    */ public class ROnOpenChange extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 23 */     if (((OpenChangeComplexArg)this.arg).getType() == 219) {
/* 24 */       if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */       {
/* 26 */         new RUpdateMercenary().process();
/*    */       }
/*    */       else
/*    */       {
/* 30 */         onCloseMercenary();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private void onCloseMercenary()
/*    */   {
/* 38 */     int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/* 39 */     if ((stage < 1) || (stage >= 4)) {
/* 40 */       return;
/*    */     }
/*    */     
/*    */ 
/* 44 */     Competition xCompetition = CompetitionManager.getXCompetition(false);
/* 45 */     if (xCompetition == null) {
/* 46 */       return;
/*    */     }
/*    */     
/* 49 */     Iterator<Map.Entry<CompetitionMatch, CompetitionAgainst>> iter = xCompetition.getAgainsts().entrySet().iterator();
/*    */     
/*    */ 
/* 52 */     while (iter.hasNext()) {
/* 53 */       Map.Entry<CompetitionMatch, CompetitionAgainst> entry = (Map.Entry)iter.next();
/* 54 */       CompetitionMatch cMatch = (CompetitionMatch)entry.getKey();
/* 55 */       CompetitionAgainst xAgainst = (CompetitionAgainst)entry.getValue();
/*    */       
/* 57 */       if (!xAgainst.getFinished())
/*    */       {
/*    */ 
/*    */ 
/* 61 */         long factionid = cMatch.getFrontfaction();
/*    */         
/* 63 */         FactionCompetitionTmp xFC = Faction_competition_tmp.select(Long.valueOf(factionid));
/* 64 */         if (xFC != null)
/*    */         {
/*    */ 
/* 67 */           long world = xFC.getWorld();
/* 68 */           ControllerInterface.collectWorldController(world, SCompetitionMercenaryConsts.getInstance().MercenaryController);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */