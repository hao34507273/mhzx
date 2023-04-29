/*     */ package mzm.gsp.groupshopping.confbean;
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
/*     */ public class SBigGroupShoppingItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBigGroupShoppingItemCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBigGroupShoppingItemCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int itemId;
/*     */   public int originalPrice;
/*     */   public int singlePrice;
/*     */   public int groupPrice;
/*     */   public int groupSize;
/*  24 */   public java.util.ArrayList<Integer> groupSizesToNotify = new java.util.ArrayList();
/*     */   public int itemNum;
/*     */   public int maxBuyNum;
/*     */   public int timeLimitCfgId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/*  33 */     this.originalPrice = Integer.valueOf(rootElement.attributeValue("originalPrice")).intValue();
/*  34 */     this.singlePrice = Integer.valueOf(rootElement.attributeValue("singlePrice")).intValue();
/*  35 */     this.groupPrice = Integer.valueOf(rootElement.attributeValue("groupPrice")).intValue();
/*  36 */     this.groupSize = Integer.valueOf(rootElement.attributeValue("groupSize")).intValue();
/*     */     
/*  38 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "groupSizesToNotify");
/*  39 */     if (collectionElement == null)
/*     */     {
/*  41 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  44 */     List<?> _nodeList = collectionElement.elements();
/*  45 */     int _len = _nodeList.size();
/*  46 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  48 */       Element elem = (Element)_nodeList.get(i);
/*  49 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  56 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  63 */         this.groupSizesToNotify.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  66 */     this.itemNum = Integer.valueOf(rootElement.attributeValue("itemNum")).intValue();
/*  67 */     this.maxBuyNum = Integer.valueOf(rootElement.attributeValue("maxBuyNum")).intValue();
/*  68 */     this.timeLimitCfgId = Integer.valueOf(rootElement.attributeValue("timeLimitCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  73 */     _os_.marshal(this.id);
/*  74 */     _os_.marshal(this.itemId);
/*  75 */     _os_.marshal(this.originalPrice);
/*  76 */     _os_.marshal(this.singlePrice);
/*  77 */     _os_.marshal(this.groupPrice);
/*  78 */     _os_.marshal(this.groupSize);
/*  79 */     _os_.compact_uint32(this.groupSizesToNotify.size());
/*  80 */     for (Integer _v_ : this.groupSizesToNotify)
/*     */     {
/*  82 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  84 */     _os_.marshal(this.itemNum);
/*  85 */     _os_.marshal(this.maxBuyNum);
/*  86 */     _os_.marshal(this.timeLimitCfgId);
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     this.id = _os_.unmarshal_int();
/*  93 */     this.itemId = _os_.unmarshal_int();
/*  94 */     this.originalPrice = _os_.unmarshal_int();
/*  95 */     this.singlePrice = _os_.unmarshal_int();
/*  96 */     this.groupPrice = _os_.unmarshal_int();
/*  97 */     this.groupSize = _os_.unmarshal_int();
/*  98 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 101 */       int _v_ = _os_.unmarshal_int();
/* 102 */       this.groupSizesToNotify.add(Integer.valueOf(_v_));
/*     */     }
/* 104 */     this.itemNum = _os_.unmarshal_int();
/* 105 */     this.maxBuyNum = _os_.unmarshal_int();
/* 106 */     this.timeLimitCfgId = _os_.unmarshal_int();
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 112 */     String path = dir + "mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 116 */       all = new java.util.HashMap();
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg"))
/*     */         {
/*     */ 
/* 128 */           SBigGroupShoppingItemCfg obj = new SBigGroupShoppingItemCfg();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBigGroupShoppingItemCfg> all)
/*     */   {
/* 142 */     String path = dir + "mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 146 */       SAXReader reader = new SAXReader();
/* 147 */       org.dom4j.Document doc = reader.read(new File(path));
/* 148 */       Element root = doc.getRootElement();
/* 149 */       List<?> nodeList = root.elements();
/* 150 */       int len = nodeList.size();
/* 151 */       for (int i = 0; i < len; i++)
/*     */       {
/* 153 */         Element elem = (Element)nodeList.get(i);
/* 154 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg"))
/*     */         {
/*     */ 
/* 157 */           SBigGroupShoppingItemCfg obj = new SBigGroupShoppingItemCfg();
/* 158 */           obj.loadFromXml(elem);
/* 159 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 160 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 165 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 171 */     all = new java.util.HashMap();
/*     */     
/* 173 */     String path = dir + "mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg.bny";
/*     */     try
/*     */     {
/* 176 */       File file = new File(path);
/* 177 */       if (file.exists())
/*     */       {
/* 179 */         byte[] bytes = new byte['Ѐ'];
/* 180 */         FileInputStream fis = new FileInputStream(file);
/* 181 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 182 */         int len = 0;
/* 183 */         while ((len = fis.read(bytes)) > 0)
/* 184 */           baos.write(bytes, 0, len);
/* 185 */         fis.close();
/* 186 */         bytes = baos.toByteArray();
/* 187 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 188 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 190 */           _os_.unmarshal_int();
/* 191 */           _os_.unmarshal_int();
/* 192 */           _os_.unmarshal_int();
/*     */         }
/* 194 */         _os_.unmarshal_int();
/* 195 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 198 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 200 */           SBigGroupShoppingItemCfg _v_ = new SBigGroupShoppingItemCfg();
/* 201 */           _v_.unmarshal(_os_);
/* 202 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 203 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 208 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBigGroupShoppingItemCfg> all)
/*     */   {
/* 220 */     String path = dir + "mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg.bny";
/*     */     try
/*     */     {
/* 223 */       File file = new File(path);
/* 224 */       if (file.exists())
/*     */       {
/* 226 */         byte[] bytes = new byte['Ѐ'];
/* 227 */         FileInputStream fis = new FileInputStream(file);
/* 228 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 229 */         int len = 0;
/* 230 */         while ((len = fis.read(bytes)) > 0)
/* 231 */           baos.write(bytes, 0, len);
/* 232 */         fis.close();
/* 233 */         bytes = baos.toByteArray();
/* 234 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 235 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 237 */           _os_.unmarshal_int();
/* 238 */           _os_.unmarshal_int();
/* 239 */           _os_.unmarshal_int();
/*     */         }
/* 241 */         _os_.unmarshal_int();
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 245 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 247 */           SBigGroupShoppingItemCfg _v_ = new SBigGroupShoppingItemCfg();
/* 248 */           _v_.unmarshal(_os_);
/* 249 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 250 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 255 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 260 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBigGroupShoppingItemCfg getOld(int key)
/*     */   {
/* 268 */     return (SBigGroupShoppingItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBigGroupShoppingItemCfg get(int key)
/*     */   {
/* 273 */     return (SBigGroupShoppingItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBigGroupShoppingItemCfg> getOldAll()
/*     */   {
/* 278 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBigGroupShoppingItemCfg> getAll()
/*     */   {
/* 283 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBigGroupShoppingItemCfg> newAll)
/*     */   {
/* 288 */     oldAll = all;
/* 289 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 294 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\confbean\SBigGroupShoppingItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */