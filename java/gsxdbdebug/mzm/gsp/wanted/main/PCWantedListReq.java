/*    */ package mzm.gsp.wanted.main;
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
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.wanted.SWantedListRsp;
/*    */ import mzm.gsp.wanted.WantedRoleInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2wantedinfo;
/*    */ 
/*    */ public class PCWantedListReq extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int pageNo;
/*    */   
/*    */   public PCWantedListReq(long roleId, int pageNo)
/*    */   {
/* 28 */     this.roleId = roleId;
/* 29 */     this.pageNo = pageNo;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     boolean ret = WantedManager.checkSwitchAndCross(this.roleId, 1653);
/* 36 */     if (!ret)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (!NpcInterface.checkNpcService(SPKConsts.getInstance().WANTED_NPC_ID, SPKConsts.getInstance().ARREST_SERVICE_ID, this.roleId))
/*    */     {
/*    */ 
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     if (!MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().WANTED_NPC_ID))
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     List<Long> roleIds = WantedPageManager.getInstance().getPageFromTail(this.pageNo);
/* 53 */     if (roleIds == null)
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     SWantedListRsp wantedListRsp = new SWantedListRsp();
/* 59 */     wantedListRsp.pagetotal = WantedPageManager.getInstance().getTotalPage();
/* 60 */     wantedListRsp.pageno = this.pageNo;
/*    */     
/* 62 */     long timeCfg = TimeUnit.MINUTES.toMillis(SPKConsts.getInstance().NPC_ARREST_MINUTES);
/*    */     
/*    */ 
/* 65 */     lock(Basic.getTable(), roleIds);
/*    */     
/* 67 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 69 */       WantedRoleInfo wantedRoleInfo = new WantedRoleInfo();
/* 70 */       wantedRoleInfo.roleid = roleId;
/* 71 */       wantedRoleInfo.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/* 72 */       wantedRoleInfo.gender = RoleInterface.getGender(roleId);
/* 73 */       wantedRoleInfo.menpai = RoleInterface.getOccupationId(roleId);
/* 74 */       wantedRoleInfo.name.setString(RoleInterface.getName(roleId), "utf-8");
/* 75 */       wantedRoleInfo.level = RoleInterface.getLevel(roleId);
/* 76 */       wantedRoleInfo.endtimestamp = (Role2wantedinfo.selectStarttimestamp(Long.valueOf(roleId)).longValue() + timeCfg);
/* 77 */       wantedRoleInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/* 78 */       wantedListRsp.wantedlist.add(wantedRoleInfo);
/*    */     }
/*    */     
/* 81 */     OnlineManager.getInstance().send(this.roleId, wantedListRsp);
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\PCWantedListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */