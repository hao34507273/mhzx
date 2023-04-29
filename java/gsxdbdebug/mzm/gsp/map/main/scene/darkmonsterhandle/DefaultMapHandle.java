/*    */ package mzm.gsp.map.main.scene.darkmonsterhandle;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.MapCfgManager;
/*    */ import mzm.gsp.map.main.MapObjectManager;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ 
/*    */ public class DefaultMapHandle implements MeetDarkMonsterHandle
/*    */ {
/*    */   private final int mapId;
/*    */   private final int darkMonsterTableId;
/*    */   
/*    */   public DefaultMapHandle(int mapId, int darkMonsterTableId)
/*    */   {
/* 15 */     this.mapId = mapId;
/* 16 */     this.darkMonsterTableId = darkMonsterTableId;
/*    */   }
/*    */   
/*    */ 
/*    */   public int handle(long roleId, MeetDarkMonsterHandle.MeetDarkMonsterHandleContext context)
/*    */   {
/* 22 */     MapPrototype protoType = MapCfgManager.getInstance().getMapProtoById(this.mapId);
/* 23 */     if (protoType == null)
/*    */     {
/* 25 */       return 0;
/*    */     }
/*    */     
/* 28 */     int fightCfgid = MapObjectManager.getInstance().getDarkMonsterFightId(this.darkMonsterTableId);
/* 29 */     if (fightCfgid < -1)
/*    */     {
/* 31 */       return 0;
/*    */     }
/*    */     
/* 34 */     context.reason = FightReason.NORMAL_DARK_MONSTER_FIGHT;
/*    */     
/* 36 */     return fightCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\darkmonsterhandle\DefaultMapHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */