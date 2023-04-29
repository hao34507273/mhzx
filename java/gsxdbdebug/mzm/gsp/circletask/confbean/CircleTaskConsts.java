/*     */ package mzm.gsp.circletask.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class CircleTaskConsts
/*     */ {
/*  13 */   private static volatile CircleTaskConsts oldInstance = null;
/*     */   
/*  15 */   private static CircleTaskConsts instance = new CircleTaskConsts();
/*     */   public int TASK_GRAPHIC_ID;
/*     */   public int TASK_ACTIVITY_ID;
/*     */   public int START_TASK_NEED_SILVER;
/*     */   public int CALL_GANG_HELP_COOLDOWN_SECOND;
/*     */   public int LEGEND_TASK_MINUTE;
/*     */   public int AWARD_TYPE_ID;
/*     */   
/*  23 */   public static CircleTaskConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static CircleTaskConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int ACCEPT_NPC_ID;
/*     */   
/*     */   public int AWARD_VIGOR_ID;
/*     */   
/*     */   public int AWARD_VIGOR_WEEK_COUNT;
/*     */   
/*     */   public int LEGEND_DROP_PROP;
/*     */   
/*     */   public int AWARD_XIAYIZHI;
/*     */   
/*     */   public int AWARD_BANGGONG;
/*     */   
/*     */   public int AWARD_BANGGONG_MAX;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  47 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  52 */     String path = dir + "mzm.gsp.circletask.confbean.CircleTaskConsts.xml";
/*     */     try
/*     */     {
/*  55 */       SAXReader reader = new SAXReader();
/*  56 */       org.dom4j.Document doc = reader.read(new File(path));
/*  57 */       Element root = doc.getRootElement();
/*  58 */       Map<String, Element> data = new java.util.HashMap();
/*  59 */       java.util.List<?> nodeList = root.elements();
/*  60 */       int len = nodeList.size();
/*  61 */       for (int i = 0; i < len; i++)
/*     */       {
/*  63 */         Element element = (Element)nodeList.get(i);
/*  64 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  67 */           String name = element.attributeValue("name");
/*  68 */           if (data.put(name, element) != null)
/*  69 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  72 */       this.TASK_GRAPHIC_ID = Integer.valueOf(((Element)data.get("TASK_GRAPHIC_ID")).attributeValue("value")).intValue();
/*  73 */       this.TASK_ACTIVITY_ID = Integer.valueOf(((Element)data.get("TASK_ACTIVITY_ID")).attributeValue("value")).intValue();
/*  74 */       this.START_TASK_NEED_SILVER = Integer.valueOf(((Element)data.get("START_TASK_NEED_SILVER")).attributeValue("value")).intValue();
/*  75 */       this.CALL_GANG_HELP_COOLDOWN_SECOND = Integer.valueOf(((Element)data.get("CALL_GANG_HELP_COOLDOWN_SECOND")).attributeValue("value")).intValue();
/*  76 */       this.LEGEND_TASK_MINUTE = Integer.valueOf(((Element)data.get("LEGEND_TASK_MINUTE")).attributeValue("value")).intValue();
/*  77 */       this.AWARD_TYPE_ID = Integer.valueOf(((Element)data.get("AWARD_TYPE_ID")).attributeValue("value")).intValue();
/*  78 */       this.ACCEPT_NPC_ID = Integer.valueOf(((Element)data.get("ACCEPT_NPC_ID")).attributeValue("value")).intValue();
/*  79 */       this.AWARD_VIGOR_ID = Integer.valueOf(((Element)data.get("AWARD_VIGOR_ID")).attributeValue("value")).intValue();
/*  80 */       this.AWARD_VIGOR_WEEK_COUNT = Integer.valueOf(((Element)data.get("AWARD_VIGOR_WEEK_COUNT")).attributeValue("value")).intValue();
/*  81 */       this.LEGEND_DROP_PROP = Integer.valueOf(((Element)data.get("LEGEND_DROP_PROP")).attributeValue("value")).intValue();
/*  82 */       this.AWARD_XIAYIZHI = Integer.valueOf(((Element)data.get("AWARD_XIAYIZHI")).attributeValue("value")).intValue();
/*  83 */       this.AWARD_BANGGONG = Integer.valueOf(((Element)data.get("AWARD_BANGGONG")).attributeValue("value")).intValue();
/*  84 */       this.AWARD_BANGGONG_MAX = Integer.valueOf(((Element)data.get("AWARD_BANGGONG_MAX")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  88 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  93 */     String path = dir + "mzm.gsp.circletask.confbean.CircleTaskConsts.xml";
/*     */     try
/*     */     {
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       Map<String, Element> data = new java.util.HashMap();
/* 100 */       java.util.List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element element = (Element)nodeList.get(i);
/* 105 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 108 */           String name = element.attributeValue("name");
/* 109 */           if (data.put(name, element) != null)
/* 110 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 113 */       this.TASK_GRAPHIC_ID = Integer.valueOf(((Element)data.get("TASK_GRAPHIC_ID")).attributeValue("value")).intValue();
/* 114 */       this.TASK_ACTIVITY_ID = Integer.valueOf(((Element)data.get("TASK_ACTIVITY_ID")).attributeValue("value")).intValue();
/* 115 */       this.START_TASK_NEED_SILVER = Integer.valueOf(((Element)data.get("START_TASK_NEED_SILVER")).attributeValue("value")).intValue();
/* 116 */       this.CALL_GANG_HELP_COOLDOWN_SECOND = Integer.valueOf(((Element)data.get("CALL_GANG_HELP_COOLDOWN_SECOND")).attributeValue("value")).intValue();
/* 117 */       this.LEGEND_TASK_MINUTE = Integer.valueOf(((Element)data.get("LEGEND_TASK_MINUTE")).attributeValue("value")).intValue();
/* 118 */       this.AWARD_TYPE_ID = Integer.valueOf(((Element)data.get("AWARD_TYPE_ID")).attributeValue("value")).intValue();
/* 119 */       this.ACCEPT_NPC_ID = Integer.valueOf(((Element)data.get("ACCEPT_NPC_ID")).attributeValue("value")).intValue();
/* 120 */       this.AWARD_VIGOR_ID = Integer.valueOf(((Element)data.get("AWARD_VIGOR_ID")).attributeValue("value")).intValue();
/* 121 */       this.AWARD_VIGOR_WEEK_COUNT = Integer.valueOf(((Element)data.get("AWARD_VIGOR_WEEK_COUNT")).attributeValue("value")).intValue();
/* 122 */       this.LEGEND_DROP_PROP = Integer.valueOf(((Element)data.get("LEGEND_DROP_PROP")).attributeValue("value")).intValue();
/* 123 */       this.AWARD_XIAYIZHI = Integer.valueOf(((Element)data.get("AWARD_XIAYIZHI")).attributeValue("value")).intValue();
/* 124 */       this.AWARD_BANGGONG = Integer.valueOf(((Element)data.get("AWARD_BANGGONG")).attributeValue("value")).intValue();
/* 125 */       this.AWARD_BANGGONG_MAX = Integer.valueOf(((Element)data.get("AWARD_BANGGONG_MAX")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 129 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 133 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 136 */     String path = dir + "mzm.gsp.circletask.confbean.CircleTaskConsts.bny";
/*     */     try
/*     */     {
/* 139 */       File file = new File(path);
/* 140 */       if (file.exists())
/*     */       {
/* 142 */         byte[] bytes = new byte['Ѐ'];
/* 143 */         FileInputStream fis = new FileInputStream(file);
/* 144 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 145 */         int len = 0;
/* 146 */         while ((len = fis.read(bytes)) > 0)
/* 147 */           baos.write(bytes, 0, len);
/* 148 */         fis.close();
/* 149 */         bytes = baos.toByteArray();
/* 150 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 151 */         this.TASK_GRAPHIC_ID = _os_.unmarshal_int();
/* 152 */         this.TASK_ACTIVITY_ID = _os_.unmarshal_int();
/* 153 */         this.START_TASK_NEED_SILVER = _os_.unmarshal_int();
/* 154 */         this.CALL_GANG_HELP_COOLDOWN_SECOND = _os_.unmarshal_int();
/* 155 */         this.LEGEND_TASK_MINUTE = _os_.unmarshal_int();
/* 156 */         this.AWARD_TYPE_ID = _os_.unmarshal_int();
/* 157 */         this.ACCEPT_NPC_ID = _os_.unmarshal_int();
/* 158 */         this.AWARD_VIGOR_ID = _os_.unmarshal_int();
/* 159 */         this.AWARD_VIGOR_WEEK_COUNT = _os_.unmarshal_int();
/* 160 */         this.LEGEND_DROP_PROP = _os_.unmarshal_int();
/* 161 */         this.AWARD_XIAYIZHI = _os_.unmarshal_int();
/* 162 */         this.AWARD_BANGGONG = _os_.unmarshal_int();
/* 163 */         this.AWARD_BANGGONG_MAX = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 174 */     String path = dir + "mzm.gsp.circletask.confbean.CircleTaskConsts.bny";
/*     */     try
/*     */     {
/* 177 */       File file = new File(path);
/* 178 */       if (file.exists())
/*     */       {
/* 180 */         byte[] bytes = new byte['Ѐ'];
/* 181 */         FileInputStream fis = new FileInputStream(file);
/* 182 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 183 */         int len = 0;
/* 184 */         while ((len = fis.read(bytes)) > 0)
/* 185 */           baos.write(bytes, 0, len);
/* 186 */         fis.close();
/* 187 */         bytes = baos.toByteArray();
/* 188 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 189 */         this.TASK_GRAPHIC_ID = _os_.unmarshal_int();
/* 190 */         this.TASK_ACTIVITY_ID = _os_.unmarshal_int();
/* 191 */         this.START_TASK_NEED_SILVER = _os_.unmarshal_int();
/* 192 */         this.CALL_GANG_HELP_COOLDOWN_SECOND = _os_.unmarshal_int();
/* 193 */         this.LEGEND_TASK_MINUTE = _os_.unmarshal_int();
/* 194 */         this.AWARD_TYPE_ID = _os_.unmarshal_int();
/* 195 */         this.ACCEPT_NPC_ID = _os_.unmarshal_int();
/* 196 */         this.AWARD_VIGOR_ID = _os_.unmarshal_int();
/* 197 */         this.AWARD_VIGOR_WEEK_COUNT = _os_.unmarshal_int();
/* 198 */         this.LEGEND_DROP_PROP = _os_.unmarshal_int();
/* 199 */         this.AWARD_XIAYIZHI = _os_.unmarshal_int();
/* 200 */         this.AWARD_BANGGONG = _os_.unmarshal_int();
/* 201 */         this.AWARD_BANGGONG_MAX = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(CircleTaskConsts newInstance)
/*     */   {
/* 212 */     oldInstance = instance;
/* 213 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 218 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\confbean\CircleTaskConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */