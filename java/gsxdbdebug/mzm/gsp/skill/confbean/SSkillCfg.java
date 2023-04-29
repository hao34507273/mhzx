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
/*     */ public class SSkillCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSkillCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSkillCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public int type;
/*     */   public int specialType;
/*     */   public int icon;
/*     */   public String description;
/*     */   public boolean canAuto;
/*     */   public boolean canBeCounterAttack;
/*     */   public boolean canBeProtect;
/*     */   public int condition;
/*     */   public int skilltargettype1;
/*     */   public int skilltargettype2;
/*     */   public int skilltargettype3;
/*     */   public int skilltargettype4;
/*     */   public int skilltargettype5;
/*     */   public boolean autoSelectSecond;
/*     */   public int targetnumformula;
/*     */   public int secondTarget;
/*     */   public int secondTargetSort;
/*  37 */   public java.util.ArrayList<Integer> skillEffectGroupId = new java.util.ArrayList();
/*     */   public int skillPlayid;
/*     */   public int speedModify;
/*     */   public int cdRound;
/*     */   public int complexSkillid;
/*     */   public int useCountInFight;
/*     */   public boolean isMenPaiSkill;
/*     */   public int mountsSkillClassid;
/*     */   public boolean isUltimateSkill;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  49 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  50 */     this.name = rootElement.attributeValue("name");
/*  51 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  52 */     this.specialType = Integer.valueOf(rootElement.attributeValue("specialType")).intValue();
/*  53 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  54 */     this.description = rootElement.attributeValue("description");
/*  55 */     this.canAuto = Boolean.valueOf(rootElement.attributeValue("canAuto")).booleanValue();
/*  56 */     this.canBeCounterAttack = Boolean.valueOf(rootElement.attributeValue("canBeCounterAttack")).booleanValue();
/*  57 */     this.canBeProtect = Boolean.valueOf(rootElement.attributeValue("canBeProtect")).booleanValue();
/*  58 */     this.condition = Integer.valueOf(rootElement.attributeValue("condition")).intValue();
/*  59 */     this.skilltargettype1 = Integer.valueOf(rootElement.attributeValue("skilltargettype1")).intValue();
/*  60 */     this.skilltargettype2 = Integer.valueOf(rootElement.attributeValue("skilltargettype2")).intValue();
/*  61 */     this.skilltargettype3 = Integer.valueOf(rootElement.attributeValue("skilltargettype3")).intValue();
/*  62 */     this.skilltargettype4 = Integer.valueOf(rootElement.attributeValue("skilltargettype4")).intValue();
/*  63 */     this.skilltargettype5 = Integer.valueOf(rootElement.attributeValue("skilltargettype5")).intValue();
/*  64 */     this.autoSelectSecond = Boolean.valueOf(rootElement.attributeValue("autoSelectSecond")).booleanValue();
/*  65 */     this.targetnumformula = Integer.valueOf(rootElement.attributeValue("targetnumformula")).intValue();
/*  66 */     this.secondTarget = Integer.valueOf(rootElement.attributeValue("secondTarget")).intValue();
/*  67 */     this.secondTargetSort = Integer.valueOf(rootElement.attributeValue("secondTargetSort")).intValue();
/*     */     
/*  69 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "skillEffectGroupId");
/*  70 */     if (collectionElement == null)
/*     */     {
/*  72 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  75 */     List<?> _nodeList = collectionElement.elements();
/*  76 */     int _len = _nodeList.size();
/*  77 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  79 */       Element elem = (Element)_nodeList.get(i);
/*  80 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  87 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  94 */         this.skillEffectGroupId.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  97 */     this.skillPlayid = Integer.valueOf(rootElement.attributeValue("skillPlayid")).intValue();
/*  98 */     this.speedModify = Integer.valueOf(rootElement.attributeValue("speedModify")).intValue();
/*  99 */     this.cdRound = Integer.valueOf(rootElement.attributeValue("cdRound")).intValue();
/* 100 */     this.complexSkillid = Integer.valueOf(rootElement.attributeValue("complexSkillid")).intValue();
/* 101 */     this.useCountInFight = Integer.valueOf(rootElement.attributeValue("useCountInFight")).intValue();
/* 102 */     this.isMenPaiSkill = Boolean.valueOf(rootElement.attributeValue("isMenPaiSkill")).booleanValue();
/* 103 */     this.mountsSkillClassid = Integer.valueOf(rootElement.attributeValue("mountsSkillClassid")).intValue();
/* 104 */     this.isUltimateSkill = Boolean.valueOf(rootElement.attributeValue("isUltimateSkill")).booleanValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 109 */     _os_.marshal(this.id);
/* 110 */     _os_.marshal(this.name, "UTF-8");
/* 111 */     _os_.marshal(this.type);
/* 112 */     _os_.marshal(this.specialType);
/* 113 */     _os_.marshal(this.icon);
/* 114 */     _os_.marshal(this.description, "UTF-8");
/* 115 */     _os_.marshal(this.canAuto);
/* 116 */     _os_.marshal(this.canBeCounterAttack);
/* 117 */     _os_.marshal(this.canBeProtect);
/* 118 */     _os_.marshal(this.condition);
/* 119 */     _os_.marshal(this.skilltargettype1);
/* 120 */     _os_.marshal(this.skilltargettype2);
/* 121 */     _os_.marshal(this.skilltargettype3);
/* 122 */     _os_.marshal(this.skilltargettype4);
/* 123 */     _os_.marshal(this.skilltargettype5);
/* 124 */     _os_.marshal(this.autoSelectSecond);
/* 125 */     _os_.marshal(this.targetnumformula);
/* 126 */     _os_.marshal(this.secondTarget);
/* 127 */     _os_.marshal(this.secondTargetSort);
/* 128 */     _os_.compact_uint32(this.skillEffectGroupId.size());
/* 129 */     for (Integer _v_ : this.skillEffectGroupId)
/*     */     {
/* 131 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 133 */     _os_.marshal(this.skillPlayid);
/* 134 */     _os_.marshal(this.speedModify);
/* 135 */     _os_.marshal(this.cdRound);
/* 136 */     _os_.marshal(this.complexSkillid);
/* 137 */     _os_.marshal(this.useCountInFight);
/* 138 */     _os_.marshal(this.isMenPaiSkill);
/* 139 */     _os_.marshal(this.mountsSkillClassid);
/* 140 */     _os_.marshal(this.isUltimateSkill);
/* 141 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 146 */     this.id = _os_.unmarshal_int();
/* 147 */     this.name = _os_.unmarshal_String("UTF-8");
/* 148 */     this.type = _os_.unmarshal_int();
/* 149 */     this.specialType = _os_.unmarshal_int();
/* 150 */     this.icon = _os_.unmarshal_int();
/* 151 */     this.description = _os_.unmarshal_String("UTF-8");
/* 152 */     this.canAuto = _os_.unmarshal_boolean();
/* 153 */     this.canBeCounterAttack = _os_.unmarshal_boolean();
/* 154 */     this.canBeProtect = _os_.unmarshal_boolean();
/* 155 */     this.condition = _os_.unmarshal_int();
/* 156 */     this.skilltargettype1 = _os_.unmarshal_int();
/* 157 */     this.skilltargettype2 = _os_.unmarshal_int();
/* 158 */     this.skilltargettype3 = _os_.unmarshal_int();
/* 159 */     this.skilltargettype4 = _os_.unmarshal_int();
/* 160 */     this.skilltargettype5 = _os_.unmarshal_int();
/* 161 */     this.autoSelectSecond = _os_.unmarshal_boolean();
/* 162 */     this.targetnumformula = _os_.unmarshal_int();
/* 163 */     this.secondTarget = _os_.unmarshal_int();
/* 164 */     this.secondTargetSort = _os_.unmarshal_int();
/* 165 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 168 */       int _v_ = _os_.unmarshal_int();
/* 169 */       this.skillEffectGroupId.add(Integer.valueOf(_v_));
/*     */     }
/* 171 */     this.skillPlayid = _os_.unmarshal_int();
/* 172 */     this.speedModify = _os_.unmarshal_int();
/* 173 */     this.cdRound = _os_.unmarshal_int();
/* 174 */     this.complexSkillid = _os_.unmarshal_int();
/* 175 */     this.useCountInFight = _os_.unmarshal_int();
/* 176 */     this.isMenPaiSkill = _os_.unmarshal_boolean();
/* 177 */     this.mountsSkillClassid = _os_.unmarshal_int();
/* 178 */     this.isUltimateSkill = _os_.unmarshal_boolean();
/* 179 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 184 */     String path = dir + "mzm.gsp.skill.confbean.SSkillCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 188 */       all = new java.util.HashMap();
/* 189 */       SAXReader reader = new SAXReader();
/* 190 */       org.dom4j.Document doc = reader.read(new File(path));
/* 191 */       Element root = doc.getRootElement();
/* 192 */       List<?> nodeList = root.elements();
/* 193 */       int len = nodeList.size();
/* 194 */       for (int i = 0; i < len; i++)
/*     */       {
/* 196 */         Element elem = (Element)nodeList.get(i);
/* 197 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillCfg"))
/*     */         {
/*     */ 
/* 200 */           SSkillCfg obj = new SSkillCfg();
/* 201 */           obj.loadFromXml(elem);
/* 202 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 203 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSkillCfg> all)
/*     */   {
/* 214 */     String path = dir + "mzm.gsp.skill.confbean.SSkillCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 218 */       SAXReader reader = new SAXReader();
/* 219 */       org.dom4j.Document doc = reader.read(new File(path));
/* 220 */       Element root = doc.getRootElement();
/* 221 */       List<?> nodeList = root.elements();
/* 222 */       int len = nodeList.size();
/* 223 */       for (int i = 0; i < len; i++)
/*     */       {
/* 225 */         Element elem = (Element)nodeList.get(i);
/* 226 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SSkillCfg"))
/*     */         {
/*     */ 
/* 229 */           SSkillCfg obj = new SSkillCfg();
/* 230 */           obj.loadFromXml(elem);
/* 231 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 232 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 237 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 243 */     all = new java.util.HashMap();
/*     */     
/* 245 */     String path = dir + "mzm.gsp.skill.confbean.SSkillCfg.bny";
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
/* 272 */           SSkillCfg _v_ = new SSkillCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SSkillCfg> all)
/*     */   {
/* 292 */     String path = dir + "mzm.gsp.skill.confbean.SSkillCfg.bny";
/*     */     try
/*     */     {
/* 295 */       File file = new File(path);
/* 296 */       if (file.exists())
/*     */       {
/* 298 */         byte[] bytes = new byte['Ѐ'];
/* 299 */         FileInputStream fis = new FileInputStream(file);
/* 300 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 301 */         int len = 0;
/* 302 */         while ((len = fis.read(bytes)) > 0)
/* 303 */           baos.write(bytes, 0, len);
/* 304 */         fis.close();
/* 305 */         bytes = baos.toByteArray();
/* 306 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 307 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 309 */           _os_.unmarshal_int();
/* 310 */           _os_.unmarshal_int();
/* 311 */           _os_.unmarshal_int();
/*     */         }
/* 313 */         _os_.unmarshal_int();
/* 314 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 317 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 319 */           SSkillCfg _v_ = new SSkillCfg();
/* 320 */           _v_.unmarshal(_os_);
/* 321 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 322 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 327 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 332 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSkillCfg getOld(int key)
/*     */   {
/* 340 */     return (SSkillCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSkillCfg get(int key)
/*     */   {
/* 345 */     return (SSkillCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillCfg> getOldAll()
/*     */   {
/* 350 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSkillCfg> getAll()
/*     */   {
/* 355 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSkillCfg> newAll)
/*     */   {
/* 360 */     oldAll = all;
/* 361 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 366 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SSkillCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */