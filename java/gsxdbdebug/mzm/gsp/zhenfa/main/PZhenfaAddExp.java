/*     */ package mzm.gsp.zhenfa.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.zhenfa.NeedItemBean;
/*     */ import mzm.gsp.zhenfa.SResZhenfaInfo;
/*     */ import mzm.gsp.zhenfa.SZhenfaErrorInfo;
/*     */ import mzm.gsp.zhenfa.event.ZhenfaLevelUp;
/*     */ import mzm.gsp.zhenfa.event.ZhenfaLevelUpArg;
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
/*     */ public class PZhenfaAddExp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int zhenfaId;
/*     */   private final List<NeedItemBean> needItemBeans;
/*     */   
/*     */   public PZhenfaAddExp(long roleid, int zhenfaid, List<NeedItemBean> needItemBeans)
/*     */   {
/*  34 */     this.roleId = roleid;
/*  35 */     this.zhenfaId = zhenfaid;
/*  36 */     this.needItemBeans = needItemBeans;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!ZhenfaManager.isZhenfaSwitchOpenForRole(this.roleId))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!ZhenfaManager.isRoleStateCanOperateZhenfa(this.roleId))
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     int expNum = computeExp();
/*  52 */     if (expNum == -1)
/*     */     {
/*  54 */       sendErrorProtocal(3);
/*  55 */       return false;
/*     */     }
/*  57 */     int beforeexp = ZhenfaInterface.getZhenfaExp(this.roleId, this.zhenfaId);
/*  58 */     int beforelevel = ZhenfaInterface.getZhenfaLevel(this.roleId, this.zhenfaId);
/*  59 */     for (NeedItemBean itemBean : this.needItemBeans)
/*     */     {
/*  61 */       boolean ret = ItemInterface.removeItemById(this.roleId, 340600000, itemBean.itemid, itemBean.num, new TLogArg(LogReason.ZHENFA_ADDEXP_REM, itemBean.itemid));
/*     */       
/*  63 */       if (!ret)
/*     */       {
/*  65 */         sendErrorProtocal(4);
/*  66 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  70 */     if (!ZhenfaInterface.addZhenfaExp(this.roleId, this.zhenfaId, expNum))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     int afterlevel = ZhenfaInterface.getZhenfaLevel(this.roleId, this.zhenfaId);
/*  75 */     int afterexp = ZhenfaInterface.getZhenfaExp(this.roleId, this.zhenfaId);
/*  76 */     SResZhenfaInfo resZhenfaInfo = new SResZhenfaInfo();
/*  77 */     resZhenfaInfo.zhenfabean.zhenfaid = this.zhenfaId;
/*  78 */     resZhenfaInfo.zhenfabean.level = afterlevel;
/*  79 */     resZhenfaInfo.zhenfabean.exp = afterexp;
/*  80 */     OnlineManager.getInstance().send(this.roleId, resZhenfaInfo);
/*  81 */     if (afterlevel > beforelevel)
/*     */     {
/*  83 */       ZhenfaManager.logZhenfaLevelup(this.roleId, this.zhenfaId, beforelevel, afterlevel);
/*  84 */       ZhenfaManager.tLogZhenfaLevelup(this.roleId, this.zhenfaId, beforelevel, afterlevel, beforeexp, afterexp);
/*  85 */       TriggerEventsManger.getInstance().triggerEvent(new ZhenfaLevelUp(), new ZhenfaLevelUpArg(this.roleId, this.zhenfaId, beforelevel, afterlevel));
/*     */     }
/*     */     
/*     */ 
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int computeExp()
/*     */   {
/*  99 */     int exp = 0;
/* 100 */     for (NeedItemBean itemBean : this.needItemBeans)
/*     */     {
/* 102 */       if (ItemInterface.getItemTypeByItemId(itemBean.itemid) == 11)
/*     */       {
/* 104 */         int e = ZhenfaInterface.getZhenfaBookExp(itemBean.itemid);
/* 105 */         if (e == -1)
/*     */         {
/* 107 */           return -1;
/*     */         }
/*     */         
/* 110 */         exp += itemBean.num * e;
/* 111 */         if (ZhenfaInterface.isZhenfaBookSuitZhenfa(this.zhenfaId, itemBean.itemid))
/*     */         {
/* 113 */           int ex = ZhenfaInterface.getZhenfaBookExtraExp(itemBean.itemid);
/* 114 */           if (ex == -1)
/*     */           {
/* 116 */             return -1;
/*     */           }
/* 118 */           exp += itemBean.num * ex;
/*     */         }
/*     */       }
/* 121 */       else if (ItemInterface.getItemTypeByItemId(itemBean.itemid) == 34)
/*     */       {
/* 123 */         int ef = ZhenfaInterface.getZhenfaFragmentExp(itemBean.itemid);
/* 124 */         if (ef == -1)
/*     */         {
/* 126 */           return -1;
/*     */         }
/*     */         
/* 129 */         exp += itemBean.num * ef;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 134 */         return -1;
/*     */       }
/*     */     }
/*     */     
/* 138 */     return exp;
/*     */   }
/*     */   
/*     */   private void sendErrorProtocal(int rescode)
/*     */   {
/* 143 */     SZhenfaErrorInfo zhenfaErrorInfo = new SZhenfaErrorInfo();
/* 144 */     zhenfaErrorInfo.rescode = rescode;
/* 145 */     OnlineManager.getInstance().sendAtOnce(this.roleId, zhenfaErrorInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\main\PZhenfaAddExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */