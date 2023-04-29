/*     */ package mzm.gsp.children.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SBabyOperatorOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBabyOperatorOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBabyOperatorOriginalCfg> all = null;
/*     */   
/*     */   public int operator;
/*  19 */   public ArrayList<BabyOperatorCostBean> cost_currency_list = new ArrayList();
/*  20 */   public ArrayList<BabyOperatorPropertyBean> add_property_list = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.operator = Integer.valueOf(rootElement.attributeValue("operator")).intValue();
/*     */     
/*  26 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "cost_currency_list");
/*  27 */     if (collectionElement == null)
/*     */     {
/*  29 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  32 */     List<?> _nodeList = collectionElement.elements();
/*  33 */     int _len = _nodeList.size();
/*  34 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  36 */       Element elem = (Element)_nodeList.get(i);
/*  37 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.BabyOperatorCostBean"))
/*     */       {
/*     */         BabyOperatorCostBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  44 */           _v_ = new BabyOperatorCostBean();
/*  45 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  52 */         this.cost_currency_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  56 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "add_property_list");
/*  57 */     if (collectionElement == null)
/*     */     {
/*  59 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  62 */     List<?> _nodeList = collectionElement.elements();
/*  63 */     int _len = _nodeList.size();
/*  64 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  66 */       Element elem = (Element)_nodeList.get(i);
/*  67 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.BabyOperatorPropertyBean"))
/*     */       {
/*     */         BabyOperatorPropertyBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  74 */           _v_ = new BabyOperatorPropertyBean();
/*  75 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  82 */         this.add_property_list.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  89 */     _os_.marshal(this.operator);
/*  90 */     _os_.compact_uint32(this.cost_currency_list.size());
/*  91 */     for (BabyOperatorCostBean _v_ : this.cost_currency_list)
/*     */     {
/*  93 */       _os_.marshal(_v_);
/*     */     }
/*  95 */     _os_.compact_uint32(this.add_property_list.size());
/*  96 */     for (BabyOperatorPropertyBean _v_ : this.add_property_list)
/*     */     {
/*  98 */       _os_.marshal(_v_);
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 105 */     this.operator = _os_.unmarshal_int();
/* 106 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 109 */       BabyOperatorCostBean _v_ = new BabyOperatorCostBean();
/* 110 */       _v_.unmarshal(_os_);
/* 111 */       this.cost_currency_list.add(_v_);
/*     */     }
/* 113 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 116 */       BabyOperatorPropertyBean _v_ = new BabyOperatorPropertyBean();
/* 117 */       _v_.unmarshal(_os_);
/* 118 */       this.add_property_list.add(_v_);
/*     */     }
/* 120 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.children.confbean.SBabyOperatorOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       all = new java.util.HashMap();
/* 130 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 131 */       org.dom4j.Document doc = reader.read(new File(path));
/* 132 */       Element root = doc.getRootElement();
/* 133 */       List<?> nodeList = root.elements();
/* 134 */       int len = nodeList.size();
/* 135 */       for (int i = 0; i < len; i++)
/*     */       {
/* 137 */         Element elem = (Element)nodeList.get(i);
/* 138 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SBabyOperatorOriginalCfg"))
/*     */         {
/*     */ 
/* 141 */           SBabyOperatorOriginalCfg obj = new SBabyOperatorOriginalCfg();
/* 142 */           obj.loadFromXml(elem);
/* 143 */           if (all.put(Integer.valueOf(obj.operator), obj) != null) {
/* 144 */             throw new RuntimeException("duplicate key : " + obj.operator);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 149 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBabyOperatorOriginalCfg> all)
/*     */   {
/* 155 */     String path = dir + "mzm.gsp.children.confbean.SBabyOperatorOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 159 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 160 */       org.dom4j.Document doc = reader.read(new File(path));
/* 161 */       Element root = doc.getRootElement();
/* 162 */       List<?> nodeList = root.elements();
/* 163 */       int len = nodeList.size();
/* 164 */       for (int i = 0; i < len; i++)
/*     */       {
/* 166 */         Element elem = (Element)nodeList.get(i);
/* 167 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SBabyOperatorOriginalCfg"))
/*     */         {
/*     */ 
/* 170 */           SBabyOperatorOriginalCfg obj = new SBabyOperatorOriginalCfg();
/* 171 */           obj.loadFromXml(elem);
/* 172 */           if (all.put(Integer.valueOf(obj.operator), obj) != null) {
/* 173 */             throw new RuntimeException("duplicate key : " + obj.operator);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 178 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 184 */     all = new java.util.HashMap();
/*     */     
/* 186 */     String path = dir + "mzm.gsp.children.confbean.SBabyOperatorOriginalCfg.bny";
/*     */     try
/*     */     {
/* 189 */       File file = new File(path);
/* 190 */       if (file.exists())
/*     */       {
/* 192 */         byte[] bytes = new byte['Ѐ'];
/* 193 */         FileInputStream fis = new FileInputStream(file);
/* 194 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 195 */         int len = 0;
/* 196 */         while ((len = fis.read(bytes)) > 0)
/* 197 */           baos.write(bytes, 0, len);
/* 198 */         fis.close();
/* 199 */         bytes = baos.toByteArray();
/* 200 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 203 */           _os_.unmarshal_int();
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/*     */         }
/* 207 */         _os_.unmarshal_int();
/* 208 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 211 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 213 */           SBabyOperatorOriginalCfg _v_ = new SBabyOperatorOriginalCfg();
/* 214 */           _v_.unmarshal(_os_);
/* 215 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 216 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 221 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 226 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBabyOperatorOriginalCfg> all)
/*     */   {
/* 233 */     String path = dir + "mzm.gsp.children.confbean.SBabyOperatorOriginalCfg.bny";
/*     */     try
/*     */     {
/* 236 */       File file = new File(path);
/* 237 */       if (file.exists())
/*     */       {
/* 239 */         byte[] bytes = new byte['Ѐ'];
/* 240 */         FileInputStream fis = new FileInputStream(file);
/* 241 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 242 */         int len = 0;
/* 243 */         while ((len = fis.read(bytes)) > 0)
/* 244 */           baos.write(bytes, 0, len);
/* 245 */         fis.close();
/* 246 */         bytes = baos.toByteArray();
/* 247 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 248 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 250 */           _os_.unmarshal_int();
/* 251 */           _os_.unmarshal_int();
/* 252 */           _os_.unmarshal_int();
/*     */         }
/* 254 */         _os_.unmarshal_int();
/* 255 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 258 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 260 */           SBabyOperatorOriginalCfg _v_ = new SBabyOperatorOriginalCfg();
/* 261 */           _v_.unmarshal(_os_);
/* 262 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 263 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 268 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 273 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBabyOperatorOriginalCfg getOld(int key)
/*     */   {
/* 281 */     return (SBabyOperatorOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBabyOperatorOriginalCfg get(int key)
/*     */   {
/* 286 */     return (SBabyOperatorOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBabyOperatorOriginalCfg> getOldAll()
/*     */   {
/* 291 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBabyOperatorOriginalCfg> getAll()
/*     */   {
/* 296 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBabyOperatorOriginalCfg> newAll)
/*     */   {
/* 301 */     oldAll = all;
/* 302 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 307 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\SBabyOperatorOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */