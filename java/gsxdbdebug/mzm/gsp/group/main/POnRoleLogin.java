/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.group.SSynRoleMessageState;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.Group;
/*    */ import xbean.GroupInfo;
/*    */ import xbean.GroupSetting;
/*    */ import xtable.Groups;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 24 */     GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(roleid));
/* 25 */     if (xGroupInfo == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (GroupManager.isGroupSwitchOpenForRole(roleid, false))
/*    */     {
/* 32 */       GroupAsynTaskManager.getInstance().addTask(new POfflineGroupInfoNotifyOnRoleLogin(roleid, xGroupInfo.getOffline_group_join_infos(), xGroupInfo.getOffline_group_kick_infos(), xGroupInfo.getOffline_group_dissolve_infos()));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 38 */     SSynRoleMessageState protocol = new SSynRoleMessageState();
/* 39 */     Iterator<Long> iteratorCreate = xGroupInfo.getCreate_same_zone_groupids().keySet().iterator();
/* 40 */     while (iteratorCreate.hasNext())
/*    */     {
/* 42 */       long groupid = ((Long)iteratorCreate.next()).longValue();
/* 43 */       Group xGroup = Groups.select(Long.valueOf(groupid));
/* 44 */       if ((xGroup == null) || (xGroup.getMasterid() != roleid))
/*    */       {
/* 46 */         iteratorCreate.remove();
/*    */       }
/*    */       else {
/* 49 */         protocol.groupid2message_state.put(Long.valueOf(groupid), Integer.valueOf(((GroupSetting)xGroupInfo.getCreate_same_zone_groupids().get(Long.valueOf(groupid))).getMessage_state()));
/*    */       }
/*    */     }
/*    */     
/* 53 */     Iterator<Long> iteratorJoin = xGroupInfo.getJoin_same_zone_groupids().keySet().iterator();
/* 54 */     while (iteratorJoin.hasNext())
/*    */     {
/* 56 */       long groupid = ((Long)iteratorJoin.next()).longValue();
/* 57 */       Group xGroup = Groups.select(Long.valueOf(groupid));
/* 58 */       if ((xGroup == null) || (!xGroup.getMemberlist().contains(Long.valueOf(roleid))))
/*    */       {
/* 60 */         iteratorJoin.remove();
/*    */       }
/*    */       else
/* 63 */         protocol.groupid2message_state.put(Long.valueOf(groupid), Integer.valueOf(((GroupSetting)xGroupInfo.getJoin_same_zone_groupids().get(Long.valueOf(groupid))).getMessage_state()));
/*    */     }
/* 65 */     GroupAsynTaskManager.getInstance().addTask(new PMemberOnlineStateChangeNotify(roleid, xGroupInfo.getCreate_same_zone_groupids().keySet(), xGroupInfo.getJoin_same_zone_groupids().keySet(), 1));
/*    */     
/*    */ 
/*    */ 
/* 69 */     if (GroupManager.isGroupSwitchOpenForRole(roleid, false))
/*    */     {
/* 71 */       OnlineManager.getInstance().send(roleid, protocol);
/*    */     }
/*    */     
/* 74 */     xGroupInfo.getOffline_group_join_infos().clear();
/* 75 */     xGroupInfo.getOffline_group_kick_infos().clear();
/* 76 */     xGroupInfo.getOffline_group_dissolve_infos().clear();
/*    */     
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */