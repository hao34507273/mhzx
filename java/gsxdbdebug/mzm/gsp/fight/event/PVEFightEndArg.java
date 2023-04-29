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
/*    */ public class PVEFightEndArg
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
/*    */   
/* 34 */   public final List<Integer> alivedMonsters = new ArrayList();
/* 35 */   public final List<Integer> diedMonsters = new ArrayList();
/* 36 */   public final List<Integer> escapedMonsters = new ArrayList();
/* 37 */   public final Map<Integer, Integer> monsteridToLevel = new HashMap();
/*    */   
/*    */ 
/* 40 */   public final Map<Long, List<Integer>> fellowers = new HashMap();
/*    */   
/* 42 */   public final Map<Long, List<Long>> petids = new HashMap();
/*    */   
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
/*    */   public int passiveMonsterKillCount;
/*    */   
/* 59 */   public int passiveMonsterReliveCount = 0;
/*    */   
/* 61 */   public Map<Integer, List<Integer>> monsterDeadInRound = new HashMap();
/*    */   
/*    */ 
/*    */   public PVEFightEndArg(long fightid, boolean isPlayerWin, int fightCfgID, long timeMills, int round, int deadTimes, int fightReason, FightContext context, long startTime, int fightEndReason, int actionTotalCount, int actionMaxCountRound, boolean isForceEnd, long recordid)
/*    */   {
/* 66 */     this.fightid = fightid;
/* 67 */     this.isPlayerWin = isPlayerWin;
/* 68 */     this.fightCfgID = fightCfgID;
/* 69 */     this.timeMills = timeMills;
/* 70 */     this.round = round;
/* 71 */     this.deadTimes = deadTimes;
/* 72 */     this.fightReason = fightReason;
/* 73 */     this.context = context;
/* 74 */     this.startTime = startTime;
/* 75 */     this.fightEndReason = fightEndReason;
/* 76 */     this.actionTotalCount = actionTotalCount;
/* 77 */     this.actionMaxCountRound = actionMaxCountRound;
/* 78 */     this.isForceEnd = isForceEnd;
/* 79 */     this.recordid = recordid;
/*    */   }
/*    */   
/*    */   public List<Long> notEscapeRoles() {
/* 83 */     List<Long> allRoles = new ArrayList(this.roleList);
/* 84 */     allRoles.removeAll(this.escapedRoles);
/* 85 */     return allRoles;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVEFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */