/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.confbean.SChildrenCfg;
/*     */ import mzm.gsp.children.confbean.SFashionCfg;
/*     */ import mzm.gsp.children.fashion.FashionManager;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.util.confbean.SChangeFashionCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.DressedInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Children
/*     */ {
/*     */   protected final long roleid;
/*     */   protected final long childid;
/*     */   protected final ChildInfo xChildInfo;
/*     */   
/*     */   Children(long roleid, long childid, ChildInfo xChildInfo)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.childid = childid;
/*  29 */     this.xChildInfo = xChildInfo;
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/*  34 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public long getId()
/*     */   {
/*  39 */     return this.childid;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  44 */     return this.xChildInfo.getChild_name();
/*     */   }
/*     */   
/*     */   public void getModel(ModelInfo modelInfo)
/*     */   {
/*  49 */     int period = this.xChildInfo.getChild_period();
/*  50 */     modelInfo.extramap.put(Integer.valueOf(25), Integer.valueOf(period));
/*  51 */     modelInfo.extramap.put(Integer.valueOf(26), Integer.valueOf(this.xChildInfo.getChild_gender()));
/*  52 */     modelInfo.extramap.put(Integer.valueOf(27), Integer.valueOf(FashionManager.getChangeFashionCfgid(this.xChildInfo, period)));
/*     */     
/*  54 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  55 */     if (xAdulthoodInfo != null)
/*     */     {
/*  57 */       modelInfo.extramap.put(Integer.valueOf(28), Integer.valueOf(xAdulthoodInfo.getModelcfgid()));
/*  58 */       modelInfo.extramap.put(Integer.valueOf(29), Integer.valueOf(ChildrenManager.getChildrenWeaponCfgid(xAdulthoodInfo)));
/*     */     }
/*     */     else
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[Children]Children.getModel@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*     */     }
/*     */     
/*  65 */     modelInfo.modelid = getModelid();
/*     */   }
/*     */   
/*     */   public int getHP()
/*     */   {
/*  70 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  71 */     if (xAdulthoodInfo == null)
/*     */     {
/*  73 */       GameServer.logger().error(String.format("[Children]Children.getHP@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*     */       
/*  75 */       return 0;
/*     */     }
/*  77 */     return xAdulthoodInfo.getHp();
/*     */   }
/*     */   
/*     */   public int getMP()
/*     */   {
/*  82 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  83 */     if (xAdulthoodInfo == null)
/*     */     {
/*  85 */       GameServer.logger().error(String.format("[Children]Children.getMP@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*     */       
/*  87 */       return 0;
/*     */     }
/*  89 */     return xAdulthoodInfo.getMp();
/*     */   }
/*     */   
/*     */   public void setHP(int hp)
/*     */   {
/*  94 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/*  95 */     if (xAdulthoodInfo == null)
/*     */     {
/*  97 */       GameServer.logger().error(String.format("[Children]Children.setHP@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*     */       
/*  99 */       return;
/*     */     }
/* 101 */     hp = Math.max(1, hp);
/* 102 */     xAdulthoodInfo.setHp(hp);
/*     */   }
/*     */   
/*     */   public void setMP(int mp)
/*     */   {
/* 107 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/* 108 */     if (xAdulthoodInfo == null)
/*     */     {
/* 110 */       GameServer.logger().error(String.format("[Children]Children.setMP@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*     */       
/* 112 */       return;
/*     */     }
/* 114 */     mp = Math.max(1, mp);
/* 115 */     xAdulthoodInfo.setMp(mp);
/*     */   }
/*     */   
/*     */   public int getModelid()
/*     */   {
/* 120 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(this.xChildInfo);
/* 121 */     if (xAdulthoodInfo == null)
/*     */     {
/* 123 */       GameServer.logger().error(String.format("[Children]Children.getModelid@do not has adult info|childid=%d|roleid=%d", new Object[] { Long.valueOf(this.childid), Long.valueOf(this.roleid) }));
/*     */       
/* 125 */       return 0;
/*     */     }
/* 127 */     SChildrenCfg childrenCfg = SChildrenCfg.get(xAdulthoodInfo.getModelcfgid());
/* 128 */     if (childrenCfg == null)
/*     */     {
/* 130 */       return 0;
/*     */     }
/* 132 */     int defaultModelid = childrenCfg.modelId;
/* 133 */     DressedInfo xDressedInfo = (DressedInfo)this.xChildInfo.getDressed().get(Integer.valueOf(2));
/* 134 */     if (xDressedInfo == null)
/*     */     {
/* 136 */       return defaultModelid;
/*     */     }
/* 138 */     int fashionCfgid = xDressedInfo.getFashion_cfgid();
/* 139 */     SFashionCfg fashionCfg = SFashionCfg.get(fashionCfgid);
/* 140 */     if (fashionCfg == null)
/*     */     {
/* 142 */       return defaultModelid;
/*     */     }
/* 144 */     SChangeFashionCfg changeFashionCfg = SChangeFashionCfg.get(fashionCfg.changeFashionCfgid);
/* 145 */     if (changeFashionCfg == null)
/*     */     {
/* 147 */       return defaultModelid;
/*     */     }
/* 149 */     if (changeFashionCfg.changeType == 2)
/*     */     {
/* 151 */       return changeFashionCfg.modelCfgid;
/*     */     }
/* 153 */     return defaultModelid;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\Children.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */