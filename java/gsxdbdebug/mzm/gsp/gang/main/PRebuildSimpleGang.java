/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pod;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRebuildSimpleGang
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangid;
/*    */   private final String gangName;
/*    */   
/*    */   public PRebuildSimpleGang(long gangid, String gangName)
/*    */   {
/* 16 */     this.gangid = gangid;
/* 17 */     this.gangName = gangName;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     xbean.Gang xGang = GangManager.getXGang(this.gangid, true);
/* 24 */     if (xGang == null) {
/* 25 */       xGang = Pod.newGang();
/* 26 */       boolean ret = xtable.Gang.add(Long.valueOf(this.gangid), xGang);
/* 27 */       if (!ret) {
/* 28 */         GangManager.logError("PRebuildGang.processImp@add xgang failed|gangid=%d|gang_name=%s", new Object[] { Long.valueOf(this.gangid), this.gangName });
/*    */       }
/*    */       
/*    */ 
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!xGang.getName().equals(this.gangName)) {
/* 36 */       xGang.setName(this.gangName);
/*    */     }
/*    */     
/* 39 */     GangManager.logInfo("PRebuildGang.processImp@success|gangid=%d|gang_name=%s", new Object[] { Long.valueOf(this.gangid), this.gangName });
/*    */     
/*    */ 
/*    */ 
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRebuildSimpleGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */