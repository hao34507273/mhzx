/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.gsp.singlebattle.main.SingleBattleContext;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeaveSingleBattleArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final long battleId;
/*    */   private final SingleBattleInterface.LeaveBattleReason reason;
/*    */   private final SingleBattleContext _context;
/*    */   private final int pvpFightCount;
/*    */   private SingleBattleResult res;
/*    */   
/*    */   public LeaveSingleBattleArg(long roleId, long battleId, SingleBattleInterface.LeaveBattleReason reason, SingleBattleContext _context, int pvpFightCount)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.battleId = battleId;
/* 28 */     this.reason = reason;
/* 29 */     this._context = _context;
/* 30 */     this.pvpFightCount = pvpFightCount;
/*    */   }
/*    */   
/*    */   public SingleBattleResult getRes()
/*    */   {
/* 35 */     return this.res;
/*    */   }
/*    */   
/*    */   public void setRes(SingleBattleResult res)
/*    */   {
/* 40 */     this.res = res;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 45 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public long getBattleId()
/*    */   {
/* 50 */     return this.battleId;
/*    */   }
/*    */   
/*    */   public SingleBattleInterface.LeaveBattleReason getReason()
/*    */   {
/* 55 */     return this.reason;
/*    */   }
/*    */   
/*    */   public SingleBattleContext get_context()
/*    */   {
/* 60 */     return this._context;
/*    */   }
/*    */   
/*    */   public int getPvpFightCount()
/*    */   {
/* 65 */     return this.pvpFightCount;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\LeaveSingleBattleArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */