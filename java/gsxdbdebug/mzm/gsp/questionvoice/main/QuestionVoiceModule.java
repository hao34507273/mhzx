/*    */ package mzm.gsp.questionvoice.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import xdb.Table;
/*    */ import xtable.Role2question_voice_info;
/*    */ 
/*    */ 
/*    */ public class QuestionVoiceModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 18 */     ActivityInterface.registerActivityByLogicType(114, new QuestionVoiceActivityHandler(), false);
/*    */     
/* 20 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 44 */     List<Table> tables = new ArrayList();
/* 45 */     tables.add(Role2question_voice_info.getTable());
/* 46 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\QuestionVoiceModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */