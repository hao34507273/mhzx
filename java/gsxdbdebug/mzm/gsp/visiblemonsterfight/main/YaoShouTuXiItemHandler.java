/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.SBrocastYaoShouItem;
/*    */ import mzm.gsp.item.main.ItemReasonHandler;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class YaoShouTuXiItemHandler implements ItemReasonHandler
/*    */ {
/* 12 */   private static final YaoShouTuXiItemHandler instance = new YaoShouTuXiItemHandler();
/*    */   
/*    */   public static YaoShouTuXiItemHandler getInstance() {
/* 15 */     return instance;
/*    */   }
/*    */   
/*    */   public void gainPreciousItem(long roleid, Map<Integer, Integer> itemid2num)
/*    */   {
/* 20 */     SBrocastYaoShouItem brd = new SBrocastYaoShouItem();
/* 21 */     brd.rolename = RoleInterface.getName(roleid);
/* 22 */     brd.roleid = roleid;
/* 23 */     brd.itemid2count.putAll(itemid2num);
/* 24 */     OnlineManager.getInstance().sendAll(brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\YaoShouTuXiItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */