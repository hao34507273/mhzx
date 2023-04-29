/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.children.SBreedBabyChildEnd;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.BabyPeriodInfo;
/*    */ import xbean.ChildInfo;
/*    */ 
/*    */ public class PGM_ClearChildTired extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long childId;
/*    */   
/*    */   public PGM_ClearChildTired(long roleId, long childId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.childId = childId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*    */     {
/* 29 */       notifyClient(this.roleId, "功能开关未开启");
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childId));
/* 34 */     if (xChildInfo == null)
/*    */     {
/* 36 */       notifyClient(this.roleId, "孩子数据不存在");
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*    */     {
/* 42 */       notifyClient(this.roleId, "不是您的孩子");
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (xChildInfo.getChild_period() != 0)
/*    */     {
/* 48 */       notifyClient(this.roleId, "不是婴儿期的孩子");
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/* 53 */     xBabyPeriodInfo.getBaby_property_info_map().put(Integer.valueOf(3), Integer.valueOf(0));
/*    */     
/* 55 */     Map<Integer, Integer> xBabyPeriodPropertyMap = xBabyPeriodInfo.getBaby_property_info_map();
/* 56 */     SBreedBabyChildEnd sBreedBabyChildEnd = new SBreedBabyChildEnd();
/* 57 */     sBreedBabyChildEnd.operator = 3;
/* 58 */     sBreedBabyChildEnd.child_id = this.childId;
/*    */     
/* 60 */     for (Map.Entry<Integer, Integer> propertyEntry : xBabyPeriodPropertyMap.entrySet())
/*    */     {
/* 62 */       sBreedBabyChildEnd.now_baby_property.put(propertyEntry.getKey(), propertyEntry.getValue());
/*    */     }
/* 64 */     OnlineManager.getInstance().send(this.roleId, sBreedBabyChildEnd);
/*    */     
/* 66 */     long anotherParentRoleId = xChildInfo.getAnother_parent_role_id();
/* 67 */     if (anotherParentRoleId != -1L)
/*    */     {
/* 69 */       long realAnotherParentRoelId = this.roleId == anotherParentRoleId ? xChildInfo.getOwn_role_id() : anotherParentRoleId;
/*    */       
/* 71 */       OnlineManager.getInstance().send(realAnotherParentRoelId, sBreedBabyChildEnd);
/*    */     }
/*    */     
/* 74 */     notifyClient(this.roleId, "清除疲劳度成功");
/* 75 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(long roleId, String str)
/*    */   {
/* 80 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 81 */     messagetip.result = Integer.MAX_VALUE;
/* 82 */     messagetip.args.add(str);
/* 83 */     OnlineManager.getInstance().sendAtOnce(roleId, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PGM_ClearChildTired.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */