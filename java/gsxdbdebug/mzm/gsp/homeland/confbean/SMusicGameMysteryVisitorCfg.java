/*     */ package mzm.gsp.homeland.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMusicGameMysteryVisitorCfg extends SMysteryVisitorCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SMusicGameMysteryVisitorCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SMusicGameMysteryVisitorCfg> all = null;
/*     */   
/*     */   public int mystery_visitor_npc_id;
/*     */   public int mystery_visitor_npc_service_id;
/*     */   public int music_game_id;
/*     */   public int need_right_num;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  27 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  28 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  29 */     this.mystery_visitor_npc_id = Integer.valueOf(rootElement.attributeValue("mystery_visitor_npc_id")).intValue();
/*  30 */     this.mystery_visitor_npc_service_id = Integer.valueOf(rootElement.attributeValue("mystery_visitor_npc_service_id")).intValue();
/*  31 */     this.music_game_id = Integer.valueOf(rootElement.attributeValue("music_game_id")).intValue();
/*  32 */     this.need_right_num = Integer.valueOf(rootElement.attributeValue("need_right_num")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  37 */     _os_.marshal(this.id);
/*  38 */     _os_.marshal(this.type);
/*  39 */     _os_.marshal(this.award_id);
/*  40 */     _os_.marshal(this.mystery_visitor_npc_id);
/*  41 */     _os_.marshal(this.mystery_visitor_npc_service_id);
/*  42 */     _os_.marshal(this.music_game_id);
/*  43 */     _os_.marshal(this.need_right_num);
/*  44 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  49 */     this.id = _os_.unmarshal_int();
/*  50 */     this.type = _os_.unmarshal_int();
/*  51 */     this.award_id = _os_.unmarshal_int();
/*  52 */     this.mystery_visitor_npc_id = _os_.unmarshal_int();
/*  53 */     this.mystery_visitor_npc_service_id = _os_.unmarshal_int();
/*  54 */     this.music_game_id = _os_.unmarshal_int();
/*  55 */     this.need_right_num = _os_.unmarshal_int();
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  61 */     String path = dir + "mzm.gsp.homeland.confbean.SMusicGameMysteryVisitorCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  65 */       all = new java.util.HashMap();
/*  66 */       SAXReader reader = new SAXReader();
/*  67 */       org.dom4j.Document doc = reader.read(new File(path));
/*  68 */       Element root = doc.getRootElement();
/*  69 */       List<?> nodeList = root.elements();
/*  70 */       int len = nodeList.size();
/*  71 */       for (int i = 0; i < len; i++)
/*     */       {
/*  73 */         Element elem = (Element)nodeList.get(i);
/*  74 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SMusicGameMysteryVisitorCfg"))
/*     */         {
/*     */ 
/*  77 */           SMusicGameMysteryVisitorCfg obj = new SMusicGameMysteryVisitorCfg();
/*  78 */           obj.loadFromXml(elem);
/*  79 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  80 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  85 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMusicGameMysteryVisitorCfg> all)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.homeland.confbean.SMusicGameMysteryVisitorCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       SAXReader reader = new SAXReader();
/*  96 */       org.dom4j.Document doc = reader.read(new File(path));
/*  97 */       Element root = doc.getRootElement();
/*  98 */       List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element elem = (Element)nodeList.get(i);
/* 103 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SMusicGameMysteryVisitorCfg"))
/*     */         {
/*     */ 
/* 106 */           SMusicGameMysteryVisitorCfg obj = new SMusicGameMysteryVisitorCfg();
/* 107 */           obj.loadFromXml(elem);
/* 108 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 109 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 120 */     all = new java.util.HashMap();
/*     */     
/* 122 */     String path = dir + "mzm.gsp.homeland.confbean.SMusicGameMysteryVisitorCfg.bny";
/*     */     try
/*     */     {
/* 125 */       File file = new File(path);
/* 126 */       if (file.exists())
/*     */       {
/* 128 */         byte[] bytes = new byte['Ѐ'];
/* 129 */         FileInputStream fis = new FileInputStream(file);
/* 130 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 131 */         int len = 0;
/* 132 */         while ((len = fis.read(bytes)) > 0)
/* 133 */           baos.write(bytes, 0, len);
/* 134 */         fis.close();
/* 135 */         bytes = baos.toByteArray();
/* 136 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 137 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 139 */           _os_.unmarshal_int();
/* 140 */           _os_.unmarshal_int();
/* 141 */           _os_.unmarshal_int();
/*     */         }
/* 143 */         _os_.unmarshal_int();
/* 144 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 147 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 149 */           SMusicGameMysteryVisitorCfg _v_ = new SMusicGameMysteryVisitorCfg();
/* 150 */           _v_.unmarshal(_os_);
/* 151 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 152 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 157 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 162 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMusicGameMysteryVisitorCfg> all)
/*     */   {
/* 169 */     String path = dir + "mzm.gsp.homeland.confbean.SMusicGameMysteryVisitorCfg.bny";
/*     */     try
/*     */     {
/* 172 */       File file = new File(path);
/* 173 */       if (file.exists())
/*     */       {
/* 175 */         byte[] bytes = new byte['Ѐ'];
/* 176 */         FileInputStream fis = new FileInputStream(file);
/* 177 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 178 */         int len = 0;
/* 179 */         while ((len = fis.read(bytes)) > 0)
/* 180 */           baos.write(bytes, 0, len);
/* 181 */         fis.close();
/* 182 */         bytes = baos.toByteArray();
/* 183 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 184 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 186 */           _os_.unmarshal_int();
/* 187 */           _os_.unmarshal_int();
/* 188 */           _os_.unmarshal_int();
/*     */         }
/* 190 */         _os_.unmarshal_int();
/* 191 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 194 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 196 */           SMusicGameMysteryVisitorCfg _v_ = new SMusicGameMysteryVisitorCfg();
/* 197 */           _v_.unmarshal(_os_);
/* 198 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 199 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 204 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 209 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 215 */     for (Map.Entry<Integer, SMusicGameMysteryVisitorCfg> entry : all.entrySet())
/*     */     {
/* 217 */       if (SMysteryVisitorCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 219 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 223 */       SMysteryVisitorCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SMusicGameMysteryVisitorCfg> all, Map<Integer, SMysteryVisitorCfg> parent)
/*     */   {
/* 230 */     for (Map.Entry<Integer, SMusicGameMysteryVisitorCfg> entry : all.entrySet())
/*     */     {
/* 232 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 234 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 238 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SMusicGameMysteryVisitorCfg getOld(int key)
/*     */   {
/* 245 */     return (SMusicGameMysteryVisitorCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMusicGameMysteryVisitorCfg get(int key)
/*     */   {
/* 250 */     return (SMusicGameMysteryVisitorCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMusicGameMysteryVisitorCfg> getOldAllSelf()
/*     */   {
/* 255 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMusicGameMysteryVisitorCfg> getAllSelf()
/*     */   {
/* 260 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMusicGameMysteryVisitorCfg> newAll)
/*     */   {
/* 265 */     oldAll = all;
/* 266 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 271 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SMusicGameMysteryVisitorCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */