/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.prison.PrisonRoleInfo;
/*    */ import mzm.gsp.prison.SPrisonListRsp;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2prisoninfo;
/*    */ 
/*    */ public class PCPrisonListReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int pageNo;
/*    */   
/*    */   public PCPrisonListReq(long roleId, int pageNo)
/*    */   {
/* 30 */     this.roleId = roleId;
/* 31 */     this.pageNo = pageNo;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     boolean ret = PrisonManager.checkSwitchAndCross(this.roleId, 1666);
/* 39 */     if (!ret)
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 45 */     ret = NpcInterface.checkNpcService(SPKConsts.getInstance().RESCUE_NPC_ID, SPKConsts.getInstance().RESCUE_SERVICE_ID, this.roleId);
/*    */     
/* 47 */     if (!ret)
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     ret = MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().RESCUE_NPC_ID);
/* 54 */     if (!ret)
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     List<Long> roleIds = PrisonPageManager.getInstance().getPageFromTail(this.pageNo);
/* 60 */     if (roleIds == null)
/*    */     {
/* 62 */       return false;
/*    */     }
/* 64 */     SPrisonListRsp prisonListRsp = new SPrisonListRsp();
/* 65 */     prisonListRsp.pageno = this.pageNo;
/* 66 */     prisonListRsp.pagetotal = PrisonPageManager.getInstance().getTotalPage();
/*    */     
/*    */ 
/*    */ 
/* 70 */     lock(Basic.getTable(), roleIds);
/*    */     
/* 72 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 74 */       PrisonRoleInfo prisonRoleInfo = new PrisonRoleInfo();
/* 75 */       prisonRoleInfo.roleid = roleId;
/* 76 */       prisonRoleInfo.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/* 77 */       prisonRoleInfo.gender = RoleInterface.getGender(roleId);
/* 78 */       prisonRoleInfo.menpai = RoleInterface.getOccupationId(roleId);
/* 79 */       prisonRoleInfo.name.setString(RoleInterface.getName(roleId), "utf-8");
/* 80 */       prisonRoleInfo.level = RoleInterface.getLevel(roleId);
/* 81 */       prisonRoleInfo.endtimestamp = (TimeUnit.SECONDS.toMillis(PrisonInterface.checkCanLetRoleOutOfJail(roleId, Role2prisoninfo.select(Long.valueOf(roleId))).inJailLeftTime) + DateTimeUtils.getCurrTimeInMillis());
/*    */       
/*    */ 
/* 84 */       prisonRoleInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/* 85 */       prisonListRsp.prisonlist.add(prisonRoleInfo);
/*    */     }
/*    */     
/* 88 */     OnlineManager.getInstance().send(this.roleId, prisonListRsp);
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PCPrisonListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */