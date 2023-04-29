/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeSet;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SFreeChildSuccess;
/*     */ import mzm.gsp.children.SRealDeleteChild;
/*     */ import mzm.gsp.children.childhood.ChildhoodManager;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.children.event.RemoveChildFromHome;
/*     */ import mzm.gsp.children.event.RemoveChildFromHomeArg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Children;
/*     */ import xtable.Childrengrowthdiary;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCFreeChild extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   
/*     */   public PCFreeChild(long roleId, long childId)
/*     */   {
/*  45 */     this.roleId = roleId;
/*  46 */     this.childId = childId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  54 */       onChildFreeFail(21);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!ChildrenManager.canDoAction(this.roleId, 838))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  70 */     long marriedRoleId = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.roleId, false);
/*  71 */     if (marriedRoleId > 0L)
/*     */     {
/*  73 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/*  74 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/*  75 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  79 */       lock(Lockeys.get(User.getTable(), userId));
/*     */     }
/*     */     
/*     */ 
/*  83 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/*     */     
/*  85 */     if (xRole2ChildrenInfo == null)
/*     */     {
/*  87 */       onChildFreeFail(4);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     lock(Children.getTable(), new ArrayList(xRole2ChildrenInfo.getChild_id_list()));
/*     */     
/*  93 */     if (xRole2ChildrenInfo.getTotal_discard_child_num() >= SChildrenConsts.getInstance().discard_child_num_limit)
/*     */     {
/*  95 */       SortedSet<ChildDiscard> discardChildSet = new TreeSet();
/*  96 */       for (Iterator i$ = xRole2ChildrenInfo.getChild_id_list().iterator(); i$.hasNext();) { long ownChildId = ((Long)i$.next()).longValue();
/*     */         
/*  98 */         ChildInfo xChildInfo = Children.get(Long.valueOf(ownChildId));
/*  99 */         if ((xChildInfo != null) && (xChildInfo.getIs_discard()))
/*     */         {
/* 101 */           discardChildSet.add(new ChildDiscard(ownChildId, xChildInfo));
/*     */         }
/*     */       }
/* 104 */       long realDiscardChild = ((ChildDiscard)discardChildSet.first()).childId;
/* 105 */       Children.remove(Long.valueOf(realDiscardChild));
/* 106 */       Childrengrowthdiary.remove(Long.valueOf(realDiscardChild));
/* 107 */       xRole2ChildrenInfo.getChild_id_list().remove(Long.valueOf(realDiscardChild));
/*     */       
/* 109 */       tlogRealDeleteChild(userId, this.roleId, marriedRoleId, realDiscardChild);
/*     */       
/*     */ 
/* 112 */       SRealDeleteChild sRealDeleteChild = new SRealDeleteChild();
/* 113 */       sRealDeleteChild.child_id = realDiscardChild;
/*     */       
/* 115 */       OnlineManager.getInstance().send(this.roleId, sRealDeleteChild);
/* 116 */       if (marriedRoleId > 0L)
/*     */       {
/* 118 */         OnlineManager.getInstance().send(marriedRoleId, sRealDeleteChild);
/*     */       }
/*     */       
/* 121 */       xRole2ChildrenInfo.setTotal_discard_child_num(xRole2ChildrenInfo.getTotal_discard_child_num() - 1);
/*     */     }
/*     */     
/*     */ 
/* 125 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/* 126 */     if (xChildInfo == null)
/*     */     {
/* 128 */       onChildFreeFail(2);
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     if (xChildInfo.getOwn_role_id() != this.roleId)
/*     */     {
/* 134 */       onChildFreeFail(1);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if (ChildrenInterface.isInFight(this.roleId, this.childId))
/*     */     {
/* 140 */       onChildFreeFail(51);
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     if (xChildInfo.getIs_discard())
/*     */     {
/* 146 */       onChildFreeFail(72);
/* 147 */       return false;
/*     */     }
/* 149 */     boolean isInMyBag = xRole2ChildrenInfo.getChild_bag_id_list().contains(Long.valueOf(this.childId));
/*     */     
/* 151 */     if ((!isInMyBag) && (xChildInfo.getHome_state() == 0))
/*     */     {
/* 153 */       onChildFreeFail(36);
/* 154 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 158 */     ChildhoodManager.onDiscard(this.childId, xChildInfo);
/*     */     
/* 160 */     xRole2ChildrenInfo.getChild_bag_id_list().remove(Long.valueOf(this.childId));
/*     */     
/* 162 */     if (marriedRoleId > 0L)
/*     */     {
/* 164 */       Role2ChildrenInfo xMarriedChildrenInfo = Role2children.get(Long.valueOf(marriedRoleId));
/* 165 */       if (xMarriedChildrenInfo != null)
/*     */       {
/* 167 */         List<String> contextArgs = new ArrayList();
/* 168 */         contextArgs.add(xChildInfo.getChild_name());
/* 169 */         contextArgs.add(RoleInterface.getName(this.roleId));
/*     */         
/* 171 */         MailInterface.synBuildAndSendMail(marriedRoleId, SChildrenConsts.getInstance().child_give_up_notify_mail_id, new ArrayList(), contextArgs, new MailAttachment(), new mzm.gsp.tlog.TLogArg(LogReason.CHILDREN_FREE_NOTIFY_MAIL));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 177 */     ChildrenManager.tlogChildOperator(userId, this.roleId, this.childId, 4, 0);
/*     */     
/* 179 */     if ((xRole2ChildrenInfo != null) && (xRole2ChildrenInfo.getShow_child_id() == this.childId))
/*     */     {
/* 181 */       xRole2ChildrenInfo.setShow_child_id(-1L);
/* 182 */       xRole2ChildrenInfo.setShow_child_period(0);
/*     */       
/* 184 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleId, mzm.gsp.children.event.ChildShowModelChangeReason.REMOVE));
/*     */     }
/*     */     
/*     */ 
/* 188 */     if (xChildInfo.getHome_state() != 0)
/*     */     {
/* 190 */       ChildrenManager.trigChildrenEvent(new RemoveChildFromHome(), new RemoveChildFromHomeArg(this.roleId, this.childId));
/*     */     }
/* 192 */     xChildInfo.setIs_discard(true);
/*     */     
/* 194 */     xChildInfo.setCarry_role_id(-1L);
/* 195 */     xChildInfo.setHome_state(0);
/*     */     
/* 197 */     xChildInfo.setDiscard_time(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 199 */     xRole2ChildrenInfo.setTotal_discard_child_num(xRole2ChildrenInfo.getTotal_discard_child_num() + 1);
/*     */     
/* 201 */     ChildrenManager.trigChildrenEvent(new mzm.gsp.children.event.ChildFree(), new mzm.gsp.children.event.ChildFreeArg(this.roleId, this.childId));
/*     */     
/* 203 */     SFreeChildSuccess sFreeChildSuccess = new SFreeChildSuccess();
/* 204 */     sFreeChildSuccess.child_id = this.childId;
/* 205 */     OnlineManager.getInstance().send(this.roleId, sFreeChildSuccess);
/* 206 */     if (marriedRoleId > 0L)
/*     */     {
/* 208 */       OnlineManager.getInstance().send(marriedRoleId, sFreeChildSuccess);
/*     */     }
/*     */     
/* 211 */     ChildrenManager.triggerChildRatingChange(this.roleId, this.childId, true);
/*     */     
/* 213 */     GameServer.logger().info(String.format("[children]PCFreeChild.processImp@free child success|role_id=%d|child_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId) }));
/*     */     
/*     */ 
/* 216 */     return true;
/*     */   }
/*     */   
/*     */   private static class ChildDiscard implements Comparable<ChildDiscard>
/*     */   {
/*     */     public final long childId;
/*     */     private final ChildInfo xChildInfo;
/*     */     
/*     */     public ChildDiscard(long childId, ChildInfo xChildInfo)
/*     */     {
/* 226 */       this.childId = childId;
/* 227 */       this.xChildInfo = xChildInfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public int compareTo(ChildDiscard o)
/*     */     {
/* 233 */       if (this.xChildInfo.getChild_period() < o.xChildInfo.getChild_period())
/*     */       {
/* 235 */         return -1;
/*     */       }
/* 237 */       if (this.xChildInfo.getChild_period() > o.xChildInfo.getChild_period())
/*     */       {
/* 239 */         return 1;
/*     */       }
/* 241 */       if ((this.xChildInfo.getChild_period() == 1) || (this.xChildInfo.getChild_period() == 0))
/*     */       {
/* 243 */         if (this.xChildInfo.getDiscard_time() < o.xChildInfo.getDiscard_time())
/*     */         {
/* 245 */           return -1;
/*     */         }
/*     */         
/*     */ 
/* 249 */         return 1;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 254 */       int myChildRating = ChildrenManager.getChildRating(this.xChildInfo, true);
/* 255 */       int compareChildRating = ChildrenManager.getChildRating(o.xChildInfo, true);
/* 256 */       if (myChildRating < compareChildRating)
/*     */       {
/* 258 */         return -1;
/*     */       }
/*     */       
/*     */ 
/* 262 */       return 1;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onChildFreeFail(int ret)
/*     */   {
/* 271 */     onChildFreeFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onChildFreeFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 276 */     StringBuilder sbLog = new StringBuilder();
/* 277 */     sbLog.append("[children]PCFreeChild.processImp@child free failed");
/* 278 */     sbLog.append("|ret=").append(ret);
/* 279 */     sbLog.append("|role_id=").append(this.roleId);
/* 280 */     sbLog.append("|child_id=").append(this.childId);
/* 281 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 283 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 285 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 288 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 290 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 291 */     sChildNormalFail.result = ret;
/*     */     
/* 293 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */   
/*     */   private void tlogRealDeleteChild(String userId, long roleId, long partnerRoleId, long childId)
/*     */   {
/* 298 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 300 */     StringBuilder sbLog = new StringBuilder();
/* 301 */     sbLog.append(mzm.gsp.GameServerInfoManager.getHostIP()).append('|');
/* 302 */     sbLog.append(userId).append('|');
/* 303 */     sbLog.append(roleId).append('|');
/* 304 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 306 */     sbLog.append(partnerRoleId).append('|');
/* 307 */     sbLog.append(childId);
/*     */     
/* 309 */     TLogManager.getInstance().addLog(roleId, "ChildRealDeleteStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCFreeChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */