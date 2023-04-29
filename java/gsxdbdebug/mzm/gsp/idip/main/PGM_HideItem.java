/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_HideItem extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int itemType;
/*    */   private final int cfgid;
/*    */   private final boolean hide;
/*    */   
/*    */   public PGM_HideItem(long gmRoleid, int itemType, int cfgid, boolean hide)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.itemType = itemType;
/* 19 */     this.cfgid = cfgid;
/* 20 */     this.hide = hide;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if ((this.itemType < 1) || (this.itemType > 6))
/*    */     {
/* 28 */       notifyClient("类型不支持");
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (!ItemHideManager.itemHide(this.itemType, this.cfgid, this.hide))
/*    */     {
/* 34 */       notifyClient("操作失败");
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     notifyClient("操作成功");
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 44 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 45 */     messagetip.result = Integer.MAX_VALUE;
/* 46 */     messagetip.args.add(str);
/* 47 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGM_HideItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */