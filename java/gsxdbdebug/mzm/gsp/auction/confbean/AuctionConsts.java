/*     */ package mzm.gsp.auction.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class AuctionConsts
/*     */ {
/*  13 */   private static volatile AuctionConsts oldInstance = null;
/*     */   
/*  15 */   private static AuctionConsts instance = new AuctionConsts();
/*     */   public int AUCTION_PRE_TIP_ID;
/*     */   public int AUCTION_FUN_TIP_ID;
/*     */   public int WIN_BID_MAIL_ID;
/*     */   public int LOSE_BID_MAIL_ID;
/*     */   
/*     */   public static AuctionConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static AuctionConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int SWITCH_CLOSE_REFUND_MAIL_ID;
/*     */   
/*     */   public int SERVER_CLOSE_REFUND_MAIL_ID;
/*     */   
/*     */   public int SERVER_MERGE_REFUND_MAIL_ID;
/*     */   
/*     */   public int BID_BEGIN_PANEL_CFG_ID;
/*     */   
/*     */   public int BID_PRICE_MAX;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  43 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  48 */     String path = dir + "mzm.gsp.auction.confbean.AuctionConsts.xml";
/*     */     try
/*     */     {
/*  51 */       SAXReader reader = new SAXReader();
/*  52 */       org.dom4j.Document doc = reader.read(new File(path));
/*  53 */       Element root = doc.getRootElement();
/*  54 */       Map<String, Element> data = new java.util.HashMap();
/*  55 */       java.util.List<?> nodeList = root.elements();
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
/*  68 */       this.AUCTION_PRE_TIP_ID = Integer.valueOf(((Element)data.get("AUCTION_PRE_TIP_ID")).attributeValue("value")).intValue();
/*  69 */       this.AUCTION_FUN_TIP_ID = Integer.valueOf(((Element)data.get("AUCTION_FUN_TIP_ID")).attributeValue("value")).intValue();
/*  70 */       this.WIN_BID_MAIL_ID = Integer.valueOf(((Element)data.get("WIN_BID_MAIL_ID")).attributeValue("value")).intValue();
/*  71 */       this.LOSE_BID_MAIL_ID = Integer.valueOf(((Element)data.get("LOSE_BID_MAIL_ID")).attributeValue("value")).intValue();
/*  72 */       this.SWITCH_CLOSE_REFUND_MAIL_ID = Integer.valueOf(((Element)data.get("SWITCH_CLOSE_REFUND_MAIL_ID")).attributeValue("value")).intValue();
/*  73 */       this.SERVER_CLOSE_REFUND_MAIL_ID = Integer.valueOf(((Element)data.get("SERVER_CLOSE_REFUND_MAIL_ID")).attributeValue("value")).intValue();
/*  74 */       this.SERVER_MERGE_REFUND_MAIL_ID = Integer.valueOf(((Element)data.get("SERVER_MERGE_REFUND_MAIL_ID")).attributeValue("value")).intValue();
/*  75 */       this.BID_BEGIN_PANEL_CFG_ID = Integer.valueOf(((Element)data.get("BID_BEGIN_PANEL_CFG_ID")).attributeValue("value")).intValue();
/*  76 */       this.BID_PRICE_MAX = Integer.valueOf(((Element)data.get("BID_PRICE_MAX")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  85 */     String path = dir + "mzm.gsp.auction.confbean.AuctionConsts.xml";
/*     */     try
/*     */     {
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       Map<String, Element> data = new java.util.HashMap();
/*  92 */       java.util.List<?> nodeList = root.elements();
/*  93 */       int len = nodeList.size();
/*  94 */       for (int i = 0; i < len; i++)
/*     */       {
/*  96 */         Element element = (Element)nodeList.get(i);
/*  97 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 100 */           String name = element.attributeValue("name");
/* 101 */           if (data.put(name, element) != null)
/* 102 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 105 */       this.AUCTION_PRE_TIP_ID = Integer.valueOf(((Element)data.get("AUCTION_PRE_TIP_ID")).attributeValue("value")).intValue();
/* 106 */       this.AUCTION_FUN_TIP_ID = Integer.valueOf(((Element)data.get("AUCTION_FUN_TIP_ID")).attributeValue("value")).intValue();
/* 107 */       this.WIN_BID_MAIL_ID = Integer.valueOf(((Element)data.get("WIN_BID_MAIL_ID")).attributeValue("value")).intValue();
/* 108 */       this.LOSE_BID_MAIL_ID = Integer.valueOf(((Element)data.get("LOSE_BID_MAIL_ID")).attributeValue("value")).intValue();
/* 109 */       this.SWITCH_CLOSE_REFUND_MAIL_ID = Integer.valueOf(((Element)data.get("SWITCH_CLOSE_REFUND_MAIL_ID")).attributeValue("value")).intValue();
/* 110 */       this.SERVER_CLOSE_REFUND_MAIL_ID = Integer.valueOf(((Element)data.get("SERVER_CLOSE_REFUND_MAIL_ID")).attributeValue("value")).intValue();
/* 111 */       this.SERVER_MERGE_REFUND_MAIL_ID = Integer.valueOf(((Element)data.get("SERVER_MERGE_REFUND_MAIL_ID")).attributeValue("value")).intValue();
/* 112 */       this.BID_BEGIN_PANEL_CFG_ID = Integer.valueOf(((Element)data.get("BID_BEGIN_PANEL_CFG_ID")).attributeValue("value")).intValue();
/* 113 */       this.BID_PRICE_MAX = Integer.valueOf(((Element)data.get("BID_PRICE_MAX")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 117 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 121 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 124 */     String path = dir + "mzm.gsp.auction.confbean.AuctionConsts.bny";
/*     */     try
/*     */     {
/* 127 */       File file = new File(path);
/* 128 */       if (file.exists())
/*     */       {
/* 130 */         byte[] bytes = new byte['Ѐ'];
/* 131 */         FileInputStream fis = new FileInputStream(file);
/* 132 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 133 */         int len = 0;
/* 134 */         while ((len = fis.read(bytes)) > 0)
/* 135 */           baos.write(bytes, 0, len);
/* 136 */         fis.close();
/* 137 */         bytes = baos.toByteArray();
/* 138 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 139 */         this.AUCTION_PRE_TIP_ID = _os_.unmarshal_int();
/* 140 */         this.AUCTION_FUN_TIP_ID = _os_.unmarshal_int();
/* 141 */         this.WIN_BID_MAIL_ID = _os_.unmarshal_int();
/* 142 */         this.LOSE_BID_MAIL_ID = _os_.unmarshal_int();
/* 143 */         this.SWITCH_CLOSE_REFUND_MAIL_ID = _os_.unmarshal_int();
/* 144 */         this.SERVER_CLOSE_REFUND_MAIL_ID = _os_.unmarshal_int();
/* 145 */         this.SERVER_MERGE_REFUND_MAIL_ID = _os_.unmarshal_int();
/* 146 */         this.BID_BEGIN_PANEL_CFG_ID = _os_.unmarshal_int();
/* 147 */         this.BID_PRICE_MAX = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 158 */     String path = dir + "mzm.gsp.auction.confbean.AuctionConsts.bny";
/*     */     try
/*     */     {
/* 161 */       File file = new File(path);
/* 162 */       if (file.exists())
/*     */       {
/* 164 */         byte[] bytes = new byte['Ѐ'];
/* 165 */         FileInputStream fis = new FileInputStream(file);
/* 166 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 167 */         int len = 0;
/* 168 */         while ((len = fis.read(bytes)) > 0)
/* 169 */           baos.write(bytes, 0, len);
/* 170 */         fis.close();
/* 171 */         bytes = baos.toByteArray();
/* 172 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 173 */         this.AUCTION_PRE_TIP_ID = _os_.unmarshal_int();
/* 174 */         this.AUCTION_FUN_TIP_ID = _os_.unmarshal_int();
/* 175 */         this.WIN_BID_MAIL_ID = _os_.unmarshal_int();
/* 176 */         this.LOSE_BID_MAIL_ID = _os_.unmarshal_int();
/* 177 */         this.SWITCH_CLOSE_REFUND_MAIL_ID = _os_.unmarshal_int();
/* 178 */         this.SERVER_CLOSE_REFUND_MAIL_ID = _os_.unmarshal_int();
/* 179 */         this.SERVER_MERGE_REFUND_MAIL_ID = _os_.unmarshal_int();
/* 180 */         this.BID_BEGIN_PANEL_CFG_ID = _os_.unmarshal_int();
/* 181 */         this.BID_PRICE_MAX = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(AuctionConsts newInstance)
/*     */   {
/* 192 */     oldInstance = instance;
/* 193 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 198 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\confbean\AuctionConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */