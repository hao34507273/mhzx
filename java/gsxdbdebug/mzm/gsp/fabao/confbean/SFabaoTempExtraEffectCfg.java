/*     */ package mzm.gsp.fabao.confbean;
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
/*     */ public class SFabaoTempExtraEffectCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFabaoTempExtraEffectCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFabaoTempExtraEffectCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int fabaoMinLv;
/*     */   public int roleLv;
/*  21 */   public HashMap<Integer, Integer> proMap = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.fabaoMinLv = Integer.valueOf(rootElement.attributeValue("fabaoMinLv")).intValue();
/*  27 */     this.roleLv = Integer.valueOf(rootElement.attributeValue("roleLv")).intValue();
/*     */     
/*  29 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "proMap");
/*  30 */     if (mapTypeElement == null)
/*     */     {
/*  32 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  35 */     List<?> entryNodeList = mapTypeElement.elements();
/*  36 */     int entryLen = entryNodeList.size();
/*  37 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  39 */       Element entryElement = (Element)entryNodeList.get(i);
/*  40 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  45 */         Element keyElem = null;
/*  46 */         Element valueElem = null;
/*     */         
/*  48 */         List<?> _nodeList = entryElement.elements();
/*  49 */         int _len = _nodeList.size();
/*  50 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  52 */           Element elem = (Element)_nodeList.get(j);
/*  53 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  55 */             keyElem = elem;
/*     */           }
/*  57 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  59 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  63 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  65 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  72 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  73 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  80 */         this.proMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  87 */     _os_.marshal(this.id);
/*  88 */     _os_.marshal(this.fabaoMinLv);
/*  89 */     _os_.marshal(this.roleLv);
/*  90 */     _os_.compact_uint32(this.proMap.size());
/*  91 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.proMap.entrySet())
/*     */     {
/*  93 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  94 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  96 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 101 */     this.id = _os_.unmarshal_int();
/* 102 */     this.fabaoMinLv = _os_.unmarshal_int();
/* 103 */     this.roleLv = _os_.unmarshal_int();
/* 104 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 107 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 109 */       int _v_ = _os_.unmarshal_int();
/* 110 */       this.proMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoTempExtraEffectCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       all = new HashMap();
/* 122 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 123 */       org.dom4j.Document doc = reader.read(new File(path));
/* 124 */       Element root = doc.getRootElement();
/* 125 */       List<?> nodeList = root.elements();
/* 126 */       int len = nodeList.size();
/* 127 */       for (int i = 0; i < len; i++)
/*     */       {
/* 129 */         Element elem = (Element)nodeList.get(i);
/* 130 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fabao.confbean.SFabaoTempExtraEffectCfg"))
/*     */         {
/*     */ 
/* 133 */           SFabaoTempExtraEffectCfg obj = new SFabaoTempExtraEffectCfg();
/* 134 */           obj.loadFromXml(elem);
/* 135 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 136 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 141 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFabaoTempExtraEffectCfg> all)
/*     */   {
/* 147 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoTempExtraEffectCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 151 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 152 */       org.dom4j.Document doc = reader.read(new File(path));
/* 153 */       Element root = doc.getRootElement();
/* 154 */       List<?> nodeList = root.elements();
/* 155 */       int len = nodeList.size();
/* 156 */       for (int i = 0; i < len; i++)
/*     */       {
/* 158 */         Element elem = (Element)nodeList.get(i);
/* 159 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fabao.confbean.SFabaoTempExtraEffectCfg"))
/*     */         {
/*     */ 
/* 162 */           SFabaoTempExtraEffectCfg obj = new SFabaoTempExtraEffectCfg();
/* 163 */           obj.loadFromXml(elem);
/* 164 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 165 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 170 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 176 */     all = new HashMap();
/*     */     
/* 178 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoTempExtraEffectCfg.bny";
/*     */     try
/*     */     {
/* 181 */       File file = new File(path);
/* 182 */       if (file.exists())
/*     */       {
/* 184 */         byte[] bytes = new byte['Ѐ'];
/* 185 */         FileInputStream fis = new FileInputStream(file);
/* 186 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 187 */         int len = 0;
/* 188 */         while ((len = fis.read(bytes)) > 0)
/* 189 */           baos.write(bytes, 0, len);
/* 190 */         fis.close();
/* 191 */         bytes = baos.toByteArray();
/* 192 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 193 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 195 */           _os_.unmarshal_int();
/* 196 */           _os_.unmarshal_int();
/* 197 */           _os_.unmarshal_int();
/*     */         }
/* 199 */         _os_.unmarshal_int();
/* 200 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 203 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 205 */           SFabaoTempExtraEffectCfg _v_ = new SFabaoTempExtraEffectCfg();
/* 206 */           _v_.unmarshal(_os_);
/* 207 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 208 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 213 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 218 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFabaoTempExtraEffectCfg> all)
/*     */   {
/* 225 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoTempExtraEffectCfg.bny";
/*     */     try
/*     */     {
/* 228 */       File file = new File(path);
/* 229 */       if (file.exists())
/*     */       {
/* 231 */         byte[] bytes = new byte['Ѐ'];
/* 232 */         FileInputStream fis = new FileInputStream(file);
/* 233 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 234 */         int len = 0;
/* 235 */         while ((len = fis.read(bytes)) > 0)
/* 236 */           baos.write(bytes, 0, len);
/* 237 */         fis.close();
/* 238 */         bytes = baos.toByteArray();
/* 239 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 240 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 242 */           _os_.unmarshal_int();
/* 243 */           _os_.unmarshal_int();
/* 244 */           _os_.unmarshal_int();
/*     */         }
/* 246 */         _os_.unmarshal_int();
/* 247 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 250 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 252 */           SFabaoTempExtraEffectCfg _v_ = new SFabaoTempExtraEffectCfg();
/* 253 */           _v_.unmarshal(_os_);
/* 254 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 255 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 260 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 265 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFabaoTempExtraEffectCfg getOld(int key)
/*     */   {
/* 273 */     return (SFabaoTempExtraEffectCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFabaoTempExtraEffectCfg get(int key)
/*     */   {
/* 278 */     return (SFabaoTempExtraEffectCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFabaoTempExtraEffectCfg> getOldAll()
/*     */   {
/* 283 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFabaoTempExtraEffectCfg> getAll()
/*     */   {
/* 288 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFabaoTempExtraEffectCfg> newAll)
/*     */   {
/* 293 */     oldAll = all;
/* 294 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 299 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\confbean\SFabaoTempExtraEffectCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */