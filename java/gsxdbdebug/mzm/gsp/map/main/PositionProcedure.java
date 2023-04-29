/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import xbean.Location;
/*    */ 
/*    */ public class PositionProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int x;
/*    */   private final int y;
/*    */   private final int z;
/*    */   private final int sceneId;
/*    */   
/*    */   public PositionProcedure(long roleId, int x, int y, int z, int sceneId)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.x = x;
/* 18 */     this.y = y;
/* 19 */     this.z = z;
/* 20 */     this.sceneId = sceneId;
/*    */   }
/*    */   
/*    */   public PositionProcedure(long roleId, Position position)
/*    */   {
/* 25 */     this(roleId, position.getX(), position.getY(), position.getZ(), position.getSceneId());
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (this.roleId < 0L)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     xbean.Properties xProperties = xtable.Role2properties.get(Long.valueOf(this.roleId));
/* 37 */     if (xProperties == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     Location xLocation = xProperties.getLocation();
/* 43 */     xLocation.setSceneid(this.sceneId);
/* 44 */     xLocation.setX(this.x);
/* 45 */     xLocation.setY(this.y);
/* 46 */     xLocation.setZ(this.z);
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PositionProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */