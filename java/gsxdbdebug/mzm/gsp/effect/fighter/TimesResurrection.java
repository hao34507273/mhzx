/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class TimesResurrection extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeKilledHandle
/*    */ {
/*    */   private int rate;
/*    */   private int timestype;
/*    */   private int times;
/*    */   private final int reliveRate;
/* 16 */   private final int TIMETYPE_ROUND = 1;
/* 17 */   private final int TIMETYPE_TIME = 2;
/*    */   
/* 19 */   private int effectRound = -1;
/* 20 */   private int effectTimes = 0;
/*    */   
/*    */   public TimesResurrection(int rate, int timestype, int times, int reliveRate) {
/* 23 */     this.rate = rate;
/* 24 */     this.timestype = timestype;
/* 25 */     if ((timestype != 1) && (timestype != 2)) {
/* 26 */       GameServer.logger().error(String.format("[Fight]TimesResurrection.construction@error,timesType params error|timesType=%d", new Object[] { Integer.valueOf(timestype) }));
/*    */     }
/*    */     
/*    */ 
/* 30 */     this.times = Math.min(times, 50);
/*    */     
/* 32 */     this.reliveRate = reliveRate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 37 */     fighter.addBeKilledHandle(this);
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 43 */     fighter.remBeKilledHandle(this);
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, BeKilledHandle.OutPutObj outPutObj)
/*    */   {
/* 49 */     if (inputObj.target == null) {
/* 50 */       return;
/*    */     }
/*    */     
/* 53 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 54 */     if (this.reliveRate <= random) {
/* 55 */       return;
/*    */     }
/*    */     
/* 58 */     Fighter target = inputObj.target;
/* 59 */     int curRound = target.getRound();
/* 60 */     switch (this.timestype) {
/*    */     case 1: 
/* 62 */       if (this.effectRound == curRound) {
/*    */         return;
/*    */       }
/*    */       break;
/*    */     case 2: 
/* 67 */       if (this.effectTimes >= this.times) {
/* 68 */         setLeftRound(0); return;
/*    */       }
/*    */       
/*    */       break;
/*    */     default: 
/* 73 */       GameServer.logger().error(String.format("[Fight]TimesResurrection.construction@error,timesType params error|timesType=%d", new Object[] { Integer.valueOf(this.timestype) }));
/*    */       
/*    */ 
/* 76 */       return;
/*    */     }
/* 78 */     this.effectRound = curRound;
/* 79 */     this.effectTimes += 1;
/* 80 */     if (this.effectTimes >= this.times) {
/* 81 */       setLeftRound(0);
/*    */     }
/* 83 */     int hpchange = (int)(target.getMaxHp() * (this.rate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 84 */     target.addHp(hpchange);
/* 85 */     if (target.getHp() > 0) {
/* 86 */       target.setAlive();
/* 87 */       target.onRelive();
/* 88 */       target.addActionCount();
/* 89 */       int passiveskillid = getPassiveSkillid();
/* 90 */       if (passiveskillid > 0) {
/* 91 */         outPutObj.targetPassiveSkillids.add(Integer.valueOf(passiveskillid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\TimesResurrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */