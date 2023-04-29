/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.huanhun.SAddGangHelp;
/*     */ import mzm.gsp.huanhun.SRmGangHelp;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GangHelpManager
/*     */ {
/*     */   static boolean addRoleGangHelp(long gangId, xbean.GangHelpInfo xHelpInfo, long roleId, int boxIndex, int itemId, int num)
/*     */   {
/*  38 */     if (xHelpInfo == null)
/*     */     {
/*  40 */       GameServer.logger().error(String.format("[hun]GangHelpManager.addRoleGangHelp@ xHelpInfo is null!|roleId=%d|boxIndex=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(boxIndex) }));
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*  45 */     HunGangHelpInfo helpInfo = new HunGangHelpInfo(xHelpInfo);
/*  46 */     if (helpInfo.isBoxCallHelped(roleId, boxIndex))
/*     */     {
/*  48 */       GameServer.logger().error(String.format("[hun]GangHelpManager.addRoleGangHelp@ already call help!|roleId=%d|boxIndex=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(boxIndex) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       HuanhunManager.sendNormalResult(2, roleId, new String[0]);
/*  53 */       return false;
/*     */     }
/*  55 */     long nowSecond = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  56 */     helpInfo.addRoleHelp(roleId, boxIndex, itemId, num, nowSecond);
/*     */     
/*  58 */     callHelpSucNotice(gangId, roleId, boxIndex, itemId, num, nowSecond);
/*  59 */     return true;
/*     */   }
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
/*     */   private static void callHelpSucNotice(long gangId, long roleId, int boxIndex, int itemId, int num, long nowSecond)
/*     */   {
/*  73 */     SAddGangHelp p = new SAddGangHelp();
/*  74 */     p.roleid = roleId;
/*  75 */     p.boxindex2data.put(Integer.valueOf(boxIndex), fillBoxData(itemId, num, nowSecond));
/*  76 */     GangInterface.brocastInGang(p, gangId);
/*     */   }
/*     */   
/*     */   private static mzm.gsp.huanhun.BoxData fillBoxData(int itemId, int num, long nowSecond)
/*     */   {
/*  81 */     mzm.gsp.huanhun.BoxData boxData = new mzm.gsp.huanhun.BoxData();
/*  82 */     boxData.itemid = itemId;
/*  83 */     boxData.num = num;
/*  84 */     boxData.starttime = nowSecond;
/*  85 */     return boxData;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rmRoleGangHelp(long gangId, xbean.GangHelpInfo xHelpInfo, long roleId, Set<Integer> boxIndexs)
/*     */   {
/*  97 */     if (xHelpInfo == null)
/*     */     {
/*  99 */       GameServer.logger().error(String.format("[hun]GangHelpManager.rmRoleGangHelp@ xHelpInfo is null!|roleId=%d|boxIndexs=%s", new Object[] { Long.valueOf(roleId), boxIndexs.toString() }));
/*     */       
/*     */ 
/* 102 */       return;
/*     */     }
/* 104 */     HunGangHelpInfo helpInfo = new HunGangHelpInfo(xHelpInfo);
/* 105 */     if ((boxIndexs == null) || (boxIndexs.size() == 0))
/*     */     {
/* 107 */       boxIndexs = helpInfo.rmRoleHelp(roleId);
/*     */     }
/*     */     else
/*     */     {
/* 111 */       helpInfo.rmRoleHelp(roleId, boxIndexs);
/*     */     }
/* 113 */     rmRoleHelpNotice(gangId, roleId, boxIndexs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rmRoleGangHelp(long gangId, xbean.GangHelpInfo xHelpInfo, long roleId, int boxIndex)
/*     */   {
/* 125 */     Set<Integer> boxIndexs = new HashSet();
/* 126 */     boxIndexs.add(Integer.valueOf(boxIndex));
/* 127 */     rmRoleGangHelp(gangId, xHelpInfo, roleId, boxIndexs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void rmRoleHelpNotice(long gangId, long roleId, Set<Integer> boxIndexs)
/*     */   {
/* 139 */     if ((boxIndexs == null) || (boxIndexs.size() == 0))
/*     */     {
/* 141 */       return;
/*     */     }
/* 143 */     SRmGangHelp p = new SRmGangHelp();
/* 144 */     p.roleid = roleId;
/* 145 */     p.boxindexs.addAll(boxIndexs);
/* 146 */     GangInterface.brocastInGang(p, gangId);
/* 147 */     GameServer.logger().info(String.format("[hun]GangHelpManager.rmRoleHelpNotice@ rm help record!|roleId=%d|gangId=%d|boxIndexs", new Object[] { Long.valueOf(roleId), Long.valueOf(gangId), boxIndexs }));
/*     */   }
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
/*     */   static void fillGangHelpInfo(mzm.gsp.huanhun.GangHelpInfo pHelpInfo, xbean.GangHelpInfo xHelpInfo)
/*     */   {
/* 161 */     fillRole2helpData(xHelpInfo, pHelpInfo.role2helpdata);
/*     */   }
/*     */   
/*     */   private static void fillRole2helpData(xbean.GangHelpInfo xHelpInfo, Map<Long, mzm.gsp.huanhun.CallHelpData> role2helpData)
/*     */   {
/* 166 */     Iterator<Map.Entry<Long, xbean.CallHelpData>> it = xHelpInfo.getRole2helpdata().entrySet().iterator();
/* 167 */     if (it.hasNext())
/*     */     {
/* 169 */       Map.Entry<Long, xbean.CallHelpData> entry = (Map.Entry)it.next();
/* 170 */       long roleId = ((Long)entry.getKey()).longValue();
/* 171 */       xbean.CallHelpData xCallHelpData = (xbean.CallHelpData)entry.getValue();
/*     */       
/* 173 */       mzm.gsp.huanhun.CallHelpData pCallHelpData = new mzm.gsp.huanhun.CallHelpData();
/* 174 */       fillBoxIndex2Data(xCallHelpData, pCallHelpData.boxindex2data);
/*     */       
/* 176 */       role2helpData.put(Long.valueOf(roleId), pCallHelpData);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void fillBoxIndex2Data(xbean.CallHelpData xCallHelpData, Map<Integer, mzm.gsp.huanhun.BoxData> boxIndex2Data)
/*     */   {
/* 182 */     Iterator<Map.Entry<Integer, xbean.BoxData>> it = xCallHelpData.getBoxindex2data().entrySet().iterator();
/* 183 */     while (it.hasNext())
/*     */     {
/* 185 */       Map.Entry<Integer, xbean.BoxData> entry = (Map.Entry)it.next();
/* 186 */       int boxIndex = ((Integer)entry.getKey()).intValue();
/* 187 */       xbean.BoxData xBoxData = (xbean.BoxData)entry.getValue();
/*     */       
/* 189 */       mzm.gsp.huanhun.BoxData pBoxData = new mzm.gsp.huanhun.BoxData();
/* 190 */       pBoxData.itemid = xBoxData.getItemid();
/* 191 */       pBoxData.num = xBoxData.getNum();
/* 192 */       pBoxData.starttime = xBoxData.getStarttime();
/*     */       
/* 194 */       boxIndex2Data.put(Integer.valueOf(boxIndex), pBoxData);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\GangHelpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */