/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.AddAngerHandle;
/*    */ import mzm.gsp.fight.handle.AddAngerHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ForbidAddAnger
/*    */   extends FighterEffect
/*    */   implements AddAngerHandle
/*    */ {
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 21 */     paramFighter.addAddAngerHandle(this);
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 27 */     paramFighter.remAddAngerHandle(this);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public void onAddAnger(AddAngerHandle.OutputObj paramOutputObj)
/*    */   {
/* 33 */     paramOutputObj.finalAddAnger = 0.0D;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ForbidAddAnger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */