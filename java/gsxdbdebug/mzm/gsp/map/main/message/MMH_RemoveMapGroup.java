/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.main.group.MapGroupManager;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ 
/*    */ 
/*    */ public class MMH_RemoveMapGroup
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final MapGroupType groupType;
/*    */   private final long groupid;
/*    */   private Map<Long, Integer> nowFlyings;
/*    */   private Set<Long> offlines;
/*    */   
/*    */   public MMH_RemoveMapGroup(MapGroupType groupType, long groupid, Map<Long, Integer> nowFlyings, Set<Long> offlineRoles)
/*    */   {
/* 19 */     this.groupType = groupType;
/* 20 */     this.groupid = groupid;
/* 21 */     this.nowFlyings = nowFlyings;
/* 22 */     this.offlines = offlineRoles;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 28 */     MapGroupManager.getInstance().removeGroupData(this.groupType, this.groupid, this.nowFlyings, this.offlines);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RemoveMapGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */