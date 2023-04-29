/*    */ package mzm.gsp.avatar.frame;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogout
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     Map<Integer, Long> xSessionMap = AvatarFrameManager.getRoleAvatarFrameSessionMap(((Long)this.arg).longValue(), true);
/* 16 */     if (xSessionMap != null)
/* 17 */       AvatarFrameExpireManager.stopSessions(xSessionMap, ((Long)this.arg).longValue());
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\POnRoleLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */