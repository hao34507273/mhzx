/*    */ package mzm.gsp.interaction.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import mzm.gsp.interaction.RoleListItem;
/*    */ import mzm.gsp.interaction.SGetInteractionTargetList;
/*    */ import mzm.gsp.interaction.confbean.SInteractionCfg;
/*    */ import mzm.gsp.interaction.confbean.SInteractionConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGetInteractionTargetList
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int interactionId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGetInteractionTargetList(int interactionId, long roleId)
/*    */   {
/* 28 */     this.interactionId = interactionId;
/* 29 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if (!InteractionManager.isEnable()) {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!InteractionManager.meetLevelCondition(this.roleId)) {
/* 39 */       return false;
/*    */     }
/* 41 */     SInteractionCfg interactionCfg = SInteractionCfg.get(this.interactionId);
/* 42 */     if (interactionCfg == null) {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if ((RoleStatusInterface.containsStatus(this.roleId, 1831)) || (RoleStatusInterface.containsStatus(this.roleId, 1832)))
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1831, false))
/*    */     {
/* 53 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 57 */     Collection<Long> inViewRoleIds = MapInterface.getRolesInSomebodyView(this.roleId);
/*    */     
/* 59 */     int roleGender = RoleInterface.getGender(this.roleId);
/* 60 */     int openLevel = SInteractionConsts.getInstance().OPEN_LEVEL;
/* 61 */     boolean allowSameGender = interactionCfg.targetCanBeSameGender;
/*    */     
/* 63 */     SGetInteractionTargetList list = new SGetInteractionTargetList();
/* 64 */     list.interaction_id = this.interactionId;
/*    */     
/* 66 */     for (Long targetRoleId : inViewRoleIds)
/*    */     {
/* 68 */       if (OnlineManager.getInstance().isOnline(targetRoleId.longValue()))
/*    */       {
/* 70 */         int targetLevel = RoleInterface.getLevel(targetRoleId.longValue());
/* 71 */         if (targetLevel >= openLevel)
/*    */         {
/* 73 */           int targetGender = RoleInterface.getGender(targetRoleId.longValue());
/* 74 */           if ((allowSameGender) || (targetGender != roleGender))
/*    */           {
/*    */ 
/* 77 */             String targetName = RoleInterface.getName(targetRoleId.longValue());
/* 78 */             if (targetName != null)
/*    */             {
/*    */ 
/* 81 */               RoleListItem item = new RoleListItem();
/* 82 */               item.role_id = targetRoleId.longValue();
/* 83 */               item.role_name.setString(targetName, "UTF-8");
/* 84 */               item.role_level = targetLevel;
/* 85 */               item.occupation_id = RoleInterface.getOccupationId(targetRoleId.longValue());
/* 86 */               item.gender = targetGender;
/* 87 */               item.avatar_id = AvatarInterface.getCurrentAvatar(targetRoleId.longValue(), false);
/* 88 */               item.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(targetRoleId.longValue(), false);
/* 89 */               list.target_list.add(item);
/*    */             }
/*    */           } } } }
/* 92 */     OnlineManager.getInstance().send(this.roleId, list);
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\PGetInteractionTargetList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */