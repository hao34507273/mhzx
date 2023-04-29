/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.groupshopping.SBroadcastGroupShoppingCompleted;
/*     */ import mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg;
/*     */ import mzm.gsp.groupshopping.confbean.SGroupShoppingConsts;
/*     */ import mzm.gsp.groupshopping.confbean.SSmallGroupShoppingItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.RoleGroupShoppingRecord;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xbean.SmallGroupShoppingItemInfo;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ public class RCloseGroupShopping extends LogicRunnable
/*     */ {
/*     */   private final int activityId;
/*     */   private final long groupId;
/*     */   private final boolean isForceClose;
/*     */   private final boolean calledInActivity;
/*     */   private final boolean calledOnBan;
/*     */   
/*     */   RCloseGroupShopping(int activityId, long groupId)
/*     */   {
/*  40 */     this.activityId = activityId;
/*  41 */     this.groupId = groupId;
/*  42 */     this.isForceClose = false;
/*  43 */     this.calledInActivity = true;
/*  44 */     this.calledOnBan = false;
/*     */   }
/*     */   
/*     */ 
/*     */   RCloseGroupShopping(int activityId, long groupId, boolean isForceClose, boolean calledInActivity, boolean calledOnBan)
/*     */   {
/*  50 */     this.activityId = activityId;
/*  51 */     this.groupId = groupId;
/*  52 */     this.isForceClose = isForceClose;
/*  53 */     this.calledInActivity = calledInActivity;
/*  54 */     this.calledOnBan = calledOnBan;
/*     */   }
/*     */   
/*     */   private class Status
/*     */   {
/*  59 */     boolean failed = false;
/*  60 */     boolean isSmallGroupShopping = false;
/*  61 */     long creatorRoleId = 0L;
/*  62 */     int groupShoppingItemCfgId = 0;
/*  63 */     int groupSize = 0;
/*  64 */     int price = 0;
/*  65 */     int closeType = 0;
/*  66 */     final List<Long> members = new ArrayList();
/*     */     
/*     */     private Status() {}
/*     */   }
/*     */   
/*     */   public void process() throws Exception {
/*  72 */     final Status status = new Status(null);
/*  73 */     new PHandleShoppingGroupInfo(status, null).call();
/*  74 */     if (status.failed) {
/*  75 */       return;
/*     */     }
/*  77 */     for (Long roleId : status.members) {
/*  78 */       new PHandleRoleInfo(status, roleId.longValue(), null).call();
/*     */     }
/*  80 */     new PHandleGroupShoppingInfo(status, null).call();
/*     */     
/*     */ 
/*  83 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  88 */         for (Long roleId : status.members)
/*     */         {
/*  90 */           if (status.closeType == 1)
/*     */           {
/*  92 */             GroupShoppingLogger.tlogGroupShoppingSuccess(roleId.longValue(), RCloseGroupShopping.this.groupId, status.groupShoppingItemCfgId, status.price, status.members.size());
/*     */ 
/*     */           }
/*  95 */           else if (status.closeType == 2)
/*     */           {
/*  97 */             GroupShoppingLogger.tlogGroupShoppingFailOfGroupSize(roleId.longValue(), RCloseGroupShopping.this.groupId, status.groupShoppingItemCfgId, status.price, status.members.size());
/*     */ 
/*     */           }
/* 100 */           else if (RCloseGroupShopping.this.calledOnBan)
/*     */           {
/* 102 */             GroupShoppingLogger.tlogGroupShoppingFailOfItemBanned(roleId.longValue(), RCloseGroupShopping.this.groupId, status.groupShoppingItemCfgId, status.price, status.members.size());
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 107 */             GroupShoppingLogger.tlogGroupShoppingFailOfCfgModification(roleId.longValue(), RCloseGroupShopping.this.groupId, status.groupShoppingItemCfgId, status.price, status.members.size());
/*     */           }
/*     */         }
/*     */         
/* 111 */         return true;
/*     */       }
/* 113 */     }.call();
/* 114 */     GroupShoppingLogger.info("RCloseGroupShopping.process()@done|group_id=%d|group_shopping_item_cfg_id=%d|close_type=%d", new Object[] { Long.valueOf(this.groupId), Integer.valueOf(status.groupShoppingItemCfgId), Integer.valueOf(status.closeType) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private class PHandleShoppingGroupInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final RCloseGroupShopping.Status status;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private PHandleShoppingGroupInfo(RCloseGroupShopping.Status status)
/*     */     {
/* 130 */       this.status = status;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 137 */       ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.get(Long.valueOf(RCloseGroupShopping.this.groupId));
/* 138 */       if ((xShoppingGroupInfo == null) || (xShoppingGroupInfo.getStatus() != 0))
/*     */       {
/* 140 */         this.status.failed = true;
/* 141 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 145 */       this.status.creatorRoleId = xShoppingGroupInfo.getCreator_roleid();
/* 146 */       this.status.price = xShoppingGroupInfo.getPrice();
/* 147 */       this.status.members.addAll(xShoppingGroupInfo.getMembers());
/* 148 */       this.status.groupSize = xShoppingGroupInfo.getGroup_size();
/* 149 */       this.status.groupShoppingItemCfgId = xShoppingGroupInfo.getGroup_shopping_item_cfgid();
/* 150 */       this.status.isSmallGroupShopping = (SSmallGroupShoppingItemCfg.get(this.status.groupShoppingItemCfgId) != null);
/*     */       
/*     */ 
/* 153 */       GroupShoppingCloseSession.stop(RCloseGroupShopping.this.groupId);
/*     */       
/*     */ 
/* 156 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 157 */       xShoppingGroupInfo.setClose_time(now);
/* 158 */       if (RCloseGroupShopping.this.isForceClose)
/*     */       {
/* 160 */         xShoppingGroupInfo.setStatus(3);
/* 161 */         this.status.closeType = 3;
/*     */       }
/* 163 */       else if (xShoppingGroupInfo.getMembers().size() >= xShoppingGroupInfo.getGroup_size())
/*     */       {
/* 165 */         xShoppingGroupInfo.setStatus(1);
/* 166 */         this.status.closeType = 1;
/*     */         
/*     */ 
/* 169 */         boolean broadcastCompleted = true;
/* 170 */         if (((this.status.isSmallGroupShopping) && (!GroupShoppingManager.isSmallGroupShoppingOpen())) || ((!this.status.isSmallGroupShopping) && (!GroupShoppingManager.isBigGroupShoppingOpen())))
/*     */         {
/* 172 */           broadcastCompleted = false; }
/* 173 */         if (broadcastCompleted)
/*     */         {
/* 175 */           final ShoppingGroupInfo xShoppingGroupInfoData = xShoppingGroupInfo.toData();
/* 176 */           new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/* 181 */               SBroadcastGroupShoppingCompleted completed = new SBroadcastGroupShoppingCompleted();
/* 182 */               completed.group_shopping_item_cfgid = xShoppingGroupInfoData.getGroup_shopping_item_cfgid();
/* 183 */               completed.creator_role_id = xShoppingGroupInfoData.getCreator_roleid();
/* 184 */               if (completed.creator_role_id != 0L)
/* 185 */                 completed.creator_name.setString(RoleInterface.getName(completed.creator_role_id), "UTF-8");
/* 186 */               OnlineManager.getInstance().sendAll(completed);
/* 187 */               return true;
/*     */             }
/*     */           }.execute();
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 194 */         xShoppingGroupInfo.setStatus(2);
/* 195 */         this.status.closeType = 2;
/*     */       }
/* 197 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class PHandleRoleInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final RCloseGroupShopping.Status status;
/*     */     
/*     */ 
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */ 
/*     */     private PHandleRoleInfo(RCloseGroupShopping.Status status, long roleId)
/*     */     {
/* 215 */       this.status = status;
/* 216 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*     */       SBigGroupShoppingItemCfg bigGroupShoppingItemCfg;
/*     */       SBigGroupShoppingItemCfg bigGroupShoppingItemCfg;
/*     */       SSmallGroupShoppingItemCfg smallGroupShoppingItemCfg;
/* 225 */       if (this.status.isSmallGroupShopping)
/*     */       {
/* 227 */         SSmallGroupShoppingItemCfg smallGroupShoppingItemCfg = SSmallGroupShoppingItemCfg.get(this.status.groupShoppingItemCfgId);
/* 228 */         if (smallGroupShoppingItemCfg == null)
/* 229 */           return false;
/* 230 */         bigGroupShoppingItemCfg = null;
/*     */       }
/*     */       else
/*     */       {
/* 234 */         bigGroupShoppingItemCfg = SBigGroupShoppingItemCfg.get(this.status.groupShoppingItemCfgId);
/* 235 */         if (bigGroupShoppingItemCfg == null)
/* 236 */           return false;
/* 237 */         smallGroupShoppingItemCfg = null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 242 */       RoleGroupShoppingRecord xRoleRecord = GroupShoppingManager.getRoleGroupShoppingRecord(this.roleId, RCloseGroupShopping.this.activityId);
/*     */       
/* 244 */       if (xRoleRecord == null)
/* 245 */         return false;
/* 246 */       xRoleRecord.getParticipating_groups().remove(Long.valueOf(RCloseGroupShopping.this.groupId));
/* 247 */       if (this.status.closeType != 3) {
/* 248 */         xRoleRecord.getParticipated_groups().add(Long.valueOf(RCloseGroupShopping.this.groupId));
/*     */       }
/*     */       
/*     */       String itemName;
/*     */       
/*     */       String itemName;
/* 254 */       if (smallGroupShoppingItemCfg != null) {
/* 255 */         itemName = ItemInterface.getItemName(smallGroupShoppingItemCfg.itemId);
/*     */       } else {
/* 257 */         itemName = ItemInterface.getItemName(bigGroupShoppingItemCfg.itemId);
/*     */       }
/* 259 */       MailAttachment attachment = new MailAttachment();
/* 260 */       int mailId; TLogArg tLogArg; if (this.status.closeType == 1)
/*     */       {
/*     */ 
/* 263 */         int mailId = SGroupShoppingConsts.getInstance().SUCCESS_MAIL_ID;
/* 264 */         TLogArg tLogArg = new TLogArg(LogReason.GROUP_SHOPPING_COMPLETED);
/* 265 */         if (smallGroupShoppingItemCfg != null)
/*     */         {
/* 267 */           attachment.addItem(smallGroupShoppingItemCfg.itemId, 1, ItemInterface.isItemFromShanghuiOrBaitan(smallGroupShoppingItemCfg.itemId));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 272 */           attachment.addItem(bigGroupShoppingItemCfg.itemId, 1, ItemInterface.isItemFromShanghuiOrBaitan(bigGroupShoppingItemCfg.itemId));
/*     */         }
/*     */         
/*     */       }
/* 276 */       else if (this.status.closeType == 2)
/*     */       {
/*     */ 
/* 279 */         xRoleRecord.getBought_num_map().put(Integer.valueOf(this.status.groupShoppingItemCfgId), Integer.valueOf(((Integer)xRoleRecord.getBought_num_map().get(Integer.valueOf(this.status.groupShoppingItemCfgId))).intValue() - 1));
/*     */         
/* 281 */         int mailId = SGroupShoppingConsts.getInstance().FAIL_MAIL_ID;
/* 282 */         TLogArg tLogArg = new TLogArg(LogReason.GROUP_SHOPPING_REFUND);
/*     */         
/*     */ 
/* 285 */         Integer usedBindYuanbao = (Integer)xRoleRecord.getUsed_bind_yuanbao_map().get(Long.valueOf(RCloseGroupShopping.this.groupId));
/* 286 */         if (usedBindYuanbao == null)
/*     */         {
/* 288 */           attachment.setYuanBao(this.status.price);
/*     */         }
/*     */         else
/*     */         {
/* 292 */           attachment.setBindYuanBao(usedBindYuanbao.intValue());
/* 293 */           int usedNonBindYuanbao = this.status.price - usedBindYuanbao.intValue();
/* 294 */           if (usedNonBindYuanbao > 0)
/*     */           {
/* 296 */             attachment.setYuanBao(usedNonBindYuanbao);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 303 */         xRoleRecord.getBought_num_map().put(Integer.valueOf(this.status.groupShoppingItemCfgId), Integer.valueOf(((Integer)xRoleRecord.getBought_num_map().get(Integer.valueOf(this.status.groupShoppingItemCfgId))).intValue() - 1));
/*     */         
/* 305 */         mailId = SGroupShoppingConsts.getInstance().SYSTEM_FAIL_MAIL_ID;
/* 306 */         TLogArg tLogArg; if (RCloseGroupShopping.this.calledOnBan)
/*     */         {
/* 308 */           tLogArg = new TLogArg(LogReason.GROUP_SHOPPING_BANNED);
/*     */         }
/*     */         else
/*     */         {
/* 312 */           tLogArg = new TLogArg(LogReason.GROUP_SHOPPING_CANCELLED);
/*     */         }
/*     */         
/*     */ 
/* 316 */         Integer usedBindYuanbao = (Integer)xRoleRecord.getUsed_bind_yuanbao_map().get(Long.valueOf(RCloseGroupShopping.this.groupId));
/* 317 */         if (usedBindYuanbao == null)
/*     */         {
/* 319 */           attachment.setYuanBao(this.status.price);
/*     */         }
/*     */         else
/*     */         {
/* 323 */           attachment.setBindYuanBao(usedBindYuanbao.intValue());
/* 324 */           int usedNonBindYuanbao = this.status.price - usedBindYuanbao.intValue();
/* 325 */           if (usedNonBindYuanbao > 0)
/*     */           {
/* 327 */             attachment.setYuanBao(usedNonBindYuanbao);
/*     */           }
/*     */         }
/*     */       }
/* 331 */       MailInterface.asynBuildAndSendMail(this.roleId, mailId, null, Collections.singletonList(itemName), attachment, tLogArg);
/*     */       
/* 333 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private class PHandleGroupShoppingInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final RCloseGroupShopping.Status status;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private PHandleGroupShoppingInfo(RCloseGroupShopping.Status status)
/*     */     {
/* 350 */       this.status = status;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 357 */       GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(RCloseGroupShopping.this.activityId);
/* 358 */       if (xGroupShoppingInfo == null) {
/* 359 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 363 */       if (this.status.isSmallGroupShopping)
/*     */       {
/* 365 */         if (RCloseGroupShopping.this.calledInActivity)
/* 366 */           IncompletedSmallGroupChartManager.remove(RCloseGroupShopping.this.groupId, this.status.groupShoppingItemCfgId);
/* 367 */         xGroupShoppingInfo.getIncompleted_small_groups().remove(Long.valueOf(RCloseGroupShopping.this.groupId));
/* 368 */         if (this.status.closeType != 1)
/*     */         {
/* 370 */           SmallGroupShoppingItemInfo xSmallGroupShoppingItemInfo = (SmallGroupShoppingItemInfo)xGroupShoppingInfo.getSmall_group_infos().get(Integer.valueOf(this.status.groupShoppingItemCfgId));
/*     */           
/* 372 */           if (xSmallGroupShoppingItemInfo == null)
/* 373 */             return false;
/* 374 */           xSmallGroupShoppingItemInfo.setRemaining_num(xSmallGroupShoppingItemInfo.getRemaining_num() + this.status.groupSize);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 380 */       if ((!this.status.isSmallGroupShopping) && (this.status.closeType != 1))
/*     */       {
/* 382 */         BigGroupShoppingItemInfo xBigGroupShoppingItemInfo = (BigGroupShoppingItemInfo)xGroupShoppingInfo.getBig_group_infos().get(Integer.valueOf(this.status.groupShoppingItemCfgId));
/*     */         
/* 384 */         if (xBigGroupShoppingItemInfo == null)
/* 385 */           return false;
/* 386 */         xBigGroupShoppingItemInfo.setRemaining_num(xBigGroupShoppingItemInfo.getRemaining_num() + this.status.members.size());
/*     */       }
/*     */       
/* 389 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\RCloseGroupShopping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */