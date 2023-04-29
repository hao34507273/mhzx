/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.CorpsBriefInfo;
/*    */ import xbean.AttendCorpsInfo;
/*    */ import xbean.CrossBattleOwn;
/*    */ import xbean.RoundRobinRoundInfo;
/*    */ 
/*    */ 
/*    */ public class CrossBattleOwnInfo
/*    */ {
/*    */   private final CrossBattleOwn xCrossBattleOwn;
/*    */   
/*    */   public CrossBattleOwnInfo(CrossBattleOwn xCrossBattleOwn)
/*    */   {
/* 18 */     this.xCrossBattleOwn = xCrossBattleOwn;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean fillCorpsBriefInfo(CorpsBriefInfo corpsBriefInfo, long corpsid)
/*    */   {
/* 33 */     if (!this.xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsid)))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     CrossBattleOwnManager.fillCorpsBriefInfo(corpsBriefInfo, corpsid, (AttendCorpsInfo)this.xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid)));
/*    */     
/* 39 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<CrossBattleRoundRobinRoundInfo> getRoundRobinRoundInfoList()
/*    */   {
/* 49 */     List<CrossBattleRoundRobinRoundInfo> roundInfos = new ArrayList();
/* 50 */     for (RoundRobinRoundInfo xRoundRobinRoundInfo : this.xCrossBattleOwn.getRound_robin_round_infos())
/*    */     {
/* 52 */       roundInfos.add(new CrossBattleRoundRobinRoundInfo(xRoundRobinRoundInfo));
/*    */     }
/* 54 */     return roundInfos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public CrossBattleRoundRobinRoundInfo getRoundRobinRoundInfo(int roundIndex)
/*    */   {
/* 66 */     if ((roundIndex <= 0) || (roundIndex > this.xCrossBattleOwn.getRound_robin_round_infos().size()))
/*    */     {
/*    */ 
/* 69 */       return null;
/*    */     }
/* 71 */     return new CrossBattleRoundRobinRoundInfo((RoundRobinRoundInfo)this.xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getCorpsName(long corpsid)
/*    */   {
/* 82 */     AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)this.xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/* 83 */     if (xAttendCorpsInfo == null)
/*    */     {
/* 85 */       return "";
/*    */     }
/* 87 */     return xAttendCorpsInfo.getName();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\CrossBattleOwnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */