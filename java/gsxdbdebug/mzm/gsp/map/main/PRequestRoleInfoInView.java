/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import mzm.gsp.map.SSyncRoleInfoInView;
/*    */ import mzm.gsp.map.SimpleRoleInfo;
/*    */ import mzm.gsp.map.main.message.MMH_GetRoleInfosInVeiw;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRequestRoleInfoInView
/*    */   extends LogicProcedure
/*    */   implements MapCallback<List<Long>>
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PRequestRoleInfoInView(long roleId)
/*    */   {
/* 28 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     new MMH_GetRoleInfosInVeiw(this.roleId, this).execute();
/*    */     
/* 36 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onResult(List<Long> rolelist)
/*    */   {
/* 48 */     if (rolelist == null)
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     SSyncRoleInfoInView infoInView = new SSyncRoleInfoInView();
/* 54 */     for (Iterator i$ = rolelist.iterator(); i$.hasNext();) { long playerId = ((Long)i$.next()).longValue();
/*    */       
/* 56 */       if ((TeamInterface.getTeamidByRoleid(playerId, false) == null) && 
/*    */       
/*    */ 
/*    */ 
/* 60 */         (playerId != this.roleId))
/*    */       {
/*    */ 
/*    */ 
/* 64 */         SimpleRoleInfo roleInfo = new SimpleRoleInfo();
/* 65 */         Role roleData = RoleInterface.getRole(playerId, false);
/* 66 */         roleInfo.level = roleData.getLevel();
/* 67 */         roleInfo.name = roleData.getName();
/* 68 */         roleInfo.gender = roleData.getGender();
/* 69 */         roleInfo.occupationid = roleData.getOccupationId();
/* 70 */         roleInfo.roleid = playerId;
/* 71 */         roleInfo.avatarid = AvatarInterface.getCurrentAvatar(playerId, false);
/* 72 */         roleInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(playerId, false);
/* 73 */         infoInView.roleinfolist.add(roleInfo);
/*    */       } }
/* 75 */     OnlineManager.getInstance().send(this.roleId, infoInView);
/*    */     
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PRequestRoleInfoInView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */