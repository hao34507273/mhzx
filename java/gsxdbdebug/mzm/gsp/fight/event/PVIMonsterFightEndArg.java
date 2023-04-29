/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PVIMonsterFightEndArg
/*    */   extends FightEndArg
/*    */ {
/*    */   public final long fightid;
/*    */   public final boolean isPlayerWin;
/*    */   public final int fightCfgID;
/*    */   public final long timeMills;
/*    */   public final int round;
/*    */   public final int deadTimes;
/*    */   public final int fightReason;
/*    */   public final FightContext context;
/* 29 */   public final Set<Long> alivedRoles = new HashSet();
/* 30 */   public final Set<Long> diedRoles = new HashSet();
/* 31 */   public final Set<Long> escapedRoles = new HashSet();
/* 32 */   public final List<Long> roleList = new ArrayList();
/* 33 */   public final Map<Long, Integer> roleDamageMap = new HashMap();
/* 34 */   public final List<Integer> alivedMonsters = new ArrayList();
/* 35 */   public final List<Integer> escapedMonsters = new ArrayList();
/* 36 */   public final Map<Integer, Integer> monsteridToLevel = new HashMap();
/*    */   
/*    */ 
/* 39 */   public final Map<Long, List<Integer>> fellowers = new HashMap();
/*    */   
/* 41 */   public final Map<Long, List<Long>> petids = new HashMap();
/*    */   
/*    */   public final long startTime;
/*    */   
/*    */   public final int fightEndReason;
/*    */   
/*    */   public final int actionTotalCount;
/*    */   
/*    */   public final int actionMaxCountRound;
/*    */   
/*    */   public final boolean isForceEnd;
/*    */   
/*    */   public final long recordid;
/*    */   
/*    */ 
/*    */   public PVIMonsterFightEndArg(long fightid, boolean isPlayerWin, int fightCfgID, long timeMills, int round, int deadTimes, int fightReason, FightContext context, long startTime, int fightEndReason, int actionTotalCount, int actionMaxCountRound, boolean isForceEnd, long recordid)
/*    */   {
/* 58 */     this.fightid = fightid;
/* 59 */     this.isPlayerWin = isPlayerWin;
/* 60 */     this.fightCfgID = fightCfgID;
/* 61 */     this.timeMills = timeMills;
/* 62 */     this.round = round;
/* 63 */     this.deadTimes = deadTimes;
/* 64 */     this.fightReason = fightReason;
/* 65 */     this.context = context;
/* 66 */     this.startTime = startTime;
/* 67 */     this.fightEndReason = fightEndReason;
/* 68 */     this.actionTotalCount = actionTotalCount;
/* 69 */     this.actionMaxCountRound = actionMaxCountRound;
/* 70 */     this.isForceEnd = isForceEnd;
/* 71 */     this.recordid = recordid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVIMonsterFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */