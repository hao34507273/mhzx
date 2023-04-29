/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.PRemoveMapGroup;
/*    */ import mzm.gsp.map.main.group.MapGroupData;
/*    */ import mzm.gsp.map.main.group.MapGroupManager;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_RemoveMapGroupByRoleid extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public MMH_RemoveMapGroupByRoleid(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 24 */     MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 25 */     if (mapRole == null)
/*    */     {
/* 27 */       return;
/*    */     }
/*    */     
/* 30 */     long groupid = mapRole.getGroupid();
/*    */     
/* 32 */     MapGroupType mapGroupType = mapRole.getGroupType();
/* 33 */     if ((groupid == -1L) || (mapGroupType == MapGroupType.UNKNOWN))
/*    */     {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     MapGroupData mapGroupData = MapGroupManager.getInstance().getMapGroupData(mapGroupType, groupid);
/* 39 */     if (mapGroupData == null)
/*    */     {
/* 41 */       return;
/*    */     }
/*    */     
/* 44 */     List<Long> roles = new ArrayList(mapGroupData.getOtherMemebersForInner());
/* 45 */     roles.add(Long.valueOf(mapGroupData.getLeaderid()));
/*    */     
/*    */ 
/* 48 */     new PRemoveMapGroup(mapGroupType, groupid, roles).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RemoveMapGroupByRoleid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */