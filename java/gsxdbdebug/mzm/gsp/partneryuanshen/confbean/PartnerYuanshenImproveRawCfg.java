/*     */ package mzm.gsp.partneryuanshen.confbean;
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
/*     */ public class PartnerYuanshenImproveRawCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, PartnerYuanshenImproveRawCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, PartnerYuanshenImproveRawCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int position;
/*     */   public int level;
/*     */   public int frameColor;
/*     */   public int improveRequiredItemSiftId;
/*     */   public int improveRequiredItemNum;
/*  24 */   public ArrayList<Integer> propertyTypes = new ArrayList();
/*  25 */   public ArrayList<Integer> propertyRatios = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     this.position = Integer.valueOf(rootElement.attributeValue("position")).intValue();
/*  31 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  32 */     this.frameColor = Integer.valueOf(rootElement.attributeValue("frameColor")).intValue();
/*  33 */     this.improveRequiredItemSiftId = Integer.valueOf(rootElement.attributeValue("improveRequiredItemSiftId")).intValue();
/*  34 */     this.improveRequiredItemNum = Integer.valueOf(rootElement.attributeValue("improveRequiredItemNum")).intValue();
/*     */     
/*  36 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyTypes");
/*  37 */     if (collectionElement == null)
/*     */     {
/*  39 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  42 */     List<?> _nodeList = collectionElement.elements();
/*  43 */     int _len = _nodeList.size();
/*  44 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  46 */       Element elem = (Element)_nodeList.get(i);
/*  47 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  54 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  61 */         this.propertyTypes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  65 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyRatios");
/*  66 */     if (collectionElement == null)
/*     */     {
/*  68 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  71 */     List<?> _nodeList = collectionElement.elements();
/*  72 */     int _len = _nodeList.size();
/*  73 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  75 */       Element elem = (Element)_nodeList.get(i);
/*  76 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  83 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  90 */         this.propertyRatios.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  97 */     _os_.marshal(this.id);
/*  98 */     _os_.marshal(this.position);
/*  99 */     _os_.marshal(this.level);
/* 100 */     _os_.marshal(this.frameColor);
/* 101 */     _os_.marshal(this.improveRequiredItemSiftId);
/* 102 */     _os_.marshal(this.improveRequiredItemNum);
/* 103 */     _os_.compact_uint32(this.propertyTypes.size());
/* 104 */     for (Integer _v_ : this.propertyTypes)
/*     */     {
/* 106 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 108 */     _os_.compact_uint32(this.propertyRatios.size());
/* 109 */     for (Integer _v_ : this.propertyRatios)
/*     */     {
/* 111 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 113 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 118 */     this.id = _os_.unmarshal_int();
/* 119 */     this.position = _os_.unmarshal_int();
/* 120 */     this.level = _os_.unmarshal_int();
/* 121 */     this.frameColor = _os_.unmarshal_int();
/* 122 */     this.improveRequiredItemSiftId = _os_.unmarshal_int();
/* 123 */     this.improveRequiredItemNum = _os_.unmarshal_int();
/* 124 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 127 */       int _v_ = _os_.unmarshal_int();
/* 128 */       this.propertyTypes.add(Integer.valueOf(_v_));
/*     */     }
/* 130 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 133 */       int _v_ = _os_.unmarshal_int();
/* 134 */       this.propertyRatios.add(Integer.valueOf(_v_));
/*     */     }
/* 136 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 141 */     String path = dir + "mzm.gsp.partneryuanshen.confbean.PartnerYuanshenImproveRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 145 */       all = new java.util.HashMap();
/* 146 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 147 */       org.dom4j.Document doc = reader.read(new File(path));
/* 148 */       Element root = doc.getRootElement();
/* 149 */       List<?> nodeList = root.elements();
/* 150 */       int len = nodeList.size();
/* 151 */       for (int i = 0; i < len; i++)
/*     */       {
/* 153 */         Element elem = (Element)nodeList.get(i);
/* 154 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partneryuanshen.confbean.PartnerYuanshenImproveRawCfg"))
/*     */         {
/*     */ 
/* 157 */           PartnerYuanshenImproveRawCfg obj = new PartnerYuanshenImproveRawCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, PartnerYuanshenImproveRawCfg> all)
/*     */   {
/* 171 */     String path = dir + "mzm.gsp.partneryuanshen.confbean.PartnerYuanshenImproveRawCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 175 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 176 */       org.dom4j.Document doc = reader.read(new File(path));
/* 177 */       Element root = doc.getRootElement();
/* 178 */       List<?> nodeList = root.elements();
/* 179 */       int len = nodeList.size();
/* 180 */       for (int i = 0; i < len; i++)
/*     */       {
/* 182 */         Element elem = (Element)nodeList.get(i);
/* 183 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partneryuanshen.confbean.PartnerYuanshenImproveRawCfg"))
/*     */         {
/*     */ 
/* 186 */           PartnerYuanshenImproveRawCfg obj = new PartnerYuanshenImproveRawCfg();
/* 187 */           obj.loadFromXml(elem);
/* 188 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 189 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 194 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 200 */     all = new java.util.HashMap();
/*     */     
/* 202 */     String path = dir + "mzm.gsp.partneryuanshen.confbean.PartnerYuanshenImproveRawCfg.bny";
/*     */     try
/*     */     {
/* 205 */       File file = new File(path);
/* 206 */       if (file.exists())
/*     */       {
/* 208 */         byte[] bytes = new byte['Ѐ'];
/* 209 */         FileInputStream fis = new FileInputStream(file);
/* 210 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 211 */         int len = 0;
/* 212 */         while ((len = fis.read(bytes)) > 0)
/* 213 */           baos.write(bytes, 0, len);
/* 214 */         fis.close();
/* 215 */         bytes = baos.toByteArray();
/* 216 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 219 */           _os_.unmarshal_int();
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/*     */         }
/* 223 */         _os_.unmarshal_int();
/* 224 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 227 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 229 */           PartnerYuanshenImproveRawCfg _v_ = new PartnerYuanshenImproveRawCfg();
/* 230 */           _v_.unmarshal(_os_);
/* 231 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 232 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 237 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 242 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, PartnerYuanshenImproveRawCfg> all)
/*     */   {
/* 249 */     String path = dir + "mzm.gsp.partneryuanshen.confbean.PartnerYuanshenImproveRawCfg.bny";
/*     */     try
/*     */     {
/* 252 */       File file = new File(path);
/* 253 */       if (file.exists())
/*     */       {
/* 255 */         byte[] bytes = new byte['Ѐ'];
/* 256 */         FileInputStream fis = new FileInputStream(file);
/* 257 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 258 */         int len = 0;
/* 259 */         while ((len = fis.read(bytes)) > 0)
/* 260 */           baos.write(bytes, 0, len);
/* 261 */         fis.close();
/* 262 */         bytes = baos.toByteArray();
/* 263 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 264 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 266 */           _os_.unmarshal_int();
/* 267 */           _os_.unmarshal_int();
/* 268 */           _os_.unmarshal_int();
/*     */         }
/* 270 */         _os_.unmarshal_int();
/* 271 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 274 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 276 */           PartnerYuanshenImproveRawCfg _v_ = new PartnerYuanshenImproveRawCfg();
/* 277 */           _v_.unmarshal(_os_);
/* 278 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 279 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 284 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 289 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static PartnerYuanshenImproveRawCfg getOld(int key)
/*     */   {
/* 297 */     return (PartnerYuanshenImproveRawCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static PartnerYuanshenImproveRawCfg get(int key)
/*     */   {
/* 302 */     return (PartnerYuanshenImproveRawCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, PartnerYuanshenImproveRawCfg> getOldAll()
/*     */   {
/* 307 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, PartnerYuanshenImproveRawCfg> getAll()
/*     */   {
/* 312 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, PartnerYuanshenImproveRawCfg> newAll)
/*     */   {
/* 317 */     oldAll = all;
/* 318 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 323 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\confbean\PartnerYuanshenImproveRawCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */