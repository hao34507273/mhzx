/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity4.confbean.SCakeContentCfg;
/*     */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import xbean.Item;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PAwardCake extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int cakeId;
/*     */   private final int activityId;
/*     */   private final int curTurn;
/*     */   
/*     */   public PAwardCake(long roleId, int cakeId, int activityId, int curTurn)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.cakeId = cakeId;
/*  34 */     this.activityId = activityId;
/*  35 */     this.curTurn = curTurn;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     SCakeContentCfg cakeCfg = SCakeContentCfg.get(this.cakeId);
/*  42 */     if (cakeCfg == null)
/*     */     {
/*     */ 
/*  45 */       CakeManager.loggerError("PAwardCake.processImp@ SCakeContentCfg is null!|roleId=%d|cakeId=%d|activityId=%d|curTurn=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cakeId), Integer.valueOf(this.activityId), Integer.valueOf(this.curTurn) });
/*     */       
/*     */ 
/*  48 */       return false;
/*     */     }
/*  50 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  52 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  54 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*     */ 
/*  57 */     List<Item> xItems = ItemInterface.createXItem(cakeCfg.awardItemId, 1, getItemExtroMap(), false);
/*  58 */     if ((xItems == null) || (xItems.size() == 0))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     TLogArg logArg = getTLogArg(cakeCfg);
/*  64 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, xItems, true, logArg);
/*  65 */     if (result.success())
/*     */     {
/*  67 */       return true;
/*     */     }
/*  69 */     if (!result.isBagFull())
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     CakeManager.loggerInfo("PAwardCake.processImp@ bag full, send mail!|roleId=%d|activityId=%d|cakeId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.cakeId) });
/*     */     
/*  75 */     List<String> emptyStrings = java.util.Collections.emptyList();
/*  76 */     SendMailRet ret = MailInterface.synBuildAndSendMail(this.roleId, SCatCfgConsts.getInstance().CAT_ITEM_MAIL_CFG_ID, emptyStrings, emptyStrings, getMailAttachment(xItems), logArg);
/*     */     
/*  78 */     if (!ret.isOK())
/*     */     {
/*  80 */       return false;
/*     */     }
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   private MailAttachment getMailAttachment(List<Item> xItems)
/*     */   {
/*  87 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/*  88 */     mailAttachment.addXItem(xItems);
/*  89 */     return mailAttachment;
/*     */   }
/*     */   
/*     */   private TLogArg getTLogArg(SCakeContentCfg cakeCfg)
/*     */   {
/*  94 */     TLogArg logArg = new TLogArg(LogReason.AWARD_GET_CAKE, this.activityId);
/*  95 */     logArg.addItem2num(cakeCfg.awardItemId, 1);
/*  96 */     return logArg;
/*     */   }
/*     */   
/*     */   private Map<Integer, Integer> getItemExtroMap()
/*     */   {
/* 101 */     Map<Integer, Integer> extraMap = new HashMap();
/* 102 */     extraMap.put(Integer.valueOf(ItemStoreEnum.CAKE_ACTIVITY_ID.getStoreType()), Integer.valueOf(this.activityId));
/* 103 */     extraMap.put(Integer.valueOf(ItemStoreEnum.CAKE_MAKER_ID_HIGH.getStoreType()), Integer.valueOf(CommonUtils.getLongHigh(this.roleId)));
/* 104 */     extraMap.put(Integer.valueOf(ItemStoreEnum.CAKE_MAKER_ID_LOW.getStoreType()), Integer.valueOf(CommonUtils.getLongLow(this.roleId)));
/* 105 */     return extraMap;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PAwardCake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */