/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg;
/*     */ import mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg;
/*     */ import mzm.gsp.groupshopping.confbean.SSmallGroupShoppingItemCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.GroupShoppingBanInfo;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xbean.SmallGroupShoppingItemInfo;
/*     */ import xtable.Group_shopping_ban_info;
/*     */ import xtable.Group_shopping_info;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ROnActivityStart
/*     */   extends LogicRunnable
/*     */ {
/*     */   private final ActivityHandler.ActivityStartType activityStartType;
/*     */   private final int activityId;
/*     */   
/*     */   ROnActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityId)
/*     */   {
/*  39 */     this.activityStartType = activityStartType;
/*  40 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  46 */     if (this.activityStartType == ActivityHandler.ActivityStartType.BIG_TURN)
/*     */     {
/*  48 */       initGroupShoppingInfo();
/*  49 */       initBigGroupShopping();
/*  50 */       IncompletedSmallGroupChartManager.init(this.activityId);
/*     */     }
/*     */     else
/*     */     {
/*  54 */       checkAndHandleCfgModification();
/*  55 */       checkAndHandleBannedItems();
/*  56 */       initSmallGroupShopping();
/*  57 */       initBigGroupShopping();
/*  58 */       IncompletedSmallGroupChartManager.init(this.activityId);
/*     */     }
/*     */     
/*     */ 
/*  62 */     GroupShoppingManager.currentActivityId = this.activityId;
/*  63 */     GroupShoppingLogger.info("ROnActivityStart.process()@done|activity_id=%d", new Object[] { Integer.valueOf(this.activityId) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initGroupShoppingInfo()
/*     */   {
/*  71 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  77 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(ROnActivityStart.this.activityId);
/*  78 */         if (xGroupShoppingInfo != null)
/*     */         {
/*  80 */           xGroupShoppingInfo.getBig_group_infos().clear();
/*  81 */           xGroupShoppingInfo.getSmall_group_infos().clear();
/*  82 */           xGroupShoppingInfo.getIncompleted_small_groups().clear();
/*     */         }
/*     */         else
/*     */         {
/*  86 */           xGroupShoppingInfo = Pod.newGroupShoppingInfo();
/*  87 */           Group_shopping_info.add(Long.valueOf(GameServerInfoManager.toGlobalId(ROnActivityStart.this.activityId)), xGroupShoppingInfo);
/*     */         }
/*     */         
/*  90 */         GroupShoppingActivityCfg groupShoppingActivityCfg = GroupShoppingActivityCfg.get(ROnActivityStart.this.activityId);
/*  91 */         if (groupShoppingActivityCfg == null) {
/*  92 */           return false;
/*     */         }
/*  94 */         for (Integer groupShoppingItemCfgId : groupShoppingActivityCfg.smallGroupItemCfgIds)
/*     */         {
/*  96 */           SSmallGroupShoppingItemCfg cfg = SSmallGroupShoppingItemCfg.get(groupShoppingItemCfgId.intValue());
/*  97 */           if (cfg != null)
/*     */           {
/*  99 */             SmallGroupShoppingItemInfo xInfo = Pod.newSmallGroupShoppingItemInfo();
/*     */             
/* 101 */             xInfo.setTotal_num(cfg.itemNum > 0 ? cfg.itemNum : 0);
/* 102 */             xInfo.setRemaining_num(cfg.itemNum > 0 ? cfg.itemNum : 0);
/* 103 */             xGroupShoppingInfo.getSmall_group_infos().put(groupShoppingItemCfgId, xInfo);
/*     */           }
/*     */         }
/* 106 */         for (Integer groupShoppingItemCfgId : groupShoppingActivityCfg.bigGroupItemCfgIds)
/*     */         {
/* 108 */           SBigGroupShoppingItemCfg cfg = SBigGroupShoppingItemCfg.get(groupShoppingItemCfgId.intValue());
/* 109 */           if (cfg != null)
/*     */           {
/* 111 */             BigGroupShoppingItemInfo xInfo = Pod.newBigGroupShoppingItemInfo();
/*     */             
/* 113 */             xInfo.setTotal_num(cfg.itemNum > 0 ? cfg.itemNum : 0);
/* 114 */             xInfo.setRemaining_num(cfg.itemNum > 0 ? cfg.itemNum : 0);
/* 115 */             xInfo.setGroup_id(0L);
/* 116 */             xGroupShoppingInfo.getBig_group_infos().put(groupShoppingItemCfgId, xInfo);
/*     */           } }
/* 118 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initBigGroupShopping()
/*     */   {
/* 131 */     final List<Integer> toStartImmediately = new ArrayList();
/* 132 */     final List<Long> toCloseImmediately = new ArrayList();
/*     */     
/* 134 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 140 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(ROnActivityStart.this.activityId);
/* 141 */         if (xGroupShoppingInfo == null)
/* 142 */           return false;
/* 143 */         List<Long> openedGroups = new ArrayList();
/*     */         
/* 145 */         for (Map.Entry<Integer, BigGroupShoppingItemInfo> entry : xGroupShoppingInfo.getBig_group_infos().entrySet())
/*     */         {
/* 147 */           int groupShoppingItemCfgId = ((Integer)entry.getKey()).intValue();
/* 148 */           BigGroupShoppingItemInfo xBigGroupShoppingItemInfo = (BigGroupShoppingItemInfo)entry.getValue();
/* 149 */           long groupId = xBigGroupShoppingItemInfo.getGroup_id();
/*     */           
/*     */ 
/* 152 */           if (groupId == 0L)
/*     */           {
/* 154 */             if (!BigGroupShoppingStartSession.start(ROnActivityStart.this.activityId, groupShoppingItemCfgId))
/*     */             {
/* 156 */               toStartImmediately.add(Integer.valueOf(groupShoppingItemCfgId));
/*     */             }
/*     */             
/*     */           }
/*     */           else {
/* 161 */             openedGroups.add(Long.valueOf(groupId));
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 167 */         lock(Shopping_group_info.getTable(), openedGroups);
/* 168 */         for (Long groupId : openedGroups)
/*     */         {
/* 170 */           ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.get(groupId);
/* 171 */           if (xShoppingGroupInfo.getStatus() == 0)
/*     */           {
/* 173 */             long roleId = xShoppingGroupInfo.getCreator_roleid();
/* 174 */             int closeTime = xShoppingGroupInfo.getClose_time();
/* 175 */             if (!GroupShoppingCloseSession.start(ROnActivityStart.this.activityId, roleId, groupId.longValue(), closeTime))
/*     */             {
/* 177 */               toCloseImmediately.add(groupId);
/*     */             }
/*     */           }
/*     */         }
/* 181 */         return true;
/*     */       }
/*     */     }.call();
/*     */     
/*     */ 
/* 186 */     for (Integer groupShoppingItemCfgId : toStartImmediately) {
/* 187 */       new PCreateBigShoppingGroup(this.activityId, groupShoppingItemCfgId.intValue()).call();
/*     */     }
/*     */     
/* 190 */     for (Long groupId : toCloseImmediately) {
/* 191 */       new RCloseGroupShopping(this.activityId, groupId.longValue(), false, false, false).run();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void initSmallGroupShopping()
/*     */   {
/* 199 */     final List<Long> toCloseImmediately = new ArrayList();
/*     */     
/* 201 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 207 */         Set<Long> xIncompletedSmallGroups = GroupShoppingManager.getIncompletedSmallGroups(ROnActivityStart.this.activityId);
/* 208 */         if (xIncompletedSmallGroups == null)
/* 209 */           return false;
/* 210 */         lock(Shopping_group_info.getTable(), xIncompletedSmallGroups);
/*     */         
/*     */ 
/*     */ 
/* 214 */         List<Long> invalidGroups = new ArrayList();
/* 215 */         for (Long groupId : xIncompletedSmallGroups)
/*     */         {
/* 217 */           ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.get(groupId);
/* 218 */           if ((xShoppingGroupInfo == null) || (xShoppingGroupInfo.getStatus() != 0))
/*     */           {
/* 220 */             invalidGroups.add(groupId);
/*     */           }
/*     */           else
/*     */           {
/* 224 */             long roleId = xShoppingGroupInfo.getCreator_roleid();
/* 225 */             int closeTime = xShoppingGroupInfo.getClose_time();
/* 226 */             if (!GroupShoppingCloseSession.start(ROnActivityStart.this.activityId, roleId, groupId.longValue(), closeTime))
/*     */             {
/* 228 */               toCloseImmediately.add(groupId);
/*     */             }
/*     */           }
/*     */         }
/* 232 */         xIncompletedSmallGroups.removeAll(invalidGroups);
/* 233 */         return true;
/*     */       }
/*     */     }.call();
/*     */     
/*     */ 
/* 238 */     for (Long groupId : toCloseImmediately) {
/* 239 */       new RCloseGroupShopping(this.activityId, groupId.longValue(), false, false, false).run();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void checkAndHandleCfgModification()
/*     */   {
/* 247 */     new RCheckAndHandleCfgModification(this.activityId).run();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkAndHandleBannedItems()
/*     */   {
/* 255 */     final List<Long> groupsToClose = new ArrayList();
/* 256 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 262 */         GroupShoppingBanInfo xBanInfo = Group_shopping_ban_info.get(Long.valueOf(GameServerInfoManager.toGlobalId(ROnActivityStart.this.activityId)));
/*     */         
/* 264 */         if (xBanInfo == null)
/* 265 */           return false;
/* 266 */         Set<Integer> banned = xBanInfo.getBanned_group_shopping_items();
/*     */         
/* 268 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(ROnActivityStart.this.activityId);
/* 269 */         if (xGroupShoppingInfo != null)
/*     */         {
/*     */ 
/* 272 */           for (Long groupId : xGroupShoppingInfo.getIncompleted_small_groups())
/*     */           {
/* 274 */             Integer groupShoppingItemCfgId = Shopping_group_info.selectGroup_shopping_item_cfgid(groupId);
/*     */             
/* 276 */             if ((groupShoppingItemCfgId != null) && (banned.contains(groupShoppingItemCfgId))) {
/* 277 */               groupsToClose.add(groupId);
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 282 */           for (Map.Entry<Integer, BigGroupShoppingItemInfo> entry : xGroupShoppingInfo.getBig_group_infos().entrySet())
/*     */           {
/* 284 */             if (banned.contains(entry.getKey()))
/*     */             {
/* 286 */               if (((BigGroupShoppingItemInfo)entry.getValue()).getGroup_id() != 0L)
/*     */               {
/* 288 */                 Integer status = Shopping_group_info.selectStatus(Long.valueOf(((BigGroupShoppingItemInfo)entry.getValue()).getGroup_id()));
/* 289 */                 if ((status != null) && (status.intValue() == 0))
/* 290 */                   groupsToClose.add(Long.valueOf(((BigGroupShoppingItemInfo)entry.getValue()).getGroup_id()));
/*     */               } }
/*     */           }
/*     */         }
/* 294 */         return true;
/*     */       }
/*     */     }.call();
/* 297 */     for (Long groupId : groupsToClose) {
/* 298 */       new RCloseGroupShopping(this.activityId, groupId.longValue(), true, false, true).run();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\ROnActivityStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */