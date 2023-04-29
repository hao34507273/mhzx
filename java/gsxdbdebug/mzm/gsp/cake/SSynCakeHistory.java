/*     */ package mzm.gsp.cake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynCakeHistory
/*     */   extends __SSynCakeHistory__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627722;
/*     */   public int activityid;
/*     */   public long factionid;
/*     */   public long roleid;
/*     */   public LinkedList<CakeHistory> history;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12627722;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynCakeHistory()
/*     */   {
/*  36 */     this.history = new LinkedList();
/*     */   }
/*     */   
/*     */   public SSynCakeHistory(int _activityid_, long _factionid_, long _roleid_, LinkedList<CakeHistory> _history_) {
/*  40 */     this.activityid = _activityid_;
/*  41 */     this.factionid = _factionid_;
/*  42 */     this.roleid = _roleid_;
/*  43 */     this.history = _history_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (CakeHistory _v_ : this.history)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activityid);
/*  54 */     _os_.marshal(this.factionid);
/*  55 */     _os_.marshal(this.roleid);
/*  56 */     _os_.compact_uint32(this.history.size());
/*  57 */     for (CakeHistory _v_ : this.history) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.activityid = _os_.unmarshal_int();
/*  65 */     this.factionid = _os_.unmarshal_long();
/*  66 */     this.roleid = _os_.unmarshal_long();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       CakeHistory _v_ = new CakeHistory();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.history.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSynCakeHistory)) {
/*  81 */       SSynCakeHistory _o_ = (SSynCakeHistory)_o1_;
/*  82 */       if (this.activityid != _o_.activityid) return false;
/*  83 */       if (this.factionid != _o_.factionid) return false;
/*  84 */       if (this.roleid != _o_.roleid) return false;
/*  85 */       if (!this.history.equals(_o_.history)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.activityid;
/*  94 */     _h_ += (int)this.factionid;
/*  95 */     _h_ += (int)this.roleid;
/*  96 */     _h_ += this.history.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.activityid).append(",");
/* 104 */     _sb_.append(this.factionid).append(",");
/* 105 */     _sb_.append(this.roleid).append(",");
/* 106 */     _sb_.append(this.history).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\SSynCakeHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */