/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.SSyncStartHuSong;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.object.MapNPC;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_SetHuSong extends AbstractMapMsgHandler
/*    */ {
/*    */   private long roleId;
/*    */   private int targetNpcId;
/*    */   private int coupleNpcOrFollowMonsterCfgid;
/*    */   private int gender;
/*    */   
/*    */   public MMH_SetHuSong(long roleId, int targetNpcId, int followMonsterCfgid)
/*    */   {
/* 18 */     this(roleId, targetNpcId, followMonsterCfgid, -1);
/*    */   }
/*    */   
/*    */   public MMH_SetHuSong(long roleId, int targetNpcId, int followMonsterCfgid, int gender)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.targetNpcId = targetNpcId;
/* 25 */     this.coupleNpcOrFollowMonsterCfgid = followMonsterCfgid;
/* 26 */     this.gender = gender;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 32 */     MapNPC npc = MapObjectInstanceManager.getInstance().getNPCByCfgId(this.targetNpcId);
/* 33 */     if (npc == null)
/*    */     {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 39 */     role.genHuSongNPCPath(npc);
/* 40 */     Position targetPos = role.nextHuSongTargetPosition();
/* 41 */     if (targetPos == null)
/*    */     {
/* 43 */       return;
/*    */     }
/* 45 */     role.setHuSong(this.coupleNpcOrFollowMonsterCfgid, this.gender);
/* 46 */     role.setTargetPos(targetPos);
/*    */     
/* 48 */     SSyncStartHuSong syncStartHuSong = new SSyncStartHuSong();
/* 49 */     syncStartHuSong.is_special = ((byte)(this.gender == -1 ? 0 : 1));
/* 50 */     syncStartHuSong.targetpos.x = targetPos.getX();
/* 51 */     syncStartHuSong.targetpos.y = targetPos.getY();
/* 52 */     MapProtocolSendQueue.getInstance().send(this.roleId, syncStartHuSong);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SetHuSong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */