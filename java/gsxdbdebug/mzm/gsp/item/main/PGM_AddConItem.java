/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.item.confbean.SItemSiftCfg;
/*    */ import mzm.gsp.item.confbean.SItemSiftConCfg;
/*    */ import mzm.gsp.item.main.sift.SiftInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class PGM_AddConItem extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int cfgid;
/*    */   
/*    */   public PGM_AddConItem(long roleid, int cfgid)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.cfgid = cfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (SItemCfg.get(this.cfgid) != null) {
/* 27 */       ItemInterface.addItem(this.roleid, this.cfgid, 1, new TLogArg(LogReason.GM_ADD));
/* 28 */       return true;
/*    */     }
/* 30 */     if (SItemSiftCfg.get(this.cfgid) != null) {
/* 31 */       List<Integer> same = ItemInterface.getSamePriceItems(this.cfgid);
/* 32 */       ItemInterface.addItem(this.roleid, ((Integer)same.get(0)).intValue(), 1, new TLogArg(LogReason.GM_ADD));
/* 33 */       return true;
/*    */     }
/* 35 */     if (SItemSiftConCfg.get(this.cfgid) != null) {
/* 36 */       Set<Integer> same = SiftInterface.siftItems(this.cfgid);
/* 37 */       ItemInterface.addItem(this.roleid, ((Integer)same.iterator().next()).intValue(), 1, new TLogArg(LogReason.GM_ADD));
/* 38 */       return true;
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_AddConItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */