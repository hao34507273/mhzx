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
/*     */ public class SSkillTargetPosSortCfg_Integration implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSkillTargetPosSortCfg_Integration> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSkillTargetPosSortCfg_Integration> all = null;
/*     */   
/*     */   public int id;
/*     */   public int group;
/*  20 */   public ArrayList<Integer> targetPos = new ArrayList();
/*  21 */   public ArrayList<Integer> pos = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.group = Integer.valueOf(rootElement.attributeValue("group")).intValue();
/*     */     
/*  28 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "targetPos");
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
/*  39 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  46 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  53 */         this.targetPos.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  57 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "pos");
/*  58 */     if (collectionElement == null)
/*     */     {
/*  60 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  63 */     List<?> _nodeList = collectionElement.elements();
/*  64 */     int _len = _nodeList.size();
/*  65 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  67 */       Element elem = (Element)_nodeList.get(i);
/*  68 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  75 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  82 */         this.pos.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  89 */     _os_.marshal(this.id);
/*  90 */     _os_.marshal(this.group);
/*  91 */     _os_.compact_uint32(this.targetPos.size());
/*  92 */     for (Integer _v_ : this.targetPos)
/*     */     {
/*  94 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  96 */     _os_.compact_uint32(this.pos.size());
/*  97 */     for (Integer _v_ : this.pos)
/*     */     {
/*  99 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 106 */     this.id = _os_.unmarshal_int();
/* 107 */     this.group = _os_.unmarshal_int();
/* 108 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 111 */       int _v_ = _os_.unmarshal_int();
/* 112 */       this.targetPos.add(Integer.valueOf(_v_));
/*     */     }
/* 114 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 117 */       int _v_ = _os_.unmarshal_int();
/* 118 */       this.pos.add(Integer.valueOf(_v_));
/*     */     }
/* 120 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.skill.confbean.SSkillTargetPosSortCfg_Integration.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       all = new java.util.HashMap();
/* 130 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 131 */       org.dom4j.Document doc = reader.read(new File(path));
/* 132 */       Element root = doc.getRootElement();
/* 133 */       List<?> nodeList = root.elements();
/* 134 */       int len = nodeList.size();
/* 135 */       for (int i = 0; i < len; i++)
/*     */       {
/* 137 */         Element elem = (Element)nodeList.get(i);
/* 138 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillTargetPosSortCfg_Integration"))
/*     */         {
/*     */ 
/* 141 */           SSkillTargetPosSortCfg_Integration obj = new SSkillTargetPosSortCfg_Integration();
/* 142 */           obj.loadFromXml(elem);
/* 143 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 144 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 149 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSkillTargetPosSortCfg_Integration> all)
/*     */   {
/* 155 */     String path = dir + "mzm.gsp.skill.confbean.SSkillTargetPosSortCfg_Integration.xml";
/*     */     
/*     */     try
/*     */     {
/* 159 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 160 */       org.dom4j.Document doc = reader.read(new File(path));
/* 161 */       Element root = doc.getRootElement();
/* 162 */       List<?> nodeList = root.elements();
/* 163 */       int len = nodeList.size();
/* 164 */       for (int i = 0; i < len; i++)
/*     */       {
/* 166 */         Element elem = (Element)nodeList.get(i);
/* 167 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillTargetPosSortCfg_Integration"))
/*     */         {
/*     */ 
/* 170 */           SSkillTargetPosSortCfg_Integration obj = new SSkillTargetPosSortCfg_Integration();
/* 171 */           obj.loadFromXml(elem);
/* 172 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 173 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 178 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 184 */     all = new java.util.HashMap();
/*     */     
/* 186 */     String path = dir + "mzm.gsp.skill.confbean.SSkillTargetPosSortCfg_Integration.bny";
/*     */     try
/*     */     {
/* 189 */       File file = new File(path);
/* 190 */       if (file.exists())
/*     */       {
/* 192 */         byte[] bytes = new byte['Ѐ'];
/* 193 */         FileInputStream fis = new FileInputStream(file);
/* 194 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 195 */         int len = 0;
/* 196 */         while ((len = fis.read(bytes)) > 0)
/* 197 */           baos.write(bytes, 0, len);
/* 198 */         fis.close();
/* 199 */         bytes = baos.toByteArray();
/* 200 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 203 */           _os_.unmarshal_int();
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/*     */         }
/* 207 */         _os_.unmarshal_int();
/* 208 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 211 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 213 */           SSkillTargetPosSortCfg_Integration _v_ = new SSkillTargetPosSortCfg_Integration();
/* 214 */           _v_.unmarshal(_os_);
/* 215 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 216 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 221 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 226 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSkillTargetPosSortCfg_Integration> all)
/*     */   {
/* 233 */     String path = dir + "mzm.gsp.skill.confbean.SSkillTargetPosSortCfg_Integration.bny";
/*     */     try
/*     */     {
/* 236 */       File file = new File(path);
/* 237 */       if (file.exists())
/*     */       {
/* 239 */         byte[] bytes = new byte['Ѐ'];
/* 240 */         FileInputStream fis = new FileInputStream(file);
/* 241 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 242 */         int len = 0;
/* 243 */         while ((len = fis.read(bytes)) > 0)
/* 244 */           baos.write(bytes, 0, len);
/* 245 */         fis.close();
/* 246 */         bytes = baos.toByteArray();
/* 247 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 248 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 250 */           _os_.unmarshal_int();
/* 251 */           _os_.unmarshal_int();
/* 252 */           _os_.unmarshal_int();
/*     */         }
/* 254 */         _os_.unmarshal_int();
/* 255 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 258 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 260 */           SSkillTargetPosSortCfg_Integration _v_ = new SSkillTargetPosSortCfg_Integration();
/* 261 */           _v_.unmarshal(_os_);
/* 262 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 263 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 268 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 273 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSkillTargetPosSortCfg_Integration getOld(int key)
/*     */   {
/* 281 */     return (SSkillTargetPosSortCfg_Integration)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSkillTargetPosSortCfg_Integration get(int key)
/*     */   {
/* 286 */     return (SSkillTargetPosSortCfg_Integration)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillTargetPosSortCfg_Integration> getOldAll()
/*     */   {
/* 291 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillTargetPosSortCfg_Integration> getAll()
/*     */   {
/* 296 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSkillTargetPosSortCfg_Integration> newAll)
/*     */   {
/* 301 */     oldAll = all;
/* 302 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 307 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SSkillTargetPosSortCfg_Integration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */