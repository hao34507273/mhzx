/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*     */ import mzm.gsp.gang.SSyncGangHelp;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.huanhun.SSeekHelpFromGangReq;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HanhunInfo;
/*     */ import xbean.ItemInfo;
/*     */ import xtable.Gang;
/*     */ import xtable.Gang2hunhelp;
/*     */ 
/*     */ public class PSeekHelpFromGangReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int itemIndex;
/*     */   
/*     */   public PSeekHelpFromGangReq(long roleId, int itemIndex)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.itemIndex = itemIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!HuanhunManager.isHunOpen(this.roleId))
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     if (!HuanhunManager.isHunHelpOpen(this.roleId))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     HanhunInfo xHunInfo = xtable.Role2huanhun.get(Long.valueOf(this.roleId));
/*  42 */     if (xHunInfo == null)
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     long gangId = GangInterface.getGangId(this.roleId);
/*  47 */     if (gangId <= 0L)
/*     */     {
/*  49 */       HuanhunManager.sendNormalResult(3, this.roleId, new String[0]);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     lock(Gang.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(gangId) }));
/*  54 */     if (gangId != GangInterface.getGangId(this.roleId))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     xbean.GangHelpInfo xHelpInfo = Gang2hunhelp.get(Long.valueOf(gangId));
/*  60 */     if (xHelpInfo == null)
/*     */     {
/*  62 */       xHelpInfo = xbean.Pod.newGangHelpInfo();
/*  63 */       Gang2hunhelp.insert(Long.valueOf(gangId), xHelpInfo);
/*     */     }
/*     */     
/*  66 */     ItemInfo xItemInfo = (ItemInfo)xHunInfo.getIteminfos().get(Integer.valueOf(this.itemIndex));
/*  67 */     if (xItemInfo == null)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[hun]PSeekHelpFromGangReq.processImp@ xItemInfo is null!|roleId=%d|gangId=%d|index=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(gangId), Integer.valueOf(this.itemIndex) }));
/*     */       
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (!checkCanCallHelp(xHunInfo))
/*     */     {
/*  77 */       GameServer.logger().error(String.format("[hun]PSeekHelpFromGangReq.processImp@ can not call help!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (!GangHelpManager.addRoleGangHelp(gangId, xHelpInfo, this.roleId, this.itemIndex, xItemInfo.getItemcfgid(), xItemInfo.getItemnum()))
/*     */     {
/*     */ 
/*  85 */       GameServer.logger().error(String.format("[hun]PSeekHelpFromGangReq.processImp@ add help error!|roleId=%d|gangId=%d|index=%d|itemId=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(gangId), Integer.valueOf(this.itemIndex), Integer.valueOf(xItemInfo.getItemcfgid()), Integer.valueOf(xItemInfo.getItemnum()) }));
/*     */       
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     afterCallHelp(xHunInfo, gangId, xItemInfo);
/*     */     
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   private void afterCallHelp(HanhunInfo xHunInfo, long gangId, ItemInfo xItemInfo)
/*     */   {
/*  99 */     xItemInfo.setGanghelpstate(true);
/* 100 */     if (xHunInfo.getSeekhelpleftcount() > 0)
/*     */     {
/* 102 */       int count = xHunInfo.getSeekhelpleftcount();
/* 103 */       xHunInfo.setSeekhelpleftcount(--count);
/*     */     }
/*     */     
/* 106 */     broGangHelp(gangId, xItemInfo);
/*     */     
/* 108 */     noticSeekHelpSuc();
/*     */     
/* 110 */     HunLogManager.addHunHelpLog(this.roleId, 0L, 1, xItemInfo.getItemcfgid());
/*     */   }
/*     */   
/*     */   private void noticSeekHelpSuc()
/*     */   {
/* 115 */     SSeekHelpFromGangReq seekHelpFromGangReq = new SSeekHelpFromGangReq();
/* 116 */     seekHelpFromGangReq.itemindex = this.itemIndex;
/*     */     
/* 118 */     OnlineManager.getInstance().send(this.roleId, seekHelpFromGangReq);
/*     */   }
/*     */   
/*     */ 
/*     */   private void broGangHelp(long gangId, ItemInfo xItemInfo)
/*     */   {
/* 124 */     SSyncGangHelp sSyncGangHelp = new SSyncGangHelp();
/* 125 */     sSyncGangHelp.helpertype = 0;
/* 126 */     sSyncGangHelp.paramlong.put(Integer.valueOf(10), Long.valueOf(this.roleId));
/* 127 */     sSyncGangHelp.paramint.put(Integer.valueOf(11), Integer.valueOf(xItemInfo.getItemcfgid()));
/* 128 */     sSyncGangHelp.paramint.put(Integer.valueOf(12), Integer.valueOf(xItemInfo.getItemnum()));
/* 129 */     sSyncGangHelp.paramint.put(Integer.valueOf(13), Integer.valueOf(this.itemIndex));
/*     */     
/*     */ 
/* 132 */     GangInterface.brocastInGang(sSyncGangHelp, gangId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkCanCallHelp(HanhunInfo xHunInfo)
/*     */   {
/* 144 */     int fullNum = 0;
/* 145 */     for (ItemInfo itemInfo : xHunInfo.getIteminfos().values())
/*     */     {
/* 147 */       if (itemInfo.getTaskstate())
/*     */       {
/* 149 */         fullNum++;
/*     */       }
/*     */     }
/* 152 */     int num = HuanHunMiShuConsts.getInstance().FULL_BOX_NUM_BEFORE_SEEK_HRLP;
/* 153 */     if (fullNum < num)
/*     */     {
/* 155 */       GameServer.logger().error(String.format("[hun]PSeekHelpFromGangReq.checkCanCallHelp@full box num not enough!|roleId=%d|fullNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(fullNum) }));
/*     */       
/*     */ 
/* 158 */       HuanhunManager.sendNormalResult(1, this.roleId, new String[] { num + "" });
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     int count = xHunInfo.getSeekhelpleftcount();
/* 163 */     if (count <= 0)
/*     */     {
/* 165 */       GameServer.logger().error(String.format("[hun]PSeekHelpFromGangReq.checkCanCallHelp@can call help num not enough!|roleId=%d|count=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(count) }));
/*     */       
/*     */ 
/*     */ 
/* 169 */       HuanhunManager.sendNormalResult(1, this.roleId, new String[0]);
/* 170 */       return false;
/*     */     }
/* 172 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PSeekHelpFromGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */