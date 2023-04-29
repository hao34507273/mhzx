/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.item.event.FlowerReceivePointChangedArg;
/*    */ import mzm.gsp.item.event.FlowerReceivePointChangedEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnFlowerReceivePointChange extends FlowerReceivePointChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((FlowerReceivePointChangedArg)this.arg).roleId;
/* 13 */     String userId = RoleInterface.getUserId(roleId);
/*    */     
/* 15 */     int newPoint = ((FlowerReceivePointChangedArg)this.arg).newPoint;
/* 16 */     long expireTime = TimeUnit.MILLISECONDS.toSeconds(((FlowerReceivePointChangedArg)this.arg).endEffectTime);
/*    */     
/* 18 */     return MSDKProfileManager.reportRoleRankScore(userId, roleId, newPoint, expireTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnFlowerReceivePointChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */