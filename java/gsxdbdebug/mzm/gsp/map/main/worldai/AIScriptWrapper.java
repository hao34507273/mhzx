/*    */ package mzm.gsp.map.main.worldai;
/*    */ 
/*    */ import mzm.gsp.map.main.worldai.script.IAIScript;
/*    */ 
/*    */ public class AIScriptWrapper
/*    */ {
/*    */   private Class<IAIScript> aiclass;
/*    */   private int cfgId;
/*    */   
/*    */   public AIScriptWrapper(Class<IAIScript> aiclass, int cfgId)
/*    */   {
/* 12 */     this.aiclass = aiclass;
/* 13 */     this.cfgId = cfgId;
/*    */   }
/*    */   
/*    */   public Class<IAIScript> getAiclass()
/*    */   {
/* 18 */     return this.aiclass;
/*    */   }
/*    */   
/*    */   public int getCfgId()
/*    */   {
/* 23 */     return this.cfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\worldai\AIScriptWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */