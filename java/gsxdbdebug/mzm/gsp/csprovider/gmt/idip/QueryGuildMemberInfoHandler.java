/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import gnet.link.Onlines;
/*     */ import idip.MemberInfo;
/*     */ import idip.QueryGuildMemberInfoRsp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QueryGuildMemberInfoHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  24 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(0));
/*  25 */     long gangid = Long.parseLong((String)params.get(1));
/*  26 */     int page = Integer.parseInt((String)params.get(2));
/*     */     
/*  28 */     Gang gang = null;
/*  29 */     if (roleid > 0L)
/*     */     {
/*  31 */       if (!mzm.gsp.role.main.RoleInterface.isRoleExist(roleid, false))
/*     */       {
/*  33 */         int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  34 */         rsp.retcode = retcode;
/*  35 */         Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  36 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  38 */         GameServer.logger().error(String.format("[gmt]QueryGuildMemberInfoHandler.execute@role not found|roleid=%d|gangid=%d|page=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(gangid), Integer.valueOf(page) }));
/*     */         
/*     */ 
/*  41 */         return;
/*     */       }
/*     */       
/*  44 */       gang = GangInterface.getGangByRoleId(roleid, false);
/*     */     }
/*     */     
/*  47 */     if (gang == null)
/*     */     {
/*  49 */       if (gangid > 0L)
/*     */       {
/*  51 */         gang = GangInterface.getGang(gangid, false);
/*     */       }
/*     */     }
/*     */     
/*  55 */     if (gang == null)
/*     */     {
/*  57 */       int retcode = Retcode.QUERY_GANG_NOT_EXIST.value;
/*  58 */       rsp.retcode = retcode;
/*  59 */       Response response = IdipGmtUtil.getResponse(retcode, "gang not exist");
/*  60 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  62 */       GameServer.logger().error(String.format("[gmt]QueryGuildMemberInfoHandler.execute@gang not exist|roleid=%d|gangid=%d|page=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(gangid), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  65 */       return;
/*     */     }
/*     */     
/*  68 */     if (page <= 0)
/*     */     {
/*  70 */       int retcode = Retcode.QUERY_GANG_PAGE_INVALID.value;
/*  71 */       rsp.retcode = retcode;
/*  72 */       Response response = IdipGmtUtil.getResponse(retcode, "page <= 0");
/*  73 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  75 */       GameServer.logger().error(String.format("[gmt]QueryGuildMemberInfoHandler.execute@page <= 0|roleid=%d|gangid=%d|page=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(gangid), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     int size = gang.getMemberSize();
/*  82 */     int pageSize = 100;
/*  83 */     int totalPageNo = (int)Math.ceil(size * 1.0D / 100.0D);
/*  84 */     int fromIndex = (page - 1) * 100;
/*     */     
/*  86 */     QueryGuildMemberInfoRsp queryGuildMemberInfoRsp = new QueryGuildMemberInfoRsp();
/*  87 */     queryGuildMemberInfoRsp.TotalPageNo = totalPageNo;
/*  88 */     if (fromIndex >= size)
/*     */     {
/*  90 */       rsp.retcode = Retcode.SUCCESS.value;
/*  91 */       Response response = new Response();
/*  92 */       response.data = queryGuildMemberInfoRsp;
/*  93 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  95 */       GameServer.logger().info(String.format("[gmt]QueryGuildMemberInfoHandler.execute@query guild memeber info success|roleid=%d|gangid=%d|page=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(gangid), Integer.valueOf(page) }));
/*     */       
/*     */ 
/*     */ 
/*  99 */       return;
/*     */     }
/*     */     
/* 102 */     int toIndex = page * 100;
/* 103 */     if (toIndex > size)
/*     */     {
/* 105 */       toIndex = size;
/*     */     }
/* 107 */     for (Iterator i$ = gang.getMemberList().subList(fromIndex, toIndex).iterator(); i$.hasNext();) { long memberRoleid = ((Long)i$.next()).longValue();
/*     */       
/* 109 */       queryGuildMemberInfoRsp.MemberInfo.add(fillMemberInfo(memberRoleid, gang));
/*     */     }
/* 111 */     queryGuildMemberInfoRsp.MemberInfo_count = queryGuildMemberInfoRsp.MemberInfo.size();
/*     */     
/* 113 */     rsp.retcode = Retcode.SUCCESS.value;
/* 114 */     Response response = new Response();
/* 115 */     response.data = queryGuildMemberInfoRsp;
/* 116 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 118 */     GameServer.logger().info(String.format("[gmt]QueryGuildMemberInfoHandler.execute@query guild memeber info success|roleid=%d|gangid=%d|page=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(gangid), Integer.valueOf(page) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private MemberInfo fillMemberInfo(long roleid, Gang gang)
/*     */   {
/* 126 */     Role role = mzm.gsp.role.main.RoleInterface.getRole(roleid, false);
/* 127 */     MemberInfo memberInfo = new MemberInfo();
/* 128 */     memberInfo.RoleId = String.valueOf(roleid);
/* 129 */     memberInfo.RoleName = role.getName();
/* 130 */     memberInfo.Pos = gang.getGangDuty(roleid);
/* 131 */     memberInfo.Job = role.getOccupationId();
/* 132 */     memberInfo.Level = role.getLevel();
/* 133 */     memberInfo.Fight = role.getFightValue();
/* 134 */     memberInfo.Contribute = ((int)GangInterface.getBangGong(roleid));
/* 135 */     memberInfo.IsOnline = (OnlineManager.getInstance().isOnline(roleid) ? 1 : 0);
/* 136 */     String userId = role.getUserId();
/* 137 */     String OpenID = Onlines.getInstance().findOpenid(userId);
/* 138 */     memberInfo.OpenId = OpenID;
/* 139 */     return memberInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryGuildMemberInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */