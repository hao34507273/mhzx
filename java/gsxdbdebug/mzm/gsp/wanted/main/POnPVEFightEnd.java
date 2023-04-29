/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.wanted.SNotifyPVEFightResult;
/*    */ import xbean.WantedInfo;
/*    */ 
/*    */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     if ((((PVEFightEndArg)this.arg).fightReason != FightReason.WANTED_FIGHT_PVE.value) || (!(((PVEFightEndArg)this.arg).context instanceof WantedPVEFightContext)))
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     SNotifyPVEFightResult notifyFightResult = new SNotifyPVEFightResult();
/* 23 */     WantedManager.getRoleNamesOctets(((PVEFightEndArg)this.arg).roleList, notifyFightResult.passivenamelist, true);
/*    */     
/*    */ 
/* 26 */     lock(xtable.Basic.getTable(), ((PVEFightEndArg)this.arg).roleList);
/*    */     
/*    */ 
/* 29 */     Set<Long> wantedRoles = WantedManager.getWantedRoleIds(((PVEFightEndArg)this.arg).roleList);
/*    */     
/* 31 */     long wantedRoleId = ((WantedPVEFightContext)((PVEFightEndArg)this.arg).context).wantedRoleId;
/* 32 */     int fightId = ((WantedPVEFightContext)((PVEFightEndArg)this.arg).context).fightId;
/* 33 */     WantedInfo xWantedInfo = xtable.Role2wantedinfo.get(Long.valueOf(wantedRoleId));
/* 34 */     notifyFightResult.fightcount = (xWantedInfo.getNpcfightcount() + 1);
/*    */     
/* 36 */     if (((PVEFightEndArg)this.arg).isPlayerWin)
/*    */     {
/* 38 */       notifyFightResult.result = 2;
/*    */       
/*    */ 
/*    */ 
/* 42 */       NPCWantedSession npcWantedSession = new NPCWantedSession(TimeUnit.MINUTES.toSeconds(SPKConsts.getInstance().NPC_ARREST_INTERVAL_MINUTES), wantedRoleId, SPKConsts.getInstance().NPC_ARREST_FIGHT_ID_2);
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 47 */       xWantedInfo.setSessionid(npcWantedSession.getSessionId());
/* 48 */       xWantedInfo.setNpcfightcount(notifyFightResult.fightcount);
/*    */     }
/*    */     else
/*    */     {
/* 52 */       notifyFightResult.result = 1;
/*    */       
/* 54 */       WantedManager.ArrestRoles(wantedRoles);
/*    */     }
/*    */     
/*    */ 
/* 58 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).diedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 60 */       if (wantedRoles.contains(Long.valueOf(roleId)))
/*    */       {
/*    */ 
/* 63 */         WantedManager.reduceEquipmentUsePoint(roleId, SPKConsts.getInstance().WANTED_ARREST_DEATH_EQUIPMENT_PENALTY);
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 68 */         WantedManager.reduceEquipmentUsePoint(roleId, SPKConsts.getInstance().NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 73 */     WantedTlogManager.tlogWantedPVEResult(wantedRoleId, ((PVEFightEndArg)this.arg).roleList, wantedRoles, notifyFightResult.fightcount, fightId, ((PVEFightEndArg)this.arg).isPlayerWin ? 2 : 1);
/*    */     
/*    */ 
/* 76 */     OnlineManager.getInstance().sendAll(notifyFightResult);
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */