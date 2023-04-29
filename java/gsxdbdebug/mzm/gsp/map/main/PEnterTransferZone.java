/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_EnterTransferZone;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PEnterTransferZone extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long worldid;
/*    */   private final Position target;
/*    */   
/*    */   public PEnterTransferZone(long roleid, long worldid, Position target)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.worldid = worldid;
/* 18 */     this.target = target;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     Position tmpTargetPosition = this.target;
/* 27 */     int targetMapCfgid = this.target.getSceneId();
/* 28 */     TransferZoneProxyHandler transferZoneProxyHandler = TransferZoneProxyHandlerManager.getInstance().getHandler(targetMapCfgid);
/*    */     
/* 30 */     if (transferZoneProxyHandler != null)
/*    */     {
/* 32 */       Position realTarget = transferZoneProxyHandler.getProxyTargetMapCfgid(this.roleid, this.worldid, targetMapCfgid);
/*    */       
/* 34 */       if (realTarget != null)
/*    */       {
/* 36 */         if ((realTarget.getX() < 0) || (realTarget.getY() < 0))
/*    */         {
/* 38 */           int realTargetMapCfgid = realTarget.getSceneId();
/* 39 */           int posX = MapPrototype.getDefaultTransferPosX(realTargetMapCfgid);
/* 40 */           int posY = MapPrototype.getDefaultTransferPosY(realTargetMapCfgid);
/* 41 */           tmpTargetPosition = new Position(posX, posY, 0, realTargetMapCfgid);
/*    */         }
/*    */         else
/*    */         {
/* 45 */           tmpTargetPosition = new Position(realTarget);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 50 */     MMH_EnterTransferZone handler = new MMH_EnterTransferZone(this.roleid, tmpTargetPosition);
/* 51 */     handler.execute();
/*    */     
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PEnterTransferZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */