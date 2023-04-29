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
/*     */ public class SActiveBrightMonster extends SBaseBrightMonster implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SActiveBrightMonster> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SActiveBrightMonster> all = null;
/*     */   
/*     */   public boolean isDieVanish;
/*     */   public int attackRadius;
/*     */   public int attackTimeInterval;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  25 */     this.templatename = rootElement.attributeValue("templatename");
/*  26 */     this.name = rootElement.attributeValue("name");
/*  27 */     this.maxKilledTimes = Integer.valueOf(rootElement.attributeValue("maxKilledTimes")).intValue();
/*  28 */     this.killedEffect = Integer.valueOf(rootElement.attributeValue("killedEffect")).intValue();
/*  29 */     this.isInAir = Boolean.valueOf(rootElement.attributeValue("isInAir")).booleanValue();
/*  30 */     this.velocity = Integer.valueOf(rootElement.attributeValue("velocity")).intValue();
/*  31 */     this.enterFightMinRoleNum = Integer.valueOf(rootElement.attributeValue("enterFightMinRoleNum")).intValue();
/*  32 */     this.enterFightMaxRoleNum = Integer.valueOf(rootElement.attributeValue("enterFightMaxRoleNum")).intValue();
/*  33 */     this.enterFightLevelType = Integer.valueOf(rootElement.attributeValue("enterFightLevelType")).intValue();
/*  34 */     this.enterFightMinLevel = Integer.valueOf(rootElement.attributeValue("enterFightMinLevel")).intValue();
/*  35 */     this.enterFightMaxLevel = Integer.valueOf(rootElement.attributeValue("enterFightMaxLevel")).intValue();
/*  36 */     this.monsterModelTableId = Integer.valueOf(rootElement.attributeValue("monsterModelTableId")).intValue();
/*  37 */     this.monsterFightTableId = Integer.valueOf(rootElement.attributeValue("monsterFightTableId")).intValue();
/*  38 */     this.controllerId = Integer.valueOf(rootElement.attributeValue("controllerId")).intValue();
/*  39 */     this.isDieVanish = Boolean.valueOf(rootElement.attributeValue("isDieVanish")).booleanValue();
/*  40 */     this.attackRadius = Integer.valueOf(rootElement.attributeValue("attackRadius")).intValue();
/*  41 */     this.attackTimeInterval = Integer.valueOf(rootElement.attributeValue("attackTimeInterval")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  46 */     _os_.marshal(this.id);
/*  47 */     _os_.marshal(this.templatename, "UTF-8");
/*  48 */     _os_.marshal(this.name, "UTF-8");
/*  49 */     _os_.marshal(this.maxKilledTimes);
/*  50 */     _os_.marshal(this.killedEffect);
/*  51 */     _os_.marshal(this.isInAir);
/*  52 */     _os_.marshal(this.velocity);
/*  53 */     _os_.marshal(this.enterFightMinRoleNum);
/*  54 */     _os_.marshal(this.enterFightMaxRoleNum);
/*  55 */     _os_.marshal(this.enterFightLevelType);
/*  56 */     _os_.marshal(this.enterFightMinLevel);
/*  57 */     _os_.marshal(this.enterFightMaxLevel);
/*  58 */     _os_.marshal(this.monsterModelTableId);
/*  59 */     _os_.marshal(this.monsterFightTableId);
/*  60 */     _os_.marshal(this.controllerId);
/*  61 */     _os_.marshal(this.isDieVanish);
/*  62 */     _os_.marshal(this.attackRadius);
/*  63 */     _os_.marshal(this.attackTimeInterval);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  71 */     this.name = _os_.unmarshal_String("UTF-8");
/*  72 */     this.maxKilledTimes = _os_.unmarshal_int();
/*  73 */     this.killedEffect = _os_.unmarshal_int();
/*  74 */     this.isInAir = _os_.unmarshal_boolean();
/*  75 */     this.velocity = _os_.unmarshal_int();
/*  76 */     this.enterFightMinRoleNum = _os_.unmarshal_int();
/*  77 */     this.enterFightMaxRoleNum = _os_.unmarshal_int();
/*  78 */     this.enterFightLevelType = _os_.unmarshal_int();
/*  79 */     this.enterFightMinLevel = _os_.unmarshal_int();
/*  80 */     this.enterFightMaxLevel = _os_.unmarshal_int();
/*  81 */     this.monsterModelTableId = _os_.unmarshal_int();
/*  82 */     this.monsterFightTableId = _os_.unmarshal_int();
/*  83 */     this.controllerId = _os_.unmarshal_int();
/*  84 */     this.isDieVanish = _os_.unmarshal_boolean();
/*  85 */     this.attackRadius = _os_.unmarshal_int();
/*  86 */     this.attackTimeInterval = _os_.unmarshal_int();
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  92 */     String path = dir + "mzm.gsp.monster.confbean.SActiveBrightMonster.xml";
/*     */     
/*     */     try
/*     */     {
/*  96 */       all = new java.util.HashMap();
/*  97 */       SAXReader reader = new SAXReader();
/*  98 */       org.dom4j.Document doc = reader.read(new File(path));
/*  99 */       Element root = doc.getRootElement();
/* 100 */       List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element elem = (Element)nodeList.get(i);
/* 105 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SActiveBrightMonster"))
/*     */         {
/*     */ 
/* 108 */           SActiveBrightMonster obj = new SActiveBrightMonster();
/* 109 */           obj.loadFromXml(elem);
/* 110 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 111 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 116 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SActiveBrightMonster> all)
/*     */   {
/* 122 */     String path = dir + "mzm.gsp.monster.confbean.SActiveBrightMonster.xml";
/*     */     
/*     */     try
/*     */     {
/* 126 */       SAXReader reader = new SAXReader();
/* 127 */       org.dom4j.Document doc = reader.read(new File(path));
/* 128 */       Element root = doc.getRootElement();
/* 129 */       List<?> nodeList = root.elements();
/* 130 */       int len = nodeList.size();
/* 131 */       for (int i = 0; i < len; i++)
/*     */       {
/* 133 */         Element elem = (Element)nodeList.get(i);
/* 134 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SActiveBrightMonster"))
/*     */         {
/*     */ 
/* 137 */           SActiveBrightMonster obj = new SActiveBrightMonster();
/* 138 */           obj.loadFromXml(elem);
/* 139 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 145 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 151 */     all = new java.util.HashMap();
/*     */     
/* 153 */     String path = dir + "mzm.gsp.monster.confbean.SActiveBrightMonster.bny";
/*     */     try
/*     */     {
/* 156 */       File file = new File(path);
/* 157 */       if (file.exists())
/*     */       {
/* 159 */         byte[] bytes = new byte['Ѐ'];
/* 160 */         FileInputStream fis = new FileInputStream(file);
/* 161 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 162 */         int len = 0;
/* 163 */         while ((len = fis.read(bytes)) > 0)
/* 164 */           baos.write(bytes, 0, len);
/* 165 */         fis.close();
/* 166 */         bytes = baos.toByteArray();
/* 167 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 168 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/* 172 */           _os_.unmarshal_int();
/*     */         }
/* 174 */         _os_.unmarshal_int();
/* 175 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 178 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 180 */           SActiveBrightMonster _v_ = new SActiveBrightMonster();
/* 181 */           _v_.unmarshal(_os_);
/* 182 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 183 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 188 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 193 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SActiveBrightMonster> all)
/*     */   {
/* 200 */     String path = dir + "mzm.gsp.monster.confbean.SActiveBrightMonster.bny";
/*     */     try
/*     */     {
/* 203 */       File file = new File(path);
/* 204 */       if (file.exists())
/*     */       {
/* 206 */         byte[] bytes = new byte['Ѐ'];
/* 207 */         FileInputStream fis = new FileInputStream(file);
/* 208 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 209 */         int len = 0;
/* 210 */         while ((len = fis.read(bytes)) > 0)
/* 211 */           baos.write(bytes, 0, len);
/* 212 */         fis.close();
/* 213 */         bytes = baos.toByteArray();
/* 214 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 215 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/* 219 */           _os_.unmarshal_int();
/*     */         }
/* 221 */         _os_.unmarshal_int();
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 225 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 227 */           SActiveBrightMonster _v_ = new SActiveBrightMonster();
/* 228 */           _v_.unmarshal(_os_);
/* 229 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 230 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 235 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 240 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SActiveBrightMonster getOld(int key)
/*     */   {
/* 248 */     return (SActiveBrightMonster)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SActiveBrightMonster get(int key)
/*     */   {
/* 253 */     return (SActiveBrightMonster)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SActiveBrightMonster> getOldAll()
/*     */   {
/* 258 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SActiveBrightMonster> getAll()
/*     */   {
/* 263 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SActiveBrightMonster> newAll)
/*     */   {
/* 268 */     oldAll = all;
/* 269 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 274 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\confbean\SActiveBrightMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */