/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xbean.BanNpcServices;
/*    */ import xdb.Table;
/*    */ import xtable.Bannpcservice;
/*    */ 
/*    */ public class NpcMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 15 */     List<Table> tables = new ArrayList();
/* 16 */     tables.add(Bannpcservice.getTable());
/* 17 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 22 */     final long viceZoneid = MergeMain.getViceZoneid();
/* 23 */     long mainZoneid = MergeMain.getMainZoneid();
/* 24 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 28 */         lock(Bannpcservice.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/* 29 */         BanNpcServices xViceBanNpcServices = Bannpcservice.get(Long.valueOf(viceZoneid));
/* 30 */         if (xViceBanNpcServices == null) {
/* 31 */           return false;
/*    */         }
/* 33 */         BanNpcServices xMainBanNpcServices = Bannpcservice.get(Long.valueOf(this.val$mainZoneid));
/* 34 */         if (xMainBanNpcServices == null) {
/* 35 */           xMainBanNpcServices = xbean.Pod.newBanNpcServices();
/* 36 */           Bannpcservice.insert(Long.valueOf(this.val$mainZoneid), xMainBanNpcServices);
/*    */         }
/* 38 */         xMainBanNpcServices.getNpcservices().addAll(xViceBanNpcServices.getNpcservices());
/* 39 */         return true;
/*    */       }
/* 41 */     }.call();
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\NpcMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */