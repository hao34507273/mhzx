/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Ceremony;
/*    */ import xbean.Ceremonys;
/*    */ import xbean.MarriageParades;
/*    */ 
/*    */ public class MarriageModule implements mzm.event.Module, mzm.event.PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 17 */     MarriageManager.init();
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 39 */     mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 43 */         Ceremonys xCeremonys = xtable.Weddingceremony.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 44 */         if ((xCeremonys == null) || (xCeremonys.getCeremonys().size() == 0)) {
/* 45 */           return false;
/*    */         }
/* 47 */         Ceremony ceremony = (Ceremony)xCeremonys.getCeremonys().get(0);
/* 48 */         int level = ceremony.getLevel();
/* 49 */         int step = ceremony.getStage();
/* 50 */         Integer time = MarriageManager.getWeddingPlayCfg(level, step);
/* 51 */         if (time == null) {
/* 52 */           GameServer.logger().info(String.format("[Marriage]MarriageModule.postInit@marriage paly step do not exist|level=%d|step=%d", new Object[] { Integer.valueOf(level), Integer.valueOf(step) }));
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 59 */           time = Integer.valueOf(0);
/*    */         }
/* 61 */         new WeddingPlaySession(time.intValue(), level, step);
/* 62 */         return true;
/*    */       }
/* 64 */     });
/* 65 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 70 */         MarriageParades xMarriageParades = xtable.Marriageparade.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 71 */         if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 72 */           return false;
/*    */         }
/* 74 */         for (xbean.MarriageParade marriageParade : xMarriageParades.getMarriageparades()) {
/* 75 */           GameServer.logger().info(String.format("[Marriage]MarriageModule.postInit@palyer is in marraige parade when server start|marriageParade=%s", new Object[] { marriageParade.toString() }));
/*    */         }
/*    */         
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 83 */         xMarriageParades.getMarriageparades().clear();
/* 84 */         return true;
/*    */       }
/*    */       
/*    */ 
/* 88 */     }.call();
/* 89 */     MapInterface.registerMonsterFightHandler(MapInterface.getBigWorldid(), new MarriageParadeFightHandler());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\MarriageModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */