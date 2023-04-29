/*     */ package mzm.gsp.chat.question;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.WorldQuestionConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WAwardBean;
/*     */ import xbean.WorldQuestionBean;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoleAnswer
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final String answer;
/*     */   private WorldQuestion worldQuestion;
/*     */   
/*     */   public POnRoleAnswer(long roleId, String answer)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.answer = answer;
/*  33 */     this.worldQuestion = WorldQuestion.getInstance();
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     WorldQuestionBean xWQBean = this.worldQuestion.getWorldQuestionBean(false);
/*  40 */     if (!checkCanGiveAward(xWQBean))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     String userId = RoleInterface.getUserId(this.roleId);
/*  46 */     lock(Lockeys.get(User.getTable(), userId));
/*  47 */     lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*  48 */     xWQBean = this.worldQuestion.getWorldQuestionBean(true);
/*     */     
/*  50 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.worldQuestion.getActivityId()).isCanJoin())
/*     */     {
/*  52 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/*  54 */         GameServer.logger().debug(String.format("[worldquestion]POnRoleAnswer.processImp@can not answer question!|roleId=%d|roleLevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(RoleInterface.getLevel(this.roleId)) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if (!getRightAnswer(this.worldQuestion, xWQBean, true))
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     WorldQuestion.AddRes res = this.worldQuestion.addAwardRole(this.roleId);
/*  68 */     if (res != WorldQuestion.AddRes.SUC)
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     if (!this.worldQuestion.isWQOpen(this.roleId, false))
/*     */     {
/*  74 */       return false;
/*     */     }
/*  76 */     if (!afterAnswerRight(xWQBean, userId))
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean afterAnswerRight(WorldQuestionBean xWQBean, String userId)
/*     */   {
/*  92 */     int nowSize = xWQBean.getRoleawarddata().size();
/*     */     
/*  94 */     boolean frist = needTopNAward(nowSize);
/*  95 */     if (!doAward(xWQBean, frist, this.roleId, userId))
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     boolean full = nowSize >= getAwardRoleCfgNum();
/* 101 */     if (full)
/*     */     {
/* 103 */       new PQuestionOver().execute();
/*     */     }
/*     */     
/* 106 */     logAnswerRight(xWQBean, userId);
/* 107 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean needTopNAward(int nowSize)
/*     */   {
/* 118 */     if (this.worldQuestion.isWQRanAwardOpen())
/*     */     {
/*     */ 
/* 121 */       return false;
/*     */     }
/* 123 */     return nowSize <= getAwardNBRoleCfgNum();
/*     */   }
/*     */   
/*     */   private void logAnswerRight(WorldQuestionBean xWQBean, String userId)
/*     */   {
/* 128 */     int questionId = xWQBean.getQuestionid();
/* 129 */     List<WAwardBean> xWAwardBeans = xWQBean.getRoleawarddata();
/* 130 */     if ((xWAwardBeans == null) || (xWAwardBeans.size() == 0))
/*     */     {
/* 132 */       return;
/*     */     }
/* 134 */     for (int index = 0; index < xWAwardBeans.size(); index++)
/*     */     {
/*     */ 
/* 137 */       WAwardBean xAwardBean = (WAwardBean)xWAwardBeans.get(index);
/* 138 */       if (xAwardBean.getRoleid() == this.roleId)
/*     */       {
/*     */ 
/*     */ 
/* 142 */         String vGameIP = GameServerInfoManager.getHostIP();
/* 143 */         int rolelevel = RoleInterface.getLevel(this.roleId);
/*     */         
/* 145 */         Object[] colums = { vGameIP, userId, Long.valueOf(this.roleId), Integer.valueOf(rolelevel), Integer.valueOf(questionId), Integer.valueOf(index + 1), xAwardBean.getNbitems(), xAwardBean.getNmitems() };
/*     */         
/*     */ 
/* 148 */         TLogManager.getInstance().addLog(this.roleId, "WorldQuestion", colums);
/* 149 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkCanGiveAward(WorldQuestionBean xWQBean)
/*     */   {
/* 163 */     if (!getRightAnswer(this.worldQuestion, xWQBean, false))
/*     */     {
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean doAward(WorldQuestionBean xWQBean, boolean fristOne, long roleId, String userId)
/*     */   {
/* 182 */     if (fristOne)
/*     */     {
/* 184 */       if (!this.worldQuestion.doNBAward(roleId, userId, xWQBean))
/*     */       {
/* 186 */         return false;
/*     */       }
/*     */     }
/* 189 */     if (!this.worldQuestion.doNormalAward(roleId, userId, xWQBean))
/*     */     {
/* 191 */       return false;
/*     */     }
/* 193 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean getRightAnswer(WorldQuestion worldQuestion, WorldQuestionBean xWQBean, boolean isLog)
/*     */   {
/* 206 */     if (xWQBean == null)
/*     */     {
/* 208 */       if ((isLog) && (GameServer.logger().isDebugEnabled()))
/*     */       {
/* 210 */         GameServer.logger().error(String.format("[worldQuestion]POnRoleAnswer.getRightAnswer@ xbean not exist!", new Object[0]));
/*     */       }
/* 212 */       return false;
/*     */     }
/* 214 */     if (!xWQBean.getGoing())
/*     */     {
/* 216 */       if ((isLog) && (GameServer.logger().isDebugEnabled()))
/*     */       {
/* 218 */         GameServer.logger().debug(String.format("[worldQuestion]POnRoleAnswer.getRightAnswer@ answer end!", new Object[0]));
/*     */       }
/* 220 */       return false;
/*     */     }
/* 222 */     if (!worldQuestion.answerRight(this.roleId, this.answer, xWQBean.getQuestionid()))
/*     */     {
/* 224 */       if ((isLog) && (GameServer.logger().isDebugEnabled()))
/*     */       {
/* 226 */         GameServer.logger().debug(String.format("[worldQuestion]POnRoleAnswer.getRightAnswer@ answer wrong!", new Object[0]));
/*     */       }
/* 228 */       return false;
/*     */     }
/* 230 */     return true;
/*     */   }
/*     */   
/*     */   private int getAwardRoleCfgNum()
/*     */   {
/* 235 */     return WorldQuestionConsts.getInstance().NORMAL_AWARD_ROLE_NUM;
/*     */   }
/*     */   
/*     */   private int getAwardNBRoleCfgNum()
/*     */   {
/* 240 */     return WorldQuestionConsts.getInstance().NB_AWARD_ROLE_NUM;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\POnRoleAnswer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */