/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.feisheng.main.FeiShengInterface;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.occupation.confbean.SRoleLevelFlyCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleAddExp
/*     */ {
/*     */   private final long roleId;
/*     */   private final Occupation occupation;
/*     */   private final int orgAddValue;
/*     */   private int roleMaxLvInCfg;
/*     */   private int roleMaxLvInSer;
/*     */   private int orgLevel;
/*     */   private int finalLevel;
/*     */   private int needConvertXiuExp;
/*     */   private int realAddExp;
/*     */   private int expShowValue;
/*     */   private boolean suc;
/*  28 */   private boolean debug_can_fly = false;
/*     */   
/*     */   private boolean isCalRelease;
/*     */   
/*  32 */   private int releasedExp = 0;
/*     */   
/*     */   public RoleAddExp(long roleId, Occupation occupation, Properties xProperties, int addValue)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.occupation = occupation;
/*  38 */     this.orgAddValue = addValue;
/*     */     
/*  40 */     this.realAddExp = this.orgAddValue;
/*  41 */     this.expShowValue = xProperties.getExp();
/*     */     
/*  43 */     this.orgLevel = xProperties.getLevel();
/*  44 */     this.finalLevel = this.orgLevel;
/*     */     
/*  46 */     this.roleMaxLvInCfg = occupation.getMaxLevel();
/*  47 */     this.roleMaxLvInSer = (ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL);
/*     */   }
/*     */   
/*     */ 
/*     */   public RoleAddExp(long roleId, Occupation occupation, int expShowValue, int orgLevel, int addValue)
/*     */   {
/*  53 */     this.roleId = roleId;
/*  54 */     this.occupation = occupation;
/*  55 */     this.orgAddValue = addValue;
/*     */     
/*  57 */     this.realAddExp = this.orgAddValue;
/*  58 */     this.expShowValue = expShowValue;
/*     */     
/*  60 */     this.orgLevel = orgLevel;
/*  61 */     this.finalLevel = orgLevel;
/*     */     
/*  63 */     this.roleMaxLvInCfg = occupation.getMaxLevel();
/*  64 */     this.roleMaxLvInSer = (ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void calAddExpValue()
/*     */   {
/*  75 */     if (this.orgAddValue < 0)
/*     */     {
/*  77 */       this.suc = false;
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     int leftAddValue = this.orgAddValue;
/*  82 */     int tmpLevel = this.orgLevel;
/*     */     
/*     */     for (;;)
/*     */     {
/*  86 */       this.finalLevel = tmpLevel;
/*     */       
/*     */ 
/*  89 */       if (canAddXiuExp(this.finalLevel))
/*     */       {
/*  91 */         this.realAddExp -= leftAddValue;
/*  92 */         this.needConvertXiuExp += leftAddValue;
/*  93 */         break;
/*     */       }
/*     */       
/*  96 */       int totalLevelUpExp = this.occupation.getToNextLevelNeedExp(tmpLevel);
/*  97 */       int needLevelUpExp = totalLevelUpExp - this.expShowValue;
/*  98 */       if (needLevelUpExp >= leftAddValue)
/*     */       {
/* 100 */         this.expShowValue += leftAddValue;
/* 101 */         break;
/*     */       }
/*     */       
/*     */ 
/* 105 */       tmpLevel++;
/* 106 */       if (this.expShowValue <= totalLevelUpExp)
/*     */       {
/* 108 */         leftAddValue -= needLevelUpExp;
/* 109 */         this.expShowValue = totalLevelUpExp;
/*     */       }
/*     */       
/* 112 */       Pair<Boolean, Boolean> res = reachMaxLevelAndDoAction(leftAddValue, tmpLevel);
/* 113 */       if (((Boolean)res.first).booleanValue()) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/* 118 */       if (!((Boolean)res.second).booleanValue())
/*     */       {
/*     */ 
/* 121 */         this.suc = false;
/* 122 */         return;
/*     */       }
/* 124 */       if (this.expShowValue > totalLevelUpExp)
/*     */       {
/*     */ 
/* 127 */         this.releasedExp = (this.expShowValue - totalLevelUpExp);
/* 128 */         leftAddValue += this.releasedExp;
/*     */       }
/*     */       
/* 131 */       this.expShowValue = 0;
/*     */     }
/* 133 */     this.suc = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Pair<Boolean, Boolean> reachMaxLevelAndDoAction(int leftAddValue, int tmpLevel)
/*     */   {
/* 145 */     Pair<Boolean, Boolean> res = new Pair(Boolean.valueOf(false), Boolean.valueOf(true));
/* 146 */     if (!needStorageExp(tmpLevel))
/*     */     {
/* 148 */       return res;
/*     */     }
/* 150 */     if (isCalRelease())
/*     */     {
/*     */ 
/* 153 */       GameServer.logger().error(String.format("[role]RoleAddExp.reachMaxLevelAndDoAction@ releasing exp, but steal storage exp!|roleId=%d|finalLevel=%d|leftAddValue=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.finalLevel), Integer.valueOf(leftAddValue) }));
/*     */       
/*     */ 
/*     */ 
/* 157 */       res.second = Boolean.valueOf(false);
/* 158 */       return res;
/*     */     }
/* 160 */     SRoleLevelFlyCfg cfg = SRoleLevelFlyCfg.get(this.finalLevel);
/* 161 */     if (cfg == null)
/*     */     {
/* 163 */       GameServer.logger().error(String.format("[role]RoleAddExp.reachMaxLevelAndDoAction@ SRoleLevelFlyCfg is null!|roleId=%d|finalLevel=%d|leftAddValue=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.finalLevel), Integer.valueOf(leftAddValue) }));
/*     */       
/*     */ 
/*     */ 
/* 167 */       res.second = Boolean.valueOf(false);
/* 168 */       return res;
/*     */     }
/* 170 */     if ((cfg.openId > 0) && (OpenInterface.getOpenStatus(cfg.openId)))
/*     */     {
/*     */ 
/* 173 */       Pair<Integer, Integer> pair = handleOverMaxLevel(this.expShowValue, leftAddValue, this.finalLevel, cfg);
/* 174 */       int needAddExp = ((Integer)pair.first).intValue();
/* 175 */       int needAddXiuExp = ((Integer)pair.second).intValue();
/* 176 */       this.realAddExp -= needAddXiuExp;
/* 177 */       this.expShowValue += needAddExp;
/* 178 */       this.needConvertXiuExp += needAddXiuExp;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 183 */       this.realAddExp -= leftAddValue;
/* 184 */       this.needConvertXiuExp += leftAddValue;
/*     */     }
/* 186 */     res.first = Boolean.valueOf(true);
/* 187 */     return res;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   Pair<Integer, Integer> handleOverMaxLevel(int showValue, int addValue, int level, SRoleLevelFlyCfg cfg)
/*     */   {
/* 206 */     Pair<Integer, Integer> pair = getMaxExpStorageValue(level, cfg);
/* 207 */     int expNeedToMaxValue = ((Integer)pair.second).intValue() - showValue;
/*     */     
/* 209 */     int exp = 0;
/* 210 */     int xiuExp = 0;
/* 211 */     if (expNeedToMaxValue == 0)
/*     */     {
/* 213 */       xiuExp = addValue;
/*     */ 
/*     */ 
/*     */     }
/* 217 */     else if (expNeedToMaxValue <= addValue)
/*     */     {
/* 219 */       exp = expNeedToMaxValue;
/* 220 */       xiuExp = addValue - expNeedToMaxValue;
/*     */     }
/*     */     else
/*     */     {
/* 224 */       exp = addValue;
/*     */     }
/*     */     
/* 227 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 229 */       GameServer.logger().debug(String.format("[exp]RoleAddExp.getAddPoolExpValue@ exchange info:|showValue=%d|addValue=%d|level=%d|lastExp=%d|xiuExp=%d|levelUpNeedExp=%d|expPoolValue=%d", new Object[] { Integer.valueOf(showValue), Integer.valueOf(addValue), Integer.valueOf(level), Integer.valueOf(exp), Integer.valueOf(xiuExp), pair.first, pair.second }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 234 */     return new Pair(Integer.valueOf(exp), Integer.valueOf(xiuExp));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean canAddXiuExp(int level)
/*     */   {
/* 245 */     if (level < this.roleMaxLvInSer)
/*     */     {
/* 247 */       return false;
/*     */     }
/* 249 */     if (this.roleMaxLvInSer >= this.roleMaxLvInCfg)
/*     */     {
/* 251 */       return false;
/*     */     }
/* 253 */     return true;
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
/*     */   Pair<Integer, Integer> getMaxExpStorageValue(int level, SRoleLevelFlyCfg cfg)
/*     */   {
/* 267 */     Pair<Integer, Integer> pair = new Pair(Integer.valueOf(0), Integer.valueOf(0));
/* 268 */     int totalLvExpMax = this.occupation.getToNextLevelNeedExp(level);
/* 269 */     pair.first = Integer.valueOf(totalLvExpMax);
/* 270 */     long lastValue = totalLvExpMax * cfg.storageRet;
/* 271 */     pair.second = Integer.valueOf(lastValue > 2147483647L ? Integer.MAX_VALUE : (int)lastValue);
/* 272 */     return pair;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean needStorageExp(int tmpLevel)
/*     */   {
/* 283 */     if (tmpLevel > this.roleMaxLvInCfg)
/*     */     {
/*     */ 
/* 286 */       return true;
/*     */     }
/* 288 */     SRoleLevelFlyCfg cfg = SRoleLevelFlyCfg.get(tmpLevel - 1);
/* 289 */     if (cfg == null)
/*     */     {
/*     */ 
/* 292 */       return false;
/*     */     }
/* 294 */     if (!canLevelFly(this.roleId, tmpLevel))
/*     */     {
/*     */ 
/* 297 */       return true;
/*     */     }
/* 299 */     if ((cfg.releaseOpenId <= 0) || (!OpenInterface.getOpenStatus(cfg.releaseOpenId)))
/*     */     {
/*     */ 
/* 302 */       return true;
/*     */     }
/* 304 */     return false;
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
/*     */   private boolean canLevelFly(long roleId, int level)
/*     */   {
/* 318 */     if (this.debug_can_fly)
/*     */     {
/* 320 */       return true;
/*     */     }
/* 322 */     return FeiShengInterface.checkRoleCanFeiSheng(roleId, level - 1, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoleId()
/*     */   {
/* 332 */     return this.roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSuc()
/*     */   {
/* 342 */     return this.suc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFinalLevel()
/*     */   {
/* 352 */     return this.finalLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getNeedConvertXiuExp()
/*     */   {
/* 362 */     return this.needConvertXiuExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRealAddExp()
/*     */   {
/* 372 */     return this.realAddExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getExpShowValue()
/*     */   {
/* 382 */     return this.expShowValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean levelChange()
/*     */   {
/* 392 */     return this.finalLevel != this.orgLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOrglevel()
/*     */   {
/* 402 */     return this.orgLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBeginConvertXiuExp()
/*     */   {
/* 412 */     return (this.needConvertXiuExp > 0) && (this.realAddExp > 0);
/*     */   }
/*     */   
/*     */   public void setDebug_can_fly(boolean debug_can_fly)
/*     */   {
/* 417 */     this.debug_can_fly = debug_can_fly;
/*     */   }
/*     */   
/*     */   public boolean isCalRelease()
/*     */   {
/* 422 */     return this.isCalRelease;
/*     */   }
/*     */   
/*     */   public void setCalRelease(boolean isCalRelease)
/*     */   {
/* 427 */     this.isCalRelease = isCalRelease;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getReleasedExp()
/*     */   {
/* 437 */     return this.releasedExp;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleAddExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */