/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Procedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ public class UpdateTimer
/*    */   extends Observer
/*    */ {
/*    */   private final long fightuuid;
/*    */   
/*    */   UpdateTimer(long fightuuid, int intervalSeconds)
/*    */   {
/* 21 */     super(intervalSeconds);
/* 22 */     this.fightuuid = fightuuid;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 27 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 32 */         Fight fight = FightManager.getFight(UpdateTimer.this.fightuuid);
/* 33 */         if (fight == null) {
/* 34 */           UpdateTimer.this.stopTimer();
/* 35 */           return false;
/*    */         }
/* 37 */         long nextTimerSec = fight.getNextTimerMillSec();
/* 38 */         long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 39 */         long checkABSMillSec = curTime - nextTimerSec;
/*    */         
/* 41 */         if (checkABSMillSec > SFightConsts.getInstance().checkABS * 1000) {
/* 42 */           Set<Long> lockRoles = fight.getLockRoles();
/*    */           
/* 44 */           lock(Basic.getTable(), lockRoles);
/* 45 */           fight.onFightEnd(false, 103);
/*    */           
/* 47 */           int fightCfgid = 0;
/* 48 */           if ((fight instanceof PVEFight)) {
/* 49 */             fightCfgid = ((PVEFight)fight).getFightCfgid();
/*    */           }
/*    */           
/* 52 */           GameServer.logger().error("UpdateTimer检测战斗出问题了,fightuuid:" + UpdateTimer.this.fightuuid + ",fightType:" + fight.getType() + ",fightcfgid:" + fightCfgid);
/*    */         }
/*    */         
/*    */ 
/*    */ 
/* 57 */         return true;
/*    */       }
/*    */       
/* 60 */     });
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\UpdateTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */