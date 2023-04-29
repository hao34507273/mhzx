/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.children.SAddChild;
/*     */ import mzm.gsp.children.SSyncBreedInfo;
/*     */ import mzm.gsp.children.event.AddChildIntoHome;
/*     */ import mzm.gsp.children.event.AddChildIntoHomeArg;
/*     */ import mzm.gsp.children.event.ChildAddHomeReason;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.gift.main.InvitationInterface;
/*     */ import mzm.gsp.interactivetask.event.GiveBirthArg;
/*     */ import mzm.gsp.interactivetask.event.GiveBirthFinishEventProcedure;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChildGrowthDiaryInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnGiveBirthFinishEvent extends GiveBirthFinishEventProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     List<String> userIdList = new ArrayList();
/*  30 */     for (Iterator i$ = ((GiveBirthArg)this.arg).roleids.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  32 */       String userId = RoleInterface.getUserId(roleId);
/*  33 */       userIdList.add(userId);
/*     */     }
/*  35 */     lock(User.getTable(), userIdList);
/*  36 */     lock(xtable.Role2properties.getTable(), ((GiveBirthArg)this.arg).roleids);
/*     */     
/*  38 */     if (!((GiveBirthArg)this.arg).isSuccess)
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     int teamSize = ((GiveBirthArg)this.arg).roleids.size();
/*  44 */     if (teamSize != 2)
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     long roleIdA = ((Long)((GiveBirthArg)this.arg).roleids.get(0)).longValue();
/*  50 */     long roleIdB = ((Long)((GiveBirthArg)this.arg).roleids.get(1)).longValue();
/*     */     
/*  52 */     long roleIdAPartnerRoleId = MarriageInterface.getMarriedRoleid(roleIdA, true);
/*  53 */     if ((roleIdAPartnerRoleId != roleIdB) || (roleIdAPartnerRoleId < 0L))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long marriageId = MarriageInterface.getMarriedId(roleIdA, true);
/*  59 */     if (marriageId < 0L)
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  66 */     lock(Lockeys.get(xtable.Marriage.getTable(), Long.valueOf(marriageId)));
/*     */     
/*     */ 
/*  69 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(roleIdA, true);
/*  70 */     if (breedInfo.breed_state != 0)
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (breedInfo.step != 4)
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     long belongRoleId = breedInfo.belongRoleId;
/*     */     
/*  82 */     if ((belongRoleId != roleIdA) && (belongRoleId != roleIdB))
/*     */     {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     int roomMapCfgId = mzm.gsp.homeland.main.HomelandInterface.getRoleHomeRoomMap(roleIdA);
/*     */     
/*  89 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  90 */     ChildInfo xChildInfo = ChildrenManager.generatorChild(belongRoleId, currentTimeMillis);
/*  91 */     long childId = xtable.Children.insert(xChildInfo).longValue();
/*     */     
/*  93 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = ChildrenManager.generatorChildGrowthDiary(currentTimeMillis, childId);
/*     */     
/*     */ 
/*  96 */     xChildInfo.setOwn_role_id(belongRoleId);
/*     */     
/*  98 */     if (belongRoleId == roleIdA)
/*     */     {
/* 100 */       xChildInfo.setAnother_parent_role_id(roleIdB);
/* 101 */       xChildGrowthDiaryInfo.setAnother_give_birth_parent_role_id(roleIdB);
/*     */     }
/*     */     else
/*     */     {
/* 105 */       xChildInfo.setAnother_parent_role_id(roleIdA);
/* 106 */       xChildGrowthDiaryInfo.setAnother_give_birth_parent_role_id(roleIdA);
/*     */     }
/*     */     
/* 109 */     Role2ChildrenInfo xRole2ChildrenInfo = ChildrenManager.initAndGetChildrenInfo(belongRoleId);
/* 110 */     xRole2ChildrenInfo.getChild_id_list().add(Long.valueOf(childId));
/*     */     
/* 112 */     MarriageInterface.clearMarriagePregnant(marriageId);
/*     */     
/* 114 */     String roleIdAName = RoleInterface.getName(roleIdA);
/* 115 */     String roleIdBName = RoleInterface.getName(roleIdB);
/* 116 */     List<String> paramList = new ArrayList();
/* 117 */     paramList.add(roleIdAName);
/* 118 */     paramList.add(roleIdBName);
/*     */     
/* 120 */     List<Long> roleIdAFriendList = FriendInterface.getAllFriends(roleIdA, true);
/* 121 */     roleIdAFriendList.remove(Long.valueOf(roleIdB));
/*     */     
/* 123 */     List<Long> roleIdBFriendList = FriendInterface.getAllFriends(roleIdB, true);
/* 124 */     roleIdBFriendList.remove(Long.valueOf(roleIdA));
/*     */     
/* 126 */     InvitationInterface.sendInvitationToRoles(roleIdA, roleIdAFriendList, 2, paramList);
/*     */     
/* 128 */     InvitationInterface.sendInvitationToRoles(roleIdB, roleIdBFriendList, 2, paramList);
/*     */     
/*     */ 
/* 131 */     ChildrenManager.trigChildrenEvent(new AddChildIntoHome(), new AddChildIntoHomeArg(roleIdA, childId, roomMapCfgId, ChildAddHomeReason.GIVE_BIRTH));
/*     */     
/*     */ 
/* 134 */     ChildrenManager.tlogCoupleWayGetChildren(roleIdA, roleIdB, childId, xChildInfo.getOwn_role_id());
/*     */     
/* 136 */     mzm.gsp.status.main.RoleStatusInterface.unsetStatus(((GiveBirthArg)this.arg).roleids, 901);
/*     */     
/* 138 */     ChildrenManager.cancelGiveBirthObserver(marriageId);
/*     */     
/* 140 */     SAddChild sAddChild = new SAddChild();
/* 141 */     sAddChild.child_id = childId;
/* 142 */     ChildrenManager.fillChildBean(belongRoleId, childId, xChildInfo, sAddChild.child_info, false);
/*     */     
/* 144 */     OnlineManager.getInstance().sendMulti(sAddChild, ((GiveBirthArg)this.arg).roleids);
/*     */     
/* 146 */     SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo();
/* 147 */     sSyncBreedInfo.breed_state = 2;
/* 148 */     sSyncBreedInfo.step = 1;
/*     */     
/* 150 */     OnlineManager.getInstance().sendMulti(sSyncBreedInfo, ((GiveBirthArg)this.arg).roleids);
/* 151 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnGiveBirthFinishEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */