/*     */ package mzm.gsp.xiaohuikuaipao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOuterDrawRsp
/*     */   extends __SOuterDrawRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622855;
/*     */   public int activityid;
/*     */   public OuterInfo outerinfo;
/*     */   public ArrayList<AwardInfo> awardinfolist;
/*     */   public ArrayList<Integer> stepcountlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12622855;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SOuterDrawRsp()
/*     */   {
/*  34 */     this.outerinfo = new OuterInfo();
/*  35 */     this.awardinfolist = new ArrayList();
/*  36 */     this.stepcountlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SOuterDrawRsp(int _activityid_, OuterInfo _outerinfo_, ArrayList<AwardInfo> _awardinfolist_, ArrayList<Integer> _stepcountlist_) {
/*  40 */     this.activityid = _activityid_;
/*  41 */     this.outerinfo = _outerinfo_;
/*  42 */     this.awardinfolist = _awardinfolist_;
/*  43 */     this.stepcountlist = _stepcountlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.outerinfo._validator_()) return false;
/*  48 */     for (AwardInfo _v_ : this.awardinfolist)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activityid);
/*  55 */     _os_.marshal(this.outerinfo);
/*  56 */     _os_.compact_uint32(this.awardinfolist.size());
/*  57 */     for (AwardInfo _v_ : this.awardinfolist) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     _os_.compact_uint32(this.stepcountlist.size());
/*  61 */     for (Integer _v_ : this.stepcountlist) {
/*  62 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.activityid = _os_.unmarshal_int();
/*  69 */     this.outerinfo.unmarshal(_os_);
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  71 */       AwardInfo _v_ = new AwardInfo();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.awardinfolist.add(_v_);
/*     */     }
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  77 */       int _v_ = _os_.unmarshal_int();
/*  78 */       this.stepcountlist.add(Integer.valueOf(_v_));
/*     */     }
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SOuterDrawRsp)) {
/*  89 */       SOuterDrawRsp _o_ = (SOuterDrawRsp)_o1_;
/*  90 */       if (this.activityid != _o_.activityid) return false;
/*  91 */       if (!this.outerinfo.equals(_o_.outerinfo)) return false;
/*  92 */       if (!this.awardinfolist.equals(_o_.awardinfolist)) return false;
/*  93 */       if (!this.stepcountlist.equals(_o_.stepcountlist)) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.activityid;
/* 102 */     _h_ += this.outerinfo.hashCode();
/* 103 */     _h_ += this.awardinfolist.hashCode();
/* 104 */     _h_ += this.stepcountlist.hashCode();
/* 105 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder _sb_ = new StringBuilder();
/* 110 */     _sb_.append("(");
/* 111 */     _sb_.append(this.activityid).append(",");
/* 112 */     _sb_.append(this.outerinfo).append(",");
/* 113 */     _sb_.append(this.awardinfolist).append(",");
/* 114 */     _sb_.append(this.stepcountlist).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\SOuterDrawRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */