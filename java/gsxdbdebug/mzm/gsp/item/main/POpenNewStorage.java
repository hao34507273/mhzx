/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.bag.confbean.SStorageCfg;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.SOpenNewStorageRes;
/*     */ import mzm.gsp.item.event.OpenNewStorage;
/*     */ import mzm.gsp.item.event.OpenNewStorageArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POpenNewStorage
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long clientmoneynum;
/*     */   
/*     */   public POpenNewStorage(long roleid, long clientmoneynum)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.clientmoneynum = clientmoneynum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!ItemModuleSwitchInterface.isOpenNewStorageSwitchOpenForRole(this.roleid))
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  43 */       String logStr = String.format("[item]POpenNewStorage.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  44 */       ItemManager.logger.info(logStr);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     String userid = RoleInterface.getUserId(this.roleid);
/*  49 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  51 */     int size = ItemManager.getAllRoleStorageBags(this.roleid, true).size();
/*  52 */     int storageid = ItemConfigManager.getStorageid(size);
/*     */     
/*  54 */     if (storageid == -1)
/*     */     {
/*  56 */       ItemManager.sendWrongInfo(this.roleid, 1000, new String[0]);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     SStorageCfg mt = SStorageCfg.get(storageid);
/*  62 */     TLogArg logArg = new TLogArg(LogReason.ITEM_EXPEND_STORAGE_REM);
/*  63 */     switch (mt.moneytype)
/*     */     {
/*     */     case 3: 
/*  66 */       long hasSilver = RoleInterface.getSilver(this.roleid);
/*  67 */       if (hasSilver != this.clientmoneynum)
/*     */       {
/*  69 */         return false;
/*     */       }
/*  71 */       if (mt.num > hasSilver)
/*     */       {
/*  73 */         ItemManager.sendWrongInfo(this.roleid, 1001, new String[0]);
/*  74 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  78 */       RoleInterface.cutSilver(this.roleid, mt.num, logArg);
/*     */       
/*  80 */       break;
/*     */     case 2: 
/*  82 */       long hasGold = RoleInterface.getGold(this.roleid);
/*  83 */       if (hasGold != this.clientmoneynum)
/*     */       {
/*  85 */         return false;
/*     */       }
/*  87 */       if (mt.num > hasGold)
/*     */       {
/*  89 */         ItemManager.sendWrongInfo(this.roleid, 1001, new String[0]);
/*  90 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  94 */       RoleInterface.cutGold(this.roleid, mt.num, logArg);
/*     */       
/*  96 */       break;
/*     */     case 1: 
/*  98 */       long hasyuanbao = QingfuInterface.getBalance(userid, true);
/*     */       
/* 100 */       if (hasyuanbao != this.clientmoneynum)
/*     */       {
/* 102 */         return false;
/*     */       }
/* 104 */       if (mt.num > hasyuanbao)
/*     */       {
/* 106 */         ItemManager.sendWrongInfo(this.roleid, 1001, new String[0]);
/* 107 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 111 */       QingfuInterface.costYuanbao(userid, this.roleid, mt.num, CostType.COST_BIND_FIRST_ITEM_OPEN_NEW_STORAGE, logArg);
/*     */       
/*     */ 
/* 114 */       break;
/*     */     case 4: 
/* 116 */       long hasbang = GangInterface.getBangGong(this.roleid);
/* 117 */       if (hasbang != this.clientmoneynum)
/*     */       {
/* 119 */         return false;
/*     */       }
/*     */       
/* 122 */       if (mt.num > hasbang)
/*     */       {
/* 124 */         ItemManager.sendWrongInfo(this.roleid, 1001, new String[0]);
/* 125 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 130 */       GangInterface.cutBangGong(this.roleid, mt.num, logArg);
/*     */       
/*     */ 
/* 133 */       break;
/*     */     default: 
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     boolean ret = ItemManager.createRoleStorageBag(this.roleid, storageid);
/* 139 */     if (ret)
/*     */     {
/* 141 */       SOpenNewStorageRes res = new SOpenNewStorageRes();
/* 142 */       res.capacity = mt.initcapacity;
/* 143 */       res.name = mt.name;
/* 144 */       res.storageid = storageid;
/* 145 */       OnlineManager.getInstance().send(this.roleid, res);
/*     */       
/* 147 */       TriggerEventsManger.getInstance().triggerEvent(new OpenNewStorage(), new OpenNewStorageArg(this.roleid, size), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       
/*     */ 
/* 150 */       String logString = String.format("[item]POpenNewStorage.processImp@role open new storage|roleid=%d|storageid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(storageid) });
/*     */       
/* 152 */       ItemManager.logger.info(logString);
/*     */     }
/* 154 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POpenNewStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */