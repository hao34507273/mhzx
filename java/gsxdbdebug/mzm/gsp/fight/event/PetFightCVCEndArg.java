/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetFightCVCEndArg
/*    */   extends FightEndArg
/*    */ {
/*    */   public final long fightid;
/*    */   public final FightContext context;
/*    */   public final int fightReason;
/*    */   public final int fightCfgType;
/*    */   public final boolean isActiveWin;
/*    */   public final long timeMills;
/*    */   public final int round;
/*    */   public final long startTime;
/*    */   public final int fightEndReason;
/*    */   public final int actionTotalCount;
/*    */   public final int actionMaxCountRound;
/*    */   public final boolean isForceEnd;
/*    */   public final long recordid;
/* 31 */   public final List<Long> activeRoleList = new ArrayList();
/* 32 */   public final List<Long> passiveRoleList = new ArrayList();
/*    */   
/*    */ 
/* 35 */   public final Map<Long, List<Long>> rolePetMap = new HashMap();
/*    */   
/*    */ 
/* 38 */   public Map<Long, Integer> petDamages = new HashMap();
/*    */   
/*    */ 
/*    */   public PetFightCVCEndArg(long fightid, int fightCfgType, int fightReason, FightContext context, boolean isActiveWin, int timeMills, int activeDeadTimes, int passiveDeadTimes, int round, long startTime, int fightEndReason, int actionTotalCount, int actionMaxCountRound, boolean isForceEnd, long recordid)
/*    */   {
/* 43 */     this.fightid = fightid;
/* 44 */     this.context = context;
/* 45 */     this.isActiveWin = isActiveWin;
/* 46 */     this.timeMills = timeMills;
/* 47 */     this.fightCfgType = fightCfgType;
/* 48 */     this.fightReason = fightReason;
/* 49 */     this.round = round;
/* 50 */     this.startTime = startTime;
/* 51 */     this.fightEndReason = fightEndReason;
/* 52 */     this.actionTotalCount = actionTotalCount;
/* 53 */     this.actionMaxCountRound = actionMaxCountRound;
/* 54 */     this.isForceEnd = isForceEnd;
/* 55 */     this.recordid = recordid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PetFightCVCEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */