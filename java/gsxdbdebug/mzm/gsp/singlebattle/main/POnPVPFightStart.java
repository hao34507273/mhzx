/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import xbean.RoleSingleBattle;
/*    */ 
/*    */ public class POnPVPFightStart extends mzm.gsp.fight.event.PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (!(((PVPFightStartArg)this.arg).context instanceof SingleBattleFightContext))
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     SingleBattleFightContext fightContext = (SingleBattleFightContext)((PVPFightStartArg)this.arg).context;
/*    */     
/* 18 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(fightContext.getBattleId(), true);
/* 19 */     if (globalInfo == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     globalInfo.addFightId(((PVPFightStartArg)this.arg).fightid);
/*    */     
/* 26 */     recordPVPFightCount();
/* 27 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void recordPVPFightCount()
/*    */   {
/* 36 */     for (Iterator i$ = ((PVPFightStartArg)this.arg).getAllRoles().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 38 */       asynRecordEachFight(roleId);
/*    */     }
/*    */   }
/*    */   
/*    */   private void asynRecordEachFight(final long roleId)
/*    */   {
/* 44 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 51 */         RoleSingleBattle xRoleBattleData = xtable.Role2singlebattle.get(Long.valueOf(roleId));
/* 52 */         if (xRoleBattleData == null)
/*    */         {
/* 54 */           GameServer.logger().error(String.format("[singlebattle]POnPVPFightStart.recordPVPFightCount@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */           
/*    */ 
/*    */ 
/* 58 */           return false;
/*    */         }
/* 60 */         xRoleBattleData.setPvpfightcount(xRoleBattleData.getPvpfightcount() + 1);
/* 61 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */