/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ public class SGetChildGrowthDiaryInfo
/*     */   extends __SGetChildGrowthDiaryInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609391;
/*     */   public long child_id;
/*     */   public long give_birth_time;
/*     */   public Octets own_role_name;
/*     */   public Octets another_parent_name;
/*     */   public long child_hood_begin_time;
/*     */   public long adult_begin_time;
/*     */   public ArrayList<GrowthInfo> growth_diary;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12609391;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetChildGrowthDiaryInfo()
/*     */   {
/*  37 */     this.own_role_name = new Octets();
/*  38 */     this.another_parent_name = new Octets();
/*  39 */     this.growth_diary = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetChildGrowthDiaryInfo(long _child_id_, long _give_birth_time_, Octets _own_role_name_, Octets _another_parent_name_, long _child_hood_begin_time_, long _adult_begin_time_, ArrayList<GrowthInfo> _growth_diary_) {
/*  43 */     this.child_id = _child_id_;
/*  44 */     this.give_birth_time = _give_birth_time_;
/*  45 */     this.own_role_name = _own_role_name_;
/*  46 */     this.another_parent_name = _another_parent_name_;
/*  47 */     this.child_hood_begin_time = _child_hood_begin_time_;
/*  48 */     this.adult_begin_time = _adult_begin_time_;
/*  49 */     this.growth_diary = _growth_diary_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     for (GrowthInfo _v_ : this.growth_diary)
/*  54 */       if (!_v_._validator_()) return false;
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.child_id);
/*  60 */     _os_.marshal(this.give_birth_time);
/*  61 */     _os_.marshal(this.own_role_name);
/*  62 */     _os_.marshal(this.another_parent_name);
/*  63 */     _os_.marshal(this.child_hood_begin_time);
/*  64 */     _os_.marshal(this.adult_begin_time);
/*  65 */     _os_.compact_uint32(this.growth_diary.size());
/*  66 */     for (GrowthInfo _v_ : this.growth_diary) {
/*  67 */       _os_.marshal(_v_);
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  73 */     this.child_id = _os_.unmarshal_long();
/*  74 */     this.give_birth_time = _os_.unmarshal_long();
/*  75 */     this.own_role_name = _os_.unmarshal_Octets();
/*  76 */     this.another_parent_name = _os_.unmarshal_Octets();
/*  77 */     this.child_hood_begin_time = _os_.unmarshal_long();
/*  78 */     this.adult_begin_time = _os_.unmarshal_long();
/*  79 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  80 */       GrowthInfo _v_ = new GrowthInfo();
/*  81 */       _v_.unmarshal(_os_);
/*  82 */       this.growth_diary.add(_v_);
/*     */     }
/*  84 */     if (!_validator_()) {
/*  85 */       throw new VerifyError("validator failed");
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  91 */     if (_o1_ == this) return true;
/*  92 */     if ((_o1_ instanceof SGetChildGrowthDiaryInfo)) {
/*  93 */       SGetChildGrowthDiaryInfo _o_ = (SGetChildGrowthDiaryInfo)_o1_;
/*  94 */       if (this.child_id != _o_.child_id) return false;
/*  95 */       if (this.give_birth_time != _o_.give_birth_time) return false;
/*  96 */       if (!this.own_role_name.equals(_o_.own_role_name)) return false;
/*  97 */       if (!this.another_parent_name.equals(_o_.another_parent_name)) return false;
/*  98 */       if (this.child_hood_begin_time != _o_.child_hood_begin_time) return false;
/*  99 */       if (this.adult_begin_time != _o_.adult_begin_time) return false;
/* 100 */       if (!this.growth_diary.equals(_o_.growth_diary)) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += (int)this.child_id;
/* 109 */     _h_ += (int)this.give_birth_time;
/* 110 */     _h_ += this.own_role_name.hashCode();
/* 111 */     _h_ += this.another_parent_name.hashCode();
/* 112 */     _h_ += (int)this.child_hood_begin_time;
/* 113 */     _h_ += (int)this.adult_begin_time;
/* 114 */     _h_ += this.growth_diary.hashCode();
/* 115 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder _sb_ = new StringBuilder();
/* 120 */     _sb_.append("(");
/* 121 */     _sb_.append(this.child_id).append(",");
/* 122 */     _sb_.append(this.give_birth_time).append(",");
/* 123 */     _sb_.append("B").append(this.own_role_name.size()).append(",");
/* 124 */     _sb_.append("B").append(this.another_parent_name.size()).append(",");
/* 125 */     _sb_.append(this.child_hood_begin_time).append(",");
/* 126 */     _sb_.append(this.adult_begin_time).append(",");
/* 127 */     _sb_.append(this.growth_diary).append(",");
/* 128 */     _sb_.append(")");
/* 129 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SGetChildGrowthDiaryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */