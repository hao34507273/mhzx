/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.group.MapGroupManager;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ 
/*    */ 
/*    */ public class MMH_CreateMapGroup
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final MapGroupType groupType;
/*    */   private final long groupid;
/*    */   private final Map<Integer, Integer> groupExtraInfos;
/*    */   private final List<Long> roleids;
/*    */   private final int groupSpeed;
/*    */   
/*    */   public MMH_CreateMapGroup(MapGroupType groupType, long groupid, List<Long> roleids, int groupSpeed, Map<Integer, Integer> groupExtraInfos)
/*    */   {
/* 20 */     this.groupType = groupType;
/* 21 */     this.groupid = groupid;
/* 22 */     this.groupExtraInfos = groupExtraInfos;
/* 23 */     this.roleids = roleids;
/* 24 */     this.groupSpeed = groupSpeed;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 30 */     MapGroupManager.getInstance().addGroupData(this.groupType, this.groupid, this.roleids, this.groupSpeed, this.groupExtraInfos);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_CreateMapGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */