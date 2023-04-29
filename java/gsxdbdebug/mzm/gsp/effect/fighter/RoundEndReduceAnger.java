/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeforePoisonHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.RoundEndHandle;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ 
/*    */ public class RoundEndReduceAnger
/*    */   extends FighterEffect
/*    */   implements RoundEndHandle
/*    */ {
/*    */   private int roundendreduceanger;
/*    */   
/*    */   public RoundEndReduceAnger(int paramInt)
/*    */   {
/* 21 */     this.roundendreduceanger = paramInt;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 26 */     paramFighter.addRoundEndHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 32 */     paramFighter.remRoundEndHandle(this);
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundEnd(Fighter paramFighter)
/*    */   {
/* 38 */     if (!paramFighter.isAlive()) {
/* 39 */       return;
/*    */     }
/* 41 */     int i = this.roundendreduceanger;
/* 42 */     if (getGroup() != null)
/*    */     {
/* 44 */       if (getGroup().getEffectGroupType() == 16)
/*    */       {
/* 46 */         localObject = getGroup().getReleaser(paramFighter);
/* 47 */         BeforePoisonHandle.InputObj localInputObj = new BeforePoisonHandle.InputObj((Fighter)localObject, paramFighter, getGroup().getSkill());
/*    */         
/* 49 */         BeforePoisonHandle.OutputObj localOutputObj = paramFighter.handleonBeforePoison(localInputObj);
/* 50 */         i = (int)(i * (1.0D + localOutputObj.expoisonrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */       }
/* 52 */       localObject = getGroup().getReleaser(paramFighter);
/* 53 */       if ((localObject != null) && (i > 0)) {
/* 54 */         ((Fighter)localObject).addDamageToFighter(paramFighter, i);
/*    */       }
/*    */     }
/* 57 */     paramFighter.addAnger(-i);
/* 58 */     Object localObject = paramFighter.getAndAddRoundStatus();
/* 59 */     localObject.angerchange -= i;
/* 60 */     paramFighter.fillFighterStatus((FighterStatus)localObject);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundEndReduceAnger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */