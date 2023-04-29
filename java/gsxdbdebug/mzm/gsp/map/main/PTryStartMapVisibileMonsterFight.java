/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.message.MMH_StartFightResult;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PTryStartMapVisibileMonsterFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int fightid;
/*    */   private final MapVisibleMonsterFightContext context;
/*    */   private final List<IMonsterFightHandler> fightHandlers;
/*    */   
/*    */   public PTryStartMapVisibileMonsterFight(long roleid, int fightid, MapVisibleMonsterFightContext context, List<IMonsterFightHandler> fightHandlers)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.fightid = fightid;
/* 24 */     this.context = context;
/* 25 */     this.fightHandlers = fightHandlers;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 33 */       if (!MapManager.canDoAction(this.roleid, 163))
/*    */       {
/* 35 */         new MMH_StartFightResult(this.roleid, this.context.instanceId, -1).execute();
/*    */         
/* 37 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 41 */       if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 0, true))
/*    */       {
/* 43 */         new MMH_StartFightResult(this.roleid, this.context.instanceId, -1).execute();
/*    */         
/* 45 */         return false;
/*    */       }
/*    */       
/* 48 */       if (GameServer.logger().isDebugEnabled())
/*    */       {
/* 50 */         GameServer.logger().debug(String.format("[map]PTryStartMapVisibileMonsterFight.processImp@args info|roleid=%d|fightid=%d|monster_cfgid=%d|monster_instanceid=%d|mapid=%d|worldid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.fightid), Integer.valueOf(this.context.monsterCfgId), Integer.valueOf(this.context.instanceId), Integer.valueOf(this.context.mapId), Long.valueOf(this.context.worldId) }));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 57 */       for (IMonsterFightHandler handler : this.fightHandlers)
/*    */       {
/* 59 */         int ret = handler.startFight(this.roleid, this.fightid, this.context);
/* 60 */         if (ret != 0)
/*    */         {
/* 62 */           if (ret != 1)
/*    */           {
/* 64 */             new MMH_StartFightResult(this.roleid, this.context.instanceId, ret).execute();
/*    */           }
/*    */           
/* 67 */           GameServer.logger().info(String.format("[map]PTryStartMapVisibileMonsterFight.processImp@monster fight handler done|roleid=%d|fightid=%d|monster_cfgid=%d|monster_instanceid=%d|mapid=%d|worldid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.fightid), Integer.valueOf(this.context.monsterCfgId), Integer.valueOf(this.context.instanceId), Integer.valueOf(this.context.mapId), Long.valueOf(this.context.worldId) }));
/*    */           
/*    */ 
/*    */ 
/*    */ 
/* 72 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 78 */       new MMH_StartFightResult(this.roleid, this.context.instanceId, -1).execute();
/*    */       
/* 80 */       throw e;
/*    */     }
/*    */     
/* 83 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PTryStartMapVisibileMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */