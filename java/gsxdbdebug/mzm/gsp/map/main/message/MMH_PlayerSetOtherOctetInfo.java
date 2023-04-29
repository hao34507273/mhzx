/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_PlayerSetOtherOctetInfo
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final Octets octets;
/*    */   private final int protoType;
/*    */   
/*    */   public MMH_PlayerSetOtherOctetInfo(long roleId, int protoType, Octets octets)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.octets = octets;
/* 18 */     this.protoType = protoType;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 24 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 25 */     if (role == null)
/*    */     {
/* 27 */       return;
/*    */     }
/* 29 */     if (this.octets != null)
/*    */     {
/* 31 */       role.setOtherOctetsInfo(this.protoType, this.octets);
/*    */     }
/*    */     else
/*    */     {
/* 35 */       role.unsetOtherOctetsInfo(this.protoType);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerSetOtherOctetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */