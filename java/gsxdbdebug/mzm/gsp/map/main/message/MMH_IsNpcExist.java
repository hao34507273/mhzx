/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ 
/*    */ public class MMH_IsNpcExist
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int npcCfgId;
/*  9 */   private boolean result = false;
/*    */   
/*    */   public MMH_IsNpcExist(int npcCfgId)
/*    */   {
/* 13 */     this.npcCfgId = npcCfgId;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 18 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 24 */     this.result = (MapObjectInstanceManager.getInstance().getNPCByCfgId(this.npcCfgId) != null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsNpcExist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */