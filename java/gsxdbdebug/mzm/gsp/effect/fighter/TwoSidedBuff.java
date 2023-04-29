/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class TwoSidedBuff
/*    */   extends FighterEffect
/*    */   implements OpOnce
/*    */ {
/*    */   private int enemybuff;
/*    */   private int friendbuff;
/*    */   
/*    */   public TwoSidedBuff(int paramInt1, int paramInt2)
/*    */   {
/* 22 */     this.enemybuff = paramInt1;
/* 23 */     this.friendbuff = paramInt2;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 38 */     int i = isFriend(paramFighter1, paramFighter2) ? this.friendbuff : this.enemybuff;
/* 39 */     FighterEffectGroup localFighterEffectGroup = EffectInterface.getEffectGroup(i);
/* 40 */     if (localFighterEffectGroup != null) {
/* 41 */       localFighterEffectGroup.run(getSkillLevel(), paramFighter1, paramFighter2, paramFighter1.getid());
/*    */     } else {
/* 43 */       GameServer.logger().error("no exist FighterEffectGroup");
/*    */     }
/*    */     
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   protected boolean isFriend(Fighter paramFighter1, Fighter paramFighter2) {
/* 50 */     Set localSet = paramFighter1.getFriendFighters();
/* 51 */     if (localSet.size() == 0)
/* 52 */       return false;
/* 53 */     for (Fighter localFighter : localSet) {
/* 54 */       if (localFighter.getid() == paramFighter2.getid())
/* 55 */         return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\TwoSidedBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */