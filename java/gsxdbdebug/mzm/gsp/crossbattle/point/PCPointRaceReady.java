/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.util.LogicProcedure;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCPointRaceReady
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int index;
/*    */   
/*    */   public PCPointRaceReady(long roleid, int activityCfgid, int index)
/*    */   {
/* 40 */     this.roleid = roleid;
/* 41 */     this.activityCfgid = activityCfgid;
/* 42 */     this.index = index;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 48 */     if (this.activityCfgid <= 0)
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PPointRaceReady(this.roleid, this.activityCfgid, this.index));
/*    */     
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PCPointRaceReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */