/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalSpreadWealthControllerId2randomTypeCfgId;
/*    */ import mzm.gsp.map.confbean.SMapItemCfg;
/*    */ import mzm.gsp.map.main.GatherItemEventArg;
/*    */ import xbean.DrawCarnivalActivityInfo;
/*    */ import xbean.DrawCarnivalGlobalInfo;
/*    */ 
/*    */ public class POnGatherItem extends mzm.gsp.map.event.PlayerGatherItemSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((GatherItemEventArg)this.arg).worldId != 1L)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     SMapItemCfg mapItemCfg = SMapItemCfg.get(((GatherItemEventArg)this.arg).gatherItemCfgId);
/*    */     
/* 19 */     if (mapItemCfg == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     SDrawCarnivalSpreadWealthControllerId2randomTypeCfgId controllerId2randomTypeCfgId = SDrawCarnivalSpreadWealthControllerId2randomTypeCfgId.get(mapItemCfg.controllerId);
/*    */     
/*    */ 
/* 27 */     if (controllerId2randomTypeCfgId == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfo(true);
/* 34 */     if (xDrawCarnivalGlobalInfo == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = DrawCarnivalManager.getCurrentDrawCarnivalActivityInfo(xDrawCarnivalGlobalInfo.getActivity_id2info());
/*    */     
/* 40 */     if (xDrawCarnivalActivityInfo == null)
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     Integer xChestCount = (Integer)xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().get(Integer.valueOf(controllerId2randomTypeCfgId.randomTypeCfgId));
/*    */     
/* 47 */     if ((xChestCount == null) || (xChestCount.intValue() <= 0))
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().put(Integer.valueOf(controllerId2randomTypeCfgId.randomTypeCfgId), Integer.valueOf(xChestCount.intValue() - 1));
/*    */     
/*    */ 
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\POnGatherItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */