/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.children.ChildBean;
/*     */ import mzm.gsp.children.SAddChild;
/*     */ import mzm.gsp.children.confbean.SChildHoodConst;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xbean.CourseInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PGM_FullCourse extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long gmRoleid;
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final boolean r;
/*     */   private static final int COURSE_NUM = 10;
/*     */   private static final int INTEREST = 832100045;
/*  29 */   private final Random random = Xdb.random();
/*     */   
/*     */   public PGM_FullCourse(long gmRoleid, long roleid, long childid)
/*     */   {
/*  33 */     this(gmRoleid, roleid, childid, true);
/*     */   }
/*     */   
/*     */   public PGM_FullCourse(long gmRoleid, long roleid, long childid, boolean random)
/*     */   {
/*  38 */     this.gmRoleid = gmRoleid;
/*  39 */     this.roleid = roleid;
/*  40 */     this.childid = childid;
/*  41 */     this.r = random;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     long marriedRoleid = MarriageInterface.getMarriedRoleid(this.roleid, false);
/*  49 */     if (marriedRoleid > 0L)
/*     */     {
/*  51 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(marriedRoleid) }));
/*     */     }
/*     */     else
/*     */     {
/*  55 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     }
/*     */     
/*  58 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childid));
/*  59 */     if (xChildInfo == null)
/*     */     {
/*  61 */       notifyClient("子女不存在");
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if ((xChildInfo.getOwn_role_id() != this.roleid) && (xChildInfo.getAnother_parent_role_id() != this.roleid))
/*     */     {
/*  67 */       notifyClient("不是自己的子女");
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (xChildInfo.getChild_period() != 1)
/*     */     {
/*  73 */       notifyClient("子女不是童年期阶段");
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/*  78 */     if (xChildhoodInfo.getTotal_num() >= SChildHoodConst.getInstance().TOTAL_NUM)
/*     */     {
/*  80 */       notifyClient("课程已经学满");
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  85 */     int surplus = SChildHoodConst.getInstance().TOTAL_NUM - xChildhoodInfo.getTotal_num();
/*  86 */     if (this.r)
/*     */     {
/*  88 */       for (int i = 0; i < surplus; i++)
/*     */       {
/*  90 */         boolean isCrit = ChildhoodManager.isCrit(xChildhoodInfo.getTotal_crit_num(), xChildhoodInfo.getTotal_num());
/*     */         
/*  92 */         ChildhoodManager.onCourseEnd(xChildInfo, randomCourseType(), isCrit, now);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  97 */       int courseType = 6;
/*  98 */       xChildhoodInfo.setTotal_num(10);
/*  99 */       xChildhoodInfo.setTotal_crit_num(1);
/* 100 */       xChildhoodInfo.setInterest(832100045);
/*     */       
/* 102 */       Map<Integer, CourseInfo> xCourseInfos = xChildhoodInfo.getCourses();
/* 103 */       CourseInfo xCourseInfo = (CourseInfo)xCourseInfos.get(Integer.valueOf(6));
/* 104 */       if (xCourseInfo == null)
/*     */       {
/* 106 */         xCourseInfo = xbean.Pod.newCourseInfo();
/* 107 */         xCourseInfos.put(Integer.valueOf(6), xCourseInfo);
/*     */       }
/* 109 */       xCourseInfo.setNum(10);
/* 110 */       xCourseInfo.setCrit_num(1);
/*     */       
/* 112 */       for (int i = 0; i < SChildHoodConst.getInstance().TOTAL_NUM - 10; i++)
/*     */       {
/* 114 */         int type = this.random.nextInt(5) + 1;
/* 115 */         ChildhoodManager.onCourseEnd(xChildInfo, type, false, now);
/*     */       }
/*     */     }
/*     */     
/* 119 */     SAddChild msg = new SAddChild();
/* 120 */     msg.child_id = this.childid;
/* 121 */     ChildBean childBean = new ChildBean();
/* 122 */     mzm.gsp.children.main.ChildrenManager.fillChildBean(xChildInfo.getOwn_role_id(), this.childid, xChildInfo, childBean, true);
/* 123 */     msg.child_info = childBean;
/* 124 */     OnlineManager.getInstance().send(this.roleid, msg);
/*     */     
/* 126 */     notifyClient("操作成功");
/* 127 */     return true;
/*     */   }
/*     */   
/*     */   private int randomCourseType()
/*     */   {
/* 132 */     return this.random.nextInt(6) + 1;
/*     */   }
/*     */   
/*     */   private void notifyClient(String str)
/*     */   {
/* 137 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 138 */     messagetip.result = Integer.MAX_VALUE;
/* 139 */     messagetip.args.add(str);
/* 140 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\PGM_FullCourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */