/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.arena.main.ArenaInterface;
/*     */ import mzm.gsp.bigboss.main.BigbossInterface;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.item.main.ItemGiveManager;
/*     */ import mzm.gsp.jingji.main.JingjiInterface;
/*     */ import mzm.gsp.paraselene.main.ParaseleneInterface;
/*     */ import mzm.gsp.qmhw.main.QMHWInterface;
/*     */ import mzm.gsp.question.main.QuestionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class AqDoRoleListDataHandler
/*     */   implements IdipHandler
/*     */ {
/*     */   private static final int ALL = 99;
/*     */   private static final int MIN = 0;
/*     */   private static final int MAX = 25;
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  29 */     String userid = (String)params.get(0);
/*  30 */     long roleid = Long.parseLong((String)params.get(1));
/*  31 */     int type = Integer.parseInt((String)params.get(2));
/*  32 */     int value = Integer.parseInt((String)params.get(3));
/*     */     
/*  34 */     xbean.User xUser = xtable.User.get(userid);
/*  35 */     if (null == xUser)
/*     */     {
/*  37 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  38 */       rsp.retcode = retcode;
/*  39 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  40 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  42 */       GameServer.logger().error(String.format("[gmt]AqDoRoleListDataHandler.execute@user not found|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*  45 */       return;
/*     */     }
/*     */     
/*  48 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  50 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  51 */       rsp.retcode = retcode;
/*  52 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  53 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  55 */       GameServer.logger().error(String.format("[gmt]AqDoRoleListDataHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  59 */       return;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if ((type != 99) && ((type > 25) || (type < 0)))
/*     */     {
/*  65 */       int retcode = Retcode.AQ_DO_BAN_ROLE_LIST_DATA_RANK_TYPE_INVALID.value;
/*  66 */       rsp.retcode = retcode;
/*  67 */       Response response = IdipGmtUtil.getResponse(retcode, "rank type invalid");
/*  68 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  70 */       GameServer.logger().error(String.format("[gmt]AqDoRoleListDataHandler.execute@rank type not exist|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  74 */       return;
/*     */     }
/*     */     
/*  77 */     if (value < 0)
/*     */     {
/*  79 */       int retcode = Retcode.AQ_DO_BAN_ROLE_LIST_DATA_VALUE_INVALID.value;
/*  80 */       rsp.retcode = retcode;
/*  81 */       Response response = IdipGmtUtil.getResponse(retcode, "value < 0");
/*  82 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  84 */       GameServer.logger().error(String.format("[gmt]AqDoRoleListDataHandler.execute@rank value invalid|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/*  88 */       return;
/*     */     }
/*     */     
/*     */ 
/*  92 */     boolean success = true;
/*  93 */     switch (type)
/*     */     {
/*     */     case 0: 
/*     */     case 1: 
/*     */     case 2: 
/*     */     case 12: 
/*     */     case 13: 
/*     */     case 16: 
/*     */     case 17: 
/*     */     case 18: 
/*     */     case 19: 
/*     */     case 20: 
/*     */     case 21: 
/*     */     case 22: 
/* 107 */       success = false;
/* 108 */       break;
/*     */     case 3: 
/* 110 */       JingjiInterface.insertIntoRankForIdip(roleid, value);
/* 111 */       break;
/*     */     case 4: 
/* 113 */       QuestionInterface.insertIntoRankForIdip(roleid, value);
/* 114 */       break;
/*     */     case 5: 
/* 116 */       ItemGiveManager.insertIntoRankForIdip(roleid, -1, value);
/* 117 */       break;
/*     */     case 6: 
/* 119 */       ItemGiveManager.insertIntoRankForIdip(roleid, value, -1);
/* 120 */       break;
/*     */     case 7: 
/* 122 */       success = ArenaInterface.setScore(roleid, value);
/* 123 */       break;
/*     */     case 8: 
/* 125 */       BigbossInterface.insertIntoRankForIdip(roleid, value);
/* 126 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 9: 
/* 131 */       success = false;
/* 132 */       break;
/*     */     case 10: 
/* 134 */       ParaseleneInterface.insertIntoRankForIdip(roleid, value);
/* 135 */       break;
/*     */     
/*     */     case 11: 
/* 138 */       success = false;
/* 139 */       break;
/*     */     case 14: 
/* 141 */       QMHWInterface.setScoreForIDIP(roleid, value);
/* 142 */       break;
/*     */     
/*     */     case 15: 
/*     */     case 23: 
/*     */     case 24: 
/*     */     case 25: 
/* 148 */       success = false;
/* 149 */       break;
/*     */     case 99: 
/* 151 */       JingjiInterface.insertIntoRankForIdip(roleid, value);
/* 152 */       QuestionInterface.insertIntoRankForIdip(roleid, value);
/* 153 */       BigbossInterface.insertIntoRankForIdip(roleid, value);
/* 154 */       ParaseleneInterface.insertIntoRankForIdip(roleid, value);
/* 155 */       ItemGiveManager.insertIntoRankForIdip(roleid, value, -1);
/* 156 */       ItemGiveManager.insertIntoRankForIdip(roleid, -1, value);
/*     */       
/* 158 */       ArenaInterface.setScore(roleid, value);
/* 159 */       QMHWInterface.setScoreForIDIP(roleid, value);
/*     */       
/* 161 */       break;
/*     */     case 26: case 27: case 28: case 29: case 30: case 31: case 32: case 33: case 34: case 35: case 36: case 37: case 38: case 39: case 40: case 41: case 42: case 43: case 44: case 45: case 46: case 47: case 48: case 49: case 50: case 51: case 52: case 53: case 54: case 55: case 56: case 57: case 58: case 59: case 60: case 61: case 62: 
/*     */     case 63: case 64: case 65: case 66: case 67: case 68: case 69: case 70: case 71: case 72: case 73: case 74: case 75: case 76: case 77: case 78: case 79: case 80: case 81: case 82: case 83: case 84: case 85: case 86: case 87: case 88: case 89: case 90: case 91: case 92: case 93: case 94: case 95: case 96: case 97: case 98: default: 
/* 164 */       success = false;
/*     */     }
/*     */     
/*     */     
/* 168 */     if (!success)
/*     */     {
/* 170 */       int retcode = Retcode.AQ_DO_BAN_ROLE_LIST_DATA_RANK_TYPE_NOT_SUPPORT.value;
/* 171 */       rsp.retcode = retcode;
/* 172 */       Response response = IdipGmtUtil.getResponse(retcode, "rank type not support");
/* 173 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 175 */       GameServer.logger().error(String.format("[gmt]AqDoRoleListDataHandler.execute@rank type unsupport|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/* 179 */       return;
/*     */     }
/*     */     
/* 182 */     rsp.retcode = Retcode.SUCCESS.value;
/* 183 */     Response response = new Response();
/* 184 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 186 */     TLogManager.getInstance().addLog(userid, "GMTAqDoRoleListData", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) });
/*     */     
/* 188 */     GameServer.logger().info(String.format("[gmt]AqDoRoleListDataHandler.execute@do role list data done|userid=%s|roleid=%d|type=%d|value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(value) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\AqDoRoleListDataHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */