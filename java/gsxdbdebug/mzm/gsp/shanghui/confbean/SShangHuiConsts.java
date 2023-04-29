/*     */ package mzm.gsp.shanghui.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SShangHuiConsts
/*     */ {
/*  13 */   private static volatile SShangHuiConsts oldInstance = null;
/*     */   
/*  15 */   private static SShangHuiConsts instance = new SShangHuiConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SShangHuiConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SShangHuiConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public double OPEN_LEVEL = 20.0D;
/*  32 */   public double PRICE_DAY_MAX_FLOW_LIMIT = 1000.0D;
/*  33 */   public double PRICE_DAY_MIN_FLOW_LIMIT = -1000.0D;
/*  34 */   public double RISE_FALL_BACK_RATE = 5000.0D;
/*  35 */   public double FALL_RISE_BACK_RATE = 5000.0D;
/*  36 */   public double STOP_RISE_BUY_RATE = 1.0D;
/*  37 */   public double STOP_FALL_SELL_RATE = 0.0D;
/*  38 */   public double SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE = 5000.0D;
/*  39 */   public double NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE = 5000.0D;
/*  40 */   public double ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE = 8000.0D;
/*  41 */   public double ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE = 9000.0D;
/*  42 */   public double EXCHANGE_ONE_PRICE_CHANGE_RATE = 10.0D;
/*  43 */   public double SHOW_CHANGE_NEED_EXCHANGE_ITEM_NUM = 10.0D;
/*  44 */   public double SHANGHUI_PRICE_UDPATE_OBSERVER_ID = 3.50200033E8D;
/*  45 */   public int SHANGHUI_PAGE_NUM = 4;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  54 */     String path = dir + "mzm.gsp.shanghui.confbean.SShangHuiConsts.xml";
/*     */     try
/*     */     {
/*  57 */       SAXReader reader = new SAXReader();
/*  58 */       org.dom4j.Document doc = reader.read(new File(path));
/*  59 */       Element root = doc.getRootElement();
/*  60 */       Map<String, Element> data = new java.util.HashMap();
/*  61 */       java.util.List<?> nodeList = root.elements();
/*  62 */       int len = nodeList.size();
/*  63 */       for (int i = 0; i < len; i++)
/*     */       {
/*  65 */         Element element = (Element)nodeList.get(i);
/*  66 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  69 */           String name = element.attributeValue("name");
/*  70 */           if (data.put(name, element) != null)
/*  71 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  74 */       this.OPEN_LEVEL = Double.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).doubleValue();
/*  75 */       this.PRICE_DAY_MAX_FLOW_LIMIT = Double.valueOf(((Element)data.get("PRICE_DAY_MAX_FLOW_LIMIT")).attributeValue("value")).doubleValue();
/*  76 */       this.PRICE_DAY_MIN_FLOW_LIMIT = Double.valueOf(((Element)data.get("PRICE_DAY_MIN_FLOW_LIMIT")).attributeValue("value")).doubleValue();
/*  77 */       this.RISE_FALL_BACK_RATE = Double.valueOf(((Element)data.get("RISE_FALL_BACK_RATE")).attributeValue("value")).doubleValue();
/*  78 */       this.FALL_RISE_BACK_RATE = Double.valueOf(((Element)data.get("FALL_RISE_BACK_RATE")).attributeValue("value")).doubleValue();
/*  79 */       this.STOP_RISE_BUY_RATE = Double.valueOf(((Element)data.get("STOP_RISE_BUY_RATE")).attributeValue("value")).doubleValue();
/*  80 */       this.STOP_FALL_SELL_RATE = Double.valueOf(((Element)data.get("STOP_FALL_SELL_RATE")).attributeValue("value")).doubleValue();
/*  81 */       this.SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE = Double.valueOf(((Element)data.get("SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE")).attributeValue("value")).doubleValue();
/*  82 */       this.NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE = Double.valueOf(((Element)data.get("NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE")).attributeValue("value")).doubleValue();
/*  83 */       this.ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE = Double.valueOf(((Element)data.get("ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE")).attributeValue("value")).doubleValue();
/*  84 */       this.ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE = Double.valueOf(((Element)data.get("ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE")).attributeValue("value")).doubleValue();
/*  85 */       this.EXCHANGE_ONE_PRICE_CHANGE_RATE = Double.valueOf(((Element)data.get("EXCHANGE_ONE_PRICE_CHANGE_RATE")).attributeValue("value")).doubleValue();
/*  86 */       this.SHOW_CHANGE_NEED_EXCHANGE_ITEM_NUM = Double.valueOf(((Element)data.get("SHOW_CHANGE_NEED_EXCHANGE_ITEM_NUM")).attributeValue("value")).doubleValue();
/*  87 */       this.SHANGHUI_PRICE_UDPATE_OBSERVER_ID = Double.valueOf(((Element)data.get("SHANGHUI_PRICE_UDPATE_OBSERVER_ID")).attributeValue("value")).doubleValue();
/*  88 */       this.SHANGHUI_PAGE_NUM = Integer.valueOf(((Element)data.get("SHANGHUI_PAGE_NUM")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  92 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  97 */     String path = dir + "mzm.gsp.shanghui.confbean.SShangHuiConsts.xml";
/*     */     try
/*     */     {
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       Map<String, Element> data = new java.util.HashMap();
/* 104 */       java.util.List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element element = (Element)nodeList.get(i);
/* 109 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 112 */           String name = element.attributeValue("name");
/* 113 */           if (data.put(name, element) != null)
/* 114 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 117 */       this.OPEN_LEVEL = Double.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).doubleValue();
/* 118 */       this.PRICE_DAY_MAX_FLOW_LIMIT = Double.valueOf(((Element)data.get("PRICE_DAY_MAX_FLOW_LIMIT")).attributeValue("value")).doubleValue();
/* 119 */       this.PRICE_DAY_MIN_FLOW_LIMIT = Double.valueOf(((Element)data.get("PRICE_DAY_MIN_FLOW_LIMIT")).attributeValue("value")).doubleValue();
/* 120 */       this.RISE_FALL_BACK_RATE = Double.valueOf(((Element)data.get("RISE_FALL_BACK_RATE")).attributeValue("value")).doubleValue();
/* 121 */       this.FALL_RISE_BACK_RATE = Double.valueOf(((Element)data.get("FALL_RISE_BACK_RATE")).attributeValue("value")).doubleValue();
/* 122 */       this.STOP_RISE_BUY_RATE = Double.valueOf(((Element)data.get("STOP_RISE_BUY_RATE")).attributeValue("value")).doubleValue();
/* 123 */       this.STOP_FALL_SELL_RATE = Double.valueOf(((Element)data.get("STOP_FALL_SELL_RATE")).attributeValue("value")).doubleValue();
/* 124 */       this.SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE = Double.valueOf(((Element)data.get("SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE")).attributeValue("value")).doubleValue();
/* 125 */       this.NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE = Double.valueOf(((Element)data.get("NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE")).attributeValue("value")).doubleValue();
/* 126 */       this.ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE = Double.valueOf(((Element)data.get("ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE")).attributeValue("value")).doubleValue();
/* 127 */       this.ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE = Double.valueOf(((Element)data.get("ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE")).attributeValue("value")).doubleValue();
/* 128 */       this.EXCHANGE_ONE_PRICE_CHANGE_RATE = Double.valueOf(((Element)data.get("EXCHANGE_ONE_PRICE_CHANGE_RATE")).attributeValue("value")).doubleValue();
/* 129 */       this.SHOW_CHANGE_NEED_EXCHANGE_ITEM_NUM = Double.valueOf(((Element)data.get("SHOW_CHANGE_NEED_EXCHANGE_ITEM_NUM")).attributeValue("value")).doubleValue();
/* 130 */       this.SHANGHUI_PRICE_UDPATE_OBSERVER_ID = Double.valueOf(((Element)data.get("SHANGHUI_PRICE_UDPATE_OBSERVER_ID")).attributeValue("value")).doubleValue();
/* 131 */       this.SHANGHUI_PAGE_NUM = Integer.valueOf(((Element)data.get("SHANGHUI_PAGE_NUM")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 135 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 139 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 142 */     String path = dir + "mzm.gsp.shanghui.confbean.SShangHuiConsts.bny";
/*     */     try
/*     */     {
/* 145 */       File file = new File(path);
/* 146 */       if (file.exists())
/*     */       {
/* 148 */         byte[] bytes = new byte['Ѐ'];
/* 149 */         FileInputStream fis = new FileInputStream(file);
/* 150 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 151 */         int len = 0;
/* 152 */         while ((len = fis.read(bytes)) > 0)
/* 153 */           baos.write(bytes, 0, len);
/* 154 */         fis.close();
/* 155 */         bytes = baos.toByteArray();
/* 156 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 157 */         this.OPEN_LEVEL = _os_.unmarshal_float();
/* 158 */         this.PRICE_DAY_MAX_FLOW_LIMIT = _os_.unmarshal_float();
/* 159 */         this.PRICE_DAY_MIN_FLOW_LIMIT = _os_.unmarshal_float();
/* 160 */         this.RISE_FALL_BACK_RATE = _os_.unmarshal_float();
/* 161 */         this.FALL_RISE_BACK_RATE = _os_.unmarshal_float();
/* 162 */         this.STOP_RISE_BUY_RATE = _os_.unmarshal_float();
/* 163 */         this.STOP_FALL_SELL_RATE = _os_.unmarshal_float();
/* 164 */         this.SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE = _os_.unmarshal_float();
/* 165 */         this.NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE = _os_.unmarshal_float();
/* 166 */         this.ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE = _os_.unmarshal_float();
/* 167 */         this.ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE = _os_.unmarshal_float();
/* 168 */         this.EXCHANGE_ONE_PRICE_CHANGE_RATE = _os_.unmarshal_float();
/* 169 */         this.SHOW_CHANGE_NEED_EXCHANGE_ITEM_NUM = _os_.unmarshal_float();
/* 170 */         this.SHANGHUI_PRICE_UDPATE_OBSERVER_ID = _os_.unmarshal_float();
/* 171 */         this.SHANGHUI_PAGE_NUM = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 182 */     String path = dir + "mzm.gsp.shanghui.confbean.SShangHuiConsts.bny";
/*     */     try
/*     */     {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists())
/*     */       {
/* 188 */         byte[] bytes = new byte['Ѐ'];
/* 189 */         FileInputStream fis = new FileInputStream(file);
/* 190 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 191 */         int len = 0;
/* 192 */         while ((len = fis.read(bytes)) > 0)
/* 193 */           baos.write(bytes, 0, len);
/* 194 */         fis.close();
/* 195 */         bytes = baos.toByteArray();
/* 196 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 197 */         this.OPEN_LEVEL = _os_.unmarshal_float();
/* 198 */         this.PRICE_DAY_MAX_FLOW_LIMIT = _os_.unmarshal_float();
/* 199 */         this.PRICE_DAY_MIN_FLOW_LIMIT = _os_.unmarshal_float();
/* 200 */         this.RISE_FALL_BACK_RATE = _os_.unmarshal_float();
/* 201 */         this.FALL_RISE_BACK_RATE = _os_.unmarshal_float();
/* 202 */         this.STOP_RISE_BUY_RATE = _os_.unmarshal_float();
/* 203 */         this.STOP_FALL_SELL_RATE = _os_.unmarshal_float();
/* 204 */         this.SHOW_ALL_SELLED_MORE_THAN_ORG_PRICE_RATE = _os_.unmarshal_float();
/* 205 */         this.NO_ITEM_SELLED_MORE_THAN_ORG_PRICE_RATE = _os_.unmarshal_float();
/* 206 */         this.ITEM_FROM_SHANGHUI_SELL_BASE_BUY_RATE = _os_.unmarshal_float();
/* 207 */         this.ITEM_NOT_FROM_SHANGHUI_SELL_BASE_MARKET_RATE = _os_.unmarshal_float();
/* 208 */         this.EXCHANGE_ONE_PRICE_CHANGE_RATE = _os_.unmarshal_float();
/* 209 */         this.SHOW_CHANGE_NEED_EXCHANGE_ITEM_NUM = _os_.unmarshal_float();
/* 210 */         this.SHANGHUI_PRICE_UDPATE_OBSERVER_ID = _os_.unmarshal_float();
/* 211 */         this.SHANGHUI_PAGE_NUM = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SShangHuiConsts newInstance)
/*     */   {
/* 222 */     oldInstance = instance;
/* 223 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 228 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\confbean\SShangHuiConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */