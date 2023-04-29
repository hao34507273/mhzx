/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SLearnCourseFailed;
/*     */ import mzm.gsp.children.SLearnCourseSuccess;
/*     */ import mzm.gsp.children.confbean.SChildHoodConst;
/*     */ import mzm.gsp.children.confbean.SCourseCfg;
/*     */ import mzm.gsp.children.main.ChildrenManager;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xbean.DailyCourseInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Children;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCLearnCourse
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final int courseType;
/*     */   
/*     */   public PCLearnCourse(long roleid, long childid, int courseType)
/*     */   {
/*  45 */     this.roleid = roleid;
/*  46 */     this.childid = childid;
/*  47 */     this.courseType = courseType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if ((this.childid <= 0L) || (this.courseType <= 0))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!ChildrenManager.isFunOpen(this.roleid))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!ChildhoodManager.canDoAction(this.roleid, 602))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  71 */       onFailed(8);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     String userid = RoleInterface.getUserId(this.roleid);
/*  76 */     if (userid == null)
/*     */     {
/*  78 */       onFailed(12);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     lock(Lockeys.get(User.getTable(), userid));
/*  84 */     if (!ChildhoodManager.checkHomeWorldid(this.roleid, true))
/*     */     {
/*  86 */       onFailed(9);
/*  87 */       return false;
/*     */     }
/*  89 */     long marriedRoleid = MarriageInterface.getMarriedRoleid(this.roleid, true);
/*  90 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childid));
/*  91 */     if (xChildInfo == null)
/*     */     {
/*  93 */       onFailed(10);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/*  98 */     if (!ChildhoodManager.checkChild(xChildInfo, this.roleid, marriedRoleid))
/*     */     {
/* 100 */       Map<String, Object> extras = new HashMap();
/* 101 */       extras.put("married_roleid", Long.valueOf(marriedRoleid));
/* 102 */       extras.put("owner_roleid", Long.valueOf(ownerRoleid));
/* 103 */       extras.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/* 104 */       onFailed(11, extras);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/* 110 */       GameServer.logger().error(String.format("[childhood]PCLearnCourse.processImp@child not in home|roleid=%d|childid=%d|userid=%s|home_state=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid, Integer.valueOf(xChildInfo.getHome_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     int phase = xChildInfo.getChild_period();
/* 118 */     if (phase != 1)
/*     */     {
/* 120 */       Map<String, Object> extras = new HashMap();
/* 121 */       extras.put("status", Integer.valueOf(phase));
/* 122 */       onFailed(2, extras);
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 128 */     if (xChildhoodInfo.getInterest() == 0)
/*     */     {
/* 130 */       onFailed(3);
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 135 */     xbean.CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/* 136 */     if (xCourseStudyInfo.getCourse_type() != 0)
/*     */     {
/* 138 */       Map<String, Object> extras = new HashMap();
/* 139 */       extras.put("course_type", Integer.valueOf(xCourseStudyInfo.getCourse_type()));
/* 140 */       extras.put("start_time", Long.valueOf(xCourseStudyInfo.getTime()));
/* 141 */       onFailed(4, extras);
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 146 */     DailyCourseInfo xDailyCourseInfo = xChildhoodInfo.getDaily_curse();
/* 147 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 148 */     if (!ChildhoodManager.checkCourse(xDailyCourseInfo, now))
/*     */     {
/* 150 */       Map<String, Object> extras = new HashMap();
/* 151 */       extras.put("cur_num", Integer.valueOf(xDailyCourseInfo.getNum()));
/* 152 */       onFailed(-1, extras);
/* 153 */       return false;
/*     */     }
/* 155 */     if (xChildhoodInfo.getTotal_num() >= SChildHoodConst.getInstance().TOTAL_NUM)
/*     */     {
/* 157 */       Map<String, Object> extras = new HashMap();
/* 158 */       extras.put("total_num", Integer.valueOf(xChildhoodInfo.getTotal_num()));
/* 159 */       onFailed(-1, extras);
/* 160 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 164 */     SCourseCfg courseCfg = SCourseCfg.get(this.courseType);
/* 165 */     if (courseCfg == null)
/*     */     {
/* 167 */       onFailed(5);
/* 168 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 172 */     if (!ChildhoodManager.checkCanLearnCourse(this.courseType, xChildhoodInfo))
/*     */     {
/* 174 */       Map<String, Object> extras = new HashMap();
/* 175 */       extras.put("course_info", xChildhoodInfo.getCourses().toString());
/* 176 */       onFailed(-4, extras);
/* 177 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 181 */     TLogArg tLogArg = new TLogArg(LogReason.CHILDHOOD_LEARN_COURSE);
/* 182 */     int vigor = courseCfg.vigor;
/* 183 */     if (!RoleInterface.cutVigor(this.roleid, vigor, tLogArg))
/*     */     {
/* 185 */       Map<String, Object> extras = new HashMap();
/* 186 */       extras.put("vigor", Integer.valueOf(vigor));
/* 187 */       onFailed(-2, extras);
/* 188 */       return false;
/*     */     }
/*     */     
/* 191 */     int moneyType = courseCfg.moneyType;
/* 192 */     int cost = courseCfg.cost;
/* 193 */     if (!ChildhoodManager.cutCurrency(userid, this.roleid, moneyType, cost, tLogArg))
/*     */     {
/* 195 */       Map<String, Object> extras = new HashMap();
/* 196 */       extras.put("money_type", Integer.valueOf(moneyType));
/* 197 */       extras.put("cost", Integer.valueOf(cost));
/* 198 */       onFailed(-3, extras);
/* 199 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 203 */     xCourseStudyInfo.setTime(now);
/* 204 */     xCourseStudyInfo.setCourse_type(this.courseType);
/*     */     
/*     */ 
/* 207 */     ChildhoodManager.startCourseObserver(ownerRoleid, this.childid, TimeUnit.MINUTES.toSeconds(courseCfg.studyTime));
/*     */     
/*     */ 
/* 210 */     addTlog(userid, ownerRoleid, marriedRoleid, phase, vigor, moneyType, cost);
/*     */     
/*     */ 
/* 213 */     SLearnCourseSuccess resp = new SLearnCourseSuccess();
/* 214 */     resp.childid = this.childid;
/* 215 */     resp.course_info = new mzm.gsp.children.CourseStudyInfo(this.courseType, (int)TimeUnit.MILLISECONDS.toSeconds(now));
/* 216 */     ChildhoodManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */     
/* 218 */     GameServer.logger().info(String.format("[childhood]PCLearnCourse.processImp@learn course success|roleid=%d|childid=%d|course_type=%d|vigor=%d|money_type=%d|cost=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(this.courseType), Integer.valueOf(vigor), Integer.valueOf(moneyType), Integer.valueOf(cost) }));
/*     */     
/*     */ 
/*     */ 
/* 222 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 227 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 232 */     if (retcode < 0)
/*     */     {
/* 234 */       SLearnCourseFailed resp = new SLearnCourseFailed();
/* 235 */       resp.retcode = retcode;
/* 236 */       resp.childid = this.childid;
/* 237 */       resp.course_type = this.courseType;
/* 238 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 241 */     StringBuffer logBuilder = new StringBuffer();
/* 242 */     logBuilder.append("[childhood]PCLearnCourse.onFailed@learn course failed");
/* 243 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 244 */     logBuilder.append('|').append("childid=").append(this.childid);
/* 245 */     logBuilder.append('|').append("course_cfgid=").append(this.courseType);
/* 246 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 248 */     if (extraParams != null)
/*     */     {
/* 250 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 252 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 256 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long ownerRoleid, long marriedRoleid, int phase, int vigor, int moneyType, int cost)
/*     */   {
/* 262 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 263 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 265 */     TLogManager.getInstance().addLog(userid, "ChildLearnCourseForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), Integer.valueOf(phase), Integer.valueOf(this.courseType), Integer.valueOf(vigor), Integer.valueOf(moneyType), Integer.valueOf(cost) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\PCLearnCourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */