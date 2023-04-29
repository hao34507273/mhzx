/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Idipcmds;
/*    */ import xtable.Idipconfig;
/*    */ import xtable.Idipmarquee;
/*    */ import xtable.Idipnotice;
/*    */ import xtable.Role2ntimesaward;
/*    */ 
/*    */ public class IdipModule implements mzm.event.Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/*    */     
/* 20 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 22 */       return 0;
/*    */     }
/*    */     
/* 25 */     IdipManager.init();
/*    */     
/*    */ 
/* 28 */     NTimesAwardManager.init();
/*    */     
/*    */ 
/* 31 */     NoticeManager.init();
/*    */     
/*    */ 
/* 34 */     MarqueeManager.init();
/*    */     
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 48 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 54 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 60 */     List<Table> tables = new ArrayList();
/* 61 */     tables.add(Idipconfig.getTable());
/* 62 */     tables.add(Idipnotice.getTable());
/* 63 */     tables.add(Idipmarquee.getTable());
/* 64 */     tables.add(Idipcmds.getTable());
/* 65 */     tables.add(Role2ntimesaward.getTable());
/* 66 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 72 */     return new PIdipMerge().call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\IdipModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */