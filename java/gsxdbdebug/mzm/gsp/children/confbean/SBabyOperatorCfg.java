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
/*     */ public class SBabyOperatorCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBabyOperatorCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBabyOperatorCfg> all = null;
/*     */   
/*     */   public int operator;
/*  19 */   public ArrayList<BabyOperatorCostBean> cost_currency_list = new ArrayList();
/*  20 */   public ArrayList<BabyOperatorPropertyBean> add_property_list = new ArrayList();
/*     */   public int operator_cd_time;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.operator = Integer.valueOf(rootElement.attributeValue("operator")).intValue();
/*     */     
/*  27 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "cost_currency_list");
/*  28 */     if (collectionElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> _nodeList = collectionElement.elements();
/*  34 */     int _len = _nodeList.size();
/*  35 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  37 */       Element elem = (Element)_nodeList.get(i);
/*  38 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.BabyOperatorCostBean"))
/*     */       {
/*     */         BabyOperatorCostBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  45 */           _v_ = new BabyOperatorCostBean();
/*  46 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  53 */         this.cost_currency_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  57 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "add_property_list");
/*  58 */     if (collectionElement == null)
/*     */     {
/*  60 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  63 */     List<?> _nodeList = collectionElement.elements();
/*  64 */     int _len = _nodeList.size();
/*  65 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  67 */       Element elem = (Element)_nodeList.get(i);
/*  68 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.BabyOperatorPropertyBean"))
/*     */       {
/*     */         BabyOperatorPropertyBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  75 */           _v_ = new BabyOperatorPropertyBean();
/*  76 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.add_property_list.add(_v_);
/*     */       }
/*     */     }
/*  86 */     this.operator_cd_time = Integer.valueOf(rootElement.attributeValue("operator_cd_time")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  91 */     _os_.marshal(this.operator);
/*  92 */     _os_.compact_uint32(this.cost_currency_list.size());
/*  93 */     for (BabyOperatorCostBean _v_ : this.cost_currency_list)
/*     */     {
/*  95 */       _os_.marshal(_v_);
/*     */     }
/*  97 */     _os_.compact_uint32(this.add_property_list.size());
/*  98 */     for (BabyOperatorPropertyBean _v_ : this.add_property_list)
/*     */     {
/* 100 */       _os_.marshal(_v_);
/*     */     }
/* 102 */     _os_.marshal(this.operator_cd_time);
/* 103 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 108 */     this.operator = _os_.unmarshal_int();
/* 109 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 112 */       BabyOperatorCostBean _v_ = new BabyOperatorCostBean();
/* 113 */       _v_.unmarshal(_os_);
/* 114 */       this.cost_currency_list.add(_v_);
/*     */     }
/* 116 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 119 */       BabyOperatorPropertyBean _v_ = new BabyOperatorPropertyBean();
/* 120 */       _v_.unmarshal(_os_);
/* 121 */       this.add_property_list.add(_v_);
/*     */     }
/* 123 */     this.operator_cd_time = _os_.unmarshal_int();
/* 124 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.children.confbean.SBabyOperatorCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 133 */       all = new java.util.HashMap();
/* 134 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 135 */       org.dom4j.Document doc = reader.read(new File(path));
/* 136 */       Element root = doc.getRootElement();
/* 137 */       List<?> nodeList = root.elements();
/* 138 */       int len = nodeList.size();
/* 139 */       for (int i = 0; i < len; i++)
/*     */       {
/* 141 */         Element elem = (Element)nodeList.get(i);
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SBabyOperatorCfg"))
/*     */         {
/*     */ 
/* 145 */           SBabyOperatorCfg obj = new SBabyOperatorCfg();
/* 146 */           obj.loadFromXml(elem);
/* 147 */           if (all.put(Integer.valueOf(obj.operator), obj) != null) {
/* 148 */             throw new RuntimeException("duplicate key : " + obj.operator);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBabyOperatorCfg> all)
/*     */   {
/* 159 */     String path = dir + "mzm.gsp.children.confbean.SBabyOperatorCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 163 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 164 */       org.dom4j.Document doc = reader.read(new File(path));
/* 165 */       Element root = doc.getRootElement();
/* 166 */       List<?> nodeList = root.elements();
/* 167 */       int len = nodeList.size();
/* 168 */       for (int i = 0; i < len; i++)
/*     */       {
/* 170 */         Element elem = (Element)nodeList.get(i);
/* 171 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SBabyOperatorCfg"))
/*     */         {
/*     */ 
/* 174 */           SBabyOperatorCfg obj = new SBabyOperatorCfg();
/* 175 */           obj.loadFromXml(elem);
/* 176 */           if (all.put(Integer.valueOf(obj.operator), obj) != null) {
/* 177 */             throw new RuntimeException("duplicate key : " + obj.operator);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 182 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 188 */     all = new java.util.HashMap();
/*     */     
/* 190 */     String path = dir + "mzm.gsp.children.confbean.SBabyOperatorCfg.bny";
/*     */     try
/*     */     {
/* 193 */       File file = new File(path);
/* 194 */       if (file.exists())
/*     */       {
/* 196 */         byte[] bytes = new byte['Ѐ'];
/* 197 */         FileInputStream fis = new FileInputStream(file);
/* 198 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 199 */         int len = 0;
/* 200 */         while ((len = fis.read(bytes)) > 0)
/* 201 */           baos.write(bytes, 0, len);
/* 202 */         fis.close();
/* 203 */         bytes = baos.toByteArray();
/* 204 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 207 */           _os_.unmarshal_int();
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/*     */         }
/* 211 */         _os_.unmarshal_int();
/* 212 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 215 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 217 */           SBabyOperatorCfg _v_ = new SBabyOperatorCfg();
/* 218 */           _v_.unmarshal(_os_);
/* 219 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 220 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 225 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 230 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBabyOperatorCfg> all)
/*     */   {
/* 237 */     String path = dir + "mzm.gsp.children.confbean.SBabyOperatorCfg.bny";
/*     */     try
/*     */     {
/* 240 */       File file = new File(path);
/* 241 */       if (file.exists())
/*     */       {
/* 243 */         byte[] bytes = new byte['Ѐ'];
/* 244 */         FileInputStream fis = new FileInputStream(file);
/* 245 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 246 */         int len = 0;
/* 247 */         while ((len = fis.read(bytes)) > 0)
/* 248 */           baos.write(bytes, 0, len);
/* 249 */         fis.close();
/* 250 */         bytes = baos.toByteArray();
/* 251 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 252 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 254 */           _os_.unmarshal_int();
/* 255 */           _os_.unmarshal_int();
/* 256 */           _os_.unmarshal_int();
/*     */         }
/* 258 */         _os_.unmarshal_int();
/* 259 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 262 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 264 */           SBabyOperatorCfg _v_ = new SBabyOperatorCfg();
/* 265 */           _v_.unmarshal(_os_);
/* 266 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 267 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 272 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 277 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBabyOperatorCfg getOld(int key)
/*     */   {
/* 285 */     return (SBabyOperatorCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBabyOperatorCfg get(int key)
/*     */   {
/* 290 */     return (SBabyOperatorCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBabyOperatorCfg> getOldAll()
/*     */   {
/* 295 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBabyOperatorCfg> getAll()
/*     */   {
/* 300 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBabyOperatorCfg> newAll)
/*     */   {
/* 305 */     oldAll = all;
/* 306 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 311 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\SBabyOperatorCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */