/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PRemoveFightRecord extends LogicProcedure
/*    */ {
/*    */   private final long recordid;
/*    */   
/*    */   public PRemoveFightRecord(long recordid)
/*    */   {
/* 11 */     this.recordid = recordid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return xtable.Fightreord.remove(Long.valueOf(this.recordid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PRemoveFightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */