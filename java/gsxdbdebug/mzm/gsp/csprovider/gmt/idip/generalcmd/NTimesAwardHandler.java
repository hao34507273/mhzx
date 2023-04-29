/*     */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.buff.confbean.BuffConstants;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*     */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.Response;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.idip.main.NTimesAwardGlobalMillObserver;
/*     */ import mzm.gsp.idip.main.NTimesAwardInfo;
/*     */ import mzm.gsp.idip.main.NTimesAwardManager;
/*     */ import mzm.gsp.idip.main.NTimesAwardRoleMillObserver;
/*     */ import mzm.gsp.idip.main.PIDIPCmd_NTimesAwardReq.PIDIPAddGlobalNTimesAward;
/*     */ import mzm.gsp.idip.main.PIDIPCmd_NTimesAwardReq.PIDIPAddRoleNTimesAward;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class NTimesAwardHandler
/*     */   implements IdipHandler
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  99 */     this.awardChannel = Integer.valueOf((String)params.get(0)).intValue();
/* 100 */     if (((this.awardChannel < 1) && (this.awardChannel != -1)) || (this.awardChannel > BuffConstants.getInstance().MAX_AWARD_CHANNEL))
/*     */     {
/*     */ 
/* 103 */       int retcode = Retcode.N_TIMES_AWARD_CHANNEL_NOT_SUPPORT.value;
/* 104 */       rsp.retcode = retcode;
/* 105 */       Response response = IdipGmtUtil.getResponse(retcode, "award channel not support");
/* 106 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 108 */       GameServer.logger().error(String.format("[gmt]NTimesAwardHandler.execute@award channel not support|award_channel=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), params.toString() }));
/*     */       
/*     */ 
/* 111 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 118 */     this.awardType = Integer.valueOf((String)params.get(1)).intValue();
/* 119 */     if (((this.awardType < 1) && (this.awardType != -1)) || (this.awardType > BuffConstants.getInstance().MAX_AWARD_TYPE))
/*     */     {
/*     */ 
/* 122 */       int retcode = Retcode.N_TIMES_AWARD_TYPE_NOT_SUPPORT.value;
/* 123 */       rsp.retcode = retcode;
/* 124 */       Response response = IdipGmtUtil.getResponse(retcode, "award type not support");
/* 125 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 127 */       GameServer.logger().error(String.format("[gmt]NTimesAwardHandler.execute@award type not support|award_channel=%d|award_type=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 131 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 137 */     this.isInstall = Integer.valueOf((String)params.get(2)).intValue();
/* 138 */     if ((this.isInstall != 1) && (this.isInstall != 0))
/*     */     {
/* 140 */       int retcode = Retcode.N_TIMES_INSTALL_TYPE_NOT_SUPPORT.value;
/* 141 */       rsp.retcode = retcode;
/* 142 */       Response response = IdipGmtUtil.getResponse(retcode, "install params not support");
/* 143 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 145 */       GameServer.logger().error(String.format("[gmt]NTimesAwardHandler.execute@install params not support|award_channel=%d|award_type=%d|is_install=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 149 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 154 */     this.roleId = Long.valueOf((String)params.get(3)).longValue();
/* 155 */     if ((this.roleId < 0L) && (this.roleId != -1L))
/*     */     {
/* 157 */       int retcode = Retcode.N_TIMES_ROLE_ID_NOT_MATCH_RULES.value;
/* 158 */       rsp.retcode = retcode;
/* 159 */       Response response = IdipGmtUtil.getResponse(retcode, "roleId not match rules,roleId < 0 but not equal -1");
/* 160 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 162 */       GameServer.logger().error(String.format("[gmt]NTimesAwardHandler.execute@roleId not match rules,roleId < 0 but not equal -1|award_channel=%d|award_type=%d|is_install=%d|role_id=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), Long.valueOf(this.roleId), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 166 */       return;
/*     */     }
/*     */     
/* 169 */     if ((this.roleId >= 0L) && (!RoleInterface.isRoleExist(this.roleId, true)))
/*     */     {
/* 171 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 172 */       rsp.retcode = retcode;
/* 173 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 174 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 176 */       GameServer.logger().error(String.format("[gmt]NTimesAwardHandler.execute@role not found|award_channel=%d|award_type=%d|is_install=%d|role_id=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), Long.valueOf(this.roleId), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 180 */       return;
/*     */     }
/* 182 */     int originalNTimesValue = Integer.valueOf((String)params.get(4)).intValue();
/* 183 */     if (originalNTimesValue > BuffConstants.getInstance().MAX_N_TIMES_AWARD * 100)
/*     */     {
/* 185 */       String retMsg = String.format("n times is too large,max n = %d", new Object[] { Integer.valueOf(BuffConstants.getInstance().MAX_N_TIMES_AWARD * 100) });
/*     */       
/* 187 */       int retcode = Retcode.N_TIMES_TOO_LARGE.value;
/* 188 */       rsp.retcode = retcode;
/* 189 */       Response response = IdipGmtUtil.getResponse(retcode, retMsg);
/* 190 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 192 */       GameServer.logger().error(String.format("[gmt]NTimesAwardHandler.execute@n times is too large|award_channel=%d|award_type=%d|is_install=%d|role_id=%d|n_times=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), Long.valueOf(this.roleId), Integer.valueOf(originalNTimesValue), params.toString() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 197 */       return;
/*     */     }
/* 199 */     this.nTimes = (originalNTimesValue * 100);
/* 200 */     List<Integer> buffIdList = getNeedBuffIdList();
/* 201 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 202 */     if (this.isInstall == 1)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 208 */       this.startTime = TimeUnit.SECONDS.toMillis(Long.valueOf((String)params.get(5)).longValue());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 213 */       this.expireTime = TimeUnit.SECONDS.toMillis(Long.valueOf((String)params.get(6)).longValue());
/*     */       
/* 215 */       if ((this.expireTime <= currentTimeMillis) || (this.startTime >= this.expireTime))
/*     */       {
/* 217 */         int retcode = Retcode.N_TIMES_END_TIME_OR_START_TIME_ERROR.value;
/* 218 */         rsp.retcode = retcode;
/* 219 */         Response response = IdipGmtUtil.getResponse(retcode, "endTime less than currentTime or startTime more than endTime");
/*     */         
/* 221 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 223 */         GameServer.logger().error(String.format("[gmt]NTimesAwardHandler.execute@endTime less than currentTime or startTime more than endTime|award_channel=%d|award_type=%d|is_install=%d|role_id=%d|start_time=%d|end_time=%d|current_time=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.isInstall), Long.valueOf(this.roleId), Long.valueOf(this.startTime), Long.valueOf(this.expireTime), Long.valueOf(currentTimeMillis), params.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 228 */         return;
/*     */       }
/*     */       
/*     */ 
/* 232 */       if (!OpenInterface.getOpenStatus(55))
/*     */       {
/* 234 */         GameServer.logger().info(String.format("[gmt]NTimesAwardHandler.execute@n times award switch is close|award_channel=%d|award_type=%d|n_times=%d|start_time=%d|end_time=%d|current_time=%d|role_id=%d|is_install=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.nTimes), Long.valueOf(this.startTime), Long.valueOf(this.expireTime), Long.valueOf(currentTimeMillis), Long.valueOf(this.roleId), Integer.valueOf(this.isInstall), params.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 240 */         int retcode = Retcode.N_TIMES_SWITCH_CLOSE.value;
/* 241 */         rsp.retcode = retcode;
/* 242 */         Response response = IdipGmtUtil.getResponse(retcode, "n times award switch is close");
/* 243 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 245 */         return;
/*     */       }
/*     */       
/* 248 */       if (this.roleId < 0L)
/*     */       {
/*     */ 
/* 251 */         new PIDIPCmd_NTimesAwardReq.PIDIPAddGlobalNTimesAward(buffIdList, this.nTimes, this.startTime, this.expireTime).execute();
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 256 */         if (OpenInterface.isBanPlay(this.roleId, 55))
/*     */         {
/* 258 */           GameServer.logger().info(String.format("[ntimesaward]NTimesAwardHandler.execute@n times award is ban play|award_channel=%d|award_type=%d|n_times=%d|start_time=%d|end_time=%d|current_time=%d|role_id=%d|is_install=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.nTimes), Long.valueOf(this.startTime), Long.valueOf(this.expireTime), Long.valueOf(currentTimeMillis), Long.valueOf(this.roleId), Integer.valueOf(this.isInstall), params.toString() }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 264 */           int retcode = Retcode.N_TIMES_BAN_THE_ROLE_PLAY.value;
/* 265 */           rsp.retcode = retcode;
/* 266 */           Response response = IdipGmtUtil.getResponse(retcode, "n times award is ban play");
/* 267 */           rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */           
/* 269 */           return;
/*     */         }
/*     */         
/*     */ 
/* 273 */         new PIDIPCmd_NTimesAwardReq.PIDIPAddRoleNTimesAward(buffIdList, this.roleId, this.nTimes, this.startTime, this.expireTime).execute();
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 279 */     else if (this.roleId < 0L)
/*     */     {
/*     */ 
/* 282 */       removeGlobalNTimesAward(buffIdList);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 287 */       removeRoleNTimesAward(buffIdList);
/*     */     }
/*     */     
/*     */ 
/* 291 */     GameServer.logger().info(String.format("[gmt]PIDIPCmd_NTimesAwardReq.executeCmd@handle idip n times award req success|award_channel=%d|award_type=%d|n_times=%d|start_time=%d|end_time=%d|current_time=%d|role_id=%d|is_install=%d|params=%s", new Object[] { Integer.valueOf(this.awardChannel), Integer.valueOf(this.awardType), Integer.valueOf(this.nTimes), Long.valueOf(this.startTime), Long.valueOf(this.expireTime), Long.valueOf(currentTimeMillis), Long.valueOf(this.roleId), Integer.valueOf(this.isInstall), params.toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 297 */     rsp.retcode = Retcode.SUCCESS.value;
/* 298 */     Response response = new Response();
/* 299 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void removeGlobalNTimesAward(List<Integer> buffIdList)
/*     */   {
/* 307 */     for (Iterator i$ = buffIdList.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 310 */       new NTimesAwardGlobalMillObserver(0L, buffId, new NTimesAwardInfo(-1, -1L, -1L), 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void removeRoleNTimesAward(List<Integer> buffIdList)
/*     */   {
/* 319 */     for (Iterator i$ = buffIdList.iterator(); i$.hasNext();) { int buffId = ((Integer)i$.next()).intValue();
/*     */       
/* 321 */       new NTimesAwardRoleMillObserver(0L, this.roleId, buffId, new NTimesAwardInfo(-1, -1L, -1L), 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Integer> getNeedBuffIdList()
/*     */   {
/* 331 */     List<Integer> buffIdList = new ArrayList();
/*     */     
/* 333 */     if ((this.awardChannel != -1) && (this.awardType != -1))
/*     */     {
/* 335 */       int idipId = (this.awardChannel - 1) * 20 + this.awardType;
/* 336 */       int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 337 */       buffIdList.add(Integer.valueOf(buffId));
/* 338 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 342 */     if ((this.awardChannel == -1) && (this.awardType == -1))
/*     */     {
/* 344 */       buffIdList.addAll(NTimesAwardManager.getAllBuffIdList());
/* 345 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 349 */     if (this.awardChannel == -1)
/*     */     {
/* 351 */       for (int index = 1; index <= BuffConstants.getInstance().MAX_AWARD_CHANNEL; index++)
/*     */       {
/* 353 */         int idipId = (index - 1) * 20 + this.awardType;
/* 354 */         int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 355 */         buffIdList.add(Integer.valueOf(buffId));
/*     */       }
/* 357 */       return buffIdList;
/*     */     }
/*     */     
/*     */ 
/* 361 */     if (this.awardType == -1)
/*     */     {
/* 363 */       for (int index = 1; index <= BuffConstants.getInstance().MAX_AWARD_TYPE; index++)
/*     */       {
/* 365 */         int idipId = (this.awardChannel - 1) * 20 + index;
/* 366 */         int buffId = NTimesAwardManager.getBuffIdByIdipId(idipId);
/* 367 */         buffIdList.add(Integer.valueOf(buffId));
/*     */       }
/* 369 */       return buffIdList;
/*     */     }
/*     */     
/* 372 */     return buffIdList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\NTimesAwardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */