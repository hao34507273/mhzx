/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.SSyncRoleStatusChange;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MMH_SetMapRoleStatus
/*    */   extends AbstractMapMsgHandler
/*    */ {
/* 19 */   private List<Integer> addStatusList = new ArrayList();
/* 20 */   private List<Integer> remStatusList = new ArrayList();
/*    */   private long roleId;
/*    */   
/*    */   public MMH_SetMapRoleStatus(List<Integer> addStatusList, List<Integer> remStatusList, long roleId)
/*    */   {
/* 25 */     this.addStatusList = addStatusList;
/* 26 */     this.remStatusList = remStatusList;
/* 27 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 33 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 34 */     if (role == null)
/*    */     {
/* 36 */       return;
/*    */     }
/*    */     
/* 39 */     if (this.addStatusList.contains(Integer.valueOf(0)))
/*    */     {
/* 41 */       role.notifyOtherInFight();
/* 42 */       role.updateMovePath(Collections.emptyList());
/*    */     }
/* 44 */     else if (this.remStatusList.contains(Integer.valueOf(0)))
/*    */     {
/* 46 */       role.notifyOtherOutFight();
/* 47 */       role.setMoveDistance(0);
/*    */     }
/*    */     
/* 50 */     if ((this.addStatusList.contains(Integer.valueOf(32))) || (this.addStatusList.contains(Integer.valueOf(33))))
/*    */     {
/*    */ 
/* 53 */       role.setHusongState(true, false);
/*    */     }
/* 55 */     else if ((this.remStatusList.contains(Integer.valueOf(32))) || (this.remStatusList.contains(Integer.valueOf(33))))
/*    */     {
/*    */ 
/* 58 */       if (role.setHusongState(false, true))
/*    */       {
/* 60 */         role.unsetHuSong();
/*    */       }
/*    */     }
/*    */     
/* 64 */     if (this.addStatusList.contains(Integer.valueOf(97)))
/*    */     {
/* 66 */       role.setState(32);
/*    */     }
/* 68 */     else if (this.remStatusList.contains(Integer.valueOf(97)))
/*    */     {
/* 70 */       role.unsetState(32);
/*    */     }
/*    */     
/* 73 */     if (this.remStatusList.contains(Integer.valueOf(2)))
/*    */     {
/*    */ 
/* 76 */       role.tryEnterZone();
/*    */       
/*    */ 
/* 79 */       role.tryShowFollower();
/*    */     }
/*    */     
/* 82 */     role.updateStatusSet(this.addStatusList, this.remStatusList);
/*    */     
/* 84 */     SSyncRoleStatusChange syncRoleStatusChange = new SSyncRoleStatusChange();
/* 85 */     syncRoleStatusChange.addlist.addAll(this.addStatusList);
/* 86 */     syncRoleStatusChange.removelist.addAll(this.remStatusList);
/* 87 */     syncRoleStatusChange.roleid = role.getRoleId();
/* 88 */     role.broadcastProtocolIncludeSelf(syncRoleStatusChange);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SetMapRoleStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */