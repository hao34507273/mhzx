/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public class MMH_FindMonster extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleid;
/*    */   private final int monsterCfgid;
/*    */   private final int order;
/*    */   
/*    */   public MMH_FindMonster(long gmRoleId, long roleid, int monsterCfgid, int order)
/*    */   {
/* 21 */     this.gmRoleId = gmRoleId;
/* 22 */     this.roleid = roleid;
/* 23 */     this.monsterCfgid = monsterCfgid;
/* 24 */     this.order = order;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 30 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 31 */     if (role == null)
/*    */     {
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     List<MapMonster> monsterList = MapObjectInstanceManager.getInstance().getMonsterListByCfgId(this.monsterCfgid);
/* 37 */     if (monsterList.size() < this.order)
/*    */     {
/* 39 */       Protocol gmRes = GmManager.getInstance().makeGMResult("only have " + monsterList.size() + " monster");
/* 40 */       MapProtocolSendQueue.getInstance().send(this.gmRoleId, gmRes);
/*    */       
/* 42 */       return;
/*    */     }
/*    */     
/* 45 */     MapMonster mm = (MapMonster)monsterList.get(this.order - 1);
/* 46 */     Position pos = mm.getPositionForInner();
/* 47 */     role.teleportWithProtocol(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getSceneId(), TransferType.GM);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_FindMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */