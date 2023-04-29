/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SCancelCourseSuccess;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xbean.CourseStudyInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCancelCourse extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   
/*     */   public PCCancelCourse(long roleid, long childid)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.childid = childid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (this.childid <= 0L)
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     if (!mzm.gsp.children.main.ChildrenManager.isFunOpen(this.roleid))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!ChildhoodManager.isFunOpen(this.roleid))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!ChildhoodManager.canDoAction(this.roleid, 605))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@home not exist|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     String userid = RoleInterface.getUserId(this.roleid);
/*  60 */     if (userid == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@userid is null|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */       
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     lock(Lockeys.get(User.getTable(), userid));
/*  70 */     if (!ChildhoodManager.checkHomeWorldid(this.roleid, true))
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@world not exist|roleid=%d|childid=%d|userid=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid }));
/*     */       
/*     */ 
/*  75 */       return false;
/*     */     }
/*  77 */     long marriedRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.roleid, true);
/*  78 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childid));
/*  79 */     if (xChildInfo == null)
/*     */     {
/*  81 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@child not exist|roleid=%d|childid=%d|userid=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid }));
/*     */       
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/*  88 */     if (!ChildhoodManager.checkChild(xChildInfo, this.roleid, marriedRoleid))
/*     */     {
/*  90 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@child check failed|roleid=%d|childid=%d|userid=%s|married_roleid=%d|owner_roleid=%d|another_parent_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid, Long.valueOf(marriedRoleid), Long.valueOf(ownerRoleid), Long.valueOf(xChildInfo.getAnother_parent_role_id()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/* 100 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@child not in home|roleid=%d|childid=%d|userid=%s|home_state=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid, Integer.valueOf(xChildInfo.getHome_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     int phase = xChildInfo.getChild_period();
/* 108 */     if (phase != 1)
/*     */     {
/* 110 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@child status|roleid=%d|childid=%d|status=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(phase) }));
/*     */       
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 117 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 118 */     if (xChildhoodInfo.getInterest() == 0)
/*     */     {
/* 120 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@child not choose interest|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */       
/*     */ 
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/* 128 */     int courseType = xCourseStudyInfo.getCourse_type();
/* 129 */     if (courseType == 0)
/*     */     {
/* 131 */       GameServer.logger().error(String.format("[childhood]PCCancelCourse.processImp@study course not exist|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */       
/*     */ 
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     xCourseStudyInfo.setCourse_type(0);
/*     */     
/*     */ 
/* 141 */     ChildhoodManager.cancelCourseObserver(this.childid);
/*     */     
/*     */ 
/* 144 */     addTlog(userid, ownerRoleid, marriedRoleid, phase, courseType);
/*     */     
/* 146 */     SCancelCourseSuccess resp = new SCancelCourseSuccess();
/* 147 */     resp.childid = this.childid;
/* 148 */     ChildhoodManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */     
/* 150 */     GameServer.logger().info(String.format("[childhood]PCCancelCourse.processImp@cancel course success|roleid=%d|childid=%d|course_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(courseType) }));
/*     */     
/*     */ 
/*     */ 
/* 154 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long ownerRoleid, long marriedRoleid, int phase, int courseType)
/*     */   {
/* 160 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 161 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 163 */     TLogManager.getInstance().addLog(userid, "ChildCancelCourseForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), Integer.valueOf(phase), Integer.valueOf(courseType) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\PCCancelCourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */