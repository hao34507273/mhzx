/*     */ package mzm.gsp.xiaohuikuaipao.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class XiaoHuiKuaiPaoActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, XiaoHuiKuaiPaoActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, XiaoHuiKuaiPaoActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int modelId;
/*     */   public int mainItemId;
/*     */   public int subItemId;
/*     */   public int itemCount;
/*     */   public int lotteryViewCfgId;
/*     */   public int ticketCount;
/*     */   public int duration;
/*     */   public int isClearPointExchangeInfo;
/*     */   public int initFlagCount;
/*     */   public int systemDrawMailId;
/*     */   public int outerDrawTipId;
/*     */   public int innerDrawTipId;
/*     */   public int pointExchangeTipId;
/*     */   public int nengLiangQiIconId;
/*     */   public int fireEffectSourceCfgId;
/*     */   public int nengLiangQiItemId;
/*     */   public int weightCorrectTypeCfgId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  39 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  40 */     this.modelId = Integer.valueOf(rootElement.attributeValue("modelId")).intValue();
/*  41 */     this.mainItemId = Integer.valueOf(rootElement.attributeValue("mainItemId")).intValue();
/*  42 */     this.subItemId = Integer.valueOf(rootElement.attributeValue("subItemId")).intValue();
/*  43 */     this.itemCount = Integer.valueOf(rootElement.attributeValue("itemCount")).intValue();
/*  44 */     this.lotteryViewCfgId = Integer.valueOf(rootElement.attributeValue("lotteryViewCfgId")).intValue();
/*  45 */     this.ticketCount = Integer.valueOf(rootElement.attributeValue("ticketCount")).intValue();
/*  46 */     this.duration = Integer.valueOf(rootElement.attributeValue("duration")).intValue();
/*  47 */     this.isClearPointExchangeInfo = Integer.valueOf(rootElement.attributeValue("isClearPointExchangeInfo")).intValue();
/*  48 */     this.initFlagCount = Integer.valueOf(rootElement.attributeValue("initFlagCount")).intValue();
/*  49 */     this.systemDrawMailId = Integer.valueOf(rootElement.attributeValue("systemDrawMailId")).intValue();
/*  50 */     this.outerDrawTipId = Integer.valueOf(rootElement.attributeValue("outerDrawTipId")).intValue();
/*  51 */     this.innerDrawTipId = Integer.valueOf(rootElement.attributeValue("innerDrawTipId")).intValue();
/*  52 */     this.pointExchangeTipId = Integer.valueOf(rootElement.attributeValue("pointExchangeTipId")).intValue();
/*  53 */     this.nengLiangQiIconId = Integer.valueOf(rootElement.attributeValue("nengLiangQiIconId")).intValue();
/*  54 */     this.fireEffectSourceCfgId = Integer.valueOf(rootElement.attributeValue("fireEffectSourceCfgId")).intValue();
/*  55 */     this.nengLiangQiItemId = Integer.valueOf(rootElement.attributeValue("nengLiangQiItemId")).intValue();
/*  56 */     this.weightCorrectTypeCfgId = Integer.valueOf(rootElement.attributeValue("weightCorrectTypeCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  61 */     _os_.marshal(this.activityId);
/*  62 */     _os_.marshal(this.modelId);
/*  63 */     _os_.marshal(this.mainItemId);
/*  64 */     _os_.marshal(this.subItemId);
/*  65 */     _os_.marshal(this.itemCount);
/*  66 */     _os_.marshal(this.lotteryViewCfgId);
/*  67 */     _os_.marshal(this.ticketCount);
/*  68 */     _os_.marshal(this.duration);
/*  69 */     _os_.marshal(this.isClearPointExchangeInfo);
/*  70 */     _os_.marshal(this.initFlagCount);
/*  71 */     _os_.marshal(this.systemDrawMailId);
/*  72 */     _os_.marshal(this.outerDrawTipId);
/*  73 */     _os_.marshal(this.innerDrawTipId);
/*  74 */     _os_.marshal(this.pointExchangeTipId);
/*  75 */     _os_.marshal(this.nengLiangQiIconId);
/*  76 */     _os_.marshal(this.fireEffectSourceCfgId);
/*  77 */     _os_.marshal(this.nengLiangQiItemId);
/*  78 */     _os_.marshal(this.weightCorrectTypeCfgId);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     this.activityId = _os_.unmarshal_int();
/*  85 */     this.modelId = _os_.unmarshal_int();
/*  86 */     this.mainItemId = _os_.unmarshal_int();
/*  87 */     this.subItemId = _os_.unmarshal_int();
/*  88 */     this.itemCount = _os_.unmarshal_int();
/*  89 */     this.lotteryViewCfgId = _os_.unmarshal_int();
/*  90 */     this.ticketCount = _os_.unmarshal_int();
/*  91 */     this.duration = _os_.unmarshal_int();
/*  92 */     this.isClearPointExchangeInfo = _os_.unmarshal_int();
/*  93 */     this.initFlagCount = _os_.unmarshal_int();
/*  94 */     this.systemDrawMailId = _os_.unmarshal_int();
/*  95 */     this.outerDrawTipId = _os_.unmarshal_int();
/*  96 */     this.innerDrawTipId = _os_.unmarshal_int();
/*  97 */     this.pointExchangeTipId = _os_.unmarshal_int();
/*  98 */     this.nengLiangQiIconId = _os_.unmarshal_int();
/*  99 */     this.fireEffectSourceCfgId = _os_.unmarshal_int();
/* 100 */     this.nengLiangQiItemId = _os_.unmarshal_int();
/* 101 */     this.weightCorrectTypeCfgId = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 107 */     String path = dir + "mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 111 */       all = new java.util.HashMap();
/* 112 */       SAXReader reader = new SAXReader();
/* 113 */       org.dom4j.Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       List<?> nodeList = root.elements();
/* 116 */       int len = nodeList.size();
/* 117 */       for (int i = 0; i < len; i++)
/*     */       {
/* 119 */         Element elem = (Element)nodeList.get(i);
/* 120 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg"))
/*     */         {
/*     */ 
/* 123 */           XiaoHuiKuaiPaoActivityCfg obj = new XiaoHuiKuaiPaoActivityCfg();
/* 124 */           obj.loadFromXml(elem);
/* 125 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 126 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 131 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, XiaoHuiKuaiPaoActivityCfg> all)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 141 */       SAXReader reader = new SAXReader();
/* 142 */       org.dom4j.Document doc = reader.read(new File(path));
/* 143 */       Element root = doc.getRootElement();
/* 144 */       List<?> nodeList = root.elements();
/* 145 */       int len = nodeList.size();
/* 146 */       for (int i = 0; i < len; i++)
/*     */       {
/* 148 */         Element elem = (Element)nodeList.get(i);
/* 149 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg"))
/*     */         {
/*     */ 
/* 152 */           XiaoHuiKuaiPaoActivityCfg obj = new XiaoHuiKuaiPaoActivityCfg();
/* 153 */           obj.loadFromXml(elem);
/* 154 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 155 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 166 */     all = new java.util.HashMap();
/*     */     
/* 168 */     String path = dir + "mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg.bny";
/*     */     try
/*     */     {
/* 171 */       File file = new File(path);
/* 172 */       if (file.exists())
/*     */       {
/* 174 */         byte[] bytes = new byte['Ѐ'];
/* 175 */         FileInputStream fis = new FileInputStream(file);
/* 176 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 177 */         int len = 0;
/* 178 */         while ((len = fis.read(bytes)) > 0)
/* 179 */           baos.write(bytes, 0, len);
/* 180 */         fis.close();
/* 181 */         bytes = baos.toByteArray();
/* 182 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/* 187 */           _os_.unmarshal_int();
/*     */         }
/* 189 */         _os_.unmarshal_int();
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 193 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 195 */           XiaoHuiKuaiPaoActivityCfg _v_ = new XiaoHuiKuaiPaoActivityCfg();
/* 196 */           _v_.unmarshal(_os_);
/* 197 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 198 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 203 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, XiaoHuiKuaiPaoActivityCfg> all)
/*     */   {
/* 215 */     String path = dir + "mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg.bny";
/*     */     try
/*     */     {
/* 218 */       File file = new File(path);
/* 219 */       if (file.exists())
/*     */       {
/* 221 */         byte[] bytes = new byte['Ѐ'];
/* 222 */         FileInputStream fis = new FileInputStream(file);
/* 223 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 224 */         int len = 0;
/* 225 */         while ((len = fis.read(bytes)) > 0)
/* 226 */           baos.write(bytes, 0, len);
/* 227 */         fis.close();
/* 228 */         bytes = baos.toByteArray();
/* 229 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 232 */           _os_.unmarshal_int();
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/*     */         }
/* 236 */         _os_.unmarshal_int();
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 240 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 242 */           XiaoHuiKuaiPaoActivityCfg _v_ = new XiaoHuiKuaiPaoActivityCfg();
/* 243 */           _v_.unmarshal(_os_);
/* 244 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 245 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 250 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 255 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static XiaoHuiKuaiPaoActivityCfg getOld(int key)
/*     */   {
/* 263 */     return (XiaoHuiKuaiPaoActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static XiaoHuiKuaiPaoActivityCfg get(int key)
/*     */   {
/* 268 */     return (XiaoHuiKuaiPaoActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, XiaoHuiKuaiPaoActivityCfg> getOldAll()
/*     */   {
/* 273 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, XiaoHuiKuaiPaoActivityCfg> getAll()
/*     */   {
/* 278 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, XiaoHuiKuaiPaoActivityCfg> newAll)
/*     */   {
/* 283 */     oldAll = all;
/* 284 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 289 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\confbean\XiaoHuiKuaiPaoActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */