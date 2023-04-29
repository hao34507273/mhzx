/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SQueryChildInfo
/*     */   extends __SQueryChildInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609395;
/*     */   public long child_id;
/*     */   public int child_give_birth_time;
/*     */   public ArrayList<Octets> parents_name_list;
/*     */   public ChildBean child_bean;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609395;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SQueryChildInfo()
/*     */   {
/*  36 */     this.parents_name_list = new ArrayList();
/*  37 */     this.child_bean = new ChildBean();
/*     */   }
/*     */   
/*     */   public SQueryChildInfo(long _child_id_, int _child_give_birth_time_, ArrayList<Octets> _parents_name_list_, ChildBean _child_bean_) {
/*  41 */     this.child_id = _child_id_;
/*  42 */     this.child_give_birth_time = _child_give_birth_time_;
/*  43 */     this.parents_name_list = _parents_name_list_;
/*  44 */     this.child_bean = _child_bean_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     if (!this.child_bean._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.child_id);
/*  54 */     _os_.marshal(this.child_give_birth_time);
/*  55 */     _os_.compact_uint32(this.parents_name_list.size());
/*  56 */     for (Octets _v_ : this.parents_name_list) {
/*  57 */       _os_.marshal(_v_);
/*     */     }
/*  59 */     _os_.marshal(this.child_bean);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.child_id = _os_.unmarshal_long();
/*  65 */     this.child_give_birth_time = _os_.unmarshal_int();
/*  66 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  68 */       Octets _v_ = _os_.unmarshal_Octets();
/*  69 */       this.parents_name_list.add(_v_);
/*     */     }
/*  71 */     this.child_bean.unmarshal(_os_);
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SQueryChildInfo)) {
/*  81 */       SQueryChildInfo _o_ = (SQueryChildInfo)_o1_;
/*  82 */       if (this.child_id != _o_.child_id) return false;
/*  83 */       if (this.child_give_birth_time != _o_.child_give_birth_time) return false;
/*  84 */       if (!this.parents_name_list.equals(_o_.parents_name_list)) return false;
/*  85 */       if (!this.child_bean.equals(_o_.child_bean)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += (int)this.child_id;
/*  94 */     _h_ += this.child_give_birth_time;
/*  95 */     _h_ += this.parents_name_list.hashCode();
/*  96 */     _h_ += this.child_bean.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.child_id).append(",");
/* 104 */     _sb_.append(this.child_give_birth_time).append(",");
/* 105 */     _sb_.append(this.parents_name_list).append(",");
/* 106 */     _sb_.append(this.child_bean).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SQueryChildInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */