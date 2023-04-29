/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ class MatchFaction
/*    */   implements Comparable<MatchFaction>
/*    */ {
/*    */   final long factionid;
/*    */   final String factionName;
/*    */   final int serverid;
/*    */   final int serverLevel;
/*    */   final int activeness;
/*    */   final Map<Long, Integer> factionid2MatchTimes;
/*    */   final int missTurnTimes;
/* 16 */   volatile long opponentFactionid = -1L;
/*    */   
/*    */   MatchFaction(long factionid, String factionName, int serverid, int serverLevel, int activeness, Map<Long, Integer> factionid2MatchTimes, int missTurnTimes)
/*    */   {
/* 20 */     this.factionid = factionid;
/* 21 */     this.factionName = factionName;
/* 22 */     this.serverid = serverid;
/* 23 */     this.serverLevel = serverLevel;
/* 24 */     this.activeness = activeness;
/* 25 */     this.factionid2MatchTimes = new HashMap(factionid2MatchTimes);
/* 26 */     this.missTurnTimes = missTurnTimes;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(MatchFaction other)
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */   int getMatchTimes(long otherFactionid) {
/* 36 */     Integer times = (Integer)this.factionid2MatchTimes.get(Long.valueOf(otherFactionid));
/* 37 */     if (times == null) {
/* 38 */       return 0;
/*    */     }
/* 40 */     return times.intValue();
/*    */   }
/*    */   
/*    */   void setOpponentFactionid(long opponentFactionid) {
/* 44 */     this.opponentFactionid = opponentFactionid;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 49 */     return String.format("[factionid=%d|name=%s|serverid=%d|server_level=%d|activeness=%d|miss_turn_times=%d]", new Object[] { Long.valueOf(this.factionid), this.factionName, Integer.valueOf(this.serverid), Integer.valueOf(this.serverLevel), Integer.valueOf(this.activeness), Integer.valueOf(this.missTurnTimes) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\MatchFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */