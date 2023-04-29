/*    */ package mzm.gsp.greetingcard.main;
/*    */ 
/*    */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import mzm.gsp.badge.main.BadgeInterface;
/*    */ import mzm.gsp.greetingcard.SenderData;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GreetingCardManager
/*    */ {
/* 12 */   private static Logger logger = Logger.getLogger("GreetingCard");
/*    */   
/*    */   static void debug(String str)
/*    */   {
/* 16 */     if (logger.isDebugEnabled()) {
/* 17 */       logger.debug(str);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void fillSenderData(SenderData senderData, long roleId)
/*    */   {
/* 28 */     senderData.roleid = roleId;
/* 29 */     senderData.rolename = RoleInterface.getName(roleId);
/* 30 */     senderData.gender = RoleInterface.getGender(roleId);
/* 31 */     senderData.occupationid = RoleInterface.getOccupationId(roleId);
/* 32 */     senderData.level = RoleInterface.getLevel(roleId);
/* 33 */     senderData.modelid = RoleInterface.getModelId(roleId);
/* 34 */     senderData.badge.addAll(BadgeInterface.selectRoleBadgeIds(roleId));
/* 35 */     senderData.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/* 36 */     senderData.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\greetingcard\main\GreetingCardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */