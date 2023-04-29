/*     */ package mzm.gsp.menpaistar;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class MenPaiStarInfo implements Marshal
/*     */ {
/*     */   public byte campaign;
/*     */   public int today_campaign_num;
/*     */   public int last_campaign_time;
/*     */   public byte vote;
/*     */   public int today_vote_num;
/*     */   public int last_vote_time;
/*     */   public int vote_num;
/*     */   public HashMap<Long, Integer> world_canvass;
/*     */   public HashMap<Long, Integer> gang_canvass;
/*     */   
/*     */   public MenPaiStarInfo()
/*     */   {
/*  22 */     this.world_canvass = new HashMap();
/*  23 */     this.gang_canvass = new HashMap();
/*     */   }
/*     */   
/*     */   public MenPaiStarInfo(byte _campaign_, int _today_campaign_num_, int _last_campaign_time_, byte _vote_, int _today_vote_num_, int _last_vote_time_, int _vote_num_, HashMap<Long, Integer> _world_canvass_, HashMap<Long, Integer> _gang_canvass_) {
/*  27 */     this.campaign = _campaign_;
/*  28 */     this.today_campaign_num = _today_campaign_num_;
/*  29 */     this.last_campaign_time = _last_campaign_time_;
/*  30 */     this.vote = _vote_;
/*  31 */     this.today_vote_num = _today_vote_num_;
/*  32 */     this.last_vote_time = _last_vote_time_;
/*  33 */     this.vote_num = _vote_num_;
/*  34 */     this.world_canvass = _world_canvass_;
/*  35 */     this.gang_canvass = _gang_canvass_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  43 */     _os_.marshal(this.campaign);
/*  44 */     _os_.marshal(this.today_campaign_num);
/*  45 */     _os_.marshal(this.last_campaign_time);
/*  46 */     _os_.marshal(this.vote);
/*  47 */     _os_.marshal(this.today_vote_num);
/*  48 */     _os_.marshal(this.last_vote_time);
/*  49 */     _os_.marshal(this.vote_num);
/*  50 */     _os_.compact_uint32(this.world_canvass.size());
/*  51 */     for (Map.Entry<Long, Integer> _e_ : this.world_canvass.entrySet()) {
/*  52 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  55 */     _os_.compact_uint32(this.gang_canvass.size());
/*  56 */     for (Map.Entry<Long, Integer> _e_ : this.gang_canvass.entrySet()) {
/*  57 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  58 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  64 */     this.campaign = _os_.unmarshal_byte();
/*  65 */     this.today_campaign_num = _os_.unmarshal_int();
/*  66 */     this.last_campaign_time = _os_.unmarshal_int();
/*  67 */     this.vote = _os_.unmarshal_byte();
/*  68 */     this.today_vote_num = _os_.unmarshal_int();
/*  69 */     this.last_vote_time = _os_.unmarshal_int();
/*  70 */     this.vote_num = _os_.unmarshal_int();
/*  71 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  73 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  75 */       int _v_ = _os_.unmarshal_int();
/*  76 */       this.world_canvass.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  78 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  80 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  82 */       int _v_ = _os_.unmarshal_int();
/*  83 */       this.gang_canvass.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof MenPaiStarInfo)) {
/*  91 */       MenPaiStarInfo _o_ = (MenPaiStarInfo)_o1_;
/*  92 */       if (this.campaign != _o_.campaign) return false;
/*  93 */       if (this.today_campaign_num != _o_.today_campaign_num) return false;
/*  94 */       if (this.last_campaign_time != _o_.last_campaign_time) return false;
/*  95 */       if (this.vote != _o_.vote) return false;
/*  96 */       if (this.today_vote_num != _o_.today_vote_num) return false;
/*  97 */       if (this.last_vote_time != _o_.last_vote_time) return false;
/*  98 */       if (this.vote_num != _o_.vote_num) return false;
/*  99 */       if (!this.world_canvass.equals(_o_.world_canvass)) return false;
/* 100 */       if (!this.gang_canvass.equals(_o_.gang_canvass)) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.campaign;
/* 109 */     _h_ += this.today_campaign_num;
/* 110 */     _h_ += this.last_campaign_time;
/* 111 */     _h_ += this.vote;
/* 112 */     _h_ += this.today_vote_num;
/* 113 */     _h_ += this.last_vote_time;
/* 114 */     _h_ += this.vote_num;
/* 115 */     _h_ += this.world_canvass.hashCode();
/* 116 */     _h_ += this.gang_canvass.hashCode();
/* 117 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuilder _sb_ = new StringBuilder();
/* 122 */     _sb_.append("(");
/* 123 */     _sb_.append(this.campaign).append(",");
/* 124 */     _sb_.append(this.today_campaign_num).append(",");
/* 125 */     _sb_.append(this.last_campaign_time).append(",");
/* 126 */     _sb_.append(this.vote).append(",");
/* 127 */     _sb_.append(this.today_vote_num).append(",");
/* 128 */     _sb_.append(this.last_vote_time).append(",");
/* 129 */     _sb_.append(this.vote_num).append(",");
/* 130 */     _sb_.append(this.world_canvass).append(",");
/* 131 */     _sb_.append(this.gang_canvass).append(",");
/* 132 */     _sb_.append(")");
/* 133 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\MenPaiStarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */