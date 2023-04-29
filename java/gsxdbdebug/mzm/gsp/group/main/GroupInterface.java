/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import xbean.Group;
/*    */ import xbean.GroupInfo;
/*    */ import xtable.Groups;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GroupInterface
/*    */ {
/*    */   public static boolean isRoleInGroup(long roleid, long groupid)
/*    */   {
/* 23 */     return GroupManager.isRoleInGroup(roleid, groupid, true);
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
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isRoleInGroup(long roleid, long groupid, boolean remainLock)
/*    */   {
/* 39 */     return GroupManager.isRoleInGroup(roleid, groupid, remainLock);
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
/*    */ 
/*    */ 
/*    */   public static List<Long> getRoleGroupList(long roleid, boolean remainLock)
/*    */   {
/* 54 */     List<Long> groupList = new ArrayList();
/* 55 */     GroupInfo xGroupInfo = null;
/* 56 */     if (remainLock)
/*    */     {
/* 58 */       xGroupInfo = Role2groupinfo.get(Long.valueOf(roleid));
/*    */     }
/*    */     else
/*    */     {
/* 62 */       xGroupInfo = Role2groupinfo.select(Long.valueOf(roleid));
/*    */     }
/* 64 */     if (xGroupInfo != null)
/*    */     {
/* 66 */       groupList.addAll(xGroupInfo.getCreate_same_zone_groupids().keySet());
/* 67 */       groupList.addAll(xGroupInfo.getJoin_same_zone_groupids().keySet());
/*    */     }
/* 69 */     return groupList;
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
/*    */ 
/*    */ 
/*    */   public static List<Long> getGroupMemberList(long groupid, boolean remainLock)
/*    */   {
/* 84 */     Group xGroup = null;
/* 85 */     if (remainLock)
/*    */     {
/* 87 */       xGroup = Groups.get(Long.valueOf(groupid));
/*    */     }
/*    */     else
/*    */     {
/* 91 */       xGroup = Groups.select(Long.valueOf(groupid));
/*    */     }
/* 93 */     List<Long> memberList = new ArrayList();
/* 94 */     if (xGroup != null)
/*    */     {
/* 96 */       memberList.addAll(xGroup.getMemberlist());
/*    */     }
/* 98 */     return memberList;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\GroupInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */