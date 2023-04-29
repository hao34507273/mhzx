/*     */ package mzm.gsp.superequipment.wushi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.superequipment.SPutOffWuShiSuccess;
/*     */ import mzm.gsp.superequipment.SSynWuShiInfo;
/*     */ import mzm.gsp.superequipment.SWuShiError;
/*     */ import mzm.gsp.superequipment.main.SuperEquipmentInterface;
/*     */ import mzm.gsp.superequipment.wushi.confbean.SWuShiAccumulateFragmentCountInfo;
/*     */ import mzm.gsp.superequipment.wushi.confbean.SWuShiAwardCfg;
/*     */ import mzm.gsp.superequipment.wushi.confbean.TWuShiTypeId2firstLevelId;
/*     */ import mzm.gsp.superequipment.wushi.confbean.WuShiCfg;
/*     */ import mzm.gsp.superequipment.wushi.event.DelWuShi;
/*     */ import mzm.gsp.superequipment.wushi.event.DelWuShiArg;
/*     */ import mzm.gsp.superequipment.wushi.event.PutOffSuperEquipmentWuShi;
/*     */ import mzm.gsp.superequipment.wushi.event.PutOffSuperEquipmentWuShiArg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.Pod;
/*     */ import xbean.WuShiAwardInfo;
/*     */ import xbean.WuShiInfoMap;
/*     */ import xtable.Role2wushiawardinfo;
/*     */ import xtable.Role2wushiinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WuShiManager
/*     */ {
/*     */   static int getOnWuShiCfgId(WuShiInfoMap xWuShiInfoMap)
/*     */   {
/*  52 */     return xWuShiInfoMap.getOnwushicfgid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkSwitchAndCross(long roleId)
/*     */   {
/*  63 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  65 */       OnlineManager.getInstance().sendAtOnce(roleId, new SWuShiError(4));
/*  66 */       return false;
/*     */     }
/*  68 */     if (!OpenInterface.getOpenStatus(397))
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkSwitchAndCross(long roleId, int status)
/*     */   {
/*  84 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, status, true))
/*     */     {
/*  86 */       OnlineManager.getInstance().sendAtOnce(roleId, new SWuShiError(4));
/*  87 */       return false;
/*     */     }
/*  89 */     if (!OpenInterface.getOpenStatus(397))
/*     */     {
/*  91 */       return false;
/*     */     }
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   static boolean synWuShiInfo(long roleId)
/*     */   {
/*  98 */     WuShiInfoMap xWuShiInfoMap = Role2wushiinfo.get(Long.valueOf(roleId));
/*  99 */     ArrayList<mzm.gsp.superequipment.WuShiInfo> wushiinfos = new ArrayList();
/*     */     
/* 101 */     if (xWuShiInfoMap == null)
/*     */     {
/* 103 */       OnlineManager.getInstance().sendAtOnce(roleId, new SSynWuShiInfo(wushiinfos));
/* 104 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 109 */     Map<Integer, xbean.WuShiInfo> xWuShiCfgId2WuShiInfo = xWuShiInfoMap.getWushicfgid2wushiinfo();
/* 110 */     for (Map.Entry<Integer, xbean.WuShiInfo> entry : xWuShiCfgId2WuShiInfo.entrySet())
/*     */     {
/* 112 */       xbean.WuShiInfo xWuShiInfo = (xbean.WuShiInfo)entry.getValue();
/* 113 */       mzm.gsp.superequipment.WuShiInfo wuShiInfo = new mzm.gsp.superequipment.WuShiInfo();
/* 114 */       wuShiInfo.wushicfgid = ((Integer)entry.getKey()).intValue();
/* 115 */       wuShiInfo.fragmentcount = xWuShiInfo.getFragmentcount();
/* 116 */       wuShiInfo.isactivate = xWuShiInfo.getIsactivate();
/* 117 */       wuShiInfo.ison = (xWuShiInfoMap.getOnwushicfgid() == wuShiInfo.wushicfgid ? 1 : 2);
/* 118 */       wushiinfos.add(wuShiInfo);
/*     */     }
/*     */     
/*     */ 
/* 122 */     OnlineManager.getInstance().sendAtOnce(roleId, new SSynWuShiInfo(wushiinfos));
/* 123 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean putOffWuShi(long roleId)
/*     */   {
/* 134 */     boolean ret = checkSwitchAndCross(roleId, 1612);
/* 135 */     if (!ret)
/*     */     {
/* 137 */       return false;
/*     */     }
/* 139 */     WuShiInfoMap xWuShiInfoMap = Role2wushiinfo.get(Long.valueOf(roleId));
/* 140 */     if (xWuShiInfoMap == null)
/*     */     {
/* 142 */       OnlineManager.getInstance().sendAtOnce(roleId, new SWuShiError(2));
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     int wuShiCfgId = xWuShiInfoMap.getOnwushicfgid();
/* 147 */     if (wuShiCfgId == -1)
/*     */     {
/* 149 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 153 */     xWuShiInfoMap.setOnwushicfgid(0);
/*     */     
/*     */ 
/* 156 */     TriggerEventsManger.getInstance().triggerEvent(new PutOffSuperEquipmentWuShi(), new PutOffSuperEquipmentWuShiArg(roleId, wuShiCfgId));
/*     */     
/* 158 */     OnlineManager.getInstance().send(roleId, new SPutOffWuShiSuccess());
/* 159 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean sendAwardByMail(long roleId, int fixAwardId, int mailCfgId, String stage)
/*     */   {
/* 164 */     AwardModel awardModel = AwardInterface.getRoleFixAwardModel(fixAwardId, roleId, new AwardReason(LogReason.SUPER_EQUIPMENT_WUSHI_AWARD, fixAwardId));
/*     */     
/* 166 */     if (awardModel == null)
/*     */     {
/* 168 */       return false;
/*     */     }
/* 170 */     MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel);
/* 171 */     List<String> contentArgs = new ArrayList();
/* 172 */     contentArgs.add(stage);
/* 173 */     Map<Integer, Integer> itemMap = awardModel.getItemMap();
/* 174 */     for (Map.Entry<Integer, Integer> entry : itemMap.entrySet())
/*     */     {
/* 176 */       contentArgs.add(SItemCfg.get(((Integer)entry.getKey()).intValue()).name);
/*     */     }
/* 178 */     SendMailRet ret = MailInterface.synBuildAndSendMail(roleId, mailCfgId, new ArrayList(), contentArgs, attachment, new TLogArg(LogReason.SUPER_EQUIPMENT_WUSHI_AWARD));
/*     */     
/* 180 */     return ret.isOK();
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean sendWuShiAward(long roleId)
/*     */   {
/* 186 */     boolean ret = checkSwitchAndCross(roleId);
/* 187 */     if (!ret)
/*     */     {
/* 189 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 193 */     int minStage = SuperEquipmentInterface.getMinStageFromRoleEquipments(roleId);
/* 194 */     if (minStage == -1)
/*     */     {
/* 196 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 200 */     WuShiAwardInfo xWuShiAwardInfo = Role2wushiawardinfo.get(Long.valueOf(roleId));
/* 201 */     if (xWuShiAwardInfo == null)
/*     */     {
/* 203 */       xWuShiAwardInfo = Pod.newWuShiAwardInfo();
/* 204 */       Role2wushiawardinfo.insert(Long.valueOf(roleId), xWuShiAwardInfo);
/*     */     }
/* 206 */     Set<Integer> xWuShiAwardCfgIds = xWuShiAwardInfo.getWushiawardcfgids();
/*     */     
/* 208 */     for (int i = 1; i <= minStage; i++)
/*     */     {
/*     */ 
/* 211 */       SWuShiAwardCfg wuShiAwardCfg = SWuShiAwardCfg.get(i);
/* 212 */       if (wuShiAwardCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 217 */         if (!xWuShiAwardCfgIds.contains(Integer.valueOf(i)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */           ret = sendAwardByMail(roleId, wuShiAwardCfg.fixAwardId, wuShiAwardCfg.mailId, String.valueOf(i));
/* 224 */           if (!ret)
/*     */           {
/* 226 */             return false;
/*     */           }
/*     */           
/* 229 */           xWuShiAwardCfgIds.add(Integer.valueOf(i));
/*     */         } } }
/* 231 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static int removeWuShiByFragment(long roleId, int wuShiTypeId, int fragmentCountToRemove, boolean isHoldRoleLock)
/*     */   {
/* 237 */     WuShiInfoMap xWuShiInfoMap = isHoldRoleLock ? Role2wushiinfo.get(Long.valueOf(roleId)) : Role2wushiinfo.select(Long.valueOf(roleId));
/*     */     
/*     */ 
/* 240 */     if (xWuShiInfoMap == null)
/*     */     {
/* 242 */       return 63976;
/*     */     }
/*     */     
/* 245 */     WuShiCfg wuShiCfg = null;
/*     */     
/* 247 */     xbean.WuShiInfo xWuShiInfo = null;
/*     */     
/* 249 */     for (Map.Entry<Integer, xbean.WuShiInfo> entry : xWuShiInfoMap.getWushicfgid2wushiinfo().entrySet())
/*     */     {
/* 251 */       wuShiCfg = WuShiCfg.get(((Integer)entry.getKey()).intValue());
/* 252 */       if (wuShiCfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 256 */         if (wuShiCfg.typeId == wuShiTypeId)
/*     */         {
/* 258 */           xWuShiInfo = (xbean.WuShiInfo)entry.getValue();
/* 259 */           break;
/*     */         } }
/*     */     }
/* 262 */     if (xWuShiInfo == null)
/*     */     {
/* 264 */       return 63976;
/*     */     }
/*     */     
/* 267 */     int oldWuShiCfgId = wuShiCfg.id;
/*     */     
/* 269 */     SWuShiAccumulateFragmentCountInfo wuShiAccumulateFragmentCountInfo = SWuShiAccumulateFragmentCountInfo.get(wuShiTypeId);
/*     */     
/* 271 */     if (wuShiAccumulateFragmentCountInfo == null)
/*     */     {
/* 273 */       return 63976;
/*     */     }
/* 275 */     Integer oldWuShiCfgAccumulateFragCount = (Integer)wuShiAccumulateFragmentCountInfo.cfgId2accumulateFragCountMap.get(Integer.valueOf(oldWuShiCfgId));
/*     */     
/* 277 */     if (oldWuShiCfgAccumulateFragCount == null)
/*     */     {
/* 279 */       return 63976;
/*     */     }
/* 281 */     TWuShiTypeId2firstLevelId wuShiTypeId2firstLevelId = TWuShiTypeId2firstLevelId.get(wuShiTypeId);
/* 282 */     if (wuShiTypeId2firstLevelId == null)
/*     */     {
/* 284 */       return 63976;
/*     */     }
/*     */     
/*     */ 
/* 288 */     int beforeFragCount = xWuShiInfo.getFragmentcount();
/*     */     
/* 290 */     int currAccFragmentCount = 0;
/* 291 */     int afterFragCount = 0;
/* 292 */     int newWuShiCfgId = 0;
/*     */     
/*     */ 
/* 295 */     xWuShiInfoMap.getWushicfgid2wushiinfo().remove(Integer.valueOf(oldWuShiCfgId));
/*     */     int oldAccumulateFragmentCount;
/* 297 */     int oldAccumulateFragmentCount; if (xWuShiInfo.getIsactivate() == 4)
/*     */     {
/* 299 */       oldAccumulateFragmentCount = xWuShiInfo.getFragmentcount();
/*     */     }
/*     */     else
/*     */     {
/* 303 */       oldAccumulateFragmentCount = xWuShiInfo.getFragmentcount() + oldWuShiCfgAccumulateFragCount.intValue();
/*     */     }
/*     */     
/* 306 */     if (oldAccumulateFragmentCount < fragmentCountToRemove)
/*     */     {
/* 308 */       return 63975;
/*     */     }
/*     */     
/* 311 */     if (fragmentCountToRemove > 0)
/*     */     {
/* 313 */       xWuShiInfo = Pod.newWuShiInfo();
/*     */       
/* 315 */       currAccFragmentCount = oldAccumulateFragmentCount - fragmentCountToRemove;
/* 316 */       Map.Entry<Integer, Integer> floorEntry = wuShiAccumulateFragmentCountInfo.accumulateFragCount2cfgIdMap.floorEntry(Integer.valueOf(currAccFragmentCount));
/*     */       
/*     */ 
/* 319 */       if (floorEntry == null)
/*     */       {
/* 321 */         newWuShiCfgId = wuShiTypeId2firstLevelId.firstLevelId;
/* 322 */         xWuShiInfo.setFragmentcount(currAccFragmentCount);
/* 323 */         xWuShiInfo.setIsactivate(4);
/*     */       }
/*     */       else
/*     */       {
/* 327 */         newWuShiCfgId = ((Integer)floorEntry.getValue()).intValue();
/* 328 */         xWuShiInfo.setFragmentcount(currAccFragmentCount - ((Integer)floorEntry.getKey()).intValue());
/* 329 */         xWuShiInfo.setIsactivate(3);
/*     */       }
/*     */       
/* 332 */       xWuShiInfoMap.getWushicfgid2wushiinfo().put(Integer.valueOf(newWuShiCfgId), xWuShiInfo);
/* 333 */       afterFragCount = xWuShiInfo.getFragmentcount();
/*     */     }
/*     */     
/* 336 */     if (xWuShiInfoMap.getOnwushicfgid() == oldWuShiCfgId)
/*     */     {
/* 338 */       xWuShiInfoMap.setOnwushicfgid(0);
/* 339 */       TriggerEventsManger.getInstance().triggerEvent(new PutOffSuperEquipmentWuShi(), new PutOffSuperEquipmentWuShiArg(roleId, oldWuShiCfgId));
/*     */     }
/*     */     
/*     */ 
/* 343 */     WuShiTlogManager.tLogDelWuSHi(roleId, oldAccumulateFragmentCount, beforeFragCount, oldWuShiCfgId, fragmentCountToRemove, currAccFragmentCount, afterFragCount, newWuShiCfgId);
/*     */     
/*     */ 
/* 346 */     TriggerEventsManger.getInstance().triggerEvent(new DelWuShi(), new DelWuShiArg(roleId));
/*     */     
/* 348 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\WuShiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */