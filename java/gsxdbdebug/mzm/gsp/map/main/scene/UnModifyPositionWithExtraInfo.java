/*    */ package mzm.gsp.map.main.scene;
/*    */ 
/*    */ public class UnModifyPositionWithExtraInfo extends PositionWithExtraInfo
/*    */ {
/*    */   public UnModifyPositionWithExtraInfo(PositionWithExtraInfo pos)
/*    */   {
/*  7 */     super(pos.getX(), pos.getY(), pos.getZ(), pos.getSceneId(), pos.getMapCfgid(), pos.getChannelid());
/*    */   }
/*    */   
/*    */   public UnModifyPositionWithExtraInfo(Position pos, int mapCfgid, int channelid)
/*    */   {
/* 12 */     super(pos.getX(), pos.getY(), pos.getZ(), pos.getSceneId(), mapCfgid, channelid);
/*    */   }
/*    */   
/*    */ 
/*    */   public void setXYZ(int x, int y, int z)
/*    */   {
/* 18 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setXYZ(int x, int y, int z, int mapCfgid)
/*    */   {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setY(int y)
/*    */   {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setX(int x)
/*    */   {
/* 36 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setZ(int z)
/*    */   {
/* 42 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setSceneId(int id)
/*    */   {
/* 48 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setMapCfgid(int mapCfgid)
/*    */   {
/* 54 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setChannelid(int channelid)
/*    */   {
/* 60 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\UnModifyPositionWithExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */