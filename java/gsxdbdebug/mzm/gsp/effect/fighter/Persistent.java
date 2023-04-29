/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.AddBuffHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class Persistent extends FighterEffect implements mzm.gsp.fight.handle.AddBuffHandle
/*    */ {
/*    */   private int multiple;
/*    */   
/*    */   public Persistent(int multiple)
/*    */   {
/* 15 */     this.multiple = multiple;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addBuffState(115);
/* 21 */     fighter.addAddBuffHandle(this);
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 27 */     fighter.remBuffState(115);
/* 28 */     fighter.remAddBuffHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public void onAddBuff(Fighter fighter, FighterBuff fighterBuff)
/*    */   {
/* 34 */     if (this.multiple <= 0) {
/* 35 */       GameServer.logger().error("Persistent效果的参数配置有问题");
/* 36 */       return;
/*    */     }
/* 38 */     if (fighterBuff.isPositive()) {
/* 39 */       int round = fighterBuff.getLeftRound() * this.multiple;
/* 40 */       fighterBuff.setLeftRound(round);
/*    */     }
/*    */   }
/*    */   
/*    */   public void isCanAddBuff(Fighter fighter, FighterBuff fighterBuff, AddBuffHandle.OutPutObj outPutObj) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Persistent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */