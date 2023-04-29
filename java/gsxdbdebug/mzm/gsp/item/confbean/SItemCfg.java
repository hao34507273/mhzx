/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SItemCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SItemCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int type;
/*     */   public String name;
/*     */   public int namecolor;
/*     */   public int icon;
/*     */   public int pilemax;
/*     */   public int sellSilver;
/*     */   public boolean isProprietary;
/*     */   public boolean canSellAndThrow;
/*     */   public int awardRoleLevelMin;
/*     */   public int awardRoleLevelMax;
/*     */   public int useLevel;
/*     */   public int sort;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  36 */     this.name = rootElement.attributeValue("name");
/*  37 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  38 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  39 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  40 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  41 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  42 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  43 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  44 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  45 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  46 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.id);
/*  52 */     _os_.marshal(this.type);
/*  53 */     _os_.marshal(this.name, "UTF-8");
/*  54 */     _os_.marshal(this.namecolor);
/*  55 */     _os_.marshal(this.icon);
/*  56 */     _os_.marshal(this.pilemax);
/*  57 */     _os_.marshal(this.sellSilver);
/*  58 */     _os_.marshal(this.isProprietary);
/*  59 */     _os_.marshal(this.canSellAndThrow);
/*  60 */     _os_.marshal(this.awardRoleLevelMin);
/*  61 */     _os_.marshal(this.awardRoleLevelMax);
/*  62 */     _os_.marshal(this.useLevel);
/*  63 */     _os_.marshal(this.sort);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.type = _os_.unmarshal_int();
/*  71 */     this.name = _os_.unmarshal_String("UTF-8");
/*  72 */     this.namecolor = _os_.unmarshal_int();
/*  73 */     this.icon = _os_.unmarshal_int();
/*  74 */     this.pilemax = _os_.unmarshal_int();
/*  75 */     this.sellSilver = _os_.unmarshal_int();
/*  76 */     this.isProprietary = _os_.unmarshal_boolean();
/*  77 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  78 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  79 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  80 */     this.useLevel = _os_.unmarshal_int();
/*  81 */     this.sort = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.item.confbean.SItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  91 */       all = new java.util.HashMap();
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemCfg"))
/*     */         {
/*     */ 
/* 103 */           SItemCfg obj = new SItemCfg();
/* 104 */           obj.loadFromXml(elem);
/* 105 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 106 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SItemCfg> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.item.confbean.SItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemCfg"))
/*     */         {
/*     */ 
/* 132 */           SItemCfg obj = new SItemCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 146 */     all = new java.util.HashMap();
/*     */     
/* 148 */     String path = dir + "mzm.gsp.item.confbean.SItemCfg.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/*     */         }
/* 169 */         _os_.unmarshal_int();
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 173 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 175 */           SItemCfg _v_ = new SItemCfg();
/* 176 */           _v_.unmarshal(_os_);
/* 177 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 183 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SItemCfg> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.item.confbean.SItemCfg.bny";
/*     */     try
/*     */     {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists())
/*     */       {
/* 201 */         byte[] bytes = new byte['Ѐ'];
/* 202 */         FileInputStream fis = new FileInputStream(file);
/* 203 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 204 */         int len = 0;
/* 205 */         while ((len = fis.read(bytes)) > 0)
/* 206 */           baos.write(bytes, 0, len);
/* 207 */         fis.close();
/* 208 */         bytes = baos.toByteArray();
/* 209 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/*     */         }
/* 216 */         _os_.unmarshal_int();
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 220 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 222 */           SItemCfg _v_ = new SItemCfg();
/* 223 */           _v_.unmarshal(_os_);
/* 224 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 230 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 235 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SItemCfg getOld(int key)
/*     */   {
/* 243 */     return (SItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SItemCfg get(int key)
/*     */   {
/* 248 */     return (SItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemCfg> getOldAll()
/*     */   {
/* 253 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemCfg> getAll()
/*     */   {
/* 258 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SItemCfg> newAll)
/*     */   {
/* 263 */     oldAll = all;
/* 264 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 269 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */