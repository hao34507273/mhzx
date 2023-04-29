/*     */ package mzm.gsp.activity2.confbean;
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
/*     */ public class SMemoryCompetitionCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMemoryCompetitionCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMemoryCompetitionCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int mapping_type_id;
/*     */   public int mapping_num;
/*     */   public int question_num;
/*     */   public int mapping_answer_show_seconds;
/*     */   public int question_answer_seconds;
/*     */   public int seek_help_times;
/*     */   public int right_answer_score;
/*     */   public int wrong_answer_score;
/*     */   public int right_answer_award;
/*     */   public int wrong_answer_award;
/*     */   public int extra_award;
/*     */   public int question_interval;
/*     */   public int question_option_num;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.mapping_type_id = Integer.valueOf(rootElement.attributeValue("mapping_type_id")).intValue();
/*  37 */     this.mapping_num = Integer.valueOf(rootElement.attributeValue("mapping_num")).intValue();
/*  38 */     this.question_num = Integer.valueOf(rootElement.attributeValue("question_num")).intValue();
/*  39 */     this.mapping_answer_show_seconds = Integer.valueOf(rootElement.attributeValue("mapping_answer_show_seconds")).intValue();
/*  40 */     this.question_answer_seconds = Integer.valueOf(rootElement.attributeValue("question_answer_seconds")).intValue();
/*  41 */     this.seek_help_times = Integer.valueOf(rootElement.attributeValue("seek_help_times")).intValue();
/*  42 */     this.right_answer_score = Integer.valueOf(rootElement.attributeValue("right_answer_score")).intValue();
/*  43 */     this.wrong_answer_score = Integer.valueOf(rootElement.attributeValue("wrong_answer_score")).intValue();
/*  44 */     this.right_answer_award = Integer.valueOf(rootElement.attributeValue("right_answer_award")).intValue();
/*  45 */     this.wrong_answer_award = Integer.valueOf(rootElement.attributeValue("wrong_answer_award")).intValue();
/*  46 */     this.extra_award = Integer.valueOf(rootElement.attributeValue("extra_award")).intValue();
/*  47 */     this.question_interval = Integer.valueOf(rootElement.attributeValue("question_interval")).intValue();
/*  48 */     this.question_option_num = Integer.valueOf(rootElement.attributeValue("question_option_num")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.mapping_type_id);
/*  55 */     _os_.marshal(this.mapping_num);
/*  56 */     _os_.marshal(this.question_num);
/*  57 */     _os_.marshal(this.mapping_answer_show_seconds);
/*  58 */     _os_.marshal(this.question_answer_seconds);
/*  59 */     _os_.marshal(this.seek_help_times);
/*  60 */     _os_.marshal(this.right_answer_score);
/*  61 */     _os_.marshal(this.wrong_answer_score);
/*  62 */     _os_.marshal(this.right_answer_award);
/*  63 */     _os_.marshal(this.wrong_answer_award);
/*  64 */     _os_.marshal(this.extra_award);
/*  65 */     _os_.marshal(this.question_interval);
/*  66 */     _os_.marshal(this.question_option_num);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.mapping_type_id = _os_.unmarshal_int();
/*  74 */     this.mapping_num = _os_.unmarshal_int();
/*  75 */     this.question_num = _os_.unmarshal_int();
/*  76 */     this.mapping_answer_show_seconds = _os_.unmarshal_int();
/*  77 */     this.question_answer_seconds = _os_.unmarshal_int();
/*  78 */     this.seek_help_times = _os_.unmarshal_int();
/*  79 */     this.right_answer_score = _os_.unmarshal_int();
/*  80 */     this.wrong_answer_score = _os_.unmarshal_int();
/*  81 */     this.right_answer_award = _os_.unmarshal_int();
/*  82 */     this.wrong_answer_award = _os_.unmarshal_int();
/*  83 */     this.extra_award = _os_.unmarshal_int();
/*  84 */     this.question_interval = _os_.unmarshal_int();
/*  85 */     this.question_option_num = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.activity2.confbean.SMemoryCompetitionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.SMemoryCompetitionCfg"))
/*     */         {
/*     */ 
/* 107 */           SMemoryCompetitionCfg obj = new SMemoryCompetitionCfg();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMemoryCompetitionCfg> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.activity2.confbean.SMemoryCompetitionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.SMemoryCompetitionCfg"))
/*     */         {
/*     */ 
/* 136 */           SMemoryCompetitionCfg obj = new SMemoryCompetitionCfg();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.activity2.confbean.SMemoryCompetitionCfg.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           SMemoryCompetitionCfg _v_ = new SMemoryCompetitionCfg();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMemoryCompetitionCfg> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.activity2.confbean.SMemoryCompetitionCfg.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           SMemoryCompetitionCfg _v_ = new SMemoryCompetitionCfg();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMemoryCompetitionCfg getOld(int key)
/*     */   {
/* 247 */     return (SMemoryCompetitionCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMemoryCompetitionCfg get(int key)
/*     */   {
/* 252 */     return (SMemoryCompetitionCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMemoryCompetitionCfg> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMemoryCompetitionCfg> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMemoryCompetitionCfg> newAll)
/*     */   {
/* 267 */     oldAll = all;
/* 268 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 273 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity2\confbean\SMemoryCompetitionCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */