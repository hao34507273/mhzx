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
/*     */ public class SMonsterSkillCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMonsterSkillCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMonsterSkillCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int randomType;
/*  20 */   public java.util.ArrayList<MonsterSkill2Prob> monsterSkill2Prob = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  25 */     this.randomType = Integer.valueOf(rootElement.attributeValue("randomType")).intValue();
/*     */     
/*  27 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "monsterSkill2Prob");
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
/*  38 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.MonsterSkill2Prob"))
/*     */       {
/*     */         MonsterSkill2Prob _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  45 */           _v_ = new MonsterSkill2Prob();
/*  46 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  53 */         this.monsterSkill2Prob.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _os_.marshal(this.id);
/*  61 */     _os_.marshal(this.randomType);
/*  62 */     _os_.compact_uint32(this.monsterSkill2Prob.size());
/*  63 */     for (MonsterSkill2Prob _v_ : this.monsterSkill2Prob)
/*     */     {
/*  65 */       _os_.marshal(_v_);
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.randomType = _os_.unmarshal_int();
/*  74 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  77 */       MonsterSkill2Prob _v_ = new MonsterSkill2Prob();
/*  78 */       _v_.unmarshal(_os_);
/*  79 */       this.monsterSkill2Prob.add(_v_);
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  86 */     String path = dir + "mzm.gsp.skill.confbean.SMonsterSkillCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  90 */       all = new java.util.HashMap();
/*  91 */       SAXReader reader = new SAXReader();
/*  92 */       org.dom4j.Document doc = reader.read(new File(path));
/*  93 */       Element root = doc.getRootElement();
/*  94 */       List<?> nodeList = root.elements();
/*  95 */       int len = nodeList.size();
/*  96 */       for (int i = 0; i < len; i++)
/*     */       {
/*  98 */         Element elem = (Element)nodeList.get(i);
/*  99 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SMonsterSkillCfg"))
/*     */         {
/*     */ 
/* 102 */           SMonsterSkillCfg obj = new SMonsterSkillCfg();
/* 103 */           obj.loadFromXml(elem);
/* 104 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 105 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 110 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMonsterSkillCfg> all)
/*     */   {
/* 116 */     String path = dir + "mzm.gsp.skill.confbean.SMonsterSkillCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 120 */       SAXReader reader = new SAXReader();
/* 121 */       org.dom4j.Document doc = reader.read(new File(path));
/* 122 */       Element root = doc.getRootElement();
/* 123 */       List<?> nodeList = root.elements();
/* 124 */       int len = nodeList.size();
/* 125 */       for (int i = 0; i < len; i++)
/*     */       {
/* 127 */         Element elem = (Element)nodeList.get(i);
/* 128 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SMonsterSkillCfg"))
/*     */         {
/*     */ 
/* 131 */           SMonsterSkillCfg obj = new SMonsterSkillCfg();
/* 132 */           obj.loadFromXml(elem);
/* 133 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 134 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 139 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 145 */     all = new java.util.HashMap();
/*     */     
/* 147 */     String path = dir + "mzm.gsp.skill.confbean.SMonsterSkillCfg.bny";
/*     */     try
/*     */     {
/* 150 */       File file = new File(path);
/* 151 */       if (file.exists())
/*     */       {
/* 153 */         byte[] bytes = new byte['Ѐ'];
/* 154 */         FileInputStream fis = new FileInputStream(file);
/* 155 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 156 */         int len = 0;
/* 157 */         while ((len = fis.read(bytes)) > 0)
/* 158 */           baos.write(bytes, 0, len);
/* 159 */         fis.close();
/* 160 */         bytes = baos.toByteArray();
/* 161 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 164 */           _os_.unmarshal_int();
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/*     */         }
/* 168 */         _os_.unmarshal_int();
/* 169 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 172 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 174 */           SMonsterSkillCfg _v_ = new SMonsterSkillCfg();
/* 175 */           _v_.unmarshal(_os_);
/* 176 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 177 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 182 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 187 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMonsterSkillCfg> all)
/*     */   {
/* 194 */     String path = dir + "mzm.gsp.skill.confbean.SMonsterSkillCfg.bny";
/*     */     try
/*     */     {
/* 197 */       File file = new File(path);
/* 198 */       if (file.exists())
/*     */       {
/* 200 */         byte[] bytes = new byte['Ѐ'];
/* 201 */         FileInputStream fis = new FileInputStream(file);
/* 202 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 203 */         int len = 0;
/* 204 */         while ((len = fis.read(bytes)) > 0)
/* 205 */           baos.write(bytes, 0, len);
/* 206 */         fis.close();
/* 207 */         bytes = baos.toByteArray();
/* 208 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 211 */           _os_.unmarshal_int();
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/*     */         }
/* 215 */         _os_.unmarshal_int();
/* 216 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 219 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 221 */           SMonsterSkillCfg _v_ = new SMonsterSkillCfg();
/* 222 */           _v_.unmarshal(_os_);
/* 223 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 224 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 229 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 234 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMonsterSkillCfg getOld(int key)
/*     */   {
/* 242 */     return (SMonsterSkillCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMonsterSkillCfg get(int key)
/*     */   {
/* 247 */     return (SMonsterSkillCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMonsterSkillCfg> getOldAll()
/*     */   {
/* 252 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMonsterSkillCfg> getAll()
/*     */   {
/* 257 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMonsterSkillCfg> newAll)
/*     */   {
/* 262 */     oldAll = all;
/* 263 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 268 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SMonsterSkillCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */