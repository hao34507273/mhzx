/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FactionCompetition;
/*     */ import xtable.Faction_competition;
/*     */ 
/*     */ 
/*     */ 
/*     */ class PMailNotifyAgainst
/*     */   extends LogicProcedure
/*     */ {
/*  24 */   public static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/*     */   private final long factionid1;
/*     */   private final long factionid2;
/*     */   private final int matchTimes;
/*     */   
/*     */   PMailNotifyAgainst(long factionid1, long factionid2, int matchTimes)
/*     */   {
/*  31 */     this.factionid1 = factionid1;
/*  32 */     this.factionid2 = factionid2;
/*  33 */     this.matchTimes = matchTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     Gang tlogGang = GangInterface.getGang(this.factionid1, false);
/*  40 */     if (tlogGang == null)
/*     */     {
/*  42 */       tlogGang = GangInterface.getGang(this.factionid2, false);
/*     */     }
/*     */     
/*  45 */     String tlogUserid = null;
/*  46 */     if (tlogGang != null) {
/*  47 */       long tlogLeaderid = tlogGang.getBangZhuId();
/*     */       
/*  49 */       tlogUserid = RoleInterface.getUserId(tlogLeaderid);
/*     */     }
/*     */     
/*     */ 
/*  53 */     lock(Faction_competition.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*     */     
/*  55 */     FactionCompetition xFactionCompetition1 = CompetitionManager.getXFactionCompetitionIfNotExist(this.factionid1);
/*  56 */     CompetitionManager.initXFactionCompetition(xFactionCompetition1);
/*  57 */     xFactionCompetition1.setOpponent(this.factionid2);
/*  58 */     FactionCompetition xFactionCompetition2 = CompetitionManager.getXFactionCompetitionIfNotExist(this.factionid2);
/*  59 */     CompetitionManager.initXFactionCompetition(xFactionCompetition2);
/*  60 */     xFactionCompetition2.setOpponent(this.factionid1);
/*     */     
/*  62 */     Gang faction1 = GangInterface.getGang(this.factionid1, true);
/*  63 */     Gang faction2 = GangInterface.getGang(this.factionid2, true);
/*     */     
/*  65 */     String timeStr = DATE_FORMAT.format(Long.valueOf(ActivityInterface.getNextActivityStartTime(SCompetitionConsts.getInstance().Activityid)));
/*     */     
/*     */ 
/*  68 */     TLogArg tlogArg = new TLogArg(LogReason.COMPETITION_AGAINST_MAIL);
/*     */     
/*  70 */     GangInterface.sendGangMail(this.factionid1, SCompetitionConsts.getInstance().FactionAgainstMail, Arrays.asList(new String[] { faction1.getName(), timeStr, faction2.getName() }), null, tlogArg);
/*     */     
/*     */ 
/*  73 */     GangInterface.sendGangMail(this.factionid2, SCompetitionConsts.getInstance().FactionAgainstMail, Arrays.asList(new String[] { faction2.getName(), timeStr, faction1.getName() }), null, tlogArg);
/*     */     
/*     */ 
/*  76 */     if (CompetitionManager.logger.isInfoEnabled()) {
/*  77 */       StringBuilder sb = new StringBuilder("帮派竞赛匹配成功：");
/*  78 */       sb.append(faction1.getName()).append('(').append(this.factionid1).append(") vs ");
/*  79 */       sb.append(faction2.getName()).append('(').append(this.factionid2).append(')');
/*  80 */       CompetitionManager.logger.info(sb.toString());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */     if (tlogUserid != null) {
/*  94 */       int activeNumber1 = xFactionCompetition1.getActive_number();
/*  95 */       int winTimes1 = xFactionCompetition1.getWin_times();
/*  96 */       int loseTimes1 = xFactionCompetition1.getLose_times();
/*  97 */       int activeness1 = CompetitionConfigManager.getInstance().getActiveness(activeNumber1, winTimes1, loseTimes1);
/*     */       
/*  99 */       int activeNumber2 = xFactionCompetition2.getActive_number();
/* 100 */       int winTimes2 = xFactionCompetition2.getWin_times();
/* 101 */       int loseTimes2 = xFactionCompetition2.getLose_times();
/* 102 */       int activeness2 = CompetitionConfigManager.getInstance().getActiveness(activeNumber2, winTimes2, loseTimes2);
/*     */       
/* 104 */       TLogManager.getInstance().addLog(tlogUserid, "CompetitionMatchByActiveness", new Object[] { Long.valueOf(this.factionid1), Integer.valueOf(faction1.getLevel()), Integer.valueOf(activeNumber1), Integer.valueOf(winTimes1), Integer.valueOf(loseTimes1), Integer.valueOf(activeness1), Long.valueOf(this.factionid2), Integer.valueOf(faction2.getLevel()), Integer.valueOf(activeNumber2), Integer.valueOf(winTimes2), Integer.valueOf(loseTimes2), Integer.valueOf(activeness2), Integer.valueOf(this.matchTimes), Long.valueOf(faction1.getDisplayid()), Long.valueOf(faction2.getDisplayid()) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PMailNotifyAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */