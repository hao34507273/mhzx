/*     */ package mzm.gsp.petmark.confbean;
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
/*     */ public class SOriginalPetMarkLevelCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SOriginalPetMarkLevelCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SOriginalPetMarkLevelCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int markCfgId;
/*     */   public int level;
/*     */   public int upgradeExp;
/*     */   public int provideExp;
/*     */   public int smeltScoreType;
/*     */   public int smeltScore;
/*     */   public int unlockItemId;
/*     */   public int passiveSkillId;
/*  27 */   public ArrayList<Integer> propTypes = new ArrayList();
/*  28 */   public ArrayList<Integer> propValues = new ArrayList();
/*     */   public int addYaoli;
/*     */   public int needRoleLevel;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.markCfgId = Integer.valueOf(rootElement.attributeValue("markCfgId")).intValue();
/*  36 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  37 */     this.upgradeExp = Integer.valueOf(rootElement.attributeValue("upgradeExp")).intValue();
/*  38 */     this.provideExp = Integer.valueOf(rootElement.attributeValue("provideExp")).intValue();
/*  39 */     this.smeltScoreType = Integer.valueOf(rootElement.attributeValue("smeltScoreType")).intValue();
/*  40 */     this.smeltScore = Integer.valueOf(rootElement.attributeValue("smeltScore")).intValue();
/*  41 */     this.unlockItemId = Integer.valueOf(rootElement.attributeValue("unlockItemId")).intValue();
/*  42 */     this.passiveSkillId = Integer.valueOf(rootElement.attributeValue("passiveSkillId")).intValue();
/*     */     
/*  44 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propTypes");
/*  45 */     if (collectionElement == null)
/*     */     {
/*  47 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  50 */     List<?> _nodeList = collectionElement.elements();
/*  51 */     int _len = _nodeList.size();
/*  52 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  54 */       Element elem = (Element)_nodeList.get(i);
/*  55 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  62 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  69 */         this.propTypes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  73 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propValues");
/*  74 */     if (collectionElement == null)
/*     */     {
/*  76 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  79 */     List<?> _nodeList = collectionElement.elements();
/*  80 */     int _len = _nodeList.size();
/*  81 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  83 */       Element elem = (Element)_nodeList.get(i);
/*  84 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  91 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  98 */         this.propValues.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 101 */     this.addYaoli = Integer.valueOf(rootElement.attributeValue("addYaoli")).intValue();
/* 102 */     this.needRoleLevel = Integer.valueOf(rootElement.attributeValue("needRoleLevel")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 107 */     _os_.marshal(this.id);
/* 108 */     _os_.marshal(this.markCfgId);
/* 109 */     _os_.marshal(this.level);
/* 110 */     _os_.marshal(this.upgradeExp);
/* 111 */     _os_.marshal(this.provideExp);
/* 112 */     _os_.marshal(this.smeltScoreType);
/* 113 */     _os_.marshal(this.smeltScore);
/* 114 */     _os_.marshal(this.unlockItemId);
/* 115 */     _os_.marshal(this.passiveSkillId);
/* 116 */     _os_.compact_uint32(this.propTypes.size());
/* 117 */     for (Integer _v_ : this.propTypes)
/*     */     {
/* 119 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 121 */     _os_.compact_uint32(this.propValues.size());
/* 122 */     for (Integer _v_ : this.propValues)
/*     */     {
/* 124 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 126 */     _os_.marshal(this.addYaoli);
/* 127 */     _os_.marshal(this.needRoleLevel);
/* 128 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 133 */     this.id = _os_.unmarshal_int();
/* 134 */     this.markCfgId = _os_.unmarshal_int();
/* 135 */     this.level = _os_.unmarshal_int();
/* 136 */     this.upgradeExp = _os_.unmarshal_int();
/* 137 */     this.provideExp = _os_.unmarshal_int();
/* 138 */     this.smeltScoreType = _os_.unmarshal_int();
/* 139 */     this.smeltScore = _os_.unmarshal_int();
/* 140 */     this.unlockItemId = _os_.unmarshal_int();
/* 141 */     this.passiveSkillId = _os_.unmarshal_int();
/* 142 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 145 */       int _v_ = _os_.unmarshal_int();
/* 146 */       this.propTypes.add(Integer.valueOf(_v_));
/*     */     }
/* 148 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 151 */       int _v_ = _os_.unmarshal_int();
/* 152 */       this.propValues.add(Integer.valueOf(_v_));
/*     */     }
/* 154 */     this.addYaoli = _os_.unmarshal_int();
/* 155 */     this.needRoleLevel = _os_.unmarshal_int();
/* 156 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 161 */     String path = dir + "mzm.gsp.petmark.confbean.SOriginalPetMarkLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 165 */       all = new java.util.HashMap();
/* 166 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 167 */       org.dom4j.Document doc = reader.read(new File(path));
/* 168 */       Element root = doc.getRootElement();
/* 169 */       List<?> nodeList = root.elements();
/* 170 */       int len = nodeList.size();
/* 171 */       for (int i = 0; i < len; i++)
/*     */       {
/* 173 */         Element elem = (Element)nodeList.get(i);
/* 174 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petmark.confbean.SOriginalPetMarkLevelCfg"))
/*     */         {
/*     */ 
/* 177 */           SOriginalPetMarkLevelCfg obj = new SOriginalPetMarkLevelCfg();
/* 178 */           obj.loadFromXml(elem);
/* 179 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 180 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 185 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOriginalPetMarkLevelCfg> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.petmark.confbean.SOriginalPetMarkLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 195 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 196 */       org.dom4j.Document doc = reader.read(new File(path));
/* 197 */       Element root = doc.getRootElement();
/* 198 */       List<?> nodeList = root.elements();
/* 199 */       int len = nodeList.size();
/* 200 */       for (int i = 0; i < len; i++)
/*     */       {
/* 202 */         Element elem = (Element)nodeList.get(i);
/* 203 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petmark.confbean.SOriginalPetMarkLevelCfg"))
/*     */         {
/*     */ 
/* 206 */           SOriginalPetMarkLevelCfg obj = new SOriginalPetMarkLevelCfg();
/* 207 */           obj.loadFromXml(elem);
/* 208 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 214 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 220 */     all = new java.util.HashMap();
/*     */     
/* 222 */     String path = dir + "mzm.gsp.petmark.confbean.SOriginalPetMarkLevelCfg.bny";
/*     */     try
/*     */     {
/* 225 */       File file = new File(path);
/* 226 */       if (file.exists())
/*     */       {
/* 228 */         byte[] bytes = new byte['Ѐ'];
/* 229 */         FileInputStream fis = new FileInputStream(file);
/* 230 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 231 */         int len = 0;
/* 232 */         while ((len = fis.read(bytes)) > 0)
/* 233 */           baos.write(bytes, 0, len);
/* 234 */         fis.close();
/* 235 */         bytes = baos.toByteArray();
/* 236 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 239 */           _os_.unmarshal_int();
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/*     */         }
/* 243 */         _os_.unmarshal_int();
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 247 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 249 */           SOriginalPetMarkLevelCfg _v_ = new SOriginalPetMarkLevelCfg();
/* 250 */           _v_.unmarshal(_os_);
/* 251 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 252 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 257 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 262 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SOriginalPetMarkLevelCfg> all)
/*     */   {
/* 269 */     String path = dir + "mzm.gsp.petmark.confbean.SOriginalPetMarkLevelCfg.bny";
/*     */     try
/*     */     {
/* 272 */       File file = new File(path);
/* 273 */       if (file.exists())
/*     */       {
/* 275 */         byte[] bytes = new byte['Ѐ'];
/* 276 */         FileInputStream fis = new FileInputStream(file);
/* 277 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 278 */         int len = 0;
/* 279 */         while ((len = fis.read(bytes)) > 0)
/* 280 */           baos.write(bytes, 0, len);
/* 281 */         fis.close();
/* 282 */         bytes = baos.toByteArray();
/* 283 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 284 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 286 */           _os_.unmarshal_int();
/* 287 */           _os_.unmarshal_int();
/* 288 */           _os_.unmarshal_int();
/*     */         }
/* 290 */         _os_.unmarshal_int();
/* 291 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 294 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 296 */           SOriginalPetMarkLevelCfg _v_ = new SOriginalPetMarkLevelCfg();
/* 297 */           _v_.unmarshal(_os_);
/* 298 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 299 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 304 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 309 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SOriginalPetMarkLevelCfg getOld(int key)
/*     */   {
/* 317 */     return (SOriginalPetMarkLevelCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOriginalPetMarkLevelCfg get(int key)
/*     */   {
/* 322 */     return (SOriginalPetMarkLevelCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalPetMarkLevelCfg> getOldAll()
/*     */   {
/* 327 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalPetMarkLevelCfg> getAll()
/*     */   {
/* 332 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOriginalPetMarkLevelCfg> newAll)
/*     */   {
/* 337 */     oldAll = all;
/* 338 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 343 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\confbean\SOriginalPetMarkLevelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */