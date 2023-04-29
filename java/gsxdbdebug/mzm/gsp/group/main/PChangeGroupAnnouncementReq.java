/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.group.SChangeGroupAnnouncementFail;
/*     */ import mzm.gsp.group.SChangeGroupAnnouncementSuccessBrd;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Group;
/*     */ import xbean.GroupInfo;
/*     */ import xbean.GroupMember;
/*     */ import xtable.Groups;
/*     */ 
/*     */ public class PChangeGroupAnnouncementReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long groupid;
/*     */   private final String announcement;
/*     */   
/*     */   public PChangeGroupAnnouncementReq(long roleid, long groupid, Octets announcement)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.groupid = groupid;
/*  26 */     this.announcement = announcement.getString("UTF-8").trim();
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (this.groupid < 0L)
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     if (!GroupManager.checkGroupAnnouncement(this.announcement))
/*     */     {
/*     */ 
/*  39 */       sendChangeGroupAnnouncementFail(3);
/*  40 */       GroupManager.logger.info(String.format("[group]PChangeGroupAnnouncementReq.processImp@group announcement illegal|roleid=%d|groupid=%d|announcement=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), this.announcement }));
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!GroupManager.isGroupSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  49 */       GroupManager.logger.info(String.format("[group]PChangeGroupAnnouncementReq.processImp@group module close or role forbidden|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!GroupManager.checkRoleStatus(this.roleid, 257))
/*     */     {
/*     */ 
/*  58 */       GroupManager.logger.info(String.format("[group]PChangeGroupAnnouncementReq.processImp@role status error|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     GroupInfo xGroupInfo = xtable.Role2groupinfo.get(Long.valueOf(this.roleid));
/*  65 */     if ((xGroupInfo == null) || (!xGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(this.groupid))))
/*     */     {
/*     */ 
/*  68 */       sendChangeGroupAnnouncementFail(2);
/*  69 */       GroupManager.logger.info(String.format("[group]PChangeGroupAnnouncementReq.processImp@only master can change group announcement|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     Group xGroup = Groups.get(Long.valueOf(this.groupid));
/*  77 */     if (xGroup == null)
/*     */     {
/*     */ 
/*  80 */       sendChangeGroupAnnouncementFail(1);
/*  81 */       GroupManager.logger.error(String.format("[group]PChangeGroupAnnouncementReq.processImp@group not exist|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (this.roleid != xGroup.getMasterid())
/*     */     {
/*     */ 
/*  89 */       sendChangeGroupAnnouncementFail(2);
/*  90 */       GroupManager.logger.error(String.format("[group]PChangeGroupAnnouncementReq.processImp@only master can change group announcement|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (this.announcement.equals(xGroup.getAnnouncement()))
/*     */     {
/*     */ 
/*  99 */       sendChangeGroupAnnouncementFail(4);
/* 100 */       GroupManager.logger.info(String.format("[group]PChangeGroupAnnouncementReq.processImp@same group announcement|roleid=%d|groupid=%d|announcement=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), this.announcement }));
/*     */       
/*     */ 
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     ArrayList<Long> concernMemberList = new ArrayList(xGroup.getMemberlist());
/* 109 */     Iterator<Long> iterator = concernMemberList.iterator();
/* 110 */     while (iterator.hasNext())
/*     */     {
/* 112 */       long memberid = ((Long)iterator.next()).longValue();
/* 113 */       if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() < 0L)
/*     */       {
/* 115 */         iterator.remove();
/*     */       }
/* 117 */       if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_basic_info_version() == xGroup.getInfo_version())
/* 118 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_basic_info_version(xGroup.getInfo_version() + 1L);
/* 119 */       if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() == xGroup.getInfo_version())
/* 120 */         ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).setGroup_info_version(xGroup.getInfo_version() + 1L);
/*     */     }
/* 122 */     if (!concernMemberList.contains(Long.valueOf(this.roleid))) {
/* 123 */       concernMemberList.add(Long.valueOf(this.roleid));
/*     */     }
/*     */     
/* 126 */     xGroup.setAnnouncement(this.announcement);
/* 127 */     xGroup.setInfo_version(xGroup.getInfo_version() + 1L);
/*     */     
/*     */ 
/* 130 */     SChangeGroupAnnouncementSuccessBrd protocol = new SChangeGroupAnnouncementSuccessBrd();
/* 131 */     protocol.groupid = this.groupid;
/* 132 */     protocol.announcement.setString(this.announcement, "UTF-8");
/* 133 */     protocol.info_version = xGroup.getInfo_version();
/* 134 */     OnlineManager.getInstance().sendMulti(protocol, concernMemberList);
/*     */     
/* 136 */     GroupTlogManager.addGroupTlog(this.roleid, 7, 1, xGroup.getGroup_type(), this.groupid, xGroup.getGroup_name(), -1L, -1);
/*     */     
/* 138 */     GroupManager.logger.info(String.format("[group]PChangeGroupAnnouncementReq.processImp@change group announcement success|roleid=%d|groupid=%d|announcement=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), this.announcement }));
/*     */     
/*     */ 
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   private void sendChangeGroupAnnouncementFail(int res)
/*     */   {
/* 146 */     SChangeGroupAnnouncementFail protocol = new SChangeGroupAnnouncementFail();
/* 147 */     protocol.res = res;
/* 148 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PChangeGroupAnnouncementReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */