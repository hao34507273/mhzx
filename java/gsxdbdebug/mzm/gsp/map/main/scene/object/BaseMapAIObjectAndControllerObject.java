/*    */ package mzm.gsp.map.main.scene.object;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.ai.IMapAIObject;
/*    */ import mzm.gsp.map.main.controller.IControllerObject;
/*    */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*    */ import mzm.gsp.map.main.scene.view.IView;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public abstract class BaseMapAIObjectAndControllerObject extends SceneObject implements IMapAIObject, IControllerObject
/*    */ {
/* 14 */   protected int controllerId = -1;
/*    */   
/* 16 */   protected long stayTime = -1L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<? extends SceneObject> refresh(long worldId, int maxSpawnNum)
/*    */   {
/* 25 */     this.isVisible = true;
/*    */     
/* 27 */     syncView();
/*    */     
/* 29 */     notifyBorn();
/*    */     
/* 31 */     return java.util.Arrays.asList(new BaseMapAIObjectAndControllerObject[] { this });
/*    */   }
/*    */   
/*    */ 
/*    */   public void stay(long time)
/*    */   {
/* 37 */     this.stayTime = time;
/*    */   }
/*    */   
/*    */ 
/*    */   public long getStayTime()
/*    */   {
/* 43 */     return this.stayTime;
/*    */   }
/*    */   
/*    */   protected void sendToView(Protocol protocol)
/*    */   {
/* 48 */     Collection<MapRole> roles = this.view.getPlayers();
/* 49 */     List<Long> ids = new ArrayList();
/* 50 */     for (MapRole role : roles)
/*    */     {
/* 52 */       ids.add(Long.valueOf(role.getRoleId()));
/*    */     }
/* 54 */     MapProtocolSendQueue.getInstance().sendMulti(ids, protocol);
/*    */   }
/*    */   
/*    */   private void syncView()
/*    */   {
/* 59 */     for (MapRole role : getView().getPlayers())
/*    */     {
/*    */ 
/* 62 */       role.updateView();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\BaseMapAIObjectAndControllerObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */