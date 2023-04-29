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
/*     */ public class SItemEquipCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SItemEquipCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SItemEquipCfg> all = null;
/*     */   
/*     */   public int menpai;
/*     */   public int sex;
/*     */   public int equipmodel;
/*     */   public int equipspecileffect;
/*     */   public int wearpos;
/*     */   public int attrA;
/*     */   public int attrAvaluemin;
/*     */   public int attrAvaluemax;
/*     */   public int attrB;
/*     */   public int attrBvaluemin;
/*     */   public int attrBvaluemax;
/*     */   public int exattrprobId;
/*     */   public int qilinTypeid;
/*     */   public int extraHunMaxNum;
/*  33 */   public java.util.ArrayList<Integer> hunNumberRates = new java.util.ArrayList();
/*     */   public int skillid;
/*     */   public int skillProb;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  39 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  40 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  41 */     this.name = rootElement.attributeValue("name");
/*  42 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  43 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  44 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  45 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  46 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  47 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  48 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  49 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  50 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  51 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  52 */     this.menpai = Integer.valueOf(rootElement.attributeValue("menpai")).intValue();
/*  53 */     this.sex = Integer.valueOf(rootElement.attributeValue("sex")).intValue();
/*  54 */     this.equipmodel = Integer.valueOf(rootElement.attributeValue("equipmodel")).intValue();
/*  55 */     this.equipspecileffect = Integer.valueOf(rootElement.attributeValue("equipspecileffect")).intValue();
/*  56 */     this.wearpos = Integer.valueOf(rootElement.attributeValue("wearpos")).intValue();
/*  57 */     this.attrA = Integer.valueOf(rootElement.attributeValue("attrA")).intValue();
/*  58 */     this.attrAvaluemin = Integer.valueOf(rootElement.attributeValue("attrAvaluemin")).intValue();
/*  59 */     this.attrAvaluemax = Integer.valueOf(rootElement.attributeValue("attrAvaluemax")).intValue();
/*  60 */     this.attrB = Integer.valueOf(rootElement.attributeValue("attrB")).intValue();
/*  61 */     this.attrBvaluemin = Integer.valueOf(rootElement.attributeValue("attrBvaluemin")).intValue();
/*  62 */     this.attrBvaluemax = Integer.valueOf(rootElement.attributeValue("attrBvaluemax")).intValue();
/*  63 */     this.exattrprobId = Integer.valueOf(rootElement.attributeValue("exattrprobId")).intValue();
/*  64 */     this.qilinTypeid = Integer.valueOf(rootElement.attributeValue("qilinTypeid")).intValue();
/*  65 */     this.extraHunMaxNum = Integer.valueOf(rootElement.attributeValue("extraHunMaxNum")).intValue();
/*     */     
/*  67 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "hunNumberRates");
/*  68 */     if (collectionElement == null)
/*     */     {
/*  70 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  73 */     List<?> _nodeList = collectionElement.elements();
/*  74 */     int _len = _nodeList.size();
/*  75 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  77 */       Element elem = (Element)_nodeList.get(i);
/*  78 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  85 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  92 */         this.hunNumberRates.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  95 */     this.skillid = Integer.valueOf(rootElement.attributeValue("skillid")).intValue();
/*  96 */     this.skillProb = Integer.valueOf(rootElement.attributeValue("skillProb")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 101 */     _os_.marshal(this.id);
/* 102 */     _os_.marshal(this.type);
/* 103 */     _os_.marshal(this.name, "UTF-8");
/* 104 */     _os_.marshal(this.namecolor);
/* 105 */     _os_.marshal(this.icon);
/* 106 */     _os_.marshal(this.pilemax);
/* 107 */     _os_.marshal(this.sellSilver);
/* 108 */     _os_.marshal(this.isProprietary);
/* 109 */     _os_.marshal(this.canSellAndThrow);
/* 110 */     _os_.marshal(this.awardRoleLevelMin);
/* 111 */     _os_.marshal(this.awardRoleLevelMax);
/* 112 */     _os_.marshal(this.useLevel);
/* 113 */     _os_.marshal(this.sort);
/* 114 */     _os_.marshal(this.menpai);
/* 115 */     _os_.marshal(this.sex);
/* 116 */     _os_.marshal(this.equipmodel);
/* 117 */     _os_.marshal(this.equipspecileffect);
/* 118 */     _os_.marshal(this.wearpos);
/* 119 */     _os_.marshal(this.attrA);
/* 120 */     _os_.marshal(this.attrAvaluemin);
/* 121 */     _os_.marshal(this.attrAvaluemax);
/* 122 */     _os_.marshal(this.attrB);
/* 123 */     _os_.marshal(this.attrBvaluemin);
/* 124 */     _os_.marshal(this.attrBvaluemax);
/* 125 */     _os_.marshal(this.exattrprobId);
/* 126 */     _os_.marshal(this.qilinTypeid);
/* 127 */     _os_.marshal(this.extraHunMaxNum);
/* 128 */     _os_.compact_uint32(this.hunNumberRates.size());
/* 129 */     for (Integer _v_ : this.hunNumberRates)
/*     */     {
/* 131 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 133 */     _os_.marshal(this.skillid);
/* 134 */     _os_.marshal(this.skillProb);
/* 135 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 140 */     this.id = _os_.unmarshal_int();
/* 141 */     this.type = _os_.unmarshal_int();
/* 142 */     this.name = _os_.unmarshal_String("UTF-8");
/* 143 */     this.namecolor = _os_.unmarshal_int();
/* 144 */     this.icon = _os_.unmarshal_int();
/* 145 */     this.pilemax = _os_.unmarshal_int();
/* 146 */     this.sellSilver = _os_.unmarshal_int();
/* 147 */     this.isProprietary = _os_.unmarshal_boolean();
/* 148 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/* 149 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/* 150 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/* 151 */     this.useLevel = _os_.unmarshal_int();
/* 152 */     this.sort = _os_.unmarshal_int();
/* 153 */     this.menpai = _os_.unmarshal_int();
/* 154 */     this.sex = _os_.unmarshal_int();
/* 155 */     this.equipmodel = _os_.unmarshal_int();
/* 156 */     this.equipspecileffect = _os_.unmarshal_int();
/* 157 */     this.wearpos = _os_.unmarshal_int();
/* 158 */     this.attrA = _os_.unmarshal_int();
/* 159 */     this.attrAvaluemin = _os_.unmarshal_int();
/* 160 */     this.attrAvaluemax = _os_.unmarshal_int();
/* 161 */     this.attrB = _os_.unmarshal_int();
/* 162 */     this.attrBvaluemin = _os_.unmarshal_int();
/* 163 */     this.attrBvaluemax = _os_.unmarshal_int();
/* 164 */     this.exattrprobId = _os_.unmarshal_int();
/* 165 */     this.qilinTypeid = _os_.unmarshal_int();
/* 166 */     this.extraHunMaxNum = _os_.unmarshal_int();
/* 167 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 170 */       int _v_ = _os_.unmarshal_int();
/* 171 */       this.hunNumberRates.add(Integer.valueOf(_v_));
/*     */     }
/* 173 */     this.skillid = _os_.unmarshal_int();
/* 174 */     this.skillProb = _os_.unmarshal_int();
/* 175 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 180 */     String path = dir + "mzm.gsp.item.confbean.SItemEquipCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 184 */       all = new java.util.HashMap();
/* 185 */       SAXReader reader = new SAXReader();
/* 186 */       org.dom4j.Document doc = reader.read(new File(path));
/* 187 */       Element root = doc.getRootElement();
/* 188 */       List<?> nodeList = root.elements();
/* 189 */       int len = nodeList.size();
/* 190 */       for (int i = 0; i < len; i++)
/*     */       {
/* 192 */         Element elem = (Element)nodeList.get(i);
/* 193 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemEquipCfg"))
/*     */         {
/*     */ 
/* 196 */           SItemEquipCfg obj = new SItemEquipCfg();
/* 197 */           obj.loadFromXml(elem);
/* 198 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 199 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 204 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SItemEquipCfg> all)
/*     */   {
/* 210 */     String path = dir + "mzm.gsp.item.confbean.SItemEquipCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 214 */       SAXReader reader = new SAXReader();
/* 215 */       org.dom4j.Document doc = reader.read(new File(path));
/* 216 */       Element root = doc.getRootElement();
/* 217 */       List<?> nodeList = root.elements();
/* 218 */       int len = nodeList.size();
/* 219 */       for (int i = 0; i < len; i++)
/*     */       {
/* 221 */         Element elem = (Element)nodeList.get(i);
/* 222 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemEquipCfg"))
/*     */         {
/*     */ 
/* 225 */           SItemEquipCfg obj = new SItemEquipCfg();
/* 226 */           obj.loadFromXml(elem);
/* 227 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 228 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 233 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 239 */     all = new java.util.HashMap();
/*     */     
/* 241 */     String path = dir + "mzm.gsp.item.confbean.SItemEquipCfg.bny";
/*     */     try
/*     */     {
/* 244 */       File file = new File(path);
/* 245 */       if (file.exists())
/*     */       {
/* 247 */         byte[] bytes = new byte['Ѐ'];
/* 248 */         FileInputStream fis = new FileInputStream(file);
/* 249 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 250 */         int len = 0;
/* 251 */         while ((len = fis.read(bytes)) > 0)
/* 252 */           baos.write(bytes, 0, len);
/* 253 */         fis.close();
/* 254 */         bytes = baos.toByteArray();
/* 255 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 256 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 258 */           _os_.unmarshal_int();
/* 259 */           _os_.unmarshal_int();
/* 260 */           _os_.unmarshal_int();
/*     */         }
/* 262 */         _os_.unmarshal_int();
/* 263 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 266 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 268 */           SItemEquipCfg _v_ = new SItemEquipCfg();
/* 269 */           _v_.unmarshal(_os_);
/* 270 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 271 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 276 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 281 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SItemEquipCfg> all)
/*     */   {
/* 288 */     String path = dir + "mzm.gsp.item.confbean.SItemEquipCfg.bny";
/*     */     try
/*     */     {
/* 291 */       File file = new File(path);
/* 292 */       if (file.exists())
/*     */       {
/* 294 */         byte[] bytes = new byte['Ѐ'];
/* 295 */         FileInputStream fis = new FileInputStream(file);
/* 296 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 297 */         int len = 0;
/* 298 */         while ((len = fis.read(bytes)) > 0)
/* 299 */           baos.write(bytes, 0, len);
/* 300 */         fis.close();
/* 301 */         bytes = baos.toByteArray();
/* 302 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 303 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 305 */           _os_.unmarshal_int();
/* 306 */           _os_.unmarshal_int();
/* 307 */           _os_.unmarshal_int();
/*     */         }
/* 309 */         _os_.unmarshal_int();
/* 310 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 313 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 315 */           SItemEquipCfg _v_ = new SItemEquipCfg();
/* 316 */           _v_.unmarshal(_os_);
/* 317 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 318 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 323 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 328 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 334 */     for (Map.Entry<Integer, SItemEquipCfg> entry : all.entrySet())
/*     */     {
/* 336 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 338 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 342 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SItemEquipCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 349 */     for (Map.Entry<Integer, SItemEquipCfg> entry : all.entrySet())
/*     */     {
/* 351 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 353 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 357 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SItemEquipCfg getOld(int key)
/*     */   {
/* 364 */     return (SItemEquipCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SItemEquipCfg get(int key)
/*     */   {
/* 369 */     return (SItemEquipCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemEquipCfg> getOldAllSelf()
/*     */   {
/* 374 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemEquipCfg> getAllSelf()
/*     */   {
/* 379 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SItemEquipCfg> newAll)
/*     */   {
/* 384 */     oldAll = all;
/* 385 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 390 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SItemEquipCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */