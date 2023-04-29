/*     */ package mzm.gsp.children.confbean;
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
/*     */ public class SChildrenOccupationSkillCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SChildrenOccupationSkillCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SChildrenOccupationSkillCfg> all = null;
/*     */   
/*     */   public int skillid;
/*     */   public int occupation;
/*     */   public int mainItemid;
/*  21 */   public java.util.HashSet<Integer> subItemids = new java.util.HashSet();
/*     */   public int levelUpCostClassid;
/*     */   public int skillIndex;
/*     */   public int needEquipmentLevel;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.skillid = Integer.valueOf(rootElement.attributeValue("skillid")).intValue();
/*  29 */     this.occupation = Integer.valueOf(rootElement.attributeValue("occupation")).intValue();
/*  30 */     this.mainItemid = Integer.valueOf(rootElement.attributeValue("mainItemid")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "subItemids");
/*  33 */     if (collectionElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> _nodeList = collectionElement.elements();
/*  39 */     int _len = _nodeList.size();
/*  40 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  42 */       Element elem = (Element)_nodeList.get(i);
/*  43 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  57 */         this.subItemids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  60 */     this.levelUpCostClassid = Integer.valueOf(rootElement.attributeValue("levelUpCostClassid")).intValue();
/*  61 */     this.skillIndex = Integer.valueOf(rootElement.attributeValue("skillIndex")).intValue();
/*  62 */     this.needEquipmentLevel = Integer.valueOf(rootElement.attributeValue("needEquipmentLevel")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _os_.marshal(this.skillid);
/*  68 */     _os_.marshal(this.occupation);
/*  69 */     _os_.marshal(this.mainItemid);
/*  70 */     _os_.compact_uint32(this.subItemids.size());
/*  71 */     for (Integer _v_ : this.subItemids)
/*     */     {
/*  73 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  75 */     _os_.marshal(this.levelUpCostClassid);
/*  76 */     _os_.marshal(this.skillIndex);
/*  77 */     _os_.marshal(this.needEquipmentLevel);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     this.skillid = _os_.unmarshal_int();
/*  84 */     this.occupation = _os_.unmarshal_int();
/*  85 */     this.mainItemid = _os_.unmarshal_int();
/*  86 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  89 */       int _v_ = _os_.unmarshal_int();
/*  90 */       this.subItemids.add(Integer.valueOf(_v_));
/*     */     }
/*  92 */     this.levelUpCostClassid = _os_.unmarshal_int();
/*  93 */     this.skillIndex = _os_.unmarshal_int();
/*  94 */     this.needEquipmentLevel = _os_.unmarshal_int();
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 100 */     String path = dir + "mzm.gsp.children.confbean.SChildrenOccupationSkillCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 104 */       all = new java.util.HashMap();
/* 105 */       SAXReader reader = new SAXReader();
/* 106 */       org.dom4j.Document doc = reader.read(new File(path));
/* 107 */       Element root = doc.getRootElement();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element elem = (Element)nodeList.get(i);
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SChildrenOccupationSkillCfg"))
/*     */         {
/*     */ 
/* 116 */           SChildrenOccupationSkillCfg obj = new SChildrenOccupationSkillCfg();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.skillid), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.skillid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SChildrenOccupationSkillCfg> all)
/*     */   {
/* 130 */     String path = dir + "mzm.gsp.children.confbean.SChildrenOccupationSkillCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 134 */       SAXReader reader = new SAXReader();
/* 135 */       org.dom4j.Document doc = reader.read(new File(path));
/* 136 */       Element root = doc.getRootElement();
/* 137 */       List<?> nodeList = root.elements();
/* 138 */       int len = nodeList.size();
/* 139 */       for (int i = 0; i < len; i++)
/*     */       {
/* 141 */         Element elem = (Element)nodeList.get(i);
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SChildrenOccupationSkillCfg"))
/*     */         {
/*     */ 
/* 145 */           SChildrenOccupationSkillCfg obj = new SChildrenOccupationSkillCfg();
/* 146 */           obj.loadFromXml(elem);
/* 147 */           if (all.put(Integer.valueOf(obj.skillid), obj) != null) {
/* 148 */             throw new RuntimeException("duplicate key : " + obj.skillid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 159 */     all = new java.util.HashMap();
/*     */     
/* 161 */     String path = dir + "mzm.gsp.children.confbean.SChildrenOccupationSkillCfg.bny";
/*     */     try
/*     */     {
/* 164 */       File file = new File(path);
/* 165 */       if (file.exists())
/*     */       {
/* 167 */         byte[] bytes = new byte['Ѐ'];
/* 168 */         FileInputStream fis = new FileInputStream(file);
/* 169 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 170 */         int len = 0;
/* 171 */         while ((len = fis.read(bytes)) > 0)
/* 172 */           baos.write(bytes, 0, len);
/* 173 */         fis.close();
/* 174 */         bytes = baos.toByteArray();
/* 175 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 176 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/* 180 */           _os_.unmarshal_int();
/*     */         }
/* 182 */         _os_.unmarshal_int();
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 186 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 188 */           SChildrenOccupationSkillCfg _v_ = new SChildrenOccupationSkillCfg();
/* 189 */           _v_.unmarshal(_os_);
/* 190 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 191 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 196 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SChildrenOccupationSkillCfg> all)
/*     */   {
/* 208 */     String path = dir + "mzm.gsp.children.confbean.SChildrenOccupationSkillCfg.bny";
/*     */     try
/*     */     {
/* 211 */       File file = new File(path);
/* 212 */       if (file.exists())
/*     */       {
/* 214 */         byte[] bytes = new byte['Ѐ'];
/* 215 */         FileInputStream fis = new FileInputStream(file);
/* 216 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 217 */         int len = 0;
/* 218 */         while ((len = fis.read(bytes)) > 0)
/* 219 */           baos.write(bytes, 0, len);
/* 220 */         fis.close();
/* 221 */         bytes = baos.toByteArray();
/* 222 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 223 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/* 227 */           _os_.unmarshal_int();
/*     */         }
/* 229 */         _os_.unmarshal_int();
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 233 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 235 */           SChildrenOccupationSkillCfg _v_ = new SChildrenOccupationSkillCfg();
/* 236 */           _v_.unmarshal(_os_);
/* 237 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 238 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 243 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 248 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SChildrenOccupationSkillCfg getOld(int key)
/*     */   {
/* 256 */     return (SChildrenOccupationSkillCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SChildrenOccupationSkillCfg get(int key)
/*     */   {
/* 261 */     return (SChildrenOccupationSkillCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChildrenOccupationSkillCfg> getOldAll()
/*     */   {
/* 266 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChildrenOccupationSkillCfg> getAll()
/*     */   {
/* 271 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SChildrenOccupationSkillCfg> newAll)
/*     */   {
/* 276 */     oldAll = all;
/* 277 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 282 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\SChildrenOccupationSkillCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */