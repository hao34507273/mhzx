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
/*    */ public class PVCFightEndArg
/*    */   extends FightEndArg
/*    */ {
/*    */   public final long fightid;
/*    */   public final FightContext context;
/*    */   public final int fightReason;
/*    */   public final boolean isActiveWin;
/*    */   public final long timeMills;
/*    */   public final int round;
/* 25 */   public final Set<Long> activeAlivedRoles = new HashSet();
/* 26 */   public final Set<Long> activeDeadRoles = new HashSet();
/* 27 */   public final Set<Long> activeEscapedRoles = new HashSet();
/* 28 */   public final List<Long> activeRoleList = new ArrayList();
/*    */   
/* 30 */   public final List<Long> passiveRoleList = new ArrayList();
/*    */   
/* 32 */   public final Map<Long, List<Integer>> activeFellowers = new HashMap();
/*    */   
/* 34 */   public final Map<Long, List<Long>> activePetids = new HashMap();
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
/*    */   public PVCFightEndArg(long fightid, FightContext context, int fightReason, boolean isActiveWin, long timeMills, int round, long startTime, int fightEndReason, int actionTotalCount, int actionMaxCountRound, boolean isForceEnd, long recordid)
/*    */   {
/* 51 */     this.fightid = fightid;
/* 52 */     this.context = context;
/* 53 */     this.fightReason = fightReason;
/* 54 */     this.isActiveWin = isActiveWin;
/* 55 */     this.timeMills = timeMills;
/* 56 */     this.round = round;
/* 57 */     this.startTime = startTime;
/* 58 */     this.fightEndReason = fightEndReason;
/* 59 */     this.actionTotalCount = actionTotalCount;
/* 60 */     this.actionMaxCountRound = actionMaxCountRound;
/* 61 */     this.isForceEnd = isForceEnd;
/* 62 */     this.recordid = recordid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVCFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */