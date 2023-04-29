/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.group.SCreateGroupFail;
/*     */ import mzm.gsp.group.confbean.GroupConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCreateGroupReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int groupType;
/*     */   private final String groupName;
/*     */   
/*     */   public PCreateGroupReq(long roleid, int groupType, Octets groupName)
/*     */   {
/*  22 */     this.roleid = roleid;
/*  23 */     this.groupType = groupType;
/*  24 */     this.groupName = groupName.getString("UTF-8").trim();
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!GroupManager.checkGroupType(this.groupType))
/*     */     {
/*     */ 
/*  33 */       sendCreateGroupFail(4);
/*  34 */       GroupManager.logger.info(String.format("[group]PCreateGroupReq.processImp@create group fail|roleid=%d|groupType=%d|groupName=%s|error=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.groupType), this.groupName, Integer.valueOf(4) }));
/*     */       
/*     */ 
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!GroupManager.checkGroupName(this.groupName))
/*     */     {
/*     */ 
/*  43 */       sendCreateGroupFail(3);
/*  44 */       GroupManager.logger.info(String.format("[group]PCreateGroupReq.processImp@create group fail|roleid=%d|groupType=%d|groupName=%s|error=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.groupType), this.groupName, Integer.valueOf(3) }));
/*     */       
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!GroupManager.isGroupSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  53 */       GroupManager.logger.info(String.format("[group]PCreateGroupReq.processImp@group module close or role forbidden|roleid=%d|groupType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.groupType) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!GroupManager.checkRoleStatus(this.roleid, 251))
/*     */     {
/*     */ 
/*  62 */       GroupManager.logger.info(String.format("[group]PCreateGroupReq.processImp@role status error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*  67 */     if (roleLevel < GroupConsts.getInstance().CREATE_GROUP_LEVEL)
/*     */     {
/*     */ 
/*  70 */       sendCreateGroupFail(1);
/*  71 */       GroupManager.logger.info(String.format("[group]PCreateGroupReq.processImp@create group fail|roleid=%d|groupType=%d|error=%d|roleLevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.groupType), Integer.valueOf(1), Integer.valueOf(roleLevel) }));
/*     */       
/*     */ 
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     int createGroupNumLimit = GroupManager.getCreateGroupNumLimit(roleLevel);
/*  78 */     if (createGroupNumLimit < 0)
/*     */     {
/*     */ 
/*  81 */       GroupManager.logger.error(String.format("[group]PCreateGroupReq.processImp@get create group num limit error|roleid=%d|groupType=%d|roleLevel=%d|error=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.groupType), Integer.valueOf(roleLevel), Integer.valueOf(createGroupNumLimit) }));
/*     */       
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     int res = GroupManager.createGroup(this.roleid, this.groupType, this.groupName, createGroupNumLimit, 1);
/*     */     
/*  89 */     if (res != 0)
/*     */     {
/*  91 */       sendCreateGroupFail(res);
/*  92 */       GroupManager.logger.info(String.format("[group]PQuitGroupReq.processImp@create group fail|roleid=%d|groupType=%d|groupName=%s|error=%d|roleLevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.groupType), this.groupName, Integer.valueOf(res), Integer.valueOf(roleLevel) }));
/*     */       
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     GroupManager.logger.info(String.format("[group]PCreateGroupReq.processImp@create group success|roleid=%d|groupType=%d|groupName=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.groupType), this.groupName }));
/*     */     
/*     */ 
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   private void sendCreateGroupFail(int res)
/*     */   {
/* 106 */     SCreateGroupFail protocol = new SCreateGroupFail();
/* 107 */     protocol.res = res;
/* 108 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PCreateGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */