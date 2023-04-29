/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.group.SKickGroupMemberFail;
/*     */ import mzm.gsp.group.SKickGroupMemberSuccessBrd;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Group;
/*     */ import xbean.GroupInfo;
/*     */ import xbean.GroupMember;
/*     */ import xtable.Groups;
/*     */ import xtable.Role2groupinfo;
/*     */ 
/*     */ public class PKickGroupMemberReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long masterid;
/*     */   private final long memberid;
/*     */   private final long groupid;
/*     */   
/*     */   public PKickGroupMemberReq(long masterid, long memberid, long groupid)
/*     */   {
/*  27 */     this.masterid = masterid;
/*  28 */     this.memberid = memberid;
/*  29 */     this.groupid = groupid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if ((this.memberid < 0L) || (this.groupid < 0L))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!GroupManager.isGroupSwitchOpenForRole(this.masterid, true))
/*     */     {
/*     */ 
/*  43 */       GroupManager.logger.info(String.format("[group]PKickGroupMemberReq.processImp@group module close or role forbidden|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  46 */       return false;
/*     */     }
/*  48 */     if (!GroupManager.checkRoleStatus(this.masterid, 254))
/*     */     {
/*     */ 
/*  51 */       GroupManager.logger.info(String.format("[group]PKickGroupMemberReq.processImp@role status error|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  54 */       return false;
/*     */     }
/*  56 */     if (this.masterid == this.memberid)
/*     */     {
/*  58 */       GroupManager.logger.info(String.format("[group]PKickGroupMemberReq.processImp@masterid equals memberid|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     HashSet<Long> lockRole = new HashSet();
/*  66 */     lockRole.add(Long.valueOf(this.masterid));
/*  67 */     lockRole.add(Long.valueOf(this.memberid));
/*  68 */     lock(xdb.Lockeys.get(xtable.Basic.getTable(), lockRole));
/*     */     
/*  70 */     GroupInfo xMasterGroupInfo = Role2groupinfo.get(Long.valueOf(this.masterid));
/*  71 */     GroupInfo xMemberGroupInfo = Role2groupinfo.get(Long.valueOf(this.memberid));
/*     */     
/*     */ 
/*  74 */     Group xGroup = Groups.get(Long.valueOf(this.groupid));
/*     */     
/*  76 */     if ((xMasterGroupInfo == null) || (!xMasterGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(this.groupid))))
/*     */     {
/*     */ 
/*  79 */       sendKickGroupMemberFail(2);
/*  80 */       GroupManager.logger.info(String.format("[group]PKickGroupMemberReq.processImp@only master can kick member|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if ((xMemberGroupInfo == null) || (!xMemberGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(this.groupid))))
/*     */     {
/*     */ 
/*  89 */       sendKickGroupMemberFail(3);
/*  90 */       GroupManager.logger.info(String.format("[group]PKickGroupMemberReq.processImp@member is not in group|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (xGroup == null)
/*     */     {
/*     */ 
/*  99 */       sendKickGroupMemberFail(1);
/* 100 */       GroupManager.logger.error(String.format("[group]PKickGroupMemberReq.processImp@group not exist|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     if (xGroup.getMasterid() != this.masterid)
/*     */     {
/*     */ 
/* 109 */       sendKickGroupMemberFail(2);
/* 110 */       GroupManager.logger.error(String.format("[group]PKickGroupMemberReq.processImp@only master can kick member|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     if (!xGroup.getMemberlist().contains(Long.valueOf(this.memberid)))
/*     */     {
/*     */ 
/* 119 */       sendKickGroupMemberFail(3);
/* 120 */       GroupManager.logger.info(String.format("[group]PKickGroupMemberReq.processImp@member is not in group|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     ArrayList<Long> concernMemberList = new ArrayList(xGroup.getMemberlist());
/* 128 */     Iterator<Long> iteratorConcern = concernMemberList.iterator();
/* 129 */     while (iteratorConcern.hasNext())
/*     */     {
/* 131 */       long memberid = ((Long)iteratorConcern.next()).longValue();
/* 132 */       if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() != xGroup.getInfo_version())
/*     */       {
/* 134 */         iteratorConcern.remove();
/*     */       }
/*     */       else
/*     */       {
/* 138 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_basic_info_version(xGroup.getInfo_version() + 1L);
/* 139 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_info_version(xGroup.getInfo_version() + 1L);
/*     */       }
/*     */     }
/* 142 */     if (!concernMemberList.contains(Long.valueOf(this.masterid)))
/* 143 */       concernMemberList.add(Long.valueOf(this.masterid));
/* 144 */     if (!GroupManager.isGroupSwitchOpenForRole(this.memberid, false))
/*     */     {
/* 146 */       concernMemberList.remove(Long.valueOf(this.memberid));
/*     */     }
/* 148 */     else if (OnlineManager.getInstance().isOnline(this.memberid))
/*     */     {
/* 150 */       if (!concernMemberList.contains(Long.valueOf(this.memberid))) {
/* 151 */         concernMemberList.add(Long.valueOf(this.memberid));
/*     */       }
/*     */     }
/*     */     
/* 155 */     Iterator<Long> iterator = xGroup.getMemberlist().iterator();
/* 156 */     while (iterator.hasNext())
/*     */     {
/* 158 */       long roleid = ((Long)iterator.next()).longValue();
/* 159 */       if (roleid == this.memberid)
/*     */       {
/* 161 */         iterator.remove();
/* 162 */         break;
/*     */       }
/*     */     }
/* 165 */     xGroup.getGroupmembers().remove(Long.valueOf(this.memberid));
/* 166 */     xGroup.setInfo_version(xGroup.getInfo_version() + 1L);
/* 167 */     xMemberGroupInfo.getJoin_same_zone_groupids().remove(Long.valueOf(this.groupid));
/*     */     
/*     */ 
/* 170 */     SKickGroupMemberSuccessBrd protocol = new SKickGroupMemberSuccessBrd();
/* 171 */     protocol.groupid = this.groupid;
/* 172 */     protocol.group_name.setString(xGroup.getGroup_name(), "UTF-8");
/* 173 */     protocol.master_name.setString(mzm.gsp.role.main.RoleInterface.getName(this.masterid), "UTF-8");
/* 174 */     protocol.memberid = this.memberid;
/* 175 */     protocol.info_version = xGroup.getInfo_version();
/* 176 */     OnlineManager.getInstance().sendMulti(protocol, concernMemberList);
/*     */     
/* 178 */     if ((GroupManager.isGroupSwitchOpenForRole(this.memberid, false)) && (!concernMemberList.contains(Long.valueOf(this.memberid)))) {
/* 179 */       GroupAsynTaskManager.getInstance().addTask(new PAddOfflineGroupKickInfo(this.masterid, this.memberid, this.groupid));
/*     */     }
/* 181 */     GroupTlogManager.addGroupTlog(this.masterid, 4, 1, xGroup.getGroup_type(), this.groupid, xGroup.getGroup_name(), this.memberid, -1);
/*     */     
/* 183 */     GroupManager.logger.info(String.format("[group]PKickGroupMemberReq.processImp@kick group member success|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*     */     
/*     */ 
/* 186 */     return true;
/*     */   }
/*     */   
/*     */   private void sendKickGroupMemberFail(int res)
/*     */   {
/* 191 */     SKickGroupMemberFail protocol = new SKickGroupMemberFail();
/* 192 */     protocol.res = res;
/* 193 */     OnlineManager.getInstance().sendAtOnce(this.masterid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PKickGroupMemberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */