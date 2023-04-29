/*     */ package mzm.gsp.monster.confbean;
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
/*     */ public class SBrightMonster extends SBaseBrightMonster implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBrightMonster> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBrightMonster> all = null;
/*     */   
/*     */   public String title;
/*     */   public int vanishType;
/*     */   public String talk;
/*     */   public String attackOptionTalk;
/*     */   public String notAttackOptionTalk;
/*     */   public String canNotAttackOptionTalk;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.templatename = rootElement.attributeValue("templatename");
/*  29 */     this.name = rootElement.attributeValue("name");
/*  30 */     this.maxKilledTimes = Integer.valueOf(rootElement.attributeValue("maxKilledTimes")).intValue();
/*  31 */     this.killedEffect = Integer.valueOf(rootElement.attributeValue("killedEffect")).intValue();
/*  32 */     this.isInAir = Boolean.valueOf(rootElement.attributeValue("isInAir")).booleanValue();
/*  33 */     this.velocity = Integer.valueOf(rootElement.attributeValue("velocity")).intValue();
/*  34 */     this.enterFightMinRoleNum = Integer.valueOf(rootElement.attributeValue("enterFightMinRoleNum")).intValue();
/*  35 */     this.enterFightMaxRoleNum = Integer.valueOf(rootElement.attributeValue("enterFightMaxRoleNum")).intValue();
/*  36 */     this.enterFightLevelType = Integer.valueOf(rootElement.attributeValue("enterFightLevelType")).intValue();
/*  37 */     this.enterFightMinLevel = Integer.valueOf(rootElement.attributeValue("enterFightMinLevel")).intValue();
/*  38 */     this.enterFightMaxLevel = Integer.valueOf(rootElement.attributeValue("enterFightMaxLevel")).intValue();
/*  39 */     this.monsterModelTableId = Integer.valueOf(rootElement.attributeValue("monsterModelTableId")).intValue();
/*  40 */     this.monsterFightTableId = Integer.valueOf(rootElement.attributeValue("monsterFightTableId")).intValue();
/*  41 */     this.controllerId = Integer.valueOf(rootElement.attributeValue("controllerId")).intValue();
/*  42 */     this.title = rootElement.attributeValue("title");
/*  43 */     this.vanishType = Integer.valueOf(rootElement.attributeValue("vanishType")).intValue();
/*  44 */     this.talk = rootElement.attributeValue("talk");
/*  45 */     this.attackOptionTalk = rootElement.attributeValue("attackOptionTalk");
/*  46 */     this.notAttackOptionTalk = rootElement.attributeValue("notAttackOptionTalk");
/*  47 */     this.canNotAttackOptionTalk = rootElement.attributeValue("canNotAttackOptionTalk");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  52 */     _os_.marshal(this.id);
/*  53 */     _os_.marshal(this.templatename, "UTF-8");
/*  54 */     _os_.marshal(this.name, "UTF-8");
/*  55 */     _os_.marshal(this.maxKilledTimes);
/*  56 */     _os_.marshal(this.killedEffect);
/*  57 */     _os_.marshal(this.isInAir);
/*  58 */     _os_.marshal(this.velocity);
/*  59 */     _os_.marshal(this.enterFightMinRoleNum);
/*  60 */     _os_.marshal(this.enterFightMaxRoleNum);
/*  61 */     _os_.marshal(this.enterFightLevelType);
/*  62 */     _os_.marshal(this.enterFightMinLevel);
/*  63 */     _os_.marshal(this.enterFightMaxLevel);
/*  64 */     _os_.marshal(this.monsterModelTableId);
/*  65 */     _os_.marshal(this.monsterFightTableId);
/*  66 */     _os_.marshal(this.controllerId);
/*  67 */     _os_.marshal(this.title, "UTF-8");
/*  68 */     _os_.marshal(this.vanishType);
/*  69 */     _os_.marshal(this.talk, "UTF-8");
/*  70 */     _os_.marshal(this.attackOptionTalk, "UTF-8");
/*  71 */     _os_.marshal(this.notAttackOptionTalk, "UTF-8");
/*  72 */     _os_.marshal(this.canNotAttackOptionTalk, "UTF-8");
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.id = _os_.unmarshal_int();
/*  79 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  80 */     this.name = _os_.unmarshal_String("UTF-8");
/*  81 */     this.maxKilledTimes = _os_.unmarshal_int();
/*  82 */     this.killedEffect = _os_.unmarshal_int();
/*  83 */     this.isInAir = _os_.unmarshal_boolean();
/*  84 */     this.velocity = _os_.unmarshal_int();
/*  85 */     this.enterFightMinRoleNum = _os_.unmarshal_int();
/*  86 */     this.enterFightMaxRoleNum = _os_.unmarshal_int();
/*  87 */     this.enterFightLevelType = _os_.unmarshal_int();
/*  88 */     this.enterFightMinLevel = _os_.unmarshal_int();
/*  89 */     this.enterFightMaxLevel = _os_.unmarshal_int();
/*  90 */     this.monsterModelTableId = _os_.unmarshal_int();
/*  91 */     this.monsterFightTableId = _os_.unmarshal_int();
/*  92 */     this.controllerId = _os_.unmarshal_int();
/*  93 */     this.title = _os_.unmarshal_String("UTF-8");
/*  94 */     this.vanishType = _os_.unmarshal_int();
/*  95 */     this.talk = _os_.unmarshal_String("UTF-8");
/*  96 */     this.attackOptionTalk = _os_.unmarshal_String("UTF-8");
/*  97 */     this.notAttackOptionTalk = _os_.unmarshal_String("UTF-8");
/*  98 */     this.canNotAttackOptionTalk = _os_.unmarshal_String("UTF-8");
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 104 */     String path = dir + "mzm.gsp.monster.confbean.SBrightMonster.xml";
/*     */     
/*     */     try
/*     */     {
/* 108 */       all = new java.util.HashMap();
/* 109 */       SAXReader reader = new SAXReader();
/* 110 */       org.dom4j.Document doc = reader.read(new File(path));
/* 111 */       Element root = doc.getRootElement();
/* 112 */       List<?> nodeList = root.elements();
/* 113 */       int len = nodeList.size();
/* 114 */       for (int i = 0; i < len; i++)
/*     */       {
/* 116 */         Element elem = (Element)nodeList.get(i);
/* 117 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SBrightMonster"))
/*     */         {
/*     */ 
/* 120 */           SBrightMonster obj = new SBrightMonster();
/* 121 */           obj.loadFromXml(elem);
/* 122 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 123 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 128 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBrightMonster> all)
/*     */   {
/* 134 */     String path = dir + "mzm.gsp.monster.confbean.SBrightMonster.xml";
/*     */     
/*     */     try
/*     */     {
/* 138 */       SAXReader reader = new SAXReader();
/* 139 */       org.dom4j.Document doc = reader.read(new File(path));
/* 140 */       Element root = doc.getRootElement();
/* 141 */       List<?> nodeList = root.elements();
/* 142 */       int len = nodeList.size();
/* 143 */       for (int i = 0; i < len; i++)
/*     */       {
/* 145 */         Element elem = (Element)nodeList.get(i);
/* 146 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SBrightMonster"))
/*     */         {
/*     */ 
/* 149 */           SBrightMonster obj = new SBrightMonster();
/* 150 */           obj.loadFromXml(elem);
/* 151 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 152 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 157 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 163 */     all = new java.util.HashMap();
/*     */     
/* 165 */     String path = dir + "mzm.gsp.monster.confbean.SBrightMonster.bny";
/*     */     try
/*     */     {
/* 168 */       File file = new File(path);
/* 169 */       if (file.exists())
/*     */       {
/* 171 */         byte[] bytes = new byte['Ѐ'];
/* 172 */         FileInputStream fis = new FileInputStream(file);
/* 173 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 174 */         int len = 0;
/* 175 */         while ((len = fis.read(bytes)) > 0)
/* 176 */           baos.write(bytes, 0, len);
/* 177 */         fis.close();
/* 178 */         bytes = baos.toByteArray();
/* 179 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 180 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 182 */           _os_.unmarshal_int();
/* 183 */           _os_.unmarshal_int();
/* 184 */           _os_.unmarshal_int();
/*     */         }
/* 186 */         _os_.unmarshal_int();
/* 187 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 190 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 192 */           SBrightMonster _v_ = new SBrightMonster();
/* 193 */           _v_.unmarshal(_os_);
/* 194 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 195 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 200 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBrightMonster> all)
/*     */   {
/* 212 */     String path = dir + "mzm.gsp.monster.confbean.SBrightMonster.bny";
/*     */     try
/*     */     {
/* 215 */       File file = new File(path);
/* 216 */       if (file.exists())
/*     */       {
/* 218 */         byte[] bytes = new byte['Ѐ'];
/* 219 */         FileInputStream fis = new FileInputStream(file);
/* 220 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 221 */         int len = 0;
/* 222 */         while ((len = fis.read(bytes)) > 0)
/* 223 */           baos.write(bytes, 0, len);
/* 224 */         fis.close();
/* 225 */         bytes = baos.toByteArray();
/* 226 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 227 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 229 */           _os_.unmarshal_int();
/* 230 */           _os_.unmarshal_int();
/* 231 */           _os_.unmarshal_int();
/*     */         }
/* 233 */         _os_.unmarshal_int();
/* 234 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 237 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 239 */           SBrightMonster _v_ = new SBrightMonster();
/* 240 */           _v_.unmarshal(_os_);
/* 241 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 242 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 247 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 252 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBrightMonster getOld(int key)
/*     */   {
/* 260 */     return (SBrightMonster)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBrightMonster get(int key)
/*     */   {
/* 265 */     return (SBrightMonster)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBrightMonster> getOldAll()
/*     */   {
/* 270 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBrightMonster> getAll()
/*     */   {
/* 275 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBrightMonster> newAll)
/*     */   {
/* 280 */     oldAll = all;
/* 281 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 286 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\confbean\SBrightMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */