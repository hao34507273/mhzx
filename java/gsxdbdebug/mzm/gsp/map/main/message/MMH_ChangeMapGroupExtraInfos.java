/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.main.group.MapGroupManager;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ 
/*    */ 
/*    */ public class MMH_ChangeMapGroupExtraInfos
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final MapGroupType groupType;
/*    */   private final long groupid;
/*    */   private Map<Integer, Integer> replaceExtraInfoEntries;
/*    */   private Set<Integer> removeExtraInfoKeys;
/*    */   
/*    */   public MMH_ChangeMapGroupExtraInfos(MapGroupType groupType, long groupid, Map<Integer, Integer> replaceExtraInfoEntries, Set<Integer> removeExtraInfoKeys)
/*    */   {
/* 19 */     this.groupType = groupType;
/* 20 */     this.groupid = groupid;
/* 21 */     this.replaceExtraInfoEntries = replaceExtraInfoEntries;
/* 22 */     this.removeExtraInfoKeys = removeExtraInfoKeys;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 28 */     MapGroupManager.getInstance().changeMapGroupExtraInfos(this.groupType, this.groupid, this.replaceExtraInfoEntries, this.removeExtraInfoKeys);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_ChangeMapGroupExtraInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */