/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import mzm.gsp.chat.confbean.ChatConsts;
/*     */ import mzm.gsp.chat.confbean.SChatEachChannelCfg;
/*     */ 
/*     */ 
/*     */ public class ChatChannelCfg
/*     */ {
/*     */   private int id;
/*     */   private int channelType;
/*     */   private int timeLag;
/*     */   private int levelMin;
/*     */   private int channelIconId;
/*     */   private boolean channelBubble;
/*     */   private int energyConsume;
/*     */   private boolean shieldChannelMessage;
/*     */   private boolean autoPlayVoice;
/*     */   private boolean canChatInCross;
/*     */   
/*     */   public void init(SChatEachChannelCfg sChatEachChannelCfg)
/*     */   {
/*  22 */     this.id = sChatEachChannelCfg.id;
/*  23 */     this.channelType = sChatEachChannelCfg.channelType;
/*  24 */     this.timeLag = sChatEachChannelCfg.timeLag;
/*  25 */     this.levelMin = sChatEachChannelCfg.levelMin;
/*  26 */     this.channelIconId = sChatEachChannelCfg.channelIconId;
/*  27 */     this.channelBubble = sChatEachChannelCfg.channelBubble;
/*  28 */     this.energyConsume = sChatEachChannelCfg.energyConsume;
/*  29 */     this.autoPlayVoice = sChatEachChannelCfg.autoPlayVoice;
/*  30 */     this.canChatInCross = sChatEachChannelCfg.canChatInCross;
/*     */   }
/*     */   
/*     */   public int getId()
/*     */   {
/*  35 */     return this.id;
/*     */   }
/*     */   
/*     */   public int getChannelType()
/*     */   {
/*  40 */     return this.channelType;
/*     */   }
/*     */   
/*     */   public int getTimeLag()
/*     */   {
/*  45 */     return this.timeLag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSecretTimeLag()
/*     */   {
/*  55 */     int timeLag = getTimeLag();
/*  56 */     if (timeLag <= 0)
/*     */     {
/*  58 */       return 0;
/*     */     }
/*  60 */     int secretTypeTimeRet = ChatConsts.getInstance().secretTypeTimeRet;
/*  61 */     if (secretTypeTimeRet <= 0)
/*     */     {
/*  63 */       return 0;
/*     */     }
/*  65 */     return timeLag * secretTypeTimeRet / 10000;
/*     */   }
/*     */   
/*     */   public int getLevelMin()
/*     */   {
/*  70 */     return this.levelMin;
/*     */   }
/*     */   
/*     */   public int getChannelIconId()
/*     */   {
/*  75 */     return this.channelIconId;
/*     */   }
/*     */   
/*     */   public boolean isChannelBubble()
/*     */   {
/*  80 */     return this.channelBubble;
/*     */   }
/*     */   
/*     */   public int getEnergyConsume()
/*     */   {
/*  85 */     return this.energyConsume;
/*     */   }
/*     */   
/*     */   public boolean isShieldChannelMessage()
/*     */   {
/*  90 */     return this.shieldChannelMessage;
/*     */   }
/*     */   
/*     */   public boolean isAutoPlayVoice()
/*     */   {
/*  95 */     return this.autoPlayVoice;
/*     */   }
/*     */   
/*     */   public int getShieldChannelMessageValue()
/*     */   {
/* 100 */     if (isShieldChannelMessage())
/*     */     {
/* 102 */       return 1;
/*     */     }
/*     */     
/*     */ 
/* 106 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getAutoPlayVoiceValue()
/*     */   {
/* 112 */     if (isAutoPlayVoice())
/*     */     {
/* 114 */       return 1;
/*     */     }
/*     */     
/*     */ 
/* 118 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canChatInCross()
/*     */   {
/* 124 */     return this.canChatInCross;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ChatChannelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */