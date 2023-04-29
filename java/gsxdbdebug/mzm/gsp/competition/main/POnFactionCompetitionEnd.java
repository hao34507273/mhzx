/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.FactionCompetition;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xtable.Faction_competition;
/*    */ import xtable.Faction_competition_tmp;
/*    */ 
/*    */ class POnFactionCompetitionEnd extends LogicProcedure
/*    */ {
/*    */   private final long factionid;
/*    */   
/*    */   POnFactionCompetitionEnd(long factionid)
/*    */   {
/* 21 */     this.factionid = factionid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     FactionCompetitionTmp xFCTmp = Faction_competition_tmp.get(Long.valueOf(this.factionid));
/* 28 */     if (xFCTmp == null) {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     final long world = xFCTmp.getWorld();
/*    */     
/*    */ 
/* 36 */     Faction_competition_tmp.delete(Long.valueOf(this.factionid));
/*    */     
/*    */ 
/* 39 */     FactionCompetition xFC = Faction_competition.get(Long.valueOf(this.factionid));
/* 40 */     CompetitionManager.initXFactionCompetition(xFC);
/*    */     
/*    */ 
/* 43 */     List<Long> roles = MapInterface.getRoleList(world);
/*    */     
/* 45 */     Gang faction = GangInterface.getGang(this.factionid, true);
/* 46 */     Iterator i$; if (faction != null) {
/* 47 */       for (i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 48 */         if (faction.isInGang(r)) {
/* 49 */           CompetitionManager.leaveNoneRealTime(r, this.factionid);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 55 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 59 */         CompetitionManager.destroyWorld(world);
/*    */         
/* 61 */         return true;
/*    */       }
/*    */       
/* 64 */     });
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnFactionCompetitionEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */