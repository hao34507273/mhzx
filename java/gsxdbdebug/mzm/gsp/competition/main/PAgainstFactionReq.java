/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.competition.SAgainstFactionRes;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionCompetition;
/*    */ import xtable.Faction_competition;
/*    */ 
/*    */ 
/*    */ public class PAgainstFactionReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PAgainstFactionReq(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     long factionid = GangInterface.getGangId(this.roleid);
/* 24 */     if (factionid <= 0L) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     FactionCompetition xFC = Faction_competition.select(Long.valueOf(factionid));
/* 29 */     if (xFC == null) {
/* 30 */       CompetitionManager.sendNoAgainstFactionRes(this.roleid);
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     if (xFC.getOpponent() <= 0L) {
/* 35 */       CompetitionManager.sendNoAgainstFactionRes(this.roleid);
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     SAgainstFactionRes res = new SAgainstFactionRes();
/* 40 */     res.faction_id = xFC.getOpponent();
/* 41 */     String againstName = GangInterface.getGangNameByGangId(xFC.getOpponent());
/* 42 */     if (againstName != null) {
/* 43 */       res.faction_name = againstName;
/*    */     }
/*    */     
/* 46 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PAgainstFactionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */