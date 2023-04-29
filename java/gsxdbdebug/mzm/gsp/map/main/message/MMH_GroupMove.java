/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.Location;
/*    */ import mzm.gsp.map.main.group.MapGroupData;
/*    */ import mzm.gsp.map.main.group.MapGroupManager;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ 
/*    */ public class MMH_GroupMove
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final MapGroupType groupType;
/*    */   private final long groupid;
/*    */   private final List<Location> keyPathList;
/*    */   
/*    */   public MMH_GroupMove(MapGroupType groupType, long groupid, List<Location> keyPathList)
/*    */   {
/* 18 */     this.groupType = groupType;
/* 19 */     this.groupid = groupid;
/* 20 */     this.keyPathList = keyPathList;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 26 */     MapGroupData groupData = MapGroupManager.getInstance().getMapGroupData(this.groupType, this.groupid);
/* 27 */     if (groupData == null)
/*    */     {
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     long leaderid = groupData.getLeaderid();
/* 33 */     new MMH_PlayerMove(leaderid, this.keyPathList).doProcess();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GroupMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */