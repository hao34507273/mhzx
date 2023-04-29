/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SGiveUpBreedSuccess;
/*     */ import mzm.gsp.children.SSyncBreedInfo;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2children;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGiveUpBreed extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCGiveUpBreed(long roleId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  39 */       onGiveUpBreedFail(21);
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!ChildrenManager.canDoAction(this.roleId, 840))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  55 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*     */     
/*     */ 
/*  58 */     if (marriedRoleId > 0L)
/*     */     {
/*  60 */       String marriedRoleUserId = RoleInterface.getUserId(marriedRoleId);
/*  61 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedRoleUserId }));
/*  62 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  66 */       lock(Lockeys.get(User.getTable(), userId));
/*  67 */       lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*  70 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(this.roleId, true);
/*  71 */     if (breedInfo == null)
/*     */     {
/*  73 */       onGiveUpBreedFail(43);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (breedInfo.breed_state == 1)
/*     */     {
/*  79 */       Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/*  80 */       if (xRole2ChildrenInfo == null)
/*     */       {
/*  82 */         onGiveUpBreedFail(44);
/*  83 */         return false;
/*     */       }
/*     */       
/*  86 */       xRole2ChildrenInfo.setSignal_way_child_score(0);
/*  87 */       SGiveUpBreedSuccess sGiveUpBreedSuccess = new SGiveUpBreedSuccess();
/*  88 */       OnlineManager.getInstance().send(this.roleId, sGiveUpBreedSuccess);
/*     */     }
/*     */     else
/*     */     {
/*  92 */       long marrigedId = MarriageInterface.getMarriedId(this.roleId, true);
/*  93 */       if (marrigedId < 0L)
/*     */       {
/*  95 */         onGiveUpBreedFail(31);
/*  96 */         return false;
/*     */       }
/*     */       
/*  99 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }), 901);
/*     */       
/* 101 */       MarriageInterface.clearMarriagePregnant(marrigedId);
/* 102 */       String roleIdName = RoleInterface.getName(this.roleId);
/*     */       
/* 104 */       List<String> contextArgList = new ArrayList();
/* 105 */       contextArgList.add(roleIdName);
/*     */       
/*     */ 
/* 108 */       MailInterface.synBuildAndSendMail(marriedRoleId, SChildrenConsts.getInstance().breed_give_up_notify_mail_id, new ArrayList(), contextArgList, null, new TLogArg(mzm.gsp.tlog.LogReason.CHILDREN_GIVE_UP_PREGNANT_NOTIFY_MAIL));
/*     */       
/*     */ 
/* 111 */       SGiveUpBreedSuccess sGiveUpBreedSuccess = new SGiveUpBreedSuccess();
/* 112 */       OnlineManager.getInstance().send(this.roleId, sGiveUpBreedSuccess);
/*     */     }
/*     */     
/* 115 */     ChildrenManager.tlogGiveUpBreed(userId, this.roleId, breedInfo.breed_state, breedInfo.step, breedInfo.score);
/*     */     
/* 117 */     SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo();
/* 118 */     sSyncBreedInfo.breed_state = 2;
/* 119 */     sSyncBreedInfo.step = 1;
/*     */     
/* 121 */     if (breedInfo.breed_state == 1)
/*     */     {
/* 123 */       OnlineManager.getInstance().send(this.roleId, sSyncBreedInfo);
/*     */     }
/*     */     else
/*     */     {
/* 127 */       long partnerRoleId = MarriageInterface.getMarriedRoleid(this.roleId, true);
/* 128 */       OnlineManager.getInstance().sendMulti(sSyncBreedInfo, Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId) }));
/*     */     }
/*     */     
/* 131 */     GameServer.logger().info(String.format("[children]PCGiveUpBreed.processImp@give up breed success|role_id=%d|breed_state=%d|breed_step=%d|score=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(breedInfo.breed_state), Integer.valueOf(breedInfo.step), Integer.valueOf(breedInfo.score) }));
/*     */     
/*     */ 
/*     */ 
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private void onGiveUpBreedFail(int ret)
/*     */   {
/* 140 */     onGiveUpBreedFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onGiveUpBreedFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 145 */     StringBuilder sbLog = new StringBuilder();
/* 146 */     sbLog.append("[children]PCGiveUpBreed.processImp@give up breed failed");
/* 147 */     sbLog.append("|ret=").append(ret);
/* 148 */     sbLog.append("|role_id=").append(this.roleId);
/* 149 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 151 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 153 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 156 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 158 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 159 */     sChildNormalFail.result = ret;
/*     */     
/* 161 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCGiveUpBreed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */