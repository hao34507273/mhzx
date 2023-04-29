/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.message.MMH_TransformMapReq;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PTransformMapReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int mapCfgid;
/*    */   private final int targetPosX;
/*    */   private final int targetPosY;
/*    */   
/*    */   public PTransformMapReq(long paramLong, int paramInt1, int paramInt2, int paramInt3)
/*    */   {
/* 18 */     this.roleid = paramLong;
/* 19 */     this.mapCfgid = paramInt1;
/* 20 */     this.targetPosX = paramInt2;
/* 21 */     this.targetPosY = paramInt3;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 25 */     if (!MapManager.canDoAction(this.roleid, 168)) {
/* 26 */       GameServer.logger().error(String.format("[map]PTransformMapReq.processImp@can not do action|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgid), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 27 */       return false;
/*    */     }
/* 29 */     if (!MapManager.guajiMapIsOpen(this.roleid, this.mapCfgid)) {
/* 30 */       GameServer.logger().error(String.format("[map]PTransformMapReq.processImp@guaji map is not open|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgid), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 31 */       return false;
/*    */     }
/* 33 */     if (!MapPrototype.canDirectTransfer(this.mapCfgid)) {
/* 34 */       GameServer.logger().error(String.format("[map]PTransformMapReq.processImp@can not transfer directly|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgid), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 35 */       return false;
/*    */     }
/* 37 */     if (MapPrototype.isHomelandMap(this.mapCfgid)) {
/* 38 */       GameServer.logger().error(String.format("[map]PTransformMapReq.processImp@go to homeland invalid|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgid), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 39 */       return false;
/*    */     }
/* 41 */     MMH_TransformMapReq localMMH_TransformMapReq = new MMH_TransformMapReq(this.roleid, this.mapCfgid, this.targetPosX, this.targetPosY);
/* 42 */     GameServer.logger().error(String.format("[map]PTransformMapReq.processImp@MMH_TransformMapReq execute|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgid), Integer.valueOf(this.targetPosX), Integer.valueOf(this.targetPosY) }));
/* 43 */     localMMH_TransformMapReq.execute();
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PTransformMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */