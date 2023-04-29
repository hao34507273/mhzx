/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapEntity;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ 
/*    */ 
/*    */ public class MMH_ChangeMapEntityExtraInfos
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_ChangeMapEntityExtraInfos>
/*    */ {
/*    */   private final MapEntityType entityType;
/*    */   private final long entityInstanceid;
/*    */   private final Map<Integer, Integer> replaceIntExtraInfoEntries;
/*    */   private final Map<Integer, Long> replaceLongExtraInfoEntries;
/*    */   private final Map<Integer, String> replaceStringExtraInfoEntries;
/*    */   private final Set<Integer> removeExtraInfoKeys;
/*    */   private final MapCallback<Boolean> callback;
/* 22 */   private boolean result = false;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public MMH_ChangeMapEntityExtraInfos(MapEntityType entityType, long entityInstanceid, Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys, MapCallback<Boolean> callback)
/*    */   {
/* 29 */     this.entityType = entityType;
/* 30 */     this.entityInstanceid = entityInstanceid;
/* 31 */     this.replaceIntExtraInfoEntries = replaceIntExtraInfoEntries;
/* 32 */     this.replaceLongExtraInfoEntries = replaceLongExtraInfoEntries;
/* 33 */     this.replaceStringExtraInfoEntries = replaceStringExtraInfoEntries;
/* 34 */     this.removeExtraInfoKeys = removeExtraInfoKeys;
/* 35 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 40 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 46 */     MapEntity entity = MapObjectInstanceManager.getInstance().getMapEntity(this.entityType.ordinal(), this.entityInstanceid);
/*    */     
/* 48 */     if (entity == null)
/*    */     {
/* 50 */       return;
/*    */     }
/*    */     
/* 53 */     if (!entity.changeExtraInfos(this.replaceIntExtraInfoEntries, this.replaceLongExtraInfoEntries, this.replaceStringExtraInfoEntries, this.removeExtraInfoKeys))
/*    */     {
/*    */ 
/* 56 */       return;
/*    */     }
/*    */     
/* 59 */     this.result = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_ChangeMapEntityExtraInfos> getMapMsgHandlerDone()
/*    */   {
/* 66 */     if (this.callback == null)
/*    */     {
/* 68 */       return null;
/*    */     }
/*    */     
/* 71 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 77 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_ChangeMapEntityExtraInfos mmh)
/*    */     throws Exception
/*    */   {
/* 83 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_ChangeMapEntityExtraInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */