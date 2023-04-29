/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.item.AccessWayInfoList;
/*    */ import mzm.gsp.item.SResItemAccessWay;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PQueryItemSiftCfgAccessWay
/*    */   extends PQueryItemAccessWay
/*    */ {
/*    */   public PQueryItemSiftCfgAccessWay(long roleid, int siftcfgid)
/*    */   {
/* 20 */     super(roleid, new ArrayList());
/*    */     
/* 22 */     this.itemIdList = ItemInterface.getSamePriceItems(siftcfgid);
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     SResItemAccessWay res = new SResItemAccessWay();
/* 28 */     int level = RoleInterface.getLevel(this.roleid);
/* 29 */     String useId = RoleInterface.getUserId(this.roleid);
/* 30 */     for (Integer itemId : this.itemIdList)
/*    */     {
/* 32 */       AccessWayInfoList wayList = queryItemWayInfoList(useId, itemId.intValue(), level);
/* 33 */       if (wayList.accessways.size() > 0) {
/* 34 */         res.itemaccessway.put(itemId, wayList);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 40 */     OnlineManager.getInstance().send(this.roleid, res);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PQueryItemSiftCfgAccessWay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */