/*     */ package mzm.gsp.alllotto.confbean;
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
/*     */ public class AllLottoCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, AllLottoCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, AllLottoCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activity_cfg_id;
/*     */   public int tips_id;
/*     */   public int server_level_limit;
/*     */   public int award_mail_cfg_id;
/*  23 */   public java.util.ArrayList<Integer> award_item_cfg_ids = new java.util.ArrayList();
/*     */   public int turn;
/*     */   public int year;
/*     */   public int month;
/*     */   public int day;
/*     */   public int hour;
/*     */   public int minute;
/*     */   public int fix_award_id;
/*     */   public int model_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  37 */     this.tips_id = Integer.valueOf(rootElement.attributeValue("tips_id")).intValue();
/*  38 */     this.server_level_limit = Integer.valueOf(rootElement.attributeValue("server_level_limit")).intValue();
/*  39 */     this.award_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("award_mail_cfg_id")).intValue();
/*     */     
/*  41 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "award_item_cfg_ids");
/*  42 */     if (collectionElement == null)
/*     */     {
/*  44 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  47 */     List<?> _nodeList = collectionElement.elements();
/*  48 */     int _len = _nodeList.size();
/*  49 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  51 */       Element elem = (Element)_nodeList.get(i);
/*  52 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  59 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  66 */         this.award_item_cfg_ids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  69 */     this.turn = Integer.valueOf(rootElement.attributeValue("turn")).intValue();
/*  70 */     this.year = Integer.valueOf(rootElement.attributeValue("year")).intValue();
/*  71 */     this.month = Integer.valueOf(rootElement.attributeValue("month")).intValue();
/*  72 */     this.day = Integer.valueOf(rootElement.attributeValue("day")).intValue();
/*  73 */     this.hour = Integer.valueOf(rootElement.attributeValue("hour")).intValue();
/*  74 */     this.minute = Integer.valueOf(rootElement.attributeValue("minute")).intValue();
/*  75 */     this.fix_award_id = Integer.valueOf(rootElement.attributeValue("fix_award_id")).intValue();
/*  76 */     this.model_id = Integer.valueOf(rootElement.attributeValue("model_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  81 */     _os_.marshal(this.id);
/*  82 */     _os_.marshal(this.activity_cfg_id);
/*  83 */     _os_.marshal(this.tips_id);
/*  84 */     _os_.marshal(this.server_level_limit);
/*  85 */     _os_.marshal(this.award_mail_cfg_id);
/*  86 */     _os_.compact_uint32(this.award_item_cfg_ids.size());
/*  87 */     for (Integer _v_ : this.award_item_cfg_ids)
/*     */     {
/*  89 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  91 */     _os_.marshal(this.turn);
/*  92 */     _os_.marshal(this.year);
/*  93 */     _os_.marshal(this.month);
/*  94 */     _os_.marshal(this.day);
/*  95 */     _os_.marshal(this.hour);
/*  96 */     _os_.marshal(this.minute);
/*  97 */     _os_.marshal(this.fix_award_id);
/*  98 */     _os_.marshal(this.model_id);
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 104 */     this.id = _os_.unmarshal_int();
/* 105 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 106 */     this.tips_id = _os_.unmarshal_int();
/* 107 */     this.server_level_limit = _os_.unmarshal_int();
/* 108 */     this.award_mail_cfg_id = _os_.unmarshal_int();
/* 109 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 112 */       int _v_ = _os_.unmarshal_int();
/* 113 */       this.award_item_cfg_ids.add(Integer.valueOf(_v_));
/*     */     }
/* 115 */     this.turn = _os_.unmarshal_int();
/* 116 */     this.year = _os_.unmarshal_int();
/* 117 */     this.month = _os_.unmarshal_int();
/* 118 */     this.day = _os_.unmarshal_int();
/* 119 */     this.hour = _os_.unmarshal_int();
/* 120 */     this.minute = _os_.unmarshal_int();
/* 121 */     this.fix_award_id = _os_.unmarshal_int();
/* 122 */     this.model_id = _os_.unmarshal_int();
/* 123 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 128 */     String path = dir + "mzm.gsp.alllotto.confbean.AllLottoCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 132 */       all = new java.util.HashMap();
/* 133 */       SAXReader reader = new SAXReader();
/* 134 */       org.dom4j.Document doc = reader.read(new File(path));
/* 135 */       Element root = doc.getRootElement();
/* 136 */       List<?> nodeList = root.elements();
/* 137 */       int len = nodeList.size();
/* 138 */       for (int i = 0; i < len; i++)
/*     */       {
/* 140 */         Element elem = (Element)nodeList.get(i);
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.alllotto.confbean.AllLottoCfgOriginal"))
/*     */         {
/*     */ 
/* 144 */           AllLottoCfgOriginal obj = new AllLottoCfgOriginal();
/* 145 */           obj.loadFromXml(elem);
/* 146 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 147 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, AllLottoCfgOriginal> all)
/*     */   {
/* 158 */     String path = dir + "mzm.gsp.alllotto.confbean.AllLottoCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 162 */       SAXReader reader = new SAXReader();
/* 163 */       org.dom4j.Document doc = reader.read(new File(path));
/* 164 */       Element root = doc.getRootElement();
/* 165 */       List<?> nodeList = root.elements();
/* 166 */       int len = nodeList.size();
/* 167 */       for (int i = 0; i < len; i++)
/*     */       {
/* 169 */         Element elem = (Element)nodeList.get(i);
/* 170 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.alllotto.confbean.AllLottoCfgOriginal"))
/*     */         {
/*     */ 
/* 173 */           AllLottoCfgOriginal obj = new AllLottoCfgOriginal();
/* 174 */           obj.loadFromXml(elem);
/* 175 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 176 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 181 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 187 */     all = new java.util.HashMap();
/*     */     
/* 189 */     String path = dir + "mzm.gsp.alllotto.confbean.AllLottoCfgOriginal.bny";
/*     */     try
/*     */     {
/* 192 */       File file = new File(path);
/* 193 */       if (file.exists())
/*     */       {
/* 195 */         byte[] bytes = new byte['Ѐ'];
/* 196 */         FileInputStream fis = new FileInputStream(file);
/* 197 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 198 */         int len = 0;
/* 199 */         while ((len = fis.read(bytes)) > 0)
/* 200 */           baos.write(bytes, 0, len);
/* 201 */         fis.close();
/* 202 */         bytes = baos.toByteArray();
/* 203 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 204 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 206 */           _os_.unmarshal_int();
/* 207 */           _os_.unmarshal_int();
/* 208 */           _os_.unmarshal_int();
/*     */         }
/* 210 */         _os_.unmarshal_int();
/* 211 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 214 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 216 */           AllLottoCfgOriginal _v_ = new AllLottoCfgOriginal();
/* 217 */           _v_.unmarshal(_os_);
/* 218 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 219 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 224 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 229 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, AllLottoCfgOriginal> all)
/*     */   {
/* 236 */     String path = dir + "mzm.gsp.alllotto.confbean.AllLottoCfgOriginal.bny";
/*     */     try
/*     */     {
/* 239 */       File file = new File(path);
/* 240 */       if (file.exists())
/*     */       {
/* 242 */         byte[] bytes = new byte['Ѐ'];
/* 243 */         FileInputStream fis = new FileInputStream(file);
/* 244 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 245 */         int len = 0;
/* 246 */         while ((len = fis.read(bytes)) > 0)
/* 247 */           baos.write(bytes, 0, len);
/* 248 */         fis.close();
/* 249 */         bytes = baos.toByteArray();
/* 250 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 251 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 253 */           _os_.unmarshal_int();
/* 254 */           _os_.unmarshal_int();
/* 255 */           _os_.unmarshal_int();
/*     */         }
/* 257 */         _os_.unmarshal_int();
/* 258 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 261 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 263 */           AllLottoCfgOriginal _v_ = new AllLottoCfgOriginal();
/* 264 */           _v_.unmarshal(_os_);
/* 265 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 266 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 271 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 276 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static AllLottoCfgOriginal getOld(int key)
/*     */   {
/* 284 */     return (AllLottoCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static AllLottoCfgOriginal get(int key)
/*     */   {
/* 289 */     return (AllLottoCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, AllLottoCfgOriginal> getOldAll()
/*     */   {
/* 294 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, AllLottoCfgOriginal> getAll()
/*     */   {
/* 299 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, AllLottoCfgOriginal> newAll)
/*     */   {
/* 304 */     oldAll = all;
/* 305 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 310 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\confbean\AllLottoCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */