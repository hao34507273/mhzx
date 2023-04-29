/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SEndCourseFailed;
/*     */ import mzm.gsp.children.SEndCourseSuccess;
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
/*     */ import xtable.Children;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCEndCourse
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final long clientYuanbao;
/*     */   
/*     */   public PCEndCourse(long roleid, long childid, long clientYunbao)
/*     */   {
/*  47 */     this.roleid = roleid;
/*  48 */     this.childid = childid;
/*  49 */     this.clientYuanbao = clientYunbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  55 */     if ((this.childid <= 0L) || (this.clientYuanbao <= 0L))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!ChildrenManager.isFunOpen(this.roleid))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (!ChildhoodManager.isFunOpen(this.roleid))
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     if (!ChildhoodManager.canDoAction(this.roleid, 604))
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  78 */       onFailed(8);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     String userid = RoleInterface.getUserId(this.roleid);
/*  83 */     if (userid == null)
/*     */     {
/*  85 */       onFailed(12);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     long yuanbao = QingfuInterface.getBalance(userid, true);
/*  91 */     if (yuanbao < 0L)
/*     */     {
/*  93 */       Map<String, Object> extras = new HashMap();
/*  94 */       extras.put("userid", userid);
/*  95 */       extras.put("yuanbao", Long.valueOf(yuanbao));
/*  96 */       onFailed(1, extras);
/*  97 */       return false;
/*     */     }
/*  99 */     if (this.clientYuanbao != yuanbao)
/*     */     {
/* 101 */       Map<String, Object> extras = new HashMap();
/* 102 */       extras.put("yuanbao", Long.valueOf(yuanbao));
/* 103 */       onFailed(7, extras);
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     if (!ChildhoodManager.checkHomeWorldid(this.roleid, true))
/*     */     {
/* 110 */       onFailed(9);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     long marriedRoleid = MarriageInterface.getMarriedRoleid(this.roleid, true);
/*     */     
/* 116 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childid));
/* 117 */     if (xChildInfo == null)
/*     */     {
/* 119 */       onFailed(10);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/* 124 */     if (!ChildhoodManager.checkChild(xChildInfo, this.roleid, marriedRoleid))
/*     */     {
/* 126 */       Map<String, Object> extras = new HashMap();
/* 127 */       extras.put("married_roleid", Long.valueOf(marriedRoleid));
/* 128 */       extras.put("owner_roleid", Long.valueOf(ownerRoleid));
/* 129 */       extras.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/* 130 */       onFailed(11, extras);
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/* 136 */       GameServer.logger().error(String.format("[childhood]PCEndCourse.processImp@child not in home|roleid=%d|childid=%d|userid=%s|home_state=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid, Integer.valueOf(xChildInfo.getHome_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     int phase = xChildInfo.getChild_period();
/* 144 */     if (phase != 1)
/*     */     {
/* 146 */       Map<String, Object> extras = new HashMap();
/* 147 */       extras.put("status", Integer.valueOf(phase));
/* 148 */       onFailed(2, extras);
/* 149 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 153 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 154 */     if (xChildhoodInfo.getInterest() == 0)
/*     */     {
/* 156 */       onFailed(3);
/* 157 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 161 */     CourseStudyInfo xCourseStudyInfo = xChildhoodInfo.getCur_course();
/* 162 */     int courseType = xCourseStudyInfo.getCourse_type();
/* 163 */     if (courseType == 0)
/*     */     {
/* 165 */       onFailed(13);
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     long startTime = xCourseStudyInfo.getTime();
/* 170 */     SCourseCfg courseCfg = SCourseCfg.get(courseType);
/* 171 */     int studyTime = courseCfg.studyTime;
/*     */     
/* 173 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 174 */     int needYuanbao = 0;
/* 175 */     long surplus = TimeUnit.MILLISECONDS.toSeconds(startTime + TimeUnit.MINUTES.toMillis(studyTime) - now);
/* 176 */     if (surplus <= 0L)
/*     */     {
/* 178 */       needYuanbao = SChildHoodConst.getInstance().YUAN_BAO_PER_MINUTE;
/*     */     }
/*     */     else
/*     */     {
/* 182 */       needYuanbao = (int)Math.ceil(surplus / 60.0D) * SChildHoodConst.getInstance().YUAN_BAO_PER_MINUTE;
/*     */     }
/*     */     
/* 185 */     TLogArg tLogArg = new TLogArg(LogReason.CHILDHOOD_END_COURSE);
/* 186 */     CostResult costResult = QingfuInterface.costYuanbao(userid, this.roleid, needYuanbao, CostType.COST_BIND_FIRST_CHILDHOOD_END_COURSE, tLogArg);
/*     */     
/* 188 */     if (costResult != CostResult.Success)
/*     */     {
/* 190 */       Map<String, Object> extras = new HashMap();
/* 191 */       extras.put("need_yuanbao", Integer.valueOf(needYuanbao));
/* 192 */       extras.put("yuanbao", Long.valueOf(yuanbao));
/* 193 */       onFailed(-1, extras);
/* 194 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 198 */     boolean isCrit = ChildhoodManager.isCrit(xChildhoodInfo.getTotal_crit_num(), xChildhoodInfo.getTotal_num());
/* 199 */     ChildhoodManager.onCourseEnd(xChildInfo, courseType, isCrit, now);
/*     */     
/* 201 */     ChildhoodManager.asyncSendCourseMail(this.childid, xChildInfo, courseType, courseCfg.name);
/*     */     
/*     */ 
/* 204 */     ChildhoodManager.cancelCourseObserver(this.childid);
/*     */     
/*     */ 
/* 207 */     ChildhoodManager.courseRecord(this.childid, courseType, isCrit, now);
/*     */     
/*     */ 
/* 210 */     addTlog(userid, ownerRoleid, marriedRoleid, phase, courseType, surplus, needYuanbao, isCrit);
/*     */     
/* 212 */     SEndCourseSuccess resp = new SEndCourseSuccess();
/* 213 */     resp.childid = this.childid;
/* 214 */     resp.study_effect_info = new StudyEffectInfo(courseType, (byte)(isCrit ? 1 : 0));
/* 215 */     ChildhoodManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */     
/* 217 */     GameServer.logger().info(String.format("[childhood]PCEndCourse.processImp@finish course success|roleid=%d|childid=%d|course_type=%d|need_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(courseType), Integer.valueOf(needYuanbao) }));
/*     */     
/*     */ 
/*     */ 
/* 221 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 226 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 231 */     if (retcode < 0)
/*     */     {
/* 233 */       SEndCourseFailed resp = new SEndCourseFailed();
/* 234 */       resp.retcode = retcode;
/* 235 */       resp.childid = this.childid;
/* 236 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 239 */     StringBuffer logBuilder = new StringBuffer();
/* 240 */     logBuilder.append("[childhood]PCEndCourse.onFailed@end course failed");
/* 241 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 242 */     logBuilder.append('|').append("childid=").append(this.childid);
/* 243 */     logBuilder.append('|').append("client_yuanbao=").append(this.clientYuanbao);
/* 244 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 246 */     if (extraParams != null)
/*     */     {
/* 248 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 250 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 254 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long ownerRoleid, long marriedRoleid, int phase, int courseType, long surplus, int yuanbao, boolean isCrit)
/*     */   {
/* 260 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 261 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 263 */     TLogManager.getInstance().addLog(userid, "ChildEndCourseForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), Integer.valueOf(phase), Integer.valueOf(courseType), Long.valueOf(surplus), Integer.valueOf(yuanbao), Integer.valueOf(isCrit ? 1 : 0) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\PCEndCourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */