/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCObserveMapMonsterFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int monsterInstanceid;
/*    */   
/*    */   public PCObserveMapMonsterFight(long roleid, int monsterInstanceid)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.monsterInstanceid = monsterInstanceid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!MapManager.canDoAction(this.roleid, 164))
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     MapInterface.observeMonsterFight(this.roleid, this.monsterInstanceid);
/*    */     
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PCObserveMapMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */