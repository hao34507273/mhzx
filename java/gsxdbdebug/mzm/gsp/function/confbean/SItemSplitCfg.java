/*     */ package mzm.gsp.function.confbean;
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
/*     */ public class SItemSplitCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SItemSplitCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SItemSplitCfg> all = null;
/*     */   
/*     */   public int itemId;
/*     */   public int requiredSilver;
/*     */   public int requiredGold;
/*     */   public int requiredVigor;
/*     */   public boolean canSplitAll;
/*     */   public boolean canSplitBind;
/*  24 */   public java.util.ArrayList<SItemSplitResult> results = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/*  29 */     this.requiredSilver = Integer.valueOf(rootElement.attributeValue("requiredSilver")).intValue();
/*  30 */     this.requiredGold = Integer.valueOf(rootElement.attributeValue("requiredGold")).intValue();
/*  31 */     this.requiredVigor = Integer.valueOf(rootElement.attributeValue("requiredVigor")).intValue();
/*  32 */     this.canSplitAll = Boolean.valueOf(rootElement.attributeValue("canSplitAll")).booleanValue();
/*  33 */     this.canSplitBind = Boolean.valueOf(rootElement.attributeValue("canSplitBind")).booleanValue();
/*     */     
/*  35 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "results");
/*  36 */     if (collectionElement == null)
/*     */     {
/*  38 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  41 */     List<?> _nodeList = collectionElement.elements();
/*  42 */     int _len = _nodeList.size();
/*  43 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  45 */       Element elem = (Element)_nodeList.get(i);
/*  46 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.function.confbean.SItemSplitResult"))
/*     */       {
/*     */         SItemSplitResult _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  53 */           _v_ = new SItemSplitResult();
/*  54 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  61 */         this.results.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  68 */     _os_.marshal(this.itemId);
/*  69 */     _os_.marshal(this.requiredSilver);
/*  70 */     _os_.marshal(this.requiredGold);
/*  71 */     _os_.marshal(this.requiredVigor);
/*  72 */     _os_.marshal(this.canSplitAll);
/*  73 */     _os_.marshal(this.canSplitBind);
/*  74 */     _os_.compact_uint32(this.results.size());
/*  75 */     for (SItemSplitResult _v_ : this.results)
/*     */     {
/*  77 */       _os_.marshal(_v_);
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     this.itemId = _os_.unmarshal_int();
/*  85 */     this.requiredSilver = _os_.unmarshal_int();
/*  86 */     this.requiredGold = _os_.unmarshal_int();
/*  87 */     this.requiredVigor = _os_.unmarshal_int();
/*  88 */     this.canSplitAll = _os_.unmarshal_boolean();
/*  89 */     this.canSplitBind = _os_.unmarshal_boolean();
/*  90 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  93 */       SItemSplitResult _v_ = new SItemSplitResult();
/*  94 */       _v_.unmarshal(_os_);
/*  95 */       this.results.add(_v_);
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 102 */     String path = dir + "mzm.gsp.function.confbean.SItemSplitCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 106 */       all = new java.util.HashMap();
/* 107 */       SAXReader reader = new SAXReader();
/* 108 */       org.dom4j.Document doc = reader.read(new File(path));
/* 109 */       Element root = doc.getRootElement();
/* 110 */       List<?> nodeList = root.elements();
/* 111 */       int len = nodeList.size();
/* 112 */       for (int i = 0; i < len; i++)
/*     */       {
/* 114 */         Element elem = (Element)nodeList.get(i);
/* 115 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.function.confbean.SItemSplitCfg"))
/*     */         {
/*     */ 
/* 118 */           SItemSplitCfg obj = new SItemSplitCfg();
/* 119 */           obj.loadFromXml(elem);
/* 120 */           if (all.put(Integer.valueOf(obj.itemId), obj) != null) {
/* 121 */             throw new RuntimeException("duplicate key : " + obj.itemId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 126 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SItemSplitCfg> all)
/*     */   {
/* 132 */     String path = dir + "mzm.gsp.function.confbean.SItemSplitCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 136 */       SAXReader reader = new SAXReader();
/* 137 */       org.dom4j.Document doc = reader.read(new File(path));
/* 138 */       Element root = doc.getRootElement();
/* 139 */       List<?> nodeList = root.elements();
/* 140 */       int len = nodeList.size();
/* 141 */       for (int i = 0; i < len; i++)
/*     */       {
/* 143 */         Element elem = (Element)nodeList.get(i);
/* 144 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.function.confbean.SItemSplitCfg"))
/*     */         {
/*     */ 
/* 147 */           SItemSplitCfg obj = new SItemSplitCfg();
/* 148 */           obj.loadFromXml(elem);
/* 149 */           if (all.put(Integer.valueOf(obj.itemId), obj) != null) {
/* 150 */             throw new RuntimeException("duplicate key : " + obj.itemId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 155 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 161 */     all = new java.util.HashMap();
/*     */     
/* 163 */     String path = dir + "mzm.gsp.function.confbean.SItemSplitCfg.bny";
/*     */     try
/*     */     {
/* 166 */       File file = new File(path);
/* 167 */       if (file.exists())
/*     */       {
/* 169 */         byte[] bytes = new byte['Ѐ'];
/* 170 */         FileInputStream fis = new FileInputStream(file);
/* 171 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 172 */         int len = 0;
/* 173 */         while ((len = fis.read(bytes)) > 0)
/* 174 */           baos.write(bytes, 0, len);
/* 175 */         fis.close();
/* 176 */         bytes = baos.toByteArray();
/* 177 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 180 */           _os_.unmarshal_int();
/* 181 */           _os_.unmarshal_int();
/* 182 */           _os_.unmarshal_int();
/*     */         }
/* 184 */         _os_.unmarshal_int();
/* 185 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 188 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 190 */           SItemSplitCfg _v_ = new SItemSplitCfg();
/* 191 */           _v_.unmarshal(_os_);
/* 192 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 193 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 198 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 203 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SItemSplitCfg> all)
/*     */   {
/* 210 */     String path = dir + "mzm.gsp.function.confbean.SItemSplitCfg.bny";
/*     */     try
/*     */     {
/* 213 */       File file = new File(path);
/* 214 */       if (file.exists())
/*     */       {
/* 216 */         byte[] bytes = new byte['Ѐ'];
/* 217 */         FileInputStream fis = new FileInputStream(file);
/* 218 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 219 */         int len = 0;
/* 220 */         while ((len = fis.read(bytes)) > 0)
/* 221 */           baos.write(bytes, 0, len);
/* 222 */         fis.close();
/* 223 */         bytes = baos.toByteArray();
/* 224 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 227 */           _os_.unmarshal_int();
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/*     */         }
/* 231 */         _os_.unmarshal_int();
/* 232 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 235 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 237 */           SItemSplitCfg _v_ = new SItemSplitCfg();
/* 238 */           _v_.unmarshal(_os_);
/* 239 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 240 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 245 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 250 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SItemSplitCfg getOld(int key)
/*     */   {
/* 258 */     return (SItemSplitCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SItemSplitCfg get(int key)
/*     */   {
/* 263 */     return (SItemSplitCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemSplitCfg> getOldAll()
/*     */   {
/* 268 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemSplitCfg> getAll()
/*     */   {
/* 273 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SItemSplitCfg> newAll)
/*     */   {
/* 278 */     oldAll = all;
/* 279 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 284 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\function\confbean\SItemSplitCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */