/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.worldai.AIScriptWrapper;
/*    */ import mzm.gsp.map.main.worldai.script.IAIScript;
/*    */ import mzm.gsp.worldai.confbean.SWorldAiConfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldScriptManager
/*    */ {
/* 15 */   private static WorldScriptManager instance = new WorldScriptManager();
/* 16 */   private Map<Integer, List<AIScriptWrapper>> scriptListMap = new HashMap();
/*    */   
/*    */   private static final String packagename = "mzm.gsp.map.main.worldai.";
/*    */   
/*    */   public static WorldScriptManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */   public void init() {
/* 26 */     for (SWorldAiConfig config : SWorldAiConfig.getAll().values()) {
/*    */       try
/*    */       {
/* 29 */         Class<IAIScript> scriptcls = Class.forName("mzm.gsp.map.main.worldai." + config.name);
/* 30 */         List<AIScriptWrapper> scriptList = (List)this.scriptListMap.get(Integer.valueOf(config.mapId));
/* 31 */         if (scriptList == null) {
/* 32 */           scriptList = new ArrayList();
/* 33 */           this.scriptListMap.put(Integer.valueOf(config.mapId), scriptList);
/*    */         }
/* 35 */         scriptList.add(new AIScriptWrapper(scriptcls, config.id));
/*    */       } catch (Exception e) {
/* 37 */         throw new RuntimeException(e);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public List<AIScriptWrapper> getScriptListForMap(int mapCfgId) {
/* 43 */     return (List)this.scriptListMap.get(Integer.valueOf(mapCfgId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\WorldScriptManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */