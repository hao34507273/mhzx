/*     */ package mzm.gsp.gm.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Scanner;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.baitan.SCommonResultRes;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.main.PKFightContext;
/*     */ import mzm.gsp.qingfu.main.PGM_AddInnerSaveAmt;
/*     */ import mzm.gsp.role.main.PGMSetRoleLevel;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yuanbao.confbean.SYuanBaoConsts;
/*     */ import mzm.gsp.yuanbao.confbean.ZengSong;
/*     */ import mzm.gsp.yuanbao.main.PGM_AddBuyYuanBao;
/*     */ import mzm.gsp.yzdd.main.PJoinActivity;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GMInfo;
/*     */ import xbean.GMStatus;
/*     */ import xdb.Procedure;
/*     */ import xtable.Gm;
/*     */ import xtable.Gmstatus;
/*     */ 
/*     */ public class PGMCommand extends LogicProcedure
/*     */ {
/*     */   private final Role m_Role;
/*     */   private final String m_command;
/*     */   
/*     */   public PGMCommand(Role role, String m_command)
/*     */   {
/*  37 */     this.m_Role = role;
/*  38 */     this.m_command = m_command;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  43 */     if ((this.m_Role == null) || (this.m_command == null)) {
/*  44 */       return false;
/*     */     }
/*  46 */     long gmRoleId = this.m_Role.getRoleid();
/*  47 */     if (this.m_command.toLowerCase().contains("rmb")) {
/*  48 */       String[] data = this.m_command.split("\\.");
/*  49 */       int rmb = Integer.valueOf(data[1]).intValue();
/*  50 */       if (ItemInterface.getItemNumberById(gmRoleId, SYuanBaoConsts.getInstance().ItemId) < rmb) {
/*  51 */         SCommonResultRes sCommonResultRes = new SCommonResultRes();
/*  52 */         sCommonResultRes.res = 9;
/*  53 */         OnlineManager.getInstance().sendAtOnce(gmRoleId, sCommonResultRes);
/*  54 */         return false; }
/*  55 */       if (!ItemInterface.removeItemById(gmRoleId, SYuanBaoConsts.getInstance().ItemId, rmb, new TLogArg(LogReason.GM_REM))) {
/*  56 */         return false;
/*     */       }
/*  58 */       long yunbaoNum = rmb * SYuanBaoConsts.getInstance().Percent;
/*  59 */       Iterator<ZengSong> i$ = SYuanBaoConsts.getInstance().ZengSongs.iterator();
/*     */       
/*  61 */       while (i$.hasNext())
/*     */       {
/*     */ 
/*  64 */         ZengSong z = (ZengSong)i$.next();
/*  65 */         if (z.Rmb == rmb) {
/*  66 */           yunbaoNum += z.Song;
/*  67 */           break;
/*     */         }
/*     */       }
/*  70 */       Procedure.execute(new PGM_AddBuyYuanBao(gmRoleId, yunbaoNum));
/*  71 */       Procedure.execute(new PGM_AddInnerSaveAmt(gmRoleId, gmRoleId, (int)yunbaoNum));
/*  72 */       return true;
/*     */     }
/*  74 */     if (this.m_command.equals("joinyzdd")) {
/*  75 */       Procedure.execute(new PJoinActivity(gmRoleId));
/*  76 */       return true; }
/*  77 */     if (this.m_command.contains("yzddpk")) {
/*  78 */       String[] data = this.m_command.split("\\.");
/*  79 */       PKFightContext fightContext = new PKFightContext();
/*  80 */       fightContext.mainActiveRoleId = gmRoleId;
/*  81 */       fightContext.mainTargetRoleId = Long.valueOf(data[1]).longValue();
/*  82 */       FightInterface.startPVPFight(gmRoleId, Long.valueOf(data[1]).longValue(), fightContext, 25, FightReason.PK_FIGHT);
/*  83 */       return true;
/*     */     }
/*     */     
/*  86 */     GMStatus gmStatus = Gmstatus.get(Long.valueOf(gmRoleId));
/*  87 */     if (this.m_command.toLowerCase().equals("okzs")) {
/*  88 */       Procedure.execute(new PGMSetRoleLevel(gmRoleId, 1));
/*     */     }
/*  90 */     if (((gmStatus == null) || (gmStatus.getStatus() == 2)) && (!this.m_command.toLowerCase().equals("gm on"))) {
/*  91 */       return false;
/*     */     }
/*  93 */     Scanner scanner = new Scanner(this.m_command);
/*  94 */     scanner.useDelimiter("( +)|,");
/*  95 */     String commandName = scanner.next().toLowerCase();
/*  96 */     if (commandName == null) {
/*  97 */       GmManager.getInstance().sendResultToGM(gmRoleId, "command format error.");
/*  98 */       return false;
/*     */     }
/* 100 */     if (!GmManager.getInstance().isDebugEnv()) {
/* 101 */       String gmUserId = this.m_Role.getUserId();
/* 102 */       GMInfo gminfo = Gm.get(gmUserId);
/* 103 */       if (gminfo == null) {
/* 104 */         return false;
/*     */       }
/*     */     }
/* 107 */     ArrayList<String> arguments = new ArrayList(2);
/* 108 */     while (scanner.hasNext()) {
/* 109 */       arguments.add(scanner.next());
/*     */     }
/*     */     try {
/* 112 */       CmdBase cmd = (CmdBase)Class.forName("mzm.gsp.gm.main.Cmd_" + commandName).newInstance();
/* 113 */       GameServer.logger().info("[gm]received gm command : " + commandName);
/* 114 */       cmd.init(this.m_Role, arguments);
/* 115 */       return cmd.execute();
/*     */     } catch (ClassNotFoundException e) {
/* 117 */       GameServer.logger().debug("[GM]@PGMCommand " + commandName);
/* 118 */       GmManager.getInstance().sendResultToGM(gmRoleId, "Not support the command:" + commandName); }
/* 119 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\PGMCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */