/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.drawcarnival.confbean.SOrigDrawCarnivalSpreadWealthCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DrawCarnivalActivityInfo;
/*    */ import xbean.DrawCarnivalGlobalInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PTriggerOrCollectChests
/*    */   extends LogicProcedure
/*    */ {
/*    */   final boolean isTrigger;
/*    */   
/*    */   public PTriggerOrCollectChests(boolean isTrigger)
/*    */   {
/* 21 */     this.isTrigger = isTrigger;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (GameServerInfoManager.isRoamServer())
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
/*    */ 
/*    */ 
/* 47 */     for (Map.Entry<Integer, Integer> entry : xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().entrySet())
/*    */     {
/* 49 */       int chestCount = ((Integer)entry.getValue()).intValue();
/* 50 */       if (chestCount > 0)
/*    */       {
/*    */ 
/*    */ 
/* 54 */         int randomTypeId = ((Integer)entry.getKey()).intValue();
/* 55 */         SOrigDrawCarnivalSpreadWealthCfg sOrigDrawCarnivalSpreadWealthCfg = SOrigDrawCarnivalSpreadWealthCfg.get(randomTypeId);
/* 56 */         if (sOrigDrawCarnivalSpreadWealthCfg != null)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 61 */           if (this.isTrigger)
/*    */           {
/* 63 */             ControllerInterface.triggerWorldControllerWithMaxSpawnNum(1L, sOrigDrawCarnivalSpreadWealthCfg.spreadWealthControllerId, chestCount);
/*    */ 
/*    */           }
/*    */           else
/*    */           {
/* 68 */             ControllerInterface.collectWorldController(1L, sOrigDrawCarnivalSpreadWealthCfg.spreadWealthControllerId);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PTriggerOrCollectChests.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */