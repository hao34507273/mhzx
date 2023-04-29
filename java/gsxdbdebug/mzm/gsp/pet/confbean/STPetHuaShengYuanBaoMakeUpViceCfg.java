/*     */ package mzm.gsp.pet.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class STPetHuaShengYuanBaoMakeUpViceCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STPetHuaShengYuanBaoMakeUpViceCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STPetHuaShengYuanBaoMakeUpViceCfg> all = null;
/*     */   
/*     */   public int vicePetMinRoleLevel;
/*  19 */   public TreeMap<Integer, VicePetSkillPriceInfo> skillBookPrice2vicePetSkillPriceInfo = new TreeMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.vicePetMinRoleLevel = Integer.valueOf(rootElement.attributeValue("vicePetMinRoleLevel")).intValue();
/*     */     
/*  25 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "skillBookPrice2vicePetSkillPriceInfo");
/*  26 */     if (mapTypeElement == null)
/*     */     {
/*  28 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  31 */     List<?> entryNodeList = mapTypeElement.elements();
/*  32 */     int entryLen = entryNodeList.size();
/*  33 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  35 */       Element entryElement = (Element)entryNodeList.get(i);
/*  36 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  41 */         Element keyElem = null;
/*  42 */         Element valueElem = null;
/*     */         
/*  44 */         List<?> _nodeList = entryElement.elements();
/*  45 */         int _len = _nodeList.size();
/*  46 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  48 */           Element elem = (Element)_nodeList.get(j);
/*  49 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  51 */             keyElem = elem;
/*     */           }
/*  53 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.VicePetSkillPriceInfo")))
/*     */           {
/*  55 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  59 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  61 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         VicePetSkillPriceInfo _v_;
/*     */         try
/*     */         {
/*  68 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  69 */           _v_ = new VicePetSkillPriceInfo();
/*  70 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  77 */         this.skillBookPrice2vicePetSkillPriceInfo.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  84 */     _os_.marshal(this.vicePetMinRoleLevel);
/*  85 */     _os_.compact_uint32(this.skillBookPrice2vicePetSkillPriceInfo.size());
/*  86 */     for (java.util.Map.Entry<Integer, VicePetSkillPriceInfo> _e_ : this.skillBookPrice2vicePetSkillPriceInfo.entrySet())
/*     */     {
/*  88 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  89 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     this.vicePetMinRoleLevel = _os_.unmarshal_int();
/*  97 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 100 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 102 */       VicePetSkillPriceInfo _v_ = new VicePetSkillPriceInfo();
/* 103 */       _v_.unmarshal(_os_);
/* 104 */       this.skillBookPrice2vicePetSkillPriceInfo.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 106 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 111 */     String path = dir + "mzm.gsp.pet.confbean.STPetHuaShengYuanBaoMakeUpViceCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 115 */       all = new java.util.HashMap();
/* 116 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 117 */       org.dom4j.Document doc = reader.read(new File(path));
/* 118 */       Element root = doc.getRootElement();
/* 119 */       List<?> nodeList = root.elements();
/* 120 */       int len = nodeList.size();
/* 121 */       for (int i = 0; i < len; i++)
/*     */       {
/* 123 */         Element elem = (Element)nodeList.get(i);
/* 124 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.STPetHuaShengYuanBaoMakeUpViceCfg"))
/*     */         {
/*     */ 
/* 127 */           STPetHuaShengYuanBaoMakeUpViceCfg obj = new STPetHuaShengYuanBaoMakeUpViceCfg();
/* 128 */           obj.loadFromXml(elem);
/* 129 */           if (all.put(Integer.valueOf(obj.vicePetMinRoleLevel), obj) != null) {
/* 130 */             throw new RuntimeException("duplicate key : " + obj.vicePetMinRoleLevel);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 135 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STPetHuaShengYuanBaoMakeUpViceCfg> all)
/*     */   {
/* 141 */     String path = dir + "mzm.gsp.pet.confbean.STPetHuaShengYuanBaoMakeUpViceCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 145 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 146 */       org.dom4j.Document doc = reader.read(new File(path));
/* 147 */       Element root = doc.getRootElement();
/* 148 */       List<?> nodeList = root.elements();
/* 149 */       int len = nodeList.size();
/* 150 */       for (int i = 0; i < len; i++)
/*     */       {
/* 152 */         Element elem = (Element)nodeList.get(i);
/* 153 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.STPetHuaShengYuanBaoMakeUpViceCfg"))
/*     */         {
/*     */ 
/* 156 */           STPetHuaShengYuanBaoMakeUpViceCfg obj = new STPetHuaShengYuanBaoMakeUpViceCfg();
/* 157 */           obj.loadFromXml(elem);
/* 158 */           if (all.put(Integer.valueOf(obj.vicePetMinRoleLevel), obj) != null) {
/* 159 */             throw new RuntimeException("duplicate key : " + obj.vicePetMinRoleLevel);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 170 */     all = new java.util.HashMap();
/*     */     
/* 172 */     String path = dir + "mzm.gsp.pet.confbean.STPetHuaShengYuanBaoMakeUpViceCfg.bny";
/*     */     try
/*     */     {
/* 175 */       File file = new File(path);
/* 176 */       if (file.exists())
/*     */       {
/* 178 */         byte[] bytes = new byte['Ѐ'];
/* 179 */         FileInputStream fis = new FileInputStream(file);
/* 180 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 181 */         int len = 0;
/* 182 */         while ((len = fis.read(bytes)) > 0)
/* 183 */           baos.write(bytes, 0, len);
/* 184 */         fis.close();
/* 185 */         bytes = baos.toByteArray();
/* 186 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 187 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 189 */           _os_.unmarshal_int();
/* 190 */           _os_.unmarshal_int();
/* 191 */           _os_.unmarshal_int();
/*     */         }
/* 193 */         _os_.unmarshal_int();
/* 194 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 197 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 199 */           STPetHuaShengYuanBaoMakeUpViceCfg _v_ = new STPetHuaShengYuanBaoMakeUpViceCfg();
/* 200 */           _v_.unmarshal(_os_);
/* 201 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 202 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 207 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 212 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STPetHuaShengYuanBaoMakeUpViceCfg> all)
/*     */   {
/* 219 */     String path = dir + "mzm.gsp.pet.confbean.STPetHuaShengYuanBaoMakeUpViceCfg.bny";
/*     */     try
/*     */     {
/* 222 */       File file = new File(path);
/* 223 */       if (file.exists())
/*     */       {
/* 225 */         byte[] bytes = new byte['Ѐ'];
/* 226 */         FileInputStream fis = new FileInputStream(file);
/* 227 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 228 */         int len = 0;
/* 229 */         while ((len = fis.read(bytes)) > 0)
/* 230 */           baos.write(bytes, 0, len);
/* 231 */         fis.close();
/* 232 */         bytes = baos.toByteArray();
/* 233 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 234 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 236 */           _os_.unmarshal_int();
/* 237 */           _os_.unmarshal_int();
/* 238 */           _os_.unmarshal_int();
/*     */         }
/* 240 */         _os_.unmarshal_int();
/* 241 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 244 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 246 */           STPetHuaShengYuanBaoMakeUpViceCfg _v_ = new STPetHuaShengYuanBaoMakeUpViceCfg();
/* 247 */           _v_.unmarshal(_os_);
/* 248 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 249 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 254 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 259 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STPetHuaShengYuanBaoMakeUpViceCfg getOld(int key)
/*     */   {
/* 267 */     return (STPetHuaShengYuanBaoMakeUpViceCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STPetHuaShengYuanBaoMakeUpViceCfg get(int key)
/*     */   {
/* 272 */     return (STPetHuaShengYuanBaoMakeUpViceCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STPetHuaShengYuanBaoMakeUpViceCfg> getOldAll()
/*     */   {
/* 277 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STPetHuaShengYuanBaoMakeUpViceCfg> getAll()
/*     */   {
/* 282 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STPetHuaShengYuanBaoMakeUpViceCfg> newAll)
/*     */   {
/* 287 */     oldAll = all;
/* 288 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 293 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\STPetHuaShengYuanBaoMakeUpViceCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */