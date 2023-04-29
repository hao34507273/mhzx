/*    */ package mzm.gsp.map.main.scene.view;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.map.main.scene.object.SceneObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActiveMonsterView
/*    */   extends CircleView
/*    */ {
/*    */   private final int attackRadiusSquare;
/* 21 */   private final Map<Long, MapRole> attackablePlayer = new HashMap();
/*    */   
/*    */   public ActiveMonsterView(SceneObject owner, int radius, int attackRadius)
/*    */   {
/* 25 */     super(owner, radius);
/*    */     
/* 27 */     this.attackRadiusSquare = (attackRadius * attackRadius);
/*    */   }
/*    */   
/*    */ 
/*    */   public int onEnter(SceneObject enterObj, boolean delaySync)
/*    */   {
/* 33 */     if ((enterObj instanceof MapRole))
/*    */     {
/* 35 */       MapRole role = (MapRole)enterObj;
/* 36 */       if (getDistanceSquare(enterObj) <= this.attackRadiusSquare)
/*    */       {
/* 38 */         this.attackablePlayer.put(Long.valueOf(role.getRoleId()), role);
/*    */       }
/*    */       else
/*    */       {
/* 42 */         this.attackablePlayer.remove(Long.valueOf(role.getRoleId()));
/*    */       }
/*    */     }
/*    */     
/* 46 */     return super.onEnter(enterObj, delaySync);
/*    */   }
/*    */   
/*    */ 
/*    */   public int onMove(SceneObject moveObj, boolean delaySync)
/*    */   {
/* 52 */     if ((moveObj instanceof MapRole))
/*    */     {
/* 54 */       MapRole role = (MapRole)moveObj;
/* 55 */       if (getDistanceSquare(moveObj) <= this.attackRadiusSquare)
/*    */       {
/* 57 */         this.attackablePlayer.put(Long.valueOf(role.getRoleId()), role);
/*    */       }
/*    */       else
/*    */       {
/* 61 */         this.attackablePlayer.remove(Long.valueOf(role.getRoleId()));
/*    */       }
/*    */     }
/*    */     
/* 65 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int onLeave(SceneObject leaveObj, boolean delaySync)
/*    */   {
/* 71 */     if ((leaveObj instanceof MapRole))
/*    */     {
/* 73 */       MapRole role = (MapRole)leaveObj;
/* 74 */       this.attackablePlayer.remove(Long.valueOf(role.getRoleId()));
/*    */     }
/*    */     
/* 77 */     return super.onLeave(leaveObj, delaySync);
/*    */   }
/*    */   
/*    */   public Collection<MapRole> getAttackablePlayer()
/*    */   {
/* 82 */     return this.attackablePlayer.values();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\view\ActiveMonsterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */