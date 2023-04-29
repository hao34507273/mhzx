/*     */ package mzm.gsp.fabao.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SFabaoConstants
/*     */ {
/*  13 */   private static volatile SFabaoConstants oldInstance = null;
/*     */   
/*  15 */   private static SFabaoConstants instance = new SFabaoConstants();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SFabaoConstants getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SFabaoConstants getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int FABAO_OPEN_LEVEL = 60;
/*  32 */   public int FABAO_MAX_HOLE = 5;
/*  33 */   public int FABAO_MAX = 6;
/*     */   public int MAX_LONG_JING_TRANSFER_COUNT;
/*     */   public int LONG_JING_TRANSFER_NPC;
/*     */   public int LONG_JING_TRANSFER_NPC_SERVICE;
/*     */   public int BASE_PRICE_ITEM_LEVEL;
/*     */   public int MIN_LEVEL_FOR_TRANSFER;
/*  39 */   public java.util.HashSet<Integer> specialTypes = new java.util.HashSet();
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  43 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  48 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoConstants.xml";
/*     */     try
/*     */     {
/*  51 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  52 */       org.dom4j.Document doc = reader.read(new File(path));
/*  53 */       Element root = doc.getRootElement();
/*  54 */       Map<String, Element> data = new java.util.HashMap();
/*  55 */       List<?> nodeList = root.elements();
/*  56 */       int len = nodeList.size();
/*  57 */       for (int i = 0; i < len; i++)
/*     */       {
/*  59 */         Element element = (Element)nodeList.get(i);
/*  60 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  63 */           String name = element.attributeValue("name");
/*  64 */           if (data.put(name, element) != null)
/*  65 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  68 */       this.FABAO_OPEN_LEVEL = Integer.valueOf(((Element)data.get("FABAO_OPEN_LEVEL")).attributeValue("value")).intValue();
/*  69 */       this.FABAO_MAX_HOLE = Integer.valueOf(((Element)data.get("FABAO_MAX_HOLE")).attributeValue("value")).intValue();
/*  70 */       this.FABAO_MAX = Integer.valueOf(((Element)data.get("FABAO_MAX")).attributeValue("value")).intValue();
/*  71 */       this.MAX_LONG_JING_TRANSFER_COUNT = Integer.valueOf(((Element)data.get("MAX_LONG_JING_TRANSFER_COUNT")).attributeValue("value")).intValue();
/*  72 */       this.LONG_JING_TRANSFER_NPC = Integer.valueOf(((Element)data.get("LONG_JING_TRANSFER_NPC")).attributeValue("value")).intValue();
/*  73 */       this.LONG_JING_TRANSFER_NPC_SERVICE = Integer.valueOf(((Element)data.get("LONG_JING_TRANSFER_NPC_SERVICE")).attributeValue("value")).intValue();
/*  74 */       this.BASE_PRICE_ITEM_LEVEL = Integer.valueOf(((Element)data.get("BASE_PRICE_ITEM_LEVEL")).attributeValue("value")).intValue();
/*  75 */       this.MIN_LEVEL_FOR_TRANSFER = Integer.valueOf(((Element)data.get("MIN_LEVEL_FOR_TRANSFER")).attributeValue("value")).intValue();
/*     */       
/*  77 */       Element collectionElement = (Element)data.get("specialTypes");
/*  78 */       if (collectionElement == null)
/*     */       {
/*  80 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/*  83 */       List<?> _nodeList = collectionElement.elements();
/*  84 */       int _len = _nodeList.size();
/*  85 */       for (int i = 0; i < _len; i++)
/*     */       {
/*  87 */         Element elem = (Element)_nodeList.get(i);
/*  88 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/*  95 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 102 */           this.specialTypes.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 113 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoConstants.xml";
/*     */     try
/*     */     {
/* 116 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 117 */       org.dom4j.Document doc = reader.read(new File(path));
/* 118 */       Element root = doc.getRootElement();
/* 119 */       Map<String, Element> data = new java.util.HashMap();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element element = (Element)nodeList.get(i);
/* 125 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 128 */           String name = element.attributeValue("name");
/* 129 */           if (data.put(name, element) != null)
/* 130 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 133 */       this.FABAO_OPEN_LEVEL = Integer.valueOf(((Element)data.get("FABAO_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 134 */       this.FABAO_MAX_HOLE = Integer.valueOf(((Element)data.get("FABAO_MAX_HOLE")).attributeValue("value")).intValue();
/* 135 */       this.FABAO_MAX = Integer.valueOf(((Element)data.get("FABAO_MAX")).attributeValue("value")).intValue();
/* 136 */       this.MAX_LONG_JING_TRANSFER_COUNT = Integer.valueOf(((Element)data.get("MAX_LONG_JING_TRANSFER_COUNT")).attributeValue("value")).intValue();
/* 137 */       this.LONG_JING_TRANSFER_NPC = Integer.valueOf(((Element)data.get("LONG_JING_TRANSFER_NPC")).attributeValue("value")).intValue();
/* 138 */       this.LONG_JING_TRANSFER_NPC_SERVICE = Integer.valueOf(((Element)data.get("LONG_JING_TRANSFER_NPC_SERVICE")).attributeValue("value")).intValue();
/* 139 */       this.BASE_PRICE_ITEM_LEVEL = Integer.valueOf(((Element)data.get("BASE_PRICE_ITEM_LEVEL")).attributeValue("value")).intValue();
/* 140 */       this.MIN_LEVEL_FOR_TRANSFER = Integer.valueOf(((Element)data.get("MIN_LEVEL_FOR_TRANSFER")).attributeValue("value")).intValue();
/*     */       
/* 142 */       Element collectionElement = (Element)data.get("specialTypes");
/* 143 */       if (collectionElement == null)
/*     */       {
/* 145 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 148 */       List<?> _nodeList = collectionElement.elements();
/* 149 */       int _len = _nodeList.size();
/* 150 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 152 */         Element elem = (Element)_nodeList.get(i);
/* 153 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 160 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 167 */           this.specialTypes.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 173 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 177 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 180 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoConstants.bny";
/*     */     try
/*     */     {
/* 183 */       File file = new File(path);
/* 184 */       if (file.exists())
/*     */       {
/* 186 */         byte[] bytes = new byte['Ѐ'];
/* 187 */         FileInputStream fis = new FileInputStream(file);
/* 188 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 189 */         int len = 0;
/* 190 */         while ((len = fis.read(bytes)) > 0)
/* 191 */           baos.write(bytes, 0, len);
/* 192 */         fis.close();
/* 193 */         bytes = baos.toByteArray();
/* 194 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 195 */         this.FABAO_OPEN_LEVEL = _os_.unmarshal_int();
/* 196 */         this.FABAO_MAX_HOLE = _os_.unmarshal_int();
/* 197 */         this.FABAO_MAX = _os_.unmarshal_int();
/* 198 */         this.MAX_LONG_JING_TRANSFER_COUNT = _os_.unmarshal_int();
/* 199 */         this.LONG_JING_TRANSFER_NPC = _os_.unmarshal_int();
/* 200 */         this.LONG_JING_TRANSFER_NPC_SERVICE = _os_.unmarshal_int();
/* 201 */         this.BASE_PRICE_ITEM_LEVEL = _os_.unmarshal_int();
/* 202 */         this.MIN_LEVEL_FOR_TRANSFER = _os_.unmarshal_int();
/* 203 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 206 */           int _v_ = _os_.unmarshal_int();
/* 207 */           this.specialTypes.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 219 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoConstants.bny";
/*     */     try
/*     */     {
/* 222 */       File file = new File(path);
/* 223 */       if (file.exists())
/*     */       {
/* 225 */         byte[] bytes = new byte['Ѐ'];
/* 226 */         FileInputStream fis = new FileInputStream(file);
/* 227 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 228 */         int len = 0;
/* 229 */         while ((len = fis.read(bytes)) > 0)
/* 230 */           baos.write(bytes, 0, len);
/* 231 */         fis.close();
/* 232 */         bytes = baos.toByteArray();
/* 233 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 234 */         this.FABAO_OPEN_LEVEL = _os_.unmarshal_int();
/* 235 */         this.FABAO_MAX_HOLE = _os_.unmarshal_int();
/* 236 */         this.FABAO_MAX = _os_.unmarshal_int();
/* 237 */         this.MAX_LONG_JING_TRANSFER_COUNT = _os_.unmarshal_int();
/* 238 */         this.LONG_JING_TRANSFER_NPC = _os_.unmarshal_int();
/* 239 */         this.LONG_JING_TRANSFER_NPC_SERVICE = _os_.unmarshal_int();
/* 240 */         this.BASE_PRICE_ITEM_LEVEL = _os_.unmarshal_int();
/* 241 */         this.MIN_LEVEL_FOR_TRANSFER = _os_.unmarshal_int();
/* 242 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 245 */           int _v_ = _os_.unmarshal_int();
/* 246 */           this.specialTypes.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 252 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SFabaoConstants newInstance)
/*     */   {
/* 258 */     oldInstance = instance;
/* 259 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 264 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\confbean\SFabaoConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */