/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crossserver.event.CrossCompeteRoamServersDoneArg;
/*    */ import mzm.gsp.crossserver.event.CrossCompeteRoamServersDoneProcedure;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.CrossCompeteMatchFaction;
/*    */ 
/*    */ public class POnCrossCompeteRoamServersDone extends CrossCompeteRoamServersDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     long activityStartTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/*    */ 
/* 24 */     DateFormat dateFormat = CrossCompeteManager.getLogDateFormat();
/* 25 */     if (activityStartTime != ((CrossCompeteRoamServersDoneArg)this.arg).startMillis) {
/* 26 */       String selfDate = dateFormat.format(Long.valueOf(activityStartTime));
/* 27 */       String matcherDate = dateFormat.format(Long.valueOf(((CrossCompeteRoamServersDoneArg)this.arg).startMillis));
/* 28 */       CrossCompeteManager.logError("POnCrossCompeteRoamServersDone.processImp@activity start time err|self_starttime=%d|matcher_starttime=%d|self_date=%s|matcher_date=%s", new Object[] { Long.valueOf(activityStartTime), Long.valueOf(((CrossCompeteRoamServersDoneArg)this.arg).startMillis), selfDate, matcherDate });
/*    */       
/*    */ 
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/* 36 */     Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCompete.getAgainsts().entrySet().iterator();
/*    */     
/* 38 */     while (iter.hasNext()) {
/* 39 */       Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/* 40 */       CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/* 41 */       CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/* 42 */       Integer roamServerid = (Integer)((CrossCompeteRoamServersDoneArg)this.arg).compete2RoamServerid.get(Integer.valueOf(xAgainst.getCompete_index()));
/* 43 */       if (roamServerid != null) {
/* 44 */         xAgainst.setRoam_serverid(roamServerid.intValue());
/*    */         
/* 46 */         CrossCompeteManager.logInfo("POnCrossCompeteRoamServersDone.processImp@set roam serverid|front_factionid=%d|front_faction_name=%s|behind_factionid=%d|behind_faction_name=%s|compete_index=%d|roam_serverid=%d", new Object[] { Long.valueOf(cMatch.getFront_factionid()), xAgainst.getFront_faction().getName(), Long.valueOf(cMatch.getBehind_factionid()), xAgainst.getBehind_faction().getName(), Integer.valueOf(xAgainst.getCompete_index()), Integer.valueOf(roamServerid.intValue()) });
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnCrossCompeteRoamServersDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */