/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.groupshopping.GroupShoppingBanInfo;
/*     */ import mzm.gsp.groupshopping.SSyncGroupShoppingBanInfo;
/*     */ import mzm.gsp.groupshopping.SSyncMyShoppingGroupList;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.RoleGroupShoppingRecord;
/*     */ import xbean.RoleGroupShoppingRecords;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  18 */     int activityId = GroupShoppingManager.currentActivityId;
/*  19 */     if (activityId == 0) {
/*  20 */       return false;
/*     */     }
/*     */     
/*  23 */     if (!GroupShoppingManager.isServerLevelEnough(activityId)) {
/*  24 */       return false;
/*     */     }
/*     */     
/*  27 */     if (!GroupShoppingManager.canGetGroupShoppingInfo(((Long)this.arg).longValue())) {
/*  28 */       return false;
/*     */     }
/*     */     
/*  31 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(((Long)this.arg).longValue());
/*  32 */     if (userId == null)
/*  33 */       return false;
/*  34 */     if (!mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, ((Long)this.arg).longValue(), activityId).isCanJoin()) {
/*  35 */       return false;
/*     */     }
/*  37 */     syncMyShoppingGroupList(activityId);
/*  38 */     syncGroupShoppingBanInfo(activityId);
/*  39 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void syncMyShoppingGroupList(final int activityId)
/*     */   {
/*  47 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  53 */         RoleGroupShoppingRecords xRoleRecords = xtable.Role2group_shopping_records.select((Long)POnRoleLogin.this.arg);
/*  54 */         if (xRoleRecords == null)
/*  55 */           return false;
/*  56 */         RoleGroupShoppingRecord xRoleRecord = (RoleGroupShoppingRecord)xRoleRecords.getRecords().get(Integer.valueOf(activityId));
/*  57 */         if (xRoleRecord == null)
/*  58 */           return false;
/*  59 */         SSyncMyShoppingGroupList sync = new SSyncMyShoppingGroupList();
/*  60 */         for (Long groupId : xRoleRecord.getParticipating_groups())
/*     */         {
/*     */ 
/*  63 */           xbean.ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(groupId);
/*  64 */           if (xShoppingGroupInfo != null)
/*     */           {
/*  66 */             mzm.gsp.groupshopping.ShoppingGroupInfo info = new mzm.gsp.groupshopping.ShoppingGroupInfo();
/*  67 */             GroupShoppingManager.fillShoppingGroupInfo(groupId.longValue(), xShoppingGroupInfo, info);
/*  68 */             info.status = 0;
/*  69 */             sync.list.add(info);
/*     */           }
/*     */         }
/*  72 */         for (Long groupId : xRoleRecord.getParticipated_groups())
/*     */         {
/*     */ 
/*  75 */           xbean.ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(groupId);
/*  76 */           if (xShoppingGroupInfo != null)
/*     */           {
/*  78 */             mzm.gsp.groupshopping.ShoppingGroupInfo info = new mzm.gsp.groupshopping.ShoppingGroupInfo();
/*  79 */             GroupShoppingManager.fillShoppingGroupInfo(groupId.longValue(), xShoppingGroupInfo, info);
/*  80 */             sync.list.add(info);
/*     */           }
/*     */         }
/*  83 */         OnlineManager.getInstance().send(((Long)POnRoleLogin.this.arg).longValue(), sync);
/*  84 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void syncGroupShoppingBanInfo(int activityId)
/*     */   {
/*  94 */     SSyncGroupShoppingBanInfo sync = new SSyncGroupShoppingBanInfo();
/*  95 */     for (Integer groupShoppingItemCfgId : GroupShoppingBanInterface.getBannedSet(activityId))
/*     */     {
/*  97 */       GroupShoppingBanInfo banInfo = new GroupShoppingBanInfo(groupShoppingItemCfgId.intValue(), 1);
/*  98 */       sync.ban_infos.add(banInfo);
/*     */     }
/* 100 */     if (!sync.ban_infos.isEmpty()) {
/* 101 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), sync);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */