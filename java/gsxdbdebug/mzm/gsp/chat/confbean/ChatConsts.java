/*     */ package mzm.gsp.chat.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class ChatConsts
/*     */ {
/*  13 */   private static volatile ChatConsts oldInstance = null;
/*     */   
/*  15 */   private static ChatConsts instance = new ChatConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ChatConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static ChatConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int chatRecordMax = 20;
/*  32 */   public int mainInterfaceChatRecordMax = 100;
/*  33 */   public int singleChannelChatRecordMax = 100;
/*  34 */   public int newChannelMemberMax = 100;
/*  35 */   public int newChannelMemberMergeMax = 100;
/*  36 */   public int chatBubbleTimeLag = 5;
/*  37 */   public int roleNameColorR = 0;
/*  38 */   public int roleNameColorG = 0;
/*  39 */   public int roleNameColorB = 0;
/*  40 */   public int chatCommonFontColorR = 0;
/*  41 */   public int chatCommonFontColorG = 0;
/*  42 */   public int chatCommonFontColorB = 0;
/*  43 */   public int chatInputNumMax = 40;
/*  44 */   public int ManualloadMessageNum = 25;
/*  45 */   public int newChannelCheckTime = 10;
/*  46 */   public int EachOnlineWhisperRecordMax = 100;
/*  47 */   public int SumOfflineWhisperRecordMax = 100;
/*  48 */   public int offlineWhisperRecordCheckTime = 259200;
/*  49 */   public int strangerWhisperRecordMax = 10;
/*  50 */   public int strangerWhisperMemberMax = 10;
/*  51 */   public int whisperCommonFontColorR = 255;
/*  52 */   public int whisperCommonFontColorG = 255;
/*  53 */   public int whisperCommonFontColorB = 255;
/*  54 */   public int helpHintTimeLag = 1200;
/*  55 */   public int singleBrodcastDisapperTime = 5;
/*  56 */   public int multiBrodcastDisapperTime = 3;
/*  57 */   public int sysChannelRecordMax = 100;
/*  58 */   public int sysHintFontColorR = 255;
/*  59 */   public int sysHintFontColorG = 255;
/*  60 */   public int sysHintFontColorB = 255;
/*  61 */   public int helpHintFontColorR = 255;
/*  62 */   public int helpHintFontColorG = 255;
/*  63 */   public int helpHintFontColorB = 255;
/*  64 */   public int petFontColorR = 255;
/*  65 */   public int petFontColorG = 255;
/*  66 */   public int petFontColorB = 255;
/*  67 */   public int taskFontColorR = 255;
/*  68 */   public int taskFontColorG = 255;
/*  69 */   public int taskFontColorB = 255;
/*  70 */   public int channelHintFontColorR = 255;
/*  71 */   public int channelHintFontColorG = 255;
/*  72 */   public int channelHintFontColorB = 255;
/*  73 */   public int chatBubbleFontColorR = 255;
/*  74 */   public int chatBubbleFontColorG = 255;
/*  75 */   public int chatBubbleFontColorB = 255;
/*  76 */   public int friendPrivatechatFontColorR = 54;
/*  77 */   public int friendPrivatechatFontColorG = 56;
/*  78 */   public int friendPrivatechatFontColorB = 153;
/*  79 */   public int secretTypeTimeRet = 5000;
/*     */   public int messageBoxMessageNumUpperLimit;
/*  81 */   public String atMessageColor = "";
/*     */   public int atEffectid;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  86 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.chat.confbean.ChatConsts.xml";
/*     */     try
/*     */     {
/*  94 */       SAXReader reader = new SAXReader();
/*  95 */       org.dom4j.Document doc = reader.read(new File(path));
/*  96 */       Element root = doc.getRootElement();
/*  97 */       Map<String, Element> data = new java.util.HashMap();
/*  98 */       java.util.List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element element = (Element)nodeList.get(i);
/* 103 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 106 */           String name = element.attributeValue("name");
/* 107 */           if (data.put(name, element) != null)
/* 108 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 111 */       this.chatRecordMax = Integer.valueOf(((Element)data.get("chatRecordMax")).attributeValue("value")).intValue();
/* 112 */       this.mainInterfaceChatRecordMax = Integer.valueOf(((Element)data.get("mainInterfaceChatRecordMax")).attributeValue("value")).intValue();
/* 113 */       this.singleChannelChatRecordMax = Integer.valueOf(((Element)data.get("singleChannelChatRecordMax")).attributeValue("value")).intValue();
/* 114 */       this.newChannelMemberMax = Integer.valueOf(((Element)data.get("newChannelMemberMax")).attributeValue("value")).intValue();
/* 115 */       this.newChannelMemberMergeMax = Integer.valueOf(((Element)data.get("newChannelMemberMergeMax")).attributeValue("value")).intValue();
/* 116 */       this.chatBubbleTimeLag = Integer.valueOf(((Element)data.get("chatBubbleTimeLag")).attributeValue("value")).intValue();
/* 117 */       this.roleNameColorR = Integer.valueOf(((Element)data.get("roleNameColorR")).attributeValue("value")).intValue();
/* 118 */       this.roleNameColorG = Integer.valueOf(((Element)data.get("roleNameColorG")).attributeValue("value")).intValue();
/* 119 */       this.roleNameColorB = Integer.valueOf(((Element)data.get("roleNameColorB")).attributeValue("value")).intValue();
/* 120 */       this.chatCommonFontColorR = Integer.valueOf(((Element)data.get("chatCommonFontColorR")).attributeValue("value")).intValue();
/* 121 */       this.chatCommonFontColorG = Integer.valueOf(((Element)data.get("chatCommonFontColorG")).attributeValue("value")).intValue();
/* 122 */       this.chatCommonFontColorB = Integer.valueOf(((Element)data.get("chatCommonFontColorB")).attributeValue("value")).intValue();
/* 123 */       this.chatInputNumMax = Integer.valueOf(((Element)data.get("chatInputNumMax")).attributeValue("value")).intValue();
/* 124 */       this.ManualloadMessageNum = Integer.valueOf(((Element)data.get("ManualloadMessageNum")).attributeValue("value")).intValue();
/* 125 */       this.newChannelCheckTime = Integer.valueOf(((Element)data.get("newChannelCheckTime")).attributeValue("value")).intValue();
/* 126 */       this.EachOnlineWhisperRecordMax = Integer.valueOf(((Element)data.get("EachOnlineWhisperRecordMax")).attributeValue("value")).intValue();
/* 127 */       this.SumOfflineWhisperRecordMax = Integer.valueOf(((Element)data.get("SumOfflineWhisperRecordMax")).attributeValue("value")).intValue();
/* 128 */       this.offlineWhisperRecordCheckTime = Integer.valueOf(((Element)data.get("offlineWhisperRecordCheckTime")).attributeValue("value")).intValue();
/* 129 */       this.strangerWhisperRecordMax = Integer.valueOf(((Element)data.get("strangerWhisperRecordMax")).attributeValue("value")).intValue();
/* 130 */       this.strangerWhisperMemberMax = Integer.valueOf(((Element)data.get("strangerWhisperMemberMax")).attributeValue("value")).intValue();
/* 131 */       this.whisperCommonFontColorR = Integer.valueOf(((Element)data.get("whisperCommonFontColorR")).attributeValue("value")).intValue();
/* 132 */       this.whisperCommonFontColorG = Integer.valueOf(((Element)data.get("whisperCommonFontColorG")).attributeValue("value")).intValue();
/* 133 */       this.whisperCommonFontColorB = Integer.valueOf(((Element)data.get("whisperCommonFontColorB")).attributeValue("value")).intValue();
/* 134 */       this.helpHintTimeLag = Integer.valueOf(((Element)data.get("helpHintTimeLag")).attributeValue("value")).intValue();
/* 135 */       this.singleBrodcastDisapperTime = Integer.valueOf(((Element)data.get("singleBrodcastDisapperTime")).attributeValue("value")).intValue();
/* 136 */       this.multiBrodcastDisapperTime = Integer.valueOf(((Element)data.get("multiBrodcastDisapperTime")).attributeValue("value")).intValue();
/* 137 */       this.sysChannelRecordMax = Integer.valueOf(((Element)data.get("sysChannelRecordMax")).attributeValue("value")).intValue();
/* 138 */       this.sysHintFontColorR = Integer.valueOf(((Element)data.get("sysHintFontColorR")).attributeValue("value")).intValue();
/* 139 */       this.sysHintFontColorG = Integer.valueOf(((Element)data.get("sysHintFontColorG")).attributeValue("value")).intValue();
/* 140 */       this.sysHintFontColorB = Integer.valueOf(((Element)data.get("sysHintFontColorB")).attributeValue("value")).intValue();
/* 141 */       this.helpHintFontColorR = Integer.valueOf(((Element)data.get("helpHintFontColorR")).attributeValue("value")).intValue();
/* 142 */       this.helpHintFontColorG = Integer.valueOf(((Element)data.get("helpHintFontColorG")).attributeValue("value")).intValue();
/* 143 */       this.helpHintFontColorB = Integer.valueOf(((Element)data.get("helpHintFontColorB")).attributeValue("value")).intValue();
/* 144 */       this.petFontColorR = Integer.valueOf(((Element)data.get("petFontColorR")).attributeValue("value")).intValue();
/* 145 */       this.petFontColorG = Integer.valueOf(((Element)data.get("petFontColorG")).attributeValue("value")).intValue();
/* 146 */       this.petFontColorB = Integer.valueOf(((Element)data.get("petFontColorB")).attributeValue("value")).intValue();
/* 147 */       this.taskFontColorR = Integer.valueOf(((Element)data.get("taskFontColorR")).attributeValue("value")).intValue();
/* 148 */       this.taskFontColorG = Integer.valueOf(((Element)data.get("taskFontColorG")).attributeValue("value")).intValue();
/* 149 */       this.taskFontColorB = Integer.valueOf(((Element)data.get("taskFontColorB")).attributeValue("value")).intValue();
/* 150 */       this.channelHintFontColorR = Integer.valueOf(((Element)data.get("channelHintFontColorR")).attributeValue("value")).intValue();
/* 151 */       this.channelHintFontColorG = Integer.valueOf(((Element)data.get("channelHintFontColorG")).attributeValue("value")).intValue();
/* 152 */       this.channelHintFontColorB = Integer.valueOf(((Element)data.get("channelHintFontColorB")).attributeValue("value")).intValue();
/* 153 */       this.chatBubbleFontColorR = Integer.valueOf(((Element)data.get("chatBubbleFontColorR")).attributeValue("value")).intValue();
/* 154 */       this.chatBubbleFontColorG = Integer.valueOf(((Element)data.get("chatBubbleFontColorG")).attributeValue("value")).intValue();
/* 155 */       this.chatBubbleFontColorB = Integer.valueOf(((Element)data.get("chatBubbleFontColorB")).attributeValue("value")).intValue();
/* 156 */       this.friendPrivatechatFontColorR = Integer.valueOf(((Element)data.get("friendPrivatechatFontColorR")).attributeValue("value")).intValue();
/* 157 */       this.friendPrivatechatFontColorG = Integer.valueOf(((Element)data.get("friendPrivatechatFontColorG")).attributeValue("value")).intValue();
/* 158 */       this.friendPrivatechatFontColorB = Integer.valueOf(((Element)data.get("friendPrivatechatFontColorB")).attributeValue("value")).intValue();
/* 159 */       this.secretTypeTimeRet = Integer.valueOf(((Element)data.get("secretTypeTimeRet")).attributeValue("value")).intValue();
/* 160 */       this.messageBoxMessageNumUpperLimit = Integer.valueOf(((Element)data.get("messageBoxMessageNumUpperLimit")).attributeValue("value")).intValue();
/* 161 */       this.atMessageColor = String.valueOf(((Element)data.get("atMessageColor")).attributeValue("value"));
/* 162 */       this.atEffectid = Integer.valueOf(((Element)data.get("atEffectid")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 166 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 171 */     String path = dir + "mzm.gsp.chat.confbean.ChatConsts.xml";
/*     */     try
/*     */     {
/* 174 */       SAXReader reader = new SAXReader();
/* 175 */       org.dom4j.Document doc = reader.read(new File(path));
/* 176 */       Element root = doc.getRootElement();
/* 177 */       Map<String, Element> data = new java.util.HashMap();
/* 178 */       java.util.List<?> nodeList = root.elements();
/* 179 */       int len = nodeList.size();
/* 180 */       for (int i = 0; i < len; i++)
/*     */       {
/* 182 */         Element element = (Element)nodeList.get(i);
/* 183 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 186 */           String name = element.attributeValue("name");
/* 187 */           if (data.put(name, element) != null)
/* 188 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 191 */       this.chatRecordMax = Integer.valueOf(((Element)data.get("chatRecordMax")).attributeValue("value")).intValue();
/* 192 */       this.mainInterfaceChatRecordMax = Integer.valueOf(((Element)data.get("mainInterfaceChatRecordMax")).attributeValue("value")).intValue();
/* 193 */       this.singleChannelChatRecordMax = Integer.valueOf(((Element)data.get("singleChannelChatRecordMax")).attributeValue("value")).intValue();
/* 194 */       this.newChannelMemberMax = Integer.valueOf(((Element)data.get("newChannelMemberMax")).attributeValue("value")).intValue();
/* 195 */       this.newChannelMemberMergeMax = Integer.valueOf(((Element)data.get("newChannelMemberMergeMax")).attributeValue("value")).intValue();
/* 196 */       this.chatBubbleTimeLag = Integer.valueOf(((Element)data.get("chatBubbleTimeLag")).attributeValue("value")).intValue();
/* 197 */       this.roleNameColorR = Integer.valueOf(((Element)data.get("roleNameColorR")).attributeValue("value")).intValue();
/* 198 */       this.roleNameColorG = Integer.valueOf(((Element)data.get("roleNameColorG")).attributeValue("value")).intValue();
/* 199 */       this.roleNameColorB = Integer.valueOf(((Element)data.get("roleNameColorB")).attributeValue("value")).intValue();
/* 200 */       this.chatCommonFontColorR = Integer.valueOf(((Element)data.get("chatCommonFontColorR")).attributeValue("value")).intValue();
/* 201 */       this.chatCommonFontColorG = Integer.valueOf(((Element)data.get("chatCommonFontColorG")).attributeValue("value")).intValue();
/* 202 */       this.chatCommonFontColorB = Integer.valueOf(((Element)data.get("chatCommonFontColorB")).attributeValue("value")).intValue();
/* 203 */       this.chatInputNumMax = Integer.valueOf(((Element)data.get("chatInputNumMax")).attributeValue("value")).intValue();
/* 204 */       this.ManualloadMessageNum = Integer.valueOf(((Element)data.get("ManualloadMessageNum")).attributeValue("value")).intValue();
/* 205 */       this.newChannelCheckTime = Integer.valueOf(((Element)data.get("newChannelCheckTime")).attributeValue("value")).intValue();
/* 206 */       this.EachOnlineWhisperRecordMax = Integer.valueOf(((Element)data.get("EachOnlineWhisperRecordMax")).attributeValue("value")).intValue();
/* 207 */       this.SumOfflineWhisperRecordMax = Integer.valueOf(((Element)data.get("SumOfflineWhisperRecordMax")).attributeValue("value")).intValue();
/* 208 */       this.offlineWhisperRecordCheckTime = Integer.valueOf(((Element)data.get("offlineWhisperRecordCheckTime")).attributeValue("value")).intValue();
/* 209 */       this.strangerWhisperRecordMax = Integer.valueOf(((Element)data.get("strangerWhisperRecordMax")).attributeValue("value")).intValue();
/* 210 */       this.strangerWhisperMemberMax = Integer.valueOf(((Element)data.get("strangerWhisperMemberMax")).attributeValue("value")).intValue();
/* 211 */       this.whisperCommonFontColorR = Integer.valueOf(((Element)data.get("whisperCommonFontColorR")).attributeValue("value")).intValue();
/* 212 */       this.whisperCommonFontColorG = Integer.valueOf(((Element)data.get("whisperCommonFontColorG")).attributeValue("value")).intValue();
/* 213 */       this.whisperCommonFontColorB = Integer.valueOf(((Element)data.get("whisperCommonFontColorB")).attributeValue("value")).intValue();
/* 214 */       this.helpHintTimeLag = Integer.valueOf(((Element)data.get("helpHintTimeLag")).attributeValue("value")).intValue();
/* 215 */       this.singleBrodcastDisapperTime = Integer.valueOf(((Element)data.get("singleBrodcastDisapperTime")).attributeValue("value")).intValue();
/* 216 */       this.multiBrodcastDisapperTime = Integer.valueOf(((Element)data.get("multiBrodcastDisapperTime")).attributeValue("value")).intValue();
/* 217 */       this.sysChannelRecordMax = Integer.valueOf(((Element)data.get("sysChannelRecordMax")).attributeValue("value")).intValue();
/* 218 */       this.sysHintFontColorR = Integer.valueOf(((Element)data.get("sysHintFontColorR")).attributeValue("value")).intValue();
/* 219 */       this.sysHintFontColorG = Integer.valueOf(((Element)data.get("sysHintFontColorG")).attributeValue("value")).intValue();
/* 220 */       this.sysHintFontColorB = Integer.valueOf(((Element)data.get("sysHintFontColorB")).attributeValue("value")).intValue();
/* 221 */       this.helpHintFontColorR = Integer.valueOf(((Element)data.get("helpHintFontColorR")).attributeValue("value")).intValue();
/* 222 */       this.helpHintFontColorG = Integer.valueOf(((Element)data.get("helpHintFontColorG")).attributeValue("value")).intValue();
/* 223 */       this.helpHintFontColorB = Integer.valueOf(((Element)data.get("helpHintFontColorB")).attributeValue("value")).intValue();
/* 224 */       this.petFontColorR = Integer.valueOf(((Element)data.get("petFontColorR")).attributeValue("value")).intValue();
/* 225 */       this.petFontColorG = Integer.valueOf(((Element)data.get("petFontColorG")).attributeValue("value")).intValue();
/* 226 */       this.petFontColorB = Integer.valueOf(((Element)data.get("petFontColorB")).attributeValue("value")).intValue();
/* 227 */       this.taskFontColorR = Integer.valueOf(((Element)data.get("taskFontColorR")).attributeValue("value")).intValue();
/* 228 */       this.taskFontColorG = Integer.valueOf(((Element)data.get("taskFontColorG")).attributeValue("value")).intValue();
/* 229 */       this.taskFontColorB = Integer.valueOf(((Element)data.get("taskFontColorB")).attributeValue("value")).intValue();
/* 230 */       this.channelHintFontColorR = Integer.valueOf(((Element)data.get("channelHintFontColorR")).attributeValue("value")).intValue();
/* 231 */       this.channelHintFontColorG = Integer.valueOf(((Element)data.get("channelHintFontColorG")).attributeValue("value")).intValue();
/* 232 */       this.channelHintFontColorB = Integer.valueOf(((Element)data.get("channelHintFontColorB")).attributeValue("value")).intValue();
/* 233 */       this.chatBubbleFontColorR = Integer.valueOf(((Element)data.get("chatBubbleFontColorR")).attributeValue("value")).intValue();
/* 234 */       this.chatBubbleFontColorG = Integer.valueOf(((Element)data.get("chatBubbleFontColorG")).attributeValue("value")).intValue();
/* 235 */       this.chatBubbleFontColorB = Integer.valueOf(((Element)data.get("chatBubbleFontColorB")).attributeValue("value")).intValue();
/* 236 */       this.friendPrivatechatFontColorR = Integer.valueOf(((Element)data.get("friendPrivatechatFontColorR")).attributeValue("value")).intValue();
/* 237 */       this.friendPrivatechatFontColorG = Integer.valueOf(((Element)data.get("friendPrivatechatFontColorG")).attributeValue("value")).intValue();
/* 238 */       this.friendPrivatechatFontColorB = Integer.valueOf(((Element)data.get("friendPrivatechatFontColorB")).attributeValue("value")).intValue();
/* 239 */       this.secretTypeTimeRet = Integer.valueOf(((Element)data.get("secretTypeTimeRet")).attributeValue("value")).intValue();
/* 240 */       this.messageBoxMessageNumUpperLimit = Integer.valueOf(((Element)data.get("messageBoxMessageNumUpperLimit")).attributeValue("value")).intValue();
/* 241 */       this.atMessageColor = String.valueOf(((Element)data.get("atMessageColor")).attributeValue("value"));
/* 242 */       this.atEffectid = Integer.valueOf(((Element)data.get("atEffectid")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 250 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 253 */     String path = dir + "mzm.gsp.chat.confbean.ChatConsts.bny";
/*     */     try
/*     */     {
/* 256 */       File file = new File(path);
/* 257 */       if (file.exists())
/*     */       {
/* 259 */         byte[] bytes = new byte['Ѐ'];
/* 260 */         FileInputStream fis = new FileInputStream(file);
/* 261 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 262 */         int len = 0;
/* 263 */         while ((len = fis.read(bytes)) > 0)
/* 264 */           baos.write(bytes, 0, len);
/* 265 */         fis.close();
/* 266 */         bytes = baos.toByteArray();
/* 267 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 268 */         this.chatRecordMax = _os_.unmarshal_int();
/* 269 */         this.mainInterfaceChatRecordMax = _os_.unmarshal_int();
/* 270 */         this.singleChannelChatRecordMax = _os_.unmarshal_int();
/* 271 */         this.newChannelMemberMax = _os_.unmarshal_int();
/* 272 */         this.newChannelMemberMergeMax = _os_.unmarshal_int();
/* 273 */         this.chatBubbleTimeLag = _os_.unmarshal_int();
/* 274 */         this.roleNameColorR = _os_.unmarshal_int();
/* 275 */         this.roleNameColorG = _os_.unmarshal_int();
/* 276 */         this.roleNameColorB = _os_.unmarshal_int();
/* 277 */         this.chatCommonFontColorR = _os_.unmarshal_int();
/* 278 */         this.chatCommonFontColorG = _os_.unmarshal_int();
/* 279 */         this.chatCommonFontColorB = _os_.unmarshal_int();
/* 280 */         this.chatInputNumMax = _os_.unmarshal_int();
/* 281 */         this.ManualloadMessageNum = _os_.unmarshal_int();
/* 282 */         this.newChannelCheckTime = _os_.unmarshal_int();
/* 283 */         this.EachOnlineWhisperRecordMax = _os_.unmarshal_int();
/* 284 */         this.SumOfflineWhisperRecordMax = _os_.unmarshal_int();
/* 285 */         this.offlineWhisperRecordCheckTime = _os_.unmarshal_int();
/* 286 */         this.strangerWhisperRecordMax = _os_.unmarshal_int();
/* 287 */         this.strangerWhisperMemberMax = _os_.unmarshal_int();
/* 288 */         this.whisperCommonFontColorR = _os_.unmarshal_int();
/* 289 */         this.whisperCommonFontColorG = _os_.unmarshal_int();
/* 290 */         this.whisperCommonFontColorB = _os_.unmarshal_int();
/* 291 */         this.helpHintTimeLag = _os_.unmarshal_int();
/* 292 */         this.singleBrodcastDisapperTime = _os_.unmarshal_int();
/* 293 */         this.multiBrodcastDisapperTime = _os_.unmarshal_int();
/* 294 */         this.sysChannelRecordMax = _os_.unmarshal_int();
/* 295 */         this.sysHintFontColorR = _os_.unmarshal_int();
/* 296 */         this.sysHintFontColorG = _os_.unmarshal_int();
/* 297 */         this.sysHintFontColorB = _os_.unmarshal_int();
/* 298 */         this.helpHintFontColorR = _os_.unmarshal_int();
/* 299 */         this.helpHintFontColorG = _os_.unmarshal_int();
/* 300 */         this.helpHintFontColorB = _os_.unmarshal_int();
/* 301 */         this.petFontColorR = _os_.unmarshal_int();
/* 302 */         this.petFontColorG = _os_.unmarshal_int();
/* 303 */         this.petFontColorB = _os_.unmarshal_int();
/* 304 */         this.taskFontColorR = _os_.unmarshal_int();
/* 305 */         this.taskFontColorG = _os_.unmarshal_int();
/* 306 */         this.taskFontColorB = _os_.unmarshal_int();
/* 307 */         this.channelHintFontColorR = _os_.unmarshal_int();
/* 308 */         this.channelHintFontColorG = _os_.unmarshal_int();
/* 309 */         this.channelHintFontColorB = _os_.unmarshal_int();
/* 310 */         this.chatBubbleFontColorR = _os_.unmarshal_int();
/* 311 */         this.chatBubbleFontColorG = _os_.unmarshal_int();
/* 312 */         this.chatBubbleFontColorB = _os_.unmarshal_int();
/* 313 */         this.friendPrivatechatFontColorR = _os_.unmarshal_int();
/* 314 */         this.friendPrivatechatFontColorG = _os_.unmarshal_int();
/* 315 */         this.friendPrivatechatFontColorB = _os_.unmarshal_int();
/* 316 */         this.secretTypeTimeRet = _os_.unmarshal_int();
/* 317 */         this.messageBoxMessageNumUpperLimit = _os_.unmarshal_int();
/* 318 */         this.atMessageColor = _os_.unmarshal_String("UTF-8");
/* 319 */         this.atEffectid = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 324 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 330 */     String path = dir + "mzm.gsp.chat.confbean.ChatConsts.bny";
/*     */     try
/*     */     {
/* 333 */       File file = new File(path);
/* 334 */       if (file.exists())
/*     */       {
/* 336 */         byte[] bytes = new byte['Ѐ'];
/* 337 */         FileInputStream fis = new FileInputStream(file);
/* 338 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 339 */         int len = 0;
/* 340 */         while ((len = fis.read(bytes)) > 0)
/* 341 */           baos.write(bytes, 0, len);
/* 342 */         fis.close();
/* 343 */         bytes = baos.toByteArray();
/* 344 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 345 */         this.chatRecordMax = _os_.unmarshal_int();
/* 346 */         this.mainInterfaceChatRecordMax = _os_.unmarshal_int();
/* 347 */         this.singleChannelChatRecordMax = _os_.unmarshal_int();
/* 348 */         this.newChannelMemberMax = _os_.unmarshal_int();
/* 349 */         this.newChannelMemberMergeMax = _os_.unmarshal_int();
/* 350 */         this.chatBubbleTimeLag = _os_.unmarshal_int();
/* 351 */         this.roleNameColorR = _os_.unmarshal_int();
/* 352 */         this.roleNameColorG = _os_.unmarshal_int();
/* 353 */         this.roleNameColorB = _os_.unmarshal_int();
/* 354 */         this.chatCommonFontColorR = _os_.unmarshal_int();
/* 355 */         this.chatCommonFontColorG = _os_.unmarshal_int();
/* 356 */         this.chatCommonFontColorB = _os_.unmarshal_int();
/* 357 */         this.chatInputNumMax = _os_.unmarshal_int();
/* 358 */         this.ManualloadMessageNum = _os_.unmarshal_int();
/* 359 */         this.newChannelCheckTime = _os_.unmarshal_int();
/* 360 */         this.EachOnlineWhisperRecordMax = _os_.unmarshal_int();
/* 361 */         this.SumOfflineWhisperRecordMax = _os_.unmarshal_int();
/* 362 */         this.offlineWhisperRecordCheckTime = _os_.unmarshal_int();
/* 363 */         this.strangerWhisperRecordMax = _os_.unmarshal_int();
/* 364 */         this.strangerWhisperMemberMax = _os_.unmarshal_int();
/* 365 */         this.whisperCommonFontColorR = _os_.unmarshal_int();
/* 366 */         this.whisperCommonFontColorG = _os_.unmarshal_int();
/* 367 */         this.whisperCommonFontColorB = _os_.unmarshal_int();
/* 368 */         this.helpHintTimeLag = _os_.unmarshal_int();
/* 369 */         this.singleBrodcastDisapperTime = _os_.unmarshal_int();
/* 370 */         this.multiBrodcastDisapperTime = _os_.unmarshal_int();
/* 371 */         this.sysChannelRecordMax = _os_.unmarshal_int();
/* 372 */         this.sysHintFontColorR = _os_.unmarshal_int();
/* 373 */         this.sysHintFontColorG = _os_.unmarshal_int();
/* 374 */         this.sysHintFontColorB = _os_.unmarshal_int();
/* 375 */         this.helpHintFontColorR = _os_.unmarshal_int();
/* 376 */         this.helpHintFontColorG = _os_.unmarshal_int();
/* 377 */         this.helpHintFontColorB = _os_.unmarshal_int();
/* 378 */         this.petFontColorR = _os_.unmarshal_int();
/* 379 */         this.petFontColorG = _os_.unmarshal_int();
/* 380 */         this.petFontColorB = _os_.unmarshal_int();
/* 381 */         this.taskFontColorR = _os_.unmarshal_int();
/* 382 */         this.taskFontColorG = _os_.unmarshal_int();
/* 383 */         this.taskFontColorB = _os_.unmarshal_int();
/* 384 */         this.channelHintFontColorR = _os_.unmarshal_int();
/* 385 */         this.channelHintFontColorG = _os_.unmarshal_int();
/* 386 */         this.channelHintFontColorB = _os_.unmarshal_int();
/* 387 */         this.chatBubbleFontColorR = _os_.unmarshal_int();
/* 388 */         this.chatBubbleFontColorG = _os_.unmarshal_int();
/* 389 */         this.chatBubbleFontColorB = _os_.unmarshal_int();
/* 390 */         this.friendPrivatechatFontColorR = _os_.unmarshal_int();
/* 391 */         this.friendPrivatechatFontColorG = _os_.unmarshal_int();
/* 392 */         this.friendPrivatechatFontColorB = _os_.unmarshal_int();
/* 393 */         this.secretTypeTimeRet = _os_.unmarshal_int();
/* 394 */         this.messageBoxMessageNumUpperLimit = _os_.unmarshal_int();
/* 395 */         this.atMessageColor = _os_.unmarshal_String("UTF-8");
/* 396 */         this.atEffectid = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 401 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(ChatConsts newInstance)
/*     */   {
/* 407 */     oldInstance = instance;
/* 408 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 413 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\confbean\ChatConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */