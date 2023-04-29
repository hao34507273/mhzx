/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.instance.confbean.SGraphidToInstanceid;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ 
/*    */ public class InstanceModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/*    */     
/* 18 */     for (Map.Entry<Integer, SGraphidToInstanceid> graphid2InstanceEntry : SGraphidToInstanceid.getAll().entrySet()) {
/* 19 */       int graphid = ((Integer)graphid2InstanceEntry.getKey()).intValue();
/* 20 */       int instanceid = ((SGraphidToInstanceid)graphid2InstanceEntry.getValue()).instanceid;
/* 21 */       TaskInterface.setFightType(graphid, SInstanceCfg.get(instanceid).fightType);
/*    */     }
/* 23 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\InstanceModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */