/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Table;
/*    */ import xtable.Gangmakeup;
/*    */ import xtable.Globalmakeup;
/*    */ import xtable.Role2makeupinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MakeUpModule
/*    */   implements Module, PostModuleInitListner, MergeModule
/*    */ {
/*    */   public void postInit() {}
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 30 */     ActivityInterface.registerActivityByLogicType(133, new MakeUpActivityHandler(), false);
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 43 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 49 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 55 */     List<Table> tables = new ArrayList();
/* 56 */     tables.add(Role2makeupinfo.getTable());
/* 57 */     tables.add(Gangmakeup.getTable());
/* 58 */     tables.add(Globalmakeup.getTable());
/* 59 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 65 */     boolean res = true;
/* 66 */     if (!new handMakeUpMerge(null).call())
/*    */     {
/* 68 */       GameServer.logger().error(String.format("[makeup]MakeUpModule.handleMerge@ Merge Globalmakeup fail!", new Object[0]));
/* 69 */       res = false;
/*    */     }
/* 71 */     return res;
/*    */   }
/*    */   
/*    */   private class handMakeUpMerge extends LogicProcedure
/*    */   {
/*    */     private handMakeUpMerge() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 80 */       long mainKey = MergeMain.getMainZoneid();
/* 81 */       long viceKey = MergeMain.getViceZoneid();
/* 82 */       lock(Globalmakeup.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 84 */       Globalmakeup.remove(Long.valueOf(viceKey));
/* 85 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\MakeUpModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */