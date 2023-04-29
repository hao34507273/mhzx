/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public class MMH_BroadcastInSight extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final Protocol protocol;
/*    */   private final boolean includeSelf;
/*    */   
/*    */   public MMH_BroadcastInSight(long roleid, Protocol p, boolean includeSelf)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.protocol = p;
/* 16 */     this.includeSelf = includeSelf;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 22 */     MapRole mapRole = mzm.gsp.map.main.MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 23 */     if (this.includeSelf)
/*    */     {
/* 25 */       mapRole.broadcastProtocolIncludeSelf(this.protocol);
/*    */     }
/*    */     else
/*    */     {
/* 29 */       mapRole.broadcastProtocol(this.protocol);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_BroadcastInSight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */