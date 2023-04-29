/*     */ package mzm.gsp.market.confbean;
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
/*     */ public class MarketSubTypeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, MarketSubTypeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, MarketSubTypeCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public String name;
/*     */   public int iconId;
/*     */   public int sort;
/*     */   public int needlevel;
/*     */   public boolean ispricesort;
/*     */   public boolean isAsc;
/*     */   public boolean islevelsift;
/*     */   public int maxsellnum;
/*     */   public int marketCfgId;
/*     */   public int initLevel;
/*     */   public int levelDelta;
/*     */   public int maxLevel;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.templatename = rootElement.attributeValue("templatename");
/*  37 */     this.name = rootElement.attributeValue("name");
/*  38 */     this.iconId = Integer.valueOf(rootElement.attributeValue("iconId")).intValue();
/*  39 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  40 */     this.needlevel = Integer.valueOf(rootElement.attributeValue("needlevel")).intValue();
/*  41 */     this.ispricesort = Boolean.valueOf(rootElement.attributeValue("ispricesort")).booleanValue();
/*  42 */     this.isAsc = Boolean.valueOf(rootElement.attributeValue("isAsc")).booleanValue();
/*  43 */     this.islevelsift = Boolean.valueOf(rootElement.attributeValue("islevelsift")).booleanValue();
/*  44 */     this.maxsellnum = Integer.valueOf(rootElement.attributeValue("maxsellnum")).intValue();
/*  45 */     this.marketCfgId = Integer.valueOf(rootElement.attributeValue("marketCfgId")).intValue();
/*  46 */     this.initLevel = Integer.valueOf(rootElement.attributeValue("initLevel")).intValue();
/*  47 */     this.levelDelta = Integer.valueOf(rootElement.attributeValue("levelDelta")).intValue();
/*  48 */     this.maxLevel = Integer.valueOf(rootElement.attributeValue("maxLevel")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.templatename, "UTF-8");
/*  55 */     _os_.marshal(this.name, "UTF-8");
/*  56 */     _os_.marshal(this.iconId);
/*  57 */     _os_.marshal(this.sort);
/*  58 */     _os_.marshal(this.needlevel);
/*  59 */     _os_.marshal(this.ispricesort);
/*  60 */     _os_.marshal(this.isAsc);
/*  61 */     _os_.marshal(this.islevelsift);
/*  62 */     _os_.marshal(this.maxsellnum);
/*  63 */     _os_.marshal(this.marketCfgId);
/*  64 */     _os_.marshal(this.initLevel);
/*  65 */     _os_.marshal(this.levelDelta);
/*  66 */     _os_.marshal(this.maxLevel);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  74 */     this.name = _os_.unmarshal_String("UTF-8");
/*  75 */     this.iconId = _os_.unmarshal_int();
/*  76 */     this.sort = _os_.unmarshal_int();
/*  77 */     this.needlevel = _os_.unmarshal_int();
/*  78 */     this.ispricesort = _os_.unmarshal_boolean();
/*  79 */     this.isAsc = _os_.unmarshal_boolean();
/*  80 */     this.islevelsift = _os_.unmarshal_boolean();
/*  81 */     this.maxsellnum = _os_.unmarshal_int();
/*  82 */     this.marketCfgId = _os_.unmarshal_int();
/*  83 */     this.initLevel = _os_.unmarshal_int();
/*  84 */     this.levelDelta = _os_.unmarshal_int();
/*  85 */     this.maxLevel = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.market.confbean.MarketSubTypeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.MarketSubTypeCfg"))
/*     */         {
/*     */ 
/* 107 */           MarketSubTypeCfg obj = new MarketSubTypeCfg();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, MarketSubTypeCfg> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.market.confbean.MarketSubTypeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.MarketSubTypeCfg"))
/*     */         {
/*     */ 
/* 136 */           MarketSubTypeCfg obj = new MarketSubTypeCfg();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.market.confbean.MarketSubTypeCfg.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           MarketSubTypeCfg _v_ = new MarketSubTypeCfg();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, MarketSubTypeCfg> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.market.confbean.MarketSubTypeCfg.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           MarketSubTypeCfg _v_ = new MarketSubTypeCfg();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static MarketSubTypeCfg getOld(int key)
/*     */   {
/* 247 */     return (MarketSubTypeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static MarketSubTypeCfg get(int key)
/*     */   {
/* 252 */     return (MarketSubTypeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, MarketSubTypeCfg> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, MarketSubTypeCfg> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, MarketSubTypeCfg> newAll)
/*     */   {
/* 267 */     oldAll = all;
/* 268 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 273 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\confbean\MarketSubTypeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */