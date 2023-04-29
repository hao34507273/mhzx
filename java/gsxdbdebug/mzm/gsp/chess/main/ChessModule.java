/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*    */ import xdb.Table;
/*    */ import xtable.Role2chessactivityinfo;
/*    */ 
/*    */ 
/*    */ public class ChessModule
/*    */   implements Module, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 19 */     ActivityInterface.registerActivityByLogicType(108, new ChessActivityHandler(), false);
/* 20 */     TeamConfirmInterface.registerConfirmHandler(2, new ChessActivityConfirmHandler());
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 45 */     List<Table> tables = new ArrayList();
/* 46 */     tables.add(Role2chessactivityinfo.getTable());
/* 47 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */