/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.group.SRenameGroupFail;
/*     */ import mzm.gsp.group.SRenameGroupSuccessBrd;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Group;
/*     */ import xbean.GroupInfo;
/*     */ import xbean.GroupMember;
/*     */ import xtable.Groups;
/*     */ 
/*     */ public class PRenameGroupReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long groupid;
/*     */   private final String newGroupName;
/*     */   
/*     */   public PRenameGroupReq(long roleid, long groupid, Octets newGroupName)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.groupid = groupid;
/*  26 */     this.newGroupName = newGroupName.getString("UTF-8").trim();
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (this.groupid < 0L)
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     if (!GroupManager.checkGroupName(this.newGroupName))
/*     */     {
/*     */ 
/*  40 */       sendRenameGroupFail(3);
/*  41 */       GroupManager.logger.info(String.format("[group]PRenameGroupReq.processImp@group name illegal|roleid=%d|groupid=%d|newGroupName=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), this.newGroupName }));
/*     */       
/*     */ 
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!GroupManager.isGroupSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  50 */       GroupManager.logger.info(String.format("[group]PRenameGroupReq.processImp@group module close or role forbidden|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!GroupManager.checkRoleStatus(this.roleid, 256))
/*     */     {
/*     */ 
/*  59 */       GroupManager.logger.info(String.format("[group]PRenameGroupReq.processImp@role status error|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     GroupInfo xGroupInfo = xtable.Role2groupinfo.get(Long.valueOf(this.roleid));
/*  66 */     if ((xGroupInfo == null) || (!xGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(this.groupid))))
/*     */     {
/*     */ 
/*  69 */       sendRenameGroupFail(2);
/*  70 */       GroupManager.logger.info(String.format("[group]PRenameGroupReq.processImp@only master can rename group|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     Group xGroup = Groups.get(Long.valueOf(this.groupid));
/*  77 */     if (xGroup == null)
/*     */     {
/*     */ 
/*  80 */       sendRenameGroupFail(1);
/*  81 */       GroupManager.logger.error(String.format("[group]PRenameGroupReq.processImp@group not exist|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (this.roleid != xGroup.getMasterid())
/*     */     {
/*     */ 
/*  89 */       sendRenameGroupFail(2);
/*  90 */       GroupManager.logger.error(String.format("[group]PRenameGroupReq.processImp@only master can rename group|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (this.newGroupName.equals(xGroup.getGroup_name()))
/*     */     {
/*     */ 
/*  98 */       sendRenameGroupFail(4);
/*  99 */       GroupManager.logger.info(String.format("[group]PRenameGroupReq.processImp@same group name|roleid=%d|groupid=%d|newGroupName=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), this.newGroupName }));
/*     */       
/*     */ 
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     ArrayList<Long> concernMemberList = new ArrayList(xGroup.getMemberlist());
/* 107 */     Iterator<Long> iterator = concernMemberList.iterator();
/* 108 */     while (iterator.hasNext())
/*     */     {
/* 110 */       long memberid = ((Long)iterator.next()).longValue();
/* 111 */       if ((((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_basic_info_version() < 0L) && (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() < 0L))
/*     */       {
/*     */ 
/* 114 */         iterator.remove();
/*     */       }
/* 116 */       if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_basic_info_version() == xGroup.getInfo_version())
/* 117 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_basic_info_version(xGroup.getInfo_version() + 1L);
/* 118 */       if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() == xGroup.getInfo_version())
/* 119 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_info_version(xGroup.getInfo_version() + 1L);
/*     */     }
/* 121 */     if (!concernMemberList.contains(Long.valueOf(this.roleid))) {
/* 122 */       concernMemberList.add(Long.valueOf(this.roleid));
/*     */     }
/*     */     
/* 125 */     xGroup.setGroup_name(this.newGroupName);
/* 126 */     xGroup.setInfo_version(xGroup.getInfo_version() + 1L);
/*     */     
/*     */ 
/* 129 */     SRenameGroupSuccessBrd protocol = new SRenameGroupSuccessBrd();
/* 130 */     protocol.groupid = this.groupid;
/* 131 */     protocol.new_group_name.setString(this.newGroupName, "UTF-8");
/* 132 */     protocol.info_version = xGroup.getInfo_version();
/* 133 */     OnlineManager.getInstance().sendMulti(protocol, concernMemberList);
/*     */     
/* 135 */     GroupTlogManager.addGroupTlog(this.roleid, 6, 1, xGroup.getGroup_type(), this.groupid, xGroup.getGroup_name(), -1L, -1);
/*     */     
/* 137 */     GroupManager.logger.info(String.format("[group]PRenameGroupReq.processImp@rename group success|roleid=%d|groupid=%d|newGroupName=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), this.newGroupName }));
/*     */     
/*     */ 
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   private void sendRenameGroupFail(int res)
/*     */   {
/* 145 */     SRenameGroupFail protocol = new SRenameGroupFail();
/* 146 */     protocol.res = res;
/* 147 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PRenameGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */