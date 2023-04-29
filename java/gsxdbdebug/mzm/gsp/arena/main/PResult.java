/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Arena;
/*    */ import xbean.ArenaScore;
/*    */ import xbean.ArenaTmp;
/*    */ import xbean.Camp;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ 
/*    */ class PResult
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     Arena xArena = ArenaManager.getXArena(false);
/* 30 */     if (xArena.getFinished()) {
/* 31 */       return false;
/*    */     }
/* 33 */     int topCamp = -1;
/* 34 */     int topScore = -1;
/* 35 */     for (Map.Entry<Integer, Camp> entry : xArena.getCamps().entrySet()) {
/* 36 */       int camp = ((Integer)entry.getKey()).intValue();
/* 37 */       Camp xCamp = (Camp)entry.getValue();
/* 38 */       if (topCamp < 0) {
/* 39 */         topCamp = camp;
/* 40 */         topScore = xCamp.getScore();
/*    */ 
/*    */       }
/* 43 */       else if (xCamp.getScore() > topScore) {
/* 44 */         topCamp = camp;
/* 45 */         topScore = xCamp.getScore();
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 50 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmp(false);
/*    */     
/* 52 */     List<Long> roles = MapInterface.getRoleList(xArenaTmp.getWorld());
/* 53 */     Iterator<Long> iter = roles.iterator();
/* 54 */     List<Long> winnerRoles = new ArrayList();
/* 55 */     List<Long> loserRoles = new ArrayList();
/* 56 */     while (iter.hasNext()) {
/* 57 */       long r = ((Long)iter.next()).longValue();
/*    */       
/* 59 */       ArenaScore xScore = Arenascore.select(Long.valueOf(r));
/* 60 */       if (xScore.getCamp() != topCamp) {
/* 61 */         loserRoles.add(Long.valueOf(r));
/*    */       }
/*    */       else {
/* 64 */         winnerRoles.add(Long.valueOf(r));
/*    */       }
/* 66 */       iter.remove();
/*    */     }
/*    */     
/*    */ 
/* 70 */     xArena = ArenaManager.getXArena(true);
/* 71 */     if (xArena.getFinished()) {
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     xArena.setFinished(true);
/*    */     
/*    */ 
/* 78 */     for (Iterator i$ = loserRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 79 */       ArenaManager.leaveActivityWorld(r);
/*    */     }
/*    */     
/*    */ 
/* 83 */     AwardPoolInterface.awardLottery(winnerRoles, SArenaConsts.getInstance().WinCampAward, new TLogArg(LogReason.ARENA_WINNER_CAMP_AWARD));
/*    */     
/*    */ 
/*    */ 
/* 87 */     List<ArenaChartObj> topList = ArenaManager.chart.getRankObjs(0, SArenaConsts.getInstance().TopNumber - 1);
/* 88 */     for (ArenaChartObj obj : topList)
/*    */     {
/* 90 */       TitleInterface.addAppellationNoneRealTime(obj.getRoleid(), SArenaConsts.getInstance().TopAppellation, true);
/*    */       
/* 92 */       MailInterface.asynBuildAndSendMail(obj.getRoleid(), SArenaConsts.getInstance().TopMail, null, null, new TLogArg(LogReason.ARENA_TOP_AWARD));
/*    */     }
/*    */     
/*    */ 
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */