/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.blacklist.main.BlacklistInterface;
/*     */ import mzm.gsp.item.SGiveItemCountChangeInfo;
/*     */ import mzm.gsp.item.SGiveItemSuccess;
/*     */ import mzm.gsp.item.SGiveYuanbaoCountChangeInfo;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SNoProprietaryAndTypeCanGiveButForbidGiveItemCfg;
/*     */ import mzm.gsp.item.event.GiveItem;
/*     */ import mzm.gsp.item.event.GiveItemArg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGiveItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long receiveRoleid;
/*     */   private Map<Long, Integer> uuid2num;
/*     */   
/*     */   public PGiveItem(long roleid, long receiveRoleid, Map<Long, Integer> uuid2num)
/*     */   {
/*  53 */     this.roleid = roleid;
/*  54 */     this.receiveRoleid = receiveRoleid;
/*  55 */     this.uuid2num = uuid2num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  61 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     if (this.receiveRoleid == this.roleid)
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     if (!ItemModuleSwitchInterface.isGiveItemSwitchOpenForRole(this.roleid, this.receiveRoleid))
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  75 */       String logStr = String.format("[item]PGiveItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  76 */       ItemManager.logger.info(logStr);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     String receiveUserid = RoleInterface.getUserId(this.receiveRoleid);
/*  81 */     if (receiveUserid == null)
/*     */     {
/*  83 */       return false;
/*     */     }
/*  85 */     int r2 = RoleInterface.getLevel(this.receiveRoleid);
/*     */     
/*  87 */     if (BlacklistInterface.isInBlacklist(this.receiveRoleid, this.roleid))
/*     */     {
/*  89 */       ItemManager.sendWrongInfo(this.roleid, 732, new String[0]);
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     String userid = RoleInterface.getUserId(this.roleid);
/*  95 */     lock(Lockeys.get(User.getTable(), userid));
/*  96 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.receiveRoleid) }));
/*  97 */     int r1 = RoleInterface.getLevel(this.roleid);
/*     */     
/*  99 */     Set<Long> mallItemUuids = new HashSet();
/* 100 */     long mallItemPrice = 0L;
/* 101 */     int itemmun = 0;
/* 102 */     Map<Integer, Integer> itemid2num = new HashMap();
/*     */     
/* 104 */     for (Long uuid : this.uuid2num.keySet())
/*     */     {
/* 106 */       BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, uuid.longValue());
/* 107 */       if (basicItem == null)
/*     */       {
/* 109 */         ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 110 */         return false;
/*     */       }
/* 112 */       if (basicItem.checkState(1))
/*     */       {
/* 114 */         ItemManager.sendWrongInfo(this.roleid, 104, new String[0]);
/* 115 */         return false;
/*     */       }
/*     */       
/* 118 */       int itemCfgId = basicItem.getCfgId();
/*     */       
/* 120 */       if (!ItemConfigManager.isCanGive(itemCfgId))
/*     */       {
/* 122 */         ItemManager.sendWrongInfo(this.roleid, 105, new String[0]);
/* 123 */         return false;
/*     */       }
/*     */       
/* 126 */       if (ItemConfigManager.isProprietary(itemCfgId))
/*     */       {
/* 128 */         ItemManager.sendWrongInfo(this.roleid, 106, new String[0]);
/* 129 */         return false;
/*     */       }
/*     */       
/* 132 */       if (SNoProprietaryAndTypeCanGiveButForbidGiveItemCfg.get(itemCfgId) != null)
/*     */       {
/* 134 */         ItemManager.sendWrongInfo(this.roleid, 105, new String[0]);
/* 135 */         return false;
/*     */       }
/*     */       
/* 138 */       if (basicItem.isItemFromShanghui())
/*     */       {
/* 140 */         return false;
/*     */       }
/* 142 */       int price = MallInterface.getItemPrice(basicItem.getCfgId());
/* 143 */       if (price == -1)
/*     */       {
/* 145 */         itemmun += ((Integer)this.uuid2num.get(uuid)).intValue();
/*     */       }
/*     */       else
/*     */       {
/* 149 */         mallItemPrice += price * ((Integer)this.uuid2num.get(uuid)).intValue();
/* 150 */         mallItemUuids.add(uuid);
/*     */       }
/*     */       
/* 153 */       if (itemid2num.get(Integer.valueOf(basicItem.getCfgId())) == null)
/*     */       {
/* 155 */         itemid2num.put(Integer.valueOf(basicItem.getCfgId()), this.uuid2num.get(uuid));
/*     */       }
/*     */       else
/*     */       {
/* 159 */         itemid2num.put(Integer.valueOf(basicItem.getCfgId()), Integer.valueOf(((Integer)itemid2num.get(Integer.valueOf(basicItem.getCfgId()))).intValue() + ((Integer)this.uuid2num.get(uuid)).intValue()));
/*     */       }
/*     */     }
/* 162 */     int giveItemcount = ItemGiveManager.getGiveItemCount(this.roleid, this.receiveRoleid);
/*     */     
/* 164 */     int maxGiveItemcount = ItemGiveManager.getMaxGiveItemCount(r1 - r2);
/* 165 */     if (giveItemcount + itemmun > maxGiveItemcount)
/*     */     {
/* 167 */       ItemManager.sendWrongInfo(this.roleid, 730, new String[0]);
/* 168 */       return false;
/*     */     }
/* 170 */     long cumYuanbao = QingfuInterface.getTotalCash(userid, true);
/* 171 */     long maxGiveYuanbaoNum = ItemGiveManager.getMaxGiveYuanbaoCount(cumYuanbao);
/* 172 */     long hasGiveYuanbao = ItemGiveManager.getGiveYuanbaoCount(this.roleid, this.receiveRoleid);
/* 173 */     if (mallItemPrice + hasGiveYuanbao > maxGiveYuanbaoNum)
/*     */     {
/* 175 */       ItemManager.sendWrongInfo(this.roleid, 731, new String[0]);
/* 176 */       return false;
/*     */     }
/* 178 */     TLogArg logArg = new TLogArg(LogReason.ITEM_GIVE);
/* 179 */     ItemOperateResult result = ItemInterface.removeItemByUuid(this.roleid, this.uuid2num, logArg);
/*     */     
/* 181 */     if (!result.success())
/*     */     {
/* 183 */       ItemManager.sendWrongInfo(this.roleid, 100, new String[0]);
/* 184 */       return false;
/*     */     }
/* 186 */     List<Item> xItemList = new ArrayList();
/* 187 */     for (ItemOperateResult.ChangeItemInfo c : result.getChangeItemInfoList())
/*     */     {
/* 189 */       c.basicItem.setState(1);
/* 190 */       xItemList.add(c.basicItem.getItem());
/*     */     }
/*     */     
/* 193 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/*     */     
/* 195 */     mailAttachment.addXItem(xItemList);
/*     */     
/* 197 */     List<String> titleArgs = new ArrayList();
/* 198 */     String rolename = RoleInterface.getName(this.roleid);
/* 199 */     titleArgs.add(rolename);
/*     */     
/* 201 */     List<String> contentArgs = new ArrayList();
/* 202 */     contentArgs.add(rolename);
/* 203 */     StringBuffer sb = new StringBuffer();
/* 204 */     for (Iterator i$ = itemid2num.keySet().iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */       
/* 206 */       sb.append(ItemConfigManager.getItemName(itemid) + "*" + itemid2num.get(Integer.valueOf(itemid)) + "、");
/*     */     }
/* 208 */     contentArgs.add(sb.substring(0, sb.length() - 1));
/*     */     
/* 210 */     SendMailRet sendMailRes = MailInterface.synBuildAndSendMail(this.receiveRoleid, ItemCfgConsts.getInstance().GIVE_ITEM_MAIL_ID, titleArgs, contentArgs, mailAttachment, logArg);
/*     */     
/* 212 */     if (!sendMailRes.isOK())
/*     */     {
/* 214 */       return false;
/*     */     }
/* 216 */     if (itemmun > 0)
/*     */     {
/* 218 */       boolean ret = ItemGiveManager.addGiveItemCount(this.roleid, this.receiveRoleid, itemmun);
/* 219 */       if (!ret)
/*     */       {
/* 221 */         return false;
/*     */       }
/* 223 */       SGiveItemCountChangeInfo c = new SGiveItemCountChangeInfo();
/* 224 */       c.roleid = this.receiveRoleid;
/* 225 */       c.count = ItemGiveManager.getGiveItemCount(this.roleid, this.receiveRoleid);
/* 226 */       OnlineManager.getInstance().send(this.roleid, c);
/*     */     }
/* 228 */     if (mallItemPrice > 0L)
/*     */     {
/* 230 */       boolean ret = ItemGiveManager.addGiveYuanbaoCount(this.roleid, this.receiveRoleid, mallItemPrice);
/* 231 */       if (!ret)
/*     */       {
/* 233 */         return false;
/*     */       }
/* 235 */       SGiveYuanbaoCountChangeInfo c = new SGiveYuanbaoCountChangeInfo();
/* 236 */       c.roleid = this.receiveRoleid;
/* 237 */       c.count = ItemGiveManager.getGiveYuanbaoCount(this.roleid, this.receiveRoleid);
/* 238 */       OnlineManager.getInstance().send(this.roleid, c);
/*     */     }
/* 240 */     SGiveItemSuccess res = new SGiveItemSuccess();
/* 241 */     res.roleid = this.receiveRoleid;
/* 242 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 244 */     TriggerEventsManger.getInstance().triggerEvent(new GiveItem(), new GiveItemArg(this.roleid, this.receiveRoleid, itemid2num), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/* 248 */     Map<Integer, Set<Long>> itemId2Uuids = new HashMap();
/* 249 */     for (Item xItem : xItemList)
/*     */     {
/* 251 */       Set<Long> uuids = (Set)itemId2Uuids.get(Integer.valueOf(xItem.getCfgid()));
/* 252 */       if (uuids == null)
/*     */       {
/* 254 */         uuids = new HashSet();
/* 255 */         itemId2Uuids.put(Integer.valueOf(xItem.getCfgid()), uuids);
/*     */       }
/* 257 */       uuids.addAll(xItem.getUuid());
/*     */     }
/* 259 */     ItemGiveManager.tlogGiveItemForIdip(this.roleid, this.receiveRoleid, itemId2Uuids);
/* 260 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGiveItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */