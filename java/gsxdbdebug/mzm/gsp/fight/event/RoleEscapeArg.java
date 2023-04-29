/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleEscapeArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final FightContext fightContext;
/*    */   public final int fightType;
/*    */   public final int fightReason;
/* 17 */   public final List<Integer> fellowers = new ArrayList();
/*    */   
/* 19 */   public final List<Long> petids = new ArrayList();
/*    */   
/*    */   public final int fightCfgId;
/*    */   
/*    */   public final long startTime;
/*    */   
/*    */   public final int round;
/*    */   
/*    */   public final int actionMaxCountRound;
/*    */   
/*    */   public final int actionTotalCount;
/*    */   
/*    */   public RoleEscapeArg(long roleid, FightContext fightContext, int fightType, int fightReason, List<Integer> fellowers, List<Long> petIds, int fightCfgId, long startTime, int round, int actionMaxCountRound, int actionTotalCount)
/*    */   {
/* 33 */     this.roleid = roleid;
/* 34 */     this.fightContext = fightContext;
/* 35 */     this.fightType = fightType;
/* 36 */     this.fightReason = fightReason;
/* 37 */     this.fellowers.addAll(fellowers);
/* 38 */     this.petids.addAll(petIds);
/* 39 */     this.fightCfgId = fightCfgId;
/* 40 */     this.startTime = startTime;
/* 41 */     this.round = round;
/* 42 */     this.actionMaxCountRound = actionMaxCountRound;
/* 43 */     this.actionTotalCount = actionTotalCount;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\RoleEscapeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */