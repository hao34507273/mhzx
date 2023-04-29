/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Procedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FightTimer
/*    */   extends FightSession
/*    */ {
/*    */   FightTimer(long fightid, int interval)
/*    */   {
/* 25 */     super(fightid, (int)(interval * 1000L));
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 31 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 36 */         long fightid = FightTimer.this.getFightid();
/* 37 */         Fight fight = FightManager.getFight(fightid);
/* 38 */         if (fight == null)
/*    */         {
/* 40 */           return false;
/*    */         }
/*    */         
/* 43 */         Set<Long> lockRoles = fight.getLockRoles();
/* 44 */         lock(Basic.getTable(), lockRoles);
/*    */         
/* 46 */         int fightCfgid = 0;
/* 47 */         if (((fight instanceof PVEFight)) || ((fight instanceof PVIMonsterFight)))
/*    */         {
/* 49 */           fightCfgid = ((PVEFight)fight).getFightCfgid();
/*    */         }
/* 51 */         fight.fightEndOnForceEnd(103);
/*    */         
/* 53 */         GameServer.logger().info(String.format("[fight]FightTimer.onTimeOut@fight timeout|fightid=%d|fight_type=%d|fight_cfgid=%d", new Object[] { Long.valueOf(fightid), Integer.valueOf(fight.getType()), Integer.valueOf(fightCfgid) }));
/*    */         
/*    */ 
/*    */ 
/* 57 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */