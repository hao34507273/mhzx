/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.blacklist.main.BlacklistInterface;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.item.SGiveFlowerRes;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SFlowerItem;
/*     */ import mzm.gsp.item.event.FlowerGivePointChangedArg;
/*     */ import mzm.gsp.item.event.FlowerGivePointChangedEvent;
/*     */ import mzm.gsp.item.event.FlowerReceivePointChangedArg;
/*     */ import mzm.gsp.item.event.FlowerReceivePointChangedEvent;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.SNSTYPE;
/*     */ import mzm.gsp.tlog.SnsFlowArg;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TlogUtil;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGiveFlower
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long receiverroleid;
/*     */   private int itemid;
/*     */   private int itemnum;
/*     */   private String message;
/*     */   
/*     */   public PGiveFlower(long roleid, long receiverroleid, int itemid, int itemnum, String message)
/*     */   {
/*  48 */     this.roleid = roleid;
/*  49 */     this.receiverroleid = receiverroleid;
/*  50 */     this.itemid = itemid;
/*  51 */     this.itemnum = itemnum;
/*  52 */     this.message = message;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  58 */     if (this.message == null)
/*     */     {
/*  60 */       this.message = "";
/*     */     }
/*  62 */     int len = this.message.length();
/*  63 */     if (len > ItemCfgConsts.getInstance().GIVE_FLOWER_MESSAGE_LENGTH)
/*     */     {
/*  65 */       String logStr = String.format("[item]PGiveFlower.processImp@message is too long|roleid=%d|length=%d|conflength=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(len), Integer.valueOf(ItemCfgConsts.getInstance().GIVE_FLOWER_MESSAGE_LENGTH) });
/*     */       
/*  67 */       ItemManager.logger.info(logStr);
/*  68 */       return false;
/*     */     }
/*  70 */     if (SensitiveInterface.isNameSensitive(this.message))
/*     */     {
/*  72 */       String logStr = String.format("[item]PGiveFlower.processImp@message is sensistive|roleid=%d|message=%s", new Object[] { Long.valueOf(this.roleid), this.message });
/*     */       
/*  74 */       ItemManager.logger.info(logStr);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*     */     
/*  80 */     if (this.roleid == this.receiverroleid)
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     if (!ItemModuleSwitchInterface.isGiveFlowerSwitchOpenForRole(this.roleid, this.receiverroleid))
/*     */     {
/*  86 */       return false;
/*     */     }
/*  88 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  90 */       String logStr = String.format("[item]PGiveFlower.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  91 */       ItemManager.logger.info(logStr);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.receiverroleid) }));
/*  96 */     String receiveUserid = RoleInterface.getUserId(this.receiverroleid);
/*  97 */     if (receiveUserid == null)
/*     */     {
/*  99 */       return false;
/*     */     }
/* 101 */     if (BlacklistInterface.isInBlacklist(this.receiverroleid, this.roleid))
/*     */     {
/* 103 */       ItemManager.sendWrongInfo(this.roleid, 732, new String[0]);
/* 104 */       return false;
/*     */     }
/* 106 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 108 */     int levelDelta = serverLevel - ItemCfgConsts.getInstance().GIVE_RECEIVE_FLOWER_LEVEL_DELTA;
/*     */     
/* 110 */     int hasnum = ItemInterface.getItemNumberById(this.roleid, this.itemid);
/* 111 */     if (hasnum < this.itemnum)
/*     */     {
/* 113 */       return false;
/*     */     }
/* 115 */     SFlowerItem flowerItem = SFlowerItem.get(this.itemid);
/* 116 */     if (flowerItem == null)
/*     */     {
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     int itemPrice = MallInterface.getItemPrice(this.itemid);
/* 122 */     boolean isYuanbaoFlower = itemPrice != -1;
/*     */     
/* 124 */     boolean canAddReceivePoint = false;
/* 125 */     boolean canAddGivePoint = false;
/* 126 */     if (isYuanbaoFlower)
/*     */     {
/* 128 */       canAddReceivePoint = true;
/* 129 */       canAddGivePoint = true;
/*     */     }
/*     */     else
/*     */     {
/* 133 */       canAddReceivePoint = roleLevel > levelDelta;
/* 134 */       canAddGivePoint = roleLevel > levelDelta;
/*     */     }
/*     */     
/* 137 */     int addnum = 0;
/* 138 */     int addPoint = flowerItem.rankPoint * this.itemnum;
/* 139 */     if (!IdipManager.isBanRank(this.roleid, 5))
/*     */     {
/*     */ 
/* 142 */       int addIntimacy = this.itemnum * flowerItem.addIntimacyNum;
/* 143 */       addnum = FriendInterface.addFriendValue(this.roleid, this.receiverroleid, addIntimacy, 2);
/*     */       
/* 145 */       String log = String.format("[item]PGiveFlower.processImp@role add friend value point|roleid=%d|receiveRoleid=%d|addIntimacy=%d|itemid=%d|itemnum=%d|desaddnum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.receiverroleid), Integer.valueOf(this.itemnum * flowerItem.addIntimacyNum), Integer.valueOf(this.itemid), Integer.valueOf(this.itemnum), Integer.valueOf(addnum) });
/*     */       
/*     */ 
/* 148 */       ItemManager.logger.info(log);
/*     */       
/* 150 */       if (canAddGivePoint)
/*     */       {
/* 152 */         ItemGiveManager.addGiveFlowerPoint(this.roleid, addPoint);
/*     */       }
/*     */       else
/*     */       {
/* 156 */         String logstr = String.format("[item]PGiveFlower.processImp@role can not add give point|roleid=%d|receiveRoleid=%d|addIntimacy=%d|itemid=%d|itemnum=%d|canAddGivePoint=%b", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.receiverroleid), Integer.valueOf(this.itemnum * flowerItem.addIntimacyNum), Integer.valueOf(this.itemid), Integer.valueOf(this.itemnum), Boolean.valueOf(canAddGivePoint) });
/*     */         
/*     */ 
/* 159 */         ItemManager.logger.info(logstr);
/*     */       }
/*     */       
/* 162 */       if ((!IdipManager.isBanRank(this.receiverroleid, 6)) && (canAddReceivePoint))
/*     */       {
/* 164 */         ItemGiveManager.addReceiveFlowerPoint(this.receiverroleid, addPoint);
/*     */       }
/*     */       else
/*     */       {
/* 168 */         String logstr = String.format("[item]PGiveFlower.processImp@role is is ban receive flower rank state|roleid=%d|receiveRoleid=%d|addIntimacy=%d|itemid=%d|itemnum=%d|canAddReceivePoint=%b", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.receiverroleid), Integer.valueOf(this.itemnum * flowerItem.addIntimacyNum), Integer.valueOf(this.itemid), Integer.valueOf(this.itemnum), Boolean.valueOf(canAddReceivePoint) });
/*     */         
/*     */ 
/*     */ 
/* 172 */         ItemManager.logger.info(logstr);
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 178 */       String logstr = String.format("[item]PGiveFlower.processImp@role is is ban rank state|roleid=%d|receiveRoleid=%d|addIntimacy=%d|itemid=%d|itemnum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.receiverroleid), Integer.valueOf(this.itemnum * flowerItem.addIntimacyNum), Integer.valueOf(this.itemid), Integer.valueOf(this.itemnum) });
/*     */       
/*     */ 
/*     */ 
/* 182 */       ItemManager.logger.info(logstr);
/*     */     }
/*     */     
/* 185 */     TLogArg logArg = new TLogArg(LogReason.ITEM_GIVE_FLOWER_REM, this.itemid);
/* 186 */     boolean ret = ItemInterface.removeItemById(this.roleid, 340600000, this.itemid, this.itemnum, logArg);
/* 187 */     if (!ret)
/*     */     {
/* 189 */       return false;
/*     */     }
/* 191 */     SGiveFlowerRes giveFlowerRes = new SGiveFlowerRes();
/* 192 */     giveFlowerRes.giverroleid = this.roleid;
/* 193 */     giveFlowerRes.giverrolename = RoleInterface.getName(this.roleid);
/* 194 */     giveFlowerRes.receiverroleid = this.receiverroleid;
/* 195 */     giveFlowerRes.receiverrolename = RoleInterface.getName(this.receiverroleid);
/* 196 */     giveFlowerRes.itemid = this.itemid;
/* 197 */     giveFlowerRes.itemnum = this.itemnum;
/* 198 */     giveFlowerRes.addintimacynum = addnum;
/* 199 */     giveFlowerRes.effectid = flowerItem.effectid;
/* 200 */     giveFlowerRes.message = (this.message + "");
/* 201 */     giveFlowerRes.isall = (flowerItem.isservereffect ? 1 : 0);
/* 202 */     giveFlowerRes.isbulletin = (flowerItem.isbulletin ? 1 : 0);
/* 203 */     if (flowerItem.isservereffect)
/*     */     {
/* 205 */       OnlineManager.getInstance().sendAll(giveFlowerRes);
/*     */     }
/*     */     else
/*     */     {
/* 209 */       OnlineManager.getInstance().send(this.roleid, giveFlowerRes);
/* 210 */       OnlineManager.getInstance().send(this.receiverroleid, giveFlowerRes);
/*     */     }
/*     */     
/* 213 */     if (flowerItem.isbulletin)
/*     */     {
/* 215 */       SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 216 */       bulletinInfo.bulletintype = 18;
/* 217 */       bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleid));
/* 218 */       bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(this.itemid));
/* 219 */       bulletinInfo.params.put(Integer.valueOf(15), String.valueOf(this.itemnum));
/* 220 */       bulletinInfo.params.put(Integer.valueOf(2), RoleInterface.getName(this.receiverroleid));
/* 221 */       BulletinInterface.sendBulletin(bulletinInfo);
/*     */     }
/* 223 */     ItemGiveManager.asynRankGiveFlower(this.roleid);
/* 224 */     ItemGiveManager.asynRankReceiveFlower(this.receiverroleid);
/* 225 */     TlogUtil.tlogSnsFlow(this.roleid, 1, this.itemnum, new SnsFlowArg(SNSTYPE.SNSTYPE_SENDHEART, this.itemid));
/* 226 */     TlogUtil.tlogSnsFlow(this.receiverroleid, 1, this.itemnum, new SnsFlowArg(SNSTYPE.SNSTYPE_RECEIVEHEART, this.itemid));
/*     */     
/* 228 */     int newgive = ItemGiveManager.getGiveFlowerPoint(this.roleid);
/* 229 */     int newReceive = ItemGiveManager.getReceiveFlowerPoint(this.receiverroleid);
/*     */     
/* 231 */     long nextStartTime = TimeCommonUtil.getNextStartTime(DateTimeUtils.getCurrTimeInMillis(), ItemCfgConsts.getInstance().FLOWER_POINT_CLEAR_TIME);
/*     */     
/*     */ 
/* 234 */     int totalGivePoint = ItemGiveManager.getTotalGiveFlowerPoint(this.roleid, true);
/* 235 */     TriggerEventsManger.getInstance().triggerEvent(new FlowerGivePointChangedEvent(), new FlowerGivePointChangedArg(this.roleid, newgive, nextStartTime, addPoint, totalGivePoint));
/*     */     
/*     */ 
/* 238 */     int totalReceivePoint = ItemGiveManager.getTotalReceiveFlowerPoint(this.receiverroleid, true);
/* 239 */     TriggerEventsManger.getInstance().triggerEvent(new FlowerReceivePointChangedEvent(), new FlowerReceivePointChangedArg(this.receiverroleid, newReceive, nextStartTime, addPoint, totalReceivePoint));
/*     */     
/*     */ 
/* 242 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGiveFlower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */