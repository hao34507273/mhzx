/*     */ package mzm.gsp.qingfu.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SLevelGrowthFundCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLevelGrowthFundCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLevelGrowthFundCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int serviceId;
/*  20 */   public HashMap<Integer, SLevelGrowthFundActivityAwardInfo> award_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  25 */     this.serviceId = Integer.valueOf(rootElement.attributeValue("serviceId")).intValue();
/*     */     
/*  27 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "award_infos");
/*  28 */     if (mapTypeElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> entryNodeList = mapTypeElement.elements();
/*  34 */     int entryLen = entryNodeList.size();
/*  35 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  37 */       Element entryElement = (Element)entryNodeList.get(i);
/*  38 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  43 */         Element keyElem = null;
/*  44 */         Element valueElem = null;
/*     */         
/*  46 */         List<?> _nodeList = entryElement.elements();
/*  47 */         int _len = _nodeList.size();
/*  48 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  50 */           Element elem = (Element)_nodeList.get(j);
/*  51 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  53 */             keyElem = elem;
/*     */           }
/*  55 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.SLevelGrowthFundActivityAwardInfo")))
/*     */           {
/*  57 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  61 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  63 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SLevelGrowthFundActivityAwardInfo _v_;
/*     */         try
/*     */         {
/*  70 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  71 */           _v_ = new SLevelGrowthFundActivityAwardInfo();
/*  72 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  79 */         this.award_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  86 */     _os_.marshal(this.id);
/*  87 */     _os_.marshal(this.serviceId);
/*  88 */     _os_.compact_uint32(this.award_infos.size());
/*  89 */     for (java.util.Map.Entry<Integer, SLevelGrowthFundActivityAwardInfo> _e_ : this.award_infos.entrySet())
/*     */     {
/*  91 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  92 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     this.id = _os_.unmarshal_int();
/* 100 */     this.serviceId = _os_.unmarshal_int();
/* 101 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 104 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 106 */       SLevelGrowthFundActivityAwardInfo _v_ = new SLevelGrowthFundActivityAwardInfo();
/* 107 */       _v_.unmarshal(_os_);
/* 108 */       this.award_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 110 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 115 */     String path = dir + "mzm.gsp.qingfu.confbean.SLevelGrowthFundCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 119 */       all = new HashMap();
/* 120 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 121 */       org.dom4j.Document doc = reader.read(new File(path));
/* 122 */       Element root = doc.getRootElement();
/* 123 */       List<?> nodeList = root.elements();
/* 124 */       int len = nodeList.size();
/* 125 */       for (int i = 0; i < len; i++)
/*     */       {
/* 127 */         Element elem = (Element)nodeList.get(i);
/* 128 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.SLevelGrowthFundCfg"))
/*     */         {
/*     */ 
/* 131 */           SLevelGrowthFundCfg obj = new SLevelGrowthFundCfg();
/* 132 */           obj.loadFromXml(elem);
/* 133 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 134 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 139 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLevelGrowthFundCfg> all)
/*     */   {
/* 145 */     String path = dir + "mzm.gsp.qingfu.confbean.SLevelGrowthFundCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 149 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 150 */       org.dom4j.Document doc = reader.read(new File(path));
/* 151 */       Element root = doc.getRootElement();
/* 152 */       List<?> nodeList = root.elements();
/* 153 */       int len = nodeList.size();
/* 154 */       for (int i = 0; i < len; i++)
/*     */       {
/* 156 */         Element elem = (Element)nodeList.get(i);
/* 157 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.SLevelGrowthFundCfg"))
/*     */         {
/*     */ 
/* 160 */           SLevelGrowthFundCfg obj = new SLevelGrowthFundCfg();
/* 161 */           obj.loadFromXml(elem);
/* 162 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 163 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 174 */     all = new HashMap();
/*     */     
/* 176 */     String path = dir + "mzm.gsp.qingfu.confbean.SLevelGrowthFundCfg.bny";
/*     */     try
/*     */     {
/* 179 */       File file = new File(path);
/* 180 */       if (file.exists())
/*     */       {
/* 182 */         byte[] bytes = new byte['Ѐ'];
/* 183 */         FileInputStream fis = new FileInputStream(file);
/* 184 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 185 */         int len = 0;
/* 186 */         while ((len = fis.read(bytes)) > 0)
/* 187 */           baos.write(bytes, 0, len);
/* 188 */         fis.close();
/* 189 */         bytes = baos.toByteArray();
/* 190 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 191 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 193 */           _os_.unmarshal_int();
/* 194 */           _os_.unmarshal_int();
/* 195 */           _os_.unmarshal_int();
/*     */         }
/* 197 */         _os_.unmarshal_int();
/* 198 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 201 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 203 */           SLevelGrowthFundCfg _v_ = new SLevelGrowthFundCfg();
/* 204 */           _v_.unmarshal(_os_);
/* 205 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 206 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 211 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLevelGrowthFundCfg> all)
/*     */   {
/* 223 */     String path = dir + "mzm.gsp.qingfu.confbean.SLevelGrowthFundCfg.bny";
/*     */     try
/*     */     {
/* 226 */       File file = new File(path);
/* 227 */       if (file.exists())
/*     */       {
/* 229 */         byte[] bytes = new byte['Ѐ'];
/* 230 */         FileInputStream fis = new FileInputStream(file);
/* 231 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 232 */         int len = 0;
/* 233 */         while ((len = fis.read(bytes)) > 0)
/* 234 */           baos.write(bytes, 0, len);
/* 235 */         fis.close();
/* 236 */         bytes = baos.toByteArray();
/* 237 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 238 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/* 242 */           _os_.unmarshal_int();
/*     */         }
/* 244 */         _os_.unmarshal_int();
/* 245 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 248 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 250 */           SLevelGrowthFundCfg _v_ = new SLevelGrowthFundCfg();
/* 251 */           _v_.unmarshal(_os_);
/* 252 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 253 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 258 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 263 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SLevelGrowthFundCfg getOld(int key)
/*     */   {
/* 271 */     return (SLevelGrowthFundCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLevelGrowthFundCfg get(int key)
/*     */   {
/* 276 */     return (SLevelGrowthFundCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLevelGrowthFundCfg> getOldAll()
/*     */   {
/* 281 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLevelGrowthFundCfg> getAll()
/*     */   {
/* 286 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLevelGrowthFundCfg> newAll)
/*     */   {
/* 291 */     oldAll = all;
/* 292 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 297 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\SLevelGrowthFundCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */