/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.SealedHandle;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class SealRebound
/*    */   extends FighterEffect
/*    */   implements SealedHandle
/*    */ {
/*    */   private int times;
/*    */   
/*    */   public SealRebound(int paramInt)
/*    */   {
/* 18 */     this.times = paramInt;
/*    */   }
/*    */   
/*    */   public void onSealed(Fighter paramFighter1, Fighter paramFighter2, FighterBuff paramFighterBuff)
/*    */   {
/* 23 */     if (this.times <= 0) {
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     this.times -= 1;
/* 28 */     if (this.times <= 0)
/*    */     {
/* 30 */       setLeftRound(0);
/*    */     }
/*    */     
/* 33 */     FighterEffectGroup localFighterEffectGroup = EffectInterface.getEffectGroup(paramFighterBuff.getBuffCfgId());
/* 34 */     if (localFighterEffectGroup != null) {
/* 35 */       int i = paramFighterBuff.getLevel();
/* 36 */       paramFighter2.addSealHitRate(10000);
/* 37 */       localFighterEffectGroup.run(i, paramFighter2, paramFighter1, paramFighter1.getid());
/* 38 */       paramFighter2.addSealHitRate(55536);
/*    */     }
/*    */     
/* 41 */     paramFighterBuff.setLeftRound(0);
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 46 */     paramFighter.addSealedHandle(this);
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 52 */     paramFighter.remSealedHandle(this);
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public void onSealOthers(Fighter paramFighter1, Fighter paramFighter2, FighterBuff paramFighterBuff) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SealRebound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */