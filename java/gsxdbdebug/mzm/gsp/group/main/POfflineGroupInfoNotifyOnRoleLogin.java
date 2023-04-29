/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.group.GroupJoinInfo;
/*    */ import mzm.gsp.group.GroupKickInfo;
/*    */ import mzm.gsp.group.SSynGroupDissolveInfo;
/*    */ import mzm.gsp.group.SSynGroupJoinInfo;
/*    */ import mzm.gsp.group.SSynGroupKickInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.Groups;
/*    */ 
/*    */ public class POfflineGroupInfoNotifyOnRoleLogin extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/* 20 */   private final HashMap<Long, Long> groupid2Inviter = new HashMap();
/* 21 */   private final HashMap<Long, Long> groupid2Masterid = new HashMap();
/* 22 */   private final HashMap<Long, String> groupid2GroupName = new HashMap();
/*    */   
/*    */ 
/*    */   public POfflineGroupInfoNotifyOnRoleLogin(long roleid, Map<Long, Long> offlineGroupJoinInfos, Map<Long, Long> offlineGroupKickInfos, Map<Long, String> offlineGroupsDissolveInfos)
/*    */   {
/* 27 */     this.roleid = roleid;
/* 28 */     this.groupid2Inviter.putAll(offlineGroupJoinInfos);
/* 29 */     this.groupid2Masterid.putAll(offlineGroupKickInfos);
/* 30 */     this.groupid2GroupName.putAll(offlineGroupsDissolveInfos);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     if (!GroupManager.isGroupSwitchOpenForRole(this.roleid, false))
/*    */     {
/*    */ 
/* 39 */       GroupManager.logger.info(String.format("[group]POfflineGroupInfoNotifyOnRoleLogin.processImp@group module close or role forbidden|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 42 */       return false;
/*    */     }
/* 44 */     SSynGroupJoinInfo protocolJoin = new SSynGroupJoinInfo();
/* 45 */     for (Map.Entry<Long, Long> entry : this.groupid2Inviter.entrySet())
/*    */     {
/* 47 */       String groupName = Groups.selectGroup_name((Long)entry.getKey());
/* 48 */       if ((groupName != null) && (!groupName.isEmpty()))
/*    */       {
/* 50 */         GroupJoinInfo groupJoinInfo = new GroupJoinInfo();
/* 51 */         groupJoinInfo.inviter_name.setString(RoleInterface.getName(((Long)entry.getValue()).longValue()), "UTF-8");
/* 52 */         groupJoinInfo.group_name.setString(groupName, "UTF-8");
/* 53 */         protocolJoin.group_join_infos.add(groupJoinInfo);
/*    */       }
/*    */     }
/* 56 */     if (!protocolJoin.group_join_infos.isEmpty()) {
/* 57 */       OnlineManager.getInstance().send(this.roleid, protocolJoin);
/*    */     }
/* 59 */     SSynGroupKickInfo protocolKick = new SSynGroupKickInfo();
/* 60 */     for (Map.Entry<Long, Long> entry : this.groupid2Masterid.entrySet())
/*    */     {
/* 62 */       String groupName = Groups.selectGroup_name((Long)entry.getKey());
/* 63 */       if ((groupName != null) && (!groupName.isEmpty()))
/*    */       {
/* 65 */         GroupKickInfo groupKickInfo = new GroupKickInfo();
/* 66 */         groupKickInfo.master_name.setString(RoleInterface.getName(((Long)entry.getValue()).longValue()), "UTF-8");
/* 67 */         groupKickInfo.group_name.setString(groupName, "UTF-8");
/* 68 */         protocolKick.group_kick_infos.add(groupKickInfo);
/*    */       }
/*    */     }
/* 71 */     if (!protocolKick.group_kick_infos.isEmpty()) {
/* 72 */       OnlineManager.getInstance().send(this.roleid, protocolKick);
/*    */     }
/* 74 */     SSynGroupDissolveInfo protocolDissolve = new SSynGroupDissolveInfo();
/* 75 */     for (Map.Entry<Long, String> entry : this.groupid2GroupName.entrySet())
/*    */     {
/* 77 */       Octets groupName = new Octets();
/* 78 */       groupName.setString((String)entry.getValue(), "UTF-8");
/* 79 */       protocolDissolve.group_dissolve_infos.add(groupName);
/*    */     }
/* 81 */     if (!protocolDissolve.group_dissolve_infos.isEmpty()) {
/* 82 */       OnlineManager.getInstance().send(this.roleid, protocolDissolve);
/*    */     }
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\POfflineGroupInfoNotifyOnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */