/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_AddItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleid;
/*    */   private final int itemid;
/*    */   private final int itemnum;
/*    */   private final boolean isBind;
/*    */   
/*    */   public PGM_AddItem(long gmRoleId, long roleid, int itemid, int itemnum, boolean isBind)
/*    */   {
/* 26 */     this.gmRoleId = gmRoleId;
/* 27 */     this.roleid = roleid;
/* 28 */     this.itemid = itemid;
/* 29 */     this.itemnum = itemnum;
/* 30 */     this.isBind = isBind;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     if (ItemInterface.isItemExist(this.itemid))
/*    */     {
/* 38 */       final int pilenum = ItemInterface.getPileMaxCount(this.itemid);
/* 39 */       int count = this.itemnum / pilenum;
/* 40 */       final int rest = this.itemnum % pilenum;
/* 41 */       for (int i = 0; i < count; i++)
/*    */       {
/* 43 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */         {
/*    */ 
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/* 49 */             ItemInterface.addItem(PGM_AddItem.this.roleid, PGM_AddItem.this.itemid, pilenum, PGM_AddItem.this.isBind, new TLogArg(LogReason.GM_ADD));
/* 50 */             return true;
/*    */           }
/*    */         });
/*    */       }
/*    */       
/* 55 */       if (rest > 0)
/*    */       {
/* 57 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */         {
/*    */ 
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/* 63 */             ItemInterface.addItem(PGM_AddItem.this.roleid, PGM_AddItem.this.itemid, rest, PGM_AddItem.this.isBind, new TLogArg(LogReason.GM_ADD));
/* 64 */             return true;
/*    */           }
/*    */         });
/*    */       }
/*    */       
/* 69 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d增加物品%d成功,共%d个", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.itemnum) }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 74 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("物品%d不存在，增加失败", new Object[] { Integer.valueOf(this.itemid) }));
/*    */     }
/*    */     
/*    */ 
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_AddItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */