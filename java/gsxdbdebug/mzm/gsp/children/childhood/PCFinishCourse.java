/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SFinishCourseFailed;
/*     */ import mzm.gsp.children.SFinishCourseSuccess;
/*     */ import mzm.gsp.children.StudyEffectInfo;
/*     */ import mzm.gsp.children.confbean.SChildHoodConst;
/*     */ import mzm.gsp.children.confbean.SCourseCfg;
/*     */ import mzm.gsp.children.main.ChildrenManager;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xbean.CourseStudyInfo;
/*     */ import xbean.DailyCourseInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCFinishCourse
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final int courseType;
/*     */   private final long clientYuanbao;
/*     */   
/*     */   public PCFinishCourse(long roleid, long childid, int courseType, long clientYuanbao)
/*     */   {
/*  47 */     this.roleid = roleid;
/*  48 */     this.childid = childid;
/*  49 */     this.courseType = courseType;
/*  50 */     this.clientYuanbao = clientYuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  56 */     if ((this.childid <= 0L) || (this.courseType <= 0) || (this.clientYuanbao <= 0L))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (!ChildrenManager.isFunOpen(this.roleid))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!ChildhoodManager.isFunOpen(this.roleid))
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!ChildhoodManager.canDoAction(this.roleid, 603))
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  79 */       onFailed(8);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     String userid = RoleInterface.getUserId(this.roleid);
/*  84 */     if (userid == null)
/*     */     {
/*  86 */       onFailed(12);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     long yuanbao = QingfuInterface.getBalance(userid, true);
/*  92 */     if (yuanbao < 0L)
/*     */     {
/*  94 */       Map<String, Object> extras = new HashMap();
/*  95 */       extras.put("userid", userid);
/*  96 */       extras.put("yuanbao", Long.valueOf(yuanbao));
/*  97 */       onFailed(1, extras);
/*  98 */       return false;
/*     */     }
/* 100 */     if (this.clientYuanbao != yuanbao)
/*     */     {
/* 102 */       Map<String, Object> extras = new HashMap();
/* 103 */       extras.put("yuanbao", Long.valueOf(yuanbao));
/* 104 */       onFailed(7, extras);
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 109 */     if (!ChildhoodManager.checkHomeWorldid(this.roleid, true))
/*     */     {
/* 111 */       onFailed(9);
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     long marriedRoleid = MarriageInterface.getMarriedRoleid(this.roleid, true);
/*     */     
/* 117 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childid));
/* 118 */     if (xChildInfo == null)
/*     */     {
/* 120 */       onFailed(10);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/* 125 */     if (!ChildhoodManager.checkChild(xChildInfo, this.roleid, marriedRoleid))
/*     */     {
/* 127 */       Map<String, Object> extras = new HashMap();
/* 128 */       extras.put("married_roleid", Long.valueOf(marriedRoleid));
/* 129 */       extras.put("owner_roleid", Long.valueOf(ownerRoleid));
/* 130 */       extras.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/* 131 */       onFailed(11, extras);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/* 137 */       GameServer.logger().error(String.format("[childhood]PCFinishCourse.processImp@child not in home|roleid=%d|childid=%d|userid=%s|home_state=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid, Integer.valueOf(xChildInfo.getHome_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     int phase = xChildInfo.getChild_period();
/* 145 */     if (phase != 1)
/*     */     {
/* 147 */       Map<String, Object> extras = new HashMap();
/* 148 */       extras.put("status", Integer.valueOf(phase));
/* 149 */       onFailed(2, extras);
/* 150 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 154 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 155 */     if (xChildhoodInfo.getInterest() == 0)
/*     */     {
/* 157 */       onFailed(3);
/* 158 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 162 */     CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/* 163 */     if (xCourseStudyInfo.getCourse_type() != 0)
/*     */     {
/* 165 */       Map<String, Object> extras = new HashMap();
/* 166 */       extras.put("course_type", Integer.valueOf(xCourseStudyInfo.getCourse_type()));
/* 167 */       extras.put("start_time", Long.valueOf(xCourseStudyInfo.getTime()));
/* 168 */       onFailed(4, extras);
/* 169 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 173 */     DailyCourseInfo xDailyCourseInfo = xChildhoodInfo.getDaily_curse();
/* 174 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 175 */     if (!ChildhoodManager.checkCourse(xDailyCourseInfo, now))
/*     */     {
/* 177 */       Map<String, Object> extras = new HashMap();
/* 178 */       extras.put("cur_num", Integer.valueOf(xDailyCourseInfo.getNum()));
/* 179 */       onFailed(-1, extras);
/* 180 */       return false;
/*     */     }
/* 182 */     if (xChildhoodInfo.getTotal_num() >= SChildHoodConst.getInstance().TOTAL_NUM)
/*     */     {
/* 184 */       Map<String, Object> extras = new HashMap();
/* 185 */       extras.put("total_num", Integer.valueOf(xChildhoodInfo.getTotal_num()));
/* 186 */       onFailed(-1, extras);
/* 187 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 191 */     SCourseCfg courseCfg = SCourseCfg.get(this.courseType);
/* 192 */     if (courseCfg == null)
/*     */     {
/* 194 */       onFailed(5);
/* 195 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 199 */     if (!ChildhoodManager.checkCanLearnCourse(this.courseType, xChildhoodInfo))
/*     */     {
/* 201 */       Map<String, Object> extras = new HashMap();
/* 202 */       extras.put("course_info", xChildhoodInfo.getCourses().toString());
/* 203 */       onFailed(-5, extras);
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     int needYuanbao = courseCfg.studyTime * SChildHoodConst.getInstance().YUAN_BAO_PER_MINUTE;
/* 208 */     if (needYuanbao <= 0)
/*     */     {
/* 210 */       Map<String, Object> extras = new HashMap();
/* 211 */       extras.put("study_time", Integer.valueOf(courseCfg.studyTime));
/* 212 */       extras.put("unit", Integer.valueOf(SChildHoodConst.getInstance().YUAN_BAO_PER_MINUTE));
/* 213 */       onFailed(6, extras);
/* 214 */       return false;
/*     */     }
/*     */     
/* 217 */     TLogArg tLogArg = new TLogArg(LogReason.CHILDHOOD_FINISH_COURSE);
/* 218 */     CostResult costResult = QingfuInterface.costYuanbao(userid, this.roleid, needYuanbao, CostType.COST_BIND_FIRST_CHILDHOOD_FINISH_COURSE, tLogArg);
/*     */     
/* 220 */     if (costResult != CostResult.Success)
/*     */     {
/* 222 */       Map<String, Object> extras = new HashMap();
/* 223 */       extras.put("need_yuanbao", Integer.valueOf(needYuanbao));
/* 224 */       extras.put("yuanbao", Long.valueOf(yuanbao));
/* 225 */       onFailed(-4, extras);
/* 226 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 230 */     int vigor = courseCfg.vigor;
/* 231 */     if (!RoleInterface.cutVigor(this.roleid, vigor, tLogArg))
/*     */     {
/* 233 */       Map<String, Object> extras = new HashMap();
/* 234 */       extras.put("vigor", Integer.valueOf(vigor));
/* 235 */       onFailed(-2, extras);
/* 236 */       return false;
/*     */     }
/*     */     
/* 239 */     int moneyType = courseCfg.moneyType;
/* 240 */     int cost = courseCfg.cost;
/* 241 */     if (!ChildhoodManager.cutCurrency(userid, this.roleid, moneyType, cost, tLogArg))
/*     */     {
/* 243 */       Map<String, Object> extras = new HashMap();
/* 244 */       extras.put("money_type", Integer.valueOf(moneyType));
/* 245 */       extras.put("cost", Integer.valueOf(cost));
/* 246 */       onFailed(-3, extras);
/* 247 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 251 */     boolean isCrit = ChildhoodManager.isCrit(xChildhoodInfo.getTotal_crit_num(), xChildhoodInfo.getTotal_num());
/* 252 */     ChildhoodManager.onCourseEnd(xChildInfo, this.courseType, isCrit, now);
/*     */     
/* 254 */     ChildhoodManager.asyncSendCourseMail(this.childid, xChildInfo, this.courseType, courseCfg.name);
/*     */     
/*     */ 
/* 257 */     ChildhoodManager.courseRecord(this.childid, this.courseType, isCrit, now);
/*     */     
/*     */ 
/* 260 */     addTlog(userid, ownerRoleid, marriedRoleid, phase, this.courseType, needYuanbao, vigor, moneyType, cost, isCrit);
/*     */     
/*     */ 
/* 263 */     SFinishCourseSuccess resp = new SFinishCourseSuccess();
/* 264 */     resp.childid = this.childid;
/* 265 */     resp.study_effect_info = new StudyEffectInfo(this.courseType, (byte)(isCrit ? 1 : 0));
/* 266 */     ChildhoodManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */     
/* 268 */     GameServer.logger().info(String.format("[childhood]PCFinishCourse.processImp@finish course success|roleid=%d|childid=%d|course_type=%d|need_yuanbao=%d|vigor=%d|money_type=%d|cost=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(this.courseType), Integer.valueOf(needYuanbao), Integer.valueOf(vigor), Integer.valueOf(moneyType), Integer.valueOf(cost) }));
/*     */     
/*     */ 
/*     */ 
/* 272 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 277 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 282 */     if (retcode < 0)
/*     */     {
/* 284 */       SFinishCourseFailed resp = new SFinishCourseFailed();
/* 285 */       resp.retcode = retcode;
/* 286 */       resp.childid = this.childid;
/* 287 */       resp.course_type = this.courseType;
/* 288 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 291 */     StringBuffer logBuilder = new StringBuffer();
/* 292 */     logBuilder.append("[childhood]PCFinishCourse.onFailed@finish course failed");
/* 293 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 294 */     logBuilder.append('|').append("childid=").append(this.childid);
/* 295 */     logBuilder.append('|').append("course_cfgid=").append(this.courseType);
/* 296 */     logBuilder.append('|').append("client_yuanbao=").append(this.clientYuanbao);
/* 297 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 299 */     if (extraParams != null)
/*     */     {
/* 301 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 303 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 307 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long ownerRoleid, long marriedRoleid, int phase, int courseType, int yuanbao, int vigor, int moneyType, int cost, boolean isCrit)
/*     */   {
/* 313 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 314 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 316 */     TLogManager.getInstance().addLog(userid, "ChildFinishCourseForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), Integer.valueOf(phase), Integer.valueOf(courseType), Integer.valueOf(yuanbao), Integer.valueOf(vigor), Integer.valueOf(moneyType), Integer.valueOf(cost), Integer.valueOf(isCrit ? 1 : 0) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\PCFinishCourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */