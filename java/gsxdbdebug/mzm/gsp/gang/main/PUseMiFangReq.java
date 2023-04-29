/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SSyncMiFangCountChange;
/*     */ import mzm.gsp.gang.SUseMiFangRes;
/*     */ import mzm.gsp.gang.confbean.GangMiFangConst;
/*     */ import mzm.gsp.gang.confbean.SGangMiFangCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.lifeskill.main.GangMiYaoSkill;
/*     */ import mzm.gsp.lifeskill.main.LifeSkillInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangMember;
/*     */ import xbean.MiFang;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2gangmember;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PUseMiFangReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*  31 */   private Logger LOGGER = Logger.getLogger(PUseMiFangReq.class);
/*     */   private long roleId;
/*     */   
/*     */   public PUseMiFangReq(long roleId) {
/*  35 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     String userid = RoleInterface.getUserId(this.roleId);
/*  42 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  44 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*  45 */     if (xGangMember == null) {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/*  50 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleId)))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     MiFang xMiFang = xGang.getYaodian().getMifang();
/*     */     
/*  57 */     if (isEnd(xMiFang.getMifangcfgendtime())) {
/*  58 */       TaskInterface.closeActivityGraph(this.roleId, GangMiFangConst.getInstance().TASK_GRAPH_ID);
/*  59 */       return true;
/*     */     }
/*     */     
/*  62 */     if (isOutOfUse(xGangMember)) {
/*  63 */       TaskInterface.closeActivityGraph(this.roleId, GangMiFangConst.getInstance().TASK_GRAPH_ID);
/*  64 */       return true;
/*     */     }
/*  66 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.GANG_USE_MIFANG, xMiFang.getMifangcfgid());
/*     */     
/*  68 */     if (!removeYaoCai(xMiFang, logArg)) {
/*  69 */       SGangNormalResult result1 = new SGangNormalResult();
/*  70 */       result1.result = 53;
/*  71 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result1);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     if (ItemInterface.isBagFull(this.roleId, 340600000, true)) {
/*  77 */       SGangNormalResult result = new SGangNormalResult();
/*  78 */       result.result = 35;
/*  79 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     SGangMiFangCfg miFangCfg = SGangMiFangCfg.get(xMiFang.getMifangcfgid());
/*     */     
/*  85 */     GangMiYaoSkill skill = LifeSkillInterface.getGangLifeSkill(this.roleId, GangMiFangConst.getInstance().LIAYO_SKILL_BAG_ID, miFangCfg.generLifeSkillId, isNeedSuccess(xMiFang.getMifangcfgid(), xGangMember));
/*     */     
/*  87 */     if (skill == null) {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     int vigor = skill.getCostVigor();
/*     */     
/*  93 */     if (vigor < 0) {
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     if (!RoleInterface.cutVigor(this.roleId, vigor, logArg)) {
/*  99 */       SGangNormalResult result = new SGangNormalResult();
/* 100 */       result.result = 39;
/* 101 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*     */     }
/*     */     
/* 104 */     int itemId = skill.generateItem();
/*     */     
/* 106 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, itemId, 1, logArg);
/* 107 */     if (!result.success()) {
/* 108 */       SGangNormalResult result1 = new SGangNormalResult();
/* 109 */       result1.result = 35;
/* 110 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result1);
/* 111 */       return false;
/*     */     }
/* 113 */     SUseMiFangRes res = new SUseMiFangRes();
/* 114 */     res.itemid = itemId;
/* 115 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 117 */     int yaocai1 = ((Integer)xMiFang.getMifangyaocailist().get(0)).intValue();
/* 118 */     int yaocai2 = ((Integer)xMiFang.getMifangyaocailist().get(1)).intValue();
/* 119 */     int yaocai3 = ((Integer)xMiFang.getMifangyaocailist().get(2)).intValue();
/* 120 */     int yaocai4 = ((Integer)xMiFang.getMifangyaocailist().get(3)).intValue();
/*     */     
/* 122 */     StringBuilder tLogStr = new StringBuilder();
/*     */     
/* 124 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(this.roleId)).append("|").append(this.roleId).append("|").append(RoleInterface.getLevel(this.roleId)).append("|").append(xGangMember.getGangid()).append("|").append(xMiFang.getMifangcfgid()).append("|").append(yaocai1).append("|").append(yaocai2).append("|").append(yaocai3).append("|").append(yaocai4).append("|").append(itemId).append("|").append(xGang.getDisplayid());
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
/* 136 */     TLogManager.getInstance().addLog(this.roleId, "GangUseMiFang", tLogStr.toString());
/*     */     
/* 138 */     if (isOutOfUse(xGangMember)) {
/* 139 */       TaskInterface.closeActivityGraph(this.roleId, GangMiFangConst.getInstance().TASK_GRAPH_ID);
/* 140 */       return true;
/*     */     }
/* 142 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isOutOfUse(GangMember xGangMember) {
/* 146 */     if (xGangMember.getMakemifangcount() >= xGangMember.getTotalmakemifangcount()) {
/* 147 */       return true;
/*     */     }
/* 149 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isEnd(long mifangendtime) {
/* 153 */     if (mifangendtime < DateTimeUtils.getCurrTimeInMillis()) {
/* 154 */       return true;
/*     */     }
/* 156 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean removeYaoCai(MiFang xMiFang, TLogArg logArg)
/*     */   {
/* 165 */     for (Iterator i$ = xMiFang.getMifangyaocailist().iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*     */       
/* 167 */       if (!ItemInterface.removeItemById(this.roleId, 340600000, id, 1, logArg)) {
/* 168 */         return false;
/*     */       }
/*     */     }
/* 171 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isNeedSuccess(int mifangcfgid, GangMember xGangMember)
/*     */   {
/* 179 */     SGangMiFangCfg cfg = SGangMiFangCfg.get(mifangcfgid);
/* 180 */     int prop = xdb.Xdb.random().nextInt(10000);
/* 181 */     if (cfg.successRate < prop) {
/* 182 */       if (this.LOGGER.isInfoEnabled()) {
/* 183 */         this.LOGGER.info("正常炼药失败！");
/*     */       }
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     xGangMember.setMakemifangcount(xGangMember.getMakemifangcount() + 1);
/* 189 */     SSyncMiFangCountChange sSyncMiFangCountChange = new SSyncMiFangCountChange();
/* 190 */     sSyncMiFangCountChange.count = xGangMember.getMakemifangcount();
/* 191 */     OnlineManager.getInstance().send(this.roleId, sSyncMiFangCountChange);
/* 192 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PUseMiFangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */