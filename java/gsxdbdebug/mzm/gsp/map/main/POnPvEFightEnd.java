/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.map.main.message.MMH_OnPvEFightEnd;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.LogManager;
/*    */ 
/*    */ public class POnPvEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     FightContext context = ((PVEFightEndArg)this.arg).context;
/* 16 */     MapVisibleMonsterFightContext monsterContext; Iterator i$; if ((context != null) && ((context instanceof MapVisibleMonsterFightContext)))
/*    */     {
/* 18 */       monsterContext = (MapVisibleMonsterFightContext)context;
/*    */       
/* 20 */       new MMH_OnPvEFightEnd(monsterContext.instanceId, ((PVEFightEndArg)this.arg).isPlayerWin).execute();
/*    */       
/* 22 */       for (i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 24 */         LogManager.getInstance().addLog("killmonsters", new Object[] { Integer.valueOf(RoleInterface.getPlatform(roleId)), RoleInterface.getChannel(roleId), RoleInterface.getMac(roleId), RoleInterface.getUserId(roleId), Long.valueOf(roleId), Integer.valueOf(RoleInterface.getLevel(roleId)), Integer.valueOf(((PVEFightEndArg)this.arg).fightReason), Long.valueOf(((PVEFightEndArg)this.arg).fightid), Integer.valueOf(monsterContext.monsterCfgId), Integer.valueOf(((PVEFightEndArg)this.arg).isPlayerWin ? 1 : 2) });
/*    */         
/*    */ 
/*    */ 
/* 28 */         StringBuilder logStr = new StringBuilder();
/* 29 */         logStr.append(mzm.gsp.GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(roleId)).append("|").append(roleId).append("|").append(RoleInterface.getLevel(roleId)).append("|").append(((PVEFightEndArg)this.arg).fightReason).append("|").append(((PVEFightEndArg)this.arg).fightCfgID).append("|").append(monsterContext.monsterCfgId).append("|").append(((PVEFightEndArg)this.arg).isPlayerWin ? 1 : 0);
/*    */         
/*    */ 
/*    */ 
/* 33 */         TLogManager.getInstance().addLog(roleId, "KillMonsters", logStr.toString());
/*    */       }
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */