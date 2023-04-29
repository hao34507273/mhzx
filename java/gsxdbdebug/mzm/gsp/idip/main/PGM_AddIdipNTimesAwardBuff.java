/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.buff.confbean.BuffConstants;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGM_AddIdipNTimesAwardBuff
/*     */   extends LogicProcedure
/*     */ {
/*     */   private static final int MIN_N_TIMES_AWARD_CHANNEL = 1;
/*     */   private static final int MIN_N_TIMES_AWARD_TYPE = 1;
/*     */   private static final int AWARD_CHANNEL_ALL = -1;
/*     */   private static final int AWARD_TYPE_ALL = -1;
/*     */   private static final int GLOBAL_ROLE = -1;
/*     */   private final int awardChannel;
/*     */   private final int awardType;
/*     */   private final int isInstall;
/*     */   private final int roleId;
/*     */   private int originalNTimesValue;
/*     */   private long startTime;
/*     */   private long expireTime;
/*     */   
/*     */   public PGM_AddIdipNTimesAwardBuff(int awardChannel, int awardType, int isInstall, int roleId, int originalNTimesValue, long startTime, long expireTime)
/*     */   {
/*  58 */     this.awardChannel = awardChannel;
/*  59 */     this.awardType = awardType;
/*  60 */     this.isInstall = isInstall;
/*  61 */     this.roleId = roleId;
/*  62 */     this.originalNTimesValue = originalNTimesValue;
/*  63 */     this.startTime = startTime;
/*  64 */     this.expireTime = expireTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  77 */     if (((this.awardChannel < 1) && (this.awardChannel != -1)) || (this.awardChannel > BuffConstants.getInstance().MAX_AWARD_CHANNEL))
/*     */     {
/*     */ 
/*  80 */       sendGmMessageTipRes("award channel not support");
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */     if (((this.awardType < 1) && (this.awardType != -1)) || (this.awardType > BuffConstants.getInstance().MAX_AWARD_TYPE))
/*     */     {
/*     */ 
/*  91 */       sendGmMessageTipRes("award type not support");
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  98 */     if ((this.isInstall != 1) && (this.isInstall != 0))
/*     */     {
/* 100 */       sendGmMessageTipRes("install params not support");
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 106 */     if ((this.roleId < 0) && (this.roleId != -1))
/*     */     {
/* 108 */       sendGmMessageTipRes("roleId not match rules,roleId < 0 but not equal -1");
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if ((this.roleId >= 0) && (!RoleInterface.isRoleExist(this.roleId, true)))
/*     */     {
/* 114 */       sendGmMessageTipRes("role not found");
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if (this.originalNTimesValue > BuffConstants.getInstance().MAX_N_TIMES_AWARD * 100)
/*     */     {
/* 120 */       sendGmMessageTipRes(String.format("n times is too large,max n = %d", new Object[] { Integer.valueOf(BuffConstants.getInstance().MAX_N_TIMES_AWARD * 100) }));
/*     */       
/* 122 */       return false;
/*     */     }
/* 124 */     this.originalNTimesValue *= 100;
/* 125 */     List<Integer> buffIdList = getNeedBuffIdList();
/* 126 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 127 */     if (this.isInstall == 1)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */       this.startTime = TimeUnit.SECONDS.toMillis(this.startTime);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 138 */       this.expireTime = TimeUnit.SECONDS.toMillis(this.expireTime);
/*     */       
/* 140 */       if ((this.expireTime <= currentTimeMillis) || (this.startTime >= this.expireTime))
/*     */       {
/* 142 */         sendGmMessageTipRes("endTime less than currentTime or startTime more than endTime");
/*     */         
/* 144 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 148 */       if (!OpenInterface.getOpenStatus(55))
/*     */       {
/* 150 */         sendGmMessageTipRes("n times award switch is close");
/* 151 */         return false;
/*     */       }
/*     */       
/* 154 */       if (this.roleId < 0)
/*     */       {
/*     */ 
/* 157 */         new PIDIPCmd_NTimesAwardReq.PIDIPAddGlobalNTimesAward(buffIdList, this.originalNTimesValue, this.startTime, this.expireTime).execute();
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 162 */         if (OpenInterface.isBanPlay(this.roleId, 55))
/*     */         {
/* 164 */           sendGmMessageTipRes("n times award is ban play");
/* 165 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 169 */         new PIDIPCmd_NTimesAwardReq.PIDIPAddRoleNTimesAward(buffIdList, this.roleId, this.originalNTimesValue, this.startTime, this.expireTime).execute();
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 175 */     else if (this.roleId < 0)
/*     */     {
/*     */ 
/* 178 */       removeGlobalNTimesAward(buffIdList);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 183 */       removeRoleNTimesAward(buffIdList);
/*     */     }
/*     */     
/* 186 */     sendGmMessageTipRes("ok,增加N倍经验成功");
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   private void sendGmMessageTipRes(String str)
/*     */   {
/* 192 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 193 */     messagetip.result = Integer.MAX_VALUE;
/* 194 */     messagetip.args.add(str);
/* 195 */     OnlineManager.getInstance().sendAtOnce(this.roleId, messagetip);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Integer> getNeedBuffIdList()
/*     */   {
/* 203 */     List<Integer> buffIdList = new ArrayList();
/*     */     
/* 205 */     if ((this.awardChannel != -1) && (this.awardType != -1))
/*     */     {
/* 207 */       int idipId = (this.awardChannel - 1) * 20 + this.awardType;
/* 208 */       int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 209 */       buffIdList.add(Integer.valueOf(buffId));
/* 210 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 214 */     if ((this.awardChannel == -1) && (this.awardType == -1))
/*     */     {
/* 216 */       buffIdList.addAll(NTimesAwardManager.getAllBuffIdList());
/* 217 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 221 */     if (this.awardChannel == -1)
/*     */     {
/* 223 */       for (int index = 1; index <= BuffConstants.getInstance().MAX_AWARD_CHANNEL; index++)
/*     */       {
/* 225 */         int idipId = (index - 1) * 20 + this.awardType;
/* 226 */         int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 227 */         buffIdList.add(Integer.valueOf(buffId));
/*     */       }
/* 229 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 233 */     if (this.awardType == -1)
/*     */     {
/* 235 */       for (int index = 1; index <= BuffConstants.getInstance().MAX_AWARD_TYPE; index++)
/*     */       {
/* 237 */         int idipId = (this.awardChannel - 1) * 20 + index;
/* 238 */         int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 239 */         buffIdList.add(Integer.valueOf(buffId));
/*     */       }
/* 241 */       return buffIdList;
/*     */     }
/*     */     
/* 244 */     return buffIdList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void removeGlobalNTimesAward(List<Integer> buffIdList)
/*     */   {
/* 252 */     for (Iterator i$ = buffIdList.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 255 */       new NTimesAwardGlobalMillObserver(0L, buffId, new NTimesAwardInfo(-1, -1L, -1L), 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void removeRoleNTimesAward(List<Integer> buffIdList)
/*     */   {
/* 264 */     for (Iterator i$ = buffIdList.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */       
/* 266 */       new NTimesAwardRoleMillObserver(0L, this.roleId, buffId, new NTimesAwardInfo(-1, -1L, -1L), 0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGM_AddIdipNTimesAwardBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */