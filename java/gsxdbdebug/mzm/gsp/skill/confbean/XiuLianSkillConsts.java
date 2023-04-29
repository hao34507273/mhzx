/*     */ package mzm.gsp.skill.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class XiuLianSkillConsts
/*     */ {
/*  13 */   private static volatile XiuLianSkillConsts oldInstance = null;
/*     */   
/*  15 */   private static XiuLianSkillConsts instance = new XiuLianSkillConsts();
/*     */   
/*     */   public int XIULIAN_LEARN_NEED_SILVER;
/*     */   public int XIULIAN_LEARN_ADD_EXP;
/*     */   public int OPEN_LEVEL;
/*     */   
/*     */   public static XiuLianSkillConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static XiuLianSkillConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int SKILL_BAG_ORGINAL_LEVEL;
/*     */   
/*     */   public int SKILL_BAG_MAX_LEVEL;
/*     */   
/*     */   public int DEFAULT_XIULIAN_SKILL_CFG_ID;
/*     */   
/*     */   public int STUDY_HUNDRED_OPEN_LEVEL;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  41 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  46 */     String path = dir + "mzm.gsp.skill.confbean.XiuLianSkillConsts.xml";
/*     */     try
/*     */     {
/*  49 */       SAXReader reader = new SAXReader();
/*  50 */       org.dom4j.Document doc = reader.read(new File(path));
/*  51 */       Element root = doc.getRootElement();
/*  52 */       Map<String, Element> data = new java.util.HashMap();
/*  53 */       java.util.List<?> nodeList = root.elements();
/*  54 */       int len = nodeList.size();
/*  55 */       for (int i = 0; i < len; i++)
/*     */       {
/*  57 */         Element element = (Element)nodeList.get(i);
/*  58 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  61 */           String name = element.attributeValue("name");
/*  62 */           if (data.put(name, element) != null)
/*  63 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  66 */       this.XIULIAN_LEARN_NEED_SILVER = Integer.valueOf(((Element)data.get("XIULIAN_LEARN_NEED_SILVER")).attributeValue("value")).intValue();
/*  67 */       this.XIULIAN_LEARN_ADD_EXP = Integer.valueOf(((Element)data.get("XIULIAN_LEARN_ADD_EXP")).attributeValue("value")).intValue();
/*  68 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/*  69 */       this.SKILL_BAG_ORGINAL_LEVEL = Integer.valueOf(((Element)data.get("SKILL_BAG_ORGINAL_LEVEL")).attributeValue("value")).intValue();
/*  70 */       this.SKILL_BAG_MAX_LEVEL = Integer.valueOf(((Element)data.get("SKILL_BAG_MAX_LEVEL")).attributeValue("value")).intValue();
/*  71 */       this.DEFAULT_XIULIAN_SKILL_CFG_ID = Integer.valueOf(((Element)data.get("DEFAULT_XIULIAN_SKILL_CFG_ID")).attributeValue("value")).intValue();
/*  72 */       this.STUDY_HUNDRED_OPEN_LEVEL = Integer.valueOf(((Element)data.get("STUDY_HUNDRED_OPEN_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  76 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  81 */     String path = dir + "mzm.gsp.skill.confbean.XiuLianSkillConsts.xml";
/*     */     try
/*     */     {
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       Map<String, Element> data = new java.util.HashMap();
/*  88 */       java.util.List<?> nodeList = root.elements();
/*  89 */       int len = nodeList.size();
/*  90 */       for (int i = 0; i < len; i++)
/*     */       {
/*  92 */         Element element = (Element)nodeList.get(i);
/*  93 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  96 */           String name = element.attributeValue("name");
/*  97 */           if (data.put(name, element) != null)
/*  98 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 101 */       this.XIULIAN_LEARN_NEED_SILVER = Integer.valueOf(((Element)data.get("XIULIAN_LEARN_NEED_SILVER")).attributeValue("value")).intValue();
/* 102 */       this.XIULIAN_LEARN_ADD_EXP = Integer.valueOf(((Element)data.get("XIULIAN_LEARN_ADD_EXP")).attributeValue("value")).intValue();
/* 103 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/* 104 */       this.SKILL_BAG_ORGINAL_LEVEL = Integer.valueOf(((Element)data.get("SKILL_BAG_ORGINAL_LEVEL")).attributeValue("value")).intValue();
/* 105 */       this.SKILL_BAG_MAX_LEVEL = Integer.valueOf(((Element)data.get("SKILL_BAG_MAX_LEVEL")).attributeValue("value")).intValue();
/* 106 */       this.DEFAULT_XIULIAN_SKILL_CFG_ID = Integer.valueOf(((Element)data.get("DEFAULT_XIULIAN_SKILL_CFG_ID")).attributeValue("value")).intValue();
/* 107 */       this.STUDY_HUNDRED_OPEN_LEVEL = Integer.valueOf(((Element)data.get("STUDY_HUNDRED_OPEN_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 115 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 118 */     String path = dir + "mzm.gsp.skill.confbean.XiuLianSkillConsts.bny";
/*     */     try
/*     */     {
/* 121 */       File file = new File(path);
/* 122 */       if (file.exists())
/*     */       {
/* 124 */         byte[] bytes = new byte['Ѐ'];
/* 125 */         FileInputStream fis = new FileInputStream(file);
/* 126 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 127 */         int len = 0;
/* 128 */         while ((len = fis.read(bytes)) > 0)
/* 129 */           baos.write(bytes, 0, len);
/* 130 */         fis.close();
/* 131 */         bytes = baos.toByteArray();
/* 132 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 133 */         this.XIULIAN_LEARN_NEED_SILVER = _os_.unmarshal_int();
/* 134 */         this.XIULIAN_LEARN_ADD_EXP = _os_.unmarshal_int();
/* 135 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 136 */         this.SKILL_BAG_ORGINAL_LEVEL = _os_.unmarshal_int();
/* 137 */         this.SKILL_BAG_MAX_LEVEL = _os_.unmarshal_int();
/* 138 */         this.DEFAULT_XIULIAN_SKILL_CFG_ID = _os_.unmarshal_int();
/* 139 */         this.STUDY_HUNDRED_OPEN_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 150 */     String path = dir + "mzm.gsp.skill.confbean.XiuLianSkillConsts.bny";
/*     */     try
/*     */     {
/* 153 */       File file = new File(path);
/* 154 */       if (file.exists())
/*     */       {
/* 156 */         byte[] bytes = new byte['Ѐ'];
/* 157 */         FileInputStream fis = new FileInputStream(file);
/* 158 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 159 */         int len = 0;
/* 160 */         while ((len = fis.read(bytes)) > 0)
/* 161 */           baos.write(bytes, 0, len);
/* 162 */         fis.close();
/* 163 */         bytes = baos.toByteArray();
/* 164 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 165 */         this.XIULIAN_LEARN_NEED_SILVER = _os_.unmarshal_int();
/* 166 */         this.XIULIAN_LEARN_ADD_EXP = _os_.unmarshal_int();
/* 167 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 168 */         this.SKILL_BAG_ORGINAL_LEVEL = _os_.unmarshal_int();
/* 169 */         this.SKILL_BAG_MAX_LEVEL = _os_.unmarshal_int();
/* 170 */         this.DEFAULT_XIULIAN_SKILL_CFG_ID = _os_.unmarshal_int();
/* 171 */         this.STUDY_HUNDRED_OPEN_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(XiuLianSkillConsts newInstance)
/*     */   {
/* 182 */     oldInstance = instance;
/* 183 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 188 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\XiuLianSkillConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */