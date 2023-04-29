/*     */ package mzm.gsp.skill.confbean;
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
/*     */ public class SSkillConditionCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSkillConditionCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSkillConditionCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public boolean isInFight;
/*  20 */   public ArrayList<ConditionType2FormulaId> needCondtions = new ArrayList();
/*  21 */   public ArrayList<CostType2Formulaid> costCondtions = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.isInFight = Boolean.valueOf(rootElement.attributeValue("isInFight")).booleanValue();
/*     */     
/*  28 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "needCondtions");
/*  29 */     if (collectionElement == null)
/*     */     {
/*  31 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  34 */     List<?> _nodeList = collectionElement.elements();
/*  35 */     int _len = _nodeList.size();
/*  36 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  38 */       Element elem = (Element)_nodeList.get(i);
/*  39 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.ConditionType2FormulaId"))
/*     */       {
/*     */         ConditionType2FormulaId _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  46 */           _v_ = new ConditionType2FormulaId();
/*  47 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  54 */         this.needCondtions.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  58 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "costCondtions");
/*  59 */     if (collectionElement == null)
/*     */     {
/*  61 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  64 */     List<?> _nodeList = collectionElement.elements();
/*  65 */     int _len = _nodeList.size();
/*  66 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  68 */       Element elem = (Element)_nodeList.get(i);
/*  69 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.CostType2Formulaid"))
/*     */       {
/*     */         CostType2Formulaid _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  76 */           _v_ = new CostType2Formulaid();
/*  77 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  84 */         this.costCondtions.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  91 */     _os_.marshal(this.id);
/*  92 */     _os_.marshal(this.isInFight);
/*  93 */     _os_.compact_uint32(this.needCondtions.size());
/*  94 */     for (ConditionType2FormulaId _v_ : this.needCondtions)
/*     */     {
/*  96 */       _os_.marshal(_v_);
/*     */     }
/*  98 */     _os_.compact_uint32(this.costCondtions.size());
/*  99 */     for (CostType2Formulaid _v_ : this.costCondtions)
/*     */     {
/* 101 */       _os_.marshal(_v_);
/*     */     }
/* 103 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 108 */     this.id = _os_.unmarshal_int();
/* 109 */     this.isInFight = _os_.unmarshal_boolean();
/* 110 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 113 */       ConditionType2FormulaId _v_ = new ConditionType2FormulaId();
/* 114 */       _v_.unmarshal(_os_);
/* 115 */       this.needCondtions.add(_v_);
/*     */     }
/* 117 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 120 */       CostType2Formulaid _v_ = new CostType2Formulaid();
/* 121 */       _v_.unmarshal(_os_);
/* 122 */       this.costCondtions.add(_v_);
/*     */     }
/* 124 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.skill.confbean.SSkillConditionCfg.xml";
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
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillConditionCfg"))
/*     */         {
/*     */ 
/* 145 */           SSkillConditionCfg obj = new SSkillConditionCfg();
/* 146 */           obj.loadFromXml(elem);
/* 147 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 148 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSkillConditionCfg> all)
/*     */   {
/* 159 */     String path = dir + "mzm.gsp.skill.confbean.SSkillConditionCfg.xml";
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
/* 171 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillConditionCfg"))
/*     */         {
/*     */ 
/* 174 */           SSkillConditionCfg obj = new SSkillConditionCfg();
/* 175 */           obj.loadFromXml(elem);
/* 176 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 177 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 190 */     String path = dir + "mzm.gsp.skill.confbean.SSkillConditionCfg.bny";
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
/* 217 */           SSkillConditionCfg _v_ = new SSkillConditionCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SSkillConditionCfg> all)
/*     */   {
/* 237 */     String path = dir + "mzm.gsp.skill.confbean.SSkillConditionCfg.bny";
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
/* 264 */           SSkillConditionCfg _v_ = new SSkillConditionCfg();
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
/*     */   public static SSkillConditionCfg getOld(int key)
/*     */   {
/* 285 */     return (SSkillConditionCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSkillConditionCfg get(int key)
/*     */   {
/* 290 */     return (SSkillConditionCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillConditionCfg> getOldAll()
/*     */   {
/* 295 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillConditionCfg> getAll()
/*     */   {
/* 300 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSkillConditionCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SSkillConditionCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */