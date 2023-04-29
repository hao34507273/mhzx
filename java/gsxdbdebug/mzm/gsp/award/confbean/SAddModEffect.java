/*     */ package mzm.gsp.award.confbean;
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
/*     */ public class SAddModEffect implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAddModEffect> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAddModEffect> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public boolean isTeamExpAddEffect;
/*     */   public boolean isLeaderExpAddEffect;
/*     */   public boolean isStableTeamExpAddEffect;
/*     */   public boolean isDoubleExpAddEffect;
/*     */   public boolean isGangExpAddEffect;
/*     */   public boolean isRelationExpAddEffect;
/*     */   public boolean isNewMarriageExpAddEffect;
/*     */   public boolean isNewMarriageTeamExpAddEffect;
/*     */   public boolean isServerLevelExpAddEffect;
/*     */   public boolean isServerLevelExpCutEffect;
/*     */   public boolean isTeamsilverAddEffect;
/*     */   public boolean isLeadersilverAddEffect;
/*     */   public boolean isStableTeamsilverAddEffect;
/*     */   public boolean isDoublesilverAddEffect;
/*     */   public boolean isGangsilverAddEffect;
/*     */   public boolean isRelationsilverAddEffect;
/*     */   public boolean isNewMarriagesilverAddEffect;
/*     */   public boolean isNewMarriageTeamsilverAddEffect;
/*     */   public boolean isDoubleItemRateModEffect;
/*     */   public boolean isStoreExpEffect;
/*  40 */   public java.util.ArrayList<AwardBuffCfg> AwardBuffCfgList = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  44 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  45 */     this.templatename = rootElement.attributeValue("templatename");
/*  46 */     this.isTeamExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isTeamExpAddEffect")).booleanValue();
/*  47 */     this.isLeaderExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isLeaderExpAddEffect")).booleanValue();
/*  48 */     this.isStableTeamExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isStableTeamExpAddEffect")).booleanValue();
/*  49 */     this.isDoubleExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isDoubleExpAddEffect")).booleanValue();
/*  50 */     this.isGangExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isGangExpAddEffect")).booleanValue();
/*  51 */     this.isRelationExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isRelationExpAddEffect")).booleanValue();
/*  52 */     this.isNewMarriageExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isNewMarriageExpAddEffect")).booleanValue();
/*  53 */     this.isNewMarriageTeamExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isNewMarriageTeamExpAddEffect")).booleanValue();
/*  54 */     this.isServerLevelExpAddEffect = Boolean.valueOf(rootElement.attributeValue("isServerLevelExpAddEffect")).booleanValue();
/*  55 */     this.isServerLevelExpCutEffect = Boolean.valueOf(rootElement.attributeValue("isServerLevelExpCutEffect")).booleanValue();
/*  56 */     this.isTeamsilverAddEffect = Boolean.valueOf(rootElement.attributeValue("isTeamsilverAddEffect")).booleanValue();
/*  57 */     this.isLeadersilverAddEffect = Boolean.valueOf(rootElement.attributeValue("isLeadersilverAddEffect")).booleanValue();
/*  58 */     this.isStableTeamsilverAddEffect = Boolean.valueOf(rootElement.attributeValue("isStableTeamsilverAddEffect")).booleanValue();
/*  59 */     this.isDoublesilverAddEffect = Boolean.valueOf(rootElement.attributeValue("isDoublesilverAddEffect")).booleanValue();
/*  60 */     this.isGangsilverAddEffect = Boolean.valueOf(rootElement.attributeValue("isGangsilverAddEffect")).booleanValue();
/*  61 */     this.isRelationsilverAddEffect = Boolean.valueOf(rootElement.attributeValue("isRelationsilverAddEffect")).booleanValue();
/*  62 */     this.isNewMarriagesilverAddEffect = Boolean.valueOf(rootElement.attributeValue("isNewMarriagesilverAddEffect")).booleanValue();
/*  63 */     this.isNewMarriageTeamsilverAddEffect = Boolean.valueOf(rootElement.attributeValue("isNewMarriageTeamsilverAddEffect")).booleanValue();
/*  64 */     this.isDoubleItemRateModEffect = Boolean.valueOf(rootElement.attributeValue("isDoubleItemRateModEffect")).booleanValue();
/*  65 */     this.isStoreExpEffect = Boolean.valueOf(rootElement.attributeValue("isStoreExpEffect")).booleanValue();
/*     */     
/*  67 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "AwardBuffCfgList");
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
/*  78 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.AwardBuffCfg"))
/*     */       {
/*     */         AwardBuffCfg _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  85 */           _v_ = new AwardBuffCfg();
/*  86 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  93 */         this.AwardBuffCfgList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 100 */     _os_.marshal(this.id);
/* 101 */     _os_.marshal(this.templatename, "UTF-8");
/* 102 */     _os_.marshal(this.isTeamExpAddEffect);
/* 103 */     _os_.marshal(this.isLeaderExpAddEffect);
/* 104 */     _os_.marshal(this.isStableTeamExpAddEffect);
/* 105 */     _os_.marshal(this.isDoubleExpAddEffect);
/* 106 */     _os_.marshal(this.isGangExpAddEffect);
/* 107 */     _os_.marshal(this.isRelationExpAddEffect);
/* 108 */     _os_.marshal(this.isNewMarriageExpAddEffect);
/* 109 */     _os_.marshal(this.isNewMarriageTeamExpAddEffect);
/* 110 */     _os_.marshal(this.isServerLevelExpAddEffect);
/* 111 */     _os_.marshal(this.isServerLevelExpCutEffect);
/* 112 */     _os_.marshal(this.isTeamsilverAddEffect);
/* 113 */     _os_.marshal(this.isLeadersilverAddEffect);
/* 114 */     _os_.marshal(this.isStableTeamsilverAddEffect);
/* 115 */     _os_.marshal(this.isDoublesilverAddEffect);
/* 116 */     _os_.marshal(this.isGangsilverAddEffect);
/* 117 */     _os_.marshal(this.isRelationsilverAddEffect);
/* 118 */     _os_.marshal(this.isNewMarriagesilverAddEffect);
/* 119 */     _os_.marshal(this.isNewMarriageTeamsilverAddEffect);
/* 120 */     _os_.marshal(this.isDoubleItemRateModEffect);
/* 121 */     _os_.marshal(this.isStoreExpEffect);
/* 122 */     _os_.compact_uint32(this.AwardBuffCfgList.size());
/* 123 */     for (AwardBuffCfg _v_ : this.AwardBuffCfgList)
/*     */     {
/* 125 */       _os_.marshal(_v_);
/*     */     }
/* 127 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 132 */     this.id = _os_.unmarshal_int();
/* 133 */     this.templatename = _os_.unmarshal_String("UTF-8");
/* 134 */     this.isTeamExpAddEffect = _os_.unmarshal_boolean();
/* 135 */     this.isLeaderExpAddEffect = _os_.unmarshal_boolean();
/* 136 */     this.isStableTeamExpAddEffect = _os_.unmarshal_boolean();
/* 137 */     this.isDoubleExpAddEffect = _os_.unmarshal_boolean();
/* 138 */     this.isGangExpAddEffect = _os_.unmarshal_boolean();
/* 139 */     this.isRelationExpAddEffect = _os_.unmarshal_boolean();
/* 140 */     this.isNewMarriageExpAddEffect = _os_.unmarshal_boolean();
/* 141 */     this.isNewMarriageTeamExpAddEffect = _os_.unmarshal_boolean();
/* 142 */     this.isServerLevelExpAddEffect = _os_.unmarshal_boolean();
/* 143 */     this.isServerLevelExpCutEffect = _os_.unmarshal_boolean();
/* 144 */     this.isTeamsilverAddEffect = _os_.unmarshal_boolean();
/* 145 */     this.isLeadersilverAddEffect = _os_.unmarshal_boolean();
/* 146 */     this.isStableTeamsilverAddEffect = _os_.unmarshal_boolean();
/* 147 */     this.isDoublesilverAddEffect = _os_.unmarshal_boolean();
/* 148 */     this.isGangsilverAddEffect = _os_.unmarshal_boolean();
/* 149 */     this.isRelationsilverAddEffect = _os_.unmarshal_boolean();
/* 150 */     this.isNewMarriagesilverAddEffect = _os_.unmarshal_boolean();
/* 151 */     this.isNewMarriageTeamsilverAddEffect = _os_.unmarshal_boolean();
/* 152 */     this.isDoubleItemRateModEffect = _os_.unmarshal_boolean();
/* 153 */     this.isStoreExpEffect = _os_.unmarshal_boolean();
/* 154 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 157 */       AwardBuffCfg _v_ = new AwardBuffCfg();
/* 158 */       _v_.unmarshal(_os_);
/* 159 */       this.AwardBuffCfgList.add(_v_);
/*     */     }
/* 161 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 166 */     String path = dir + "mzm.gsp.award.confbean.SAddModEffect.xml";
/*     */     
/*     */     try
/*     */     {
/* 170 */       all = new java.util.HashMap();
/* 171 */       SAXReader reader = new SAXReader();
/* 172 */       org.dom4j.Document doc = reader.read(new File(path));
/* 173 */       Element root = doc.getRootElement();
/* 174 */       List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element elem = (Element)nodeList.get(i);
/* 179 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SAddModEffect"))
/*     */         {
/*     */ 
/* 182 */           SAddModEffect obj = new SAddModEffect();
/* 183 */           obj.loadFromXml(elem);
/* 184 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 190 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAddModEffect> all)
/*     */   {
/* 196 */     String path = dir + "mzm.gsp.award.confbean.SAddModEffect.xml";
/*     */     
/*     */     try
/*     */     {
/* 200 */       SAXReader reader = new SAXReader();
/* 201 */       org.dom4j.Document doc = reader.read(new File(path));
/* 202 */       Element root = doc.getRootElement();
/* 203 */       List<?> nodeList = root.elements();
/* 204 */       int len = nodeList.size();
/* 205 */       for (int i = 0; i < len; i++)
/*     */       {
/* 207 */         Element elem = (Element)nodeList.get(i);
/* 208 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SAddModEffect"))
/*     */         {
/*     */ 
/* 211 */           SAddModEffect obj = new SAddModEffect();
/* 212 */           obj.loadFromXml(elem);
/* 213 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 225 */     all = new java.util.HashMap();
/*     */     
/* 227 */     String path = dir + "mzm.gsp.award.confbean.SAddModEffect.bny";
/*     */     try
/*     */     {
/* 230 */       File file = new File(path);
/* 231 */       if (file.exists())
/*     */       {
/* 233 */         byte[] bytes = new byte['Ѐ'];
/* 234 */         FileInputStream fis = new FileInputStream(file);
/* 235 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 236 */         int len = 0;
/* 237 */         while ((len = fis.read(bytes)) > 0)
/* 238 */           baos.write(bytes, 0, len);
/* 239 */         fis.close();
/* 240 */         bytes = baos.toByteArray();
/* 241 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/* 246 */           _os_.unmarshal_int();
/*     */         }
/* 248 */         _os_.unmarshal_int();
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 252 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 254 */           SAddModEffect _v_ = new SAddModEffect();
/* 255 */           _v_.unmarshal(_os_);
/* 256 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 257 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 262 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAddModEffect> all)
/*     */   {
/* 274 */     String path = dir + "mzm.gsp.award.confbean.SAddModEffect.bny";
/*     */     try
/*     */     {
/* 277 */       File file = new File(path);
/* 278 */       if (file.exists())
/*     */       {
/* 280 */         byte[] bytes = new byte['Ѐ'];
/* 281 */         FileInputStream fis = new FileInputStream(file);
/* 282 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 283 */         int len = 0;
/* 284 */         while ((len = fis.read(bytes)) > 0)
/* 285 */           baos.write(bytes, 0, len);
/* 286 */         fis.close();
/* 287 */         bytes = baos.toByteArray();
/* 288 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 289 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 291 */           _os_.unmarshal_int();
/* 292 */           _os_.unmarshal_int();
/* 293 */           _os_.unmarshal_int();
/*     */         }
/* 295 */         _os_.unmarshal_int();
/* 296 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 299 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 301 */           SAddModEffect _v_ = new SAddModEffect();
/* 302 */           _v_.unmarshal(_os_);
/* 303 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 304 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 309 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 314 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAddModEffect getOld(int key)
/*     */   {
/* 322 */     return (SAddModEffect)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAddModEffect get(int key)
/*     */   {
/* 327 */     return (SAddModEffect)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAddModEffect> getOldAll()
/*     */   {
/* 332 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAddModEffect> getAll()
/*     */   {
/* 337 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAddModEffect> newAll)
/*     */   {
/* 342 */     oldAll = all;
/* 343 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 348 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\SAddModEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */