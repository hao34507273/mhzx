/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapManager;
/*    */ 
/*    */ public class MMH_IsNearByNPC
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_IsNearByNPC>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int npcid;
/*    */   private final MapCallback<Boolean> callback;
/* 12 */   private boolean result = false;
/*    */   
/*    */   public MMH_IsNearByNPC(long roleid, int npcid)
/*    */   {
/* 16 */     this(roleid, npcid, null);
/*    */   }
/*    */   
/*    */   public MMH_IsNearByNPC(long roleid, int npcid, MapCallback<Boolean> callback)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.npcid = npcid;
/* 23 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 28 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 34 */     this.result = MapManager.isNearByNPC(this.roleid, this.npcid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_IsNearByNPC> getMapMsgHandlerDone()
/*    */   {
/* 41 */     if (this.callback == null)
/*    */     {
/* 43 */       return null;
/*    */     }
/*    */     
/* 46 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 52 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_IsNearByNPC mmh)
/*    */     throws Exception
/*    */   {
/* 58 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsNearByNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */