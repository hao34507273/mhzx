/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ 
/*    */ public class ParaseleneFightContext implements FightContext
/*    */ {
/*    */   private int fightid;
/*    */   private int layer;
/*    */   private FightReason fightReson;
/*    */   
/*    */   public ParaseleneFightContext(int fightid, int layer, FightReason fightReson)
/*    */   {
/* 14 */     this.fightid = fightid;
/* 15 */     this.layer = layer;
/* 16 */     this.fightReson = fightReson;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   public FightReason getFightReson()
/*    */   {
/* 28 */     return this.fightReson;
/*    */   }
/*    */   
/*    */   public int getFightid()
/*    */   {
/* 33 */     return this.fightid;
/*    */   }
/*    */   
/*    */   public int getLayer()
/*    */   {
/* 38 */     return this.layer;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */