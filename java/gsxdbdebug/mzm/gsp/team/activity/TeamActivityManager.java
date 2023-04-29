/*    */ package mzm.gsp.team.activity;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.RoleInfo;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class TeamActivityManager
/*    */ {
/* 14 */   private static int FLUSH_NUM = 8;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getFlushNum()
/*    */   {
/* 23 */     return FLUSH_NUM;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void fillRoleInfo(long roleId, RoleInfo roleInfo)
/*    */   {
/* 36 */     Role role = RoleInterface.getRole(roleId, false);
/* 37 */     roleInfo.gender = role.getGender();
/* 38 */     roleInfo.level = role.getLevel();
/* 39 */     roleInfo.menpai = role.getOccupationId();
/* 40 */     roleInfo.name = role.getName();
/* 41 */     roleInfo.roleid = roleId;
/* 42 */     roleInfo.avatarid = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(roleId, false);
/* 43 */     roleInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static List<Long> getRefreshMembers(List<Long> members, long selfMember)
/*    */   {
/* 54 */     List<Long> membersSelect = new ArrayList();
/* 55 */     if ((members == null) || (members.size() == 0))
/*    */     {
/* 57 */       return membersSelect;
/*    */     }
/* 59 */     if (selfMember != 0L)
/*    */     {
/* 61 */       members.remove(Long.valueOf(selfMember));
/*    */     }
/* 63 */     if (members.size() <= getFlushNum())
/*    */     {
/* 65 */       membersSelect.addAll(members);
/*    */     }
/*    */     else
/*    */     {
/* 69 */       List<Long> membersCopy = new ArrayList(members);
/*    */       for (;;)
/*    */       {
/* 72 */         int step = 1;
/* 73 */         int seed = membersCopy.size();
/* 74 */         Random r = Xdb.random();
/* 75 */         int ran = r.nextInt(seed);
/*    */         
/* 77 */         long teamId = ((Long)membersCopy.get(ran)).longValue();
/* 78 */         membersSelect.add(Long.valueOf(teamId));
/*    */         
/* 80 */         membersCopy.remove(ran);
/*    */         
/* 82 */         if ((membersSelect.size() >= getFlushNum()) || (step >= 20)) {
/*    */           break;
/*    */         }
/*    */         
/* 86 */         step++;
/*    */       }
/*    */     }
/* 89 */     return membersSelect;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\activity\TeamActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */