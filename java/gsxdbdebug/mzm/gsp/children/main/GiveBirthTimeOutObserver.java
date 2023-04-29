/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SSyncBreedInfo;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Givebirthobservers;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GiveBirthTimeOutObserver
/*     */   extends MilliObserver
/*     */ {
/*     */   private final long roleId;
/*     */   private final long marriedId;
/*     */   private final long partnerRoleId;
/*     */   private final long giveBirthScoreEnoughTime;
/*     */   
/*     */   public GiveBirthTimeOutObserver(long intervalMilliSeconds, long roleId, long marriedId, long partnerRoleId, long giveBirthScoreEnoughTime)
/*     */   {
/*  31 */     super(intervalMilliSeconds);
/*  32 */     this.roleId = roleId;
/*  33 */     this.marriedId = marriedId;
/*  34 */     this.partnerRoleId = partnerRoleId;
/*  35 */     this.giveBirthScoreEnoughTime = giveBirthScoreEnoughTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  41 */     new PGiveBirthTimeOut(this.roleId, this.marriedId, this.partnerRoleId, this.giveBirthScoreEnoughTime).execute();
/*  42 */     return false;
/*     */   }
/*     */   
/*     */   private static class PGiveBirthTimeOut
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final long marriedId;
/*     */     private final long partnerRoleId;
/*     */     private final long giveBirthScoreEnoughTime;
/*     */     
/*     */     public PGiveBirthTimeOut(long roleId, long married, long partnerRoleId, long giveBirthScoreEnoughTime)
/*     */     {
/*  55 */       this.roleId = roleId;
/*  56 */       this.marriedId = married;
/*  57 */       this.partnerRoleId = partnerRoleId;
/*  58 */       this.giveBirthScoreEnoughTime = giveBirthScoreEnoughTime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  64 */       String userId = RoleInterface.getUserId(this.roleId);
/*  65 */       String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */       
/*  67 */       List<Long> roleIdList = new ArrayList();
/*  68 */       roleIdList.add(Long.valueOf(this.roleId));
/*  69 */       roleIdList.add(Long.valueOf(this.partnerRoleId));
/*     */       
/*  71 */       lock(User.getTable(), Arrays.asList(new String[] { userId, partnerUserId }));
/*  72 */       lock(Role2properties.getTable(), roleIdList);
/*     */       
/*  74 */       long marriedId = MarriageInterface.getMarriedId(this.roleId, true);
/*  75 */       if (marriedId != this.marriedId)
/*     */       {
/*  77 */         return false;
/*     */       }
/*     */       
/*  80 */       long partnerRoleId = MarriageInterface.getMarriedRoleid(this.roleId, true);
/*  81 */       if (partnerRoleId != this.partnerRoleId)
/*     */       {
/*  83 */         return false;
/*     */       }
/*     */       
/*  86 */       long xGiveBirthScoreEnoughTime = MarriageInterface.getGiveBirthScoreEnoughTime(marriedId, true);
/*  87 */       if (xGiveBirthScoreEnoughTime != this.giveBirthScoreEnoughTime)
/*     */       {
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       Givebirthobservers.remove(Long.valueOf(this.marriedId));
/*     */       
/*  94 */       MarriageInterface.clearMarriagePregnant(marriedId);
/*     */       
/*  96 */       RoleStatusInterface.unsetStatus(roleIdList, 901);
/*     */       
/*  98 */       SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo(2, 0, 1, 0L);
/*     */       
/*     */ 
/* 101 */       OnlineManager.getInstance().sendMulti(sSyncBreedInfo, roleIdList);
/*     */       
/* 103 */       ChildrenManager.notifyChildAbortion(this.roleId, this.partnerRoleId, AbortionReasonEnum.TIME_OUT.reason);
/*     */       
/* 105 */       GameServer.logger().info(String.format("[children]PGiveBirthTimeOut.processImp@child give birth time out|role_id=%d|partner_role_id=%d|married_id=%d|give_birth_score_enough_time=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.marriedId), Long.valueOf(this.giveBirthScoreEnoughTime) }));
/*     */       
/*     */ 
/*     */ 
/* 109 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\GiveBirthTimeOutObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */