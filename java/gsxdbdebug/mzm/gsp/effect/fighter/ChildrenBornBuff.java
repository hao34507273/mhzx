/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.ChildEnterFightHandle;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class ChildrenBornBuff extends FighterEffect implements ChildEnterFightHandle
/*    */ {
/*    */   private final int hitdebuffrate;
/*    */   private final int debuffid;
/*    */   
/*    */   public ChildrenBornBuff(int hitdebuffrate, int debuffid)
/*    */   {
/* 21 */     this.hitdebuffrate = hitdebuffrate;
/* 22 */     this.debuffid = debuffid;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 27 */     fighter.addChildEnterFightHandle(this);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 33 */     fighter.remChildEnterFightHandle(this);
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public void onEnterFight(Fighter releaser, Fighter child)
/*    */   {
/* 39 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 40 */     if (random >= this.hitdebuffrate) {
/* 41 */       return;
/*    */     }
/* 43 */     FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.debuffid);
/* 44 */     if (addGroup != null) {
/* 45 */       int level = super.getSkillLevel();
/* 46 */       addGroup.run(level, releaser, child, child.getid());
/*    */     } else {
/* 48 */       GameServer.logger().error(String.format("[Effect]ChildrenBornBuff.onEnterFight@effect group not exist|debuffid=%d", new Object[] { Integer.valueOf(this.debuffid) }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ChildrenBornBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */