/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_PVCFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long activeRoleid;
/*    */   private long passiveRoleid;
/*    */   private FightContext fightContext;
/*    */   private int pvcCfgid;
/*    */   
/*    */   public PGM_PVCFight(long activeRoleid, long passiveRoleid, int pvcCfgid)
/*    */   {
/* 17 */     this(activeRoleid, passiveRoleid, new FightContext()
/*    */     {
/*    */ 
/* 20 */       public boolean isRecordEnable() { return true; } }, pvcCfgid);
/*    */   }
/*    */   
/*    */ 
/*    */   public PGM_PVCFight(long activeRoleid, long passiveRoleid, FightContext fightContext, int pvcCfgid)
/*    */   {
/* 26 */     this.activeRoleid = activeRoleid;
/* 27 */     this.passiveRoleid = passiveRoleid;
/* 28 */     this.fightContext = fightContext;
/* 29 */     this.pvcCfgid = pvcCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 34 */     if (this.passiveRoleid > 0L) {
/* 35 */       return new PStartPVCFight(this.activeRoleid, Arrays.asList(new Long[] { Long.valueOf(this.passiveRoleid) }), this.fightContext, 1, FightReason.GM, this.pvcCfgid).call();
/*    */     }
/*    */     
/* 38 */     return new PStartPVCFight(this.activeRoleid, new ArrayList(), this.fightContext, 1, FightReason.GM, this.pvcCfgid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_PVCFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */