/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.StudyEffectInfo;
/*     */ import mzm.gsp.children.SyncCourseInfo;
/*     */ import mzm.gsp.children.confbean.SCourseCfg;
/*     */ import mzm.gsp.children.main.ChildrenManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xbean.CourseStudyInfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class CourseObserver extends Observer
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   
/*     */   public CourseObserver(long roleid, long childid, long intervalSeconds)
/*     */   {
/*  24 */     super(intervalSeconds);
/*     */     
/*  26 */     this.roleid = roleid;
/*  27 */     this.childid = childid;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  33 */     if (!ChildrenManager.isFunOpen(this.roleid))
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     if (!ChildhoodManager.isFunOpen(this.roleid))
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     new PCourseEnd(this.roleid, this.childid).execute();
/*  42 */     return false;
/*     */   }
/*     */   
/*     */   private static class PCourseEnd extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final long childid;
/*     */     
/*     */     public PCourseEnd(long roleid, long childid)
/*     */     {
/*  52 */       this.roleid = roleid;
/*  53 */       this.childid = childid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  59 */       if (!ChildrenManager.isFunOpen(this.roleid))
/*     */       {
/*  61 */         return false;
/*     */       }
/*  63 */       if (!ChildhoodManager.isFunOpen(this.roleid))
/*     */       {
/*  65 */         return false;
/*     */       }
/*     */       
/*  68 */       String userid = RoleInterface.getUserId(this.roleid);
/*  69 */       if (userid == null)
/*     */       {
/*  71 */         GameServer.logger().error(String.format("[childhood]PCourseEnd.processImp@userid is null|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */         
/*     */ 
/*  74 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  78 */       lock(xdb.Lockeys.get(User.getTable(), userid));
/*  79 */       long marriedRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.roleid, true);
/*  80 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childid));
/*  81 */       if (xChildInfo == null)
/*     */       {
/*  83 */         GameServer.logger().error(String.format("[childhood]PCourseEnd.processImp@child not exist|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */         
/*     */ 
/*  86 */         return false;
/*     */       }
/*     */       
/*  89 */       ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/*     */       
/*  91 */       CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/*  92 */       int courseType = xCourseStudyInfo.getCourse_type();
/*  93 */       if (courseType == 0)
/*     */       {
/*  95 */         GameServer.logger().error(String.format("[childhood]PCourseEnd.processImp@not study course|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */         
/*     */ 
/*  98 */         return false;
/*     */       }
/*     */       
/* 101 */       SCourseCfg courseCfg = SCourseCfg.get(courseType);
/* 102 */       if (courseCfg == null)
/*     */       {
/* 104 */         GameServer.logger().error(String.format("[childhood]PCourseEnd.processImp@course_cfg is null|roleid=%d|childid=%d|course_type=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(courseType) }));
/*     */         
/*     */ 
/*     */ 
/* 108 */         return false;
/*     */       }
/*     */       
/* 111 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */       
/* 113 */       boolean isCrit = ChildhoodManager.isCrit(xChildhoodInfo.getTotal_crit_num(), xChildhoodInfo.getTotal_num());
/* 114 */       ChildhoodManager.onCourseEnd(xChildInfo, courseType, isCrit, now);
/*     */       
/* 116 */       ChildhoodManager.asyncSendCourseMail(this.childid, xChildInfo, courseType, courseCfg.name);
/*     */       
/*     */ 
/* 119 */       ChildhoodManager.courseRecord(this.childid, courseType, isCrit, now);
/*     */       
/*     */ 
/* 122 */       ChildhoodManager.cancelCourseObserver(this.childid);
/*     */       
/*     */ 
/* 125 */       addTlog(userid, xChildInfo.getOwn_role_id(), marriedRoleid, xChildInfo.getChild_period(), courseType, isCrit);
/*     */       
/*     */ 
/* 128 */       SyncCourseInfo resp = new SyncCourseInfo();
/* 129 */       resp.childid = this.childid;
/* 130 */       resp.study_effect_info = new StudyEffectInfo(courseType, (byte)(isCrit ? 1 : 0));
/* 131 */       ChildhoodManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */       
/* 133 */       GameServer.logger().info(String.format("[childhood]PCourseEnd.processImp@finish course success|roleid=%d|childid=%d|course_cfgid=%d|married_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(courseType), Long.valueOf(marriedRoleid) }));
/*     */       
/*     */ 
/*     */ 
/* 137 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     private void addTlog(String userid, long ownerRoleid, long marriedRoleid, int phase, int courseType, boolean isCrit)
/*     */     {
/* 143 */       String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 144 */       int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */       
/* 146 */       TLogManager.getInstance().addLog(userid, "ChildCourseForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), Integer.valueOf(phase), Integer.valueOf(courseType), Integer.valueOf(isCrit ? 1 : 0) });
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\CourseObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */