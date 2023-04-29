/*    */ package mzm.gsp.map.main.group;
/*    */ 
/*    */ import mzm.gsp.map.main.SpaceBitMask;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum MapGroupType
/*    */ {
/* 11 */   MGT_TEAM(3), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 16 */   MGT_COUPLE_FLY(2), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   MGT_MARRIAGE(1), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   MGT_WATCH_MOON_XYXW_FLY(2), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   MGT_WATCH_MOON_SIDE_BY_SIDE_FLY(2), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   MGT_GROUP_WEDDING(1), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   UNKNOWN(3);
/*    */   
/*    */   private final int spaceFlags;
/*    */   
/*    */   private MapGroupType(int spaceFlags)
/*    */   {
/* 47 */     this.spaceFlags = spaceFlags;
/*    */   }
/*    */   
/*    */   public boolean isFlyable()
/*    */   {
/* 52 */     return SpaceBitMask.isSkyValid(this.spaceFlags);
/*    */   }
/*    */   
/*    */   public static TransferType getTransferType(MapGroupType groupType)
/*    */   {
/* 57 */     return TransferType.getTransferType(groupType.ordinal() + TransferType.TEAM.ordinal());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\group\MapGroupType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */