/*     */ package mzm.gsp.chat.question;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.RoleAwardData;
/*     */ import mzm.gsp.activity.SQuestionIsOver;
/*     */ import mzm.gsp.activity.confbean.WorldQuestionConsts;
/*     */ import mzm.gsp.chat.main.ChatInWorldObManager;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.WAwardBean;
/*     */ import xbean.WorldQuestionBean;
/*     */ 
/*     */ public class PQuestionOver extends LogicRunnable
/*     */ {
/*     */   List<Long> ranAwardMembers;
/*     */   
/*     */   public PQuestionOver()
/*     */   {
/*  26 */     this.ranAwardMembers = new ArrayList();
/*     */   }
/*     */   
/*     */   public void process() throws Exception
/*     */   {
/*  31 */     this.ranAwardMembers.clear();
/*     */     
/*  33 */     WorldQuestionBean xWQBean = WorldQuestion.getInstance().getWorldQuestionBean(false);
/*     */     
/*  35 */     doRandomAward(xWQBean);
/*     */     
/*  37 */     noticeAllOver(xWQBean);
/*     */     
/*  39 */     new OverQuestion().call();
/*     */   }
/*     */   
/*     */   class OverQuestion
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     OverQuestion() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  49 */       WorldQuestionBean xWQBean = WorldQuestion.getInstance().getWorldQuestionBean(true);
/*  50 */       return overQuestion(xWQBean);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean overQuestion(WorldQuestionBean xWQBean)
/*     */     {
/*  63 */       if (xWQBean == null)
/*     */       {
/*  65 */         return false;
/*     */       }
/*  67 */       boolean isGoing = xWQBean.getGoing();
/*  68 */       if (!isGoing)
/*     */       {
/*  70 */         return false;
/*     */       }
/*  72 */       xWQBean.setGoing(false);
/*  73 */       xWQBean.getRoleawarddata().clear();
/*     */       
/*  75 */       ChatInterface.unRegisterWorldChat(ChatInWorldObManager.TYPE__WORLD_QUESTION);
/*  76 */       GameServer.logger().info("[worldQuestion]PQuestionOver.overQuestion@world question over!");
/*  77 */       return true;
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
/*     */ 
/*     */   private void doRandomAward(WorldQuestionBean xWQBean)
/*     */   {
/*  91 */     if (!WorldQuestion.getInstance().isWQRanAwardOpen())
/*     */     {
/*  93 */       return;
/*     */     }
/*  95 */     RRandomAward r = new RRandomAward(WorldQuestion.getInstance().getAllAwardRoleIds(xWQBean));
/*  96 */     r.doAward();
/*  97 */     this.ranAwardMembers.addAll(r.getRanRoleIds());
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
/*     */   private boolean noticeAllOver(WorldQuestionBean xWQBean)
/*     */   {
/* 110 */     if (xWQBean == null)
/*     */     {
/* 112 */       return false;
/*     */     }
/* 114 */     boolean isGoing = xWQBean.getGoing();
/* 115 */     if (!isGoing)
/*     */     {
/* 117 */       return false;
/*     */     }
/* 119 */     noticeQuestionOver(xWQBean);
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   private void noticeQuestionOver(WorldQuestionBean xWQBean)
/*     */   {
/* 125 */     SQuestionIsOver sOver = new SQuestionIsOver();
/* 126 */     fillSOverPro(xWQBean, sOver);
/* 127 */     OnlineManager.getInstance().sendAll(sOver);
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
/*     */   private void fillSOverPro(WorldQuestionBean xWQBean, SQuestionIsOver sOver)
/*     */   {
/* 140 */     for (WAwardBean xAwardBean : xWQBean.getRoleawarddata())
/*     */     {
/* 142 */       fillSingleAwardInfo(sOver, xAwardBean, RoleInterface.getName(xAwardBean.getRoleid()));
/*     */     }
/*     */     
/* 145 */     fillRandomAwardInfo(sOver.nbawardinfo, this.ranAwardMembers);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillSingleAwardInfo(SQuestionIsOver sOver, WAwardBean xAwardBean, String name)
/*     */   {
/* 157 */     fillNbAwardInfo(sOver.nbawardinfo, xAwardBean, name);
/* 158 */     fillNmAwardInfo(sOver.normalawardinfo, xAwardBean, name);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillNmAwardInfo(List<RoleAwardData> normalawardinfo, WAwardBean xAwardBean, String name)
/*     */   {
/* 170 */     Map<Integer, Integer> nmItems = xAwardBean.getNmitems();
/* 171 */     if (nmItems.size() <= 0)
/*     */     {
/* 173 */       return;
/*     */     }
/* 175 */     RoleAwardData nmData = new RoleAwardData();
/* 176 */     nmData.rolename = name;
/* 177 */     nmData.roleid = xAwardBean.getRoleid();
/* 178 */     nmData.items.putAll(nmItems);
/*     */     
/* 180 */     normalawardinfo.add(nmData);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillNbAwardInfo(List<RoleAwardData> nbawardinfo, WAwardBean xAwardBean, String name)
/*     */   {
/* 192 */     if (WorldQuestion.getInstance().isWQRanAwardOpen())
/*     */     {
/*     */ 
/* 195 */       return;
/*     */     }
/* 197 */     if (nbawardinfo.size() >= WorldQuestionConsts.getInstance().NB_AWARD_ROLE_NUM)
/*     */     {
/* 199 */       return;
/*     */     }
/* 201 */     RoleAwardData nbData = new RoleAwardData();
/* 202 */     nbData.rolename = name;
/* 203 */     nbData.roleid = xAwardBean.getRoleid();
/* 204 */     Map<Integer, Integer> nbItems = xAwardBean.getNbitems();
/* 205 */     if (nbItems.size() > 0)
/*     */     {
/* 207 */       nbData.items.putAll(nbItems);
/*     */     }
/* 209 */     nbawardinfo.add(nbData);
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
/*     */   private void fillRandomAwardInfo(List<RoleAwardData> nbawardinfo, List<Long> ranMembers)
/*     */   {
/* 222 */     if ((ranMembers == null) || (ranMembers.size() == 0))
/*     */     {
/* 224 */       return;
/*     */     }
/* 226 */     for (Iterator i$ = ranMembers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 228 */       RoleAwardData nbData = new RoleAwardData();
/* 229 */       nbData.rolename = RoleInterface.getName(member);
/* 230 */       nbData.roleid = member;
/* 231 */       nbawardinfo.add(nbData);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\PQuestionOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */