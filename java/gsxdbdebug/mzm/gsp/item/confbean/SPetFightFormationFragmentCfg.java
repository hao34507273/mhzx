/*     */ package mzm.gsp.item.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SPetFightFormationFragmentCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SPetFightFormationFragmentCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SPetFightFormationFragmentCfg> all = null;
/*     */   
/*     */   public int exp;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  24 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  25 */     this.name = rootElement.attributeValue("name");
/*  26 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  27 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  28 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  29 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  30 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  31 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  32 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  33 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  34 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  35 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  36 */     this.exp = Integer.valueOf(rootElement.attributeValue("exp")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  41 */     _os_.marshal(this.id);
/*  42 */     _os_.marshal(this.type);
/*  43 */     _os_.marshal(this.name, "UTF-8");
/*  44 */     _os_.marshal(this.namecolor);
/*  45 */     _os_.marshal(this.icon);
/*  46 */     _os_.marshal(this.pilemax);
/*  47 */     _os_.marshal(this.sellSilver);
/*  48 */     _os_.marshal(this.isProprietary);
/*  49 */     _os_.marshal(this.canSellAndThrow);
/*  50 */     _os_.marshal(this.awardRoleLevelMin);
/*  51 */     _os_.marshal(this.awardRoleLevelMax);
/*  52 */     _os_.marshal(this.useLevel);
/*  53 */     _os_.marshal(this.sort);
/*  54 */     _os_.marshal(this.exp);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  60 */     this.id = _os_.unmarshal_int();
/*  61 */     this.type = _os_.unmarshal_int();
/*  62 */     this.name = _os_.unmarshal_String("UTF-8");
/*  63 */     this.namecolor = _os_.unmarshal_int();
/*  64 */     this.icon = _os_.unmarshal_int();
/*  65 */     this.pilemax = _os_.unmarshal_int();
/*  66 */     this.sellSilver = _os_.unmarshal_int();
/*  67 */     this.isProprietary = _os_.unmarshal_boolean();
/*  68 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  69 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  70 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  71 */     this.useLevel = _os_.unmarshal_int();
/*  72 */     this.sort = _os_.unmarshal_int();
/*  73 */     this.exp = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.item.confbean.SPetFightFormationFragmentCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       all = new java.util.HashMap();
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element elem = (Element)nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SPetFightFormationFragmentCfg"))
/*     */         {
/*     */ 
/*  95 */           SPetFightFormationFragmentCfg obj = new SPetFightFormationFragmentCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPetFightFormationFragmentCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.item.confbean.SPetFightFormationFragmentCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SPetFightFormationFragmentCfg"))
/*     */         {
/*     */ 
/* 124 */           SPetFightFormationFragmentCfg obj = new SPetFightFormationFragmentCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 138 */     all = new java.util.HashMap();
/*     */     
/* 140 */     String path = dir + "mzm.gsp.item.confbean.SPetFightFormationFragmentCfg.bny";
/*     */     try
/*     */     {
/* 143 */       File file = new File(path);
/* 144 */       if (file.exists())
/*     */       {
/* 146 */         byte[] bytes = new byte['Ѐ'];
/* 147 */         FileInputStream fis = new FileInputStream(file);
/* 148 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 149 */         int len = 0;
/* 150 */         while ((len = fis.read(bytes)) > 0)
/* 151 */           baos.write(bytes, 0, len);
/* 152 */         fis.close();
/* 153 */         bytes = baos.toByteArray();
/* 154 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 155 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 157 */           _os_.unmarshal_int();
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/*     */         }
/* 161 */         _os_.unmarshal_int();
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 165 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 167 */           SPetFightFormationFragmentCfg _v_ = new SPetFightFormationFragmentCfg();
/* 168 */           _v_.unmarshal(_os_);
/* 169 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 175 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPetFightFormationFragmentCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.item.confbean.SPetFightFormationFragmentCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SPetFightFormationFragmentCfg _v_ = new SPetFightFormationFragmentCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 233 */     for (Map.Entry<Integer, SPetFightFormationFragmentCfg> entry : all.entrySet())
/*     */     {
/* 235 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 237 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 241 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SPetFightFormationFragmentCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 248 */     for (Map.Entry<Integer, SPetFightFormationFragmentCfg> entry : all.entrySet())
/*     */     {
/* 250 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 252 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 256 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SPetFightFormationFragmentCfg getOld(int key)
/*     */   {
/* 263 */     return (SPetFightFormationFragmentCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPetFightFormationFragmentCfg get(int key)
/*     */   {
/* 268 */     return (SPetFightFormationFragmentCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetFightFormationFragmentCfg> getOldAllSelf()
/*     */   {
/* 273 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetFightFormationFragmentCfg> getAllSelf()
/*     */   {
/* 278 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPetFightFormationFragmentCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SPetFightFormationFragmentCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */