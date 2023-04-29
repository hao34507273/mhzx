/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.crossfield.SSynCrossFieldForbidMatchInfo;
/*     */ import mzm.gsp.crossfield.SSynCrossFieldMatchInfo;
/*     */ import mzm.gsp.crossfield.SSynCrossFieldSeasonInfo;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSingleCrossFieldInfo;
/*     */ import xbean.RoleSingleCrossFieldResult;
/*     */ import xbean.RoleSingleCrossFieldSeasonInfo;
/*     */ import xio.Protocol;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_single_cross_field_infos;
/*     */ import xtable.Role_single_cross_field_results;
/*     */ import xtable.User;
/*     */ 
/*     */ public class ROnRoleLogin extends mzm.gsp.online.event.PlayerLoginRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  28 */     if (mzm.gsp.GameServerInfoManager.isRoamServer())
/*     */     {
/*  30 */       return;
/*     */     }
/*  32 */     long roleid = ((Long)this.arg).longValue();
/*     */     
/*  34 */     new PSynMatchProcess(roleid).call();
/*     */     
/*  36 */     new PSynForbidMatchInfo(roleid).call();
/*     */     
/*  38 */     new PSynSeasonInfo(roleid).call();
/*     */     
/*  40 */     new PRefreshRank(roleid).call();
/*     */     
/*  42 */     SingleCrossFieldChartManager.getInstance().checkAndSendAward(roleid);
/*     */   }
/*     */   
/*     */   class PSynMatchProcess extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     PSynMatchProcess(long roleid)
/*     */     {
/*  51 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  57 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/*  59 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  61 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/*  63 */       long contextid = RoleSingleCrossFieldContextManager.getInstance().getContextid(this.roleid);
/*  64 */       if (contextid <= 0L)
/*     */       {
/*  66 */         CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynMatchProcess.processImp@not in match|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/*  68 */         return false;
/*     */       }
/*  70 */       SingleCrossFieldContext context = CrossServerInterface.getSingleCrossFieldContext(contextid);
/*  71 */       if (context == null)
/*     */       {
/*  73 */         CrossFieldManager.logger.error(String.format("[crossfield]ROnRoleLogin.PSynMatchProcess.processImp@context do not exist|roleid=%d|contextid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(contextid) }));
/*     */         
/*     */ 
/*  76 */         return false;
/*     */       }
/*     */       
/*  79 */       SSynCrossFieldMatchInfo protocol = new SSynCrossFieldMatchInfo();
/*  80 */       protocol.activity_cfg_id = context.getActivityCfgid();
/*  81 */       protocol.process = context.getProcess();
/*  82 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/*  84 */       CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynMatchProcess.processImp@game server login process|roleid=%d|activity_cfg_id=%d|process=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(context.getActivityCfgid()), Byte.valueOf(context.getProcess()) }));
/*     */       
/*     */ 
/*  87 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PSynForbidMatchInfo extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     PSynForbidMatchInfo(long roleid)
/*     */     {
/*  97 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 103 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/* 105 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/* 107 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/* 109 */       SSynCrossFieldForbidMatchInfo protocol = new SSynCrossFieldForbidMatchInfo();
/* 110 */       protocol.active_leave_field_timestamp = ((int)(CrossFieldManager.getRoleActiveLeaveFieldTimestamp(this.roleid) / 1000L));
/* 111 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 113 */       CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynForbidMatchInfo.processImp@game server login process|roleid=%d|active_leave_field_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(protocol.active_leave_field_timestamp) }));
/*     */       
/*     */ 
/* 116 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PSynSeasonInfo extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     PSynSeasonInfo(long roleid)
/*     */     {
/* 126 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 132 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/* 134 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/* 136 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/* 138 */       RoleSingleCrossFieldResult xRoleSingleCrossFieldResult = Role_single_cross_field_results.get(Long.valueOf(this.roleid));
/* 139 */       if (xRoleSingleCrossFieldResult != null)
/*     */       {
/* 141 */         mzm.gsp.timer.main.Session.removeSession(xRoleSingleCrossFieldResult.getSession_id(), this.roleid);
/* 142 */         for (Protocol protocol : xRoleSingleCrossFieldResult.getResult())
/*     */         {
/* 144 */           OnlineManager.getInstance().send(this.roleid, protocol);
/* 145 */           CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynSeasonInfo.processImp@send protocol to role|userid=%s|roleid=%d|protocol_name=%s|protocol_type=%d|protocol_content=%s", new Object[] { userid, Long.valueOf(this.roleid), protocol.getClass().getName(), Integer.valueOf(protocol.getType()), protocol.toString() }));
/*     */         }
/*     */         
/*     */ 
/* 149 */         Role_single_cross_field_results.remove(Long.valueOf(this.roleid));
/* 150 */         CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynSeasonInfo.processImp@game server login process|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/* 152 */         return true;
/*     */       }
/*     */       
/* 155 */       int season = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/* 156 */       if (season <= 0)
/*     */       {
/* 158 */         CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynSeasonInfo.processImp@no active season|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       }
/*     */       
/* 161 */       RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.get(Long.valueOf(this.roleid));
/* 162 */       if (xRoleSingleCrossFieldInfo == null)
/*     */       {
/* 164 */         CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynSeasonInfo.processImp@no season data|roleid=%d|season=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(season) }));
/*     */         
/*     */ 
/* 167 */         return false;
/*     */       }
/* 169 */       RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = (RoleSingleCrossFieldSeasonInfo)xRoleSingleCrossFieldInfo.getSeason_infos().get(Integer.valueOf(season));
/*     */       
/* 171 */       if (xRoleSingleCrossFieldSeasonInfo == null)
/*     */       {
/* 173 */         CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynSeasonInfo.processImp@no season data|roleid=%d|season=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(season) }));
/*     */         
/*     */ 
/* 176 */         return false;
/*     */       }
/*     */       
/* 179 */       SSynCrossFieldSeasonInfo protocol = new SSynCrossFieldSeasonInfo();
/* 180 */       protocol.season = season;
/* 181 */       protocol.star_num = xRoleSingleCrossFieldSeasonInfo.getStar_num();
/* 182 */       protocol.win_point = xRoleSingleCrossFieldSeasonInfo.getWin_point();
/* 183 */       protocol.straight_win_num = xRoleSingleCrossFieldSeasonInfo.getStraight_win_num();
/* 184 */       protocol.star_num_timestamp = ((int)(xRoleSingleCrossFieldSeasonInfo.getStar_num_timestamp() / 1000L));
/*     */       
/* 186 */       protocol.current_week_point = (DateTimeUtils.needWeeklyReset(xRoleSingleCrossFieldInfo.getWeekly_point_sum_timestamp(), DateTimeUtils.getCurrTimeInMillis(), 1, 0) ? 0 : xRoleSingleCrossFieldInfo.getWeekly_point_sum());
/*     */       
/*     */ 
/* 189 */       protocol.last_get_point_time = TimeUnit.MILLISECONDS.toSeconds(xRoleSingleCrossFieldInfo.getWeekly_point_sum_timestamp());
/*     */       
/* 191 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 193 */       CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.PSynSeasonInfo.processImp@game server login process|roleid=%d|season=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(season) }));
/*     */       
/*     */ 
/* 196 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */