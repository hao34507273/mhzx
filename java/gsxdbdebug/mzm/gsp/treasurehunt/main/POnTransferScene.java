/*    */ package mzm.gsp.treasurehunt.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*    */ import mzm.gsp.treasurehunt.confbean.ControllerId2Num;
/*    */ import mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg;
/*    */ import xbean.Role2TreasureHuntWorldInfo;
/*    */ 
/*    */ public class POnTransferScene extends PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if (((MapTransferArg)this.arg).roleList.isEmpty())
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     long roleId = ((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue();
/* 20 */     Role2TreasureHuntWorldInfo xRole2TreasureHuntWorldInfo = xtable.Role2treasurehuntworld.get(Long.valueOf(roleId));
/* 21 */     if (xRole2TreasureHuntWorldInfo == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (xRole2TreasureHuntWorldInfo.getWorld_id() != ((MapTransferArg)this.arg).newWorldId)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     STreasureHuntChapterCfg sTreasureHuntChapterCfg = STreasureHuntChapterCfg.get(xRole2TreasureHuntWorldInfo.getChapter_cfg_id());
/* 32 */     if (sTreasureHuntChapterCfg == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (sTreasureHuntChapterCfg.map_cfg_id != ((MapTransferArg)this.arg).newMapCfgId)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     mzm.gsp.map.main.MapInterface.destroyScene(((MapTransferArg)this.arg).newWorldId, ((MapTransferArg)this.arg).oldMapCfgId, null);
/*    */     
/* 45 */     for (ControllerId2Num controllerId2Num : sTreasureHuntChapterCfg.controllerList)
/*    */     {
/* 47 */       mzm.gsp.map.main.ControllerInterface.triggerWorldControllerWithMaxSpawnNum(xRole2TreasureHuntWorldInfo.getWorld_id(), controllerId2Num.controllerId, controllerId2Num.num);
/*    */     }
/*    */     
/*    */ 
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */