/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.groupshopping.SGetShoppingGroupListRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGetShoppingGroupList
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int groupShoppingItemCfgId;
/*     */   private final int page;
/*     */   
/*     */   public PGetShoppingGroupList(long roleId, int groupShoppingItemCfgId, int page)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/*  27 */     this.page = page;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     int activityId = GroupShoppingManager.currentActivityId;
/*  35 */     if (activityId == 0) {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!GroupShoppingManager.isSmallGroupShoppingOpen()) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!GroupShoppingManager.isServerLevelEnough(activityId)) {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!GroupShoppingManager.canGetGroupShoppingInfo(this.roleId)) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (this.groupShoppingItemCfgId != 0)
/*     */     {
/*  53 */       GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, this.groupShoppingItemCfgId);
/*     */       
/*  55 */       if (type != GroupShoppingManager.GroupShoppingType.SMALL) {
/*  56 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  60 */     if (GroupShoppingBanInterface.isBanned(activityId, this.groupShoppingItemCfgId)) {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     String userId = RoleInterface.getUserId(this.roleId);
/*  65 */     if (userId == null)
/*  66 */       return false;
/*  67 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId).isCanJoin()) {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  76 */         IncompletedSmallGroupChartManager.PageInfo pageInfo = IncompletedSmallGroupChartManager.getPageInfo(PGetShoppingGroupList.this.groupShoppingItemCfgId, PGetShoppingGroupList.this.page);
/*     */         
/*  78 */         SGetShoppingGroupListRes res = new SGetShoppingGroupListRes();
/*  79 */         res.group_shopping_item_cfgid = PGetShoppingGroupList.this.groupShoppingItemCfgId;
/*  80 */         res.last_page = pageInfo.lastPage;
/*  81 */         res.page = pageInfo.currentPage;
/*     */         
/*  83 */         for (Long groupId : pageInfo.groupIds)
/*     */         {
/*  85 */           xbean.ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(groupId);
/*  86 */           if (xShoppingGroupInfo != null)
/*     */           {
/*  88 */             mzm.gsp.groupshopping.ShoppingGroupInfo info = new mzm.gsp.groupshopping.ShoppingGroupInfo();
/*  89 */             GroupShoppingManager.fillShoppingGroupInfo(groupId.longValue(), xShoppingGroupInfo, info);
/*  90 */             info.status = 0;
/*  91 */             res.shopping_groups.add(info);
/*     */           }
/*     */         }
/*     */         
/*  95 */         OnlineManager.getInstance().send(PGetShoppingGroupList.this.roleId, res);
/*  96 */         GroupShoppingLogger.info("PGetShoppingGroupList.processImp()@done|roleid=%d|group_shopping_item_cfgid=%d|page=%d", new Object[] { Long.valueOf(PGetShoppingGroupList.this.roleId), Integer.valueOf(PGetShoppingGroupList.this.groupShoppingItemCfgId), Integer.valueOf(PGetShoppingGroupList.this.page) });
/*     */         
/*  98 */         return true;
/*     */       }
/*     */       
/* 101 */     }.execute();
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\PGetShoppingGroupList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */