/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.confbean.TeamPlatformConsts;
/*     */ import mzm.gsp.teamplatform.STeamMatchBro;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WorldBroInfo;
/*     */ import xtable.Role2worldbroinfo;
/*     */ 
/*     */ public class PCBroTeamMatchReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCBroTeamMatchReq(long roleId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     Long curTime = Long.valueOf(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*  33 */     WorldBroInfo xWorldBroInfo = Role2worldbroinfo.get(Long.valueOf(this.roleId));
/*  34 */     if (xWorldBroInfo == null)
/*     */     {
/*  36 */       xWorldBroInfo = xbean.Pod.newWorldBroInfo();
/*  37 */       Role2worldbroinfo.insert(Long.valueOf(this.roleId), xWorldBroInfo);
/*     */     }
/*  39 */     long lastBroTime = xWorldBroInfo.getLastbrotime();
/*  40 */     if (TimeUnit.MILLISECONDS.toSeconds(curTime.longValue() - lastBroTime) < getInterval())
/*     */     {
/*  42 */       GameServer.logger().error(String.format("[teammatch]PCBroTeamMatchReq.processImp@ not at time!|roleId=%d|lastBroTime=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(lastBroTime) }));
/*     */       
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     RoleMatchInfo matchInfo = TeamMatchInterface.getRoleTeamMatchInfo(this.roleId, false);
/*  50 */     if (matchInfo == null)
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[teamMatch]PCBroTeamMatchReq.processImp@ role is not matching!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     mzm.gsp.teamplatform.TeamInfo pTeamInfo = matchInfo.getPTeamInfo();
/*  58 */     if (pTeamInfo == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[teamMatch]PCBroTeamMatchReq.processImp@ get teamInfo err!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     if (!RoleInterface.cutVigor(this.roleId, getCutVigorValue(), new TLogArg(LogReason.VIGOR_CUT__TEAM_MATCH_BRO)))
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[teamMatch]PCBroTeamMatchReq.processImp@ cutVigor err!|roleId=%d|cutValue=%d|leftValue=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(getCutVigorValue()), Integer.valueOf(RoleInterface.getVigor(this.roleId)) }));
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     xWorldBroInfo.setLastbrotime(curTime.longValue());
/*     */     
/*  76 */     OctetsStream os = new OctetsStream();
/*  77 */     Octets octets = os.marshal(pTeamInfo);
/*  78 */     STeamMatchBro bro = new STeamMatchBro();
/*  79 */     ChatInterface.fillChatContent(this.roleId, bro.content, octets, 2);
/*     */     
/*  81 */     ChatInterface.addWorldBroMsg(bro);
/*     */     
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getCutVigorValue()
/*     */   {
/*  93 */     return TeamPlatformConsts.getInstance().EASY_BRO_VIGOUR_COST;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getInterval()
/*     */   {
/* 103 */     return TeamPlatformConsts.getInstance().EASY_BRO_TIME_INTERVAL;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\PCBroTeamMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */