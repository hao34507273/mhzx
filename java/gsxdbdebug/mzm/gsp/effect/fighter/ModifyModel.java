/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyModel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int modelid;
/*    */   
/*    */   public ModifyModel(int modelid)
/*    */   {
/* 11 */     this.modelid = modelid;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addModel(this.modelid);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.removeModel(Integer.valueOf(this.modelid));
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */