/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.genius.confbean.SGeniusConst;
/*     */ import mzm.gsp.genius.main.GeniusInterface;
/*     */ import mzm.gsp.item.SUseGeniusStoneItemSuccess;
/*     */ import mzm.gsp.item.confbean.SGeniusStoneItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SUseAllItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GeniusInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUseGeniusStoneItem extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   private final boolean useAll;
/*     */   
/*     */   public PCUseGeniusStoneItem(long roleid, long uuid, boolean useAll)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.uuid = uuid;
/*  33 */     this.useAll = useAll;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (this.uuid <= 0L)
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1075, true))
/*     */     {
/*  46 */       GameServer.logger().info(String.format("[item]PCUseGeniusStoneItem.checkRoleStatus@status check failed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!GeniusInterface.isFunOpen(this.roleid))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String userid = RoleInterface.getUserId(this.roleid);
/*  57 */     if (userid == null)
/*     */     {
/*  59 */       GameServer.logger().info(String.format("[item]PCUseGeniusStoneItem.processImp@userid is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     int level = RoleInterface.getLevel(this.roleid);
/*  65 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  67 */       ItemManager.sendWrongInfo(this.roleid, 1191, new String[0]);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     lock(Lockeys.get(User.getTable(), userid));
/*  73 */     GeniusInfo xGeniusInfo = GeniusInterface.getAndInitGeniusInfo(this.roleid);
/*     */     
/*  75 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  76 */     if (item == null)
/*     */     {
/*  78 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     SItemCfg itemCfg = SItemCfg.get(item.getCfgId());
/*  83 */     if ((itemCfg == null) || (itemCfg.type != 120))
/*     */     {
/*  85 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     SGeniusStoneItemCfg geniusStoneItemCfg = SGeniusStoneItemCfg.get(itemCfg.id);
/*  91 */     if (geniusStoneItemCfg == null)
/*     */     {
/*  93 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     if (geniusStoneItemCfg.useLevel > level)
/*     */     {
/* 100 */       ItemManager.sendWrongInfo(this.roleid, 1190, new String[0]);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (this.useAll)
/*     */     {
/* 106 */       return useAllItem(xGeniusInfo, geniusStoneItemCfg, item);
/*     */     }
/*     */     
/*     */ 
/* 110 */     return useSignleItem(xGeniusInfo, geniusStoneItemCfg);
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean useSignleItem(GeniusInfo xGeniusInfo, SGeniusStoneItemCfg geniusStoneItemCfg)
/*     */   {
/* 116 */     int maxExtraPoint = GeniusInterface.getMaxExtraPoint();
/* 117 */     int oldExtraPoint = xGeniusInfo.getExtra_point();
/* 118 */     int addGeniusPoint = geniusStoneItemCfg.addGeniusPoint;
/* 119 */     int endExtraPoint = oldExtraPoint + addGeniusPoint;
/* 120 */     if (endExtraPoint > maxExtraPoint)
/*     */     {
/* 122 */       ItemManager.sendWrongInfo(this.roleid, 1192, new String[0]);
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     LogReason logReason = LogReason.USE_GENIUS_STONE_ITEM;
/* 128 */     int itemCfgid = geniusStoneItemCfg.id;
/* 129 */     TLogArg tLogArg = new TLogArg(logReason, itemCfgid);
/* 130 */     if (!ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, tLogArg))
/*     */     {
/* 132 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 133 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 137 */     xGeniusInfo.setExtra_point(endExtraPoint);
/*     */     
/*     */ 
/* 140 */     addTLog(this.roleid, "UseItemAddGeniusForServer", new Object[] { Integer.valueOf(oldExtraPoint), Integer.valueOf(itemCfgid), Integer.valueOf(addGeniusPoint), Integer.valueOf(1), Integer.valueOf(endExtraPoint) });
/*     */     
/*     */ 
/* 143 */     GeniusInterface.syncExtraPoint(this.roleid, endExtraPoint, false);
/*     */     
/* 145 */     sendResponse(itemCfgid, 1);
/* 146 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean useAllItem(GeniusInfo xGeniusInfo, SGeniusStoneItemCfg geniusStoneItemCfg, BasicItem item)
/*     */   {
/* 152 */     int itemCfgid = geniusStoneItemCfg.id;
/* 153 */     if (SUseAllItemCfg.get(itemCfgid) == null)
/*     */     {
/* 155 */       String logStr = String.format("[item]PCUseGeniusStoneItem.useAllItem@use all item cfg is null|roleid=%d|uuid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemCfgid) });
/*     */       
/*     */ 
/* 158 */       ItemManager.logger.error(logStr);
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     int uuidHasNum = item.getNumber();
/* 163 */     int totalNum = ItemInterface.getItemNumberById(this.roleid, itemCfgid);
/* 164 */     if (totalNum < uuidHasNum)
/*     */     {
/* 166 */       String logStr = String.format("[item]PCUseGeniusStoneItem.useAllItem@item num error|roleid=%d|uuid=%d|itemid=%d|total_num=%d|grid_has_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemCfgid), Integer.valueOf(totalNum), Integer.valueOf(uuidHasNum) });
/*     */       
/*     */ 
/* 169 */       ItemManager.logger.error(logStr);
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     int maxExtraPoint = GeniusInterface.getMaxExtraPoint();
/* 174 */     int oldExtraPoint = xGeniusInfo.getExtra_point();
/* 175 */     int addGeniusPoint = geniusStoneItemCfg.addGeniusPoint;
/* 176 */     int needItemNum = (maxExtraPoint - oldExtraPoint) / addGeniusPoint;
/* 177 */     if (needItemNum <= 0)
/*     */     {
/* 179 */       ItemManager.sendWrongInfo(this.roleid, 1192, new String[0]);
/* 180 */       return false;
/*     */     }
/*     */     
/* 183 */     if (needItemNum > uuidHasNum)
/*     */     {
/* 185 */       needItemNum = uuidHasNum;
/*     */     }
/*     */     
/*     */ 
/* 189 */     LogReason logReason = LogReason.USE_GENIUS_STONE_ITEM;
/* 190 */     TLogArg tLogArg = new TLogArg(logReason, itemCfgid);
/* 191 */     if (!ItemInterface.removeItemByUuid(this.roleid, this.uuid, needItemNum, tLogArg))
/*     */     {
/* 193 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 194 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 198 */     int endExtraPoint = oldExtraPoint + addGeniusPoint * needItemNum;
/* 199 */     xGeniusInfo.setExtra_point(endExtraPoint);
/*     */     
/*     */ 
/* 202 */     addTLog(this.roleid, "UseItemAddGeniusForServer", new Object[] { Integer.valueOf(oldExtraPoint), Integer.valueOf(itemCfgid), Integer.valueOf(addGeniusPoint), Integer.valueOf(needItemNum), Integer.valueOf(endExtraPoint) });
/*     */     
/*     */ 
/* 205 */     GeniusInterface.syncExtraPoint(this.roleid, endExtraPoint, false);
/*     */     
/* 207 */     sendResponse(itemCfgid, needItemNum);
/* 208 */     return true;
/*     */   }
/*     */   
/*     */   private void sendResponse(int itemCfgid, int usedNum)
/*     */   {
/* 213 */     SUseGeniusStoneItemSuccess msg = new SUseGeniusStoneItemSuccess();
/* 214 */     msg.item_cfgid = itemCfgid;
/* 215 */     msg.used_num = usedNum;
/* 216 */     OnlineManager.getInstance().send(this.roleid, msg);
/*     */   }
/*     */   
/*     */   private void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 221 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 222 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 223 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 225 */     StringBuilder logStr = new StringBuilder();
/* 226 */     logStr.append(vGameIp);
/* 227 */     logStr.append("|").append(userid);
/* 228 */     logStr.append("|").append(roleid);
/* 229 */     logStr.append("|").append(roleLevel);
/*     */     
/* 231 */     for (Object colum : logColumns)
/*     */     {
/* 233 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 236 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCUseGeniusStoneItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */