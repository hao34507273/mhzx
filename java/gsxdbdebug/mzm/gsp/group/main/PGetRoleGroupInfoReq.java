/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.group.SGetRoleGroupInfoSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Group;
/*     */ import xtable.Groups;
/*     */ 
/*     */ public class PGetRoleGroupInfoReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final HashMap<Long, Long> groupid2InfoVersion;
/*     */   
/*     */   public PGetRoleGroupInfoReq(long roleid, HashMap<Long, Long> groupid2InfoVersion)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.groupid2InfoVersion = groupid2InfoVersion;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     for (Map.Entry<Long, Long> entry : this.groupid2InfoVersion.entrySet())
/*     */     {
/*  32 */       if ((((Long)entry.getKey()).longValue() < 0L) || (((Long)entry.getValue()).longValue() < -1L))
/*     */       {
/*  34 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  38 */     if (!GroupManager.isGroupSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  41 */       GroupManager.logger.info(String.format("[group]PGetRoleGroupInfoReq.processImp@group module close or role forbidden|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!GroupManager.checkRoleStatus(this.roleid, 259))
/*     */     {
/*     */ 
/*  49 */       GroupManager.logger.info(String.format("[group]PGetRoleGroupInfoReq.processImp@role status error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     SGetRoleGroupInfoSuccess protocol = new SGetRoleGroupInfoSuccess();
/*     */     
/*  55 */     xbean.GroupInfo xGroupInfo = xtable.Role2groupinfo.select(Long.valueOf(this.roleid));
/*  56 */     Iterator i$; if (xGroupInfo != null)
/*     */     {
/*  58 */       HashSet<Long> groupids = new HashSet();
/*  59 */       groupids.addAll(xGroupInfo.getCreate_same_zone_groupids().keySet());
/*  60 */       groupids.addAll(xGroupInfo.getJoin_same_zone_groupids().keySet());
/*  61 */       for (i$ = groupids.iterator(); i$.hasNext();) { long groupid = ((Long)i$.next()).longValue();
/*     */         
/*     */ 
/*  64 */         Group xGroup = Groups.select(Long.valueOf(groupid));
/*  65 */         if ((xGroup == null) || (!xGroup.getMemberlist().contains(Long.valueOf(this.roleid))))
/*     */         {
/*  67 */           if (this.groupid2InfoVersion.containsKey(Long.valueOf(groupid)))
/*     */           {
/*  69 */             mzm.gsp.group.GroupInfo groupInfo = new mzm.gsp.group.GroupInfo();
/*  70 */             groupInfo.groupid = groupid;
/*  71 */             groupInfo.info_version = -1L;
/*  72 */             protocol.groupid2group_basic_info.put(Long.valueOf(groupid), groupInfo);
/*  73 */             this.groupid2InfoVersion.remove(Long.valueOf(groupid));
/*     */           }
/*     */         }
/*     */         else {
/*  77 */           if ((!this.groupid2InfoVersion.containsKey(Long.valueOf(groupid))) || (((Long)this.groupid2InfoVersion.get(Long.valueOf(groupid))).longValue() != xGroup.getInfo_version()))
/*     */           {
/*  79 */             mzm.gsp.group.GroupInfo groupInfo = new mzm.gsp.group.GroupInfo();
/*  80 */             GroupManager.fillGroupInfo(groupInfo, xGroup, groupid, true);
/*  81 */             protocol.groupid2group_basic_info.put(Long.valueOf(groupid), groupInfo);
/*     */           }
/*  83 */           this.groupid2InfoVersion.remove(Long.valueOf(groupid));
/*     */           
/*  85 */           GroupAsynTaskManager.getInstance().addTask(new PUpdateMemberVersionInfo(this.roleid, groupid, xGroup.getInfo_version(), -1L));
/*     */         }
/*     */       }
/*     */     }
/*  89 */     for (Iterator i$ = this.groupid2InfoVersion.keySet().iterator(); i$.hasNext();) { long groupid = ((Long)i$.next()).longValue();
/*     */       
/*  91 */       mzm.gsp.group.GroupInfo groupInfo = new mzm.gsp.group.GroupInfo();
/*  92 */       groupInfo.groupid = groupid;
/*  93 */       groupInfo.info_version = -1L;
/*  94 */       protocol.groupid2group_basic_info.put(Long.valueOf(groupid), groupInfo);
/*     */     }
/*  96 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  98 */     GroupManager.logger.info(String.format("[group]PGetRoleGroupInfoReq.processImp@get role groupinfo success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */     
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PGetRoleGroupInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */