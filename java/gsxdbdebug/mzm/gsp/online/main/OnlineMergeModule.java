/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AccountNumBean;
/*    */ import xdb.Table;
/*    */ import xtable.Accountnum;
/*    */ import xtable.Onlineuserinfo;
/*    */ import xtable.User2localcrossstoken;
/*    */ 
/*    */ public class OnlineMergeModule implements MergeModule
/*    */ {
/* 15 */   private static final Logger logger = Logger.getLogger(OnlineMergeModule.class);
/*    */   
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 19 */     List<Table> tables = new java.util.ArrayList();
/*    */     
/* 21 */     tables.add(Onlineuserinfo.getTable());
/*    */     
/* 23 */     tables.add(Accountnum.getTable());
/*    */     
/* 25 */     tables.add(User2localcrossstoken.getTable());
/* 26 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 31 */     final long viceZoneid = MergeMain.getViceZoneid();
/* 32 */     long mainZoneid = MergeMain.getMainZoneid();
/*    */     
/*    */ 
/* 35 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 39 */         lock(Accountnum.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/* 40 */         AccountNumBean xViceAccountNumBean = Accountnum.get(Long.valueOf(viceZoneid));
/* 41 */         if (xViceAccountNumBean == null) {
/* 42 */           return false;
/*    */         }
/* 44 */         AccountNumBean xMainAccountNumBean = Accountnum.get(Long.valueOf(this.val$mainZoneid));
/* 45 */         if (xMainAccountNumBean == null) {
/* 46 */           xMainAccountNumBean = xbean.Pod.newAccountNumBean();
/* 47 */           Accountnum.insert(Long.valueOf(this.val$mainZoneid), xMainAccountNumBean);
/*    */         }
/* 49 */         xMainAccountNumBean.setUsernum(xMainAccountNumBean.getUsernum() + xViceAccountNumBean.getUsernum());
/*    */         
/* 51 */         Accountnum.remove(Long.valueOf(viceZoneid));
/*    */         
/* 53 */         OnlineMergeModule.logger.info(String.format("[Merge]OnlineMergeModule.handleMerge@merge Accountnum table finished", new Object[0]));
/*    */         
/* 55 */         return true;
/*    */       }
/* 57 */     }.call();
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */