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
/*     */ public class SSkillBagCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSkillBagCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSkillBagCfg> all = null;
/*     */   
/*     */   public int id;
/*  19 */   public java.util.ArrayList<SkillBagSkill2NeedLevel> skillid2NeedLevel = new java.util.ArrayList();
/*     */   public int levelcfgid;
/*     */   public int initlevel;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*     */     
/*  27 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "skillid2NeedLevel");
/*  28 */     if (collectionElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> _nodeList = collectionElement.elements();
/*  34 */     int _len = _nodeList.size();
/*  35 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  37 */       Element elem = (Element)_nodeList.get(i);
/*  38 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SkillBagSkill2NeedLevel"))
/*     */       {
/*     */         SkillBagSkill2NeedLevel _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  45 */           _v_ = new SkillBagSkill2NeedLevel();
/*  46 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  53 */         this.skillid2NeedLevel.add(_v_);
/*     */       }
/*     */     }
/*  56 */     this.levelcfgid = Integer.valueOf(rootElement.attributeValue("levelcfgid")).intValue();
/*  57 */     this.initlevel = Integer.valueOf(rootElement.attributeValue("initlevel")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _os_.marshal(this.id);
/*  63 */     _os_.compact_uint32(this.skillid2NeedLevel.size());
/*  64 */     for (SkillBagSkill2NeedLevel _v_ : this.skillid2NeedLevel)
/*     */     {
/*  66 */       _os_.marshal(_v_);
/*     */     }
/*  68 */     _os_.marshal(this.levelcfgid);
/*  69 */     _os_.marshal(this.initlevel);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  79 */       SkillBagSkill2NeedLevel _v_ = new SkillBagSkill2NeedLevel();
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.skillid2NeedLevel.add(_v_);
/*     */     }
/*  83 */     this.levelcfgid = _os_.unmarshal_int();
/*  84 */     this.initlevel = _os_.unmarshal_int();
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  90 */     String path = dir + "mzm.gsp.skill.confbean.SSkillBagCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  94 */       all = new java.util.HashMap();
/*  95 */       SAXReader reader = new SAXReader();
/*  96 */       org.dom4j.Document doc = reader.read(new File(path));
/*  97 */       Element root = doc.getRootElement();
/*  98 */       List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element elem = (Element)nodeList.get(i);
/* 103 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillBagCfg"))
/*     */         {
/*     */ 
/* 106 */           SSkillBagCfg obj = new SSkillBagCfg();
/* 107 */           obj.loadFromXml(elem);
/* 108 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 109 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSkillBagCfg> all)
/*     */   {
/* 120 */     String path = dir + "mzm.gsp.skill.confbean.SSkillBagCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 124 */       SAXReader reader = new SAXReader();
/* 125 */       org.dom4j.Document doc = reader.read(new File(path));
/* 126 */       Element root = doc.getRootElement();
/* 127 */       List<?> nodeList = root.elements();
/* 128 */       int len = nodeList.size();
/* 129 */       for (int i = 0; i < len; i++)
/*     */       {
/* 131 */         Element elem = (Element)nodeList.get(i);
/* 132 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillBagCfg"))
/*     */         {
/*     */ 
/* 135 */           SSkillBagCfg obj = new SSkillBagCfg();
/* 136 */           obj.loadFromXml(elem);
/* 137 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 138 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 143 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 149 */     all = new java.util.HashMap();
/*     */     
/* 151 */     String path = dir + "mzm.gsp.skill.confbean.SSkillBagCfg.bny";
/*     */     try
/*     */     {
/* 154 */       File file = new File(path);
/* 155 */       if (file.exists())
/*     */       {
/* 157 */         byte[] bytes = new byte['Ѐ'];
/* 158 */         FileInputStream fis = new FileInputStream(file);
/* 159 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 160 */         int len = 0;
/* 161 */         while ((len = fis.read(bytes)) > 0)
/* 162 */           baos.write(bytes, 0, len);
/* 163 */         fis.close();
/* 164 */         bytes = baos.toByteArray();
/* 165 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 168 */           _os_.unmarshal_int();
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/*     */         }
/* 172 */         _os_.unmarshal_int();
/* 173 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 176 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 178 */           SSkillBagCfg _v_ = new SSkillBagCfg();
/* 179 */           _v_.unmarshal(_os_);
/* 180 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 181 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 186 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSkillBagCfg> all)
/*     */   {
/* 198 */     String path = dir + "mzm.gsp.skill.confbean.SSkillBagCfg.bny";
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
/* 225 */           SSkillBagCfg _v_ = new SSkillBagCfg();
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
/*     */ 
/*     */   public static SSkillBagCfg getOld(int key)
/*     */   {
/* 246 */     return (SSkillBagCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSkillBagCfg get(int key)
/*     */   {
/* 251 */     return (SSkillBagCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillBagCfg> getOldAll()
/*     */   {
/* 256 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillBagCfg> getAll()
/*     */   {
/* 261 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSkillBagCfg> newAll)
/*     */   {
/* 266 */     oldAll = all;
/* 267 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 272 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SSkillBagCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */