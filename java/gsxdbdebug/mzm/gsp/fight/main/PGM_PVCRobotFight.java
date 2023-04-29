/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_PVCRobotFight extends LogicProcedure
/*    */ {
/*    */   private long activeRoleid;
/*    */   private long passiveRoleid;
/*    */   private FightContext fightContext;
/*    */   private int robotClassid;
/*    */   
/*    */   public PGM_PVCRobotFight(long activeRoleid, long passiveRoleid, int robotClassid)
/*    */   {
/* 16 */     this(activeRoleid, passiveRoleid, new FightContext()
/*    */     {
/*    */ 
/* 19 */       public boolean isRecordEnable() { return true; } }, robotClassid);
/*    */   }
/*    */   
/*    */ 
/*    */   public PGM_PVCRobotFight(long activeRoleid, long passiveRoleid, FightContext fightContext, int robotClassid)
/*    */   {
/* 25 */     this.activeRoleid = activeRoleid;
/* 26 */     this.passiveRoleid = passiveRoleid;
/* 27 */     this.fightContext = fightContext;
/* 28 */     this.robotClassid = robotClassid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 33 */     if (this.passiveRoleid > 0L) {
/* 34 */       return new PStartPVCFightWithRobot(this.activeRoleid, Arrays.asList(new Long[] { Long.valueOf(this.passiveRoleid) }), this.fightContext, 1, FightReason.GM, this.robotClassid).call();
/*    */     }
/*    */     
/* 37 */     return new PStartPVCFightWithRobot(this.activeRoleid, new ArrayList(), this.fightContext, 1, FightReason.GM, this.robotClassid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_PVCRobotFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */