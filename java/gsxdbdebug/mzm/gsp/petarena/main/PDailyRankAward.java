/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaAppellationCfg;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaRankAwardCfg;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaInfo;
/*     */ import xbean.PetArenaRankBackup;
/*     */ import xtable.Petarenarankbackup;
/*     */ import xtable.Role2petarenainfo;
/*     */ 
/*     */ public class PDailyRankAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int rank;
/*     */   
/*     */   public PDailyRankAward(long roleid, int rank)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.rank = rank;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*     */     {
/*  44 */       GameServer.logger().error(String.format("[petarena]PDailyRankAward.processImp@fun not open|roleid=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank) }));
/*     */       
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     PetArenaInfo xPetArenaInfo = Role2petarenainfo.get(Long.valueOf(this.roleid));
/*  50 */     if (xPetArenaInfo == null)
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[petarena]PDailyRankAward.processImp@system error|roleid=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank) }));
/*     */       
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     int oldMaxRank = xPetArenaInfo.getMax_rank();
/*  59 */     if ((oldMaxRank == 0) || (this.rank < oldMaxRank))
/*     */     {
/*  61 */       int addPoint = 0;
/*  62 */       if (oldMaxRank == 0)
/*     */       {
/*  64 */         addPoint = PetArenaManager.getAwardPoint(this.rank);
/*     */       }
/*     */       else
/*     */       {
/*  68 */         addPoint = PetArenaManager.getAwardPoint(this.rank) - PetArenaManager.getAwardPoint(oldMaxRank);
/*     */       }
/*     */       
/*  71 */       xPetArenaInfo.setMax_rank(this.rank);
/*  72 */       TLogArg logArg = new TLogArg(LogReason.PET_ARENA_MAX_RANK_AWARD);
/*  73 */       JifenOperateResult res = MallInterface.addJifen(this.roleid, addPoint, 14, true, logArg);
/*  74 */       if (!res.isSuccess())
/*     */       {
/*  76 */         GameServer.logger().error(String.format("[petarena]PDailyRankAward.processImp@add point failed|roleid=%d|rank=%d|old_max_rank=%d|add_point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Integer.valueOf(oldMaxRank), Integer.valueOf(addPoint) }));
/*     */         
/*     */ 
/*     */ 
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       if (!sendManRankMail(oldMaxRank, addPoint))
/*     */       {
/*  85 */         GameServer.logger().error(String.format("[petarena]PDailyRankAward.processImp@send mail fail|roleid=%d|rank=%d|old_max_rank=%d|add_point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Integer.valueOf(oldMaxRank), Integer.valueOf(addPoint) }));
/*     */         
/*     */ 
/*     */ 
/*  89 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  94 */     TreeMap<Integer, SPetArenaRankAwardCfg> cfgs = (TreeMap)SPetArenaRankAwardCfg.getAll();
/*  95 */     Map.Entry<Integer, SPetArenaRankAwardCfg> entry = cfgs.floorEntry(Integer.valueOf(this.rank));
/*  96 */     if (entry == null)
/*     */     {
/*  98 */       GameServer.logger().info(String.format("[petarena]PDailyRankAward.processImp@floor entry is null|roleid=%d|rank=%d|old_max_rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Integer.valueOf(oldMaxRank) }));
/*     */       
/*     */ 
/* 101 */       return false;
/*     */     }
/* 103 */     SPetArenaRankAwardCfg petArenaRankAwardCfg = (SPetArenaRankAwardCfg)entry.getValue();
/* 104 */     if (this.rank <= petArenaRankAwardCfg.maxRank)
/*     */     {
/* 106 */       int awardCfgid = petArenaRankAwardCfg.award;
/* 107 */       AwardReason awardReason = new AwardReason(LogReason.PET_ARENA_RANK_AWARD_MAIL, awardCfgid);
/* 108 */       awardReason.setAwardItemBind(true);
/* 109 */       mzm.gsp.award.main.AwardModel awardModel = AwardInterface.getRoleFixAwardModel(awardCfgid, this.roleid, awardReason);
/* 110 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 113 */         GameServer.logger().error(String.format("[petarena]PDailyRankAward.processImp@award model null|roleid=%d|rank=%d|award_cfgid=%d|old_max_rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Integer.valueOf(awardCfgid), Integer.valueOf(oldMaxRank) }));
/*     */         
/*     */ 
/*     */ 
/* 117 */         return false;
/*     */       }
/* 119 */       MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel, true);
/* 120 */       TLogArg tLogArg = new TLogArg(LogReason.PET_ARENA_RANK_AWARD_MAIL, awardCfgid);
/* 121 */       int mailCfgid = SPetArenaConst.getInstance().RANK_MAIL_CFG_ID;
/* 122 */       List<String> contentArgs = new ArrayList();
/* 123 */       contentArgs.add(String.valueOf(this.rank));
/* 124 */       SendMailRet ret = MailInterface.synBuildAndSendMail(this.roleid, mailCfgid, null, contentArgs, attachment, tLogArg);
/*     */       
/* 126 */       if (!ret.isOK())
/*     */       {
/*     */ 
/* 129 */         GameServer.logger().error(String.format("[petarena]PDailyRankAward.processImp@send mail failed|roleid=%d|rank=%d|award_cfgid=%d|mail_cfgid=%d|old_max_rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Integer.valueOf(awardCfgid), Integer.valueOf(mailCfgid), Integer.valueOf(oldMaxRank) }));
/*     */         
/*     */ 
/*     */ 
/* 133 */         return false;
/*     */       }
/*     */       
/* 136 */       PetArenaManager.addTLog(this.roleid, "PetArenaDailyRankAwardForServer", new Object[] { Integer.valueOf(this.rank), Integer.valueOf(awardCfgid) });
/*     */     }
/*     */     
/*     */ 
/* 140 */     SPetArenaAppellationCfg petArenaAppellationCfg = SPetArenaAppellationCfg.get(this.rank);
/* 141 */     if (petArenaAppellationCfg != null)
/*     */     {
/* 143 */       TitleInterface.addAppellation(this.roleid, petArenaAppellationCfg.appellation, true);
/*     */     }
/*     */     
/*     */ 
/* 147 */     long key = GameServerInfoManager.getLocalId();
/* 148 */     PetArenaRankBackup xPetArenaRankBackup = Petarenarankbackup.get(Long.valueOf(key));
/* 149 */     if (xPetArenaRankBackup == null)
/*     */     {
/* 151 */       GameServer.logger().info(String.format("[petarena]PDailyRankAward.processImp@xbean is null|roleid=%d|rank=%d|old_max_rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Integer.valueOf(oldMaxRank) }));
/*     */       
/*     */ 
/* 154 */       return false;
/*     */     }
/* 156 */     xPetArenaRankBackup.getAwards().remove(Long.valueOf(this.roleid));
/*     */     
/* 158 */     GameServer.logger().info(String.format("[petarena]PDailyRankAward.processImp@send mail success|roleid=%d|rank=%d|old_max_rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rank), Integer.valueOf(oldMaxRank) }));
/*     */     
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   private boolean sendManRankMail(int oldMaxRank, int addPoint)
/*     */   {
/* 166 */     int mailCfgid = SPetArenaConst.getInstance().MAX_RANK_MAIL_CFG_ID;
/* 167 */     List<String> contentArgs = new ArrayList();
/* 168 */     contentArgs.add(String.valueOf(this.rank));
/* 169 */     if (oldMaxRank != 0)
/*     */     {
/* 171 */       contentArgs.add(String.valueOf(oldMaxRank - this.rank));
/*     */     }
/*     */     else
/*     */     {
/* 175 */       mailCfgid = SPetArenaConst.getInstance().MAX_RANK_MAIL_CFG_ID_PROMOTE;
/*     */     }
/* 177 */     contentArgs.add(String.valueOf(addPoint));
/* 178 */     TLogArg tLogArg = new TLogArg(LogReason.PET_ARENA_MAX_RANK_AWARD);
/* 179 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleid, mailCfgid, null, contentArgs, tLogArg);
/* 180 */     return sendMailRet.isOK();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PDailyRankAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */