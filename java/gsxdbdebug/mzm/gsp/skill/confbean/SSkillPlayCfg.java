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
/*     */ public class SSkillPlayCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSkillPlayCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSkillPlayCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int skillPlayType;
/*     */   public int prepareStage;
/*  21 */   public ArrayList<Integer> moveStages = new ArrayList();
/*  22 */   public ArrayList<Integer> effectStages = new ArrayList();
/*     */   public int returnStage;
/*     */   public int deadStyle;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.skillPlayType = Integer.valueOf(rootElement.attributeValue("skillPlayType")).intValue();
/*  30 */     this.prepareStage = Integer.valueOf(rootElement.attributeValue("prepareStage")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "moveStages");
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
/*  57 */         this.moveStages.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  61 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "effectStages");
/*  62 */     if (collectionElement == null)
/*     */     {
/*  64 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  67 */     List<?> _nodeList = collectionElement.elements();
/*  68 */     int _len = _nodeList.size();
/*  69 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  71 */       Element elem = (Element)_nodeList.get(i);
/*  72 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  79 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  86 */         this.effectStages.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  89 */     this.returnStage = Integer.valueOf(rootElement.attributeValue("returnStage")).intValue();
/*  90 */     this.deadStyle = Integer.valueOf(rootElement.attributeValue("deadStyle")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  95 */     _os_.marshal(this.id);
/*  96 */     _os_.marshal(this.skillPlayType);
/*  97 */     _os_.marshal(this.prepareStage);
/*  98 */     _os_.compact_uint32(this.moveStages.size());
/*  99 */     for (Integer _v_ : this.moveStages)
/*     */     {
/* 101 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 103 */     _os_.compact_uint32(this.effectStages.size());
/* 104 */     for (Integer _v_ : this.effectStages)
/*     */     {
/* 106 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 108 */     _os_.marshal(this.returnStage);
/* 109 */     _os_.marshal(this.deadStyle);
/* 110 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 115 */     this.id = _os_.unmarshal_int();
/* 116 */     this.skillPlayType = _os_.unmarshal_int();
/* 117 */     this.prepareStage = _os_.unmarshal_int();
/* 118 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 121 */       int _v_ = _os_.unmarshal_int();
/* 122 */       this.moveStages.add(Integer.valueOf(_v_));
/*     */     }
/* 124 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 127 */       int _v_ = _os_.unmarshal_int();
/* 128 */       this.effectStages.add(Integer.valueOf(_v_));
/*     */     }
/* 130 */     this.returnStage = _os_.unmarshal_int();
/* 131 */     this.deadStyle = _os_.unmarshal_int();
/* 132 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.skill.confbean.SSkillPlayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 141 */       all = new java.util.HashMap();
/* 142 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 143 */       org.dom4j.Document doc = reader.read(new File(path));
/* 144 */       Element root = doc.getRootElement();
/* 145 */       List<?> nodeList = root.elements();
/* 146 */       int len = nodeList.size();
/* 147 */       for (int i = 0; i < len; i++)
/*     */       {
/* 149 */         Element elem = (Element)nodeList.get(i);
/* 150 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillPlayCfg"))
/*     */         {
/*     */ 
/* 153 */           SSkillPlayCfg obj = new SSkillPlayCfg();
/* 154 */           obj.loadFromXml(elem);
/* 155 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 156 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 161 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSkillPlayCfg> all)
/*     */   {
/* 167 */     String path = dir + "mzm.gsp.skill.confbean.SSkillPlayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 171 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 172 */       org.dom4j.Document doc = reader.read(new File(path));
/* 173 */       Element root = doc.getRootElement();
/* 174 */       List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element elem = (Element)nodeList.get(i);
/* 179 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillPlayCfg"))
/*     */         {
/*     */ 
/* 182 */           SSkillPlayCfg obj = new SSkillPlayCfg();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 196 */     all = new java.util.HashMap();
/*     */     
/* 198 */     String path = dir + "mzm.gsp.skill.confbean.SSkillPlayCfg.bny";
/*     */     try
/*     */     {
/* 201 */       File file = new File(path);
/* 202 */       if (file.exists())
/*     */       {
/* 204 */         byte[] bytes = new byte['Ѐ'];
/* 205 */         FileInputStream fis = new FileInputStream(file);
/* 206 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 207 */         int len = 0;
/* 208 */         while ((len = fis.read(bytes)) > 0)
/* 209 */           baos.write(bytes, 0, len);
/* 210 */         fis.close();
/* 211 */         bytes = baos.toByteArray();
/* 212 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 215 */           _os_.unmarshal_int();
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/*     */         }
/* 219 */         _os_.unmarshal_int();
/* 220 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 223 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 225 */           SSkillPlayCfg _v_ = new SSkillPlayCfg();
/* 226 */           _v_.unmarshal(_os_);
/* 227 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 228 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 233 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 238 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSkillPlayCfg> all)
/*     */   {
/* 245 */     String path = dir + "mzm.gsp.skill.confbean.SSkillPlayCfg.bny";
/*     */     try
/*     */     {
/* 248 */       File file = new File(path);
/* 249 */       if (file.exists())
/*     */       {
/* 251 */         byte[] bytes = new byte['Ѐ'];
/* 252 */         FileInputStream fis = new FileInputStream(file);
/* 253 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 254 */         int len = 0;
/* 255 */         while ((len = fis.read(bytes)) > 0)
/* 256 */           baos.write(bytes, 0, len);
/* 257 */         fis.close();
/* 258 */         bytes = baos.toByteArray();
/* 259 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 260 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 262 */           _os_.unmarshal_int();
/* 263 */           _os_.unmarshal_int();
/* 264 */           _os_.unmarshal_int();
/*     */         }
/* 266 */         _os_.unmarshal_int();
/* 267 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 270 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 272 */           SSkillPlayCfg _v_ = new SSkillPlayCfg();
/* 273 */           _v_.unmarshal(_os_);
/* 274 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 275 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 280 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 285 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSkillPlayCfg getOld(int key)
/*     */   {
/* 293 */     return (SSkillPlayCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSkillPlayCfg get(int key)
/*     */   {
/* 298 */     return (SSkillPlayCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillPlayCfg> getOldAll()
/*     */   {
/* 303 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillPlayCfg> getAll()
/*     */   {
/* 308 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSkillPlayCfg> newAll)
/*     */   {
/* 313 */     oldAll = all;
/* 314 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 319 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SSkillPlayCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */