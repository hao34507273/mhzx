/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.GeneralCommandRsp;
/*     */ import idip.IDIPCmd_GeneralCommandReq;
/*     */ import idip.IDIPPacket_GeneralCommandRsp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.buff.confbean.BuffConstants;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IdipConfigInfo;
/*     */ import xbean.IdipNTimesAwardInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2NTimesAwardInfo;
/*     */ import xtable.Idipconfig;
/*     */ import xtable.Role2ntimesaward;
/*     */ import xtable.User;
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
/*     */ public class PIDIPCmd_NTimesAwardReq
/*     */   extends PIDIPCmd_GeneralCommandReq
/*     */ {
/*     */   private static final int MIN_N_TIMES_AWARD_CHANNEL = 1;
/*     */   private static final int MIN_N_TIMES_AWARD_TYPE = 1;
/*     */   private static final int AWARD_CHANNEL_ALL = -1;
/*     */   private static final int AWARD_TYPE_ALL = -1;
/*     */   private static final int GLOBAL_ROLE = -1;
/*  57 */   private int awardChannel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  62 */   private int awardType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  67 */   private int nTimes = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  72 */   private long startTime = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  77 */   private long expireTime = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  82 */   private long roleId = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  87 */   private int isInstall = 0;
/*     */   
/*     */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*     */   {
/*  91 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*     */     {
/*     */ 
/*     */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*     */       {
/*  96 */         return new PIDIPCmd_NTimesAwardReq(cmd);
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public PIDIPCmd_NTimesAwardReq(IDIPCmd_GeneralCommandReq cmd)
/*     */   {
/* 103 */     super(cmd);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean executeCmd(List<Long> params)
/*     */     throws Exception
/*     */   {
/* 116 */     this.awardChannel = ((Long)params.get(0)).intValue();
/* 117 */     if (((this.awardChannel < 1) && (this.awardChannel != -1)) || (this.awardChannel > BuffConstants.getInstance().MAX_AWARD_CHANNEL))
/*     */     {
/*     */ 
/* 120 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 121 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "award channel not support");
/* 122 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/* 124 */       GameServer.logger().error(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@award channel not support|award_channel=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 128 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 135 */     this.awardType = ((Long)params.get(1)).intValue();
/* 136 */     if (((this.awardType < 1) && (this.awardType != -1)) || (this.awardType > BuffConstants.getInstance().MAX_AWARD_TYPE))
/*     */     {
/*     */ 
/* 139 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 140 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "award type not support");
/* 141 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/* 143 */       GameServer.logger().error(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@award type not support|award_channel=%d|award_type=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 153 */     this.isInstall = ((Long)params.get(2)).intValue();
/* 154 */     if ((this.isInstall != 1) && (this.isInstall != 0))
/*     */     {
/* 156 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 157 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "install params not support");
/* 158 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/* 160 */       GameServer.logger().error(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@install params not support|award_channel=%d|award_type=%d|is_install=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 169 */     this.roleId = ((Long)params.get(3)).longValue();
/* 170 */     if ((this.roleId < 0L) && (this.roleId != -1L))
/*     */     {
/* 172 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 173 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "roleId not match rules,roleId < 0 but not equal -1");
/* 174 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/* 176 */       GameServer.logger().error(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@roleId not match rules,roleId < 0 but not equal -1|award_channel=%d|award_type=%d|is_install=%d|role_id=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), Long.valueOf(this.roleId), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 180 */       return false;
/*     */     }
/*     */     
/* 183 */     if ((this.roleId >= 0L) && (!RoleInterface.isRoleExist(this.roleId, true)))
/*     */     {
/* 185 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 186 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "role not found");
/* 187 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/* 189 */       GameServer.logger().error(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@role not found|award_channel=%d|award_type=%d|is_install=%d|role_id=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), Long.valueOf(this.roleId), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 193 */       return false;
/*     */     }
/* 195 */     int originalNTimesValue = ((Long)params.get(4)).intValue();
/* 196 */     if (originalNTimesValue > BuffConstants.getInstance().MAX_N_TIMES_AWARD * 100)
/*     */     {
/* 198 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 199 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("n times is too large,max n = %d", new Object[] { Integer.valueOf(BuffConstants.getInstance().MAX_N_TIMES_AWARD * 100) }));
/*     */       
/* 201 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/* 203 */       GameServer.logger().error(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@n times is too large|award_channel=%d|award_type=%d|is_install=%d|role_id=%d|n_times=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), Long.valueOf(this.roleId), Integer.valueOf(originalNTimesValue), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 208 */       return false;
/*     */     }
/* 210 */     this.nTimes = (originalNTimesValue * 100);
/* 211 */     List<Integer> buffIdList = getNeedBuffIdList();
/* 212 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 213 */     if (this.isInstall == 1)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 219 */       this.startTime = TimeUnit.SECONDS.toMillis(((Long)params.get(5)).longValue());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 224 */       this.expireTime = TimeUnit.SECONDS.toMillis(((Long)params.get(6)).longValue());
/*     */       
/* 226 */       if ((this.expireTime <= currentTimeMillis) || (this.startTime >= this.expireTime))
/*     */       {
/* 228 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 229 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "endTime less than currentTime or startTime more than endTime");
/* 230 */         ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */         
/* 232 */         GameServer.logger().error(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@endTime less than currentTime or startTime more than endTime|award_channel=%d|award_type=%d|is_install=%d|role_id=%d|start_time=%d|end_time=%d|current_time=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), Long.valueOf(this.roleId), Long.valueOf(this.startTime), Long.valueOf(this.expireTime), Long.valueOf(currentTimeMillis), params.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 237 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 241 */       if (!OpenInterface.getOpenStatus(55))
/*     */       {
/* 243 */         GameServer.logger().info(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@n times award switch is close|award_channel=%d|award_type=%d|n_times=%d|start_time=%d|end_time=%d|current_time=%d|role_id=%d|is_install=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.nTimes), Long.valueOf(this.startTime), Long.valueOf(this.expireTime), Long.valueOf(currentTimeMillis), Long.valueOf(this.roleId), Integer.valueOf(this.isInstall), params.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 249 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 250 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "n times award switch is close");
/* 251 */         ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/* 252 */         return false;
/*     */       }
/*     */       
/* 255 */       if (this.roleId < 0L)
/*     */       {
/*     */ 
/* 258 */         new PIDIPAddGlobalNTimesAward(buffIdList, this.nTimes, this.startTime, this.expireTime).execute();
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 263 */         if (OpenInterface.isBanPlay(this.roleId, 55))
/*     */         {
/* 265 */           GameServer.logger().info(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@n times award is ban play|award_channel=%d|award_type=%d|n_times=%d|start_time=%d|end_time=%d|current_time=%d|role_id=%d|is_install=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.nTimes), Long.valueOf(this.startTime), Long.valueOf(this.expireTime), Long.valueOf(currentTimeMillis), Long.valueOf(this.roleId), Integer.valueOf(this.isInstall), params.toString() }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 271 */           ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 272 */           ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "n times award is ban play");
/* 273 */           ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/* 274 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 278 */         new PIDIPAddRoleNTimesAward(buffIdList, this.roleId, this.nTimes, this.startTime, this.expireTime).execute();
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 284 */     else if (this.roleId < 0L)
/*     */     {
/*     */ 
/* 287 */       removeGlobalNTimesAward(buffIdList);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 292 */       removeRoleNTimesAward(buffIdList);
/*     */     }
/*     */     
/*     */ 
/* 296 */     GameServer.logger().info(String.format("[ntimesaward]PIDIPCmd_NTimesAwardReq.executeCmd@handle idip n times award req success|award_channel=%d|award_type=%d|n_times=%d|start_time=%d|end_time=%d|current_time=%d|role_id=%d|is_install=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.nTimes), Long.valueOf(this.startTime), Long.valueOf(this.expireTime), Long.valueOf(currentTimeMillis), Long.valueOf(this.roleId), Integer.valueOf(this.isInstall), params.toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 302 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 303 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "ok");
/* 304 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/* 305 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void removeGlobalNTimesAward(List<Integer> buffIdList)
/*     */   {
/* 313 */     for (Iterator i$ = buffIdList.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 316 */       new NTimesAwardGlobalMillObserver(0L, buffId, new NTimesAwardInfo(-1, -1L, -1L), 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void removeRoleNTimesAward(List<Integer> buffIdList)
/*     */   {
/* 325 */     for (Iterator i$ = buffIdList.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */       
/* 327 */       new NTimesAwardRoleMillObserver(0L, this.roleId, buffId, new NTimesAwardInfo(-1, -1L, -1L), 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Integer> getNeedBuffIdList()
/*     */   {
/* 337 */     List<Integer> buffIdList = new ArrayList();
/*     */     
/* 339 */     if ((this.awardChannel != -1) && (this.awardType != -1))
/*     */     {
/* 341 */       int idipId = (this.awardChannel - 1) * 20 + this.awardType;
/* 342 */       int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 343 */       buffIdList.add(Integer.valueOf(buffId));
/* 344 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 348 */     if ((this.awardChannel == -1) && (this.awardType == -1))
/*     */     {
/* 350 */       buffIdList.addAll(NTimesAwardManager.getAllBuffIdList());
/* 351 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 355 */     if (this.awardChannel == -1)
/*     */     {
/* 357 */       for (int index = 1; index <= BuffConstants.getInstance().MAX_AWARD_CHANNEL; index++)
/*     */       {
/* 359 */         int idipId = (index - 1) * 20 + this.awardType;
/* 360 */         int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 361 */         buffIdList.add(Integer.valueOf(buffId));
/*     */       }
/* 363 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 367 */     if (this.awardType == -1)
/*     */     {
/* 369 */       for (int index = 1; index <= BuffConstants.getInstance().MAX_AWARD_TYPE; index++)
/*     */       {
/* 371 */         int idipId = (this.awardChannel - 1) * 20 + index;
/* 372 */         int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 373 */         buffIdList.add(Integer.valueOf(buffId));
/*     */       }
/* 375 */       return buffIdList;
/*     */     }
/*     */     
/* 378 */     return buffIdList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class PIDIPAddGlobalNTimesAward
/*     */     extends LogicProcedure
/*     */   {
/* 389 */     private List<Integer> buffIdList = null;
/*     */     
/*     */     private final int nTimes;
/*     */     private final long startTime;
/*     */     private final long expireTime;
/*     */     private final Set<Integer> validedZoneIdSet;
/*     */     
/*     */     public PIDIPAddGlobalNTimesAward(List<Integer> buffIdList, int nTimes, long startTime, long expireTime)
/*     */     {
/* 398 */       this.buffIdList = buffIdList;
/* 399 */       this.nTimes = nTimes;
/* 400 */       this.startTime = startTime;
/* 401 */       this.expireTime = expireTime;
/* 402 */       this.validedZoneIdSet = new HashSet();
/*     */     }
/*     */     
/*     */ 
/*     */     public PIDIPAddGlobalNTimesAward(List<Integer> buffIdList, int nTimes, long startTime, long expireTime, Set<Integer> validedZoneIdSet)
/*     */     {
/* 408 */       this.buffIdList = buffIdList;
/* 409 */       this.nTimes = nTimes;
/* 410 */       this.startTime = startTime;
/* 411 */       this.expireTime = expireTime;
/* 412 */       this.validedZoneIdSet = validedZoneIdSet;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 418 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 419 */       if (xIdipConfigInfo == null)
/*     */       {
/* 421 */         xIdipConfigInfo = Pod.newIdipConfigInfo();
/* 422 */         Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*     */       }
/* 424 */       Map<Integer, IdipNTimesAwardInfo> xIdipNTimesAwardList = xIdipConfigInfo.getN_times_award();
/*     */       
/* 426 */       long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 427 */       long startIntervalMills = this.startTime - currentTimeMillis;
/* 428 */       long endIntervalMillis = this.expireTime - currentTimeMillis;
/*     */       
/* 430 */       for (Iterator i$ = this.buffIdList.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */         
/* 432 */         IdipNTimesAwardInfo xIdipNTimesAwardInfo = Pod.newIdipNTimesAwardInfo();
/* 433 */         xIdipNTimesAwardInfo.setN_times(this.nTimes);
/* 434 */         xIdipNTimesAwardInfo.setStart_time(this.startTime);
/* 435 */         xIdipNTimesAwardInfo.setExpire_time(this.expireTime);
/* 436 */         xIdipNTimesAwardInfo.getValid_zone_id_set().addAll(this.validedZoneIdSet);
/* 437 */         xIdipNTimesAwardList.put(Integer.valueOf(buffId), xIdipNTimesAwardInfo);
/*     */         
/*     */ 
/* 440 */         NTimesAwardGlobalMillObserver globalStartObserver = new NTimesAwardGlobalMillObserver(startIntervalMills < 0L ? 0L : startIntervalMills, buffId, new NTimesAwardInfo(this.nTimes, this.startTime, this.expireTime, this.validedZoneIdSet), 1);
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
/* 451 */         NTimesAwardGlobalMillObserver globalEndObserver = new NTimesAwardGlobalMillObserver(endIntervalMillis, buffId, new NTimesAwardInfo(this.nTimes, this.startTime, this.expireTime, this.validedZoneIdSet), 0);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 460 */         NTimesAwardManager.addGlobalObserver(buffId, globalStartObserver, globalEndObserver);
/*     */       }
/*     */       
/* 463 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static class PIDIPAddRoleNTimesAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final List<Integer> buffIdList;
/*     */     
/*     */     private final long roleId;
/*     */     
/*     */     private final int nTimes;
/*     */     
/*     */     private final long startTime;
/*     */     private final long expireTime;
/*     */     
/*     */     public PIDIPAddRoleNTimesAward(List<Integer> buffIdList, long roleId, int nTimes, long startTime, long expireTime)
/*     */     {
/* 482 */       this.buffIdList = buffIdList;
/* 483 */       this.roleId = roleId;
/* 484 */       this.nTimes = nTimes;
/* 485 */       this.startTime = startTime;
/* 486 */       this.expireTime = expireTime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 492 */       String userId = RoleInterface.getUserId(this.roleId);
/* 493 */       lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */       
/* 495 */       Role2NTimesAwardInfo xRole2NTimesAwardInfo = Role2ntimesaward.get(Long.valueOf(this.roleId));
/* 496 */       if (xRole2NTimesAwardInfo == null)
/*     */       {
/* 498 */         xRole2NTimesAwardInfo = Pod.newRole2NTimesAwardInfo();
/* 499 */         Role2ntimesaward.add(Long.valueOf(this.roleId), xRole2NTimesAwardInfo);
/*     */       }
/*     */       
/* 502 */       long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 503 */       Map<Integer, IdipNTimesAwardInfo> ntimesAwardMapInfo = xRole2NTimesAwardInfo.getN_times_award_role_map();
/* 504 */       for (Iterator i$ = this.buffIdList.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */         
/* 506 */         IdipNTimesAwardInfo xIdipNTimesAwardInfo = Pod.newIdipNTimesAwardInfo();
/* 507 */         xIdipNTimesAwardInfo.setExpire_time(this.expireTime);
/* 508 */         xIdipNTimesAwardInfo.setStart_time(this.startTime);
/* 509 */         xIdipNTimesAwardInfo.setN_times(this.nTimes);
/* 510 */         long startIntervalMillis = this.startTime - currentTime;
/*     */         
/* 512 */         ntimesAwardMapInfo.put(Integer.valueOf(buffId), xIdipNTimesAwardInfo);
/* 513 */         NTimesAwardRoleMillObserver roleStartObserver = new NTimesAwardRoleMillObserver(startIntervalMillis < 0L ? 0L : startIntervalMillis, this.roleId, buffId, new NTimesAwardInfo(this.nTimes, this.startTime, this.expireTime), 1);
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
/* 524 */         NTimesAwardRoleMillObserver roleEndObserver = new NTimesAwardRoleMillObserver(this.expireTime - currentTime, this.roleId, buffId, new NTimesAwardInfo(this.nTimes, this.startTime, this.expireTime), 0);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 533 */         NTimesAwardManager.addRoleObserver(this.roleId, buffId, roleStartObserver, roleEndObserver);
/*     */       }
/* 535 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 542 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_NTimesAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */