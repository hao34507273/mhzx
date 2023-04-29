/*     */ package mzm.gsp.award.gift;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.XAwardContent;
/*     */ import xbean.XAwardData;
/*     */ import xbean.XAwardInfo;
/*     */ 
/*     */ public class RoleGiftInfo
/*     */ {
/*     */   private final long roleId;
/*     */   private final boolean locked;
/*     */   private XAwardInfo xAwardInfo;
/*  13 */   public static int COMPLETE_CLIENT_AWARD = 1;
/*  14 */   static int TYPE_MIN = 1;
/*  15 */   static int TYPE_MAX = 1;
/*     */   
/*     */   public static final int SUC = 0;
/*     */   
/*     */   public static final int ERR_CODE__TYPE_ILLEGAL = -1;
/*     */   public static final int ERR_CODE__NOT_GETLOCK = -2;
/*     */   public static final int ERR_CODE__XGLOBAL_UP = -3;
/*     */   public static final int ERR_CODE__ALREADY_GET = -4;
/*     */   
/*     */   public RoleGiftInfo(long roleId, boolean remainRoleLock)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.locked = remainRoleLock;
/*  28 */     if (remainRoleLock)
/*     */     {
/*  30 */       this.xAwardInfo = xtable.Role2xawardinfo.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  34 */       this.xAwardInfo = xtable.Role2xawardinfo.select(Long.valueOf(roleId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   XAwardInfo getxAwardInfo()
/*     */   {
/*  45 */     return this.xAwardInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean hasXAwardInfo()
/*     */   {
/*  55 */     return getxAwardInfo() != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean createXAwardInfo()
/*     */   {
/*  67 */     this.xAwardInfo = xbean.Pod.newXAwardInfo();
/*  68 */     xtable.Role2xawardinfo.insert(Long.valueOf(this.roleId), this.xAwardInfo);
/*  69 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getAwardXIdNum(int type, int awardXId)
/*     */   {
/*  81 */     if (!isTypeLegal(type))
/*     */     {
/*  83 */       return -1;
/*     */     }
/*  85 */     if (this.xAwardInfo == null)
/*     */     {
/*  87 */       return 0;
/*     */     }
/*  89 */     XAwardContent xAwardContent = (XAwardContent)this.xAwardInfo.getType2awardcontent().get(Integer.valueOf(type));
/*  90 */     if (xAwardContent == null)
/*     */     {
/*  92 */       return 0;
/*     */     }
/*  94 */     Integer count = (Integer)xAwardContent.getXid2awardnum().get(Integer.valueOf(awardXId));
/*  95 */     return count == null ? 0 : count.intValue();
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
/*     */   int addAwardXIdNum(int type, int awardXId, int addNum)
/*     */   {
/* 108 */     if (!isTypeLegal(type))
/*     */     {
/* 110 */       return -1;
/*     */     }
/* 112 */     if (!this.locked)
/*     */     {
/* 114 */       return -2;
/*     */     }
/* 116 */     XAwardContent xAwardContent = (XAwardContent)this.xAwardInfo.getType2awardcontent().get(Integer.valueOf(type));
/* 117 */     if (xAwardContent == null)
/*     */     {
/* 119 */       xAwardContent = xbean.Pod.newXAwardContent();
/* 120 */       this.xAwardInfo.getType2awardcontent().put(Integer.valueOf(type), xAwardContent);
/*     */     }
/* 122 */     Integer oldCount = (Integer)xAwardContent.getXid2awardnum().get(Integer.valueOf(awardXId));
/* 123 */     int newCount = addNum;
/* 124 */     if (oldCount != null)
/*     */     {
/* 126 */       newCount += oldCount.intValue();
/*     */     }
/* 128 */     xAwardContent.getXid2awardnum().put(Integer.valueOf(awardXId), Integer.valueOf(newCount));
/* 129 */     return newCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int rmAwardXIdNum(int type, int awardXId)
/*     */   {
/* 141 */     if (!isTypeLegal(type))
/*     */     {
/* 143 */       return -1;
/*     */     }
/* 145 */     if (!this.locked)
/*     */     {
/* 147 */       return -2;
/*     */     }
/* 149 */     XAwardContent xAwardContent = (XAwardContent)this.xAwardInfo.getType2awardcontent().get(Integer.valueOf(type));
/* 150 */     if (xAwardContent == null)
/*     */     {
/* 152 */       return 0;
/*     */     }
/* 154 */     xAwardContent.getXid2awardnum().remove(Integer.valueOf(awardXId));
/* 155 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int rmAwardXIdNum(int type)
/*     */   {
/* 167 */     if (!isTypeLegal(type))
/*     */     {
/* 169 */       return -1;
/*     */     }
/* 171 */     if (!this.locked)
/*     */     {
/* 173 */       return -2;
/*     */     }
/* 175 */     XAwardContent xAwardContent = (XAwardContent)this.xAwardInfo.getType2awardcontent().get(Integer.valueOf(type));
/* 176 */     if (xAwardContent == null)
/*     */     {
/* 178 */       return 0;
/*     */     }
/* 180 */     xAwardContent.getXid2awardnum().clear();
/* 181 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int rmAll()
/*     */   {
/* 191 */     if (!this.locked)
/*     */     {
/* 193 */       return -2;
/*     */     }
/* 195 */     this.xAwardInfo.getType2awardcontent().clear();
/* 196 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isTypeLegal(int type)
/*     */   {
/* 207 */     if (type > TYPE_MAX)
/*     */     {
/* 209 */       return false;
/*     */     }
/* 211 */     if (type < TYPE_MIN)
/*     */     {
/* 213 */       return false;
/*     */     }
/* 215 */     return true;
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
/*     */ 
/*     */ 
/*     */   int addGiftCount(int useType, int xGlobal)
/*     */   {
/* 231 */     if (!this.locked)
/*     */     {
/* 233 */       return -2;
/*     */     }
/* 235 */     XAwardData xAwardData = (XAwardData)this.xAwardInfo.getType2awarddata().get(Integer.valueOf(useType));
/* 236 */     if (xAwardData == null)
/*     */     {
/* 238 */       xAwardData = xbean.Pod.newXAwardData();
/* 239 */       this.xAwardInfo.getType2awarddata().put(Integer.valueOf(useType), xAwardData);
/*     */     }
/*     */     
/* 242 */     int xAwardglobal = xAwardData.getAwardglobal();
/* 243 */     if (xAwardglobal > xGlobal)
/*     */     {
/* 245 */       mzm.gsp.GameServer.logger().error(String.format("[gift]RoleGiftInfo.addGiftCount@ role verson upper than global'!|roleId=%d|useType=%d|roleGlobal=%d|xGlobal=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(useType), Integer.valueOf(xAwardglobal), Integer.valueOf(xGlobal) }));
/*     */       
/*     */ 
/*     */ 
/* 249 */       return -3;
/*     */     }
/* 251 */     if (xAwardglobal == xGlobal)
/*     */     {
/* 253 */       if (xAwardData.getCount() >= GiftManager.awardCountMaxCfg(useType))
/*     */       {
/* 255 */         mzm.gsp.GameServer.logger().error(String.format("[gift]RoleGiftInfo.addGiftCount@ already get all!|roleId=%d|useType=%d|alreadGetCount=%d|max=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(useType), Integer.valueOf(xAwardData.getCount()), Integer.valueOf(GiftManager.awardCountMaxCfg(useType)) }));
/*     */         
/*     */ 
/*     */ 
/* 259 */         return -4;
/*     */       }
/*     */     }
/* 262 */     if (xAwardglobal < xGlobal)
/*     */     {
/* 264 */       xAwardData.setCount(0);
/*     */     }
/*     */     
/* 267 */     xAwardData.setAwardglobal(xGlobal);
/* 268 */     int oldCount = xAwardData.getCount();
/* 269 */     xAwardData.setCount(oldCount + 1);
/*     */     
/* 271 */     return xAwardData.getCount();
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
/*     */ 
/*     */   int rmRoleGiftData(int useType, int cfgGlobal, boolean addGlobal)
/*     */   {
/* 286 */     if (!this.locked)
/*     */     {
/* 288 */       return -2;
/*     */     }
/* 290 */     XAwardData xAwardData = (XAwardData)this.xAwardInfo.getType2awarddata().get(Integer.valueOf(useType));
/* 291 */     if (xAwardData == null)
/*     */     {
/* 293 */       return 0;
/*     */     }
/* 295 */     if (addGlobal)
/*     */     {
/* 297 */       xAwardData.setAwardglobal(cfgGlobal + 1);
/*     */     }
/*     */     else
/*     */     {
/* 301 */       xAwardData.setAwardglobal(cfgGlobal);
/*     */     }
/* 303 */     xAwardData.setCount(0);
/* 304 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getGiftAwardCount(int useType, int xGlobal)
/*     */   {
/* 316 */     XAwardData xAwardData = (XAwardData)this.xAwardInfo.getType2awarddata().get(Integer.valueOf(useType));
/* 317 */     if (xAwardData == null)
/*     */     {
/* 319 */       return 0;
/*     */     }
/* 321 */     int xRoleGlobal = xAwardData.getAwardglobal();
/* 322 */     if (xRoleGlobal < xGlobal)
/*     */     {
/* 324 */       return 0;
/*     */     }
/* 326 */     if (xRoleGlobal == xGlobal)
/*     */     {
/* 328 */       return xAwardData.getCount();
/*     */     }
/* 330 */     mzm.gsp.GameServer.logger().error(String.format("[gift]RoleGiftInfo.getGiftAwardCount@roleGlobal greater than xGlobal!|roleGlobal=%d|xGlobal=%d", new Object[] { Integer.valueOf(xRoleGlobal), Integer.valueOf(xGlobal) }));
/*     */     
/*     */ 
/* 333 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\RoleGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */