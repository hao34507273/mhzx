/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ public class RewardEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int rewardCfg;
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 14 */     return false;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 19 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public RewardEffect(int rewardCfg)
/*    */   {
/* 25 */     setRewardCfg(rewardCfg);
/*    */   }
/*    */   
/*    */   public int getRewardCfg() {
/* 29 */     return this.rewardCfg;
/*    */   }
/*    */   
/*    */   public void setRewardCfg(int rewardCfg) {
/* 33 */     this.rewardCfg = rewardCfg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\RewardEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */