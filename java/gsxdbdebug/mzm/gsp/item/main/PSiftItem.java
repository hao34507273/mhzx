/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.item.SSiftItemRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSiftItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int siftcfgid;
/*    */   
/*    */   public PSiftItem(long roleid, int siftcfgid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.siftcfgid = siftcfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     SSiftItemRes s = new SSiftItemRes();
/* 26 */     s.itemlist.addAll(ItemInterface.getSamePriceItems(this.siftcfgid));
/* 27 */     s.siftcfgid = this.siftcfgid;
/* 28 */     OnlineManager.getInstance().send(this.roleid, s);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PSiftItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */