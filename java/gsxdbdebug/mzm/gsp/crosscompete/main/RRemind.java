/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.CrossCompeteMatchFaction;
/*    */ 
/*    */ class RRemind
/*    */   extends LogicRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 24 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 25 */     if (xCompete == null) {
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCompete.getAgainsts().entrySet().iterator();
/*    */     
/*    */ 
/* 32 */     while (iter.hasNext()) {
/* 33 */       Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/* 34 */       CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/* 35 */       CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/*    */       
/* 37 */       long frontFactionid = cMatch.getFront_factionid();
/* 38 */       long behindFactionid = cMatch.getBehind_factionid();
/* 39 */       int competeIndex = xAgainst.getCompete_index();
/*    */       
/* 41 */       if (competeIndex < 0) {
/* 42 */         CrossCompeteManager.logError("RRemind.process@invalid compete index|front_factionid=%d|behind_factionid=%d|compete_index=%d", new Object[] { Long.valueOf(frontFactionid), Long.valueOf(behindFactionid), Integer.valueOf(competeIndex) });
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/*    */ 
/* 48 */         String startTimeStr = CrossCompeteManager.getCompeteBeginTimeStr(competeIndex);
/* 49 */         String forbidEnterTimeStr = CrossCompeteManager.getCompeteForbidEnterTimeStr(competeIndex);
/*    */         
/* 51 */         TLogArg tlogArg = new TLogArg(LogReason.CROSS_COMPETE_MATCH_MAIL, competeIndex);
/* 52 */         List<String> contentArgs = new ArrayList();
/* 53 */         contentArgs.add(startTimeStr);
/* 54 */         contentArgs.add(forbidEnterTimeStr);
/*    */         
/*    */ 
/* 57 */         GangInterface.sendGangMailSync(frontFactionid, SCrossCompeteConsts.getInstance().RemindMail, contentArgs, null, tlogArg);
/*    */         
/* 59 */         GangInterface.sendGangMailSync(behindFactionid, SCrossCompeteConsts.getInstance().RemindMail, contentArgs, null, tlogArg);
/*    */         
/*    */ 
/* 62 */         CrossCompeteManager.logInfo("RRemind.process@remind mail|front_factionid=%d|behind_factionid=%d|front_name=%s|behind_name=%s|compete_index=%d", new Object[] { Long.valueOf(frontFactionid), Long.valueOf(behindFactionid), xAgainst.getFront_faction().getName(), xAgainst.getBehind_faction().getName(), Integer.valueOf(competeIndex) });
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\RRemind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */