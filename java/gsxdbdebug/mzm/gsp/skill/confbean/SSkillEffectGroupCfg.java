/*     */ package mzm.gsp.skill.confbean;
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
/*     */ public class SSkillEffectGroupCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSkillEffectGroupCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSkillEffectGroupCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int targettype;
/*     */   public int damagetype;
/*     */   public int effectgrouptype;
/*     */   public int classType;
/*     */   public int mutex;
/*     */   public int additionFormula;
/*     */   public int additionMaxOPER;
/*     */   public boolean isdispel;
/*     */   public boolean isdealaway;
/*     */   public int roundsformula;
/*  29 */   public java.util.ArrayList<Integer> effectgroupsub = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.targettype = Integer.valueOf(rootElement.attributeValue("targettype")).intValue();
/*  35 */     this.damagetype = Integer.valueOf(rootElement.attributeValue("damagetype")).intValue();
/*  36 */     this.effectgrouptype = Integer.valueOf(rootElement.attributeValue("effectgrouptype")).intValue();
/*  37 */     this.classType = Integer.valueOf(rootElement.attributeValue("classType")).intValue();
/*  38 */     this.mutex = Integer.valueOf(rootElement.attributeValue("mutex")).intValue();
/*  39 */     this.additionFormula = Integer.valueOf(rootElement.attributeValue("additionFormula")).intValue();
/*  40 */     this.additionMaxOPER = Integer.valueOf(rootElement.attributeValue("additionMaxOPER")).intValue();
/*  41 */     this.isdispel = Boolean.valueOf(rootElement.attributeValue("isdispel")).booleanValue();
/*  42 */     this.isdealaway = Boolean.valueOf(rootElement.attributeValue("isdealaway")).booleanValue();
/*  43 */     this.roundsformula = Integer.valueOf(rootElement.attributeValue("roundsformula")).intValue();
/*     */     
/*  45 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "effectgroupsub");
/*  46 */     if (collectionElement == null)
/*     */     {
/*  48 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  51 */     List<?> _nodeList = collectionElement.elements();
/*  52 */     int _len = _nodeList.size();
/*  53 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  55 */       Element elem = (Element)_nodeList.get(i);
/*  56 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  63 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  70 */         this.effectgroupsub.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _os_.marshal(this.id);
/*  78 */     _os_.marshal(this.targettype);
/*  79 */     _os_.marshal(this.damagetype);
/*  80 */     _os_.marshal(this.effectgrouptype);
/*  81 */     _os_.marshal(this.classType);
/*  82 */     _os_.marshal(this.mutex);
/*  83 */     _os_.marshal(this.additionFormula);
/*  84 */     _os_.marshal(this.additionMaxOPER);
/*  85 */     _os_.marshal(this.isdispel);
/*  86 */     _os_.marshal(this.isdealaway);
/*  87 */     _os_.marshal(this.roundsformula);
/*  88 */     _os_.compact_uint32(this.effectgroupsub.size());
/*  89 */     for (Integer _v_ : this.effectgroupsub)
/*     */     {
/*  91 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  98 */     this.id = _os_.unmarshal_int();
/*  99 */     this.targettype = _os_.unmarshal_int();
/* 100 */     this.damagetype = _os_.unmarshal_int();
/* 101 */     this.effectgrouptype = _os_.unmarshal_int();
/* 102 */     this.classType = _os_.unmarshal_int();
/* 103 */     this.mutex = _os_.unmarshal_int();
/* 104 */     this.additionFormula = _os_.unmarshal_int();
/* 105 */     this.additionMaxOPER = _os_.unmarshal_int();
/* 106 */     this.isdispel = _os_.unmarshal_boolean();
/* 107 */     this.isdealaway = _os_.unmarshal_boolean();
/* 108 */     this.roundsformula = _os_.unmarshal_int();
/* 109 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 112 */       int _v_ = _os_.unmarshal_int();
/* 113 */       this.effectgroupsub.add(Integer.valueOf(_v_));
/*     */     }
/* 115 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 120 */     String path = dir + "mzm.gsp.skill.confbean.SSkillEffectGroupCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 124 */       all = new java.util.HashMap();
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillEffectGroupCfg"))
/*     */         {
/*     */ 
/* 136 */           SSkillEffectGroupCfg obj = new SSkillEffectGroupCfg();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSkillEffectGroupCfg> all)
/*     */   {
/* 150 */     String path = dir + "mzm.gsp.skill.confbean.SSkillEffectGroupCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 154 */       SAXReader reader = new SAXReader();
/* 155 */       org.dom4j.Document doc = reader.read(new File(path));
/* 156 */       Element root = doc.getRootElement();
/* 157 */       List<?> nodeList = root.elements();
/* 158 */       int len = nodeList.size();
/* 159 */       for (int i = 0; i < len; i++)
/*     */       {
/* 161 */         Element elem = (Element)nodeList.get(i);
/* 162 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillEffectGroupCfg"))
/*     */         {
/*     */ 
/* 165 */           SSkillEffectGroupCfg obj = new SSkillEffectGroupCfg();
/* 166 */           obj.loadFromXml(elem);
/* 167 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 168 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 173 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 179 */     all = new java.util.HashMap();
/*     */     
/* 181 */     String path = dir + "mzm.gsp.skill.confbean.SSkillEffectGroupCfg.bny";
/*     */     try
/*     */     {
/* 184 */       File file = new File(path);
/* 185 */       if (file.exists())
/*     */       {
/* 187 */         byte[] bytes = new byte['Ѐ'];
/* 188 */         FileInputStream fis = new FileInputStream(file);
/* 189 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 190 */         int len = 0;
/* 191 */         while ((len = fis.read(bytes)) > 0)
/* 192 */           baos.write(bytes, 0, len);
/* 193 */         fis.close();
/* 194 */         bytes = baos.toByteArray();
/* 195 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 196 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 198 */           _os_.unmarshal_int();
/* 199 */           _os_.unmarshal_int();
/* 200 */           _os_.unmarshal_int();
/*     */         }
/* 202 */         _os_.unmarshal_int();
/* 203 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 206 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 208 */           SSkillEffectGroupCfg _v_ = new SSkillEffectGroupCfg();
/* 209 */           _v_.unmarshal(_os_);
/* 210 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 211 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 216 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 221 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSkillEffectGroupCfg> all)
/*     */   {
/* 228 */     String path = dir + "mzm.gsp.skill.confbean.SSkillEffectGroupCfg.bny";
/*     */     try
/*     */     {
/* 231 */       File file = new File(path);
/* 232 */       if (file.exists())
/*     */       {
/* 234 */         byte[] bytes = new byte['Ѐ'];
/* 235 */         FileInputStream fis = new FileInputStream(file);
/* 236 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 237 */         int len = 0;
/* 238 */         while ((len = fis.read(bytes)) > 0)
/* 239 */           baos.write(bytes, 0, len);
/* 240 */         fis.close();
/* 241 */         bytes = baos.toByteArray();
/* 242 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 243 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 245 */           _os_.unmarshal_int();
/* 246 */           _os_.unmarshal_int();
/* 247 */           _os_.unmarshal_int();
/*     */         }
/* 249 */         _os_.unmarshal_int();
/* 250 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 253 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 255 */           SSkillEffectGroupCfg _v_ = new SSkillEffectGroupCfg();
/* 256 */           _v_.unmarshal(_os_);
/* 257 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 258 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 263 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 268 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSkillEffectGroupCfg getOld(int key)
/*     */   {
/* 276 */     return (SSkillEffectGroupCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSkillEffectGroupCfg get(int key)
/*     */   {
/* 281 */     return (SSkillEffectGroupCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillEffectGroupCfg> getOldAll()
/*     */   {
/* 286 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillEffectGroupCfg> getAll()
/*     */   {
/* 291 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSkillEffectGroupCfg> newAll)
/*     */   {
/* 296 */     oldAll = all;
/* 297 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 302 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SSkillEffectGroupCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */