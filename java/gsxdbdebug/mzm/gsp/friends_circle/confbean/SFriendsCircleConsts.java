/*     */ package mzm.gsp.friends_circle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SFriendsCircleConsts
/*     */ {
/*  13 */   private static volatile SFriendsCircleConsts oldInstance = null;
/*     */   
/*  15 */   private static SFriendsCircleConsts instance = new SFriendsCircleConsts();
/*     */   
/*     */   public int friends_circle_open_role_level;
/*     */   public int tread_open_role_level;
/*     */   public int give_gift_open_role_level;
/*     */   
/*     */   public static SFriendsCircleConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SFriendsCircleConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int treasure_box_gold_price;
/*     */   
/*     */   public int place_treasure_box_max_num;
/*     */   
/*     */   public int max_treasure_box_num_get_every_day;
/*     */   
/*     */   public int treasure_box_award_fix_id;
/*     */   public int tread_circle_get_treasure_box_probability;
/*     */   public int tread_circle_get_popularity_value;
/*     */   public int max_tread_num_every_circle_every_day;
/*     */   public int popularity_chart_clear_time;
/*     */   public int present_message_character_max_num;
/*     */   public int max_get_popularity_by_tread;
/*     */   public int max_black_role_num_limit;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  48 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.friends_circle.confbean.SFriendsCircleConsts.xml";
/*     */     try
/*     */     {
/*  56 */       SAXReader reader = new SAXReader();
/*  57 */       org.dom4j.Document doc = reader.read(new File(path));
/*  58 */       Element root = doc.getRootElement();
/*  59 */       Map<String, Element> data = new java.util.HashMap();
/*  60 */       java.util.List<?> nodeList = root.elements();
/*  61 */       int len = nodeList.size();
/*  62 */       for (int i = 0; i < len; i++)
/*     */       {
/*  64 */         Element element = (Element)nodeList.get(i);
/*  65 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  68 */           String name = element.attributeValue("name");
/*  69 */           if (data.put(name, element) != null)
/*  70 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  73 */       this.friends_circle_open_role_level = Integer.valueOf(((Element)data.get("friends_circle_open_role_level")).attributeValue("value")).intValue();
/*  74 */       this.tread_open_role_level = Integer.valueOf(((Element)data.get("tread_open_role_level")).attributeValue("value")).intValue();
/*  75 */       this.give_gift_open_role_level = Integer.valueOf(((Element)data.get("give_gift_open_role_level")).attributeValue("value")).intValue();
/*  76 */       this.treasure_box_gold_price = Integer.valueOf(((Element)data.get("treasure_box_gold_price")).attributeValue("value")).intValue();
/*  77 */       this.place_treasure_box_max_num = Integer.valueOf(((Element)data.get("place_treasure_box_max_num")).attributeValue("value")).intValue();
/*  78 */       this.max_treasure_box_num_get_every_day = Integer.valueOf(((Element)data.get("max_treasure_box_num_get_every_day")).attributeValue("value")).intValue();
/*  79 */       this.treasure_box_award_fix_id = Integer.valueOf(((Element)data.get("treasure_box_award_fix_id")).attributeValue("value")).intValue();
/*  80 */       this.tread_circle_get_treasure_box_probability = Integer.valueOf(((Element)data.get("tread_circle_get_treasure_box_probability")).attributeValue("value")).intValue();
/*  81 */       this.tread_circle_get_popularity_value = Integer.valueOf(((Element)data.get("tread_circle_get_popularity_value")).attributeValue("value")).intValue();
/*  82 */       this.max_tread_num_every_circle_every_day = Integer.valueOf(((Element)data.get("max_tread_num_every_circle_every_day")).attributeValue("value")).intValue();
/*  83 */       this.popularity_chart_clear_time = Integer.valueOf(((Element)data.get("popularity_chart_clear_time")).attributeValue("value")).intValue();
/*  84 */       this.present_message_character_max_num = Integer.valueOf(((Element)data.get("present_message_character_max_num")).attributeValue("value")).intValue();
/*  85 */       this.max_get_popularity_by_tread = Integer.valueOf(((Element)data.get("max_get_popularity_by_tread")).attributeValue("value")).intValue();
/*  86 */       this.max_black_role_num_limit = Integer.valueOf(((Element)data.get("max_black_role_num_limit")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  90 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  95 */     String path = dir + "mzm.gsp.friends_circle.confbean.SFriendsCircleConsts.xml";
/*     */     try
/*     */     {
/*  98 */       SAXReader reader = new SAXReader();
/*  99 */       org.dom4j.Document doc = reader.read(new File(path));
/* 100 */       Element root = doc.getRootElement();
/* 101 */       Map<String, Element> data = new java.util.HashMap();
/* 102 */       java.util.List<?> nodeList = root.elements();
/* 103 */       int len = nodeList.size();
/* 104 */       for (int i = 0; i < len; i++)
/*     */       {
/* 106 */         Element element = (Element)nodeList.get(i);
/* 107 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 110 */           String name = element.attributeValue("name");
/* 111 */           if (data.put(name, element) != null)
/* 112 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 115 */       this.friends_circle_open_role_level = Integer.valueOf(((Element)data.get("friends_circle_open_role_level")).attributeValue("value")).intValue();
/* 116 */       this.tread_open_role_level = Integer.valueOf(((Element)data.get("tread_open_role_level")).attributeValue("value")).intValue();
/* 117 */       this.give_gift_open_role_level = Integer.valueOf(((Element)data.get("give_gift_open_role_level")).attributeValue("value")).intValue();
/* 118 */       this.treasure_box_gold_price = Integer.valueOf(((Element)data.get("treasure_box_gold_price")).attributeValue("value")).intValue();
/* 119 */       this.place_treasure_box_max_num = Integer.valueOf(((Element)data.get("place_treasure_box_max_num")).attributeValue("value")).intValue();
/* 120 */       this.max_treasure_box_num_get_every_day = Integer.valueOf(((Element)data.get("max_treasure_box_num_get_every_day")).attributeValue("value")).intValue();
/* 121 */       this.treasure_box_award_fix_id = Integer.valueOf(((Element)data.get("treasure_box_award_fix_id")).attributeValue("value")).intValue();
/* 122 */       this.tread_circle_get_treasure_box_probability = Integer.valueOf(((Element)data.get("tread_circle_get_treasure_box_probability")).attributeValue("value")).intValue();
/* 123 */       this.tread_circle_get_popularity_value = Integer.valueOf(((Element)data.get("tread_circle_get_popularity_value")).attributeValue("value")).intValue();
/* 124 */       this.max_tread_num_every_circle_every_day = Integer.valueOf(((Element)data.get("max_tread_num_every_circle_every_day")).attributeValue("value")).intValue();
/* 125 */       this.popularity_chart_clear_time = Integer.valueOf(((Element)data.get("popularity_chart_clear_time")).attributeValue("value")).intValue();
/* 126 */       this.present_message_character_max_num = Integer.valueOf(((Element)data.get("present_message_character_max_num")).attributeValue("value")).intValue();
/* 127 */       this.max_get_popularity_by_tread = Integer.valueOf(((Element)data.get("max_get_popularity_by_tread")).attributeValue("value")).intValue();
/* 128 */       this.max_black_role_num_limit = Integer.valueOf(((Element)data.get("max_black_role_num_limit")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 136 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 139 */     String path = dir + "mzm.gsp.friends_circle.confbean.SFriendsCircleConsts.bny";
/*     */     try
/*     */     {
/* 142 */       File file = new File(path);
/* 143 */       if (file.exists())
/*     */       {
/* 145 */         byte[] bytes = new byte['Ѐ'];
/* 146 */         FileInputStream fis = new FileInputStream(file);
/* 147 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 148 */         int len = 0;
/* 149 */         while ((len = fis.read(bytes)) > 0)
/* 150 */           baos.write(bytes, 0, len);
/* 151 */         fis.close();
/* 152 */         bytes = baos.toByteArray();
/* 153 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 154 */         this.friends_circle_open_role_level = _os_.unmarshal_int();
/* 155 */         this.tread_open_role_level = _os_.unmarshal_int();
/* 156 */         this.give_gift_open_role_level = _os_.unmarshal_int();
/* 157 */         this.treasure_box_gold_price = _os_.unmarshal_int();
/* 158 */         this.place_treasure_box_max_num = _os_.unmarshal_int();
/* 159 */         this.max_treasure_box_num_get_every_day = _os_.unmarshal_int();
/* 160 */         this.treasure_box_award_fix_id = _os_.unmarshal_int();
/* 161 */         this.tread_circle_get_treasure_box_probability = _os_.unmarshal_int();
/* 162 */         this.tread_circle_get_popularity_value = _os_.unmarshal_int();
/* 163 */         this.max_tread_num_every_circle_every_day = _os_.unmarshal_int();
/* 164 */         this.popularity_chart_clear_time = _os_.unmarshal_int();
/* 165 */         this.present_message_character_max_num = _os_.unmarshal_int();
/* 166 */         this.max_get_popularity_by_tread = _os_.unmarshal_int();
/* 167 */         this.max_black_role_num_limit = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.friends_circle.confbean.SFriendsCircleConsts.bny";
/*     */     try
/*     */     {
/* 181 */       File file = new File(path);
/* 182 */       if (file.exists())
/*     */       {
/* 184 */         byte[] bytes = new byte['Ѐ'];
/* 185 */         FileInputStream fis = new FileInputStream(file);
/* 186 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 187 */         int len = 0;
/* 188 */         while ((len = fis.read(bytes)) > 0)
/* 189 */           baos.write(bytes, 0, len);
/* 190 */         fis.close();
/* 191 */         bytes = baos.toByteArray();
/* 192 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 193 */         this.friends_circle_open_role_level = _os_.unmarshal_int();
/* 194 */         this.tread_open_role_level = _os_.unmarshal_int();
/* 195 */         this.give_gift_open_role_level = _os_.unmarshal_int();
/* 196 */         this.treasure_box_gold_price = _os_.unmarshal_int();
/* 197 */         this.place_treasure_box_max_num = _os_.unmarshal_int();
/* 198 */         this.max_treasure_box_num_get_every_day = _os_.unmarshal_int();
/* 199 */         this.treasure_box_award_fix_id = _os_.unmarshal_int();
/* 200 */         this.tread_circle_get_treasure_box_probability = _os_.unmarshal_int();
/* 201 */         this.tread_circle_get_popularity_value = _os_.unmarshal_int();
/* 202 */         this.max_tread_num_every_circle_every_day = _os_.unmarshal_int();
/* 203 */         this.popularity_chart_clear_time = _os_.unmarshal_int();
/* 204 */         this.present_message_character_max_num = _os_.unmarshal_int();
/* 205 */         this.max_get_popularity_by_tread = _os_.unmarshal_int();
/* 206 */         this.max_black_role_num_limit = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SFriendsCircleConsts newInstance)
/*     */   {
/* 217 */     oldInstance = instance;
/* 218 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 223 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friends_circle\confbean\SFriendsCircleConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */