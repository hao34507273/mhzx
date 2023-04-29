/*     */ package mzm.gsp.lonngboatrace;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SEvent
/*     */   extends __SEvent__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619271;
/*     */   public static final int CALC_SPEED = 0;
/*     */   public static final int NON_CALC_SPEED = 1;
/*     */   public int phaseid;
/*     */   public int eventtriggerid;
/*     */   public HashMap<Long, Integer> team2eventid;
/*     */   public long endtimestamp;
/*     */   public long currtimestamp;
/*     */   public int calcspeed;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619271;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SEvent()
/*     */   {
/*  41 */     this.team2eventid = new HashMap();
/*     */   }
/*     */   
/*     */   public SEvent(int _phaseid_, int _eventtriggerid_, HashMap<Long, Integer> _team2eventid_, long _endtimestamp_, long _currtimestamp_, int _calcspeed_) {
/*  45 */     this.phaseid = _phaseid_;
/*  46 */     this.eventtriggerid = _eventtriggerid_;
/*  47 */     this.team2eventid = _team2eventid_;
/*  48 */     this.endtimestamp = _endtimestamp_;
/*  49 */     this.currtimestamp = _currtimestamp_;
/*  50 */     this.calcspeed = _calcspeed_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.phaseid);
/*  59 */     _os_.marshal(this.eventtriggerid);
/*  60 */     _os_.compact_uint32(this.team2eventid.size());
/*  61 */     for (Map.Entry<Long, Integer> _e_ : this.team2eventid.entrySet()) {
/*  62 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  63 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  65 */     _os_.marshal(this.endtimestamp);
/*  66 */     _os_.marshal(this.currtimestamp);
/*  67 */     _os_.marshal(this.calcspeed);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  72 */     this.phaseid = _os_.unmarshal_int();
/*  73 */     this.eventtriggerid = _os_.unmarshal_int();
/*  74 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  76 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  78 */       int _v_ = _os_.unmarshal_int();
/*  79 */       this.team2eventid.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  81 */     this.endtimestamp = _os_.unmarshal_long();
/*  82 */     this.currtimestamp = _os_.unmarshal_long();
/*  83 */     this.calcspeed = _os_.unmarshal_int();
/*  84 */     if (!_validator_()) {
/*  85 */       throw new VerifyError("validator failed");
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  91 */     if (_o1_ == this) return true;
/*  92 */     if ((_o1_ instanceof SEvent)) {
/*  93 */       SEvent _o_ = (SEvent)_o1_;
/*  94 */       if (this.phaseid != _o_.phaseid) return false;
/*  95 */       if (this.eventtriggerid != _o_.eventtriggerid) return false;
/*  96 */       if (!this.team2eventid.equals(_o_.team2eventid)) return false;
/*  97 */       if (this.endtimestamp != _o_.endtimestamp) return false;
/*  98 */       if (this.currtimestamp != _o_.currtimestamp) return false;
/*  99 */       if (this.calcspeed != _o_.calcspeed) return false;
/* 100 */       return true;
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 106 */     int _h_ = 0;
/* 107 */     _h_ += this.phaseid;
/* 108 */     _h_ += this.eventtriggerid;
/* 109 */     _h_ += this.team2eventid.hashCode();
/* 110 */     _h_ += (int)this.endtimestamp;
/* 111 */     _h_ += (int)this.currtimestamp;
/* 112 */     _h_ += this.calcspeed;
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.phaseid).append(",");
/* 120 */     _sb_.append(this.eventtriggerid).append(",");
/* 121 */     _sb_.append(this.team2eventid).append(",");
/* 122 */     _sb_.append(this.endtimestamp).append(",");
/* 123 */     _sb_.append(this.currtimestamp).append(",");
/* 124 */     _sb_.append(this.calcspeed).append(",");
/* 125 */     _sb_.append(")");
/* 126 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\SEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */