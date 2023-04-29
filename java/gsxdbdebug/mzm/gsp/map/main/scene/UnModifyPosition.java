/*    */ package mzm.gsp.map.main.scene;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UnModifyPosition
/*    */   extends Position
/*    */ {
/*    */   public UnModifyPosition(Position position)
/*    */   {
/* 10 */     super(position.getX(), position.getY(), position.getZ(), position.getSceneId());
/*    */   }
/*    */   
/*    */ 
/*    */   public void setXYZ(int x, int y, int z)
/*    */   {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setY(int y)
/*    */   {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setX(int x)
/*    */   {
/* 28 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setZ(int z)
/*    */   {
/* 34 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */ 
/*    */   public void setSceneId(int id)
/*    */   {
/* 40 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\UnModifyPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */