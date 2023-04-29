/*     */ package mzm.gsp.lonngboatrace;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SRejectJoin extends __SRejectJoin__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619267;
/*     */   public static final int TEAM_NOT_ENOUGH = 0;
/*     */   public static final int MEMBER_LEVEL_LOW = 1;
/*     */   public static final int PROTOCOL_PARAM_WRONG = 2;
/*     */   public static final int ACTIVITY_CLOSED = 3;
/*     */   public static final int NPC_SERVICE_NOT_AVAILABLE = 4;
/*     */   public static final int NOT_NEARBY_NPC = 5;
/*     */   public static final int TEAM_NOT_EXIST = 6;
/*     */   public static final int IS_NOT_LEADER = 7;
/*     */   public static final int TEAM_MEMBER_NOT_NORMAL = 8;
/*     */   public static final int TEAM_CHANGED = 9;
/*     */   public int rejcode;
/*     */   public ArrayList<String> params;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619267;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRejectJoin()
/*     */   {
/*  45 */     this.params = new ArrayList();
/*     */   }
/*     */   
/*     */   public SRejectJoin(int _rejcode_, ArrayList<String> _params_) {
/*  49 */     this.rejcode = _rejcode_;
/*  50 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.rejcode);
/*  59 */     _os_.compact_uint32(this.params.size());
/*  60 */     for (String _v_ : this.params) {
/*  61 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.rejcode = _os_.unmarshal_int();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  70 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  71 */       this.params.add(_v_);
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SRejectJoin)) {
/*  82 */       SRejectJoin _o_ = (SRejectJoin)_o1_;
/*  83 */       if (this.rejcode != _o_.rejcode) return false;
/*  84 */       if (!this.params.equals(_o_.params)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.rejcode;
/*  93 */     _h_ += this.params.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.rejcode).append(",");
/* 101 */     _sb_.append(this.params).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\SRejectJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */