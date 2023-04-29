/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.group.SGetSingleGroupInfoFail;
/*     */ import mzm.gsp.group.SGetSingleGroupInfoSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Group;
/*     */ import xbean.GroupInfo;
/*     */ import xbean.GroupMember;
/*     */ import xtable.Groups;
/*     */ 
/*     */ public class PGetSingleGroupInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long groupid;
/*     */   private final long infoVersion;
/*     */   
/*     */   public PGetSingleGroupInfoReq(long roleid, long groupid, long infoVersion)
/*     */   {
/*  21 */     this.roleid = roleid;
/*  22 */     this.groupid = groupid;
/*  23 */     this.infoVersion = infoVersion;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if ((this.groupid < 0L) || (this.infoVersion < -1L))
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     if (!GroupManager.isGroupSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  37 */       GroupManager.logger.info(String.format("[group]PGetSingleGroupInfoReq.processImp@group module close or role forbidden|roleid=%d|groupid=%d|infoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.infoVersion) }));
/*     */       
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!GroupManager.checkRoleStatus(this.roleid, 260))
/*     */     {
/*     */ 
/*  46 */       GroupManager.logger.info(String.format("[group]PGetSingleGroupInfoReq.processImp@role status error|roleid=%d|groupid=%d|infoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.infoVersion) }));
/*     */       
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     GroupInfo xGroupInfo = xtable.Role2groupinfo.get(Long.valueOf(this.roleid));
/*  54 */     if ((xGroupInfo == null) || ((!xGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(this.groupid))) && (!xGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(this.groupid)))))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  59 */       sendGetSingleGroupInfoFail(2);
/*  60 */       GroupManager.logger.info(String.format("[group]PGetSingleGroupInfoReq.processImp@role is not in group|roleid=%d|groupid=%d|infoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.infoVersion) }));
/*     */       
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     Group xGroup = Groups.get(Long.valueOf(this.groupid));
/*  68 */     if (xGroup == null)
/*     */     {
/*     */ 
/*  71 */       sendGetSingleGroupInfoFail(1);
/*  72 */       GroupManager.logger.info(String.format("[group]PGetSingleGroupInfoReq.processImp@group not exist|roleid=%d|groupid=%d|infoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.infoVersion) }));
/*     */       
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!xGroup.getMemberlist().contains(Long.valueOf(this.roleid)))
/*     */     {
/*     */ 
/*  81 */       sendGetSingleGroupInfoFail(2);
/*  82 */       GroupManager.logger.error(String.format("[group]PGetSingleGroupInfoReq.processImp@role is not in group|roleid=%d|groupid=%d|infoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.infoVersion) }));
/*     */       
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if (xGroup.getInfo_version() == this.infoVersion)
/*     */     {
/*     */ 
/*  91 */       ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(this.roleid))).setGroup_basic_info_version(this.infoVersion);
/*  92 */       ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(this.roleid))).setGroup_info_version(this.infoVersion);
/*     */       
/*  94 */       SGetSingleGroupInfoSuccess protocol = new SGetSingleGroupInfoSuccess();
/*  95 */       protocol.group_info.groupid = this.groupid;
/*  96 */       protocol.group_info.info_version = this.infoVersion;
/*  97 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*  98 */       GroupManager.logger.info(String.format("[group]PGetSingleGroupInfoReq.processImp@get single group info success|roleid=%d|groupid=%d|infoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.infoVersion) }));
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 105 */       GroupAsynTaskManager.getInstance().addTask(new PGetSingleGroupInfoReqVersionNotMatch(this.roleid, this.groupid));
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   private void sendGetSingleGroupInfoFail(int res)
/*     */   {
/* 112 */     SGetSingleGroupInfoFail protocol = new SGetSingleGroupInfoFail();
/* 113 */     protocol.res = res;
/* 114 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PGetSingleGroupInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */