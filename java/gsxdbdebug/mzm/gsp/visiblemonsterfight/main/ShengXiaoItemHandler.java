/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.SBrocastShengXiaoItem;
/*    */ import mzm.gsp.item.main.ItemReasonHandler;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class ShengXiaoItemHandler implements ItemReasonHandler
/*    */ {
/* 12 */   private static final ShengXiaoItemHandler instance = new ShengXiaoItemHandler();
/*    */   
/*    */   public static ShengXiaoItemHandler getInstance() {
/* 15 */     return instance;
/*    */   }
/*    */   
/*    */   public void gainPreciousItem(long roleid, Map<Integer, Integer> itemid2num)
/*    */   {
/* 20 */     SBrocastShengXiaoItem brd = new SBrocastShengXiaoItem();
/* 21 */     brd.rolename = RoleInterface.getName(roleid);
/* 22 */     brd.roleid = roleid;
/* 23 */     brd.itemid2count.putAll(itemid2num);
/* 24 */     OnlineManager.getInstance().sendAll(brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\ShengXiaoItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */